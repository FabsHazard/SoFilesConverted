package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final a a = new a();
    private static final int c;
    private static final int d;
    private static final int e;
    private final Executor b = new C0000a((byte) 0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a  reason: collision with other inner class name */
    static class C0000a implements Executor {
        private C0000a() {
        }

        /* synthetic */ C0000a(byte b) {
            this();
        }

        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        c = availableProcessors;
        d = availableProcessors + 1;
        e = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return a.b;
    }
}
