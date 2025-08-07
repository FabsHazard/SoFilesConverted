package com.igexin.a.a.b;

public abstract class b {
    protected String c;
    protected b d;
    protected b e;
    protected boolean f;

    public b(String str, boolean z) {
        this.c = str;
        this.f = z;
    }

    public abstract Object a(d dVar, Object obj) throws Exception;

    /* access modifiers changed from: protected */
    public final void a(b bVar) {
        if (bVar != null) {
            b bVar2 = bVar.d;
            bVar.d = this;
            this.e = bVar;
            this.d = bVar2;
        }
    }

    public void a(boolean z) {
        if (!this.f || z) {
            while (true) {
                b bVar = this.d;
                if (bVar != null) {
                    b bVar2 = bVar.d;
                    bVar.d = null;
                    this.d = bVar2;
                } else {
                    return;
                }
            }
        }
    }

    public abstract Object c(d dVar, Object obj) throws Exception;

    public final Object d(d dVar, Object obj) throws Exception {
        if (obj != null) {
            b bVar = this.d;
            if (bVar != null) {
                obj = bVar.d(dVar, obj);
            }
            return a(dVar, obj);
        }
        throw new NullPointerException("Nothing to encode!");
    }
}
