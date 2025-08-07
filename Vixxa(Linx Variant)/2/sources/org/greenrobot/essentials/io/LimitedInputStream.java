package org.greenrobot.essentials.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class LimitedInputStream extends InputStream {
    private int bytesLeft;
    private final InputStream in;

    public void close() throws IOException {
    }

    public static GZIPInputStream createGZIPInputStream(InputStream inputStream, int i) throws IOException {
        return new GZIPInputStream(new LimitedInputStream(inputStream, i));
    }

    public LimitedInputStream(InputStream inputStream, int i) {
        this.in = inputStream;
        this.bytesLeft = i;
    }

    public int available() throws IOException {
        return Math.min(this.in.available(), this.bytesLeft);
    }

    public int read() throws IOException {
        if (this.bytesLeft <= 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.bytesLeft--;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.bytesLeft;
        if (i3 <= 0) {
            return -1;
        }
        int read = this.in.read(bArr, i, Math.min(i3, i2));
        if (read > 0) {
            this.bytesLeft -= read;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0;
        }
        long skip = this.in.skip(Math.min((long) this.bytesLeft, j));
        if (skip > 0) {
            this.bytesLeft = (int) (((long) this.bytesLeft) - skip);
        }
        return skip;
    }

    public int getBytesLeft() {
        return this.bytesLeft;
    }
}
