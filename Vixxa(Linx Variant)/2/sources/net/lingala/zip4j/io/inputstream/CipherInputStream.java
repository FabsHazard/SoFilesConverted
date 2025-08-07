package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

abstract class CipherInputStream<T extends Decrypter> extends InputStream {
    private T decrypter;
    private byte[] lastReadRawDataCache;
    private LocalFileHeader localFileHeader;
    private byte[] singleByteBuffer = new byte[1];
    private ZipEntryInputStream zipEntryInputStream;

    /* access modifiers changed from: protected */
    public void endOfEntryReached(InputStream inputStream, int i) throws IOException {
    }

    /* access modifiers changed from: protected */
    public abstract T initializeDecrypter(LocalFileHeader localFileHeader2, char[] cArr, boolean z) throws IOException;

    public CipherInputStream(ZipEntryInputStream zipEntryInputStream2, LocalFileHeader localFileHeader2, char[] cArr, int i, boolean z) throws IOException {
        this.zipEntryInputStream = zipEntryInputStream2;
        this.decrypter = initializeDecrypter(localFileHeader2, cArr, z);
        this.localFileHeader = localFileHeader2;
        if (Zip4jUtil.getCompressionMethod(localFileHeader2).equals(CompressionMethod.DEFLATE)) {
            this.lastReadRawDataCache = new byte[i];
        }
    }

    public int read() throws IOException {
        if (read(this.singleByteBuffer) == -1) {
            return -1;
        }
        return this.singleByteBuffer[0] & UByte.MAX_VALUE;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readFully = Zip4jUtil.readFully(this.zipEntryInputStream, bArr, i, i2);
        if (readFully > 0) {
            cacheRawData(bArr, readFully);
            this.decrypter.decryptData(bArr, i, readFully);
        }
        return readFully;
    }

    public void close() throws IOException {
        this.zipEntryInputStream.close();
    }

    public byte[] getLastReadRawDataCache() {
        return this.lastReadRawDataCache;
    }

    /* access modifiers changed from: protected */
    public int readRaw(byte[] bArr) throws IOException {
        return this.zipEntryInputStream.readRawFully(bArr);
    }

    private void cacheRawData(byte[] bArr, int i) {
        byte[] bArr2 = this.lastReadRawDataCache;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i);
        }
    }

    public T getDecrypter() {
        return this.decrypter;
    }

    /* access modifiers changed from: protected */
    public long getNumberOfBytesReadForThisEntry() {
        return this.zipEntryInputStream.getNumberOfBytesRead();
    }

    public LocalFileHeader getLocalFileHeader() {
        return this.localFileHeader;
    }
}
