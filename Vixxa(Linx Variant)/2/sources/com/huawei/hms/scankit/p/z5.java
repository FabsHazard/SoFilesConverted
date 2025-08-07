package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ParticleProperties */
public class z5 implements g4 {
    private List<g4> a = new ArrayList();

    public void a(w5 w5Var) {
        for (g4 a2 : this.a) {
            a2.a(w5Var);
        }
    }

    public void a(g4 g4Var) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(g4Var);
    }
}
