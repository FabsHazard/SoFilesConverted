package com.huawei.hms.scankit.p;

/* compiled from: TextEncoder */
final class g7 extends d0 {
    g7() {
    }

    public int a() {
        return 2;
    }

    /* access modifiers changed from: package-private */
    public int a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        } else if (c >= 'a' && c <= 'z') {
            sb.append((char) (c - 'S'));
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
        } else if (c == '`') {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append(2);
            sb.append((char) (c - '@'));
            return 2;
        } else if (c < '{' || c > 127) {
            sb.append("\u0001\u001e");
            return a((char) (c - 128), sb) + 2;
        } else {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        }
    }
}
