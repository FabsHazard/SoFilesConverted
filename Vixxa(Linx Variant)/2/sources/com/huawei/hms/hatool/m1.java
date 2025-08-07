package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class m1 {
    private static m1 b = new m1();
    /* access modifiers changed from: private */
    public a a = new a();

    class a {
        String a;
        String b;
        long c = 0;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            m1.this.a.c = j;
        }

        /* access modifiers changed from: package-private */
        public void a(String str) {
            m1.this.a.b = str;
        }

        /* access modifiers changed from: package-private */
        public void b(String str) {
            m1.this.a.a = str;
        }
    }

    public static m1 d() {
        return b;
    }

    public String a() {
        return this.a.b;
    }

    public void a(String str, String str2) {
        long b2 = b();
        String b3 = w0.b(str, str2);
        if (b3 == null || b3.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b2 == 0) {
            b2 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b2 <= 43200000) {
            return;
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String a2 = h0.a(b3, generateSecureRandomStr);
        this.a.a(b2);
        this.a.b(generateSecureRandomStr);
        this.a.a(a2);
    }

    public long b() {
        return this.a.c;
    }

    public String c() {
        return this.a.a;
    }
}
