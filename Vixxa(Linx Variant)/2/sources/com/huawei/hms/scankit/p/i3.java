package com.huawei.hms.scankit.p;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: FinderPatternFinder */
public class i3 {
    private static final int[] f = {1, 3, 1, 1};
    private static final int[] g = {1, 1, 3, 1};
    private static boolean h = false;
    private static boolean i = false;
    private static final d j = new d();
    private final s a;
    private final List<e3> b = new ArrayList();
    private final List<e3> c;
    private final int[] d = new int[5];
    private final v6 e;

    /* compiled from: FinderPatternFinder */
    private static final class b implements Comparator<e3>, Serializable {
        private final float a;

        /* renamed from: a */
        public int compare(e3 e3Var, e3 e3Var2) {
            int compare = Integer.compare(e3Var2.a(), e3Var.a());
            return compare == 0 ? Float.compare(Math.abs(e3Var.e() - this.a), Math.abs(e3Var2.e() - this.a)) : compare;
        }

        private b(float f) {
            this.a = f;
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class c implements Comparator<e3>, Serializable {
        private c() {
        }

        /* renamed from: a */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Integer.compare(e3Var2.a(), e3Var.a());
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class d implements Comparator<e3>, Serializable {
        private d() {
        }

        /* renamed from: a */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.e(), e3Var2.e());
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class e implements Comparator<e3>, Serializable {
        private final float a;

        /* renamed from: a */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(Math.abs(e3Var2.e() - this.a), Math.abs(e3Var.e() - this.a));
        }

        private e(float f) {
            this.a = f;
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class f implements Comparator<e3>, Serializable {
        private f() {
        }

        /* renamed from: a */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.b(), e3Var2.b());
        }
    }

    /* compiled from: FinderPatternFinder */
    private static final class g implements Comparator<e3>, Serializable {
        private g() {
        }

        /* renamed from: a */
        public int compare(e3 e3Var, e3 e3Var2) {
            return Float.compare(e3Var.c(), e3Var2.c());
        }
    }

    public i3(s sVar, v6 v6Var) {
        this.a = sVar;
        this.e = v6Var;
        this.c = new ArrayList();
    }

    protected static float a(int[] iArr, int[] iArr2, float f2) {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i2 += iArr[i4];
            i3 += iArr2[i4];
        }
        if (i2 < i3) {
            return Float.POSITIVE_INFINITY;
        }
        float f3 = (float) i2;
        float f4 = f3 / ((float) i3);
        float f5 = f2 * f4;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            float f7 = ((float) iArr2[i5]) * f4;
            float f8 = (float) i6;
            float f9 = f8 > f7 ? f8 - f7 : f7 - f8;
            if (f9 > f5) {
                return Float.POSITIVE_INFINITY;
            }
            f6 += f9;
        }
        return f6 / f3;
    }

