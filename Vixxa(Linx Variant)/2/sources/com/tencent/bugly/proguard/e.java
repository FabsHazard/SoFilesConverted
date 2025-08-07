package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* compiled from: BUGLY */
public final class e extends d {
    static HashMap<String, byte[]> h;
    static HashMap<String, HashMap<String, byte[]>> i;
    protected g g;
    private int j = 0;

    public e() {
        g gVar = new g();
        this.g = gVar;
        gVar.a = 2;
    }

    public final <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is ".concat(String.valueOf(str)));
    }

    public final void b() {
        super.b();
        this.g.a = 3;
    }

    public final byte[] a() {
        if (this.g.a != 2) {
            if (this.g.e == null) {
                this.g.e = "";
            }
            if (this.g.f == null) {
                this.g.f = "";
            }
        } else if (this.g.e.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.g.f.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        l lVar = new l(0);
        lVar.a(this.c);
        if (this.g.a == 2) {
            lVar.a(this.a, 0);
        } else {
            lVar.a(this.e, 0);
        }
        this.g.g = n.a(lVar.a);
        l lVar2 = new l(0);
        lVar2.a(this.c);
        this.g.a(lVar2);
        byte[] a = n.a(lVar2.a);
        int length = a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a).flip();
        return allocate.array();
    }

    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, (byte) 0);
                kVar.a(this.c);
                this.g.a(kVar);
                if (this.g.a == 3) {
                    k kVar2 = new k(this.g.g);
                    kVar2.a(this.c);
                    if (h == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        h = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    this.e = kVar2.a(h, 0, false);
                    return;
                }
                k kVar3 = new k(this.g.g);
                kVar3.a(this.c);
                if (i == null) {
                    i = new HashMap<>();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("", new byte[0]);
                    i.put("", hashMap2);
                }
                this.a = kVar3.a(i, 0, false);
                this.b = new HashMap();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }

    public final void b(String str) {
        this.g.e = str;
    }

    public final void c(String str) {
        this.g.f = str;
    }

    public final void c() {
        this.g.d = 1;
    }
}
