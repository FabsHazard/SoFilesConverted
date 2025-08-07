package com.igexin.push.util;

import android.text.TextUtils;
import android.util.Base64;
import com.igexin.a.a.a.a;
import com.igexin.a.a.b.e;
import com.igexin.a.a.c.b;
import com.igexin.push.core.d;
import java.security.MessageDigest;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class EncryptUtils {
    private static final String a = "com.igexin.push.util.EncryptUtils";
    private static boolean b = false;
    private static int c = 0;
    private static byte[] d = null;
    private static byte[] e = null;
    public static String errorMsg = "";
    public static String rsaKeyId = "69d747c4b9f641baf4004be4297e9f3b";
    public static String rsaPublicKey = "MHwwDQYJKoZIhvcNAQEBBQADawAwaAJhAJp1rROuvBF7sBSnvLaesj2iFhMcY8aXyLvpnNLKs2wjL3JmEnyr++SlVa35liUlzi83tnAFkn3A9GB7pHBNzawyUkBh8WUhq5bnFIkk2RaDa6+5MpG84DEv52p7RR+aWwIDAQAB";

    static {
        try {
            d = initSocketAESKey();
            byte[] initHttpAESKey = initHttpAESKey();
            e = initHttpAESKey;
            b = (d == null || initHttpAESKey == null || getRSAKeyId() == null) ? false : true;
        } catch (Throwable th) {
            b.a(a + "|load key error = " + th.toString(), new Object[0]);
            b = false;
            errorMsg = th.getMessage();
        }
        if (!b) {
            b.a(a + "|load key error ++++++++", new Object[0]);
            if (TextUtils.isEmpty(errorMsg)) {
                errorMsg = "value = null, normal error";
                return;
            }
            return;
        }
        b.a(a + "|load  Encrypt key success ~~~~~~~", new Object[0]);
    }

    public static byte[] aesDecHttp(byte[] bArr, byte[] bArr2) {
        try {
            return c.b("AES/CFB/NoPadding", new SecretKeySpec(e, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable unused) {
            b.a(a + "| httpId decrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] aesDecSocket(byte[] bArr, byte[] bArr2) {
        try {
            return c.b("AES/CFB/NoPadding", new SecretKeySpec(d, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable unused) {
            b.a(a + "| sockeId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] aesEncHttp(byte[] bArr, byte[] bArr2) {
        try {
            return c.a("AES/CFB/NoPadding", new SecretKeySpec(e, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable unused) {
            b.a(a + "| httpId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] aesEncSocket(byte[] bArr, byte[] bArr2) {
        try {
            return c.a("AES/CFB/NoPadding", new SecretKeySpec(d, "AES"), new IvParameterSpec(bArr2), bArr);
        } catch (Throwable unused) {
            b.a(a + "| sockeId encrypt  http data  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] altAesDecSocket(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = rsaKeyId.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                bArr3[i] = (byte) (~(bytes[(bytes.length - i) - 1] & UByte.MAX_VALUE));
            }
            return c.b("AES/CFB/NoPadding", new SecretKeySpec(md5(bArr3), "AES"), new IvParameterSpec(md5(bArr2)), bArr);
        } catch (Throwable th) {
            String str = a;
            b.c(str, th.getMessage());
            b.a(str + "| altAesDecSocket  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] altAesEncSocket(byte[] bArr, byte[] bArr2) {
        try {
            byte[] bytes = rsaKeyId.getBytes();
            byte[] bArr3 = new byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                bArr3[i] = (byte) (~(bytes[(bytes.length - i) - 1] & UByte.MAX_VALUE));
            }
            return c.a("AES/CFB/NoPadding", new SecretKeySpec(md5(bArr3), "AES"), new IvParameterSpec(md5(bArr2)), bArr);
        } catch (Throwable unused) {
            b.a(a + "| altAesEncSocket  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] getBytesEncrypted(byte[] bArr) {
        return a.d(bArr, d.C);
    }

    public static byte[] getHttpAESKey() {
        try {
            byte[] bArr = e;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return c.a("RSA/NONE/OAEPWithSHA1AndMGF1Padding", c.a("RSA", rsaPublicKey), bArr2);
        } catch (Throwable unused) {
            b.a(a + "| getHttpAESKey  fail ~~~~~~~", new Object[0]);
            return new byte[0];
        }
    }

    public static String getHttpGTCV() {
        byte[] httpAESKey = getHttpAESKey();
        byte[] bytes = p.a(16).getBytes();
        byte[] bArr = new byte[(bytes.length + httpAESKey.length)];
        e.a(httpAESKey, 0, bArr, e.a(bytes, 0, bArr, 0, bytes.length), httpAESKey.length);
        return Base64.encodeToString(bArr, 2);
    }

    public static String getHttpSignature(String str, byte[] bArr) throws Exception {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length)];
        int a2 = e.a(bytes, 0, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            e.a(bArr, 0, bArr2, a2, bArr.length);
        }
        return Base64.encodeToString(sha1(bArr2), 2);
    }

    public static byte[] getIV(byte[] bArr) {
        return md5(bArr);
    }

    public static int getPacketId() {
        int i = c;
        c = i + 1;
        return i;
    }

    public static byte[] getRSAKeyId() {
        return rsaKeyId.getBytes();
    }

    public static byte[] getSocketAESKey() {
        if (!b) {
            return new byte[0];
        }
        try {
            byte[] bArr = d;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return c.a("RSA/NONE/OAEPWithSHA1AndMGF1Padding", c.a("RSA", rsaPublicKey), bArr2);
        } catch (Throwable th) {
            b.a(a + "| getSocketAESKey  fail ~~~~~~~" + th.getMessage(), new Object[0]);
            return new byte[0];
        }
    }

    public static byte[] getSocketSignature(com.igexin.push.d.c.a aVar, int i, int i2) {
        byte[] bArr = new byte[(aVar.a + 11)];
        int a2 = e.a(i, bArr, 0);
        int a3 = a2 + e.a(i2, bArr, a2);
        int b2 = a3 + e.b((short) aVar.a, bArr, a3);
        e.a(aVar.e, 0, bArr, b2 + e.c(aVar.b, bArr, b2), aVar.a);
        return sha1(bArr);
    }

    public static byte[] initHttpAESKey() {
        try {
            return c.a("AES", 128).getEncoded();
        } catch (Throwable unused) {
            b.a(a + "|generate  http key fail ~~~~~~~", new Object[0]);
            return null;
        }
    }

    public static byte[] initSocketAESKey() {
        try {
            return c.a("AES", 128).getEncoded();
        } catch (Throwable unused) {
            b.a(a + "|generate  socket key fail ~~~~~~~", new Object[0]);
            return null;
        }
    }

    public static boolean isLoadSuccess() {
        return b;
    }

    public static byte[] md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean reset() {
        try {
            d = initSocketAESKey();
            byte[] initHttpAESKey = initHttpAESKey();
            e = initHttpAESKey;
            b = (d == null || initHttpAESKey == null || getRSAKeyId() == null) ? false : true;
        } catch (Throwable th) {
            b.a(a + "|load key error = " + th.toString(), new Object[0]);
            b = false;
        }
        if (!b) {
            b.a(a + "|load key error ++++++++", new Object[0]);
        } else {
            b.a(a + "|load key success ~~~~~~~", new Object[0]);
        }
        return b;
    }

    public static byte[] rsaEnc(byte[] bArr) {
        return new byte[0];
    }

    public static byte[] sha1(byte[] bArr) {
        try {
            return MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1).digest(bArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
