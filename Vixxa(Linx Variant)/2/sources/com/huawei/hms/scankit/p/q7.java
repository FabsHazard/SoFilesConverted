package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* compiled from: UPCEANReader */
public abstract class q7 extends g5 {
    public static final int[] c = {1, 1, 1};
    public static final int[] d = {1, 1, 1, 1, 1};
    public static final int[] e = {1, 1, 1, 1, 1, 1};
    public static final int[][] f;
    public static final int[][] g;
    private final StringBuilder a = new StringBuilder(20);
    private final p7 b = new p7();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f = iArr;
        int[][] iArr2 = new int[20][];
        g = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            g[i] = iArr4;
        }
    }

    protected q7() {
    }

    static int[] a(r rVar) throws a {
        return b(rVar, 0);
    }

    static ArrayList<int[]> b(r rVar) throws a {
        int e2 = rVar.e() / 2;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i = 0;
        while (i < e2) {
            try {
                int[] b2 = b(rVar, i);
                arrayList.add(b2);
                i = b2[0] + 1;
            } catch (a unused) {
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw a.a();
    }

    /* access modifiers changed from: protected */
    public abstract int a(r rVar, int[] iArr, StringBuilder sb) throws a;

    /* access modifiers changed from: package-private */
    public abstract BarcodeFormat a();

    /* access modifiers changed from: package-private */
    public abstract boolean a(int i, int i2, r rVar);

    /* access modifiers changed from: package-private */
    public abstract boolean a(int[] iArr, int[] iArr2) throws a;

    public s6 a(int i, r rVar, Map<l1, ?> map) throws a {
        return a(i, rVar, a(rVar), map);
    }

    public s6 a(int i, r rVar, int[] iArr, Map<l1, ?> map) throws a {
        int i2 = i;
        r rVar2 = rVar;
        int[] iArr2 = iArr;
        Map<l1, ?> map2 = map;
        v6 v6Var = map2 == null ? null : (v6) map2.get(l1.NEED_RESULT_POINT_CALLBACK);
        if (v6Var != null) {
            v6Var.a(new u6(((float) (iArr2[0] + iArr2[1])) / 2.0f, (float) i2));
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int a2 = a(rVar2, iArr2, sb);
        if (v6Var != null) {
            v6Var.a(new u6((float) a2, (float) i2));
        }
        int[] a3 = a(rVar2, a2);
        if (a3[0] - a2 <= 1) {
            if (v6Var != null) {
                v6Var.a(new u6(((float) (a3[0] + a3[1])) / 2.0f, (float) i2));
            }
            if (a(iArr2, a3)) {
                int i3 = a3[1];
                if ((i3 - a3[0]) + i3 >= rVar.e() || !a(a3[0], i3, rVar2)) {
                    throw a.a();
                }
                String sb2 = sb.toString();
                if (sb2.length() < 8) {
                    throw a.a();
                } else if (a(sb2)) {
                    float f2 = (float) i2;
                    s6 s6Var = new s6(sb2, (byte[]) null, new u6[]{new u6((float) iArr2[0], f2), new u6((float) a3[1], f2)}, a());
                    a(s6Var, a3, i, rVar, map);
                    return s6Var;
                } else {
                    throw a.a();
                }
            } else {
                throw a.a();
            }
        } else {
            throw a.a();
        }
    }

    static int[] b(r rVar, int i) throws a {
        int[] iArr = new int[c.length];
        int[] iArr2 = null;
        boolean z = false;
        while (!z) {
            int[] iArr3 = c;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = a(rVar, i, false, iArr3, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            int i5 = i4 + 3;
            while (i4 <= i5 && (i4 < 0 || !(z = rVar.a(i4, i2, false, true)))) {
                i4++;
            }
            i = i3;
        }
        return iArr2;
    }

    public static int b(CharSequence charSequence) throws a {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw a.a();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw a.a();
            }
            i3 += charAt2;
        }
        return (1000 - i3) % 10;
    }

    private void a(s6 s6Var, int[] iArr, int i, r rVar, Map<l1, ?> map) throws a {
        int i2;
        int[] iArr2;
        int i3 = 0;
        try {
            s6 a2 = this.b.a(i, rVar, iArr[1]);
            s6Var.a(a2.j());
            i2 = a2.k().length();
        } catch (a unused) {
            i2 = 0;
        }
        if (map == null) {
            iArr2 = null;
        } else {
            iArr2 = (int[]) map.get(l1.ALLOWED_EAN_EXTENSIONS);
        }
        if (iArr2 != null) {
            int length = iArr2.length;
            while (i3 < length) {
                if (i2 != iArr2[i3]) {
                    i3++;
                } else {
                    return;
                }
            }
            throw a.a();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) throws a {
        return a((CharSequence) str);
    }

    public static boolean a(CharSequence charSequence) throws a {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        if (b(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int[] a(r rVar, int i) throws a {
        return a(rVar, i, false, c);
    }

    static int[] a(r rVar, int i, boolean z, int[] iArr) throws a {
        return a(rVar, i, z, iArr, new int[iArr.length]);
    }

    private static int[] a(r rVar, int i, boolean z, int[] iArr, int[] iArr2) throws a {
        int e2 = rVar.e();
        int d2 = z ? rVar.d(i) : rVar.c(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = d2;
        while (d2 < e2) {
            if (rVar.b(d2) == z2) {
                if (i2 != length - 1) {
                    i2++;
                } else if (g5.a(iArr2, iArr, 0.8f) < 0.46f) {
                    return new int[]{i3, d2};
                } else {
                    i3 += iArr2[0] + iArr2[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i2] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            } else if (i2 < 0 || i2 >= iArr2.length) {
                throw a.a();
            } else {
                iArr2[i2] = iArr2[i2] + 1;
            }
            d2++;
        }
        throw a.a();
    }

    static int a(r rVar, int[] iArr, int i, int[][] iArr2) throws a {
        g5.a(rVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.46f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float a2 = g5.a(iArr, iArr2[i3], 0.8f);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw a.a();
    }
}
