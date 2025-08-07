package com.microtech.aidexx.common.net;

import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import javax.crypto.Cipher;

public class RSAUtil {
    private static final String ALGORITHM_RSA = "RSA";
    public static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI4fCLavIlpWS8HEyMS6YIT3KX0Udg7ny/6yUJ65OSP5XRLUiRGYufd2w1wastUltLuI0c/ffP/sHfYZhcIOykwyR8twh6spkuD/R1mjirV09Fl4jG/wChK9ce+VFs9mqNs4k61jWiGPo4sjofL3LbRvXi0478pK3IaHXRVuPhTbAgMBAAECgYAbDqN9DDixFC7WFB3Y/laz2c5nRsb3LYAz3ETnAwJy692hYR87X2V\nATLcCyP50//m5nmG7fqPwoUZO/Sru+BvhPgNU1T1zaY/q/FihkZJQfX2DErHvJq69tFI/wr8V80185RN/6W2eCsMnbTAHdUlZNyBSqjLEfNSkYwUOPfqvoQJBAJ+PprYac0YFuJXollvRlTiMDRPkW2IJ9wVdRZ5XyePk+2CFMkj7DDQE7Yxt2sAVxeLIXHK2oIlpO1oKJ/2rudECQQDkBPcQg2e3KitCFib4xfLAiqyzA4KzrFjMlDNZzx0ZJrmRGRv79Ahcw7pzvU3XlloX7kWXeZhlS\nC5wSOjSkOLrAkAs/2PyYw8zJhXiIM+WYUqFwelGPNYQleLV3nHtr7A91quVkrqVnkbYvLMJMUnJddpylDKOHzayybx1LfwNK8qhAkEAqD4RnhmXGUsACA8YSk6kQvUPYDai5bew/aIMEaQEMF6mZS1FvK3ezbONi4COQxgo+adRqeaKT5Dm0uq4/0TwaQJAXVBeajTN4i3WN6Fr0DCuFRJDEWvYFdCVDgXvKtSVIheFWwst/rFwUjoOKndVLaDOKfnorKioPsIYd/EQ/z8SQw==";
    public static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCifgLBAr2MhgWLBJWtTuhtGC4f47eb5xs1Ys/GvYjS77h6aX9Zw2HIpovVRLITdd0bMjD4/VHnrC1bZOD/OeXchOTmjrVlIdKVeJK4RIrYc7oDSlWUYkBKDRqWLEUXS2CS0Fc1X6wa2Pub7G9e3ukV+orrJkMC0+YTEgn18iLUBQIDAQAB";

    public static List<Key> getRSAKeyObject(int i) throws NoSuchAlgorithmException {
        ArrayList arrayList = new ArrayList(2);
        KeyPairGenerator instance = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        instance.initialize(i);
        KeyPair generateKeyPair = instance.generateKeyPair();
        arrayList.add(generateKeyPair.getPublic());
        arrayList.add(generateKeyPair.getPrivate());
        return arrayList;
    }

    public static List<String> getRSAKeyString(int i) throws NoSuchAlgorithmException {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList(2);
        KeyPairGenerator instance = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        instance.initialize(i);
        KeyPair generateKeyPair = instance.generateKeyPair();
        if (Build.VERSION.SDK_INT >= 26) {
            str = Base64.getEncoder().encodeToString(generateKeyPair.getPublic().getEncoded());
        } else {
            str = android.util.Base64.encodeToString(generateKeyPair.getPublic().getEncoded(), 0);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            str2 = Base64.getEncoder().encodeToString(generateKeyPair.getPrivate().getEncoded());
        } else {
            str2 = android.util.Base64.encodeToString(generateKeyPair.getPrivate().getEncoded(), 0);
        }
        arrayList.add(str);
        arrayList.add(str2);
        return arrayList;
    }

    public static RSAPublicKey getPublicKey(String str) throws Exception {
        byte[] bArr;
        KeyFactory instance = KeyFactory.getInstance(ALGORITHM_RSA);
        if (Build.VERSION.SDK_INT >= 26) {
            bArr = Base64.getMimeDecoder().decode(str);
        } else {
            bArr = android.util.Base64.decode(str, 0);
        }
        return (RSAPublicKey) instance.generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static RSAPrivateKey getPrivateKey(String str) throws Exception {
        byte[] bArr;
        KeyFactory instance = KeyFactory.getInstance(ALGORITHM_RSA);
        if (Build.VERSION.SDK_INT >= 26) {
            bArr = Base64.getMimeDecoder().decode(str);
        } else {
            bArr = android.util.Base64.decode(str, 0);
        }
        return (RSAPrivateKey) instance.generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static String encryptByPublicKey(String str, RSAPublicKey rSAPublicKey) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, rSAPublicKey);
        byte[][] optimizedSplitArray = optimizedSplitArray(str.getBytes(StandardCharsets.UTF_8), (rSAPublicKey.getModulus().bitLength() / 8) - 11);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte[] doFinal : optimizedSplitArray) {
            byteArrayOutputStream.write(instance.doFinal(doFinal));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        }
        return android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static String decryptByPrivateKey(String str, RSAPrivateKey rSAPrivateKey) throws Exception {
        byte[] bArr;
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, rSAPrivateKey);
        int bitLength = rSAPrivateKey.getModulus().bitLength() / 8;
        byte[] bytes = str.getBytes();
        if (Build.VERSION.SDK_INT >= 26) {
            bArr = Base64.getDecoder().decode(bytes);
        } else {
            bArr = android.util.Base64.decode(bytes, 0);
        }
        byte[][] optimizedSplitArray = optimizedSplitArray(bArr, bitLength);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        for (byte[] doFinal : optimizedSplitArray) {
            allocate.put(instance.doFinal(doFinal));
        }
        allocate.flip();
        byteArrayOutputStream.write(allocate.array(), 0, allocate.limit());
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }

    private static byte[][] splitArray(byte[] bArr, int i) {
        int length = bArr.length;
        if (length <= i) {
            return new byte[][]{bArr};
        }
        int i2 = (length - 1) / i;
        int i3 = i2 + 1;
        byte[][] bArr2 = new byte[i3][];
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            } else if (i4 == i2) {
                int i5 = i * i4;
                int i6 = length - i5;
                byte[] bArr3 = new byte[i6];
                System.arraycopy(bArr, i5, bArr3, 0, i6);
                bArr2[i4] = bArr3;
                break;
            } else {
                byte[] bArr4 = new byte[i];
                System.arraycopy(bArr, i * i4, bArr4, 0, i);
                bArr2[i4] = bArr4;
                i4++;
            }
        }
        return bArr2;
    }

    public static byte[][] optimizedSplitArray(byte[] bArr, int i) {
        int length = bArr.length;
        if (length <= i) {
            return new byte[][]{bArr};
        }
        int i2 = ((length + i) - 1) / i;
        byte[][] bArr2 = new byte[i2][];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int min = Math.min(i4 + i, length);
            bArr2[i3] = Arrays.copyOfRange(bArr, i4, min);
            i3++;
            i4 = min;
        }
        return bArr2;
    }
}
