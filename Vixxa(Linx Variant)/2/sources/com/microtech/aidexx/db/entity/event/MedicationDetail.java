package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.common.ExtendsKt;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\b\u00101\u001a\u000202H\u0016J\u0012\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u00105\u001a\u00020\nHÖ\u0001J\b\u00106\u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00067"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/MedicationDetail;", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "category_name", "", "tradeName", "manufacturer", "english_name", "quantity", "", "unit", "", "medicationId", "medicationPresetId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DILjava/lang/String;Ljava/lang/String;)V", "getCategory_name", "()Ljava/lang/String;", "setCategory_name", "(Ljava/lang/String;)V", "getEnglish_name", "setEnglish_name", "getManufacturer", "setManufacturer", "getMedicationId", "setMedicationId", "getMedicationPresetId", "setMedicationPresetId", "getQuantity", "()D", "setQuantity", "(D)V", "getTradeName", "setTradeName", "getUnit", "()I", "setUnit", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getCurrClassMutableListType", "Ljava/lang/reflect/Type;", "getEventDesc", "splitter", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MedicationEntity.kt */
public final class MedicationDetail extends BaseEventDetail {
    private String category_name;
    private String english_name;
    private String manufacturer;
    private String medicationId;
    private String medicationPresetId;
    private double quantity;
    private String tradeName;
    private int unit;

    public MedicationDetail() {
        this((String) null, (String) null, (String) null, (String) null, Utils.DOUBLE_EPSILON, 0, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MedicationDetail copy$default(MedicationDetail medicationDetail, String str, String str2, String str3, String str4, double d, int i, String str5, String str6, int i2, Object obj) {
        MedicationDetail medicationDetail2 = medicationDetail;
        int i3 = i2;
        return medicationDetail.copy((i3 & 1) != 0 ? medicationDetail2.category_name : str, (i3 & 2) != 0 ? medicationDetail2.tradeName : str2, (i3 & 4) != 0 ? medicationDetail2.manufacturer : str3, (i3 & 8) != 0 ? medicationDetail2.english_name : str4, (i3 & 16) != 0 ? medicationDetail2.quantity : d, (i3 & 32) != 0 ? medicationDetail2.unit : i, (i3 & 64) != 0 ? medicationDetail2.medicationId : str5, (i3 & 128) != 0 ? medicationDetail2.medicationPresetId : str6);
    }

    public final String component1() {
        return this.category_name;
    }

    public final String component2() {
        return this.tradeName;
    }

    public final String component3() {
        return this.manufacturer;
    }

    public final String component4() {
        return this.english_name;
    }

    public final double component5() {
        return this.quantity;
    }

    public final int component6() {
        return this.unit;
    }

    public final String component7() {
        return this.medicationId;
    }

    public final String component8() {
        return this.medicationPresetId;
    }

    public final MedicationDetail copy(String str, String str2, String str3, String str4, double d, int i, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str2, "tradeName");
        Intrinsics.checkNotNullParameter(str3, "manufacturer");
        return new MedicationDetail(str, str2, str3, str4, d, i, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MedicationDetail)) {
            return false;
        }
        MedicationDetail medicationDetail = (MedicationDetail) obj;
        return Intrinsics.areEqual((Object) this.category_name, (Object) medicationDetail.category_name) && Intrinsics.areEqual((Object) this.tradeName, (Object) medicationDetail.tradeName) && Intrinsics.areEqual((Object) this.manufacturer, (Object) medicationDetail.manufacturer) && Intrinsics.areEqual((Object) this.english_name, (Object) medicationDetail.english_name) && Double.compare(this.quantity, medicationDetail.quantity) == 0 && this.unit == medicationDetail.unit && Intrinsics.areEqual((Object) this.medicationId, (Object) medicationDetail.medicationId) && Intrinsics.areEqual((Object) this.medicationPresetId, (Object) medicationDetail.medicationPresetId);
    }

    public int hashCode() {
        String str = this.category_name;
        int i = 0;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.tradeName.hashCode()) * 31) + this.manufacturer.hashCode()) * 31;
        String str2 = this.english_name;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Double.hashCode(this.quantity)) * 31) + Integer.hashCode(this.unit)) * 31;
        String str3 = this.medicationId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.medicationPresetId;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MedicationDetail(java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, double r15, int r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0013
        L_0x0012:
            r3 = r12
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r4 = r13
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r14
        L_0x0020:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = 0
            goto L_0x0028
        L_0x0027:
            r6 = r15
        L_0x0028:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x002e
            r8 = 0
            goto L_0x0030
        L_0x002e:
            r8 = r17
        L_0x0030:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0036
            r9 = r2
            goto L_0x0038
        L_0x0036:
            r9 = r18
        L_0x0038:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r2 = r19
        L_0x003f:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r18 = r8
            r19 = r9
            r20 = r2
            r11.<init>(r12, r13, r14, r15, r16, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.event.MedicationDetail.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCategory_name() {
        return this.category_name;
    }

    public final void setCategory_name(String str) {
        this.category_name = str;
    }

    public final String getTradeName() {
        return this.tradeName;
    }

    public final void setTradeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tradeName = str;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void setManufacturer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.manufacturer = str;
    }

    public final String getEnglish_name() {
        return this.english_name;
    }

    public final void setEnglish_name(String str) {
        this.english_name = str;
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

    public final String getMedicationId() {
        return this.medicationId;
    }

    public final void setMedicationId(String str) {
        this.medicationId = str;
    }

    public final String getMedicationPresetId() {
        return this.medicationPresetId;
    }

    public final void setMedicationPresetId(String str) {
        this.medicationPresetId = str;
    }

    public MedicationDetail(String str, String str2, String str3, String str4, double d, int i, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str2, "tradeName");
        Intrinsics.checkNotNullParameter(str3, "manufacturer");
        this.category_name = str;
        this.tradeName = str2;
        this.manufacturer = str3;
        this.english_name = str4;
        this.quantity = d;
        this.unit = i;
        this.medicationId = str5;
        this.medicationPresetId = str6;
    }

    public String toString() {
        return "ExerciseDetailEntity(" + super.toString() + ", category_name='" + this.category_name + "', quantity=" + this.quantity + ", unit=" + this.unit + ", tradeName='" + this.tradeName + "', manufacturer='" + this.manufacturer + "', english_name='" + this.english_name + "')";
    }

    public String getEventDesc(String str) {
        String str2;
        if (str != null && (str2 = getName() + str + ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + getUnitStr()) != null) {
            return str2;
        }
        MedicationDetail medicationDetail = this;
        CharSequence charSequence = this.tradeName;
        if (charSequence.length() == 0) {
            charSequence = this.manufacturer;
        }
        String str3 = (String) charSequence;
        return getName() + (str3.length() > 0 ? "(" + str3 + ')' : "") + '(' + ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + getUnitStr() + ')';
    }

    public Type getCurrClassMutableListType() {
        Type type = new MedicationDetail$getCurrClassMutableListType$$inlined$getMutableListType$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getMutableListType(...)");
        return type;
    }
}
