package com.microtech.aidexx.ui.welcome.guide.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.FragmentHighThresholdSetBinding;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.views.ruler.RulerWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/HighThresholdSetFragment;", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/GuideBaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentHighThresholdSetBinding;", "()V", "getPageName", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNextClick", "", "onResume", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HighThresholdSetFragment.kt */
public final class HighThresholdSetFragment extends GuideBaseFragment<BaseViewModel, FragmentHighThresholdSetBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHighThresholdSetBinding inflate = FragmentHighThresholdSetBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ConstraintLayout root = ((FragmentHighThresholdSetBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onResume() {
        super.onResume();
        ((FragmentHighThresholdSetBinding) getBinding()).rwHighSet.setType(RulerWidget.RulerType.HYPER, ThresholdManager.INSTANCE.getHyper());
    }

    public void onNextClick() {
        ThresholdManager.INSTANCE.setHyper(GlucoseUtilKt.fromGlucoseValue(((FragmentHighThresholdSetBinding) getBinding()).rwHighSet.getCurrentValue()));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/HighThresholdSetFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/HighThresholdSetFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HighThresholdSetFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HighThresholdSetFragment newInstance() {
            return new HighThresholdSetFragment();
        }
    }

    public String getPageName() {
        String string = getString(R.string.user_warning_high_value);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
