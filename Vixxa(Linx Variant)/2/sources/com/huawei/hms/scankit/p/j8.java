package com.huawei.hms.scankit.p;

/* compiled from: WhiteRectangleDetector */
public final class j8 {
    private final s a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public j8(s sVar) throws a {
        this(sVar, 10, sVar.e() / 2, sVar.c() / 2);
    }

    private u6[] b(int[] iArr) throws a {
        int i = iArr[1] - iArr[0];
        u6 u6Var = null;
        int i2 = 1;
        u6 u6Var2 = null;
        while (u6Var2 == null && i2 < i) {
            int i3 = iArr[0];
            int i4 = iArr[3];
            u6Var2 = a((float) i3, (float) (i4 - i2), (float) (i3 + i2), (float) i4);
            i2++;
        }
        if (u6Var2 != null) {
            int i5 = 1;
            u6 u6Var3 = null;
            while (u6Var3 == null && i5 < i) {
                int i6 = iArr[0];
                int i7 = iArr[2];
                u6Var3 = a((float) i6, (float) (i7 + i5), (float) (i6 + i5), (float) i7);
                i5++;
            }
            if (u6Var3 != null) {
                int i8 = 1;
                u6 u6Var4 = null;
                while (u6Var4 == null && i8 < i) {
                    int i9 = iArr[1];
                    int i10 = iArr[2];
                    u6Var4 = a((float) i9, (float) (i10 + i8), (float) (i9 - i8), (float) i10);
                    i8++;
                }
                if (u6Var4 != null) {
                    int i11 = 1;
                    while (u6Var == null && i11 < i) {
                        int i12 = iArr[1];
                        int i13 = iArr[3];
                        u6Var = a((float) i12, (float) (i13 - i11), (float) (i12 - i11), (float) i13);
                        i11++;
                    }
                    if (u6Var != null) {
                        return a(u6Var, u6Var2, u6Var4, u6Var3);
                    }
                    throw a.a();
                }
                throw a.a();
            }
            throw a.a();
        }
        throw a.a();
    }

    private void c(int[] iArr) {
        int i;
        boolean z = true;
        while (true) {
            if ((z || iArr[9] != 1) && (i = iArr[0]) >= 0) {
                boolean a2 = a(iArr[2], iArr[3], i, false);
                if (a2) {
                    iArr[0] = iArr[0] - 1;
                    iArr[5] = 1;
                    iArr[9] = 1;
                } else if (iArr[9] != 1) {
                    iArr[0] = iArr[0] - 1;
                }
                z = a2;
            } else {
                return;
            }
        }
    }

    private void d(int[] iArr) {
        int i;
        boolean z = true;
        while (true) {
            if ((z || iArr[7] != 1) && (i = iArr[1]) < this.c) {
                z = a(iArr[2], iArr[3], i, false);
                if (z) {
                    iArr[1] = iArr[1] + 1;
                    iArr[5] = 1;
                    iArr[7] = 1;
                } else if (iArr[7] != 1) {
                    iArr[1] = iArr[1] + 1;
                }
            } else {
                return;
            }
        }
    }

    private void e(int[] iArr) {
        int i;
        boolean z = true;
        while (true) {
            if ((z || iArr[10] != 1) && (i = iArr[2]) >= 0) {
                boolean a2 = a(iArr[0], iArr[1], i, true);
                if (a2) {
                    iArr[2] = iArr[2] - 1;
                    iArr[5] = 1;
                    iArr[10] = 1;
                } else if (iArr[10] != 1) {
                    iArr[2] = iArr[2] - 1;
                }
                z = a2;
            } else {
                return;
            }
        }
    }

    public u6[] a() throws a {
        int[] iArr = {this.d, this.e, this.g, this.f, 0, 1, 0, 0, 0, 0, 0};
        while (true) {
            if (iArr[5] != 1) {
                break;
            }
            iArr[5] = 0;
            d(iArr);
            if (iArr[1] >= this.c) {
                iArr[4] = 1;
                break;
            }
            a(iArr);
            if (iArr[3] >= this.b) {
                iArr[4] = 1;
                break;
            }
            c(iArr);
            if (iArr[0] < 0) {
                iArr[4] = 1;
                break;
            }
            e(iArr);
            if (iArr[2] < 0) {
                iArr[4] = 1;
                break;
            } else if (iArr[5] == 1) {
                iArr[6] = 1;
            }
        }
        if (iArr[4] != 1 && iArr[6] == 1) {
            return b(iArr);
        }
        throw a.a();
    }

    public j8(s sVar, int i, int i2, int i3) throws a {
        this.a = sVar;
        int c2 = sVar.c();
        this.b = c2;
        int e2 = sVar.e();
        this.c = e2;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.d = i5;
        int i6 = i2 + i4;
        this.e = i6;
        int i7 = i3 - i4;
        this.g = i7;
        int i8 = i3 + i4;
        this.f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= c2 || i6 >= e2) {
            throw a.a();
        }
    }

    private void a(int[] iArr) {
        int i;
        boolean z = true;
        while (true) {
            if ((z || iArr[8] != 1) && (i = iArr[3]) < this.b) {
                boolean a2 = a(iArr[0], iArr[1], i, true);
                if (a2) {
                    iArr[3] = iArr[3] + 1;
                    iArr[5] = 1;
                    iArr[8] = 1;
                } else if (iArr[8] != 1) {
                    iArr[3] = iArr[3] + 1;
                }
                z = a2;
            } else {
                return;
            }
        }
    }

    private u6 a(float f2, float f3, float f4, float f5) {
        int a2 = s4.a(s4.a(f2, f3, f4, f5));
        float f6 = (float) a2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i = 0; i < a2; i++) {
            float f9 = (float) i;
            int a3 = s4.a((f9 * f7) + f2);
            int a4 = s4.a((f9 * f8) + f3);
            if (this.a.b(a3, a4)) {
                return new u6((float) a3, (float) a4);
            }
        }
        return null;
    }

    private u6[] a(u6 u6Var, u6 u6Var2, u6 u6Var3, u6 u6Var4) {
        float b2 = u6Var.b();
        float c2 = u6Var.c();
        float b3 = u6Var2.b();
        float c3 = u6Var2.c();
        float b4 = u6Var3.b();
        float c4 = u6Var3.c();
        float b5 = u6Var4.b();
        float c5 = u6Var4.c();
        if (b2 < ((float) this.c) / 2.0f) {
            return new u6[]{new u6(b5 - 1.0f, c5 + 1.0f), new u6(b3 + 1.0f, c3 + 1.0f), new u6(b4 - 1.0f, c4 - 1.0f), new u6(b2 + 1.0f, c2 - 1.0f)};
        }
        return new u6[]{new u6(b5 + 1.0f, c5 + 1.0f), new u6(b3 + 1.0f, c3 - 1.0f), new u6(b4 - 1.0f, c4 + 1.0f), new u6(b2 - 1.0f, c2 - 1.0f)};
    }

    private boolean a(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.a.b(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.a.b(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }
}
