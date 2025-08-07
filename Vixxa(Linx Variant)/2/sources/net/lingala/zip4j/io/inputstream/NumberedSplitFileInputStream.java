package net.lingala.zip4j.io.inputstream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;

public class NumberedSplitFileInputStream extends SplitFileInputStream {
    private RandomAccessFile randomAccessFile;

    public NumberedSplitFileInputStream(File file) throws IOException {
        this.randomAccessFile = new NumberedSplitRandomAccessFile(file, RandomAccessFileMode.READ.getValue());
    }

    public int read() throws IOException {
        return this.randomAccessFile.read();
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.randomAccessFile.read(bArr, i, i2);
    }

    public void prepareExtractionForFileHeader(FileHeader fileHeader) throws IOException {
        this.randomAccessFile.seek(fileHeader.getOffsetLocalHeader());
    }

    public void close() throws IOException {
        RandomAccessFile randomAccessFile2 = this.randomAccessFile;
        if (randomAccessFile2 != null) {
            randomAccessFile2.close();
        }
    }
}
