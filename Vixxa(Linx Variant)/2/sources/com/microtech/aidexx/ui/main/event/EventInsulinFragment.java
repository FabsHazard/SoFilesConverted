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
import com.microtech.aidexx.databinding.FragmentEventInsulinBinding;
import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.db.entity.event.InsulinDetail;
import com.microtech.aidexx.ui.main.event.dialog.InsulinPresetDialog;
import com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel;
import com.microtech.aidexx.ui.main.event.viewmodels.InsulinViewModel;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016Jr\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u00100\"2%\u0010&\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006("}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventInsulinFragment;", "Lcom/microtech/aidexx/ui/main/event/BaseEventFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentEventInsulinBinding;", "()V", "vm", "Lcom/microtech/aidexx/ui/main/event/viewmodels/InsulinViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/event/viewmodels/InsulinViewModel;", "vm$delegate", "Lkotlin/Lazy;", "getNoRecordView", "Landroid/view/View;", "getViewModel", "Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel;", "initEventClick", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRealResume", "isFromSelfOnResume", "", "showPresetDialog", "detail", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "isNewPreset", "supportDelete", "needSaveNewPreset", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "insulinDetailEntity", "onDeleteClick", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventInsulinFragment.kt */
public final class EventInsulinFragment extends BaseEventFragment<BaseViewModel, FragmentEventInsulinBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "EventInsulinFragment";
    private final Lazy vm$delegate;

    public EventInsulinFragment() {
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new EventInsulinFragment$special$$inlined$viewModels$default$2(new EventInsulinFragment$special$$inlined$viewModels$default$1(fragment)));
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(InsulinViewModel.class), new EventInsulinFragment$special$$inlined$viewModels$default$3(lazy), new EventInsulinFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new EventInsulinFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventInsulinFragment$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventInsulinFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final InsulinViewModel getVm() {
        return (InsulinViewModel) this.vm$delegate.getValue();
    }

    public BaseEventViewModel<?, ?, ?> getViewModel() {
        return getVm();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentEventInsulinBinding inflate = FragmentEventInsulinBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ShadowLayout shadowLayout = ((FragmentEventInsulinBinding) getBinding()).slInjectionPreset;
        Intrinsics.checkNotNullExpressionValue(shadowLayout, "slInjectionPreset");
        RecyclerView recyclerView = ((FragmentEventInsulinBinding) getBinding()).rvInjectionPreset;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvInjectionPreset");
        EditText editText = ((FragmentEventInsulinBinding) getBinding()).etInsulinName;
        Intrinsics.checkNotNullExpressionValue(editText, "etInsulinName");
        initInputEvent(shadowLayout, recyclerView, editText);
        RecyclerView recyclerView2 = ((FragmentEventInsulinBinding) getBinding()).rvInjectInput;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "rvInjectInput");
        initToSaveList(recyclerView2);
        initEventClick();
        RecyclerView recyclerView3 = ((FragmentEventInsulinBinding) getBinding()).rvInjectionHistory;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "rvInjectionHistory");
        initHistory(recyclerView3);
        initEventMsg();
        ConstraintLayout root = ((FragmentEventInsulinBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onRealResume(boolean z) {
        if (isBindingInit()) {
            FragmentEventInsulinBinding fragmentEventInsulinBinding = (FragmentEventInsulinBinding) getBinding();
            fragmentEventInsulinBinding.tvInjectionTime.setText(BaseEventViewModel.updateEventTime$default(getVm(), (Date) null, 1, (Object) null));
            fragmentEventInsulinBinding.tvInjectionType.setText(getVm().refreshEventPeriod());
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new EventInsulinFragment$onRealResume$2((Continuation<? super EventInsulinFragment$onRealResume$2>) null), 3, (Object) null);
        }
    }

    public View getNoRecordView() {
        TextView textView = ((FragmentEventInsulinBinding) getBinding()).tvInjectionNoRecord;
        Intrinsics.checkNotNullExpressionValue(textView, "tvInjectionNoRecord");
        return textView;
    }

    public void showPresetDialog(BaseEventDetail baseEventDetail, boolean z, boolean z2, boolean z3, Function1<? super BaseEventDetail, Unit> function1, Function1<? super BaseEventDetail, Unit> function12) {
        Intrinsics.checkNotNullParameter(baseEventDetail, "detail");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        new InsulinPresetDialog(this, (InsulinDetail) baseEventDetail, z2, z3, function1, function12).show();
    }

    private final void initEventClick() {
        FragmentEventInsulinBinding fragmentEventInsulinBinding = (FragmentEventInsulinBinding) getBinding();
        RoundTextView roundTextView = fragmentEventInsulinBinding.btSaveInjection;
        Intrinsics.checkNotNullExpressionValue(roundTextView, "btSaveInjection");
        ExtendsKt.setDebounceClickListener$default(roundTextView, 0, new EventInsulinFragment$$ExternalSyntheticLambda0(this, fragmentEventInsulinBinding), 1, (Object) null);
        TextView textView = fragmentEventInsulinBinding.tvInjectionType;
        Intrinsics.checkNotNullExpressionValue(textView, "tvInjectionType");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new EventInsulinFragment$$ExternalSyntheticLambda1(this, fragmentEventInsulinBinding), 1, (Object) null);
        TextView textView2 = fragmentEventInsulinBinding.tvInjectionTime;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvInjectionTime");
        ExtendsKt.setDebounceClickListener$default(textView2, 0, new EventInsulinFragment$$ExternalSyntheticLambda2(this, fragmentEventInsulinBinding), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$4$lambda$1(EventInsulinFragment eventInsulinFragment, FragmentEventInsulinBinding fragmentEventInsulinBinding, View view) {
        Intrinsics.checkNotNullParameter(eventInsulinFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentEventInsulinBinding, "$this_apply");
        BaseEventFragment.onSaveClick$default(eventInsulinFragment, false, new EventInsulinFragment$initEventClick$1$1$1(fragmentEventInsulinBinding), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$4$lambda$2(EventInsulinFragment eventInsulinFragment, FragmentEventInsulinBinding fragmentEventInsulinBinding, View view) {
        Intrinsics.checkNotNullParameter(eventInsulinFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentEventInsulinBinding, "$this_apply");
        eventInsulinFragment.onEventTimeTypeClick(eventInsulinFragment.getVm().getEventSlotType().intValue(), new EventInsulinFragment$initEventClick$1$2$1(fragmentEventInsulinBinding));
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$4$lambda$3(EventInsulinFragment eventInsulinFragment, FragmentEventInsulinBinding fragmentEventInsulinBinding, View view) {
        Intrinsics.checkNotNullParameter(eventInsulinFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentEventInsulinBinding, "$this_apply");
        eventInsulinFragment.onEventTimeClick(new EventInsulinFragment$initEventClick$1$3$1(fragmentEventInsulinBinding));
    }
}
