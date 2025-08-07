package com.huawei.hmf.tasks.a;

import android.app.Activity;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.SuccessContinuation;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class i<TResult> extends Task<TResult> {
    private final Object a = new Object();
    private boolean b;
    private volatile boolean c;
    private TResult d;
    private Exception e;
    private List<ExecuteResult<TResult>> f = new ArrayList();

    private Task<TResult> a(ExecuteResult<TResult> executeResult) {
        boolean isComplete;
        synchronized (this.a) {
            isComplete = isComplete();
            if (!isComplete) {
                this.f.add(executeResult);
            }
        }
        if (isComplete) {
            executeResult.onComplete(this);
        }
        return this;
    }

    private void b() {
        synchronized (this.a) {
            for (ExecuteResult onComplete : this.f) {
                try {
                    onComplete.onComplete(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f = null;
        }
    }

    public final void a(Exception exc) {
        synchronized (this.a) {
            if (!this.b) {
                this.b = true;
                this.e = exc;
                this.a.notifyAll();
                b();
            }
        }
    }

    public final void a(TResult tresult) {
        synchronized (this.a) {
            if (!this.b) {
                this.b = true;
                this.d = tresult;
                this.a.notifyAll();
                b();
            }
        }
    }

    public final boolean a() {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.c = true;
            this.a.notifyAll();
            b();
            return true;
        }
    }

    public final Task<TResult> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        b bVar = new b(TaskExecutors.uiThread(), onCanceledListener);
        g.a(activity, bVar);
        return a(bVar);
    }

    public final Task<TResult> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.uiThread(), onCanceledListener);
    }

    public final Task<TResult> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return a(new b(executor, onCanceledListener));
    }

    public final Task<TResult> addOnCompleteListener(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        d dVar = new d(TaskExecutors.uiThread(), onCompleteListener);
        g.a(activity, dVar);
        return a(dVar);
    }

    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.uiThread(), onCompleteListener);
    }

    public final Task<TResult> addOnCompleteListener(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        return a(new d(executor, onCompleteListener));
    }

    public final Task<TResult> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        f fVar = new f(TaskExecutors.uiThread(), onFailureListener);
        g.a(activity, fVar);
        return a(fVar);
    }

    public final Task<TResult> addOnFailureListener(OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.uiThread(), onFailureListener);
    }

    public final Task<TResult> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return a(new f(executor, onFailureListener));
    }

    public final Task<TResult> addOnSuccessListener(Activity activity, OnSuccessListener<TResult> onSuccessListener) {
        h hVar = new h(TaskExecutors.uiThread(), onSuccessListener);
        g.a(activity, hVar);
        return a(hVar);
    }

    public final Task<TResult> addOnSuccessListener(OnSuccessListener<TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.uiThread(), onSuccessListener);
    }

    public final Task<TResult> addOnSuccessListener(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        return a(new h(executor, onSuccessListener));
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.uiThread(), continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, final Continuation<TResult, TContinuationResult> continuation) {
        final i iVar = new i();
        addOnCompleteListener(executor, new OnCompleteListener<TResult>() {
            public final void onComplete(Task<TResult> task) {
                if (task.isCanceled()) {
                    iVar.a();
                    return;
                }
                try {
                    iVar.a(continuation.then(task));
                } catch (Exception e) {
                    iVar.a(e);
                }
            }
        });
        return iVar;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.uiThread(), continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, final Continuation<TResult, Task<TContinuationResult>> continuation) {
        final i iVar = new i();
        addOnCompleteListener(executor, new OnCompleteListener<TResult>() {
            public final void onComplete(Task<TResult> task) {
                try {
                    Task task2 = (Task) continuation.then(task);
                    if (task2 == null) {
                        iVar.a((Exception) new NullPointerException("Continuation returned null"));
                    } else {
                        task2.addOnCompleteListener(new OnCompleteListener<TContinuationResult>() {
                            public final void onComplete(Task<TContinuationResult> task) {
                                if (task.isSuccessful()) {
                                    iVar.a(task.getResult());
                                } else if (task.isCanceled()) {
                                    iVar.a();
                                } else {
                                    iVar.a(task.getException());
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    iVar.a(e);
                }
            }
        });
        return iVar;
    }

    public final Exception getException() {
        Exception exc;
        synchronized (this.a) {
            exc = this.e;
        }
        return exc;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            if (this.e == null) {
                tresult = this.d;
            } else {
                throw new RuntimeException(this.e);
            }
        }
        return tresult;
    }

    public final <E extends Throwable> TResult getResultThrowException(Class<E> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            if (cls != null) {
                if (cls.isInstance(this.e)) {
                    throw ((Throwable) cls.cast(this.e));
                }
            }
            if (this.e == null) {
                tresult = this.d;
            } else {
                throw new RuntimeException(this.e);
            }
        }
        return tresult;
    }

    public final boolean isCanceled() {
        return this.c;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.a) {
            z = this.b && !isCanceled() && this.e == null;
        }
        return z;
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.uiThread(), successContinuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, final SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        final i iVar = new i();
        addOnSuccessListener(executor, new OnSuccessListener<TResult>() {
            public final void onSuccess(TResult tresult) {
                try {
                    Task then = successContinuation.then(tresult);
                    if (then == null) {
                        iVar.a((Exception) new NullPointerException("SuccessContinuation returned null"));
                    } else {
                        then.addOnCompleteListener(new OnCompleteListener<TContinuationResult>() {
                            public final void onComplete(Task<TContinuationResult> task) {
                                if (task.isSuccessful()) {
                                    iVar.a(task.getResult());
                                } else if (task.isCanceled()) {
                                    iVar.a();
                                } else {
                                    iVar.a(task.getException());
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    iVar.a(e);
                }
            }
        });
        addOnFailureListener(new OnFailureListener() {
            public final void onFailure(Exception exc) {
                iVar.a(exc);
            }
        });
        addOnCanceledListener(new OnCanceledListener() {
            public final void onCanceled() {
                iVar.a();
            }
        });
        return iVar;
    }
}
