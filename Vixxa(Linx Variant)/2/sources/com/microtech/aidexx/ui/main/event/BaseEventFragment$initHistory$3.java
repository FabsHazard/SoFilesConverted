package com.microtech.aidexx.ui.main.event;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\u0006H@"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.BaseEventFragment$initHistory$3", f = "BaseEventFragment.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$initHistory$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$initHistory$3(BaseEventFragment<VM, VB> baseEventFragment, Continuation<? super BaseEventFragment$initHistory$3> continuation) {
        super(2, continuation);
        this.this$0 = baseEventFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseEventFragment$initHistory$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseEventFragment$initHistory$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.updateHistoryUi(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
