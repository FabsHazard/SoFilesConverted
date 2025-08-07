package com.microtech.aidexx.db.entity;

import android.content.res.Resources;
import com.microtech.aidexx.utils.EncryptUtils;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\n2\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020\nH\u0016J\u0006\u0010C\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001e\u0010'\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R\u001a\u00102\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R \u00105\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR\u001a\u00108\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR\u001e\u0010;\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001d¨\u0006D"}, d2 = {"Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "()V", "calTime", "Ljava/util/Date;", "getCalTime", "()Ljava/util/Date;", "setCalTime", "(Ljava/util/Date;)V", "calibrationId", "", "getCalibrationId", "()Ljava/lang/String;", "setCalibrationId", "(Ljava/lang/String;)V", "cf", "", "getCf", "()F", "setCf", "(F)V", "deviceId", "getDeviceId", "setDeviceId", "eventIndex", "", "getEventIndex", "()I", "setEventIndex", "(I)V", "index", "getIndex", "setIndex", "indexAfterCal", "getIndexAfterCal", "setIndexAfterCal", "indexBeforeCal", "getIndexBeforeCal", "setIndexBeforeCal", "isValid", "()Ljava/lang/Integer;", "setValid", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "language", "getLanguage", "setLanguage", "offset", "getOffset", "setOffset", "referenceGlucose", "getReferenceGlucose", "setReferenceGlucose", "sensorId", "getSensorId", "setSensorId", "sensorIndex", "getSensorIndex", "setSensorIndex", "timeOffset", "getTimeOffset", "setTimeOffset", "getEventDescription", "res", "Landroid/content/res/Resources;", "getValueDescription", "toString", "updateCalibrationId", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CalibrateEntity.kt */
public final class CalibrateEntity extends BaseEventEntity {
    private Date calTime = new Date();
    private String calibrationId;
    private float cf = 1.0f;
    private String deviceId = "";
    private int eventIndex;
    private int index;
    private int indexAfterCal;
    private int indexBeforeCal;
    private Integer isValid;
    private transient String language = "";
    private float offset;
    private float referenceGlucose;
    private String sensorId;
    private int sensorIndex;
    private int timeOffset;

    public final Date getCalTime() {
        return this.calTime;
    }

    public final void setCalTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.calTime = date;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceId = str;
    }

    public final int getEventIndex() {
        return this.eventIndex;
    }

    public final void setEventIndex(int i) {
        this.eventIndex = i;
    }

    public final String getCalibrationId() {
        return this.calibrationId;
    }

    public final void setCalibrationId(String str) {
        this.calibrationId = str;
    }

    public final int getSensorIndex() {
        return this.sensorIndex;
    }

    public final void setSensorIndex(int i) {
        this.sensorIndex = i;
    }

    public final String getSensorId() {
        return this.sensorId;
    }

    public final void setSensorId(String str) {
        this.sensorId = str;
    }

    public final float getReferenceGlucose() {
        return this.referenceGlucose;
    }

    public final void setReferenceGlucose(float f) {
        this.referenceGlucose = f;
    }

    public final int getIndexBeforeCal() {
        return this.indexBeforeCal;
    }

    public final void setIndexBeforeCal(int i) {
        this.indexBeforeCal = i;
    }

    public final int getIndexAfterCal() {
        return this.indexAfterCal;
    }

    public final void setIndexAfterCal(int i) {
        this.indexAfterCal = i;
    }

    public final float getCf() {
        return this.cf;
    }

    public final void setCf(float f) {
        this.cf = f;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final void setOffset(float f) {
        this.offset = f;
    }

    public final Integer isValid() {
        return this.isValid;
    }

    public final void setValid(Integer num) {
        this.isValid = num;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final int getTimeOffset() {
        return this.timeOffset;
    }

    public final void setTimeOffset(int i) {
        this.timeOffset = i;
    }

    public final String updateCalibrationId() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.sensorId).append(this.index);
        return EncryptUtils.Companion.md5(stringBuffer.toString());
    }

    public String getEventDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    public String getValueDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CalibrateEntity(userId = ");
        sb.append(getUserId()).append(",calTime=").append(this.calTime).append(", language='").append(getLanguage()).append("', deviceId='").append(this.deviceId).append("', eventIndex=").append(this.eventIndex).append(", calibrationId=").append(this.calibrationId).append(", sensorIndex=").append(this.sensorIndex).append(", sensorId=").append(this.sensorId).append(", referenceGlucose=").append(this.referenceGlucose).append(", indexBeforeCal=").append(this.indexBeforeCal).append(", indexAfterCal=").append(this.indexAfterCal).append(", cf=");
        sb.append(this.cf).append(", offset=").append(this.offset).append(", isValid=").append(this.isValid).append(", index=").append(this.index).append(", autoIncrementColumn=").append(getAutoIncrementColumn()).append(", timeOffset=").append(this.timeOffset).append(",appTime=").append(getAppTime()).append(",appTimeZone=").append(getAppTimeZone()).append(",dstOffset=").append(getDstOffset()).append(')');
        return sb.toString();
    }
}
