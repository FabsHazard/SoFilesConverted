package com.microtech.aidexx.db.entity;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.utils.EncryptUtils;
import com.microtechmd.blecomm.entity.BleMessage;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010i\u001a\u00020\u0004J\u0010\u0010j\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\rH\u0002J\u001e\u0010\u001b\u001a\u00020l2\u0006\u0010m\u001a\u00020\r2\u0006\u0010n\u001a\u00020\r2\u0006\u0010o\u001a\u00020\u0004J\u0006\u0010p\u001a\u00020\rJ\u0010\u0010p\u001a\u00020\r2\b\u0010q\u001a\u0004\u0018\u00010`J\b\u0010r\u001a\u00020\u0004H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0005R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0005R\u001a\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0005R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0005R\u001a\u0010\"\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\u001c\u0010%\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u001a\u0010(\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u001a\u0010+\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R$\u0010/\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u001a\u00102\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\u001a\u00105\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R\u001a\u00108\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u000209X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\u001c\u0010A\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0014\"\u0004\bC\u0010\u0005R\"\u0010D\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010K\u001a\u00020LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0014\"\u0004\bS\u0010\u0005R\u001a\u0010T\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR \u0010Z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0014\"\u0004\b\\\u0010\u0005R\u001a\u0010]\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R(\u0010a\u001a\u0004\u0018\u00010`2\b\u0010.\u001a\u0004\u0018\u00010`@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001c\u0010f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0014\"\u0004\bh\u0010\u0005¨\u0006s"}, d2 = {"Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "", "()V", "sn", "", "(Ljava/lang/String;)V", "accessId", "", "getAccessId", "()[B", "setAccessId", "([B)V", "calIndex", "", "getCalIndex", "()I", "setCalIndex", "(I)V", "deviceKey", "getDeviceKey", "()Ljava/lang/String;", "setDeviceKey", "deviceMac", "getDeviceMac", "setDeviceMac", "deviceModel", "getDeviceModel", "setDeviceModel", "deviceName", "getDeviceName", "setDeviceName", "deviceSn", "getDeviceSn", "setDeviceSn", "deviceType", "getDeviceType", "setDeviceType", "encryptionKey", "getEncryptionKey", "setEncryptionKey", "et", "getEt", "setEt", "eventIndex", "getEventIndex", "setEventIndex", "value", "expirationTime", "getExpirationTime", "setExpirationTime", "fullEventIndex", "getFullEventIndex", "setFullEventIndex", "fullSensorIndex", "getFullSensorIndex", "setFullSensorIndex", "hyperThreshold", "", "getHyperThreshold", "()F", "setHyperThreshold", "(F)V", "hypoThreshold", "getHypoThreshold", "setHypoThreshold", "id", "getId", "setId", "idx", "", "getIdx", "()Ljava/lang/Long;", "setIdx", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "messageType", "Lcom/microtechmd/blecomm/entity/BleMessage$MessageType;", "getMessageType", "()Lcom/microtechmd/blecomm/entity/BleMessage$MessageType;", "setMessageType", "(Lcom/microtechmd/blecomm/entity/BleMessage$MessageType;)V", "modelName", "getModelName", "setModelName", "needReplace", "", "getNeedReplace", "()Z", "setNeedReplace", "(Z)V", "sensorId", "getSensorId", "setSensorId", "sensorIndex", "getSensorIndex", "setSensorIndex", "Ljava/util/Date;", "sensorStartTime", "getSensorStartTime", "()Ljava/util/Date;", "setSensorStartTime", "(Ljava/util/Date;)V", "version", "getVersion", "setVersion", "getDeviceModelName", "getDeviceTypeByModel", "model", "", "typeWithFlag", "life", "deviceModelName", "startTimeToIndex", "startTime", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterEntity.kt */
public final class TransmitterEntity {
    private byte[] accessId;
    private int calIndex;
    private String deviceKey;
    private String deviceMac;
    private int deviceModel;
    private String deviceName;
    private String deviceSn;
    private int deviceType = 2;
    private byte[] encryptionKey;
    private int et;
    private int eventIndex;
    private int expirationTime;
    private int fullEventIndex;
    private int fullSensorIndex;
    private float hyperThreshold = 180.0f;
    private float hypoThreshold = 70.200005f;
    private String id;
    private Long idx;
    private transient BleMessage.MessageType messageType = BleMessage.MessageType.NORMAL;
    private String modelName;
    private boolean needReplace;
    private String sensorId;
    private int sensorIndex;
    private Date sensorStartTime;
    private String version;

    public final BleMessage.MessageType getMessageType() {
        return this.messageType;
    }

    public final void setMessageType(BleMessage.MessageType messageType2) {
        Intrinsics.checkNotNullParameter(messageType2, "<set-?>");
        this.messageType = messageType2;
    }

    public final int getCalIndex() {
        return this.calIndex;
    }

    public final void setCalIndex(int i) {
        this.calIndex = i;
    }

    public final Long getIdx() {
        return this.idx;
    }

    public final void setIdx(Long l) {
        this.idx = l;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getDeviceMac() {
        return this.deviceMac;
    }

    public final void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getDeviceSn() {
        return this.deviceSn;
    }

    public final void setDeviceSn(String str) {
        this.deviceSn = str;
    }

    public final byte[] getAccessId() {
        return this.accessId;
    }

    public final void setAccessId(byte[] bArr) {
        this.accessId = bArr;
    }

    public final byte[] getEncryptionKey() {
        return this.encryptionKey;
    }

    public final void setEncryptionKey(byte[] bArr) {
        this.encryptionKey = bArr;
    }

    public final Date getSensorStartTime() {
        return this.sensorStartTime;
    }

    public final void setSensorStartTime(Date date) {
        this.sensorStartTime = date;
        if (date != null) {
            int startTimeToIndex = startTimeToIndex(date);
            this.sensorIndex = startTimeToIndex;
            this.sensorId = EncryptUtils.Companion.md5(UserInfoManager.Companion.instance().userId() + this.deviceSn + startTimeToIndex + startTimeToIndex);
        }
    }

    public final boolean getNeedReplace() {
        return this.needReplace;
    }

    public final void setNeedReplace(boolean z) {
        this.needReplace = z;
    }

    public final int getDeviceModel() {
        return this.deviceModel;
    }

    public final void setDeviceModel(int i) {
        this.deviceModel = i;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final void setModelName(String str) {
        this.modelName = str;
    }

    public final int getExpirationTime() {
        return this.expirationTime;
    }

    public final void setExpirationTime(int i) {
        this.expirationTime = i;
        this.et = i;
    }

    public final int getSensorIndex() {
        return this.sensorIndex;
    }

    public final void setSensorIndex(int i) {
        this.sensorIndex = i;
    }

    public final int getEventIndex() {
        return this.eventIndex;
    }

    public final void setEventIndex(int i) {
        this.eventIndex = i;
    }

    public final int getFullEventIndex() {
        return this.fullEventIndex;
    }

    public final void setFullEventIndex(int i) {
        this.fullEventIndex = i;
    }

    public final int getFullSensorIndex() {
        return this.fullSensorIndex;
    }

    public final void setFullSensorIndex(int i) {
        this.fullSensorIndex = i;
    }

    public final float getHyperThreshold() {
        return this.hyperThreshold;
    }

    public final void setHyperThreshold(float f) {
        this.hyperThreshold = f;
    }

    public final float getHypoThreshold() {
        return this.hypoThreshold;
    }

    public final void setHypoThreshold(float f) {
        this.hypoThreshold = f;
    }

    public final String getDeviceKey() {
        return this.deviceKey;
    }

    public final void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public final int getEt() {
        return this.et;
    }

    public final void setEt(int i) {
        this.et = i;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(int i) {
        this.deviceType = i;
    }

    public final String getSensorId() {
        return this.sensorId;
    }

    public final void setSensorId(String str) {
        this.sensorId = str;
    }

    public TransmitterEntity() {
    }

    public TransmitterEntity(String str) {
        Intrinsics.checkNotNullParameter(str, "sn");
        this.deviceSn = str;
    }

    public final void setDeviceModel(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "deviceModelName");
        setExpirationTime(i2);
        this.deviceModel = i;
        this.et = i2;
        this.modelName = str;
    }

    public final int startTimeToIndex() {
        Date date = this.sensorStartTime;
        if (date == null || date == null) {
            return 0;
        }
        return ExtendsKt.millisToIntSeconds(date.getTime());
    }

    public final int startTimeToIndex(Date date) {
        if (date == null) {
            return 0;
        }
        return ExtendsKt.millisToIntSeconds(date.getTime());
    }

    public final String getDeviceModelName() {
        String str = this.modelName;
        return str == null ? "" : str;
    }

    private final String getDeviceTypeByModel(int i) {
        if (i == 0) {
            return "1034_GX01S";
        }
        if (i == 1) {
            return "1034_GX02S";
        }
        if (i == 2) {
            return "1034_GX03S";
        }
        if (i == 3) {
            return "1034_GX01";
        }
        if (i == 4) {
            return "1034_GX02";
        }
        if (i != 5) {
            return "";
        }
        return "1034_GX03";
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("calIndex=");
        StringBuilder append = sb.append(this.calIndex).append(", idx=").append(this.idx).append(", id=").append(this.id).append(", deviceMac=").append(this.deviceMac).append(", version=").append(this.version).append(", deviceSn=").append(this.deviceSn).append(", accessId=");
        byte[] bArr = this.accessId;
        String str3 = null;
        if (bArr != null) {
            str = Arrays.toString(bArr);
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        } else {
            str = null;
        }
        StringBuilder append2 = append.append(str).append(", encryptionKey=");
        byte[] bArr2 = this.encryptionKey;
        if (bArr2 != null) {
            str2 = Arrays.toString(bArr2);
            Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
        } else {
            str2 = null;
        }
        StringBuilder append3 = append2.append(str2).append(", sensorStartTime=");
        Date date = this.sensorStartTime;
        if (date != null) {
            str3 = ExtendsKt.date2ymdhm$default(date, (String) null, 1, (Object) null);
        }
        append3.append(str3).append(", needReplace=").append(this.needReplace).append(", deviceModel=").append(this.deviceModel).append(", expirationTime=");
        sb.append(this.expirationTime).append(", sensorIndex=").append(this.sensorIndex).append(", eventIndex=").append(this.eventIndex).append(", fullEventIndex=").append(this.fullEventIndex).append(", fullSensorIndex=").append(this.fullSensorIndex).append(", hyperThreshold=").append(this.hyperThreshold).append(", hypoThreshold=").append(this.hypoThreshold).append(", deviceKey=").append(this.deviceKey).append(", et=").append(this.et).append(", deviceName=").append(this.deviceName).append(", deviceType=").append(this.deviceType).append(", sensorId=").append(this.sensorId);
        return sb.toString();
    }
}
