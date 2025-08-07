package com.igexin.a.a.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.igexin.a.a.d.a.b;
import com.igexin.a.a.d.a.e;
import com.igexin.push.core.d;
import com.igexin.push.d.b.a;
import com.igexin.push.d.c.m;
import com.igexin.push.util.n;
import com.microtech.aidexx.common.ExtendsKt;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class f extends BroadcastReceiver implements Comparator<e> {
    public static final String g = "com.igexin.a.a.d.f";
    public static final long u = TimeUnit.SECONDS.toMillis(2);
    private boolean a = false;
    final k h = new k(this);
    final HashMap<Long, b> i = new HashMap<>(7);
    final c j = new c();
    final d<e> k = new d<>(this, this);
    final ReentrantLock l = new ReentrantLock();
    PowerManager m;
    AlarmManager n;
    Intent o;
    PendingIntent p;
    Intent q;
    PendingIntent r;
    String s;
    volatile boolean t;

    protected f() {
        e.D = this;
    }

    /* renamed from: a */
    public final int compare(e eVar, e eVar2) {
        if (eVar.t < eVar2.t) {
            return -1;
        }
        if (eVar.t > eVar2.t) {
            return 1;
        }
        if (eVar.z > eVar2.z) {
            return -1;
        }
        if (eVar.z < eVar2.z) {
            return 1;
        }
        if (eVar.u < eVar2.u) {
            return -1;
        }
        if (eVar.u > eVar2.u) {
            return 1;
        }
        return eVar.hashCode() - eVar2.hashCode();
    }

    public final void a(long j2) {
        if (this.t) {
            com.igexin.a.a.c.b.a("setalarm|" + new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.getDefault()).format(new Date(j2)), new Object[0]);
            if (j2 < 0) {
                j2 = System.currentTimeMillis() + u;
            }
            try {
                if (this.p != null) {
                    try {
                        this.n.setAndAllowWhileIdle(0, j2, this.p);
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th) {
                com.igexin.a.a.c.b.a("TaskService" + th.toString(), new Object[0]);
            }
        }
    }

    public final void a(Context context) {
        if (!this.a) {
            if (!n.b()) {
                this.m = (PowerManager) context.getSystemService("power");
                this.t = true;
                this.n = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                g gVar = new g(this, context);
                if (Build.VERSION.SDK_INT > 33) {
                    context.registerReceiver(this, gVar, d.az, (Handler) null, 4);
                } else {
                    context.registerReceiver(this, gVar, d.az, (Handler) null);
                }
                this.s = "AlarmNioTaskSchedule." + context.getPackageName();
                if (Build.VERSION.SDK_INT > 33) {
                    context.registerReceiver(this, new IntentFilter(this.s), d.az, (Handler) null, 4);
                } else {
                    context.registerReceiver(this, new IntentFilter(this.s), d.az, (Handler) null);
                }
                int i2 = (n.a(context) < 31 || Build.VERSION.SDK_INT < 30) ? 134217728 : 201326592;
                this.o = new Intent("AlarmTaskSchedule." + context.getPackageName());
                this.p = PendingIntent.getBroadcast(context, hashCode(), this.o, i2);
                this.q = new Intent(this.s);
                this.r = PendingIntent.getBroadcast(context, hashCode() + 2, this.q, i2);
            }
            this.h.start();
            try {
                Thread.yield();
            } catch (Throwable unused) {
            }
            this.a = true;
        }
    }

    public final boolean a(b bVar) {
        bVar.getClass();
        ReentrantLock reentrantLock = this.l;
        if (reentrantLock.tryLock()) {
            try {
                if (this.i.keySet().contains(Long.valueOf(bVar.m()))) {
                    return false;
                }
                this.i.put(Long.valueOf(bVar.m()), bVar);
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                com.igexin.a.a.c.b.a("TaskService|" + th.toString(), new Object[0]);
            } finally {
                reentrantLock.unlock();
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(e eVar, b bVar) {
        int b_ = eVar.b_();
        if (b_ > Integer.MIN_VALUE && b_ < 0) {
            e eVar2 = (e) eVar;
            boolean a2 = eVar2.s ? bVar.a(eVar2, this) : bVar.a(eVar, this);
            if (a2) {
                eVar2.c();
            }
            return a2;
        } else if (b_ < 0 || b_ >= Integer.MAX_VALUE) {
            return false;
        } else {
            return bVar.a(eVar, this);
        }
    }

    public final boolean a(e eVar, boolean z) {
        eVar.getClass();
        int i2 = 0;
        if (eVar.o || eVar.j) {
            return false;
        }
        d<e> dVar = this.k;
        if (!(eVar instanceof com.igexin.a.a.b.d) || !(((com.igexin.a.a.b.d) eVar).c instanceof com.igexin.push.d.c.n)) {
            if (z) {
                i2 = dVar.e.incrementAndGet();
            }
        } else if (z) {
            i2 = Integer.MAX_VALUE;
        }
        eVar.z = i2;
        return dVar.a(eVar);
    }

    public final boolean a(e eVar, boolean z, boolean z2) {
        eVar.getClass();
        boolean z3 = false;
        if (eVar.k) {
            return false;
        }
        if (!z || z2) {
            if (z2 && z) {
                z3 = true;
            }
            return a(eVar, z3);
        }
        eVar.d();
        try {
            eVar.b();
            eVar.g();
            eVar.e_();
            if (!eVar.s) {
                eVar.c();
            }
            return true;
        } catch (Exception e) {
            eVar.s = true;
            eVar.A = e;
            eVar.p();
            eVar.t();
            a((Object) eVar);
            f();
            if (!eVar.s) {
                eVar.c();
            }
            return false;
        } catch (Throwable th) {
            if (!eVar.s) {
                eVar.c();
            }
            throw th;
        }
    }

    public final boolean a(Class cls) {
        d<e> dVar = this.k;
        return dVar != null && dVar.a(cls);
    }

    public final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (obj instanceof m) {
                m mVar = (m) obj;
            }
        } catch (Exception unused) {
        }
        com.igexin.a.a.c.b.a("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode(), new Object[0]);
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.l()) {
                return false;
            }
            eVar.a(false);
            if ((obj instanceof a) || (obj instanceof com.igexin.push.d.b.b)) {
                this.j.a();
                com.igexin.a.a.c.b.a("TaskService|change to primaryQueue", new Object[0]);
            }
            this.j.a(eVar);
            return true;
        }
        throw new ClassCastException("response Obj is not a TaskResult ");
    }

    public final void b(long j2) {
        if (!n.b()) {
            com.igexin.a.a.c.b.a("setnioalarm|" + new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.getDefault()).format(new Date(j2)), new Object[0]);
            if (j2 < 0) {
                j2 = System.currentTimeMillis() + u;
            }
            try {
                this.n.setAndAllowWhileIdle(0, j2, this.p);
            } catch (Throwable unused) {
            }
        }
    }

    public final void e() {
        try {
            PendingIntent pendingIntent = this.r;
            if (pendingIntent != null) {
                this.n.cancel(pendingIntent);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        k kVar = this.h;
        if (kVar != null && !kVar.isInterrupted()) {
            this.h.interrupt();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        if (r4 < 0) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008f, code lost:
        ((com.igexin.a.a.d.e) r0).c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bf, code lost:
        if (r4 < 0) goto L_0x008f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0000 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r8 = this;
        L_0x0000:
            com.igexin.a.a.d.c r0 = r8.j
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x00e8
            com.igexin.a.a.d.c r0 = r8.j
            com.igexin.a.a.d.a.e r0 = r0.d()
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "TaskService|notifyObserver responseQueue -- task = "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.igexin.a.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r3)
            r1 = 1
            r0.a(r1)
            java.util.concurrent.locks.ReentrantLock r1 = r8.l
            r1.lock()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            java.util.HashMap<java.lang.Long, com.igexin.a.a.d.a.b> r4 = r8.i     // Catch:{ all -> 0x0099 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0099 }
            if (r4 != 0) goto L_0x0084
            long r4 = r0.m()     // Catch:{ all -> 0x0099 }
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x005c
            java.util.HashMap<java.lang.Long, com.igexin.a.a.d.a.b> r6 = r8.i     // Catch:{ all -> 0x0099 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0099 }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x0099 }
            com.igexin.a.a.d.a.b r4 = (com.igexin.a.a.d.a.b) r4     // Catch:{ all -> 0x0099 }
            if (r4 == 0) goto L_0x0084
            boolean r5 = r4.l()     // Catch:{ all -> 0x0099 }
            if (r5 == 0) goto L_0x0084
            boolean r4 = r8.a((com.igexin.a.a.d.a.e) r0, (com.igexin.a.a.d.a.b) r4)     // Catch:{ all -> 0x0099 }
            goto L_0x0085
        L_0x005c:
            java.util.HashMap<java.lang.Long, com.igexin.a.a.d.a.b> r4 = r8.i     // Catch:{ all -> 0x0099 }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x0099 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0099 }
            r5 = r2
        L_0x0067:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x0080
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0082 }
            com.igexin.a.a.d.a.b r6 = (com.igexin.a.a.d.a.b) r6     // Catch:{ all -> 0x0082 }
            boolean r7 = r6.l()     // Catch:{ all -> 0x0082 }
            if (r7 != 0) goto L_0x007a
            goto L_0x0067
        L_0x007a:
            boolean r5 = r8.a((com.igexin.a.a.d.a.e) r0, (com.igexin.a.a.d.a.b) r6)     // Catch:{ all -> 0x0082 }
            if (r5 == 0) goto L_0x0067
        L_0x0080:
            r4 = r5
            goto L_0x0085
        L_0x0082:
            r4 = move-exception
            goto L_0x009b
        L_0x0084:
            r4 = r2
        L_0x0085:
            if (r4 != 0) goto L_0x0095
            int r4 = r0.b_()
            if (r4 <= r3) goto L_0x0095
            if (r4 >= 0) goto L_0x0095
        L_0x008f:
            r3 = r0
            com.igexin.a.a.d.e r3 = (com.igexin.a.a.d.e) r3
            r3.c()
        L_0x0095:
            r1.unlock()
            goto L_0x00c2
        L_0x0099:
            r4 = move-exception
            r5 = r2
        L_0x009b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            r6.<init>()     // Catch:{ all -> 0x00d4 }
            java.lang.String r7 = "TaskService|"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d4 }
            java.lang.StringBuilder r4 = r6.append(r4)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d4 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d4 }
            com.igexin.a.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r6)     // Catch:{ all -> 0x00d4 }
            if (r5 != 0) goto L_0x0095
            int r4 = r0.b_()
            if (r4 <= r3) goto L_0x0095
            if (r4 >= 0) goto L_0x0095
            goto L_0x008f
        L_0x00c2:
            boolean r0 = r0 instanceof com.igexin.push.d.c.k
            if (r0 == 0) goto L_0x0000
            com.igexin.a.a.d.c r0 = r8.j
            r0.b()
            java.lang.String r0 = "TaskService|queue -> secondRespQueue"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
            goto L_0x0000
        L_0x00d4:
            r2 = move-exception
            if (r5 != 0) goto L_0x00e4
            int r4 = r0.b_()
            if (r4 <= r3) goto L_0x00e4
            if (r4 >= 0) goto L_0x00e4
            com.igexin.a.a.d.e r0 = (com.igexin.a.a.d.e) r0
            r0.c()
        L_0x00e4:
            r1.unlock()
            throw r2
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.a.a.d.f.g():void");
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.t = true;
            com.igexin.a.a.c.b.a("screenoff", new Object[0]);
            if (this.k.h.get() > 0) {
                a(this.k.h.get());
            }
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.t = false;
            com.igexin.a.a.c.b.a("screenon", new Object[0]);
        } else if (intent.getAction().startsWith("AlarmTaskSchedule.") || intent.getAction().startsWith("AlarmTaskScheduleBak.")) {
            com.igexin.a.a.c.b.a("receivealarm|" + this.t, new Object[0]);
            f();
        } else if (this.s.equals(intent.getAction())) {
            com.igexin.a.a.c.b.a("receive nioalarm", new Object[0]);
            try {
                com.igexin.a.a.c.b.a("TaskService|alarm time out #######", new Object[0]);
                com.igexin.a.a.b.a.a.f.a().e();
            } catch (Exception unused) {
            }
        }
    }
}
