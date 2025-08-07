package com.huawei.hms.scankit.p;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.e.c;
import com.huawei.hms.feature.dynamic.e.e;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.microtech.aidexx.ota.OtaManagerKt;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: Decoder */
public final class s1 {
    private static final String[] b = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, OtaManagerKt.AIDEX_VERSION, "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = {"CTRL_PS", " ", com.huawei.hms.feature.dynamic.e.a.a, "b", c.a, "d", e.a, "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", Logger.c, "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", ContainerUtils.FIELD_DELIMITER, "'", "(", ")", "*", "+", ",", "-", ".", InternalZipConstants.ZIP_FILE_SEPARATOR, ":", ";", "<", ContainerUtils.KEY_VALUE_DELIMITER, ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] f = {"CTRL_PS", " ", "0", "1", "2", "3", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_VIVO, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST, "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    private g a;

    /* compiled from: Decoder */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.hms.scankit.p.s1$b[] r0 = com.huawei.hms.scankit.p.s1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.scankit.p.s1$b r1 = com.huawei.hms.scankit.p.s1.b.UPPER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.scankit.p.s1$b r1 = com.huawei.hms.scankit.p.s1.b.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.scankit.p.s1$b r1 = com.huawei.hms.scankit.p.s1.b.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.scankit.p.s1$b r1 = com.huawei.hms.scankit.p.s1.b.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.scankit.p.s1$b r1 = com.huawei.hms.scankit.p.s1.b.DIGIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.s1.a.<clinit>():void");
        }
    }

    /* compiled from: Decoder */
    private enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private boolean[] b(boolean[] zArr) throws a {
        int i;
        o3 o3Var;
        g gVar = this.a;
        if (gVar != null) {
            if (gVar.f() <= 2) {
                o3Var = o3.j;
                i = 6;
            } else {
                i = 8;
                if (this.a.f() <= 8) {
                    o3Var = o3.n;
                } else if (this.a.f() <= 22) {
                    o3Var = o3.i;
                    i = 10;
                } else {
                    o3Var = o3.h;
                    i = 12;
                }
            }
            int e2 = this.a.e();
            int length = zArr.length / i;
            if (length >= e2) {
                int length2 = zArr.length % i;
                int[] iArr = new int[length];
                int i2 = 0;
                while (i2 < length) {
                    iArr[i2] = a(zArr, length2, i);
                    i2++;
                    length2 += i;
                }
                try {
                    new p6(o3Var).a(iArr, length - e2);
                    return a(e2, i, iArr);
                } catch (a e3) {
                    throw a.a(e3.getMessage());
                }
            } else {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    public w1 a(g gVar, Map<l1, ?> map) throws a {
        this.a = gVar;
        boolean[] b2 = b(a(gVar.a()));
        w1 w1Var = new w1(a(b2), a(b2, map), (List<byte[]>) null, (String) null);
        w1Var.a(b2.length);
        return w1Var;
    }

    private static String a(boolean[] zArr, Map<l1, ?> map) throws a {
        b bVar = b.UPPER;
        StringBuilder a2 = a(zArr, bVar, bVar);
        int length = a2.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) a2.charAt(i);
        }
        try {
            return new String(bArr, c7.a(bArr, map));
        } catch (UnsupportedEncodingException unused) {
            throw a.a();
        }
    }

    private static StringBuilder a(boolean[] zArr, b bVar, b bVar2) {
        int length = zArr.length;
        StringBuilder sb = new StringBuilder(20);
        int i = 0;
        while (i < length) {
            if (bVar2 == b.BINARY) {
                if (length - i >= 5) {
                    int a2 = a(zArr, i, 5);
                    int i2 = i + 5;
                    if (a2 == 0) {
                        if (length - i2 < 11) {
                            break;
                        }
                        a2 = a(zArr, i2, 11) + 31;
                        i2 = i + 16;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= a2) {
                            i = i2;
                            break;
                        } else if (length - i2 < 8) {
                            i = length;
                            break;
                        } else {
                            sb.append((char) a(zArr, i2, 8));
                            i2 += 8;
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            } else {
                int i4 = bVar2 == b.DIGIT ? 4 : 5;
                if (length - i < i4) {
                    break;
                }
                int a3 = a(zArr, i, i4);
                i += i4;
                String a4 = a(bVar2, a3);
                if (a4.startsWith("CTRL_")) {
                    bVar = a(a4.charAt(5));
                    if (a4.charAt(6) != 'L') {
                        b bVar3 = bVar2;
                        bVar2 = bVar;
                        bVar = bVar3;
                    }
                } else {
                    sb.append(a4);
                }
            }
            bVar2 = bVar;
        }
        return sb;
    }

    private static b a(char c2) {
        if (c2 == 'B') {
            return b.BINARY;
        }
        if (c2 == 'D') {
            return b.DIGIT;
        }
        if (c2 == 'P') {
            return b.PUNCT;
        }
        if (c2 == 'L') {
            return b.LOWER;
        }
        if (c2 != 'M') {
            return b.UPPER;
        }
        return b.MIXED;
    }

    private static String a(b bVar, int i) {
        int i2 = a.a[bVar.ordinal()];
        if (i2 == 1) {
            return b[i];
        }
        if (i2 == 2) {
            return c[i];
        }
        if (i2 == 3) {
            return d[i];
        }
        if (i2 == 4) {
            return e[i];
        }
        if (i2 == 5) {
            return f[i];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] a(int i, int i2, int[] iArr) throws a {
        int i3 = 1 << i2;
        int i4 = i3 - 1;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            int i7 = iArr[i6];
            if (i7 == 0 || i7 == i4) {
                throw a.a();
            }
            if (i7 == 1 || i7 == i3 - 2) {
                i5++;
            }
        }
        boolean[] zArr = new boolean[((i * i2) - i5)];
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            int i10 = iArr[i9];
            if (i10 == 1 || i10 == i3 - 2) {
                Arrays.fill(zArr, i8, (i8 + i2) - 1, i10 > 1);
                i8 += i2 - 1;
            } else {
                int i11 = i2 - 1;
                while (i11 >= 0) {
                    int i12 = i8 + 1;
                    zArr[i8] = ((1 << i11) & i10) != 0;
                    i11--;
                    i8 = i12;
                }
            }
        }
        return zArr;
    }

    private boolean[] a(s sVar) {
        s sVar2 = sVar;
        g gVar = this.a;
        boolean z = gVar != null && gVar.g();
        g gVar2 = this.a;
        int f2 = gVar2 != null ? gVar2.f() : 0;
        int i = (z ? 11 : 14) + (f2 * 4);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[a(f2, z)];
        int i2 = 2;
        if (z) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = (i6 / 15) + i6;
                iArr[(i4 - i6) - 1] = (i5 - i7) - 1;
                iArr[i4 + i6] = i7 + i5 + 1;
            }
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < f2) {
            int i10 = ((f2 - i8) * 4) + (z ? 9 : 12);
            int i11 = i8 * 2;
            int i12 = (i - 1) - i11;
            int i13 = 0;
            while (i13 < i10) {
                int i14 = i13 * 2;
                int i15 = 0;
                while (i15 < i2) {
                    int i16 = i11 + i15;
                    int i17 = i11 + i13;
                    zArr[i9 + i14 + i15] = sVar2.b(iArr[i16], iArr[i17]);
                    int i18 = i12 - i15;
                    zArr[(i10 * 2) + i9 + i14 + i15] = sVar2.b(iArr[i17], iArr[i18]);
                    int i19 = i12 - i13;
                    zArr[(i10 * 4) + i9 + i14 + i15] = sVar2.b(iArr[i18], iArr[i19]);
                    zArr[(i10 * 6) + i9 + i14 + i15] = sVar2.b(iArr[i19], iArr[i16]);
                    i15++;
                    z = z;
                    i2 = 2;
                }
                boolean z2 = z;
                i13++;
                i2 = 2;
            }
            boolean z3 = z;
            i9 += i10 * 8;
            i8++;
            i2 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static byte a(boolean[] zArr, int i) {
        int a2;
        int length = zArr.length - i;
        if (length >= 8) {
            a2 = a(zArr, i, 8);
        } else {
            a2 = a(zArr, i, length) << (8 - length);
        }
        return (byte) a2;
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = a(zArr, i * 8);
        }
        return bArr;
    }
}
