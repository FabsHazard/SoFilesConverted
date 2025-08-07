package com.microtech.aidexx.ui.main.event;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventFragment.kt */
final class EventFragment$needConfirmLeave$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $cb;
    final /* synthetic */ Function0<Unit> $confirmCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventFragment$needConfirmLeave$1$1(Function0<Unit> function0, Function0<Unit> function02) {
        super(0);
        this.$cb = function0;
        this.$confirmCallback = function02;
    }

    public final void invoke() {
        this.$cb.invoke();
        this.$confirmCallback.invoke();
    }
}
