package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* compiled from: CameraMeteringData */
public class k0 {
    private int a;
    private Rect b;

    /* compiled from: CameraMeteringData */
    public static class a {
        public Rect a;
        public int b;

        public a(Rect rect, int i) {
            this.a = rect;
            this.b = i;
        }
    }

    public k0(int i, Rect rect) {
        this.a = i;
        this.b = new Rect(rect);
    }

    public int a() {
        return this.a;
    }

    public Rect b() {
        return this.b;
    }
}
