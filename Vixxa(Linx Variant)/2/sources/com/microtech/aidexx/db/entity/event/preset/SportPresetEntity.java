package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/SportPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "()V", "hourKcalPerKg", "", "getHourKcalPerKg", "()D", "setHourKcalPerKg", "(D)V", "intensityCategoryName", "", "getIntensityCategoryName", "()Ljava/lang/String;", "setIntensityCategoryName", "(Ljava/lang/String;)V", "getEventDesc", "splitter", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public class SportPresetEntity extends BasePresetEntity {
    private double hourKcalPerKg;
    private String intensityCategoryName;

    public final String getIntensityCategoryName() {
        return this.intensityCategoryName;
    }

    public final void setIntensityCategoryName(String str) {
        this.intensityCategoryName = str;
    }

    public final double getHourKcalPerKg() {
        return this.hourKcalPerKg;
    }

    public final void setHourKcalPerKg(double d) {
        this.hourKcalPerKg = d;
    }

    public String toString() {
        return "[intensity_category_name=" + this.intensityCategoryName + ", hour_kcal_per_kg=" + this.hourKcalPerKg + ", " + super.toString() + ']';
    }

    public String getEventDesc(String str) {
        return getName();
    }
}
