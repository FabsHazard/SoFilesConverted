package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class b<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */
    public OnCanceledListener a;
    private Executor b;
    /* access modifiers changed from: private */
    public final Object c = new Object();

    b(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = onCanceledListener;
        this.b = executor;
    }

    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.b.execute(new Runnable() {
                public final void run() {
                    synchronized (b.this.c) {
                        if (b.this.a != null) {
                            b.this.a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
