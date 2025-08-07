package com.microtech.aidexx.ui.main.event;

import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\u0006H@"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.BaseEventFragment$updateHistoryUi$2", f = "BaseEventFragment.kt", i = {}, l = {233, 233}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$updateHistoryUi$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$updateHistoryUi$2(BaseEventFragment<VM, VB> baseEventFragment, Continuation<? super BaseEventFragment$updateHistoryUi$2> continuation) {
        super(2, continuation);
        this.this$0 = baseEventFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseEventFragment$updateHistoryUi$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseEventFragment$updateHistoryUi$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getViewModel().loadHistory(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final BaseEventFragment<VM, VB> baseEventFragment = this.this$0;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation);
            }

            public final Object emit(int i, Continuation<? super Unit> continuation) {
                baseEventFragment.getDetailHistoryAdapter().setData$app_gpGrxMmolRelease(CollectionsKt.toMutableList(baseEventFragment.getViewModel().getDetailHistory()));
                baseEventFragment.getDetailHistoryAdapter().notifyDataSetChanged();
                View noRecordView = baseEventFragment.getNoRecordView();
                int i2 = 0;
                if (!(i <= 0)) {
                    i2 = 8;
                }
                noRecordView.setVisibility(i2);
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
