package com.huawei.hms.scankit.p;

/* compiled from: Mode */
public enum v4 {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HEXADECIMAL(new int[]{8, 10, 12}, 10),
    HEXABYTE(new int[]{8, 10, 12}, 11),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int[] a;
    private final int b;

    private v4(int[] iArr, int i) {
        this.a = iArr;
        this.b = i;
    }

    public static v4 a(int i) {
        switch (i) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
            case 10:
                return HEXADECIMAL;
            case 11:
                return HEXABYTE;
            case 13:
                return HANZI;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int a(a8 a8Var) {
        int m = a8Var.m();
        return this.a[m <= 9 ? 0 : m <= 26 ? (char) 1 : 2];
    }
}
