package com.igexin.a.a.b.a.a;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class p {
    private BufferedOutputStream a;

    public p(OutputStream outputStream) throws IOException {
        this.a = new BufferedOutputStream(outputStream);
    }

    public void a(byte[] bArr) throws IOException {
        this.a.write(bArr, 0, bArr.length);
        this.a.flush();
    }
}
