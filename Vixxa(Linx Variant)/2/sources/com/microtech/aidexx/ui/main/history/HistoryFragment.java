package com.microtech.aidexx.ui.main.history;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.FragmentHistoryBinding;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.calendar.CalendarSingleDialog;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/HistoryFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentHistoryBinding;", "()V", "toJumpDate", "Ljava/util/Date;", "vm", "Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/history/HistoryViewModel;", "vm$delegate", "Lkotlin/Lazy;", "initScrollTab", "", "initTitle", "initViewPager", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "HistoryPageAdapter", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryFragment.kt */
public final class HistoryFragment extends BaseFragment<BaseViewModel, FragmentHistoryBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public Date toJumpDate;
    private final Lazy vm$delegate;

    @JvmStatic
    public static final HistoryFragment newInstance() {
        return Companion.newInstance();
    }

    public HistoryFragment() {
        Fragment fragment = this;
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(HistoryViewModel.class), new HistoryFragment$special$$inlined$activityViewModels$default$1(fragment), new HistoryFragment$special$$inlined$activityViewModels$default$2((Function0) null, fragment), new HistoryFragment$special$$inlined$activityViewModels$default$3(fragment));
    }

    /* access modifiers changed from: private */
    public final HistoryViewModel getVm() {
        return (HistoryViewModel) this.vm$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHistoryBinding inflate = FragmentHistoryBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ((FragmentHistoryBinding) getBinding()).tvHistoryTitle.setPadding(0, ExtendsKt.getStatusBarHeight() + ExtendsKt.dp2px((Number) 10), 0, 0);
        initTitle();
        initScrollTab();
        initViewPager();
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_GO_TO_HISTORY, (LifecycleOwner) this, new HistoryFragment$onCreateView$1(this));
        ConstraintLayout root = ((FragmentHistoryBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onResume() {
        CharSequence charSequence;
        String displayName;
        super.onResume();
        TextView textView = ((FragmentHistoryBinding) getBinding()).tvHistoryTitle;
        ShareUserInfo shareUserInfo = UserInfoManager.Companion.getShareUserInfo();
        if (shareUserInfo == null || (displayName = shareUserInfo.getDisplayName()) == null) {
            charSequence = getString(R.string.history);
        } else {
            charSequence = displayName;
        }
        textView.setText(charSequence);
        HistoryViewModel vm = getVm();
        Date date = this.toJumpDate;
        if (date == null) {
            date = new Date();
        }
        vm.updateDate(date);
        this.toJumpDate = null;
    }

    private final void initTitle() {
        FragmentHistoryBinding fragmentHistoryBinding = (FragmentHistoryBinding) getBinding();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new HistoryFragment$initTitle$1$1(this, fragmentHistoryBinding, (Continuation<? super HistoryFragment$initTitle$1$1>) null), 3, (Object) null);
        ImageView imageView = fragmentHistoryBinding.btnPreviousDay;
        Intrinsics.checkNotNullExpressionValue(imageView, "btnPreviousDay");
        ExtendsKt.setDebounceClickListener$default(imageView, 0, new HistoryFragment$$ExternalSyntheticLambda0(this), 1, (Object) null);
        ImageView imageView2 = fragmentHistoryBinding.btnNextDay;
        Intrinsics.checkNotNullExpressionValue(imageView2, "btnNextDay");
        ExtendsKt.setDebounceClickListener$default(imageView2, 0, new HistoryFragment$$ExternalSyntheticLambda1(this), 1, (Object) null);
        TextView textView = fragmentHistoryBinding.tvTimeSelected;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTimeSelected");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new HistoryFragment$$ExternalSyntheticLambda2(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initTitle$lambda$4$lambda$1(HistoryFragment historyFragment, View view) {
        Intrinsics.checkNotNullParameter(historyFragment, "this$0");
        historyFragment.getVm().toPreviousDay();
    }

    /* access modifiers changed from: private */
    public static final void initTitle$lambda$4$lambda$2(HistoryFragment historyFragment, View view) {
        Intrinsics.checkNotNullParameter(historyFragment, "this$0");
        historyFragment.getVm().toNextDay();
    }

    /* access modifiers changed from: private */
    public static final void initTitle$lambda$4$lambda$3(HistoryFragment historyFragment, View view) {
        Intrinsics.checkNotNullParameter(historyFragment, "this$0");
        Context requireContext = historyFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        new CalendarSingleDialog(requireContext, false, false, historyFragment.getVm().getCurDate().getValue(), new HistoryFragment$initTitle$1$4$1(historyFragment), 6, (DefaultConstructorMarker) null);
    }

    private final void initScrollTab() {
        List mutableListOf = CollectionsKt.mutableListOf(getString(R.string.history_seg_glucose), getString(R.string.history_seg_warning));
        FragmentHistoryBinding fragmentHistoryBinding = (FragmentHistoryBinding) getBinding();
        fragmentHistoryBinding.stIndicator.setTitles(mutableListOf);
        fragmentHistoryBinding.stIndicator.setOnTabListener(new HistoryFragment$initScrollTab$1$1(fragmentHistoryBinding));
    }

    private final void initViewPager() {
        FragmentHistoryBinding fragmentHistoryBinding = (FragmentHistoryBinding) getBinding();
        fragmentHistoryBinding.pageHistory.setUserInputEnabled(false);
        ViewPager2 viewPager2 = fragmentHistoryBinding.pageHistory;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        viewPager2.setAdapter(new HistoryPageAdapter(requireActivity));
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/HistoryFragment$HistoryPageAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "alert", "Lcom/microtech/aidexx/ui/main/history/AlertHistoryFragment;", "getAlert", "()Lcom/microtech/aidexx/ui/main/history/AlertHistoryFragment;", "alert$delegate", "Lkotlin/Lazy;", "event", "Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;", "getEvent", "()Lcom/microtech/aidexx/ui/main/history/EventHistoryFragment;", "event$delegate", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HistoryFragment.kt */
    public static final class HistoryPageAdapter extends FragmentStateAdapter {
        private final Lazy alert$delegate = LazyKt.lazy(HistoryFragment$HistoryPageAdapter$alert$2.INSTANCE);
        private final Lazy event$delegate = LazyKt.lazy(HistoryFragment$HistoryPageAdapter$event$2.INSTANCE);

        public int getItemCount() {
            return 2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HistoryPageAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        }

        public final EventHistoryFragment getEvent() {
            return (EventHistoryFragment) this.event$delegate.getValue();
        }

        public final AlertHistoryFragment getAlert() {
            return (AlertHistoryFragment) this.alert$delegate.getValue();
        }

        public Fragment createFragment(int i) {
            if (i == 1) {
                return getAlert();
            }
            return getEvent();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/HistoryFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/history/HistoryFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HistoryFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HistoryFragment newInstance() {
            return new HistoryFragment();
        }
    }
}
