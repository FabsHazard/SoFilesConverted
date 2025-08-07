package com.microtech.aidexx.ui.main.event;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.db.entity.event.preset.DietPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicinePresetEntity;
import com.microtech.aidexx.db.entity.event.preset.PresetExtentionsKt;
import com.microtech.aidexx.db.entity.event.preset.SportPresetEntity;
import com.microtech.aidexx.ui.main.event.adapter.EventInputAdapter;
import com.microtech.aidexx.ui.main.event.adapter.EventPresetAdapter;
import com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.selector.time.TimePicker;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\u0004\u0018\u0001`\u0019H\u0017J\b\u0010\u001a\u001a\u00020\u001bH&J\u0014\u0010\u001c\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001dH&J\u0006\u0010\u001e\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!J \u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020!H\u0016J)\u0010*\u001a\u00020\u00182!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00180,J3\u00101\u001a\u00020\u00182\b\b\u0001\u00102\u001a\u0002032!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110-¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00180,J\u0010\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u000206H&J\b\u00107\u001a\u00020\u0018H\u0016J&\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u0002062\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0018\u0018\u00010,J\u0012\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=H\u0002Jz\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u0002062\b\b\u0002\u0010A\u001a\u0002062\b\b\u0002\u0010B\u001a\u0002062!\u0010C\u001a\u001d\u0012\u0013\u0012\u00110;¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u00180,2'\b\u0002\u0010E\u001a!\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\u0018\u0018\u00010,H&J\u0011\u0010F\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010GR\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006H"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/BaseEventFragment;", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/microtech/aidexx/base/BaseFragment;", "()V", "detailHistoryAdapter", "Lcom/microtech/aidexx/ui/main/event/adapter/EventInputAdapter;", "getDetailHistoryAdapter", "()Lcom/microtech/aidexx/ui/main/event/adapter/EventInputAdapter;", "setDetailHistoryAdapter", "(Lcom/microtech/aidexx/ui/main/event/adapter/EventInputAdapter;)V", "presetAdapter", "Lcom/microtech/aidexx/ui/main/event/adapter/EventPresetAdapter;", "getPresetAdapter", "()Lcom/microtech/aidexx/ui/main/event/adapter/EventPresetAdapter;", "setPresetAdapter", "(Lcom/microtech/aidexx/ui/main/event/adapter/EventPresetAdapter;)V", "toSaveDetailAdapter", "getToSaveDetailAdapter", "setToSaveDetailAdapter", "canLeave", "Lkotlin/Function0;", "", "Lcom/microtech/aidexx/base/AfterLeaveCallback;", "getNoRecordView", "Landroid/view/View;", "getViewModel", "Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel;", "initEventMsg", "initHistory", "historyRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "initInputEvent", "presetRecyclerViewContainer", "Landroid/view/ViewGroup;", "presetRecyclerView", "inputEditText", "Landroid/widget/EditText;", "initToSaveList", "toSaveRecyclerView", "onEventTimeClick", "cb", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "time", "onEventTimeTypeClick", "type", "", "onRealResume", "isFromSelfOnResume", "", "onResume", "onSaveClick", "ignoreDetailList", "presetToDetail", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "p", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "showPresetDialog", "detail", "isNewPreset", "supportDelete", "needSaveNewPreset", "onConfirmClick", "insulinDetailEntity", "onDeleteClick", "updateHistoryUi", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventFragment.kt */
public abstract class BaseEventFragment<VM extends BaseViewModel, VB extends ViewBinding> extends BaseFragment<VM, VB> {
    public EventInputAdapter detailHistoryAdapter;
    public EventPresetAdapter presetAdapter;
    public EventInputAdapter toSaveDetailAdapter;

    public abstract View getNoRecordView();

    public abstract BaseEventViewModel<?, ?, ?> getViewModel();

    public abstract void onRealResume(boolean z);

    public abstract void showPresetDialog(BaseEventDetail baseEventDetail, boolean z, boolean z2, boolean z3, Function1<? super BaseEventDetail, Unit> function1, Function1<? super BaseEventDetail, Unit> function12);

    public final EventInputAdapter getToSaveDetailAdapter() {
        EventInputAdapter eventInputAdapter = this.toSaveDetailAdapter;
        if (eventInputAdapter != null) {
            return eventInputAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("toSaveDetailAdapter");
        return null;
    }

    public final void setToSaveDetailAdapter(EventInputAdapter eventInputAdapter) {
        Intrinsics.checkNotNullParameter(eventInputAdapter, "<set-?>");
        this.toSaveDetailAdapter = eventInputAdapter;
    }

    public final EventInputAdapter getDetailHistoryAdapter() {
        EventInputAdapter eventInputAdapter = this.detailHistoryAdapter;
        if (eventInputAdapter != null) {
            return eventInputAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("detailHistoryAdapter");
        return null;
    }

    public final void setDetailHistoryAdapter(EventInputAdapter eventInputAdapter) {
        Intrinsics.checkNotNullParameter(eventInputAdapter, "<set-?>");
        this.detailHistoryAdapter = eventInputAdapter;
    }

    public final EventPresetAdapter getPresetAdapter() {
        EventPresetAdapter eventPresetAdapter = this.presetAdapter;
        if (eventPresetAdapter != null) {
            return eventPresetAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presetAdapter");
        return null;
    }

    public final void setPresetAdapter(EventPresetAdapter eventPresetAdapter) {
        Intrinsics.checkNotNullParameter(eventPresetAdapter, "<set-?>");
        this.presetAdapter = eventPresetAdapter;
    }

    public void onResume() {
        super.onResume();
        onRealResume(true);
    }

    public Function0<Unit> canLeave() {
        if (getViewModel().getToSaveDetailList().isEmpty()) {
            return null;
        }
        return new BaseEventFragment$canLeave$1(this);
    }

    public final void initEventMsg() {
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_DATA_CHANGED, (LifecycleOwner) this, new BaseEventFragment$initEventMsg$1(this));
    }

    /* access modifiers changed from: private */
    public final BaseEventDetail presetToDetail(BasePresetEntity basePresetEntity) {
        if (basePresetEntity instanceof MedicinePresetEntity) {
            return PresetExtentionsKt.toMedicineDetailEntity((MedicinePresetEntity) basePresetEntity);
        }
        if (basePresetEntity instanceof DietPresetEntity) {
            return PresetExtentionsKt.toDietDetailEntity((DietPresetEntity) basePresetEntity);
        }
        if (basePresetEntity instanceof InsulinPresetEntity) {
            return PresetExtentionsKt.toInsulinDetailEntity((InsulinPresetEntity) basePresetEntity);
        }
        if (basePresetEntity instanceof SportPresetEntity) {
            return PresetExtentionsKt.toExerciseDetailEntity((SportPresetEntity) basePresetEntity);
        }
        return null;
    }

    public void initInputEvent(ViewGroup viewGroup, RecyclerView recyclerView, EditText editText) {
        Intrinsics.checkNotNullParameter(viewGroup, "presetRecyclerViewContainer");
        Intrinsics.checkNotNullParameter(recyclerView, "presetRecyclerView");
        Intrinsics.checkNotNullParameter(editText, "inputEditText");
        setPresetAdapter(new EventPresetAdapter(CollectionsKt.toMutableList(getViewModel().getPresetList()), new BaseEventFragment$initInputEvent$1(editText, this, viewGroup)));
        recyclerView.setAdapter(getPresetAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        editText.addTextChangedListener(new BaseEventFragment$initInputEvent$$inlined$addTextChangedListener$default$1(viewGroup, this));
    }

    public static /* synthetic */ void showPresetDialog$default(BaseEventFragment baseEventFragment, BaseEventDetail baseEventDetail, boolean z, boolean z2, boolean z3, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj == null) {
            baseEventFragment.showPresetDialog(baseEventDetail, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, function1, (i & 32) != 0 ? null : function12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPresetDialog");
    }

    public void initToSaveList(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "toSaveRecyclerView");
        setToSaveDetailAdapter(new EventInputAdapter(CollectionsKt.toMutableList(getViewModel().getToSaveDetailList()), false, 2, (DefaultConstructorMarker) null));
        recyclerView.setAdapter(getToSaveDetailAdapter());
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(2);
        flexboxLayoutManager.setFlexWrap(1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        getToSaveDetailAdapter().setOnItemClickListener(new BaseEventFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void initToSaveList$lambda$2(BaseEventFragment baseEventFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseEventFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        showPresetDialog$default(baseEventFragment, (BaseEventDetail) baseEventFragment.getViewModel().getToSaveDetailList().get(i), false, true, false, new BaseEventFragment$initToSaveList$2$1(baseEventFragment, i), new BaseEventFragment$initToSaveList$2$2(baseEventFragment, i), 10, (Object) null);
    }

    public final void initHistory(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "historyRecyclerView");
        setDetailHistoryAdapter(new EventInputAdapter(CollectionsKt.toMutableList(getViewModel().getDetailHistory()), true));
        getDetailHistoryAdapter().setOnItemClickListener(new BaseEventFragment$$ExternalSyntheticLambda0(this));
        recyclerView.setAdapter(getDetailHistoryAdapter());
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(2);
        flexboxLayoutManager.setFlexWrap(1);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseEventFragment$initHistory$3(this, (Continuation<? super BaseEventFragment$initHistory$3>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initHistory$lambda$3(BaseEventFragment baseEventFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseEventFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        showPresetDialog$default(baseEventFragment, (BaseEventDetail) baseEventFragment.getViewModel().getDetailHistory().get(i), false, false, false, new BaseEventFragment$initHistory$1$1(baseEventFragment), (Function1) null, 46, (Object) null);
    }

    public final Object updateHistoryUi(Continuation<? super Unit> continuation) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseEventFragment$updateHistoryUi$2(this, (Continuation<? super BaseEventFragment$updateHistoryUi$2>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void onSaveClick$default(BaseEventFragment baseEventFragment, boolean z, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseEventFragment.onSaveClick(z, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSaveClick");
    }

    public final void onSaveClick(boolean z, Function1<? super Boolean, Unit> function1) {
        if (z || !getViewModel().getToSaveDetailList().isEmpty()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseEventFragment$onSaveClick$1(this, z, function1, (Continuation<? super BaseEventFragment$onSaveClick$1>) null), 3, (Object) null);
        } else if (this instanceof EventDietFragment) {
            String string = getString(R.string.event_food_nameHint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        } else if (this instanceof EventInsulinFragment) {
            String string2 = getString(R.string.event_insulin_nameHint);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
        } else if (this instanceof EventMedicineFragment) {
            String string3 = getString(R.string.event_medicine_nameHint);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            ExtendsKt.toast(string3);
        } else if (this instanceof EventSportFragment) {
            String string4 = getString(R.string.event_exercise_nameHint);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            ExtendsKt.toast(string4);
        } else {
            String string5 = getString(R.string.event_other_nameHint);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            ExtendsKt.toast(string5);
        }
    }

    public final void onEventTimeClick(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "cb");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        TimePicker.pick$default(new TimePicker(requireContext), (boolean[]) null, (String) null, (Calendar) null, new BaseEventFragment$onEventTimeClick$1(function1, this), 7, (Object) null);
    }

    public final void onEventTimeTypeClick(int i, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "cb");
        List<String> eventPeriodTypes = getViewModel().getEventPeriodTypes(i);
        int eventSlotIndex = getViewModel().getEventSlotIndex(i);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        new Dialogs.Picker(requireContext).singlePick(eventPeriodTypes, eventSlotIndex, new BaseEventFragment$onEventTimeTypeClick$1(function1, eventPeriodTypes, this));
    }
}
