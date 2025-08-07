package com.microtech.aidexx.db.entity;

import android.content.res.Resources;
import com.microtech.aidexx.R;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.UnitManager;
import java.util.Date;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020\u0006J\u0010\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020$J\u0010\u0010'\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020\tH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "()V", "testTime", "Ljava/util/Date;", "bloodGlucose", "", "(Ljava/util/Date;F)V", "bloodGlucoseId", "", "getBloodGlucoseId", "()Ljava/lang/String;", "setBloodGlucoseId", "(Ljava/lang/String;)V", "bloodGlucoseMg", "getBloodGlucoseMg", "()F", "setBloodGlucoseMg", "(F)V", "calibration", "", "getCalibration", "()Z", "setCalibration", "(Z)V", "testTag", "", "getTestTag", "()I", "setTestTag", "(I)V", "equals", "other", "", "getEventDescription", "res", "Landroid/content/res/Resources;", "getGlucoseValue", "getTagText", "getValueDescription", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BloodGlucoseEntity.kt */
public final class BloodGlucoseEntity extends BaseEventEntity {
    private String bloodGlucoseId;
    private float bloodGlucoseMg;
    private transient boolean calibration;
    private int testTag;

    public final String getBloodGlucoseId() {
        return this.bloodGlucoseId;
    }

    public final void setBloodGlucoseId(String str) {
        this.bloodGlucoseId = str;
    }

    public final int getTestTag() {
        return this.testTag;
    }

    public final void setTestTag(int i) {
        this.testTag = i;
    }

    public final float getBloodGlucoseMg() {
        return this.bloodGlucoseMg;
    }

    public final void setBloodGlucoseMg(float f) {
        this.bloodGlucoseMg = f;
    }

    public final boolean getCalibration() {
        return this.calibration;
    }

    public final void setCalibration(boolean z) {
        this.calibration = z;
    }

    public BloodGlucoseEntity() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.bloodGlucoseId = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
    }

    public BloodGlucoseEntity(Date date, float f) {
        Intrinsics.checkNotNullParameter(date, "testTime");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.bloodGlucoseId = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
        setTimeInfo(date);
        this.bloodGlucoseMg = GlucoseUtilKt.roundOffDecimal(f);
        setLanguage(LanguageResourceManager.INSTANCE.getCurLanguageTag());
    }

    public String getEventDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        if (this.calibration) {
            String string = resources.getString(R.string.glucose_type_calibration);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        String tagText = getTagText(resources);
        CharSequence charSequence = tagText;
        if (charSequence != null && charSequence.length() != 0) {
            return resources.getString(R.string.glucose_type_glucose) + '(' + tagText + ')';
        }
        String string2 = resources.getString(R.string.glucose_type_glucose);
        Intrinsics.checkNotNull(string2);
        return string2;
    }

    public final String getTagText(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        if (this.calibration) {
            return resources.getString(R.string.glucose_type_calibration);
        }
        int i = this.testTag;
        if (i == 99) {
            return resources.getString(R.string.glucose_slot_randomTime);
        }
        switch (i) {
            case 0:
                return "";
            case 1:
                return resources.getString(R.string.glucose_slot_emptyStomach);
            case 2:
                return resources.getString(R.string.glucose_slot_afterBreakfast);
            case 3:
                return resources.getString(R.string.glucose_slot_beforeLunch);
            case 4:
                return resources.getString(R.string.glucose_slot_afterLunch);
            case 5:
                return resources.getString(R.string.glucose_slot_beforeDinner);
            case 6:
                return resources.getString(R.string.glucose_slot_afterDinner);
            case 7:
                return resources.getString(R.string.glucose_slot_beforeSleep);
            case 8:
                return resources.getString(R.string.glucose_slot_beforeDawn);
            default:
                return null;
        }
    }

    public String getValueDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return GlucoseUtilKt.toGlucoseStringWithUnit(this.bloodGlucoseMg);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BloodGlucoseEntity(userId=");
        sb.append(getUserId()).append(", idx=").append(getIdx()).append(", state=").append(getState()).append(", recordIndex=").append(getRecordIndex()).append(", recordId=").append(getRecordId()).append(", deleteStatus=").append(getDeleteStatus()).append(", bloodGlucoseId=").append(this.bloodGlucoseId).append(", id=").append(getId()).append(", testTag=").append(this.testTag).append(", bloodGlucoseMg=").append(this.bloodGlucoseMg).append(", bloodGlucoseMg=").append(this.bloodGlucoseMg).append(", createTime=");
        sb.append(getAppCreateTime()).append(", calibration=").append(this.calibration).append(", language='").append(getLanguage()).append("', uploadState=").append(getUploadState()).append(')');
        return sb.toString();
    }

    public int hashCode() {
        String str = this.bloodGlucoseId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof BloodGlucoseEntity) && Intrinsics.areEqual((Object) ((BloodGlucoseEntity) obj).bloodGlucoseId, (Object) this.bloodGlucoseId);
    }

    public final float getGlucoseValue() {
        if (this.bloodGlucoseMg < 36.0f) {
            return GlucoseUtilKt.toGlucoseValue(36.0f);
        }
        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L) {
            float f = this.bloodGlucoseMg;
            if (f > 540.0f) {
                return GlucoseUtilKt.toGlucoseValue(538.2f);
            }
            GlucoseUtilKt.toGlucoseValue(f);
            return GlucoseUtilKt.toGlucoseValue(this.bloodGlucoseMg);
        }
        float f2 = this.bloodGlucoseMg;
        if (f2 >= 600.0f) {
            return GlucoseUtilKt.toGlucoseValue(599.0f);
        }
        return GlucoseUtilKt.toGlucoseValue(f2);
    }
}
