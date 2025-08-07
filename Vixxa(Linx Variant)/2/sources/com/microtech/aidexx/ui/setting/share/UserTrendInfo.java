package com.microtech.aidexx.ui.setting.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bs\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\bH\u0016J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\b\u00106\u001a\u0004\u0018\u000107J\t\u00108\u001a\u00020\bHÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001J\u0018\u0010:\u001a\u00020;2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\bH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\"\u0010\u001bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u0006>"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appTime", "", "trend", "", "trendValue", "trendId", "dstOffset", "userId", "appTimeZone", "bloodGlucose", "", "status", "historyStatus", "calTemp", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppTime", "()Ljava/lang/String;", "getAppTimeZone", "getBloodGlucose", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getCalTemp", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDstOffset", "getHistoryStatus", "getStatus", "getTrend", "getTrendId", "getTrendValue", "getUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;", "describeContents", "equals", "", "other", "", "getGlucoseTrend", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseTrend;", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareUserInfo.kt */
public final class UserTrendInfo implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final String appTime;
    private final String appTimeZone;
    private final Float bloodGlucose;
    private final Integer calTemp;
    private final String dstOffset;
    private final Integer historyStatus;
    private final Integer status;
    private final Integer trend;
    private final String trendId;
    private final Integer trendValue;
    private final String userId;

    public static /* synthetic */ UserTrendInfo copy$default(UserTrendInfo userTrendInfo, String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, Float f, Integer num3, Integer num4, Integer num5, int i, Object obj) {
        UserTrendInfo userTrendInfo2 = userTrendInfo;
        int i2 = i;
        return userTrendInfo.copy((i2 & 1) != 0 ? userTrendInfo2.appTime : str, (i2 & 2) != 0 ? userTrendInfo2.trend : num, (i2 & 4) != 0 ? userTrendInfo2.trendValue : num2, (i2 & 8) != 0 ? userTrendInfo2.trendId : str2, (i2 & 16) != 0 ? userTrendInfo2.dstOffset : str3, (i2 & 32) != 0 ? userTrendInfo2.userId : str4, (i2 & 64) != 0 ? userTrendInfo2.appTimeZone : str5, (i2 & 128) != 0 ? userTrendInfo2.bloodGlucose : f, (i2 & 256) != 0 ? userTrendInfo2.status : num3, (i2 & 512) != 0 ? userTrendInfo2.historyStatus : num4, (i2 & 1024) != 0 ? userTrendInfo2.calTemp : num5);
    }

    public final String component1() {
        return this.appTime;
    }

    public final Integer component10() {
        return this.historyStatus;
    }

    public final Integer component11() {
        return this.calTemp;
    }

    public final Integer component2() {
        return this.trend;
    }

    public final Integer component3() {
        return this.trendValue;
    }

    public final String component4() {
        return this.trendId;
    }

    public final String component5() {
        return this.dstOffset;
    }

    public final String component6() {
        return this.userId;
    }

    public final String component7() {
        return this.appTimeZone;
    }

    public final Float component8() {
        return this.bloodGlucose;
    }

    public final Integer component9() {
        return this.status;
    }

    public final UserTrendInfo copy(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, Float f, Integer num3, Integer num4, Integer num5) {
        return new UserTrendInfo(str, num, num2, str2, str3, str4, str5, f, num3, num4, num5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserTrendInfo)) {
            return false;
        }
        UserTrendInfo userTrendInfo = (UserTrendInfo) obj;
        return Intrinsics.areEqual((Object) this.appTime, (Object) userTrendInfo.appTime) && Intrinsics.areEqual((Object) this.trend, (Object) userTrendInfo.trend) && Intrinsics.areEqual((Object) this.trendValue, (Object) userTrendInfo.trendValue) && Intrinsics.areEqual((Object) this.trendId, (Object) userTrendInfo.trendId) && Intrinsics.areEqual((Object) this.dstOffset, (Object) userTrendInfo.dstOffset) && Intrinsics.areEqual((Object) this.userId, (Object) userTrendInfo.userId) && Intrinsics.areEqual((Object) this.appTimeZone, (Object) userTrendInfo.appTimeZone) && Intrinsics.areEqual((Object) this.bloodGlucose, (Object) userTrendInfo.bloodGlucose) && Intrinsics.areEqual((Object) this.status, (Object) userTrendInfo.status) && Intrinsics.areEqual((Object) this.historyStatus, (Object) userTrendInfo.historyStatus) && Intrinsics.areEqual((Object) this.calTemp, (Object) userTrendInfo.calTemp);
    }

    public int hashCode() {
        String str = this.appTime;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.trend;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.trendValue;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.trendId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dstOffset;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.userId;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appTimeZone;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Float f = this.bloodGlucose;
        int hashCode8 = (hashCode7 + (f == null ? 0 : f.hashCode())) * 31;
        Integer num3 = this.status;
        int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.historyStatus;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.calTemp;
        if (num5 != null) {
            i = num5.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserTrendInfo(appTime=");
        sb.append(this.appTime).append(", trend=").append(this.trend).append(", trendValue=").append(this.trendValue).append(", trendId=").append(this.trendId).append(", dstOffset=").append(this.dstOffset).append(", userId=").append(this.userId).append(", appTimeZone=").append(this.appTimeZone).append(", bloodGlucose=").append(this.bloodGlucose).append(", status=").append(this.status).append(", historyStatus=").append(this.historyStatus).append(", calTemp=").append(this.calTemp).append(')');
        return sb.toString();
    }

    public UserTrendInfo(String str, Integer num, Integer num2, String str2, String str3, String str4, String str5, Float f, Integer num3, Integer num4, Integer num5) {
        this.appTime = str;
        this.trend = num;
        this.trendValue = num2;
        this.trendId = str2;
        this.dstOffset = str3;
        this.userId = str4;
        this.appTimeZone = str5;
        this.bloodGlucose = f;
        this.status = num3;
        this.historyStatus = num4;
        this.calTemp = num5;
    }

    public final String getAppTime() {
        return this.appTime;
    }

    public final Integer getTrend() {
        return this.trend;
    }

    public final Integer getTrendValue() {
        return this.trendValue;
    }

    public final String getTrendId() {
        return this.trendId;
    }

    public final String getDstOffset() {
        return this.dstOffset;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getAppTimeZone() {
        return this.appTimeZone;
    }

    public final Float getBloodGlucose() {
        return this.bloodGlucose;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getHistoryStatus() {
        return this.historyStatus;
    }

    public final Integer getCalTemp() {
        return this.calTemp;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UserTrendInfo(android.os.Parcel r14) {
        /*
            r13 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r2 = r14.readString()
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r14.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            r3 = 0
            if (r1 == 0) goto L_0x001b
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x001c
        L_0x001b:
            r0 = r3
        L_0x001c:
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r14.readValue(r1)
            boolean r4 = r1 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x002e
            java.lang.Integer r1 = (java.lang.Integer) r1
            r4 = r1
            goto L_0x002f
        L_0x002e:
            r4 = r3
        L_0x002f:
            java.lang.String r5 = r14.readString()
            java.lang.String r6 = r14.readString()
            java.lang.String r7 = r14.readString()
            java.lang.String r8 = r14.readString()
            java.lang.Class r1 = java.lang.Float.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r14.readValue(r1)
            boolean r9 = r1 instanceof java.lang.Float
            if (r9 == 0) goto L_0x0051
            java.lang.Float r1 = (java.lang.Float) r1
            r9 = r1
            goto L_0x0052
        L_0x0051:
            r9 = r3
        L_0x0052:
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r14.readValue(r1)
            boolean r10 = r1 instanceof java.lang.Integer
            if (r10 == 0) goto L_0x0064
            java.lang.Integer r1 = (java.lang.Integer) r1
            r10 = r1
            goto L_0x0065
        L_0x0064:
            r10 = r3
        L_0x0065:
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r14.readValue(r1)
            boolean r11 = r1 instanceof java.lang.Integer
            if (r11 == 0) goto L_0x0077
            java.lang.Integer r1 = (java.lang.Integer) r1
            r11 = r1
            goto L_0x0078
        L_0x0077:
            r11 = r3
        L_0x0078:
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r14 = r14.readValue(r1)
            boolean r1 = r14 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x008a
            java.lang.Integer r14 = (java.lang.Integer) r14
            r12 = r14
            goto L_0x008b
        L_0x008a:
            r12 = r3
        L_0x008b:
            r1 = r13
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.UserTrendInfo.<init>(android.os.Parcel):void");
    }

    public final DeviceModel.GlucoseTrend getGlucoseTrend() {
        Integer num = this.trend;
        if (num != null && num.intValue() == -3) {
            return DeviceModel.GlucoseTrend.FAST_FALL;
        }
        if (num != null && num.intValue() == -2) {
            return DeviceModel.GlucoseTrend.FALL;
        }
        if (num != null && num.intValue() == -1) {
            return DeviceModel.GlucoseTrend.SLOW_FALL;
        }
        if (num != null && num.intValue() == 0) {
            return DeviceModel.GlucoseTrend.STEADY;
        }
        if (num != null && num.intValue() == 1) {
            return DeviceModel.GlucoseTrend.SLOW_UP;
        }
        if (num != null && num.intValue() == 2) {
            return DeviceModel.GlucoseTrend.UP;
        }
        if (num != null && num.intValue() == 3) {
            return DeviceModel.GlucoseTrend.FAST_UP;
        }
        if (num != null && num.intValue() == -99) {
            return DeviceModel.GlucoseTrend.UNKNOWN;
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.appTime);
        parcel.writeValue(this.trend);
        parcel.writeValue(this.trendValue);
        parcel.writeString(this.trendId);
        parcel.writeString(this.dstOffset);
        parcel.writeString(this.userId);
        parcel.writeString(this.appTimeZone);
        parcel.writeValue(this.bloodGlucose);
        parcel.writeValue(this.status);
        parcel.writeValue(this.historyStatus);
        parcel.writeValue(this.calTemp);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ShareUserInfo.kt */
    public static final class CREATOR implements Parcelable.Creator<UserTrendInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public UserTrendInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserTrendInfo(parcel);
        }

        public UserTrendInfo[] newArray(int i) {
            return new UserTrendInfo[i];
        }
    }
}
