package com.huawei.hms.scankit.p;

/* compiled from: UPCEANExtensionSupport */
final class p7 {
    private static final int[] c = {1, 1, 2};
    private final n7 a = new n7();
    private final o7 b = new o7();

    p7() {
    }

    /* access modifiers changed from: package-private */
    public s6 a(int i, r rVar, int i2) throws a {
        int[] a2 = q7.a(rVar, i2, false, c);
        try {
            return this.b.a(i, rVar, a2);
        } catch (a unused) {
            return this.a.a(i, rVar, a2);
        }
    }
}
