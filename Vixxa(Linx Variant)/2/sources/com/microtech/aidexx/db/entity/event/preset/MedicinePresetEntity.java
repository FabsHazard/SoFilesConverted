package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/MedicinePresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "()V", "categoryName", "", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "englishName", "getEnglishName", "setEnglishName", "manufacturer", "getManufacturer", "setManufacturer", "tradeName", "getTradeName", "setTradeName", "getEventDesc", "splitter", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public class MedicinePresetEntity extends BasePresetEntity {
    private String categoryName;
    private String englishName;
    private String manufacturer;
    private String tradeName;

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final void setCategoryName(String str) {
        this.categoryName = str;
    }

    public final String getTradeName() {
        return this.tradeName;
    }

    public final void setTradeName(String str) {
        this.tradeName = str;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public final String getEnglishName() {
        return this.englishName;
    }

    public final void setEnglishName(String str) {
        this.englishName = str;
    }

    public String toString() {
        return "[" + super.toString() + ", category_name='" + this.categoryName + "', trade_name='" + this.tradeName + "', manufacturer='" + this.manufacturer + "', english_name='" + this.englishName + "']";
    }

    public String getEventDesc(String str) {
        String str2 = this.tradeName;
        String str3 = "";
        if (str2 == null && (str2 = this.manufacturer) == null) {
            str2 = str3;
        }
        StringBuilder append = new StringBuilder().append(getName());
        if (str2.length() > 0) {
            str3 = "(" + str2 + ')';
        }
        return append.append(str3).toString();
    }
}
