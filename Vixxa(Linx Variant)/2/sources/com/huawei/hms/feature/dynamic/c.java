package com.huawei.hms.feature.dynamic;

import com.huawei.hms.common.util.Logger;
import java.lang.Thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class c {
    public static final String a = "ExecutorsManager";
    public static final long b = 60;

    public static class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);
        public final String b;

        /* renamed from: com.huawei.hms.feature.dynamic.c$a$a  reason: collision with other inner class name */
        public class C0001a implements Thread.UncaughtExceptionHandler {
            public C0001a() {
            }

            public void uncaughtException(Thread thread, Throwable th) {
                Logger.e(c.a, thread.getName() + " : " + th.getMessage());
            }
        }

        public a(String str) {
            this.b = str + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.a.getAndIncrement());
            thread.setUncaughtExceptionHandler(new C0001a());
            return thread;
        }
    }

    public static ExecutorService a(int i, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
