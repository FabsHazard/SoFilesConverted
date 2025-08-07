package com.microtech.aidexx.ui.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.widget.RemoteViews;
import com.microtech.aidexx.AidexxAppKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.UnitManager;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/ui/widget/AidexWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "()V", "onUpdate", "", "context", "Landroid/content/Context;", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AidexWidgetProvider.kt */
public final class AidexWidgetProvider extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        PackageManager packageManager;
        super.onUpdate(context, appWidgetManager, iArr);
        Intent intent = null;
        RemoteViews remoteViews = new RemoteViews(context != null ? context.getPackageName() : null, R.layout.layout_aidex_widget);
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        String str = "--";
        if (deviceModel == null || !deviceModel.isPaired() || !deviceModel.isDataValid() || !deviceModel.getMalFunctionList().isEmpty() || !UserInfoManager.Companion.instance().isLogin()) {
            remoteViews.setTextViewText(R.id.widget_glucose_value, str);
            remoteViews.setTextViewText(R.id.widget_unit, UnitManager.INSTANCE.getDisplayUnit());
            remoteViews.setTextViewText(R.id.widget_update_time, str);
            remoteViews.setImageViewResource(R.id.iv_widget_bg, R.drawable.bg_widget_white);
            remoteViews.setImageViewResource(R.id.widget_trend, 0);
        } else {
            if (context != null) {
                int i = R.id.widget_glucose_value;
                Float glucose = deviceModel.getGlucose();
                if (glucose != null) {
                    float floatValue = glucose.floatValue();
                    Resources resources = context.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                    String glucoseStringWithLowAndHigh = GlucoseUtilKt.toGlucoseStringWithLowAndHigh(floatValue, resources);
                    if (glucoseStringWithLowAndHigh != null) {
                        str = glucoseStringWithLowAndHigh;
                    }
                }
                remoteViews.setTextViewText(i, str);
                remoteViews.setTextViewText(R.id.widget_unit, UnitManager.INSTANCE.getDisplayUnit());
                WidgetUpdateManager.Companion.instance().updateBgAndTrend(remoteViews);
            }
            remoteViews.setTextViewText(R.id.widget_update_time, TimeUtils.dateHourMinute$default(TimeUtils.INSTANCE, new Date(), (String) null, 1, (Object) null));
        }
        if (!(context == null || (packageManager = context.getPackageManager()) == null)) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                packageName = AidexxAppKt.APP_DEFAULT_PACKAGE_NAME;
            }
            intent = packageManager.getLaunchIntentForPackage(packageName);
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        remoteViews.setOnClickPendingIntent(R.id.widget_root, activity);
        if (appWidgetManager != null) {
            appWidgetManager.updateAppWidget(iArr, remoteViews);
        }
    }
}
