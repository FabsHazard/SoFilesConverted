package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
    private final Object a = new Object();
    private final int b;
    private final i<Void> c;
    private int d;
    private Exception e;
    private boolean f;

    e(int i, i<Void> iVar) {
        this.b = i;
        this.c = iVar;
    }

    private void a() {
        if (this.d < this.b) {
            return;
        }
        if (this.e != null) {
            this.c.a((Exception) new ExecutionException("a task failed", this.e));
        } else if (this.f) {
            this.c.a();
        } else {
            this.c.a(null);
        }
    }

    public final void onCanceled() {
        synchronized (this.a) {
            this.d++;
            this.f = true;
            a();
        }
    }

    public final void onFailure(Exception exc) {
        synchronized (this.a) {
            this.d++;
            this.e = exc;
            a();
        }
    }

    public final void onSuccess(TResult tresult) {
        synchronized (this.a) {
            this.d++;
            a();
        }
    }
}
