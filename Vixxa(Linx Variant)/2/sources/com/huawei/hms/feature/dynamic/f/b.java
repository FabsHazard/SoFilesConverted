package com.huawei.hms.feature.dynamic.f;

public final class b {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] a(byte[] bArr) {
        return a(bArr, false);
    }

    public static char[] a(byte[] bArr, boolean z) {
        return a(bArr, z ? b : a);
    }

    public static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[(r0 << 1)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i += 2;
            cArr2[i2] = cArr[b2 & 15];
        }
        return cArr2;
    }

    public static String b(byte[] bArr, boolean z) {
        return new String(a(bArr, z));
    }
}
