package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0013\u001a\u00020\nJ\r\u0010\u0014\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001eJ\u0011\u0010#\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010$R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/microtech/aidexx/ui/setting/SettingsManager;", "", "()V", "settingEntity", "Lcom/microtech/aidexx/db/entity/SettingsEntity;", "getSettingEntity", "()Lcom/microtech/aidexx/db/entity/SettingsEntity;", "setSettingEntity", "(Lcom/microtech/aidexx/db/entity/SettingsEntity;)V", "downloadSettings", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFastDownSwitch", "getFastUpSwitch", "getHyperAlertSwitch", "getHypoAlertSwitch", "getTimezone", "getUrgentAlertSwitch", "inDaylightTime", "()Ljava/lang/Boolean;", "saveSetting", "", "settings", "setInDaylightTime", "setLanguage", "lang", "setTheme", "theme", "", "setTimezone", "id", "setUnit", "unit", "uploadSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingsManager.kt */
public final class SettingsManager {
    public static final SettingsManager INSTANCE = new SettingsManager();
    private static SettingsEntity settingEntity;

    private SettingsManager() {
    }

    public final void setSettingEntity(SettingsEntity settingsEntity) {
        settingEntity = settingsEntity;
    }

    public final SettingsEntity getSettingEntity() {
        if (settingEntity == null) {
            SettingsEntity settings = MmkvManager.INSTANCE.getSettings();
            if (settings == null) {
                settings = new SettingsEntity();
            }
            settingEntity = settings;
        }
        return settingEntity;
    }

    public final boolean getFastDownSwitch() {
        SettingsEntity settingEntity2 = getSettingEntity();
        return settingEntity2 != null && settingEntity2.getFastDownSwitch() == 0;
    }

    public final boolean getFastUpSwitch() {
        SettingsEntity settingEntity2 = getSettingEntity();
        return settingEntity2 != null && settingEntity2.getFastUpSwitch() == 0;
    }

    public final boolean getHyperAlertSwitch() {
        SettingsEntity settingEntity2 = getSettingEntity();
        return settingEntity2 != null && settingEntity2.getHighAlertSwitch() == 0;
    }

    public final boolean getHypoAlertSwitch() {
        SettingsEntity settingEntity2 = getSettingEntity();
        return settingEntity2 != null && settingEntity2.getLowAlertSwitch() == 0;
    }

    public final boolean getUrgentAlertSwitch() {
        SettingsEntity settingEntity2 = getSettingEntity();
        return settingEntity2 != null && settingEntity2.getUrgentLowAlertSwitch() == 0;
    }

    public final Boolean inDaylightTime() {
        SettingsEntity settingEntity2 = getSettingEntity();
        if (settingEntity2 != null) {
            return settingEntity2.getInDaylightTime();
        }
        return null;
    }

    public final void setInDaylightTime(boolean z) {
        SettingsEntity settingEntity2 = getSettingEntity();
        if (!(settingEntity2 != null ? Intrinsics.areEqual((Object) Boolean.valueOf(z), (Object) settingEntity2.getInDaylightTime()) : false)) {
            SettingsEntity settingEntity3 = getSettingEntity();
            if (settingEntity3 != null) {
                settingEntity3.setInDaylightTime(Boolean.valueOf(z));
            }
            saveSetting(getSettingEntity());
        }
    }

    public final String getTimezone() {
        SettingsEntity settingEntity2 = getSettingEntity();
        if (settingEntity2 != null) {
            return settingEntity2.getTimeZone();
        }
        return null;
    }

    public final void setTimezone(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        SettingsEntity settingEntity2 = getSettingEntity();
        if (!Intrinsics.areEqual((Object) str, (Object) settingEntity2 != null ? settingEntity2.getTimeZone() : null)) {
            SettingsEntity settingEntity3 = getSettingEntity();
            if (settingEntity3 != null) {
                settingEntity3.setTimeZone(str);
            }
            saveSetting(getSettingEntity());
        }
    }

    public final void saveSetting(SettingsEntity settingsEntity) {
        if (settingsEntity != null) {
            settingsEntity.setVersion(settingsEntity.getVersion() + 1);
            MmkvManager.INSTANCE.saveSettings(settingsEntity);
        }
    }

