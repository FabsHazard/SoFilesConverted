package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqSysPresetMedicationPageInfo;", "Lcom/microtech/aidexx/common/net/entity/ReqPageInfo;", "medicationSysPresetId", "", "(Ljava/lang/Long;)V", "getMedicationSysPresetId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/microtech/aidexx/common/net/entity/ReqSysPresetMedicationPageInfo;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqSysPresetMedicationPageInfo extends ReqPageInfo {
    private final Long medicationSysPresetId;

    public static /* synthetic */ ReqSysPresetMedicationPageInfo copy$default(ReqSysPresetMedicationPageInfo reqSysPresetMedicationPageInfo, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = reqSysPresetMedicationPageInfo.medicationSysPresetId;
        }
        return reqSysPresetMedicationPageInfo.copy(l);
    }

    public final Long component1() {
        return this.medicationSysPresetId;
    }

    public final ReqSysPresetMedicationPageInfo copy(Long l) {
        return new ReqSysPresetMedicationPageInfo(l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReqSysPresetMedicationPageInfo) && Intrinsics.areEqual((Object) this.medicationSysPresetId, (Object) ((ReqSysPresetMedicationPageInfo) obj).medicationSysPresetId);
    }

    public int hashCode() {
        Long l = this.medicationSysPresetId;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "ReqSysPresetMedicationPageInfo(medicationSysPresetId=" + this.medicationSysPresetId + ')';
    }

    public final Long getMedicationSysPresetId() {
        return this.medicationSysPresetId;
    }

    public ReqSysPresetMedicationPageInfo(Long l) {
        super(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
        this.medicationSysPresetId = l;
    }
}
