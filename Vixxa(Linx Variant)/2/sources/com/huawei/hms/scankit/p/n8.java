package com.huawei.hms.scankit.p;

/* compiled from: X12Encoder */
final class n8 extends d0 {
    n8() {
    }

    public int a() {
        return 3;
    }

    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            char c = y2Var.c();
            y2Var.f++;
            a(c, sb);
            if (sb.length() % 3 == 0) {
                d0.b(y2Var, sb);
                if (d4.a(y2Var.d(), y2Var.f, a()) != a()) {
                    y2Var.b(0);
                    break;
                }
            }
        }
        a(y2Var, sb);
    }

    /* access modifiers changed from: package-private */
    public int a(char c, StringBuilder sb) {
        if (c == 13) {
            sb.append(0);
        } else if (c == ' ') {
            sb.append(3);
        } else if (c == '*') {
            sb.append(1);
        } else if (c == '>') {
            sb.append(2);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
        } else if (c < 'A' || c > 'Z') {
            d4.a(c);
        } else {
            sb.append((char) (c - '3'));
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void a(y2 y2Var, StringBuilder sb) {
        y2Var.l();
        int a = y2Var.g().a() - y2Var.a();
        y2Var.f -= sb.length();
        if (y2Var.f() > 1 || a > 1 || y2Var.f() != a) {
            y2Var.a(254);
        }
        if (y2Var.e() < 0) {
            y2Var.b(0);
        }
    }
}
