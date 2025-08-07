package com.igexin.a.a.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class j implements ThreadFactory {
    final AtomicInteger a = new AtomicInteger(0);
    final /* synthetic */ h b;

    public j(h hVar) {
        this.b = hVar;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "TS-pool-" + this.a.incrementAndGet());
    }
}
