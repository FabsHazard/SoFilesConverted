package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.databinding.ActivitySettingBinding;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
final class SettingActivity$initView$1$12$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ ActivitySettingBinding $this_apply;
    final /* synthetic */ SettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingActivity$initView$1$12$1(ActivitySettingBinding activitySettingBinding, SettingActivity settingActivity) {
        super(1);
        this.$this_apply = activitySettingBinding;
        this.this$0 = settingActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$this_apply.settingUnit.setValue((String) this.this$0.units.get(i));
        UnitManager.INSTANCE.setGlucoseUnit(UnitManager.INSTANCE.getUnitByIndex(i));
        EventBusManager.INSTANCE.send(EventBusKey.EVENT_UNIT_CHANGE, true);
        EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, true);
    }
}
