package com.microtech.aidexx.ui.main;

import com.microtech.aidexx.databinding.ActivityMainBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
final class MainActivity$initView$1$3$hasConfirm$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $it;
    final /* synthetic */ ActivityMainBinding $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$initView$1$3$hasConfirm$1(ActivityMainBinding activityMainBinding, int i) {
        super(0);
        this.$this_apply = activityMainBinding;
        this.$it = i;
    }

    public final void invoke() {
        this.$this_apply.viewpager.setCurrentItem(this.$it, false);
    }
}
