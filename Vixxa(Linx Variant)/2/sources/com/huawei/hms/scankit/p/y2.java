package com.huawei.hms.scankit.p;

import java.nio.charset.StandardCharsets;
import kotlin.UByte;

/* compiled from: EncoderContext */
final class y2 {
    private final String a;
    private e7 b;
    private l2 c;
    private l2 d;
    private final StringBuilder e;
    int f;
    private int g;
    private d7 h;
    private int i;

    y2(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        int i2 = 0;
        while (i2 < length) {
            char c2 = (char) (bytes[i2] & UByte.MAX_VALUE);
            if (c2 != '?' || str.charAt(i2) == '?') {
                sb.append(c2);
                i2++;
            } else {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
        }
        this.a = sb.toString();
        this.b = e7.FORCE_NONE;
        this.e = new StringBuilder(str.length());
        this.g = -1;
    }

    private int h() {
        return this.a.length() - this.i;
    }

    public void a(e7 e7Var) {
        this.b = e7Var;
    }

    public StringBuilder b() {
        return this.e;
    }

    public char c() {
        return this.a.charAt(this.f);
    }

    public String d() {
        return this.a;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return h() - this.f;
    }

    public d7 g() {
        return this.h;
    }

    public boolean i() {
        return this.f < h();
    }

    public void j() {
        this.g = -1;
    }

    public void k() {
        this.h = null;
    }

    public void l() {
        c(a());
    }

    public void a(l2 l2Var, l2 l2Var2) {
        this.c = l2Var;
        this.d = l2Var2;
    }

    public void b(int i2) {
        this.g = i2;
    }

    public void c(int i2) {
        d7 d7Var = this.h;
        if (d7Var == null || i2 > d7Var.a()) {
            this.h = d7.a(i2, this.b, this.c, this.d, true);
        }
    }

    public void a(int i2) {
        this.i = i2;
    }

    public void a(String str) {
        this.e.append(str);
    }

    public void a(char c2) {
        this.e.append(c2);
    }

    public int a() {
        return this.e.length();
    }
}
