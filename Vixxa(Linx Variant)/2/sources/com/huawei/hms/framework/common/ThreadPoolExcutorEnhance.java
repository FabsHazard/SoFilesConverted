package com.huawei.hms.framework.common;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorEnhance extends ThreadPoolExecutor {
    public ThreadPoolExcutorEnhance(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    public ThreadPoolExcutorEnhance(int i, int i2, int i3, TimeUnit timeUnit, LinkedBlockingQueue<Runnable> linkedBlockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, (long) i3, timeUnit, linkedBlockingQueue, threadFactory, rejectedExecutionHandler);
    }

    public void execute(Runnable runnable) {
        super.execute(new RunnableEnhance(runnable));
    }

    /* access modifiers changed from: protected */
    public void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof RunnableEnhance) {
            String parentName = ((RunnableEnhance) runnable).getParentName();
            int lastIndexOf = parentName.lastIndexOf(" -->");
            if (lastIndexOf != -1) {
                parentName = StringUtils.substring(parentName, lastIndexOf + " -->".length());
            }
            String name = thread.getName();
            int lastIndexOf2 = name.lastIndexOf(" -->");
            if (lastIndexOf2 != -1) {
                name = StringUtils.substring(name, lastIndexOf2 + " -->".length());
            }
            thread.setName(parentName + " -->" + name);
        }
        super.beforeExecute(thread, runnable);
    }
}
