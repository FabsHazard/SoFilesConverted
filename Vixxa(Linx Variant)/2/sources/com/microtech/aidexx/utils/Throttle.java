package com.microtech.aidexx.utils;

import android.os.SystemClock;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rR*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/utils/Throttle;", "", "()V", "lastTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "emit", "", "thresholdMillis", "requestCode", "callBack", "Lkotlin/Function0;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Throttle.kt */
public final class Throttle {
    public static final int ANTI_FAST_RESUME = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int ON_BLUETOOTH_STATE_CHANGE = 2;
    public static final int ON_TIME_CHANGE = 1;
    /* access modifiers changed from: private */
    public static Throttle instance;
    private HashMap<Integer, Long> lastTimeMap;

    public /* synthetic */ Throttle(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Throttle() {
        this.lastTimeMap = new HashMap<>();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/utils/Throttle$Companion;", "", "()V", "ANTI_FAST_RESUME", "", "ON_BLUETOOTH_STATE_CHANGE", "ON_TIME_CHANGE", "instance", "Lcom/microtech/aidexx/utils/Throttle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Throttle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized Throttle instance() {
            Throttle access$getInstance$cp;
            if (Throttle.instance == null) {
                Throttle.instance = new Throttle((DefaultConstructorMarker) null);
            }
            access$getInstance$cp = Throttle.instance;
            Intrinsics.checkNotNull(access$getInstance$cp);
            return access$getInstance$cp;
        }
    }

    public final void emit(long j, int i, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callBack");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastTimeMap.get(Integer.valueOf(i)) != null) {
            Long l = this.lastTimeMap.get(Integer.valueOf(i));
            Intrinsics.checkNotNull(l);
            if (elapsedRealtime - l.longValue() >= j) {
                function0.invoke();
                this.lastTimeMap.put(Integer.valueOf(i), Long.valueOf(elapsedRealtime));
                return;
            }
            return;
        }
        function0.invoke();
        this.lastTimeMap.put(Integer.valueOf(i), Long.valueOf(elapsedRealtime));
    }
}
