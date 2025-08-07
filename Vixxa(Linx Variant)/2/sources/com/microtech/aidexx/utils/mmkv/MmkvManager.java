package com.microtech.aidexx.utils.mmkv;

import android.os.Parcelable;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.igexin.assist.sdk.AssistPushConsts;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.DataSyncController;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.db.entity.event.preset.BaseSysPreset;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity;
import com.microtech.aidexx.ui.main.event.viewmodels.EventType;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b2\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020\u0004J\u0006\u0010:\u001a\u00020\u0004J\u0006\u0010;\u001a\u00020<J\u0006\u0010=\u001a\u00020<J\u0006\u0010>\u001a\u00020<J\u0006\u0010?\u001a\u00020<J\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0004J\u0015\u0010D\u001a\u0004\u0018\u0001082\u0006\u0010E\u001a\u00020\u0004¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010E\u001a\u00020\u0004J\u001e\u0010I\u001a\u00020\u0004\"\b\b\u0000\u0010J*\u00020K2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HJ0MJ\u001e\u0010N\u001a\u00020\u0004\"\b\b\u0000\u0010J*\u00020K2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HJ0MJ\"\u0010O\u001a\u0004\u0018\u00010\u0004\"\b\b\u0000\u0010J*\u00020K2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HJ0MH\u0002J\u0006\u0010P\u001a\u00020<J\"\u0010Q\u001a\u0004\u0018\u00010\u0004\"\b\b\u0000\u0010J*\u00020K2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HJ0MH\u0002J\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020SJ\u0006\u0010U\u001a\u00020\u0004J\u0006\u0010V\u001a\u00020\u0004J\u0006\u0010W\u001a\u00020\u0004J\u0006\u0010X\u001a\u00020<J\u0006\u0010Y\u001a\u00020\u0004J\u0010\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010\\\u001a\u00020<J\u0018\u0010]\u001a\u00020\u00042\b\b\u0001\u0010^\u001a\u00020<2\u0006\u0010_\u001a\u00020BJ\u0006\u0010`\u001a\u000208J\u0006\u0010a\u001a\u00020\u0004J\b\u0010b\u001a\u0004\u0018\u00010cJ\u0006\u0010d\u001a\u00020<J\u0006\u0010e\u001a\u00020\u0004J\u0006\u0010f\u001a\u000208J\u0006\u0010g\u001a\u00020<J\u0006\u0010h\u001a\u00020\u0004J\u0006\u0010i\u001a\u00020\u0004J\u0006\u0010j\u001a\u00020\u0004J\u0006\u0010k\u001a\u00020\u0004J\u0006\u0010l\u001a\u000208J\u0006\u0010m\u001a\u00020BJ\u0006\u0010n\u001a\u00020BJ\u0006\u0010o\u001a\u00020BJ\u0006\u0010p\u001a\u00020BJ\u0006\u0010q\u001a\u00020BJ\u000e\u0010r\u001a\u00020B2\u0006\u0010E\u001a\u00020\u0004J\u0006\u0010s\u001a\u00020BJ\u000e\u0010t\u001a\u00020B2\u0006\u0010u\u001a\u00020\u0004J\u000e\u0010v\u001a\u0002062\u0006\u0010w\u001a\u00020BJ\u0006\u0010x\u001a\u000206J&\u0010y\u001a\u0002062\u0006\u0010z\u001a\u00020<2\u0006\u0010{\u001a\u00020<2\u0006\u0010|\u001a\u00020<2\u0006\u0010}\u001a\u00020<J\u000e\u0010~\u001a\u0002062\u0006\u0010}\u001a\u00020<J\u000e\u0010\u001a\u0002062\u0006\u0010z\u001a\u00020<J\u000f\u0010\u0001\u001a\u0002062\u0006\u0010|\u001a\u00020<J\u000f\u0010\u0001\u001a\u0002062\u0006\u0010{\u001a\u00020<J\u0018\u0010\u0001\u001a\u0002062\u0006\u0010C\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020BJ\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020<J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020SJ\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020SJ\u0019\u0010\u0001\u001a\u0002062\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\\\u001a\u00020<J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\u0004J\u0011\u0010\u0001\u001a\u0002062\b\u0010\u0001\u001a\u00030\u0001J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020<J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u000208J\u0007\u0010\u0001\u001a\u000206J\u0007\u0010\u0001\u001a\u000206J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u00020\u0004J\u000f\u0010\u0001\u001a\u0002062\u0006\u0010u\u001a\u00020\u0004J \u0010\u0001\u001a\u0002062\u0006\u0010E\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u000108¢\u0006\u0003\u0010\u0001J\u001a\u0010\u0001\u001a\u0002062\u0006\u0010E\u001a\u00020\u00042\t\u0010 \u0001\u001a\u0004\u0018\u00010HJ(\u0010¡\u0001\u001a\u000206\"\b\b\u0000\u0010J*\u00020K2\u0007\u0010¢\u0001\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HJ0MJ(\u0010£\u0001\u001a\u000206\"\b\b\u0000\u0010J*\u00020K2\u0007\u0010¤\u0001\u001a\u00020\u00042\f\u0010L\u001a\b\u0012\u0004\u0012\u0002HJ0MJ\u0010\u0010¥\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0010\u0010¦\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0010\u0010§\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0018\u0010¨\u0001\u001a\u0002062\u0006\u0010E\u001a\u00020\u00042\u0007\u0010©\u0001\u001a\u00020BJ\u000f\u0010ª\u0001\u001a\u0002062\u0006\u0010s\u001a\u00020BJ\u0010\u0010«\u0001\u001a\u0002062\u0007\u0010¬\u0001\u001a\u00020<J\u0010\u0010­\u0001\u001a\u0002062\u0007\u0010®\u0001\u001a\u00020\u0004J\"\u0010¯\u0001\u001a\u0002062\b\b\u0001\u0010^\u001a\u00020<2\u0007\u0010¤\u0001\u001a\u00020\u00042\u0006\u0010_\u001a\u00020BJ\u0010\u0010°\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0010\u0010±\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u000208J\u0010\u0010²\u0001\u001a\u0002062\u0007\u0010³\u0001\u001a\u00020<J\u0010\u0010´\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0010\u0010µ\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0010\u0010¶\u0001\u001a\u0002062\u0007\u0010·\u0001\u001a\u00020\u0004J\u000f\u0010¸\u0001\u001a\u0002062\u0006\u0010u\u001a\u00020\u0004J\u0012\u0010¹\u0001\u001a\u0002062\t\b\u0002\u0010º\u0001\u001a\u000208J\u0012\u0010»\u0001\u001a\u0002062\t\b\u0002\u0010º\u0001\u001a\u000208R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006¼\u0001"}, d2 = {"Lcom/microtech/aidexx/utils/mmkv/MmkvManager;", "", "()V", "ALREADY_SHOW_FOLLOWERS_DIALOG_GUIDE", "", "APP_CHECK_UPDATE_DATE", "CURRENT_LANGUAGE_TAG", "CUSTOMER_SERVICE_ICON_BOTTOM", "CUSTOMER_SERVICE_ICON_LEFT", "CUSTOMER_SERVICE_ICON_RIGHT", "CUSTOMER_SERVICE_ICON_TOP", "FLAG_BOOT_VER_BEFORE_OTA", "FLAG_DID_OTA_SN", "FLAG_HAS_BIND_WATCH", "FLAG_LOGIN", "FLAG_NEW_VERSION_EXERCISE_SYS_PRESET", "FLAG_NEW_VERSION_FOOD_SYS_PRESET", "FLAG_NEW_VERSION_INSULIN_SYS_PRESET", "FLAG_NEW_VERSION_LANGUAGE", "FLAG_NEW_VERSION_MEDICINE_SYS_PRESET", "FLAG_NEW_VERSION_UNIT", "FLAG_OTA_INFO", "GIVEN_NAME", "GLUCOSE_UNIT", "HAS_SHOW_AVATAR_ENQUIRE", "HYPER", "HYPO", "IS_AGREE_PROTOCOL", "IS_APP_FIRST_LAUNCH", "LAST_WELFARE_DIALOG_TIME", "NICK_NAME", "OS_API_31_FIRST_IN", "PHONE_NUMBER", "POLICY_INFO", "PRESET_VERSION_", "PRIVACY_UPDATE_DATE", "RESOURCE_VERSION", "SETTINGS", "SUR_NAME", "THEME", "TOKEN", "UNIT_LATEST_UPDATE_TIME", "UNIT_LOADED_APK_VERSION", "UPGRADE_RESOURCE_ZIP_FILE_INFO", "USER_AVATAR", "USER_ID", "VERSION_EXERCISE_SYS_PRESET", "VERSION_FOOD_SYS_PRESET", "VERSION_INSULIN_SYS_PRESET", "VERSION_LANGUAGE", "VERSION_LANGUAGE_CONF", "VERSION_MEDICINE_SYS_PRESET", "VERSION_UNIT", "bindWatch", "", "getAppCheckVersionTime", "", "getBootVer", "getCurrentLanguageTag", "getCustomerServiceIconBottom", "", "getCustomerServiceIconLeft", "getCustomerServiceIconRight", "getCustomerServiceIconTop", "getDidOtaSn", "getEnquireFlag", "", "flag", "getEventDataId", "key", "(Ljava/lang/String;)Ljava/lang/Long;", "getEventSyncTask", "Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItemList;", "getEventSysPresetNewVersion", "T", "Lcom/microtech/aidexx/db/entity/event/preset/BaseSysPreset;", "clazz", "Ljava/lang/Class;", "getEventSysPresetVersion", "getEventSysPresetVersionKey", "getGlucoseUnit", "getHasEventSysPresetNewVersionKey", "getHyper", "", "getHypo", "getLanguageConfVersion", "getLanguageNewVersion", "getLanguageVersion", "getOnlineServiceMsgCount", "getOtaInfo", "getPolicyInfo", "Lcom/microtech/aidexx/common/net/entity/PolicyUpgradeInfo;", "policyType", "getPresetVersion", "type", "isSys", "getPrivacyCheckTime", "getResourceVersion", "getSettings", "Lcom/microtech/aidexx/db/entity/SettingsEntity;", "getTheme", "getToken", "getUnitLatestUpdateTime", "getUnitLoadedApkVersion", "getUnitNewVersion", "getUnitVersion", "getUpgradeResourceZipFileInfo", "getUserId", "getWelfareDialogTime", "hasBindWatch", "isAgreeProtocol", "isAlreadyShowFollowersGuide", "isApi31FirstIn", "isAppFirstLaunch", "isLastLoginEventDownloadSuccess", "isLogin", "needShowExpiredDialog", "sn", "saveAgreeProtocol", "isAgree", "saveAppLaunched", "saveCustomerIconPosition", "left", "top", "right", "bottom", "saveCustomerServiceIconBottom", "saveCustomerServiceIconLeft", "saveCustomerServiceIconRight", "saveCustomerServiceIconTop", "saveEnquireFlag", "value", "saveGlucoseUnit", "index", "saveHyper", "saveHypo", "savePolicyInfo", "parcelable", "Landroid/os/Parcelable;", "saveProfile", "profile", "saveSettings", "saveTheme", "saveToken", "token", "saveUserId", "id", "saveWelfareDialogTime", "time", "setAlreadyShowFollowersGuide", "setApi31FirstIn", "setBootVer", "bootVer", "setCurrentLanguageTag", "tag", "setDidOtaSn", "setEventDataId", "eventId", "(Ljava/lang/String;Ljava/lang/Long;)V", "setEventSyncTask", "tasks", "setEventSysPresetNewVersion", "newVersion", "setEventSysPresetVersion", "version", "setLanguageConfVersion", "setLanguageNewVersion", "setLanguageVersion", "setLastLoginEventDownloadState", "isSuccess", "setLogin", "setOnlineServiceMsgCount", "count", "setOtaInfo", "snOfOta", "setPresetVersion", "setResourceVersion", "setUnitLatestUpdateTime", "setUnitLoadedApkVersion", "v", "setUnitNewVersion", "setUnitVersion", "setUpgradeResourceZipFileInfo", "info", "shownExpiredDialog", "updateAppCheckVersionTime", "date", "updatePrivacyCheckTime", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MmkvManager.kt */
public final class MmkvManager {
    private static final String ALREADY_SHOW_FOLLOWERS_DIALOG_GUIDE = "ALREADY_SHOW_FOLLOWERS_DIALOG_GUIDE";
    private static final String APP_CHECK_UPDATE_DATE = "APP_CHECK_UPDATE_DATE";
    private static final String CURRENT_LANGUAGE_TAG = "CURRENT_LANGUAGE_TAG";
    private static final String CUSTOMER_SERVICE_ICON_BOTTOM = "CUSTOMER_SERVICE_ICON_BOTTOM";
    private static final String CUSTOMER_SERVICE_ICON_LEFT = "CUSTOMER_SERVICE_ICON_LEFT";
    private static final String CUSTOMER_SERVICE_ICON_RIGHT = "CUSTOMER_SERVICE_ICON_RIGHT";
    private static final String CUSTOMER_SERVICE_ICON_TOP = "CUSTOMER_SERVICE_ICON_TOP";
    private static final String FLAG_BOOT_VER_BEFORE_OTA = "FLAG_BOOT_VER_BEFORE_OTA";
    private static final String FLAG_DID_OTA_SN = "FLAG_DID_OTA_SN";
    private static final String FLAG_HAS_BIND_WATCH = "FLAG_HAS_BIND_WATCH";
    private static final String FLAG_LOGIN = "FLAG_LOGIN";
    private static final String FLAG_NEW_VERSION_EXERCISE_SYS_PRESET = "FLAG_NEW_VERSION_EXERCISE_SYS_PRESET";
    private static final String FLAG_NEW_VERSION_FOOD_SYS_PRESET = "FLAG_NEW_VERSION_FOOD_SYS_PRESET";
    private static final String FLAG_NEW_VERSION_INSULIN_SYS_PRESET = "FLAG_NEW_VERSION_INSULIN_SYS_PRESET";
    private static final String FLAG_NEW_VERSION_LANGUAGE = "FLAG_NEW_VERSION_LANGUAGE";
    private static final String FLAG_NEW_VERSION_MEDICINE_SYS_PRESET = "FLAG_NEW_VERSION_MEDICINE_SYS_PRESET";
    private static final String FLAG_NEW_VERSION_UNIT = "FLAG_NEW_VERSION_UNIT";
    private static final String FLAG_OTA_INFO = "FLAG_OTA_INFO";
    private static final String GIVEN_NAME = "GIVEN_NAME";
    private static final String GLUCOSE_UNIT = "GLUCOSE_UNIT";
    private static final String HAS_SHOW_AVATAR_ENQUIRE = "HAS_SHOW_AVATAR_ENQUIRE";
    private static final String HYPER = "HYPER";
    private static final String HYPO = "HYPO";
    public static final MmkvManager INSTANCE = new MmkvManager();
    private static final String IS_AGREE_PROTOCOL = "IS_AGREE_PROTOCOL";
    private static final String IS_APP_FIRST_LAUNCH = "IS_APP_FIRST_LAUNCH";
    private static final String LAST_WELFARE_DIALOG_TIME = "LAST_WELFARE_DIALOG_TIME";
    private static final String NICK_NAME = "NICK_NAME";
    private static final String OS_API_31_FIRST_IN = "OS_API_31_FIRST_IN";
    private static final String PHONE_NUMBER = "PHONE_NUMBER";
    private static final String POLICY_INFO = "POLICY_INFO";
    private static final String PRESET_VERSION_ = "PRESET_VERSION_";
    private static final String PRIVACY_UPDATE_DATE = "PRIVACY_UPDATE_DATE";
    private static final String RESOURCE_VERSION = "RESOURCE_VERSION";
    private static final String SETTINGS = "SETTINGS";
    private static final String SUR_NAME = "SUR_NAME";
    private static final String THEME = "THEME";
    private static final String TOKEN = "TOKEN";
    private static final String UNIT_LATEST_UPDATE_TIME = "UNIT_LATEST_UPDATE_TIME";
    private static final String UNIT_LOADED_APK_VERSION = "UNIT_LOADED_APK_VERSION";
    private static final String UPGRADE_RESOURCE_ZIP_FILE_INFO = "UPGRADE_RESOURCE_ZIP_FILE_INFO";
    private static final String USER_AVATAR = "USER_AVATAR";
    private static final String USER_ID = "USER_ID";
    private static final String VERSION_EXERCISE_SYS_PRESET = "VERSION_EXERCISE_SYS_PRESET";
    private static final String VERSION_FOOD_SYS_PRESET = "VERSION_FOOD_SYS_PRESET";
    private static final String VERSION_INSULIN_SYS_PRESET = "VERSION_INSULIN_SYS_PRESET";
    private static final String VERSION_LANGUAGE = "VERSION_LANGUAGE";
    private static final String VERSION_LANGUAGE_CONF = "VERSION_LANGUAGE_CONF";
    private static final String VERSION_MEDICINE_SYS_PRESET = "VERSION_MEDICINE_SYS_PRESET";
    private static final String VERSION_UNIT = "VERSION_UNIT";

    private MmkvManager() {
    }

    public final boolean hasBindWatch() {
        return MmkvUtil.Companion.decodeBoolean(FLAG_HAS_BIND_WATCH, false);
    }

    public final void bindWatch() {
        MmkvUtil.Companion.encodeBoolean(FLAG_HAS_BIND_WATCH, true);
    }

    public final void setDidOtaSn(String str) {
        Intrinsics.checkNotNullParameter(str, "sn");
        MmkvUtil.Companion.encodeString(FLAG_DID_OTA_SN, str);
    }

    public final String getDidOtaSn() {
        return MmkvUtil.Companion.decodeString(FLAG_DID_OTA_SN, "");
    }

    public final void setBootVer(String str) {
        Intrinsics.checkNotNullParameter(str, "bootVer");
        MmkvUtil.Companion.encodeString(FLAG_BOOT_VER_BEFORE_OTA, str);
    }

    public final String getBootVer() {
        return MmkvUtil.Companion.decodeString(FLAG_BOOT_VER_BEFORE_OTA, "");
    }

    public final void setOtaInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "snOfOta");
        MmkvUtil.Companion.encodeString(FLAG_OTA_INFO, str);
    }

    public final String getOtaInfo() {
        return MmkvUtil.Companion.decodeString(FLAG_OTA_INFO, "");
    }

    public final boolean isApi31FirstIn() {
        return MmkvUtil.Companion.decodeBoolean(OS_API_31_FIRST_IN, true);
    }

    public final void setApi31FirstIn() {
        MmkvUtil.Companion.encodeBoolean(OS_API_31_FIRST_IN, false);
    }

    public final void setUpgradeResourceZipFileInfo(String str) {
        Intrinsics.checkNotNullParameter(str, TransmitterActivityKt.BLE_INFO);
        MmkvUtil.Companion.encodeString(UPGRADE_RESOURCE_ZIP_FILE_INFO, str);
    }

    public final String getUpgradeResourceZipFileInfo() {
        return MmkvUtil.Companion.decodeString(UPGRADE_RESOURCE_ZIP_FILE_INFO, "");
    }

    public final void setCurrentLanguageTag(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        MmkvUtil.Companion.encodeString(CURRENT_LANGUAGE_TAG, str);
    }

    public final String getCurrentLanguageTag() {
        return MmkvUtil.Companion.decodeString(CURRENT_LANGUAGE_TAG, "");
    }

    private final <T extends BaseSysPreset> String getHasEventSysPresetNewVersionKey(Class<T> cls) {
        if (Intrinsics.areEqual((Object) cls, (Object) DietSysPresetEntity.class)) {
            return FLAG_NEW_VERSION_FOOD_SYS_PRESET;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) SportSysPresetEntity.class)) {
            return FLAG_NEW_VERSION_EXERCISE_SYS_PRESET;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) MedicineSysPresetEntity.class)) {
            return FLAG_NEW_VERSION_MEDICINE_SYS_PRESET;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) InsulinSysPresetEntity.class)) {
            return FLAG_NEW_VERSION_INSULIN_SYS_PRESET;
        }
        return null;
    }

    private final <T extends BaseSysPreset> String getEventSysPresetVersionKey(Class<T> cls) {
        if (Intrinsics.areEqual((Object) cls, (Object) DietSysPresetEntity.class)) {
            return VERSION_FOOD_SYS_PRESET;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) SportSysPresetEntity.class)) {
            return VERSION_EXERCISE_SYS_PRESET;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) MedicineSysPresetEntity.class)) {
            return VERSION_MEDICINE_SYS_PRESET;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) InsulinSysPresetEntity.class)) {
            return VERSION_INSULIN_SYS_PRESET;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r3 = com.microtech.aidexx.utils.mmkv.MmkvUtil.Companion.decodeString(r3, "");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.microtech.aidexx.db.entity.event.preset.BaseSysPreset> java.lang.String getEventSysPresetVersion(java.lang.Class<T> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r3 = r2.getEventSysPresetVersionKey(r3)
            java.lang.String r0 = ""
            if (r3 == 0) goto L_0x0017
            com.microtech.aidexx.utils.mmkv.MmkvUtil$Companion r1 = com.microtech.aidexx.utils.mmkv.MmkvUtil.Companion
            java.lang.String r3 = r1.decodeString(r3, r0)
            if (r3 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.mmkv.MmkvManager.getEventSysPresetVersion(java.lang.Class):java.lang.String");
    }

    public final <T extends BaseSysPreset> void setEventSysPresetVersion(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        String eventSysPresetVersionKey = getEventSysPresetVersionKey(cls);
        if (eventSysPresetVersionKey != null) {
            MmkvUtil.Companion.encodeString(eventSysPresetVersionKey, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r3 = com.microtech.aidexx.utils.mmkv.MmkvUtil.Companion.decodeString(r3, "");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.microtech.aidexx.db.entity.event.preset.BaseSysPreset> java.lang.String getEventSysPresetNewVersion(java.lang.Class<T> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r3 = r2.getHasEventSysPresetNewVersionKey(r3)
            java.lang.String r0 = ""
            if (r3 == 0) goto L_0x0017
            com.microtech.aidexx.utils.mmkv.MmkvUtil$Companion r1 = com.microtech.aidexx.utils.mmkv.MmkvUtil.Companion
            java.lang.String r3 = r1.decodeString(r3, r0)
            if (r3 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.mmkv.MmkvManager.getEventSysPresetNewVersion(java.lang.Class):java.lang.String");
    }

    public final <T extends BaseSysPreset> void setEventSysPresetNewVersion(String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "newVersion");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        String hasEventSysPresetNewVersionKey = getHasEventSysPresetNewVersionKey(cls);
        if (hasEventSysPresetNewVersionKey != null) {
            MmkvUtil.Companion.encodeString(hasEventSysPresetNewVersionKey, str);
        }
    }

    public final void setLanguageVersion(String str) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        MmkvUtil.Companion.encodeString(VERSION_LANGUAGE, str);
    }

    public final String getLanguageVersion() {
        return MmkvUtil.Companion.decodeString(VERSION_LANGUAGE, "");
    }

    public final void setLanguageNewVersion(String str) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        MmkvUtil.Companion.encodeString(FLAG_NEW_VERSION_LANGUAGE, str);
    }

    public final String getLanguageNewVersion() {
        return MmkvUtil.Companion.decodeString(FLAG_NEW_VERSION_LANGUAGE, "");
    }

    public final void setLanguageConfVersion(String str) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        MmkvUtil.Companion.encodeString(VERSION_LANGUAGE_CONF, str);
    }

    public final String getLanguageConfVersion() {
        return MmkvUtil.Companion.decodeString(VERSION_LANGUAGE_CONF, "");
    }

    public final void setUnitVersion(String str) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        MmkvUtil.Companion.encodeString(VERSION_UNIT, str);
    }

    public final String getUnitVersion() {
        return MmkvUtil.Companion.decodeString(VERSION_UNIT, "");
    }

    public final void setUnitNewVersion(String str) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        MmkvUtil.Companion.encodeString(FLAG_NEW_VERSION_UNIT, str);
    }

    public final String getUnitNewVersion() {
        return MmkvUtil.Companion.decodeString(FLAG_NEW_VERSION_UNIT, "");
    }

    public final void setResourceVersion(String str) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        MmkvUtil.Companion.encodeString(RESOURCE_VERSION, str);
    }

    public final String getResourceVersion() {
        return MmkvUtil.Companion.decodeString(RESOURCE_VERSION, "");
    }

    public final void setLastLoginEventDownloadState(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        MmkvUtil.Companion.encodeBoolean(str, z);
    }

    public final boolean isLastLoginEventDownloadSuccess(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return MmkvUtil.Companion.decodeBoolean(str, true);
    }

    public final void setEventSyncTask(String str, DataSyncController.SyncTaskItemList syncTaskItemList) {
        String str2;
        String syncTaskItemList2;
        Intrinsics.checkNotNullParameter(str, "key");
        LogUtil.Companion companion = LogUtil.Companion;
        StringBuilder append = new StringBuilder("kv setEventSyncTask ").append(str).append('=');
        String str3 = "";
        if (syncTaskItemList == null || (str2 = syncTaskItemList.toString()) == null) {
            str2 = str3;
        }
        companion.xLogE(append.append(str2).toString(), "SyncTaskItemList");
        MmkvUtil.Companion companion2 = MmkvUtil.Companion;
        if (!(syncTaskItemList == null || (syncTaskItemList2 = syncTaskItemList.toString()) == null)) {
            str3 = syncTaskItemList2;
        }
        companion2.encodeString(str, str3);
    }

    public final DataSyncController.SyncTaskItemList getEventSyncTask(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return DataSyncController.SyncTaskItemList.Companion.fromString(MmkvUtil.Companion.decodeString(str, ""));
    }

    public final void setEventDataId(String str, Long l) {
        Intrinsics.checkNotNullParameter(str, "key");
        MmkvUtil.Companion.encodeLong(str, l != null ? l.longValue() : -1);
    }

    public final Long getEventDataId(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        long decodeLong = MmkvUtil.Companion.decodeLong(str, -1);
        if (decodeLong == -1) {
            return null;
        }
        return Long.valueOf(decodeLong);
    }

    public final int getUnitLoadedApkVersion() {
        return MmkvUtil.Companion.decodeInt(UNIT_LOADED_APK_VERSION, 0);
    }

    public final void setUnitLoadedApkVersion(int i) {
        MmkvUtil.Companion.encodeInt(UNIT_LOADED_APK_VERSION, i);
    }

    public final long getUnitLatestUpdateTime() {
        return MmkvUtil.Companion.decodeLong(UNIT_LATEST_UPDATE_TIME, 0);
    }

    public final void setUnitLatestUpdateTime(long j) {
        MmkvUtil.Companion.encodeLong(UNIT_LATEST_UPDATE_TIME, j);
    }

    public final void setPresetVersion(@EventType int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        MmkvUtil.Companion.encodeString(PRESET_VERSION_ + i + (z ? "_SYS" : "_USR"), str);
    }

    public final String getPresetVersion(@EventType int i, boolean z) {
        return MmkvUtil.Companion.decodeString(PRESET_VERSION_ + i + (z ? "_SYS" : "_USR"), "");
    }

    public final void setAlreadyShowFollowersGuide() {
        MmkvUtil.Companion.encodeBoolean(ALREADY_SHOW_FOLLOWERS_DIALOG_GUIDE, true);
    }

    public final boolean isAlreadyShowFollowersGuide() {
        return MmkvUtil.Companion.decodeBoolean(ALREADY_SHOW_FOLLOWERS_DIALOG_GUIDE, true);
    }

    public final void saveProfile(String str) {
        Intrinsics.checkNotNullParameter(str, "profile");
        MmkvUtil.Companion.encodeString(USER_AVATAR, str);
    }

    public final void setLogin(boolean z) {
        MmkvUtil.Companion.encodeBoolean(FLAG_LOGIN, z);
    }

    public final boolean isLogin() {
        return MmkvUtil.Companion.decodeBoolean(FLAG_LOGIN, false);
    }

    public final void saveToken(String str) {
        Intrinsics.checkNotNullParameter(str, AssistPushConsts.MSG_TYPE_TOKEN);
        LogUtil.Companion.eAiDEX("save token: " + str);
        MmkvUtil.Companion.encodeString(TOKEN, str);
    }

    public final String getToken() {
        String decodeString = MmkvUtil.Companion.decodeString(TOKEN, "");
        LogUtil.Companion.eAiDEX("get token: " + decodeString);
        return decodeString;
    }

    public final void saveHypo(float f) {
        MmkvUtil.Companion.encodeFloat(HYPO, f);
    }

    public final float getHypo() {
        return MmkvUtil.Companion.decodeFloat(HYPO, 70.200005f);
    }

    public final void saveHyper(float f) {
        MmkvUtil.Companion.encodeFloat(HYPER, f);
    }

    public final float getHyper() {
        return MmkvUtil.Companion.decodeFloat(HYPER, 180.0f);
    }

    public final void saveAppLaunched() {
        MmkvUtil.Companion.encodeBoolean(IS_APP_FIRST_LAUNCH, false);
    }

    public final boolean isAppFirstLaunch() {
        return MmkvUtil.Companion.decodeBoolean(IS_APP_FIRST_LAUNCH, true);
    }

    public final void saveAgreeProtocol(boolean z) {
        MmkvUtil.Companion.encodeBoolean(IS_AGREE_PROTOCOL, z);
    }

    public final boolean isAgreeProtocol() {
        return MmkvUtil.Companion.decodeBoolean(IS_AGREE_PROTOCOL, true);
    }

    public final void saveUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        MmkvUtil.Companion.encodeString(USER_ID, str);
    }

    public final String getUserId() {
        return MmkvUtil.Companion.decodeString(USER_ID, "");
    }

    public final int getOnlineServiceMsgCount() {
        return MmkvUtil.Companion.decodeInt(UserInfoManager.Companion.instance().userId(), 0);
    }

    public final void setOnlineServiceMsgCount(int i) {
        MmkvUtil.Companion.encodeInt(UserInfoManager.Companion.instance().userId(), i);
    }

    public final boolean getEnquireFlag(String str) {
        Intrinsics.checkNotNullParameter(str, "flag");
        return MmkvUtil.Companion.decodeBoolean(str, false);
    }

    public final void saveEnquireFlag(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "flag");
        MmkvUtil.Companion.encodeBoolean(str, z);
    }

    public final int getTheme() {
        return MmkvUtil.Companion.decodeInt(THEME, 0);
    }

    public final void saveTheme(int i) {
        MmkvUtil.Companion.encodeInt(THEME, i);
    }

    public final int getGlucoseUnit() {
        return MmkvUtil.Companion.decodeInt(GLUCOSE_UNIT, 0);
    }

    public final void saveGlucoseUnit(int i) {
        MmkvUtil.Companion.encodeInt(GLUCOSE_UNIT, i);
    }

    public final void saveCustomerIconPosition(int i, int i2, int i3, int i4) {
        saveCustomerServiceIconLeft(i);
        saveCustomerServiceIconTop(i2);
        saveCustomerServiceIconRight(i3);
        saveCustomerServiceIconBottom(i4);
    }

    public final void saveCustomerServiceIconLeft(int i) {
        MmkvUtil.Companion.encodeInt(CUSTOMER_SERVICE_ICON_LEFT, i);
    }

    public final void saveCustomerServiceIconTop(int i) {
        MmkvUtil.Companion.encodeInt(CUSTOMER_SERVICE_ICON_TOP, i);
    }

    public final void saveCustomerServiceIconRight(int i) {
        MmkvUtil.Companion.encodeInt(CUSTOMER_SERVICE_ICON_RIGHT, i);
    }

    public final void saveCustomerServiceIconBottom(int i) {
        MmkvUtil.Companion.encodeInt(CUSTOMER_SERVICE_ICON_BOTTOM, i);
    }

    public final int getCustomerServiceIconLeft() {
        return MmkvUtil.Companion.decodeInt(CUSTOMER_SERVICE_ICON_LEFT, 0);
    }

    public final int getCustomerServiceIconTop() {
        return MmkvUtil.Companion.decodeInt(CUSTOMER_SERVICE_ICON_TOP, 0);
    }

    public final int getCustomerServiceIconRight() {
        return MmkvUtil.Companion.decodeInt(CUSTOMER_SERVICE_ICON_RIGHT, 0);
    }

    public final int getCustomerServiceIconBottom() {
        return MmkvUtil.Companion.decodeInt(CUSTOMER_SERVICE_ICON_BOTTOM, 0);
    }

    public static /* synthetic */ void updateAppCheckVersionTime$default(MmkvManager mmkvManager, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ExtendsKt.getStartOfTheDay(new Date()).getTime();
        }
        mmkvManager.updateAppCheckVersionTime(j);
    }

    public final void updateAppCheckVersionTime(long j) {
        MmkvUtil.Companion.encodeLong("APP_CHECK_UPDATE_DATE-1.7.1", j);
    }

    public static /* synthetic */ void updatePrivacyCheckTime$default(MmkvManager mmkvManager, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ExtendsKt.getStartOfTheDay(new Date()).getTime();
        }
        mmkvManager.updatePrivacyCheckTime(j);
    }

    public final void updatePrivacyCheckTime(long j) {
        MmkvUtil.Companion.encodeLong(PRIVACY_UPDATE_DATE, j);
    }

    public final long getPrivacyCheckTime() {
        return MmkvUtil.Companion.decodeLong(PRIVACY_UPDATE_DATE, -1);
    }

    public final long getAppCheckVersionTime() {
        return MmkvUtil.Companion.decodeLong("APP_CHECK_UPDATE_DATE-1.7.1", 0);
    }

    public final SettingsEntity getSettings() {
        return (SettingsEntity) MmkvUtil.Companion.decodeParcelable(SETTINGS, SettingsEntity.class, MmkvUtil.Companion.getSETTING());
    }

    public final void saveSettings(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "parcelable");
        MmkvUtil.Companion.encodeParcelable(SETTINGS, parcelable, MmkvUtil.Companion.getSETTING());
    }

    public final long getWelfareDialogTime() {
        return MmkvUtil.Companion.decodeLong(LAST_WELFARE_DIALOG_TIME, 0);
    }

    public final void saveWelfareDialogTime(long j) {
        MmkvUtil.Companion.encodeLong(LAST_WELFARE_DIALOG_TIME, j);
    }

    public final boolean needShowExpiredDialog(String str) {
        Intrinsics.checkNotNullParameter(str, "sn");
        return MmkvUtil.Companion.decodeBoolean(str, true);
    }

    public final void shownExpiredDialog(String str) {
        Intrinsics.checkNotNullParameter(str, "sn");
        MmkvUtil.Companion.encodeBoolean(str, false);
    }

    public final PolicyUpgradeInfo getPolicyInfo(int i) {
        return (PolicyUpgradeInfo) MmkvUtil.Companion.decodeParcelable("POLICY_INFO-" + i + Soundex.SILENT_MARKER + LanguageResourceManager.INSTANCE.getCurLanguageTag(), PolicyUpgradeInfo.class, MmkvUtil.Companion.getSETTING());
    }

    public final void savePolicyInfo(Parcelable parcelable, int i) {
        Intrinsics.checkNotNullParameter(parcelable, "parcelable");
        MmkvUtil.Companion.encodeParcelable("POLICY_INFO-" + i + Soundex.SILENT_MARKER + LanguageResourceManager.INSTANCE.getCurLanguageTag(), parcelable, MmkvUtil.Companion.getSETTING());
    }
}
