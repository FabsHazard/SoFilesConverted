package com.microtech.aidexx.ui.main.event.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.flyco.roundview.RoundTextView;
import com.github.mikephil.charting.utils.Utils;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.EventUnitManager;
import com.microtech.aidexx.data.resource.SpecificationModel;
import com.microtech.aidexx.databinding.DialogDietPresetBinding;
import com.microtech.aidexx.db.entity.event.DietDetail;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.utils.DecimalInputTextWatcher;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.bottom.BaseBottomDialog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t\u0012'\b\u0002\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\b\u0010\u001f\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\rH\u0002J\b\u0010$\u001a\u00020\rH\u0002J\b\u0010%\u001a\u00020\rH\u0003J\b\u0010&\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0002J\u0012\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\rH\u0016J\b\u0010-\u001a\u00020\rH\u0002J\u0019\u0010.\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010/R\u000e\u0010\u0010\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R0\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/dialog/DietPresetDialog;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomDialog;", "mFragment", "Landroidx/fragment/app/Fragment;", "oldDietEntity", "Lcom/microtech/aidexx/db/entity/event/DietDetail;", "supportDelete", "", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dietDetailEntity", "", "onDeleteClick", "(Landroidx/fragment/app/Fragment;Lcom/microtech/aidexx/db/entity/event/DietDetail;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "dietEntity", "getOnConfirmClick", "()Lkotlin/jvm/functions/Function1;", "getOnDeleteClick", "specificationModelList", "", "Lcom/microtech/aidexx/data/resource/SpecificationModel;", "textWatcherWeight", "Lcom/microtech/aidexx/utils/DecimalInputTextWatcher;", "viewBinding", "Lcom/microtech/aidexx/databinding/DialogDietPresetBinding;", "getViewBinding", "()Lcom/microtech/aidexx/databinding/DialogDietPresetBinding;", "setViewBinding", "(Lcom/microtech/aidexx/databinding/DialogDietPresetBinding;)V", "applyDynamicLanguageRes", "calculatePresetValue", "copyOldDietEntity", "hasChooseUnit", "initButtonClick", "initPresetValue", "initUnitUi", "initView", "intCustomButton", "intDeleteUI", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "setPresetText", "setPropertyName", "(Lcom/microtech/aidexx/db/entity/event/DietDetail;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DietPresetDialog.kt */
public final class DietPresetDialog extends BaseBottomDialog {
    private final DietDetail dietEntity;
    /* access modifiers changed from: private */
    public final Fragment mFragment;
    private final DietDetail oldDietEntity;
    private final Function1<DietDetail, Unit> onConfirmClick;
    private final Function1<DietDetail, Unit> onDeleteClick;
    private final List<SpecificationModel> specificationModelList;
    private final boolean supportDelete;
    private DecimalInputTextWatcher textWatcherWeight;
    public DialogDietPresetBinding viewBinding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DietPresetDialog(Fragment fragment, DietDetail dietDetail, boolean z, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, dietDetail, (i & 4) != 0 ? false : z, function1, (i & 16) != 0 ? null : function12);
    }

    public final Function1<DietDetail, Unit> getOnConfirmClick() {
        return this.onConfirmClick;
    }

    public final Function1<DietDetail, Unit> getOnDeleteClick() {
        return this.onDeleteClick;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DietPresetDialog(Fragment fragment, DietDetail dietDetail, boolean z, Function1<? super DietDetail, Unit> function1, Function1<? super DietDetail, Unit> function12) {
        super(fragment.requireContext());
        Intrinsics.checkNotNullParameter(fragment, "mFragment");
        Intrinsics.checkNotNullParameter(dietDetail, "oldDietEntity");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        this.mFragment = fragment;
        this.oldDietEntity = dietDetail;
        this.supportDelete = z;
        this.onConfirmClick = function1;
        this.onDeleteClick = function12;
        this.dietEntity = copyOldDietEntity();
        this.specificationModelList = EventUnitManager.INSTANCE.getDietUnitList();
    }

    public final DialogDietPresetBinding getViewBinding() {
        DialogDietPresetBinding dialogDietPresetBinding = this.viewBinding;
        if (dialogDietPresetBinding != null) {
            return dialogDietPresetBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        return null;
    }

    public final void setViewBinding(DialogDietPresetBinding dialogDietPresetBinding) {
        Intrinsics.checkNotNullParameter(dialogDietPresetBinding, "<set-?>");
        this.viewBinding = dialogDietPresetBinding;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DialogDietPresetBinding inflate = DialogDietPresetBinding.inflate(LayoutInflater.from(this.mFragment.requireContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setViewBinding(inflate);
        applyDynamicLanguageRes();
        setContentView(getViewBinding().getRoot());
        initView();
    }

    private final void initView() {
        DialogDietPresetBinding viewBinding2 = getViewBinding();
        EditText editText = viewBinding2.etWeight;
        Intrinsics.checkNotNullExpressionValue(editText, "etWeight");
        this.textWatcherWeight = new DecimalInputTextWatcher(editText, 10, 3);
        EditText editText2 = viewBinding2.etWeight;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcherWeight;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherWeight");
            decimalInputTextWatcher = null;
        }
        editText2.addTextChangedListener(decimalInputTextWatcher);
        initUnitUi();
        initPresetValue();
        initButtonClick();
        intCustomButton();
        intDeleteUI();
    }

    private final void intCustomButton() {
        getViewBinding().tvCustom.setOnClickListener(new DietPresetDialog$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final void intCustomButton$lambda$2$lambda$1(DietPresetDialog dietPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(dietPresetDialog, "this$0");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(dietPresetDialog.mFragment), (CoroutineContext) null, (CoroutineStart) null, new DietPresetDialog$intCustomButton$1$1$1(dietPresetDialog, dietPresetDialog.copyOldDietEntity(), (Continuation<? super DietPresetDialog$intCustomButton$1$1$1>) null), 3, (Object) null);
    }

    private final DietDetail copyOldDietEntity() {
        DietDetail copy$default = DietDetail.copy$default(this.oldDietEntity, (String) null, (String) null, Utils.DOUBLE_EPSILON, 0, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, (String) null, 255, (Object) null);
        copy$default.setId(this.oldDietEntity.getId());
        copy$default.setPresetType(this.oldDietEntity.getPresetType());
        copy$default.setName(this.oldDietEntity.getName());
        copy$default.setUnitStr(this.oldDietEntity.getUnitStr());
        return copy$default;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00aa A[EDGE_INSN: B:29:0x00aa->B:26:0x00aa ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setPropertyName(com.microtech.aidexx.db.entity.event.DietDetail r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog$setPropertyName$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog$setPropertyName$1 r0 = (com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog$setPropertyName$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog$setPropertyName$1 r0 = new com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog$setPropertyName$1
            r0.<init>(r10, r12)
        L_0x0019:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r9 = 1
            if (r1 == 0) goto L_0x003b
            if (r1 != r9) goto L_0x0033
            java.lang.Object r11 = r6.L$1
            com.microtech.aidexx.db.entity.event.DietDetail r11 = (com.microtech.aidexx.db.entity.event.DietDetail) r11
            java.lang.Object r0 = r6.L$0
            com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog r0 = (com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0058
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r12)
            com.microtech.aidexx.db.repository.EventDbRepository r1 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            java.lang.String r2 = r11.getName()
            r6.L$0 = r10
            r6.L$1 = r11
            r6.label = r9
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            java.lang.Object r12 = com.microtech.aidexx.db.repository.EventDbRepository.queryDietPresetByName$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L_0x0057
            return r0
        L_0x0057:
            r0 = r10
        L_0x0058:
            java.util.List r12 = (java.util.List) r12
        L_0x005a:
            r1 = 10000(0x2710, float:1.4013E-41)
            if (r9 >= r1) goto L_0x00aa
            java.util.Iterator r1 = r12.iterator()
        L_0x0062:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0090
            java.lang.Object r2 = r1.next()
            com.microtech.aidexx.db.entity.event.preset.DietPresetEntity r2 = (com.microtech.aidexx.db.entity.event.preset.DietPresetEntity) r2
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r11.getName()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0062
            int r9 = r9 + 1
            goto L_0x005a
        L_0x0090:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            com.microtech.aidexx.db.entity.event.DietDetail r0 = r0.oldDietEntity
            java.lang.String r0 = r0.getName()
            java.lang.StringBuilder r12 = r12.append(r0)
            java.lang.StringBuilder r12 = r12.append(r9)
            java.lang.String r12 = r12.toString()
            r11.setName(r12)
        L_0x00aa:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog.setPropertyName(com.microtech.aidexx.db.entity.event.DietDetail, kotlin.coroutines.Continuation):java.lang.Object");
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

    private final void initButtonClick() {
        DialogDietPresetBinding viewBinding2 = getViewBinding();
        RoundTextView roundTextView = viewBinding2.btnOk;
        Intrinsics.checkNotNullExpressionValue(roundTextView, "btnOk");
        ExtendsKt.setDebounceClickListener$default(roundTextView, 0, new DietPresetDialog$$ExternalSyntheticLambda1(this), 1, (Object) null);
        viewBinding2.btnCancel.setOnClickListener(new DietPresetDialog$$ExternalSyntheticLambda2(this));
        viewBinding2.viWhiteSpace.setOnClickListener(new DietPresetDialog$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void initButtonClick$lambda$9$lambda$6(DietPresetDialog dietPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(dietPresetDialog, "this$0");
        DecimalInputTextWatcher decimalInputTextWatcher = dietPresetDialog.textWatcherWeight;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherWeight");
            decimalInputTextWatcher = null;
        }
        Double doubleValue = decimalInputTextWatcher.getDoubleValue();
        if (doubleValue == null) {
            String string = dietPresetDialog.mFragment.getString(R.string.event_food_edit_valueHint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        } else if (!dietPresetDialog.hasChooseUnit()) {
            String string2 = dietPresetDialog.mFragment.getString(R.string.event_food_edit_unitHint);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
        } else if (dietPresetDialog.dietEntity.getCarbohydrate() > 999999.99d || dietPresetDialog.dietEntity.getProtein() > 999999.99d || dietPresetDialog.dietEntity.getFat() > 999999.99d) {
            String string3 = dietPresetDialog.mFragment.getString(R.string.event_food_edit_error);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            ExtendsKt.toast(string3);
        } else {
            dietPresetDialog.dietEntity.setName(dietPresetDialog.oldDietEntity.getName());
            doubleValue.doubleValue();
            dietPresetDialog.dietEntity.setQuantity(doubleValue.doubleValue());
            dietPresetDialog.onConfirmClick.invoke(dietPresetDialog.dietEntity);
            dietPresetDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void initButtonClick$lambda$9$lambda$7(DietPresetDialog dietPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(dietPresetDialog, "this$0");
        dietPresetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void initButtonClick$lambda$9$lambda$8(DietPresetDialog dietPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(dietPresetDialog, "this$0");
        dietPresetDialog.dismiss();
    }

    private final void initPresetValue() {
        DialogDietPresetBinding viewBinding2 = getViewBinding();
        viewBinding2.tvCategoryName.setText(this.oldDietEntity.getName());
        if (Utils.DOUBLE_EPSILON == this.oldDietEntity.getQuantity()) {
            this.oldDietEntity.setQuantity(100.0d);
        }
        setPresetText();
        EditText editText = viewBinding2.etWeight;
        Intrinsics.checkNotNullExpressionValue(editText, "etWeight");
        editText.addTextChangedListener(new DietPresetDialog$initPresetValue$lambda$12$$inlined$addTextChangedListener$default$1(this));
        viewBinding2.etWeight.setText(ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.oldDietEntity.getQuantity()), (Integer) null, 1, (Object) null));
        viewBinding2.llWeight.setOnClickListener(new DietPresetDialog$$ExternalSyntheticLambda4(viewBinding2));
    }

    /* access modifiers changed from: private */
    public static final void initPresetValue$lambda$12$lambda$11(DialogDietPresetBinding dialogDietPresetBinding, View view) {
        Intrinsics.checkNotNullParameter(dialogDietPresetBinding, "$this_apply");
        dialogDietPresetBinding.etWeight.setSelection(dialogDietPresetBinding.etWeight.getText().length());
    }

    private final void initUnitUi() {
        Object obj;
        int size = this.specificationModelList.size();
        for (int i = 0; i < size; i++) {
            this.specificationModelList.get(i).setCheck(false);
        }
        Iterator it = this.specificationModelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SpecificationModel) obj).getCode() == this.oldDietEntity.getUnit()) {
                break;
            }
        }
        SpecificationModel specificationModel = (SpecificationModel) obj;
        if (specificationModel != null) {
            specificationModel.setCheck(true);
        }
        RecyclerView recyclerView = getViewBinding().rvSpecification;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(2);
        flexboxLayoutManager.setFlexWrap(1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        RecyclerView recyclerView2 = getViewBinding().rvSpecification;
        SpecificationAdapter specificationAdapter = new SpecificationAdapter(this.specificationModelList);
        specificationAdapter.setOnItemClickListener(new DietPresetDialog$$ExternalSyntheticLambda6(this, specificationAdapter));
        recyclerView2.setAdapter(specificationAdapter);
    }

    /* access modifiers changed from: private */
    public static final void initUnitUi$lambda$17$lambda$16(DietPresetDialog dietPresetDialog, SpecificationAdapter specificationAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(dietPresetDialog, "this$0");
        Intrinsics.checkNotNullParameter(specificationAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        int size = dietPresetDialog.specificationModelList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            } else if (dietPresetDialog.specificationModelList.get(i2).getCheck()) {
                dietPresetDialog.specificationModelList.get(i2).setCheck(false);
                specificationAdapter.notifyItemChanged(i2);
                break;
            } else {
                i2++;
            }
        }
        dietPresetDialog.specificationModelList.get(i).setCheck(!dietPresetDialog.specificationModelList.get(i).getCheck());
        dietPresetDialog.dietEntity.setUnit(dietPresetDialog.specificationModelList.get(i).getCode());
        dietPresetDialog.calculatePresetValue();
        specificationAdapter.notifyItemChanged(i);
    }

    /* access modifiers changed from: private */
    public final void calculatePresetValue() {
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcherWeight;
        Object obj = null;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherWeight");
            decimalInputTextWatcher = null;
        }
        Double doubleValue = decimalInputTextWatcher.getDoubleValue();
        double doubleValue2 = doubleValue != null ? doubleValue.doubleValue() : Utils.DOUBLE_EPSILON;
        Iterator it = this.specificationModelList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((SpecificationModel) next).getCode() == this.oldDietEntity.getUnit()) {
                obj = next;
                break;
            }
        }
        double quantity = obj != null ? (doubleValue2 / this.oldDietEntity.getQuantity()) * (this.specificationModelList.get(this.dietEntity.getUnit()).getRatio() / this.specificationModelList.get(this.oldDietEntity.getUnit()).getRatio()) : 1.0d;
        this.dietEntity.setCarbohydrate(this.oldDietEntity.getCarbohydrate() * quantity);
        this.dietEntity.setProtein(this.oldDietEntity.getProtein() * quantity);
        this.dietEntity.setFat(this.oldDietEntity.getFat() * quantity);
        setPresetText();
    }

    private final void setPresetText() {
        DialogDietPresetBinding viewBinding2 = getViewBinding();
        viewBinding2.tvCarbohydrate.setText(ExtendsKt.stripTrailingZeros(Double.valueOf(this.dietEntity.getCarbohydrate()), 3));
        viewBinding2.tvFat.setText(ExtendsKt.stripTrailingZeros(Double.valueOf(this.dietEntity.getFat()), 3));
        viewBinding2.tvProtein.setText(ExtendsKt.stripTrailingZeros(Double.valueOf(this.dietEntity.getProtein()), 3));
    }

    private final void intDeleteUI() {
        boolean z;
        ImageView imageView = getViewBinding().ivDelete;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivDelete");
        View view = imageView;
        int i = 0;
        if (this.supportDelete) {
            getViewBinding().ivDelete.setOnClickListener(new DietPresetDialog$$ExternalSyntheticLambda0(this));
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
    public static final void intDeleteUI$lambda$20(DietPresetDialog dietPresetDialog, View view) {
        Intrinsics.checkNotNullParameter(dietPresetDialog, "this$0");
        Dialogs dialogs = Dialogs.INSTANCE;
        FragmentActivity activity = dietPresetDialog.mFragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Dialogs.showWhether$default(dialogs, (AppCompatActivity) activity, (String) null, dietPresetDialog.mFragment.getString(R.string.com_delete_confirm), new DietPresetDialog$intDeleteUI$1$1(dietPresetDialog), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        EditText editText = getViewBinding().etWeight;
        DecimalInputTextWatcher decimalInputTextWatcher = this.textWatcherWeight;
        if (decimalInputTextWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textWatcherWeight");
            decimalInputTextWatcher = null;
        }
        editText.removeTextChangedListener(decimalInputTextWatcher);
    }

    private final void applyDynamicLanguageRes() {
        DialogDietPresetBinding viewBinding2 = getViewBinding();
        viewBinding2.labelFoodWeight.setText(getContext().getString(R.string.event_food_quality));
        viewBinding2.etWeight.setHint(getContext().getString(R.string.event_food_edit_valueHint));
        viewBinding2.labelFoodUnit.setText(getContext().getString(R.string.event_food_unit));
        viewBinding2.labelCarb.setText(getContext().getString(R.string.event_food_carb));
        viewBinding2.labelProtein.setText(getContext().getString(R.string.event_food_protein));
        viewBinding2.labelFat.setText(getContext().getString(R.string.event_food_fat));
        viewBinding2.btnCancel.setText(getContext().getString(R.string.com_action_cancel));
        viewBinding2.btnOk.setText(getContext().getString(R.string.com_action_sure));
        viewBinding2.tvCustom.setText(getContext().getString(R.string.event_custom));
    }
}
