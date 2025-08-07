package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.model.LocalFileHeader;

class NoCipherInputStream extends CipherInputStream<NoDecrypter> {
    public NoCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr, int i) throws IOException {
        super(zipEntryInputStream, localFileHeader, cArr, i, true);
    }

    /* access modifiers changed from: protected */
    public NoDecrypter initializeDecrypter(LocalFileHeader localFileHeader, char[] cArr, boolean z) {
        return new NoDecrypter();
    }

    static class NoDecrypter implements Decrypter {
        public int decryptData(byte[] bArr, int i, int i2) {
            return i2;
        }

        NoDecrypter() {
        }
    }
}