    public final void setLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "lang");
        SettingsEntity settingEntity2 = getSettingEntity();
        if (!Intrinsics.areEqual((Object) str, (Object) settingEntity2 != null ? settingEntity2.getLanguage() : null)) {
            SettingsEntity settingEntity3 = getSettingEntity();
            if (settingEntity3 != null) {
                settingEntity3.setLanguage(str);
            }
            saveSetting(getSettingEntity());
        }
    }

    public final void setUnit(int i) {
        SettingsEntity settingEntity2 = getSettingEntity();
        if (settingEntity2 == null || i != settingEntity2.getUnit()) {
            SettingsEntity settingEntity3 = getSettingEntity();
            if (settingEntity3 != null) {
                settingEntity3.setUnit(i);
            }
            saveSetting(getSettingEntity());
        }
    }

    public final void setTheme(int i) {
        SettingsEntity settingEntity2 = getSettingEntity();
        if (settingEntity2 == null || i != settingEntity2.getTheme()) {
            SettingsEntity settingEntity3 = getSettingEntity();
            if (settingEntity3 != null) {
                settingEntity3.setTheme(i);
            }
            saveSetting(getSettingEntity());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object uploadSettings(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.microtech.aidexx.ui.setting.SettingsManager$uploadSettings$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.microtech.aidexx.ui.setting.SettingsManager$uploadSettings$1 r0 = (com.microtech.aidexx.ui.setting.SettingsManager$uploadSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.setting.SettingsManager$uploadSettings$1 r0 = new com.microtech.aidexx.ui.setting.SettingsManager$uploadSettings$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.db.entity.SettingsEntity r0 = (com.microtech.aidexx.db.entity.SettingsEntity) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0079
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            com.microtech.aidexx.db.entity.SettingsEntity r9 = r8.getSettingEntity()
            if (r9 == 0) goto L_0x00d1
            int r2 = r9.getVersion()
            if (r2 <= 0) goto L_0x00d1
            java.lang.String r2 = r9.getUserSettingId()
            if (r2 == 0) goto L_0x00d1
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            java.lang.String r2 = r2.toJson((java.lang.Object) r9)
            okhttp3.RequestBody$Companion r4 = okhttp3.RequestBody.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            okhttp3.MediaType$Companion r5 = okhttp3.MediaType.Companion
            java.lang.String r6 = "application/json"
            okhttp3.MediaType r5 = r5.get(r6)
            okhttp3.RequestBody r2 = r4.create((java.lang.String) r2, (okhttp3.MediaType) r5)
            com.microtech.aidexx.common.net.ApiService$Companion r4 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r4 = r4.getInstance()
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r0 = r4.uploadSetting(r2, r0)
            if (r0 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r7 = r0
            r0 = r9
            r9 = r7
        L_0x0079:
            com.microtech.aidexx.common.net.ApiResult r9 = (com.microtech.aidexx.common.net.ApiResult) r9
            boolean r1 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r1 == 0) goto L_0x00b3
            int r9 = r0.getVersion()
            com.microtech.aidexx.ui.setting.SettingsManager r1 = INSTANCE
            com.microtech.aidexx.db.entity.SettingsEntity r1 = r1.getSettingEntity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getVersion()
            if (r9 != r1) goto L_0x00d1
            r9 = 0
            r0.setVersion(r9)
            com.microtech.aidexx.utils.mmkv.MmkvManager r9 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r1 = r0
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            r9.saveSettings(r1)
            com.microtech.aidexx.utils.LogUtil$Companion r9 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Settings upload success:"
            r1.<init>(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r9.eAiDEX(r0)
            goto L_0x00d1
        L_0x00b3:
            boolean r0 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r0 == 0) goto L_0x00d1
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Settings upload fail:"
            r1.<init>(r2)
            com.microtech.aidexx.common.net.ApiResult$Failure r9 = (com.microtech.aidexx.common.net.ApiResult.Failure) r9
            java.lang.String r9 = r9.getMsg()
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r9 = r9.toString()
            r0.eAiDEX(r9)
        L_0x00d1:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.SettingsManager.uploadSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadSettings(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ui.setting.SettingsManager$downloadSettings$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ui.setting.SettingsManager$downloadSettings$1 r0 = (com.microtech.aidexx.ui.setting.SettingsManager$downloadSettings$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.setting.SettingsManager$downloadSettings$1 r0 = new com.microtech.aidexx.ui.setting.SettingsManager$downloadSettings$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0059
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r6 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r6 = r6.instance()
            java.lang.String r6 = r6.userId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r5)
            if (r6 != 0) goto L_0x004a
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L_0x004a:
            com.microtech.aidexx.common.net.ApiService$Companion r6 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r6 = r6.getInstance()
            r0.label = r3
            java.lang.Object r6 = r6.downloadSetting(r5, r0)
            if (r6 != r1) goto L_0x0059
            return r1
        L_0x0059:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r5 == 0) goto L_0x0087
            com.microtech.aidexx.common.net.ApiResult$Success r6 = (com.microtech.aidexx.common.net.ApiResult.Success) r6
            java.lang.Object r5 = r6.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r5 = (com.microtech.aidexx.common.net.entity.BaseResponse) r5
            java.lang.Object r5 = r5.getData()
            com.microtech.aidexx.db.entity.SettingsEntity r5 = (com.microtech.aidexx.db.entity.SettingsEntity) r5
            if (r5 == 0) goto L_0x0082
            int r6 = r5.getTheme()
            r0 = 2
            if (r6 != r0) goto L_0x0079
            r5.setTheme(r3)
        L_0x0079:
            settingEntity = r5
            com.microtech.aidexx.utils.mmkv.MmkvManager r6 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            android.os.Parcelable r5 = (android.os.Parcelable) r5
            r6.saveSettings(r5)
        L_0x0082:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L_0x0087:
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r5 == 0) goto L_0x00a5
            com.microtech.aidexx.utils.LogUtil$Companion r5 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Settings upload fail:"
            r0.<init>(r1)
            com.microtech.aidexx.common.net.ApiResult$Failure r6 = (com.microtech.aidexx.common.net.ApiResult.Failure) r6
            java.lang.String r6 = r6.getMsg()
            java.lang.StringBuilder r6 = r0.append(r6)
            java.lang.String r6 = r6.toString()
            r5.eAiDEX(r6)
        L_0x00a5:
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.SettingsManager.downloadSettings(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
