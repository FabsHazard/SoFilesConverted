package com.microtech.aidexx.ui.main.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.FragmentAlertHistoryBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/AlertHistoryFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentAlertHistoryBinding;", "()V", "adapter", "Lcom/microtech/aidexx/ui/main/history/HistoryRecyclerViewAdapter;", "dataList", "", "Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;", "vm", "Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "vm$delegate", "Lkotlin/Lazy;", "initData", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlertHistoryFragment.kt */
public final class AlertHistoryFragment extends BaseFragment<BaseViewModel, FragmentAlertHistoryBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public HistoryRecyclerViewAdapter adapter;
    /* access modifiers changed from: private */
    public final List<HistoryDetailModel> dataList = new ArrayList();
    private final Lazy vm$delegate;

    @JvmStatic
    public static final AlertHistoryFragment newInstance() {
        return Companion.newInstance();
    }

    public AlertHistoryFragment() {
        Fragment fragment = this;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(HistoryViewModel.class), new AlertHistoryFragment$special$$inlined$activityViewModels$default$1(fragment), new AlertHistoryFragment$special$$inlined$activityViewModels$default$2((Function0) null, fragment), new AlertHistoryFragment$special$$inlined$activityViewModels$default$3(fragment));
    }

    /* access modifiers changed from: private */
    public final HistoryViewModel getVm() {
        return (HistoryViewModel) this.vm$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAlertHistoryBinding inflate = FragmentAlertHistoryBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initData();
        LinearLayout root = ((FragmentAlertHistoryBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public final void initView() {
        if (this.adapter == null) {
            HistoryRecyclerViewAdapter historyRecyclerViewAdapter = null;
            this.adapter = new HistoryRecyclerViewAdapter(this.dataList, (Function1<? super HistoryDetailModel, Unit>) null);
            FragmentAlertHistoryBinding fragmentAlertHistoryBinding = (FragmentAlertHistoryBinding) getBinding();
            RecyclerView recyclerView = fragmentAlertHistoryBinding.rvHistoryDetail;
            HistoryRecyclerViewAdapter historyRecyclerViewAdapter2 = this.adapter;
            if (historyRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                historyRecyclerViewAdapter = historyRecyclerViewAdapter2;
            }
            recyclerView.setAdapter(historyRecyclerViewAdapter);
            fragmentAlertHistoryBinding.rvHistoryDetail.setLayoutManager(new LinearLayoutManager(requireActivity(), 1, false));
        }
    }

    private final void initData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new AlertHistoryFragment$initData$1(this, (Continuation<? super AlertHistoryFragment$initData$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/AlertHistoryFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/history/AlertHistoryFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AlertHistoryFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AlertHistoryFragment newInstance() {
            return new AlertHistoryFragment();
        }
    }
}
