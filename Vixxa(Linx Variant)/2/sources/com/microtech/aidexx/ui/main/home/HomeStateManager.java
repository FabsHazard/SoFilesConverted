package com.microtech.aidexx.ui.main.home;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.work.PeriodicWorkRequest;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeStateManager;", "", "()V", "currentState", "", "handler", "Landroid/os/Handler;", "timeLeft", "", "Ljava/lang/Integer;", "timer", "Ljava/util/Timer;", "cancel", "", "countDownToReset", "getCurrentState", "resetState", "tag", "setState", "setWarmingUpTimeLeft", "time", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeStateManager.kt */
public final class HomeStateManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static HomeStateManager homeStateManager;
    /* access modifiers changed from: private */
    public static Function1<? super String, Unit> onHomeStateChange;
    /* access modifiers changed from: private */
    public static Function1<? super Integer, Unit> onWarmingUpTimeLeftListener;
    private String currentState;
    private final Handler handler;
    private Integer timeLeft;
    private Timer timer;

    public /* synthetic */ HomeStateManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private HomeStateManager() {
        this.currentState = HomeFragmentKt.glucosePanel;
        this.handler = new Handler(this, Looper.getMainLooper()) {
            final /* synthetic */ HomeStateManager this$0;

            {
                this.this$0 = r1;
            }

            public void handleMessage(Message message) {
                Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
                if (message.what == 110) {
                    this.this$0.resetState(HomeFragmentKt.glucosePanel);
                    HomeStateManager.Companion.setOnWarmingUpTimeLeftListener((Function1<? super Integer, Unit>) null);
                }
            }
        };
    }

    public final String getCurrentState() {
        return this.currentState;
    }

    public final void resetState(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.currentState = str;
        Function1<? super String, Unit> function1 = onHomeStateChange;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR9\u0010\u0010\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeStateManager$Companion;", "", "()V", "homeStateManager", "Lcom/microtech/aidexx/ui/main/home/HomeStateManager;", "onHomeStateChange", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "tag", "", "getOnHomeStateChange", "()Lkotlin/jvm/functions/Function1;", "setOnHomeStateChange", "(Lkotlin/jvm/functions/Function1;)V", "onWarmingUpTimeLeftListener", "", "timeLeft", "getOnWarmingUpTimeLeftListener", "setOnWarmingUpTimeLeftListener", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HomeStateManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function1<Integer, Unit> getOnWarmingUpTimeLeftListener() {
            return HomeStateManager.onWarmingUpTimeLeftListener;
        }

        public final void setOnWarmingUpTimeLeftListener(Function1<? super Integer, Unit> function1) {
            HomeStateManager.onWarmingUpTimeLeftListener = function1;
        }

        public final Function1<String, Unit> getOnHomeStateChange() {
            return HomeStateManager.onHomeStateChange;
        }

        public final void setOnHomeStateChange(Function1<? super String, Unit> function1) {
            HomeStateManager.onHomeStateChange = function1;
        }

        public final synchronized HomeStateManager instance() {
            HomeStateManager access$getHomeStateManager$cp;
            if (HomeStateManager.homeStateManager == null) {
                HomeStateManager.homeStateManager = new HomeStateManager((DefaultConstructorMarker) null);
            }
            access$getHomeStateManager$cp = HomeStateManager.homeStateManager;
            Intrinsics.checkNotNull(access$getHomeStateManager$cp);
            return access$getHomeStateManager$cp;
        }
    }

    public final void setState(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        LogUtil.Companion.eAiDEX("Set home states --> " + str);
        if (!Intrinsics.areEqual((Object) str, (Object) HomeFragmentKt.glucosePanel)) {
            EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, false);
        }
        if (!Intrinsics.areEqual((Object) str, (Object) HomeFragmentKt.needPair) && !Intrinsics.areEqual((Object) str, (Object) HomeFragmentKt.glucosePanel)) {
            countDownToReset();
        }
        if (Intrinsics.areEqual((Object) str, (Object) HomeFragmentKt.warmingUp)) {
            this.timeLeft = null;
        }
        this.currentState = str;
        Function1<? super String, Unit> function1 = onHomeStateChange;
        if (function1 != null) {
            function1.invoke(str);
        }
    }

    public final void setWarmingUpTimeLeft(int i) {
        Integer num = this.timeLeft;
        if (num == null || num.intValue() != i) {
            Integer valueOf = Integer.valueOf(i);
            this.timeLeft = valueOf;
            Function1<? super Integer, Unit> function1 = onWarmingUpTimeLeftListener;
            if (function1 != null) {
                function1.invoke(valueOf);
            }
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_WARMING_UP_TIME_LEFT, this.timeLeft);
        }
    }

    private final synchronized void countDownToReset() {
        this.handler.removeMessages(110);
        this.handler.sendEmptyMessageDelayed(110, PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
    }

    public final void cancel() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        this.timer = null;
        onHomeStateChange = null;
        this.handler.removeCallbacksAndMessages((Object) null);
    }
}
