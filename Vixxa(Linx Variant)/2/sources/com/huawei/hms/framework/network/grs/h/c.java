package com.huawei.hms.framework.network.grs.h;

public class c {
    private static final String a = "c";

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.huawei.hms.framework.common.Logger.w(a, "local config file is not exist.filename is {%s}", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r0);
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0062, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0050 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r5, android.content.Context r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0050 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0050 }
            boolean r3 = r3.isDirectory()     // Catch:{ IOException -> 0x0050 }
            if (r3 == 0) goto L_0x0021
        L_0x001a:
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r0)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r2)
            return r1
        L_0x0021:
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ IOException -> 0x0050 }
            java.io.InputStream r2 = r6.open(r5)     // Catch:{ IOException -> 0x0050 }
            r6 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0050 }
        L_0x002d:
            int r3 = r2.read(r6)     // Catch:{ IOException -> 0x0050 }
            r4 = -1
            if (r3 == r4) goto L_0x0039
            r4 = 0
            r0.write(r6, r4, r3)     // Catch:{ IOException -> 0x0050 }
            goto L_0x002d
        L_0x0039:
            r0.flush()     // Catch:{ IOException -> 0x0050 }
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x0050 }
            byte[] r3 = r0.toByteArray()     // Catch:{ IOException -> 0x0050 }
            java.lang.String r4 = "UTF-8"
            r6.<init>(r3, r4)     // Catch:{ IOException -> 0x0050 }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r0)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r2)
            return r6
        L_0x004e:
            r5 = move-exception
            goto L_0x005c
        L_0x0050:
            java.lang.String r6 = a     // Catch:{ all -> 0x004e }
            java.lang.String r3 = "local config file is not exist.filename is {%s}"
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch:{ all -> 0x004e }
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r6, (java.lang.String) r3, (java.lang.Object[]) r5)     // Catch:{ all -> 0x004e }
            goto L_0x001a
        L_0x005c:
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r0)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r2)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.h.c.a(java.lang.String, android.content.Context):java.lang.String");
    }
}
