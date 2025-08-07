package com.microtech.aidexx.ui.main.event.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.microtech.aidexx.databinding.DialogSportPresetBinding;
import com.microtech.aidexx.db.entity.event.ExerciseDetail;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.ui.main.event.viewmodels.SportViewModel;
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

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\n\u0012'\b\u0002\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\b\u0010%\u001a\u00020\rH\u0002J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\rH\u0003J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\u0012\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020\rH\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R-\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/dialog/SportPresetDialog;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomDialog;", "mFragment", "Landroidx/fragment/app/Fragment;", "sportDetailEntity", "Lcom/microtech/aidexx/db/entity/event/ExerciseDetail;", "supportDelete", "", "needSaveNewPreset", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "onDeleteClick", "(Landroidx/fragment/app/Fragment;Lcom/microtech/aidexx/db/entity/event/ExerciseDetail;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/microtech/aidexx/databinding/DialogSportPresetBinding;", "getBinding", "()Lcom/microtech/aidexx/databinding/DialogSportPresetBinding;", "setBinding", "(Lcom/microtech/aidexx/databinding/DialogSportPresetBinding;)V", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "textWatcher", "Lcom/microtech/aidexx/utils/DecimalInputTextWatcher;", "timeUnits", "", "Lcom/microtech/aidexx/data/resource/SpecificationModel;", "vm", "Lcom/microtech/aidexx/ui/main/event/viewmodels/SportViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/event/viewmodels/SportViewModel;", "vm$delegate", "Lkotlin/Lazy;", "applyDynamicLanguageRes", "getFocusView", "Landroid/view/View;", "hasChooseUnit", "initBtnEvent", "initPresetValue", "initUnitUi", "initView", "intDeleteUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SportPresetDialog.kt */
public final class SportPresetDialog extends BaseBottomDialog {
    public DialogSportPresetBinding binding;
    private Fragment mFragment;
    /* access modifiers changed from: private */
    public final boolean needSaveNewPreset;
    /* access modifiers changed from: private */
    public final Function1<ExerciseDetail, Unit> onConfirmClick;
    /* access modifiers changed from: private */
    public final Function1<ExerciseDetail, Unit> onDeleteClick;
    /* access modifiers changed from: private */
    public final ExerciseDetail sportDetailEntity;
    private final boolean supportDelete;
    private DecimalInputTextWatcher textWatcher;
    private final List<SpecificationModel> timeUnits;
    private final Lazy vm$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SportPresetDialog(Fragment fragment, ExerciseDetail exerciseDetail, boolean z, boolean z2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, exerciseDetail, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, function1, (i & 32) != 0 ? null : function12);
    }

    public final Fragment getMFragment() {
        return this.mFragment;
    }

    public final void setMFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.mFragment = fragment;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SportPresetDialog(Fragment fragment, ExerciseDetail exerciseDetail, boolean z, boolean z2, Function1<? super ExerciseDetail, Unit> function1, Function1<? super ExerciseDetail, Unit> function12) {
        super(fragment.requireContext());
        Intrinsics.checkNotNullParameter(fragment, "mFragment");
        Intrinsics.checkNotNullParameter(exerciseDetail, "sportDetailEntity");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        this.mFragment = fragment;
        this.sportDetailEntity = exerciseDetail;
        this.supportDelete = z;
        this.needSaveNewPreset = z2;
        this.onConfirmClick = function1;
        this.onDeleteClick = function12;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SportPresetDialog$special$$inlined$viewModels$default$2(new SportPresetDialog$special$$inlined$viewModels$default$1(fragment)));
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SportViewModel.class), new SportPresetDialog$special$$inlined$viewModels$default$3(lazy), new SportPresetDialog$special$$inlined$viewModels$default$4((Function0) null, lazy), new SportPresetDialog$special$$inlined$viewModels$default$5(fragment, lazy));
        this.timeUnits = EventUnitManager.INSTANCE.getTimeUnitList();
    }

    /* access modifiers changed from: private */
    public final SportViewModel getVm() {
        return (SportViewModel) this.vm$delegate.getValue();
    }

    public final DialogSportPresetBinding getBinding() {
        DialogSportPresetBinding dialogSportPresetBinding = this.binding;
        if (dialogSportPresetBinding != null) {
            return dialogSportPresetBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogSportPresetBinding dialogSportPresetBinding) {
        Intrinsics.checkNotNullParameter(dialogSportPresetBinding, "<set-?>");
        this.binding = dialogSportPresetBinding;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogSportPresetBinding inflate = DialogSportPresetBinding.inflate(LayoutInflater.from(this.mFragment.requireContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        applyDynamicLanguageRes();
        setContentView(getBinding().getRoot());
        initView();
    }

    private final void initView() {
        DialogSportPresetBinding binding2 = getBinding();
        EditText editText = binding2.etDuration;
        Intrinsics.checkNotNullExpressionValue(editText, "etDuration");
        this.textWatcher = new DecimalInputTextWatcher(editText, 10, 3);
        EditText editText2 = binding2.etDuration;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcher;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
            decimalInputTextWatcher = null;
        }
        editText2.addTextChangedListener(decimalInputTextWatcher);
        initUnitUi();
        intDeleteUI();
        initPresetValue();
        initBtnEvent();
    }

    private final void initBtnEvent() {
        DialogSportPresetBinding binding2 = getBinding();
        RoundTextView roundTextView = binding2.btnCancel;
        Intrinsics.checkNotNullExpressionValue(roundTextView, "btnCancel");
        ExtendsKt.setDebounceClickListener$default(roundTextView, 0, new SportPresetDialog$$ExternalSyntheticLambda1(this), 1, (Object) null);
        RoundTextView roundTextView2 = binding2.btnOk;
        Intrinsics.checkNotNullExpressionValue(roundTextView2, "btnOk");
        ExtendsKt.setDebounceClickListener$default(roundTextView2, 0, new SportPresetDialog$$ExternalSyntheticLambda2(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$3$lambda$1(SportPresetDialog sportPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(sportPresetDialog, "this$0");
        sportPresetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initBtnEvent$lambda$3$lambda$2(SportPresetDialog sportPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(sportPresetDialog, "this$0");
        DecimalInputTextWatcher decimalInputTextWatcher = sportPresetDialog.textWatcher;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
            decimalInputTextWatcher = null;
        }
        Double doubleValue = decimalInputTextWatcher.getDoubleValue();
        if (doubleValue == null) {
            String string = sportPresetDialog.mFragment.getString(R.string.event_exercise_edit_valueHint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        } else if (!sportPresetDialog.hasChooseUnit()) {
            String string2 = sportPresetDialog.mFragment.getString(R.string.event_exercise_edit_unitHint);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
        } else {
            sportPresetDialog.sportDetailEntity.setQuantity(doubleValue.doubleValue());
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(sportPresetDialog.mFragment), (CoroutineContext) null, (CoroutineStart) null, new SportPresetDialog$initBtnEvent$1$2$1(sportPresetDialog, (Continuation<? super SportPresetDialog$initBtnEvent$1$2$1>) null), 3, (Object) null);
        }
    }

    private final void initPresetValue() {
        DialogSportPresetBinding binding2 = getBinding();
        binding2.tvCategoryName.setText(this.sportDetailEntity.getName());
        if (Utils.DOUBLE_EPSILON != this.sportDetailEntity.getQuantity()) {
            binding2.etDuration.setText(ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.sportDetailEntity.getQuantity()), (Integer) null, 1, (Object) null));
        }
    }

    private final boolean hasChooseUnit() {
        Object obj;
        Iterator it = this.timeUnits.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpecificationModel) obj).getCheck()) {
                break;
            }
        }
        return obj != null;
    }

    private final void initUnitUi() {
        SpecificationModel specificationModel;
        Object obj;
        Object obj2;
        int size = this.timeUnits.size();
        for (int i = 0; i < size; i++) {
            this.timeUnits.get(i).setCheck(false);
        }
        Iterator it = this.timeUnits.iterator();
        while (true) {
            specificationModel = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpecificationModel) obj).getCode() == this.sportDetailEntity.getUnit()) {
                break;
            }
        }
        SpecificationModel specificationModel2 = (SpecificationModel) obj;
        if (specificationModel2 != null) {
            specificationModel2.setCheck(true);
        } else {
            SportPresetDialog sportPresetDialog = this;
            Iterator it2 = this.timeUnits.iterator();
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
            SpecificationModel specificationModel3 = (SpecificationModel) obj2;
            if (specificationModel3 != null) {
                specificationModel3.setCheck(true);
                specificationModel = specificationModel3;
            }
            specificationModel2 = specificationModel;
        }
        if (specificationModel2 != null) {
            this.sportDetailEntity.setUnit(specificationModel2.getCode());
            this.sportDetailEntity.setUnitStr(specificationModel2.getSpecification());
        }
        RecyclerView recyclerView = getBinding().rvSpecification;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(2);
        flexboxLayoutManager.setFlexWrap(1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        RecyclerView recyclerView2 = getBinding().rvSpecification;
        SpecificationAdapter specificationAdapter = new SpecificationAdapter(this.timeUnits);
        specificationAdapter.setOnItemClickListener(new SportPresetDialog$$ExternalSyntheticLambda0(this, specificationAdapter));
        recyclerView2.setAdapter(specificationAdapter);
    }

    /* access modifiers changed from: private */
    public static final void initUnitUi$lambda$14$lambda$13(SportPresetDialog sportPresetDialog, SpecificationAdapter specificationAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(sportPresetDialog, "this$0");
        Intrinsics.checkNotNullParameter(specificationAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int size = sportPresetDialog.timeUnits.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (sportPresetDialog.timeUnits.get(i2).getCheck()) {
                sportPresetDialog.timeUnits.get(i2).setCheck(false);
                specificationAdapter.notifyItemChanged(i2);
                break;
            } else {
                i2++;
            }
        }
        sportPresetDialog.timeUnits.get(i).setCheck(!sportPresetDialog.timeUnits.get(i).getCheck());
        sportPresetDialog.sportDetailEntity.setUnit(sportPresetDialog.timeUnits.get(i).getCode());
        sportPresetDialog.sportDetailEntity.setUnitStr(sportPresetDialog.timeUnits.get(i).getSpecification());
        specificationAdapter.notifyItemChanged(i);
    }

    private final void intDeleteUI() {
        boolean z;
        ImageView imageView = getBinding().ivDelete;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivDelete");
        View view = imageView;
        int i = 0;
        if (this.supportDelete) {
            getBinding().ivDelete.setOnClickListener(new SportPresetDialog$$ExternalSyntheticLambda3(this));
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
    public static final void intDeleteUI$lambda$15(SportPresetDialog sportPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(sportPresetDialog, "this$0");
        Dialogs dialogs = Dialogs.INSTANCE;
        FragmentActivity activity = sportPresetDialog.mFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Dialogs.showWhether$default(dialogs, (AppCompatActivity) activity, (String) null, sportPresetDialog.mFragment.getString(R.string.com_delete_confirm), new SportPresetDialog$intDeleteUI$1$1(sportPresetDialog), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EditText editText = getBinding().etDuration;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcher;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcher");
            decimalInputTextWatcher = null;
        }
        editText.removeTextChangedListener(decimalInputTextWatcher);
    }

    public View getFocusView() {
        return getBinding().etDuration;
    }

    private final void applyDynamicLanguageRes() {
        DialogSportPresetBinding binding2 = getBinding();
        binding2.labelQuality.setText(getContext().getString(R.string.event_exercise_quality));
        binding2.etDuration.setHint(getContext().getString(R.string.event_exercise_edit_valueHint));
        binding2.labelUnit.setText(getContext().getString(R.string.event_exercise_unit));
        binding2.btnCancel.setText(getContext().getString(R.string.com_action_cancel));
        binding2.btnOk.setText(getContext().getString(R.string.com_action_sure));
    }
}
