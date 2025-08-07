package com.huawei.hms.scankit.p;

/* compiled from: ASCIIEncoder */
final class b implements v2 {
    b() {
    }

    public int a() {
        return 0;
    }

    public void a(y2 y2Var) {
        if (d4.a((CharSequence) y2Var.d(), y2Var.f) >= 2) {
            y2Var.a(a(y2Var.d().charAt(y2Var.f), y2Var.d().charAt(y2Var.f + 1)));
            y2Var.f += 2;
            return;
        }
        char c = y2Var.c();
        int a = d4.a(y2Var.d(), y2Var.f, a());
        if (a != a()) {
            if (a == 1) {
                y2Var.a(230);
                y2Var.b(1);
            } else if (a == 2) {
                y2Var.a(239);
                y2Var.b(2);
            } else if (a == 3) {
                y2Var.a(238);
                y2Var.b(3);
            } else if (a == 4) {
                y2Var.a(240);
                y2Var.b(4);
            } else if (a == 5) {
                y2Var.a(231);
                y2Var.b(5);
            } else {
                throw new IllegalStateException("Illegal mode: " + a);
            }
        } else if (d4.c(c)) {
            y2Var.a(235);
            y2Var.a((char) (c - 127));
            y2Var.f++;
        } else {
            y2Var.a((char) (c + 1));
            y2Var.f++;
        }
    }

    private static char a(char c, char c2) {
        if (d4.b(c) && d4.b(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }
}
