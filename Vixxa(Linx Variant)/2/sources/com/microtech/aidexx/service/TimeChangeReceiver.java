package com.microtech.aidexx.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.microtech.aidexx.utils.Throttle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/service/TimeChangeReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeChangeReceiver.kt */
public final class TimeChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Throttle.Companion.instance().emit(3000, 1, new TimeChangeReceiver$onReceive$1(intent));
    }
}
