package net.lingala.zip4j.crypto;

import java.security.SecureRandom;
import kotlin.UByte;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardEncrypter implements Encrypter {
    private byte[] headerBytes;
    private final ZipCryptoEngine zipCryptoEngine = new ZipCryptoEngine();

    public StandardEncrypter(char[] cArr, long j, boolean z) throws ZipException {
        init(cArr, j, z);
    }

    private void init(char[] cArr, long j, boolean z) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.zipCryptoEngine.initKeys(cArr, z);
        this.headerBytes = generateRandomBytes();
        this.zipCryptoEngine.initKeys(cArr, z);
        byte[] bArr = this.headerBytes;
        bArr[11] = (byte) ((int) (j >>> 24));
        bArr[10] = (byte) ((int) (j >>> 16));
        encryptData(bArr);
    }

    public int encryptData(byte[] bArr) throws ZipException {
        bArr.getClass();
        return encryptData(bArr, 0, bArr.length);
    }

    public int encryptData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 >= 0) {
            for (int i3 = i; i3 < i + i2; i3++) {
                bArr[i3] = encryptByte(bArr[i3]);
            }
            return i2;
        }
        throw new ZipException("invalid length specified to decrpyt data");
    }

    /* access modifiers changed from: protected */
    public byte encryptByte(byte b) {
        byte decryptByte = (byte) ((this.zipCryptoEngine.decryptByte() & UByte.MAX_VALUE) ^ b);
        this.zipCryptoEngine.updateKeys(b);
        return decryptByte;
    }

    /* access modifiers changed from: protected */
    public byte[] generateRandomBytes() {
        byte[] bArr = new byte[12];
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 12; i++) {
            bArr[i] = encryptByte((byte) secureRandom.nextInt(256));
        }
        return bArr;
    }

    public byte[] getHeaderBytes() {
        return this.headerBytes;
    }
}
