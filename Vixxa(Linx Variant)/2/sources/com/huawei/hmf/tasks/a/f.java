package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class f<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */
    public OnFailureListener a;
    private Executor b;
    /* access modifiers changed from: private */
    public final Object c = new Object();

    f(Executor executor, OnFailureListener onFailureListener) {
        this.a = onFailureListener;
        this.b = executor;
    }

    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            this.b.execute(new Runnable() {
                public final void run() {
                    synchronized (f.this.c) {
                        if (f.this.a != null) {
                            f.this.a.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
