package com.microtech.aidexx.utils.eventbus;

import androidx.lifecycle.LifecycleOwner;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Je\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0002\u0010\u0011J?\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\u0012J!\u0010\u0014\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u0002H\u00052\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/utils/eventbus/EventBusManager;", "", "()V", "onReceive", "", "T", "keys", "", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "data", "([Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "it", "send", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "sendDelay", "delay", "", "(Ljava/lang/String;Ljava/lang/Object;J)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventBusManager.kt */
public final class EventBusManager {
    public static final EventBusManager INSTANCE = new EventBusManager();

    private EventBusManager() {
    }

    public final <T> void send(String str, T t) {
        Intrinsics.checkNotNullParameter(str, "key");
        LiveEventBus.get(str).post(t);
    }

    public final <T> void sendDelay(String str, T t, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        LiveEventBus.get(str).postDelay(t, j);
    }

    public final <T> void onReceive(String[] strArr, LifecycleOwner lifecycleOwner, Function2<? super String, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(strArr, "keys");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function2, "callback");
        for (String str : strArr) {
            LiveEventBus.get(str).observe(lifecycleOwner, new EventBusManager$$ExternalSyntheticLambda1(function2, str));
        }
    }

    /* access modifiers changed from: private */
    public static final void onReceive$lambda$0(Function2 function2, String str, Object obj) {
        Intrinsics.checkNotNullParameter(function2, "$callback");
        Intrinsics.checkNotNullParameter(str, "$key");
        function2.invoke(str, obj);
    }

    public final <T> void onReceive(String str, LifecycleOwner lifecycleOwner, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "callback");
        LiveEventBus.get(str).observe(lifecycleOwner, new EventBusManager$$ExternalSyntheticLambda0(function1));
    }

    /* access modifiers changed from: private */
    public static final void onReceive$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$callback");
        function1.invoke(obj);
    }
}
