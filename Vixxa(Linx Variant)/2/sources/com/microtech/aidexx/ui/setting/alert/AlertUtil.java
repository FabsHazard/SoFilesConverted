package com.microtech.aidexx.ui.setting.alert;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u000e\u0010\u0007\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010#\u001a\u00020%J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010)\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010*\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010+\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010,\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0019J\u000e\u0010\u0012\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\fJ\u0016\u0010.\u001a\u00020\u00142\u000e\u0010/\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000300J\u0018\u00101\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000ej\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\u000fX.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u00062"}, d2 = {"Lcom/microtech/aidexx/ui/setting/alert/AlertUtil;", "", "()V", "alertFrequency", "", "getAlertFrequency", "()J", "setAlertFrequency", "(J)V", "mSoundPool", "Landroid/media/SoundPool;", "playingSound", "", "soundMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "urgentFrequency", "getUrgentFrequency", "setUrgentFrequency", "alert", "", "context", "Landroid/content/Context;", "index", "isUrgent", "", "init", "playSound", "sound", "rate", "setAlertMethod", "setFastDownEnable", "enable", "setFastUpEnable", "setHyperEnable", "value", "setHyperThreshold", "", "setHypoEnable", "setHypoThreshold", "setSignalLossEnable", "setSignalLossFrequency", "setSignalLossMethod", "setUrgentAlertMethod", "setUrgentEnable", "minutes", "stop", "activity", "Lcom/microtech/aidexx/base/BaseActivity;", "vibrate", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlertUtil.kt */
public final class AlertUtil {
    public static final AlertUtil INSTANCE = new AlertUtil();
    private static long alertFrequency = ExtendsKt.minutesToMillis(30);
    private static SoundPool mSoundPool;
    private static int playingSound = -1;
    private static HashMap<Integer, Integer> soundMap;
    private static long urgentFrequency = ExtendsKt.minutesToMillis(5);

    private AlertUtil() {
    }

    public final void setAlertFrequency(long j) {
        alertFrequency = j;
    }

