package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: BUGLY */
public final class ay {
    public static ay f;
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final ActivityManager b;
    final aa c;
    final ak d;
    String e;
    private final Context g;
    private final ac h;
    private final as i;
    private final Object j = new Object();
    private FileObserver k;
    private boolean l = true;
    private bg m;
    private int n;
    private long o = 0;

    public static synchronized ay a() {
        ay ayVar;
        synchronized (ay.class) {
            ayVar = f;
        }
        return ayVar;
    }

    public ay(Context context, ac acVar, aa aaVar, ak akVar, as asVar) {
        Context a2 = ap.a(context);
        this.g = a2;
        this.b = (ActivityManager) a2.getSystemService("activity");
        if (ap.a(NativeCrashHandler.getDumpFilePath())) {
            this.e = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.e = NativeCrashHandler.getDumpFilePath();
        }
        this.c = aaVar;
        this.d = akVar;
        this.h = acVar;
        this.i = asVar;
    }

    private CrashDetailBean a(ax axVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = this.c.k();
            crashDetailBean.G = this.c.j();
            crashDetailBean.H = this.c.l();
            crashDetailBean.I = ab.b(this.g);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = 3;
            crashDetailBean.e = this.c.g();
            crashDetailBean.f = this.c.o;
            crashDetailBean.g = this.c.q();
            crashDetailBean.m = this.c.f();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = axVar.f;
            crashDetailBean.q = axVar.g;
            crashDetailBean.T = new HashMap();
            crashDetailBean.T.put("BUGLY_CR_01", axVar.e);
            int indexOf = crashDetailBean.q != null ? crashDetailBean.q.indexOf("\n") : -1;
            crashDetailBean.p = indexOf > 0 ? crashDetailBean.q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.r = axVar.c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
            }
            crashDetailBean.z = axVar.b;
            crashDetailBean.A = axVar.a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.L = this.c.s();
            crashDetailBean.h = this.c.p();
            crashDetailBean.i = this.c.A();
            crashDetailBean.v = axVar.d;
            crashDetailBean.P = this.c.u;
            crashDetailBean.Q = this.c.a;
            crashDetailBean.R = this.c.a();
            crashDetailBean.U = this.c.z();
            crashDetailBean.V = this.c.x;
            crashDetailBean.W = this.c.t();
            crashDetailBean.X = this.c.y();
            crashDetailBean.y = ao.a();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private static boolean a(String str, String str2, String str3) {
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.d == null || readTargetDumpInfo.d.isEmpty()) {
            al.e("not found trace dump for %s", str3);
            return false;
        }
        StringBuilder sb = new StringBuilder(1024);
        String[] strArr = readTargetDumpInfo.d.get("main");
        if (strArr != null && strArr.length >= 3) {
            sb.append("\"main\" tid=").append(strArr[2]).append(" :\n").append(strArr[0]).append("\n").append(strArr[1]).append("\n\n");
        }
        for (Map.Entry next : readTargetDumpInfo.d.entrySet()) {
            if (!((String) next.getKey()).equals("main") && next.getValue() != null && ((String[]) next.getValue()).length >= 3) {
                sb.append("\"").append((String) next.getKey()).append("\" tid=").append(((String[]) next.getValue())[2]).append(" :\n").append(((String[]) next.getValue())[0]).append("\n").append(((String[]) next.getValue())[1]).append("\n\n");
            }
        }
        return am.a(str2, sb.toString(), sb.length() * 2);
    }

    private static String a(List<ba> list, long j2) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable";
        }
        StringBuilder sb = new StringBuilder(4096);
        sb.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        for (int i2 = 0; i2 < list.size(); i2++) {
            ba baVar = list.get(i2);
            sb.append("Thread name:").append(baVar.a).append("\n");
            long j3 = baVar.b - j2;
            sb.append("Got ").append(j3 <= 0 ? "before " : "after ");
            sb.append("anr:").append(Math.abs(j3)).append("ms\n");
            sb.append(baVar.c).append("\n");
            if (sb.length() * 2 >= 101376) {
                break;
            }
        }
        sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb.toString();
    }

    public final boolean a(boolean z) {
        boolean compareAndSet = this.a.compareAndSet(!z, z);
        al.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    private synchronized void c() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        AnonymousClass1 r0 = new FileObserver("/data/anr/") {
            public final void onEvent(int i, String str) {
                if (str != null) {
                    final String concat = "/data/anr/".concat(String.valueOf(str));
                    al.d("watching file %s", concat);
                    if (!concat.contains("trace")) {
                        al.d("not anr file %s", concat);
                    } else {
                        ay.this.d.a(new Runnable() {
                            public final void run() {
                                ay ayVar = ay.this;
                                String str = concat;
                                if (ayVar.a(true)) {
                                    try {
                                        al.c("read trace first dump for create time!", new Object[0]);
                                        TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                                        long j = readFirstDumpInfo != null ? readFirstDumpInfo.c : -1;
                                        if (j == -1) {
                                            al.d("trace dump fail could not get time!", new Object[0]);
                                            j = System.currentTimeMillis();
                                        }
                                        if (!ayVar.a(j)) {
                                            ayVar.a(j, str);
                                        }
                                    } catch (Throwable th) {
                                        if (!al.a(th)) {
                                            th.printStackTrace();
                                        }
                                        al.e("handle anr error %s", th.getClass().toString());
                                    }
                                }
                            }
                        });
                    }
                }
            }
        };
        this.k = r0;
        try {
            r0.startWatching();
            al.a("start anr monitor!", new Object[0]);
            this.d.a(new Runnable() {
                public final void run() {
                    ay.a(ay.this);
                }
            });
        } catch (Throwable th) {
            this.k = null;
            al.d("start anr monitor failed!", new Object[0]);
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized void d() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.k.stopWatching();
            this.k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized boolean e() {
        return this.k != null;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 116 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c(boolean r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            if (r1 == 0) goto L_0x0008
            r0.g()     // Catch:{ all -> 0x000f }
            monitor-exit(r0)
            return
        L_0x0008:
            r0.h()     // Catch:{ all -> 0x000f }
            monitor-exit(r0)
            return
        L_0x000d:
            monitor-exit(r0)     // Catch:{ all -> 0x000f }
            throw r1
        L_0x000f:
            r1 = move-exception
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ay.c(boolean):void");
    }

    private synchronized boolean f() {
        return this.l;
    }

    private synchronized void d(boolean z) {
        if (this.l != z) {
            al.a("user change anr %b", Boolean.valueOf(z));
            this.l = z;
        }
    }

    public final void b(boolean z) {
        d(z);
        boolean f2 = f();
        ac a2 = ac.a();
        if (a2 != null) {
            f2 = f2 && a2.c().f;
        }
        if (f2 != e()) {
            al.a("anr changed to %b", Boolean.valueOf(f2));
            c(f2);
        }
    }

    public final synchronized void b() {
        al.d("customer decides whether to open or close.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01af A[Catch:{ all -> 0x0206 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b7 A[Catch:{ all -> 0x0206 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01de A[Catch:{ all -> 0x0206 }] */
    public final void a(long r20, java.lang.String r22) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r0 = r22
            r4 = 0
            java.lang.String r5 = "anr time:%s"
            java.lang.Long r6 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0206 }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r5, r6)     // Catch:{ all -> 0x0206 }
            java.lang.Object r5 = r1.j     // Catch:{ all -> 0x0206 }
            monitor-enter(r5)     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.bg r6 = r1.m     // Catch:{ all -> 0x0203 }
            if (r6 == 0) goto L_0x0027
            java.lang.String r6 = "Disable record main stack trace."
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x0203 }
            com.tencent.bugly.proguard.al.c(r6, r7)     // Catch:{ all -> 0x0203 }
            com.tencent.bugly.proguard.bg r6 = r1.m     // Catch:{ all -> 0x0203 }
            r6.c()     // Catch:{ all -> 0x0203 }
        L_0x0027:
            monitor-exit(r5)     // Catch:{ all -> 0x0203 }
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0206 }
            java.lang.Thread r5 = r5.getThread()     // Catch:{ all -> 0x0206 }
            java.lang.String r5 = com.tencent.bugly.proguard.ap.a((java.lang.Thread) r5)     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.aa r6 = r1.c     // Catch:{ all -> 0x0206 }
            boolean r6 = r6.R     // Catch:{ all -> 0x0206 }
            int r7 = com.tencent.bugly.proguard.at.h     // Catch:{ all -> 0x0206 }
            java.util.Map r6 = com.tencent.bugly.proguard.ap.a((boolean) r6, (int) r7)     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.aa r7 = r1.c     // Catch:{ all -> 0x0206 }
            boolean r7 = r7.a()     // Catch:{ all -> 0x0206 }
            r8 = 0
            r10 = 1
            if (r7 == 0) goto L_0x0074
            android.content.Context r7 = r1.g     // Catch:{ all -> 0x0206 }
            boolean r11 = com.tencent.bugly.proguard.ab.e(r7)     // Catch:{ all -> 0x0206 }
            if (r11 != 0) goto L_0x005a
            boolean r7 = com.tencent.bugly.proguard.ab.f(r7)     // Catch:{ all -> 0x0206 }
            if (r7 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r7 = r4
            goto L_0x005b
        L_0x005a:
            r7 = r10
        L_0x005b:
            java.lang.String r11 = "isAnrCrashDevice:%s"
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0206 }
            java.lang.Object[] r12 = new java.lang.Object[]{r12}     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r11, r12)     // Catch:{ all -> 0x0206 }
            if (r7 == 0) goto L_0x006b
            goto L_0x0074
        L_0x006b:
            android.app.ActivityManager r7 = r1.b     // Catch:{ all -> 0x0206 }
            r11 = 21000(0x5208, double:1.03754E-319)
            android.app.ActivityManager$ProcessErrorStateInfo r7 = com.tencent.bugly.proguard.az.a(r7, r11)     // Catch:{ all -> 0x0206 }
            goto L_0x007a
        L_0x0074:
            android.app.ActivityManager r7 = r1.b     // Catch:{ all -> 0x0206 }
            android.app.ActivityManager$ProcessErrorStateInfo r7 = com.tencent.bugly.proguard.az.a(r7, r8)     // Catch:{ all -> 0x0206 }
        L_0x007a:
            if (r7 != 0) goto L_0x0087
            java.lang.String r0 = "proc state is invisible or not my proc!"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r0, r2)     // Catch:{ all -> 0x0206 }
            r1.a((boolean) r4)
            return
        L_0x0087:
            com.tencent.bugly.proguard.ax r11 = new com.tencent.bugly.proguard.ax     // Catch:{ all -> 0x0206 }
            r11.<init>()     // Catch:{ all -> 0x0206 }
            r11.c = r2     // Catch:{ all -> 0x0206 }
            if (r7 == 0) goto L_0x0093
            java.lang.String r12 = r7.processName     // Catch:{ all -> 0x0206 }
            goto L_0x009b
        L_0x0093:
            int r12 = android.os.Process.myPid()     // Catch:{ all -> 0x0206 }
            java.lang.String r12 = com.tencent.bugly.proguard.z.a((int) r12)     // Catch:{ all -> 0x0206 }
        L_0x009b:
            r11.a = r12     // Catch:{ all -> 0x0206 }
            if (r7 == 0) goto L_0x00a2
            java.lang.String r12 = r7.shortMsg     // Catch:{ all -> 0x0206 }
            goto L_0x00a4
        L_0x00a2:
            java.lang.String r12 = ""
        L_0x00a4:
            r11.f = r12     // Catch:{ all -> 0x0206 }
            if (r7 == 0) goto L_0x00ab
            java.lang.String r7 = r7.longMsg     // Catch:{ all -> 0x0206 }
            goto L_0x00ad
        L_0x00ab:
            java.lang.String r7 = ""
        L_0x00ad:
            r11.e = r7     // Catch:{ all -> 0x0206 }
            r11.b = r6     // Catch:{ all -> 0x0206 }
            r11.g = r5     // Catch:{ all -> 0x0206 }
            java.lang.String r5 = r11.g     // Catch:{ all -> 0x0206 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0206 }
            if (r5 == 0) goto L_0x00bf
            java.lang.String r5 = "main stack is null , some error may be encountered."
            r11.g = r5     // Catch:{ all -> 0x0206 }
        L_0x00bf:
            java.lang.String r5 = "anr time:%d\ntrace file:%s\nproc:%s\nmain stack:%s\nshort msg:%s\nlong msg:%s\n threads:%d"
            long r6 = r11.c     // Catch:{ all -> 0x0206 }
            java.lang.Long r12 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0206 }
            java.lang.String r13 = r11.d     // Catch:{ all -> 0x0206 }
            java.lang.String r14 = r11.a     // Catch:{ all -> 0x0206 }
            java.lang.String r15 = r11.g     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = r11.f     // Catch:{ all -> 0x0206 }
            java.lang.String r7 = r11.e     // Catch:{ all -> 0x0206 }
            java.util.Map<java.lang.String, java.lang.String> r8 = r11.b     // Catch:{ all -> 0x0206 }
            if (r8 != 0) goto L_0x00d7
            r8 = r4
            goto L_0x00dd
        L_0x00d7:
            java.util.Map<java.lang.String, java.lang.String> r8 = r11.b     // Catch:{ all -> 0x0206 }
            int r8 = r8.size()     // Catch:{ all -> 0x0206 }
        L_0x00dd:
            java.lang.Integer r18 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0206 }
            r16 = r6
            r17 = r7
            java.lang.Object[] r6 = new java.lang.Object[]{r12, r13, r14, r15, r16, r17, r18}     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r5, r6)     // Catch:{ all -> 0x0206 }
            java.lang.String r5 = "found visible anr , start to upload!"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x0206 }
            java.lang.String r5 = "trace file:%s"
            java.lang.Object[] r6 = new java.lang.Object[]{r22}     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r5, r6)     // Catch:{ all -> 0x0206 }
            boolean r5 = android.text.TextUtils.isEmpty(r22)     // Catch:{ all -> 0x0206 }
            if (r5 != 0) goto L_0x0195
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0206 }
            r5.<init>(r0)     // Catch:{ all -> 0x0206 }
            boolean r5 = r5.exists()     // Catch:{ all -> 0x0206 }
            if (r5 != 0) goto L_0x010f
            goto L_0x0195
        L_0x010f:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = r1.e     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0206 }
            java.lang.String r8 = "bugly_trace_"
            r7.<init>(r8)     // Catch:{ all -> 0x0206 }
            java.lang.StringBuilder r7 = r7.append(r2)     // Catch:{ all -> 0x0206 }
            java.lang.String r8 = ".txt"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x0206 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0206 }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = "trace file exists"
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r6, r7)     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = "/data/anr/"
            boolean r6 = r0.startsWith(r6)     // Catch:{ all -> 0x0206 }
            if (r6 == 0) goto L_0x0152
            java.lang.String r6 = r5.getAbsolutePath()     // Catch:{ all -> 0x0206 }
            java.lang.String r7 = r11.a     // Catch:{ all -> 0x0206 }
            boolean r0 = a((java.lang.String) r0, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = "backup trace isOK:%s"
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0206 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r6, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0206 }
            goto L_0x0168
        L_0x0152:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0206 }
            r6.<init>(r0)     // Catch:{ all -> 0x0206 }
            boolean r0 = r6.renameTo(r5)     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = "trace file rename :%s"
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0206 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r6, (java.lang.Object[]) r0)     // Catch:{ all -> 0x0206 }
        L_0x0168:
            java.lang.Object r6 = r1.j     // Catch:{ all -> 0x0206 }
            monitor-enter(r6)     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.bg r0 = r1.m     // Catch:{ all -> 0x0192 }
            if (r0 == 0) goto L_0x0176
            com.tencent.bugly.proguard.bf r0 = r0.a     // Catch:{ all -> 0x0192 }
            java.util.List r0 = r0.c()     // Catch:{ all -> 0x0192 }
            goto L_0x0177
        L_0x0176:
            r0 = 0
        L_0x0177:
            monitor-exit(r6)     // Catch:{ all -> 0x0192 }
            if (r0 == 0) goto L_0x018b
            java.lang.String r0 = a((java.util.List<com.tencent.bugly.proguard.ba>) r0, (long) r2)     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = "save main stack trace"
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r6, r7)     // Catch:{ all -> 0x0206 }
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            com.tencent.bugly.proguard.am.a((java.io.File) r5, (java.lang.String) r0, (long) r6, (boolean) r10)     // Catch:{ all -> 0x0206 }
        L_0x018b:
            java.lang.String r0 = r5.getAbsolutePath()     // Catch:{ all -> 0x0206 }
            r11.d = r0     // Catch:{ all -> 0x0206 }
            goto L_0x019c
        L_0x0192:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0192 }
            throw r0     // Catch:{ all -> 0x0206 }
        L_0x0195:
            java.lang.String r0 = "trace file is null or not exists, just ignore"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.c(r0, r5)     // Catch:{ all -> 0x0206 }
        L_0x019c:
            com.tencent.bugly.crashreport.crash.CrashDetailBean r0 = r1.a((com.tencent.bugly.proguard.ax) r11)     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.at r5 = com.tencent.bugly.proguard.at.a()     // Catch:{ all -> 0x0206 }
            r5.a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r0)     // Catch:{ all -> 0x0206 }
            long r5 = r0.a     // Catch:{ all -> 0x0206 }
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x01b7
            java.lang.String r5 = "backup anr record success!"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ all -> 0x0206 }
            goto L_0x01be
        L_0x01b7:
            java.lang.String r5 = "backup anr record fail!"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.al.d(r5, r6)     // Catch:{ all -> 0x0206 }
        L_0x01be:
            java.lang.String r12 = "ANR"
            java.lang.String r13 = com.tencent.bugly.proguard.ap.a((long) r20)     // Catch:{ all -> 0x0206 }
            java.lang.String r14 = r11.a     // Catch:{ all -> 0x0206 }
            java.lang.String r15 = "main"
            java.lang.String r2 = r11.g     // Catch:{ all -> 0x0206 }
            r16 = r2
            r17 = r0
            com.tencent.bugly.proguard.as.a(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.as r2 = r1.i     // Catch:{ all -> 0x0206 }
            boolean r3 = com.tencent.bugly.proguard.ab.o()     // Catch:{ all -> 0x0206 }
            r3 = r3 ^ r10
            boolean r2 = r2.a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r0, (boolean) r3)     // Catch:{ all -> 0x0206 }
            if (r2 != 0) goto L_0x01e3
            com.tencent.bugly.proguard.as r2 = r1.i     // Catch:{ all -> 0x0206 }
            r2.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r0, (boolean) r10)     // Catch:{ all -> 0x0206 }
        L_0x01e3:
            com.tencent.bugly.proguard.as r2 = r1.i     // Catch:{ all -> 0x0206 }
            r2.a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r0)     // Catch:{ all -> 0x0206 }
            java.lang.Object r2 = r1.j     // Catch:{ all -> 0x0206 }
            monitor-enter(r2)     // Catch:{ all -> 0x0206 }
            com.tencent.bugly.proguard.bg r0 = r1.m     // Catch:{ all -> 0x0200 }
            if (r0 == 0) goto L_0x01fb
            java.lang.String r0 = "Finish anr process."
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x0200 }
            com.tencent.bugly.proguard.al.c(r0, r3)     // Catch:{ all -> 0x0200 }
            com.tencent.bugly.proguard.bg r0 = r1.m     // Catch:{ all -> 0x0200 }
            r0.d()     // Catch:{ all -> 0x0200 }
        L_0x01fb:
            monitor-exit(r2)     // Catch:{ all -> 0x0200 }
            r1.a((boolean) r4)
            return
        L_0x0200:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0200 }
            throw r0     // Catch:{ all -> 0x0206 }
        L_0x0203:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0203 }
            throw r0     // Catch:{ all -> 0x0206 }
        L_0x0206:
            r0 = move-exception
            com.tencent.bugly.proguard.al.b(r0)     // Catch:{ all -> 0x020e }
            r1.a((boolean) r4)
            return
        L_0x020e:
            r0 = move-exception
            r2 = r0
            r1.a((boolean) r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ay.a(long, java.lang.String):void");
    }

    private synchronized void g() {
        if (e()) {
            al.d("start when started!", new Object[0]);
        } else if (!TextUtils.isEmpty(this.e)) {
            synchronized (this.j) {
                bg bgVar = this.m;
                if (bgVar == null || !bgVar.isAlive()) {
                    bg bgVar2 = new bg();
                    this.m = bgVar2;
                    boolean z = this.c.S;
                    bgVar2.b = z;
                    al.c("set record stack trace enable:".concat(String.valueOf(z)), new Object[0]);
                    bg bgVar3 = this.m;
                    StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                    int i2 = this.n;
                    this.n = i2 + 1;
                    bgVar3.setName(sb.append(i2).toString());
                    this.m.b();
                }
            }
            AnonymousClass3 r0 = new FileObserver(this.e) {
                public final void onEvent(int i, String str) {
                    if (str != null) {
                        al.d("observe file, dir:%s fileName:%s", ay.this.e, str);
                        if (!str.startsWith("manual_bugly_trace_") || !str.endsWith(".txt")) {
                            al.c("not manual trace file, ignore.", new Object[0]);
                        } else if (!ay.this.a.get()) {
                            al.c("proc is not in anr, just ignore", new Object[0]);
                        } else if (ay.this.c.a()) {
                            al.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                            NativeCrashHandler.getInstance().resendSigquit();
                            ay.this.a(am.a(str, "manual_bugly_trace_", ".txt"), ay.this.e + InternalZipConstants.ZIP_FILE_SEPARATOR + str);
                            al.c("Finish handling one anr.", new Object[0]);
                        } else {
                            al.c("Found background anr, resend sigquit later.", new Object[0]);
                            ay.this.a(am.a(str, "manual_bugly_trace_", ".txt"), ay.this.e + InternalZipConstants.ZIP_FILE_SEPARATOR + str);
                            al.c("Finish handling one anr, now resend sigquit.", new Object[0]);
                            NativeCrashHandler.getInstance().resendSigquit();
                        }
                    }
                }
            };
            this.k = r0;
            try {
                r0.startWatching();
                al.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.e);
                this.d.a(new Runnable() {
                    public final void run() {
                        ay.a(ay.this);
                    }
                });
            } catch (Throwable th) {
                this.k = null;
                al.d("startWatchingPrivateAnrDir failed!", new Object[0]);
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public final boolean a(long j2) {
        if (Math.abs(j2 - this.o) < WorkRequest.MIN_BACKOFF_MILLIS) {
            al.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.o = j2;
        return false;
    }

    private synchronized void h() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.j) {
            bg bgVar = this.m;
            if (bgVar != null) {
                bgVar.a();
                this.m = null;
            }
        }
        al.a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.k.stopWatching();
            this.k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(ay ayVar) {
        long currentTimeMillis = (at.i + System.currentTimeMillis()) - ap.b();
        am.a(ayVar.e, "bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "manual_bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "main_stack_record_", ".txt", currentTimeMillis);
        am.a(ayVar.e, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }
}
