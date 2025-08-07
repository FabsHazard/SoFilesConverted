package com.huawei.hms.scankit.p;

/* compiled from: C40Encoder */
class d0 implements v2 {
    d0() {
    }

    static void b(y2 y2Var, StringBuilder sb) {
        y2Var.a(a((CharSequence) sb, 0));
        sb.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            char c = y2Var.c();
            y2Var.f++;
            int a = a(c, sb);
            int a2 = y2Var.a() + ((sb.length() / 3) * 2);
            y2Var.c(a2);
            int a3 = y2Var.g().a() - a2;
            if (y2Var.i()) {
                if (sb.length() % 3 == 0 && d4.a(y2Var.d(), y2Var.f, a()) != a()) {
                    y2Var.b(0);
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (a3 < 2 || a3 > 2)) {
                    a = a(y2Var, sb, sb2, a);
                }
                while (sb.length() % 3 == 1 && ((a <= 3 && a3 != 1) || a > 3)) {
                    a = a(y2Var, sb, sb2, a);
                }
            }
        }
        a(y2Var, sb);
    }

    private int a(y2 y2Var, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        y2Var.f--;
        int a = a(y2Var.c(), sb2);
        y2Var.k();
        return a;
    }

    /* access modifiers changed from: package-private */
    public void a(y2 y2Var, StringBuilder sb) {
        int length = sb.length() % 3;
        int a = y2Var.a() + ((sb.length() / 3) * 2);
        y2Var.c(a);
        int a2 = y2Var.g().a() - a;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (y2Var.i()) {
                y2Var.a(254);
            }
        } else if (a2 == 1 && length == 1) {
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (y2Var.i()) {
                y2Var.a(254);
            }
            y2Var.f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (a2 > 0 || y2Var.i()) {
                y2Var.a(254);
            }
        } else {
            try {
                throw new IllegalStateException("Unexpected case. Please report!");
            } catch (Exception unused) {
                o4.b("exception", "Exception");
            }
        }
        y2Var.b(0);
    }

    /* access modifiers changed from: package-private */
    public int a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        } else if (c < ' ') {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append(1);
            sb.append((char) (c - '+'));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append(1);
            sb.append((char) (c - 'E'));
            return 2;
        } else if (c < '`' || c > 127) {
            sb.append("\u0001\u001e");
            return a((char) (c - 128), sb) + 2;
        } else {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        }
    }

    private static String a(CharSequence charSequence, int i) {
        int charAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
