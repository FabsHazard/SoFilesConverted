package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.work.WorkRequest;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.TimeUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: BUGLY */
public class ap {
    private static Map<String, String> a;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (al.a(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String a(Date date) {
        try {
            return new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f A[SYNTHETIC, Splitter:B:28:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "rqdp{  ZF end}"
            r1 = 0
            if (r6 == 0) goto L_0x008e
            int r2 = r6.length()
            if (r2 != 0) goto L_0x000d
            goto L_0x008e
        L_0x000d:
            java.lang.String r2 = "rqdp{  ZF start}"
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r2, r4)
            java.lang.String r2 = "UTF-8"
            byte[] r6 = r6.getBytes(r2)     // Catch:{ all -> 0x0062 }
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0062 }
            r2.<init>(r6)     // Catch:{ all -> 0x0062 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0062 }
            r6.<init>()     // Catch:{ all -> 0x0062 }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x0062 }
            r4.<init>(r6)     // Catch:{ all -> 0x0062 }
            r5 = 8
            r4.setMethod(r5)     // Catch:{ all -> 0x0060 }
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0060 }
            r5.<init>(r7)     // Catch:{ all -> 0x0060 }
            r4.putNextEntry(r5)     // Catch:{ all -> 0x0060 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0060 }
        L_0x003b:
            int r5 = r2.read(r7)     // Catch:{ all -> 0x0060 }
            if (r5 <= 0) goto L_0x0045
            r4.write(r7, r3, r5)     // Catch:{ all -> 0x0060 }
            goto L_0x003b
        L_0x0045:
            r4.closeEntry()     // Catch:{ all -> 0x0060 }
            r4.flush()     // Catch:{ all -> 0x0060 }
            r4.finish()     // Catch:{ all -> 0x0060 }
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x0060 }
            r4.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005a:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r0, r7)
            return r6
        L_0x0060:
            r6 = move-exception
            goto L_0x0064
        L_0x0062:
            r6 = move-exception
            r4 = r1
        L_0x0064:
            boolean r7 = com.tencent.bugly.proguard.al.a(r6)     // Catch:{ all -> 0x007d }
            if (r7 != 0) goto L_0x006d
            r6.printStackTrace()     // Catch:{ all -> 0x007d }
        L_0x006d:
            if (r4 == 0) goto L_0x0077
            r4.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0077:
            java.lang.Object[] r6 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r0, r6)
            return r1
        L_0x007d:
            r6 = move-exception
            if (r4 == 0) goto L_0x0088
            r4.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0088:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            com.tencent.bugly.proguard.al.c(r0, r7)
            throw r6
        L_0x008e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.lang.String, java.lang.String):byte[]");
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        al.c("[Util] Zip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return bh.a().a(bArr);
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        al.c("[Util] Unzip %d bytes data with type %s", Integer.valueOf(bArr.length), "Gzip");
        try {
            return bh.a().b(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                al.d(th.getMessage(), new Object[0]);
                return null;
            } else if (al.a(th)) {
                return null;
            } else {
                th.printStackTrace();
                return null;
            }
        }
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / TimeUtils.oneDayMillis) * TimeUtils.oneDayMillis) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            instance.update(bArr);
            byte[] digest = instance.digest();
            if (digest == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.zip.ZipOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A[Catch:{ all -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b A[SYNTHETIC, Splitter:B:36:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085 A[SYNTHETIC, Splitter:B:41:0x0085] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r7, java.io.File r8) {
        /*
            java.lang.String r0 = "rqdp{  ZF end}"
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "rqdp{  ZF start}"
            com.tencent.bugly.proguard.al.c(r3, r2)
            boolean r2 = b((java.io.File) r7, (java.io.File) r8)
            if (r2 != 0) goto L_0x0011
            return r1
        L_0x0011:
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x006e }
            r3.<init>(r7)     // Catch:{ all -> 0x006e }
            java.util.zip.ZipOutputStream r4 = new java.util.zip.ZipOutputStream     // Catch:{ all -> 0x006a }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x006a }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x006a }
            r6.<init>(r8)     // Catch:{ all -> 0x006a }
            r5.<init>(r6)     // Catch:{ all -> 0x006a }
            r4.<init>(r5)     // Catch:{ all -> 0x006a }
            r8 = 8
            r4.setMethod(r8)     // Catch:{ all -> 0x0068 }
            java.util.zip.ZipEntry r8 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x0068 }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0068 }
            r8.<init>(r7)     // Catch:{ all -> 0x0068 }
            r4.putNextEntry(r8)     // Catch:{ all -> 0x0068 }
            r7 = 5000(0x1388, float:7.006E-42)
            r8 = 1000(0x3e8, float:1.401E-42)
            int r7 = java.lang.Math.max(r7, r8)     // Catch:{ all -> 0x0068 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0068 }
        L_0x0041:
            int r8 = r3.read(r7)     // Catch:{ all -> 0x0068 }
            if (r8 <= 0) goto L_0x004b
            r4.write(r7, r1, r8)     // Catch:{ all -> 0x0068 }
            goto L_0x0041
        L_0x004b:
            r4.flush()     // Catch:{ all -> 0x0068 }
            r4.closeEntry()     // Catch:{ all -> 0x0068 }
            r3.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0059:
            r4.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0061:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.al.c(r0, r7)
            r7 = 1
            return r7
        L_0x0068:
            r7 = move-exception
            goto L_0x006c
        L_0x006a:
            r7 = move-exception
            r4 = r2
        L_0x006c:
            r2 = r3
            goto L_0x0070
        L_0x006e:
            r7 = move-exception
            r4 = r2
        L_0x0070:
            boolean r8 = com.tencent.bugly.proguard.al.a(r7)     // Catch:{ all -> 0x0093 }
            if (r8 != 0) goto L_0x0079
            r7.printStackTrace()     // Catch:{ all -> 0x0093 }
        L_0x0079:
            if (r2 == 0) goto L_0x0083
            r2.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0083:
            if (r4 == 0) goto L_0x008d
            r4.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008d:
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.al.c(r0, r7)
            return r1
        L_0x0093:
            r7 = move-exception
            if (r2 == 0) goto L_0x009e
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r8 = move-exception
            r8.printStackTrace()
        L_0x009e:
            if (r4 == 0) goto L_0x00a8
            r4.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00a8
        L_0x00a4:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a8:
            java.lang.Object[] r8 = new java.lang.Object[r1]
            com.tencent.bugly.proguard.al.c(r0, r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.io.File, java.io.File):boolean");
    }

    private static boolean b(File file, File file2) {
        if (file == null || file2 == null || file.equals(file2)) {
            al.d("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        } else if (!file.exists() || !file.canRead()) {
            al.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        } else {
            try {
                if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                if (!file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
            if (!file2.exists() || !file2.canWrite()) {
                return false;
            }
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[Catch:{ all -> 0x008d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007a A[SYNTHETIC, Splitter:B:35:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0084 A[SYNTHETIC, Splitter:B:40:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> a(android.content.Context r4, java.lang.String[] r5) {
        /*
            boolean r4 = com.tencent.bugly.proguard.z.e(r4)
            if (r4 == 0) goto L_0x0018
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]
            r0 = 0
            java.lang.String r1 = "unknown(low memory)"
            r5[r0] = r1
            java.util.List r5 = java.util.Arrays.asList(r5)
            r4.<init>(r5)
            return r4
        L_0x0018:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x006c }
            java.lang.Process r5 = r1.exec(r5)     // Catch:{ all -> 0x006c }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x006c }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x006c }
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ all -> 0x006c }
            r2.<init>(r3)     // Catch:{ all -> 0x006c }
            r1.<init>(r2)     // Catch:{ all -> 0x006c }
        L_0x0034:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0069 }
            if (r2 == 0) goto L_0x003e
            r4.add(r2)     // Catch:{ all -> 0x0069 }
            goto L_0x0034
        L_0x003e:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0069 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0069 }
            java.io.InputStream r5 = r5.getErrorStream()     // Catch:{ all -> 0x0069 }
            r3.<init>(r5)     // Catch:{ all -> 0x0069 }
            r2.<init>(r3)     // Catch:{ all -> 0x0069 }
        L_0x004c:
            java.lang.String r5 = r2.readLine()     // Catch:{ all -> 0x0067 }
            if (r5 == 0) goto L_0x0056
            r4.add(r5)     // Catch:{ all -> 0x0067 }
            goto L_0x004c
        L_0x0056:
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005e:
            r2.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0066:
            return r4
        L_0x0067:
            r4 = move-exception
            goto L_0x006f
        L_0x0069:
            r4 = move-exception
            r2 = r0
            goto L_0x006f
        L_0x006c:
            r4 = move-exception
            r1 = r0
            r2 = r1
        L_0x006f:
            boolean r5 = com.tencent.bugly.proguard.al.a(r4)     // Catch:{ all -> 0x008d }
            if (r5 != 0) goto L_0x0078
            r4.printStackTrace()     // Catch:{ all -> 0x008d }
        L_0x0078:
            if (r1 == 0) goto L_0x0082
            r1.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0082:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r4 = move-exception
            r4.printStackTrace()
        L_0x008c:
            return r0
        L_0x008d:
            r4 = move-exception
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0098:
            if (r2 == 0) goto L_0x00a2
            r2.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00a2:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(android.content.Context, java.lang.String[]):java.util.ArrayList");
    }

    public static String a(Context context, String str) {
        if (str.trim().equals("")) {
            return "";
        }
        if (a == null) {
            a = new HashMap();
            String str2 = "/system/bin/sh";
            if (!new File(str2).exists() || !new File(str2).canExecute()) {
                str2 = "sh";
            }
            ArrayList<String> a2 = a(context, new String[]{str2, "-c", "getprop"});
            if (a2 != null && a2.size() > 0) {
                Class<ap> cls = ap.class;
                al.b(cls, "Successfully get 'getprop' list.", new Object[0]);
                Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                for (String matcher : a2) {
                    Matcher matcher2 = compile.matcher(matcher);
                    if (matcher2.find()) {
                        a.put(matcher2.group(1), matcher2.group(2));
                    }
                }
                al.b(cls, "Systems properties number: %d.", Integer.valueOf(a.size()));
            }
        }
        if (a.containsKey(str)) {
            return a.get(str);
        }
        return "fail";
    }

    public static void b(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean a(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static void b(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        }
    }

    public static byte[] c(long j) {
        try {
            return String.valueOf(j).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long d(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r0 = r1.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Context a(android.content.Context r1) {
        /*
            if (r1 != 0) goto L_0x0003
            return r1
        L_0x0003:
            android.content.Context r0 = r1.getApplicationContext()
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(android.content.Context):android.content.Context");
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void a(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set((Object) null, obj);
        } catch (Exception unused) {
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle((Bundle) null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(next.getKey());
            arrayList2.add(next.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            bundle.putString("pluginKey".concat(String.valueOf(i)), (String) arrayList.get(i));
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString("pluginVal" + i2 + "plugInId", ((PlugInBean) arrayList2.get(i2)).a);
            bundle.putString("pluginVal" + i2 + "plugInUUID", ((PlugInBean) arrayList2.get(i2)).c);
            bundle.putString("pluginVal" + i2 + "plugInVersion", ((PlugInBean) arrayList2.get(i2)).b);
        }
        parcel.writeBundle(bundle);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int intValue = ((Integer) readBundle.get("pluginNum")).intValue();
        for (int i = 0; i < intValue; i++) {
            arrayList.add(readBundle.getString("pluginKey".concat(String.valueOf(i))));
        }
        for (int i2 = 0; i2 < intValue; i2++) {
            arrayList2.add(new PlugInBean(readBundle.getString("pluginVal" + i2 + "plugInId"), readBundle.getString("pluginVal" + i2 + "plugInVersion"), readBundle.getString("pluginVal" + i2 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            hashMap = new HashMap(arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                hashMap.put(arrayList.get(i3), PlugInBean.class.cast(arrayList2.get(i3)));
            }
        } else {
            al.e("map plugin parcel error!", new Object[0]);
        }
        return hashMap;
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle((Bundle) null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(next.getKey());
            arrayList2.add(next.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    public static Map<String, String> b(Parcel parcel) {
        Bundle readBundle = parcel.readBundle();
        HashMap hashMap = null;
        if (readBundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = readBundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = readBundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            al.e("map parcel error!", new Object[0]);
        } else {
            hashMap = new HashMap(stringArrayList.size());
            for (int i = 0; i < stringArrayList.size(); i++) {
                hashMap.put(stringArrayList.get(i), stringArrayList2.get(i));
            }
        }
        return hashMap;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static String a(int i, String str) {
        String[] strArr;
        if (str == null) {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime"};
        } else {
            strArr = new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        }
        StringBuilder sb = new StringBuilder();
        Process process = null;
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine).append("\n");
                if (i > 0 && sb.length() > i) {
                    sb.delete(0, sb.length() - i);
                }
            }
            String sb2 = sb.toString();
            if (exec != null) {
                try {
                    exec.getOutputStream().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    exec.getInputStream().close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    exec.getErrorStream().close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            return sb2;
        } catch (Throwable th) {
            if (process != null) {
                try {
                    process.getOutputStream().close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                try {
                    process.getInputStream().close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    process.getErrorStream().close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static Map<String, String> a(boolean z, int i) {
        if (!z) {
            al.c("get all thread stack not enable", new Object[0]);
            return new HashMap();
        }
        Map<String, String> a2 = a(i);
        return a2 == null ? new HashMap() : a2;
    }

    private static Map<String, String> a(int i) {
        HashMap hashMap = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : allStackTraces.entrySet()) {
            int i2 = 0;
            sb.setLength(0);
            if (!(next.getValue() == null || ((StackTraceElement[]) next.getValue()).length == 0)) {
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
                int length = stackTraceElementArr.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cut!]");
                        break;
                    }
                    sb.append(stackTraceElement.toString()).append("\n");
                    i2++;
                }
                hashMap.put(((Thread) next.getKey()).getName() + "(" + ((Thread) next.getKey()).getId() + ")", sb.toString());
            }
        }
        return hashMap;
    }

    public static String a(Thread thread) {
        if (thread == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb.append(stackTraceElement.toString()).append("\n");
        }
        return sb.toString();
    }

    public static boolean b(Context context, String str) {
        al.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < WorkRequest.MIN_BACKOFF_MILLIS) {
                    return false;
                }
                al.c("[Util] Lock file (%s) is expired, unlock it.", str);
                c(context, str);
            }
            if (file.createNewFile()) {
                al.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            al.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    public static boolean c(Context context, String str) {
        al.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            al.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068 A[SYNTHETIC, Splitter:B:30:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r5, int r6, boolean r7) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x007d
            boolean r1 = r5.exists()
            if (r1 == 0) goto L_0x007d
            boolean r1 = r5.canRead()
            if (r1 != 0) goto L_0x0011
            goto L_0x007d
        L_0x0011:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r1.<init>()     // Catch:{ all -> 0x0061 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0061 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0061 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0061 }
            r4.<init>(r5)     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = "utf-8"
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0061 }
            r2.<init>(r3)     // Catch:{ all -> 0x0061 }
        L_0x0027:
            java.lang.String r5 = r2.readLine()     // Catch:{ all -> 0x005f }
            if (r5 == 0) goto L_0x0052
            java.lang.StringBuilder r5 = r1.append(r5)     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "\n"
            r5.append(r3)     // Catch:{ all -> 0x005f }
            if (r6 <= 0) goto L_0x0027
            int r5 = r1.length()     // Catch:{ all -> 0x005f }
            if (r5 <= r6) goto L_0x0027
            if (r7 == 0) goto L_0x0048
            int r5 = r1.length()     // Catch:{ all -> 0x005f }
            r1.delete(r6, r5)     // Catch:{ all -> 0x005f }
            goto L_0x0052
        L_0x0048:
            int r5 = r1.length()     // Catch:{ all -> 0x005f }
            int r5 = r5 - r6
            r3 = 0
            r1.delete(r3, r5)     // Catch:{ all -> 0x005f }
            goto L_0x0027
        L_0x0052:
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x005f }
            r2.close()     // Catch:{ Exception -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r6 = move-exception
            com.tencent.bugly.proguard.al.a(r6)
        L_0x005e:
            return r5
        L_0x005f:
            r5 = move-exception
            goto L_0x0063
        L_0x0061:
            r5 = move-exception
            r2 = r0
        L_0x0063:
            com.tencent.bugly.proguard.al.a(r5)     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x0070
            r2.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r5 = move-exception
            com.tencent.bugly.proguard.al.a(r5)
        L_0x0070:
            return r0
        L_0x0071:
            r5 = move-exception
            if (r2 == 0) goto L_0x007c
            r2.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r6 = move-exception
            com.tencent.bugly.proguard.al.a(r6)
        L_0x007c:
            throw r5
        L_0x007d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.io.File, int, boolean):java.lang.String");
    }

    public static BufferedReader a(File file) {
        if (file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                al.a(th);
            }
        }
        return null;
    }

    public static BufferedReader b(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists()) {
                if (file.canRead()) {
                    return a(file);
                }
            }
            return null;
        } catch (NullPointerException e) {
            al.a(e);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            al.e("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        ak a2 = ak.a();
        if (a2 != null) {
            return a2.a(runnable);
        }
        String[] split = runnable.getClass().getName().split("\\.");
        return a(runnable, split[split.length - 1]) != null;
    }

    public static boolean c(String str) {
        if (a(str)) {
            return false;
        }
        if (str.length() > 255) {
            al.a("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (str.toLowerCase().startsWith("http")) {
            return true;
        } else {
            al.a("URL(%s) is not start with \"http\".", str);
            return false;
        }
    }

    public static SharedPreferences a(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static void c(String str, String str2) {
        if (aa.b() != null && aa.b().O != null) {
            aa.b().O.edit().putString(str, str2).apply();
        }
    }

    public static String d(String str, String str2) {
        if (aa.b() == null || aa.b().O == null) {
            return "";
        }
        return aa.b().O.getString(str, str2);
    }

    public static <T> T a(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            T createFromParcel = creator.createFromParcel(obtain);
            if (obtain != null) {
                obtain.recycle();
            }
            return createFromParcel;
        } catch (Throwable th) {
            if (obtain != null) {
                obtain.recycle();
            }
            throw th;
        }
    }
}
