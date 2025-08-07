package com.microtech.aidexx.ui.setting.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.FragShareOrFollowBinding;
import com.microtech.aidexx.utils.LogUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0003J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareFollowFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragShareOrFollowBinding;", "isShare", "", "(Z)V", "listAdapter", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowListAdapter;", "sfViewModel", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "getSfViewModel", "()Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "sfViewModel$delegate", "Lkotlin/Lazy;", "getData", "", "initEvent", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareFollowFragment.kt */
public final class ShareFollowFragment extends BaseFragment<BaseViewModel, FragShareOrFollowBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = "ShareFollowFragment";
    /* access modifiers changed from: private */
    public final boolean isShare;
    /* access modifiers changed from: private */
    public ShareFollowListAdapter listAdapter;
    private final Lazy sfViewModel$delegate;

    public ShareFollowFragment(boolean z) {
        this.isShare = z;
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ShareFollowFragment$special$$inlined$viewModels$default$1(new ShareFollowFragment$sfViewModel$2(this)));
        this.sfViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ShareFollowViewModel.class), new ShareFollowFragment$special$$inlined$viewModels$default$2(lazy), new ShareFollowFragment$special$$inlined$viewModels$default$3((Function0) null, lazy), new ShareFollowFragment$special$$inlined$viewModels$default$4(fragment, lazy));
    }

    /* access modifiers changed from: private */
    public final ShareFollowViewModel getSfViewModel() {
        return (ShareFollowViewModel) this.sfViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragShareOrFollowBinding inflate = FragShareOrFollowBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initView();
        initEvent();
        SmartRefreshLayout root = ((FragShareOrFollowBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initView() {
        LinearLayout linearLayout = ((FragShareOrFollowBinding) getBinding()).llBtn;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llBtn");
        linearLayout.setVisibility(this.isShare ? 0 : 8);
    }

    private final void initEvent() {
        FragShareOrFollowBinding fragShareOrFollowBinding = (FragShareOrFollowBinding) getBinding();
        fragShareOrFollowBinding.shareRefreshLayout.setOnRefreshListener(new ShareFollowFragment$$ExternalSyntheticLambda0(this));
        fragShareOrFollowBinding.btnAccountAdd.setOnClickListener(new ShareFollowFragment$$ExternalSyntheticLambda1(this));
        fragShareOrFollowBinding.btnWechatAdd.setOnClickListener(new ShareFollowFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$4$lambda$1(ShareFollowFragment shareFollowFragment, RefreshLayout refreshLayout) {
        Intrinsics.checkNotNullParameter(shareFollowFragment, "this$0");
        Intrinsics.checkNotNullParameter(refreshLayout, "it");
        LogUtil.Companion companion = LogUtil.Companion;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion.xLogE("setOnRefreshListener", str);
        shareFollowFragment.getData();
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$4$lambda$2(ShareFollowFragment shareFollowFragment, View view) {
        Intrinsics.checkNotNullParameter(shareFollowFragment, "this$0");
        Context context = shareFollowFragment.getContext();
        if (context != null) {
            context.startActivity(new Intent(shareFollowFragment.getContext(), ShareAddUserActivity.class));
        }
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$4$lambda$3(ShareFollowFragment shareFollowFragment, View view) {
        Intrinsics.checkNotNullParameter(shareFollowFragment, "this$0");
        Context context = shareFollowFragment.getContext();
        if (context != null) {
            context.startActivity(new Intent(shareFollowFragment.getContext(), ShareAddUserByWechatActivity.class));
        }
    }

    private final void getData() {
        LogUtil.Companion companion = LogUtil.Companion;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion.xLogE("getData", str);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ShareFollowFragment$getData$1(this, (Continuation<? super ShareFollowFragment$getData$1>) null), 3, (Object) null);
    }

    public void onResume() {
        super.onResume();
        LogUtil.Companion companion = LogUtil.Companion;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        companion.xLogE("onResume autoRefresh", str);
        ((FragShareOrFollowBinding) getBinding()).shareRefreshLayout.autoRefresh();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareFollowFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getFollowInstance", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowFragment;", "getShareInstance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ShareFollowFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShareFollowFragment getShareInstance() {
            return new ShareFollowFragment(true);
        }

        public final ShareFollowFragment getFollowInstance() {
            return new ShareFollowFragment(false);
        }
    }
}
