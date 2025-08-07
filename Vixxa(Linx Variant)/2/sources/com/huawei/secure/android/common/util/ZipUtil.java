package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    private static final String a = "ZipUtil";
    private static final int b = 104857600;
    private static final int c = 100;
    private static final int d = 4096;
    private static final String e = "../";
    private static final String f = "..\\";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.util.zip.ZipFile} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10);
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r11);
        com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r9);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.io.File> a(java.io.File r16, java.io.File r17, long r18, boolean r20) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "ZipUtil"
            r3 = 0
            if (r0 == 0) goto L_0x0135
            if (r1 != 0) goto L_0x000d
            goto L_0x0135
        L_0x000d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
            r6 = 1
            java.util.zip.ZipFile r7 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0108, all -> 0x0106 }
            r7.<init>(r0)     // Catch:{ IOException -> 0x0108, all -> 0x0106 }
            java.util.Enumeration r0 = r7.entries()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            r8 = r5
        L_0x001e:
            boolean r9 = r0.hasMoreElements()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r9 == 0) goto L_0x00f5
            java.lang.Object r9 = r0.nextElement()     // Catch:{ IllegalArgumentException -> 0x00ee }
            java.util.zip.ZipEntry r9 = (java.util.zip.ZipEntry) r9     // Catch:{ IllegalArgumentException -> 0x00ee }
            java.lang.String r10 = r9.getName()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r11 == 0) goto L_0x0035
            goto L_0x001e
        L_0x0035:
            java.text.Normalizer$Form r11 = java.text.Normalizer.Form.NFKC     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            java.lang.String r10 = java.text.Normalizer.normalize(r10, r11)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            boolean r11 = e((java.lang.String) r10)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r11 == 0) goto L_0x005d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            r0.<init>()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            java.lang.String r1 = "zipPath is a invalid path: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            java.lang.String r1 = d((java.lang.String) r10)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            android.util.Log.e(r2, r0)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            goto L_0x00f6
        L_0x005d:
            java.lang.String r11 = "\\\\"
            java.lang.String r12 = "/"
            java.lang.String r10 = r10.replaceAll(r11, r12)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            java.io.File r11 = new java.io.File     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            r11.<init>(r1, r10)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r20 == 0) goto L_0x007b
            boolean r10 = r11.exists()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r10 == 0) goto L_0x007b
            boolean r10 = r11.isFile()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r10 == 0) goto L_0x007b
            e((java.io.File) r11)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
        L_0x007b:
            r4.add(r11)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            boolean r10 = r9.isDirectory()     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r10 == 0) goto L_0x0091
            boolean r9 = a((java.io.File) r11)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r9 != 0) goto L_0x001e
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r7)
            a((java.util.List<java.io.File>) r4)
            return r3
        L_0x0091:
            boolean r10 = b((java.io.File) r11)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            if (r10 != 0) goto L_0x009e
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r7)
            a((java.util.List<java.io.File>) r4)
            return r3
        L_0x009e:
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00e1 }
            java.io.InputStream r9 = r7.getInputStream(r9)     // Catch:{ all -> 0x00e1 }
            r10.<init>(r9)     // Catch:{ all -> 0x00e1 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x00de }
            r9.<init>(r11)     // Catch:{ all -> 0x00de }
            java.io.BufferedOutputStream r11 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00da }
            r11.<init>(r9)     // Catch:{ all -> 0x00da }
            r12 = 1024(0x400, float:1.435E-42)
            byte[] r12 = new byte[r12]     // Catch:{ all -> 0x00d8 }
        L_0x00b5:
            int r13 = r10.read(r12)     // Catch:{ all -> 0x00d8 }
            r14 = -1
            if (r13 == r14) goto L_0x00cd
            int r8 = r8 + r13
            long r14 = (long) r8     // Catch:{ all -> 0x00d8 }
            int r14 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r14 <= 0) goto L_0x00c9
            java.lang.String r12 = "unzipFileNew: over than top size"
            android.util.Log.e(r2, r12)     // Catch:{ all -> 0x00d8 }
            r6 = r5
            goto L_0x00cd
        L_0x00c9:
            r11.write(r12, r5, r13)     // Catch:{ all -> 0x00d8 }
            goto L_0x00b5
        L_0x00cd:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r11)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r9)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            goto L_0x001e
        L_0x00d8:
            r0 = move-exception
            goto L_0x00dc
        L_0x00da:
            r0 = move-exception
            r11 = r3
        L_0x00dc:
            r3 = r9
            goto L_0x00e4
        L_0x00de:
            r0 = move-exception
            r11 = r3
            goto L_0x00e4
        L_0x00e1:
            r0 = move-exception
            r10 = r3
            r11 = r10
        L_0x00e4:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r11)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r3)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            throw r0     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
        L_0x00ee:
            java.lang.String r9 = "entries.nextElement IllegalArgumentException"
            android.util.Log.e(r2, r9)     // Catch:{ IOException -> 0x0103, all -> 0x00ff }
            goto L_0x001e
        L_0x00f5:
            r5 = r6
        L_0x00f6:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r7)
            if (r5 != 0) goto L_0x0129
            a((java.util.List<java.io.File>) r4)
            goto L_0x0129
        L_0x00ff:
            r0 = move-exception
            r5 = r6
            r3 = r7
            goto L_0x012b
        L_0x0103:
            r0 = move-exception
            r3 = r7
            goto L_0x0109
        L_0x0106:
            r0 = move-exception
            goto L_0x012c
        L_0x0108:
            r0 = move-exception
        L_0x0109:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x012a }
            r1.<init>()     // Catch:{ all -> 0x012a }
            java.lang.String r6 = "unzip new IOException : "
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x012a }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x012a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x012a }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x012a }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r3)
            a((java.util.List<java.io.File>) r4)
        L_0x0129:
            return r4
        L_0x012a:
            r0 = move-exception
        L_0x012b:
            r6 = r5
        L_0x012c:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.Closeable) r3)
            if (r6 != 0) goto L_0x0134
            a((java.util.List<java.io.File>) r4)
        L_0x0134:
            throw r0
        L_0x0135:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.io.File, java.io.File, long, boolean):java.util.List");
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r2.lastIndexOf(java.io.File.separator);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String d(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r0 = java.io.File.separator
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 != r1) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.d(java.lang.String):java.lang.String");
    }

    private static void e(File file) {
        if (file != null) {
            if (file.isFile()) {
                c(file);
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    c(file);
                    return;
                }
                for (File e2 : listFiles) {
                    e(e2);
                }
                c(file);
            }
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, 104857600, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, 104857600, 100, z);
    }

    private static void c(File file) {
        if (file != null && !file.delete()) {
            LogsUtil.e(a, "delete file error");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v22, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v23, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        android.util.Log.e(a, "unzip  over than top size");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d9, code lost:
        r2 = false;
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0101, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0102, code lost:
        r16 = r9;
        r9 = r6;
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0108, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010d, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010e, code lost:
        r6 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0122, code lost:
        r12 = r9;
        r6 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ff A[ExcHandler: all (th java.lang.Throwable), PHI: r6 r9 
      PHI: (r6v9 java.io.FileInputStream) = (r6v17 java.io.FileInputStream), (r6v18 java.io.FileInputStream), (r6v19 java.io.FileInputStream), (r6v24 java.io.FileInputStream), (r6v25 java.io.FileInputStream) binds: [B:14:0x004e, B:71:0x0117, B:72:?, B:55:0x00f7, B:56:?] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v16 java.io.FileOutputStream) = (r9v13 java.io.FileOutputStream), (r9v13 java.io.FileOutputStream), (r9v13 java.io.FileOutputStream), (r9v18 java.io.FileOutputStream), (r9v18 java.io.FileOutputStream) binds: [B:14:0x004e, B:71:0x0117, B:72:?, B:55:0x00f7, B:56:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:55:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:37:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0164  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean unZip(java.lang.String r17, java.lang.String r18, long r19, int r21, boolean r22) throws com.huawei.secure.android.common.util.SecurityCommonException {
        /*
            r0 = r18
            java.lang.String r1 = "ZipUtil"
            boolean r2 = a((java.lang.String) r17, (java.lang.String) r18, (long) r19, (int) r21)
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = java.io.File.separator
            boolean r2 = r0.endsWith(r2)
            if (r2 == 0) goto L_0x002f
            int r2 = r18.length()
            java.lang.String r4 = java.io.File.separator
            int r4 = r4.length()
            if (r2 <= r4) goto L_0x002f
            int r2 = r18.length()
            java.lang.String r4 = java.io.File.separator
            int r4 = r4.length()
            int r2 = r2 - r4
            java.lang.String r0 = r0.substring(r3, r2)
        L_0x002f:
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r2]
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x013c, all -> 0x0137 }
            r8 = r17
            r7.<init>(r8)     // Catch:{ IOException -> 0x013c, all -> 0x0137 }
            java.util.zip.ZipInputStream r8 = new java.util.zip.ZipInputStream     // Catch:{ IOException -> 0x0130, all -> 0x012a }
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0130, all -> 0x012a }
            r9.<init>(r7)     // Catch:{ IOException -> 0x0130, all -> 0x012a }
            r8.<init>(r9)     // Catch:{ IOException -> 0x0130, all -> 0x012a }
            r9 = 1
            r11 = r3
            r10 = r9
            r9 = r6
        L_0x004e:
            java.util.zip.ZipEntry r12 = r8.getNextEntry()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            if (r12 == 0) goto L_0x0116
            java.lang.String r13 = r12.getName()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.lang.String r14 = "\\\\"
            java.lang.String r15 = "/"
            java.lang.String r13 = r13.replaceAll(r14, r15)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.io.File r14 = new java.io.File     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            r14.<init>(r0, r13)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.text.Normalizer$Form r15 = java.text.Normalizer.Form.NFKC     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.lang.String r13 = java.text.Normalizer.normalize(r13, r15)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            boolean r15 = e((java.lang.String) r13)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            if (r15 == 0) goto L_0x008f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            r0.<init>()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.lang.String r2 = "zipPath is a invalid path: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.lang.String r2 = d((java.lang.String) r13)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            android.util.Log.e(r1, r0)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            r2 = r3
            r10 = r2
            goto L_0x0117
        L_0x008f:
            if (r22 == 0) goto L_0x00a0
            boolean r13 = r14.exists()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            if (r13 == 0) goto L_0x00a0
            boolean r13 = r14.isFile()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            if (r13 == 0) goto L_0x00a0
            e((java.io.File) r14)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
        L_0x00a0:
            boolean r12 = r12.isDirectory()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            if (r12 == 0) goto L_0x00ae
            d((java.io.File) r14)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            r5.add(r14)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            r2 = r3
            goto L_0x00f7
        L_0x00ae:
            java.io.File r12 = r14.getParentFile()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            if (r12 == 0) goto L_0x00bd
            boolean r13 = r12.exists()     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            if (r13 != 0) goto L_0x00bd
            d((java.io.File) r12)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
        L_0x00bd:
            java.io.FileOutputStream r12 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            r12.<init>(r14)     // Catch:{ IOException -> 0x0125, all -> 0x00ff }
            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
            r9.<init>(r12)     // Catch:{ IOException -> 0x0113, all -> 0x0111 }
        L_0x00c7:
            int r6 = r8.read(r4, r3, r2)     // Catch:{ IOException -> 0x010c, all -> 0x010a }
            r13 = -1
            if (r6 == r13) goto L_0x00e8
            int r11 = r11 + r6
            long r2 = (long) r11
            int r2 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x00e0
            java.lang.String r2 = "unzip  over than top size"
            android.util.Log.e(r1, r2)     // Catch:{ IOException -> 0x00dc, all -> 0x010a }
            r2 = 0
            r10 = 0
            goto L_0x00e9
        L_0x00dc:
            r0 = move-exception
            r6 = r12
            r2 = 0
            goto L_0x010f
        L_0x00e0:
            r2 = 0
            r9.write(r4, r2, r6)     // Catch:{ IOException -> 0x0108, all -> 0x010a }
            r3 = r2
            r2 = 4096(0x1000, float:5.74E-42)
            goto L_0x00c7
        L_0x00e8:
            r2 = r3
        L_0x00e9:
            r5.add(r14)     // Catch:{ IOException -> 0x0108, all -> 0x010a }
            r9.flush()     // Catch:{ IOException -> 0x0108, all -> 0x010a }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r9)     // Catch:{ IOException -> 0x0108, all -> 0x010a }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r12)     // Catch:{ IOException -> 0x0108, all -> 0x010a }
            r6 = r9
            r9 = r12
        L_0x00f7:
            r8.closeEntry()     // Catch:{ IOException -> 0x0101, all -> 0x00ff }
            r3 = r2
            r2 = 4096(0x1000, float:5.74E-42)
            goto L_0x004e
        L_0x00ff:
            r0 = move-exception
            goto L_0x0122
        L_0x0101:
            r0 = move-exception
            r16 = r9
            r9 = r6
            r6 = r16
            goto L_0x010f
        L_0x0108:
            r0 = move-exception
            goto L_0x010e
        L_0x010a:
            r0 = move-exception
            goto L_0x012e
        L_0x010c:
            r0 = move-exception
            r2 = r3
        L_0x010e:
            r6 = r12
        L_0x010f:
            r12 = r6
            goto L_0x0135
        L_0x0111:
            r0 = move-exception
            goto L_0x0123
        L_0x0113:
            r0 = move-exception
            r2 = r3
            goto L_0x0128
        L_0x0116:
            r2 = r3
        L_0x0117:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r8)     // Catch:{ IOException -> 0x0120, all -> 0x00ff }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r7)     // Catch:{ IOException -> 0x0120, all -> 0x00ff }
            r3 = r10
            goto L_0x015f
        L_0x0120:
            r0 = move-exception
            goto L_0x0127
        L_0x0122:
            r12 = r9
        L_0x0123:
            r9 = r6
            goto L_0x012e
        L_0x0125:
            r0 = move-exception
            r2 = r3
        L_0x0127:
            r12 = r9
        L_0x0128:
            r9 = r6
            goto L_0x0135
        L_0x012a:
            r0 = move-exception
            r8 = r6
            r9 = r8
            r12 = r9
        L_0x012e:
            r6 = r7
            goto L_0x0169
        L_0x0130:
            r0 = move-exception
            r2 = r3
            r8 = r6
            r9 = r8
            r12 = r9
        L_0x0135:
            r6 = r7
            goto L_0x0141
        L_0x0137:
            r0 = move-exception
            r8 = r6
            r9 = r8
            r12 = r9
            goto L_0x0169
        L_0x013c:
            r0 = move-exception
            r2 = r3
            r8 = r6
            r9 = r8
            r12 = r9
        L_0x0141:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0168 }
            r3.<init>()     // Catch:{ all -> 0x0168 }
            java.lang.String r4 = "Unzip IOException : "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0168 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0168 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x0168 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0168 }
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)     // Catch:{ all -> 0x0168 }
            r3 = r2
            r7 = r6
            r6 = r9
            r9 = r12
        L_0x015f:
            a((java.io.FileInputStream) r7, (java.io.BufferedOutputStream) r6, (java.util.zip.ZipInputStream) r8, (java.io.FileOutputStream) r9)
            if (r3 != 0) goto L_0x0167
            a((java.util.List<java.io.File>) r5)
        L_0x0167:
            return r3
        L_0x0168:
            r0 = move-exception
        L_0x0169:
            a((java.io.FileInputStream) r6, (java.io.BufferedOutputStream) r9, (java.util.zip.ZipInputStream) r8, (java.io.FileOutputStream) r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.unZip(java.lang.String, java.lang.String, long, int, boolean):boolean");
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        if (!a(str, str2, j, i)) {
            return null;
        }
        if (str2.endsWith(File.separator) && str2.length() > File.separator.length()) {
            str2 = str2.substring(0, str2.length() - File.separator.length());
        }
        return a(c(str), c(str2), j, z);
    }

    private static void d(File file) {
        if (file != null && !file.exists() && !file.mkdirs()) {
            LogsUtil.e(a, "mkdirs error , files exists or IOException.");
        }
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(a, "isContainInvalidStr: name is null");
            return true;
        } else if (str.contains(e) || str.contains(f) || str.contains("..") || str.contains("./") || str.contains(".\\.\\") || str.contains("%00")) {
            return true;
        } else {
            return false;
        }
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str) && e(str)) {
            Log.e(a, "IllegalArgumentException--path is not a standard path");
            throw new IllegalArgumentException("path is not a standard path");
        }
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f A[SYNTHETIC, Splitter:B:27:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079 A[SYNTHETIC, Splitter:B:33:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0045 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0019 A[Catch:{ IOException -> 0x004d, all -> 0x004a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r11, long r12, int r14) {
        /*
            java.lang.String r0 = "close zipFile IOException "
            java.lang.String r1 = "ZipUtil"
            r2 = 0
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0052 }
            r4.<init>(r11)     // Catch:{ IOException -> 0x0052 }
            java.util.Enumeration r11 = r4.entries()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            r5 = 0
            r2 = r3
        L_0x0012:
            boolean r7 = r11.hasMoreElements()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            r8 = 1
            if (r7 == 0) goto L_0x0045
            java.lang.Object r7 = r11.nextElement()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            java.util.zip.ZipEntry r7 = (java.util.zip.ZipEntry) r7     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            long r9 = r7.getSize()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            long r5 = r5 + r9
            int r2 = r2 + r8
            java.lang.String r8 = r7.getName()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            boolean r8 = e((java.lang.String) r8)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            if (r8 != 0) goto L_0x003f
            if (r2 >= r14) goto L_0x003f
            int r8 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r8 > 0) goto L_0x003f
            long r7 = r7.getSize()     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0012
        L_0x003f:
            java.lang.String r11 = "File name is invalid or too many files or too big"
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r11)     // Catch:{ IOException -> 0x004d, all -> 0x004a }
            goto L_0x0046
        L_0x0045:
            r3 = r8
        L_0x0046:
            r4.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0076
        L_0x004a:
            r11 = move-exception
            r2 = r4
            goto L_0x0077
        L_0x004d:
            r11 = move-exception
            r2 = r4
            goto L_0x0053
        L_0x0050:
            r11 = move-exception
            goto L_0x0077
        L_0x0052:
            r11 = move-exception
        L_0x0053:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            r12.<init>()     // Catch:{ all -> 0x0050 }
            java.lang.String r13 = "not a valid zip file, IOException : "
            java.lang.StringBuilder r12 = r12.append(r13)     // Catch:{ all -> 0x0050 }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x0050 }
            java.lang.StringBuilder r11 = r12.append(r11)     // Catch:{ all -> 0x0050 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0050 }
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r11)     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x0076
            r2.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0076
        L_0x0073:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L_0x0076:
            return r3
        L_0x0077:
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0080
        L_0x007d:
            com.huawei.secure.android.common.util.LogsUtil.e(r1, r0)
        L_0x0080:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.lang.String, long, int):boolean");
    }

    private static boolean a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (TextUtils.isEmpty(str) || e(str)) {
            LogsUtil.e(a, "zip file is not valid");
            return false;
        } else if (TextUtils.isEmpty(str2) || e(str2)) {
            LogsUtil.e(a, "target directory is not valid");
            return false;
        } else if (a(str, j, i)) {
            return true;
        } else {
            LogsUtil.e(a, "zip file contains valid chars or too many files");
            throw new SecurityCommonException("unsecure zipfile!");
        }
    }

    private static boolean a(List<File> list) {
        try {
            for (File e2 : list) {
                e(e2);
            }
            return true;
        } catch (Exception e3) {
            LogsUtil.e(a, "unzip fail delete file failed" + e3.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
