package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/DietPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "()V", "carbohydrate", "", "getCarbohydrate", "()D", "setCarbohydrate", "(D)V", "fat", "getFat", "setFat", "protein", "getProtein", "setProtein", "quantity", "getQuantity", "setQuantity", "unit", "", "getUnit", "()I", "setUnit", "(I)V", "getEventDesc", "", "splitter", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public class DietPresetEntity extends BasePresetEntity {
    private double carbohydrate;
    private double fat;
    private double protein;
    private double quantity;
    private int unit;

    public final double getProtein() {
        return this.protein;
    }

    public final void setProtein(double d) {
        this.protein = d;
    }

    public final double getFat() {
        return this.fat;
    }

    public final void setFat(double d) {
        this.fat = d;
    }

    public final double getCarbohydrate() {
        return this.carbohydrate;
    }

    public final void setCarbohydrate(double d) {
        this.carbohydrate = d;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final void setQuantity(double d) {
        this.quantity = d;
    }

    public final int getUnit() {
        return this.unit;
    }

    public final void setUnit(int i) {
        this.unit = i;
    }

    public String toString() {
        return "[protein=" + this.protein + ",fat=" + this.fat + ", carbohydrate=" + this.carbohydrate + ", quantity=" + this.quantity + ", unit=" + this.unit + ", " + super.toString() + ']';
    }

    public String getEventDesc(String str) {
        return getName();
    }
}
