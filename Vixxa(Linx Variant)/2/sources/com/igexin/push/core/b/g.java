package com.igexin.push.core.b;

import android.content.ContentValues;
import com.igexin.push.b.d;

class g extends d {
    final /* synthetic */ long a;
    final /* synthetic */ e b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    g(e eVar, ContentValues contentValues, long j) {
        super(contentValues);
        this.b = eVar;
        this.a = j;
    }

    public void a() throws Exception {
        this.d.delete("ral", "id=?", new String[]{String.valueOf(this.a)});
    }
}
