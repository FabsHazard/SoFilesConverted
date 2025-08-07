package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;

/* compiled from: MatrixUtil */
final class t4 {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c;
    private static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static {
        int[] iArr = new int[7];
        int[] iArr2 = iArr;
        // fill-array-data instruction
        iArr[0] = -1;
        iArr[1] = -1;
        iArr[2] = -1;
        iArr[3] = -1;
        iArr[4] = -1;
        iArr[5] = -1;
        iArr[6] = -1;
        int[] iArr3 = new int[7];
        int[] iArr4 = iArr3;
        // fill-array-data instruction
        iArr3[0] = 6;
        iArr3[1] = 18;
        iArr3[2] = -1;
        iArr3[3] = -1;
        iArr3[4] = -1;
        iArr3[5] = -1;
        iArr3[6] = -1;
        int[] iArr5 = new int[7];
        int[] iArr6 = iArr5;
        // fill-array-data instruction
        iArr5[0] = 6;
        iArr5[1] = 22;
        iArr5[2] = -1;
        iArr5[3] = -1;
        iArr5[4] = -1;
        iArr5[5] = -1;
        iArr5[6] = -1;
        int[] iArr7 = new int[7];
        int[] iArr8 = iArr7;
        // fill-array-data instruction
        iArr7[0] = 6;
        iArr7[1] = 26;
        iArr7[2] = -1;
        iArr7[3] = -1;
        iArr7[4] = -1;
        iArr7[5] = -1;
        iArr7[6] = -1;
        int[] iArr9 = new int[7];
        int[] iArr10 = iArr9;
        // fill-array-data instruction
        iArr9[0] = 6;
        iArr9[1] = 30;
        iArr9[2] = -1;
        iArr9[3] = -1;
        iArr9[4] = -1;
        iArr9[5] = -1;
        iArr9[6] = -1;
        int[] iArr11 = new int[7];
        int[] iArr12 = iArr11;
        // fill-array-data instruction
        iArr11[0] = 6;
        iArr11[1] = 34;
        iArr11[2] = -1;
        iArr11[3] = -1;
        iArr11[4] = -1;
        iArr11[5] = -1;
        iArr11[6] = -1;
        int[] iArr13 = new int[7];
        int[] iArr14 = iArr13;
        // fill-array-data instruction
        iArr13[0] = 6;
        iArr13[1] = 22;
        iArr13[2] = 38;
        iArr13[3] = -1;
        iArr13[4] = -1;
        iArr13[5] = -1;
        iArr13[6] = -1;
        int[] iArr15 = new int[7];
        int[] iArr16 = iArr15;
        // fill-array-data instruction
        iArr15[0] = 6;
        iArr15[1] = 24;
        iArr15[2] = 42;
        iArr15[3] = -1;
        iArr15[4] = -1;
        iArr15[5] = -1;
        iArr15[6] = -1;
        int[] iArr17 = new int[7];
        int[] iArr18 = iArr17;
        // fill-array-data instruction
        iArr17[0] = 6;
        iArr17[1] = 26;
        iArr17[2] = 46;
        iArr17[3] = -1;
        iArr17[4] = -1;
        iArr17[5] = -1;
        iArr17[6] = -1;
        int[] iArr19 = new int[7];
        int[] iArr20 = iArr19;
        // fill-array-data instruction
        iArr19[0] = 6;
        iArr19[1] = 28;
        iArr19[2] = 50;
        iArr19[3] = -1;
        iArr19[4] = -1;
        iArr19[5] = -1;
        iArr19[6] = -1;
        int[] iArr21 = new int[7];
        int[] iArr22 = iArr21;
        // fill-array-data instruction
        iArr21[0] = 6;
        iArr21[1] = 30;
        iArr21[2] = 54;
        iArr21[3] = -1;
        iArr21[4] = -1;
        iArr21[5] = -1;
        iArr21[6] = -1;
        int[] iArr23 = new int[7];
        int[] iArr24 = iArr23;
        // fill-array-data instruction
        iArr23[0] = 6;
        iArr23[1] = 32;
        iArr23[2] = 58;
        iArr23[3] = -1;
        iArr23[4] = -1;
        iArr23[5] = -1;
        iArr23[6] = -1;
        int[] iArr25 = new int[7];
        int[] iArr26 = iArr25;
        // fill-array-data instruction
        iArr25[0] = 6;
        iArr25[1] = 34;
        iArr25[2] = 62;
        iArr25[3] = -1;
        iArr25[4] = -1;
        iArr25[5] = -1;
        iArr25[6] = -1;
        int[] iArr27 = new int[7];
        int[] iArr28 = iArr27;
        // fill-array-data instruction
        iArr27[0] = 6;
        iArr27[1] = 26;
        iArr27[2] = 46;
        iArr27[3] = 66;
        iArr27[4] = -1;
        iArr27[5] = -1;
        iArr27[6] = -1;
        int[] iArr29 = new int[7];
        int[] iArr30 = iArr29;
        // fill-array-data instruction
        iArr29[0] = 6;
        iArr29[1] = 26;
        iArr29[2] = 48;
        iArr29[3] = 70;
        iArr29[4] = -1;
        iArr29[5] = -1;
        iArr29[6] = -1;
        int[] iArr31 = new int[7];
        int[] iArr32 = iArr31;
        // fill-array-data instruction
        iArr31[0] = 6;
        iArr31[1] = 26;
        iArr31[2] = 50;
        iArr31[3] = 74;
        iArr31[4] = -1;
        iArr31[5] = -1;
        iArr31[6] = -1;
        int[] iArr33 = new int[7];
        int[] iArr34 = iArr33;
        // fill-array-data instruction
        iArr33[0] = 6;
        iArr33[1] = 30;
        iArr33[2] = 54;
        iArr33[3] = 78;
        iArr33[4] = -1;
        iArr33[5] = -1;
        iArr33[6] = -1;
        int[] iArr35 = new int[7];
        int[] iArr36 = iArr35;
        // fill-array-data instruction
        iArr35[0] = 6;
        iArr35[1] = 30;
        iArr35[2] = 56;
        iArr35[3] = 82;
        iArr35[4] = -1;
        iArr35[5] = -1;
        iArr35[6] = -1;
        int[] iArr37 = new int[7];
        int[] iArr38 = iArr37;
        // fill-array-data instruction
        iArr37[0] = 6;
        iArr37[1] = 30;
        iArr37[2] = 58;
        iArr37[3] = 86;
        iArr37[4] = -1;
        iArr37[5] = -1;
        iArr37[6] = -1;
        int[] iArr39 = new int[7];
        int[] iArr40 = iArr39;
        // fill-array-data instruction
        iArr39[0] = 6;
        iArr39[1] = 34;
        iArr39[2] = 62;
        iArr39[3] = 90;
        iArr39[4] = -1;
        iArr39[5] = -1;
        iArr39[6] = -1;
        int[] iArr41 = new int[7];
        int[] iArr42 = iArr41;
        // fill-array-data instruction
        iArr41[0] = 6;
        iArr41[1] = 28;
        iArr41[2] = 50;
        iArr41[3] = 72;
        iArr41[4] = 94;
        iArr41[5] = -1;
        iArr41[6] = -1;
        int[] iArr43 = new int[7];
        int[] iArr44 = iArr43;
        // fill-array-data instruction
        iArr43[0] = 6;
        iArr43[1] = 26;
        iArr43[2] = 50;
        iArr43[3] = 74;
        iArr43[4] = 98;
        iArr43[5] = -1;
        iArr43[6] = -1;
        int[] iArr45 = new int[7];
        int[] iArr46 = iArr45;
        // fill-array-data instruction
        iArr45[0] = 6;
        iArr45[1] = 30;
        iArr45[2] = 54;
        iArr45[3] = 78;
        iArr45[4] = 102;
        iArr45[5] = -1;
        iArr45[6] = -1;
        int[] iArr47 = new int[7];
        int[] iArr48 = iArr47;
        // fill-array-data instruction
        iArr47[0] = 6;
        iArr47[1] = 28;
        iArr47[2] = 54;
        iArr47[3] = 80;
        iArr47[4] = 106;
        iArr47[5] = -1;
        iArr47[6] = -1;
        int[] iArr49 = new int[7];
        int[] iArr50 = iArr49;
        // fill-array-data instruction
        iArr49[0] = 6;
        iArr49[1] = 32;
        iArr49[2] = 58;
        iArr49[3] = 84;
        iArr49[4] = 110;
        iArr49[5] = -1;
        iArr49[6] = -1;
        int[] iArr51 = new int[7];
        int[] iArr52 = iArr51;
        // fill-array-data instruction
        iArr51[0] = 6;
        iArr51[1] = 30;
        iArr51[2] = 58;
        iArr51[3] = 86;
        iArr51[4] = 114;
        iArr51[5] = -1;
        iArr51[6] = -1;
        int[] iArr53 = new int[7];
        int[] iArr54 = iArr53;
        // fill-array-data instruction
        iArr53[0] = 6;
        iArr53[1] = 34;
        iArr53[2] = 62;
        iArr53[3] = 90;
        iArr53[4] = 118;
        iArr53[5] = -1;
        iArr53[6] = -1;
        int[] iArr55 = new int[7];
        int[] iArr56 = iArr55;
        // fill-array-data instruction
        iArr55[0] = 6;
        iArr55[1] = 26;
        iArr55[2] = 50;
        iArr55[3] = 74;
        iArr55[4] = 98;
        iArr55[5] = 122;
        iArr55[6] = -1;
        int[] iArr57 = new int[7];
        int[] iArr58 = iArr57;
        // fill-array-data instruction
        iArr57[0] = 6;
        iArr57[1] = 30;
        iArr57[2] = 54;
        iArr57[3] = 78;
        iArr57[4] = 102;
        iArr57[5] = 126;
        iArr57[6] = -1;
        int[] iArr59 = new int[7];
        int[] iArr60 = iArr59;
        // fill-array-data instruction
        iArr59[0] = 6;
        iArr59[1] = 26;
        iArr59[2] = 52;
        iArr59[3] = 78;
        iArr59[4] = 104;
        iArr59[5] = 130;
        iArr59[6] = -1;
        int[] iArr61 = new int[7];
        int[] iArr62 = iArr61;
        // fill-array-data instruction
        iArr61[0] = 6;
        iArr61[1] = 30;
        iArr61[2] = 56;
        iArr61[3] = 82;
        iArr61[4] = 108;
        iArr61[5] = 134;
        iArr61[6] = -1;
        int[] iArr63 = new int[7];
        int[] iArr64 = iArr63;
        // fill-array-data instruction
        iArr63[0] = 6;
        iArr63[1] = 34;
        iArr63[2] = 60;
        iArr63[3] = 86;
        iArr63[4] = 112;
        iArr63[5] = 138;
        iArr63[6] = -1;
        int[] iArr65 = new int[7];
        int[] iArr66 = iArr65;
        // fill-array-data instruction
        iArr65[0] = 6;
        iArr65[1] = 30;
        iArr65[2] = 58;
        iArr65[3] = 86;
        iArr65[4] = 114;
        iArr65[5] = 142;
        iArr65[6] = -1;
        int[] iArr67 = new int[7];
        int[] iArr68 = iArr67;
        // fill-array-data instruction
        iArr67[0] = 6;
        iArr67[1] = 34;
        iArr67[2] = 62;
        iArr67[3] = 90;
        iArr67[4] = 118;
        iArr67[5] = 146;
        iArr67[6] = -1;
        int[] iArr69 = new int[7];
        int[] iArr70 = iArr69;
        // fill-array-data instruction
        iArr69[0] = 6;
        iArr69[1] = 30;
        iArr69[2] = 54;
        iArr69[3] = 78;
        iArr69[4] = 102;
        iArr69[5] = 126;
        iArr69[6] = 150;
        int[] iArr71 = new int[7];
        int[] iArr72 = iArr71;
        // fill-array-data instruction
        iArr71[0] = 6;
        iArr71[1] = 24;
        iArr71[2] = 50;
        iArr71[3] = 76;
        iArr71[4] = 102;
        iArr71[5] = 128;
        iArr71[6] = 154;
        int[] iArr73 = new int[7];
        int[] iArr74 = iArr73;
        // fill-array-data instruction
        iArr73[0] = 6;
        iArr73[1] = 28;
        iArr73[2] = 54;
        iArr73[3] = 80;
        iArr73[4] = 106;
        iArr73[5] = 132;
        iArr73[6] = 158;
        int[] iArr75 = new int[7];
        int[] iArr76 = iArr75;
        // fill-array-data instruction
        iArr75[0] = 6;
        iArr75[1] = 32;
        iArr75[2] = 58;
        iArr75[3] = 84;
        iArr75[4] = 110;
        iArr75[5] = 136;
        iArr75[6] = 162;
        int[] iArr77 = new int[7];
        int[] iArr78 = iArr77;
        // fill-array-data instruction
        iArr77[0] = 6;
        iArr77[1] = 26;
        iArr77[2] = 54;
        iArr77[3] = 82;
        iArr77[4] = 110;
        iArr77[5] = 138;
        iArr77[6] = 166;
        int[] iArr79 = new int[7];
        // fill-array-data instruction
        iArr79[0] = 6;
        iArr79[1] = 30;
        iArr79[2] = 58;
        iArr79[3] = 86;
        iArr79[4] = 114;
        iArr79[5] = 142;
        iArr79[6] = 170;
        c = new int[][]{iArr2, iArr4, iArr6, iArr8, iArr10, iArr12, iArr14, iArr16, iArr18, iArr20, iArr22, iArr24, iArr26, iArr28, iArr30, iArr32, iArr34, iArr36, iArr38, iArr40, iArr42, iArr44, iArr46, iArr48, iArr50, iArr52, iArr54, iArr56, iArr58, iArr60, iArr62, iArr64, iArr66, iArr68, iArr70, iArr72, iArr74, iArr76, iArr78, iArr79};
    }

