package com.huawei.hms.scankit.p;

import androidx.core.location.LocationRequestCompat;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Code128Writer */
public final class s0 extends h5 {

    /* compiled from: Code128Writer */
    private enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<u2, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    public boolean[] a(String str) {
        int i;
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int a2 = a(str, i5, i7);
            int i8 = 100;
            if (a2 == i7) {
                switch (str.charAt(i5)) {
                    case 241:
                        i8 = LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY;
                        break;
                    case 242:
                        i8 = 97;
                        break;
                    case 243:
                        i8 = 96;
                        break;
                    case 244:
                        break;
                    default:
                        if (i7 == 100) {
                            i8 = str.charAt(i5) - ' ';
                            break;
                        } else {
                            try {
                                i8 = Integer.parseInt(str.substring(i5, i5 + 2));
                                i5++;
                                break;
                            } catch (NumberFormatException unused) {
                                throw new IllegalArgumentException("contents substring can not format integer");
                            }
                        }
                }
                i5++;
            } else {
                if (i7 == 0) {
                    i = a2 == 100 ? LocationRequestCompat.QUALITY_LOW_POWER : 105;
                } else {
                    i = a2;
                }
                i7 = a2;
            }
            arrayList.add(r0.a[i]);
            i6 += i * i4;
            if (i5 != 0) {
                i4++;
            }
        }
        int[][] iArr = r0.a;
        arrayList.add(iArr[i6 % 103]);
        arrayList.add(iArr[106]);
        int i9 = 0;
        for (int[] iArr2 : arrayList) {
            for (int i10 : (int[]) r12.next()) {
                i9 += i10;
            }
        }
        boolean[] zArr = new boolean[i9];
        for (int[] a3 : arrayList) {
            i2 += h5.a(zArr, i2, a3, true);
        }
        return zArr;
    }

    private static a a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            return a.ONE_DIGIT;
        }
        return a.TWO_DIGITS;
    }

    private static int a(CharSequence charSequence, int i, int i2) {
        a aVar;
        a a2;
        a a3;
        a a4 = a(charSequence, i);
        a aVar2 = a.UNCODABLE;
        if (!(a4 == aVar2 || a4 == (aVar = a.ONE_DIGIT))) {
            if (i2 == 99) {
                return 99;
            }
            if (i2 == 100) {
                a aVar3 = a.FNC_1;
                if (a4 == aVar3 || (a2 = a(charSequence, i + 2)) == aVar2 || a2 == aVar) {
                    return 100;
                }
                if (a2 == aVar3) {
                    return a(charSequence, i + 3) == a.TWO_DIGITS ? 99 : 100;
                }
                int i3 = i + 4;
                while (true) {
                    a3 = a(charSequence, i3);
                    if (a3 != a.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                return a3 == a.ONE_DIGIT ? 100 : 99;
            }
            if (a4 == a.FNC_1) {
                a4 = a(charSequence, i + 1);
            }
            if (a4 == a.TWO_DIGITS) {
                return 99;
            }
        }
        return 100;
    }
}
