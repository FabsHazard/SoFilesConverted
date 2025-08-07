package com.microtech.aidexx.ui.main.event;

import com.microtech.aidexx.databinding.FragmentEventDietBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "str", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventDietFragment.kt */
final class EventDietFragment$initEventClick$1$2$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ FragmentEventDietBinding $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventDietFragment$initEventClick$1$2$1(FragmentEventDietBinding fragmentEventDietBinding) {
        super(1);
        this.$this_apply = fragmentEventDietBinding;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        this.$this_apply.tvDietType.setText(str);
    }
}
