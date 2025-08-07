package com.igexin.push.util;

class k extends i {
    static final /* synthetic */ boolean g = true;
    private static final byte[] h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] i = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;

    static {
        Class<h> cls = h.class;
    }

    public k(int i2, byte[] bArr) {
        this.a = bArr;
        boolean z = true;
        this.d = (i2 & 1) == 0;
        boolean z2 = (i2 & 2) == 0;
        this.e = z2;
        this.f = (i2 & 4) == 0 ? false : z;
        this.l = (i2 & 8) == 0 ? h : i;
        this.j = new byte[2];
        this.c = 0;
        this.k = z2 ? 19 : -1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00e6 A[SYNTHETIC] */
    public boolean a(byte[] r19, int r20, int r21, boolean r22) {
        /*
            r18 = this;
            r0 = r18
            byte[] r1 = r0.l
            byte[] r2 = r0.a
            int r3 = r0.k
            int r4 = r21 + r20
            int r5 = r0.c
            r6 = 2
            r7 = 1
            r8 = 0
            r9 = -1
            if (r5 == r7) goto L_0x0031
            if (r5 == r6) goto L_0x0015
            goto L_0x0050
        L_0x0015:
            int r5 = r20 + 1
            if (r5 > r4) goto L_0x0050
            byte[] r10 = r0.j
            byte r11 = r10[r8]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 16
            byte r10 = r10[r7]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 8
            r10 = r10 | r11
            byte r11 = r19[r20]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r10 = r10 | r11
            r0.c = r8
            r11 = r5
            goto L_0x0053
        L_0x0031:
            int r5 = r20 + 2
            if (r5 > r4) goto L_0x0050
            byte[] r5 = r0.j
            byte r5 = r5[r8]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 16
            int r10 = r20 + 1
            byte r11 = r19[r20]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r5 = r5 | r11
            int r11 = r20 + 2
            byte r10 = r19[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r10 = r10 | r5
            r0.c = r8
            goto L_0x0053
        L_0x0050:
            r11 = r20
            r10 = r9
        L_0x0053:
            r12 = 13
            r13 = 4
            r14 = 10
            if (r10 == r9) goto L_0x008f
            int r9 = r10 >> 18
            r9 = r9 & 63
            byte r9 = r1[r9]
            r2[r8] = r9
            int r9 = r10 >> 12
            r9 = r9 & 63
            byte r9 = r1[r9]
            r2[r7] = r9
            int r9 = r10 >> 6
            r9 = r9 & 63
            byte r9 = r1[r9]
            r2[r6] = r9
            r9 = r10 & 63
            byte r9 = r1[r9]
            r10 = 3
            r2[r10] = r9
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x008d
            boolean r3 = r0.f
            if (r3 == 0) goto L_0x0085
            r2[r13] = r12
            r3 = 5
            goto L_0x0086
        L_0x0085:
            r3 = r13
        L_0x0086:
            int r9 = r3 + 1
            r2[r3] = r14
        L_0x008a:
            r3 = 19
            goto L_0x0090
        L_0x008d:
            r9 = r13
            goto L_0x0090
        L_0x008f:
            r9 = r8
        L_0x0090:
            int r10 = r11 + 3
            if (r10 > r4) goto L_0x00e6
            byte r15 = r19[r11]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r15 = r15 << 16
            int r16 = r11 + 1
            byte r5 = r19[r16]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            r5 = r5 | r15
            int r11 = r11 + 2
            byte r11 = r19[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            r5 = r5 | r11
            int r11 = r5 >> 18
            r11 = r11 & 63
            byte r11 = r1[r11]
            r2[r9] = r11
            int r11 = r9 + 1
            int r15 = r5 >> 12
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r9 + 2
            int r15 = r5 >> 6
            r15 = r15 & 63
            byte r15 = r1[r15]
            r2[r11] = r15
            int r11 = r9 + 3
            r5 = r5 & 63
            byte r5 = r1[r5]
            r2[r11] = r5
            int r5 = r9 + 4
            int r3 = r3 + -1
            if (r3 != 0) goto L_0x00e3
            boolean r3 = r0.f
            if (r3 == 0) goto L_0x00dd
            int r9 = r9 + 5
            r2[r5] = r12
            r5 = r9
        L_0x00dd:
            int r9 = r5 + 1
            r2[r5] = r14
            r11 = r10
            goto L_0x008a
        L_0x00e3:
            r9 = r5
            r11 = r10
            goto L_0x0090
        L_0x00e6:
            if (r22 == 0) goto L_0x01d7
            int r5 = r0.c
            int r10 = r11 - r5
            int r15 = r4 + -1
            r16 = 61
            if (r10 != r15) goto L_0x0139
            if (r5 <= 0) goto L_0x00fa
            byte[] r6 = r0.j
            byte r6 = r6[r8]
            r8 = r7
            goto L_0x0100
        L_0x00fa:
            int r6 = r11 + 1
            byte r10 = r19[r11]
            r11 = r6
            r6 = r10
        L_0x0100:
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r13
            int r5 = r5 - r8
            r0.c = r5
            int r5 = r9 + 1
            int r8 = r6 >> 6
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r9] = r8
            int r8 = r9 + 2
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r5] = r1
            boolean r1 = r0.d
            if (r1 == 0) goto L_0x0124
            int r1 = r9 + 3
            r2[r8] = r16
            int r8 = r9 + 4
            r2[r1] = r16
        L_0x0124:
            boolean r1 = r0.e
            if (r1 == 0) goto L_0x0136
            boolean r1 = r0.f
            if (r1 == 0) goto L_0x0131
            int r1 = r8 + 1
            r2[r8] = r12
            r8 = r1
        L_0x0131:
            int r1 = r8 + 1
            r2[r8] = r14
            r8 = r1
        L_0x0136:
            r9 = r8
            goto L_0x01bd
        L_0x0139:
            int r10 = r11 - r5
            int r13 = r4 + -2
            if (r10 != r13) goto L_0x01a5
            if (r5 <= r7) goto L_0x0147
            byte[] r10 = r0.j
            byte r8 = r10[r8]
            r10 = r7
            goto L_0x0151
        L_0x0147:
            int r10 = r11 + 1
            byte r11 = r19[r11]
            r17 = r10
            r10 = r8
            r8 = r11
            r11 = r17
        L_0x0151:
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r14
            if (r5 <= 0) goto L_0x015d
            byte[] r13 = r0.j
            int r15 = r10 + 1
            byte r10 = r13[r10]
            goto L_0x0164
        L_0x015d:
            int r13 = r11 + 1
            byte r11 = r19[r11]
            r15 = r10
            r10 = r11
            r11 = r13
        L_0x0164:
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r6 = r10 << 2
            r6 = r6 | r8
            int r5 = r5 - r15
            r0.c = r5
            int r5 = r9 + 1
            int r8 = r6 >> 12
            r8 = r8 & 63
            byte r8 = r1[r8]
            r2[r9] = r8
            int r8 = r9 + 2
            int r10 = r6 >> 6
            r10 = r10 & 63
            byte r10 = r1[r10]
            r2[r5] = r10
            int r5 = r9 + 3
            r6 = r6 & 63
            byte r1 = r1[r6]
            r2[r8] = r1
            boolean r1 = r0.d
            if (r1 == 0) goto L_0x0191
            int r9 = r9 + 4
            r2[r5] = r16
            r5 = r9
        L_0x0191:
            boolean r1 = r0.e
            if (r1 == 0) goto L_0x01a3
            boolean r1 = r0.f
            if (r1 == 0) goto L_0x019e
            int r1 = r5 + 1
            r2[r5] = r12
            r5 = r1
        L_0x019e:
            int r1 = r5 + 1
            r2[r5] = r14
            r5 = r1
        L_0x01a3:
            r9 = r5
            goto L_0x01bd
        L_0x01a5:
            boolean r1 = r0.e
            if (r1 == 0) goto L_0x01bd
            if (r9 <= 0) goto L_0x01bd
            r1 = 19
            if (r3 == r1) goto L_0x01bd
            boolean r1 = r0.f
            if (r1 == 0) goto L_0x01b8
            int r1 = r9 + 1
            r2[r9] = r12
            r9 = r1
        L_0x01b8:
            int r1 = r9 + 1
            r2[r9] = r14
            r9 = r1
        L_0x01bd:
            boolean r1 = g
            if (r1 != 0) goto L_0x01cc
            int r2 = r0.c
            if (r2 != 0) goto L_0x01c6
            goto L_0x01cc
        L_0x01c6:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01cc:
            if (r1 != 0) goto L_0x01ff
            if (r11 != r4) goto L_0x01d1
            goto L_0x01ff
        L_0x01d1:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x01d7:
            int r1 = r4 + -1
            if (r11 != r1) goto L_0x01e8
            byte[] r1 = r0.j
            int r2 = r0.c
            int r4 = r2 + 1
            r0.c = r4
            byte r4 = r19[r11]
            r1[r2] = r4
            goto L_0x01ff
        L_0x01e8:
            int r4 = r4 - r6
            if (r11 != r4) goto L_0x01ff
            byte[] r1 = r0.j
            int r2 = r0.c
            int r4 = r2 + 1
            r0.c = r4
            byte r5 = r19[r11]
            r1[r2] = r5
            int r2 = r2 + r6
            r0.c = r2
            int r11 = r11 + r7
            byte r2 = r19[r11]
            r1[r4] = r2
        L_0x01ff:
            r0.b = r9
            r0.k = r3
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.k.a(byte[], int, int, boolean):boolean");
    }
}
