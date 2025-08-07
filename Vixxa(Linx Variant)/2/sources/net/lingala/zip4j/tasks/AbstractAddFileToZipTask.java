package net.lingala.zip4j.tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderUtil;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.tasks.RemoveFilesFromZipTask;
import net.lingala.zip4j.util.BitUtils;
import net.lingala.zip4j.util.CrcUtil;
import net.lingala.zip4j.util.FileUtils;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public abstract class AbstractAddFileToZipTask<T> extends AsyncZipTask<T> {
    private final HeaderWriter headerWriter;
    private final char[] password;
    private final ZipModel zipModel;

    AbstractAddFileToZipTask(ZipModel zipModel2, char[] cArr, HeaderWriter headerWriter2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
        this.password = cArr;
        this.headerWriter = headerWriter2;
    }

    /* access modifiers changed from: package-private */
    public void addFilesToZip(List<File> list, ProgressMonitor progressMonitor, ZipParameters zipParameters, Zip4jConfig zip4jConfig) throws IOException {
        ZipOutputStream initializeOutputStream;
        FileUtils.assertFilesExist(list, zipParameters.getSymbolicLinkAction());
        byte[] bArr = new byte[zip4jConfig.getBufferSize()];
        List<File> removeFilesIfExists = removeFilesIfExists(list, zipParameters, progressMonitor, zip4jConfig);
        SplitOutputStream splitOutputStream = new SplitOutputStream(this.zipModel.getZipFile(), this.zipModel.getSplitLength());
        try {
            initializeOutputStream = initializeOutputStream(splitOutputStream, zip4jConfig);
            for (File next : removeFilesIfExists) {
                verifyIfTaskIsCancelled();
                ZipParameters cloneAndAdjustZipParameters = cloneAndAdjustZipParameters(zipParameters, next, progressMonitor);
                progressMonitor.setFileName(next.getAbsolutePath());
                if (FileUtils.isSymbolicLink(next) && addSymlink(cloneAndAdjustZipParameters)) {
                    addSymlinkToZip(next, initializeOutputStream, cloneAndAdjustZipParameters, splitOutputStream);
                    if (ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(cloneAndAdjustZipParameters.getSymbolicLinkAction())) {
                    }
                }
                addFileToZip(next, initializeOutputStream, cloneAndAdjustZipParameters, splitOutputStream, progressMonitor, bArr);
            }
            if (initializeOutputStream != null) {
                initializeOutputStream.close();
            }
            splitOutputStream.close();
            return;
        } catch (Throwable th) {
            try {
                splitOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
        throw th;
    }

    private void addSymlinkToZip(File file, ZipOutputStream zipOutputStream, ZipParameters zipParameters, SplitOutputStream splitOutputStream) throws IOException {
        ZipParameters zipParameters2 = new ZipParameters(zipParameters);
        zipParameters2.setFileNameInZip(replaceFileNameInZip(zipParameters.getFileNameInZip(), file.getName()));
        zipParameters2.setEncryptFiles(false);
        zipParameters2.setCompressionMethod(CompressionMethod.STORE);
        zipOutputStream.putNextEntry(zipParameters2);
        zipOutputStream.write(FileUtils.readSymbolicLink(file).getBytes());
        closeEntry(zipOutputStream, splitOutputStream, file, true);
    }

    private void addFileToZip(File file, ZipOutputStream zipOutputStream, ZipParameters zipParameters, SplitOutputStream splitOutputStream, ProgressMonitor progressMonitor, byte[] bArr) throws IOException {
        zipOutputStream.putNextEntry(zipParameters);
        if (file.exists() && !file.isDirectory()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                    progressMonitor.updateWorkCompleted((long) read);
                    verifyIfTaskIsCancelled();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            fileInputStream.close();
        }
        closeEntry(zipOutputStream, splitOutputStream, file, false);
        return;
        throw th;
    }

    private void closeEntry(ZipOutputStream zipOutputStream, SplitOutputStream splitOutputStream, File file, boolean z) throws IOException {
        FileHeader closeEntry = zipOutputStream.closeEntry();
        byte[] fileAttributes = FileUtils.getFileAttributes(file);
        if (!z) {
            fileAttributes[3] = BitUtils.unsetBit(fileAttributes[3], 5);
        }
        closeEntry.setExternalFileAttributes(fileAttributes);
        updateLocalFileHeader(closeEntry, splitOutputStream);
    }

    /* access modifiers changed from: package-private */
    public long calculateWorkForFiles(List<File> list, ZipParameters zipParameters) throws ZipException {
        long j;
        long j2 = 0;
        for (File next : list) {
            if (next.exists()) {
                if (!zipParameters.isEncryptFiles() || zipParameters.getEncryptionMethod() != EncryptionMethod.ZIP_STANDARD) {
                    j = next.length();
                } else {
                    j = next.length() * 2;
                }
                j2 += j;
                FileHeader fileHeader = HeaderUtil.getFileHeader(getZipModel(), FileUtils.getRelativeFileName(next, zipParameters));
                if (fileHeader != null) {
                    j2 += getZipModel().getZipFile().length() - fileHeader.getCompressedSize();
                }
            }
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public ZipOutputStream initializeOutputStream(SplitOutputStream splitOutputStream, Zip4jConfig zip4jConfig) throws IOException {
        if (this.zipModel.getZipFile().exists()) {
            splitOutputStream.seek(HeaderUtil.getOffsetStartOfCentralDirectory(this.zipModel));
        }
        return new ZipOutputStream(splitOutputStream, this.password, zip4jConfig, this.zipModel);
    }

    /* access modifiers changed from: package-private */
    public void verifyZipParameters(ZipParameters zipParameters) throws ZipException {
        if (zipParameters == null) {
            throw new ZipException("cannot validate zip parameters");
        } else if (zipParameters.getCompressionMethod() != CompressionMethod.STORE && zipParameters.getCompressionMethod() != CompressionMethod.DEFLATE) {
            throw new ZipException("unsupported compression type");
        } else if (!zipParameters.isEncryptFiles()) {
            zipParameters.setEncryptionMethod(EncryptionMethod.NONE);
        } else if (zipParameters.getEncryptionMethod() != EncryptionMethod.NONE) {
            char[] cArr = this.password;
            if (cArr == null || cArr.length <= 0) {
                throw new ZipException("input password is empty or null");
            }
        } else {
            throw new ZipException("Encryption method has to be set, when encrypt files flag is set");
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLocalFileHeader(FileHeader fileHeader, SplitOutputStream splitOutputStream) throws IOException {
        this.headerWriter.updateLocalFileHeader(fileHeader, getZipModel(), splitOutputStream);
    }

    private ZipParameters cloneAndAdjustZipParameters(ZipParameters zipParameters, File file, ProgressMonitor progressMonitor) throws IOException {
        ZipParameters zipParameters2 = new ZipParameters(zipParameters);
        if (file.isDirectory()) {
            zipParameters2.setEntrySize(0);
        } else {
            zipParameters2.setEntrySize(file.length());
        }
        if (zipParameters.getLastModifiedFileTime() <= 0) {
            zipParameters2.setLastModifiedFileTime(file.lastModified());
        }
        zipParameters2.setWriteExtendedLocalFileHeader(false);
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipParameters.getFileNameInZip())) {
            zipParameters2.setFileNameInZip(FileUtils.getRelativeFileName(file, zipParameters));
        }
        if (file.isDirectory()) {
            zipParameters2.setCompressionMethod(CompressionMethod.STORE);
            zipParameters2.setEncryptionMethod(EncryptionMethod.NONE);
            zipParameters2.setEncryptFiles(false);
        } else {
            if (zipParameters2.isEncryptFiles() && zipParameters2.getEncryptionMethod() == EncryptionMethod.ZIP_STANDARD) {
                progressMonitor.setCurrentTask(ProgressMonitor.Task.CALCULATE_CRC);
                zipParameters2.setEntryCRC(CrcUtil.computeFileCrc(file, progressMonitor));
                progressMonitor.setCurrentTask(ProgressMonitor.Task.ADD_ENTRY);
            }
            if (file.length() == 0) {
                zipParameters2.setCompressionMethod(CompressionMethod.STORE);
            }
        }
        return zipParameters2;
    }

    private List<File> removeFilesIfExists(List<File> list, ZipParameters zipParameters, ProgressMonitor progressMonitor, Zip4jConfig zip4jConfig) throws ZipException {
        ArrayList arrayList = new ArrayList(list);
        if (!this.zipModel.getZipFile().exists()) {
            return arrayList;
        }
        for (File next : list) {
            if (!Zip4jUtil.isStringNotNullAndNotEmpty(next.getName())) {
                arrayList.remove(next);
            }
            FileHeader fileHeader = HeaderUtil.getFileHeader(this.zipModel, FileUtils.getRelativeFileName(next, zipParameters));
            if (fileHeader != null) {
                if (zipParameters.isOverrideExistingFilesInZip()) {
                    progressMonitor.setCurrentTask(ProgressMonitor.Task.REMOVE_ENTRY);
                    removeFile(fileHeader, progressMonitor, zip4jConfig);
                    verifyIfTaskIsCancelled();
                    progressMonitor.setCurrentTask(ProgressMonitor.Task.ADD_ENTRY);
                } else {
                    arrayList.remove(next);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void removeFile(FileHeader fileHeader, ProgressMonitor progressMonitor, Zip4jConfig zip4jConfig) throws ZipException {
        new RemoveFilesFromZipTask(this.zipModel, this.headerWriter, new AsyncZipTask.AsyncTaskParameters((ExecutorService) null, false, progressMonitor)).execute(new RemoveFilesFromZipTask.RemoveFilesFromZipTaskParameters(Collections.singletonList(fileHeader.getFileName()), zip4jConfig));
    }

    private String replaceFileNameInZip(String str, String str2) {
        return str.contains(InternalZipConstants.ZIP_FILE_SEPARATOR) ? str.substring(0, str.lastIndexOf(InternalZipConstants.ZIP_FILE_SEPARATOR) + 1) + str2 : str2;
    }

    private boolean addSymlink(ZipParameters zipParameters) {
        return ZipParameters.SymbolicLinkAction.INCLUDE_LINK_ONLY.equals(zipParameters.getSymbolicLinkAction()) || ZipParameters.SymbolicLinkAction.INCLUDE_LINK_AND_LINKED_FILE.equals(zipParameters.getSymbolicLinkAction());
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.ADD_ENTRY;
    }

    /* access modifiers changed from: protected */
    public ZipModel getZipModel() {
        return this.zipModel;
    }
}
