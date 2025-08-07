package com.microtech.aidexx.utils;

import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.ui.setting.alert.AlertUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/utils/ThresholdManager;", "", "()V", "DEFAULT_HYPER", "", "DEFAULT_HYPO", "FAST_DOWN", "", "FAST_UP", "GLUCOSE_LOW_LIMIT", "GLUCOSE_UP_LIMIT", "SLOW_DOWN", "SLOW_UP", "SUPER_FAST_DOWN", "SUPER_FAST_UP", "URGENT_HYPO", "value", "hyper", "getHyper", "()F", "setHyper", "(F)V", "hypo", "getHypo", "setHypo", "getCurUserHyper", "getCurUserHypo", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ThresholdManager.kt */
public final class ThresholdManager {
    public static final float DEFAULT_HYPER = 180.0f;
    public static final float DEFAULT_HYPO = 70.200005f;
    public static final double FAST_DOWN = -0.11d;
    public static final double FAST_UP = 0.11d;
    public static final float GLUCOSE_LOW_LIMIT = 36.0f;
    public static final float GLUCOSE_UP_LIMIT = 450.0f;
    public static final ThresholdManager INSTANCE = new ThresholdManager();
    public static final double SLOW_DOWN = -0.06d;
    public static final double SLOW_UP = 0.06d;
    public static final double SUPER_FAST_DOWN = -0.17d;
    public static final double SUPER_FAST_UP = 0.17d;
    public static final float URGENT_HYPO = 54.0f;
    private static float hyper = 180.0f;
    private static float hypo = 70.200005f;

    private ThresholdManager() {
    }

    public final void setHyper(float f) {
        if (f != hyper) {
            AlertUtil.INSTANCE.setHyperThreshold(f);
            SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
            Intrinsics.checkNotNull(settingEntity);
            settingEntity.setHighLimitMg(f);
        }
    }

    public final float getHyper() {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        float highLimitMg = settingEntity.getHighLimitMg();
        hyper = highLimitMg;
        return highLimitMg;
    }

    public final void setHypo(float f) {
        if (f != hypo) {
            AlertUtil.INSTANCE.setHypoThreshold(f);
            SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
            Intrinsics.checkNotNull(settingEntity);
            settingEntity.setLowLimitMg(f);
        }
    }

    public final float getHypo() {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        float lowLimitMg = settingEntity.getLowLimitMg();
        hypo = lowLimitMg;
        return lowLimitMg;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getUserSetting();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float getCurUserHyper() {
        /*
            r1 = this;
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r0 = r0.getShareUserInfo()
            if (r0 == 0) goto L_0x0013
            com.microtech.aidexx.db.entity.SettingsEntity r0 = r0.getUserSetting()
            if (r0 == 0) goto L_0x0013
            float r0 = r0.getHighLimitMg()
            goto L_0x0017
        L_0x0013:
            float r0 = r1.getHyper()
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.ThresholdManager.getCurUserHyper():float");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getUserSetting();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final float getCurUserHypo() {
        /*
            r1 = this;
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r0 = r0.getShareUserInfo()
            if (r0 == 0) goto L_0x0013
            com.microtech.aidexx.db.entity.SettingsEntity r0 = r0.getUserSetting()
            if (r0 == 0) goto L_0x0013
            float r0 = r0.getLowLimitMg()
            goto L_0x0017
        L_0x0013:
            float r0 = r1.getHypo()
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.ThresholdManager.getCurUserHypo():float");
    }
}
