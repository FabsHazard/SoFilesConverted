package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.microtech.aidexx.utils.TimeUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ag;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public final class as {
    public static int a;
    private static final Map<Integer, Pair<String, String>> h = new HashMap<Integer, Pair<String, String>>() {
        {
            put(3, new Pair("203", "103"));
            put(7, new Pair("208", "108"));
            put(0, new Pair("200", "100"));
            put(1, new Pair("201", "101"));
            put(2, new Pair("202", "102"));
            put(4, new Pair("204", "104"));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };
    private static final ArrayList<a> i = new ArrayList<a>() {
        {
            add(new b((byte) 0));
            add(new c((byte) 0));
            add(new d((byte) 0));
            add(new e((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
        }
    };
    private static final Map<Integer, Integer> j = new HashMap<Integer, Integer>() {
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };
    private static final Map<Integer, String> k = new HashMap<Integer, String>() {
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };
    private static final Map<Integer, String> l = new HashMap<Integer, String>() {
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };
    protected final Context b;
    protected final ai c;
    protected final w d;
    protected final ac e;
    protected aw f = null;
    protected BuglyStrategy.a g;

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        a = 1004;
        this.b = context;
        this.c = aiVar;
        this.d = wVar;
        this.e = acVar;
        this.g = aVar;
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar next : list) {
            if (next.d && next.b <= currentTimeMillis - TimeUtils.oneDayMillis) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> c2;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (ar next : list) {
            if (next.e) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty() || (c2 = c((List<ar>) arrayList)) == null || c2.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(c2);
            crashDetailBean2 = c2.get(0);
            a(crashDetailBean2, c2);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.r != crashDetailBean.r && !crashDetailBean2.s.contains(new StringBuilder().append(crashDetailBean.r).toString())) {
            crashDetailBean2.t++;
            crashDetailBean2.s += crashDetailBean.r + "\n";
        }
        return crashDetailBean2;
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        for (int i2 = 1; i2 < list.size(); i2++) {
            CrashDetailBean crashDetailBean2 = list.get(i2);
            if (!(crashDetailBean2.s == null || (split = crashDetailBean2.s.split("\n")) == null)) {
                for (String str : split) {
                    if (!crashDetailBean.s.contains(str)) {
                        crashDetailBean.t++;
                        sb.append(str).append("\n");
                    }
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (ar next : list) {
            if (!next.e && !next.d && !crashDetailBean.s.contains(new StringBuilder().append(next.b).toString())) {
                crashDetailBean.t++;
                sb.append(next.b).append("\n");
            }
        }
        crashDetailBean.s += sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d2 A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0 A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f9 A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0101 A[Catch:{ all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0134 A[Catch:{ all -> 0x014b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.bugly.crashreport.crash.CrashDetailBean r19, boolean r20) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.lang.String r3 = "t_cr"
            r4 = 1
            r5 = 0
            if (r2 != 0) goto L_0x0012
            java.lang.String r0 = "CrashBean is null, won't handle."
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.d(r0, r2)
            return r4
        L_0x0012:
            r18.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r19)
            if (r20 == 0) goto L_0x0166
            if (r2 == 0) goto L_0x0166
            com.tencent.bugly.BuglyStrategy$a r0 = r1.g
            if (r0 != 0) goto L_0x0021
            com.tencent.bugly.proguard.aw r0 = r1.f
            if (r0 == 0) goto L_0x0166
        L_0x0021:
            java.util.ArrayList<com.tencent.bugly.proguard.as$a> r0 = i
            java.util.Iterator r0 = r0.iterator()
        L_0x0027:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0043
            java.lang.Object r6 = r0.next()
            com.tencent.bugly.proguard.as$a r6 = (com.tencent.bugly.proguard.as.a) r6
            int r7 = r6.a
            int r8 = r2.b
            if (r7 != r8) goto L_0x003b
            r7 = r4
            goto L_0x003c
        L_0x003b:
            r7 = r5
        L_0x003c:
            if (r7 == 0) goto L_0x0027
            boolean r0 = r6.a()
            goto L_0x0044
        L_0x0043:
            r0 = r5
        L_0x0044:
            if (r0 != 0) goto L_0x004f
            java.lang.String r0 = "Should not call back."
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.c(r0, r6)
            goto L_0x0166
        L_0x004f:
            java.util.Map<java.lang.Integer, java.lang.Integer> r0 = j     // Catch:{ all -> 0x014b }
            int r6 = r2.b     // Catch:{ all -> 0x014b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x014b }
            boolean r6 = r0.containsKey(r6)     // Catch:{ all -> 0x014b }
            if (r6 != 0) goto L_0x0075
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            java.lang.String r6 = "Cannot get crash type for crashBean type:"
            r0.<init>(r6)     // Catch:{ all -> 0x014b }
            int r6 = r2.b     // Catch:{ all -> 0x014b }
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ all -> 0x014b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x014b }
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.d(r0, r6)     // Catch:{ all -> 0x014b }
            goto L_0x0166
        L_0x0075:
            int r6 = r2.b     // Catch:{ all -> 0x014b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x014b }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x014b }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x014b }
            int r0 = r0.intValue()     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.aw r6 = r1.f     // Catch:{ all -> 0x014b }
            r7 = 0
            if (r6 == 0) goto L_0x00ab
            java.lang.String r6 = "Calling 'onCrashHandleStart' of RQD crash listener."
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.c(r6, r8)     // Catch:{ all -> 0x014b }
            java.lang.String r6 = "Calling 'getCrashExtraMessage' of RQD crash listener."
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.c(r6, r8)     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.aw r6 = r1.f     // Catch:{ all -> 0x014b }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x014b }
            if (r6 == 0) goto L_0x00c3
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x014b }
            r8.<init>(r4)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = "userData"
            r8.put(r9, r6)     // Catch:{ all -> 0x014b }
            goto L_0x00c4
        L_0x00ab:
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x014b }
            if (r6 == 0) goto L_0x00c3
            java.lang.String r6 = "Calling 'onCrashHandleStart' of Bugly crash listener."
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.c(r6, r8)     // Catch:{ all -> 0x014b }
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x014b }
            java.lang.String r8 = r2.n     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r2.o     // Catch:{ all -> 0x014b }
            java.lang.String r10 = r2.q     // Catch:{ all -> 0x014b }
            java.util.Map r8 = r6.onCrashHandleStart(r0, r8, r9, r10)     // Catch:{ all -> 0x014b }
            goto L_0x00c4
        L_0x00c3:
            r8 = r7
        L_0x00c4:
            a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r2, (java.util.Map<java.lang.String, java.lang.String>) r8)     // Catch:{ all -> 0x014b }
            java.lang.String r6 = "[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()"
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.a((java.lang.String) r6, (java.lang.Object[]) r8)     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.aw r6 = r1.f     // Catch:{ all -> 0x014b }
            if (r6 == 0) goto L_0x00e0
            java.lang.String r0 = "Calling 'getCrashExtraData' of RQD crash listener."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.c(r0, r6)     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.aw r0 = r1.f     // Catch:{ all -> 0x014b }
            byte[] r7 = r0.a()     // Catch:{ all -> 0x014b }
            goto L_0x00f7
        L_0x00e0:
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x014b }
            if (r6 == 0) goto L_0x00f7
            java.lang.String r6 = "Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener."
            java.lang.Object[] r7 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.c(r6, r7)     // Catch:{ all -> 0x014b }
            com.tencent.bugly.BuglyStrategy$a r6 = r1.g     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r2.n     // Catch:{ all -> 0x014b }
            java.lang.String r8 = r2.o     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r2.q     // Catch:{ all -> 0x014b }
            byte[] r7 = r6.onCrashHandleStart2GetExtraDatas(r0, r7, r8, r9)     // Catch:{ all -> 0x014b }
        L_0x00f7:
            if (r7 != 0) goto L_0x0101
            java.lang.String r0 = "extra user byte is null. CrashBean won't have userExtraByteDatas."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.d(r0, r6)     // Catch:{ all -> 0x014b }
            goto L_0x0130
        L_0x0101:
            int r0 = r7.length     // Catch:{ all -> 0x014b }
            r6 = 100000(0x186a0, float:1.4013E-40)
            if (r0 > r6) goto L_0x010a
            r2.Y = r7     // Catch:{ all -> 0x014b }
            goto L_0x0122
        L_0x010a:
            java.lang.String r0 = "extra bytes size %d is over limit %d will drop over part"
            int r8 = r7.length     // Catch:{ all -> 0x014b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x014b }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x014b }
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r9}     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.d(r0, r8)     // Catch:{ all -> 0x014b }
            byte[] r0 = java.util.Arrays.copyOf(r7, r6)     // Catch:{ all -> 0x014b }
            r2.Y = r0     // Catch:{ all -> 0x014b }
        L_0x0122:
            java.lang.String r0 = "add extra bytes %d "
            int r6 = r7.length     // Catch:{ all -> 0x014b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x014b }
            java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.a((java.lang.String) r0, (java.lang.Object[]) r6)     // Catch:{ all -> 0x014b }
        L_0x0130:
            com.tencent.bugly.proguard.aw r0 = r1.f     // Catch:{ all -> 0x014b }
            if (r0 == 0) goto L_0x0166
            java.lang.String r0 = "Calling 'onCrashSaving' of RQD crash listener."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.c(r0, r6)     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.aw r0 = r1.f     // Catch:{ all -> 0x014b }
            boolean r0 = r0.c()     // Catch:{ all -> 0x014b }
            if (r0 != 0) goto L_0x0166
            java.lang.String r0 = "Crash listener 'onCrashSaving' return 'false' thus will not handle this crash."
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x014b }
            com.tencent.bugly.proguard.al.d(r0, r6)     // Catch:{ all -> 0x014b }
            goto L_0x0166
        L_0x014b:
            r0 = move-exception
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = r6.getName()
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r7 = "crash handle callback something wrong! %s"
            com.tencent.bugly.proguard.al.d(r7, r6)
            boolean r6 = com.tencent.bugly.proguard.al.a(r0)
            if (r6 != 0) goto L_0x0166
            r0.printStackTrace()
        L_0x0166:
            boolean r0 = com.tencent.bugly.proguard.ab.o()
            if (r0 != 0) goto L_0x0176
            int r0 = com.tencent.bugly.proguard.at.f
            java.lang.String r6 = com.tencent.bugly.proguard.at.j
            java.lang.String r0 = com.tencent.bugly.proguard.ap.a((int) r0, (java.lang.String) r6)
            r2.w = r0
        L_0x0176:
            java.lang.String r0 = r2.q
            java.lang.String r6 = com.tencent.bugly.proguard.at.p
            if (r6 == 0) goto L_0x019f
            java.lang.String r6 = com.tencent.bugly.proguard.at.p
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x019f
            java.lang.String r6 = com.tencent.bugly.proguard.at.p
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r7 = "Crash filter for crash stack is: %s"
            com.tencent.bugly.proguard.al.c(r7, r6)
            java.lang.String r6 = com.tencent.bugly.proguard.at.p
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x019f
            java.lang.String r0 = "This crash contains the filter string set. It will not be record and upload."
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.d(r0, r2)
            return r4
        L_0x019f:
            java.lang.String r0 = r2.q
            boolean r0 = a((java.lang.String) r0)
            if (r0 == 0) goto L_0x01a8
            return r4
        L_0x01a8:
            int r0 = r2.b
            r6 = 2
            if (r0 == r6) goto L_0x01d6
            com.tencent.bugly.proguard.y r0 = new com.tencent.bugly.proguard.y
            r0.<init>()
            r0.b = r4
            java.lang.String r6 = r2.A
            r0.c = r6
            java.lang.String r6 = r2.B
            r0.d = r6
            long r6 = r2.r
            r0.e = r6
            com.tencent.bugly.proguard.w r6 = com.tencent.bugly.proguard.w.a()
            r6.b((int) r4)
            com.tencent.bugly.proguard.w r6 = com.tencent.bugly.proguard.w.a()
            r6.a((com.tencent.bugly.proguard.y) r0)
            java.lang.String r0 = "[crash] a crash occur, handling..."
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.b(r0, r6)
            goto L_0x01dd
        L_0x01d6:
            java.lang.String r0 = "[crash] a caught exception occur, handling..."
            java.lang.Object[] r6 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.b(r0, r6)
        L_0x01dd:
            java.util.List r6 = b()
            java.util.ArrayList r7 = new java.util.ArrayList
            r0 = 10
            r7.<init>(r0)
            if (r6 == 0) goto L_0x023d
            int r0 = r6.size()
            if (r0 <= 0) goto L_0x023d
            java.util.List r0 = a((java.util.List<com.tencent.bugly.proguard.ar>) r6)
            r7.addAll(r0)
            r6.removeAll(r7)
            int r0 = r6.size()
            long r8 = (long) r0
            r10 = 20
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0236
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "_id in (SELECT _id FROM t_cr order by _id limit 5)"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r0.setLength(r5)
            com.tencent.bugly.proguard.w r0 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x022c }
            int r0 = r0.a((java.lang.String) r3, (java.lang.String) r8)     // Catch:{ all -> 0x022c }
            java.lang.String r8 = "deleted first record %s data %d"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x022c }
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r0}     // Catch:{ all -> 0x022c }
            com.tencent.bugly.proguard.al.c(r8, r0)     // Catch:{ all -> 0x022c }
            goto L_0x0236
        L_0x022c:
            r0 = move-exception
            boolean r3 = com.tencent.bugly.proguard.al.a(r0)
            if (r3 != 0) goto L_0x0236
            r0.printStackTrace()
        L_0x0236:
            boolean r0 = r1.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r2, (java.util.List<com.tencent.bugly.proguard.ar>) r6, (java.util.List<com.tencent.bugly.proguard.ar>) r7)
            if (r0 == 0) goto L_0x023d
            return r4
        L_0x023d:
            r18.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r19)
            java.util.Map<java.lang.Integer, java.lang.String> r0 = k
            int r3 = r2.b
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r0 = r0.get(r3)
            r10 = r0
            java.lang.String r10 = (java.lang.String) r10
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 != 0) goto L_0x026d
            com.tencent.bugly.proguard.ag r0 = com.tencent.bugly.proguard.ag.a.a
            com.tencent.bugly.proguard.ag$c r3 = new com.tencent.bugly.proguard.ag$c
            java.lang.String r9 = r2.c
            long r11 = r2.r
            java.lang.String r16 = "realtime"
            r17 = 0
            r13 = 1
            r14 = 0
            r8 = r3
            r8.<init>(r9, r10, r11, r13, r14, r16, r17)
            r0.a((com.tencent.bugly.proguard.ag.c) r3)
        L_0x026d:
            d((java.util.List<com.tencent.bugly.proguard.ar>) r7)
            java.lang.String r0 = "[crash] save crash success"
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.tencent.bugly.proguard.al.b(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.a(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    private static boolean a(String str) {
        if (at.q != null && !at.q.isEmpty()) {
            try {
                al.c("Crash regular filter for crash stack is: %s", at.q);
                if (Pattern.compile(at.q).matcher(str).find()) {
                    al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e2) {
                al.a(e2);
                al.d("Failed to compile " + at.q, new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z = false;
        for (ar next : list) {
            if (crashDetailBean.u.equals(next.c)) {
                if (next.e) {
                    z = true;
                }
                list2.add(next);
            }
        }
        return z;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c2 = ac.a().c();
        if (c2 == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c2.f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b2 = ap.b();
            List<ar> b3 = b();
            al.c("Size of crash list loaded from DB: %s", Integer.valueOf(b3.size()));
            if (b3 == null || b3.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(a(b3));
            b3.removeAll(arrayList);
            Iterator<ar> it = b3.iterator();
            while (it.hasNext()) {
                ar next = it.next();
                if (next.b < b2 - at.i) {
                    arrayList2.add(next);
                    it.remove();
                    arrayList.add(next);
                } else if (next.d) {
                    if (next.b >= currentTimeMillis - TimeUtils.oneDayMillis) {
                        it.remove();
                    } else if (!next.e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (((long) next.f) >= 3 && next.b < currentTimeMillis - TimeUtils.oneDayMillis) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            b((List<ar>) arrayList2);
            if (arrayList.size() > 0) {
                d((List<ar>) arrayList);
            }
            ArrayList arrayList3 = new ArrayList();
            List<CrashDetailBean> c3 = c(b3);
            if (c3 != null && c3.size() > 0) {
                String str = aa.b().o;
                Iterator<CrashDetailBean> it2 = c3.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f)) {
                        it2.remove();
                        arrayList3.add(next2);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                e((List<CrashDetailBean>) arrayList3);
            }
            return c3;
        }
    }

    private static void b(List<ar> list) {
        List<CrashDetailBean> c2 = c(list);
        if (c2 != null && !c2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (CrashDetailBean next : c2) {
                String str = l.get(Integer.valueOf(next.b));
                if (!TextUtils.isEmpty(str)) {
                    al.c("find expired data,crashId:%s eventType:%s", next.c, str);
                    arrayList.add(new ag.c(next.c, str, next.r, false, 0, "expired", (String) null));
                }
            }
            ag.a.a.a((List<ag.c>) arrayList);
        }
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z) {
        boolean z2 = false;
        if (at.n) {
            al.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            if (crashDetailBean.b == 7) {
                z2 = true;
            }
            a((List<CrashDetailBean>) arrayList, 3000, z, z2, z);
            return;
        }
        al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public final void a(List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        List<CrashDetailBean> list2 = list;
        if (!aa.a(this.b).f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
        } else if (z3 || aiVar.b(at.a)) {
            StrategyBean c2 = this.e.c();
            if (!c2.f) {
                al.d("remote report is disable!", new Object[0]);
                al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list2 == null || list.size() == 0) {
                al.d("warn: crashList is null or crashList num is 0", new Object[0]);
            } else {
                try {
                    String str = c2.r;
                    String str2 = StrategyBean.b;
                    bp a2 = a(this.b, list2, aa.b());
                    if (a2 == null) {
                        al.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] a3 = ae.a((m) a2);
                    if (a3 == null) {
                        al.d("send encode fail!", new Object[0]);
                        return;
                    }
                    bq a4 = ae.a(this.b, 830, a3);
                    if (a4 == null) {
                        al.d("request package is null.", new Object[0]);
                        return;
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    final List<CrashDetailBean> list3 = list;
                    final boolean z4 = z;
                    AnonymousClass6 r1 = new ah() {
                        public final void a(boolean z, String str) {
                            as.a(list3, z, System.currentTimeMillis() - currentTimeMillis, z4 ? "realtime" : "cache", str);
                            as.a(z, (List<CrashDetailBean>) list3);
                        }
                    };
                    if (z) {
                        this.c.a(a, a4, str, str2, (ah) r1, j2, z2);
                    } else {
                        this.c.a(a, a4, str, str2, r1, false);
                    }
                } catch (Throwable th) {
                    al.e("req cr error %s", th.toString());
                    if (!al.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
        } else {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
        }
    }

    public static void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean next : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", next.c, Integer.valueOf(next.l), Boolean.valueOf(next.d), Boolean.valueOf(next.j));
                next.l++;
                next.d = z;
                al.c("set uid:%s uc:%d re:%b me:%b", next.c, Integer.valueOf(next.l), Boolean.valueOf(next.d), Boolean.valueOf(next.j));
            }
            for (CrashDetailBean a2 : list) {
                at.a().a(a2);
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (!z) {
            al.b("[crash] upload fail.", new Object[0]);
        }
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", ap.a((Parcelable) crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean != null) {
            ContentValues c2 = c(crashDetailBean);
            if (c2 != null) {
                long a2 = w.a().a("t_cr", c2, (v) null);
                if (a2 >= 0) {
                    al.c("insert %s success!", "t_cr");
                    crashDetailBean.a = a2;
                }
            }
            if (at.k) {
                d(crashDetailBean);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e3 A[Catch:{ all -> 0x00ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e8 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> c(java.util.List<com.tencent.bugly.proguard.ar> r10) {
        /*
            java.lang.String r0 = "t_cr"
            r1 = 0
            if (r10 == 0) goto L_0x00f3
            int r2 = r10.size()
            if (r2 != 0) goto L_0x000d
            goto L_0x00f3
        L_0x000d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "_id in ("
            r2.append(r3)
            java.util.Iterator r10 = r10.iterator()
        L_0x001b:
            boolean r4 = r10.hasNext()
            java.lang.String r5 = ","
            if (r4 == 0) goto L_0x0033
            java.lang.Object r4 = r10.next()
            com.tencent.bugly.proguard.ar r4 = (com.tencent.bugly.proguard.ar) r4
            long r6 = r4.a
            java.lang.StringBuilder r4 = r2.append(r6)
            r4.append(r5)
            goto L_0x001b
        L_0x0033:
            java.lang.String r10 = r2.toString()
            boolean r10 = r10.contains(r5)
            r4 = 0
            if (r10 == 0) goto L_0x004c
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            int r6 = r2.lastIndexOf(r5)
            java.lang.String r2 = r2.substring(r4, r6)
            r10.<init>(r2)
            r2 = r10
        L_0x004c:
            java.lang.String r10 = ")"
            r2.append(r10)
            java.lang.String r6 = r2.toString()
            r2.setLength(r4)
            com.tencent.bugly.proguard.w r7 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x00db }
            android.database.Cursor r6 = r7.a((java.lang.String) r0, (java.lang.String[]) r1, (java.lang.String) r6)     // Catch:{ all -> 0x00db }
            if (r6 != 0) goto L_0x0068
            if (r6 == 0) goto L_0x0067
            r6.close()
        L_0x0067:
            return r1
        L_0x0068:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00d9 }
            r7.<init>()     // Catch:{ all -> 0x00d9 }
            r2.append(r3)     // Catch:{ all -> 0x00d9 }
            r3 = r4
        L_0x0071:
            boolean r8 = r6.moveToNext()     // Catch:{ all -> 0x00d9 }
            if (r8 == 0) goto L_0x009d
            com.tencent.bugly.crashreport.crash.CrashDetailBean r8 = a((android.database.Cursor) r6)     // Catch:{ all -> 0x00d9 }
            if (r8 == 0) goto L_0x0081
            r7.add(r8)     // Catch:{ all -> 0x00d9 }
            goto L_0x0071
        L_0x0081:
            java.lang.String r8 = "_id"
            int r8 = r6.getColumnIndex(r8)     // Catch:{ all -> 0x0095 }
            long r8 = r6.getLong(r8)     // Catch:{ all -> 0x0095 }
            java.lang.StringBuilder r8 = r2.append(r8)     // Catch:{ all -> 0x0095 }
            r8.append(r5)     // Catch:{ all -> 0x0095 }
            int r3 = r3 + 1
            goto L_0x0071
        L_0x0095:
            java.lang.String r8 = "unknown id!"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x00d9 }
            com.tencent.bugly.proguard.al.d(r8, r9)     // Catch:{ all -> 0x00d9 }
            goto L_0x0071
        L_0x009d:
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x00d9 }
            boolean r8 = r8.contains(r5)     // Catch:{ all -> 0x00d9 }
            if (r8 == 0) goto L_0x00b5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d9 }
            int r5 = r2.lastIndexOf(r5)     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = r2.substring(r4, r5)     // Catch:{ all -> 0x00d9 }
            r8.<init>(r2)     // Catch:{ all -> 0x00d9 }
            r2 = r8
        L_0x00b5:
            r2.append(r10)     // Catch:{ all -> 0x00d9 }
            java.lang.String r10 = r2.toString()     // Catch:{ all -> 0x00d9 }
            if (r3 <= 0) goto L_0x00d3
            com.tencent.bugly.proguard.w r2 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x00d9 }
            int r10 = r2.a((java.lang.String) r0, (java.lang.String) r10)     // Catch:{ all -> 0x00d9 }
            java.lang.String r2 = "deleted %s illegal data %d"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x00d9 }
            java.lang.Object[] r10 = new java.lang.Object[]{r0, r10}     // Catch:{ all -> 0x00d9 }
            com.tencent.bugly.proguard.al.d(r2, r10)     // Catch:{ all -> 0x00d9 }
        L_0x00d3:
            if (r6 == 0) goto L_0x00d8
            r6.close()
        L_0x00d8:
            return r7
        L_0x00d9:
            r10 = move-exception
            goto L_0x00dd
        L_0x00db:
            r10 = move-exception
            r6 = r1
        L_0x00dd:
            boolean r0 = com.tencent.bugly.proguard.al.a(r10)     // Catch:{ all -> 0x00ec }
            if (r0 != 0) goto L_0x00e6
            r10.printStackTrace()     // Catch:{ all -> 0x00ec }
        L_0x00e6:
            if (r6 == 0) goto L_0x00eb
            r6.close()
        L_0x00eb:
            return r1
        L_0x00ec:
            r10 = move-exception
            if (r6 == 0) goto L_0x00f2
            r6.close()
        L_0x00f2:
            throw r10
        L_0x00f3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.c(java.util.List):java.util.List");
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            boolean z = false;
            arVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            if (cursor.getInt(cursor.getColumnIndex("_me")) == 1) {
                z = true;
            }
            arVar.e = z;
            arVar.f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.List<com.tencent.bugly.proguard.ar>, java.lang.String] */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A[Catch:{ all -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tencent.bugly.proguard.ar> b() {
        /*
            java.lang.String r0 = "_id"
            java.lang.String r1 = "t_cr"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 6
            r4 = 0
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x00c0 }
            r5 = 0
            r3[r5] = r0     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "_tm"
            r7 = 1
            r3[r7] = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "_s1"
            r7 = 2
            r3[r7] = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "_up"
            r7 = 3
            r3[r7] = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "_me"
            r7 = 4
            r3[r7] = r6     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "_uc"
            r7 = 5
            r3[r7] = r6     // Catch:{ all -> 0x00c0 }
            com.tencent.bugly.proguard.w r6 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x00c0 }
            android.database.Cursor r3 = r6.a((java.lang.String) r1, (java.lang.String[]) r3, (java.lang.String) r4)     // Catch:{ all -> 0x00c0 }
            if (r3 != 0) goto L_0x0039
            if (r3 == 0) goto L_0x0038
            r3.close()
        L_0x0038:
            return r4
        L_0x0039:
            int r4 = r3.getCount()     // Catch:{ all -> 0x00bd }
            if (r4 > 0) goto L_0x0045
            if (r3 == 0) goto L_0x0044
            r3.close()
        L_0x0044:
            return r2
        L_0x0045:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r4.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = "_id in ("
            r4.append(r6)     // Catch:{ all -> 0x00bd }
            r6 = r5
        L_0x0050:
            boolean r7 = r3.moveToNext()     // Catch:{ all -> 0x00bd }
            java.lang.String r8 = ","
            if (r7 == 0) goto L_0x007c
            com.tencent.bugly.proguard.ar r7 = b((android.database.Cursor) r3)     // Catch:{ all -> 0x00bd }
            if (r7 == 0) goto L_0x0062
            r2.add(r7)     // Catch:{ all -> 0x00bd }
            goto L_0x0050
        L_0x0062:
            int r7 = r3.getColumnIndex(r0)     // Catch:{ all -> 0x0074 }
            long r9 = r3.getLong(r7)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r7 = r4.append(r9)     // Catch:{ all -> 0x0074 }
            r7.append(r8)     // Catch:{ all -> 0x0074 }
            int r6 = r6 + 1
            goto L_0x0050
        L_0x0074:
            java.lang.String r7 = "unknown id!"
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x00bd }
            com.tencent.bugly.proguard.al.d(r7, r8)     // Catch:{ all -> 0x00bd }
            goto L_0x0050
        L_0x007c:
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00bd }
            boolean r0 = r0.contains(r8)     // Catch:{ all -> 0x00bd }
            if (r0 == 0) goto L_0x0094
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            int r7 = r4.lastIndexOf(r8)     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r4.substring(r5, r7)     // Catch:{ all -> 0x00bd }
            r0.<init>(r4)     // Catch:{ all -> 0x00bd }
            r4 = r0
        L_0x0094:
            java.lang.String r0 = ")"
            r4.append(r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00bd }
            r4.setLength(r5)     // Catch:{ all -> 0x00bd }
            if (r6 <= 0) goto L_0x00b7
            com.tencent.bugly.proguard.w r4 = com.tencent.bugly.proguard.w.a()     // Catch:{ all -> 0x00bd }
            int r0 = r4.a((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = "deleted %s illegal data %d"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x00bd }
            java.lang.Object[] r0 = new java.lang.Object[]{r1, r0}     // Catch:{ all -> 0x00bd }
            com.tencent.bugly.proguard.al.d(r4, r0)     // Catch:{ all -> 0x00bd }
        L_0x00b7:
            if (r3 == 0) goto L_0x00bc
            r3.close()
        L_0x00bc:
            return r2
        L_0x00bd:
            r0 = move-exception
            r4 = r3
            goto L_0x00c1
        L_0x00c0:
            r0 = move-exception
        L_0x00c1:
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x00d0 }
            if (r1 != 0) goto L_0x00ca
            r0.printStackTrace()     // Catch:{ all -> 0x00d0 }
        L_0x00ca:
            if (r4 == 0) goto L_0x00cf
            r4.close()
        L_0x00cf:
            return r2
        L_0x00d0:
            r0 = move-exception
            if (r4 == 0) goto L_0x00d6
            r4.close()
        L_0x00d6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.b():java.util.List");
    }

    private static void d(List<ar> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("_id in (");
            for (ar arVar : list) {
                sb.append(arVar.a).append(",");
            }
            StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
            sb2.append(")");
            String sb3 = sb2.toString();
            sb2.setLength(0);
            try {
                al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() != 0) {
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id = ").append(crashDetailBean.a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                sb.setLength(0);
                al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
            }
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        Context context2 = context;
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        aa aaVar2 = aaVar;
        boolean z = false;
        ArrayList<bl> arrayList = null;
        if (context2 == null || crashDetailBean2 == null || aaVar2 == null) {
            al.d("enExp args == null", new Object[0]);
            return null;
        }
        bo boVar = new bo();
        boVar.a = e(crashDetailBean);
        boVar.b = crashDetailBean2.r;
        boVar.c = crashDetailBean2.n;
        boVar.d = crashDetailBean2.o;
        boVar.e = crashDetailBean2.p;
        boVar.g = crashDetailBean2.q;
        boVar.h = crashDetailBean2.z;
        boVar.i = crashDetailBean2.c;
        boVar.j = null;
        boVar.l = crashDetailBean2.m;
        boVar.m = crashDetailBean2.e;
        boVar.f = crashDetailBean2.B;
        boVar.n = null;
        if (crashDetailBean2.h != null && !crashDetailBean2.h.isEmpty()) {
            arrayList = new ArrayList<>(crashDetailBean2.h.size());
            for (Map.Entry next : crashDetailBean2.h.entrySet()) {
                bl blVar = new bl();
                blVar.a = ((PlugInBean) next.getValue()).a;
                blVar.c = ((PlugInBean) next.getValue()).c;
                blVar.e = ((PlugInBean) next.getValue()).b;
                arrayList.add(blVar);
            }
        }
        boVar.p = arrayList;
        al.c("libInfo %s", boVar.o);
        ArrayList<bn> arrayList2 = new ArrayList<>(20);
        a(arrayList2, crashDetailBean2);
        a(arrayList2, crashDetailBean2.w);
        b(arrayList2, crashDetailBean2.x);
        c(arrayList2, crashDetailBean2.Z);
        a(arrayList2, crashDetailBean2.aa, context2);
        a(arrayList2, crashDetailBean2.y);
        a(arrayList2, crashDetailBean2, context2);
        b(arrayList2, crashDetailBean2, context2);
        a(arrayList2, aaVar2.L);
        b(arrayList2, crashDetailBean2.Y);
        boVar.q = arrayList2;
        if (crashDetailBean2.j) {
            boVar.k = crashDetailBean2.t;
        }
        boVar.r = a(crashDetailBean, aaVar);
        boVar.s = new HashMap();
        if (crashDetailBean2.S != null && crashDetailBean2.S.size() > 0) {
            boVar.s.putAll(crashDetailBean2.S);
            al.a("setted message size %d", Integer.valueOf(boVar.s.size()));
        }
        Map<String, String> map = boVar.s;
        al.c("pss:" + crashDetailBean2.I + " vss:" + crashDetailBean2.J + " javaHeap:" + crashDetailBean2.K, new Object[0]);
        map.put("SDK_UPLOAD_U1", new StringBuilder().append(crashDetailBean2.I).toString());
        map.put("SDK_UPLOAD_U2", new StringBuilder().append(crashDetailBean2.J).toString());
        map.put("SDK_UPLOAD_U3", new StringBuilder().append(crashDetailBean2.K).toString());
        String str = crashDetailBean2.n;
        String str2 = crashDetailBean2.c;
        String d2 = aaVar.d();
        Long valueOf = Long.valueOf((crashDetailBean2.r - crashDetailBean2.Q) / 1000);
        Boolean valueOf2 = Boolean.valueOf(crashDetailBean2.k);
        Boolean valueOf3 = Boolean.valueOf(crashDetailBean2.R);
        Boolean valueOf4 = Boolean.valueOf(crashDetailBean2.j);
        if (crashDetailBean2.b == 1) {
            z = true;
        }
        al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", str, str2, d2, valueOf, valueOf2, valueOf3, valueOf4, Boolean.valueOf(z), Integer.valueOf(crashDetailBean2.t), crashDetailBean2.s, Boolean.valueOf(crashDetailBean2.d), Integer.valueOf(boVar.r.size()));
        return boVar;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context == null || list == null || list.size() == 0 || aaVar == null) {
            al.d("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        bp bpVar = new bp();
        bpVar.a = new ArrayList<>();
        for (CrashDetailBean a2 : list) {
            bpVar.a.add(a(context, a2, aaVar));
        }
        return bpVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d A[Catch:{ all -> 0x00af }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0092 A[SYNTHETIC, Splitter:B:35:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a6 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.bugly.proguard.bn a(java.lang.String r6, android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "del tmp"
            r1 = 0
            r2 = 0
            if (r8 == 0) goto L_0x00cf
            if (r7 != 0) goto L_0x000a
            goto L_0x00cf
        L_0x000a:
            java.lang.String r3 = "zip %s"
            java.lang.Object[] r4 = new java.lang.Object[]{r8}
            com.tencent.bugly.proguard.al.c(r3, r4)
            java.io.File r3 = new java.io.File
            r3.<init>(r8)
            java.io.File r8 = new java.io.File
            java.io.File r7 = r7.getCacheDir()
            r8.<init>(r7, r6)
            boolean r6 = com.tencent.bugly.proguard.ap.a((java.io.File) r3, (java.io.File) r8)
            if (r6 != 0) goto L_0x002f
            java.lang.String r6 = "zip fail!"
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.d(r6, r7)
            return r1
        L_0x002f:
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ all -> 0x0085 }
            r7.<init>(r8)     // Catch:{ all -> 0x0085 }
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0083 }
        L_0x003d:
            int r4 = r7.read(r3)     // Catch:{ all -> 0x0083 }
            if (r4 <= 0) goto L_0x004a
            r6.write(r3, r2, r4)     // Catch:{ all -> 0x0083 }
            r6.flush()     // Catch:{ all -> 0x0083 }
            goto L_0x003d
        L_0x004a:
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0083 }
            java.lang.String r3 = "read bytes :%d"
            int r4 = r6.length     // Catch:{ all -> 0x0083 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0083 }
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch:{ all -> 0x0083 }
            com.tencent.bugly.proguard.al.c(r3, r4)     // Catch:{ all -> 0x0083 }
            com.tencent.bugly.proguard.bn r3 = new com.tencent.bugly.proguard.bn     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = r8.getName()     // Catch:{ all -> 0x0083 }
            r5 = 2
            r3.<init>(r5, r4, r6)     // Catch:{ all -> 0x0083 }
            r7.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x0074
        L_0x006a:
            r6 = move-exception
            boolean r7 = com.tencent.bugly.proguard.al.a(r6)
            if (r7 != 0) goto L_0x0074
            r6.printStackTrace()
        L_0x0074:
            boolean r6 = r8.exists()
            if (r6 == 0) goto L_0x0082
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.c(r0, r6)
            r8.delete()
        L_0x0082:
            return r3
        L_0x0083:
            r6 = move-exception
            goto L_0x0087
        L_0x0085:
            r6 = move-exception
            r7 = r1
        L_0x0087:
            boolean r3 = com.tencent.bugly.proguard.al.a(r6)     // Catch:{ all -> 0x00af }
            if (r3 != 0) goto L_0x0090
            r6.printStackTrace()     // Catch:{ all -> 0x00af }
        L_0x0090:
            if (r7 == 0) goto L_0x00a0
            r7.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x00a0
        L_0x0096:
            r6 = move-exception
            boolean r7 = com.tencent.bugly.proguard.al.a(r6)
            if (r7 != 0) goto L_0x00a0
            r6.printStackTrace()
        L_0x00a0:
            boolean r6 = r8.exists()
            if (r6 == 0) goto L_0x00ae
            java.lang.Object[] r6 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.c(r0, r6)
            r8.delete()
        L_0x00ae:
            return r1
        L_0x00af:
            r6 = move-exception
            if (r7 == 0) goto L_0x00c0
            r7.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c0
        L_0x00b6:
            r7 = move-exception
            boolean r1 = com.tencent.bugly.proguard.al.a(r7)
            if (r1 != 0) goto L_0x00c0
            r7.printStackTrace()
        L_0x00c0:
            boolean r7 = r8.exists()
            if (r7 == 0) goto L_0x00ce
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.c(r0, r7)
            r8.delete()
        L_0x00ce:
            throw r6
        L_0x00cf:
            java.lang.String r6 = "rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}"
            java.lang.Object[] r7 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.d(r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.a(java.lang.String, android.content.Context, java.lang.String):com.tencent.bugly.proguard.bn");
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        String str;
        try {
            al.c("save eup logs", new Object[0]);
            aa b2 = aa.b();
            String str2 = "#--------\npackage:" + b2.e() + "\nversion:" + b2.o + "\nsdk:" + b2.h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.r)) + "\ntype:" + crashDetailBean.n + "\nmessage:" + crashDetailBean.o + "\nstack:\n" + crashDetailBean.q + "\neupID:" + crashDetailBean.c + "\n";
            if (at.l != null) {
                File file = new File(at.l);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.b.getPackageName();
            } else {
                str = null;
            }
            am.a(str + "/euplog.txt", str2, at.m);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa b2 = aa.b();
        if (b2 != null) {
            al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
            al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
            al.e("# PKG NAME: %s", b2.c);
            al.e("# APP VER: %s", b2.o);
            al.e("# SDK VER: %s", b2.h);
            al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().a)));
            al.e("# CRASH TYPE: %s", str);
            al.e("# CRASH TIME: %s", str2);
            al.e("# CRASH PROCESS: %s", str3);
            al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b2.a()));
            al.e("# CRASH THREAD: %s", str4);
            if (crashDetailBean != null) {
                al.e("# REPORT ID: %s", crashDetailBean.c);
                al.e("# CRASH DEVICE: %s %s", b2.h(), b2.r().booleanValue() ? "ROOTED" : "UNROOT");
                al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
                al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
                if (!ap.a(crashDetailBean.O)) {
                    al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
                } else if (crashDetailBean.b == 3) {
                    if (crashDetailBean.T == null) {
                        str6 = "null";
                    } else {
                        str6 = crashDetailBean.T.get("BUGLY_CR_01");
                    }
                    al.e("# EXCEPTION ANR MESSAGE:\n %s", str6);
                }
            }
            if (!ap.a(str5)) {
                al.e("# CRASH STACK: ", new Object[0]);
                al.e(str5, new Object[0]);
            }
            al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
        }
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String str;
        if (map == null || map.isEmpty()) {
            al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
            return;
        }
        crashDetailBean.S = new LinkedHashMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (!ap.a((String) next.getKey())) {
                String str2 = (String) next.getKey();
                if (str2.length() > 100) {
                    str2 = str2.substring(0, 100);
                    al.d("setted key length is over limit %d substring to %s", 100, str2);
                }
                if (ap.a((String) next.getValue()) || ((String) next.getValue()).length() <= 100000) {
                    str = (String) next.getValue();
                } else {
                    str = ((String) next.getValue()).substring(((String) next.getValue()).length() - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                    al.d("setted %s value length is over limit %d substring", str2, Integer.valueOf(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                }
                crashDetailBean.S.put(str2, str);
                al.a("add setted key %s value size:%d", str2, Integer.valueOf(str.length()));
            }
        }
    }

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair pair = h.get(Integer.valueOf(crashDetailBean.b));
            if (pair == null) {
                al.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                return "";
            } else if (crashDetailBean.j) {
                return (String) pair.first;
            } else {
                return (String) pair.second;
            }
        } catch (Exception e2) {
            al.a(e2);
            return "";
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.j && crashDetailBean.s != null && crashDetailBean.s.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (!ap.a(str)) {
            try {
                bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
                al.c("attach crash infos", new Object[0]);
                arrayList.add(bnVar);
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn a2 = a("backupRecord.zip", context, str);
                if (a2 != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
                al.c("attach user log", new Object[0]);
                arrayList.add(bnVar);
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn a2;
        if (crashDetailBean.b == 3) {
            al.c("crashBean.anrMessages:%s", crashDetailBean.T);
            try {
                if (crashDetailBean.T != null && crashDetailBean.T.containsKey("BUGLY_CR_01")) {
                    if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                        arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                        al.c("attach anr message", new Object[0]);
                    }
                    crashDetailBean.T.remove("BUGLY_CR_01");
                }
                if (crashDetailBean.v != null && (a2 = a("trace.zip", context, crashDetailBean.v)) != null) {
                    al.c("attach traces", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        if (crashDetailBean.b == 1 && crashDetailBean.v != null) {
            try {
                bn a2 = a("tomb.zip", context, crashDetailBean.v);
                if (a2 != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(a2);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String append : list) {
                sb.append(append);
            }
            try {
                arrayList.add(new bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                al.c("attach pageTracingList", new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
                al.c("attach extraData", new Object[0]);
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap hashMap = new HashMap(30);
        try {
            hashMap.put("A9", new StringBuilder().append(crashDetailBean.C).toString());
            hashMap.put("A11", new StringBuilder().append(crashDetailBean.D).toString());
            hashMap.put("A10", new StringBuilder().append(crashDetailBean.E).toString());
            hashMap.put("A23", crashDetailBean.f);
            aaVar.getClass();
            hashMap.put("A7", "");
            hashMap.put("A6", aa.n());
            hashMap.put("A5", aaVar.m());
            hashMap.put("A22", aaVar.g());
            hashMap.put("A2", new StringBuilder().append(crashDetailBean.G).toString());
            hashMap.put("A1", new StringBuilder().append(crashDetailBean.F).toString());
            hashMap.put("A24", aaVar.k);
            hashMap.put("A17", new StringBuilder().append(crashDetailBean.H).toString());
            hashMap.put("A25", aaVar.g());
            hashMap.put("A15", aaVar.q());
            hashMap.put("A13", new StringBuilder().append(aaVar.r()).toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                hashMap.put("productIdentify", aaVar.G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.L, "utf-8"));
            if (crashDetailBean.b == 1) {
                hashMap.put("A27", crashDetailBean.O);
                hashMap.put("A28", crashDetailBean.N);
                hashMap.put("A29", new StringBuilder().append(crashDetailBean.k).toString());
            }
            hashMap.put("A30", crashDetailBean.P);
            hashMap.put("A18", new StringBuilder().append(crashDetailBean.Q).toString());
            hashMap.put("A36", new StringBuilder().append(true ^ crashDetailBean.R).toString());
            hashMap.put("F02", new StringBuilder().append(aaVar.z).toString());
            hashMap.put("F03", new StringBuilder().append(aaVar.A).toString());
            hashMap.put("F04", aaVar.d());
            hashMap.put("F05", new StringBuilder().append(aaVar.B).toString());
            hashMap.put("F06", aaVar.y);
            hashMap.put("F08", aaVar.E);
            hashMap.put("F09", aaVar.F);
            hashMap.put("F10", new StringBuilder().append(aaVar.C).toString());
            a((Map<String, String>) hashMap, crashDetailBean);
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            map.put("C01", new StringBuilder().append(crashDetailBean.U).toString());
        }
        if (crashDetailBean.V >= 0) {
            map.put("C02", new StringBuilder().append(crashDetailBean.V).toString());
        }
        if (crashDetailBean.W != null && crashDetailBean.W.size() > 0) {
            for (Map.Entry next : crashDetailBean.W.entrySet()) {
                map.put("C03_" + ((String) next.getKey()), next.getValue());
            }
        }
        if (crashDetailBean.X != null && crashDetailBean.X.size() > 0) {
            for (Map.Entry next2 : crashDetailBean.X.entrySet()) {
                map.put("C04_" + ((String) next2.getKey()), next2.getValue());
            }
        }
    }

    /* compiled from: BUGLY */
    static abstract class a {
        final int a;

        /* access modifiers changed from: package-private */
        public abstract boolean a();

        /* synthetic */ a(int i, byte b) {
            this(i);
        }

        private a(int i) {
            this.a = i;
        }
    }

    /* compiled from: BUGLY */
    static class b extends a {
        /* synthetic */ b(byte b) {
            this();
        }

        private b() {
            super(3, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return at.a().k();
        }
    }

    /* compiled from: BUGLY */
    static class c extends a {
        /* access modifiers changed from: package-private */
        public final boolean a() {
            return true;
        }

        /* synthetic */ c(byte b) {
            this();
        }

        private c() {
            super(7, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    static class d extends a {
        /* access modifiers changed from: package-private */
        public final boolean a() {
            return true;
        }

        /* synthetic */ d(byte b) {
            this();
        }

        private d() {
            super(2, (byte) 0);
        }
    }

    /* compiled from: BUGLY */
    static class e extends a {
        /* synthetic */ e(byte b) {
            this();
        }

        private e() {
            super(0, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return at.a().j();
        }
    }

    /* compiled from: BUGLY */
    static class h extends a {
        /* synthetic */ h(byte b) {
            this();
        }

        private h() {
            super(1, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return at.a().j();
        }
    }

    /* compiled from: BUGLY */
    static class i extends a {
        /* synthetic */ i(byte b) {
            this();
        }

        private i() {
            super(4, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return (at.a().A & 4) > 0;
        }
    }

    /* compiled from: BUGLY */
    static class f extends a {
        /* synthetic */ f(byte b) {
            this();
        }

        private f() {
            super(5, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return (at.a().A & 2) > 0;
        }
    }

    /* compiled from: BUGLY */
    static class g extends a {
        /* synthetic */ g(byte b) {
            this();
        }

        private g() {
            super(6, (byte) 0);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return (at.a().A & 1) > 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        if (r0.size() >= com.tencent.bugly.proguard.at.d) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.tencent.bugly.crashreport.crash.CrashDetailBean r8, java.util.List<com.tencent.bugly.proguard.ar> r9, java.util.List<com.tencent.bugly.proguard.ar> r10) {
        /*
            r7 = this;
            int r0 = r8.b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000b
            if (r0 != r1) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            r3 = r2
            goto L_0x000c
        L_0x000b:
            r3 = r1
        L_0x000c:
            r4 = 3
            if (r0 != r4) goto L_0x0011
            r0 = r1
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            boolean r4 = com.tencent.bugly.proguard.p.c
            if (r4 != 0) goto L_0x001f
            if (r0 != 0) goto L_0x001c
            if (r3 != 0) goto L_0x001c
            r0 = r1
            goto L_0x0020
        L_0x001c:
            boolean r0 = com.tencent.bugly.proguard.at.e
            goto L_0x0020
        L_0x001f:
            r0 = r2
        L_0x0020:
            if (r0 != 0) goto L_0x0023
            return r2
        L_0x0023:
            java.util.ArrayList r0 = new java.util.ArrayList
            r3 = 10
            r0.<init>(r3)
            boolean r9 = a((com.tencent.bugly.crashreport.crash.CrashDetailBean) r8, (java.util.List<com.tencent.bugly.proguard.ar>) r9, (java.util.List<com.tencent.bugly.proguard.ar>) r0)
            if (r9 != 0) goto L_0x0038
            int r9 = r0.size()     // Catch:{ Exception -> 0x006d }
            int r3 = com.tencent.bugly.proguard.at.d     // Catch:{ Exception -> 0x006d }
            if (r9 < r3) goto L_0x0078
        L_0x0038:
            java.lang.String r9 = "same crash occur too much do merged!"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x006d }
            com.tencent.bugly.proguard.al.a((java.lang.String) r9, (java.lang.Object[]) r3)     // Catch:{ Exception -> 0x006d }
            com.tencent.bugly.crashreport.crash.CrashDetailBean r8 = a((java.util.List<com.tencent.bugly.proguard.ar>) r0, (com.tencent.bugly.crashreport.crash.CrashDetailBean) r8)     // Catch:{ Exception -> 0x006d }
            java.util.Iterator r9 = r0.iterator()     // Catch:{ Exception -> 0x006d }
        L_0x0047:
            boolean r0 = r9.hasNext()     // Catch:{ Exception -> 0x006d }
            if (r0 == 0) goto L_0x005f
            java.lang.Object r0 = r9.next()     // Catch:{ Exception -> 0x006d }
            com.tencent.bugly.proguard.ar r0 = (com.tencent.bugly.proguard.ar) r0     // Catch:{ Exception -> 0x006d }
            long r3 = r0.a     // Catch:{ Exception -> 0x006d }
            long r5 = r8.a     // Catch:{ Exception -> 0x006d }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0047
            r10.add(r0)     // Catch:{ Exception -> 0x006d }
            goto L_0x0047
        L_0x005f:
            r7.b((com.tencent.bugly.crashreport.crash.CrashDetailBean) r8)     // Catch:{ Exception -> 0x006d }
            d((java.util.List<com.tencent.bugly.proguard.ar>) r10)     // Catch:{ Exception -> 0x006d }
            java.lang.String r8 = "[crash] save crash success. For this device crash many times, it will not upload crashes immediately"
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x006d }
            com.tencent.bugly.proguard.al.b(r8, r9)     // Catch:{ Exception -> 0x006d }
            return r1
        L_0x006d:
            r8 = move-exception
            com.tencent.bugly.proguard.al.a(r8)
            java.lang.String r8 = "Failed to merge crash."
            java.lang.Object[] r9 = new java.lang.Object[r2]
            com.tencent.bugly.proguard.al.d(r8, r9)
        L_0x0078:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.b(com.tencent.bugly.crashreport.crash.CrashDetailBean, java.util.List, java.util.List):boolean");
    }

    static /* synthetic */ void a(List list, boolean z, long j2, String str, String str2) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
                String str3 = l.get(Integer.valueOf(crashDetailBean.b));
                if (!TextUtils.isEmpty(str3)) {
                    arrayList.add(new ag.c(crashDetailBean.c, str3, crashDetailBean.r, z, j2, str, str2));
                }
            }
            ag.a.a.a((List<ag.c>) arrayList);
        }
    }
}
