package com.microtech.aidexx.ui.main.event;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$canLeave$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$canLeave$1(BaseEventFragment<VM, VB> baseEventFragment) {
        super(0);
        this.this$0 = baseEventFragment;
    }

    public final void invoke() {
        this.this$0.getViewModel().clearToSaveDetailList();
        this.this$0.getToSaveDetailAdapter().getData().clear();
        this.this$0.getToSaveDetailAdapter().notifyDataSetChanged();
    }
}
