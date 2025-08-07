package com.huawei.hms.scankit.p;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.hmsscankit.WriterException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* compiled from: PDF417HighLevelEncoder */
final class q5 {
    private static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, Base64.padSymbol, 94, 0, 32, 0, 0, 0};
    private static final byte[] b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, Utf8.REPLACEMENT_BYTE, 123, 125, 39, 0};
    private static final byte[] c;
    private static final byte[] d = new byte[128];
    private static final Charset e = StandardCharsets.ISO_8859_1;

    /* compiled from: PDF417HighLevelEncoder */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.huawei.hms.scankit.p.y0[] r0 = com.huawei.hms.scankit.p.y0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.scankit.p.y0 r1 = com.huawei.hms.scankit.p.y0.TEXT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.scankit.p.y0 r1 = com.huawei.hms.scankit.p.y0.BYTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.scankit.p.y0 r1 = com.huawei.hms.scankit.p.y0.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.a.<clinit>():void");
        }
    }

    static {
        byte[] bArr = new byte[128];
        c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b2 = bArr2[i2];
            if (b2 > 0) {
                c[b2] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(d, (byte) -1);
        while (true) {
            byte[] bArr3 = b;
            if (i < bArr3.length) {
                byte b3 = bArr3[i];
                if (b3 > 0) {
                    d[b3] = (byte) i;
                }
                i++;
            } else {
                return;
            }
        }
    }

    static String a(String str, y0 y0Var, Charset charset) throws WriterException {
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = e;
        } else if (!e.equals(charset)) {
            o0 a2 = o0.a(charset.name());
            if (a2 != null) {
                a(a2.a(), sb);
            }
        } else {
            o4.a("PDF417", "else");
        }
        int length = str.length();
        int i = a.a[y0Var.ordinal()];
        if (i == 1) {
            a((CharSequence) str, 0, length, sb, 0);
        } else if (i == 2) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, 0, bytes.length, 1, sb);
        } else if (i != 3) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < length) {
                int a3 = a((CharSequence) str, i2);
                if (a3 >= 13) {
                    sb.append(902);
                    a(str, i2, a3, sb);
                    i2 += a3;
                    i4 = 0;
                    i3 = 2;
                } else {
                    int b2 = b(str, i2);
                    if (b2 >= 5 || a3 == length) {
                        if (i3 != 0) {
                            sb.append(900);
                            i3 = 0;
                            i4 = 0;
                        }
                        i4 = a((CharSequence) str, i2, b2, sb, i4);
                        i2 += b2;
                    } else {
                        int a4 = a(str, i2, charset);
                        if (a4 == 0) {
                            a4 = 1;
                        }
                        int i5 = a4 + i2;
                        byte[] bytes2 = str.substring(i2, i5).getBytes(charset);
                        if (bytes2.length == 1 && i3 == 0) {
                            a(bytes2, 0, 1, 0, sb);
                        } else {
                            a(bytes2, 0, bytes2.length, i3, sb);
                            i3 = 1;
                            i4 = 0;
                        }
                        i2 = i5;
                    }
                }
            }
        } else {
            sb.append(902);
            a(str, 0, length, sb);
        }
        return sb.toString();
    }

    private static boolean a(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    private static int b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && c(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
            if (i3 >= 13) {
                return (i2 - i) - i3;
            }
            if (i3 <= 0) {
                if (!f(charSequence.charAt(i2))) {
                    break;
                }
                i2++;
            }
        }
        return i2 - i;
    }

    private static boolean b(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean c(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean d(char c2) {
        byte[] bArr = c;
        if (w7.a(bArr, (int) c2)) {
            return bArr[c2] != -1;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private static boolean e(char c2) {
        if (w7.a(c, (int) c2)) {
            return d[c2] != -1;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private static boolean f(char c2) {
        return c2 == 9 || c2 == 10 || c2 == 13 || (c2 >= ' ' && c2 <= '~');
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f6 A[EDGE_INSN: B:65:0x00f6->B:53:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x000f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 0
            r5 = r20
            r6 = r4
        L_0x000f:
            int r7 = r17 + r6
            char r8 = r0.charAt(r7)
            r9 = 26
            r10 = 32
            r11 = 28
            r12 = 27
            r13 = 29
            r14 = 2
            r15 = 1
            if (r5 == 0) goto L_0x00bc
            if (r5 == r15) goto L_0x0083
            if (r5 == r14) goto L_0x003c
            boolean r7 = e(r8)
            if (r7 == 0) goto L_0x0037
            byte[] r7 = d
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f2
        L_0x0037:
            r3.append(r13)
        L_0x003a:
            r5 = r4
            goto L_0x000f
        L_0x003c:
            boolean r9 = d(r8)
            if (r9 == 0) goto L_0x004c
            byte[] r7 = c
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f2
        L_0x004c:
            boolean r9 = b(r8)
            if (r9 == 0) goto L_0x0056
            r3.append(r11)
            goto L_0x003a
        L_0x0056:
            boolean r9 = a(r8)
            if (r9 == 0) goto L_0x0061
            r3.append(r12)
            goto L_0x00d8
        L_0x0061:
            int r7 = r7 + 1
            if (r7 >= r1) goto L_0x0076
            char r7 = r0.charAt(r7)
            boolean r7 = e(r7)
            if (r7 == 0) goto L_0x0076
            r5 = 25
            r3.append(r5)
            r5 = 3
            goto L_0x000f
        L_0x0076:
            r3.append(r13)
            byte[] r7 = d
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f2
        L_0x0083:
            boolean r7 = a(r8)
            if (r7 == 0) goto L_0x0096
            if (r8 != r10) goto L_0x008f
            r3.append(r9)
            goto L_0x00f2
        L_0x008f:
            int r8 = r8 + -97
            char r7 = (char) r8
            r3.append(r7)
            goto L_0x00f2
        L_0x0096:
            boolean r7 = b(r8)
            if (r7 == 0) goto L_0x00a6
            r3.append(r12)
            int r8 = r8 + -65
            char r7 = (char) r8
            r3.append(r7)
            goto L_0x00f2
        L_0x00a6:
            boolean r7 = d(r8)
            if (r7 == 0) goto L_0x00b0
            r3.append(r11)
            goto L_0x00e4
        L_0x00b0:
            r3.append(r13)
            byte[] r7 = d
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
            goto L_0x00f2
        L_0x00bc:
            boolean r7 = b(r8)
            if (r7 == 0) goto L_0x00cf
            if (r8 != r10) goto L_0x00c8
            r3.append(r9)
            goto L_0x00f2
        L_0x00c8:
            int r8 = r8 + -65
            char r7 = (char) r8
            r3.append(r7)
            goto L_0x00f2
        L_0x00cf:
            boolean r7 = a(r8)
            if (r7 == 0) goto L_0x00db
            r3.append(r12)
        L_0x00d8:
            r5 = r15
            goto L_0x000f
        L_0x00db:
            boolean r7 = d(r8)
            if (r7 == 0) goto L_0x00e7
            r3.append(r11)
        L_0x00e4:
            r5 = r14
            goto L_0x000f
        L_0x00e7:
            r3.append(r13)
            byte[] r7 = d
            byte r7 = r7[r8]
            char r7 = (char) r7
            r3.append(r7)
        L_0x00f2:
            int r6 = r6 + 1
            if (r6 < r1) goto L_0x000f
            int r0 = r3.length()
            r1 = r4
        L_0x00fb:
            if (r4 >= r0) goto L_0x0114
            int r6 = r4 % 2
            if (r6 == 0) goto L_0x010d
            int r1 = r1 * 30
            char r6 = r3.charAt(r4)
            int r1 = r1 + r6
            char r1 = (char) r1
            r2.append(r1)
            goto L_0x0111
        L_0x010d:
            char r1 = r3.charAt(r4)
        L_0x0111:
            int r4 = r4 + 1
            goto L_0x00fb
        L_0x0114:
            int r0 = r0 % r14
            if (r0 == 0) goto L_0x011e
            int r1 = r1 * 30
            int r1 = r1 + r13
            char r0 = (char) r1
            r2.append(r0)
        L_0x011e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.a(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static void a(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        if (i2 == 1 && i3 == 0) {
            sb.append(913);
        } else if (i2 % 6 == 0) {
            sb.append(924);
        } else {
            sb.append(901);
        }
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + ((long) (bArr[i4 + i5] & UByte.MAX_VALUE));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j % 900));
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & UByte.MAX_VALUE));
            i4++;
        }
    }

    private static void a(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int min = Math.min(44, i2 - i3);
            if (str.length() > 0) {
                int i4 = i + i3;
                BigInteger bigInteger = new BigInteger("1" + str.substring(i4, i4 + min));
                do {
                    sb2.append((char) bigInteger.mod(valueOf).intValue());
                    bigInteger = bigInteger.divide(valueOf);
                } while (!bigInteger.equals(valueOf2));
            }
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += min;
        }
    }

    private static int a(CharSequence charSequence, int i) {
        return d4.a(charSequence, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r5, int r6, java.nio.charset.Charset r7) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            java.nio.charset.CharsetEncoder r7 = r7.newEncoder()
            int r0 = r5.length()
            r1 = r6
        L_0x0009:
            if (r1 >= r0) goto L_0x005c
            char r2 = r5.charAt(r1)
            r3 = 0
        L_0x0010:
            r4 = 13
            if (r3 >= r4) goto L_0x0026
            boolean r2 = c(r2)
            if (r2 == 0) goto L_0x0026
            int r3 = r3 + 1
            int r2 = r1 + r3
            if (r2 < r0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            char r2 = r5.charAt(r2)
            goto L_0x0010
        L_0x0026:
            if (r3 < r4) goto L_0x002a
            int r1 = r1 - r6
            return r1
        L_0x002a:
            char r2 = r5.charAt(r1)
            boolean r3 = r7.canEncode(r2)
            if (r3 == 0) goto L_0x0037
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0037:
            com.huawei.hms.hmsscankit.WriterException r5 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Non-encodable character detected: "
            r6.<init>(r7)
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r7 = " (Unicode: "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r2)
            r7 = 41
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x005c:
            int r1 = r1 - r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.q5.a(java.lang.String, int, java.nio.charset.Charset):int");
    }

    private static void a(int i, StringBuilder sb) throws WriterException {
        if (i >= 0 && i < 900) {
            sb.append(927);
            sb.append((char) i);
        } else if (i < 810900) {
            sb.append(926);
            sb.append((char) ((i / TypedValues.Custom.TYPE_INT) - 1));
            sb.append((char) (i % TypedValues.Custom.TYPE_INT));
        } else if (i < 811800) {
            sb.append(925);
            sb.append((char) (810900 - i));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i);
        }
    }
}
