package com.microtech.aidexx.ui.main.event.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.flyco.roundview.RoundTextView;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.EventUnitManager;
import com.microtech.aidexx.data.resource.SpecificationModel;
import com.microtech.aidexx.databinding.DialogMedicinePresetBinding;
import com.microtech.aidexx.db.entity.event.MedicationDetail;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel;
import com.microtech.aidexx.utils.DecimalInputTextWatcher;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.bottom.BaseBottomDialog;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\n\u0012'\b\u0002\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\b\u0010\u001e\u001a\u00020\rH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\rH\u0003J\b\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\rH\u0002J\u0012\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\rH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R-\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/dialog/MedicinePresetDialog;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomDialog;", "mFragment", "Landroidx/fragment/app/Fragment;", "medicineDetailEntity", "Lcom/microtech/aidexx/db/entity/event/MedicationDetail;", "supportDelete", "", "needSaveNewPreset", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "onDeleteClick", "(Landroidx/fragment/app/Fragment;Lcom/microtech/aidexx/db/entity/event/MedicationDetail;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/microtech/aidexx/databinding/DialogMedicinePresetBinding;", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "textWatcher", "Lcom/microtech/aidexx/utils/DecimalInputTextWatcher;", "vm", "Lcom/microtech/aidexx/ui/main/event/viewmodels/MedicineViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/event/viewmodels/MedicineViewModel;", "vm$delegate", "Lkotlin/Lazy;", "applyDynamicLanguageRes", "getFocusView", "Landroid/view/View;", "initBtnEvent", "initPresetValue", "initUnitUi", "initView", "intDeleteUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MedicinePresetDialog.kt */
public final class MedicinePresetDialog extends BaseBottomDialog {
    private DialogMedicinePresetBinding binding;
    private Fragment mFragment;
    /* access modifiers changed from: private */
    public final MedicationDetail medicineDetailEntity;
    /* access modifiers changed from: private */
    public final boolean needSaveNewPreset;
    /* access modifiers changed from: private */
    public final Function1<MedicationDetail, Unit> onConfirmClick;
    /* access modifiers changed from: private */
    public final Function1<MedicationDetail, Unit> onDeleteClick;
    private final boolean supportDelete;
    private DecimalInputTextWatcher textWatcher;
    private final Lazy vm$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MedicinePresetDialog(Fragment fragment, MedicationDetail medicationDetail, boolean z, boolean z2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, medicationDetail, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, function1, (i & 32) != 0 ? null : function12);
    }

    public final Fragment getMFragment() {
        return this.mFragment;
    }

    public final void setMFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.mFragment = fragment;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MedicinePresetDialog(Fragment fragment, MedicationDetail medicationDetail, boolean z, boolean z2, Function1<? super MedicationDetail, Unit> function1, Function1<? super MedicationDetail, Unit> function12) {
        super(fragment.requireContext());
        Intrinsics.checkNotNullParameter(fragment, "mFragment");
        Intrinsics.checkNotNullParameter(medicationDetail, "medicineDetailEntity");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        this.mFragment = fragment;
        this.medicineDetailEntity = medicationDetail;
        this.supportDelete = z;
        this.needSaveNewPreset = z2;
        this.onConfirmClick = function1;
        this.onDeleteClick = function12;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new MedicinePresetDialog$special$$inlined$viewModels$default$2(new MedicinePresetDialog$special$$inlined$viewModels$default$1(fragment)));
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(MedicineViewModel.class), new MedicinePresetDialog$special$$inlined$viewModels$default$3(lazy), new MedicinePresetDialog$special$$inlined$viewModels$default$4((Function0) null, lazy), new MedicinePresetDialog$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: private */
    public final MedicineViewModel getVm() {
        return (MedicineViewModel) this.vm$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogMedicinePresetBinding inflate = DialogMedicinePresetBinding.inflate(LayoutInflater.from(this.mFragment.requireContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        applyDynamicLanguageRes();
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        setContentView(dialogMedicinePresetBinding.getRoot());
        initView();
    }

    private final void initView() {
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        DecimalInputTextWatcher decimalInputTextWatcher = null;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        EditText editText = dialogMedicinePresetBinding.etDose;
        Intrinsics.checkNotNullExpressionValue(editText, "etDose");
        this.textWatcher = new DecimalInputTextWatcher(editText, 10, 3);
        EditText editText2 = dialogMedicinePresetBinding.etDose;
        DecimalInputTextWatcher decimalInputTextWatcher2 = this.textWatcher;
        if (decimalInputTextWatcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
        } else {
            decimalInputTextWatcher = decimalInputTextWatcher2;
        }
        editText2.addTextChangedListener(decimalInputTextWatcher);
        initUnitUi();
        intDeleteUI();
        initPresetValue();
        initBtnEvent();
    }

    private final void initBtnEvent() {
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        RoundTextView roundTextView = dialogMedicinePresetBinding.btnCancel;
        Intrinsics.checkNotNullExpressionValue(roundTextView, "btnCancel");
        ExtendsKt.setDebounceClickListener$default(roundTextView, 0, new MedicinePresetDialog$$ExternalSyntheticLambda2(this), 1, (Object) null);
        dialogMedicinePresetBinding.viWhiteSpace.setOnClickListener(new MedicinePresetDialog$$ExternalSyntheticLambda3(this));
        RoundTextView roundTextView2 = dialogMedicinePresetBinding.btnOk;
        Intrinsics.checkNotNullExpressionValue(roundTextView2, "btnOk");
        ExtendsKt.setDebounceClickListener$default(roundTextView2, 0, new MedicinePresetDialog$$ExternalSyntheticLambda4(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$4$lambda$1(MedicinePresetDialog medicinePresetDialog, View view) {
        Intrinsics.checkNotNullParameter(medicinePresetDialog, "this$0");
        medicinePresetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$4$lambda$2(MedicinePresetDialog medicinePresetDialog, View view) {
        Intrinsics.checkNotNullParameter(medicinePresetDialog, "this$0");
        medicinePresetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$4$lambda$3(MedicinePresetDialog medicinePresetDialog, View view) {
        Intrinsics.checkNotNullParameter(medicinePresetDialog, "this$0");
        DecimalInputTextWatcher decimalInputTextWatcher = medicinePresetDialog.textWatcher;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
            decimalInputTextWatcher = null;
        }
        Double doubleValue = decimalInputTextWatcher.getDoubleValue();
        if (doubleValue == null) {
            String string = medicinePresetDialog.getContext().getString(R.string.event_medicine_edit_valueHint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
            return;
        }
        medicinePresetDialog.medicineDetailEntity.setQuantity(doubleValue.doubleValue());
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(medicinePresetDialog.mFragment), (CoroutineContext) null, (CoroutineStart) null, new MedicinePresetDialog$initBtnEvent$1$3$1(medicinePresetDialog, (Continuation<? super MedicinePresetDialog$initBtnEvent$1$3$1>) null), 3, (Object) null);
    }

    private final void initPresetValue() {
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        CharSequence tradeName = this.medicineDetailEntity.getTradeName();
        if (tradeName.length() == 0) {
            tradeName = this.medicineDetailEntity.getManufacturer();
        }
        String str = (String) tradeName;
        TextView textView = dialogMedicinePresetBinding.tvCategoryName;
        StringBuilder sb = new StringBuilder();
        sb.append(this.medicineDetailEntity.getName());
        sb.append(str.length() == 0 ? "" : "(" + str + ')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        textView.setText(sb2);
        if (Utils.DOUBLE_EPSILON != this.medicineDetailEntity.getQuantity()) {
            dialogMedicinePresetBinding.etDose.setText(ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.medicineDetailEntity.getQuantity()), (Integer) null, 1, (Object) null));
        }
    }

    private final void initUnitUi() {
        DialogMedicinePresetBinding dialogMedicinePresetBinding;
        Object obj;
        Object obj2;
        List<SpecificationModel> medicationUnitList = EventUnitManager.INSTANCE.getMedicationUnitList();
        int size = medicationUnitList.size();
        for (int i = 0; i < size; i++) {
            medicationUnitList.get(i).setCheck(false);
        }
        Iterable iterable = medicationUnitList;
        Iterator it = iterable.iterator();
        while (true) {
            dialogMedicinePresetBinding = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpecificationModel) obj).getCode() == this.medicineDetailEntity.getUnit()) {
                break;
            }
        }
        SpecificationModel specificationModel = (SpecificationModel) obj;
        if (specificationModel != null) {
            specificationModel.setCheck(true);
        } else {
            MedicinePresetDialog medicinePresetDialog = this;
            Iterator it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (((SpecificationModel) obj2).isDefault()) {
                    break;
                }
            }
            specificationModel = (SpecificationModel) obj2;
            if (specificationModel != null) {
                specificationModel.setCheck(true);
            } else {
                specificationModel = null;
            }
        }
        if (specificationModel != null) {
            this.medicineDetailEntity.setUnit(specificationModel.getCode());
            this.medicineDetailEntity.setUnitStr(specificationModel.getSpecification());
        }
        DialogMedicinePresetBinding dialogMedicinePresetBinding2 = this.binding;
        if (dialogMedicinePresetBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding2 = null;
        }
        RecyclerView recyclerView = dialogMedicinePresetBinding2.rvSpecification;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(2);
        flexboxLayoutManager.setFlexWrap(1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        DialogMedicinePresetBinding dialogMedicinePresetBinding3 = this.binding;
        if (dialogMedicinePresetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogMedicinePresetBinding = dialogMedicinePresetBinding3;
        }
        RecyclerView recyclerView2 = dialogMedicinePresetBinding.rvSpecification;
        SpecificationAdapter specificationAdapter = new SpecificationAdapter(medicationUnitList);
        specificationAdapter.setOnItemClickListener(new MedicinePresetDialog$$ExternalSyntheticLambda0(medicationUnitList, specificationAdapter, this));
        recyclerView2.setAdapter(specificationAdapter);
    }

    /* access modifiers changed from: private */
    public static final void initUnitUi$lambda$16$lambda$15(List list, SpecificationAdapter specificationAdapter, MedicinePresetDialog medicinePresetDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(list, "$medicationUnits");
        Intrinsics.checkNotNullParameter(specificationAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(medicinePresetDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (((SpecificationModel) list.get(i2)).getCheck()) {
                ((SpecificationModel) list.get(i2)).setCheck(false);
                specificationAdapter.notifyItemChanged(i2);
                break;
            } else {
                i2++;
            }
        }
        ((SpecificationModel) list.get(i)).setCheck(!((SpecificationModel) list.get(i)).getCheck());
        medicinePresetDialog.medicineDetailEntity.setUnit(((SpecificationModel) list.get(i)).getCode());
        medicinePresetDialog.medicineDetailEntity.setUnitStr(((SpecificationModel) list.get(i)).getSpecification());
        specificationAdapter.notifyItemChanged(i);
    }

    private final void intDeleteUI() {
        boolean z;
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        DialogMedicinePresetBinding dialogMedicinePresetBinding2 = null;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        ImageView imageView = dialogMedicinePresetBinding.ivDelete;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivDelete");
        View view = imageView;
        int i = 0;
        if (this.supportDelete) {
            DialogMedicinePresetBinding dialogMedicinePresetBinding3 = this.binding;
            if (dialogMedicinePresetBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogMedicinePresetBinding2 = dialogMedicinePresetBinding3;
            }
            dialogMedicinePresetBinding2.ivDelete.setOnClickListener(new MedicinePresetDialog$$ExternalSyntheticLambda1(this));
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
    public static final void intDeleteUI$lambda$17(MedicinePresetDialog medicinePresetDialog, View view) {
        Intrinsics.checkNotNullParameter(medicinePresetDialog, "this$0");
        Dialogs dialogs = Dialogs.INSTANCE;
        FragmentActivity activity = medicinePresetDialog.mFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Dialogs.showWhether$default(dialogs, (AppCompatActivity) activity, (String) null, medicinePresetDialog.mFragment.getString(R.string.com_delete_confirm), new MedicinePresetDialog$intDeleteUI$1$1(medicinePresetDialog), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        DecimalInputTextWatcher decimalInputTextWatcher = null;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        EditText editText = dialogMedicinePresetBinding.etDose;
        DecimalInputTextWatcher decimalInputTextWatcher2 = this.textWatcher;
        if (decimalInputTextWatcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
        } else {
            decimalInputTextWatcher = decimalInputTextWatcher2;
        }
        editText.removeTextChangedListener(decimalInputTextWatcher);
    }

    public View getFocusView() {
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        return dialogMedicinePresetBinding.etDose;
    }

    private final void applyDynamicLanguageRes() {
        DialogMedicinePresetBinding dialogMedicinePresetBinding = this.binding;
        if (dialogMedicinePresetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogMedicinePresetBinding = null;
        }
        dialogMedicinePresetBinding.labelQuality.setText(getContext().getString(R.string.event_medicine_quality));
        dialogMedicinePresetBinding.etDose.setHint(getContext().getString(R.string.event_medicine_edit_valueHint));
        dialogMedicinePresetBinding.labelUnit.setText(getContext().getString(R.string.event_medicine_unit));
        dialogMedicinePresetBinding.btnCancel.setText(getContext().getString(R.string.com_action_cancel));
        dialogMedicinePresetBinding.btnOk.setText(getContext().getString(R.string.com_action_sure));
    }
}
