package com.igexin.a.a.c;

import android.text.TextUtils;
import com.igexin.push.core.d;
import com.igexin.push.util.EncryptUtils;
import com.igexin.push.util.h;
import com.igexin.push.util.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;

public class a {
    private static byte a(char c) {
        return (byte) BinTools.hex.indexOf(c);
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static CipherOutputStream a(File file, SecretKeySpec secretKeySpec) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        byte[] bArr = new byte[16];
        if (randomAccessFile.length() == 0) {
            randomAccessFile.write(b(a(secretKeySpec.getEncoded())));
            new SecureRandom().nextBytes(bArr);
            randomAccessFile.write(bArr);
        } else if (randomAccessFile.length() >= 144) {
            if (randomAccessFile.length() % 16 != 0) {
                a(randomAccessFile);
            }
            randomAccessFile.seek(randomAccessFile.length() - 16);
            randomAccessFile.read(bArr);
        } else {
            throw new IllegalArgumentException("Invalid file length (need 2 blocks for iv and data)");
        }
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return new CipherOutputStream(new FileOutputStream(randomAccessFile.getFD()), instance);
    }

    public static void a() throws Exception {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128);
        d.au = instance.generateKey().getEncoded();
        o.b(d.e, "logkey2", a(EncryptUtils.getBytesEncrypted(d.au)), new String[0]);
    }

    public static void a(RandomAccessFile randomAccessFile) throws Exception {
        long length = (long) ((int) (randomAccessFile.length() % 16));
        if (length < 16 && length > 0) {
            randomAccessFile.setLength(randomAccessFile.length() - length);
        }
    }

    public static byte[] a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (a(charArray[i2 + 1]) | (a(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static byte[] b() {
        if (d.au == null) {
            String str = (String) o.c(d.e, "logkey2", "", new String[0]);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            d.au = com.igexin.a.a.a.a.c(a(str), d.C);
        }
        return d.au;
    }

    private static byte[] b(String str) throws Exception {
        RSAPublicKey c = c("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCzbMQ22qV6umuPXYWXEOGdlpJR\nBWMP68/ArS7XG8+7GmRbWMW1HOMLOOdwuIfPFp9QiwOshG0mYXlm1ecQ/fCXhRMW\nfh+OMCoBdl7vnCpoDYPmjYQBkm9fRW6oej33UhZtlnTZjECAsyC2Eybha7jg3Lft\ngYVnwaPShTmv5+Z9SQIDAQAB");
        Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWithSHA1AndMGF1Padding");
        instance.init(1, c);
        return instance.doFinal(str.getBytes("UTF-8"));
    }

    private static RSAPublicKey c(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(h.a(str, 0)));
    }
}
