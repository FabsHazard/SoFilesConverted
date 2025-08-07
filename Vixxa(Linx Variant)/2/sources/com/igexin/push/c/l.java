package com.igexin.push.c;

import com.igexin.a.a.b.e;
import com.igexin.a.a.c.b;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Callable;

class l implements Callable<j> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    /* renamed from: a */
    public j call() {
        Socket socket;
        if (!Thread.currentThread().isInterrupted()) {
            socket = null;
            try {
                if (Thread.currentThread().isInterrupted()) {
                    return null;
                }
                synchronized (r.class) {
                    if (this.a.e != null) {
                        this.a.e.a(this.a.d);
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                String[] a2 = e.a(this.a.d.a());
                Socket socket2 = new Socket();
                try {
                    socket2.connect(new InetSocketAddress(a2[1], this.a.d.d()), 2500);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    this.a.d.a("socket://" + k.a(socket2.getInetAddress()) + ":" + this.a.d.d(), currentTimeMillis2 - currentTimeMillis, currentTimeMillis2);
                    b.a(k.a + "|detect " + this.a.h() + "|time = " + this.a.d.e(), new Object[0]);
                    synchronized (r.class) {
                        if (this.a.e != null && !Thread.currentThread().isInterrupted()) {
                            this.a.e.a(g.a, this.a.d);
                        }
                    }
                    if (!socket2.isClosed()) {
                        try {
                            socket2.close();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    socket = socket2;
                } catch (Throwable th) {
                    th = th;
                    socket = socket2;
                    if (socket != null && !socket.isClosed()) {
                        try {
                            socket.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return this.a.d;
        try {
            b.a(k.a + "|detect " + this.a.h() + "thread -->" + e.toString(), new Object[0]);
            synchronized (r.class) {
                if (this.a.e != null) {
                    this.a.d.b();
                    this.a.e.a(g.EXCEPTION, this.a.d);
                }
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            return this.a.d;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
