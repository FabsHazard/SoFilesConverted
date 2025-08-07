package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.io.InputStream;
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
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

public class AddStreamToZipTask extends AbstractAddFileToZipTask<AddStreamToZipTaskParameters> {
    /* access modifiers changed from: protected */
    public long calculateTotalWork(AddStreamToZipTaskParameters addStreamToZipTaskParameters) {
        return 0;
    }

    public AddStreamToZipTask(ZipModel zipModel, char[] cArr, HeaderWriter headerWriter, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(zipModel, cArr, headerWriter, asyncTaskParameters);
    }

    /* access modifiers changed from: protected */
    public void executeTask(AddStreamToZipTaskParameters addStreamToZipTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        ZipOutputStream initializeOutputStream;
        verifyZipParameters(addStreamToZipTaskParameters.zipParameters);
        if (Zip4jUtil.isStringNotNullAndNotEmpty(addStreamToZipTaskParameters.zipParameters.getFileNameInZip())) {
            removeFileIfExists(getZipModel(), addStreamToZipTaskParameters.zip4jConfig, addStreamToZipTaskParameters.zipParameters.getFileNameInZip(), progressMonitor);
            addStreamToZipTaskParameters.zipParameters.setWriteExtendedLocalFileHeader(true);
            if (addStreamToZipTaskParameters.zipParameters.getCompressionMethod().equals(CompressionMethod.STORE)) {
                addStreamToZipTaskParameters.zipParameters.setEntrySize(0);
            }
            SplitOutputStream splitOutputStream = new SplitOutputStream(getZipModel().getZipFile(), getZipModel().getSplitLength());
            try {
                initializeOutputStream = initializeOutputStream(splitOutputStream, addStreamToZipTaskParameters.zip4jConfig);
                byte[] bArr = new byte[addStreamToZipTaskParameters.zip4jConfig.getBufferSize()];
                ZipParameters access$000 = addStreamToZipTaskParameters.zipParameters;
                initializeOutputStream.putNextEntry(access$000);
                if (!access$000.getFileNameInZip().endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) && !access$000.getFileNameInZip().endsWith("\\")) {
                    while (true) {
                        int read = addStreamToZipTaskParameters.inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        initializeOutputStream.write(bArr, 0, read);
                    }
                }
                FileHeader closeEntry = initializeOutputStream.closeEntry();
                if (CompressionMethod.STORE.equals(Zip4jUtil.getCompressionMethod(closeEntry))) {
                    updateLocalFileHeader(closeEntry, splitOutputStream);
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
        } else {
            throw new ZipException("fileNameInZip has to be set in zipParameters when adding stream");
        }
        throw th;
    }

    private void removeFileIfExists(ZipModel zipModel, Zip4jConfig zip4jConfig, String str, ProgressMonitor progressMonitor) throws ZipException {
        FileHeader fileHeader = HeaderUtil.getFileHeader(zipModel, str);
        if (fileHeader != null) {
            removeFile(fileHeader, progressMonitor, zip4jConfig);
        }
    }

    public static class AddStreamToZipTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */
        public final InputStream inputStream;
        /* access modifiers changed from: private */
        public final ZipParameters zipParameters;

        public AddStreamToZipTaskParameters(InputStream inputStream2, ZipParameters zipParameters2, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.inputStream = inputStream2;
            this.zipParameters = zipParameters2;
        }
    }
}
