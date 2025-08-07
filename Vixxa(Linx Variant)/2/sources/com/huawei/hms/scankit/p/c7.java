package com.huawei.hms.scankit.p;

import java.nio.charset.Charset;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: StringUtils */
public final class c7 {
    private static final String a;
    private static final boolean b;

    static {
        String name = Charset.defaultCharset().name();
        a = name;
        b = "SJIS".equalsIgnoreCase(name) || "EUC_JP".equalsIgnoreCase(name);
    }

    public static String a(byte[] bArr, Map<l1, ?> map) {
        int i;
        byte[] bArr2 = bArr;
        Map<l1, ?> map2 = map;
        if (map2 != null) {
            l1 l1Var = l1.CHARACTER_SET;
            if (map2.containsKey(l1Var)) {
                return map2.get(l1Var).toString();
            }
        }
        int[] iArr = new int[15];
        boolean z = false;
        iArr[0] = bArr2.length;
        iArr[1] = 1;
        iArr[2] = 1;
        iArr[3] = 1;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i2 = 0;
        while (true) {
            i = iArr[0];
            if (i2 < i && (iArr[1] == 1 || iArr[2] == 1 || iArr[3] == 1)) {
                byte b2 = bArr2[i2] & UByte.MAX_VALUE;
                c(b2, iArr);
                b(b2, iArr);
                a((int) b2, iArr);
                i2++;
            }
        }
        boolean z3 = iArr[3] == 1;
        boolean z4 = iArr[2] == 1;
        if (iArr[1] == 1) {
            z = true;
        }
        return a(bArr, z3, z4, z, iArr[4], iArr[8], z2, iArr[5], iArr[6], iArr[7], iArr[12], iArr[13], iArr[9], iArr[14], i);
    }

    private static void b(int i, int[] iArr) {
        if (iArr[2] == 1) {
            int i2 = iArr[8];
            if (i2 > 0) {
                if (i < 64 || i == 127 || i > 252) {
                    iArr[2] = 0;
                } else {
                    iArr[8] = i2 - 1;
                }
            } else if (i == 128 || i == 160 || i > 239) {
                iArr[2] = 0;
            } else if (i > 160 && i < 224) {
                iArr[9] = iArr[9] + 1;
                iArr[11] = 0;
                int i3 = iArr[10] + 1;
                iArr[10] = i3;
                if (i3 > iArr[12]) {
                    iArr[12] = i3;
                }
            } else if (i > 127) {
                iArr[8] = i2 + 1;
                iArr[10] = 0;
                int i4 = iArr[11] + 1;
                iArr[11] = i4;
                if (i4 > iArr[13]) {
                    iArr[13] = i4;
                }
            } else {
                iArr[10] = 0;
                iArr[11] = 0;
            }
        }
    }

    private static void c(int i, int[] iArr) {
        if (iArr[3] == 1) {
            int i2 = iArr[4];
            if (i2 > 0) {
                if ((i & 128) == 0) {
                    iArr[3] = 0;
                } else {
                    iArr[4] = i2 - 1;
                }
            } else if ((i & 128) == 0) {
            } else {
                if ((i & 64) == 0) {
                    iArr[3] = 0;
                    return;
                }
                iArr[4] = i2 + 1;
                if ((i & 32) == 0) {
                    iArr[5] = iArr[5] + 1;
                    return;
                }
                iArr[4] = i2 + 2;
                if ((i & 16) == 0) {
                    iArr[6] = iArr[6] + 1;
                    return;
                }
                iArr[4] = i2 + 3;
                if ((i & 8) == 0) {
                    iArr[7] = iArr[7] + 1;
                } else {
                    iArr[3] = 0;
                }
            }
        }
    }

    private static void a(int i, int[] iArr) {
        if (iArr[1] != 1) {
            return;
        }
        if (i > 127 && i < 160) {
            iArr[1] = 0;
        } else if (i <= 159) {
        } else {
            if (i < 192 || i == 215 || i == 247) {
                iArr[14] = iArr[14] + 1;
            }
        }
    }

    public static String a(byte[] bArr, boolean z, boolean z2, boolean z3, int i, int i2, boolean z4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (z && i > 0) {
            z = false;
        }
        if (z2 && i2 > 0) {
            z2 = false;
        }
        if (z && (z4 || i3 + i4 + i5 > 0)) {
            return "UTF8";
        }
        if (a(bArr).booleanValue()) {
            return "GBK";
        }
        if (z2 && (b || i6 >= 3 || i7 >= 3)) {
            return "SJIS";
        }
        if (!z3 || !z2) {
            if (z3 && i9 * 10 < i10) {
                return "ISO8859_1";
            }
            if (z2) {
                return "SJIS";
            }
            if (z) {
                return "UTF8";
            }
            if (z || !"UTF-8".equals(a)) {
                return a;
            }
            return "GB2312";
        } else if ((i6 != 2 || i8 != 2) && i9 * 10 < i10) {
            return "ISO8859_1";
        } else {
            return "SJIS";
        }
    }

    public static Boolean a(byte[] bArr) {
        int length = bArr.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            byte b2 = bArr[i];
            if ((b2 & ByteCompanionObject.MIN_VALUE) != 0) {
                byte b3 = b2 & UByte.MAX_VALUE;
                if ((b3 >= 170 || b3 <= 160) && (b3 >= 248 || b3 <= 175)) {
                    if (b3 >= 161 || b3 <= 128) {
                        if (((b3 >= 255 || b3 <= 169) && (b3 >= 170 || b3 <= 167)) || (i = i + 1) >= length) {
                            break;
                        }
                        byte b4 = bArr[i];
                        if ((b4 & UByte.MAX_VALUE) >= 161 || (b4 & UByte.MAX_VALUE) <= 63 || (b4 & UByte.MAX_VALUE) == Byte.MAX_VALUE) {
                            break;
                        }
                    } else {
                        i++;
                        if (i >= length) {
                            break;
                        }
                        byte b5 = bArr[i];
                        if ((b5 & UByte.MAX_VALUE) >= 255 || (b5 & UByte.MAX_VALUE) <= 63 || (b5 & UByte.MAX_VALUE) == Byte.MAX_VALUE) {
                            break;
                        }
                    }
                } else {
                    i++;
                    if (i >= length) {
                        break;
                    }
                    byte b6 = bArr[i];
                    if ((b6 & UByte.MAX_VALUE) >= 255 || (b6 & UByte.MAX_VALUE) <= 160 || (b6 & UByte.MAX_VALUE) == Byte.MAX_VALUE) {
                        break;
                    }
                }
            }
            i++;
        }
        return Boolean.valueOf(z);
    }
}
