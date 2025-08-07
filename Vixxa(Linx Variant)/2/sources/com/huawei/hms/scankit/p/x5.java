package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ParticleAnimators */
public class x5 implements f4 {
    private List<f4> a = new ArrayList();

    public void a(w5 w5Var, long j) {
        for (f4 a2 : this.a) {
            a2.a(w5Var, j);
        }
    }

    public void a(f4 f4Var) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(f4Var);
    }
}
