package com.huawei.hms.scankit.p;

/* compiled from: EdifactEncoder */
final class s2 implements v2 {
    s2() {
    }

    public int a() {
        return 4;
    }

    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            a(y2Var.c(), sb);
            y2Var.f++;
            if (sb.length() >= 4) {
                y2Var.a(a((CharSequence) sb, 0));
                sb.delete(0, 4);
                if (d4.a(y2Var.d(), y2Var.f, a()) != a()) {
                    y2Var.b(0);
                    break;
                }
            }
        }
        sb.append(31);
        a(y2Var, (CharSequence) sb);
    }

    private static void a(y2 y2Var, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z = true;
                if (length == 1) {
                    y2Var.l();
                    int a = y2Var.g().a() - y2Var.a();
                    int f = y2Var.f();
                    if (f > a) {
                        y2Var.c(y2Var.a() + 1);
                        a = y2Var.g().a() - y2Var.a();
                    }
                    if (f <= a && a <= 2) {
                        y2Var.b(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i = length - 1;
                    String a2 = a(charSequence, 0);
                    if (y2Var.i() || i > 2) {
                        z = false;
                    }
                    if (i <= 2) {
                        y2Var.c(y2Var.a() + i);
                        if (y2Var.g().a() - y2Var.a() >= 3) {
                            y2Var.c(y2Var.a() + a2.length());
                            z = false;
                        }
                    }
                    if (z) {
                        y2Var.k();
                        y2Var.f -= i;
                    } else {
                        y2Var.a(a2);
                    }
                    y2Var.b(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            y2Var.b(0);
        }
    }

    private static void a(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            d4.a(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    private static String a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            char charAt = charSequence.charAt(i);
            char c = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i + 2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(i + 3);
            }
            int i2 = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c;
            char c2 = (char) ((i2 >> 8) & 255);
            char c3 = (char) (i2 & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i2 >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
