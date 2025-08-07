package com.microtech.aidexx.ui.welcome.guide.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.FragmentBgIntroBinding;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.UnitManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/BgIntroFragment;", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/GuideBaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentBgIntroBinding;", "()V", "getPageName", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgIntroFragment.kt */
public final class BgIntroFragment extends GuideBaseFragment<BaseViewModel, FragmentBgIntroBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentBgIntroBinding inflate = FragmentBgIntroBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ConstraintLayout root = ((FragmentBgIntroBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onResume() {
        String str;
        String str2;
        super.onResume();
        TextView textView = ((FragmentBgIntroBinding) getBinding()).colorIntroTips;
        int i = R.string.guide_bgIntro_tips;
        float glucoseValue = GlucoseUtilKt.toGlucoseValue(70.200005f);
        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MG_PER_DL) {
            str = String.valueOf(MathKt.roundToInt(glucoseValue));
        } else {
            str = String.valueOf(glucoseValue);
        }
        float glucoseValue2 = GlucoseUtilKt.toGlucoseValue(180.0f);
        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MG_PER_DL) {
            str2 = String.valueOf(MathKt.roundToInt(glucoseValue2));
        } else {
            str2 = String.valueOf(glucoseValue2);
        }
        textView.setText(getString(i, str, str2, UnitManager.INSTANCE.getDisplayUnit()));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/BgIntroFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/BgIntroFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BgIntroFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BgIntroFragment newInstance() {
            return new BgIntroFragment();
        }
    }

    public String getPageName() {
        String string = getString(R.string.guide_bgIntro_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
