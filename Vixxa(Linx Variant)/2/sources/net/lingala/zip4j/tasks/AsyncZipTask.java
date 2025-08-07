package net.lingala.zip4j.tasks;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

public abstract class AsyncZipTask<T> {
    /* access modifiers changed from: private */
    public final ExecutorService executorService;
    /* access modifiers changed from: private */
    public final ProgressMonitor progressMonitor;
    private final boolean runInThread;

    /* access modifiers changed from: protected */
    public abstract long calculateTotalWork(T t) throws ZipException;

    /* access modifiers changed from: protected */
    public abstract void executeTask(T t, ProgressMonitor progressMonitor2) throws IOException;

    /* access modifiers changed from: protected */
    public abstract ProgressMonitor.Task getTask();

    public AsyncZipTask(AsyncTaskParameters asyncTaskParameters) {
        this.progressMonitor = asyncTaskParameters.progressMonitor;
        this.runInThread = asyncTaskParameters.runInThread;
        this.executorService = asyncTaskParameters.executorService;
    }

    public void execute(final T t) throws ZipException {
        if (!this.runInThread || !ProgressMonitor.State.BUSY.equals(this.progressMonitor.getState())) {
            initProgressMonitor();
            if (this.runInThread) {
                this.progressMonitor.setTotalWork(calculateTotalWork(t));
                this.executorService.execute(new Runnable() {
                    public void run() {
                        try {
                            AsyncZipTask asyncZipTask = AsyncZipTask.this;
                            asyncZipTask.performTaskWithErrorHandling(t, asyncZipTask.progressMonitor);
                        } catch (ZipException unused) {
                        } catch (Throwable th) {
                            AsyncZipTask.this.executorService.shutdown();
                            throw th;
                        }
                        AsyncZipTask.this.executorService.shutdown();
                    }
                });
                return;
            }
            performTaskWithErrorHandling(t, this.progressMonitor);
            return;
        }
        throw new ZipException("invalid operation - Zip4j is in busy state");
    }

    /* access modifiers changed from: private */
    public void performTaskWithErrorHandling(T t, ProgressMonitor progressMonitor2) throws ZipException {
        try {
            executeTask(t, progressMonitor2);
            progressMonitor2.endProgressMonitor();
        } catch (ZipException e) {
            progressMonitor2.endProgressMonitor(e);
            throw e;
        } catch (Exception e2) {
            progressMonitor2.endProgressMonitor(e2);
            throw new ZipException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void verifyIfTaskIsCancelled() throws ZipException {
        if (this.progressMonitor.isCancelAllTasks()) {
            this.progressMonitor.setResult(ProgressMonitor.Result.CANCELLED);
            this.progressMonitor.setState(ProgressMonitor.State.READY);
            throw new ZipException("Task cancelled", ZipException.Type.TASK_CANCELLED_EXCEPTION);
        }
    }

    private void initProgressMonitor() {
        this.progressMonitor.fullReset();
        this.progressMonitor.setState(ProgressMonitor.State.BUSY);
        this.progressMonitor.setCurrentTask(getTask());
    }

    public static class AsyncTaskParameters {
        /* access modifiers changed from: private */
        public final ExecutorService executorService;
        /* access modifiers changed from: private */
        public final ProgressMonitor progressMonitor;
        /* access modifiers changed from: private */
        public final boolean runInThread;

        public AsyncTaskParameters(ExecutorService executorService2, boolean z, ProgressMonitor progressMonitor2) {
            this.executorService = executorService2;
            this.runInThread = z;
            this.progressMonitor = progressMonitor2;
        }
    }
}
