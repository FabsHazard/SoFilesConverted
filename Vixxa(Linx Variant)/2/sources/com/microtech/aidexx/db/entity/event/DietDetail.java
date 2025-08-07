package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.common.ExtendsKt;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\b\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u00105\u001a\u00020\bHÖ\u0001J\b\u00106\u001a\u00020\u0003H\u0016R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00067"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/DietDetail;", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "foodPresetId", "", "categoryName", "quantity", "", "unit", "", "protein", "fat", "carbohydrate", "foodId", "(Ljava/lang/String;Ljava/lang/String;DIDDDLjava/lang/String;)V", "getCarbohydrate", "()D", "setCarbohydrate", "(D)V", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "getFat", "setFat", "getFoodId", "setFoodId", "getFoodPresetId", "setFoodPresetId", "getProtein", "setProtein", "getQuantity", "setQuantity", "getUnit", "()I", "setUnit", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getCurrClassMutableListType", "Ljava/lang/reflect/Type;", "getEventDesc", "spliter", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DietEntity.kt */
public final class DietDetail extends BaseEventDetail {
    private double carbohydrate;
    private String categoryName;
    private double fat;
    private String foodId;
    private String foodPresetId;
    private double protein;
    private double quantity;
    private int unit;

    public DietDetail() {
        this((String) null, (String) null, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DietDetail copy$default(DietDetail dietDetail, String str, String str2, double d, int i, double d2, double d3, double d4, String str3, int i2, Object obj) {
        DietDetail dietDetail2 = dietDetail;
        int i3 = i2;
        return dietDetail.copy((i3 & 1) != 0 ? dietDetail2.foodPresetId : str, (i3 & 2) != 0 ? dietDetail2.categoryName : str2, (i3 & 4) != 0 ? dietDetail2.quantity : d, (i3 & 8) != 0 ? dietDetail2.unit : i, (i3 & 16) != 0 ? dietDetail2.protein : d2, (i3 & 32) != 0 ? dietDetail2.fat : d3, (i3 & 64) != 0 ? dietDetail2.carbohydrate : d4, (i3 & 128) != 0 ? dietDetail2.foodId : str3);
    }

    public final String component1() {
        return this.foodPresetId;
    }

    public final String component2() {
        return this.categoryName;
    }

    public final double component3() {
        return this.quantity;
    }

    public final int component4() {
        return this.unit;
    }

    public final double component5() {
        return this.protein;
    }

    public final double component6() {
        return this.fat;
    }

    public final double component7() {
        return this.carbohydrate;
    }

    public final String component8() {
        return this.foodId;
    }

    public final DietDetail copy(String str, String str2, double d, int i, double d2, double d3, double d4, String str3) {
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str4, "categoryName");
        return new DietDetail(str, str4, d, i, d2, d3, d4, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DietDetail)) {
            return false;
        }
        DietDetail dietDetail = (DietDetail) obj;
        return Intrinsics.areEqual((Object) this.foodPresetId, (Object) dietDetail.foodPresetId) && Intrinsics.areEqual((Object) this.categoryName, (Object) dietDetail.categoryName) && Double.compare(this.quantity, dietDetail.quantity) == 0 && this.unit == dietDetail.unit && Double.compare(this.protein, dietDetail.protein) == 0 && Double.compare(this.fat, dietDetail.fat) == 0 && Double.compare(this.carbohydrate, dietDetail.carbohydrate) == 0 && Intrinsics.areEqual((Object) this.foodId, (Object) dietDetail.foodId);
    }

    public int hashCode() {
        String str = this.foodPresetId;
        int i = 0;
        int hashCode = (((((((((((((str == null ? 0 : str.hashCode()) * 31) + this.categoryName.hashCode()) * 31) + Double.hashCode(this.quantity)) * 31) + Integer.hashCode(this.unit)) * 31) + Double.hashCode(this.protein)) * 31) + Double.hashCode(this.fat)) * 31) + Double.hashCode(this.carbohydrate)) * 31;
        String str2 = this.foodId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final String getFoodPresetId() {
        return this.foodPresetId;
    }

    public final void setFoodPresetId(String str) {
        this.foodPresetId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DietDetail(java.lang.String r15, java.lang.String r16, double r17, int r19, double r20, double r22, double r24, java.lang.String r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r14 = this;
            r0 = r27
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = ""
            goto L_0x0013
        L_0x0011:
            r3 = r16
        L_0x0013:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001b
            r7 = r5
            goto L_0x001d
        L_0x001b:
            r7 = r17
        L_0x001d:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0023
            r4 = 0
            goto L_0x0025
        L_0x0023:
            r4 = r19
        L_0x0025:
            r9 = r0 & 16
            if (r9 == 0) goto L_0x002b
            r9 = r5
            goto L_0x002d
        L_0x002b:
            r9 = r20
        L_0x002d:
            r11 = r0 & 32
            if (r11 == 0) goto L_0x0033
            r11 = r5
            goto L_0x0035
        L_0x0033:
            r11 = r22
        L_0x0035:
            r13 = r0 & 64
            if (r13 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r5 = r24
        L_0x003c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r2 = r26
        L_0x0043:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r7
            r20 = r4
            r21 = r9
            r23 = r11
            r25 = r5
            r27 = r2
            r15.<init>(r16, r17, r18, r20, r21, r23, r25, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.event.DietDetail.<init>(java.lang.String, java.lang.String, double, int, double, double, double, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final void setCategoryName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryName = str;
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

    public final String getFoodId() {
        return this.foodId;
    }

    public final void setFoodId(String str) {
        this.foodId = str;
    }

    public DietDetail(String str, String str2, double d, int i, double d2, double d3, double d4, String str3) {
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        this.foodPresetId = str;
        this.categoryName = str2;
        this.quantity = d;
        this.unit = i;
        this.protein = d2;
        this.fat = d3;
        this.carbohydrate = d4;
        this.foodId = str3;
    }

    public String toString() {
        return "DietDetailEntity(id=" + getId() + ", foodPresetId=" + this.foodPresetId + ", type=" + getPresetType() + ", name='" + getName() + "', categoryName='" + this.categoryName + "', quantity=" + this.quantity + ", unit=" + this.unit + ", protein=" + this.protein + ", fat=" + this.fat + ", carbohydrate=" + this.carbohydrate + ')';
    }

    public String getEventDesc(String str) {
        return getName() + '(' + ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + getUnitStr() + ')';
    }

    public Type getCurrClassMutableListType() {
        Type type = new DietDetail$getCurrClassMutableListType$$inlined$getMutableListType$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getMutableListType(...)");
        return type;
    }
}
