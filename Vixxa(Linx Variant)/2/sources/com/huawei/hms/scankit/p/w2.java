package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import kotlin.UByte;

/* compiled from: Encoder */
public final class w2 {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* compiled from: Encoder */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.huawei.hms.scankit.p.u4[] r0 = com.huawei.hms.scankit.p.u4.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.BYTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.KANJI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w2.a.<clinit>():void");
        }
    }

    private static int a(c0 c0Var) {
        return r4.a(c0Var) + r4.b(c0Var) + r4.c(c0Var) + r4.d(c0Var);
    }

    static void b(CharSequence charSequence, r rVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                rVar.a((charAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    rVar.a((charAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    rVar.a(charAt, 4);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.scankit.p.h6 a(java.lang.String r6, com.huawei.hms.scankit.p.b3 r7, java.util.Map<com.huawei.hms.scankit.p.u2, ?> r8) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            if (r8 == 0) goto L_0x000c
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.CHARACTER_SET
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            if (r0 == 0) goto L_0x001a
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.CHARACTER_SET
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x001c
        L_0x001a:
            java.lang.String r1 = "ISO-8859-1"
        L_0x001c:
            com.huawei.hms.scankit.p.u4 r2 = a((java.lang.String) r6, (java.lang.String) r1)
            com.huawei.hms.scankit.p.r r3 = new com.huawei.hms.scankit.p.r
            r3.<init>()
            com.huawei.hms.scankit.p.u4 r4 = com.huawei.hms.scankit.p.u4.BYTE
            if (r2 != r4) goto L_0x0034
            if (r0 == 0) goto L_0x0034
            com.huawei.hms.scankit.p.o0 r0 = com.huawei.hms.scankit.p.o0.a((java.lang.String) r1)
            if (r0 == 0) goto L_0x0034
            a((com.huawei.hms.scankit.p.o0) r0, (com.huawei.hms.scankit.p.r) r3)
        L_0x0034:
            if (r8 == 0) goto L_0x0057
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.GS1_FORMAT
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto L_0x0057
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.GS1_FORMAT
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0057
            com.huawei.hms.scankit.p.u4 r0 = com.huawei.hms.scankit.p.u4.FNC1_FIRST_POSITION
            a((com.huawei.hms.scankit.p.u4) r0, (com.huawei.hms.scankit.p.r) r3)
        L_0x0057:
            a((com.huawei.hms.scankit.p.u4) r2, (com.huawei.hms.scankit.p.r) r3)
            com.huawei.hms.scankit.p.r r0 = new com.huawei.hms.scankit.p.r
            r0.<init>()
            a((java.lang.String) r6, (com.huawei.hms.scankit.p.u4) r2, (com.huawei.hms.scankit.p.r) r0, (java.lang.String) r1)
            if (r8 == 0) goto L_0x008f
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.QR_VERSION
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L_0x008f
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            com.huawei.hms.scankit.p.b8 r8 = com.huawei.hms.scankit.p.b8.c(r8)
            int r1 = a((com.huawei.hms.scankit.p.u4) r2, (com.huawei.hms.scankit.p.r) r3, (com.huawei.hms.scankit.p.r) r0, (com.huawei.hms.scankit.p.b8) r8)
            boolean r1 = a((int) r1, (com.huawei.hms.scankit.p.b8) r8, (com.huawei.hms.scankit.p.b3) r7)
            if (r1 == 0) goto L_0x0087
            goto L_0x0093
        L_0x0087:
            com.huawei.hms.hmsscankit.WriterException r6 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x008f:
            com.huawei.hms.scankit.p.b8 r8 = a((com.huawei.hms.scankit.p.b3) r7, (com.huawei.hms.scankit.p.u4) r2, (com.huawei.hms.scankit.p.r) r3, (com.huawei.hms.scankit.p.r) r0)
        L_0x0093:
            com.huawei.hms.scankit.p.r r1 = new com.huawei.hms.scankit.p.r
            r1.<init>()
            r1.a((com.huawei.hms.scankit.p.r) r3)
            if (r2 != r4) goto L_0x00a2
            int r6 = r0.f()
            goto L_0x00a6
        L_0x00a2:
            int r6 = r6.length()
        L_0x00a6:
            a((int) r6, (com.huawei.hms.scankit.p.b8) r8, (com.huawei.hms.scankit.p.u4) r2, (com.huawei.hms.scankit.p.r) r1)
            r1.a((com.huawei.hms.scankit.p.r) r0)
            com.huawei.hms.scankit.p.b8$b r6 = r8.a((com.huawei.hms.scankit.p.b3) r7)
            int r0 = r8.e()
            int r3 = r6.d()
            int r0 = r0 - r3
            a((int) r0, (com.huawei.hms.scankit.p.r) r1)
            int r3 = r8.e()
            int r6 = r6.c()
            com.huawei.hms.scankit.p.r r6 = a((com.huawei.hms.scankit.p.r) r1, (int) r3, (int) r0, (int) r6)
            com.huawei.hms.scankit.p.h6 r0 = new com.huawei.hms.scankit.p.h6
            r0.<init>()
            r0.a((com.huawei.hms.scankit.p.b3) r7)
            r0.a((com.huawei.hms.scankit.p.u4) r2)
            r0.a((com.huawei.hms.scankit.p.b8) r8)
            int r1 = r8.d()
            com.huawei.hms.scankit.p.c0 r2 = new com.huawei.hms.scankit.p.c0
            r2.<init>(r1, r1)
            int r1 = a((com.huawei.hms.scankit.p.r) r6, (com.huawei.hms.scankit.p.b3) r7, (com.huawei.hms.scankit.p.b8) r8, (com.huawei.hms.scankit.p.c0) r2)
            r0.b(r1)
            com.huawei.hms.scankit.p.t4.a(r6, r7, r8, r1, r2)
            r0.a((com.huawei.hms.scankit.p.c0) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w2.a(java.lang.String, com.huawei.hms.scankit.p.b3, java.util.Map):com.huawei.hms.scankit.p.h6");
    }

    private static b8 a(b3 b3Var, u4 u4Var, r rVar, r rVar2) throws WriterException {
        return a(a(u4Var, rVar, rVar2, a(a(u4Var, rVar, rVar2, b8.c(1)), b3Var)), b3Var);
    }

    private static int a(u4 u4Var, r rVar, r rVar2, b8 b8Var) {
        return rVar.e() + u4Var.a(b8Var) + rVar2.e();
    }

    static int a(int i) {
        int[] iArr = a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static u4 a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return u4.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (a((int) charAt) == -1) {
                return u4.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return u4.ALPHANUMERIC;
        }
        if (z2) {
            return u4.NUMERIC;
        }
        return u4.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                byte b = bytes[i] & UByte.MAX_VALUE;
                if ((b < 129 || b > 159) && (b < 224 || b > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(r rVar, b3 b3Var, b8 b8Var, c0 c0Var) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            t4.a(rVar, b3Var, b8Var, i3, c0Var);
            int a2 = a(c0Var);
            if (a2 < i) {
                i2 = i3;
                i = a2;
            }
        }
        return i2;
    }

    private static b8 a(int i, b3 b3Var) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            b8 c = b8.c(i2);
            if (a(i, c, b3Var)) {
                return c;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i, b8 b8Var, b3 b3Var) {
        return b8Var.e() - b8Var.a(b3Var).d() >= (i + 7) / 8;
    }

    static void a(int i, r rVar) throws WriterException {
        int i2 = i * 8;
        if (rVar.e() <= i2) {
            for (int i3 = 0; i3 < 4 && rVar.e() < i2; i3++) {
                rVar.a(false);
            }
            int e = rVar.e() & 7;
            if (e > 0) {
                while (e < 8) {
                    rVar.a(false);
                    e++;
                }
            }
            int f = i - rVar.f();
            for (int i4 = 0; i4 < f; i4++) {
                rVar.a((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (rVar.e() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + rVar.e() + " > " + i2);
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            } else if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            } else if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    static r a(r rVar, int i, int i2, int i3) throws WriterException {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (rVar.f() == i5) {
            ArrayList<y> arrayList = new ArrayList<>(i6);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i, i2, i3, i10, iArr, iArr2);
                int i11 = iArr[0];
                byte[] bArr = new byte[i11];
                rVar.a(i7 * 8, bArr, 0, i11);
                byte[] a2 = a(bArr, iArr2[0]);
                arrayList.add(new y(bArr, a2));
                i9 = Math.max(i9, i11);
                i8 = Math.max(i8, a2.length);
                i7 += iArr[0];
            }
            if (i5 == i7) {
                r rVar2 = new r();
                for (int i12 = 0; i12 < i9; i12++) {
                    for (y a3 : arrayList) {
                        byte[] a4 = a3.a();
                        if (i12 < a4.length) {
                            rVar2.a(a4[i12], 8);
                        }
                    }
                }
                for (int i13 = 0; i13 < i8; i13++) {
                    for (y b : arrayList) {
                        byte[] b2 = b.b();
                        if (i13 < b2.length) {
                            rVar2.a(b2[i13], 8);
                        }
                    }
                }
                if (i4 == rVar2.f()) {
                    return rVar2;
                }
                throw new WriterException("Interleaving error: " + i4 + " and " + rVar2.f() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & UByte.MAX_VALUE;
        }
        new q6(o3.l).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void a(u4 u4Var, r rVar) {
        rVar.a(u4Var.a(), 4);
    }

    static void a(int i, b8 b8Var, u4 u4Var, r rVar) throws WriterException {
        int a2 = u4Var.a(b8Var);
        int i2 = 1 << a2;
        if (i < i2) {
            rVar.a(i, a2);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    static void a(String str, u4 u4Var, r rVar, String str2) throws WriterException {
        int i = a.a[u4Var.ordinal()];
        if (i == 1) {
            b(str, rVar);
        } else if (i == 2) {
            a((CharSequence) str, rVar);
        } else if (i == 3) {
            a(str, rVar, str2);
        } else if (i == 4) {
            a(str, rVar);
        } else {
            throw new WriterException("Invalid mode: " + u4Var);
        }
    }

    static void a(CharSequence charSequence, r rVar) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a2 = a((int) charSequence.charAt(i));
            if (a2 != -1) {
                int i2 = i + 1;
                if (i2 < length) {
                    int a3 = a((int) charSequence.charAt(i2));
                    if (a3 != -1) {
                        rVar.a((a2 * 45) + a3, 11);
                        i += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    rVar.a(a2, 6);
                    i = i2;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void a(String str, r rVar, String str2) throws WriterException {
        try {
            for (byte a2 : str.getBytes(str2)) {
                rVar.a(a2, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException((Throwable) e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.lang.String r6, com.huawei.hms.scankit.p.r r7) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004d }
            int r0 = r6.length
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x004c
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x0024
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x0024
        L_0x0022:
            int r2 = r2 - r3
            goto L_0x0033
        L_0x0024:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0032
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0032
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0022
        L_0x0032:
            r2 = r4
        L_0x0033:
            if (r2 == r4) goto L_0x0044
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto L_0x0008
        L_0x0044:
            com.huawei.hms.hmsscankit.WriterException r6 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>((java.lang.String) r7)
            throw r6
        L_0x004c:
            return
        L_0x004d:
            r6 = move-exception
            com.huawei.hms.hmsscankit.WriterException r7 = new com.huawei.hms.hmsscankit.WriterException
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w2.a(java.lang.String, com.huawei.hms.scankit.p.r):void");
    }

    private static void a(o0 o0Var, r rVar) {
        rVar.a(u4.ECI.a(), 4);
        rVar.a(o0Var.a(), 8);
    }
}
