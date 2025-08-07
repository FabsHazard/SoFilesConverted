package com.microtech.aidexx.ui.main.event.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.flyco.roundview.RoundTextView;
import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.DialogInsulinPresetBinding;
import com.microtech.aidexx.db.entity.event.InsulinDetail;
import com.microtech.aidexx.ui.main.event.viewmodels.InsulinViewModel;
import com.microtech.aidexx.utils.DecimalInputTextWatcher;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.bottom.BaseBottomDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\n\u0012%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\n¢\u0006\u0002\u0010\u0010J\b\u0010#\u001a\u00020\u000eH\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u000eH\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\u0012\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u000eH\u0016R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006."}, d2 = {"Lcom/microtech/aidexx/ui/main/event/dialog/InsulinPresetDialog;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomDialog;", "mFragment", "Landroidx/fragment/app/Fragment;", "oldInsulinEntity", "Lcom/microtech/aidexx/db/entity/event/InsulinDetail;", "supportDelete", "", "needSaveNewPreset", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "insulinDetailEntity", "", "onDeleteClick", "(Landroidx/fragment/app/Fragment;Lcom/microtech/aidexx/db/entity/event/InsulinDetail;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/microtech/aidexx/databinding/DialogInsulinPresetBinding;", "getBinding", "()Lcom/microtech/aidexx/databinding/DialogInsulinPresetBinding;", "setBinding", "(Lcom/microtech/aidexx/databinding/DialogInsulinPresetBinding;)V", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "textWatcher", "Lcom/microtech/aidexx/utils/DecimalInputTextWatcher;", "vm", "Lcom/microtech/aidexx/ui/main/event/viewmodels/InsulinViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/event/viewmodels/InsulinViewModel;", "vm$delegate", "Lkotlin/Lazy;", "applyDynamicLanguageRes", "getFocusView", "Landroid/view/View;", "initBtnEvent", "initPresetValue", "initView", "intDeleteUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InsulinPresetDialog.kt */
public final class InsulinPresetDialog extends BaseBottomDialog {
    public DialogInsulinPresetBinding binding;
    private Fragment mFragment;
    /* access modifiers changed from: private */
    public final boolean needSaveNewPreset;
    /* access modifiers changed from: private */
    public final InsulinDetail oldInsulinEntity;
    /* access modifiers changed from: private */
    public final Function1<InsulinDetail, Unit> onConfirmClick;
    /* access modifiers changed from: private */
    public final Function1<InsulinDetail, Unit> onDeleteClick;
    private final boolean supportDelete;
    private DecimalInputTextWatcher textWatcher;
    private final Lazy vm$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InsulinPresetDialog(Fragment fragment, InsulinDetail insulinDetail, boolean z, boolean z2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, insulinDetail, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, function1, (i & 32) != 0 ? null : function12);
    }

    public final Fragment getMFragment() {
        return this.mFragment;
    }

    public final void setMFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.mFragment = fragment;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InsulinPresetDialog(Fragment fragment, InsulinDetail insulinDetail, boolean z, boolean z2, Function1<? super InsulinDetail, Unit> function1, Function1<? super InsulinDetail, Unit> function12) {
        super(fragment.requireContext());
        Intrinsics.checkNotNullParameter(fragment, "mFragment");
        Intrinsics.checkNotNullParameter(insulinDetail, "oldInsulinEntity");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        this.mFragment = fragment;
        this.oldInsulinEntity = insulinDetail;
        this.supportDelete = z;
        this.needSaveNewPreset = z2;
        this.onConfirmClick = function1;
        this.onDeleteClick = function12;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new InsulinPresetDialog$special$$inlined$viewModels$default$2(new InsulinPresetDialog$special$$inlined$viewModels$default$1(fragment)));
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(InsulinViewModel.class), new InsulinPresetDialog$special$$inlined$viewModels$default$3(lazy), new InsulinPresetDialog$special$$inlined$viewModels$default$4((Function0) null, lazy), new InsulinPresetDialog$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: private */
    public final InsulinViewModel getVm() {
        return (InsulinViewModel) this.vm$delegate.getValue();
    }

    public final DialogInsulinPresetBinding getBinding() {
        DialogInsulinPresetBinding dialogInsulinPresetBinding = this.binding;
        if (dialogInsulinPresetBinding != null) {
            return dialogInsulinPresetBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogInsulinPresetBinding dialogInsulinPresetBinding) {
        Intrinsics.checkNotNullParameter(dialogInsulinPresetBinding, "<set-?>");
        this.binding = dialogInsulinPresetBinding;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogInsulinPresetBinding inflate = DialogInsulinPresetBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        applyDynamicLanguageRes();
        setContentView(getBinding().getRoot());
        initView();
    }

    private final void initView() {
        DialogInsulinPresetBinding binding2 = getBinding();
        EditText editText = binding2.etDosage;
        Intrinsics.checkNotNullExpressionValue(editText, "etDosage");
        this.textWatcher = new DecimalInputTextWatcher(editText, 10, 3);
        EditText editText2 = binding2.etDosage;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcher;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
            decimalInputTextWatcher = null;
        }
        editText2.addTextChangedListener(decimalInputTextWatcher);
        initPresetValue();
        intDeleteUI();
        initBtnEvent();
    }

    private final void initBtnEvent() {
        DialogInsulinPresetBinding binding2 = getBinding();
        RoundTextView roundTextView = binding2.btnCancel;
        Intrinsics.checkNotNullExpressionValue(roundTextView, "btnCancel");
        ExtendsKt.setDebounceClickListener$default(roundTextView, 0, new InsulinPresetDialog$$ExternalSyntheticLambda1(this), 1, (Object) null);
        View view = binding2.viWhiteSpace;
        Intrinsics.checkNotNullExpressionValue(view, "viWhiteSpace");
        ExtendsKt.setDebounceClickListener$default(view, 0, new InsulinPresetDialog$$ExternalSyntheticLambda2(this), 1, (Object) null);
        RoundTextView roundTextView2 = binding2.btnOk;
        Intrinsics.checkNotNullExpressionValue(roundTextView2, "btnOk");
        ExtendsKt.setDebounceClickListener$default(roundTextView2, 0, new InsulinPresetDialog$$ExternalSyntheticLambda3(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$4$lambda$1(InsulinPresetDialog insulinPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(insulinPresetDialog, "this$0");
        insulinPresetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$4$lambda$2(InsulinPresetDialog insulinPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(insulinPresetDialog, "this$0");
        insulinPresetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$4$lambda$3(InsulinPresetDialog insulinPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(insulinPresetDialog, "this$0");
        DecimalInputTextWatcher decimalInputTextWatcher = insulinPresetDialog.textWatcher;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
            decimalInputTextWatcher = null;
        }
        Double doubleValue = decimalInputTextWatcher.getDoubleValue();
        if (doubleValue == null) {
            String string = insulinPresetDialog.mFragment.getString(R.string.event_insulin_edit_valueHint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
            return;
        }
        insulinPresetDialog.oldInsulinEntity.setQuantity(doubleValue.doubleValue());
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(insulinPresetDialog.mFragment), (CoroutineContext) null, (CoroutineStart) null, new InsulinPresetDialog$initBtnEvent$1$3$1(insulinPresetDialog, (Continuation<? super InsulinPresetDialog$initBtnEvent$1$3$1>) null), 3, (Object) null);
    }

    private final void initPresetValue() {
        String str;
        DialogInsulinPresetBinding binding2 = getBinding();
        CharSequence tradeName = this.oldInsulinEntity.getTradeName();
        if (tradeName != null) {
            CharSequence charSequence = tradeName;
            if (charSequence.length() == 0) {
                charSequence = this.oldInsulinEntity.getManufacturer();
            }
            str = (String) charSequence;
        } else {
            str = null;
        }
        TextView textView = binding2.tvInsulinName;
        StringBuilder sb = new StringBuilder();
        sb.append(this.oldInsulinEntity.getName());
        sb.append((str == null || str.length() != 0) ? "(" + str + ')' : "");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        textView.setText(sb2);
        if (this.oldInsulinEntity.getQuantity() > Utils.DOUBLE_EPSILON) {
            binding2.etDosage.setText(ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.oldInsulinEntity.getQuantity()), (Integer) null, 1, (Object) null));
        }
    }

    private final void intDeleteUI() {
        boolean z;
        ImageView imageView = getBinding().ivDelete;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivDelete");
        View view = imageView;
        int i = 0;
        if (this.supportDelete) {
            getBinding().ivDelete.setOnClickListener(new InsulinPresetDialog$$ExternalSyntheticLambda0(this));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    /* access modifiers changed from: private */
    public static final void intDeleteUI$lambda$8(InsulinPresetDialog insulinPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(insulinPresetDialog, "this$0");
        Dialogs dialogs = Dialogs.INSTANCE;
        FragmentActivity activity = insulinPresetDialog.mFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Dialogs.showWhether$default(dialogs, (AppCompatActivity) activity, (String) null, insulinPresetDialog.mFragment.getString(R.string.com_delete_confirm), new InsulinPresetDialog$intDeleteUI$1$1(insulinPresetDialog), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EditText editText = getBinding().etDosage;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcher;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
            decimalInputTextWatcher = null;
        }
        editText.removeTextChangedListener(decimalInputTextWatcher);
    }

    public View getFocusView() {
        return getBinding().etDosage;
    }

    private final void applyDynamicLanguageRes() {
        DialogInsulinPresetBinding binding2 = getBinding();
        binding2.labelQuality.setText(getContext().getString(R.string.event_insulin_quality));
        binding2.etDosage.setHint(getContext().getString(R.string.event_insulin_edit_valueHint));
        binding2.btnCancel.setText(getContext().getString(R.string.com_action_cancel));
        binding2.btnOk.setText(getContext().getString(R.string.com_action_sure));
    }
}
