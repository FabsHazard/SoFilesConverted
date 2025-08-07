package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

public class k extends u0 {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huawei.hms.hatool.d0[] r0 = com.huawei.hms.hatool.d0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.hatool.d0 r1 = com.huawei.hms.hatool.d0.SN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.hatool.d0 r1 = com.huawei.hms.hatool.d0.IMEI     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.hatool.d0 r1 = com.huawei.hms.hatool.d0.UDID     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.k.a.<clinit>():void");
        }
    }

    protected static f0 a(String str, String str2, String str3, String str4) {
        f0 a2 = u0.a(str, str2, str3, str4);
        String a3 = j.a().a(a1.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(q0.f() + a3 + currentTimeMillis);
        a2.f(String.valueOf(currentTimeMillis));
        a2.g(sha256Encrypt);
        return a2;
    }

    public static h1 a(List<b1> list, String str, String str2, String str3, String str4) {
        v.c("hmsSdk", "generate UploadData");
        h1 b = u0.b(str, str2);
        if (b == null) {
            return null;
        }
        b.a((k0) a(m1.d().a(), str, str2, str3));
        b.a(a(str, str2));
        b.a((t0) a(str2, str, str4));
        b.a(a1.g(str, str2));
        b.a(list);
        return b;
    }

    protected static l a(String str, String str2) {
        l a2 = u0.a(str, str2);
        i c = j.a().c(str, str2);
        a2.g(j.a().a(a1.c(str, str2)));
        a2.f(a1.o(str, str2));
        a2.c(j.a().f(str, str2));
        int i = a.a[c.a().ordinal()];
        if (i == 1) {
            a2.d(c.b());
        } else if (i == 2) {
            a2.b(c.b());
        } else if (i == 3) {
            a2.e(c.b());
        }
        return a2;
    }

    protected static y0 a(String str, String str2, String str3) {
        y0 a2 = u0.a(str, str2, str3);
        Pair<String, String> e = j.a().e(str2, str);
        a2.f((String) e.first);
        a2.g((String) e.second);
        a2.h(o.b());
        a2.d(j.a().d(str2, str));
        return a2;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c = u0.c(str, str3);
        Map<String, String> i = a1.i(str, str2);
        if (i == null) {
            return c;
        }
        c.putAll(i);
        return c;
    }
}
