package com.igexin.push.core;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.view.MotionEventCompat;
import com.huawei.hms.common.util.Logger;
import com.igexin.a.a.c.a.f;
import com.igexin.a.a.c.b;
import com.igexin.push.c.i;
import com.igexin.push.d.c.d;
import com.igexin.push.d.c.g;
import com.igexin.push.d.c.j;
import com.igexin.push.util.a;
import java.util.ArrayList;
import java.util.List;

public class m {
    private static m a;

    private int a(List<j> list) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.e.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            j jVar = new j();
            jVar.a = 2;
            jVar.b = String.valueOf(type);
            list.add(jVar);
            return type;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static m a() {
        if (a == null) {
            a = new m();
        }
        return a;
    }

    private void b(List<j> list) {
        if (x.a().b != null) {
            int intValue = ((Integer) x.a().b.first).intValue();
            String str = intValue + "";
            if (intValue == 1) {
                str = str + "#" + ((String) x.a().b.second);
            }
            j jVar = new j();
            jVar.a = 5;
            jVar.b = str;
            list.add(jVar);
        }
    }

    public int b() {
        if (!d.i || a.a(System.currentTimeMillis()) || !a.b()) {
            b.a("LoginInteractor|keyNegotiate stop ++++++++++", new Object[0]);
            return -1;
        }
        g gVar = new g();
        gVar.a = d.a;
        return c.a().i().a("K-", gVar, true) < 0 ? 0 : 1;
    }

    public void c() {
        f.a().a("Start login appid = " + d.a);
        if (d.k) {
            d.k = false;
        }
        i.a().d().g();
        boolean z = true;
        if (d.r == 0) {
            b.a("registerReq #####", new Object[0]);
            if (c.a().i().a("R-" + d.B, new d(d.u, d.v, d.B, d.a), true) < 0) {
                z = false;
            }
            b.a("registerReq|" + z + Logger.c + d.B, new Object[0]);
            return;
        }
        com.igexin.push.d.c.i d = d();
        b.a("loginReqBefore|" + d.a, new Object[0]);
        if (c.a().i().a("S-" + d.r, d, true) >= 0) {
            b.a("LoginInteractor|loginReq|" + d.s, new Object[0]);
        }
    }

    public com.igexin.push.d.c.i d() {
        com.igexin.push.d.c.i iVar = new com.igexin.push.d.c.i();
        iVar.a = d.r;
        iVar.b = 0;
        iVar.c = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        iVar.d = d.a;
        try {
            boolean a2 = a.a();
            ArrayList arrayList = new ArrayList();
            if (a2) {
                a(arrayList);
            }
            b(arrayList);
            if (!arrayList.isEmpty()) {
                iVar.e = arrayList;
            }
        } catch (Throwable unused) {
        }
        return iVar;
    }
}
