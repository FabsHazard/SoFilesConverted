package com.microtech.aidexx.utils.eventbus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/utils/eventbus/CgmDataState;", "", "time", "", "glucoseValueMg", "", "userId", "", "(Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;)V", "getGlucoseValueMg", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Float;Ljava/lang/String;)Lcom/microtech/aidexx/utils/eventbus/CgmDataState;", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventBusEntity.kt */
public final class CgmDataState {
    private final Float glucoseValueMg;
    private final Long time;
    private final String userId;

    public static /* synthetic */ CgmDataState copy$default(CgmDataState cgmDataState, Long l, Float f, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = cgmDataState.time;
        }
        if ((i & 2) != 0) {
            f = cgmDataState.glucoseValueMg;
        }
        if ((i & 4) != 0) {
            str = cgmDataState.userId;
        }
        return cgmDataState.copy(l, f, str);
    }

    public final Long component1() {
        return this.time;
    }

    public final Float component2() {
        return this.glucoseValueMg;
    }

    public final String component3() {
        return this.userId;
    }

    public final CgmDataState copy(Long l, Float f, String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        return new CgmDataState(l, f, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CgmDataState)) {
            return false;
        }
        CgmDataState cgmDataState = (CgmDataState) obj;
        return Intrinsics.areEqual((Object) this.time, (Object) cgmDataState.time) && Intrinsics.areEqual((Object) this.glucoseValueMg, (Object) cgmDataState.glucoseValueMg) && Intrinsics.areEqual((Object) this.userId, (Object) cgmDataState.userId);
    }

    public int hashCode() {
        Long l = this.time;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Float f = this.glucoseValueMg;
        if (f != null) {
            i = f.hashCode();
        }
        return ((hashCode + i) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "CgmDataState(time=" + this.time + ", glucoseValueMg=" + this.glucoseValueMg + ", userId=" + this.userId + ')';
    }

    public CgmDataState(Long l, Float f, String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        this.time = l;
        this.glucoseValueMg = f;
        this.userId = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CgmDataState(Long l, Float f, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : f, str);
    }

    public final Long getTime() {
        return this.time;
    }

    public final Float getGlucoseValueMg() {
        return this.glucoseValueMg;
    }

    public final String getUserId() {
        return this.userId;
    }
}
