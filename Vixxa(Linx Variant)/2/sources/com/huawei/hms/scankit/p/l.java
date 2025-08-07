package com.huawei.hms.scankit.p;

/* compiled from: BarcodeRow */
final class l {
    private final byte[] a;
    private int b = 0;

    l(int i) {
        this.a = new byte[i];
    }

    private void a(int i, boolean z) {
        if (w7.a(this.a, i)) {
            this.a[i] = z ? (byte) 1 : 0;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.b;
            this.b = i3 + 1;
            a(i3, z);
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] a(int i) {
        int length = this.a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.a[i2 / i];
        }
        return bArr;
    }
}
