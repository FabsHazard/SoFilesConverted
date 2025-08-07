package com.igexin.push.util;

import android.content.Context;
import com.huawei.hms.common.util.Logger;
import com.igexin.a.a.a.a;
import com.igexin.a.a.c.b;
import com.igexin.push.config.l;
import com.igexin.push.core.x;
import com.igexin.sdk.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;

public class d {
    private static final Object a = new Object();

    public static void a() {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(com.igexin.push.core.d.T);
            if (file.exists() || file.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(com.igexin.push.core.d.T);
                try {
                    fileOutputStream2.write(a.d((("v01" + com.igexin.push.core.d.x) + com.igexin.push.core.d.r + Logger.c + com.igexin.push.core.d.a + Logger.c + com.igexin.push.core.d.s + Logger.c + x.a().d(com.igexin.push.core.d.e)).getBytes(), com.igexin.push.core.d.C));
                    m.a(fileOutputStream2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    try {
                        b.a("FileUtils | " + e.toString(), new Object[0]);
                        m.a(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        m.a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    m.a(fileOutputStream);
                    throw th;
                }
            } else {
                b.a("FileUtils | create file : " + file.toString() + " failed !!!", new Object[0]);
                m.a((Closeable) null);
            }
        } catch (Exception e2) {
            e = e2;
            b.a("FileUtils | " + e.toString(), new Object[0]);
            m.a(fileOutputStream);
        }
    }

    public static void a(File file, String... strArr) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            List asList = strArr != null ? Arrays.asList(strArr) : null;
            for (File file2 : listFiles) {
                if (asList == null || !asList.contains(file2.getName())) {
                    file2.delete();
                }
            }
        }
    }

