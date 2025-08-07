package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\\\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\b\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0005H\u0016J\t\u00106\u001a\u00020\nHÖ\u0001J\b\u00107\u001a\u00020\u0005H\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00068"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/ExerciseDetail;", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "exec_preset_id", "", "intensity_category_name", "", "hour_kcal_per_kg", "", "quantity", "unit", "", "exerciseId", "exercisePresetId", "(Ljava/lang/Long;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;)V", "getExec_preset_id", "()Ljava/lang/Long;", "setExec_preset_id", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExerciseId", "()Ljava/lang/String;", "setExerciseId", "(Ljava/lang/String;)V", "getExercisePresetId", "setExercisePresetId", "getHour_kcal_per_kg", "()D", "setHour_kcal_per_kg", "(D)V", "getIntensity_category_name", "setIntensity_category_name", "getQuantity", "setQuantity", "getUnit", "()I", "setUnit", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;)Lcom/microtech/aidexx/db/entity/event/ExerciseDetail;", "equals", "", "other", "", "getCurrClassMutableListType", "Ljava/lang/reflect/Type;", "getEventDesc", "splitter", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ExerciseEntity.kt */
public final class ExerciseDetail extends BaseEventDetail {
    private Long exec_preset_id;
    private String exerciseId;
    private String exercisePresetId;
    private double hour_kcal_per_kg;
    private String intensity_category_name;
    private double quantity;
    private int unit;

    public ExerciseDetail() {
        this((Long) null, (String) null, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 0, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ExerciseDetail copy$default(ExerciseDetail exerciseDetail, Long l, String str, double d, double d2, int i, String str2, String str3, int i2, Object obj) {
        ExerciseDetail exerciseDetail2 = exerciseDetail;
        return exerciseDetail.copy((i2 & 1) != 0 ? exerciseDetail2.exec_preset_id : l, (i2 & 2) != 0 ? exerciseDetail2.intensity_category_name : str, (i2 & 4) != 0 ? exerciseDetail2.hour_kcal_per_kg : d, (i2 & 8) != 0 ? exerciseDetail2.quantity : d2, (i2 & 16) != 0 ? exerciseDetail2.unit : i, (i2 & 32) != 0 ? exerciseDetail2.exerciseId : str2, (i2 & 64) != 0 ? exerciseDetail2.exercisePresetId : str3);
    }

    public final Long component1() {
        return this.exec_preset_id;
    }

    public final String component2() {
        return this.intensity_category_name;
    }

    public final double component3() {
        return this.hour_kcal_per_kg;
    }

    public final double component4() {
        return this.quantity;
    }

    public final int component5() {
        return this.unit;
    }

    public final String component6() {
        return this.exerciseId;
    }

    public final String component7() {
        return this.exercisePresetId;
    }

    public final ExerciseDetail copy(Long l, String str, double d, double d2, int i, String str2, String str3) {
        return new ExerciseDetail(l, str, d, d2, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExerciseDetail)) {
            return false;
        }
        ExerciseDetail exerciseDetail = (ExerciseDetail) obj;
        return Intrinsics.areEqual((Object) this.exec_preset_id, (Object) exerciseDetail.exec_preset_id) && Intrinsics.areEqual((Object) this.intensity_category_name, (Object) exerciseDetail.intensity_category_name) && Double.compare(this.hour_kcal_per_kg, exerciseDetail.hour_kcal_per_kg) == 0 && Double.compare(this.quantity, exerciseDetail.quantity) == 0 && this.unit == exerciseDetail.unit && Intrinsics.areEqual((Object) this.exerciseId, (Object) exerciseDetail.exerciseId) && Intrinsics.areEqual((Object) this.exercisePresetId, (Object) exerciseDetail.exercisePresetId);
    }

    public int hashCode() {
        Long l = this.exec_preset_id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.intensity_category_name;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Double.hashCode(this.hour_kcal_per_kg)) * 31) + Double.hashCode(this.quantity)) * 31) + Integer.hashCode(this.unit)) * 31;
        String str2 = this.exerciseId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.exercisePresetId;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ExerciseDetail(java.lang.Long r11, java.lang.String r12, double r13, double r15, int r17, java.lang.String r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r11
        L_0x0008:
            r2 = r20 & 2
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r12
        L_0x000f:
            r3 = r20 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0017
            r6 = r4
            goto L_0x0018
        L_0x0017:
            r6 = r13
        L_0x0018:
            r3 = r20 & 8
            if (r3 == 0) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r4 = r15
        L_0x001e:
            r3 = r20 & 16
            if (r3 == 0) goto L_0x0024
            r3 = 0
            goto L_0x0026
        L_0x0024:
            r3 = r17
        L_0x0026:
            r8 = r20 & 32
            if (r8 == 0) goto L_0x002c
            r8 = r1
            goto L_0x002e
        L_0x002c:
            r8 = r18
        L_0x002e:
            r9 = r20 & 64
            if (r9 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r1 = r19
        L_0x0035:
            r11 = r10
            r12 = r0
            r13 = r2
            r14 = r6
            r16 = r4
            r18 = r3
            r19 = r8
            r20 = r1
            r11.<init>(r12, r13, r14, r16, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.event.ExerciseDetail.<init>(java.lang.Long, java.lang.String, double, double, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getExec_preset_id() {
        return this.exec_preset_id;
    }

    public final void setExec_preset_id(Long l) {
        this.exec_preset_id = l;
    }

    public final String getIntensity_category_name() {
        return this.intensity_category_name;
    }

    public final void setIntensity_category_name(String str) {
        this.intensity_category_name = str;
    }

    public final double getHour_kcal_per_kg() {
        return this.hour_kcal_per_kg;
    }

    public final void setHour_kcal_per_kg(double d) {
        this.hour_kcal_per_kg = d;
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

    public final String getExerciseId() {
        return this.exerciseId;
    }

    public final void setExerciseId(String str) {
        this.exerciseId = str;
    }

    public final String getExercisePresetId() {
        return this.exercisePresetId;
    }

    public final void setExercisePresetId(String str) {
        this.exercisePresetId = str;
    }

    public ExerciseDetail(Long l, String str, double d, double d2, int i, String str2, String str3) {
        this.exec_preset_id = l;
        this.intensity_category_name = str;
        this.hour_kcal_per_kg = d;
        this.quantity = d2;
        this.unit = i;
        this.exerciseId = str2;
        this.exercisePresetId = str3;
    }

    public String toString() {
        return "ExerciseDetailEntity(" + super.toString() + ", intensity_category_name='" + this.intensity_category_name + "', quantity=" + this.quantity + ", unit=" + this.unit + ", hour_kcal_per_kg=" + this.hour_kcal_per_kg + ')';
    }

    public String getEventDesc(String str) {
        String str2;
        String str3;
        if (LanguageResourceManager.INSTANCE.isRTL()) {
            if (str != null && (str3 = ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + getUnitStr() + str + getName()) != null) {
                return str3;
            }
            ExerciseDetail exerciseDetail = this;
            return "(" + ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + getUnitStr() + ')' + getName();
        } else if (str != null && (str2 = getName() + str + ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + getUnitStr()) != null) {
            return str2;
        } else {
            ExerciseDetail exerciseDetail2 = this;
            return getName() + '(' + ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + getUnitStr() + ')';
        }
    }

    public Type getCurrClassMutableListType() {
        Type type = new ExerciseDetail$getCurrClassMutableListType$$inlined$getMutableListType$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getMutableListType(...)");
        return type;
    }
}
