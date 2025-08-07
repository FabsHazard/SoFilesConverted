package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Code39Reader */
public final class t0 extends g5 {
    public static final int[] e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};
    private final boolean a;
    private final boolean b;
    private final StringBuilder c;
    private final int[] d;

    public t0() {
        this(false);
    }

    private static boolean b(int[] iArr) {
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 < i) {
                i = i3;
            }
            if (i3 > i2) {
                i2 = i3;
            }
        }
        if (i2 / i > 6) {
            return true;
        }
        return false;
    }

    private static int c(int[] iArr) {
        int length = iArr.length;
        if (b(iArr)) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i6 |= 1 << ((length - 1) - i7);
                    i4++;
                    i5 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if (i10 * 2 >= i5) {
                            return -1;
                        }
                    }
                }
                return i6;
            } else if (i4 <= 3) {
                return -1;
            } else {
                i = i2;
            }
        }
    }

    public s6 a(int i, r rVar, Map<l1, ?> map) throws a {
        int[] iArr = this.d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.c;
        sb.setLength(0);
        int[] a2 = a(rVar, iArr);
        int c2 = rVar.c(a2[1]);
        int e2 = rVar.e();
        while (true) {
            g5.a(rVar, c2, iArr);
            int c3 = c(iArr);
            if (c3 >= 0) {
                char a3 = a(c3);
                sb.append(a3);
                int i2 = c2;
                for (int i3 : iArr) {
                    i2 += i3;
                }
                int c4 = rVar.c(i2);
                if (a3 == '*') {
                    sb.setLength(sb.length() - 1);
                    int i4 = 0;
                    for (int i5 : iArr) {
                        i4 += i5;
                    }
                    int i6 = (c4 - c2) - i4;
                    if (c4 == e2 || i6 * 5 >= i4) {
                        return a(sb, a2, c2, i4, i);
                    }
                    throw a.a();
                }
                c2 = c4;
            } else {
                throw a.a();
            }
        }
    }

    public t0(boolean z) {
        this(z, false);
    }

    public t0(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.c = new StringBuilder(20);
        this.d = new int[9];
    }

    private s6 a(StringBuilder sb, int[] iArr, int i, int i2, int i3) throws a {
        String str;
        if (this.a) {
            int length = sb.length() - 1;
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                i4 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.c.charAt(i5));
            }
            if (sb.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i4 % 43)) {
                sb.setLength(length);
            } else {
                throw a.a();
            }
        }
        if (sb.length() != 0) {
            if (this.b) {
                str = a((CharSequence) sb);
            } else {
                str = sb.toString();
            }
            float f = (float) i3;
            return new s6(str, (byte[]) null, new u6[]{new u6((float) iArr[0], f), new u6((float) (i + i2), f)}, BarcodeFormat.CODE_39);
        }
        throw a.a();
    }

    private static int[] a(r rVar, int[] iArr) throws a {
        int e2 = rVar.e();
        int c2 = rVar.c(0);
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = c2;
        while (c2 < e2) {
            if (rVar.b(c2) == z) {
                if (i != length - 1) {
                    i++;
                } else if (c(iArr) == 148 && rVar.a(Math.max(0, i2 - ((c2 - i2) / 5)), i2, false, true)) {
                    return new int[]{i2, c2};
                } else {
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            } else if (i < 0 || i >= iArr.length) {
                throw a.a();
            } else {
                iArr[i] = iArr[i] + 1;
            }
            c2++;
        }
        throw a.a();
    }

    private static char a(int i) throws a {
        int i2 = 0;
        while (true) {
            int[] iArr = e;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i2);
                }
                i2++;
            } else if (i == 148) {
                return '*';
            } else {
                throw a.a();
            }
        }
    }

    private static String a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i++;
                sb.append(a(charAt, charSequence.charAt(i)));
            } else {
                sb.append(charAt);
            }
            i++;
        }
        return sb.toString();
    }

    private static char a(char c2, char c3) throws a {
        int i;
        if (c2 != '$') {
            if (c2 != '%') {
                if (c2 != '+') {
                    if (c2 == '/') {
                        if (c3 >= 'A' && c3 <= 'O') {
                            i = c3 - ' ';
                        } else if (c3 == 'Z') {
                            return ':';
                        } else {
                            throw a.a();
                        }
                    }
                } else if (c3 < 'A' || c3 > 'Z') {
                    throw a.a();
                } else {
                    i = c3 + ' ';
                }
            } else if (c3 >= 'A' && c3 <= 'E') {
                i = c3 - '&';
            } else if (c3 >= 'F' && c3 <= 'J') {
                i = c3 - 11;
            } else if (c3 >= 'K' && c3 <= 'O') {
                i = c3 + 16;
            } else if (c3 >= 'P' && c3 <= 'T') {
                i = c3 + '+';
            } else if (c3 != 'U') {
                if (c3 == 'V') {
                    return '@';
                }
                if (c3 == 'W') {
                    return '`';
                }
                if (c3 == 'X' || c3 == 'Y' || c3 == 'Z') {
                    return 127;
                }
                throw a.a();
            }
            return 0;
        } else if (c3 < 'A' || c3 > 'Z') {
            throw a.a();
        } else {
            i = c3 - '@';
        }
        return (char) i;
    }
}
