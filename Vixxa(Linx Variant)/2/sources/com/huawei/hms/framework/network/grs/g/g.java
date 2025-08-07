package com.huawei.hms.framework.network.grs.g;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.g.j.c;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class g {
    /* access modifiers changed from: private */
    public static final ExecutorService b = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    private static final Map<String, com.huawei.hms.framework.network.grs.g.j.b> c = new ConcurrentHashMap(16);
    private static final Object d = new Object();
    /* access modifiers changed from: private */
    public com.huawei.hms.framework.network.grs.e.a a;

    class a implements Callable<d> {
        final /* synthetic */ c a;
        final /* synthetic */ String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;

        a(c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.a = cVar;
            this.b = str;
            this.c = cVar2;
        }

        public d call() {
            return new c(this.a, g.this.a).a(g.b, this.b, this.c);
        }
    }

    class b implements Runnable {
        final /* synthetic */ c a;
        final /* synthetic */ String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;
        final /* synthetic */ com.huawei.hms.framework.network.grs.b d;

        b(c cVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2, com.huawei.hms.framework.network.grs.b bVar) {
            this.a = cVar;
            this.b = str;
            this.c = cVar2;
            this.d = bVar;
        }

        public void run() {
            g gVar = g.this;
            gVar.a(gVar.a(this.a, this.b, this.c), this.d);
        }
    }

    /* access modifiers changed from: private */
    public void a(d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar == null) {
            return;
        }
        if (dVar == null) {
            Logger.v("RequestController", "GrsResponse is null");
            bVar.a();
            return;
        }
        Logger.v("RequestController", "GrsResponse is not null");
        bVar.a(dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0085, code lost:
        r8 = com.huawei.hms.framework.network.grs.g.i.a.a(r8.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008d, code lost:
        if (r8 == null) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        r8 = r8.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0094, code lost:
        r8 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        return r9.get((long) r8, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a0, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a1, code lost:
        r9 = "RequestController";
        r10 = "when check result, find Other Exception, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a6, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        r9 = "RequestController";
        r10 = "when check result, find TimeoutException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ac, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ad, code lost:
        r9 = "RequestController";
        r10 = "when check result, find InterruptedException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b2, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b3, code lost:
        r9 = "RequestController";
        r10 = "when check result, find ExecutionException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b8, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b9, code lost:
        r9 = "RequestController";
        r10 = "when check result, find CancellationException, check others";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bd, code lost:
        com.huawei.hms.framework.common.Logger.w(r9, r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c0, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.framework.network.grs.g.d a(com.huawei.hms.framework.network.grs.g.j.c r8, java.lang.String r9, com.huawei.hms.framework.network.grs.e.c r10) {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "request to server with service name is: "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RequestController"
            com.huawei.hms.framework.common.Logger.d(r1, r0)
            com.huawei.hms.framework.network.grs.GrsBaseInfo r0 = r8.b()
            android.content.Context r1 = r8.a()
            r2 = 1
            java.lang.String r0 = r0.getGrsParasKey(r2, r2, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "request spUrlKey: "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "RequestController"
            com.huawei.hms.framework.common.Logger.v(r2, r1)
            java.lang.Object r1 = d
            monitor-enter(r1)
            android.content.Context r2 = r8.a()     // Catch:{ all -> 0x00c1 }
            boolean r2 = com.huawei.hms.framework.common.NetworkUtil.isNetworkAvailable(r2)     // Catch:{ all -> 0x00c1 }
            r3 = 0
            if (r2 != 0) goto L_0x0045
            monitor-exit(r1)     // Catch:{ all -> 0x00c1 }
            return r3
        L_0x0045:
            com.huawei.hms.framework.network.grs.h.d$a r2 = com.huawei.hms.framework.network.grs.h.d.a(r0)     // Catch:{ all -> 0x00c1 }
            java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.g.j.b> r4 = c     // Catch:{ all -> 0x00c1 }
            java.lang.Object r5 = r4.get(r0)     // Catch:{ all -> 0x00c1 }
            com.huawei.hms.framework.network.grs.g.j.b r5 = (com.huawei.hms.framework.network.grs.g.j.b) r5     // Catch:{ all -> 0x00c1 }
            if (r5 == 0) goto L_0x005f
            boolean r6 = r5.b()     // Catch:{ all -> 0x00c1 }
            if (r6 != 0) goto L_0x005a
            goto L_0x005f
        L_0x005a:
            java.util.concurrent.Future r9 = r5.a()     // Catch:{ all -> 0x00c1 }
            goto L_0x0084
        L_0x005f:
            if (r2 == 0) goto L_0x006a
            boolean r2 = r2.a()     // Catch:{ all -> 0x00c1 }
            if (r2 != 0) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            monitor-exit(r1)     // Catch:{ all -> 0x00c1 }
            return r3
        L_0x006a:
            java.lang.String r2 = "RequestController"
            java.lang.String r5 = "hitGrsRequestBean == null or request block is released."
            com.huawei.hms.framework.common.Logger.d(r2, r5)     // Catch:{ all -> 0x00c1 }
            java.util.concurrent.ExecutorService r2 = b     // Catch:{ all -> 0x00c1 }
            com.huawei.hms.framework.network.grs.g.g$a r5 = new com.huawei.hms.framework.network.grs.g.g$a     // Catch:{ all -> 0x00c1 }
            r5.<init>(r8, r9, r10)     // Catch:{ all -> 0x00c1 }
            java.util.concurrent.Future r9 = r2.submit(r5)     // Catch:{ all -> 0x00c1 }
            com.huawei.hms.framework.network.grs.g.j.b r10 = new com.huawei.hms.framework.network.grs.g.j.b     // Catch:{ all -> 0x00c1 }
            r10.<init>(r9)     // Catch:{ all -> 0x00c1 }
            r4.put(r0, r10)     // Catch:{ all -> 0x00c1 }
        L_0x0084:
            monitor-exit(r1)     // Catch:{ all -> 0x00c1 }
            android.content.Context r8 = r8.a()
            com.huawei.hms.framework.network.grs.g.j.d r8 = com.huawei.hms.framework.network.grs.g.i.a.a(r8)
            if (r8 == 0) goto L_0x0094
            int r8 = r8.c()
            goto L_0x0096
        L_0x0094:
            r8 = 10
        L_0x0096:
            long r0 = (long) r8
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ CancellationException -> 0x00b8, ExecutionException -> 0x00b2, InterruptedException -> 0x00ac, TimeoutException -> 0x00a6, Exception -> 0x00a0 }
            java.lang.Object r8 = r9.get(r0, r8)     // Catch:{ CancellationException -> 0x00b8, ExecutionException -> 0x00b2, InterruptedException -> 0x00ac, TimeoutException -> 0x00a6, Exception -> 0x00a0 }
            com.huawei.hms.framework.network.grs.g.d r8 = (com.huawei.hms.framework.network.grs.g.d) r8     // Catch:{ CancellationException -> 0x00b8, ExecutionException -> 0x00b2, InterruptedException -> 0x00ac, TimeoutException -> 0x00a6, Exception -> 0x00a0 }
            return r8
        L_0x00a0:
            r8 = move-exception
            java.lang.String r9 = "RequestController"
            java.lang.String r10 = "when check result, find Other Exception, check others"
            goto L_0x00bd
        L_0x00a6:
            r8 = move-exception
            java.lang.String r9 = "RequestController"
            java.lang.String r10 = "when check result, find TimeoutException, check others"
            goto L_0x00bd
        L_0x00ac:
            r8 = move-exception
            java.lang.String r9 = "RequestController"
            java.lang.String r10 = "when check result, find InterruptedException, check others"
            goto L_0x00bd
        L_0x00b2:
            r8 = move-exception
            java.lang.String r9 = "RequestController"
            java.lang.String r10 = "when check result, find ExecutionException, check others"
            goto L_0x00bd
        L_0x00b8:
            r8 = move-exception
            java.lang.String r9 = "RequestController"
            java.lang.String r10 = "when check result, find CancellationException, check others"
        L_0x00bd:
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r9, (java.lang.String) r10, (java.lang.Throwable) r8)
            return r3
        L_0x00c1:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c1 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.g.a(com.huawei.hms.framework.network.grs.g.j.c, java.lang.String, com.huawei.hms.framework.network.grs.e.c):com.huawei.hms.framework.network.grs.g.d");
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.a = aVar;
    }

    public void a(c cVar, com.huawei.hms.framework.network.grs.b bVar, String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        b.execute(new b(cVar, str, cVar2, bVar));
    }

    public void a(String str) {
        synchronized (d) {
            c.remove(str);
        }
    }
}
