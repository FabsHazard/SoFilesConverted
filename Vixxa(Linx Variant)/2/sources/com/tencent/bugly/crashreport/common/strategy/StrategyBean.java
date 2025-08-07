package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* compiled from: BUGLY */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new StrategyBean[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }
    };
    public static String a = "https://android.bugly.qq.com/rqd/async";
    public static String b = "https://android.bugly.qq.com/rqd/async";
    public static String c;
    public long d;
    public long e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public long p;
    public String q;
    public String r;
    public String s;
    public Map<String, String> t;
    public int u;
    public long v;
    public long w;

    public int describeContents() {
        return 0;
    }

    public StrategyBean() {
        this.d = -1;
        this.e = -1;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.q = a;
        this.r = b;
        this.u = 10;
        this.v = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.w = -1;
        this.e = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L@)");
        c = sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K@!");
        this.s = sb.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.d = -1;
        this.e = -1;
        boolean z = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = true;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        this.q = a;
        this.r = b;
        this.u = 10;
        this.v = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        this.w = -1;
        try {
            c = "S(@L@L@)";
            this.e = parcel.readLong();
            this.f = parcel.readByte() == 1;
            this.g = parcel.readByte() == 1;
            this.h = parcel.readByte() == 1;
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.t = ap.b(parcel);
            this.i = parcel.readByte() == 1;
            this.j = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.p = parcel.readLong();
            this.k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.l = z;
            this.o = parcel.readLong();
            this.u = parcel.readInt();
            this.v = parcel.readLong();
            this.w = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.e);
        parcel.writeByte(this.f ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        ap.b(parcel, this.t);
        parcel.writeByte(this.i ? (byte) 1 : 0);
        parcel.writeByte(this.j ? (byte) 1 : 0);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        parcel.writeLong(this.p);
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeLong(this.o);
        parcel.writeInt(this.u);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
    }
}
