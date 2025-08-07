package com.microtech.aidexx.ui.main.event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.flyco.roundview.RoundTextView;
import com.lihang.ShadowLayout;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentEventDietBinding;
import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.db.entity.event.DietDetail;
import com.microtech.aidexx.ui.main.event.dialog.DietNewPresetDialog;
import com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog;
import com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel;
import com.microtech.aidexx.ui.main.event.viewmodels.DietViewModel;
import java.util.Date;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0006H\u0016Jr\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00120#2%\u0010'\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0012\u0018\u00010#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006("}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventDietFragment;", "Lcom/microtech/aidexx/ui/main/event/BaseEventFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentEventDietBinding;", "()V", "isFirstIn", "", "vm", "Lcom/microtech/aidexx/ui/main/event/viewmodels/DietViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/event/viewmodels/DietViewModel;", "vm$delegate", "Lkotlin/Lazy;", "getNoRecordView", "Landroid/view/View;", "getViewModel", "Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel;", "initEventClick", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRealResume", "isFromSelfOnResume", "showPresetDialog", "detail", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "isNewPreset", "supportDelete", "needSaveNewPreset", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "insulinDetailEntity", "onDeleteClick", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventDietFragment.kt */
public final class EventDietFragment extends BaseEventFragment<BaseViewModel, FragmentEventDietBinding> {
    private boolean isFirstIn = true;
    private final Lazy vm$delegate;

    public EventDietFragment() {
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new EventDietFragment$special$$inlined$viewModels$default$2(new EventDietFragment$special$$inlined$viewModels$default$1(fragment)));
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DietViewModel.class), new EventDietFragment$special$$inlined$viewModels$default$3(lazy), new EventDietFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new EventDietFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: private */
    public final DietViewModel getVm() {
        return (DietViewModel) this.vm$delegate.getValue();
    }

    public BaseEventViewModel<?, ?, ?> getViewModel() {
        return getVm();
    }

    public View getNoRecordView() {
        TextView textView = ((FragmentEventDietBinding) getBinding()).tvDietNoRecord;
        Intrinsics.checkNotNullExpressionValue(textView, "tvDietNoRecord");
        return textView;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentEventDietBinding inflate = FragmentEventDietBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ShadowLayout shadowLayout = ((FragmentEventDietBinding) getBinding()).slFoodPreset;
        Intrinsics.checkNotNullExpressionValue(shadowLayout, "slFoodPreset");
        RecyclerView recyclerView = ((FragmentEventDietBinding) getBinding()).rvFoodPreset;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvFoodPreset");
        EditText editText = ((FragmentEventDietBinding) getBinding()).etFoodName;
        Intrinsics.checkNotNullExpressionValue(editText, "etFoodName");
        initInputEvent(shadowLayout, recyclerView, editText);
        RecyclerView recyclerView2 = ((FragmentEventDietBinding) getBinding()).rvDietFoods;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "rvDietFoods");
        initToSaveList(recyclerView2);
        initEventClick();
        RecyclerView recyclerView3 = ((FragmentEventDietBinding) getBinding()).rvDietHistory;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "rvDietHistory");
        initHistory(recyclerView3);
        initEventMsg();
        ConstraintLayout root = ((FragmentEventDietBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onRealResume(boolean z) {
        if (isBindingInit()) {
            FragmentEventDietBinding fragmentEventDietBinding = (FragmentEventDietBinding) getBinding();
            fragmentEventDietBinding.tvDietTime.setText(BaseEventViewModel.updateEventTime$default(getVm(), (Date) null, 1, (Object) null));
            fragmentEventDietBinding.tvDietType.setText(getVm().refreshEventPeriod());
            if (!this.isFirstIn) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new EventDietFragment$onRealResume$2((Continuation<? super EventDietFragment$onRealResume$2>) null), 3, (Object) null);
            } else {
                this.isFirstIn = false;
            }
        }
    }

    private final void initEventClick() {
        FragmentEventDietBinding fragmentEventDietBinding = (FragmentEventDietBinding) getBinding();
        RoundTextView roundTextView = fragmentEventDietBinding.btSaveDiet;
        Intrinsics.checkNotNullExpressionValue(roundTextView, "btSaveDiet");
        ExtendsKt.setDebounceClickListener$default(roundTextView, 0, new EventDietFragment$$ExternalSyntheticLambda0(this, fragmentEventDietBinding), 1, (Object) null);
        TextView textView = fragmentEventDietBinding.tvDietType;
        Intrinsics.checkNotNullExpressionValue(textView, "tvDietType");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new EventDietFragment$$ExternalSyntheticLambda1(this, fragmentEventDietBinding), 1, (Object) null);
        TextView textView2 = fragmentEventDietBinding.tvDietTime;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvDietTime");
        ExtendsKt.setDebounceClickListener$default(textView2, 0, new EventDietFragment$$ExternalSyntheticLambda2(this, fragmentEventDietBinding), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$4$lambda$1(EventDietFragment eventDietFragment, FragmentEventDietBinding fragmentEventDietBinding, View view) {
        Intrinsics.checkNotNullParameter(eventDietFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentEventDietBinding, "$this_apply");
        BaseEventFragment.onSaveClick$default(eventDietFragment, false, new EventDietFragment$initEventClick$1$1$1(fragmentEventDietBinding), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$4$lambda$2(EventDietFragment eventDietFragment, FragmentEventDietBinding fragmentEventDietBinding, View view) {
        Intrinsics.checkNotNullParameter(eventDietFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentEventDietBinding, "$this_apply");
        eventDietFragment.onEventTimeTypeClick(eventDietFragment.getVm().getEventSlotType().intValue(), new EventDietFragment$initEventClick$1$2$1(fragmentEventDietBinding));
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$4$lambda$3(EventDietFragment eventDietFragment, FragmentEventDietBinding fragmentEventDietBinding, View view) {
        Intrinsics.checkNotNullParameter(eventDietFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentEventDietBinding, "$this_apply");
        eventDietFragment.onEventTimeClick(new EventDietFragment$initEventClick$1$3$1(fragmentEventDietBinding));
    }

    public void showPresetDialog(BaseEventDetail baseEventDetail, boolean z, boolean z2, boolean z3, Function1<? super BaseEventDetail, Unit> function1, Function1<? super BaseEventDetail, Unit> function12) {
        Intrinsics.checkNotNullParameter(baseEventDetail, "detail");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        if (z) {
            new DietNewPresetDialog(this, (DietDetail) baseEventDetail, new EventDietFragment$showPresetDialog$1(this, function1)).show();
            return;
        }
        new DietPresetDialog(this, (DietDetail) baseEventDetail, z2, new EventDietFragment$showPresetDialog$2(this, function1), function12).show();
    }
}
