package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R7\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeBackGroundSelector;", "", "()V", "onLevelChange", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "res", "", "getOnLevelChange", "()Lkotlin/jvm/functions/Function1;", "setOnLevelChange", "(Lkotlin/jvm/functions/Function1;)V", "getBgForTrend", "trend", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseTrend;", "level", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "getHomeBg", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeBackGroundSelector.kt */
public final class HomeBackGroundSelector {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final HomeBackGroundSelector INSTANCE = new HomeBackGroundSelector();
    private Function1<? super Integer, Unit> onLevelChange;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HomeBackGroundSelector.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0055 */
        static {
            /*
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel[] r0 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r2 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.HIGH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r3 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.LOW     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r4 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.NORMAL     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend[] r0 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r4 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.FAST_UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.FAST_FALL     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.UP     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.FALL     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.SLOW_UP     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.SLOW_FALL     // Catch:{ NoSuchFieldError -> 0x005e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.HomeBackGroundSelector.WhenMappings.<clinit>():void");
        }
    }

    private HomeBackGroundSelector() {
    }

    public final Function1<Integer, Unit> getOnLevelChange() {
        return this.onLevelChange;
    }

    public final void setOnLevelChange(Function1<? super Integer, Unit> function1) {
        this.onLevelChange = function1;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeBackGroundSelector$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/ui/main/home/HomeBackGroundSelector;", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HomeBackGroundSelector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeBackGroundSelector instance() {
            return HomeBackGroundSelector.INSTANCE;
        }
    }

    public final int getBgForTrend(DeviceModel.GlucoseTrend glucoseTrend, DeviceModel.GlucoseLevel glucoseLevel) {
        int i;
        int i2 = -1;
        if (glucoseTrend == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$1[glucoseTrend.ordinal()];
        }
        switch (i) {
            case -1:
                int i3 = glucoseLevel == null ? -1 : WhenMappings.$EnumSwitchMapping$0[glucoseLevel.ordinal()];
                if (i3 != -1) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                throw new NoWhenBranchMatchedException();
                            } else if (ThemeManager.INSTANCE.isLight()) {
                                return R.drawable.unknow_blue_light;
                            } else {
                                return R.drawable.unknow_blue_dark;
                            }
                        } else if (ThemeManager.INSTANCE.isLight()) {
                            return R.drawable.unknow_red_light;
                        } else {
                            return R.drawable.unknow_red_dark;
                        }
                    } else if (ThemeManager.INSTANCE.isLight()) {
                        return R.drawable.unknow_yellow_light;
                    } else {
                        return R.drawable.unknow_yellow_dark;
                    }
                } else if (ThemeManager.INSTANCE.isLight()) {
                    return R.drawable.bg_panel_blank_light;
                } else {
                    return R.drawable.bg_panel_blank_dark;
                }
            case 1:
            case 2:
                if (glucoseLevel != null) {
                    i2 = WhenMappings.$EnumSwitchMapping$0[glucoseLevel.ordinal()];
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (ThemeManager.INSTANCE.isLight()) {
                            return R.drawable.super_trends_blue_light;
                        }
                        return R.drawable.super_trends_blue_dark;
                    } else if (ThemeManager.INSTANCE.isLight()) {
                        return R.drawable.super_trends_red_light;
                    } else {
                        return R.drawable.super_trends_red_dark;
                    }
                } else if (ThemeManager.INSTANCE.isLight()) {
                    return R.drawable.super_trends_yellow_light;
                } else {
                    return R.drawable.super_trends_yellow_dark;
                }
            case 3:
            case 4:
                if (glucoseLevel != null) {
                    i2 = WhenMappings.$EnumSwitchMapping$0[glucoseLevel.ordinal()];
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (ThemeManager.INSTANCE.isLight()) {
                            return R.drawable.trend_blue_light;
                        }
                        return R.drawable.trend_blue_dark;
                    } else if (ThemeManager.INSTANCE.isLight()) {
                        return R.drawable.trend_red_light;
                    } else {
                        return R.drawable.trend_red_dark;
                    }
                } else if (ThemeManager.INSTANCE.isLight()) {
                    return R.drawable.trend_yellow_light;
                } else {
                    return R.drawable.trend_yellow_dark;
                }
            case 5:
            case 6:
                if (glucoseLevel != null) {
                    i2 = WhenMappings.$EnumSwitchMapping$0[glucoseLevel.ordinal()];
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (ThemeManager.INSTANCE.isLight()) {
                            return R.drawable.trends_fast_blue_light;
                        }
                        return R.drawable.trends_fast_blue_dark;
                    } else if (ThemeManager.INSTANCE.isLight()) {
                        return R.drawable.trends_fast_red_light;
                    } else {
                        return R.drawable.trends_fast_red_dark;
                    }
                } else if (ThemeManager.INSTANCE.isLight()) {
                    return R.drawable.trends_fast_yellow_light;
                } else {
                    return R.drawable.trends_fast_yellow_dark;
                }
            default:
                if (glucoseLevel != null) {
                    i2 = WhenMappings.$EnumSwitchMapping$0[glucoseLevel.ordinal()];
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (ThemeManager.INSTANCE.isLight()) {
                            return R.drawable.trend_eq_blue_light;
                        }
                        return R.drawable.trend_eq_blue_dark;
                    } else if (ThemeManager.INSTANCE.isLight()) {
                        return R.drawable.trend_eq_red_light;
                    } else {
                        return R.drawable.trend_eq_red_dark;
                    }
                } else if (ThemeManager.INSTANCE.isLight()) {
                    return R.drawable.trend_eq_yellow_light;
                } else {
                    return R.drawable.trend_eq_yellow_dark;
                }
        }
    }

    public final void getHomeBg(DeviceModel.GlucoseLevel glucoseLevel) {
        int i;
        int i2;
        if (ThemeManager.INSTANCE.isLight()) {
            if (glucoseLevel == null) {
                i = -1;
            } else {
                i = WhenMappings.$EnumSwitchMapping$0[glucoseLevel.ordinal()];
            }
            if (i == 1) {
                i2 = R.drawable.bg_home_yellow;
            } else if (i == 2) {
                i2 = R.drawable.bg_home_red;
            } else if (i != 3) {
                i2 = 0;
            } else {
                i2 = R.drawable.bg_home_green;
            }
            Function1<? super Integer, Unit> function1 = this.onLevelChange;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i2));
            }
        }
    }
}
