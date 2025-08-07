package com.igexin.a.a.b.a.a;

import android.os.Message;
import com.igexin.a.a.b.a.a.a.d;
import com.igexin.a.a.c.b;
import java.net.Socket;

class g implements d {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void a(com.igexin.a.a.b.d dVar) {
        this.a.m.sendEmptyMessage(q.INTERRUPT_SUCCESS.ordinal());
    }

    public void a(Exception exc) {
        b.a("GS-M|c ex = " + exc.toString(), new Object[0]);
        this.a.i();
    }

    public void a(String str) {
        this.a.m.sendEmptyMessage(q.TCP_CREATE_SUCCESS.ordinal());
    }

    public void a(Socket socket) {
        Message obtain = Message.obtain();
        obtain.obj = socket;
        obtain.what = q.TCP_CONNECT_SUCCESS.ordinal();
        this.a.m.sendMessage(obtain);
    }
}
