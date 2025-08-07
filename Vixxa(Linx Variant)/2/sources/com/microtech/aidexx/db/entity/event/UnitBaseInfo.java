package com.microtech.aidexx.db.entity.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/UnitBaseInfo;", "", "eventType", "", "value", "default", "name", "", "ratio", "", "status", "(IIILjava/lang/String;DI)V", "getDefault", "()I", "setDefault", "(I)V", "getEventType", "setEventType", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRatio", "()D", "setRatio", "(D)V", "getStatus", "setStatus", "getValue", "setValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UnitEntity.kt */
public final class UnitBaseInfo {

    /* renamed from: default  reason: not valid java name */
    private int f0default;
    private int eventType;
    private String name;
    private double ratio;
    private int status;
    private int value;

    public static /* synthetic */ UnitBaseInfo copy$default(UnitBaseInfo unitBaseInfo, int i, int i2, int i3, String str, double d, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = unitBaseInfo.eventType;
        }
        if ((i5 & 2) != 0) {
            i2 = unitBaseInfo.value;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = unitBaseInfo.f0default;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            str = unitBaseInfo.name;
        }
        String str2 = str;
        if ((i5 & 16) != 0) {
            d = unitBaseInfo.ratio;
        }
        double d2 = d;
        if ((i5 & 32) != 0) {
            i4 = unitBaseInfo.status;
        }
        return unitBaseInfo.copy(i, i6, i7, str2, d2, i4);
    }

    public final int component1() {
        return this.eventType;
    }

    public final int component2() {
        return this.value;
    }

    public final int component3() {
        return this.f0default;
    }

    public final String component4() {
        return this.name;
    }

    public final double component5() {
        return this.ratio;
    }

    public final int component6() {
        return this.status;
    }

    public final UnitBaseInfo copy(int i, int i2, int i3, String str, double d, int i4) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new UnitBaseInfo(i, i2, i3, str, d, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnitBaseInfo)) {
            return false;
        }
        UnitBaseInfo unitBaseInfo = (UnitBaseInfo) obj;
        return this.eventType == unitBaseInfo.eventType && this.value == unitBaseInfo.value && this.f0default == unitBaseInfo.f0default && Intrinsics.areEqual((Object) this.name, (Object) unitBaseInfo.name) && Double.compare(this.ratio, unitBaseInfo.ratio) == 0 && this.status == unitBaseInfo.status;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.eventType) * 31) + Integer.hashCode(this.value)) * 31) + Integer.hashCode(this.f0default)) * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.ratio)) * 31) + Integer.hashCode(this.status);
    }

    public String toString() {
        return "UnitBaseInfo(eventType=" + this.eventType + ", value=" + this.value + ", default=" + this.f0default + ", name=" + this.name + ", ratio=" + this.ratio + ", status=" + this.status + ')';
    }

    public UnitBaseInfo(int i, int i2, int i3, String str, double d, int i4) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.eventType = i;
        this.value = i2;
        this.f0default = i3;
        this.name = str;
        this.ratio = d;
        this.status = i4;
    }

    public final int getEventType() {
        return this.eventType;
    }

    public final void setEventType(int i) {
        this.eventType = i;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i) {
        this.value = i;
    }

    public final int getDefault() {
        return this.f0default;
    }

    public final void setDefault(int i) {
        this.f0default = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final double getRatio() {
        return this.ratio;
    }

    public final void setRatio(double d) {
        this.ratio = d;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }
}
