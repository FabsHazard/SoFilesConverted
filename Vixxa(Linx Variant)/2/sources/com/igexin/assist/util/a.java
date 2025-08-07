package com.igexin.assist.util;

import com.igexin.push.util.h;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class a {
    public static String a(String str, byte[] bArr) {
        try {
            byte[] a = h.a(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(bArr), "AES");
            Cipher instance = Cipher.getInstance("AES/CFB128/NoPadding");
            instance.init(2, secretKeySpec, new IvParameterSpec(a("".getBytes())));
            byte[] doFinal = instance.doFinal(a);
            if (doFinal != null) {
                return new String(doFinal);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
