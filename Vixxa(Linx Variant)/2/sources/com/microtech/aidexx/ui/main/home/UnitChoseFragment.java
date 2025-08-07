package com.microtech.aidexx.ui.main.home;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.LayoutUnitChoseDialogBinding;
import com.microtech.aidexx.ui.setting.profile.ProfileViewModel;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/UnitChoseFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/microtech/aidexx/databinding/LayoutUnitChoseDialogBinding;", "getBinding", "()Lcom/microtech/aidexx/databinding/LayoutUnitChoseDialogBinding;", "setBinding", "(Lcom/microtech/aidexx/databinding/LayoutUnitChoseDialogBinding;)V", "pVm", "Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "getPVm", "()Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "pVm$delegate", "Lkotlin/Lazy;", "showWhether", "Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "getShowWhether", "()Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "setShowWhether", "(Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onStart", "onViewCreated", "view", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UnitChoseFragment.kt */
public final class UnitChoseFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "UnitChoseFragment";
    public LayoutUnitChoseDialogBinding binding;
    private final Lazy pVm$delegate;
    private StandardDialog showWhether;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UnitChoseFragment.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.UnitChoseFragment.WhenMappings.<clinit>():void");
        }
    }

    public UnitChoseFragment() {
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnitChoseFragment$special$$inlined$viewModels$default$2(new UnitChoseFragment$special$$inlined$viewModels$default$1(fragment)));
        this.pVm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new UnitChoseFragment$special$$inlined$viewModels$default$3(lazy), new UnitChoseFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new UnitChoseFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/UnitChoseFragment$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UnitChoseFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final LayoutUnitChoseDialogBinding getBinding() {
        LayoutUnitChoseDialogBinding layoutUnitChoseDialogBinding = this.binding;
        if (layoutUnitChoseDialogBinding != null) {
            return layoutUnitChoseDialogBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(LayoutUnitChoseDialogBinding layoutUnitChoseDialogBinding) {
        Intrinsics.checkNotNullParameter(layoutUnitChoseDialogBinding, "<set-?>");
        this.binding = layoutUnitChoseDialogBinding;
    }

    public final StandardDialog getShowWhether() {
        return this.showWhether;
    }

    public final void setShowWhether(StandardDialog standardDialog) {
        this.showWhether = standardDialog;
    }

    /* access modifiers changed from: private */
    public final ProfileViewModel getPVm() {
        return (ProfileViewModel) this.pVm$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutUnitChoseDialogBinding inflate = LayoutUnitChoseDialogBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onResume() {
        super.onResume();
        getBinding().tvDialogTitleUnitChose.setText(getString(R.string.cgm_unit));
        getBinding().buttonConfirm.setText(getString(R.string.com_action_sure));
        getBinding().rbMg.setText(getString(R.string.cgm_unit_mg));
        getBinding().rbMmol.setText(getString(R.string.cgm_unit_mmol));
    }

    public void onViewCreated(View view, Bundle bundle) {
        int i;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LayoutUnitChoseDialogBinding binding2 = getBinding();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = UnitManager.GlucoseUnit.MG_PER_DL;
        binding2.rgUnits.setOnCheckedChangeListener(new UnitChoseFragment$$ExternalSyntheticLambda0(objectRef));
        RadioGroup radioGroup = binding2.rgUnits;
        int i2 = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i2 == 1) {
            i = R.id.rb_mmol;
        } else if (i2 == 2) {
            i = R.id.rb_mg;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        radioGroup.check(i);
        binding2.buttonConfirm.setOnClickListener(new UnitChoseFragment$$ExternalSyntheticLambda1(this, objectRef));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$0(Ref.ObjectRef objectRef, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(objectRef, "$glucoseTempUnit");
        if (i == R.id.rb_mmol) {
            objectRef.element = UnitManager.GlucoseUnit.MMOL_PER_L;
        } else if (i == R.id.rb_mg) {
            objectRef.element = UnitManager.GlucoseUnit.MG_PER_DL;
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$1(UnitChoseFragment unitChoseFragment, Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(unitChoseFragment, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$glucoseTempUnit");
        Dialogs.INSTANCE.showWait(unitChoseFragment.getString(R.string.com_loading));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(unitChoseFragment), (CoroutineContext) null, (CoroutineStart) null, new UnitChoseFragment$onViewCreated$1$2$1(unitChoseFragment, objectRef, (Continuation<? super UnitChoseFragment$onViewCreated$1$2$1>) null), 3, (Object) null);
    }

    public void onStart() {
        Window window;
        Resources resources;
        DisplayMetrics displayMetrics;
        super.onStart();
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Context context = getContext();
            if (!(context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                attributes.width = displayMetrics.widthPixels - (ExtendsKt.dp2px((Number) 40) * 2);
            }
            window.setAttributes(attributes);
        }
    }
}
