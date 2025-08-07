package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraZoomData */
public class m0 {
    private int a;
    private int b;
    private List<Integer> c;

    public m0(int i, int i2, List<Integer> list) {
        this.a = i;
        this.b = i2;
        this.c = new ArrayList(list);
    }

    public List<Integer> a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }
}
