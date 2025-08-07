package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: -Utf8.kt */
public final class _Utf8Kt {
    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008a, code lost:
        if ((r0[r5] & 192) == 128) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00ec, code lost:
        if ((r0[r5] & 192) == 128) goto L_0x00ee;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String commonToUtf8String(byte[] r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            if (r1 < 0) goto L_0x0174
            int r3 = r0.length
            if (r2 > r3) goto L_0x0174
            if (r1 > r2) goto L_0x0174
            int r3 = r2 - r1
            char[] r3 = new char[r3]
            r4 = 0
            r5 = r4
        L_0x0018:
            if (r1 >= r2) goto L_0x016f
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0034
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            int r1 = r1 + 1
        L_0x0025:
            r5 = r7
            if (r1 >= r2) goto L_0x0018
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0018
            int r1 = r1 + 1
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0025
        L_0x0034:
            int r7 = r6 >> 5
            r8 = -2
            r10 = 128(0x80, float:1.794E-43)
            r11 = 65533(0xfffd, float:9.1831E-41)
            r12 = 1
            if (r7 != r8) goto L_0x006e
            int r7 = r1 + 1
            if (r2 > r7) goto L_0x004b
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x0048:
            r5 = r7
        L_0x0049:
            r9 = r12
            goto L_0x006c
        L_0x004b:
            byte r7 = r0[r7]
            r8 = r7 & 192(0xc0, float:2.69E-43)
            if (r8 != r10) goto L_0x0066
            r7 = r7 ^ 3968(0xf80, float:5.56E-42)
            int r6 = r6 << 6
            r6 = r6 ^ r7
            if (r6 >= r10) goto L_0x005e
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0063
        L_0x005e:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x0063:
            r5 = r7
        L_0x0064:
            r9 = 2
            goto L_0x006c
        L_0x0066:
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0048
        L_0x006c:
            int r1 = r1 + r9
            goto L_0x0018
        L_0x006e:
            int r7 = r6 >> 4
            r13 = 57344(0xe000, float:8.0356E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            r15 = 3
            if (r7 != r8) goto L_0x00ce
            int r7 = r1 + 2
            if (r2 > r7) goto L_0x008d
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x0048
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x0048
        L_0x008c:
            goto L_0x0063
        L_0x008d:
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00c7
            byte r7 = r0[r7]
            r9 = r7 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00c1
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r7 = r7 ^ r9
            int r8 = r8 << 6
            r7 = r7 ^ r8
            int r6 = r6 << 12
            r6 = r6 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 >= r7) goto L_0x00af
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00be
        L_0x00af:
            if (r14 > r6) goto L_0x00b9
            if (r6 >= r13) goto L_0x00b9
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00be
        L_0x00b9:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x00be:
            r5 = r7
        L_0x00bf:
            r9 = r15
            goto L_0x006c
        L_0x00c1:
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x008c
        L_0x00c7:
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0048
        L_0x00ce:
            int r7 = r6 >> 3
            if (r7 != r8) goto L_0x0166
            int r7 = r1 + 3
            if (r2 > r7) goto L_0x00f6
            int r6 = r5 + 1
            r3[r5] = r11
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x00f3
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x00f3
            int r5 = r1 + 2
            if (r2 <= r5) goto L_0x00f0
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x00f0
        L_0x00ee:
            r5 = r6
            goto L_0x00bf
        L_0x00f0:
            r5 = r6
            goto L_0x0064
        L_0x00f3:
            r5 = r6
            goto L_0x0049
        L_0x00f6:
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x0161
            int r9 = r1 + 2
            byte r9 = r0[r9]
            r12 = r9 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x015c
            byte r7 = r0[r7]
            r12 = r7 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x0157
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r7 = r7 ^ r10
            int r9 = r9 << 6
            r7 = r7 ^ r9
            int r8 = r8 << 12
            r7 = r7 ^ r8
            int r6 = r6 << 18
            r6 = r6 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r7) goto L_0x0123
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0153
        L_0x0123:
            if (r14 > r6) goto L_0x012c
            if (r6 >= r13) goto L_0x012c
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0153
        L_0x012c:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x0135
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0153
        L_0x0135:
            if (r6 == r11) goto L_0x014f
            int r7 = r6 >>> 10
            r8 = 55232(0xd7c0, float:7.7397E-41)
            int r7 = r7 + r8
            char r7 = (char) r7
            int r8 = r5 + 1
            r3[r5] = r7
            r6 = r6 & 1023(0x3ff, float:1.434E-42)
            r7 = 56320(0xdc00, float:7.8921E-41)
            int r6 = r6 + r7
            char r6 = (char) r6
            int r5 = r5 + 2
            r3[r8] = r6
            r6 = r5
            goto L_0x0153
        L_0x014f:
            int r6 = r5 + 1
            r3[r5] = r11
        L_0x0153:
            r9 = 4
            r5 = r6
            goto L_0x006c
        L_0x0157:
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x00ee
        L_0x015c:
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x00f0
        L_0x0161:
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x00f3
        L_0x0166:
            int r6 = r5 + 1
            r3[r5] = r11
            int r1 = r1 + 1
            r5 = r6
            goto L_0x0018
        L_0x016f:
            java.lang.String r0 = kotlin.text.StringsKt.concatToString(r3, r4, r5)
            return r0
        L_0x0174:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "size="
            r4.<init>(r5)
            int r0 = r0.length
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r4 = " beginIndex="
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = " endIndex="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i;
        int i2;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i3 = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (Intrinsics.compare((int) charAt2, 128) >= 0) {
                int length2 = str.length();
                int i4 = i;
                while (i < length2) {
                    char charAt3 = str.charAt(i);
                    if (Intrinsics.compare((int) charAt3, 128) < 0) {
                        int i5 = i4 + 1;
                        bArr[i4] = (byte) charAt3;
                        i++;
                        while (true) {
                            i4 = i5;
                            if (i >= length2 || Intrinsics.compare((int) str.charAt(i), 128) >= 0) {
                                break;
                            }
                            i5 = i4 + 1;
                            bArr[i4] = (byte) str.charAt(i);
                            i++;
                        }
                    } else {
                        if (Intrinsics.compare((int) charAt3, 2048) < 0) {
                            bArr[i4] = (byte) ((charAt3 >> 6) | 192);
                            i4 += 2;
                            bArr[i4 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || charAt3 >= 57344) {
                            bArr[i4] = (byte) ((charAt3 >> 12) | 224);
                            bArr[i4 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i4 += 3;
                            bArr[i4 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (Intrinsics.compare((int) charAt3, 56319) > 0 || length2 <= (i2 = i + 1) || 56320 > (charAt = str.charAt(i2)) || charAt >= 57344) {
                            bArr[i4] = Utf8.REPLACEMENT_BYTE;
                            i++;
                            i4++;
                        } else {
                            int charAt4 = ((charAt3 << 10) + str.charAt(i2)) - 56613888;
                            bArr[i4] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i4 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i4 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i4 += 4;
                            bArr[i4 + 3] = (byte) ((charAt4 & 63) | 128);
                            i += 2;
                        }
                        i++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i4);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i] = (byte) charAt2;
            i3 = i + 1;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        return copyOf2;
    }
}
