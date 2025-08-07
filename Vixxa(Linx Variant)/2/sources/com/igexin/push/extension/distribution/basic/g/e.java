package com.igexin.push.extension.distribution.basic.g;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.extension.distribution.basic.d.a;
import java.io.File;

public class e {
    public static String a(Context context) {
        byte[] b;
        try {
            a.a();
            String b2 = a.b();
            if (TextUtils.isEmpty(b2) && (b = b("/sdcard/libs//" + context.getPackageName() + ".bin")) != null) {
                b2 = new String(h.b(b));
            }
            try {
                Class.forName(b2);
            } catch (Throwable unused) {
                b2 = null;
            }
            return !TextUtils.isEmpty(b2) ? b2 : "com.igexin.sdk.PushService";
        } catch (Throwable unused2) {
            return "com.igexin.sdk.PushService";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e6 A[SYNTHETIC, Splitter:B:53:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00eb A[Catch:{ all -> 0x014e }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f1 A[Catch:{ all -> 0x014e }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0110 A[Catch:{ all -> 0x014e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0140 A[SYNTHETIC, Splitter:B:67:0x0140] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0145 A[Catch:{ all -> 0x014e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.json.JSONObject> a(java.lang.String r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x014e }
            r2.<init>(r10)     // Catch:{ all -> 0x014e }
            boolean r10 = r2.exists()     // Catch:{ all -> 0x014e }
            if (r10 != 0) goto L_0x0012
            return r1
        L_0x0012:
            java.io.File[] r10 = r2.listFiles()     // Catch:{ all -> 0x014e }
            if (r10 == 0) goto L_0x014d
            r2 = 0
            r3 = r2
        L_0x001a:
            int r4 = r10.length     // Catch:{ all -> 0x014e }
            if (r3 >= r4) goto L_0x014d
            r4 = r10[r3]     // Catch:{ all -> 0x014e }
            if (r4 == 0) goto L_0x0149
            boolean r5 = r4.isFile()     // Catch:{ all -> 0x014e }
            if (r5 == 0) goto L_0x0149
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x014e }
            java.lang.String r6 = ".db"
            int r5 = r5.indexOf(r6)     // Catch:{ all -> 0x014e }
            if (r5 <= 0) goto L_0x0149
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x014e }
            java.lang.String r6 = "com.igexin.sdk.deviceId.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x014e }
            if (r5 != 0) goto L_0x0149
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x014e }
            java.lang.String r6 = "com.getui.sdk.deviceId.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x014e }
            if (r5 != 0) goto L_0x0149
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x014e }
            java.lang.String r6 = "app.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x014e }
            if (r5 != 0) goto L_0x0149
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x014e }
            java.lang.String r6 = "imsi.db"
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x014e }
            if (r5 != 0) goto L_0x0149
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x014e }
            java.lang.String r6 = r4.getName()     // Catch:{ all -> 0x014e }
            int r6 = r6.length()     // Catch:{ all -> 0x014e }
            int r6 = r6 + -3
            java.lang.String r5 = r5.substring(r2, r6)     // Catch:{ all -> 0x014e }
            boolean r6 = com.igexin.push.extension.distribution.basic.g.b.a(r5)     // Catch:{ all -> 0x014e }
            if (r6 == 0) goto L_0x0149
            android.content.Context r6 = com.igexin.push.core.d.e     // Catch:{ all -> 0x014e }
            java.lang.String r6 = r6.getPackageName()     // Catch:{ all -> 0x014e }
            boolean r6 = r6.equals(r5)     // Catch:{ all -> 0x014e }
            if (r6 == 0) goto L_0x0089
            goto L_0x0149
        L_0x0089:
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x014e }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00bb, all -> 0x00b6 }
            r7.<init>(r4)     // Catch:{ Exception -> 0x00bb, all -> 0x00b6 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
            r4.<init>()     // Catch:{ Exception -> 0x00b3, all -> 0x00af }
        L_0x0097:
            int r8 = r7.read(r6)     // Catch:{ Exception -> 0x00ad }
            r9 = -1
            if (r8 == r9) goto L_0x00a2
            r4.write(r6, r2, r8)     // Catch:{ Exception -> 0x00ad }
            goto L_0x0097
        L_0x00a2:
            byte[] r6 = r4.toByteArray()     // Catch:{ Exception -> 0x00ad }
            r7.close()     // Catch:{ all -> 0x014e }
            r4.close()     // Catch:{ all -> 0x014e }
            goto L_0x00ef
        L_0x00ad:
            r6 = move-exception
            goto L_0x00be
        L_0x00af:
            r10 = move-exception
            r4 = r1
            goto L_0x013e
        L_0x00b3:
            r6 = move-exception
            r4 = r1
            goto L_0x00be
        L_0x00b6:
            r10 = move-exception
            r4 = r1
            r7 = r4
            goto L_0x013e
        L_0x00bb:
            r6 = move-exception
            r4 = r1
            r7 = r4
        L_0x00be:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x013d }
            r8.<init>()     // Catch:{ all -> 0x013d }
            java.lang.String r9 = "EXT-FileUtils| read "
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x013d }
            java.lang.StringBuilder r8 = r8.append(r5)     // Catch:{ all -> 0x013d }
            java.lang.String r9 = "excetpion:"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ all -> 0x013d }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x013d }
            java.lang.StringBuilder r6 = r8.append(r6)     // Catch:{ all -> 0x013d }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x013d }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x013d }
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r8)     // Catch:{ all -> 0x013d }
            if (r7 == 0) goto L_0x00e9
            r7.close()     // Catch:{ all -> 0x014e }
        L_0x00e9:
            if (r4 == 0) goto L_0x00ee
            r4.close()     // Catch:{ all -> 0x014e }
        L_0x00ee:
            r6 = r1
        L_0x00ef:
            if (r6 != 0) goto L_0x0110
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x014e }
            r4.<init>()     // Catch:{ all -> 0x014e }
            java.lang.String r6 = "EXT-FileUtils|read "
            java.lang.StringBuilder r4 = r4.append(r6)     // Catch:{ all -> 0x014e }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x014e }
            java.lang.String r5 = "bytes == null"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x014e }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x014e }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x014e }
            com.igexin.a.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x014e }
            goto L_0x0149
        L_0x0110:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x014e }
            java.lang.String r5 = com.igexin.push.core.d.C     // Catch:{ all -> 0x014e }
            byte[] r5 = com.igexin.a.a.a.a.a((byte[]) r6, (java.lang.String) r5)     // Catch:{ all -> 0x014e }
            r4.<init>(r5)     // Catch:{ all -> 0x014e }
            java.lang.String r5 = "\\|"
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ all -> 0x014e }
            int r5 = r4.length     // Catch:{ all -> 0x014e }
            r6 = 2
            if (r5 <= r6) goto L_0x0149
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0149 }
            r5.<init>()     // Catch:{ Exception -> 0x0149 }
            java.lang.String r7 = "cid"
            r6 = r4[r6]     // Catch:{ Exception -> 0x0149 }
            r5.put(r7, r6)     // Catch:{ Exception -> 0x0149 }
            java.lang.String r6 = "appid"
            r7 = 1
            r4 = r4[r7]     // Catch:{ Exception -> 0x0149 }
            r5.put(r6, r4)     // Catch:{ Exception -> 0x0149 }
            r0.add(r5)     // Catch:{ Exception -> 0x0149 }
            goto L_0x0149
        L_0x013d:
            r10 = move-exception
        L_0x013e:
            if (r7 == 0) goto L_0x0143
            r7.close()     // Catch:{ all -> 0x014e }
        L_0x0143:
            if (r4 == 0) goto L_0x0148
            r4.close()     // Catch:{ all -> 0x014e }
        L_0x0148:
            throw r10     // Catch:{ all -> 0x014e }
        L_0x0149:
            int r3 = r3 + 1
            goto L_0x001a
        L_0x014d:
            return r0
        L_0x014e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.g.e.a(java.lang.String):java.util.List");
    }

    public static boolean a() {
        try {
            File file = new File("/sdcard/libs//test.log");
            if (!file.exists()) {
                file.createNewFile();
            }
            file.delete();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:4|5|6|(6:7|8|(3:9|10|(1:12)(1:47))|13|14|15)|16|17|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        if (r6 == null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0048 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A[SYNTHETIC, Splitter:B:30:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0083 A[SYNTHETIC, Splitter:B:39:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0088 A[SYNTHETIC, Splitter:B:43:0x0088] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0028
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "EXT-FileUtils|get data from file = "
            r0.<init>(r3)
            java.lang.StringBuilder r6 = r0.append(r6)
            java.lang.String r0 = " file not exist ######"
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r0)
            return r2
        L_0x0028:
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r6.<init>()     // Catch:{ Exception -> 0x0051, all -> 0x004e }
        L_0x0036:
            int r4 = r3.read(r0)     // Catch:{ Exception -> 0x004c }
            r5 = -1
            if (r4 == r5) goto L_0x0041
            r6.write(r0, r1, r4)     // Catch:{ Exception -> 0x004c }
            goto L_0x0036
        L_0x0041:
            byte[] r2 = r6.toByteArray()     // Catch:{ Exception -> 0x004c }
            r3.close()     // Catch:{ Exception -> 0x0048 }
        L_0x0048:
            r6.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x007e
        L_0x004c:
            r0 = move-exception
            goto L_0x005a
        L_0x004e:
            r0 = move-exception
            r6 = r2
            goto L_0x0080
        L_0x0051:
            r0 = move-exception
            r6 = r2
            goto L_0x005a
        L_0x0054:
            r0 = move-exception
            r6 = r2
            goto L_0x0081
        L_0x0057:
            r0 = move-exception
            r6 = r2
            r3 = r6
        L_0x005a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007f }
            r4.<init>()     // Catch:{ all -> 0x007f }
            java.lang.String r5 = "EXT-FileUtils|"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x007f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007f }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x007f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x007f }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x007f }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x007f }
            if (r3 == 0) goto L_0x007b
            r3.close()     // Catch:{ Exception -> 0x007b }
        L_0x007b:
            if (r6 == 0) goto L_0x007e
            goto L_0x0048
        L_0x007e:
            return r2
        L_0x007f:
            r0 = move-exception
        L_0x0080:
            r2 = r3
        L_0x0081:
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            if (r6 == 0) goto L_0x008b
            r6.close()     // Catch:{ Exception -> 0x008b }
        L_0x008b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.g.e.b(java.lang.String):byte[]");
    }
}
