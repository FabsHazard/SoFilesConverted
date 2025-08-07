package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class EncryptUtil {
    private static final String a = "EncryptUtil";
    private static final String b = "RSA";
    private static boolean c = false;
    private static boolean d = true;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.SecureRandom a() {
        /*
            java.lang.String r0 = "generateSecureRandomNew "
            java.lang.String r1 = "EncryptUtil"
            com.huawei.secure.android.common.encrypt.utils.b.a(r1, r0)
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0012 }
            r2 = 26
            if (r0 < r2) goto L_0x0017
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstanceStrong()     // Catch:{ NoSuchAlgorithmException -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            java.lang.String r0 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r1, r0)
        L_0x0017:
            r0 = 0
        L_0x0018:
            r2 = 0
            if (r0 != 0) goto L_0x0024
            java.lang.String r3 = "SHA1PRNG"
            java.security.SecureRandom r0 = java.security.SecureRandom.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x0043
        L_0x0024:
            org.bouncycastle.crypto.engines.AESEngine r3 = new org.bouncycastle.crypto.engines.AESEngine     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            r3.<init>()     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            r4 = 32
            byte[] r4 = new byte[r4]     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            r0.nextBytes(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            r6 = 1
            r5.<init>(r0, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            r6 = 384(0x180, float:5.38E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r5 = r5.setEntropyBitsRequired(r6)     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            r6 = 256(0x100, float:3.59E-43)
            org.bouncycastle.crypto.prng.SP800SecureRandom r0 = r5.buildCTR(r3, r6, r4, r2)     // Catch:{ NoSuchAlgorithmException -> 0x0066, all -> 0x0022 }
            return r0
        L_0x0043:
            boolean r4 = d
            if (r4 == 0) goto L_0x006b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "exception : "
            r4.<init>(r5)
            java.lang.String r3 = r3.getMessage()
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = " , you should implementation bcprov-jdk15on library"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.huawei.secure.android.common.encrypt.utils.b.b(r1, r3)
            d = r2
            goto L_0x006b
        L_0x0066:
            java.lang.String r2 = "NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r1, r2)
        L_0x006b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.utils.EncryptUtil.a():java.security.SecureRandom");
    }

    public static SecureRandom genSecureRandom() {
        if (c) {
            return a();
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return SecureRandom.getInstanceStrong();
            }
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            b.b(a, "genSecureRandom: NoSuchAlgorithmException");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] generateSecureRandom(int r3) {
        /*
            java.lang.String r0 = "EncryptUtil"
            boolean r1 = c
            if (r1 != 0) goto L_0x0046
            byte[] r3 = new byte[r3]
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ NoSuchAlgorithmException -> 0x0013 }
            r2 = 26
            if (r1 < r2) goto L_0x0018
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstanceStrong()     // Catch:{ NoSuchAlgorithmException -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r0, r1)
        L_0x0018:
            r1 = 0
        L_0x0019:
            if (r1 != 0) goto L_0x0021
            java.lang.String r1 = "SHA1PRNG"
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x003d, Exception -> 0x0025 }
        L_0x0021:
            r1.nextBytes(r3)     // Catch:{ NoSuchAlgorithmException -> 0x003d, Exception -> 0x0025 }
            return r3
        L_0x0025:
            r3 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getSecureRandomBytes getInstance: exception : "
            r1.<init>(r2)
            java.lang.String r3 = r3.getMessage()
            java.lang.StringBuilder r3 = r1.append(r3)
            java.lang.String r3 = r3.toString()
            com.huawei.secure.android.common.encrypt.utils.b.b(r0, r3)
            goto L_0x0042
        L_0x003d:
            java.lang.String r3 = "getSecureRandomBytes getInstance: NoSuchAlgorithmException"
            com.huawei.secure.android.common.encrypt.utils.b.b(r0, r3)
        L_0x0042:
            r3 = 0
            byte[] r3 = new byte[r3]
            return r3
        L_0x0046:
            byte[] r3 = a(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandom(int):byte[]");
    }

    public static String generateSecureRandomStr(int i) {
        return HexUtil.byteArray2HexStr(generateSecureRandom(i));
    }

    public static PrivateKey getPrivateKey(String str) {
        try {
            try {
                return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.b(a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static RSAPublicKey getPublicKey(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e) {
                b.b(a, "load Key Exception:" + e.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            b.b(a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e2) {
            b.b(a, "base64 decode Exception" + e2.getMessage());
            return null;
        }
    }

    public static boolean isBouncycastleFlag() {
        return c;
    }

    public static void setBouncycastleFlag(boolean z) {
        b.c(a, "setBouncycastleFlag: " + z);
        c = z;
    }

    private static byte[] a(int i) {
        SecureRandom a2 = a();
        if (a2 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        a2.nextBytes(bArr);
        return bArr;
    }
}
