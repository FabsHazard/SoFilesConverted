package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

public final class d<TResult> implements ExecuteResult<TResult> {
    Executor a;
    /* access modifiers changed from: private */
    public OnCompleteListener<TResult> b;
    /* access modifiers changed from: private */
    public final Object c = new Object();

    d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.b = onCompleteListener;
        this.a = executor;
    }

    public final void cancel() {
        synchronized (this.c) {
            this.b = null;
        }
    }

    public final void onComplete(final Task<TResult> task) {
        this.a.execute(new Runnable() {
            public final void run() {
                synchronized (d.this.c) {
                    if (d.this.b != null) {
                        d.this.b.onComplete(task);
                    }
                }
            }
        });
    }
}
