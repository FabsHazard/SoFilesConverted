package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0017\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/MedicineUsrPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/MedicinePresetEntity;", "()V", "autoIncrementColumn", "", "getAutoIncrementColumn", "()Ljava/lang/Long;", "setAutoIncrementColumn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "medicationUserPresetId", "", "getMedicationUserPresetId", "()Ljava/lang/String;", "setMedicationUserPresetId", "(Ljava/lang/String;)V", "equals", "", "other", "", "getPresetId", "getServerPresetId", "hashCode", "", "setServerPresetId", "", "serverId", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public final class MedicineUsrPresetEntity extends MedicinePresetEntity {
    private Long autoIncrementColumn;
    private String medicationUserPresetId = genUuid();

    public final String getMedicationUserPresetId() {
        return this.medicationUserPresetId;
    }

    public final void setMedicationUserPresetId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.medicationUserPresetId = str;
    }

    public final Long getAutoIncrementColumn() {
        return this.autoIncrementColumn;
    }

    public final void setAutoIncrementColumn(Long l) {
        this.autoIncrementColumn = l;
    }

    public Long getServerPresetId() {
        return this.autoIncrementColumn;
    }

    public void setServerPresetId(Long l) {
        this.autoIncrementColumn = l;
    }

    public String getPresetId() {
        return this.medicationUserPresetId;
    }

    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }

    public int hashCode() {
        return this.medicationUserPresetId.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof MedicineUsrPresetEntity) && Intrinsics.areEqual((Object) ((MedicineUsrPresetEntity) obj).medicationUserPresetId, (Object) this.medicationUserPresetId);
    }
}
