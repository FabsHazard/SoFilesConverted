package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

public class j {
    private static j b;
    private Context a;

    private static class a extends e0 {
        String a;
        String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public String a() {
            return z.d(this.a, this.b);
        }

        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }

        public String b() {
            return z.g(this.a, this.b);
        }

        public String c() {
            return z.j(this.a, this.b);
        }

        public int d() {
            char c = 0;
            char c2 = z.k(this.a, this.b) ? (char) 4 : 0;
            if (z.e(this.a, this.b)) {
                c = 2;
            }
            return (c2 | c) | z.h(this.a, this.b) ? 1 : 0;
        }
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            if (b == null) {
                b = new j();
            }
            jVar = b;
        }
        return jVar;
    }

    public String a(String str, String str2) {
        return i0.a(this.a, str, str2);
    }

    public String a(boolean z) {
        if (!z) {
            return "";
        }
        String e = q0.e();
        if (TextUtils.isEmpty(e)) {
            e = d.a(this.a, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(e)) {
                e = UUID.randomUUID().toString().replace("-", "");
                d.b(this.a, "global_v2", "uuid", e);
            }
            q0.h(e);
        }
        return e;
    }

    public void a(Context context) {
        if (this.a == null) {
            this.a = context;
        }
    }

    public String b(String str, String str2) {
        return i0.b(this.a, str, str2);
    }

    public i c(String str, String str2) {
        return new a(str, str2).a(this.a);
    }

    public String d(String str, String str2) {
        return f1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (!z.f(str, str2)) {
            return new Pair<>("", "");
        }
        String p = s.c().b().p();
        String q = s.c().b().q();
        if (!TextUtils.isEmpty(p) && !TextUtils.isEmpty(q)) {
            return new Pair<>(p, q);
        }
        Pair<String, String> e = x0.e(this.a);
        s.c().b().k((String) e.first);
        s.c().b().l((String) e.second);
        return e;
    }

    public String f(String str, String str2) {
        return f1.a(str, str2);
    }
}
