package net.lingala.zip4j.tasks;

import java.io.IOException;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderWriter;
import net.lingala.zip4j.io.outputstream.SplitOutputStream;
import net.lingala.zip4j.model.EndOfCentralDirectoryRecord;
import net.lingala.zip4j.model.Zip4jConfig;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.tasks.AsyncZipTask;

public class SetCommentTask extends AsyncZipTask<SetCommentTaskTaskParameters> {
    private final ZipModel zipModel;

    /* access modifiers changed from: protected */
    public long calculateTotalWork(SetCommentTaskTaskParameters setCommentTaskTaskParameters) {
        return 0;
    }

    public SetCommentTask(ZipModel zipModel2, AsyncZipTask.AsyncTaskParameters asyncTaskParameters) {
        super(asyncTaskParameters);
        this.zipModel = zipModel2;
    }

    /* access modifiers changed from: protected */
    public void executeTask(SetCommentTaskTaskParameters setCommentTaskTaskParameters, ProgressMonitor progressMonitor) throws IOException {
        if (setCommentTaskTaskParameters.comment != null) {
            EndOfCentralDirectoryRecord endOfCentralDirectoryRecord = this.zipModel.getEndOfCentralDirectoryRecord();
            endOfCentralDirectoryRecord.setComment(setCommentTaskTaskParameters.comment);
            SplitOutputStream splitOutputStream = new SplitOutputStream(this.zipModel.getZipFile());
            try {
                if (this.zipModel.isZip64Format()) {
                    splitOutputStream.seek(this.zipModel.getZip64EndOfCentralDirectoryRecord().getOffsetStartCentralDirectoryWRTStartDiskNumber());
                } else {
                    splitOutputStream.seek(endOfCentralDirectoryRecord.getOffsetOfStartOfCentralDirectory());
                }
                new HeaderWriter().finalizeZipFileWithoutValidations(this.zipModel, splitOutputStream, setCommentTaskTaskParameters.zip4jConfig.getCharset());
                splitOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new ZipException("comment is null, cannot update Zip file with comment");
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    public ProgressMonitor.Task getTask() {
        return ProgressMonitor.Task.SET_COMMENT;
    }

    public static class SetCommentTaskTaskParameters extends AbstractZipTaskParameters {
        /* access modifiers changed from: private */
        public String comment;

        public SetCommentTaskTaskParameters(String str, Zip4jConfig zip4jConfig) {
            super(zip4jConfig);
            this.comment = str;
        }
    }
}
