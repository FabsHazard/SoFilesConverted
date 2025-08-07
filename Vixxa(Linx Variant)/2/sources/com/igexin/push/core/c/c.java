package com.igexin.push.core.c;

import com.igexin.push.f.b;
import com.igexin.push.util.d;

class c extends b {
    final /* synthetic */ byte[] a;
    final /* synthetic */ b b;

    c(b bVar, byte[] bArr) {
        this.b = bVar;
        this.a = bArr;
    }

    /* access modifiers changed from: protected */
    public void a() {
        d.a(this.a, com.igexin.push.core.d.e.getFilesDir().getPath() + "/conf_n.pid", false);
    }
}