    private e3[] c() throws a {
        if (this.b.size() > 2) {
            try {
                return f();
            } catch (a unused) {
                if (this.c.size() > 0) {
                    Collections.sort(this.c, new c());
                    int min = Math.min(3, this.c.size());
                    for (int i2 = 0; i2 < min; i2++) {
                        e3 e3Var = this.c.get(i2);
                        float e2 = e3Var.e();
                        float c2 = e3Var.c();
                        float b2 = e3Var.b();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.b.size()) {
                                this.b.add(e3Var);
                                break;
                            }
                            e3 e3Var2 = this.b.get(i3);
                            if (e3Var2.b(e2, c2, b2)) {
                                this.b.set(i3, e3Var2.a(c2, b2, e2, false));
                                break;
                            }
                            i3++;
                        }
                    }
                    return f();
                }
                throw a.a();
            }
        } else {
            if (this.b.size() == 2) {
                int i4 = this.b.get(0).e() > this.b.get(1).e() ? 0 : 1;
                if (((double) (Math.max(this.b.get(0).e(), this.b.get(1).e()) / Math.min(this.b.get(0).e(), this.b.get(1).e()))) > 1.5d) {
                    this.b.clear();
                    this.b.add(this.b.get(i4));
                }
            }
            if (this.b.size() <= 1 && this.c.size() >= 1) {
                for (int i5 = 0; i5 < this.b.size(); i5++) {
                    e3 e3Var3 = this.b.get(i5);
                    float e3 = e3Var3.e();
                    float c3 = e3Var3.c();
                    float b3 = e3Var3.b();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= this.c.size()) {
                            this.c.add(e3Var3);
                            break;
                        }
                        e3 e3Var4 = this.c.get(i6);
                        if (e3Var4.b(e3, c3, b3)) {
                            this.c.set(i6, e3Var3.a(e3Var4.c(), e3Var4.b(), e3Var4.e(), false));
                            break;
                        }
                        i6++;
                    }
                }
                this.b.clear();
                this.b.addAll(this.c);
                this.c.clear();
            }
            if (this.b.size() == 2) {
                try {
                    return g();
                } catch (a unused2) {
                    return a();
                }
            } else if (this.b.size() > 1) {
                return f();
            } else {
                throw a.a();
            }
        }
    }

    private int[] d() {
        a(this.d);
        return this.d;
    }

    private static void e() {
        h = false;
        i = false;
    }

    private e3[] f() throws a {
        int size = this.b.size();
        if (size >= 3) {
            e3[] e3VarArr = new e3[3];
            if (size == 3) {
                e3VarArr[0] = this.b.get(0);
                e3VarArr[1] = this.b.get(1);
                e3 e3Var = this.b.get(2);
                e3VarArr[2] = e3Var;
                if (b(e3VarArr[0], e3VarArr[1], e3Var, new float[3])) {
                    return e3VarArr;
                }
                throw a.a();
            }
            Collections.sort(this.b, new c());
            if (this.b.get(2).a() - this.b.get(3).a() <= 1 || this.b.get(2).a() <= 1) {
                float f2 = 0.0f;
                if (this.b.get(3).a() > 1) {
                    float f3 = 0.0f;
                    for (int i2 = 0; i2 < 4; i2++) {
                        f3 += this.b.get(i2).e();
                    }
                    float f4 = f3 / 4.0f;
                    int i3 = 0;
                    for (int i4 = 0; i4 < 4; i4++) {
                        float abs = Math.abs(this.b.get(i4).e() - f4);
                        if (abs > f2) {
                            i3 = i4;
                            f2 = abs;
                        }
                    }
                    if (i3 == 0) {
                        e3VarArr[0] = this.b.get(1);
                        e3VarArr[1] = this.b.get(2);
                        e3VarArr[2] = this.b.get(3);
                    } else if (i3 == 1) {
                        e3VarArr[0] = this.b.get(0);
                        e3VarArr[1] = this.b.get(2);
                        e3VarArr[2] = this.b.get(3);
                    } else if (i3 != 2) {
                        e3VarArr[0] = this.b.get(0);
                        e3VarArr[1] = this.b.get(1);
                        e3VarArr[2] = this.b.get(2);
                    } else {
                        e3VarArr[0] = this.b.get(0);
                        e3VarArr[1] = this.b.get(1);
                        e3VarArr[2] = this.b.get(3);
                    }
                    if (b(e3VarArr[0], e3VarArr[1], e3VarArr[2], new float[3])) {
                        return e3VarArr;
                    }
                    throw a.a();
                } else if (this.b.get(1).a() <= 1 || this.b.get(2).a() != 1) {
                    if (size > 3) {
                        float f5 = 0.0f;
                        float f6 = 0.0f;
                        for (int i5 = 0; i5 < size; i5++) {
                            float e2 = this.b.get(i5).e();
                            f5 += e2;
                            f6 += e2 * e2;
                        }
                        float f7 = (float) size;
                        float f8 = f5 / f7;
                        float sqrt = (float) Math.sqrt((double) ((f6 / f7) - (f8 * f8)));
                        Collections.sort(this.b, new e(f8));
                        float max = Math.max(0.5f * f8, sqrt);
                        int i6 = 0;
                        while (i6 < this.b.size() && this.b.size() > 3) {
                            if (Math.abs(this.b.get(i6).e() - f8) > max) {
                                this.b.remove(i6);
                                i6--;
                            }
                            i6++;
                        }
                    }
                    if (this.b.size() > 15) {
                        Collections.sort(this.b, new c());
                        List<e3> list = this.b;
                        list.subList(15, list.size()).clear();
                    } else if (this.b.size() > 12) {
                        Collections.sort(this.b, new c());
                        List<e3> list2 = this.b;
                        list2.subList(12, list2.size()).clear();
                    }
                    if (this.b.size() >= 6) {
                        Collections.sort(this.b, new f());
                        List<e3> list3 = this.b;
                        list3.subList(4, list3.size() - 2).clear();
                        Collections.sort(this.b, new g());
                        this.b.subList(1, 3).clear();
                        Collections.sort(this.b, new g());
                        List<e3> list4 = this.b;
                        list4.subList(list4.size() - 1, this.b.size()).clear();
                    } else if (this.b.size() > 3) {
                        for (int i7 = 0; i7 < this.b.size(); i7++) {
                            f2 += this.b.get(i7).e();
                        }
                        Collections.sort(this.b, new b(f2 / ((float) this.b.size())));
                        List<e3> list5 = this.b;
                        list5.subList(3, list5.size()).clear();
                    }
                    e3VarArr[0] = this.b.get(0);
                    e3VarArr[1] = this.b.get(1);
                    e3 e3Var2 = this.b.get(2);
                    e3VarArr[2] = e3Var2;
                    if (b(e3VarArr[0], e3VarArr[1], e3Var2, new float[3])) {
                        return e3VarArr;
                    }
                    throw a.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    float e3 = (this.b.get(0).e() + this.b.get(1).e()) / 2.0f;
                    for (int i8 = 2; i8 < size; i8++) {
                        if (((double) Math.abs(this.b.get(i8).e() - e3)) < ((double) e3) * 0.5d) {
                            arrayList.add(this.b.get(i8));
                        }
                    }
                    int i9 = 0;
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        float[] fArr = new float[3];
                        if (b(this.b.get(0), this.b.get(1), (e3) arrayList.get(i10), fArr)) {
                            float f9 = fArr[0];
                            if (f9 >= f2) {
                                i9 = i10;
                                f2 = f9;
                            }
                        }
                    }
                    e3VarArr[0] = this.b.get(0);
                    e3VarArr[1] = this.b.get(1);
                    if (i9 < arrayList.size()) {
                        e3VarArr[2] = (e3) arrayList.get(i9);
                        return e3VarArr;
                    }
                    throw a.a();
                }
            } else {
                e3VarArr[0] = this.b.get(0);
                e3VarArr[1] = this.b.get(1);
                e3VarArr[2] = this.b.get(2);
                return e3VarArr;
            }
        } else {
            throw a.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01b0, code lost:
        if (r4 == false) goto L_0x01b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.huawei.hms.scankit.p.e3[] g() throws com.huawei.hms.scankit.p.a {
        /*
            r28 = this;
            r0 = r28
            java.util.List<com.huawei.hms.scankit.p.e3> r1 = r0.b
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            com.huawei.hms.scankit.p.e3 r1 = (com.huawei.hms.scankit.p.e3) r1
            java.util.List<com.huawei.hms.scankit.p.e3> r3 = r0.b
            r4 = 1
            java.lang.Object r3 = r3.get(r4)
            com.huawei.hms.scankit.p.e3 r3 = (com.huawei.hms.scankit.p.e3) r3
            java.util.List<com.huawei.hms.scankit.p.e3> r5 = r0.b
            java.lang.Object r5 = r5.get(r4)
            com.huawei.hms.scankit.p.e3 r5 = (com.huawei.hms.scankit.p.e3) r5
            double r6 = a((com.huawei.hms.scankit.p.e3) r1, (com.huawei.hms.scankit.p.e3) r3)
            float r8 = r1.e()
            float r9 = r3.e()
            float r8 = java.lang.Math.min(r8, r9)
            java.util.List<com.huawei.hms.scankit.p.e3> r9 = r0.b
            com.huawei.hms.scankit.p.i3$e r10 = new com.huawei.hms.scankit.p.i3$e
            r11 = 0
            r10.<init>(r8)
            java.util.Collections.sort(r9, r10)
            r11 = r2
            r12 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L_0x003d:
            java.util.List<com.huawei.hms.scankit.p.e3> r14 = r0.c
            int r14 = r14.size()
            r15 = 3
            r9 = 2
            if (r11 >= r14) goto L_0x01e0
            java.util.List<com.huawei.hms.scankit.p.e3> r10 = r0.c
            java.lang.Object r10 = r10.get(r11)
            com.huawei.hms.scankit.p.e3 r10 = (com.huawei.hms.scankit.p.e3) r10
            float r14 = r10.e()
            r16 = 1067450368(0x3fa00000, float:1.25)
            float r16 = r16 * r8
            int r16 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r16 > 0) goto L_0x01d2
            r16 = 1061158912(0x3f400000, float:0.75)
            float r16 = r16 * r8
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x0065
            goto L_0x01d2
        L_0x0065:
            double r16 = a((com.huawei.hms.scankit.p.e3) r3, (com.huawei.hms.scankit.p.e3) r10)
            double r18 = a((com.huawei.hms.scankit.p.e3) r1, (com.huawei.hms.scankit.p.e3) r10)
            double[] r14 = new double[r15]
            r14[r2] = r6
            r14[r4] = r16
            r14[r9] = r18
            java.util.Arrays.sort(r14)
            r16 = r14[r9]
            r18 = r14[r4]
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r18 = r18 * r20
            double r16 = r16 - r18
            double r16 = java.lang.Math.abs(r16)
            r18 = r14[r9]
            r22 = r14[r2]
            double r22 = r22 * r20
            double r18 = r18 - r22
            double r18 = java.lang.Math.abs(r18)
            double r16 = r16 + r18
            r18 = r14[r9]
            double r16 = r16 / r18
            r22 = r14[r4]
            r24 = r14[r2]
            double r22 = r22 + r24
            double r22 = r22 - r18
            double r18 = java.lang.Math.sqrt(r24)
            double r18 = r18 * r20
            r20 = r14[r4]
            double r14 = java.lang.Math.sqrt(r20)
            double r18 = r18 * r14
            double r22 = r22 / r18
            boolean r9 = com.huawei.hms.scankit.p.r3.h
            r14 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            if (r9 == 0) goto L_0x01bc
            double r18 = java.lang.Math.abs(r22)
            int r9 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1))
            if (r9 >= 0) goto L_0x01bc
            float r9 = r1.b()
            com.huawei.hms.scankit.p.s r4 = r0.a
            int r4 = r4.e()
            float r4 = (float) r4
            r19 = 1050253722(0x3e99999a, float:0.3)
            float r4 = r4 * r19
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            r9 = 1060320051(0x3f333333, float:0.7)
            if (r4 >= 0) goto L_0x00e7
            float r4 = r3.b()
            com.huawei.hms.scankit.p.s r2 = r0.a
            int r2 = r2.e()
            float r2 = (float) r2
            float r2 = r2 * r9
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00e7
            r2 = 1
            goto L_0x00e8
        L_0x00e7:
            r2 = 0
        L_0x00e8:
            float r4 = r3.b()
            com.huawei.hms.scankit.p.s r14 = r0.a
            int r14 = r14.e()
            float r14 = (float) r14
            float r14 = r14 * r19
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 >= 0) goto L_0x010b
            float r4 = r1.b()
            com.huawei.hms.scankit.p.s r14 = r0.a
            int r14 = r14.e()
            float r14 = (float) r14
            float r14 = r14 * r9
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x010b
            r4 = 1
            goto L_0x010c
        L_0x010b:
            r4 = 0
        L_0x010c:
            float r14 = r1.c()
            com.huawei.hms.scankit.p.s r15 = r0.a
            int r15 = r15.c()
            float r15 = (float) r15
            float r15 = r15 * r19
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 >= 0) goto L_0x012f
            float r14 = r3.c()
            com.huawei.hms.scankit.p.s r15 = r0.a
            int r15 = r15.c()
            float r15 = (float) r15
            float r15 = r15 * r9
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 <= 0) goto L_0x012f
            r14 = 1
            goto L_0x0130
        L_0x012f:
            r14 = 0
        L_0x0130:
            float r15 = r3.c()
            com.huawei.hms.scankit.p.s r9 = r0.a
            int r9 = r9.c()
            float r9 = (float) r9
            float r9 = r9 * r19
            int r9 = (r15 > r9 ? 1 : (r15 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x0157
            float r9 = r1.c()
            com.huawei.hms.scankit.p.s r15 = r0.a
            int r15 = r15.c()
            float r15 = (float) r15
            r21 = 1060320051(0x3f333333, float:0.7)
            float r15 = r15 * r21
            int r9 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r9 <= 0) goto L_0x0157
            r9 = 1
            goto L_0x0158
        L_0x0157:
            r9 = 0
        L_0x0158:
            float r15 = r10.b()
            r26 = r1
            com.huawei.hms.scankit.p.s r1 = r0.a
            int r1 = r1.e()
            float r1 = (float) r1
            float r1 = r1 * r19
            int r1 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0182
            float r1 = r10.b()
            com.huawei.hms.scankit.p.s r15 = r0.a
            int r15 = r15.e()
            float r15 = (float) r15
            r21 = 1060320051(0x3f333333, float:0.7)
            float r15 = r15 * r21
            int r1 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r1 <= 0) goto L_0x0180
            goto L_0x0182
        L_0x0180:
            r1 = 0
            goto L_0x0183
        L_0x0182:
            r1 = 1
        L_0x0183:
            float r15 = r10.c()
            r27 = r3
            com.huawei.hms.scankit.p.s r3 = r0.a
            int r3 = r3.c()
            float r3 = (float) r3
            float r3 = r3 * r19
            int r3 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x01ad
            float r3 = r10.c()
            com.huawei.hms.scankit.p.s r15 = r0.a
            int r15 = r15.c()
            float r15 = (float) r15
            r19 = 1060320051(0x3f333333, float:0.7)
            float r15 = r15 * r19
            int r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r3 <= 0) goto L_0x01ab
            goto L_0x01ad
        L_0x01ab:
            r3 = 0
            goto L_0x01ae
        L_0x01ad:
            r3 = 1
        L_0x01ae:
            if (r2 != 0) goto L_0x01b2
            if (r4 == 0) goto L_0x01b5
        L_0x01b2:
            if (r1 != 0) goto L_0x01b5
            goto L_0x01d6
        L_0x01b5:
            if (r14 != 0) goto L_0x01b9
            if (r9 == 0) goto L_0x01c0
        L_0x01b9:
            if (r3 != 0) goto L_0x01c0
            goto L_0x01d6
        L_0x01bc:
            r26 = r1
            r27 = r3
        L_0x01c0:
            int r1 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
            if (r1 >= 0) goto L_0x01d6
            double r1 = java.lang.Math.abs(r22)
            r3 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x01d6
            r5 = r10
            r12 = r16
            goto L_0x01d6
        L_0x01d2:
            r26 = r1
            r27 = r3
        L_0x01d6:
            int r11 = r11 + 1
            r1 = r26
            r3 = r27
            r2 = 0
            r4 = 1
            goto L_0x003d
        L_0x01e0:
            r1 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            int r1 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0211
            java.util.List<com.huawei.hms.scankit.p.e3> r1 = r0.b
            r1.add(r5)
            com.huawei.hms.scankit.p.e3[] r1 = new com.huawei.hms.scankit.p.e3[r15]
            java.util.List<com.huawei.hms.scankit.p.e3> r2 = r0.b
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            com.huawei.hms.scankit.p.e3 r2 = (com.huawei.hms.scankit.p.e3) r2
            r1[r3] = r2
            java.util.List<com.huawei.hms.scankit.p.e3> r2 = r0.b
            r3 = 1
            java.lang.Object r2 = r2.get(r3)
            com.huawei.hms.scankit.p.e3 r2 = (com.huawei.hms.scankit.p.e3) r2
            r1[r3] = r2
            java.util.List<com.huawei.hms.scankit.p.e3> r2 = r0.b
            java.lang.Object r2 = r2.get(r9)
            com.huawei.hms.scankit.p.e3 r2 = (com.huawei.hms.scankit.p.e3) r2
            r1[r9] = r2
            return r1
        L_0x0211:
            com.huawei.hms.scankit.p.a r1 = com.huawei.hms.scankit.p.a.a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.g():com.huawei.hms.scankit.p.e3[]");
    }

    /* access modifiers changed from: package-private */
    public final k3 b() throws a {
        int c2 = this.a.c();
        int e2 = this.a.e();
        int i2 = (c2 * 3) / 388;
        if (i2 < 3) {
            i2 = 3;
        }
        if (r3.n) {
            i2 = 2;
        }
        a(i2, c2, e2);
        e3[] c3 = c();
        if (c3 != null) {
            u6.a(c3);
            if (((double) (this.a.c() * this.a.e())) / (Math.sqrt(a(c3[0], c3[1])) * Math.sqrt(a(c3[1], c3[2]))) <= 900.0d) {
                return new k3(c3);
            }
            throw a.a();
        }
        throw a.a();
    }

    /* access modifiers changed from: protected */
    public final void d(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean d(int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        int i7;
        s sVar = this.a;
        while (i2 >= 0 && !sVar.b(i3, i2) && (i7 = iArr[3]) <= i4) {
            iArr[3] = i7 + 1;
            i2--;
        }
        if (i2 >= 0 && iArr[3] <= i4) {
            while (i2 >= 0 && sVar.b(i3, i2) && (i6 = iArr[2]) <= i4) {
                iArr[2] = i6 + 1;
                i2--;
            }
            if (i2 >= 0 && iArr[2] <= i4) {
                while (i2 >= 0 && !sVar.b(i3, i2)) {
                    int i8 = iArr[1];
                    if (i8 > i4) {
                        break;
                    }
                    iArr[1] = i8 + 1;
                    i2--;
                }
                if (i2 >= 0 && iArr[1] <= i4) {
                    while (i2 >= 0 && sVar.b(i3, i2) && (i5 = iArr[0]) <= i4) {
                        iArr[0] = i5 + 1;
                        i2--;
                    }
                    if (iArr[0] > i4) {
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private void a(int r11, int r12, int r13) {
        /*
            r10 = this;
            r0 = 5
            int[] r1 = new int[r0]
            int r2 = r11 + -1
        L_0x0005:
            if (r2 >= r12) goto L_0x005e
            r10.a(r1)
            int[] r3 = new int[r0]
            r4 = 0
            r3[r4] = r4
            r5 = 1
            r3[r5] = r2
            r6 = 2
            r3[r6] = r4
            r7 = 3
            r3[r7] = r13
            r7 = 4
            r3[r7] = r11
            r8 = r4
        L_0x001c:
            if (r8 >= r13) goto L_0x0039
            r3[r6] = r8
            com.huawei.hms.scankit.p.s r9 = r10.a
            boolean r9 = r9.b((int) r8, (int) r2)
            if (r9 == 0) goto L_0x002c
            r10.a((int[]) r1, (int[]) r3)
            goto L_0x0033
        L_0x002c:
            boolean r9 = r10.b(r1, r3)
            if (r9 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            r8 = r3[r6]
            r11 = r3[r7]
        L_0x0037:
            int r8 = r8 + r5
            goto L_0x001c
        L_0x0039:
            boolean r5 = b(r1)
            if (r5 == 0) goto L_0x004e
            r3 = r3[r4]
            r5 = r13
        L_0x0042:
            if (r3 <= r6) goto L_0x004a
            r7 = r1[r3]
            int r5 = r5 - r7
            int r3 = r3 + -1
            goto L_0x0042
        L_0x004a:
            r10.b(r1, r2, r5)
            goto L_0x004f
        L_0x004e:
            r5 = r13
        L_0x004f:
            boolean r3 = a((int[]) r1, (boolean) r4)
            if (r3 == 0) goto L_0x005c
            boolean r3 = r10.a((int[]) r1, (int) r2, (int) r5, (boolean) r4)
            if (r3 == 0) goto L_0x005c
            r11 = r6
        L_0x005c:
            int r2 = r2 + r11
            goto L_0x0005
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int):void");
    }

    private boolean b(int[] iArr, int[] iArr2) {
        int i2 = iArr2[0];
        if ((i2 & 1) != 0) {
            iArr[i2] = iArr[i2] + 1;
        } else if (i2 == 4) {
            if (a(iArr, false)) {
                boolean a2 = a(iArr, iArr2[1], iArr2[2], false);
                if (a2) {
                    iArr2[4] = 2;
                }
                if (!a2) {
                    a2 = a(iArr, iArr2[1], iArr2[2]);
                }
                if (a2) {
                    iArr2[0] = 0;
                    a(iArr);
                    return true;
                }
            }
            if (b(iArr)) {
                int i3 = iArr2[2];
                for (int i4 = iArr2[0]; i4 > 2; i4--) {
                    i3 -= iArr[i4];
                }
                if (b(iArr, iArr2[1], i3)) {
                    d(iArr);
                    iArr2[0] = 3;
                    return true;
                }
            }
            if (!r3.h || !a(iArr, true) || !a(iArr, iArr2[1], iArr2[2], true)) {
                d(iArr);
                iArr2[0] = 3;
            } else {
                iArr2[0] = 0;
                a(iArr);
                return true;
            }
        } else {
            int i5 = i2 + 1;
            iArr2[0] = i5;
            iArr[i5] = iArr[i5] + 1;
        }
        return false;
    }

    private void a(int[] iArr, int[] iArr2) {
        int i2 = iArr2[0];
        if ((i2 & 1) == 1) {
            iArr2[0] = i2 + 1;
        }
        int i3 = iArr2[0];
        if (i3 >= 0 && i3 < iArr.length) {
            iArr[i3] = iArr[i3] + 1;
        }
        if (iArr2[2] == iArr2[3] - 1 && iArr2[0] == 4) {
            if (a(iArr, false)) {
                boolean a2 = a(iArr, iArr2[1], iArr2[2], false);
                if (a2) {
                    iArr2[4] = 2;
                }
                if (!a2) {
                    a2 = a(iArr, iArr2[1], iArr2[2]);
                }
                if (a2) {
                    iArr2[0] = 0;
                    a(iArr);
                    while (iArr2[2] < this.a.e() && !this.a.b(iArr2[2], iArr2[1])) {
                        iArr2[2] = iArr2[2] + 1;
                    }
                }
            }
            if (r3.h && a(iArr, true) && a(iArr, iArr2[1], iArr2[2], true)) {
                iArr2[0] = 0;
                a(iArr);
            }
        }
    }

    private static float a(int[] iArr, int i2) {
        return ((float) ((i2 - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    protected static boolean c(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = ((float) i2) / 7.0f;
        float f3 = 0.75f * f2;
        if (Math.abs(f2 - ((float) iArr[0])) >= f3 || Math.abs(f2 - ((float) iArr[1])) >= f3 || Math.abs((f2 * 3.0f) - ((float) iArr[2])) >= 3.0f * f3 || Math.abs(f2 - ((float) iArr[3])) >= f3 || Math.abs(f2 - ((float) iArr[4])) >= f3) {
            return false;
        }
        return true;
    }

    protected static boolean a(int[] iArr, boolean z) {
        float f2;
        float f3;
        e();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        if (!z || !r3.h) {
            f2 = 3.0f;
            f3 = 0.5f;
        } else {
            f3 = 0.75f;
            f2 = 1.0f;
        }
        float f4 = ((float) i2) / 7.0f;
        float f5 = f3 * f4;
        if (Math.abs(f4 - ((float) iArr[0])) < f5 && Math.abs(f4 - ((float) iArr[1])) < f5 && Math.abs((3.0f * f4) - ((float) iArr[2])) < f2 * f5 && Math.abs(f4 - ((float) iArr[3])) < f5 && Math.abs(f4 - ((float) iArr[4])) < f5) {
            return true;
        }
        if (!z) {
            return false;
        }
        int[] iArr2 = new int[(iArr.length - 1)];
        int i5 = 0;
        while (i5 < iArr.length - 1) {
            int i6 = i5 + 1;
            iArr2[i5] = iArr[i6];
            i5 = i6;
        }
        int[] iArr3 = new int[(iArr.length - 1)];
        for (int i7 = 0; i7 < iArr.length - 1; i7++) {
            iArr3[i7] = iArr[i7];
        }
        float a2 = a(iArr2, f, 0.5f);
        float a3 = a(iArr3, g, 0.5f);
        boolean z2 = a2 < 0.3f;
        h = z2;
        boolean z3 = a3 < 0.3f;
        i = z3;
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0088, code lost:
        if ((r11 * 3) > r13) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float b(int r10, int r11, int r12, int r13, boolean r14) {
        /*
            r9 = this;
            com.huawei.hms.scankit.p.s r0 = r9.a
            int r1 = r0.c()
            int[] r2 = r9.d()
            boolean r3 = r9.b((int) r10, (int) r11, (int) r12, (int[]) r2)
            r4 = 2143289344(0x7fc00000, float:NaN)
            if (r3 == 0) goto L_0x0013
            return r4
        L_0x0013:
            r3 = 1
            int r10 = r10 + r3
        L_0x0015:
            r5 = 2
            if (r10 >= r1) goto L_0x0026
            boolean r6 = r0.b((int) r11, (int) r10)
            if (r6 == 0) goto L_0x0026
            r6 = r2[r5]
            int r6 = r6 + r3
            r2[r5] = r6
            int r10 = r10 + 1
            goto L_0x0015
        L_0x0026:
            if (r10 != r1) goto L_0x0029
            return r4
        L_0x0029:
            r6 = 3
            if (r10 >= r1) goto L_0x003d
            boolean r7 = r0.b((int) r11, (int) r10)
            if (r7 != 0) goto L_0x003d
            r7 = r2[r6]
            if (r7 >= r12) goto L_0x003d
            int r7 = r7 + 1
            r2[r6] = r7
            int r10 = r10 + 1
            goto L_0x0029
        L_0x003d:
            if (r10 == r1) goto L_0x0090
            r7 = r2[r6]
            if (r7 < r12) goto L_0x0044
            goto L_0x0090
        L_0x0044:
            r7 = 4
            if (r10 >= r1) goto L_0x0058
            boolean r8 = r0.b((int) r11, (int) r10)
            if (r8 == 0) goto L_0x0058
            r8 = r2[r7]
            if (r8 >= r12) goto L_0x0058
            int r8 = r8 + 1
            r2[r7] = r8
            int r10 = r10 + 1
            goto L_0x0044
        L_0x0058:
            boolean r11 = a((int[]) r2, (boolean) r14)
            if (r11 != 0) goto L_0x005f
            return r4
        L_0x005f:
            r11 = 0
            r11 = r2[r11]
            r12 = r2[r3]
            int r11 = r11 + r12
            r12 = r2[r5]
            int r11 = r11 + r12
            r12 = r2[r6]
            int r11 = r11 + r12
            r12 = r2[r7]
            int r11 = r11 + r12
            if (r14 == 0) goto L_0x0083
            int r11 = r11 - r13
            int r11 = java.lang.Math.abs(r11)
            int r11 = r11 * 5
            int r13 = r13 * r6
            if (r11 < r13) goto L_0x008b
            boolean r11 = i
            if (r11 != 0) goto L_0x008b
            boolean r11 = h
            if (r11 != 0) goto L_0x008b
            return r4
        L_0x0083:
            int r12 = r13 * 3
            if (r11 >= r12) goto L_0x0090
            int r11 = r11 * r6
            if (r11 > r13) goto L_0x008b
            goto L_0x0090
        L_0x008b:
            float r10 = a((int[]) r2, (int) r10)
            return r10
        L_0x0090:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.b(int, int, int, int, boolean):float");
    }

    private boolean c(int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        s sVar = this.a;
        while (i2 >= 0 && !sVar.b(i3, i2) && (i6 = iArr[1]) <= i4) {
            iArr[1] = i6 + 1;
            i2--;
        }
        if (i2 < 0 || iArr[1] > i4) {
            return true;
        }
        while (i2 >= 0 && sVar.b(i3, i2) && (i5 = iArr[0]) <= i4) {
            iArr[0] = i5 + 1;
            i2--;
        }
        if (iArr[0] > i4) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = 0;
        }
    }

    private boolean a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int[] d2 = d();
        int i7 = 0;
        while (i2 >= i7 && i3 >= i7 && this.a.b(i3 - i7, i2 - i7)) {
            d2[2] = d2[2] + 1;
            i7++;
        }
        if (d2[2] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && !this.a.b(i3 - i7, i2 - i7)) {
            d2[1] = d2[1] + 1;
            i7++;
        }
        if (d2[1] == 0) {
            return false;
        }
        while (i2 >= i7 && i3 >= i7 && this.a.b(i3 - i7, i2 - i7)) {
            d2[0] = d2[0] + 1;
            i7++;
        }
        if (d2[0] == 0) {
            return false;
        }
        int c2 = this.a.c();
        int e2 = this.a.e();
        int i8 = 1;
        while (true) {
            int i9 = i2 + i8;
            if (i9 < c2 && (i6 = i3 + i8) < e2 && this.a.b(i6, i9)) {
                d2[2] = d2[2] + 1;
                i8++;
            }
        }
        while (true) {
            int i10 = i2 + i8;
            if (i10 < c2 && (i5 = i3 + i8) < e2 && !this.a.b(i5, i10)) {
                d2[3] = d2[3] + 1;
                i8++;
            }
        }
        if (d2[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i2 + i8;
            if (i11 < c2 && (i4 = i3 + i8) < e2 && this.a.b(i4, i11)) {
                d2[4] = d2[4] + 1;
                i8++;
            }
        }
        if (d2[4] == 0) {
            return false;
        }
        return c(d2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017 A[LOOP:1: B:8:0x0017->B:13:0x0023, LOOP_START, PHI: r5 
      PHI: (r5v2 int) = (r5v1 int), (r5v5 int) binds: [B:6:0x0014, B:13:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.a
        L_0x0002:
            r1 = 1
            if (r5 < 0) goto L_0x0014
            boolean r2 = r0.b((int) r6, (int) r5)
            if (r2 == 0) goto L_0x0014
            r2 = 2
            r3 = r8[r2]
            int r3 = r3 + r1
            r8[r2] = r3
            int r5 = r5 + -1
            goto L_0x0002
        L_0x0014:
            if (r5 >= 0) goto L_0x0017
            return r1
        L_0x0017:
            if (r5 < 0) goto L_0x002a
            boolean r2 = r0.b((int) r6, (int) r5)
            if (r2 != 0) goto L_0x002a
            r2 = r8[r1]
            if (r2 > r7) goto L_0x002a
            int r2 = r2 + 1
            r8[r1] = r2
            int r5 = r5 + -1
            goto L_0x0017
        L_0x002a:
            if (r5 < 0) goto L_0x0045
            r2 = r8[r1]
            if (r2 <= r7) goto L_0x0031
            goto L_0x0045
        L_0x0031:
            r1 = 0
            if (r5 < 0) goto L_0x0045
            boolean r2 = r0.b((int) r6, (int) r5)
            if (r2 == 0) goto L_0x0045
            r2 = r8[r1]
            if (r2 > r7) goto L_0x0045
            int r2 = r2 + 1
            r8[r1] = r2
            int r5 = r5 + -1
            goto L_0x0031
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.b(int, int, int, int[]):boolean");
    }

    private static boolean b(e3 e3Var, e3 e3Var2, e3 e3Var3, float[] fArr) {
        a(e3Var, e3Var2, e3Var3, fArr);
        float sqrt = (float) Math.sqrt((double) fArr[1]);
        float sqrt2 = (float) Math.sqrt((double) fArr[2]);
        float sqrt3 = (float) Math.sqrt((double) fArr[0]);
        if (Math.min(Math.min(sqrt, sqrt2), sqrt3) <= Math.max(Math.max(e3Var.e(), e3Var2.e()), e3Var3.e()) * 7.0f) {
            return false;
        }
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[0];
        float f5 = ((f2 + f3) - f4) / ((sqrt * 2.0f) * sqrt2);
        float f6 = sqrt3 * 2.0f;
        float f7 = ((f4 + f2) - f3) / (sqrt * f6);
        float f8 = ((f4 + f3) - f2) / (f6 * sqrt2);
        if (Math.abs(f5) > 0.45f || f7 < 0.2588f || f7 > 0.94f || f8 < 0.2588f || f8 > 0.94f) {
            return false;
        }
        return true;
    }

    protected static boolean b(int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr[i3];
            if (i4 == 0) {
                return false;
            }
            i2 += i4;
        }
        if (i2 < 7) {
            return false;
        }
        float f2 = ((float) i2) / 7.0f;
        float f3 = 0.5f * f2;
        if (Math.abs(f2 - ((float) iArr[0])) >= f3 || Math.abs((5.0f * f2) - ((float) iArr[1])) >= f3 || Math.abs(f2 - ((float) iArr[2])) >= f3) {
            return false;
        }
        return true;
    }

    private float a(int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int i7;
        s sVar = this.a;
        int e2 = sVar.e();
        int[] d2 = d();
        if (a(i2, i3, i4, d2)) {
            return Float.NaN;
        }
        int i8 = i2 + 1;
        while (i8 < e2 && sVar.b(i8, i3)) {
            d2[2] = d2[2] + 1;
            i8++;
        }
        if (i8 == e2) {
            return Float.NaN;
        }
        while (i8 < e2 && !sVar.b(i8, i3) && (i7 = d2[3]) < i4) {
            d2[3] = i7 + 1;
            i8++;
        }
        if (i8 == e2 || d2[3] >= i4) {
            return Float.NaN;
        }
        while (i8 < e2 && sVar.b(i8, i3) && (i6 = d2[4]) < i4) {
            d2[4] = i6 + 1;
            i8++;
        }
        if (!a(d2, z)) {
            return Float.NaN;
        }
        if (Math.abs(((((d2[0] + d2[1]) + d2[2]) + d2[3]) + d2[4]) - i5) * 5 < i5 || i || h) {
            return a(d2, i8);
        }
        return Float.NaN;
    }

    private float b(int i2, int i3, int i4, int i5) {
        int i6;
        s sVar = this.a;
        int c2 = sVar.c();
        int[] d2 = d();
        if (d(i2, i3, i4, d2)) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < c2 && !sVar.b(i3, i7) && (i6 = d2[3]) <= i4) {
            d2[3] = i6 + 1;
            i7++;
        }
        if (i7 < 0 || d2[3] > i4) {
            return Float.NaN;
        }
        while (i7 < c2 && sVar.b(i3, i7)) {
            d2[4] = d2[4] + 1;
            i7++;
        }
        int i8 = d2[4];
        if (i8 <= i4 && Math.abs(((((d2[0] + d2[1]) + d2[2]) + d2[3]) + i8) - i5) * 5 < i5 * 2 && a(d2, true)) {
            return a(d2, i7);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean b(int[] iArr, int i2, int i3) {
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = i4 + i5 + iArr[2];
        float f2 = (float) (i3 - (i6 / 2));
        int i7 = (int) f2;
        float a2 = a(i2, i7, i5, i6);
        if (Float.isNaN(a2)) {
            int i8 = iArr[1];
            a2 = a(i2, (int) (f2 - ((float) ((i8 * 2) / 5))), (int) (((float) ((i8 * 2) / 5)) + f2), i8, i6);
            if (Float.isNaN(a2) && r3.h) {
                a2 = b(i2, i7, iArr[1], i6);
            }
        }
        if (!Float.isNaN(a2)) {
            return a(false, a2, f2, ((float) i6) / 7.0f);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017 A[LOOP:1: B:8:0x0017->B:13:0x0023, LOOP_START, PHI: r5 
      PHI: (r5v2 int) = (r5v1 int), (r5v5 int) binds: [B:6:0x0014, B:13:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r5, int r6, int r7, int[] r8) {
        /*
            r4 = this;
            com.huawei.hms.scankit.p.s r0 = r4.a
        L_0x0002:
            r1 = 1
            if (r5 < 0) goto L_0x0014
            boolean r2 = r0.b((int) r5, (int) r6)
            if (r2 == 0) goto L_0x0014
            r2 = 2
            r3 = r8[r2]
            int r3 = r3 + r1
            r8[r2] = r3
            int r5 = r5 + -1
            goto L_0x0002
        L_0x0014:
            if (r5 >= 0) goto L_0x0017
            return r1
        L_0x0017:
            if (r5 < 0) goto L_0x002a
            boolean r2 = r0.b((int) r5, (int) r6)
            if (r2 != 0) goto L_0x002a
            r2 = r8[r1]
            if (r2 > r7) goto L_0x002a
            int r2 = r2 + 1
            r8[r1] = r2
            int r5 = r5 + -1
            goto L_0x0017
        L_0x002a:
            if (r5 < 0) goto L_0x0045
            r2 = r8[r1]
            if (r2 <= r7) goto L_0x0031
            goto L_0x0045
        L_0x0031:
            r1 = 0
            if (r5 < 0) goto L_0x0045
            boolean r2 = r0.b((int) r5, (int) r6)
            if (r2 == 0) goto L_0x0045
            r2 = r8[r1]
            if (r2 > r7) goto L_0x0045
            int r2 = r2 + 1
            r8[r1] = r2
            int r5 = r5 + -1
            goto L_0x0031
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i3.a(int, int, int, int[]):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean a(int[] iArr, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int[] iArr2 = iArr;
        int i6 = 0;
        int i7 = iArr2[0];
        int i8 = iArr2[1];
        int i9 = iArr2[2];
        int i10 = iArr2[3];
        int i11 = iArr2[4];
        int i12 = i7 + i8 + i9 + i10 + i11;
        boolean z2 = h;
        boolean z3 = i;
        if (z2) {
            i5 = i3;
            i4 = i8 + i8 + i9 + i10 + i11;
        } else if (z3) {
            i4 = i7 + i8 + i9 + i10 + i10;
            i5 = i3;
        } else {
            i5 = i3;
            i4 = i12;
        }
        int a2 = (int) a(iArr2, i5);
        float b2 = b(i2, a2, iArr2[2], i4, z);
        boolean z4 = h;
        boolean z5 = i;
        if (!Float.isNaN(b2)) {
            int i13 = (int) b2;
            int i14 = iArr2[2];
            int i15 = i13;
            float f2 = ((float) i4) / 7.0f;
            float a3 = a(a2, i13, i14, i4, z);
            if (!Float.isNaN(a3) && (a(i15, (int) a3) || (z && (z2 || z3 || z4 || z5)))) {
                if (z) {
                    return a(false, b2, a3, f2);
                }
                while (true) {
                    if (i6 < this.b.size()) {
                        e3 e3Var = this.b.get(i6);
                        if (e3Var.b(f2, b2, a3)) {
                            this.b.set(i6, e3Var.a(b2, a3, f2, true));
                            break;
                        }
                        i6++;
                    } else {
                        e3 e3Var2 = new e3(a3, b2, f2, true);
                        this.b.add(e3Var2);
                        v6 v6Var = this.e;
                        if (v6Var != null) {
                            v6Var.a(e3Var2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static double a(e3 e3Var, e3 e3Var2) {
        double b2 = (double) (e3Var.b() - e3Var2.b());
        double c2 = (double) (e3Var.c() - e3Var2.c());
        return (b2 * b2) + (c2 * c2);
    }

    private static void a(e3 e3Var, e3 e3Var2, e3 e3Var3, float[] fArr) {
        float b2 = e3Var.b() - e3Var2.b();
        float c2 = e3Var.c() - e3Var2.c();
        float f2 = (b2 * b2) + (c2 * c2);
        float b3 = e3Var.b() - e3Var3.b();
        float c3 = e3Var.c() - e3Var3.c();
        float f3 = (b3 * b3) + (c3 * c3);
        float b4 = e3Var2.b() - e3Var3.b();
        float c4 = e3Var2.c() - e3Var3.c();
        float f4 = (b4 * b4) + (c4 * c4);
        if (f2 > f4 && f2 > f3) {
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
        } else if (f4 <= f2 || f4 <= f3) {
            fArr[0] = f3;
            fArr[1] = f2;
            fArr[2] = f4;
        } else {
            fArr[0] = f4;
            fArr[1] = f2;
            fArr[2] = f3;
        }
    }

    private float a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        s sVar = this.a;
        int c2 = sVar.c();
        int[] d2 = d();
        if (c(i2, i3, i4, d2)) {
            return Float.NaN;
        }
        int i8 = i2 + 1;
        while (i8 < c2 && !sVar.b(i3, i8)) {
            int i9 = d2[1];
            if (i9 > i4) {
                break;
            }
            d2[1] = i9 + 1;
            i8++;
        }
        if (i8 < 0 || d2[1] > i4) {
            return Float.NaN;
        }
        while (i8 < c2 && sVar.b(i3, i8)) {
            d2[2] = d2[2] + 1;
            i8++;
        }
        if (i8 == c2) {
            return Float.NaN;
        }
        while (i8 < c2 && !sVar.b(i3, i8) && (i7 = d2[3]) < i4) {
            d2[3] = i7 + 1;
            i8++;
        }
        if (i8 == c2 || d2[3] >= i4) {
            return Float.NaN;
        }
        while (i8 < c2 && sVar.b(i3, i8) && (i6 = d2[4]) < i4) {
            d2[4] = i6 + 1;
            i8++;
        }
        int i10 = d2[4];
        if (i10 >= i4 || Math.abs(((((d2[0] + d2[1]) + d2[2]) + d2[3]) + i10) - i5) * 5 >= i5 * 2) {
            return Float.NaN;
        }
        if (r3.h) {
            if (a(d2, true)) {
                return a(d2, i8);
            }
            return Float.NaN;
        } else if (a(d2, false)) {
            return a(d2, i8);
        } else {
            return Float.NaN;
        }
    }

    private float a(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i4;
        int i10 = i5;
        s sVar = this.a;
        int c2 = sVar.c();
        int i11 = i3;
        while (i11 <= i9) {
            int[] d2 = d();
            int i12 = i2;
            while (i12 >= 0 && !sVar.b(i11, i12) && (i8 = d2[1]) <= i10) {
                d2[1] = i8 + 1;
                i12--;
            }
            if (i12 >= 0) {
                double d3 = ((double) i10) * 1.5d;
                if (((double) d2[1]) > d3) {
                    continue;
                } else {
                    while (i12 >= 0 && sVar.b(i11, i12) && (i7 = d2[0]) <= i10) {
                        d2[0] = i7 + 1;
                        i12--;
                    }
                    if (d2[0] > i10 / 2) {
                        continue;
                    } else {
                        int i13 = i2 + 1;
                        while (i13 < c2 && !sVar.b(i11, i13)) {
                            int i14 = d2[1];
                            if (i14 > i10) {
                                break;
                            }
                            d2[1] = i14 + 1;
                            i13++;
                        }
                        if (i13 >= 0 && ((double) d2[1]) <= d3) {
                            while (i13 < c2 && sVar.b(i11, i13)) {
                                d2[2] = d2[2] + 1;
                                i13++;
                            }
                            if (Math.abs(((d2[0] + d2[1]) + d2[2]) - i6) * 5 < i6 * 2 && b(d2)) {
                                return (float) ((i13 - (d2[1] / 2)) - d2[2]);
                            }
                        }
                    }
                }
            }
            i11 += i9 - i3;
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean a(int[] iArr, int i2, int i3) {
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        float a2 = a(iArr, i3);
        float b2 = b(i2, (int) a2, iArr[2], i4, false);
        if (Float.isNaN(b2)) {
            int i5 = iArr[2];
            int i6 = iArr[1];
            int i7 = iArr[3];
            b2 = a(i2, (int) ((a2 - ((float) (i5 / 2))) - ((float) (i6 / 2))), (int) (((float) (i5 / 2)) + a2 + ((float) (i7 / 2))), i6 + i5 + i7, i4);
        }
        if (!Float.isNaN(b2)) {
            return a(false, b2, a2, ((float) i4) / 7.0f);
        }
        return false;
    }

    private boolean a(boolean z, float f2, float f3, float f4) {
        int i2 = 0;
        while (true) {
            if (i2 >= this.c.size()) {
                break;
            }
            e3 e3Var = this.c.get(i2);
            if (e3Var.b(f4, f2, f3)) {
                this.c.set(i2, e3Var.a(f2, f3, f4, false));
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            e3 e3Var2 = new e3(f3, f2, f4, false);
            this.c.add(e3Var2);
            v6 v6Var = this.e;
            if (v6Var != null) {
                v6Var.a(e3Var2);
            }
        }
        return true;
    }

    private e3[] a() throws a {
        e3 e3Var = this.b.get(0);
        e3 e3Var2 = this.b.get(1);
        float[] fArr = e3Var.b() < e3Var2.b() ? new float[]{e3Var.b(), e3Var2.b()} : new float[]{e3Var2.b(), e3Var.b()};
        float[] fArr2 = e3Var.b() < e3Var2.b() ? new float[]{e3Var.c(), e3Var2.c()} : new float[]{e3Var2.c(), e3Var.c()};
        float e2 = (e3Var.e() + e3Var2.e()) / 2.0f;
        float e3 = ((e3Var.e() + e3Var2.e()) * 7.0f) / 1.5f;
        if (Math.abs(fArr[0] - fArr[1]) > e3 && Math.abs(fArr2[0] - fArr2[1]) <= e3) {
            float f2 = fArr[0];
            float f3 = fArr2[0];
            this.b.add(new e3((f2 + f3) - fArr2[1], (f3 + fArr[1]) - f2, e2, false, 0));
        } else if (Math.abs(fArr[0] - fArr[1]) <= e3 && Math.abs(fArr2[0] - fArr2[1]) > e3) {
            float f4 = fArr[0];
            float f5 = fArr[1];
            if (f4 < f5) {
                float f6 = fArr2[1];
                this.b.add(new e3((fArr2[0] + f5) - f6, (f6 + f5) - f4, e2, false, 0));
            } else {
                float f7 = fArr2[0];
                this.b.add(new e3((fArr2[1] + f4) - f7, (f7 + f4) - f5, e2, false, 0));
            }
        } else if (Math.abs(fArr[0] - fArr[1]) > e3 && Math.abs(fArr2[0] - fArr2[1]) > e3) {
            float f8 = fArr[0];
            float f9 = fArr[1];
            float f10 = fArr2[1];
            float f11 = fArr2[0];
            this.b.add(new e3((((f8 + f9) + f10) - f11) / 2.0f, (((f11 + f10) + f8) - f9) / 2.0f, e2, false, 0));
        }
        if (this.b.size() == 3) {
            return new e3[]{this.b.get(0), this.b.get(1), this.b.get(2)};
        }
        throw a.a();
    }
}
