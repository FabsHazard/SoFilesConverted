package com.igexin.a.a.b.a.a;

import com.igexin.a.a.b.a.a.a.b;
import com.igexin.a.a.b.d;

class h implements b {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public void a(d dVar) {
        this.a.m.sendEmptyMessage(q.INTERRUPT_SUCCESS.ordinal());
    }

    public void a(Exception exc) {
        com.igexin.a.a.c.b.a("GS-M|r ex = " + exc.toString(), new Object[0]);
        if (exc.getMessage() != null && exc.getMessage().equals("end of stream")) {
            com.igexin.push.d.b.a().d();
        }
        this.a.i();
    }
}
