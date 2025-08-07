package com.huawei.secure.android.common.util;

import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptUtil {
    private static final String a = "EncryptUtil";
    private static final String b = "RSA";

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] generateSecureRandom(int r3) {
        /*
            byte[] r3 = new byte[r3]
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x000d }
            r1 = 26
            if (r0 < r1) goto L_0x0014
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstanceStrong()     // Catch:{ NoSuchAlgorithmException -> 0x000d }
            goto L_0x0015
        L_0x000d:
            java.lang.String r0 = a
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.util.LogsUtil.e(r0, r1)
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 != 0) goto L_0x001d
            java.lang.String r0 = "SHA1PRNG"
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0021 }
        L_0x001d:
            r0.nextBytes(r3)     // Catch:{ NoSuchAlgorithmException -> 0x003b, Exception -> 0x0021 }
            return r3
        L_0x0021:
            r3 = move-exception
            java.lang.String r0 = a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getSecureRandomBytes getInstance: exception : "
            r1.<init>(r2)
            java.lang.String r3 = r3.getMessage()
            java.lang.StringBuilder r3 = r1.append(r3)
            java.lang.String r3 = r3.toString()
            com.huawei.secure.android.common.util.LogsUtil.e(r0, r3)
            goto L_0x0042
        L_0x003b:
            java.lang.String r3 = a
            java.lang.String r0 = "getSecureRandomBytes getInstance: NoSuchAlgorithmException"
            com.huawei.secure.android.common.util.LogsUtil.e(r3, r0)
        L_0x0042:
            r3 = 0
            byte[] r3 = new byte[r3]
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.EncryptUtil.generateSecureRandom(int):byte[]");
    }

    @Deprecated
    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    @Deprecated
    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                LogsUtil.e(a, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(a, "base64 decode Exception", true);
            return null;
        }
    }

    @Deprecated
    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                LogsUtil.e(a, "load Key Exception:" + e.getMessage(), true);
                return null;
            }
        } catch (IllegalArgumentException unused) {
            LogsUtil.e(a, "base64 decode IllegalArgumentException", true);
            return null;
        } catch (Exception unused2) {
            LogsUtil.e(a, "base64 decode Exception", true);
            return null;
        }
    }
}
