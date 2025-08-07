package com.microtech.aidexx.service;

import com.microtech.aidexx.ui.setting.SettingsManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeChangeReceiver.kt */
final class TimeChangeReceiver$onReceive$1$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isInDaylightTime;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimeChangeReceiver$onReceive$1$1$2(boolean z) {
        super(0);
        this.$isInDaylightTime = z;
    }

    public final void invoke() {
        SettingsManager.INSTANCE.setInDaylightTime(this.$isInDaylightTime);
    }
}
