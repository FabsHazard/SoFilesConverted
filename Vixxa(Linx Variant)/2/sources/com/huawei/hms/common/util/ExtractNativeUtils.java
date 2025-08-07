package com.huawei.hms.common.util;

import android.content.Context;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;

public class ExtractNativeUtils {
    public static final String a = "ExtractNativeUtils";
    public static final int b = 0;
    public static final int c = -1;
    public static final int d = 50;
    public static final int e = 52428800;
    public static final Pattern f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static class b {
        public String a;
        public ZipEntry b;
        public String c;

        public b(ZipEntry zipEntry, String str, String str2) {
            this.b = zipEntry;
            this.a = str;
            this.c = str2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c4, code lost:
        r12 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c5, code lost:
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c7, code lost:
        r12 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c8, code lost:
        r3 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00e9, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00ea, code lost:
        com.huawei.hms.common.util.Logger.e(a, "IOException:", (java.lang.Throwable) r13);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004f A[Catch:{ IOException -> 0x00c4, all -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d7 A[SYNTHETIC, Splitter:B:64:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e5 A[SYNTHETIC, Splitter:B:71:0x00e5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.io.File r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "IOException:"
            java.lang.String r1 = "begin extractNativeLibrary"
            java.lang.String r2 = "ExtractNativeUtils"
            com.huawei.hms.common.util.Logger.i(r2, r1)
            r1 = 0
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00cf }
            r4.<init>(r12)     // Catch:{ IOException -> 0x00cf }
            java.util.Enumeration r12 = r4.entries()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r3.<init>()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            int r12 = a((java.util.Enumeration) r12, (java.util.HashMap<java.lang.String, java.util.HashSet<com.huawei.hms.common.util.ExtractNativeUtils.b>>) r3, (int) r1)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r5 = -1
            if (r12 != r5) goto L_0x002e
            java.lang.String r12 = "Unsafe zip name!"
            com.huawei.hms.common.util.Logger.e(r2, r12)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r4.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x002d:
            return r5
        L_0x002e:
            r6 = 50
            if (r12 <= r6) goto L_0x0040
            java.lang.String r12 = "the total number is larger than the max"
            com.huawei.hms.common.util.Logger.e(r2, r12)     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r4.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x003f:
            return r5
        L_0x0040:
            java.util.Set r12 = r3.keySet()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ IOException -> 0x00ca, all -> 0x00c7 }
            r6 = r1
        L_0x0049:
            boolean r7 = r12.hasNext()     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            if (r7 == 0) goto L_0x00be
            java.lang.Object r7 = r12.next()     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.util.Set r7 = (java.util.Set) r7     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            if (r7 != 0) goto L_0x006b
            java.lang.String r12 = "Get nativeZipEntries failed."
            com.huawei.hms.common.util.Logger.e(r2, r12)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            r4.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x006a:
            return r5
        L_0x006b:
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
        L_0x006f:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            if (r8 == 0) goto L_0x0049
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            com.huawei.hms.common.util.ExtractNativeUtils$b r8 = (com.huawei.hms.common.util.ExtractNativeUtils.b) r8     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            r9.<init>()     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.StringBuilder r9 = r9.append(r13)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.String r10 = r8.c     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            com.huawei.hms.feature.dynamic.ModuleCopy.makeDirectory(r9)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.io.File r10 = new java.io.File     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            r10.<init>(r9)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            r11 = 1
            r10.setExecutable(r11, r1)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            int r6 = a((java.util.zip.ZipFile) r4, (com.huawei.hms.common.util.ExtractNativeUtils.b) r8, (java.lang.String) r9)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            if (r6 == 0) goto L_0x00b1
            r4.close()     // Catch:{ IOException -> 0x00ac }
            goto L_0x00b0
        L_0x00ac:
            r12 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
        L_0x00b0:
            return r6
        L_0x00b1:
            java.io.File r10 = new java.io.File     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            java.lang.String r8 = r8.a     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            r10.<init>(r9, r8)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            r10.setReadable(r11, r1)     // Catch:{ IOException -> 0x00c4, all -> 0x00c7 }
            goto L_0x006f
        L_0x00be:
            r4.close()     // Catch:{ IOException -> 0x00c2 }
            goto L_0x00e2
        L_0x00c2:
            r12 = move-exception
            goto L_0x00dd
        L_0x00c4:
            r12 = move-exception
            r1 = r6
            goto L_0x00cb
        L_0x00c7:
            r12 = move-exception
            r3 = r4
            goto L_0x00e3
        L_0x00ca:
            r12 = move-exception
        L_0x00cb:
            r3 = r4
            goto L_0x00d0
        L_0x00cd:
            r12 = move-exception
            goto L_0x00e3
        L_0x00cf:
            r12 = move-exception
        L_0x00d0:
            java.lang.String r13 = "catch IOException "
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r13, (java.lang.Throwable) r12)     // Catch:{ all -> 0x00cd }
            if (r3 == 0) goto L_0x00e1
            r3.close()     // Catch:{ IOException -> 0x00db }
            goto L_0x00e1
        L_0x00db:
            r12 = move-exception
            r6 = r1
        L_0x00dd:
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r12)
            goto L_0x00e2
        L_0x00e1:
            r6 = r1
        L_0x00e2:
            return r6
        L_0x00e3:
            if (r3 == 0) goto L_0x00ed
            r3.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r13 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r2, (java.lang.String) r0, (java.lang.Throwable) r13)
        L_0x00ed:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.a(java.io.File, java.lang.String):int");
    }

