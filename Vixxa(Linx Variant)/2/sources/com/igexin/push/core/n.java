package com.igexin.push.core;

import android.content.ContentValues;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class n {
    private static volatile n e;
    private final Object a = new Object();
    private boolean b = false;
    private final Map<String, Object> c = new HashMap();
    private final ExecutorService d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private n() {
        b();
    }

    public static n a() {
        if (e == null) {
            synchronized (n.class) {
                if (e == null) {
                    e = new n();
                }
            }
        }
        return e;
    }

    private void b() {
        new Thread(new o(this), "MessageTaskIDPreferences-load").start();
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void c() {
        /*
            r9 = this;
            java.lang.String r0 = " createtime >= "
            java.lang.Object r1 = r9.a
            monitor-enter(r1)
            boolean r2 = r9.b     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x00a2 }
            return
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x00a2 }
            r1 = 0
            r2 = 1
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            r5 = 604800000(0x240c8400, double:2.988109026E-315)
            long r3 = r3 - r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            java.lang.StringBuilder r0 = r5.append(r3)     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            com.igexin.push.core.c r3 = com.igexin.push.core.c.a()     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            com.igexin.push.b.b r3 = r3.k()     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            java.lang.String r4 = "message"
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            java.lang.String r6 = "taskid"
            r7 = 0
            r5[r7] = r6     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            android.database.Cursor r0 = r3.a((java.lang.String) r4, (java.lang.String[]) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x008e, all -> 0x0076 }
            if (r0 == 0) goto L_0x0057
            int r3 = r0.getCount()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r3 > 0) goto L_0x0041
            goto L_0x0057
        L_0x0041:
            boolean r3 = r0.moveToNext()     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            if (r3 == 0) goto L_0x005e
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.c     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r4 = "taskid"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            java.lang.String r4 = r0.getString(r4)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            r3.put(r4, r1)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            goto L_0x0041
        L_0x0057:
            java.lang.String r1 = "MessageTaskIDPreference|db cnt = 0"
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
            com.igexin.a.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x0074, all -> 0x0072 }
        L_0x005e:
            java.lang.Object r1 = r9.a
            monitor-enter(r1)
            r9.b = r2     // Catch:{ all -> 0x006f }
            java.lang.Object r2 = r9.a     // Catch:{ all -> 0x006f }
            r2.notifyAll()     // Catch:{ all -> 0x006f }
            monitor-exit(r1)     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x009e
            r0.close()     // Catch:{ all -> 0x009e }
            goto L_0x009e
        L_0x006f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006f }
            throw r0
        L_0x0072:
            r1 = move-exception
            goto L_0x007a
        L_0x0074:
            r1 = r0
            goto L_0x008e
        L_0x0076:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x007a:
            java.lang.Object r3 = r9.a
            monitor-enter(r3)
            r9.b = r2     // Catch:{ all -> 0x008b }
            java.lang.Object r2 = r9.a     // Catch:{ all -> 0x008b }
            r2.notifyAll()     // Catch:{ all -> 0x008b }
            monitor-exit(r3)     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x008a
            r0.close()     // Catch:{ all -> 0x008a }
        L_0x008a:
            throw r1
        L_0x008b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x008b }
            throw r0
        L_0x008e:
            java.lang.Object r0 = r9.a
            monitor-enter(r0)
            r9.b = r2     // Catch:{ all -> 0x009f }
            java.lang.Object r2 = r9.a     // Catch:{ all -> 0x009f }
            r2.notifyAll()     // Catch:{ all -> 0x009f }
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x009e
            r1.close()     // Catch:{ all -> 0x009e }
        L_0x009e:
            return
        L_0x009f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009f }
            throw r1
        L_0x00a2:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a2 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.c():void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x0003 A[LOOP:0: B:2:0x0003->B:13:0x0003, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.a
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r2.b     // Catch:{ all -> 0x000f }
            if (r1 != 0) goto L_0x000d
            java.lang.Object r1 = r2.a     // Catch:{ InterruptedException -> 0x0003 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0003 }
            goto L_0x0003
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            return
        L_0x000f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.n.d():void");
    }

    public void a(String str, ContentValues contentValues) {
        if (!TextUtils.isEmpty(str)) {
            d();
            synchronized (this.a) {
                this.c.put(str, (Object) null);
            }
            this.d.execute(new p(this, contentValues));
        }
    }

    public boolean a(String str) {
        boolean containsKey;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d();
        synchronized (this.a) {
            containsKey = this.c.containsKey(str);
        }
        return containsKey;
    }

    public void b(String str, ContentValues contentValues) {
        if (a(str)) {
            this.d.execute(new q(this, contentValues, str));
        }
    }
}
