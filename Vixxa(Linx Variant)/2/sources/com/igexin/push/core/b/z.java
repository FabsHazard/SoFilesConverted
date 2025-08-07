package com.igexin.push.core.b;

import android.text.TextUtils;
import com.igexin.push.b.d;

class z extends d {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    z(i iVar, String str, String str2) {
        this.c = iVar;
        this.a = str;
        this.b = str2;
    }

    public void a() throws Exception {
        if (!TextUtils.isEmpty(this.a)) {
            i.a().a(this.d, 53, this.a);
        }
        if (!TextUtils.isEmpty(this.b)) {
            i.a().a(this.d, 54, this.b);
        }
    }
}
