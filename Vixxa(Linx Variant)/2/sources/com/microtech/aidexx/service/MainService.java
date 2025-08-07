package com.microtech.aidexx.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import androidx.work.WorkRequest;
import com.igexin.sdk.PushConsts;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.ui.setting.alert.AlertUtil;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u001d\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u001bH\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\"\u00101\u001a\u0002022\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u000202H\u0016J\u0018\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u0002022\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u001bH\u0002J\u0006\u0010:\u001a\u00020\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R \u0010#\u001a\b\u0018\u00010$R\u00020%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006;"}, d2 = {"Lcom/microtech/aidexx/service/MainService;", "Landroid/app/Service;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "btStateChangeReceiver", "Lcom/microtech/aidexx/service/BtStateChangeReceiver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lockPendingIntent", "Landroid/app/PendingIntent;", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "mainServiceTask", "Ljava/util/TimerTask;", "mainServiceTimer", "Ljava/util/Timer;", "nextSignalLostCheckTime", "", "nextSignalLostDialogCheckTime", "onTransmitterChangeListener", "Lkotlin/Function1;", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "Lkotlin/ParameterName;", "name", "model", "", "serviceHandler", "com/microtech/aidexx/service/MainService$serviceHandler$1", "Lcom/microtech/aidexx/service/MainService$serviceHandler$1;", "serviceMainScope", "Lkotlinx/coroutines/CoroutineScope;", "timeChangeReceiver", "Lcom/microtech/aidexx/service/TimeChangeReceiver;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "getWakeLock", "()Landroid/os/PowerManager$WakeLock;", "setWakeLock", "(Landroid/os/PowerManager$WakeLock;)V", "observeAlert", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "process", "type", "isUrgent", "", "registerReceiver", "scheduleTask", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainService.kt */
public final class MainService extends Service implements LifecycleOwner {
    private BtStateChangeReceiver btStateChangeReceiver;
    private PendingIntent lockPendingIntent;
    private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    private TimerTask mainServiceTask;
    private Timer mainServiceTimer;
    /* access modifiers changed from: private */
    public long nextSignalLostCheckTime;
    /* access modifiers changed from: private */
    public long nextSignalLostDialogCheckTime;
    /* access modifiers changed from: private */
    public final Function1<DeviceModel, Unit> onTransmitterChangeListener = new MainService$onTransmitterChangeListener$1(this);
    private MainService$serviceHandler$1 serviceHandler = new MainService$serviceHandler$1(this, Looper.getMainLooper());
    /* access modifiers changed from: private */
    public CoroutineScope serviceMainScope;
    private TimeChangeReceiver timeChangeReceiver;
    private PowerManager.WakeLock wakeLock;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final PowerManager.WakeLock getWakeLock() {
        return this.wakeLock;
    }

    public final void setWakeLock(PowerManager.WakeLock wakeLock2) {
        this.wakeLock = wakeLock2;
    }

    public void onCreate() {
        super.onCreate();
        this.serviceMainScope = CoroutineScopeKt.MainScope();
        this.serviceHandler.sendEmptyMessage(PushConsts.ACTION_NOTIFICATION_CLICKED);
        this.serviceHandler.removeMessages(10011);
        this.serviceHandler.sendEmptyMessageDelayed(10011, 500);
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        if (Build.VERSION.SDK_INT >= 26) {
            LocalNotificationManager.INSTANCE.initNotificationChannel(this);
        }
        LifecycleOwner lifecycleOwner = this;
        EventBusManager.INSTANCE.onReceive(EventBusKey.UPDATE_NOTIFICATION, lifecycleOwner, new MainService$onCreate$1(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.RECEIVE_BROADCAST, lifecycleOwner, new MainService$onCreate$2(this));
    }

    public final void scheduleTask() {
        Timer timer = this.mainServiceTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mainServiceTask = new MainService$scheduleTask$1(new Ref.IntRef(), this);
        Timer timer2 = new Timer();
        this.mainServiceTimer = timer2;
        timer2.schedule(this.mainServiceTask, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MIN_BACKOFF_MILLIS);
    }

    /* access modifiers changed from: private */
    public final void registerReceiver() {
        this.timeChangeReceiver = new TimeChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        registerReceiver(this.timeChangeReceiver, intentFilter);
        BtStateChangeReceiver btStateChangeReceiver2 = new BtStateChangeReceiver();
        this.btStateChangeReceiver = btStateChangeReceiver2;
        btStateChangeReceiver2.register(this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            String action = intent.getAction();
            LogUtil.Companion.eAiDEX("onStartCommand intent!=null && action=" + action);
            if (Intrinsics.areEqual((Object) "START_FOREGROUND", (Object) action)) {
                LocalNotificationManager.INSTANCE.startForeground(this);
            }
        } else if (ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
            LogUtil.Companion.eAiDEX("onStartCommand intent==null && permission pass");
            LocalNotificationManager.INSTANCE.startForeground(this);
        } else {
            LogUtil.Companion.eAiDEX("onStartCommand intent==null && permission denied");
        }
        this.serviceHandler.removeMessages(10011);
        this.serviceHandler.sendEmptyMessageDelayed(10011, 500);
        return 1;
    }

    /* access modifiers changed from: private */
    public final void observeAlert(DeviceModel deviceModel) {
        deviceModel.setAlert(new MainService$observeAlert$1(this));
    }

    /* access modifiers changed from: private */
    public final void process(int i, boolean z) {
        if (i == 6) {
            SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
            Intrinsics.checkNotNull(settingEntity);
            AlertUtil.INSTANCE.alert(this, settingEntity.getSignalMissingAlertType() - 1, z);
        } else if (i != 7 && i != 8) {
            if (z) {
                SettingsEntity settingEntity2 = SettingsManager.INSTANCE.getSettingEntity();
                Intrinsics.checkNotNull(settingEntity2);
                AlertUtil.INSTANCE.alert(this, settingEntity2.getUrgentAlertType() - 1, true);
                return;
            }
            SettingsEntity settingEntity3 = SettingsManager.INSTANCE.getSettingEntity();
            Intrinsics.checkNotNull(settingEntity3);
            AlertUtil.INSTANCE.alert(this, settingEntity3.getAlertType() - 1, false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        TransmitterManager.Companion.removeOnTransmitterChangeListener(this.onTransmitterChangeListener);
        Context context = this;
        LocalNotificationManager.INSTANCE.cancelLocalNotifications(context, LifecycleOwnerKt.getLifecycleScope(this));
        this.serviceHandler.removeCallbacksAndMessages((Object) null);
        CoroutineScope coroutineScope = this.serviceMainScope;
        if (coroutineScope == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceMainScope");
            coroutineScope = null;
        }
        CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
        TimerTask timerTask = this.mainServiceTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        Timer timer = this.mainServiceTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        TimeChangeReceiver timeChangeReceiver2 = this.timeChangeReceiver;
        if (timeChangeReceiver2 != null) {
            unregisterReceiver(timeChangeReceiver2);
        }
        BtStateChangeReceiver btStateChangeReceiver2 = this.btStateChangeReceiver;
        if (btStateChangeReceiver2 != null) {
            btStateChangeReceiver2.unregister(context);
        }
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
        }
        LogUtil.Companion.eAiDEX("Main service stopped");
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }
}
