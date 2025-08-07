package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public final class ar implements Comparable<ar> {
    public long a = -1;
    public long b = -1;
    public String c = null;
    public boolean d = false;
    public boolean e = false;
    public int f = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int i;
        ar arVar = (ar) obj;
        if (arVar == null || this.b - arVar.b > 0) {
            return 1;
        }
        return i < 0 ? -1 : 0;
    }
}
