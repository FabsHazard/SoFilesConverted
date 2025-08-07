package com.microtech.aidexx.db.entity;

import android.content.res.Resources;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.EncryptUtils;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.UnitManager;
import com.microtechmd.blecomm.parser.CgmHistoryEntity;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\bb\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010'\u001a\u00020\u0005H\u0016J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010*\u001a\u00020\u0005H\u0016J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020!H\u0016J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010t\u001a\u00020\u0005H\u0016J\u0007\u0010\u0001\u001a\u00020\u000bJ\u0013\u0010\u0001\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010\u0001\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001J\u0013\u0010\u0001\u001a\u00020\u00052\n\b\u0002\u0010\u0001\u001a\u00030\u0001J\u0013\u0010\u0001\u001a\u00020\u000b2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\b\u0010\u0001\u001a\u00030\u0001J\t\u0010\u0001\u001a\u00020\u000bH\u0016J\u0007\u0010\u0001\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010'\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0007\"\u0004\b)\u0010\tR\u001e\u0010*\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u00100\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR \u00103\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\u001e\u00106\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%R\u001e\u00109\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR\u001a\u0010<\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR\u001a\u0010?\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0007\"\u0004\bA\u0010\tR\u001e\u0010B\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bC\u0010#\"\u0004\bD\u0010%R\u001e\u0010E\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R\u001e\u0010H\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bI\u0010#\"\u0004\bJ\u0010%R\u001e\u0010K\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bL\u0010#\"\u0004\bM\u0010%R\u001e\u0010N\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bO\u0010#\"\u0004\bP\u0010%R\u001e\u0010Q\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R\u001e\u0010T\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bU\u0010#\"\u0004\bV\u0010%R\u001e\u0010W\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R\u001e\u0010Z\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b[\u0010#\"\u0004\b\\\u0010%R\u001e\u0010]\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b^\u0010,\"\u0004\b_\u0010.R\u001e\u0010`\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\ba\u0010#\"\u0004\bb\u0010%R\u001e\u0010c\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bd\u0010#\"\u0004\be\u0010%R\u001a\u0010f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0007\"\u0004\bh\u0010\tR\u001e\u0010i\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\bj\u0010#\"\u0004\bk\u0010%R\u001a\u0010l\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR \u0010q\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\r\"\u0004\bs\u0010\u000fR\u001e\u0010t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0007\"\u0004\bv\u0010\tR\u001a\u0010w\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0007\"\u0004\by\u0010\tR$\u0010z\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0007\"\u0004\b|\u0010\tR\u001a\u0010}\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0007\"\u0004\b\u0010\tR\u001d\u0010\u0001\u001a\u00020\u001aX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u001d\"\u0005\b\u0001\u0010\u001f¨\u0006\u0001"}, d2 = {"Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "Lcom/microtechmd/blecomm/parser/CgmHistoryEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "()V", "briefUploadState", "", "getBriefUploadState", "()I", "setBriefUploadState", "(I)V", "cgmRecordId", "", "getCgmRecordId", "()Ljava/lang/String;", "setCgmRecordId", "(Ljava/lang/String;)V", "dataStatus", "getDataStatus", "setDataStatus", "deviceId", "getDeviceId", "setDeviceId", "deviceSn", "getDeviceSn", "setDeviceSn", "value", "Ljava/util/Date;", "deviceTime", "getDeviceTime", "()Ljava/util/Date;", "setDeviceTime", "(Ljava/util/Date;)V", "eventDataOrigin", "", "getEventDataOrigin", "()Ljava/lang/Float;", "setEventDataOrigin", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "eventIndex", "getEventIndex", "setEventIndex", "eventType", "getEventType", "()Ljava/lang/Integer;", "setEventType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "eventWarning", "getEventWarning", "setEventWarning", "frontRecordId", "getFrontRecordId", "setFrontRecordId", "glucose", "getGlucose", "setGlucose", "glucoseIsValid", "getGlucoseIsValid", "setGlucoseIsValid", "language", "getLanguage", "setLanguage", "quality", "getQuality", "setQuality", "rawData1", "getRawData1", "setRawData1", "rawData2", "getRawData2", "setRawData2", "rawData3", "getRawData3", "setRawData3", "rawData4", "getRawData4", "setRawData4", "rawData5", "getRawData5", "setRawData5", "rawData6", "getRawData6", "setRawData6", "rawData7", "getRawData7", "setRawData7", "rawData8", "getRawData8", "setRawData8", "rawData9", "getRawData9", "setRawData9", "rawIsValid", "getRawIsValid", "setRawIsValid", "rawOne", "getRawOne", "setRawOne", "rawTwo", "getRawTwo", "setRawTwo", "rawUploadState", "getRawUploadState", "setRawUploadState", "rawVc", "getRawVc", "setRawVc", "referenceGlucose", "getReferenceGlucose", "()F", "setReferenceGlucose", "(F)V", "sensorId", "getSensorId", "setSensorId", "sensorIndex", "getSensorIndex", "setSensorIndex", "status", "getStatus", "setStatus", "timeOffset", "getTimeOffset", "setTimeOffset", "type", "getType", "setType", "updateTime", "getUpdateTime", "setUpdateTime", "_setDatetime", "", "datetime", "", "_setEventIndex", "_setEventType", "_setEventValue", "eventValue", "_setRawValue", "rawValue", "", "_setSensorIndex", "genChartSetLabel", "getEventDescription", "res", "Landroid/content/res/Resources;", "getEventWarningTip", "getHighOrLowGlucoseType", "isMySelf", "", "getValueDescription", "isGlucoseIsValid", "toString", "updateRecordUUID", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RealCgmHistoryEntity.kt */
public final class RealCgmHistoryEntity extends BaseEventEntity implements CgmHistoryEntity {
    private int briefUploadState;
    private String cgmRecordId;
    private int dataStatus;
    private String deviceId;
    private String deviceSn;
    private Date deviceTime = new Date();
    private Float eventDataOrigin;
    private int eventIndex;
    private Integer eventType;
    private int eventWarning;
    private String frontRecordId;
    private Float glucose;
    private int glucoseIsValid;
    private transient String language = "";
    private int quality;
    private Float rawData1;
    private Float rawData2;
    private Float rawData3;
    private Float rawData4;
    private Float rawData5;
    private Float rawData6;
    private Float rawData7;
    private Float rawData8;
    private Float rawData9;
    private Integer rawIsValid;
    private Float rawOne;
    private Float rawTwo;
    private int rawUploadState;
    private Float rawVc;
    private float referenceGlucose;
    private String sensorId;
    private int sensorIndex;
    private int status;
    private int timeOffset;
    private int type;
    private transient Date updateTime = new Date();

    public final int getBriefUploadState() {
        return this.briefUploadState;
    }

    public final void setBriefUploadState(int i) {
        this.briefUploadState = i;
    }

    public final int getRawUploadState() {
        return this.rawUploadState;
    }

    public final void setRawUploadState(int i) {
        this.rawUploadState = i;
    }

    public final String getDeviceSn() {
        return this.deviceSn;
    }

    public final void setDeviceSn(String str) {
        this.deviceSn = str;
    }

    public final String getCgmRecordId() {
        return this.cgmRecordId;
    }

    public final void setCgmRecordId(String str) {
        this.cgmRecordId = str;
    }

    public final String getSensorId() {
        return this.sensorId;
    }

    public final void setSensorId(String str) {
        this.sensorId = str;
    }

    public final Date getDeviceTime() {
        return this.deviceTime;
    }

    public final void setDeviceTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "value");
        this.deviceTime = date;
        setAppTime(ExtendsKt.formatWithoutZone(date));
        setAppTimeZone(TimeZone.getDefault().getID());
        setDstOffset(String.valueOf(calDstOffset()));
    }

    public final int getEventIndex() {
        return this.eventIndex;
    }

    public final void setEventIndex(int i) {
        this.eventIndex = i;
    }

    public final int getSensorIndex() {
        return this.sensorIndex;
    }

    public final void setSensorIndex(int i) {
        this.sensorIndex = i;
    }

    public final int getDataStatus() {
        return this.dataStatus;
    }

    public final void setDataStatus(int i) {
        this.dataStatus = i;
    }

    public final Integer getEventType() {
        return this.eventType;
    }

    public final void setEventType(Integer num) {
        this.eventType = num;
    }

    public final Float getGlucose() {
        return this.glucose;
    }

    public final void setGlucose(Float f) {
        this.glucose = f;
    }

    public final Float getEventDataOrigin() {
        return this.eventDataOrigin;
    }

    public final void setEventDataOrigin(Float f) {
        this.eventDataOrigin = f;
    }

    public final Integer getRawIsValid() {
        return this.rawIsValid;
    }

    public final void setRawIsValid(Integer num) {
        this.rawIsValid = num;
    }

    public final int getGlucoseIsValid() {
        return this.glucoseIsValid;
    }

    public final void setGlucoseIsValid(int i) {
        this.glucoseIsValid = i;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final void setQuality(int i) {
        this.quality = i;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getTimeOffset() {
        return this.timeOffset;
    }

    public final void setTimeOffset(int i) {
        this.timeOffset = i;
        this.eventIndex = i;
    }

    public final Float getRawOne() {
        return this.rawOne;
    }

    public final void setRawOne(Float f) {
        this.rawOne = f;
    }

    public final Float getRawTwo() {
        return this.rawTwo;
    }

    public final void setRawTwo(Float f) {
        this.rawTwo = f;
    }

    public final Float getRawVc() {
        return this.rawVc;
    }

    public final void setRawVc(Float f) {
        this.rawVc = f;
    }

    public final int getEventWarning() {
        return this.eventWarning;
    }

    public final void setEventWarning(int i) {
        this.eventWarning = i;
    }

    public final float getReferenceGlucose() {
        return this.referenceGlucose;
    }

    public final void setReferenceGlucose(float f) {
        this.referenceGlucose = f;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final Date getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.updateTime = date;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.language = str;
    }

    public final String getFrontRecordId() {
        return this.frontRecordId;
    }

    public final void setFrontRecordId(String str) {
        this.frontRecordId = str;
    }

    public final String updateRecordUUID() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.sensorId).append(this.timeOffset);
        return EncryptUtils.Companion.md5(stringBuffer.toString());
    }

    public void _setDatetime(long j) {
        setDeviceTime(new Date(j * ((long) 1000)));
    }

    public void _setEventIndex(int i) {
        this.eventIndex = i;
    }

    public void _setSensorIndex(int i) {
        this.sensorIndex = i;
    }

    public void _setEventType(int i) {
        this.eventType = Integer.valueOf(i);
    }

    public void _setEventValue(float f) {
        this.glucose = Float.valueOf(f);
    }

    public final Float getRawData1() {
        return this.rawData1;
    }

    public final void setRawData1(Float f) {
        this.rawData1 = f;
    }

    public final Float getRawData2() {
        return this.rawData2;
    }

    public final void setRawData2(Float f) {
        this.rawData2 = f;
    }

    public final Float getRawData3() {
        return this.rawData3;
    }

    public final void setRawData3(Float f) {
        this.rawData3 = f;
    }

    public final Float getRawData4() {
        return this.rawData4;
    }

    public final void setRawData4(Float f) {
        this.rawData4 = f;
    }

    public final Float getRawData5() {
        return this.rawData5;
    }

    public final void setRawData5(Float f) {
        this.rawData5 = f;
    }

    public final Float getRawData6() {
        return this.rawData6;
    }

    public final void setRawData6(Float f) {
        this.rawData6 = f;
    }

    public final Float getRawData7() {
        return this.rawData7;
    }

    public final void setRawData7(Float f) {
        this.rawData7 = f;
    }

    public final Float getRawData8() {
        return this.rawData8;
    }

    public final void setRawData8(Float f) {
        this.rawData8 = f;
    }

    public final Float getRawData9() {
        return this.rawData9;
    }

    public final void setRawData9(Float f) {
        this.rawData9 = f;
    }

    public void _setRawValue(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "rawValue");
        this.rawData1 = Float.valueOf(fArr[0]);
        this.rawData2 = Float.valueOf(fArr[1]);
        this.rawData3 = Float.valueOf(fArr[2]);
        this.rawData4 = Float.valueOf(fArr[3]);
        this.rawData5 = Float.valueOf(fArr[4]);
        this.rawData6 = Float.valueOf(fArr[5]);
        this.rawData7 = Float.valueOf(fArr[6]);
        this.rawData8 = Float.valueOf(fArr[7]);
        this.rawData9 = Float.valueOf(fArr[8]);
    }

    public final String getEventWarningTip(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        int i = this.eventWarning;
        if (i == 1) {
            String string = resources.getString(R.string.cgm_warning_high);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (i == 2) {
            String string2 = resources.getString(R.string.cgm_warning_low);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (i != 3) {
            return "";
        } else {
            String string3 = resources.getString(R.string.cgm_warning_urgentLow);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
    }

    public String getEventDescription(Resources resources) {
        String string;
        Intrinsics.checkNotNullParameter(resources, "res");
        int highOrLowGlucoseType = getHighOrLowGlucoseType(false);
        String str = "";
        if (highOrLowGlucoseType == 0) {
            Integer num = this.eventType;
            if (num != null && num.intValue() == 11) {
                string = resources.getString(R.string.cgm_warning_high);
            } else {
                if (num != null && num.intValue() == 10) {
                    string = resources.getString(R.string.cgm_warning_low);
                }
                Intrinsics.checkNotNull(str);
                return str;
            }
            str = string;
            Intrinsics.checkNotNull(str);
            return str;
        } else if (highOrLowGlucoseType == 1) {
            String string2 = resources.getString(R.string.cgm_warning_high);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (highOrLowGlucoseType == 2) {
            String string3 = resources.getString(R.string.cgm_warning_low);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else if (highOrLowGlucoseType == 3) {
            String string4 = resources.getString(R.string.cgm_warning_urgentLow);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        } else if (highOrLowGlucoseType != 13) {
            return str;
        } else {
            String string5 = resources.getString(R.string.glucose);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
    }

    public String getValueDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        int i = this.eventWarning;
        Float f = null;
        if (i == 0) {
            Integer num = this.eventType;
            if (num != null && num.intValue() == 11) {
                StringBuilder sb = new StringBuilder();
                int i2 = R.string.hyper_description;
                Float f2 = this.glucose;
                if (f2 != null) {
                    f = Float.valueOf(GlucoseUtilKt.toGlucoseValue(f2.floatValue()));
                }
                return sb.append(resources.getString(i2, new Object[]{f})).append(UnitManager.INSTANCE.getDisplayUnit()).toString();
            } else if (num == null || num.intValue() != 10) {
                return "";
            } else {
                StringBuilder sb2 = new StringBuilder();
                int i3 = R.string.hypo_description;
                Float f3 = this.glucose;
                if (f3 != null) {
                    f = Float.valueOf(GlucoseUtilKt.toGlucoseValue(f3.floatValue()));
                }
                return sb2.append(resources.getString(i3, new Object[]{f})).append(UnitManager.INSTANCE.getDisplayUnit()).toString();
            }
        } else if (i == 1) {
            StringBuilder sb3 = new StringBuilder();
            int i4 = R.string.hyper_description;
            Float f4 = this.glucose;
            if (f4 != null) {
                f = Float.valueOf(GlucoseUtilKt.toGlucoseValue(f4.floatValue()));
            }
            return sb3.append(resources.getString(i4, new Object[]{f})).append(UnitManager.INSTANCE.getDisplayUnit()).toString();
        } else if (i == 2) {
            StringBuilder sb4 = new StringBuilder();
            int i5 = R.string.hypo_description;
            Float f5 = this.glucose;
            if (f5 != null) {
                f = Float.valueOf(GlucoseUtilKt.toGlucoseValue(f5.floatValue()));
            }
            return sb4.append(resources.getString(i5, new Object[]{f})).append(UnitManager.INSTANCE.getDisplayUnit()).toString();
        } else if (i != 13) {
            return "";
        } else {
            StringBuilder sb5 = new StringBuilder();
            int i6 = R.string.bg_description;
            Float f6 = this.glucose;
            if (f6 != null) {
                f = Float.valueOf(GlucoseUtilKt.toGlucoseValue(f6.floatValue()));
            }
            return sb5.append(resources.getString(i6, new Object[]{f})).append(UnitManager.INSTANCE.getDisplayUnit()).toString();
        }
    }

    public static /* synthetic */ int getHighOrLowGlucoseType$default(RealCgmHistoryEntity realCgmHistoryEntity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return realCgmHistoryEntity.getHighOrLowGlucoseType(z);
    }

    public final int getHighOrLowGlucoseType(boolean z) {
        ThresholdManager thresholdManager = ThresholdManager.INSTANCE;
        float hyper = z ? thresholdManager.getHyper() : thresholdManager.getCurUserHyper();
        float hypo = z ? ThresholdManager.INSTANCE.getHypo() : ThresholdManager.INSTANCE.getCurUserHypo();
        Float f = this.glucose;
        if (f == null) {
            return 0;
        }
        float floatValue = f.floatValue();
        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L) {
            float parseFloat = Float.parseFloat(ExtendsKt.setScaleHalfEven(Float.valueOf(floatValue / 18.0f), 1));
            if (parseFloat >= Float.parseFloat(ExtendsKt.setScaleHalfEven(Float.valueOf(hyper / 18.0f), 1))) {
                LogUtil.Companion.eAiDEX("getHighOrLowGlucoseType HISTORY_LOCAL_HYPER");
                return 1;
            } else if (parseFloat <= Float.parseFloat(ExtendsKt.setScaleHalfEven(Float.valueOf(hypo / 18.0f), 1)) && parseFloat >= 3.0f) {
                LogUtil.Companion.eAiDEX("getHighOrLowGlucoseType HISTORY_LOCAL_HYPO");
                return 2;
            } else if (parseFloat >= 3.0f) {
                return 0;
            } else {
                LogUtil.Companion.eAiDEX("getHighOrLowGlucoseType HISTORY_LOCAL_URGENT_HYPO");
                return 3;
            }
        } else if (floatValue >= ((float) MathKt.roundToInt(hyper))) {
            LogUtil.Companion.eAiDEX("getHighOrLowGlucoseType HISTORY_LOCAL_HYPER");
            return 1;
        } else if (floatValue <= ((float) MathKt.roundToInt(hypo)) && floatValue >= 54.0f) {
            LogUtil.Companion.eAiDEX("getHighOrLowGlucoseType HISTORY_LOCAL_HYPO");
            return 2;
        } else if (floatValue >= 54.0f) {
            return 0;
        } else {
            LogUtil.Companion.eAiDEX("getHighOrLowGlucoseType HISTORY_LOCAL_URGENT_HYPO");
            return 3;
        }
    }

    public final boolean isGlucoseIsValid() {
        return this.glucoseIsValid == 1 && this.status == 0;
    }

    public final String genChartSetLabel() {
        StringBuilder sb;
        String str;
        if (ExtendsKt.useAppTime()) {
            StringBuilder append = new StringBuilder().append(this.sensorId).append('*');
            String appTimeZone = getAppTimeZone();
            String str2 = "";
            if (appTimeZone == null || (str = TimeUtils.getTimezoneOffset$default(TimeUtils.INSTANCE, appTimeZone, 0, 2, (Object) null)) == null) {
                str = str2;
            }
            StringBuilder append2 = append.append(str).append('*');
            String dstOffset = getDstOffset();
            if (dstOffset != null) {
                str2 = dstOffset;
            }
            sb = append2.append(str2);
        } else {
            sb = new StringBuilder().append(this.sensorId).append(Soundex.SILENT_MARKER);
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RealCgmHistoryEntity(idx=");
        sb.append(getIdx()).append(", briefUploadState=").append(this.briefUploadState).append(", rawUploadState=").append(this.rawUploadState).append(", state=").append(getState()).append(", id=").append(getId()).append(", deviceSn=").append(this.deviceSn).append(", cgmRecordId=").append(this.cgmRecordId).append(", sensorId=").append(this.sensorId).append(", userId=").append(getUserId()).append(", appTime=").append(getAppTime()).append(", appTimeZone=").append(getAppTimeZone()).append(", dstOffset=");
        sb.append(getDstOffset()).append(", deviceTime=").append(this.deviceTime).append(", eventIndex=").append(this.eventIndex).append(", sensorIndex=").append(this.sensorIndex).append(", dataStatus=").append(this.dataStatus).append(", recordIndex=").append(getRecordIndex()).append(", deleteStatus=").append(getDeleteStatus()).append(", eventType=").append(this.eventType).append(", glucose=").append(this.glucose).append(", eventDataOrigin=").append(this.eventDataOrigin).append(", rawIsValid=").append(this.rawIsValid).append(", glucoseIsValid=").append(this.glucoseIsValid);
        sb.append(", quality=").append(this.quality).append(", status=").append(this.status).append(", autoIncrementColumn=").append(getAutoIncrementColumn()).append(", timeOffset=").append(this.timeOffset).append(", rawOne=").append(this.rawOne).append(", rawTwo=").append(this.rawTwo).append(", rawVc=").append(this.rawVc).append(", eventWarning=").append(this.eventWarning).append(", referenceGlucose=").append(this.referenceGlucose).append(", deviceId=").append(this.deviceId).append(", type=").append(this.type).append(", createTime=");
        sb.append(getAppCreateTime()).append(", updateTime=").append(this.updateTime).append(", language='").append(getLanguage()).append("', uploadState=").append(getUploadState()).append(", recordId=").append(getRecordId()).append(", frontRecordId=").append(this.frontRecordId).append(", rawData1=").append(this.rawData1).append(", rawData2=").append(this.rawData2).append(", rawData3=").append(this.rawData3).append(", rawData4=").append(this.rawData4).append(", rawData5=").append(this.rawData5).append(", rawData6=").append(this.rawData6);
        sb.append(", rawData7=").append(this.rawData7).append(", rawData8=").append(this.rawData8).append(", rawData9=").append(this.rawData9).append(')');
        return sb.toString();
    }
}
