package com.huawei.hms.scankit.p;

import java.util.Arrays;

/* compiled from: HighLevelEncoder */
public final class d4 {
    private static char a(char c, int i) {
        int i2 = c + ((i * 149) % 253) + 1;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    static boolean b(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean c(char c) {
        return c >= 128 && c <= 255;
    }

    private static boolean d(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean e(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean f(char c) {
        return c == ' ' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    private static boolean g(char c) {
        return i(c) || c == ' ' || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private static boolean h(char c) {
        return false;
    }

    private static boolean i(char c) {
        return c == 13 || c == '*' || c == '>';
    }

    public static String a(String str, e7 e7Var, l2 l2Var, l2 l2Var2) {
        int i = 0;
        v2[] v2VarArr = {new b(), new d0(), new g7(), new n8(), new s2(), new n()};
        y2 y2Var = new y2(str);
        y2Var.a(e7Var);
        y2Var.a(l2Var, l2Var2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            y2Var.a(236);
            y2Var.a(2);
            y2Var.f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            y2Var.a(237);
            y2Var.a(2);
            y2Var.f += 7;
        }
        while (y2Var.i()) {
            if (i >= 0 && i < 6) {
                v2VarArr[i].a(y2Var);
            }
            if (y2Var.e() >= 0) {
                i = y2Var.e();
                y2Var.j();
            }
        }
        int a = y2Var.a();
        y2Var.l();
        int a2 = y2Var.g().a();
        if (!(a >= a2 || i == 0 || i == 5 || i == 4)) {
            y2Var.a(254);
        }
        StringBuilder b = y2Var.b();
        if (b.length() < a2) {
            b.append(129);
        }
        while (b.length() < a2) {
            b.append(a(129, b.length() + 1));
        }
        return y2Var.b().toString();
    }

    static int a(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        int i3;
        int i4;
        CharSequence charSequence2 = charSequence;
        int i5 = i;
        if (i5 >= charSequence.length()) {
            return i2;
        }
        float f = 2.0f;
        int i6 = 6;
        int i7 = 4;
        int i8 = 3;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i9 = 0;
        while (true) {
            int i10 = i5 + i9;
            if (i10 == charSequence.length()) {
                byte[] bArr = new byte[i6];
                int[] iArr = new int[i6];
                int a = a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int a2 = a(bArr);
                if (w7.a(iArr, 0) && iArr[0] == a) {
                    return 0;
                }
                if (a2 == 1 && w7.a(bArr, 5) && bArr[5] > 0) {
                    return 5;
                }
                if (a2 == 1 && w7.a(bArr, i7) && bArr[i7] > 0) {
                    return i7;
                }
                if (a2 == 1 && w7.a(bArr, 2) && bArr[2] > 0) {
                    return 2;
                }
                if (a2 != 1 || !w7.a(bArr, i8) || bArr[i8] <= 0) {
                    return 1;
                }
                return i8;
            }
            char charAt = charSequence2.charAt(i10);
            i9++;
            if (b(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (c(charAt)) {
                float ceil = (float) Math.ceil((double) fArr[0]);
                fArr[0] = ceil;
                fArr[0] = ceil + f;
            } else {
                float ceil2 = (float) Math.ceil((double) fArr[0]);
                fArr[0] = ceil2;
                fArr[0] = ceil2 + 1.0f;
            }
            if (1 < fArr.length) {
                if (d(charAt)) {
                    fArr[1] = fArr[1] + 0.6666667f;
                } else if (c(charAt)) {
                    fArr[1] = fArr[1] + 2.6666667f;
                } else {
                    fArr[1] = fArr[1] + 1.3333334f;
                }
            }
            if (2 < fArr.length) {
                if (f(charAt)) {
                    fArr[2] = fArr[2] + 0.6666667f;
                } else if (c(charAt)) {
                    fArr[2] = fArr[2] + 2.6666667f;
                } else {
                    fArr[2] = fArr[2] + 1.3333334f;
                }
            }
            if (3 < fArr.length) {
                if (g(charAt)) {
                    fArr[3] = fArr[3] + 0.6666667f;
                } else if (c(charAt)) {
                    fArr[3] = fArr[3] + 4.3333335f;
                } else {
                    fArr[3] = fArr[3] + 3.3333333f;
                }
            }
            if (4 < fArr.length) {
                if (e(charAt)) {
                    fArr[4] = fArr[4] + 0.75f;
                } else if (c(charAt)) {
                    fArr[4] = fArr[4] + 4.25f;
                } else {
                    fArr[4] = fArr[4] + 3.25f;
                }
            }
            if (5 < fArr.length) {
                if (h(charAt)) {
                    fArr[5] = fArr[5] + 4.0f;
                } else {
                    fArr[5] = fArr[5] + 1.0f;
                }
            }
            if (i9 >= 4) {
                int[] iArr2 = new int[i6];
                byte[] bArr2 = new byte[i6];
                a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int a3 = a(bArr2);
                int i11 = iArr2[0];
                int i12 = iArr2[5];
                if (i11 >= i12 || i11 >= iArr2[1] || i11 >= iArr2[2] || i11 >= iArr2[3] || i11 >= iArr2[4]) {
                    if (i12 < i11) {
                        break;
                    }
                    byte b = bArr2[1];
                    byte b2 = bArr2[2];
                    byte b3 = bArr2[3];
                    byte b4 = bArr2[4];
                    if (b + b2 + b3 + b4 == 0) {
                        break;
                    } else if (a3 == 1 && b4 > 0) {
                        return 4;
                    } else {
                        if (a3 == 1 && b2 > 0) {
                            return 2;
                        }
                        if (a3 == 1 && b3 > 0) {
                            return 3;
                        }
                        int i13 = iArr2[1];
                        if (i13 + 1 >= i11 || i13 + 1 >= i12) {
                            i4 = 3;
                            i3 = 4;
                            i7 = i3;
                            i6 = 6;
                            i8 = i4;
                            f = 2.0f;
                        } else {
                            i3 = 4;
                            if (i13 + 1 < iArr2[4] && i13 + 1 < iArr2[2]) {
                                int i14 = iArr2[3];
                                if (i13 < i14) {
                                    return 1;
                                }
                                if (i13 == i14) {
                                    for (int i15 = i5 + i9 + 1; i15 < charSequence.length(); i15++) {
                                        char charAt2 = charSequence2.charAt(i15);
                                        if (i(charAt2)) {
                                            return 3;
                                        }
                                        if (!g(charAt2)) {
                                            break;
                                        }
                                    }
                                    return 1;
                                }
                            }
                        }
                    }
                } else {
                    return 0;
                }
            } else {
                i3 = 4;
            }
            i4 = 3;
            i7 = i3;
            i6 = 6;
            i8 = i4;
            f = 2.0f;
        }
        return 5;
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i2 = 0; i2 < 6; i2++) {
            int ceil = (int) Math.ceil((double) fArr[i2]);
            iArr[i2] = ceil;
            if (i > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i = ceil;
            }
            if (i == ceil) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    private static int a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    public static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (b(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    static void a(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
