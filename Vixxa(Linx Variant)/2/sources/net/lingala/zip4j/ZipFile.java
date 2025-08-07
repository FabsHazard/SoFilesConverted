package net.lingala.zip4j;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderReader;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.inputstream.NumberedSplitRandomAccessFile;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AddFilesToZipTask;
import net.lingala.zip4j.tasks.AddFolderToZipTask;
import net.lingala.zip4j.tasks.AddStreamToZipTask;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.tasks.ExtractAllFilesTask;
import net.lingala.zip4j.tasks.ExtractFileTask;
import net.lingala.zip4j.tasks.MergeSplitZipFileTask;
import net.lingala.zip4j.tasks.RemoveFilesFromZipTask;
import net.lingala.zip4j.tasks.RenameFilesTask;
import net.lingala.zip4j.tasks.SetCommentTask;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.RawIO;
import net.lingala.zip4j.util.UnzipUtil;
import net.lingala.zip4j.util.Zip4jUtil;

public class ZipFile implements Closeable {
    private int bufferSize;
    private Charset charset;
    private ExecutorService executorService;
    private HeaderWriter headerWriter;
    private boolean isEncrypted;
    private List<InputStream> openInputStreams;
    private char[] password;
    private ProgressMonitor progressMonitor;
    private boolean runInThread;
    private ThreadFactory threadFactory;
    private boolean useUtf8CharsetForPasswords;
    private File zipFile;
    private ZipModel zipModel;

    public ZipFile(String str) {
        this(new File(str), (char[]) null);
    }

    public ZipFile(String str, char[] cArr) {
        this(new File(str), cArr);
    }

    public ZipFile(File file) {
        this(file, (char[]) null);
    }

    public ZipFile(File file, char[] cArr) {
        this.headerWriter = new HeaderWriter();
        this.charset = null;
        this.bufferSize = 4096;
        this.openInputStreams = new ArrayList();
        this.useUtf8CharsetForPasswords = true;
        if (file != null) {
            this.zipFile = file;
            this.password = cArr;
            this.runInThread = false;
            this.progressMonitor = new ProgressMonitor();
            return;
        }
        throw new IllegalArgumentException("input zip file parameter is null");
    }

