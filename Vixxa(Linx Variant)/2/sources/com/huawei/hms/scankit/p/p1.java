package com.huawei.hms.scankit.p;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: DecodedBitStreamParser */
final class p1 {
    private static final char[] a = "0123456789abcdefghijklmnopqrstuvwxyz !-./:=?T".toCharArray();
    private static final char[] b = BinTools.hex.toCharArray();

    /* compiled from: DecodedBitStreamParser */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.hms.scankit.p.v4[] r0 = com.huawei.hms.scankit.p.v4.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.TERMINATOR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.FNC1_FIRST_POSITION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.FNC1_SECOND_POSITION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.STRUCTURED_APPEND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.ECI     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.HANZI     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.HEXADECIMAL     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.HEXABYTE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.BYTE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.huawei.hms.scankit.p.v4 r1 = com.huawei.hms.scankit.p.v4.KANJI     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.p1.a.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0070, code lost:
        r14 = r8;
        r8 = r6;
        r6 = r9;
        r9 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        if (r11 != com.huawei.hms.scankit.p.v4.c) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r1 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r4.isEmpty() == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0086, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0087, code lost:
        if (r17 != null) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0089, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008b, code lost:
        r6 = r17.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
        return new com.huawei.hms.scankit.p.w1(r15, r1, r5, r6, r8, r9);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.huawei.hms.scankit.p.w1 a(byte[] r15, com.huawei.hms.scankit.p.a8 r16, com.huawei.hms.scankit.p.c3 r17, java.util.Map<com.huawei.hms.scankit.p.l1, ?> r18) throws com.huawei.hms.scankit.p.a {
        /*
            r0 = r16
            com.huawei.hms.scankit.p.w r1 = new com.huawei.hms.scankit.p.w
            r3 = r15
            r1.<init>(r15)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r4 = 50
            r2.<init>(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 1
            r4.<init>(r5)
            r6 = -1
            r7 = 0
            r8 = 0
            r10 = r7
            r9 = r8
            r8 = r6
        L_0x001b:
            int r11 = r1.a()     // Catch:{ IllegalArgumentException -> 0x009f }
            r12 = 4
            if (r11 >= r12) goto L_0x0025
            com.huawei.hms.scankit.p.v4 r11 = com.huawei.hms.scankit.p.v4.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x009f }
            goto L_0x002d
        L_0x0025:
            int r11 = r1.a(r12)     // Catch:{ IllegalArgumentException -> 0x009f }
            com.huawei.hms.scankit.p.v4 r11 = com.huawei.hms.scankit.p.v4.a((int) r11)     // Catch:{ IllegalArgumentException -> 0x009f }
        L_0x002d:
            int[] r12 = com.huawei.hms.scankit.p.p1.a.a     // Catch:{ IllegalArgumentException -> 0x009f }
            int r13 = r11.ordinal()     // Catch:{ IllegalArgumentException -> 0x009f }
            r12 = r12[r13]     // Catch:{ IllegalArgumentException -> 0x009f }
            switch(r12) {
                case 1: goto L_0x0047;
                case 2: goto L_0x0067;
                case 3: goto L_0x0067;
                case 4: goto L_0x004a;
                case 5: goto L_0x0043;
                case 6: goto L_0x003f;
                default: goto L_0x0038;
            }     // Catch:{ IllegalArgumentException -> 0x009f }
        L_0x0038:
            r12 = r18
            com.huawei.hms.scankit.p.z0 r13 = a((com.huawei.hms.scankit.p.a8) r0, (java.util.Map<com.huawei.hms.scankit.p.l1, ?>) r12, (com.huawei.hms.scankit.p.w) r1, (java.lang.StringBuilder) r2)     // Catch:{ IllegalArgumentException -> 0x009f }
            goto L_0x006d
        L_0x003f:
            a((com.huawei.hms.scankit.p.a8) r0, (com.huawei.hms.scankit.p.w) r1, (java.lang.StringBuilder) r2, (com.huawei.hms.scankit.p.v4) r11)     // Catch:{ IllegalArgumentException -> 0x009f }
            goto L_0x0047
        L_0x0043:
            com.huawei.hms.scankit.p.o0 r10 = a((com.huawei.hms.scankit.p.w) r1)     // Catch:{ IllegalArgumentException -> 0x009f }
        L_0x0047:
            r12 = r18
            goto L_0x0070
        L_0x004a:
            int r6 = r1.a()     // Catch:{ IllegalArgumentException -> 0x009f }
            r8 = 16
            if (r6 < r8) goto L_0x0062
            r6 = 8
            int r8 = r1.a(r6)     // Catch:{ IllegalArgumentException -> 0x009f }
            int r6 = r1.a(r6)     // Catch:{ IllegalArgumentException -> 0x009f }
            r12 = r18
            r14 = r9
            r9 = r6
            r6 = r14
            goto L_0x0074
        L_0x0062:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()     // Catch:{ IllegalArgumentException -> 0x009f }
            throw r0     // Catch:{ IllegalArgumentException -> 0x009f }
        L_0x0067:
            r12 = r18
            r9 = r8
            r8 = r6
            r6 = r5
            goto L_0x0074
        L_0x006d:
            a((com.huawei.hms.scankit.p.z0) r13, (java.util.List<byte[]>) r4, (com.huawei.hms.scankit.p.o0) r10, (boolean) r9, (com.huawei.hms.scankit.p.v4) r11)     // Catch:{ IllegalArgumentException -> 0x009f }
        L_0x0070:
            r14 = r8
            r8 = r6
            r6 = r9
            r9 = r14
        L_0x0074:
            com.huawei.hms.scankit.p.v4 r13 = com.huawei.hms.scankit.p.v4.TERMINATOR     // Catch:{ IllegalArgumentException -> 0x009f }
            if (r11 != r13) goto L_0x0099
            com.huawei.hms.scankit.p.w1 r0 = new com.huawei.hms.scankit.p.w1
            java.lang.String r1 = r2.toString()
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto L_0x0086
            r5 = r7
            goto L_0x0087
        L_0x0086:
            r5 = r4
        L_0x0087:
            if (r17 != 0) goto L_0x008b
            r6 = r7
            goto L_0x0090
        L_0x008b:
            java.lang.String r2 = r17.toString()
            r6 = r2
        L_0x0090:
            r2 = r0
            r3 = r15
            r4 = r1
            r7 = r8
            r8 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0099:
            r14 = r9
            r9 = r6
            r6 = r8
            r8 = r14
            goto L_0x001b
        L_0x009f:
            com.huawei.hms.scankit.p.a r0 = com.huawei.hms.scankit.p.a.a()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.p1.a(byte[], com.huawei.hms.scankit.p.a8, com.huawei.hms.scankit.p.c3, java.util.Map):com.huawei.hms.scankit.p.w1");
    }

    private static void b(w wVar, StringBuilder sb, int i) throws a {
        if (i * 13 <= wVar.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = wVar.a(13);
                int i3 = (a2 % 192) | ((a2 / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
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

    private static void c(w wVar, StringBuilder sb, int i, boolean z) throws a {
        while (i > 1) {
            if (wVar.a() >= 8) {
                int a2 = wVar.a(8);
                sb.append(b(a2 / 16));
                sb.append(b(a2 % 16));
                i -= 2;
            } else {
                throw a.a();
            }
        }
        if (i == 1) {
            if (wVar.a() >= 4) {
                sb.append(b(wVar.a(4)));
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

    private static char b(int i) throws a {
        char[] cArr = b;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw a.a();
    }

    private static void b(w wVar, StringBuilder sb, int i, boolean z) throws a {
        while (i > 1) {
            if (wVar.a() >= 8) {
                int a2 = wVar.a(8);
                sb.append(b(a2 / 16));
                sb.append(b(a2 % 16));
                i -= 2;
            } else {
                throw a.a();
            }
        }
        if (i == 1) {
            if (wVar.a() >= 4) {
                sb.append(b(wVar.a(4)));
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

    private static int b(w wVar) throws a {
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

    private static z0 a(a8 a8Var, Map<l1, ?> map, w wVar, StringBuilder sb) {
        return new z0(a8Var, map, wVar, sb);
    }

    private static void a(z0 z0Var, List<byte[]> list, o0 o0Var, boolean z, v4 v4Var) throws a {
        a(new h7(z0Var.b, z0Var.c, z0Var.d, list), o0Var, z, v4Var, z0Var.c.a(v4Var.a(z0Var.a)));
    }

    private static o0 a(w wVar) throws a {
        o0 a2 = o0.a(b(wVar));
        a(a2);
        return a2;
    }

    private static void a(o0 o0Var) throws a {
        if (o0Var == null) {
            throw a.a();
        }
    }

    private static void a(a8 a8Var, w wVar, StringBuilder sb, v4 v4Var) throws a {
        int a2 = wVar.a(4);
        int a3 = wVar.a(v4Var.a(a8Var));
        if (a2 == 1) {
            a(wVar, sb, a3);
        }
    }

    private static void a(h7 h7Var, o0 o0Var, boolean z, v4 v4Var, int i) throws a {
        switch (a.a[v4Var.ordinal()]) {
            case 7:
                c(h7Var.b, h7Var.c, i);
                return;
            case 8:
                a(h7Var.b, h7Var.c, i, z);
                return;
            case 9:
                c(h7Var.b, h7Var.c, i, z);
                return;
            case 10:
                b(h7Var.b, h7Var.c, i, z);
                return;
            case 11:
                a(new b0(h7Var.b, h7Var.c), i, o0Var, (Collection<byte[]>) h7Var.d, h7Var.a);
                return;
            case 12:
                b(h7Var.b, h7Var.c, i);
                return;
            default:
                throw a.a();
        }
    }

    private static void a(w wVar, StringBuilder sb, int i) throws a {
        if (i * 13 <= wVar.a()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int a2 = wVar.a(13);
                int i3 = (a2 % 96) | ((a2 / 96) << 8);
                int i4 = i3 + (i3 < 2560 ? 41377 : 42657);
                bArr[i2] = (byte) ((i4 >> 8) & 255);
                bArr[i2 + 1] = (byte) (i4 & 255);
                i2 += 2;
                i--;
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

    private static void a(b0 b0Var, int i, o0 o0Var, Collection<byte[]> collection, Map<l1, ?> map) throws a {
        String str;
        if (i * 8 <= b0Var.a.a()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) b0Var.a.a(8);
            }
            if (o0Var == null) {
                str = c7.a(bArr, map);
            } else {
                str = o0Var.name();
            }
            try {
                b0Var.b.append(new String(bArr, str));
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
}
