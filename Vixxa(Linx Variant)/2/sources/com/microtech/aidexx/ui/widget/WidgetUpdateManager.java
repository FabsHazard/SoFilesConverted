package com.microtech.aidexx.ui.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.UnitManager;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/ui/widget/WidgetUpdateManager;", "", "()V", "update", "", "context", "Landroid/content/Context;", "updateBgAndTrend", "remoteViews", "Landroid/widget/RemoteViews;", "updateTrend", "level", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "trend", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseTrend;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: WidgetUpdateManager.kt */
public final class WidgetUpdateManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final WidgetUpdateManager INSTANCE = new WidgetUpdateManager();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: WidgetUpdateManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel[] r0 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.LOW     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.NORMAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseLevel.HIGH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.widget.WidgetUpdateManager.WhenMappings.<clinit>():void");
        }
    }

    private WidgetUpdateManager() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ui/widget/WidgetUpdateManager$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/ui/widget/WidgetUpdateManager;", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: WidgetUpdateManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WidgetUpdateManager instance() {
            return WidgetUpdateManager.INSTANCE;
        }
    }

    public final void updateBgAndTrend(RemoteViews remoteViews) {
        int i;
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        DeviceModel.GlucoseLevel glucoseLevel = null;
        DeviceModel.GlucoseTrend glucoseTrend = deviceModel != null ? deviceModel.getGlucoseTrend() : null;
        if (deviceModel != null) {
            glucoseLevel = deviceModel.getGlucoseLevel();
        }
        if (glucoseLevel == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[glucoseLevel.ordinal()];
        }
        if (i == 1) {
            remoteViews.setImageViewResource(R.id.iv_widget_bg, R.drawable.bg_widget_red);
        } else if (i == 2) {
            remoteViews.setImageViewResource(R.id.iv_widget_bg, R.drawable.bg_widget_green);
        } else if (i != 3) {
            remoteViews.setImageViewResource(R.id.iv_widget_bg, R.drawable.bg_widget_white);
        } else {
            remoteViews.setImageViewResource(R.id.iv_widget_bg, R.drawable.bg_widget_yellow);
        }
        if (glucoseLevel != null && glucoseTrend != null) {
            updateTrend(remoteViews, glucoseLevel, glucoseTrend);
        }
    }

    public final void updateTrend(RemoteViews remoteViews, DeviceModel.GlucoseLevel glucoseLevel, DeviceModel.GlucoseTrend glucoseTrend) {
        Intrinsics.checkNotNullParameter(remoteViews, "remoteViews");
        Intrinsics.checkNotNullParameter(glucoseLevel, "level");
        Intrinsics.checkNotNullParameter(glucoseTrend, "trend");
        if (glucoseLevel == DeviceModel.GlucoseLevel.LOW && glucoseTrend == DeviceModel.GlucoseTrend.FAST_FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t4_l);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.NORMAL && glucoseTrend == DeviceModel.GlucoseTrend.FAST_FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t4);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.HIGH && glucoseTrend == DeviceModel.GlucoseTrend.FAST_FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t4_h);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.LOW && glucoseTrend == DeviceModel.GlucoseTrend.FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t3_l);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.NORMAL && glucoseTrend == DeviceModel.GlucoseTrend.FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t3);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.HIGH && glucoseTrend == DeviceModel.GlucoseTrend.FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t3_h);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.LOW && glucoseTrend == DeviceModel.GlucoseTrend.SLOW_FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t2_l);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.NORMAL && glucoseTrend == DeviceModel.GlucoseTrend.SLOW_FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t2);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.HIGH && glucoseTrend == DeviceModel.GlucoseTrend.SLOW_FALL) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t2_h);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.LOW && glucoseTrend == DeviceModel.GlucoseTrend.SLOW_UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t5_l);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.NORMAL && glucoseTrend == DeviceModel.GlucoseTrend.SLOW_UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t5);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.HIGH && glucoseTrend == DeviceModel.GlucoseTrend.SLOW_UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t5_h);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.LOW && glucoseTrend == DeviceModel.GlucoseTrend.UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t7_l);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.NORMAL && glucoseTrend == DeviceModel.GlucoseTrend.UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t7);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.HIGH && glucoseTrend == DeviceModel.GlucoseTrend.UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t7_h);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.LOW && glucoseTrend == DeviceModel.GlucoseTrend.FAST_UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t6_l);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.NORMAL && glucoseTrend == DeviceModel.GlucoseTrend.FAST_UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t6);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.HIGH && glucoseTrend == DeviceModel.GlucoseTrend.FAST_UP) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t6_h);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.LOW && glucoseTrend == DeviceModel.GlucoseTrend.STEADY) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t1_l);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.NORMAL && glucoseTrend == DeviceModel.GlucoseTrend.STEADY) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t1);
        } else if (glucoseLevel == DeviceModel.GlucoseLevel.HIGH && glucoseTrend == DeviceModel.GlucoseTrend.STEADY) {
            remoteViews.setImageViewResource(R.id.widget_trend, R.drawable.ic_t1_h);
        } else {
            remoteViews.setImageViewResource(R.id.widget_trend, 0);
        }
    }

    public final void update(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        AppWidgetManager instance = AppWidgetManager.getInstance(context);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_aidex_widget);
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel == null || !deviceModel.isPaired() || !deviceModel.isDataValid() || !deviceModel.getMalFunctionList().isEmpty() || !UserInfoManager.Companion.instance().isLogin()) {
            remoteViews.setTextViewText(R.id.widget_glucose_value, "--");
            remoteViews.setTextViewText(R.id.widget_unit, "");
            remoteViews.setTextViewText(R.id.widget_update_time, "--");
            remoteViews.setImageViewResource(R.id.iv_widget_bg, R.drawable.bg_widget_white);
            remoteViews.setImageViewResource(R.id.widget_trend, 0);
        } else {
            int i = R.id.widget_glucose_value;
            Float glucose = deviceModel.getGlucose();
            if (glucose != null) {
                float floatValue = glucose.floatValue();
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                str = GlucoseUtilKt.toGlucoseStringWithLowAndHigh(floatValue, resources);
            } else {
                str = null;
            }
            remoteViews.setTextViewText(i, str);
            remoteViews.setTextViewText(R.id.widget_unit, UnitManager.INSTANCE.getDisplayUnit());
            updateBgAndTrend(remoteViews);
            remoteViews.setTextViewText(R.id.widget_update_time, TimeUtils.dateHourMinute$default(TimeUtils.INSTANCE, new Date(), (String) null, 1, (Object) null));
        }
        instance.updateAppWidget(new ComponentName(context, AidexWidgetProvider.class), remoteViews);
    }
}
