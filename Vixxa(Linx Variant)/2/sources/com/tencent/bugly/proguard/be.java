package com.tencent.bugly.proguard;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class be {
    private static List<File> a = new ArrayList();

    private static Map<String, Integer> d(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(",")) {
                String[] split = str2.split(":");
                if (split.length != 2) {
                    al.e("error format at %s", str2);
                    return null;
                }
                hashMap.put(split[0], Integer.valueOf(Integer.parseInt(split[1])));
            }
            return hashMap;
        } catch (Exception e) {
            al.e("error format intStateStr %s", str);
            e.printStackTrace();
            return null;
        }
    }

    protected static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split("\n");
        if (split == null || split.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2).append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f9 A[Catch:{ all -> 0x0247 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0102 A[Catch:{ all -> 0x0247 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0116 A[Catch:{ all -> 0x0247 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0142 A[Catch:{ all -> 0x0247 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x016e A[Catch:{ all -> 0x0247 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01e4 A[Catch:{ all -> 0x0247 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.content.Context r24, java.util.Map<java.lang.String, java.lang.String> r25, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r26) {
        /*
            r0 = r25
            java.lang.String r1 = "unknown"
            com.tencent.bugly.proguard.aa r2 = com.tencent.bugly.proguard.aa.a((android.content.Context) r24)
            r3 = 0
            r4 = 0
            if (r2 != 0) goto L_0x0015
            java.lang.String r0 = "abnormal com info not created"
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.e(r0, r1)
            goto L_0x025a
        L_0x0015:
            java.lang.String r2 = "intStateStr"
            java.lang.Object r5 = r0.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0253
            java.lang.String r5 = r5.trim()
            int r5 = r5.length()
            if (r5 > 0) goto L_0x002b
            goto L_0x0253
        L_0x002b:
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map r2 = d(r2)
            if (r2 != 0) goto L_0x0049
            int r0 = r25.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "parse intSateMap fail"
            com.tencent.bugly.proguard.al.e(r1, r0)
            return r4
        L_0x0049:
            java.lang.String r5 = "sino"
            java.lang.Object r5 = r2.get(r5)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x0247 }
            r5.intValue()     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = "sud"
            java.lang.Object r5 = r2.get(r5)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x0247 }
            r5.intValue()     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = "soVersion"
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x0247 }
            r19 = r5
            java.lang.String r19 = (java.lang.String) r19     // Catch:{ all -> 0x0247 }
            boolean r5 = android.text.TextUtils.isEmpty(r19)     // Catch:{ all -> 0x0247 }
            if (r5 == 0) goto L_0x0077
            java.lang.String r0 = "error format at version"
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ all -> 0x0247 }
            com.tencent.bugly.proguard.al.e(r0, r1)     // Catch:{ all -> 0x0247 }
            return r4
        L_0x0077:
            java.lang.String r5 = "codeMsg"
            java.lang.Object r5 = a(r0, r5, r1)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = "signalName"
            java.lang.Object r6 = a(r0, r6, r1)     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0247 }
            java.lang.String r7 = "errnoMsg"
            r0.get(r7)     // Catch:{ all -> 0x0247 }
            java.lang.String r7 = "stack"
            java.lang.Object r7 = a(r0, r7, r1)     // Catch:{ all -> 0x0247 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0247 }
            java.lang.String r8 = "jstack"
            java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x0247 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0247 }
            if (r8 == 0) goto L_0x00b5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            r9.<init>()     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r7 = r9.append(r7)     // Catch:{ all -> 0x0247 }
            java.lang.String r9 = "java:\n"
            java.lang.StringBuilder r7 = r7.append(r9)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x0247 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0247 }
        L_0x00b5:
            java.lang.String r8 = "sico"
            java.lang.Object r8 = r2.get(r8)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0247 }
            java.lang.String r9 = ")"
            java.lang.String r10 = "("
            if (r8 == 0) goto L_0x00e7
            int r8 = r8.intValue()     // Catch:{ all -> 0x0247 }
            if (r8 <= 0) goto L_0x00e7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            r8.<init>()     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r6 = r8.append(r6)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r6 = r6.append(r10)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = "KERNEL"
            r11 = r5
            r14 = r6
            goto L_0x00e9
        L_0x00e7:
            r14 = r5
            r11 = r6
        L_0x00e9:
            java.lang.String r5 = "nativeLog"
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0247 }
            if (r5 == 0) goto L_0x0102
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x0247 }
            if (r6 != 0) goto L_0x0102
            java.lang.String r6 = "BuglyNativeLog.txt"
            byte[] r5 = com.tencent.bugly.proguard.ap.a((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0247 }
            r20 = r5
            goto L_0x0104
        L_0x0102:
            r20 = r4
        L_0x0104:
            java.lang.String r5 = "sendingProcess"
            java.lang.Object r5 = a(r0, r5, r1)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = "spd"
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0247 }
            if (r6 == 0) goto L_0x012f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            r8.<init>()     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r8.append(r5)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0247 }
        L_0x012f:
            r15 = r5
            java.lang.String r5 = "threadName"
            java.lang.Object r5 = a(r0, r5, r1)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = "et"
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0247 }
            if (r6 == 0) goto L_0x015b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            r8.<init>()     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r8.append(r5)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0247 }
        L_0x015b:
            r8 = r5
            java.lang.String r5 = "processName"
            java.lang.Object r5 = a(r0, r5, r1)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = "ep"
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0247 }
            if (r6 == 0) goto L_0x0187
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0247 }
            r12.<init>()     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r12.append(r5)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r10)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0247 }
            java.lang.StringBuilder r5 = r5.append(r9)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0247 }
        L_0x0187:
            java.util.Map r21 = a((java.util.Map<java.lang.String, java.lang.String>) r25)     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = "ets"
            java.lang.Object r6 = r2.get(r6)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0247 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0247 }
            long r9 = (long) r6     // Catch:{ all -> 0x0247 }
            java.lang.String r6 = "etms"
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0247 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0247 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0247 }
            long r12 = (long) r2     // Catch:{ all -> 0x0247 }
            r16 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 * r16
            long r12 = r12 / r16
            long r9 = r9 + r12
            java.lang.String r2 = "errorAddr"
            java.lang.Object r2 = a(r0, r2, r1)     // Catch:{ all -> 0x0247 }
            r12 = r2
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0247 }
            java.lang.String r13 = a((java.lang.String) r7)     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "sysLogPath"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0247 }
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "jniLogPath"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0247 }
            r18 = r2
            java.lang.String r18 = (java.lang.String) r18     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "tombPath"
            java.lang.Object r1 = a(r0, r2, r1)     // Catch:{ all -> 0x0247 }
            r16 = r1
            java.lang.String r16 = (java.lang.String) r16     // Catch:{ all -> 0x0247 }
            r22 = 0
            r23 = 0
            r6 = r26
            r7 = r5
            com.tencent.bugly.crashreport.crash.CrashDetailBean r1 = r6.packageCrashDatas(r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0247 }
            if (r1 == 0) goto L_0x0246
            java.lang.String r2 = "userId"
            java.lang.String r5 = r1.m     // Catch:{ all -> 0x0247 }
            java.lang.Object r2 = a(r0, r2, r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0247 }
            r1.m = r2     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "[Native record info] userId: %s"
            java.lang.String r5 = r1.m     // Catch:{ all -> 0x0247 }
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0247 }
            com.tencent.bugly.proguard.al.c(r2, r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "sysLog"
            java.lang.String r5 = r1.w     // Catch:{ all -> 0x0247 }
            java.lang.Object r2 = a(r0, r2, r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0247 }
            r1.w = r2     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "appVersion"
            java.lang.String r5 = r1.w     // Catch:{ all -> 0x0247 }
            java.lang.Object r2 = a(r0, r2, r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0247 }
            r1.f = r2     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "[Native record info] appVersion: %s"
            java.lang.String r5 = r1.f     // Catch:{ all -> 0x0247 }
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x0247 }
            com.tencent.bugly.proguard.al.c(r2, r5)     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = "isAppForeground"
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0247 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0247 }
            if (r2 == 0) goto L_0x0238
            java.lang.String r5 = "[Native record info] isAppForeground: %s"
            java.lang.Object[] r6 = new java.lang.Object[]{r2}     // Catch:{ all -> 0x0247 }
            com.tencent.bugly.proguard.al.c(r5, r6)     // Catch:{ all -> 0x0247 }
            java.lang.String r5 = "true"
            boolean r2 = r2.equalsIgnoreCase(r5)     // Catch:{ all -> 0x0247 }
            goto L_0x0239
        L_0x0238:
            r2 = r3
        L_0x0239:
            r1.R = r2     // Catch:{ all -> 0x0247 }
            long r5 = b((java.util.Map<java.lang.String, java.lang.String>) r25)     // Catch:{ all -> 0x0247 }
            r1.Q = r5     // Catch:{ all -> 0x0247 }
            r1.z = r4     // Catch:{ all -> 0x0247 }
            r0 = 1
            r1.k = r0     // Catch:{ all -> 0x0247 }
        L_0x0246:
            return r1
        L_0x0247:
            r0 = move-exception
            java.lang.String r1 = "error format"
            java.lang.Object[] r2 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.e(r1, r2)
            r0.printStackTrace()
            return r4
        L_0x0253:
            java.lang.String r0 = "no intStateStr"
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.e(r0, r1)
        L_0x025a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.be.a(android.content.Context, java.util.Map, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static <KeyT, ValueT> ValueT a(Map<KeyT, ValueT> map, KeyT keyt, ValueT valuet) {
        try {
            ValueT valuet2 = map.get(keyt);
            if (valuet2 != null) {
                return valuet2;
            }
            return valuet;
        } catch (Exception e) {
            al.a(e);
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int read = bufferedInputStream.read();
                    if (read == -1) {
                        break;
                    } else if (read == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    } else {
                        byteArrayOutputStream.write(read);
                    }
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            try {
                al.a(th);
            } finally {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0089 A[SYNTHETIC, Splitter:B:52:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0096 A[SYNTHETIC, Splitter:B:60:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.bugly.crashreport.crash.CrashDetailBean a(android.content.Context r4, java.lang.String r5, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler r6) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x00a0
            if (r5 == 0) goto L_0x00a0
            if (r6 != 0) goto L_0x0009
            goto L_0x00a0
        L_0x0009:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "rqd_record.eup"
            r1.<init>(r5, r2)
            boolean r5 = r1.exists()
            if (r5 == 0) goto L_0x009f
            boolean r5 = r1.canRead()
            if (r5 != 0) goto L_0x001e
            goto L_0x009f
        L_0x001e:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0082, all -> 0x0080 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0082, all -> 0x0080 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0082, all -> 0x0080 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x0082, all -> 0x0080 }
            java.lang.String r1 = a((java.io.BufferedInputStream) r5)     // Catch:{ IOException -> 0x007e }
            if (r1 == 0) goto L_0x006c
            java.lang.String r2 = "NATIVE_RQD_REPORT"
            boolean r2 = r1.equals(r2)     // Catch:{ IOException -> 0x007e }
            if (r2 != 0) goto L_0x0037
            goto L_0x006c
        L_0x0037:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x007e }
            r1.<init>()     // Catch:{ IOException -> 0x007e }
        L_0x003c:
            r2 = r0
        L_0x003d:
            java.lang.String r3 = a((java.io.BufferedInputStream) r5)     // Catch:{ IOException -> 0x007e }
            if (r3 == 0) goto L_0x004b
            if (r2 != 0) goto L_0x0047
            r2 = r3
            goto L_0x003d
        L_0x0047:
            r1.put(r2, r3)     // Catch:{ IOException -> 0x007e }
            goto L_0x003c
        L_0x004b:
            if (r2 == 0) goto L_0x005f
            java.lang.String r4 = "record not pair! drop! %s"
            java.lang.Object[] r6 = new java.lang.Object[]{r2}     // Catch:{ IOException -> 0x007e }
            com.tencent.bugly.proguard.al.e(r4, r6)     // Catch:{ IOException -> 0x007e }
            r5.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005e:
            return r0
        L_0x005f:
            com.tencent.bugly.crashreport.crash.CrashDetailBean r4 = a((android.content.Context) r4, (java.util.Map<java.lang.String, java.lang.String>) r1, (com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler) r6)     // Catch:{ IOException -> 0x007e }
            r5.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r5 = move-exception
            r5.printStackTrace()
        L_0x006b:
            return r4
        L_0x006c:
            java.lang.String r4 = "record read fail! %s"
            java.lang.Object[] r6 = new java.lang.Object[]{r1}     // Catch:{ IOException -> 0x007e }
            com.tencent.bugly.proguard.al.e(r4, r6)     // Catch:{ IOException -> 0x007e }
            r5.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r4 = move-exception
            r4.printStackTrace()
        L_0x007d:
            return r0
        L_0x007e:
            r4 = move-exception
            goto L_0x0084
        L_0x0080:
            r4 = move-exception
            goto L_0x0094
        L_0x0082:
            r4 = move-exception
            r5 = r0
        L_0x0084:
            r4.printStackTrace()     // Catch:{ all -> 0x0092 }
            if (r5 == 0) goto L_0x0091
            r5.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0091:
            return r0
        L_0x0092:
            r4 = move-exception
            r0 = r5
        L_0x0094:
            if (r0 == 0) goto L_0x009e
            r0.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x009e:
            throw r4
        L_0x009f:
            return r0
        L_0x00a0:
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "get eup record file args error"
            com.tencent.bugly.proguard.al.e(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.be.a(android.content.Context, java.lang.String, com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static String b(String str, String str2) {
        BufferedReader b = ap.b(str, "reg_record.txt");
        if (b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    int i = 18;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        String readLine2 = b.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        if (i2 % 4 == 0) {
                            if (i2 > 0) {
                                sb.append("\n");
                            }
                            sb.append("  ");
                        } else {
                            if (readLine2.length() > 16) {
                                i = 28;
                            }
                            sb.append("                ".substring(0, i - i3));
                        }
                        i3 = readLine2.length();
                        sb.append(readLine2);
                        i2++;
                    }
                    sb.append("\n");
                    String sb2 = sb.toString();
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Exception e) {
                            al.a(e);
                        }
                    }
                    return sb2;
                }
            }
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e2) {
                    al.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e3) {
                    al.a(e3);
                }
            }
            throw th;
        }
    }

    private static String c(String str, String str2) {
        BufferedReader b = ap.b(str, "map_record.txt");
        if (b == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String readLine = b.readLine();
            if (readLine != null) {
                if (readLine.startsWith(str2)) {
                    while (true) {
                        String readLine2 = b.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb.append("  ");
                        sb.append(readLine2);
                        sb.append("\n");
                    }
                    String sb2 = sb.toString();
                    if (b != null) {
                        try {
                            b.close();
                        } catch (Exception e) {
                            al.a(e);
                        }
                    }
                    return sb2;
                }
            }
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e2) {
                    al.a(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            if (b != null) {
                try {
                    b.close();
                } catch (Exception e3) {
                    al.a(e3);
                }
            }
            throw th;
        }
    }

    public static String a(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String b = b(str, str2);
        if (b != null && !b.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(b);
        }
        String c = c(str, str2);
        if (c != null && !c.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(c);
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static void c(String str) {
        File[] listFiles;
        if (str != null) {
            try {
                File file = new File(str);
                if (file.canRead() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                            file2.delete();
                            al.c("Delete empty record file %s", file2.getAbsoluteFile());
                        }
                    }
                }
            } catch (Throwable th) {
                al.a(th);
            }
        }
    }

    public static void a(boolean z, String str) {
        if (str != null) {
            a.add(new File(str, "rqd_record.eup"));
            a.add(new File(str, "reg_record.txt"));
            a.add(new File(str, "map_record.txt"));
            a.add(new File(str, "backup_record.txt"));
            if (z) {
                c(str);
            }
        }
        List<File> list = a;
        if (list != null && list.size() > 0) {
            for (File next : a) {
                if (next.exists() && next.canWrite()) {
                    next.delete();
                    al.c("Delete record file %s", next.getAbsoluteFile());
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1 A[SYNTHETIC, Splitter:B:36:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r6, int r7, java.lang.String r8, boolean r9) {
        /*
            r0 = 0
            if (r6 == 0) goto L_0x00f1
            if (r7 > 0) goto L_0x0007
            goto L_0x00f1
        L_0x0007:
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            boolean r2 = r1.exists()
            if (r2 == 0) goto L_0x00f1
            boolean r2 = r1.canRead()
            if (r2 != 0) goto L_0x001a
            goto L_0x00f1
        L_0x001a:
            long r2 = r1.length()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = r1.getAbsolutePath()
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}
            java.lang.String r3 = "Read system log from native record file(length: %s bytes): %s"
            com.tencent.bugly.proguard.al.a((java.lang.String) r3, (java.lang.Object[]) r2)
            java.util.List<java.io.File> r2 = a
            r2.add(r1)
            java.lang.String r2 = "Add this record file to list for cleaning lastly."
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r2, r4)
            if (r8 != 0) goto L_0x0049
            java.io.File r8 = new java.io.File
            r8.<init>(r6)
            java.lang.String r6 = com.tencent.bugly.proguard.ap.a((java.io.File) r8, (int) r7, (boolean) r9)
            goto L_0x00e4
        L_0x0049:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x00ba }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x00ba }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x00ba }
            r5.<init>(r1)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "utf-8"
            r4.<init>(r5, r1)     // Catch:{ all -> 0x00ba }
            r2.<init>(r4)     // Catch:{ all -> 0x00ba }
        L_0x005f:
            java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00aa
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            r1.<init>()     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = "[ ]*:"
            java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b7 }
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)     // Catch:{ all -> 0x00b7 }
            java.util.regex.Matcher r1 = r1.matcher(r0)     // Catch:{ all -> 0x00b7 }
            boolean r1 = r1.find()     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x008f
            java.lang.StringBuilder r0 = r6.append(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = "\n"
            r0.append(r1)     // Catch:{ all -> 0x00b7 }
        L_0x008f:
            if (r7 <= 0) goto L_0x005f
            int r0 = r6.length()     // Catch:{ all -> 0x00b7 }
            if (r0 <= r7) goto L_0x005f
            if (r9 == 0) goto L_0x00a1
            int r8 = r6.length()     // Catch:{ all -> 0x00b7 }
            r6.delete(r7, r8)     // Catch:{ all -> 0x00b7 }
            goto L_0x00aa
        L_0x00a1:
            int r0 = r6.length()     // Catch:{ all -> 0x00b7 }
            int r0 = r0 - r7
            r6.delete(r3, r0)     // Catch:{ all -> 0x00b7 }
            goto L_0x005f
        L_0x00aa:
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00b7 }
            r2.close()     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00e4
        L_0x00b2:
            r7 = move-exception
            com.tencent.bugly.proguard.al.a(r7)
            goto L_0x00e4
        L_0x00b7:
            r7 = move-exception
            r0 = r2
            goto L_0x00bb
        L_0x00ba:
            r7 = move-exception
        L_0x00bb:
            com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            java.lang.String r9 = "\n[error:"
            r8.<init>(r9)     // Catch:{ all -> 0x00e5 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ all -> 0x00e5 }
            java.lang.String r8 = "]"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00e5 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00e5 }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00e5 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00e5 }
            if (r0 == 0) goto L_0x00e4
            r0.close()     // Catch:{ Exception -> 0x00b2 }
        L_0x00e4:
            return r6
        L_0x00e5:
            r6 = move-exception
            if (r0 == 0) goto L_0x00f0
            r0.close()     // Catch:{ Exception -> 0x00ec }
            goto L_0x00f0
        L_0x00ec:
            r7 = move-exception
            com.tencent.bugly.proguard.al.a(r7)
        L_0x00f0:
            throw r6
        L_0x00f1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.be.a(java.lang.String, int, java.lang.String, boolean):java.lang.String");
    }

    private static Map<String, String> a(Map<String, String> map) {
        String str = map.get("key-value");
        if (str == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String split : str.split("\n")) {
            String[] split2 = split.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                hashMap.put(split2[0], split2[1]);
            }
        }
        return hashMap;
    }

    private static long b(Map<String, String> map) {
        String str = map.get("launchTime");
        if (str == null) {
            return -1;
        }
        al.c("[Native record info] launchTime: %s", str);
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            if (al.a(e)) {
                return -1;
            }
            e.printStackTrace();
            return -1;
        }
    }
}
