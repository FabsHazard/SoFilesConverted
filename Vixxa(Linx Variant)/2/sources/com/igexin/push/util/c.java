package com.igexin.push.util;

import android.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class c {
    public static PublicKey a(String str, String str2) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
    }

    public static SecretKey a(String str, int i) throws NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance(str);
        instance.init(i);
        return instance.generateKey();
    }

    public static byte[] a(String str, PublicKey publicKey, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher instance = Cipher.getInstance(str);
        instance.init(1, publicKey);
        return instance.doFinal(bArr);
    }

    public static byte[] a(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher instance = Cipher.getInstance(str);
        instance.init(1, secretKey, ivParameterSpec);
        return instance.doFinal(bArr);
    }

    public static byte[] b(String str, SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher instance = Cipher.getInstance(str);
        instance.init(2, secretKey, ivParameterSpec);
        return instance.doFinal(bArr);
    }
}
