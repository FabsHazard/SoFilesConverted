package com.igexin.push.core.f;

import android.app.Activity;

public abstract class a {
    protected Long a = Long.valueOf(System.currentTimeMillis());
    protected Activity b;
    protected String c;

    public Long a() {
        return this.a;
    }

    public void a(Long l) {
        this.a = l;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public abstract void c();
}
