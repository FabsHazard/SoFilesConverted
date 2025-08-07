package com.igexin.push.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.e.c;
import com.igexin.a.a.c.b;
import com.igexin.push.core.d;
import java.io.File;
import net.lingala.zip4j.util.InternalZipConstants;

class a implements c {
    static final byte[] a = {47, 115, 100, 99, 97, 114, 100, 47, 65, 110, 100, 114, 111, 105, 100, 47, 109, 101, 100, 105, 97, 47};
    private static final String b = ("gt" + Build.MODEL);
    private String c;
    private String d;

    protected a() {
        try {
            if (e(d.e)) {
                this.c = new String(a) + "." + Integer.toHexString(b.hashCode()).toUpperCase() + InternalZipConstants.ZIP_FILE_SEPARATOR;
                b.a("AndroidQSDStorage|dir = " + this.c, new Object[0]);
                File file = new File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
        } catch (Throwable th) {
            b.a("AndroidQSDStorage|e = " + th, new Object[0]);
        }
    }

    private String a(String str) {
        return com.igexin.a.a.c.a.a(com.igexin.a.a.a.a.d(str.getBytes(), b)).toUpperCase();
    }

    private String b(String str) {
        return new String(com.igexin.a.a.a.a.c(com.igexin.a.a.c.a.a(str), b));
    }

    private void d(Context context) {
        if (TextUtils.isEmpty(this.d)) {
            this.d = this.c + com.igexin.a.a.c.a.a(com.igexin.a.a.a.a.d(context.getPackageName().getBytes(), b)).toUpperCase() + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
    }

    private boolean e(Context context) {
        return new com.igexin.sdk.a.b(context).c();
    }

    public String a(Context context) {
        if (!e(context)) {
            return null;
        }
        File file = new File(this.c + "di/");
        if (!file.exists()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            b.a("AndroidQSDStorage|getDeviceId() childs = NULL", new Object[0]);
            return null;
        }
        File file2 = listFiles[0];
        try {
            return b(file2.getName());
        } catch (Throwable unused) {
            file2.delete();
            return null;
        }
    }

    public void a(Context context, long j) {
        if (e(context)) {
            d(context);
            File file = new File(this.d + "ss");
            if (j == 0) {
                com.igexin.push.util.d.a(file, new String[0]);
                return;
            }
            String a2 = a(String.valueOf(j));
            File file2 = new File(file.getAbsolutePath() + InternalZipConstants.ZIP_FILE_SEPARATOR + a2);
            if (!file2.exists()) {
                boolean mkdirs = file2.mkdirs();
                if (mkdirs) {
                    com.igexin.push.util.d.a(file, a2);
                }
                b.a("AndroidQSDStorage|saveSession() isCreated = " + mkdirs, new Object[0]);
            }
        }
    }

    public void a(Context context, String str) {
        if (e(context) && !TextUtils.isEmpty(str)) {
            String a2 = a(str);
            File file = new File(this.c + "di");
            File file2 = new File(file.getAbsolutePath() + InternalZipConstants.ZIP_FILE_SEPARATOR + a2);
            if (!file2.exists()) {
                boolean mkdirs = file2.mkdirs();
                if (mkdirs) {
                    com.igexin.push.util.d.a(file, a2);
                }
                b.a("AndroidQSDStorage|saveDeviceId() isCreated = " + mkdirs, new Object[0]);
            }
        }
    }

    public String b(Context context) {
        if (!e(context)) {
            return null;
        }
        d(context);
        File file = new File(this.d + c.a);
        if (!file.exists()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            b.a("AndroidQSDStorage|getCid() childs = NULL", new Object[0]);
            return null;
        }
        File file2 = listFiles[0];
        try {
            return b(file2.getName());
        } catch (Throwable unused) {
            file2.delete();
            return null;
        }
    }

    public void b(Context context, String str) {
        if (e(context)) {
            d(context);
            File file = new File(this.d + c.a);
            if (TextUtils.isEmpty(str)) {
                com.igexin.push.util.d.a(file, new String[0]);
                return;
            }
            String a2 = a(str);
            File file2 = new File(file.getAbsolutePath() + InternalZipConstants.ZIP_FILE_SEPARATOR + a2);
            if (!file2.exists()) {
                boolean mkdirs = file2.mkdirs();
                if (mkdirs) {
                    com.igexin.push.util.d.a(file, a2);
                }
                b.a("AndroidQSDStorage|saveCid() isCreated = " + mkdirs, new Object[0]);
            }
        }
    }

    public long c(Context context) {
        if (!e(context)) {
            return 0;
        }
        d(context);
        File file = new File(this.d + "ss");
        if (!file.exists()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            b.a("AndroidQSDStorage|getSession() childs = NULL", new Object[0]);
            return 0;
        }
        File file2 = listFiles[0];
        try {
            return Long.parseLong(b(file2.getName()));
        } catch (Throwable unused) {
            file2.delete();
            return 0;
        }
    }
}
