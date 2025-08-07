package com.microtech.aidexx.ui.main.event;

import com.microtech.aidexx.databinding.FragmentEventBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventFragment.kt */
final class EventFragment$onCreateView$1$1$onChange$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ FragmentEventBinding $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventFragment$onCreateView$1$1$onChange$1(FragmentEventBinding fragmentEventBinding, int i) {
        super(0);
        this.$this_apply = fragmentEventBinding;
        this.$position = i;
    }

    public final void invoke() {
        this.$this_apply.stIndicator.setCurrentIndex(this.$position);
        this.$this_apply.vpEventContent.setCurrentItem(this.$position, false);
    }
}
