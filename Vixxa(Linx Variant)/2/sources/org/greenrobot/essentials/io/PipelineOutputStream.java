package org.greenrobot.essentials.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PipelineOutputStream extends OutputStream {
    final CircularByteBuffer buffer;
    boolean closedIn;
    boolean closedOut;
    private final PipelineInputStream inputStream;

    public PipelineOutputStream() {
        this(8192);
    }

    public PipelineOutputStream(int i) {
        this.buffer = new CircularByteBuffer(i);
        this.inputStream = new PipelineInputStream();
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 != i2) {
            checkPipelineInput();
            int put = this.buffer.put(bArr, i + i3, i2 - i3);
            if (put > 0) {
                i3 += put;
                notifyBuffer();
            } else {
                waitForBuffer();
            }
        }
    }

    private void checkPipelineInput() throws IOException {
        if (this.closedIn) {
            throw new IOException("PipelineInputStream was closed (broken pipeline)");
        }
    }

    public synchronized void write(int i) throws IOException {
        checkPipelineInput();
        while (!this.buffer.put((byte) i)) {
            waitForBuffer();
            checkPipelineInput();
        }
        notifyBuffer();
    }

    public synchronized void close() throws IOException {
        this.closedOut = true;
        notifyBuffer();
    }

    /* access modifiers changed from: package-private */
    public void waitForBuffer() throws IOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new IOException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void notifyBuffer() {
        notifyAll();
    }

    protected class PipelineInputStream extends InputStream {
        protected PipelineInputStream() {
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (i2 == 0) {
                return PipelineOutputStream.this.closedOut ? -1 : 0;
            }
            synchronized (PipelineOutputStream.this) {
                do {
                    i3 = PipelineOutputStream.this.buffer.get(bArr, i, i2);
                    if (i3 == 0) {
                        if (PipelineOutputStream.this.closedOut) {
                            return -1;
                        }
                        PipelineOutputStream.this.waitForBuffer();
                        continue;
                    }
                } while (i3 == 0);
                PipelineOutputStream.this.notifyBuffer();
                return i3;
            }
        }

        public int read() throws IOException {
            synchronized (PipelineOutputStream.this) {
                int i = PipelineOutputStream.this.buffer.get();
                while (i == -1) {
                    if (PipelineOutputStream.this.closedOut) {
                        return -1;
                    }
                    PipelineOutputStream.this.waitForBuffer();
                    i = PipelineOutputStream.this.buffer.get();
                }
                PipelineOutputStream.this.notifyBuffer();
                return i;
            }
        }

        public int available() throws IOException {
            return PipelineOutputStream.this.buffer.available();
        }

        public long skip(long j) throws IOException {
            int min = (int) Math.min(j, 2147483647L);
            synchronized (PipelineOutputStream.this) {
                int i = 0;
                while (i < min) {
                    int skip = PipelineOutputStream.this.buffer.skip(min - i);
                    if (skip != 0) {
                        i += skip;
                        PipelineOutputStream.this.notifyBuffer();
                    } else if (PipelineOutputStream.this.closedOut) {
                        long j2 = (long) i;
                        return j2;
                    } else {
                        PipelineOutputStream.this.waitForBuffer();
                    }
                }
                long j3 = (long) i;
                return j3;
            }
        }

        public void close() throws IOException {
            PipelineOutputStream.this.closedIn = true;
        }
    }
}
