package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.databinding.ActivitySettingBinding;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.ThemeManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
final class SettingActivity$initView$1$14$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<String> $themes;
    final /* synthetic */ ActivitySettingBinding $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingActivity$initView$1$14$1(ActivitySettingBinding activitySettingBinding, List<String> list) {
        super(1);
        this.$this_apply = activitySettingBinding;
        this.$themes = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        if (i != ThemeManager.INSTANCE.getTheme().getIndex()) {
            this.$this_apply.settingTheme.setValue(this.$themes.get(i));
            ThemeManager.INSTANCE.setTheme(ThemeManager.INSTANCE.themeByIndex(i));
            ThemeManager.INSTANCE.applyDayNight();
            ActivityUtil.INSTANCE.recreateAll();
        }
    }
}
