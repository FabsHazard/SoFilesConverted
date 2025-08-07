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
import androidx.recyclerview.widget.RecyclerView;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentEventOthersBinding;
import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel;
import com.microtech.aidexx.ui.main.event.viewmodels.OthersViewModel;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000eH\u0017J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0002J$\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016Jr\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001d2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\r0%2%\u0010)\u001a!\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\r\u0018\u00010%H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventOthersFragment;", "Lcom/microtech/aidexx/ui/main/event/BaseEventFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentEventOthersBinding;", "()V", "vm", "Lcom/microtech/aidexx/ui/main/event/viewmodels/OthersViewModel;", "getVm", "()Lcom/microtech/aidexx/ui/main/event/viewmodels/OthersViewModel;", "vm$delegate", "Lkotlin/Lazy;", "canLeave", "Lkotlin/Function0;", "", "Lcom/microtech/aidexx/base/AfterLeaveCallback;", "getNoRecordView", "Landroid/view/View;", "getViewModel", "Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel;", "initEventClick", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRealResume", "isFromSelfOnResume", "", "showPresetDialog", "detail", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "isNewPreset", "supportDelete", "needSaveNewPreset", "onConfirmClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "insulinDetailEntity", "onDeleteClick", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventOthersFragment.kt */
public final class EventOthersFragment extends BaseEventFragment<BaseViewModel, FragmentEventOthersBinding> {
    private final Lazy vm$delegate;

    public EventOthersFragment() {
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new EventOthersFragment$special$$inlined$viewModels$default$2(new EventOthersFragment$special$$inlined$viewModels$default$1(fragment)));
        this.vm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OthersViewModel.class), new EventOthersFragment$special$$inlined$viewModels$default$3(lazy), new EventOthersFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new EventOthersFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    /* access modifiers changed from: private */
    public final OthersViewModel getVm() {
        return (OthersViewModel) this.vm$delegate.getValue();
    }

    public BaseEventViewModel<?, ?, ?> getViewModel() {
        return getVm();
    }

    public View getNoRecordView() {
        TextView textView = ((FragmentEventOthersBinding) getBinding()).tvOthersNoRecord;
        Intrinsics.checkNotNullExpressionValue(textView, "tvOthersNoRecord");
        return textView;
    }

    public Function0<Unit> canLeave() {
        if (getVm().getContent().length() == 0) {
            return null;
        }
        return new EventOthersFragment$canLeave$1(this);
    }

    public void showPresetDialog(BaseEventDetail baseEventDetail, boolean z, boolean z2, boolean z3, Function1<? super BaseEventDetail, Unit> function1, Function1<? super BaseEventDetail, Unit> function12) {
        Intrinsics.checkNotNullParameter(baseEventDetail, "detail");
        Intrinsics.checkNotNullParameter(function1, "onConfirmClick");
        ((FragmentEventOthersBinding) getBinding()).etOthersContent.setText(baseEventDetail.getName());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentEventOthersBinding inflate = FragmentEventOthersBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initEventClick();
        RecyclerView recyclerView = ((FragmentEventOthersBinding) getBinding()).rvOthersHistory;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rvOthersHistory");
        initHistory(recyclerView);
        initEventMsg();
        EditText editText = ((FragmentEventOthersBinding) getBinding()).etOthersContent;
        Intrinsics.checkNotNullExpressionValue(editText, "etOthersContent");
        editText.addTextChangedListener(new EventOthersFragment$onCreateView$$inlined$addTextChangedListener$default$1(this));
        ConstraintLayout root = ((FragmentEventOthersBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onRealResume(boolean z) {
        if (isBindingInit()) {
            ((FragmentEventOthersBinding) getBinding()).tvOthersTime.setText(BaseEventViewModel.updateEventTime$default(getVm(), (Date) null, 1, (Object) null));
        }
    }

    private final void initEventClick() {
        FragmentEventOthersBinding fragmentEventOthersBinding = (FragmentEventOthersBinding) getBinding();
        RoundTextView roundTextView = fragmentEventOthersBinding.btSaveOthers;
        Intrinsics.checkNotNullExpressionValue(roundTextView, "btSaveOthers");
        ExtendsKt.setDebounceClickListener$default(roundTextView, 0, new EventOthersFragment$$ExternalSyntheticLambda0(fragmentEventOthersBinding, this), 1, (Object) null);
        TextView textView = fragmentEventOthersBinding.tvOthersTime;
        Intrinsics.checkNotNullExpressionValue(textView, "tvOthersTime");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new EventOthersFragment$$ExternalSyntheticLambda1(this, fragmentEventOthersBinding), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$3$lambda$1(FragmentEventOthersBinding fragmentEventOthersBinding, EventOthersFragment eventOthersFragment, View view) {
        Intrinsics.checkNotNullParameter(fragmentEventOthersBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(eventOthersFragment, "this$0");
        if (fragmentEventOthersBinding.etOthersContent.getText().toString().length() == 0) {
            String string = eventOthersFragment.getString(R.string.event_other_nameHint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
            return;
        }
        eventOthersFragment.onSaveClick(true, new EventOthersFragment$initEventClick$1$1$1(fragmentEventOthersBinding));
    }

    /* access modifiers changed from: private */
    public static final void initEventClick$lambda$3$lambda$2(EventOthersFragment eventOthersFragment, FragmentEventOthersBinding fragmentEventOthersBinding, View view) {
        Intrinsics.checkNotNullParameter(eventOthersFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentEventOthersBinding, "$this_apply");
        eventOthersFragment.onEventTimeClick(new EventOthersFragment$initEventClick$1$2$1(fragmentEventOthersBinding));
    }
}
