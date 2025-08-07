package com.microtech.aidexx.ui.welcome.guide.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.FragmentUnitSetBinding;
import com.microtech.aidexx.utils.UnitManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0002J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/UnitSetFragment;", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/GuideBaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentUnitSetBinding;", "()V", "getPageName", "", "initView", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UnitSetFragment.kt */
public final class UnitSetFragment extends GuideBaseFragment<BaseViewModel, FragmentUnitSetBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UnitSetFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit[] r0 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r1 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MMOL_PER_L     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r1 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MG_PER_DL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.welcome.guide.fragment.UnitSetFragment.WhenMappings.<clinit>():void");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentUnitSetBinding inflate = FragmentUnitSetBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initView();
        ConstraintLayout root = ((FragmentUnitSetBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initView() {
        int i;
        ((FragmentUnitSetBinding) getBinding()).rgUnits.setOnCheckedChangeListener(new UnitSetFragment$$ExternalSyntheticLambda0());
        RadioGroup radioGroup = ((FragmentUnitSetBinding) getBinding()).rgUnits;
        int i2 = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i2 == 1) {
            i = R.id.rb_mmol;
        } else if (i2 == 2) {
            i = R.id.rb_mg;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        radioGroup.check(i);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(RadioGroup radioGroup, int i) {
        if (i == R.id.rb_mmol) {
            UnitManager.INSTANCE.setGlucoseUnit(UnitManager.GlucoseUnit.MMOL_PER_L);
        } else if (i == R.id.rb_mg) {
            UnitManager.INSTANCE.setGlucoseUnit(UnitManager.GlucoseUnit.MG_PER_DL);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/UnitSetFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/UnitSetFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UnitSetFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UnitSetFragment newInstance() {
            return new UnitSetFragment();
        }
    }

    public String getPageName() {
        String string = getString(R.string.cgm_unit);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
