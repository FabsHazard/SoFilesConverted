package com.igexin.push.config;

import android.content.Context;
import com.igexin.a.a.c.b;
import com.igexin.push.util.d;

public class m {
    private static String a = "FileConfig";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.igexin.push.core.d.c
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ".properties"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.content.Context r2 = com.igexin.push.core.d.e
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.AssetManager r2 = r2.getAssets()
            r3 = 0
            java.io.InputStream r0 = r2.open(r0)     // Catch:{ Exception -> 0x0030, all -> 0x002b }
            a((java.io.InputStream) r0)     // Catch:{ Exception -> 0x0031, all -> 0x0028 }
            goto L_0x0031
        L_0x0028:
            r1 = move-exception
            r3 = r0
            goto L_0x002c
        L_0x002b:
            r1 = move-exception
        L_0x002c:
            com.igexin.push.util.m.a(r3)
            throw r1
        L_0x0030:
            r0 = r3
        L_0x0031:
            com.igexin.push.util.m.a(r0)
            java.io.File r2 = new java.io.File
            java.lang.String r4 = com.igexin.push.core.d.S
            r2.<init>(r4)
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x006e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.content.Context r4 = com.igexin.push.core.d.e
            java.lang.String r4 = com.igexin.push.util.d.d(r4)
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = com.igexin.push.core.d.c
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            com.igexin.push.core.d.S = r1
            java.io.File r1 = new java.io.File
            java.lang.String r2 = com.igexin.push.core.d.S
            r1.<init>(r2)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x006e
            return
        L_0x006e:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00d5, all -> 0x00cd }
            java.lang.String r2 = com.igexin.push.core.d.S     // Catch:{ Exception -> 0x00d5, all -> 0x00cd }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00d5, all -> 0x00cd }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
            java.lang.String r4 = "UTF-8"
            r2.<init>(r1, r4)     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00cb, all -> 0x00c8 }
        L_0x0081:
            java.lang.String r2 = r0.readLine()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            if (r2 == 0) goto L_0x00bc
            java.lang.String r3 = "#"
            boolean r3 = r2.startsWith(r3)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            if (r3 == 0) goto L_0x0090
            goto L_0x0081
        L_0x0090:
            java.lang.String r3 = "="
            java.lang.String[] r2 = r2.split(r3)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            int r3 = r2.length     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            r4 = 2
            if (r3 >= r4) goto L_0x009b
            goto L_0x0081
        L_0x009b:
            r3 = 0
            r3 = r2[r3]     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            r4 = 1
            r2 = r2[r4]     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            java.lang.String r4 = "sdk.debug"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            if (r3 == 0) goto L_0x0081
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            com.igexin.a.a.c.b.a = r2     // Catch:{ Exception -> 0x00c6, all -> 0x00c3 }
            goto L_0x0081
        L_0x00bc:
            com.igexin.push.util.m.a(r0)
            com.igexin.push.util.m.a(r1)
            goto L_0x00db
        L_0x00c3:
            r2 = move-exception
            r3 = r0
            goto L_0x00c9
        L_0x00c6:
            r3 = r0
            goto L_0x00cb
        L_0x00c8:
            r2 = move-exception
        L_0x00c9:
            r0 = r1
            goto L_0x00ce
        L_0x00cb:
            r0 = r1
            goto L_0x00d5
        L_0x00cd:
            r2 = move-exception
        L_0x00ce:
            com.igexin.push.util.m.a(r3)
            com.igexin.push.util.m.a(r0)
            throw r2
        L_0x00d5:
            com.igexin.push.util.m.a(r3)
            com.igexin.push.util.m.a(r0)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.m.a():void");
    }

    public static void a(Context context) {
        try {
            byte[] a2 = d.a(context.getFilesDir().getPath() + "/conf_n.pid");
            if (a2 != null) {
                l.k = Boolean.parseBoolean(new String(a2));
            }
        } catch (Throwable th) {
            b.a(a + "|load need confgi error = " + th.toString(), new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0114 A[SYNTHETIC, Splitter:B:61:0x0114] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011f A[SYNTHETIC, Splitter:B:68:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.io.InputStream r7) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x011d, all -> 0x0111 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x011d, all -> 0x0111 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r7, r3)     // Catch:{ Exception -> 0x011d, all -> 0x0111 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x011d, all -> 0x0111 }
        L_0x000d:
            java.lang.String r7 = r1.readLine()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r7 == 0) goto L_0x0108
            java.lang.String r0 = "#"
            boolean r0 = r7.startsWith(r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r0 == 0) goto L_0x001c
            goto L_0x000d
        L_0x001c:
            java.lang.String r0 = "="
            java.lang.String[] r7 = r7.split(r0)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            int r0 = r7.length     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r2 = 2
            if (r0 >= r2) goto L_0x0027
            goto L_0x000d
        L_0x0027:
            r0 = 0
            r0 = r7[r0]     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r2 = 1
            r7 = r7[r2]     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r7 = r7.trim()     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r2 = "sdk.cm_address"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            java.lang.String r3 = ","
            if (r2 == 0) goto L_0x0047
            java.lang.String[] r7 = r7.split(r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x0047:
            java.lang.String r2 = "sdk.config_address"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x0056
            java.lang.String[] r7 = r7.split(r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x0056:
            java.lang.String r2 = "sdk.bi_address"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x0065
            java.lang.String[] r7 = r7.split(r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x0065:
            java.lang.String r2 = "sdk.state_address"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x0074
            java.lang.String[] r7 = r7.split(r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.SDKUrlConfig.STATE_ADDRESS_IPS = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x0074:
            java.lang.String r2 = "sdk.cm_address_backup"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x0083
            java.lang.String[] r7 = r7.split(r3)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x0083:
            java.lang.String r2 = "sdk.debug"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x0093
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.a.a.c.b.a = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x0093:
            java.lang.String r2 = "sdk.domainbackup.enable"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x00a3
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.l.f = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x00a3:
            java.lang.String r2 = "sdk.feature.sendmessage.enable"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x00b3
            boolean r7 = java.lang.Boolean.parseBoolean(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.l.g = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x00b3:
            java.lang.String r2 = "sdk.stay.backup.time"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            r3 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x00c6
            long r5 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            long r5 = r5 * r3
            com.igexin.push.config.l.n = r5     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x00c6:
            java.lang.String r2 = "sdk.enter.backup.detect.failed.cnt"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x00d6
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.l.o = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x00d6:
            java.lang.String r2 = "sdk.login.failed.cnt"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x00e6
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            com.igexin.push.config.l.p = r7     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x00e6:
            java.lang.String r2 = "sdk.detect.ip.expired.time"
            boolean r2 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r2 == 0) goto L_0x00f7
            long r5 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            long r5 = r5 * r3
            com.igexin.push.config.l.q = r5     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x00f7:
            java.lang.String r2 = "sdk.detect.interval.time"
            boolean r0 = r0.equals(r2)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            if (r0 == 0) goto L_0x000d
            long r5 = java.lang.Long.parseLong(r7)     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            long r5 = r5 * r3
            com.igexin.push.config.l.r = r5     // Catch:{ Exception -> 0x010f, all -> 0x010c }
            goto L_0x000d
        L_0x0108:
            r1.close()     // Catch:{ Exception -> 0x0123 }
            goto L_0x0127
        L_0x010c:
            r7 = move-exception
            r0 = r1
            goto L_0x0112
        L_0x010f:
            r0 = r1
            goto L_0x011d
        L_0x0111:
            r7 = move-exception
        L_0x0112:
            if (r0 == 0) goto L_0x011c
            r0.close()     // Catch:{ Exception -> 0x0118 }
            goto L_0x011c
        L_0x0118:
            r0 = move-exception
            r0.printStackTrace()
        L_0x011c:
            throw r7
        L_0x011d:
            if (r0 == 0) goto L_0x0127
            r0.close()     // Catch:{ Exception -> 0x0123 }
            goto L_0x0127
        L_0x0123:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0127:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.m.a(java.io.InputStream):void");
    }
}
