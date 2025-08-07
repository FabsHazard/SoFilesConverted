package com.microtech.aidexx.ui.setting.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.TimeUtils;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 J2\u00020\u0001:\u0001JB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0017J\u0010\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010.\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003JÂ\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0006H\u0016J\u0013\u0010=\u001a\u00020\u00132\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\r\u0010@\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010 J\u000f\u0010A\u001a\u0004\u0018\u00010BH\u0002¢\u0006\u0002\u0010CJ\t\u0010D\u001a\u00020\u0006HÖ\u0001J\r\u0010E\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\"J\t\u0010F\u001a\u00020\bHÖ\u0001J\u0018\u0010G\u001a\u00020H2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0006H\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010#\u001a\u0004\b\u0012\u0010\"R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019¨\u0006K"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/CgmDevice;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sensorIndex", "", "registerTime", "", "startUpTimeZone", "deviceKey", "sensorStartUp", "dstOffset", "deviceId", "userId", "deviceSn", "sensorId", "et", "isForceReplace", "", "unregisterTime", "deviceMac", "deviceModel", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getDeviceKey", "getDeviceMac", "getDeviceModel", "getDeviceSn", "getDstOffset", "getEt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRegisterTime", "getSensorId", "getSensorIndex", "getSensorStartUp", "getStartUpTimeZone", "getUnregisterTime", "getUserId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/microtech/aidexx/ui/setting/share/CgmDevice;", "describeContents", "equals", "other", "", "getSensorLeftTime", "getSensorStartUpTimestamp", "", "()Ljava/lang/Long;", "hashCode", "isWarmingUp", "toString", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareUserInfo.kt */
public final class CgmDevice implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final String deviceId;
    private final String deviceKey;
    private final String deviceMac;
    private final String deviceModel;
    private final String deviceSn;
    private final String dstOffset;
    private final Integer et;
    private final Boolean isForceReplace;
    private final String registerTime;
    private final String sensorId;
    private final Integer sensorIndex;
    private final String sensorStartUp;
    private final String startUpTimeZone;
    private final String unregisterTime;
    private final String userId;

    public static /* synthetic */ CgmDevice copy$default(CgmDevice cgmDevice, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num2, Boolean bool, String str10, String str11, String str12, int i, Object obj) {
        CgmDevice cgmDevice2 = cgmDevice;
        int i2 = i;
        return cgmDevice.copy((i2 & 1) != 0 ? cgmDevice2.sensorIndex : num, (i2 & 2) != 0 ? cgmDevice2.registerTime : str, (i2 & 4) != 0 ? cgmDevice2.startUpTimeZone : str2, (i2 & 8) != 0 ? cgmDevice2.deviceKey : str3, (i2 & 16) != 0 ? cgmDevice2.sensorStartUp : str4, (i2 & 32) != 0 ? cgmDevice2.dstOffset : str5, (i2 & 64) != 0 ? cgmDevice2.deviceId : str6, (i2 & 128) != 0 ? cgmDevice2.userId : str7, (i2 & 256) != 0 ? cgmDevice2.deviceSn : str8, (i2 & 512) != 0 ? cgmDevice2.sensorId : str9, (i2 & 1024) != 0 ? cgmDevice2.et : num2, (i2 & 2048) != 0 ? cgmDevice2.isForceReplace : bool, (i2 & 4096) != 0 ? cgmDevice2.unregisterTime : str10, (i2 & 8192) != 0 ? cgmDevice2.deviceMac : str11, (i2 & 16384) != 0 ? cgmDevice2.deviceModel : str12);
    }

    public final Integer component1() {
        return this.sensorIndex;
    }

    public final String component10() {
        return this.sensorId;
    }

    public final Integer component11() {
        return this.et;
    }

    public final Boolean component12() {
        return this.isForceReplace;
    }

    public final String component13() {
        return this.unregisterTime;
    }

    public final String component14() {
        return this.deviceMac;
    }

    public final String component15() {
        return this.deviceModel;
    }

    public final String component2() {
        return this.registerTime;
    }

    public final String component3() {
        return this.startUpTimeZone;
    }

    public final String component4() {
        return this.deviceKey;
    }

    public final String component5() {
        return this.sensorStartUp;
    }

    public final String component6() {
        return this.dstOffset;
    }

    public final String component7() {
        return this.deviceId;
    }

    public final String component8() {
        return this.userId;
    }

    public final String component9() {
        return this.deviceSn;
    }

    public final CgmDevice copy(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num2, Boolean bool, String str10, String str11, String str12) {
        return new CgmDevice(num, str, str2, str3, str4, str5, str6, str7, str8, str9, num2, bool, str10, str11, str12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CgmDevice)) {
            return false;
        }
        CgmDevice cgmDevice = (CgmDevice) obj;
        return Intrinsics.areEqual((Object) this.sensorIndex, (Object) cgmDevice.sensorIndex) && Intrinsics.areEqual((Object) this.registerTime, (Object) cgmDevice.registerTime) && Intrinsics.areEqual((Object) this.startUpTimeZone, (Object) cgmDevice.startUpTimeZone) && Intrinsics.areEqual((Object) this.deviceKey, (Object) cgmDevice.deviceKey) && Intrinsics.areEqual((Object) this.sensorStartUp, (Object) cgmDevice.sensorStartUp) && Intrinsics.areEqual((Object) this.dstOffset, (Object) cgmDevice.dstOffset) && Intrinsics.areEqual((Object) this.deviceId, (Object) cgmDevice.deviceId) && Intrinsics.areEqual((Object) this.userId, (Object) cgmDevice.userId) && Intrinsics.areEqual((Object) this.deviceSn, (Object) cgmDevice.deviceSn) && Intrinsics.areEqual((Object) this.sensorId, (Object) cgmDevice.sensorId) && Intrinsics.areEqual((Object) this.et, (Object) cgmDevice.et) && Intrinsics.areEqual((Object) this.isForceReplace, (Object) cgmDevice.isForceReplace) && Intrinsics.areEqual((Object) this.unregisterTime, (Object) cgmDevice.unregisterTime) && Intrinsics.areEqual((Object) this.deviceMac, (Object) cgmDevice.deviceMac) && Intrinsics.areEqual((Object) this.deviceModel, (Object) cgmDevice.deviceModel);
    }

    public int hashCode() {
        Integer num = this.sensorIndex;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.registerTime;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.startUpTimeZone;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceKey;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sensorStartUp;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.dstOffset;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.deviceId;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.userId;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.deviceSn;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.sensorId;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num2 = this.et;
        int hashCode11 = (hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.isForceReplace;
        int hashCode12 = (hashCode11 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str10 = this.unregisterTime;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.deviceMac;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.deviceModel;
        if (str12 != null) {
            i = str12.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CgmDevice(sensorIndex=");
        sb.append(this.sensorIndex).append(", registerTime=").append(this.registerTime).append(", startUpTimeZone=").append(this.startUpTimeZone).append(", deviceKey=").append(this.deviceKey).append(", sensorStartUp=").append(this.sensorStartUp).append(", dstOffset=").append(this.dstOffset).append(", deviceId=").append(this.deviceId).append(", userId=").append(this.userId).append(", deviceSn=").append(this.deviceSn).append(", sensorId=").append(this.sensorId).append(", et=").append(this.et).append(", isForceReplace=");
        sb.append(this.isForceReplace).append(", unregisterTime=").append(this.unregisterTime).append(", deviceMac=").append(this.deviceMac).append(", deviceModel=").append(this.deviceModel).append(')');
        return sb.toString();
    }

    public CgmDevice(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num2, Boolean bool, String str10, String str11, String str12) {
        this.sensorIndex = num;
        this.registerTime = str;
        this.startUpTimeZone = str2;
        this.deviceKey = str3;
        this.sensorStartUp = str4;
        this.dstOffset = str5;
        this.deviceId = str6;
        this.userId = str7;
        this.deviceSn = str8;
        this.sensorId = str9;
        this.et = num2;
        this.isForceReplace = bool;
        this.unregisterTime = str10;
        this.deviceMac = str11;
        this.deviceModel = str12;
    }

    public final Integer getSensorIndex() {
        return this.sensorIndex;
    }

    public final String getRegisterTime() {
        return this.registerTime;
    }

    public final String getStartUpTimeZone() {
        return this.startUpTimeZone;
    }

    public final String getDeviceKey() {
        return this.deviceKey;
    }

    public final String getSensorStartUp() {
        return this.sensorStartUp;
    }

    public final String getDstOffset() {
        return this.dstOffset;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getDeviceSn() {
        return this.deviceSn;
    }

    public final String getSensorId() {
        return this.sensorId;
    }

    public final Integer getEt() {
        return this.et;
    }

    public final Boolean isForceReplace() {
        return this.isForceReplace;
    }

    public final String getUnregisterTime() {
        return this.unregisterTime;
    }

    public final String getDeviceMac() {
        return this.deviceMac;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final Integer getSensorLeftTime() {
        Integer num = this.et;
        int intValue = num != null ? num.intValue() : 15;
        Long sensorStartUpTimestamp = getSensorStartUpTimestamp();
        if (sensorStartUpTimestamp == null) {
            return null;
        }
        return Integer.valueOf(ExtendsKt.millisToHours((((long) intValue) * TimeUtils.oneDayMillis) - (System.currentTimeMillis() - sensorStartUpTimestamp.longValue()), RoundingMode.CEILING));
    }

    public final Boolean isWarmingUp() {
        Long sensorStartUpTimestamp = getSensorStartUpTimestamp();
        if (sensorStartUpTimestamp == null) {
            return null;
        }
        return Boolean.valueOf(System.currentTimeMillis() - sensorStartUpTimestamp.longValue() < 3600000);
    }

    private final Long getSensorStartUpTimestamp() {
        Object obj;
        String str = this.sensorStartUp;
        Long l = null;
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            Date parse = new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMSZ, Locale.ENGLISH).parse(str);
            obj = Result.m343constructorimpl(parse != null ? Long.valueOf(parse.getTime()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m343constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m349isFailureimpl(obj)) {
            l = obj;
        }
        Long l2 = l;
        return Long.valueOf(l2 != null ? l2.longValue() : 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CgmDevice(android.os.Parcel r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r0.readValue(r1)
            boolean r2 = r1 instanceof java.lang.Integer
            r3 = 0
            if (r2 == 0) goto L_0x001a
            java.lang.Integer r1 = (java.lang.Integer) r1
            r5 = r1
            goto L_0x001b
        L_0x001a:
            r5 = r3
        L_0x001b:
            java.lang.String r6 = r21.readString()
            java.lang.String r7 = r21.readString()
            java.lang.String r8 = r21.readString()
            java.lang.String r9 = r21.readString()
            java.lang.String r10 = r21.readString()
            java.lang.String r11 = r21.readString()
            java.lang.String r12 = r21.readString()
            java.lang.String r13 = r21.readString()
            java.lang.String r14 = r21.readString()
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r0.readValue(r1)
            boolean r2 = r1 instanceof java.lang.Integer
            if (r2 == 0) goto L_0x0051
            java.lang.Integer r1 = (java.lang.Integer) r1
            r15 = r1
            goto L_0x0052
        L_0x0051:
            r15 = r3
        L_0x0052:
            java.lang.Class r1 = java.lang.Boolean.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r0.readValue(r1)
            boolean r2 = r1 instanceof java.lang.Boolean
            if (r2 == 0) goto L_0x0063
            r3 = r1
            java.lang.Boolean r3 = (java.lang.Boolean) r3
        L_0x0063:
            r16 = r3
            java.lang.String r17 = r21.readString()
            java.lang.String r18 = r21.readString()
            java.lang.String r19 = r21.readString()
            r4 = r20
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.CgmDevice.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeValue(this.sensorIndex);
        parcel.writeString(this.registerTime);
        parcel.writeString(this.startUpTimeZone);
        parcel.writeString(this.deviceKey);
        parcel.writeString(this.sensorStartUp);
        parcel.writeString(this.dstOffset);
        parcel.writeString(this.deviceId);
        parcel.writeString(this.userId);
        parcel.writeString(this.deviceSn);
        parcel.writeString(this.sensorId);
        parcel.writeValue(this.et);
        parcel.writeValue(this.isForceReplace);
        parcel.writeString(this.unregisterTime);
        parcel.writeString(this.deviceMac);
        parcel.writeString(this.deviceModel);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/CgmDevice$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/ui/setting/share/CgmDevice;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/ui/setting/share/CgmDevice;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ShareUserInfo.kt */
    public static final class CREATOR implements Parcelable.Creator<CgmDevice> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public CgmDevice createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CgmDevice(parcel);
        }

        public CgmDevice[] newArray(int i) {
            return new CgmDevice[i];
        }
    }
}
