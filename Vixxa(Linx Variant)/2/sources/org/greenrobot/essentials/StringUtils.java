package org.greenrobot.essentials;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class StringUtils {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String[] split(String str, char c) {
        String[] strArr = new String[32];
        int i = 0;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(c, i);
            if (indexOf != -1) {
                if (i2 == strArr.length) {
                    strArr = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                strArr[i2] = str.substring(i, indexOf);
                i = indexOf + 1;
                i2++;
            } else {
                String[] strArr2 = (String[]) Arrays.copyOf(strArr, i2 + 1);
                strArr2[i2] = str.substring(i);
                return strArr2;
            }
        }
    }

    public static String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encodeUrlIso(String str) {
        try {
            return URLEncoder.encode(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decodeUrl(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decodeUrlIso(String str) {
        try {
            return URLDecoder.decode(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5(String str) {
        return digest(str, MessageDigestAlgorithms.MD5, "UTF-8");
    }

    public static String sha1(String str) {
        return digest(str, MessageDigestAlgorithms.SHA_1, "UTF-8");
    }

    public static String sha256(String str) {
        return digest(str, MessageDigestAlgorithms.SHA_256, "UTF-8");
    }

    public static String digest(String str, String str2, String str3) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(str.getBytes(str3));
            return hex(instance.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hex(byte[] bArr) {
        int length = bArr.length * 2;
        char[] cArr = new char[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            byte b = bArr[i2];
            byte b2 = b & UByte.MAX_VALUE;
            int i4 = i + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i] = cArr2[b2 >>> 4];
            i += 2;
            cArr[i4] = cArr2[b & 15];
            i2 = i3;
        }
        return new String(cArr);
    }

    public static byte[] parseHex(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            int i = length / 2;
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i2 + 1;
                i2 += 2;
                bArr[i3] = (byte) (parseHexDigit(str.charAt(i4)) | (parseHexDigit(str.charAt(i2)) << 4));
            }
            return bArr;
        }
        throw new IllegalArgumentException("Illegal string length: " + length);
    }

    public static int parseHexDigit(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        if ('A' <= c && c <= 'F') {
            return c - '7';
        }
        if ('a' <= c && c <= 'f') {
            return c - 'W';
        }
        throw new IllegalArgumentException("Illegal hex digit: " + c);
    }

    public static String resolveEntity(String str) {
        if (str.length() <= 1 || str.charAt(0) != '#') {
            if (str.equals("apos")) {
                return "'";
            }
            if (str.equals("quot")) {
                return "\"";
            }
            if (str.equals("gt")) {
                return ">";
            }
            if (str.equals("lt")) {
                return "<";
            }
            return str.equals("amp") ? ContainerUtils.FIELD_DELIMITER : str;
        } else if (str.charAt(1) == 'x') {
            return String.valueOf((char) Integer.parseInt(str.substring(2), 16));
        } else {
            return String.valueOf((char) Integer.parseInt(str.substring(1)));
        }
    }

    public static String ellipsize(String str, int i) {
        return ellipsize(str, i, "...");
    }

    public static String ellipsize(String str, int i, String str2) {
        return (str == null || str.length() <= i) ? str : str.substring(0, i - str2.length()) + str2;
    }

    public static String[] splitLines(String str, boolean z) {
        if (z) {
            return str.split("[\n\r]+");
        }
        return str.split("\\r?\\n");
    }

    public static List<String> findLinesContaining(String str, String str2) {
        String[] splitLines = splitLines(str, true);
        ArrayList arrayList = new ArrayList();
        for (String str3 : splitLines) {
            if (str3.contains(str2)) {
                arrayList.add(str3);
            }
        }
        return arrayList;
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = iterable.iterator();
        char c = 0;
        if (str.length() == 1) {
            c = str.charAt(0);
        }
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                if (c != 0) {
                    sb.append(c);
                } else {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    public static String join(int[] iArr, String str) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Math.max(16, (str.length() + 1) * iArr.length));
        char charAt = str.length() == 1 ? str.charAt(0) : 0;
        for (int i = 0; i < iArr.length; i++) {
            if (i != 0) {
                if (charAt != 0) {
                    sb.append(charAt);
                } else {
                    sb.append(str);
                }
            }
            sb.append(iArr[i]);
        }
        return sb.toString();
    }

    public static String join(String[] strArr, String str) {
        if (strArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Math.max(16, (str.length() + 1) * strArr.length));
        char charAt = str.length() == 1 ? str.charAt(0) : 0;
        for (int i = 0; i < strArr.length; i++) {
            if (i != 0) {
                if (charAt != 0) {
                    sb.append(charAt);
                } else {
                    sb.append(str);
                }
            }
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}
