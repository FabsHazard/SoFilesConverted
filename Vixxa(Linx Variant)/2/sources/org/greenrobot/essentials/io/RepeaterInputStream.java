package org.greenrobot.essentials.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RepeaterInputStream extends FilterInputStream {
    private final OutputStream out;

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public RepeaterInputStream(InputStream inputStream, OutputStream outputStream) {
        super(inputStream);
        this.out = outputStream;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read > 0) {
            this.out.write(read);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        if (read > 0) {
            this.out.write(bArr, i, read);
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void reset() throws IOException {
        throw new IOException("Unsupported");
    }
}
