package com.tencent.bugly.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class bp extends m implements Cloneable {
    static ArrayList<bo> b;
    public ArrayList<bo> a = null;

    public final void a(StringBuilder sb, int i) {
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
    }

    public final void a(k kVar) {
        if (b == null) {
            b = new ArrayList<>();
            b.add(new bo());
        }
        this.a = (ArrayList) kVar.a(b, 0, true);
    }
}
