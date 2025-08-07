package com.huawei.hms.scankit.p;

import java.util.List;

/* compiled from: DecoderResult */
public final class w1 {
    private final byte[] a;
    private int b;
    private final String c;
    private final List<byte[]> d;
    private final String e;
    private Integer f;
    private Integer g;
    private Object h;
    private final int i;
    private final int j;

    public w1(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public int a() {
        return this.b;
    }

    public void b(Integer num) {
        this.f = num;
    }

    public byte[] c() {
        return this.a;
    }

    public String d() {
        return this.c;
    }

    public w1(byte[] bArr, String str, List<byte[]> list, String str2, int i2, int i3) {
        int i4;
        this.a = bArr;
        if (bArr == null) {
            i4 = 0;
        } else {
            i4 = bArr.length * 8;
        }
        this.b = i4;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i3;
        this.j = i2;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public Object b() {
        return this.h;
    }

    public void a(Integer num) {
        this.g = num;
    }

    public void a(Object obj) {
        this.h = obj;
    }
}
