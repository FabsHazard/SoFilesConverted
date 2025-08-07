package com.huawei.hms.scankit.p;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: DecodedBitStreamParser */
final class q1 {
    private static final char[] a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] c;

    /* compiled from: DecodedBitStreamParser */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.hms.scankit.p.q1$b[] r0 = com.huawei.hms.scankit.p.q1.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.scankit.p.q1$b r1 = com.huawei.hms.scankit.p.q1.b.ALPHA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.scankit.p.q1$b r1 = com.huawei.hms.scankit.p.q1.b.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.scankit.p.q1$b r1 = com.huawei.hms.scankit.p.q1.b.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.scankit.p.q1$b r1 = com.huawei.hms.scankit.p.q1.b.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.scankit.p.q1$b r1 = com.huawei.hms.scankit.p.q1.b.ALPHA_SHIFT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huawei.hms.scankit.p.q1$b r1 = com.huawei.hms.scankit.p.q1.b.PUNCT_SHIFT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q1.a.<clinit>():void");
        }
    }

    /* compiled from: DecodedBitStreamParser */
    private enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        bigIntegerArr[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = c;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    static w1 a(int[] iArr, String str, Map<l1, ?> map) throws a {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i3 = iArr[1];
        s5 s5Var = new s5();
        Charset charset2 = charset;
        int i4 = 2;
        int i5 = i3;
        while (true) {
            int i6 = iArr[0];
            if (i4 <= i6 && (i4 != i6 || sb.length() <= 0)) {
                if (i5 == 927) {
                    i2 = i4 + 1;
                    charset2 = Charset.forName(o0.a(iArr[i4]).name());
                } else {
                    i2 = a(sb, i5, iArr, i4, charset2, s5Var);
                }
                if (i2 < iArr.length) {
                    i4 = i2 + 1;
                    i5 = iArr[i2];
                } else {
                    throw a.a();
                }
            }
        }
        if (sb.length() == 0) {
            throw a.a();
        } else if (charset2 == StandardCharsets.ISO_8859_1) {
            int length = sb.length();
            byte[] bArr = new byte[length];
            for (i = 0; i < length; i++) {
                bArr[i] = (byte) sb.charAt(i);
            }
            try {
                w1 w1Var = new w1((byte[]) null, new String(bArr, c7.a(bArr, map)), (List<byte[]>) null, str);
                w1Var.a((Object) s5Var);
                return w1Var;
            } catch (UnsupportedEncodingException unused) {
                throw a.a();
            }
        } else {
            w1 w1Var2 = new w1((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            w1Var2.a((Object) s5Var);
            return w1Var2;
        }
    }

    private static boolean a(int i) {
        return i == 901 || i == 924 || i == 902 || i == 928 || i == 923 || i == 922;
    }

    private static int b(int[] iArr, int i, StringBuilder sb) throws a {
        int i2 = iArr[0];
        int[] iArr2 = new int[((i2 - i) * 2)];
        int[] iArr3 = new int[((i2 - i) * 2)];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 == 900) {
                iArr2[i3] = 900;
                i3++;
            } else if (i5 == 913) {
                iArr2[i3] = 913;
                i += 2;
                iArr3[i3] = iArr[i4];
                i3++;
            } else if (a(i5)) {
                z = true;
            } else {
                throw a.a();
            }
            i = i4;
        }
        a(iArr2, iArr3, i3, sb);
        return i;
    }

    private static b[] c(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws a {
        b bVar3;
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 97);
        } else if (i == 900) {
            bVar = b.ALPHA;
        } else if (i != 913) {
            switch (i) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar3 = b.ALPHA_SHIFT;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar3 = b.PUNCT_SHIFT;
                    break;
                default:
                    throw a.a();
            }
            bVar2 = bVar;
            bVar = bVar3;
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] d(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws a {
        int i = iArr2[1];
        if (i < 25) {
            iArr2[2] = b[i];
        } else {
            if (i != 900) {
                if (i != 913) {
                    switch (i) {
                        case 25:
                            bVar = b.PUNCT;
                            break;
                        case 26:
                            iArr2[2] = 32;
                            break;
                        case 27:
                            bVar = b.LOWER;
                            break;
                        case 28:
                            break;
                        case 29:
                            bVar2 = bVar;
                            bVar = b.PUNCT_SHIFT;
                            break;
                        default:
                            throw a.a();
                    }
                } else {
                    sb.append((char) iArr[iArr2[0]]);
                }
            }
            bVar = b.ALPHA;
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] e(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws a {
        int i = iArr2[1];
        if (i < 29) {
            iArr2[2] = a[i];
        } else if (i == 29 || i == 900) {
            bVar = b.ALPHA;
        } else if (i == 913) {
            sb.append((char) iArr[iArr2[0]]);
        } else {
            throw a.a();
        }
        return new b[]{bVar, bVar2};
    }

    private static b[] f(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws a {
        b bVar3;
        int i = iArr2[1];
        if (i < 29) {
            iArr2[2] = a[i];
        } else if (i == 29 || i == 900) {
            bVar3 = b.ALPHA;
            return new b[]{bVar3, bVar2};
        } else if (i == 913) {
            sb.append((char) iArr[iArr2[0]]);
        } else {
            throw a.a();
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static b[] b(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws a {
        b bVar3;
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 65);
        } else if (i == 26) {
            iArr2[2] = 32;
        } else if (i == 900) {
            bVar3 = b.ALPHA;
            return new b[]{bVar3, bVar2};
        } else {
            throw a.a();
        }
        bVar3 = bVar2;
        return new b[]{bVar3, bVar2};
    }

    private static int a(StringBuilder sb, int i, int[] iArr, int i2, Charset charset, s5 s5Var) throws a {
        if (i == 913) {
            sb.append((char) iArr[i2]);
            return i2 + 1;
        } else if (i == 928) {
            return a(iArr, i2, s5Var);
        } else {
            switch (i) {
                case TypedValues.Custom.TYPE_INT:
                    return b(iArr, i2, sb);
                case TypedValues.Custom.TYPE_FLOAT:
                    break;
                case TypedValues.Custom.TYPE_COLOR:
                    return a(iArr, i2, sb);
                default:
                    switch (i) {
                        case 922:
                        case 923:
                            throw a.a();
                        case 924:
                            break;
                        case 925:
                            return i2 + 1;
                        case 926:
                            return i2 + 2;
                        default:
                            return b(iArr, i2 - 1, sb);
                    }
            }
            return a(i, iArr, charset, i2, sb);
        }
    }

    static int a(int[] iArr, int i, s5 s5Var) throws a {
        int i2 = 0;
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            while (i2 < 2) {
                iArr2[i2] = iArr[i];
                i2++;
                i++;
            }
            try {
                s5Var.c(Integer.parseInt(a(iArr2, 2)));
                StringBuilder sb = new StringBuilder();
                int b2 = b(iArr, i, sb);
                s5Var.b(sb.toString());
                int i3 = iArr[b2] == 923 ? b2 + 1 : -1;
                a(b2, iArr, s5Var);
                if (i3 != -1) {
                    int i4 = b2 - i3;
                    if (s5Var.a()) {
                        i4--;
                    }
                    s5Var.a(Arrays.copyOfRange(iArr, i3, i4 + i3));
                }
                return b2;
            } catch (Exception unused) {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    private static void a(int i, int[] iArr, s5 s5Var) throws a {
        while (i < iArr[0]) {
            int i2 = iArr[i];
            if (i2 == 923) {
                int i3 = iArr[i + 1];
                if (i3 == 0) {
                    StringBuilder sb = new StringBuilder();
                    i = b(iArr, i + 2, sb);
                    s5Var.c(sb.toString());
                } else if (i3 == 3) {
                    StringBuilder sb2 = new StringBuilder();
                    i = b(iArr, i + 2, sb2);
                    s5Var.d(sb2.toString());
                } else if (i3 == 4) {
                    StringBuilder sb3 = new StringBuilder();
                    i = b(iArr, i + 2, sb3);
                    s5Var.a(sb3.toString());
                } else if (i3 == 1) {
                    StringBuilder sb4 = new StringBuilder();
                    i = a(iArr, i + 2, sb4);
                    s5Var.b(Integer.parseInt(sb4.toString()));
                } else if (i3 == 2) {
                    StringBuilder sb5 = new StringBuilder();
                    i = a(iArr, i + 2, sb5);
                    s5Var.b(Long.parseLong(sb5.toString()));
                } else if (i3 == 6) {
                    StringBuilder sb6 = new StringBuilder();
                    i = a(iArr, i + 2, sb6);
                    s5Var.a(Integer.parseInt(sb6.toString()));
                } else if (i3 == 5) {
                    StringBuilder sb7 = new StringBuilder();
                    i = a(iArr, i + 2, sb7);
                    s5Var.a(Long.parseLong(sb7.toString()));
                } else {
                    throw a.a();
                }
            } else if (i2 == 922) {
                i++;
                s5Var.a(true);
            } else {
                throw a.a();
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int i, StringBuilder sb) throws a {
        b bVar = b.ALPHA;
        b bVar2 = bVar;
        int i2 = 0;
        while (i2 < i) {
            int[] iArr3 = {i2, iArr[i2], 0};
            b[] bVarArr = {bVar, bVar2};
            switch (a.a[bVar.ordinal()]) {
                case 1:
                    bVarArr = a(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 2:
                    bVarArr = c(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 3:
                    bVarArr = d(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 4:
                    bVarArr = e(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 5:
                    bVarArr = b(sb, iArr2, bVar, bVar2, iArr3);
                    break;
                case 6:
                    bVarArr = f(sb, iArr2, bVar, bVar2, iArr3);
                    break;
            }
            bVar = bVarArr[0];
            bVar2 = bVarArr[1];
            int i3 = iArr3[0];
            char c2 = (char) iArr3[2];
            if (c2 != 0) {
                sb.append(c2);
            }
            i2 = i3 + 1;
        }
    }

    private static b[] a(StringBuilder sb, int[] iArr, b bVar, b bVar2, int[] iArr2) throws a {
        int i = iArr2[1];
        if (i < 26) {
            iArr2[2] = (char) (i + 65);
        } else if (i == 900) {
            bVar = b.ALPHA;
        } else if (i != 913) {
            switch (i) {
                case 26:
                    iArr2[2] = 32;
                    break;
                case 27:
                    bVar = b.LOWER;
                    break;
                case 28:
                    bVar = b.MIXED;
                    break;
                case 29:
                    bVar2 = bVar;
                    bVar = b.PUNCT_SHIFT;
                    break;
                default:
                    throw a.a();
            }
        } else {
            sb.append((char) iArr[iArr2[0]]);
        }
        return new b[]{bVar, bVar2};
    }

    private static int a(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) throws a {
        int i3;
        int i4;
        int i5 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i6 = 0;
        long j = 0;
        boolean z = false;
        if (i5 == 901) {
            int[] iArr2 = new int[6];
            int i7 = i2 + 1;
            int i8 = iArr[i2];
            while (true) {
                int i9 = iArr[0];
                if (i7 < i9 && !z) {
                    int i10 = i6 + 1;
                    iArr2[i6] = i8;
                    j = (j * 900) + ((long) i8);
                    int i11 = i7 + 1;
                    i8 = iArr[i7];
                    if (i8 != 928) {
                        switch (i8) {
                            case TypedValues.Custom.TYPE_INT:
                            case TypedValues.Custom.TYPE_FLOAT:
                            case TypedValues.Custom.TYPE_COLOR:
                                break;
                            default:
                                switch (i8) {
                                    case 922:
                                    case 923:
                                    case 924:
                                        break;
                                    default:
                                        if (i10 % 5 != 0 || i10 <= 0) {
                                            i7 = i11;
                                            break;
                                        } else {
                                            for (int i12 = 0; i12 < 6; i12++) {
                                                byteArrayOutputStream.write((byte) ((int) (j >> ((5 - i12) * 8))));
                                            }
                                            j = 0;
                                            i7 = i11;
                                            i6 = 0;
                                            continue;
                                            continue;
                                        }
                                }
                        }
                    }
                    z = true;
                    i6 = i10;
                } else if (i7 == i9 && i8 < 900) {
                    iArr2[i6] = i8;
                    i6++;
                }
            }
            iArr2[i6] = i8;
            i6++;
            for (i4 = 0; i4 < i6; i4++) {
                byteArrayOutputStream.write((byte) iArr2[i4]);
            }
            i3 = i7;
        } else {
            i3 = i5 == 924 ? a(i2, iArr, false, 0, 0, byteArrayOutputStream) : i2;
        }
        Charset charset2 = charset;
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int a(int i, int[] iArr, boolean z, int i2, long j, ByteArrayOutputStream byteArrayOutputStream) throws a {
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                i2++;
                j = (j * 900) + ((long) i4);
                i = i3;
            } else {
                if (i4 != 928) {
                    switch (i4) {
                        case TypedValues.Custom.TYPE_INT:
                        case TypedValues.Custom.TYPE_FLOAT:
                        case TypedValues.Custom.TYPE_COLOR:
                            break;
                        default:
                            switch (i4) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    throw a.a();
                            }
                    }
                }
                z = true;
            }
            if (i2 % 5 == 0 && i2 > 0) {
                for (int i5 = 0; i5 < 6; i5++) {
                    byteArrayOutputStream.write((byte) ((int) (j >> ((5 - i5) * 8))));
                }
                j = 0;
                i2 = 0;
            }
        }
        return i;
    }

    private static int a(int[] iArr, int i, StringBuilder sb) throws a {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = iArr[0];
            if (i >= i3 || z) {
                return i;
            }
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i4 == i3) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i2] = i5;
                i2++;
                i = i4;
            } else {
                if (!(i5 == 900 || i5 == 901 || i5 == 928)) {
                    switch (i5) {
                        case 922:
                        case 923:
                        case 924:
                            break;
                        default:
                            throw a.a();
                    }
                }
                z = true;
            }
            if ((i2 % 15 == 0 || i5 == 902 || z) && i2 > 0) {
                sb.append(a(iArr2, i2));
                i2 = 0;
            }
        }
        return i;
    }

    private static String a(int[] iArr, int i) throws a {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(c[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw a.a();
    }
}