    public static int a(Enumeration enumeration, HashMap<String, HashSet<b>> hashMap, int i) {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    Logger.e(a, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    HashSet hashSet = hashMap.get(group);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        hashMap.put(group, hashSet);
                    }
                    hashSet.add(new b(zipEntry, group2, group));
                    i++;
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: type inference failed for: r9v14 */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0089, code lost:
        if (r9 == null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
        if (r9 == null) goto L_0x00a6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081 A[SYNTHETIC, Splitter:B:37:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0097 A[SYNTHETIC, Splitter:B:50:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ad A[SYNTHETIC, Splitter:B:61:0x00ad] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b7 A[SYNTHETIC, Splitter:B:66:0x00b7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(java.util.zip.ZipFile r9, com.huawei.hms.common.util.ExtractNativeUtils.b r10, java.lang.String r11) {
        /*
            java.lang.String r0 = "IOException"
            java.lang.String r1 = "ExtractNativeUtils"
            r2 = 4096(0x1000, float:5.74E-42)
            r3 = -1
            r4 = 0
            byte[] r2 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0079, all -> 0x0076 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0079, all -> 0x0076 }
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0079, all -> 0x0076 }
            java.lang.String r7 = r10.a     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0079, all -> 0x0076 }
            r6.<init>(r11, r7)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0079, all -> 0x0076 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0079, all -> 0x0076 }
            java.util.zip.ZipEntry r11 = r10.b     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006b }
            java.io.InputStream r9 = r9.getInputStream(r11)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006f, all -> 0x006b }
            r11 = 0
            r4 = r11
        L_0x0022:
            int r6 = r9.read(r2)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            if (r6 <= 0) goto L_0x005a
            int r4 = r4 + r6
            r7 = 52428800(0x3200000, float:4.7019774E-37)
            if (r4 <= r7) goto L_0x0056
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            r11.<init>()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            java.lang.String r2 = "so file too big , "
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            java.lang.String r2 = r10.c     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            java.lang.String r2 = " , "
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            java.lang.String r10 = r10.a     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            java.lang.String r10 = r10.toString()     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            com.huawei.hms.common.util.Logger.e(r1, r10)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            goto L_0x005b
        L_0x0056:
            r5.write(r2, r11, r6)     // Catch:{ FileNotFoundException -> 0x0069, IOException -> 0x0066, all -> 0x0064 }
            goto L_0x0022
        L_0x005a:
            r3 = r11
        L_0x005b:
            r5.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x008b
        L_0x005f:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
            goto L_0x008b
        L_0x0064:
            r10 = move-exception
            goto L_0x006d
        L_0x0066:
            r10 = move-exception
            r4 = r9
            goto L_0x0070
        L_0x0069:
            r4 = r9
            goto L_0x0073
        L_0x006b:
            r10 = move-exception
            r9 = r4
        L_0x006d:
            r4 = r5
            goto L_0x00a8
        L_0x006f:
            r10 = move-exception
        L_0x0070:
            r9 = r4
            r4 = r5
            goto L_0x007c
        L_0x0073:
            r9 = r4
            r4 = r5
            goto L_0x0090
        L_0x0076:
            r9 = move-exception
            r10 = r4
            goto L_0x00ab
        L_0x0079:
            r9 = move-exception
            r10 = r9
            r9 = r4
        L_0x007c:
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)     // Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x0089
            r4.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
        L_0x0089:
            if (r9 == 0) goto L_0x00a6
        L_0x008b:
            r9.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00a6
        L_0x008f:
            r9 = r4
        L_0x0090:
            java.lang.String r10 = "FileNotFoundException"
            com.huawei.hms.common.util.Logger.e(r1, r10)     // Catch:{ all -> 0x00a7 }
            if (r4 == 0) goto L_0x009f
            r4.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
        L_0x009f:
            if (r9 == 0) goto L_0x00a6
            goto L_0x008b
        L_0x00a2:
            r9 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x00a6:
            return r3
        L_0x00a7:
            r10 = move-exception
        L_0x00a8:
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x00ab:
            if (r4 == 0) goto L_0x00b5
            r4.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r11 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r11)
        L_0x00b5:
            if (r10 == 0) goto L_0x00bf
            r10.close()     // Catch:{ IOException -> 0x00bb }
            goto L_0x00bf
        L_0x00bb:
            r10 = move-exception
            com.huawei.hms.common.util.Logger.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r10)
        L_0x00bf:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.a(java.util.zip.ZipFile, com.huawei.hms.common.util.ExtractNativeUtils$b, java.lang.String):int");
    }

    public static boolean a(Context context, String str) {
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                Logger.i(a, "The extract-native-flag has set, need to extract.");
                return true;
            }
            Logger.i(a, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            Logger.w(a, "Get package name failed: name not found.");
            return true;
        }
    }
}
