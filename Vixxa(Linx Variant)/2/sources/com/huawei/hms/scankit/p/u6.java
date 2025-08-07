package com.huawei.hms.scankit.p;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: ResultPoint */
public class u6 implements Parcelable {
    public static final Parcelable.Creator<u6> CREATOR = new a();
    private final float a;
    private final float b;
    private int c;
    private boolean d;

    /* compiled from: ResultPoint */
    class a implements Parcelable.Creator<u6> {
        a() {
        }

        /* renamed from: a */
        public u6 createFromParcel(Parcel parcel) {
            return new u6(parcel);
        }

        /* renamed from: a */
        public u6[] newArray(int i) {
            return new u6[i];
        }
    }

    public u6(float f, float f2, int i) {
        this.d = false;
        this.a = f;
        this.b = f2;
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public final float b() {
        return this.a;
    }

    public final float c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u6)) {
            return false;
        }
        u6 u6Var = (u6) obj;
        if (((double) Math.abs(this.a - u6Var.a)) >= 1.0E-4d || ((double) Math.abs(this.b - u6Var.b)) >= 1.0E-4d) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.b + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeFloat(this.b);
    }

    public static void a(u6[] u6VarArr) {
        float a2 = a(u6VarArr[0], u6VarArr[1]);
        float a3 = a(u6VarArr[1], u6VarArr[2]);
        float a4 = a(u6VarArr[0], u6VarArr[2]);
        int[] a5 = a(a3, a2, a4);
        int i = a5[0];
        int i2 = a5[1];
        int i3 = a5[2];
        u6 u6Var = u6VarArr[i];
        u6 u6Var2 = u6VarArr[i2];
        u6 u6Var3 = u6VarArr[i3];
        float[] fArr = {a3, a4, a2};
        if (r3.j % 2 == 0 && ((double) (fArr[i2] / fArr[i])) < 1.1d) {
            u6Var = u6VarArr[i];
            u6Var2 = u6VarArr[i2];
            u6Var3 = u6VarArr[i3];
        }
        if (a(u6Var2, u6Var, u6Var3) < 0.0f) {
            u6 u6Var4 = u6Var3;
            u6Var3 = u6Var2;
            u6Var2 = u6Var4;
        }
        u6VarArr[0] = u6Var2;
        u6VarArr[1] = u6Var;
        u6VarArr[2] = u6Var3;
    }

    public u6(float f, float f2) {
        this.c = 0;
        this.d = false;
        this.a = f;
        this.b = f2;
    }

    public u6(float f, float f2, boolean z) {
        this.c = 0;
        this.a = f;
        this.b = f2;
        this.d = z;
    }

    private static int[] a(float f, float f2, float f3) {
        int i;
        int i2;
        int i3 = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        int i4 = 1;
        int i5 = 0;
        int i6 = 2;
        if (i3 < 0 || f < f3) {
            if (f3 >= f && f3 >= f2) {
                if (i3 <= 0) {
                    i2 = 2;
                    i6 = 0;
                }
                return new int[]{i4, i5, i6};
            } else if (f > f) {
                i = 2;
                i6 = 1;
                i4 = i;
                return new int[]{i4, i5, i6};
            } else {
                i5 = 1;
                i4 = 2;
                i6 = 0;
                return new int[]{i4, i5, i6};
            }
        } else if (f2 > f3) {
            i2 = 2;
            i6 = 1;
            i4 = 0;
        } else {
            i = 0;
            i5 = 1;
            i4 = i;
            return new int[]{i4, i5, i6};
        }
        i5 = i2;
        return new int[]{i4, i5, i6};
    }

    public static float a(u6 u6Var, u6 u6Var2) {
        return s4.a(u6Var.a, u6Var.b, u6Var2.a, u6Var2.b);
    }

    private static float a(u6 u6Var, u6 u6Var2, u6 u6Var3) {
        float f = u6Var2.a;
        float f2 = u6Var2.b;
        return ((u6Var3.a - f) * (u6Var.b - f2)) - ((u6Var3.b - f2) * (u6Var.a - f));
    }

    protected u6(Parcel parcel) {
        this.c = 0;
        this.d = false;
        this.a = parcel.readFloat();
        this.b = parcel.readFloat();
    }
}
