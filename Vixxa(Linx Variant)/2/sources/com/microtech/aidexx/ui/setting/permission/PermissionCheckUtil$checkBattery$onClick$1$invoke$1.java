package com.microtech.aidexx.ui.setting.permission;

import com.microtech.aidexx.base.BaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionCheckUtil.kt */
final class PermissionCheckUtil$checkBattery$onClick$1$invoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseActivity<?, ?> $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionCheckUtil$checkBattery$onClick$1$invoke$1(BaseActivity<?, ?> baseActivity) {
        super(0);
        this.$context = baseActivity;
    }

    public final void invoke() {
        BaseActivity<?, ?> baseActivity = this.$context;
        baseActivity.ignoreBatteryOptimization(baseActivity);
    }
}
