package com.huawei.hms.scankit.p;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.location.LocationRequestCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.flyco.roundview.BuildConfig;
import com.microtech.aidexx.ota.OtaManagerKt;

/* compiled from: ErrorCorrection */
public final class z2 {
    private static final int[] a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{175, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, 168, 2, 188, 160, 153, 145, 253, 79, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, 205, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, 213, 141, 136, 120, 151, 233, 168, 93, 255}, new int[]{245, 127, 242, 218, 130, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 162, 181, LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY, 120, 84, 179, 220, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, 175, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, OtaManagerKt.INITIALIZATION_MTU_VALUE, 105, 122, 2, 245, 133, 242, 8, 175, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, 238, 133, 238, 231, 205, 188, 237, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, 160, 175, 69, 213, 92, 253, 225, 19}, new int[]{175, 9, 223, 238, 12, 17, 220, 208, 100, 29, 175, 170, 230, 192, 215, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, 203, 29, 232, 144, 238, 22, 150, 201, 117, 62, 207, 164, 13, 137, 245, 127, 67, OtaManagerKt.INITIALIZATION_MTU_VALUE, 28, 155, 43, 203, 107, 233, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, 143, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 196, 37, 185, 112, 134, 230, 245, 63, 197, 190, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 106, 185, 221, 175, 64, BuildConfig.VERSION_CODE, 71, 161, 44, 147, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, 170, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, 204}, new int[]{220, 228, 173, 89, 251, 149, 159, 56, 89, 33, 147, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, 185, 202, 167, 179, 25, 220, 232, 96, 210, 231, 136, 223, 239, 181, 241, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] c = new int[256];
    private static final int[] d = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            int[] iArr = d;
            if (w7.a(iArr, i2)) {
                iArr[i2] = i;
            }
            int[] iArr2 = c;
            if (w7.a(iArr2, i)) {
                iArr2[i] = i2;
            }
            i *= 2;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    public static String a(String str, d7 d7Var) {
        if (str.length() == d7Var.a()) {
            StringBuilder sb = new StringBuilder(d7Var.a() + d7Var.b());
            sb.append(str);
            int d2 = d7Var.d();
            if (d2 == 1) {
                sb.append(a((CharSequence) str, d7Var.b()));
            } else {
                sb.setLength(sb.capacity());
                int[] iArr = new int[d2];
                int[] iArr2 = new int[d2];
                int[] iArr3 = new int[d2];
                int i = 0;
                while (i < d2) {
                    int i2 = i + 1;
                    iArr[i] = d7Var.a(i2);
                    iArr2[i] = d7Var.b(i2);
                    iArr3[i] = 0;
                    if (i > 0) {
                        iArr3[i] = iArr3[i - 1] + iArr[i];
                    }
                    i = i2;
                }
                for (int i3 = 0; i3 < d2; i3++) {
                    StringBuilder sb2 = new StringBuilder(iArr[i3]);
                    for (int i4 = i3; i4 < d7Var.a(); i4 += d2) {
                        sb2.append(str.charAt(i4));
                    }
                    String a2 = a((CharSequence) sb2.toString(), iArr2[i3]);
                    int i5 = i3;
                    int i6 = 0;
                    while (i5 < iArr2[i3] * d2) {
                        sb.setCharAt(d7Var.a() + i5, a2.charAt(i6));
                        i5 += d2;
                        i6++;
                    }
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
    }

    private static String a(CharSequence charSequence, int i) {
        return a(charSequence, 0, charSequence.length(), i);
    }

    private static String a(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = a;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            } else if (iArr[i6] == i3) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            int[] iArr2 = b[i6];
            char[] cArr = new char[i3];
            for (int i7 = 0; i7 < i3; i7++) {
                cArr[i7] = 0;
            }
            for (int i8 = i; i8 < i + i2; i8++) {
                int i9 = i3 - 1;
                char charAt = cArr[i9] ^ charSequence.charAt(i8);
                while (i9 > 0) {
                    if (charAt == 0 || (i5 = iArr2[i9]) == 0) {
                        cArr[i9] = cArr[i9 - 1];
                    } else {
                        char c2 = cArr[i9 - 1];
                        int[] iArr3 = d;
                        int[] iArr4 = c;
                        cArr[i9] = (char) (iArr3[(iArr4[charAt] + iArr4[i5]) % 255] ^ c2);
                    }
                    i9--;
                }
                if (charAt == 0 || (i4 = iArr2[0]) == 0) {
                    cArr[0] = 0;
                } else {
                    int[] iArr5 = d;
                    int[] iArr6 = c;
                    cArr[0] = (char) iArr5[(iArr6[charAt] + iArr6[i4]) % 255];
                }
            }
            char[] cArr2 = new char[i3];
            for (int i10 = 0; i10 < i3; i10++) {
                cArr2[i10] = cArr[(i3 - i10) - 1];
            }
            return String.valueOf(cArr2);
        }
        throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
    }
}
