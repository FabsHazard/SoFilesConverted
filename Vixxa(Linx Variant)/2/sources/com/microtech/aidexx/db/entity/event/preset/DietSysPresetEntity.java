package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/DietSysPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/DietPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/BaseSysPreset;", "()V", "energyKcal", "", "getEnergyKcal", "()D", "setEnergyKcal", "(D)V", "foodSysPresetId", "", "getFoodSysPresetId", "()Ljava/lang/Long;", "setFoodSysPresetId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "version", "", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "getServerPresetId", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public final class DietSysPresetEntity extends DietPresetEntity implements BaseSysPreset {
    private double energyKcal;
    private Long foodSysPresetId;
    private String version = "";

    public final double getEnergyKcal() {
        return this.energyKcal;
    }

    public final void setEnergyKcal(double d) {
        this.energyKcal = d;
    }

    public final Long getFoodSysPresetId() {
        return this.foodSysPresetId;
    }

    public final void setFoodSysPresetId(Long l) {
        this.foodSysPresetId = l;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public Long getServerPresetId() {
        return this.foodSysPresetId;
    }

    public String toString() {
        return getClass().getSimpleName() + super.toString();
    }
}