    public final long getAlertFrequency() {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            alertFrequency = ExtendsKt.minutesToMillis(settingEntity.getAlertRate());
        }
        return alertFrequency;
    }

    public final void setUrgentFrequency(long j) {
        urgentFrequency = j;
    }

    public final long getUrgentFrequency() {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            urgentFrequency = ExtendsKt.minutesToMillis(settingEntity.getUrgentAlertRate());
        }
        return urgentFrequency;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        soundMap = new HashMap<>();
        SoundPool build = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(13).setContentType(4).build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        mSoundPool = build;
        HashMap<Integer, Integer> hashMap = soundMap;
        SoundPool soundPool = null;
        if (hashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soundMap");
            hashMap = null;
        }
        Map map = hashMap;
        SoundPool soundPool2 = mSoundPool;
        if (soundPool2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSoundPool");
            soundPool2 = null;
        }
        map.put(0, Integer.valueOf(soundPool2.load(context, R.raw.common_notice, 1)));
        HashMap<Integer, Integer> hashMap2 = soundMap;
        if (hashMap2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soundMap");
            hashMap2 = null;
        }
        Map map2 = hashMap2;
        SoundPool soundPool3 = mSoundPool;
        if (soundPool3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSoundPool");
        } else {
            soundPool = soundPool3;
        }
        map2.put(1, Integer.valueOf(soundPool.load(context, R.raw.urgent_notice, 1)));
    }

    private final void playSound(int i) {
        SoundPool soundPool;
        HashMap<Integer, Integer> hashMap = soundMap;
        if (hashMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("soundMap");
            hashMap = null;
        }
        Integer num = hashMap.get(Integer.valueOf(i));
        if (num != null) {
            SoundPool soundPool2 = mSoundPool;
            if (soundPool2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSoundPool");
                soundPool = null;
            } else {
                soundPool = soundPool2;
            }
            playingSound = soundPool.play(num.intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    public final void stop(BaseActivity<?, ?> baseActivity) {
        Intrinsics.checkNotNullParameter(baseActivity, "activity");
        if (playingSound != -1) {
            SoundPool soundPool = mSoundPool;
            if (soundPool == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSoundPool");
                soundPool = null;
            }
            soundPool.stop(playingSound);
        }
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = baseActivity.getSystemService("vibrator_manager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
            Vibrator defaultVibrator = ((VibratorManager) systemService).getDefaultVibrator();
            Intrinsics.checkNotNullExpressionValue(defaultVibrator, "getDefaultVibrator(...)");
            defaultVibrator.cancel();
            return;
        }
        Object systemService2 = baseActivity.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService2).cancel();
    }

    private final void vibrate(Context context, boolean z) {
        long[] jArr = z ? new long[]{0, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500} : new long[]{0, 500, 500, 500, 500};
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = context.getSystemService("vibrator_manager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
            Vibrator defaultVibrator = ((VibratorManager) systemService).getDefaultVibrator();
            Intrinsics.checkNotNullExpressionValue(defaultVibrator, "getDefaultVibrator(...)");
            defaultVibrator.vibrate(VibrationEffect.createWaveform(jArr, -1));
            return;
        }
        Object systemService2 = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService2).vibrate(jArr, -1);
    }

    public final void alert(Context context, int i, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (i == 0) {
            playSound(z ? 1 : 0);
        } else if (i == 1) {
            vibrate(context, z);
        } else if (i == 2) {
            AlertUtil alertUtil = INSTANCE;
            alertUtil.playSound(z);
            alertUtil.vibrate(context, z);
        }
    }

    public final void setAlertMethod(int i) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity == null || i != settingEntity.getAlertType()) {
            if (settingEntity != null) {
                settingEntity.setAlertType(i);
            }
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }

    public final void setAlertFrequency(int i) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity == null || i != settingEntity.getAlertRate()) {
            if (settingEntity != null) {
                settingEntity.setAlertRate(i);
            }
            alertFrequency = ExtendsKt.minutesToMillis(i);
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }

    public final void setHypoEnable(boolean z) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            settingEntity.setLowAlertSwitch(z ^ true ? 1 : 0);
        }
        SettingsManager.INSTANCE.saveSetting(settingEntity);
    }

    public final void setHypoThreshold(float f) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (!Intrinsics.areEqual(f, settingEntity != null ? Float.valueOf(settingEntity.getLowLimitMg()) : null)) {
            if (settingEntity != null) {
                settingEntity.setLowLimitMg(f);
            }
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }

    public final void setHyperEnable(boolean z) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            settingEntity.setHighAlertSwitch(z ^ true ? 1 : 0);
        }
        SettingsManager.INSTANCE.saveSetting(settingEntity);
    }

    public final void setHyperThreshold(float f) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (!Intrinsics.areEqual(f, settingEntity != null ? Float.valueOf(settingEntity.getHighLimitMg()) : null)) {
            if (settingEntity != null) {
                settingEntity.setHighLimitMg(f);
            }
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }

    public final void setFastUpEnable(boolean z) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            settingEntity.setFastUpSwitch(z ^ true ? 1 : 0);
        }
        SettingsManager.INSTANCE.saveSetting(settingEntity);
    }

    public final void setFastDownEnable(boolean z) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            settingEntity.setFastDownSwitch(z ^ true ? 1 : 0);
        }
        SettingsManager.INSTANCE.saveSetting(settingEntity);
    }

    public final void setUrgentEnable(boolean z) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            settingEntity.setUrgentLowAlertSwitch(z ^ true ? 1 : 0);
        }
        SettingsManager.INSTANCE.saveSetting(settingEntity);
    }

    public final void setUrgentAlertMethod(int i) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity == null || i != settingEntity.getUrgentAlertType()) {
            if (settingEntity != null) {
                settingEntity.setUrgentAlertType(i);
            }
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }

    public final void setUrgentFrequency(int i) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity == null || i != settingEntity.getUrgentAlertRate()) {
            if (settingEntity != null) {
                settingEntity.setUrgentAlertRate(i);
            }
            urgentFrequency = ExtendsKt.minutesToMillis(i);
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }

    public final void setSignalLossEnable(boolean z) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity != null) {
            settingEntity.setSignalMissingSwitch(z ^ true ? 1 : 0);
        }
        SettingsManager.INSTANCE.saveSetting(settingEntity);
    }

    public final void setSignalLossMethod(int i) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity == null || i != settingEntity.getSignalMissingAlertType()) {
            if (settingEntity != null) {
                settingEntity.setSignalMissingAlertType(i);
            }
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }

    public final void setSignalLossFrequency(int i) {
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (settingEntity == null || i != settingEntity.getSignalMissingAlertRate()) {
            if (settingEntity != null) {
                settingEntity.setSignalMissingAlertRate(i);
            }
            SettingsManager.INSTANCE.saveSetting(settingEntity);
        }
    }
}
