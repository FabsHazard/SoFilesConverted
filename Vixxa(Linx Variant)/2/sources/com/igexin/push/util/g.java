package com.igexin.push.util;

import android.content.Context;

final class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ long b;

    g(Context context, long j) {
        this.a = context;
        this.b = j;
    }

    public void run() {
        d.b(this.a, String.valueOf(this.b));
    }
}
