package com.microtech.aidexx.ui.main.history;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.databinding.FragmentAlertHistoryBinding;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.history.AlertHistoryFragment$initData$1", f = "AlertHistoryFragment.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AlertHistoryFragment.kt */
final class AlertHistoryFragment$initData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AlertHistoryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertHistoryFragment$initData$1(AlertHistoryFragment alertHistoryFragment, Continuation<? super AlertHistoryFragment$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = alertHistoryFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlertHistoryFragment$initData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AlertHistoryFragment$initData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "list", "", "Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.history.AlertHistoryFragment$initData$1$1", f = "AlertHistoryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.history.AlertHistoryFragment$initData$1$1  reason: invalid class name */
    /* compiled from: AlertHistoryFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends HistoryDetailModel>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(alertHistoryFragment, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(List<HistoryDetailModel> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                if (list != null) {
                    Collection collection = list;
                    HistoryRecyclerViewAdapter historyRecyclerViewAdapter = null;
                    if (collection.isEmpty()) {
                        collection = null;
                    }
                    List list2 = (List) collection;
                    if (list2 != null) {
                        AlertHistoryFragment alertHistoryFragment = alertHistoryFragment;
                        alertHistoryFragment.initView();
                        alertHistoryFragment.dataList.clear();
                        alertHistoryFragment.dataList.addAll(CollectionsKt.sortedWith(list2, new AlertHistoryFragment$initData$1$1$invokeSuspend$lambda$2$$inlined$sortedByDescending$1()));
                        HistoryRecyclerViewAdapter access$getAdapter$p = alertHistoryFragment.adapter;
                        if (access$getAdapter$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        } else {
                            historyRecyclerViewAdapter = access$getAdapter$p;
                        }
                        historyRecyclerViewAdapter.notifyDataSetChanged();
                    }
                }
                FragmentAlertHistoryBinding fragmentAlertHistoryBinding = (FragmentAlertHistoryBinding) alertHistoryFragment.getBinding();
                TextView textView = fragmentAlertHistoryBinding.noDataView;
                Intrinsics.checkNotNullExpressionValue(textView, "noDataView");
                boolean z = true;
                int i = 8;
                textView.setVisibility(list != null ? list.isEmpty() : true ? 0 : 8);
                RecyclerView recyclerView = fragmentAlertHistoryBinding.rvHistoryDetail;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "rvHistoryDetail");
                View view = recyclerView;
                TextView textView2 = fragmentAlertHistoryBinding.noDataView;
                Intrinsics.checkNotNullExpressionValue(textView2, "noDataView");
                if (textView2.getVisibility() != 0) {
                    z = false;
                }
                if (!z) {
                    i = 0;
                }
                view.setVisibility(i);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AlertHistoryFragment alertHistoryFragment = this.this$0;
            this.label = 1;
            if (FlowKt.collectLatest(this.this$0.getVm().getAlertModel(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
