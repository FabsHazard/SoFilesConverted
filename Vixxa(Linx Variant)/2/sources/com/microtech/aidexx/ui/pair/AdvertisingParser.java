package com.microtech.aidexx.ui.pair;

import java.nio.charset.StandardCharsets;
import kotlin.UByte;

public class AdvertisingParser {
    public static String getName(byte[] bArr) {
        int length = bArr.length;
        String str = "";
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (b == 0 || b + 1 > length) {
                break;
            }
            int i3 = i + 2;
            if ((bArr[i2] & UByte.MAX_VALUE) == 9) {
                str = new String(subBytes(bArr, i3, b - 1), StandardCharsets.UTF_8);
            }
            i = i3 + (b - 1);
        }
        return str;
    }

    public static String getSN(byte[] bArr) {
        String str;
        int length = bArr.length;
        String str2 = "";
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (b == 0 || b + 1 > length) {
                break;
            }
            int i3 = i + 2;
            if ((bArr[i2] & UByte.MAX_VALUE) == 255) {
                if (b == 7) {
                    byte[] subBytes = subBytes(bArr, i3, 6);
                    bytesToSn(subBytes, subBytes.length);
                    str = new String(subBytes);
                } else if (b >= 9) {
                    byte[] subBytes2 = subBytes(bArr, i + 4, 6);
                    bytesToSn(subBytes2, subBytes2.length);
                    str = new String(subBytes2);
                }
                str2 = str;
            }
            i = i3 + (b - 1);
        }
        return str2;
    }

    static void bytesToSn(byte[] bArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byte b = bArr[i2];
            bArr[i2] = (byte) (b > 9 ? b + 55 : b + 48);
        }
    }

    public static byte[] subBytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }
}
