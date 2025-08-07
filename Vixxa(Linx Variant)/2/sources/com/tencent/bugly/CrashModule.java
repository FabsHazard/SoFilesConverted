package com.tencent.bugly;

import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.o;

/* compiled from: BUGLY */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;
    private static int c;
    private static CrashModule e = new CrashModule();
    private long a;
    private BuglyStrategy.a b;
    private boolean d = false;

    public static CrashModule getInstance() {
        e.id = 1004;
        return e;
    }

    public synchronized boolean hasInitialized() {
        return this.d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e5, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void init(android.content.Context r5, boolean r6, com.tencent.bugly.BuglyStrategy r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x00e4
            boolean r0 = r4.d     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x0009
            goto L_0x00e4
        L_0x0009:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.u r0 = com.tencent.bugly.proguard.u.a()     // Catch:{ all -> 0x00e1 }
            int r2 = c     // Catch:{ all -> 0x00e1 }
            r3 = 1
            int r2 = r2 + r3
            c = r2     // Catch:{ all -> 0x00e1 }
            r0.a((int) r2)     // Catch:{ all -> 0x00e1 }
            r4.d = r3     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.crashreport.CrashReport.setContext(r5)     // Catch:{ all -> 0x00e1 }
            r4.a(r5, r7)     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.BuglyStrategy$a r0 = r4.b     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.at r6 = com.tencent.bugly.proguard.at.a((android.content.Context) r5, (boolean) r6, (com.tencent.bugly.BuglyStrategy.a) r0)     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.av r0 = r6.s     // Catch:{ all -> 0x00e1 }
            r0.a()     // Catch:{ all -> 0x00e1 }
            if (r7 == 0) goto L_0x0061
            int r0 = r7.getCallBackType()     // Catch:{ all -> 0x00e1 }
            r6.A = r0     // Catch:{ all -> 0x00e1 }
            boolean r0 = r7.getCloseErrorCallback()     // Catch:{ all -> 0x00e1 }
            r6.B = r0     // Catch:{ all -> 0x00e1 }
            boolean r0 = r7.isUploadSpotCrash()     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.at.n = r0     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.a((android.content.Context) r5)     // Catch:{ all -> 0x00e1 }
            boolean r2 = r7.isEnableRecordAnrMainStack()     // Catch:{ all -> 0x00e1 }
            r0.S = r2     // Catch:{ all -> 0x00e1 }
            boolean r0 = r7.isEnableCatchAnrTrace()     // Catch:{ all -> 0x00e1 }
            if (r0 != 0) goto L_0x005b
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.t     // Catch:{ all -> 0x00e1 }
            r0.disableCatchAnrTrace()     // Catch:{ all -> 0x00e1 }
            goto L_0x0066
        L_0x005b:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.t     // Catch:{ all -> 0x00e1 }
            r0.enableCatchAnrTrace()     // Catch:{ all -> 0x00e1 }
            goto L_0x0066
        L_0x0061:
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.t     // Catch:{ all -> 0x00e1 }
            r0.enableCatchAnrTrace()     // Catch:{ all -> 0x00e1 }
        L_0x0066:
            com.tencent.bugly.proguard.aa r0 = com.tencent.bugly.proguard.aa.b()     // Catch:{ all -> 0x00e1 }
            java.lang.String r0 = r0.d     // Catch:{ all -> 0x00e1 }
            android.content.Context r2 = r6.c     // Catch:{ all -> 0x00e1 }
            java.lang.String r2 = com.tencent.bugly.proguard.z.a((android.content.Context) r2)     // Catch:{ all -> 0x00e1 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x007d
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r0 = r6.t     // Catch:{ all -> 0x00e1 }
            r0.removeEmptyNativeRecordFiles()     // Catch:{ all -> 0x00e1 }
        L_0x007d:
            if (r7 == 0) goto L_0x0091
            boolean r0 = r7.isEnableNativeCrashMonitor()     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x0086
            goto L_0x0091
        L_0x0086:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ all -> 0x00e1 }
            r6.d()     // Catch:{ all -> 0x00e1 }
            goto L_0x0094
        L_0x0091:
            r6.e()     // Catch:{ all -> 0x00e1 }
        L_0x0094:
            if (r7 == 0) goto L_0x00a8
            boolean r0 = r7.isEnableANRCrashMonitor()     // Catch:{ all -> 0x00e1 }
            if (r0 == 0) goto L_0x009d
            goto L_0x00a8
        L_0x009d:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00e1 }
            r6.g()     // Catch:{ all -> 0x00e1 }
            goto L_0x00ab
        L_0x00a8:
            r6.f()     // Catch:{ all -> 0x00e1 }
        L_0x00ab:
            if (r7 == 0) goto L_0x00b3
            boolean r0 = r7.isMerged()     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.at.e = r0     // Catch:{ all -> 0x00e1 }
        L_0x00b3:
            if (r7 == 0) goto L_0x00ba
            long r0 = r7.getAppReportDelay()     // Catch:{ all -> 0x00e1 }
            goto L_0x00bc
        L_0x00ba:
            r0 = 0
        L_0x00bc:
            r6.a((long) r0)     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r6 = r6.t     // Catch:{ all -> 0x00e1 }
            r6.checkUploadRecordCrash()     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.au.a((android.content.Context) r5)     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.aq r6 = com.tencent.bugly.proguard.aq.a()     // Catch:{ all -> 0x00e1 }
            java.lang.String r7 = "android.net.conn.CONNECTIVITY_CHANGE"
            r6.a((java.lang.String) r7)     // Catch:{ all -> 0x00e1 }
            r6.a((android.content.Context) r5)     // Catch:{ all -> 0x00e1 }
            com.tencent.bugly.proguard.u r5 = com.tencent.bugly.proguard.u.a()     // Catch:{ all -> 0x00e1 }
            int r6 = c     // Catch:{ all -> 0x00e1 }
            int r6 = r6 - r3
            c = r6     // Catch:{ all -> 0x00e1 }
            r5.a((int) r6)     // Catch:{ all -> 0x00e1 }
            monitor-exit(r4)
            return
        L_0x00e1:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00e1 }
            throw r5
        L_0x00e4:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(android.content.Context r5, com.tencent.bugly.BuglyStrategy r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L_0x0005
            monitor-exit(r4)
            return
        L_0x0005:
            java.lang.String r0 = r6.getLibBuglySOFilePath()     // Catch:{ all -> 0x0051 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x001e
            com.tencent.bugly.proguard.aa r5 = com.tencent.bugly.proguard.aa.a((android.content.Context) r5)     // Catch:{ all -> 0x0051 }
            r5.t = r0     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "setted libBugly.so file path :%s"
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x0051 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0051 }
        L_0x001e:
            com.tencent.bugly.BuglyStrategy$a r5 = r6.getCrashHandleCallback()     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x0032
            com.tencent.bugly.BuglyStrategy$a r5 = r6.getCrashHandleCallback()     // Catch:{ all -> 0x0051 }
            r4.b = r5     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "setted CrashHanldeCallback"
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x0051 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0051 }
        L_0x0032:
            long r0 = r6.getAppReportDelay()     // Catch:{ all -> 0x0051 }
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L_0x004f
            long r5 = r6.getAppReportDelay()     // Catch:{ all -> 0x0051 }
            r4.a = r5     // Catch:{ all -> 0x0051 }
            java.lang.String r0 = "setted delay: %d"
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0051 }
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0051 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r4)
            return
        L_0x0051:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0051 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.a(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at a2;
        if (strategyBean != null && (a2 = at.a()) != null) {
            a2.s.a(strategyBean);
            a2.t.onStrategyChanged(strategyBean);
            a2.w.b();
        }
    }

    public String[] getTables() {
        return new String[]{"t_cr"};
    }
}
