package com.microtech.aidexx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.microtech.aidexx.utils.Throttle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/service/BtStateChangeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "register", "unregister", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BtStateChangeReceiver.kt */
public final class BtStateChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Throttle.Companion.instance().emit(500, 2, new BtStateChangeReceiver$onReceive$1(intent));
    }

    public final void register(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            if (context != null) {
                context.registerReceiver(this, intentFilter, 4);
            }
        } else if (context != null) {
            context.registerReceiver(this, intentFilter);
        }
    }

    public final void unregister(Context context) {
        if (context != null) {
            context.unregisterReceiver(this);
        }
    }
}
