package com.microtech.aidexx.ui.main.history.eventHistory;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.databinding.FragmentHistoryEventBinding;
import com.microtech.aidexx.ui.main.history.EventHistoryFragment;
import com.microtech.aidexx.ui.main.history.HistoryViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/eventHistory/EventHistoryChartViewHolder;", "", "mFragment", "Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;", "(Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;)V", "binding", "Lcom/microtech/aidexx/databinding/FragmentHistoryEventBinding;", "vm", "Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "vm$delegate", "Lkotlin/Lazy;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryChartViewHolder.kt */
public final class EventHistoryChartViewHolder {
    private final FragmentHistoryEventBinding binding;
    private final EventHistoryFragment mFragment;
    private final Lazy vm$delegate;

    public EventHistoryChartViewHolder(EventHistoryFragment eventHistoryFragment) {
        Intrinsics.checkNotNullParameter(eventHistoryFragment, "mFragment");
        this.mFragment = eventHistoryFragment;
        Fragment fragment = eventHistoryFragment;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(HistoryViewModel.class), new EventHistoryChartViewHolder$special$$inlined$activityViewModels$default$1(fragment), new EventHistoryChartViewHolder$special$$inlined$activityViewModels$default$2((Function0) null, fragment), new EventHistoryChartViewHolder$special$$inlined$activityViewModels$default$3(fragment));
        FragmentHistoryEventBinding fragmentHistoryEventBinding = (FragmentHistoryEventBinding) eventHistoryFragment.getBinding();
        this.binding = fragmentHistoryEventBinding;
        fragmentHistoryEventBinding.chart.setExtraParams(new EventHistoryChartViewHolder$1$1(this));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(eventHistoryFragment), (CoroutineContext) null, (CoroutineStart) null, new EventHistoryChartViewHolder$1$2(this, fragmentHistoryEventBinding, (Continuation<? super EventHistoryChartViewHolder$1$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final HistoryViewModel getVm() {
        return (HistoryViewModel) this.vm$delegate.getValue();
    }
}
