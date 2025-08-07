package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class h<TResult> implements ExecuteResult<TResult> {
    /* access modifiers changed from: private */
    public OnSuccessListener<TResult> a;
    private Executor b;
    /* access modifiers changed from: private */
    public final Object c = new Object();

    h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.a = onSuccessListener;
        this.b = executor;
    }

    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() && !task.isCanceled()) {
            this.b.execute(new Runnable() {
                public final void run() {
                    synchronized (h.this.c) {
                        if (h.this.a != null) {
                            h.this.a.onSuccess(task.getResult());
                        }
                    }
                }
            });
        }
    }
}
