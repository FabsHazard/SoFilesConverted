package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class bd implements NativeExceptionHandler {
    private final Context a;
    private final as b;
    private final aa c;
    private final ac d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.a = context;
        this.b = asVar;
        this.c = aaVar;
        this.d = acVar;
    }

    public final CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z, boolean z2) {
        int length;
        String str12;
        int indexOf;
        String str13 = str;
        String str14 = str8;
        byte[] bArr2 = bArr;
        boolean i = at.a().i();
        if (i) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = this.c.g();
        crashDetailBean.f = this.c.o;
        crashDetailBean.g = this.c.q();
        crashDetailBean.m = this.c.f();
        crashDetailBean.n = str3;
        String str15 = "";
        crashDetailBean.o = i ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : str15;
        crashDetailBean.p = str4;
        if (str5 != null) {
            str15 = str5;
        }
        crashDetailBean.q = str15;
        crashDetailBean.r = j;
        crashDetailBean.u = ap.c(crashDetailBean.q.getBytes());
        crashDetailBean.A = str13;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.c.s();
        crashDetailBean.h = this.c.p();
        crashDetailBean.i = this.c.A();
        crashDetailBean.v = str14;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String a2 = be.a(dumpFilePath, str14);
        if (!ap.a(a2)) {
            crashDetailBean.Z = a2;
        }
        crashDetailBean.aa = be.b(dumpFilePath);
        crashDetailBean.w = be.a(str9, at.f, at.j, at.o);
        crashDetailBean.x = be.a(str10, at.f, (String) null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.c.k();
        crashDetailBean.G = this.c.j();
        crashDetailBean.H = this.c.l();
        crashDetailBean.I = ab.b(this.a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (z) {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.y = ao.a();
            crashDetailBean.Q = this.c.a;
            crashDetailBean.R = this.c.a();
            crashDetailBean.z = ap.a(this.c.Q, at.h);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (length = indexOf2 + "java:\n".length()) < crashDetailBean.q.length()) {
                String str16 = crashDetailBean.q;
                String substring = str16.substring(length, str16.length() - 1);
                if (substring.length() > 0 && crashDetailBean.z.containsKey(crashDetailBean.B) && (indexOf = str12.indexOf(substring)) > 0) {
                    String substring2 = (str12 = crashDetailBean.z.get(crashDetailBean.B)).substring(indexOf);
                    crashDetailBean.z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, length);
                    crashDetailBean.q += substring2;
                }
            }
            if (str13 == null) {
                crashDetailBean.A = this.c.d;
            }
            crashDetailBean.U = this.c.z();
            crashDetailBean.V = this.c.x;
            crashDetailBean.W = this.c.t();
            crashDetailBean.X = this.c.y();
        } else {
            crashDetailBean.C = -1;
            crashDetailBean.D = -1;
            crashDetailBean.E = -1;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.c.y();
            crashDetailBean.z = null;
            if (str13 == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr2 != null) {
                crashDetailBean.y = bArr2;
            }
        }
        return crashDetailBean;
    }

    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay a2 = ay.a();
        if (a2.a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a2.b;
        if (z.a(activityManager) || az.a(activityManager, 0) == null) {
            al.c("proc is not in anr, wait next check", new Object[0]);
            return false;
        } else if (a2.a(System.currentTimeMillis())) {
            return false;
        } else {
            return a2.a(true);
        }
    }

    public final void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        int i7 = i;
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, (String[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d A[Catch:{ all -> 0x023a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00bf A[Catch:{ all -> 0x023a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00fb A[Catch:{ all -> 0x023a }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010e A[SYNTHETIC, Splitter:B:28:0x010e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0156 A[Catch:{ all -> 0x023a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x015b A[Catch:{ all -> 0x023a }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0161 A[Catch:{ all -> 0x023a }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01b8 A[Catch:{ all -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c1 A[Catch:{ all -> 0x0236 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            r27 = this;
            r14 = r27
            r0 = r29
            r13 = r35
            r1 = r40
            r12 = 0
            java.lang.Object[] r2 = new java.lang.Object[r12]
            java.lang.String r3 = "Native Crash Happen v2"
            com.tencent.bugly.proguard.al.a((java.lang.String) r3, (java.lang.Object[]) r2)
            java.lang.String r2 = ")"
            java.lang.String r3 = "("
            if (r38 <= 0) goto L_0x0035
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            r4.<init>()     // Catch:{ all -> 0x023a }
            r5 = r34
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r4 = r4.append(r3)     // Catch:{ all -> 0x023a }
            r6 = r39
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r4 = r4.append(r2)     // Catch:{ all -> 0x023a }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x023a }
            r11 = r4
            goto L_0x003a
        L_0x0035:
            r5 = r34
            r6 = r39
            r11 = r5
        L_0x003a:
            java.lang.String r10 = com.tencent.bugly.proguard.be.a((java.lang.String) r36)     // Catch:{ all -> 0x023a }
            java.util.Map r4 = a(r45)     // Catch:{ all -> 0x023a }
            java.lang.String r5 = "HasPendingException"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x023a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x023a }
            r9 = 1
            if (r5 == 0) goto L_0x005f
            java.lang.String r7 = "true"
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x023a }
            if (r5 == 0) goto L_0x005f
            java.lang.String r5 = "Native crash happened with a Java pending exception."
            java.lang.Object[] r7 = new java.lang.Object[r12]     // Catch:{ all -> 0x023a }
            com.tencent.bugly.proguard.al.a((java.lang.String) r5, (java.lang.Object[]) r7)     // Catch:{ all -> 0x023a }
            r18 = r9
            goto L_0x0061
        L_0x005f:
            r18 = r12
        L_0x0061:
            com.tencent.bugly.proguard.aa r5 = r14.c     // Catch:{ all -> 0x023a }
            java.lang.String r7 = "ExceptionProcessName"
            java.lang.Object r7 = r4.get(r7)     // Catch:{ all -> 0x023a }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x023a }
            if (r7 == 0) goto L_0x007e
            int r8 = r7.length()     // Catch:{ all -> 0x023a }
            if (r8 != 0) goto L_0x0074
            goto L_0x007e
        L_0x0074:
            java.lang.String r5 = "Name of crash process: %s"
            java.lang.Object[] r8 = new java.lang.Object[]{r7}     // Catch:{ all -> 0x023a }
            com.tencent.bugly.proguard.al.c(r5, r8)     // Catch:{ all -> 0x023a }
            goto L_0x0080
        L_0x007e:
            java.lang.String r7 = r5.d     // Catch:{ all -> 0x023a }
        L_0x0080:
            r19 = r7
            java.lang.String r5 = "ExceptionThreadName"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x023a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x023a }
            java.lang.String r7 = "crash thread name:%s tid:%s"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r29)     // Catch:{ all -> 0x023a }
            java.lang.Object[] r8 = new java.lang.Object[]{r5, r8}     // Catch:{ all -> 0x023a }
            com.tencent.bugly.proguard.al.c(r7, r8)     // Catch:{ all -> 0x023a }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x023a }
            if (r7 == 0) goto L_0x00bf
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            r7.<init>()     // Catch:{ all -> 0x023a }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r5 = r7.append(r5)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x023a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x023a }
            goto L_0x00d8
        L_0x00bf:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            r7.<init>()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r5 = r7.append(r5)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x023a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x023a }
        L_0x00d8:
            r7 = 1000(0x3e8, double:4.94E-321)
            long r15 = r30 * r7
            long r7 = r32 / r7
            long r7 = r7 + r15
            java.lang.String r5 = "SysLogPath"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ all -> 0x023a }
            r20 = r5
            java.lang.String r20 = (java.lang.String) r20     // Catch:{ all -> 0x023a }
            java.lang.String r5 = "JniLogPath"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x023a }
            r21 = r4
            java.lang.String r21 = (java.lang.String) r21     // Catch:{ all -> 0x023a }
            com.tencent.bugly.proguard.ac r4 = r14.d     // Catch:{ all -> 0x023a }
            boolean r4 = r4.b()     // Catch:{ all -> 0x023a }
            if (r4 != 0) goto L_0x0102
            java.lang.String r4 = "no remote but still store!"
            java.lang.Object[] r5 = new java.lang.Object[r12]     // Catch:{ all -> 0x023a }
            com.tencent.bugly.proguard.al.d(r4, r5)     // Catch:{ all -> 0x023a }
        L_0x0102:
            com.tencent.bugly.proguard.ac r4 = r14.d     // Catch:{ all -> 0x023a }
            com.tencent.bugly.crashreport.common.strategy.StrategyBean r4 = r4.c()     // Catch:{ all -> 0x023a }
            boolean r4 = r4.f     // Catch:{ all -> 0x023a }
            java.lang.String r5 = "\n"
            if (r4 != 0) goto L_0x0154
            com.tencent.bugly.proguard.ac r4 = r14.d     // Catch:{ all -> 0x023a }
            boolean r4 = r4.b()     // Catch:{ all -> 0x023a }
            if (r4 == 0) goto L_0x0154
            java.lang.String r1 = "crash report was closed by remote , will not upload to Bugly , print local for helpful!"
            java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ all -> 0x023a }
            com.tencent.bugly.proguard.al.e(r1, r2)     // Catch:{ all -> 0x023a }
            java.lang.String r1 = "NATIVE_CRASH"
            java.lang.String r2 = com.tencent.bugly.proguard.ap.a()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            r3.<init>()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r3 = r3.append(r11)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r3 = r3.append(r13)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r3 = r3.append(r10)     // Catch:{ all -> 0x023a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x023a }
            r4 = 0
            r28 = r1
            r29 = r2
            r30 = r19
            r31 = r0
            r32 = r3
            r33 = r4
            com.tencent.bugly.proguard.as.a(r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x023a }
            com.tencent.bugly.proguard.ap.b((java.lang.String) r37)     // Catch:{ all -> 0x023a }
            return
        L_0x0154:
            if (r38 <= 0) goto L_0x015b
            java.lang.String r4 = "KERNEL"
            r22 = r4
            goto L_0x015d
        L_0x015b:
            r22 = r6
        L_0x015d:
            java.lang.String r4 = "UNKNOWN"
            if (r38 > 0) goto L_0x018d
            if (r1 <= 0) goto L_0x0167
            java.lang.String r4 = com.tencent.bugly.proguard.z.a((int) r40)     // Catch:{ all -> 0x023a }
        L_0x0167:
            java.lang.String r6 = java.lang.String.valueOf(r40)     // Catch:{ all -> 0x023a }
            boolean r6 = r4.equals(r6)     // Catch:{ all -> 0x023a }
            if (r6 != 0) goto L_0x018d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x023a }
            r6.<init>()     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r4 = r6.append(r4)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ all -> 0x023a }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x023a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x023a }
            r23 = r1
            goto L_0x018f
        L_0x018d:
            r23 = r4
        L_0x018f:
            r16 = 0
            r17 = 1
            r15 = 0
            r1 = r27
            r2 = r19
            r3 = r0
            r6 = r5
            r4 = r7
            r8 = r6
            r6 = r11
            r7 = r35
            r24 = r8
            r8 = r10
            r9 = r22
            r25 = r10
            r10 = r23
            r26 = r11
            r11 = r37
            r12 = r20
            r13 = r21
            r14 = r44
            com.tencent.bugly.crashreport.crash.CrashDetailBean r1 = r1.packageCrashDatas(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0236 }
            if (r1 != 0) goto L_0x01c1
            java.lang.String r0 = "pkg crash datas fail!"
            r2 = 0
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0236 }
            com.tencent.bugly.proguard.al.e(r0, r1)     // Catch:{ all -> 0x0236 }
            return
        L_0x01c1:
            r2 = 0
            java.lang.String r3 = "NATIVE_CRASH"
            java.lang.String r4 = com.tencent.bugly.proguard.ap.a()     // Catch:{ all -> 0x0236 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0236 }
            r5.<init>()     // Catch:{ all -> 0x0236 }
            r6 = r26
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0236 }
            r6 = r24
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0236 }
            r7 = r35
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ all -> 0x0236 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0236 }
            r6 = r25
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0236 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0236 }
            r28 = r3
            r29 = r4
            r30 = r19
            r31 = r0
            r32 = r5
            r33 = r1
            com.tencent.bugly.proguard.as.a(r28, r29, r30, r31, r32, r33)     // Catch:{ all -> 0x0236 }
            r3 = r27
            com.tencent.bugly.proguard.as r0 = r3.b     // Catch:{ all -> 0x0234 }
            if (r0 != 0) goto L_0x020a
            java.lang.String r0 = "crashHandler is null. Won't upload native crash."
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0234 }
            com.tencent.bugly.proguard.al.d(r0, r1)     // Catch:{ all -> 0x0234 }
            return
        L_0x020a:
            r2 = 1
            boolean r0 = r0.a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r1, (boolean) r2)     // Catch:{ all -> 0x0234 }
            com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler r4 = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getInstance()     // Catch:{ all -> 0x0234 }
            if (r4 == 0) goto L_0x021a
            java.lang.String r4 = com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.getDumpFilePath()     // Catch:{ all -> 0x0234 }
            goto L_0x021b
        L_0x021a:
            r4 = 0
        L_0x021b:
            com.tencent.bugly.proguard.be.a((boolean) r2, (java.lang.String) r4)     // Catch:{ all -> 0x0234 }
            if (r0 != 0) goto L_0x0225
            com.tencent.bugly.proguard.as r0 = r3.b     // Catch:{ all -> 0x0234 }
            r0.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r1, (boolean) r2)     // Catch:{ all -> 0x0234 }
        L_0x0225:
            com.tencent.bugly.proguard.as r0 = r3.b     // Catch:{ all -> 0x0234 }
            r0.a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r1)     // Catch:{ all -> 0x0234 }
            com.tencent.bugly.proguard.at r0 = com.tencent.bugly.proguard.at.a()     // Catch:{ all -> 0x0234 }
            com.tencent.bugly.proguard.av r0 = r0.s     // Catch:{ all -> 0x0234 }
            r0.b()     // Catch:{ all -> 0x0234 }
            return
        L_0x0234:
            r0 = move-exception
            goto L_0x023c
        L_0x0236:
            r0 = move-exception
            r3 = r27
            goto L_0x023c
        L_0x023a:
            r0 = move-exception
            r3 = r14
        L_0x023c:
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)
            if (r1 != 0) goto L_0x0245
            r0.printStackTrace()
        L_0x0245:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    private static Map<String, String> a(String[] strArr) {
        HashMap hashMap = new HashMap(strArr == null ? 1 : strArr.length);
        if (strArr != null) {
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i), str);
                    String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }
}
