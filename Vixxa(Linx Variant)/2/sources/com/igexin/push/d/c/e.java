package com.igexin.push.d.c;

import kotlin.UByte;

public class e {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte[] n;
    public int o;
    public int p;
    public int q;

    public int a() {
        byte b2 = this.d | this.g | this.h | this.i;
        this.d = b2;
        return b2;
    }

    public void a(byte b2) {
        this.d = b2 & UByte.MAX_VALUE;
        this.g = (byte) (b2 & 192);
        this.h = (byte) (b2 & 48);
        this.i = (byte) (b2 & 15);
    }

    public int b() {
        byte b2 = this.f | this.j | this.k | this.l | this.m;
        this.f = b2;
        return b2;
    }
}
