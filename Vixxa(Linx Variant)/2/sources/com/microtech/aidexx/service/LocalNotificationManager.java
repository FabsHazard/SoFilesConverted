package com.microtech.aidexx.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import android.widget.RemoteViews;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.microtech.aidexx.AidexxAppKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.ContextUtil;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0002J \u0010\u0019\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007J \u0010 \u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\bH\u0007J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020$J\u0016\u0010%\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/microtech/aidexx/service/LocalNotificationManager;", "", "()V", "alertChannelId", "", "foregroundChannelId", "notificationIds", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "buildNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "view", "Landroid/widget/RemoteViews;", "cancelAllNotification", "", "cancelLocalNotifications", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cancelNotification", "id", "clearIds", "createNotificationPendingIntent", "Landroid/app/PendingIntent;", "generateAlertNotification", "content", "isSummary", "", "getNotificationManager", "Landroid/app/NotificationManager;", "initNotificationChannel", "notificationAlert", "type", "rememberNotificationId", "startForeground", "Landroid/app/Service;", "updateNotification", "normal", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocalNotificationManager.kt */
public final class LocalNotificationManager {
    public static final LocalNotificationManager INSTANCE = new LocalNotificationManager();
    private static final String alertChannelId = "com.microtech.aidexx.alert";
    private static final String foregroundChannelId = "com.microtech.aidexx.foreground";
    /* access modifiers changed from: private */
    public static CopyOnWriteArrayList<Integer> notificationIds = new CopyOnWriteArrayList<>();

    private LocalNotificationManager() {
    }

    public final void notificationAlert(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "content");
        Notification generateAlertNotification = generateAlertNotification(context, str, false);
        if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            int millisToIntSeconds = ExtendsKt.millisToIntSeconds(SystemClock.elapsedRealtime());
            if (notificationIds.isEmpty()) {
                int i2 = millisToIntSeconds - 1;
                NotificationManagerCompat.from(context).notify(i2, generateAlertNotification(context, str, true));
                rememberNotificationId(i2);
            }
            NotificationManagerCompat.from(context).notify(millisToIntSeconds, generateAlertNotification);
            rememberNotificationId(millisToIntSeconds);
            return;
        }
        NotificationManagerCompat.from(context).notify(i, generateAlertNotification);
    }

    private final Notification generateAlertNotification(Context context, String str, boolean z) {
        Notification build = new NotificationCompat.Builder(context, alertChannelId).setContentTitle(context.getString(R.string.app_name)).setContentText(str).setCategory(NotificationCompat.CATEGORY_MESSAGE).setVisibility(1).setSmallIcon(R.drawable.ic_alert).setGroup("alert").setGroupSummary(z).setContentIntent(createNotificationPendingIntent(context)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final void rememberNotificationId(int i) {
        notificationIds.add(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public final void clearIds() {
        notificationIds.clear();
    }

    public final void initNotificationChannel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationChannel notificationChannel = new NotificationChannel(foregroundChannelId, context.getString(R.string.title_notification_foreground), 4);
        notificationChannel.setShowBadge(false);
        getNotificationManager(context).createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel(alertChannelId, context.getString(R.string.noti_warning), 4);
        notificationChannel2.setShowBadge(false);
        getNotificationManager(context).createNotificationChannel(notificationChannel2);
    }

    private final NotificationManager getNotificationManager(Context context) {
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        return (NotificationManager) systemService;
    }

    private final PendingIntent createNotificationPendingIntent(Context context) {
        Intent intent;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                packageName = AidexxAppKt.APP_DEFAULT_PACKAGE_NAME;
            }
            intent = packageManager.getLaunchIntentForPackage(packageName);
        } else {
            intent = null;
        }
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return activity;
    }

    public final void startForeground(Service service) {
        Intrinsics.checkNotNullParameter(service, "context");
        Context context = service;
        Notification buildNotification = buildNotification(context, new ForegroundServiceNotification(context, createNotificationPendingIntent(context), service.getPackageName()));
        if (Build.VERSION.SDK_INT < 33) {
            service.startForeground(10010, buildNotification);
        } else if (ActivityCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0) {
            service.startForeground(10010, buildNotification, 16);
        }
    }

    private final Notification buildNotification(Context context, RemoteViews remoteViews) {
        Notification build = new NotificationCompat.Builder(context, foregroundChannelId).setCustomContentView(remoteViews).setCustomBigContentView(remoteViews).setOnlyAlertOnce(true).setOngoing(true).setPriority(1).setSmallIcon(R.drawable.ic_small_icon).setVisibility(1).setShowWhen(false).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public final void updateNotification(Context context, boolean z) {
        Float f;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        ForegroundServiceNotification foregroundServiceNotification = new ForegroundServiceNotification(context, createNotificationPendingIntent(context), context.getPackageName());
        String string = context.getString(R.string.com_unknown);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (deviceModel == null || !deviceModel.isDataValid() || !z) {
            f = null;
        } else {
            Integer minutesAgo = deviceModel.getMinutesAgo();
            if (minutesAgo != null && minutesAgo.intValue() == 0) {
                str = ContextUtil.Companion.getResources().getString(R.string.com_time_ago_justNow);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            } else {
                str = ContextUtil.Companion.getResources().getString(R.string.com_time_ago_minute, new Object[]{String.valueOf(deviceModel.getMinutesAgo())});
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            }
            string = str;
            f = deviceModel.getGlucose();
        }
        foregroundServiceNotification.setGlucose(string, f);
        getNotificationManager(context).notify(10010, buildNotification(context, foregroundServiceNotification));
    }

    public final void cancelAllNotification(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getNotificationManager(context).cancelAll();
        notificationIds.clear();
    }

    public final void cancelNotification(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        getNotificationManager(context).cancel(i);
    }

    public final void cancelLocalNotifications(Context context, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        if (!notificationIds.isEmpty()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new LocalNotificationManager$cancelLocalNotifications$1(context, (Continuation<? super LocalNotificationManager$cancelLocalNotifications$1>) null), 2, (Object) null);
        }
    }
}
