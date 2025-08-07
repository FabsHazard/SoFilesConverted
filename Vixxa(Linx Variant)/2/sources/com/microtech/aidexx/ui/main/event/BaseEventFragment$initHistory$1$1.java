package com.microtech.aidexx.ui.main.event;

import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "detailEntity", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$initHistory$1$1 extends Lambda implements Function1<BaseEventDetail, Unit> {
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$initHistory$1$1(BaseEventFragment<VM, VB> baseEventFragment) {
        super(1);
        this.this$0 = baseEventFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BaseEventDetail) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BaseEventDetail baseEventDetail) {
        Intrinsics.checkNotNullParameter(baseEventDetail, "detailEntity");
        baseEventDetail.setId(0);
        this.this$0.getViewModel().addToSaveDetailList(baseEventDetail);
        this.this$0.getToSaveDetailAdapter().getData().add(0, baseEventDetail);
        this.this$0.getToSaveDetailAdapter().notifyItemInserted(0);
    }
}
