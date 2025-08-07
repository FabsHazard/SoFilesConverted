package com.microtech.aidexx.utils.blankj;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public final class EncryptUtils {
    private EncryptUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String encryptMD5ToString(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return encryptMD5ToString(str.getBytes());
    }

    public static String encryptMD5ToString(String str, String str2) {
        if (str == null && str2 == null) {
            return "";
        }
        if (str2 == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(str.getBytes()));
        }
        if (str == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(str2.getBytes()));
        }
        return UtilsBridge.bytes2HexString(encryptMD5((str + str2).getBytes()));
    }

    public static String encryptMD5ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptMD5(bArr));
    }

    public static String encryptMD5ToString(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return "";
        }
        if (bArr2 == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(bArr));
        }
        if (bArr == null) {
            return UtilsBridge.bytes2HexString(encryptMD5(bArr2));
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return UtilsBridge.bytes2HexString(encryptMD5(bArr3));
    }

    public static byte[] encryptMD5(byte[] bArr) {
        return hashTemplate(bArr, MessageDigestAlgorithms.MD5);
    }

    public static String encryptMD5File2String(String str) {
        return encryptMD5File2String(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static byte[] encryptMD5File(String str) {
        return encryptMD5File(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static String encryptMD5File2String(File file) {
        return UtilsBridge.bytes2HexString(encryptMD5File(file));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC, Splitter:B:31:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] encryptMD5File(java.io.File r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            r1.<init>(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            r2.<init>(r1, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            r4 = 262144(0x40000, float:3.67342E-40)
            byte[] r4 = new byte[r4]     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
        L_0x0018:
            int r3 = r2.read(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            if (r3 > 0) goto L_0x0018
            java.security.MessageDigest r4 = r2.getMessageDigest()     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            byte[] r4 = r4.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            r1.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002e:
            return r4
        L_0x002f:
            r4 = move-exception
            goto L_0x0039
        L_0x0031:
            r4 = move-exception
            goto L_0x0039
        L_0x0033:
            r4 = move-exception
            goto L_0x0049
        L_0x0035:
            r4 = move-exception
            goto L_0x0038
        L_0x0037:
            r4 = move-exception
        L_0x0038:
            r1 = r0
        L_0x0039:
            r4.printStackTrace()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0046:
            return r0
        L_0x0047:
            r4 = move-exception
            r0 = r1
        L_0x0049:
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0053:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.blankj.EncryptUtils.encryptMD5File(java.io.File):byte[]");
    }

    public static String encryptSHA256ToString(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        return encryptSHA256ToString(str.getBytes());
    }

    public static String encryptSHA256ToString(byte[] bArr) {
        return UtilsBridge.bytes2HexString(encryptSHA256(bArr));
    }

    public static byte[] encryptSHA256(byte[] bArr) {
        return hashTemplate(bArr, MessageDigestAlgorithms.SHA_256);
    }

    static byte[] hashTemplate(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                instance.update(bArr);
                return instance.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
