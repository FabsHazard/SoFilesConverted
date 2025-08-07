package com.igexin.push.core.bean;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.igexin.push.core.d;

public class k extends BaseAction {
    private String a;
    private boolean b;
    private boolean c;
    private String d;

    private String d() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.e.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "mobile";
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public String c() {
        String d2;
        String str;
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        String str3 = this.a;
        if (this.b) {
            if (str3.indexOf("?") > 0) {
                sb2 = new StringBuilder().append(str3);
                str2 = "&cid=";
            } else {
                sb2 = new StringBuilder().append(str3);
                str2 = "?cid=";
            }
            str3 = sb2.append(str2).append(d.s).toString();
        }
        if (!this.c || (d2 = d()) == null) {
            return str3;
        }
        if (str3.indexOf("?") > 0) {
            sb = new StringBuilder().append(str3);
            str = "&nettype=";
        } else {
            sb = new StringBuilder().append(str3);
            str = "?nettype=";
        }
        return sb.append(str).append(d2).toString();
    }
}
