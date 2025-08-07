package com.microtech.aidexx.db.entity.event.preset;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/preset/InsulinPresetEntity;", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "()V", "categoryName", "", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "comment", "getComment", "setComment", "manufacturer", "getManufacturer", "setManufacturer", "tradeName", "getTradeName", "setTradeName", "getEventDesc", "splitter", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MPresetEntity.kt */
public class InsulinPresetEntity extends BasePresetEntity {
    private String categoryName;
    private String comment = "";
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

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.comment = str;
    }

    public String toString() {
        return "[" + super.toString() + ", category_name='" + this.categoryName + "', trade_name='" + this.tradeName + "', manufacturer='" + this.manufacturer + "', comment='" + this.comment + "']";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getEventDesc(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = r3.tradeName
            java.lang.String r0 = ""
            r1 = 0
            if (r4 == 0) goto L_0x0023
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r2 = r4.length()
            if (r2 != 0) goto L_0x0020
            java.lang.String r4 = r3.manufacturer
            if (r4 == 0) goto L_0x001f
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r1 = r4.length()
            if (r1 != 0) goto L_0x001c
            r4 = r0
        L_0x001c:
            r1 = r4
            java.lang.String r1 = (java.lang.String) r1
        L_0x001f:
            r4 = r1
        L_0x0020:
            r1 = r4
            java.lang.String r1 = (java.lang.String) r1
        L_0x0023:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = r3.getName()
            java.lang.StringBuilder r4 = r4.append(r2)
            if (r1 == 0) goto L_0x0050
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0050
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "("
            r0.<init>(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 41
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x0050:
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r4 = r4.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.event.preset.InsulinPresetEntity.getEventDesc(java.lang.String):java.lang.String");
    }
}
