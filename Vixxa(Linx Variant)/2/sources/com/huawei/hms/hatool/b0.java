package com.huawei.hms.hatool;

import com.microtech.aidexx.utils.TimeUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class b0 {
    private static b0 b = new b0();
    private static b0 c = new b0();
    private static b0 d = new b0();
    private ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, TimeUtils.oneMinuteMillis, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    private static class a implements Runnable {
        private Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public void run() {
            Runnable runnable = this.a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    static class b implements ThreadFactory {
        private static final AtomicInteger d = new AtomicInteger(1);
        private final ThreadGroup a;
        private final AtomicInteger b = new AtomicInteger(1);
        private final String c;

        b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.c = "FormalHASDK-base-" + d.getAndIncrement();
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0);
        }
    }

    static {
        new b0();
        new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return d;
    }

    public static b0 b() {
        return c;
    }

    public static b0 c() {
        return b;
    }

    public void a(g gVar) {
        try {
            this.a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
