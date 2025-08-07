package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0017\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/InsulinUsrPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinPresetEntity;", "()V", "autoIncrementColumn", "", "getAutoIncrementColumn", "()Ljava/lang/Long;", "setAutoIncrementColumn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "insulinUserPresetId", "", "getInsulinUserPresetId", "()Ljava/lang/String;", "setInsulinUserPresetId", "(Ljava/lang/String;)V", "equals", "", "other", "", "getPresetId", "getServerPresetId", "hashCode", "", "setServerPresetId", "", "serverId", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public final class InsulinUsrPresetEntity extends InsulinPresetEntity {
    private Long autoIncrementColumn;
    private String insulinUserPresetId = genUuid();

    public final String getInsulinUserPresetId() {
        return this.insulinUserPresetId;
    }

    public final void setInsulinUserPresetId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.insulinUserPresetId = str;
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
        return this.insulinUserPresetId;
    }

    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }

    public int hashCode() {
        return this.insulinUserPresetId.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof InsulinUsrPresetEntity) && Intrinsics.areEqual((Object) ((InsulinUsrPresetEntity) obj).insulinUserPresetId, (Object) this.insulinUserPresetId);
    }
}
