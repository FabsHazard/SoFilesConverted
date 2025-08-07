package com.huawei.hms.scankit.p;

import kotlin.text.Typography;

/* compiled from: BinaryShiftToken */
final class q extends i7 {
    private final short c;
    private final short d;

    q(i7 i7Var, int i, int i2) {
        super(i7Var);
        this.c = (short) i;
        this.d = (short) i2;
    }

    public void a(r rVar, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.d;
            if (i < s) {
                if (i == 0 || (i == 31 && s <= 62)) {
                    rVar.a(31, 5);
                    short s2 = this.d;
                    if (s2 > 62) {
                        rVar.a(s2 - 31, 16);
                    } else if (i == 0) {
                        rVar.a(Math.min(s2, 31), 5);
                    } else {
                        rVar.a(s2 - 31, 5);
                    }
                }
                rVar.a(bArr[this.c + i], 8);
                i++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "<" + this.c + "::" + ((this.c + this.d) - 1) + Typography.greater;
    }
}
