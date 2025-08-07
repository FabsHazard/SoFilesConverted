package com.microtech.aidexx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.igexin.sdk.PushConsts;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/service/BootReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BootReceiver.kt */
public final class BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (MmkvManager.INSTANCE.isAgreeProtocol()) {
            LogUtil.Companion.eAiDEX("start main service after boot onReceive");
            if (!Intrinsics.areEqual((Object) intent.getAction(), (Object) PushConsts.ACTION_BROADCAST_TO_BOOT) && !Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.intent.action.REBOOT")) {
                return;
            }
            if (!ActivityUtil.INSTANCE.isServiceRunning(context, MainService.class)) {
                Intent intent2 = new Intent(context, MainService.class);
                if (Build.VERSION.SDK_INT >= 33) {
                    if (ActivityCompat.checkSelfPermission(context, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        intent2.setAction("START_FOREGROUND");
                        context.startForegroundService(intent2);
                    } else {
                        intent2.setAction("NOT_START_FOREGROUND");
                        context.startService(intent2);
                    }
                } else if (Build.VERSION.SDK_INT >= 26) {
                    intent2.setAction("START_FOREGROUND");
                    context.startForegroundService(intent2);
                } else {
                    intent2.setAction("START_FOREGROUND");
                    context.startService(intent2);
                }
                LogUtil.Companion.eAiDEX("start main service after boot");
                return;
            }
            LogUtil.Companion.eAiDEX("main service is running, need not start");
            return;
        }
        LogUtil.Companion.eAiDEX("user disagree to protocol,can't start service after boot");
    }
}
