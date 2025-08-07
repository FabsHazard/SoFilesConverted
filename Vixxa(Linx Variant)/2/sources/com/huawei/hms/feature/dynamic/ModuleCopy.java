package com.huawei.hms.feature.dynamic;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.f.d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class ModuleCopy {
    public static final String a = "ModuleCopy";
    public static final int b = 2048;
    public static final int c = 0;
    public static final int d = 1;
    public static final String e = "module_uri_path";
    public static final String f = "loader_uri_path";
    public static final String g = "dynamic_modules";
    public static final String h = ".apk";

    public static class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        public void run() {
            try {
                boolean unused = ModuleCopy.c(this.a);
            } catch (SecurityException unused2) {
                Logger.w(ModuleCopy.a, "Delete file failed: SecurityException.");
            }
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ String[] a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public b(String[] strArr, int i, String str) {
            this.a = strArr;
            this.b = i;
            this.c = str;
        }

        public void run() {
            for (String str : this.a) {
                if (Integer.parseInt(str) < this.b) {
                    Logger.i(ModuleCopy.a, "Delete low version:" + this.b + " in modulePath.");
                    boolean unused = ModuleCopy.c(this.c + File.separator + str);
                }
            }
        }
    }

    public static int a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            Logger.i(a, "No version dirs in module path, need mkdir.");
            return 0;
        }
        int i = 0;
        for (String parseInt : strArr) {
            i = Math.max(Integer.parseInt(parseInt), i);
        }
        return i;
    }

    public static String a(Context context, Bundle bundle, int i, Uri uri) {
        String str;
        StringBuilder sb;
        String str2;
        String str3;
        if (i == 0) {
            str = b.j;
            str3 = bundle.getString(str);
            str2 = String.valueOf(bundle.getInt(b.k));
            sb = new StringBuilder();
        } else {
            str = b.p;
            str3 = bundle.getString(str);
            str2 = String.valueOf(bundle.getInt(b.q));
            sb = new StringBuilder();
        }
        String sb2 = sb.append(bundle.getString(str)).append(".apk").toString();
        try {
            String str4 = getProtectedPath(context) + File.separator + "dynamic_modules" + File.separator + str3;
            String str5 = str4 + File.separator + str2;
            String str6 = str5 + File.separator + sb2;
            if (!new File(str4).exists()) {
                return a(context, str5, uri, str6);
            }
            String[] list = new File(str4).list();
            int a2 = a(list);
            if (a2 < Integer.parseInt(str2)) {
                return a(context, str5, uri, str6);
            }
            clearLowVersionModule(a2, str4, list, a);
            return str4 + File.separator + a2 + File.separator + sb2;
        } catch (IOException e2) {
            Logger.w(a, "request modulePath error: " + e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, String str, Uri uri, String str2) {
        if (!makeDirectory(str)) {
            Logger.e(a, "makeDirectory return false");
            return null;
        }
        a(context, uri, str2);
        if (d.b(context, str2)) {
            return str2;
        }
        Logger.w(a, "The coped module apk is invalid.");
        b(str2);
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: android.content.Context} */
    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v18 */
    /* JADX WARNING: type inference failed for: r3v19 */
    /* JADX WARNING: type inference failed for: r3v23 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r3, android.net.Uri r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "ModuleCopy"
            r1 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x004f, all -> 0x004b }
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x004f, all -> 0x004b }
            if (r3 != 0) goto L_0x001d
            java.lang.String r4 = "Get input stream failed: null."
            com.huawei.hms.common.util.Logger.w(r0, r4)     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            closeQuietly(r3)
            closeQuietly(r1)
            return
        L_0x0019:
            r4 = move-exception
            goto L_0x0052
        L_0x001b:
            r4 = move-exception
            goto L_0x006d
        L_0x001d:
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x001b, IOException -> 0x0019, all -> 0x0049 }
            r5 = 2048(0x800, float:2.87E-42)
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003e }
        L_0x002b:
            int r1 = r3.read(r5)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003e }
            r2 = -1
            if (r1 == r2) goto L_0x0037
            r2 = 0
            r4.write(r5, r2, r1)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003e }
            goto L_0x002b
        L_0x0037:
            closeQuietly(r3)
            closeQuietly(r4)
            goto L_0x008a
        L_0x003e:
            r5 = move-exception
            r1 = r4
            goto L_0x008c
        L_0x0041:
            r5 = move-exception
            r1 = r4
            r4 = r5
            goto L_0x0052
        L_0x0045:
            r5 = move-exception
            r1 = r4
            r4 = r5
            goto L_0x006d
        L_0x0049:
            r4 = move-exception
            goto L_0x004d
        L_0x004b:
            r4 = move-exception
            r3 = r1
        L_0x004d:
            r5 = r4
            goto L_0x008c
        L_0x004f:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L_0x0052:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r5.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "IOException "
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch:{ all -> 0x008b }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ all -> 0x008b }
        L_0x0065:
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008b }
            goto L_0x0081
        L_0x006a:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L_0x006d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r5.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "FileNotFoundException:"
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch:{ all -> 0x008b }
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r4 = r5.append(r4)     // Catch:{ all -> 0x008b }
            goto L_0x0065
        L_0x0081:
            com.huawei.hms.common.util.Logger.e(r0, r4)     // Catch:{ all -> 0x008b }
            closeQuietly(r3)
            closeQuietly(r1)
        L_0x008a:
            return
        L_0x008b:
            r5 = move-exception
        L_0x008c:
            closeQuietly(r3)
            closeQuietly(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.ModuleCopy.a(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    public static void a(Context context, Bundle bundle, int i) {
        String string = bundle.getString(i == 0 ? e : f);
        Logger.i(a, "path:" + string);
        String a2 = a(context, bundle, i, Uri.parse(string));
        if (TextUtils.isEmpty(a2)) {
            Logger.w(a, "checkModulePath failed: null.");
        } else {
            bundle.putString(i == 0 ? b.n : b.r, a2);
        }
    }

    public static boolean a(Bundle bundle) {
        return TextUtils.equals(bundle.getString(b.n), bundle.getString(b.r));
    }

    public static void b(String str) {
        c.a(1, "DeleteFile").execute(new a(str));
    }

    public static boolean c(String str) {
        boolean z;
        File file = new File(str);
        if (!file.isDirectory() || file.list() == null) {
            z = true;
        } else {
            z = true;
            for (String append : file.list()) {
                z = z && c(new StringBuilder().append(str).append(File.separator).append(append).toString());
            }
        }
        return z && file.delete();
    }

    public static void clearLowVersionModule(int i, String str, String[] strArr, String str2) {
        c.a(1, str2).execute(new b(strArr, i, str));
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Logger.e(a, "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static void copyModule(Context context, Bundle bundle) {
        if (context == null || bundle == null) {
            Logger.e(a, "The context or module info bundle is null.");
            return;
        }
        boolean a2 = a(bundle);
        a(context, bundle, 0);
        if (a2) {
            bundle.putString(b.r, bundle.getString(b.n));
        } else {
            a(context, bundle, 1);
        }
    }

    public static String getProtectedPath(Context context) throws IOException {
        return context.createDeviceProtectedStorageContext().getDataDir().getCanonicalPath();
    }

    public static boolean isLocalModuleFile(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Logger.w(a, "context or filePath is null.");
            return false;
        }
        try {
            return new File(str).getCanonicalPath().startsWith(getProtectedPath(context) + File.separator + "dynamic_modules");
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean makeDirectory(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e2) {
            Logger.e(a, "makeDirectory Exception: " + e2.getMessage());
            return false;
        }
    }

    public static String trimLastSection(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf <= 0 ? str : str.substring(0, lastIndexOf);
    }
}
