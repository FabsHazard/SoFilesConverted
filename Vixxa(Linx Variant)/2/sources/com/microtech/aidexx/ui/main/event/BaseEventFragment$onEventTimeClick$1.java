package com.microtech.aidexx.ui.main.event;

import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "it", "Ljava/util/Date;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$onEventTimeClick$1 extends Lambda implements Function1<Date, Unit> {
    final /* synthetic */ Function1<String, Unit> $cb;
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$onEventTimeClick$1(Function1<? super String, Unit> function1, BaseEventFragment<VM, VB> baseEventFragment) {
        super(1);
        this.$cb = function1;
        this.this$0 = baseEventFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Date) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Date date) {
        Intrinsics.checkNotNullParameter(date, "it");
        this.$cb.invoke(this.this$0.getViewModel().updateEventTime(date));
    }
}
