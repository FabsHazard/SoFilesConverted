package com.microtech.aidexx.ui.setting.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.utils.TimeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 y2\u00020\u0001:\u0001yB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B¹\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u000b\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010]\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010^\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003JÂ\u0001\u0010`\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010aJ\b\u0010b\u001a\u00020\rH\u0016J\u0013\u0010c\u001a\u00020+2\b\u0010d\u001a\u0004\u0018\u00010eHÖ\u0003J\u0006\u0010f\u001a\u00020\u0006J\u0006\u0010g\u001a\u00020\u0006J\u0010\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\rH\u0002J\b\u0010j\u001a\u0004\u0018\u00010kJ\b\u0010l\u001a\u0004\u0018\u00010\u0006J\u000f\u0010m\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u001cJ\u0006\u0010n\u001a\u00020\u0006J\u0006\u0010o\u001a\u00020\u0006J\u0006\u0010p\u001a\u00020\u0006J\b\u0010q\u001a\u0004\u0018\u00010\u0006J\t\u0010r\u001a\u00020\rHÖ\u0001J\u0017\u0010s\u001a\u00020+2\b\u0010i\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010tJ\t\u0010u\u001a\u00020\u0006HÖ\u0001J\u0018\u0010v\u001a\u00020w2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010x\u001a\u00020\rH\u0016R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u0010\u001eR\u0011\u00100\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b1\u0010-R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010-\"\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b<\u0010-R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010%\"\u0004\b@\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010%\"\u0004\bD\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010%\"\u0004\bH\u0010'R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006z"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "providerAlias", "", "userTrend", "Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;", "readerAlias", "dataReaderId", "providerUserName", "hideState", "", "emergePushState", "autoIncrementColumn", "readerUserName", "normalPushState", "dataProviderId", "userAuthorizationId", "information", "Lcom/microtech/aidexx/db/entity/UserEntity;", "cgmDevice", "Lcom/microtech/aidexx/ui/setting/share/CgmDevice;", "userSetting", "Lcom/microtech/aidexx/db/entity/SettingsEntity;", "(Ljava/lang/String;Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/microtech/aidexx/db/entity/UserEntity;Lcom/microtech/aidexx/ui/setting/share/CgmDevice;Lcom/microtech/aidexx/db/entity/SettingsEntity;)V", "getAutoIncrementColumn", "()Ljava/lang/Integer;", "setAutoIncrementColumn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCgmDevice", "()Lcom/microtech/aidexx/ui/setting/share/CgmDevice;", "setCgmDevice", "(Lcom/microtech/aidexx/ui/setting/share/CgmDevice;)V", "getDataProviderId", "()Ljava/lang/String;", "setDataProviderId", "(Ljava/lang/String;)V", "getDataReaderId", "setDataReaderId", "emergePush", "", "getEmergePush", "()Z", "getEmergePushState", "setEmergePushState", "hide", "getHide", "getHideState", "setHideState", "getInformation", "()Lcom/microtech/aidexx/db/entity/UserEntity;", "setInformation", "(Lcom/microtech/aidexx/db/entity/UserEntity;)V", "isLooking", "setLooking", "(Z)V", "normalPush", "getNormalPush", "getNormalPushState", "setNormalPushState", "getProviderAlias", "setProviderAlias", "getProviderUserName", "setProviderUserName", "getReaderAlias", "setReaderAlias", "getReaderUserName", "setReaderUserName", "getUserAuthorizationId", "setUserAuthorizationId", "getUserSetting", "()Lcom/microtech/aidexx/db/entity/SettingsEntity;", "setUserSetting", "(Lcom/microtech/aidexx/db/entity/SettingsEntity;)V", "getUserTrend", "()Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;", "setUserTrend", "(Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/microtech/aidexx/ui/setting/share/UserTrendInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/microtech/aidexx/db/entity/UserEntity;Lcom/microtech/aidexx/ui/setting/share/CgmDevice;Lcom/microtech/aidexx/db/entity/SettingsEntity;)Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "describeContents", "equals", "other", "", "getAlias", "getDisplayName", "getFriendlyTimeSpanByNow", "minutesAgo", "getGlucoseLevel", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "getGlucoseValue", "getLastHistoryTimeAgo", "getLatestValueTimeStr", "getMaskedAccount", "getSensorLeftTime", "getSensorStatusDesc", "hashCode", "latestHistoryIsExpired", "(Ljava/lang/Integer;)Z", "toString", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareUserInfo.kt */
public final class ShareUserInfo implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private Integer autoIncrementColumn;
    private CgmDevice cgmDevice;
    private String dataProviderId;
    private String dataReaderId;
    private Integer emergePushState;
    private Integer hideState;
    private UserEntity information;
    private boolean isLooking;
    private Integer normalPushState;
    private String providerAlias;
    private String providerUserName;
    private String readerAlias;
    private String readerUserName;
    private String userAuthorizationId;
    private SettingsEntity userSetting;
    private UserTrendInfo userTrend;

    public ShareUserInfo() {
        this((String) null, (UserTrendInfo) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (UserEntity) null, (CgmDevice) null, (SettingsEntity) null, 32767, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShareUserInfo copy$default(ShareUserInfo shareUserInfo, String str, UserTrendInfo userTrendInfo, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, String str5, Integer num4, String str6, String str7, UserEntity userEntity, CgmDevice cgmDevice2, SettingsEntity settingsEntity, int i, Object obj) {
        ShareUserInfo shareUserInfo2 = shareUserInfo;
        int i2 = i;
        return shareUserInfo.copy((i2 & 1) != 0 ? shareUserInfo2.providerAlias : str, (i2 & 2) != 0 ? shareUserInfo2.userTrend : userTrendInfo, (i2 & 4) != 0 ? shareUserInfo2.readerAlias : str2, (i2 & 8) != 0 ? shareUserInfo2.dataReaderId : str3, (i2 & 16) != 0 ? shareUserInfo2.providerUserName : str4, (i2 & 32) != 0 ? shareUserInfo2.hideState : num, (i2 & 64) != 0 ? shareUserInfo2.emergePushState : num2, (i2 & 128) != 0 ? shareUserInfo2.autoIncrementColumn : num3, (i2 & 256) != 0 ? shareUserInfo2.readerUserName : str5, (i2 & 512) != 0 ? shareUserInfo2.normalPushState : num4, (i2 & 1024) != 0 ? shareUserInfo2.dataProviderId : str6, (i2 & 2048) != 0 ? shareUserInfo2.userAuthorizationId : str7, (i2 & 4096) != 0 ? shareUserInfo2.information : userEntity, (i2 & 8192) != 0 ? shareUserInfo2.cgmDevice : cgmDevice2, (i2 & 16384) != 0 ? shareUserInfo2.userSetting : settingsEntity);
    }

    public final String component1() {
        return this.providerAlias;
    }

    public final Integer component10() {
        return this.normalPushState;
    }

    public final String component11() {
        return this.dataProviderId;
    }

    public final String component12() {
        return this.userAuthorizationId;
    }

    public final UserEntity component13() {
        return this.information;
    }

    public final CgmDevice component14() {
        return this.cgmDevice;
    }

    public final SettingsEntity component15() {
        return this.userSetting;
    }

    public final UserTrendInfo component2() {
        return this.userTrend;
    }

    public final String component3() {
        return this.readerAlias;
    }

    public final String component4() {
        return this.dataReaderId;
    }

    public final String component5() {
        return this.providerUserName;
    }

    public final Integer component6() {
        return this.hideState;
    }

    public final Integer component7() {
        return this.emergePushState;
    }

    public final Integer component8() {
        return this.autoIncrementColumn;
    }

    public final String component9() {
        return this.readerUserName;
    }

    public final ShareUserInfo copy(String str, UserTrendInfo userTrendInfo, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, String str5, Integer num4, String str6, String str7, UserEntity userEntity, CgmDevice cgmDevice2, SettingsEntity settingsEntity) {
        return new ShareUserInfo(str, userTrendInfo, str2, str3, str4, num, num2, num3, str5, num4, str6, str7, userEntity, cgmDevice2, settingsEntity);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShareUserInfo)) {
            return false;
        }
        ShareUserInfo shareUserInfo = (ShareUserInfo) obj;
        return Intrinsics.areEqual((Object) this.providerAlias, (Object) shareUserInfo.providerAlias) && Intrinsics.areEqual((Object) this.userTrend, (Object) shareUserInfo.userTrend) && Intrinsics.areEqual((Object) this.readerAlias, (Object) shareUserInfo.readerAlias) && Intrinsics.areEqual((Object) this.dataReaderId, (Object) shareUserInfo.dataReaderId) && Intrinsics.areEqual((Object) this.providerUserName, (Object) shareUserInfo.providerUserName) && Intrinsics.areEqual((Object) this.hideState, (Object) shareUserInfo.hideState) && Intrinsics.areEqual((Object) this.emergePushState, (Object) shareUserInfo.emergePushState) && Intrinsics.areEqual((Object) this.autoIncrementColumn, (Object) shareUserInfo.autoIncrementColumn) && Intrinsics.areEqual((Object) this.readerUserName, (Object) shareUserInfo.readerUserName) && Intrinsics.areEqual((Object) this.normalPushState, (Object) shareUserInfo.normalPushState) && Intrinsics.areEqual((Object) this.dataProviderId, (Object) shareUserInfo.dataProviderId) && Intrinsics.areEqual((Object) this.userAuthorizationId, (Object) shareUserInfo.userAuthorizationId) && Intrinsics.areEqual((Object) this.information, (Object) shareUserInfo.information) && Intrinsics.areEqual((Object) this.cgmDevice, (Object) shareUserInfo.cgmDevice) && Intrinsics.areEqual((Object) this.userSetting, (Object) shareUserInfo.userSetting);
    }

    public int hashCode() {
        String str = this.providerAlias;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        UserTrendInfo userTrendInfo = this.userTrend;
        int hashCode2 = (hashCode + (userTrendInfo == null ? 0 : userTrendInfo.hashCode())) * 31;
        String str2 = this.readerAlias;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dataReaderId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.providerUserName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.hideState;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.emergePushState;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.autoIncrementColumn;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str5 = this.readerUserName;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num4 = this.normalPushState;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str6 = this.dataProviderId;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.userAuthorizationId;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        UserEntity userEntity = this.information;
        int hashCode13 = (hashCode12 + (userEntity == null ? 0 : userEntity.hashCode())) * 31;
        CgmDevice cgmDevice2 = this.cgmDevice;
        int hashCode14 = (hashCode13 + (cgmDevice2 == null ? 0 : cgmDevice2.hashCode())) * 31;
        SettingsEntity settingsEntity = this.userSetting;
        if (settingsEntity != null) {
            i = settingsEntity.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ShareUserInfo(providerAlias=");
        sb.append(this.providerAlias).append(", userTrend=").append(this.userTrend).append(", readerAlias=").append(this.readerAlias).append(", dataReaderId=").append(this.dataReaderId).append(", providerUserName=").append(this.providerUserName).append(", hideState=").append(this.hideState).append(", emergePushState=").append(this.emergePushState).append(", autoIncrementColumn=").append(this.autoIncrementColumn).append(", readerUserName=").append(this.readerUserName).append(", normalPushState=").append(this.normalPushState).append(", dataProviderId=").append(this.dataProviderId).append(", userAuthorizationId=");
        sb.append(this.userAuthorizationId).append(", information=").append(this.information).append(", cgmDevice=").append(this.cgmDevice).append(", userSetting=").append(this.userSetting).append(')');
        return sb.toString();
    }

    public ShareUserInfo(String str, UserTrendInfo userTrendInfo, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, String str5, Integer num4, String str6, String str7, UserEntity userEntity, CgmDevice cgmDevice2, SettingsEntity settingsEntity) {
        this.providerAlias = str;
        this.userTrend = userTrendInfo;
        this.readerAlias = str2;
        this.dataReaderId = str3;
        this.providerUserName = str4;
        this.hideState = num;
        this.emergePushState = num2;
        this.autoIncrementColumn = num3;
        this.readerUserName = str5;
        this.normalPushState = num4;
        this.dataProviderId = str6;
        this.userAuthorizationId = str7;
        this.information = userEntity;
        this.cgmDevice = cgmDevice2;
        this.userSetting = settingsEntity;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShareUserInfo(java.lang.String r17, com.microtech.aidexx.ui.setting.share.UserTrendInfo r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Integer r22, java.lang.Integer r23, java.lang.Integer r24, java.lang.String r25, java.lang.Integer r26, java.lang.String r27, java.lang.String r28, com.microtech.aidexx.db.entity.UserEntity r29, com.microtech.aidexx.ui.setting.share.CgmDevice r30, com.microtech.aidexx.db.entity.SettingsEntity r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r28
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r29
        L_0x006b:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0071
            r15 = r2
            goto L_0x0073
        L_0x0071:
            r15 = r30
        L_0x0073:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r2 = r31
        L_0x007a:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareUserInfo.<init>(java.lang.String, com.microtech.aidexx.ui.setting.share.UserTrendInfo, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, com.microtech.aidexx.db.entity.UserEntity, com.microtech.aidexx.ui.setting.share.CgmDevice, com.microtech.aidexx.db.entity.SettingsEntity, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getProviderAlias() {
        return this.providerAlias;
    }

    public final void setProviderAlias(String str) {
        this.providerAlias = str;
    }

    public final UserTrendInfo getUserTrend() {
        return this.userTrend;
    }

    public final void setUserTrend(UserTrendInfo userTrendInfo) {
        this.userTrend = userTrendInfo;
    }

    public final String getReaderAlias() {
        return this.readerAlias;
    }

    public final void setReaderAlias(String str) {
        this.readerAlias = str;
    }

    public final String getDataReaderId() {
        return this.dataReaderId;
    }

    public final void setDataReaderId(String str) {
        this.dataReaderId = str;
    }

    public final String getProviderUserName() {
        return this.providerUserName;
    }

    public final void setProviderUserName(String str) {
        this.providerUserName = str;
    }

    public final Integer getHideState() {
        return this.hideState;
    }

    public final void setHideState(Integer num) {
        this.hideState = num;
    }

    public final Integer getEmergePushState() {
        return this.emergePushState;
    }

    public final void setEmergePushState(Integer num) {
        this.emergePushState = num;
    }

    public final Integer getAutoIncrementColumn() {
        return this.autoIncrementColumn;
    }

    public final void setAutoIncrementColumn(Integer num) {
        this.autoIncrementColumn = num;
    }

    public final String getReaderUserName() {
        return this.readerUserName;
    }

    public final void setReaderUserName(String str) {
        this.readerUserName = str;
    }

    public final Integer getNormalPushState() {
        return this.normalPushState;
    }

    public final void setNormalPushState(Integer num) {
        this.normalPushState = num;
    }

    public final String getDataProviderId() {
        return this.dataProviderId;
    }

    public final void setDataProviderId(String str) {
        this.dataProviderId = str;
    }

    public final String getUserAuthorizationId() {
        return this.userAuthorizationId;
    }

    public final void setUserAuthorizationId(String str) {
        this.userAuthorizationId = str;
    }

    public final UserEntity getInformation() {
        return this.information;
    }

    public final void setInformation(UserEntity userEntity) {
        this.information = userEntity;
    }

    public final CgmDevice getCgmDevice() {
        return this.cgmDevice;
    }

    public final void setCgmDevice(CgmDevice cgmDevice2) {
        this.cgmDevice = cgmDevice2;
    }

    public final SettingsEntity getUserSetting() {
        return this.userSetting;
    }

    public final void setUserSetting(SettingsEntity settingsEntity) {
        this.userSetting = settingsEntity;
    }

    public final boolean isLooking() {
        return this.isLooking;
    }

    public final void setLooking(boolean z) {
        this.isLooking = z;
    }

    public final boolean getHide() {
        Integer num = this.hideState;
        return num != null && num.intValue() == 1;
    }

    public final boolean getEmergePush() {
        Integer num = this.emergePushState;
        return num != null && num.intValue() == 1;
    }

    public final boolean getNormalPush() {
        Integer num = this.normalPushState;
        return num != null && num.intValue() == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r1 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r1 == null) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getDisplayName() {
        /*
            r4 = this;
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
            java.lang.String r0 = r0.userId()
            java.lang.String r1 = r4.dataReaderId
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0032
            java.lang.String r0 = r4.providerAlias
            if (r0 == 0) goto L_0x0027
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r3 = r0.length()
            if (r3 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r0
        L_0x0023:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0045
        L_0x0027:
            com.microtech.aidexx.utils.StringUtils r0 = com.microtech.aidexx.utils.StringUtils.INSTANCE
            java.lang.String r1 = r4.providerUserName
            java.lang.String r0 = r0.getMaskedPhone(r1)
            if (r0 != 0) goto L_0x0052
            goto L_0x0053
        L_0x0032:
            java.lang.String r0 = r4.readerAlias
            if (r0 == 0) goto L_0x0047
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r3 = r0.length()
            if (r3 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r1 = r0
        L_0x0040:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r2 = r1
            goto L_0x0053
        L_0x0047:
            com.microtech.aidexx.utils.StringUtils r0 = com.microtech.aidexx.utils.StringUtils.INSTANCE
            java.lang.String r1 = r4.readerUserName
            java.lang.String r0 = r0.getMaskedPhone(r1)
            if (r0 != 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r2 = r0
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareUserInfo.getDisplayName():java.lang.String");
    }

    public final String getMaskedAccount() {
        String str;
        if (Intrinsics.areEqual((Object) UserInfoManager.Companion.instance().userId(), (Object) this.dataReaderId)) {
            str = StringUtils.INSTANCE.getMaskedPhone(this.providerUserName);
            if (str == null) {
                return "";
            }
        } else {
            str = StringUtils.INSTANCE.getMaskedPhone(this.readerUserName);
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public final String getAlias() {
        String str;
        if (Intrinsics.areEqual((Object) UserInfoManager.Companion.instance().userId(), (Object) this.dataReaderId)) {
            str = this.providerAlias;
        } else {
            str = this.readerAlias;
        }
        return str == null ? "" : str;
    }

    public final String getGlucoseValue() {
        Float bloodGlucose;
        UserTrendInfo userTrendInfo = this.userTrend;
        if (userTrendInfo == null || (bloodGlucose = userTrendInfo.getBloodGlucose()) == null) {
            return null;
        }
        return GlucoseUtilKt.toGlucoseStringWithLowAndHigh(bloodGlucose.floatValue(), ExtendsKt.getContext().getResources());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.isWarmingUp();
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getSensorStatusDesc() {
        /*
            r11 = this;
            com.microtech.aidexx.ui.setting.share.CgmDevice r0 = r11.cgmDevice
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.Boolean r0 = r0.isWarmingUp()
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.booleanValue()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x001e
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r1 = com.microtech.aidexx.R.string.ble_state_sensor_warming
            java.lang.String r0 = r0.getString(r1)
            return r0
        L_0x001e:
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r0 = r11.userTrend
            r2 = 1
            if (r0 == 0) goto L_0x0033
            java.lang.Integer r0 = r0.getHistoryStatus()
            if (r0 != 0) goto L_0x002a
            goto L_0x0033
        L_0x002a:
            int r0 = r0.intValue()
            r3 = 2
            if (r0 != r3) goto L_0x0033
            r0 = r2
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r3 = r11.userTrend
            if (r3 == 0) goto L_0x0047
            java.lang.Integer r3 = r3.getHistoryStatus()
            if (r3 != 0) goto L_0x003f
            goto L_0x0047
        L_0x003f:
            int r3 = r3.intValue()
            if (r3 != r2) goto L_0x0047
            r3 = r2
            goto L_0x0048
        L_0x0047:
            r3 = r1
        L_0x0048:
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r4 = r11.userTrend
            if (r4 == 0) goto L_0x0094
            java.lang.Integer r5 = r4.getStatus()
            if (r5 == 0) goto L_0x0094
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.Integer r4 = r4.getCalTemp()
            if (r4 == 0) goto L_0x0094
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r6 = 6
            int[] r7 = new int[r6]
            int[] r8 = new int[r6]
            r9 = r1
        L_0x006a:
            if (r9 >= r6) goto L_0x0079
            int r10 = r5 >> r9
            r10 = r10 & r2
            r7[r9] = r10
            int r10 = r4 >> r9
            r10 = r10 & r2
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x006a
        L_0x0079:
            r4 = r7[r1]
            if (r4 != r2) goto L_0x0083
            r4 = r8[r1]
            if (r4 != 0) goto L_0x0083
            r4 = r2
            goto L_0x0084
        L_0x0083:
            r4 = r1
        L_0x0084:
            r5 = 5
            r5 = r7[r5]
            if (r5 != r2) goto L_0x008b
            r5 = r2
            goto L_0x008c
        L_0x008b:
            r5 = r1
        L_0x008c:
            r6 = r7[r2]
            if (r6 != r2) goto L_0x0091
            r1 = r2
        L_0x0091:
            r2 = r1
            r1 = r4
            goto L_0x0096
        L_0x0094:
            r2 = r1
            r5 = r2
        L_0x0096:
            if (r1 == 0) goto L_0x00a3
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r1 = com.microtech.aidexx.R.string.ble_state_sensor_expired
            java.lang.String r0 = r0.getString(r1)
            return r0
        L_0x00a3:
            if (r5 == 0) goto L_0x00b0
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r1 = com.microtech.aidexx.R.string.ble_state_sensor_error_critical
            java.lang.String r0 = r0.getString(r1)
            return r0
        L_0x00b0:
            if (r0 == 0) goto L_0x00bd
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r1 = com.microtech.aidexx.R.string.ble_state_sensor_error
            java.lang.String r0 = r0.getString(r1)
            return r0
        L_0x00bd:
            if (r3 == 0) goto L_0x00ca
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r1 = com.microtech.aidexx.R.string.ble_state_sensor_invalid
            java.lang.String r0 = r0.getString(r1)
            return r0
        L_0x00ca:
            if (r2 == 0) goto L_0x00d7
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r1 = com.microtech.aidexx.R.string.ble_state_sensor_batteryLow
            java.lang.String r0 = r0.getString(r1)
            return r0
        L_0x00d7:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareUserInfo.getSensorStatusDesc():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00a2, code lost:
        if (r0 == null) goto L_0x00a4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getSensorLeftTime() {
        /*
            r6 = this;
            com.microtech.aidexx.ui.setting.share.CgmDevice r0 = r6.cgmDevice
            java.lang.String r1 = "getString(...)"
            if (r0 == 0) goto L_0x00ce
            java.lang.Integer r0 = r0.getSensorLeftTime()
            java.lang.String r2 = "format(...)"
            r3 = 1
            if (r0 == 0) goto L_0x00a4
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 >= 0) goto L_0x0040
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r4 = com.microtech.aidexx.R.string.com_time_remain_day
            java.lang.String r0 = r0.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.microtech.aidexx.AidexxApp r4 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r5 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r4 = r4.getString(r5)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r3)
            java.lang.String r0 = java.lang.String.format(r0, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            goto L_0x00a2
        L_0x0040:
            r4 = 24
            if (r0 >= r4) goto L_0x006c
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            com.microtech.aidexx.AidexxApp r4 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r5 = com.microtech.aidexx.R.string.com_time_remain_hour
            java.lang.String r4 = r4.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            if (r0 >= r3) goto L_0x0058
            java.lang.String r0 = "1"
            goto L_0x005c
        L_0x0058:
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x005c:
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r3)
            java.lang.String r0 = java.lang.String.format(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            goto L_0x00a2
        L_0x006c:
            java.math.BigDecimal r5 = new java.math.BigDecimal
            r5.<init>(r0)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r4)
            java.math.RoundingMode r4 = java.math.RoundingMode.CEILING
            java.math.BigDecimal r0 = r5.divide(r0, r4)
            int r0 = r0.intValue()
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            com.microtech.aidexx.AidexxApp r4 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r5 = com.microtech.aidexx.R.string.com_time_remain_day
            java.lang.String r4 = r4.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r3)
            java.lang.String r0 = java.lang.String.format(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
        L_0x00a2:
            if (r0 != 0) goto L_0x00cc
        L_0x00a4:
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r4 = com.microtech.aidexx.R.string.com_time_remain_day
            java.lang.String r0 = r0.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.microtech.aidexx.AidexxApp r4 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r5 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r4 = r4.getString(r5)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r4, r3)
            java.lang.String r0 = java.lang.String.format(r0, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
        L_0x00cc:
            if (r0 != 0) goto L_0x00db
        L_0x00ce:
            com.microtech.aidexx.AidexxApp r0 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r2 = com.microtech.aidexx.R.string.ble_state_unpaired
            java.lang.String r0 = r0.getString(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L_0x00db:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareUserInfo.getSensorLeftTime():java.lang.String");
    }

    public final String getLatestValueTimeStr() {
        String friendlyTimeSpanByNow;
        Integer lastHistoryTimeAgo = getLastHistoryTimeAgo();
        if (lastHistoryTimeAgo != null && (friendlyTimeSpanByNow = getFriendlyTimeSpanByNow(lastHistoryTimeAgo.intValue())) != null) {
            return friendlyTimeSpanByNow;
        }
        String string = ExtendsKt.getContext().getString(R.string.com_unknown);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final Integer getLastHistoryTimeAgo() {
        String appTime;
        UserTrendInfo userTrendInfo = this.userTrend;
        if (userTrendInfo == null || (appTime = userTrendInfo.getAppTime()) == null) {
            return null;
        }
        UserTrendInfo userTrendInfo2 = this.userTrend;
        String appTimeZone = userTrendInfo2 != null ? userTrendInfo2.getAppTimeZone() : null;
        Intrinsics.checkNotNull(appTimeZone);
        Long parseToTimestamp$default = ExtendsKt.parseToTimestamp$default(appTime, appTimeZone, (String) null, 2, (Object) null);
        if (parseToTimestamp$default == null) {
            return null;
        }
        return Integer.valueOf(ExtendsKt.millisToMinutes(TimeUtils.INSTANCE.getCurrentTimeMillis() - parseToTimestamp$default.longValue()));
    }

    private final String getFriendlyTimeSpanByNow(int i) {
        if (i == 0) {
            String string = ExtendsKt.getContext().getString(R.string.com_time_ago_justNow);
            Intrinsics.checkNotNull(string);
            return string;
        } else if (latestHistoryIsExpired(Integer.valueOf(i))) {
            String string2 = ExtendsKt.getContext().getString(R.string.com_unknown);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else {
            String string3 = ExtendsKt.getContext().getString(R.string.com_time_ago_minute, new Object[]{String.valueOf(i)});
            Intrinsics.checkNotNull(string3);
            return string3;
        }
    }

    private final boolean latestHistoryIsExpired(Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        return intValue > (settingEntity != null ? settingEntity.getSignalMissingAlertRate() : 15);
    }

    public final DeviceModel.GlucoseLevel getGlucoseLevel() {
        Float bloodGlucose;
        DeviceModel.GlucoseLevel glucoseLevel;
        UserTrendInfo userTrendInfo = this.userTrend;
        if (userTrendInfo == null || (bloodGlucose = userTrendInfo.getBloodGlucose()) == null) {
            return null;
        }
        float floatValue = bloodGlucose.floatValue();
        SettingsEntity settingsEntity = this.userSetting;
        if (settingsEntity == null) {
            return null;
        }
        if (floatValue < settingsEntity.getLowLimitMg()) {
            glucoseLevel = DeviceModel.GlucoseLevel.LOW;
        } else if (floatValue < settingsEntity.getHighLimitMg()) {
            glucoseLevel = DeviceModel.GlucoseLevel.NORMAL;
        } else {
            glucoseLevel = DeviceModel.GlucoseLevel.HIGH;
        }
        return glucoseLevel;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShareUserInfo(android.os.Parcel r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r3 = r21.readString()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r1 < r2) goto L_0x0024
            com.microtech.aidexx.ui.setting.share.ShareUserInfo$1 r1 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.AnonymousClass1.INSTANCE
            java.lang.Class r1 = r1.getClass()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Class<com.microtech.aidexx.ui.setting.share.UserTrendInfo> r4 = com.microtech.aidexx.ui.setting.share.UserTrendInfo.class
            java.lang.Object r1 = r0.readParcelable(r1, r4)
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r1 = (com.microtech.aidexx.ui.setting.share.UserTrendInfo) r1
            goto L_0x0034
        L_0x0024:
            com.microtech.aidexx.ui.setting.share.ShareUserInfo$2 r1 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.AnonymousClass2.INSTANCE
            java.lang.Class r1 = r1.getClass()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            android.os.Parcelable r1 = r0.readParcelable(r1)
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r1 = (com.microtech.aidexx.ui.setting.share.UserTrendInfo) r1
        L_0x0034:
            r4 = r1
            java.lang.String r5 = r21.readString()
            java.lang.String r6 = r21.readString()
            java.lang.String r7 = r21.readString()
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r0.readValue(r1)
            boolean r8 = r1 instanceof java.lang.Integer
            r9 = 0
            if (r8 == 0) goto L_0x0054
            java.lang.Integer r1 = (java.lang.Integer) r1
            r8 = r1
            goto L_0x0055
        L_0x0054:
            r8 = r9
        L_0x0055:
            java.lang.Class r1 = java.lang.Integer.TYPE
            java.lang.ClassLoader r1 = r1.getClassLoader()
            java.lang.Object r1 = r0.readValue(r1)
            boolean r10 = r1 instanceof java.lang.Integer
            if (r10 == 0) goto L_0x0066
            java.lang.Integer r1 = (java.lang.Integer) r1
            goto L_0x0067
        L_0x0066:
            r1 = r9
        L_0x0067:
            java.lang.Class r10 = java.lang.Integer.TYPE
            java.lang.ClassLoader r10 = r10.getClassLoader()
            java.lang.Object r10 = r0.readValue(r10)
            boolean r11 = r10 instanceof java.lang.Integer
            if (r11 == 0) goto L_0x0078
            java.lang.Integer r10 = (java.lang.Integer) r10
            goto L_0x0079
        L_0x0078:
            r10 = r9
        L_0x0079:
            java.lang.String r11 = r21.readString()
            java.lang.Class r12 = java.lang.Integer.TYPE
            java.lang.ClassLoader r12 = r12.getClassLoader()
            java.lang.Object r12 = r0.readValue(r12)
            boolean r13 = r12 instanceof java.lang.Integer
            if (r13 == 0) goto L_0x008e
            java.lang.Integer r12 = (java.lang.Integer) r12
            goto L_0x008f
        L_0x008e:
            r12 = r9
        L_0x008f:
            java.lang.String r13 = r21.readString()
            java.lang.String r14 = r21.readString()
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r2) goto L_0x00ae
            com.microtech.aidexx.ui.setting.share.ShareUserInfo$3 r9 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.AnonymousClass3.INSTANCE
            java.lang.Class r9 = r9.getClass()
            java.lang.ClassLoader r9 = r9.getClassLoader()
            java.lang.Class<com.microtech.aidexx.db.entity.UserEntity> r15 = com.microtech.aidexx.db.entity.UserEntity.class
            java.lang.Object r9 = r0.readParcelable(r9, r15)
            com.microtech.aidexx.db.entity.UserEntity r9 = (com.microtech.aidexx.db.entity.UserEntity) r9
            goto L_0x00be
        L_0x00ae:
            com.microtech.aidexx.ui.setting.share.ShareUserInfo$4 r9 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.AnonymousClass4.INSTANCE
            java.lang.Class r9 = r9.getClass()
            java.lang.ClassLoader r9 = r9.getClassLoader()
            android.os.Parcelable r9 = r0.readParcelable(r9)
            com.microtech.aidexx.db.entity.UserEntity r9 = (com.microtech.aidexx.db.entity.UserEntity) r9
        L_0x00be:
            r15 = r9
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 < r2) goto L_0x00d6
            com.microtech.aidexx.ui.setting.share.ShareUserInfo$5 r2 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.AnonymousClass5.INSTANCE
            java.lang.Class r2 = r2.getClass()
            java.lang.ClassLoader r2 = r2.getClassLoader()
            java.lang.Class<com.microtech.aidexx.ui.setting.share.CgmDevice> r9 = com.microtech.aidexx.ui.setting.share.CgmDevice.class
            java.lang.Object r0 = r0.readParcelable(r2, r9)
            com.microtech.aidexx.ui.setting.share.CgmDevice r0 = (com.microtech.aidexx.ui.setting.share.CgmDevice) r0
            goto L_0x00e6
        L_0x00d6:
            com.microtech.aidexx.ui.setting.share.ShareUserInfo$6 r2 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.AnonymousClass6.INSTANCE
            java.lang.Class r2 = r2.getClass()
            java.lang.ClassLoader r2 = r2.getClassLoader()
            android.os.Parcelable r0 = r0.readParcelable(r2)
            com.microtech.aidexx.ui.setting.share.CgmDevice r0 = (com.microtech.aidexx.ui.setting.share.CgmDevice) r0
        L_0x00e6:
            r16 = r0
            r18 = 16384(0x4000, float:2.2959E-41)
            r19 = 0
            r17 = 0
            r2 = r20
            r9 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareUserInfo.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.providerAlias);
        parcel.writeParcelable(this.userTrend, i);
        parcel.writeString(this.readerAlias);
        parcel.writeString(this.dataReaderId);
        parcel.writeString(this.providerUserName);
        parcel.writeValue(this.hideState);
        parcel.writeValue(this.emergePushState);
        parcel.writeValue(this.autoIncrementColumn);
        parcel.writeString(this.readerUserName);
        parcel.writeValue(this.normalPushState);
        parcel.writeString(this.dataProviderId);
        parcel.writeString(this.userAuthorizationId);
        parcel.writeParcelable(this.information, i);
        parcel.writeParcelable(this.cgmDevice, i);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ShareUserInfo.kt */
    public static final class CREATOR implements Parcelable.Creator<ShareUserInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public ShareUserInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShareUserInfo(parcel);
        }

        public ShareUserInfo[] newArray(int i) {
            return new ShareUserInfo[i];
        }
    }
}
