package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: BUGLY */
public final class bf implements Runnable {
    final Handler a;
    long b;
    boolean c;
    long d;
    private final String e;
    private final List<ba> f = new LinkedList();
    private final long g;

    bf(Handler handler, String str) {
        this.a = handler;
        this.e = str;
        this.b = 5000;
        this.g = 5000;
        this.c = true;
    }

    public final boolean a() {
        return !this.c && SystemClock.uptimeMillis() >= this.d + this.b;
    }

    private Thread e() {
        return this.a.getLooper().getThread();
    }

    public final void run() {
        this.c = true;
        this.b = this.g;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f) {
            arrayList = new ArrayList(this.f.size());
            for (int i = 0; i < this.f.size(); i++) {
                ba baVar = this.f.get(i);
                if (!baVar.e && currentTimeMillis - baVar.b < 200000) {
                    arrayList.add(baVar);
                    baVar.e = true;
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement append : stackTrace) {
                    sb.append(append).append("\n");
                }
            }
        } catch (SecurityException e2) {
            sb.append("getStackTrace() encountered:\n").append(e2.getMessage()).append("\n");
            al.a(e2);
        }
        long nanoTime2 = System.nanoTime();
        ba baVar = new ba(sb.toString(), System.currentTimeMillis());
        baVar.d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.a = name;
        synchronized (this.f) {
            while (this.f.size() >= 32) {
                this.f.remove(0);
            }
            this.f.add(baVar);
        }
    }
}
