package com.microtech.aidexx.ui.main.event.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.resource.EventUnitManager;
import com.microtech.aidexx.data.resource.SpecificationModel;
import com.microtech.aidexx.databinding.DialogDietNewPresetBinding;
import com.microtech.aidexx.db.entity.event.DietDetail;
import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.ui.main.event.viewmodels.DietViewModel;
import com.microtech.aidexx.utils.DecimalInputTextWatcher;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010(\u001a\u00020\nH\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\nH\u0003J\b\u0010-\u001a\u00020\nH\u0002J\u0012\u0010.\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0002R\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%¨\u00063"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/dialog/DietNewPresetDialog;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomDialog;", "mFragment", "Landroidx/fragment/app/Fragment;", "dietDetail", "Lcom/microtech/aidexx/db/entity/event/DietDetail;", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "(Landroidx/fragment/app/Fragment;Lcom/microtech/aidexx/db/entity/event/DietDetail;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/microtech/aidexx/databinding/DialogDietNewPresetBinding;", "getBinding", "()Lcom/microtech/aidexx/databinding/DialogDietNewPresetBinding;", "setBinding", "(Lcom/microtech/aidexx/databinding/DialogDietNewPresetBinding;)V", "defaultWeight", "", "getMFragment", "()Landroidx/fragment/app/Fragment;", "setMFragment", "(Landroidx/fragment/app/Fragment;)V", "getOnConfirmClick", "()Lkotlin/jvm/functions/Function1;", "specificationModelList", "", "Lcom/microtech/aidexx/data/resource/SpecificationModel;", "textWatcherCarbohydrate", "Lcom/microtech/aidexx/utils/DecimalInputTextWatcher;", "textWatcherFat", "textWatcherProtein", "textWatcherWeight", "vm", "Lcom/microtech/aidexx/ui/main/event/viewmodels/DietViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/event/viewmodels/DietViewModel;", "vm$delegate", "Lkotlin/Lazy;", "applyDynamicLanguageRes", "hasChooseUnit", "", "initPresetValue", "initUnitUi", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "setPresetValue", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DietNewPresetDialog.kt */
public final class DietNewPresetDialog extends BaseBottomDialog {
    public DialogDietNewPresetBinding binding;
    private final double defaultWeight = 100.0d;
    /* access modifiers changed from: private */
    public final DietDetail dietDetail;
    private Fragment mFragment;
    private final Function1<DietDetail, Unit> onConfirmClick;
    private final List<SpecificationModel> specificationModelList = EventUnitManager.INSTANCE.getDietUnitList();
    private DecimalInputTextWatcher textWatcherCarbohydrate;
    private DecimalInputTextWatcher textWatcherFat;
    private DecimalInputTextWatcher textWatcherProtein;
    private DecimalInputTextWatcher textWatcherWeight;
    private final Lazy vm$delegate;

    public final Fragment getMFragment() {
        return this.mFragment;
    }

    public final void setMFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.mFragment = fragment;
    }

    public final Function1<DietDetail, Unit> getOnConfirmClick() {
        return this.onConfirmClick;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DietNewPresetDialog(Fragment fragment, DietDetail dietDetail2, Function1<? super DietDetail, Unit> function1) {
        super(fragment.requireContext());
        Intrinsics.checkNotNullParameter(fragment, "mFragment");
        Intrinsics.checkNotNullParameter(dietDetail2, "dietDetail");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        this.mFragment = fragment;
        this.dietDetail = dietDetail2;
        this.onConfirmClick = function1;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new DietNewPresetDialog$special$$inlined$viewModels$default$2(new DietNewPresetDialog$special$$inlined$viewModels$default$1(fragment)));
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DietViewModel.class), new DietNewPresetDialog$special$$inlined$viewModels$default$3(lazy), new DietNewPresetDialog$special$$inlined$viewModels$default$4((Function0) null, lazy), new DietNewPresetDialog$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: private */
    public final DietViewModel getVm() {
        return (DietViewModel) this.vm$delegate.getValue();
    }

    public final DialogDietNewPresetBinding getBinding() {
        DialogDietNewPresetBinding dialogDietNewPresetBinding = this.binding;
        if (dialogDietNewPresetBinding != null) {
            return dialogDietNewPresetBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogDietNewPresetBinding dialogDietNewPresetBinding) {
        Intrinsics.checkNotNullParameter(dialogDietNewPresetBinding, "<set-?>");
        this.binding = dialogDietNewPresetBinding;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogDietNewPresetBinding inflate = DialogDietNewPresetBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        applyDynamicLanguageRes();
        setContentView(getBinding().getRoot());
        initView();
    }

    private final boolean hasChooseUnit() {
        Object obj;
        Iterator it = this.specificationModelList.iterator();
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

    private final void initView() {
        DialogDietNewPresetBinding binding2 = getBinding();
        EditText editText = binding2.etWeight;
        Intrinsics.checkNotNullExpressionValue(editText, "etWeight");
        this.textWatcherWeight = new DecimalInputTextWatcher(editText, 10, 3);
        EditText editText2 = binding2.etCarbohydrate;
        Intrinsics.checkNotNullExpressionValue(editText2, "etCarbohydrate");
        this.textWatcherCarbohydrate = new DecimalInputTextWatcher(editText2, 10, 3);
        EditText editText3 = binding2.etFat;
        Intrinsics.checkNotNullExpressionValue(editText3, "etFat");
        this.textWatcherFat = new DecimalInputTextWatcher(editText3, 10, 3);
        EditText editText4 = binding2.etProtein;
        Intrinsics.checkNotNullExpressionValue(editText4, "etProtein");
        this.textWatcherProtein = new DecimalInputTextWatcher(editText4, 10, 3);
        EditText editText5 = binding2.etWeight;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcherWeight;
        DecimalInputTextWatcher decimalInputTextWatcher2 = null;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherWeight");
            decimalInputTextWatcher = null;
        }
        editText5.addTextChangedListener(decimalInputTextWatcher);
        EditText editText6 = binding2.etProtein;
        DecimalInputTextWatcher decimalInputTextWatcher3 = this.textWatcherProtein;
        if (decimalInputTextWatcher3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherProtein");
            decimalInputTextWatcher3 = null;
        }
        editText6.addTextChangedListener(decimalInputTextWatcher3);
        EditText editText7 = binding2.etFat;
        DecimalInputTextWatcher decimalInputTextWatcher4 = this.textWatcherFat;
        if (decimalInputTextWatcher4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherFat");
            decimalInputTextWatcher4 = null;
        }
        editText7.addTextChangedListener(decimalInputTextWatcher4);
        EditText editText8 = binding2.etCarbohydrate;
        DecimalInputTextWatcher decimalInputTextWatcher5 = this.textWatcherCarbohydrate;
        if (decimalInputTextWatcher5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherCarbohydrate");
        } else {
            decimalInputTextWatcher2 = decimalInputTextWatcher5;
        }
        editText8.addTextChangedListener(decimalInputTextWatcher2);
        initUnitUi();
        initPresetValue();
        binding2.btnOk.setOnClickListener(new DietNewPresetDialog$$ExternalSyntheticLambda4(this));
        binding2.btnCancel.setOnClickListener(new DietNewPresetDialog$$ExternalSyntheticLambda5(this));
        binding2.viWhiteSpace.setOnClickListener(new DietNewPresetDialog$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$2(DietNewPresetDialog dietNewPresetDialog, View view) {
        Object obj;
        Intrinsics.checkNotNullParameter(dietNewPresetDialog, "this$0");
        try {
            DecimalInputTextWatcher decimalInputTextWatcher = dietNewPresetDialog.textWatcherWeight;
            if (decimalInputTextWatcher == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textWatcherWeight");
                decimalInputTextWatcher = null;
            }
            Double doubleValue = decimalInputTextWatcher.getDoubleValue();
            DecimalInputTextWatcher decimalInputTextWatcher2 = dietNewPresetDialog.textWatcherProtein;
            if (decimalInputTextWatcher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textWatcherProtein");
                decimalInputTextWatcher2 = null;
            }
            Double doubleValue2 = decimalInputTextWatcher2.getDoubleValue();
            DecimalInputTextWatcher decimalInputTextWatcher3 = dietNewPresetDialog.textWatcherFat;
            if (decimalInputTextWatcher3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textWatcherFat");
                decimalInputTextWatcher3 = null;
            }
            Double doubleValue3 = decimalInputTextWatcher3.getDoubleValue();
            DecimalInputTextWatcher decimalInputTextWatcher4 = dietNewPresetDialog.textWatcherCarbohydrate;
            if (decimalInputTextWatcher4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textWatcherCarbohydrate");
                decimalInputTextWatcher4 = null;
            }
            Double doubleValue4 = decimalInputTextWatcher4.getDoubleValue();
            if (doubleValue == null) {
                String string = dietNewPresetDialog.mFragment.getString(R.string.event_food_edit_valueHint);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
            } else if (doubleValue2 == null) {
                String string2 = dietNewPresetDialog.mFragment.getString(R.string.event_food_edit_protinHint);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                ExtendsKt.toast(string2);
            } else if (doubleValue3 == null) {
                String string3 = dietNewPresetDialog.mFragment.getString(R.string.event_food_edit_fatHint);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                ExtendsKt.toast(string3);
            } else if (doubleValue4 == null) {
                String string4 = dietNewPresetDialog.mFragment.getString(R.string.event_food_edit_carbHint);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                ExtendsKt.toast(string4);
            } else if (!dietNewPresetDialog.hasChooseUnit()) {
                String string5 = dietNewPresetDialog.mFragment.getString(R.string.event_food_edit_unitHint);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                ExtendsKt.toast(string5);
            } else {
                dietNewPresetDialog.dietDetail.setQuantity(doubleValue.doubleValue());
                dietNewPresetDialog.dietDetail.setProtein(doubleValue2.doubleValue());
                dietNewPresetDialog.dietDetail.setCarbohydrate(doubleValue4.doubleValue());
                dietNewPresetDialog.dietDetail.setFat(doubleValue3.doubleValue());
                double quantity = dietNewPresetDialog.dietDetail.getQuantity();
                Iterator it = dietNewPresetDialog.specificationModelList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((SpecificationModel) obj).getCode() == dietNewPresetDialog.dietDetail.getUnit()) {
                        break;
                    }
                }
                SpecificationModel specificationModel = (SpecificationModel) obj;
                double d = 1.0d;
                double ratio = (quantity * (specificationModel != null ? specificationModel.getRatio() : 1.0d)) / 100.0d;
                if (ratio != Utils.DOUBLE_EPSILON) {
                    d = ratio;
                }
                DietUsrPresetEntity dietUsrPresetEntity = new DietUsrPresetEntity();
                dietUsrPresetEntity.setIdx(0);
                dietUsrPresetEntity.setName(dietNewPresetDialog.dietDetail.getName());
                dietUsrPresetEntity.setCarbohydrate(ExtendsKt.format$default(dietNewPresetDialog.dietDetail.getCarbohydrate() / d, 0, 1, (Object) null));
                dietUsrPresetEntity.setProtein(ExtendsKt.format$default(dietNewPresetDialog.dietDetail.getProtein() / d, 0, 1, (Object) null));
                dietUsrPresetEntity.setFat(ExtendsKt.format$default(dietNewPresetDialog.dietDetail.getFat() / d, 0, 1, (Object) null));
                dietUsrPresetEntity.setUserId(UserInfoManager.Companion.instance().userId());
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(dietNewPresetDialog.mFragment), (CoroutineContext) null, (CoroutineStart) null, new DietNewPresetDialog$initView$1$1$1(dietNewPresetDialog, dietUsrPresetEntity, (Continuation<? super DietNewPresetDialog$initView$1$1$1>) null), 3, (Object) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.Companion.xLogE$default(LogUtil.Companion, "新增食物预设崩溃 e=" + e, (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$3(DietNewPresetDialog dietNewPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(dietNewPresetDialog, "this$0");
        dietNewPresetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5$lambda$4(DietNewPresetDialog dietNewPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(dietNewPresetDialog, "this$0");
        dietNewPresetDialog.dismiss();
    }

    private final void initPresetValue() {
        DialogDietNewPresetBinding binding2 = getBinding();
        binding2.tvCategoryName.setText(this.dietDetail.getName());
        if (Utils.DOUBLE_EPSILON == this.dietDetail.getQuantity()) {
            this.dietDetail.setQuantity(this.defaultWeight);
        }
        setPresetValue();
        EditText editText = binding2.etWeight;
        Intrinsics.checkNotNullExpressionValue(editText, "etWeight");
        editText.addTextChangedListener(new DietNewPresetDialog$initPresetValue$lambda$7$$inlined$addTextChangedListener$default$1());
        binding2.etWeight.setText(ExtendsKt.stripTrailingZeros(Double.valueOf(this.dietDetail.getQuantity()), 3));
    }

    private final void initUnitUi() {
        SpecificationModel specificationModel;
        Object obj;
        Object obj2;
        int size = this.specificationModelList.size();
        for (int i = 0; i < size; i++) {
            this.specificationModelList.get(i).setCheck(false);
        }
        Iterator it = this.specificationModelList.iterator();
        while (true) {
            specificationModel = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpecificationModel) obj).getCode() == this.dietDetail.getUnit()) {
                break;
            }
        }
        SpecificationModel specificationModel2 = (SpecificationModel) obj;
        if (specificationModel2 != null) {
            specificationModel2.setCheck(true);
        } else {
            DietNewPresetDialog dietNewPresetDialog = this;
            Iterator it2 = this.specificationModelList.iterator();
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
            this.dietDetail.setUnit(specificationModel2.getCode());
            this.dietDetail.setUnitStr(specificationModel2.getSpecification());
        }
        RecyclerView recyclerView = getBinding().rvSpecification;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(2);
        flexboxLayoutManager.setFlexWrap(1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        RecyclerView recyclerView2 = getBinding().rvSpecification;
        SpecificationAdapter specificationAdapter = new SpecificationAdapter(this.specificationModelList);
        specificationAdapter.setOnItemClickListener(new DietNewPresetDialog$$ExternalSyntheticLambda3(this, specificationAdapter));
        recyclerView2.setAdapter(specificationAdapter);
    }

    /* access modifiers changed from: private */
    public static final void initUnitUi$lambda$16$lambda$15(DietNewPresetDialog dietNewPresetDialog, SpecificationAdapter specificationAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(dietNewPresetDialog, "this$0");
        Intrinsics.checkNotNullParameter(specificationAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int size = dietNewPresetDialog.specificationModelList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (dietNewPresetDialog.specificationModelList.get(i2).getCheck()) {
                dietNewPresetDialog.specificationModelList.get(i2).setCheck(false);
                specificationAdapter.notifyItemChanged(i2);
                break;
            } else {
                i2++;
            }
        }
        dietNewPresetDialog.specificationModelList.get(i).setCheck(!dietNewPresetDialog.specificationModelList.get(i).getCheck());
        dietNewPresetDialog.dietDetail.setUnit(dietNewPresetDialog.specificationModelList.get(i).getCode());
        dietNewPresetDialog.dietDetail.setUnitStr(dietNewPresetDialog.specificationModelList.get(i).getSpecification());
        specificationAdapter.notifyItemChanged(i);
    }

    private final void setPresetValue() {
        DialogDietNewPresetBinding binding2 = getBinding();
        binding2.etCarbohydrate.setText(ExtendsKt.stripTrailingZeros(Double.valueOf(this.dietDetail.getCarbohydrate()), 3));
        binding2.etCarbohydrate.setOnFocusChangeListener(new DietNewPresetDialog$$ExternalSyntheticLambda0(binding2));
        binding2.etFat.setText(ExtendsKt.stripTrailingZeros(Double.valueOf(this.dietDetail.getFat()), 3));
        binding2.etFat.setOnFocusChangeListener(new DietNewPresetDialog$$ExternalSyntheticLambda1(binding2));
        binding2.etProtein.setText(ExtendsKt.stripTrailingZeros(Double.valueOf(this.dietDetail.getProtein()), 3));
        binding2.etProtein.setOnFocusChangeListener(new DietNewPresetDialog$$ExternalSyntheticLambda2(binding2));
    }

    /* access modifiers changed from: private */
    public static final void setPresetValue$lambda$20$lambda$17(DialogDietNewPresetBinding dialogDietNewPresetBinding, View view, boolean z) {
        Intrinsics.checkNotNullParameter(dialogDietNewPresetBinding, "$this_apply");
        if (z && Intrinsics.areEqual((Object) dialogDietNewPresetBinding.etCarbohydrate.getText().toString(), (Object) "0")) {
            dialogDietNewPresetBinding.etCarbohydrate.setText("");
        }
    }

    /* access modifiers changed from: private */
    public static final void setPresetValue$lambda$20$lambda$18(DialogDietNewPresetBinding dialogDietNewPresetBinding, View view, boolean z) {
        Intrinsics.checkNotNullParameter(dialogDietNewPresetBinding, "$this_apply");
        if (z && Intrinsics.areEqual((Object) dialogDietNewPresetBinding.etFat.getText().toString(), (Object) "0")) {
            dialogDietNewPresetBinding.etFat.setText("");
        }
    }

    /* access modifiers changed from: private */
    public static final void setPresetValue$lambda$20$lambda$19(DialogDietNewPresetBinding dialogDietNewPresetBinding, View view, boolean z) {
        Intrinsics.checkNotNullParameter(dialogDietNewPresetBinding, "$this_apply");
        if (z && Intrinsics.areEqual((Object) dialogDietNewPresetBinding.etProtein.getText().toString(), (Object) "0")) {
            dialogDietNewPresetBinding.etProtein.setText("");
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DialogDietNewPresetBinding binding2 = getBinding();
        EditText editText = getBinding().etWeight;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcherWeight;
        DecimalInputTextWatcher decimalInputTextWatcher2 = null;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherWeight");
            decimalInputTextWatcher = null;
        }
        editText.removeTextChangedListener(decimalInputTextWatcher);
        EditText editText2 = binding2.etProtein;
        DecimalInputTextWatcher decimalInputTextWatcher3 = this.textWatcherProtein;
        if (decimalInputTextWatcher3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherProtein");
            decimalInputTextWatcher3 = null;
        }
        editText2.removeTextChangedListener(decimalInputTextWatcher3);
        EditText editText3 = binding2.etFat;
        DecimalInputTextWatcher decimalInputTextWatcher4 = this.textWatcherFat;
        if (decimalInputTextWatcher4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherFat");
            decimalInputTextWatcher4 = null;
        }
        editText3.removeTextChangedListener(decimalInputTextWatcher4);
        EditText editText4 = binding2.etCarbohydrate;
        DecimalInputTextWatcher decimalInputTextWatcher5 = this.textWatcherCarbohydrate;
        if (decimalInputTextWatcher5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherCarbohydrate");
        } else {
            decimalInputTextWatcher2 = decimalInputTextWatcher5;
        }
        editText4.removeTextChangedListener(decimalInputTextWatcher2);
    }

    private final void applyDynamicLanguageRes() {
        DialogDietNewPresetBinding binding2 = getBinding();
        binding2.labelFoodWeight.setText(getContext().getString(R.string.event_food_quality));
        binding2.etWeight.setHint(getContext().getString(R.string.event_food_edit_valueHint));
        binding2.labelFoodUnit.setText(getContext().getString(R.string.event_food_unit));
        binding2.labelCarb.setText(getContext().getString(R.string.event_food_carb));
        binding2.labelProtein.setText(getContext().getString(R.string.event_food_protein));
        binding2.labelFat.setText(getContext().getString(R.string.event_food_fat));
        binding2.etCarbohydrate.setHint(getContext().getString(R.string.event_food_edit_carbHint));
        binding2.etProtein.setHint(getContext().getString(R.string.event_food_edit_protinHint));
        binding2.etFat.setHint(getContext().getString(R.string.event_food_edit_fatHint));
        binding2.btnCancel.setText(getContext().getString(R.string.com_action_cancel));
        binding2.btnOk.setText(getContext().getString(R.string.com_action_sure));
    }
}
