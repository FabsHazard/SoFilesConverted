package com.igexin.push.extension.distribution.basic.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.igexin.a.a.c.b;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.e.a;
import java.io.File;

public class c {
    private static final String a = "EXT-c";
    private static c d;
    private a b;
    private Context c;
    private final String e = "/sdcard/libs//com.getui.sdk.deviceId.db";

    private c(Context context) {
        this.c = context;
    }

    public static c a() {
        if (d == null) {
            d = new c(e.a);
        }
        return d;
    }

    private void a(File file) {
        for (File file2 : file.listFiles()) {
            while (file2.exists()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (!file2.delete()) {
                    a(file2);
                }
            }
        }
        file.delete();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a3, code lost:
        if (r4 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d1, code lost:
        if (r4 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d7 A[SYNTHETIC, Splitter:B:32:0x00d7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "V1|"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = a
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r3 = "|save deviceId = "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r3 = " to "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r3 = r7.e
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.igexin.a.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r4)
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = new java.util.concurrent.locks.ReentrantReadWriteLock
            r1.<init>()
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r1.writeLock()
            r4 = 0
            boolean r5 = r1.tryLock()     // Catch:{ Exception -> 0x00ae }
            if (r5 == 0) goto L_0x00a3
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00ae }
            java.lang.String r6 = r7.e     // Catch:{ Exception -> 0x00ae }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00ae }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x00ae }
            if (r6 != 0) goto L_0x007a
            boolean r6 = r5.createNewFile()     // Catch:{ Exception -> 0x00ae }
            if (r6 != 0) goto L_0x007a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ae }
            r8.<init>()     // Catch:{ Exception -> 0x00ae }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r0 = "|create file "
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x00ae }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r0 = " failed"
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x00ae }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00ae }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00ae }
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r0)     // Catch:{ Exception -> 0x00ae }
            r1.unlock()
            return
        L_0x007a:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00ae }
            java.lang.String r5 = r7.e     // Catch:{ Exception -> 0x00ae }
            r2.<init>(r5)     // Catch:{ Exception -> 0x00ae }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.lang.StringBuilder r8 = r4.append(r8)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            java.lang.String r0 = "utf-8"
            byte[] r8 = r8.getBytes(r0)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            byte[] r8 = com.igexin.a.b.a.b(r8)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r2.write(r8)     // Catch:{ Exception -> 0x00a0, all -> 0x009d }
            r4 = r2
            goto L_0x00a3
        L_0x009d:
            r8 = move-exception
            r4 = r2
            goto L_0x00d5
        L_0x00a0:
            r8 = move-exception
            r4 = r2
            goto L_0x00af
        L_0x00a3:
            if (r4 == 0) goto L_0x00a8
        L_0x00a5:
            r4.close()     // Catch:{ Exception -> 0x00a8 }
        L_0x00a8:
            r1.unlock()
            goto L_0x00d4
        L_0x00ac:
            r8 = move-exception
            goto L_0x00d5
        L_0x00ae:
            r8 = move-exception
        L_0x00af:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r0.<init>()     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = a     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = "|"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r8 = r0.append(r8)     // Catch:{ all -> 0x00ac }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00ac }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x00ac }
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r0)     // Catch:{ all -> 0x00ac }
            if (r4 == 0) goto L_0x00a8
            goto L_0x00a5
        L_0x00d4:
            return
        L_0x00d5:
            if (r4 == 0) goto L_0x00da
            r4.close()     // Catch:{ Exception -> 0x00da }
        L_0x00da:
            r1.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.c.c.b(java.lang.String):void");
    }

    private void c(String str) {
        try {
            if (e.l.a()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", 2);
                contentValues.put("value", str);
                e.l.a("runtime", (String) null, contentValues);
                e.l.close();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:2|(9:3|4|5|6|(3:7|8|(1:10)(1:48))|11|(2:15|16)|17|18)|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0073, code lost:
        if (r3 == null) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[SYNTHETIC, Splitter:B:30:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0068 A[SYNTHETIC, Splitter:B:34:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070 A[SYNTHETIC, Splitter:B:42:0x0070] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String g() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r7.e
            r0.<init>(r1)
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 == 0) goto L_0x0076
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            java.lang.String r3 = r7.e     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
            r3.<init>()     // Catch:{ Exception -> 0x005d, all -> 0x0059 }
        L_0x001e:
            int r4 = r2.read(r0)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            r5 = -1
            r6 = 0
            if (r4 == r5) goto L_0x002a
            r3.write(r0, r6, r4)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            goto L_0x001e
        L_0x002a:
            byte[] r0 = r3.toByteArray()     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            byte[] r0 = com.igexin.a.b.a.c(r0)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            java.lang.String r5 = "utf-8"
            r4.<init>(r0, r5)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            java.lang.String r0 = "\\|"
            java.lang.String[] r0 = r4.split(r0)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            int r4 = r0.length     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            r5 = 1
            if (r4 <= r5) goto L_0x0050
            java.lang.String r4 = "V1"
            r6 = r0[r6]     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            boolean r4 = r4.equals(r6)     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            if (r4 == 0) goto L_0x0050
            r0 = r0[r5]     // Catch:{ Exception -> 0x006e, all -> 0x0057 }
            r1 = r0
        L_0x0050:
            r2.close()     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            r3.close()     // Catch:{ Exception -> 0x0076 }
            goto L_0x0076
        L_0x0057:
            r0 = move-exception
            goto L_0x005b
        L_0x0059:
            r0 = move-exception
            r3 = r1
        L_0x005b:
            r1 = r2
            goto L_0x0061
        L_0x005d:
            r3 = r1
            goto L_0x006e
        L_0x005f:
            r0 = move-exception
            r3 = r1
        L_0x0061:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            if (r3 == 0) goto L_0x006b
            r3.close()     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            throw r0
        L_0x006c:
            r2 = r1
            r3 = r2
        L_0x006e:
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ Exception -> 0x0073 }
        L_0x0073:
            if (r3 == 0) goto L_0x0076
            goto L_0x0053
        L_0x0076:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.c.c.g():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
        if (r8 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0086, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008a, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        if (r8 != null) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0090, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0091, code lost:
        if (r8 != null) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a A[ExcHandler: all (r12v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r8 
      PHI: (r8v3 android.database.Cursor) = (r8v0 android.database.Cursor), (r8v5 android.database.Cursor), (r8v5 android.database.Cursor) binds: [B:1:0x000e, B:5:0x0020, B:12:0x0041] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080 A[EDGE_INSN: B:29:0x0080->B:16:0x0080 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026 A[Catch:{ Exception -> 0x0082, all -> 0x008a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "imageurl"
            java.lang.String r1 = ""
            com.igexin.push.extension.distribution.basic.e.a r2 = r11.b()
            r11.b = r2
            r8 = 0
            java.lang.String r3 = "image"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            r10 = 0
            r4[r10] = r0     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            r5[r10] = r12     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            r6 = 0
            r7 = 0
            android.database.Cursor r8 = r2.a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            if (r8 == 0) goto L_0x0084
        L_0x001f:
            r2 = r1
        L_0x0020:
            boolean r3 = r8.moveToNext()     // Catch:{ Exception -> 0x0082, all -> 0x008a }
            if (r3 == 0) goto L_0x0080
            java.lang.String r3 = "imagesrc"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0082, all -> 0x008a }
            java.lang.String r2 = r8.getString(r3)     // Catch:{ Exception -> 0x0082, all -> 0x008a }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0082, all -> 0x008a }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0082, all -> 0x008a }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0082, all -> 0x008a }
            if (r4 == 0) goto L_0x0041
            boolean r3 = r3.canRead()     // Catch:{ Exception -> 0x0082, all -> 0x008a }
            if (r3 != 0) goto L_0x0020
        L_0x0041:
            com.igexin.push.extension.distribution.basic.e.a r2 = r11.b     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.String r3 = "image"
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            r4[r10] = r0     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            r5[r10] = r12     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            r2.a((java.lang.String) r3, (java.lang.String[]) r4, (java.lang.String[]) r5)     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            android.content.Context r2 = r11.c     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            android.content.Context r4 = r11.c     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            int r2 = r2.checkPermission(r3, r4)     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            if (r2 == 0) goto L_0x001f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            r2.<init>()     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            android.content.Context r3 = r11.c     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.io.File r3 = r3.getCacheDir()     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.String r3 = "/ImgCache/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            com.igexin.push.extension.distribution.basic.c.e.k = r2     // Catch:{ Exception -> 0x0091, all -> 0x008a }
            goto L_0x001f
        L_0x0080:
            r1 = r2
            goto L_0x0084
        L_0x0082:
            r1 = r2
            goto L_0x0091
        L_0x0084:
            if (r8 == 0) goto L_0x0094
        L_0x0086:
            r8.close()
            goto L_0x0094
        L_0x008a:
            r12 = move-exception
            if (r8 == 0) goto L_0x0090
            r8.close()
        L_0x0090:
            throw r12
        L_0x0091:
            if (r8 == 0) goto L_0x0094
            goto L_0x0086
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.c.c.a(java.lang.String):java.lang.String");
    }

    public a b() {
        if (this.b == null) {
            this.b = new a(this.c);
        }
        return this.b;
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis() - 604800000;
        Cursor cursor = null;
        try {
            cursor = b().a("image", new String[]{"taskid"}, "createtime <= " + String.valueOf(currentTimeMillis));
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("taskid"));
                    b().a("image", new String[]{"taskid"}, new String[]{string});
                    File file = new File(e.k + string);
                    if (file.exists()) {
                        a(file);
                    }
                }
            }
            if (cursor == null) {
                return;
            }
        } catch (Exception unused) {
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    public void d() {
        File file = new File(CoreConsts.e);
        if (file.exists()) {
            for (File file2 : file.listFiles(new d(this))) {
                if (file2.exists()) {
                    a(file2);
                }
            }
        }
    }

    public void e() {
        String g = g();
        StringBuilder sb = new StringBuilder();
        String str = a;
        b.a(sb.append(str).append("|read from com.getui.sdk.deviceId.db = ").append(g).append("; CoreRuntimeInfo.deviceId = ").append(d.y).toString(), new Object[0]);
        if (g != null) {
            if (!g.equals(d.y)) {
                d.y = g;
                c(g);
            }
        } else if (d.y != null) {
            b(d.y);
        } else {
            b.a(str + "|updateDeviceId new file deviceId and CoreRuntimeInfo deviceId is null return", new Object[0]);
        }
    }

    public void f() {
    }
}
