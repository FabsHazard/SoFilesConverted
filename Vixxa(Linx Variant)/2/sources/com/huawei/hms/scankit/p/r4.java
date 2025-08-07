package com.huawei.hms.scankit.p;

/* compiled from: MaskUtil */
final class r4 {
    static int a(c0 c0Var) {
        return a(c0Var, true) + a(c0Var, false);
    }

    static int b(c0 c0Var) {
        byte[][] a = c0Var.a();
        int c = c0Var.c();
        int b = c0Var.b();
        int i = 0;
        for (int i2 = 0; i2 < b - 1; i2++) {
            byte[] bArr = a[i2];
            int i3 = 0;
            while (i3 < c - 1) {
                byte b2 = bArr[i3];
                int i4 = i3 + 1;
                if (b2 == bArr[i4]) {
                    byte[] bArr2 = a[i2 + 1];
                    if (b2 == bArr2[i3] && b2 == bArr2[i4]) {
                        i++;
                    }
                }
                i3 = i4;
            }
        }
        return i * 3;
    }

    static int c(c0 c0Var) {
        byte[][] a = c0Var.a();
        int c = c0Var.c();
        int b = c0Var.b();
        int i = 0;
        for (int i2 = 0; i2 < b; i2++) {
            for (int i3 = 0; i3 < c; i3++) {
                byte[] bArr = a[i2];
                int i4 = i3 + 6;
                if (i4 < c && bArr[i3] == 1 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 1 && bArr[i3 + 3] == 1 && bArr[i3 + 4] == 1 && bArr[i3 + 5] == 0 && bArr[i4] == 1 && (a(bArr, i3 - 4, i3) || a(bArr, i3 + 7, i3 + 11))) {
                    i++;
                }
                int i5 = i2 + 6;
                if (i5 < b && a[i2][i3] == 1 && a[i2 + 1][i3] == 0 && a[i2 + 2][i3] == 1 && a[i2 + 3][i3] == 1 && a[i2 + 4][i3] == 1 && a[i2 + 5][i3] == 0 && a[i5][i3] == 1 && (a(a, i3, i2 - 4, i2) || a(a, i3, i2 + 7, i2 + 11))) {
                    i++;
                }
            }
        }
        return i * 40;
    }

    static int d(c0 c0Var) {
        byte[][] a = c0Var.a();
        int c = c0Var.c();
        int b = c0Var.b();
        int i = 0;
        for (int i2 = 0; i2 < b; i2++) {
            byte[] bArr = a[i2];
            for (int i3 = 0; i3 < c; i3++) {
                if (bArr[i3] == 1) {
                    i++;
                }
            }
        }
        int b2 = c0Var.b() * c0Var.c();
        return ((Math.abs((i * 2) - b2) * 10) / b2) * 10;
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, bArr.length);
        for (int max = Math.max(i, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (max < bArr.length && i < bArr[0].length && bArr[max][i] == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r4 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        r2 = r4 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r2 != 0) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r2 = r2 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(int r2, int r3, int r4) {
        /*
            java.lang.String r0 = "Invalid mask pattern: "
            r1 = 1
            switch(r2) {
                case 0: goto L_0x002d;
                case 1: goto L_0x002e;
                case 2: goto L_0x002a;
                case 3: goto L_0x0026;
                case 4: goto L_0x0021;
                case 5: goto L_0x001a;
                case 6: goto L_0x0012;
                case 7: goto L_0x0009;
                default: goto L_0x0006;
            }
        L_0x0006:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            goto L_0x0035
        L_0x0009:
            int r2 = r4 * r3
            int r2 = r2 % 3
            int r4 = r4 + r3
            r3 = r4 & 1
            int r2 = r2 + r3
            goto L_0x0018
        L_0x0012:
            int r4 = r4 * r3
            r2 = r4 & 1
            int r4 = r4 % 3
            int r2 = r2 + r4
        L_0x0018:
            r2 = r2 & r1
            goto L_0x0030
        L_0x001a:
            int r4 = r4 * r3
            r2 = r4 & 1
            int r4 = r4 % 3
            int r2 = r2 + r4
            goto L_0x0030
        L_0x0021:
            int r4 = r4 / 2
            int r3 = r3 / 3
            goto L_0x002d
        L_0x0026:
            int r4 = r4 + r3
            int r2 = r4 % 3
            goto L_0x0030
        L_0x002a:
            int r2 = r3 % 3
            goto L_0x0030
        L_0x002d:
            int r4 = r4 + r3
        L_0x002e:
            r2 = r4 & 1
        L_0x0030:
            if (r2 != 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            return r1
        L_0x0035:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r2 = r2.toString()
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r4.a(int, int, int):boolean");
    }

    private static int a(c0 c0Var, boolean z) {
        int b = z ? c0Var.b() : c0Var.c();
        int c = z ? c0Var.c() : c0Var.b();
        byte[][] a = c0Var.a();
        int i = 0;
        for (int i2 = 0; i2 < b; i2++) {
            byte b2 = -1;
            int i3 = 0;
            for (int i4 = 0; i4 < c; i4++) {
                byte b3 = z ? a[i2][i4] : a[i4][i2];
                if (b3 == b2) {
                    i3++;
                } else {
                    if (i3 >= 5) {
                        i += i3 - 2;
                    }
                    i3 = 1;
                    b2 = b3;
                }
            }
            if (i3 >= 5) {
                i += i3 - 2;
            }
        }
        return i;
    }
}
