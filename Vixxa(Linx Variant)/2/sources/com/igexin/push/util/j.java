package com.igexin.push.util;

class j extends i {
    private static final int[] c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int e;
    private int f;
    private final int[] g;

    public j(int i, byte[] bArr) {
        this.a = bArr;
        this.g = (i & 8) == 0 ? c : d;
        this.e = 0;
        this.f = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x00eb A[EDGE_INSN: B:73:0x00eb->B:54:0x00eb ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(byte[] r17, int r18, int r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r0.e
            r2 = 0
            r3 = 6
            if (r1 != r3) goto L_0x0009
            return r2
        L_0x0009:
            int r4 = r19 + r18
            int r5 = r0.f
            byte[] r6 = r0.a
            int[] r7 = r0.g
            r9 = r2
            r8 = r5
            r5 = r1
            r1 = r18
        L_0x0016:
            r10 = 3
            r11 = 4
            r12 = 2
            r13 = 1
            if (r1 >= r4) goto L_0x00eb
            if (r5 != 0) goto L_0x0063
        L_0x001e:
            int r14 = r1 + 4
            if (r14 > r4) goto L_0x005f
            byte r8 = r17[r1]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r8 = r7[r8]
            int r8 = r8 << 18
            int r15 = r1 + 1
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            int r15 = r15 << 12
            r8 = r8 | r15
            int r15 = r1 + 2
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            int r15 = r15 << r3
            r8 = r8 | r15
            int r15 = r1 + 3
            byte r15 = r17[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r15 = r7[r15]
            r8 = r8 | r15
            if (r8 < 0) goto L_0x005f
            int r1 = r9 + 2
            byte r15 = (byte) r8
            r6[r1] = r15
            int r1 = r9 + 1
            int r15 = r8 >> 8
            byte r15 = (byte) r15
            r6[r1] = r15
            int r1 = r8 >> 16
            byte r1 = (byte) r1
            r6[r9] = r1
            int r9 = r9 + 3
            r1 = r14
            goto L_0x001e
        L_0x005f:
            if (r1 < r4) goto L_0x0063
            goto L_0x00eb
        L_0x0063:
            int r14 = r1 + 1
            byte r1 = r17[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r1 = r7[r1]
            r15 = -1
            if (r5 == 0) goto L_0x00dd
            if (r5 == r13) goto L_0x00d2
            r13 = -2
            if (r5 == r12) goto L_0x00be
            r12 = 5
            if (r5 == r10) goto L_0x008c
            if (r5 == r11) goto L_0x0081
            if (r5 == r12) goto L_0x007c
            goto L_0x00e8
        L_0x007c:
            if (r1 == r15) goto L_0x00e8
            r0.e = r3
            return r2
        L_0x0081:
            if (r1 != r13) goto L_0x0087
            int r5 = r5 + 1
            goto L_0x00e8
        L_0x0087:
            if (r1 == r15) goto L_0x00e8
            r0.e = r3
            return r2
        L_0x008c:
            if (r1 < 0) goto L_0x00a7
            int r5 = r8 << 6
            r1 = r1 | r5
            int r5 = r9 + 2
            byte r8 = (byte) r1
            r6[r5] = r8
            int r5 = r9 + 1
            int r8 = r1 >> 8
            byte r8 = (byte) r8
            r6[r5] = r8
            int r5 = r1 >> 16
            byte r5 = (byte) r5
            r6[r9] = r5
            int r9 = r9 + 3
            r8 = r1
            r5 = r2
            goto L_0x00e8
        L_0x00a7:
            if (r1 != r13) goto L_0x00b9
            int r1 = r9 + 1
            int r5 = r8 >> 2
            byte r5 = (byte) r5
            r6[r1] = r5
            int r1 = r8 >> 10
            byte r1 = (byte) r1
            r6[r9] = r1
            int r9 = r9 + 2
            r5 = r12
            goto L_0x00e8
        L_0x00b9:
            if (r1 == r15) goto L_0x00e8
            r0.e = r3
            return r2
        L_0x00be:
            if (r1 < 0) goto L_0x00c1
            goto L_0x00d4
        L_0x00c1:
            if (r1 != r13) goto L_0x00cd
            int r1 = r9 + 1
            int r5 = r8 >> 4
            byte r5 = (byte) r5
            r6[r9] = r5
            r9 = r1
            r5 = r11
            goto L_0x00e8
        L_0x00cd:
            if (r1 == r15) goto L_0x00e8
            r0.e = r3
            return r2
        L_0x00d2:
            if (r1 < 0) goto L_0x00d8
        L_0x00d4:
            int r8 = r8 << 6
            r1 = r1 | r8
            goto L_0x00df
        L_0x00d8:
            if (r1 == r15) goto L_0x00e8
            r0.e = r3
            return r2
        L_0x00dd:
            if (r1 < 0) goto L_0x00e3
        L_0x00df:
            int r5 = r5 + 1
            r8 = r1
            goto L_0x00e8
        L_0x00e3:
            if (r1 == r15) goto L_0x00e8
            r0.e = r3
            return r2
        L_0x00e8:
            r1 = r14
            goto L_0x0016
        L_0x00eb:
            if (r20 != 0) goto L_0x00f4
            r0.e = r5
            r0.f = r8
        L_0x00f1:
            r0.b = r9
            return r13
        L_0x00f4:
            if (r5 == r13) goto L_0x011a
            if (r5 == r12) goto L_0x010f
            if (r5 == r10) goto L_0x0100
            if (r5 == r11) goto L_0x00fd
            goto L_0x0117
        L_0x00fd:
            r0.e = r3
            return r2
        L_0x0100:
            int r1 = r9 + 1
            int r2 = r8 >> 10
            byte r2 = (byte) r2
            r6[r9] = r2
            int r9 = r9 + 2
            int r2 = r8 >> 2
            byte r2 = (byte) r2
            r6[r1] = r2
            goto L_0x0117
        L_0x010f:
            int r1 = r9 + 1
            int r2 = r8 >> 4
            byte r2 = (byte) r2
            r6[r9] = r2
            r9 = r1
        L_0x0117:
            r0.e = r5
            goto L_0x00f1
        L_0x011a:
            r0.e = r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.j.a(byte[], int, int, boolean):boolean");
    }
}