    private static void a(List<File> list, File file, String str) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File a2 : file.listFiles()) {
                    a(list, a2, str);
                }
            } else if (file.getName().startsWith(str)) {
                list.add(file);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001a A[SYNTHETIC, Splitter:B:13:0x001a] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0020 A[SYNTHETIC, Splitter:B:19:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(byte[] r3, java.lang.String r4, boolean r5) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x001e, all -> 0x0017 }
            r1.write(r3)     // Catch:{ Exception -> 0x0015, all -> 0x0012 }
            r1.close()     // Catch:{ Exception -> 0x0023 }
            goto L_0x0023
        L_0x0012:
            r3 = move-exception
            r0 = r1
            goto L_0x0018
        L_0x0015:
            r0 = r1
            goto L_0x001e
        L_0x0017:
            r3 = move-exception
        L_0x0018:
            if (r0 == 0) goto L_0x001d
            r0.close()     // Catch:{ Exception -> 0x001d }
        L_0x001d:
            throw r3
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.d.a(byte[], java.lang.String, boolean):void");
    }

    public static boolean a(Context context) {
        return !new c(context).b();
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
    public static byte[] a(java.lang.String r6) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0028
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "FileUtils|get data from file = "
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
            java.lang.String r5 = "FileUtils|"
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
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.d.a(java.lang.String):byte[]");
    }

    public static String b() {
        return com.igexin.push.core.e.d.a().b(com.igexin.push.core.d.e);
    }

    public static void b(Context context) {
        if (!l.m) {
            b.a("FileUtils|isReportInitialize = false", new Object[0]);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - com.igexin.push.core.d.aq < 1000) {
            b.a("FileUtils|not allowed to save initialization twice within 1s", new Object[0]);
            return;
        }
        com.igexin.push.core.d.aq = currentTimeMillis;
        if (com.igexin.push.core.d.f.get()) {
            com.igexin.a.a.b.c.b().a(new f(context, currentTimeMillis), false, true);
        } else {
            new Thread(new g(context, currentTimeMillis)).start();
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str) {
        if (context != null && str != null) {
            String str2 = context.getFilesDir().getPath() + "/init_c1.pid";
            synchronized (a) {
                if (str.length() == 0) {
                    a(str.getBytes(), str2, false);
                } else {
                    a((str + Logger.c).getBytes(), str2, true);
                }
            }
        }
    }

    public static boolean b(String str) {
        boolean z;
        File[] listFiles;
        b.a("FileUtils|removeExt " + str, new Object[0]);
        try {
            File file = new File(com.igexin.push.core.d.V);
            if (!file.exists() || (listFiles = file.listFiles(new e(str))) == null) {
                z = false;
            } else {
                z = false;
                for (File delete : listFiles) {
                    z |= delete.delete();
                }
            }
            String substring = com.igexin.a.b.a.a(str).substring(12, 20);
            b.a("FileUtils|removeExt renamedExtName = " + substring, new Object[0]);
            File file2 = new File(com.igexin.push.core.d.V + InternalZipConstants.ZIP_FILE_SEPARATOR + substring);
            if (file2.exists()) {
                b.a("FileUtils|removeExt, delete ext rename Ext path = " + file2.getAbsolutePath(), new Object[0]);
                b.a("FileUtils|removeExt, delete ext renamedExt succeed = " + file2.delete(), new Object[0]);
            }
            ArrayList<File> arrayList = new ArrayList<>();
            a((List<File>) arrayList, new File(com.igexin.push.core.d.V + "/oat"), str);
            for (File delete2 : arrayList) {
                delete2.delete();
            }
            return z;
        } catch (Throwable th) {
            b.a("FileUtils|" + th.toString(), new Object[0]);
            return false;
        }
    }

    public static String c() {
        return com.igexin.push.core.e.d.a().a(com.igexin.push.core.d.e);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.nio.channels.FileLock} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009d, code lost:
        r7 = r3;
        r3 = r0;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(android.content.Context r8) {
        /*
            java.lang.String r0 = "/gt_safe.pid"
            r1 = 0
            r2 = 0
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            r5.<init>()     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.io.File r8 = r8.getFilesDir()     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.lang.String r8 = r8.getPath()     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.lang.StringBuilder r8 = r5.append(r8)     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.lang.StringBuilder r8 = r8.append(r0)     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            r4.<init>(r8)     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.lang.String r8 = "rw"
            r3.<init>(r4, r8)     // Catch:{ Exception -> 0x00c2, all -> 0x00bf }
            java.nio.channels.FileChannel r8 = r3.getChannel()     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            java.nio.channels.FileLock r8 = r8.lock()     // Catch:{ Exception -> 0x00bb, all -> 0x00b7 }
            boolean r0 = r8.isValid()     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            if (r0 == 0) goto L_0x00a1
            r0 = 128(0x80, float:1.794E-43)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            r4.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
        L_0x0040:
            int r5 = r3.read(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            r6 = -1
            if (r5 == r6) goto L_0x004b
            r4.write(r0, r1, r5)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            goto L_0x0040
        L_0x004b:
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            byte[] r4 = r4.toByteArray()     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            r2.<init>()     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            java.lang.String r4 = "FileUtils|old safeCode = "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            com.igexin.a.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r4)     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            if (r2 == 0) goto L_0x009a
            r2 = 16
            java.lang.String r2 = com.igexin.push.util.p.a(r2)     // Catch:{ Exception -> 0x009c, all -> 0x00b0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            r0.<init>()     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            java.lang.String r4 = "FileUtils|new safeCode = "
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r4)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            java.lang.String r0 = "utf-8"
            byte[] r0 = r2.getBytes(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            r3.write(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00b0 }
            goto L_0x00a1
        L_0x009a:
            r2 = r0
            goto L_0x00a1
        L_0x009c:
            r2 = move-exception
            r7 = r3
            r3 = r0
            r0 = r2
            goto L_0x00b5
        L_0x00a1:
            com.igexin.push.util.m.a(r3)
            if (r8 == 0) goto L_0x00f0
            boolean r0 = r8.isValid()
            if (r0 == 0) goto L_0x00f0
            r8.release()     // Catch:{ IOException -> 0x00f0 }
            goto L_0x00f0
        L_0x00b0:
            r0 = move-exception
            goto L_0x00b9
        L_0x00b2:
            r0 = move-exception
            r7 = r3
            r3 = r2
        L_0x00b5:
            r2 = r7
            goto L_0x00c5
        L_0x00b7:
            r0 = move-exception
            r8 = r2
        L_0x00b9:
            r2 = r3
            goto L_0x00f2
        L_0x00bb:
            r0 = move-exception
            r8 = r2
            r2 = r3
            goto L_0x00c4
        L_0x00bf:
            r0 = move-exception
            r8 = r2
            goto L_0x00f2
        L_0x00c2:
            r0 = move-exception
            r8 = r2
        L_0x00c4:
            r3 = r8
        L_0x00c5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f1 }
            r4.<init>()     // Catch:{ all -> 0x00f1 }
            java.lang.String r5 = "FileUtils|get safeCode err = "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00f1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f1 }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x00f1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f1 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00f1 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00f1 }
            com.igexin.push.util.m.a(r2)
            if (r8 == 0) goto L_0x00ef
            boolean r0 = r8.isValid()
            if (r0 == 0) goto L_0x00ef
            r8.release()     // Catch:{ IOException -> 0x00ef }
        L_0x00ef:
            r2 = r3
        L_0x00f0:
            return r2
        L_0x00f1:
            r0 = move-exception
        L_0x00f2:
            com.igexin.push.util.m.a(r2)
            if (r8 == 0) goto L_0x0100
            boolean r1 = r8.isValid()
            if (r1 == 0) goto L_0x0100
            r8.release()     // Catch:{ IOException -> 0x0100 }
        L_0x0100:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.d.c(android.content.Context):java.lang.String");
    }

    public static long d() {
        return com.igexin.push.core.e.d.a().c(com.igexin.push.core.d.e);
    }

    public static String d(Context context) {
        return context.getExternalFilesDir("gtpush") + "/log/";
    }

    public static void e() {
        com.igexin.push.core.e.d.a().a(com.igexin.push.core.d.e, com.igexin.push.core.d.y);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[SYNTHETIC, Splitter:B:26:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f() {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = com.igexin.push.core.d.e
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r1 = r1.getPath()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "/init.pid"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x005c }
            boolean r3 = r3.exists()     // Catch:{ Exception -> 0x005c }
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = com.igexin.push.core.d.s     // Catch:{ Exception -> 0x005c }
            byte[] r3 = r3.getBytes()     // Catch:{ Exception -> 0x005c }
            int r4 = r3.length     // Catch:{ Exception -> 0x005c }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x005c }
            r5 = r1
        L_0x0034:
            int r6 = r3.length     // Catch:{ Exception -> 0x005c }
            if (r5 >= r6) goto L_0x0044
            byte r6 = r3[r5]     // Catch:{ Exception -> 0x005c }
            byte[] r7 = com.igexin.push.core.d.Y     // Catch:{ Exception -> 0x005c }
            byte r7 = r7[r5]     // Catch:{ Exception -> 0x005c }
            r6 = r6 ^ r7
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x005c }
            r4[r5] = r6     // Catch:{ Exception -> 0x005c }
            int r5 = r5 + 1
            goto L_0x0034
        L_0x0044:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x005c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x005c }
            r3.write(r4)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r2 = r3
            goto L_0x0054
        L_0x004e:
            r0 = move-exception
            r2 = r3
            goto L_0x007d
        L_0x0051:
            r0 = move-exception
            r2 = r3
            goto L_0x005d
        L_0x0054:
            if (r2 == 0) goto L_0x007c
        L_0x0056:
            r2.close()     // Catch:{ Exception -> 0x007c }
            goto L_0x007c
        L_0x005a:
            r0 = move-exception
            goto L_0x007d
        L_0x005c:
            r0 = move-exception
        L_0x005d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r3.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "FileUtils|"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x005a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005a }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x005a }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x007c
            goto L_0x0056
        L_0x007c:
            return
        L_0x007d:
            if (r2 == 0) goto L_0x0082
            r2.close()     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.d.f():void");
    }
}
