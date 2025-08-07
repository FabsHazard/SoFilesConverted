package com.microtech.aidexx.ui.main.history.eventHistory;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentHistoryEventBinding;
import com.microtech.aidexx.ui.main.history.EventHistoryFragment;
import com.microtech.aidexx.ui.main.history.HistoryDetailModel;
import com.microtech.aidexx.ui.main.history.HistoryRecyclerViewAdapter;
import com.microtech.aidexx.ui.main.history.HistoryViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/eventHistory/EventHistoryRecordsViewHolder;", "", "mFragment", "Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;", "(Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;)V", "adapter", "Lcom/microtech/aidexx/ui/main/history/HistoryRecyclerViewAdapter;", "binding", "Lcom/microtech/aidexx/databinding/FragmentHistoryEventBinding;", "dataList", "", "Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;", "vm", "Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "vm$delegate", "Lkotlin/Lazy;", "initRecyclerView", "", "onDeleteClick", "model", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryRecordsViewHolder.kt */
public final class EventHistoryRecordsViewHolder {
    /* access modifiers changed from: private */
    public HistoryRecyclerViewAdapter adapter;
    private final FragmentHistoryEventBinding binding;
    /* access modifiers changed from: private */
    public final List<HistoryDetailModel> dataList = new ArrayList();
    private final EventHistoryFragment mFragment;
    private final Lazy vm$delegate;

    public EventHistoryRecordsViewHolder(EventHistoryFragment eventHistoryFragment) {
        Intrinsics.checkNotNullParameter(eventHistoryFragment, "mFragment");
        this.mFragment = eventHistoryFragment;
        Fragment fragment = eventHistoryFragment;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(HistoryViewModel.class), new EventHistoryRecordsViewHolder$special$$inlined$activityViewModels$default$1(fragment), new EventHistoryRecordsViewHolder$special$$inlined$activityViewModels$default$2((Function0) null, fragment), new EventHistoryRecordsViewHolder$special$$inlined$activityViewModels$default$3(fragment));
        this.binding = (FragmentHistoryEventBinding) eventHistoryFragment.getBinding();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(eventHistoryFragment), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final HistoryViewModel getVm() {
        return (HistoryViewModel) this.vm$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder$1", f = "HistoryRecordsViewHolder.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.history.eventHistory.EventHistoryRecordsViewHolder$1  reason: invalid class name */
    /* compiled from: HistoryRecordsViewHolder.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EventHistoryRecordsViewHolder this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final EventHistoryRecordsViewHolder eventHistoryRecordsViewHolder = this.this$0;
                this.label = 1;
                if (FlowKt.collectLatest(this.this$0.getVm().getRecordsModel(), new Function2<List<? extends HistoryDetailModel>, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    /* synthetic */ Object L$0;
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 r0 = 

                        /* access modifiers changed from: private */
                        public final void initRecyclerView() {
                            if (this.adapter == null) {
                                this.adapter = new HistoryRecyclerViewAdapter(this.dataList, new EventHistoryRecordsViewHolder$initRecyclerView$1(this));
                                FragmentHistoryEventBinding fragmentHistoryEventBinding = this.binding;
                                RecyclerView recyclerView = fragmentHistoryEventBinding.rvHistoryDetail;
                                HistoryRecyclerViewAdapter historyRecyclerViewAdapter = this.adapter;
                                if (historyRecyclerViewAdapter == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                                    historyRecyclerViewAdapter = null;
                                }
                                recyclerView.setAdapter(historyRecyclerViewAdapter);
                                fragmentHistoryEventBinding.rvHistoryDetail.setLayoutManager(new LinearLayoutManager(this.mFragment.requireActivity(), 1, false));
                            }
                        }

                        /* access modifiers changed from: private */
                        public final void onDeleteClick(HistoryDetailModel historyDetailModel) {
                            Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new EventHistoryRecordsViewHolder$onDeleteClick$1(historyDetailModel, this, (Continuation<? super EventHistoryRecordsViewHolder$onDeleteClick$1>) null), 3, (Object) null);
                        }
                    }
