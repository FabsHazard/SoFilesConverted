package net.lingala.zip4j.crypto.PBKDF2;

class BinTools {
    public static final String hex = "0123456789ABCDEF";

    BinTools() {
    }

    public static String bin2hex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            int i = (b + 256) % 256;
            stringBuffer.append(hex.charAt((i / 16) & 15));
            stringBuffer.append(hex.charAt((i % 16) & 15));
        }
        return stringBuffer.toString();
    }

    public static byte[] hex2bin(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() % 2 != 0) {
            str = "0" + str;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            i += 2;
            bArr[i2] = (byte) ((hex2bin(charAt) * 16) + hex2bin(str.charAt(i3)));
            i2++;
        }
        return bArr;
    }

    public static int hex2bin(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'A' && c <= 'F') {
            return c - '7';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        throw new IllegalArgumentException("Input string may only contain hex digits, but found '" + c + "'");
    }
}