    static void a(c0 c0Var) {
        c0Var.a((byte) -1);
    }

    private static void b(c0 c0Var) throws WriterException {
        if (c0Var.a(8, c0Var.b() - 8) != 0) {
            c0Var.a(8, c0Var.b() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static boolean b(int i) {
        return i == -1;
    }

    static void c(b8 b8Var, c0 c0Var) throws WriterException {
        if (b8Var.f() >= 7) {
            r rVar = new r();
            a(b8Var, rVar);
            int i = 17;
            for (int i2 = 0; i2 < 6; i2++) {
                for (int i3 = 0; i3 < 3; i3++) {
                    boolean b2 = rVar.b(i);
                    i--;
                    c0Var.a(i2, (c0Var.b() - 11) + i3, b2);
                    c0Var.a((c0Var.b() - 11) + i3, i2, b2);
                }
            }
        }
    }

    private static void d(c0 c0Var) {
        int i = 8;
        while (i < c0Var.c() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (b((int) c0Var.a(i, 6))) {
                c0Var.a(i, 6, i3);
            }
            if (b((int) c0Var.a(6, i))) {
                c0Var.a(6, i, i3);
            }
            i = i2;
        }
    }

    static void a(r rVar, b3 b3Var, b8 b8Var, int i, c0 c0Var) throws WriterException {
        a(c0Var);
        a(b8Var, c0Var);
        a(b3Var, i, c0Var);
        c(b8Var, c0Var);
        a(rVar, i, c0Var);
    }

    private static void b(int i, int i2, c0 c0Var) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                c0Var.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void b(b8 b8Var, c0 c0Var) {
        if (b8Var.f() >= 2) {
            int f = b8Var.f() - 1;
            int[][] iArr = c;
            if (f < iArr.length) {
                int[] iArr2 = iArr[f];
                for (int i : iArr2) {
                    if (i >= 0) {
                        for (int i2 : iArr2) {
                            if (i2 >= 0 && b((int) c0Var.a(i2, i))) {
                                b(i2 - 2, i - 2, c0Var);
                            }
                        }
                    }
                }
            }
        }
    }

    static void a(b8 b8Var, c0 c0Var) throws WriterException {
        c(c0Var);
        b(c0Var);
        b(b8Var, c0Var);
        d(c0Var);
    }

    private static void d(int i, int i2, c0 c0Var) throws WriterException {
        int i3 = 0;
        while (i3 < 7) {
            int i4 = i2 + i3;
            if (b((int) c0Var.a(i, i4))) {
                c0Var.a(i, i4, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void c(int i, int i2, c0 c0Var) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                c0Var.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    static void a(b3 b3Var, int i, c0 c0Var) throws WriterException {
        r rVar = new r();
        a(b3Var, i, rVar);
        for (int i2 = 0; i2 < rVar.e(); i2++) {
            boolean b2 = rVar.b((rVar.e() - 1) - i2);
            int[] iArr = d[i2];
            c0Var.a(iArr[0], iArr[1], b2);
            if (i2 < 8) {
                c0Var.a((c0Var.c() - i2) - 1, 8, b2);
            } else {
                c0Var.a(8, (c0Var.b() - 7) + (i2 - 8), b2);
            }
        }
    }

    private static void c(c0 c0Var) throws WriterException {
        int length = a[0].length;
        c(0, 0, c0Var);
        c(c0Var.c() - length, 0, c0Var);
        c(0, c0Var.c() - length, c0Var);
        a(0, 7, c0Var);
        a(c0Var.c() - 8, 7, c0Var);
        a(0, c0Var.c() - 8, c0Var);
        d(7, 0, c0Var);
        d(c0Var.b() - 8, 0, c0Var);
        d(7, c0Var.b() - 7, c0Var);
    }

    static void a(r rVar, int i, c0 c0Var) throws WriterException {
        boolean z;
        int c2 = c0Var.c() - 1;
        int b2 = c0Var.b() - 1;
        int i2 = 0;
        int i3 = -1;
        while (c2 > 0) {
            if (c2 == 6) {
                c2--;
            }
            while (b2 >= 0 && b2 < c0Var.b()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = c2 - i4;
                    if (b((int) c0Var.a(i5, b2))) {
                        if (i2 < rVar.e()) {
                            z = rVar.b(i2);
                            i2++;
                        } else {
                            z = false;
                        }
                        if (i != -1 && r4.a(i, i5, b2)) {
                            z = !z;
                        }
                        c0Var.a(i5, b2, z);
                    }
                }
                b2 += i3;
            }
            i3 = -i3;
            b2 += i3;
            c2 -= 2;
        }
        if (i2 != rVar.e()) {
            throw new WriterException("Not all bits consumed: " + i2 + '/' + rVar.e());
        }
    }

    static int a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    static int a(int i, int i2) {
        if (i2 != 0) {
            int a2 = a(i2);
            int i3 = i << (a2 - 1);
            while (a(i3) >= a2) {
                i3 ^= i2 << (a(i3) - a2);
            }
            return i3;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(b3 b3Var, int i, r rVar) throws WriterException {
        if (h6.a(i)) {
            int a2 = (b3Var.a() << 3) | i;
            rVar.a(a2, 5);
            rVar.a(a(a2, 1335), 10);
            r rVar2 = new r();
            rVar2.a(21522, 15);
            rVar.b(rVar2);
            if (rVar.e() != 15) {
                throw new WriterException("should not happen but we got: " + rVar.e());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(b8 b8Var, r rVar) throws WriterException {
        rVar.a(b8Var.f(), 6);
        rVar.a(a(b8Var.f(), 7973), 12);
        if (rVar.e() != 18) {
            throw new WriterException("should not happen but we got: " + rVar.e());
        }
    }

    private static void a(int i, int i2, c0 c0Var) throws WriterException {
        int i3 = 0;
        while (i3 < 8) {
            int i4 = i + i3;
            if (b((int) c0Var.a(i4, i2))) {
                c0Var.a(i4, i2, 0);
                i3++;
            } else {
                throw new WriterException();
            }
        }
    }
}
