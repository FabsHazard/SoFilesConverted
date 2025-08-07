package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Result */
public final class s6 implements Parcelable {
    public static final Parcelable.Creator<s6> CREATOR = new a();
    private final String a;
    private final byte[] b;
    private final int c;
    private u6[] d;
    private BarcodeFormat e;
    private final long f;
    private boolean g;
    private final boolean h;
    private final float i;
    private int j;
    private List<Rect> k;
    private boolean l;
    private int m;
    private List<Rect> n;
    private long o;
    private long p;
    private boolean q;
    private boolean r;

    /* compiled from: Result */
    class a implements Parcelable.Creator<s6> {
        a() {
        }

        /* renamed from: a */
        public s6 createFromParcel(Parcel parcel) {
            return new s6(parcel);
        }

        /* renamed from: a */
        public s6[] newArray(int i) {
            return new s6[i];
        }
    }

    public s6(float f2) {
        this.g = false;
        this.q = false;
        this.r = false;
        this.i = f2;
        this.a = null;
        this.b = new byte[0];
        this.c = 0;
        this.d = new u6[0];
        this.e = BarcodeFormat.NONE;
        this.f = 0;
        this.h = false;
        this.j = 0;
        this.l = false;
        this.m = 0;
        this.k = new ArrayList();
        this.n = new ArrayList();
    }

    public void a(float f2) {
        if (f2 < 20.0f) {
            this.j = 0;
        } else if (f2 < 50.0f) {
            this.j = 2;
        } else if (f2 < 90.0f) {
            this.j = 1;
        } else if (f2 < 140.0f) {
            this.j = 0;
        } else if (f2 < 190.0f) {
            this.j = -1;
        } else if (f2 <= 255.0f) {
            this.j = -2;
        }
    }

    public void b(float f2) {
        if (f2 < 50.0f) {
            this.m = 2;
        } else if (f2 < 90.0f) {
            this.m = 1;
        } else if (f2 < 140.0f) {
            this.m = 0;
        } else if (f2 < 190.0f) {
            this.m = -1;
        } else if (f2 <= 255.0f) {
            this.m = -2;
        }
    }

    public void c(boolean z) {
        this.g = z;
    }

    public List<Rect> d() {
        return this.k;
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.o;
    }

    public int f() {
        return this.j;
    }

    public List<Rect> g() {
        return this.n;
    }

    public int h() {
        return this.m;
    }

    public byte[] i() {
        return this.b;
    }

    public u6[] j() {
        return this.d;
    }

    public String k() {
        return this.a;
    }

    public float l() {
        return this.i;
    }

    public boolean m() {
        return this.q;
    }

    public boolean n() {
        return this.l;
    }

    public boolean o() {
        return this.r;
    }

    public boolean p() {
        return this.g;
    }

    public String toString() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
        parcel.writeTypedArray(this.d, i2);
        parcel.writeParcelable(this.e, i2);
        parcel.writeLong(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeFloat(this.i);
        parcel.writeInt(this.j);
        parcel.writeList(this.k);
        parcel.writeLong(this.o);
        parcel.writeLong(this.p);
        parcel.writeInt(this.q ? 1 : 0);
    }

    public BarcodeFormat c() {
        return this.e;
    }

    public void b(i2 i2Var) {
        int d2 = (int) i2Var.d();
        int e2 = (int) i2Var.e();
        this.n.add(new Rect(d2, e2, ((int) i2Var.f()) + d2, ((int) i2Var.c()) + e2));
    }

    public void a(i2 i2Var) {
        int d2 = (int) i2Var.d();
        int e2 = (int) i2Var.e();
        this.k.add(new Rect(d2, e2, ((int) i2Var.f()) + d2, ((int) i2Var.c()) + e2));
    }

    public void b(boolean z) {
        this.l = z;
    }

    public void b(long j2) {
        this.o = j2;
    }

    public void a(int i2) {
        this.m = i2;
    }

    public long b() {
        return this.p;
    }

    public void a(u6[] u6VarArr) {
        u6[] u6VarArr2 = this.d;
        if (u6VarArr2 == null) {
            this.d = u6VarArr;
        } else if (u6VarArr != null && u6VarArr.length > 0) {
            u6[] u6VarArr3 = new u6[(u6VarArr2.length + u6VarArr.length)];
            System.arraycopy(u6VarArr2, 0, u6VarArr3, 0, u6VarArr2.length);
            System.arraycopy(u6VarArr, 0, u6VarArr3, u6VarArr2.length, u6VarArr.length);
            this.d = u6VarArr3;
        }
    }

    public void b(u6[] u6VarArr) {
        this.d = u6VarArr;
    }

    public void a(long j2) {
        this.p = j2;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public void a() {
        this.d = new u6[0];
    }

    public s6(float f2, boolean z) {
        this.g = false;
        this.q = false;
        this.r = false;
        this.i = f2;
        this.a = null;
        this.b = new byte[0];
        this.c = 0;
        this.d = new u6[0];
        this.e = BarcodeFormat.NONE;
        this.f = 0;
        this.h = false;
        this.j = 0;
        this.l = false;
        this.m = 0;
        this.r = z;
        this.k = new ArrayList();
        this.n = new ArrayList();
    }

    public s6(String str, byte[] bArr, u6[] u6VarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, u6VarArr, barcodeFormat, System.currentTimeMillis());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public s6(String str, byte[] bArr, u6[] u6VarArr, BarcodeFormat barcodeFormat, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, u6VarArr, barcodeFormat, j2);
    }

    public s6(String str, byte[] bArr, int i2, u6[] u6VarArr, BarcodeFormat barcodeFormat, long j2) {
        this.g = false;
        this.q = false;
        this.r = false;
        this.a = str;
        this.b = bArr;
        this.c = i2;
        this.d = u6VarArr;
        this.e = barcodeFormat;
        this.f = j2;
        this.i = 1.0f;
        this.h = false;
    }

    protected s6(Parcel parcel) {
        boolean z = false;
        this.g = false;
        this.q = false;
        this.r = false;
        this.a = parcel.readString();
        this.b = parcel.createByteArray();
        this.c = parcel.readInt();
        this.d = (u6[]) parcel.createTypedArray(u6.CREATOR);
        Class<s6> cls = s6.class;
        this.e = (BarcodeFormat) parcel.readParcelable(cls.getClassLoader());
        this.f = parcel.readLong();
        this.g = parcel.readInt() == 1;
        this.h = parcel.readInt() == 1;
        this.i = parcel.readFloat();
        this.j = parcel.readInt();
        if (this.k == null) {
            this.k = new ArrayList();
        }
        parcel.readList(this.k, cls.getClassLoader());
        this.o = parcel.readLong();
        this.p = parcel.readLong();
        this.q = parcel.readInt() == 1 ? true : z;
    }
}
