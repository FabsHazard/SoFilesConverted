package com.huawei.hms.scankit.p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: DecodedBitStreamParser */
final class r1 {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* compiled from: DecodedBitStreamParser */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
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
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.TERMINATOR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.FNC1_FIRST_POSITION     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.FNC1_SECOND_POSITION     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.STRUCTURED_APPEND     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.ECI     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.huawei.hms.scankit.p.u4 r1 = com.huawei.hms.scankit.p.u4.HANZI     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.r1.a.<clinit>():void");
        }
    }

    static w1 a(byte[] bArr, b8 b8Var, b3 b3Var, Map<l1, ?> map) throws a {
        u4 a2;
        int i;
        int i2;
        String str;
        w wVar = new w(bArr);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            try {
                if (wVar.a() < 4) {
                    a2 = u4.TERMINATOR;
                } else {
                    a2 = u4.a(wVar.a(4));
                }
                u4 u4Var = a2;
                int[] iArr = {i5, i3, i4};
                a(u4Var, wVar, sb, b8Var, iArr, (o0) null, arrayList, map);
                i5 = iArr[0] == 1 ? 1 : 0;
                i = iArr[1];
                i2 = iArr[2];
                if (u4Var == u4.TERMINATOR) {
                    break;
                }
                i3 = i;
                i4 = i2;
            } catch (IllegalArgumentException unused) {
                throw a.a();
            }
        }
        String sb2 = sb.toString();
        ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
        if (b3Var == null) {
            str = null;
        } else {
            str = b3Var.toString();
        }
        return new w1(bArr, sb2, arrayList2, str, i, i2);
    }

    private static void b(w wVar, StringBuilder sb, int i) throws a {
        if (i * 13 <= wVar.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = wVar.a(13);
                int i3 = (a2 % 192) | ((a2 / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                if (w7.a(bArr, i2)) {
                    int i5 = i2 + 1;
                    if (w7.a(bArr, i5)) {
                        bArr[i2] = (byte) (i4 >> 8);
                        bArr[i5] = (byte) i4;
                        i2 += 2;
                        i--;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    private static void c(w wVar, StringBuilder sb, int i) throws a {
        while (i >= 3) {
            if (wVar.a() >= 10) {
                int a2 = wVar.a(10);
                if (a2 < 1000) {
                    sb.append(a(a2 / 100));
                    sb.append(a((a2 / 10) % 10));
                    sb.append(a(a2 % 10));
                    i -= 3;
                } else {
                    throw a.a();
                }
            } else {
                throw a.a();
            }
        }
        if (i == 2) {
            if (wVar.a() >= 7) {
                int a3 = wVar.a(7);
                if (a3 < 100) {
                    sb.append(a(a3 / 10));
                    sb.append(a(a3 % 10));
                    return;
                }
                throw a.a();
            }
            throw a.a();
        } else if (i != 1) {
        } else {
            if (wVar.a() >= 4) {
                int a4 = wVar.a(4);
                if (a4 < 10) {
                    sb.append(a(a4));
                    return;
                }
                throw a.a();
            }
            throw a.a();
        }
    }

    private static void a(u4 u4Var, w wVar, StringBuilder sb, b8 b8Var, int[] iArr, o0 o0Var, List<byte[]> list, Map<l1, ?> map) throws a {
        u4 u4Var2 = u4Var;
        w wVar2 = wVar;
        StringBuilder sb2 = sb;
        b8 b8Var2 = b8Var;
        int[] iArr2 = a.a;
        boolean z = false;
        switch (iArr2[u4Var.ordinal()]) {
            case 5:
                return;
            case 6:
            case 7:
                iArr[0] = 1;
                return;
            case 8:
                if (wVar.a() >= 16) {
                    iArr[1] = wVar.a(8);
                    iArr[2] = wVar.a(8);
                    return;
                }
                throw a.a();
            case 9:
                if (o0.a(a(wVar)) == null) {
                    throw a.a();
                }
                return;
            case 10:
                int a2 = wVar.a(4);
                int a3 = wVar.a(u4Var.a(b8Var));
                if (a2 == 1) {
                    a(wVar, sb, a3);
                    return;
                }
                return;
            default:
                int a4 = wVar.a(u4Var.a(b8Var));
                int i = iArr2[u4Var.ordinal()];
                if (i == 1) {
                    c(wVar, sb, a4);
                    return;
                } else if (i == 2) {
                    if (iArr[0] == 1) {
                        z = true;
                    }
                    a(wVar, sb, a4, z);
                    return;
                } else if (i == 3) {
                    a(wVar, sb, a4, o0Var, list, map);
                    return;
                } else if (i == 4) {
                    b(wVar, sb, a4);
                    return;
                } else {
                    throw a.a();
                }
        }
    }

    private static void a(w wVar, StringBuilder sb, int i) throws a {
        if (i * 13 <= wVar.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = wVar.a(13);
                int i3 = (a2 % 96) | ((a2 / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                if (w7.a(bArr, i2)) {
                    int i5 = i2 + 1;
                    if (w7.a(bArr, i5)) {
                        bArr[i2] = (byte) ((i4 >> 8) & 255);
                        bArr[i5] = (byte) (i4 & 255);
                        i2 += 2;
                        i--;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    private static void a(w wVar, StringBuilder sb, int i, o0 o0Var, Collection<byte[]> collection, Map<l1, ?> map) throws a {
        String str;
        if (i * 8 <= wVar.a()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) wVar.a(8);
            }
            if (o0Var == null) {
                str = c7.a(bArr, map);
            } else {
                str = o0Var.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    private static char a(int i) throws a {
        char[] cArr = a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw a.a();
    }

    private static void a(w wVar, StringBuilder sb, int i, boolean z) throws a {
        while (i > 1) {
            if (wVar.a() >= 11) {
                int a2 = wVar.a(11);
                sb.append(a(a2 / 45));
                sb.append(a(a2 % 45));
                i -= 2;
            } else {
                throw a.a();
            }
        }
        if (i == 1) {
            if (wVar.a() >= 6) {
                sb.append(a(wVar.a(6)));
            } else {
                throw a.a();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    private static int a(w wVar) throws a {
        int a2 = wVar.a(8);
        if ((a2 & 128) == 0) {
            return a2 & 127;
        }
        if ((a2 & 192) == 128) {
            return wVar.a(8) | ((a2 & 63) << 8);
        }
        if ((a2 & 224) == 192) {
            return wVar.a(16) | ((a2 & 31) << 16);
        }
        throw a.a();
    }
}