    public void createSplitZipFile(List<File> list, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (this.zipFile.exists()) {
            throw new ZipException("zip file: " + this.zipFile + " already exists. To add files to existing zip file use addFile method");
        } else if (list == null || list.size() == 0) {
            throw new ZipException("input file List is null, cannot create zip file");
        } else {
            createNewZipModel();
            this.zipModel.setSplitArchive(z);
            this.zipModel.setSplitLength(j);
            new AddFilesToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, buildConfig()));
        }
    }

    public void createSplitZipFileFromFolder(File file, ZipParameters zipParameters, boolean z, long j) throws ZipException {
        if (file == null) {
            throw new ZipException("folderToAdd is null, cannot create zip file from folder");
        } else if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot create zip file from folder");
        } else if (!this.zipFile.exists()) {
            createNewZipModel();
            this.zipModel.setSplitArchive(z);
            if (z) {
                this.zipModel.setSplitLength(j);
            }
            addFolder(file, zipParameters, false);
        } else {
            throw new ZipException("zip file: " + this.zipFile + " already exists. To add files to existing zip file use addFolder method");
        }
    }

    public void addFile(String str) throws ZipException {
        addFile(str, new ZipParameters());
    }

    public void addFile(String str, ZipParameters zipParameters) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            addFiles(Collections.singletonList(new File(str)), zipParameters);
            return;
        }
        throw new ZipException("file to add is null or empty");
    }

    public void addFile(File file) throws ZipException {
        addFiles(Collections.singletonList(file), new ZipParameters());
    }

    public void addFile(File file, ZipParameters zipParameters) throws ZipException {
        addFiles(Collections.singletonList(file), zipParameters);
    }

    public void addFiles(List<File> list) throws ZipException {
        addFiles(list, new ZipParameters());
    }

    public void addFiles(List<File> list, ZipParameters zipParameters) throws ZipException {
        if (list == null || list.size() == 0) {
            throw new ZipException("input file List is null or empty");
        } else if (zipParameters != null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("internal error: zip model is null");
            } else if (!this.zipFile.exists() || !this.zipModel.isSplitArchive()) {
                new AddFilesToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddFilesToZipTask.AddFilesToZipTaskParameters(list, zipParameters, buildConfig()));
            } else {
                throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
            }
        } else {
            throw new ZipException("input parameters are null");
        }
    }

    public void addFolder(File file) throws ZipException {
        addFolder(file, new ZipParameters());
    }

    public void addFolder(File file, ZipParameters zipParameters) throws ZipException {
        if (file == null) {
            throw new ZipException("input path is null, cannot add folder to zip file");
        } else if (!file.exists()) {
            throw new ZipException("folder does not exist");
        } else if (!file.isDirectory()) {
            throw new ZipException("input folder is not a directory");
        } else if (!file.canRead()) {
            throw new ZipException("cannot read input folder");
        } else if (zipParameters != null) {
            addFolder(file, zipParameters, true);
        } else {
            throw new ZipException("input parameters are null, cannot add folder to zip file");
        }
    }

    private void addFolder(File file, ZipParameters zipParameters, boolean z) throws ZipException {
        readZipInfo();
        ZipModel zipModel2 = this.zipModel;
        if (zipModel2 == null) {
            throw new ZipException("internal error: zip model is null");
        } else if (!z || !zipModel2.isSplitArchive()) {
            new AddFolderToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddFolderToZipTask.AddFolderToZipTaskParameters(file, zipParameters, buildConfig()));
        } else {
            throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
        }
    }

    public void addStream(InputStream inputStream, ZipParameters zipParameters) throws ZipException {
        if (inputStream == null) {
            throw new ZipException("inputstream is null, cannot add file to zip");
        } else if (zipParameters != null) {
            setRunInThread(false);
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("internal error: zip model is null");
            } else if (!this.zipFile.exists() || !this.zipModel.isSplitArchive()) {
                new AddStreamToZipTask(this.zipModel, this.password, this.headerWriter, buildAsyncParameters()).execute(new AddStreamToZipTask.AddStreamToZipTaskParameters(inputStream, zipParameters, buildConfig()));
            } else {
                throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
            }
        } else {
            throw new ZipException("zip parameters are null");
        }
    }

    public void extractAll(String str) throws ZipException {
        extractAll(str, new UnzipParameters());
    }

    public void extractAll(String str, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("output path is null or invalid");
        } else if (Zip4jUtil.createDirectoryIfNotExists(new File(str))) {
            if (this.zipModel == null) {
                readZipInfo();
            }
            if (this.zipModel != null) {
                new ExtractAllFilesTask(this.zipModel, this.password, unzipParameters, buildAsyncParameters()).execute(new ExtractAllFilesTask.ExtractAllFilesTaskParameters(str, buildConfig()));
                return;
            }
            throw new ZipException("Internal error occurred when extracting zip file");
        } else {
            throw new ZipException("invalid output path");
        }
    }

    public void extractFile(FileHeader fileHeader, String str) throws ZipException {
        extractFile(fileHeader, str, (String) null, new UnzipParameters());
    }

    public void extractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters) throws ZipException {
        extractFile(fileHeader, str, (String) null, unzipParameters);
    }

    public void extractFile(FileHeader fileHeader, String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        if (fileHeader != null) {
            extractFile(fileHeader.getFileName(), str, str2, unzipParameters);
            return;
        }
        throw new ZipException("input file header is null, cannot extract file");
    }

    public void extractFile(String str, String str2) throws ZipException {
        extractFile(str, str2, (String) null, new UnzipParameters());
    }

    public void extractFile(String str, String str2, UnzipParameters unzipParameters) throws ZipException {
        extractFile(str, str2, (String) null, unzipParameters);
    }

    public void extractFile(String str, String str2, String str3) throws ZipException {
        extractFile(str, str2, str3, new UnzipParameters());
    }

    public void extractFile(FileHeader fileHeader, String str, String str2) throws ZipException {
        extractFile(fileHeader, str, str2, new UnzipParameters());
    }

    public void extractFile(String str, String str2, String str3, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file to extract is null or empty, cannot extract file");
        } else if (Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            if (unzipParameters == null) {
                unzipParameters = new UnzipParameters();
            }
            readZipInfo();
            new ExtractFileTask(this.zipModel, this.password, unzipParameters, buildAsyncParameters()).execute(new ExtractFileTask.ExtractFileTaskParameters(str2, str, str3, buildConfig()));
        } else {
            throw new ZipException("destination path is empty or null, cannot extract file");
        }
    }

    public List<FileHeader> getFileHeaders() throws ZipException {
        readZipInfo();
        ZipModel zipModel2 = this.zipModel;
        if (zipModel2 == null || zipModel2.getCentralDirectory() == null) {
            return Collections.emptyList();
        }
        return this.zipModel.getCentralDirectory().getFileHeaders();
    }

    public FileHeader getFileHeader(String str) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            readZipInfo();
            ZipModel zipModel2 = this.zipModel;
            if (zipModel2 == null || zipModel2.getCentralDirectory() == null) {
                return null;
            }
            return HeaderUtil.getFileHeader(this.zipModel, str);
        }
        throw new ZipException("input file name is emtpy or null, cannot get FileHeader");
    }

    public boolean isEncrypted() throws ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("invalid zip file");
        }
        Iterator<FileHeader> it = this.zipModel.getCentralDirectory().getFileHeaders().iterator();
        while (true) {
            if (it.hasNext()) {
                FileHeader next = it.next();
                if (next != null && next.isEncrypted()) {
                    this.isEncrypted = true;
                    break;
                }
            } else {
                break;
            }
        }
        return this.isEncrypted;
    }

    public boolean isSplitArchive() throws ZipException {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        return this.zipModel.isSplitArchive();
    }

    public void removeFile(FileHeader fileHeader) throws ZipException {
        if (fileHeader != null) {
            removeFile(fileHeader.getFileName());
            return;
        }
        throw new ZipException("input file header is null, cannot remove file");
    }

    public void removeFile(String str) throws ZipException {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            removeFiles(Collections.singletonList(str));
            return;
        }
        throw new ZipException("file name is empty or null, cannot remove file");
    }

    public void removeFiles(List<String> list) throws ZipException {
        if (list == null) {
            throw new ZipException("fileNames list is null");
        } else if (!list.isEmpty()) {
            if (this.zipModel == null) {
                readZipInfo();
            }
            if (!this.zipModel.isSplitArchive()) {
                new RemoveFilesFromZipTask(this.zipModel, this.headerWriter, buildAsyncParameters()).execute(new RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(list, buildConfig()));
                return;
            }
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
    }

    public void renameFile(FileHeader fileHeader, String str) throws ZipException {
        if (fileHeader != null) {
            renameFile(fileHeader.getFileName(), str);
            return;
        }
        throw new ZipException("File header is null");
    }

    public void renameFile(String str, String str2) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file name to be changed is null or empty");
        } else if (Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            renameFiles(Collections.singletonMap(str, str2));
        } else {
            throw new ZipException("newFileName is null or empty");
        }
    }

    public void renameFiles(Map<String, String> map) throws ZipException {
        if (map == null) {
            throw new ZipException("fileNamesMap is null");
        } else if (map.size() != 0) {
            readZipInfo();
            if (!this.zipModel.isSplitArchive()) {
                new RenameFilesTask(this.zipModel, this.headerWriter, new RawIO(), buildAsyncParameters()).execute(new RenameFilesTask.RenameFilesTaskParameters(map, buildConfig()));
                return;
            }
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
    }

    public void mergeSplitFiles(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("outputZipFile is null, cannot merge split files");
        } else if (!file.exists()) {
            readZipInfo();
            if (this.zipModel != null) {
                new MergeSplitZipFileTask(this.zipModel, buildAsyncParameters()).execute(new MergeSplitZipFileTask.MergeSplitZipFileTaskParameters(file, buildConfig()));
                return;
            }
            throw new ZipException("zip model is null, corrupt zip file?");
        } else {
            throw new ZipException("output Zip File already exists");
        }
    }

    public void setComment(String str) throws ZipException {
        if (str == null) {
            throw new ZipException("input comment is null, cannot update zip file");
        } else if (this.zipFile.exists()) {
            readZipInfo();
            ZipModel zipModel2 = this.zipModel;
            if (zipModel2 == null) {
                throw new ZipException("zipModel is null, cannot update zip file");
            } else if (zipModel2.getEndOfCentralDirectoryRecord() != null) {
                new SetCommentTask(this.zipModel, buildAsyncParameters()).execute(new SetCommentTask.SetCommentTaskTaskParameters(str, buildConfig()));
            } else {
                throw new ZipException("end of central directory is null, cannot set comment");
            }
        } else {
            throw new ZipException("zip file does not exist, cannot set comment for zip file");
        }
    }

    public String getComment() throws ZipException {
        if (this.zipFile.exists()) {
            readZipInfo();
            ZipModel zipModel2 = this.zipModel;
            if (zipModel2 == null) {
                throw new ZipException("zip model is null, cannot read comment");
            } else if (zipModel2.getEndOfCentralDirectoryRecord() != null) {
                return this.zipModel.getEndOfCentralDirectoryRecord().getComment();
            } else {
                throw new ZipException("end of central directory record is null, cannot read comment");
            }
        } else {
            throw new ZipException("zip file does not exist, cannot read comment");
        }
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws IOException {
        if (fileHeader != null) {
            readZipInfo();
            ZipModel zipModel2 = this.zipModel;
            if (zipModel2 != null) {
                ZipInputStream createZipInputStream = UnzipUtil.createZipInputStream(zipModel2, fileHeader, this.password);
                this.openInputStreams.add(createZipInputStream);
                return createZipInputStream;
            }
            throw new ZipException("zip model is null, cannot get inputstream");
        }
        throw new ZipException("FileHeader is null, cannot get InputStream");
    }

    public boolean isValidZipFile() {
        if (!this.zipFile.exists()) {
            return false;
        }
        try {
            readZipInfo();
            if (!this.zipModel.isSplitArchive() || verifyAllSplitFilesOfZipExists(getSplitZipFiles())) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public List<File> getSplitZipFiles() throws ZipException {
        readZipInfo();
        return FileUtils.getSplitZipFiles(this.zipModel);
    }

    public void close() throws IOException {
        for (InputStream close : this.openInputStreams) {
            close.close();
        }
        this.openInputStreams.clear();
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(int i) {
        if (i >= 512) {
            this.bufferSize = i;
            return;
        }
        throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
    }

    private void readZipInfo() throws ZipException {
        RandomAccessFile initializeRandomAccessFileForHeaderReading;
        if (this.zipModel == null) {
            if (!this.zipFile.exists()) {
                createNewZipModel();
                return;
            } else if (this.zipFile.canRead()) {
                try {
                    initializeRandomAccessFileForHeaderReading = initializeRandomAccessFileForHeaderReading();
                    ZipModel readAllHeaders = new HeaderReader().readAllHeaders(initializeRandomAccessFileForHeaderReading, buildConfig());
                    this.zipModel = readAllHeaders;
                    readAllHeaders.setZipFile(this.zipFile);
                    if (initializeRandomAccessFileForHeaderReading != null) {
                        initializeRandomAccessFileForHeaderReading.close();
                        return;
                    }
                    return;
                } catch (ZipException e) {
                    throw e;
                } catch (IOException e2) {
                    throw new ZipException((Exception) e2);
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw new ZipException("no read access for the input zip file");
            }
        } else {
            return;
        }
        throw th;
    }

    private void createNewZipModel() {
        ZipModel zipModel2 = new ZipModel();
        this.zipModel = zipModel2;
        zipModel2.setZipFile(this.zipFile);
    }

    private RandomAccessFile initializeRandomAccessFileForHeaderReading() throws IOException {
        if (!FileUtils.isNumberedSplitFile(this.zipFile)) {
            return new RandomAccessFile(this.zipFile, RandomAccessFileMode.READ.getValue());
        }
        NumberedSplitRandomAccessFile numberedSplitRandomAccessFile = new NumberedSplitRandomAccessFile(this.zipFile, RandomAccessFileMode.READ.getValue(), FileUtils.getAllSortedNumberedSplitFiles(this.zipFile));
        numberedSplitRandomAccessFile.openLastSplitFileForReading();
        return numberedSplitRandomAccessFile;
    }

    private AsyncZipTask.AsyncTaskParameters buildAsyncParameters() {
        if (this.runInThread) {
            if (this.threadFactory == null) {
                this.threadFactory = Executors.defaultThreadFactory();
            }
            this.executorService = Executors.newSingleThreadExecutor(this.threadFactory);
        }
        return new AsyncZipTask.AsyncTaskParameters(this.executorService, this.runInThread, this.progressMonitor);
    }

    private boolean verifyAllSplitFilesOfZipExists(List<File> list) {
        for (File exists : list) {
            if (!exists.exists()) {
                return false;
            }
        }
        return true;
    }

    public ProgressMonitor getProgressMonitor() {
        return this.progressMonitor;
    }

    public boolean isRunInThread() {
        return this.runInThread;
    }

    public void setRunInThread(boolean z) {
        this.runInThread = z;
    }

    public File getFile() {
        return this.zipFile;
    }

    public Charset getCharset() {
        Charset charset2 = this.charset;
        return charset2 == null ? InternalZipConstants.CHARSET_UTF_8 : charset2;
    }

    public void setCharset(Charset charset2) throws IllegalArgumentException {
        if (charset2 != null) {
            this.charset = charset2;
            return;
        }
        throw new IllegalArgumentException("charset cannot be null");
    }

    public void setThreadFactory(ThreadFactory threadFactory2) {
        this.threadFactory = threadFactory2;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public String toString() {
        return this.zipFile.toString();
    }

    private Zip4jConfig buildConfig() {
        return new Zip4jConfig(this.charset, this.bufferSize, this.useUtf8CharsetForPasswords);
    }

    public boolean isUseUtf8CharsetForPasswords() {
        return this.useUtf8CharsetForPasswords;
    }

    public void setUseUtf8CharsetForPasswords(boolean z) {
        this.useUtf8CharsetForPasswords = z;
    }
}
