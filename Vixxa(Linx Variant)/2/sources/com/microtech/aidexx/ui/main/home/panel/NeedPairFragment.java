package com.microtech.aidexx.ui.main.home.panel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentNeedPairBinding;
import com.microtech.aidexx.ui.pair.TransmitterActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/NeedPairFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentNeedPairBinding;", "()V", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NeedPairFragment.kt */
public final class NeedPairFragment extends BaseFragment<BaseViewModel, FragmentNeedPairBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final NeedPairFragment newInstance() {
        return Companion.newInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentNeedPairBinding inflate = FragmentNeedPairBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initView();
        ConstraintLayout root = ((FragmentNeedPairBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initView() {
        ((FragmentNeedPairBinding) getBinding()).llPanel.setBackgroundResource(ThemeManager.INSTANCE.isLight() ? R.drawable.bg_panel_blank_light : R.drawable.bg_panel_blank_dark);
        ((FragmentNeedPairBinding) getBinding()).tvUnit.setText(UnitManager.INSTANCE.getDisplayUnit());
        TextView textView = ((FragmentNeedPairBinding) getBinding()).btConfirm;
        Intrinsics.checkNotNullExpressionValue(textView, "btConfirm");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new NeedPairFragment$$ExternalSyntheticLambda0(this), 1, (Object) null);
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_UNIT_CHANGE, (LifecycleOwner) this, new NeedPairFragment$initView$2(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(NeedPairFragment needPairFragment, View view) {
        Intrinsics.checkNotNullParameter(needPairFragment, "this$0");
        ActivityUtil activityUtil = ActivityUtil.INSTANCE;
        Context requireContext = needPairFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        activityUtil.toActivity(requireContext, TransmitterActivity.class);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/NeedPairFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/home/panel/NeedPairFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: NeedPairFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NeedPairFragment newInstance() {
            return new NeedPairFragment();
        }
    }
}
