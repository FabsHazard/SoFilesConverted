package com.microtech.aidexx.ui.main.event;

import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.db.entity.event.DietDetail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "detail", "Lcom/microtech/aidexx/db/entity/event/DietDetail;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventDietFragment.kt */
final class EventDietFragment$showPresetDialog$2 extends Lambda implements Function1<DietDetail, Unit> {
    final /* synthetic */ Function1<BaseEventDetail, Unit> $onConfirmClick;
    final /* synthetic */ EventDietFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventDietFragment$showPresetDialog$2(EventDietFragment eventDietFragment, Function1<? super BaseEventDetail, Unit> function1) {
        super(1);
        this.this$0 = eventDietFragment;
        this.$onConfirmClick = function1;
    }

    public final void invoke(DietDetail dietDetail) {
        Intrinsics.checkNotNullParameter(dietDetail, "detail");
        this.this$0.getVm().setScale(dietDetail);
        this.$onConfirmClick.invoke(dietDetail);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DietDetail) obj);
        return Unit.INSTANCE;
    }
}
