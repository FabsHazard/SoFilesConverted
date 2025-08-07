package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\fH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/InsulinSysPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/BaseSysPreset;", "()V", "insulinSysPresetId", "", "getInsulinSysPresetId", "()Ljava/lang/Long;", "setInsulinSysPresetId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "version", "", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getServerPresetId", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public final class InsulinSysPresetEntity extends InsulinPresetEntity implements BaseSysPreset {
    private Long insulinSysPresetId;
    private String version = "";

    public final Long getInsulinSysPresetId() {
        return this.insulinSysPresetId;
    }

    public final void setInsulinSysPresetId(Long l) {
        this.insulinSysPresetId = l;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public Long getServerPresetId() {
        return this.insulinSysPresetId;
    }

    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }
}
