package com.microtech.aidexx.ui.main.event.viewmodels;

import androidx.lifecycle.ViewModelKt;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.ResEventPresetVersion;
import com.microtech.aidexx.common.net.repository.EventRepository;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.ui.main.event.EventTimeSlotManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b&\u0018\u0000 O*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0004*\b\b\u0002\u0010\u0005*\u00020\u00062\u00020\u0007:\u0001OB\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J#\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)2\b\b\u0001\u0010+\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00028\u0000H¤@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0019\u0010/\u001a\u00028\u00022\u0006\u00100\u001a\u000201H¤@ø\u0001\u0000¢\u0006\u0002\u00102J\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH¤@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0016\u00103\u001a\b\u0012\u0004\u0012\u0002010\u000e2\b\b\u0001\u0010+\u001a\u00020\u0012J\u0010\u00104\u001a\u0002012\b\b\u0001\u0010+\u001a\u00020\u0012J\u0010\u00105\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\u0012J\u000f\u00106\u001a\u0004\u0018\u00010\u0012H'¢\u0006\u0002\u00107J\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00120)H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001f\u00109\u001a\b\u0012\u0004\u0012\u00028\u00020\u000e2\u0006\u00100\u001a\u000201H¤@ø\u0001\u0000¢\u0006\u0002\u00102J\u0006\u0010:\u001a\u000201J\u0013\u0010;\u001a\u00028\u00012\u0006\u0010<\u001a\u00020\u0012¢\u0006\u0002\u0010=J#\u0010>\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00028\u00000?0)H@ø\u0001\u0000¢\u0006\u0002\u0010.J!\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0)2\u0006\u0010%\u001a\u00028\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u001f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00120)2\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u0010E\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010.J+\u0010F\u001a\u00020$2\b\b\u0001\u0010+\u001a\u00020\u00122\u0006\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u0010IJ\u000e\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020\u0012J\u0010\u0010L\u001a\u0002012\b\b\u0002\u0010M\u001a\u00020\u0018J\u0016\u0010N\u001a\u00020$2\u0006\u0010<\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0004R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel;", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "()V", "_detailHistory", "", "_presetList", "_toSaveDetailList", "detailHistory", "", "getDetailHistory", "()Ljava/util/List;", "eventMomentTypeIndex", "", "getEventMomentTypeIndex", "()I", "setEventMomentTypeIndex", "(I)V", "eventTime", "Ljava/util/Date;", "getEventTime", "()Ljava/util/Date;", "setEventTime", "(Ljava/util/Date;)V", "presetList", "getPresetList", "tClazz", "Ljava/lang/Class;", "toSaveDetailList", "getToSaveDetailList", "addToSaveDetailList", "", "entity", "clearPresetList", "clearToSaveDetailList", "fetchPresetVersion", "Lkotlinx/coroutines/flow/Flow;", "Lcom/microtech/aidexx/common/net/entity/ResEventPresetVersion;", "type", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genEventEntityWhenSave", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genNewPreset", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEventPeriodTypes", "getEventSlot", "getEventSlotIndex", "getEventSlotType", "()Ljava/lang/Integer;", "loadHistory", "queryPresetByName", "refreshEventPeriod", "removeSaveDetailList", "position", "(I)Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "save", "Lkotlin/Pair;", "", "savePreset", "", "(Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchPresetByName", "startSyncPreset", "syncPreset", "isSys", "version", "(IZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventMomentTypeIndex", "index", "updateEventTime", "date", "updateSaveDetailList", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventViewModel.kt */
public abstract class BaseEventViewModel<T extends BaseEventEntity, D extends BaseEventDetail, P extends BasePresetEntity> extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "BaseEventViewModel";
    public static EventTimeSlotManager periodMgr;
    /* access modifiers changed from: private */
    public final List<D> _detailHistory = new ArrayList();
    /* access modifiers changed from: private */
    public final List<P> _presetList = new ArrayList();
    private final List<D> _toSaveDetailList = new ArrayList();
    private int eventMomentTypeIndex;
    private Date eventTime;
    /* access modifiers changed from: private */
    public final Class<T> tClazz;

    /* access modifiers changed from: protected */
    public abstract Object genEventEntityWhenSave(Continuation<? super T> continuation);

    /* access modifiers changed from: protected */
    public abstract Object genNewPreset(String str, Continuation<? super P> continuation);

    /* access modifiers changed from: protected */
    public abstract Object getDetailHistory(Continuation<? super List<? extends D>> continuation);

    public abstract Integer getEventSlotType();

    /* access modifiers changed from: protected */
    public abstract Object queryPresetByName(String str, Continuation<? super List<? extends P>> continuation);

    public BaseEventViewModel() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<T of com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel>");
        this.tClazz = (Class) type;
        this.eventTime = new Date();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/viewmodels/BaseEventViewModel$Companion;", "", "()V", "TAG", "", "periodMgr", "Lcom/microtech/aidexx/ui/main/event/EventTimeSlotManager;", "getPeriodMgr", "()Lcom/microtech/aidexx/ui/main/event/EventTimeSlotManager;", "setPeriodMgr", "(Lcom/microtech/aidexx/ui/main/event/EventTimeSlotManager;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseEventViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EventTimeSlotManager getPeriodMgr() {
            EventTimeSlotManager eventTimeSlotManager = BaseEventViewModel.periodMgr;
            if (eventTimeSlotManager != null) {
                return eventTimeSlotManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("periodMgr");
            return null;
        }

        public final void setPeriodMgr(EventTimeSlotManager eventTimeSlotManager) {
            Intrinsics.checkNotNullParameter(eventTimeSlotManager, "<set-?>");
            BaseEventViewModel.periodMgr = eventTimeSlotManager;
        }
    }

    public final List<D> getToSaveDetailList() {
        return CollectionsKt.toList(this._toSaveDetailList);
    }

    public final List<D> getDetailHistory() {
        return CollectionsKt.toList(this._detailHistory);
    }

    public final List<P> getPresetList() {
        return CollectionsKt.toList(this._presetList);
    }

    /* access modifiers changed from: protected */
    public final int getEventMomentTypeIndex() {
        return this.eventMomentTypeIndex;
    }

    /* access modifiers changed from: protected */
    public final void setEventMomentTypeIndex(int i) {
        this.eventMomentTypeIndex = i;
    }

    /* access modifiers changed from: protected */
    public final Date getEventTime() {
        return this.eventTime;
    }

    /* access modifiers changed from: protected */
    public final void setEventTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.eventTime = date;
    }

    public static /* synthetic */ String updateEventTime$default(BaseEventViewModel baseEventViewModel, Date date, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                date = new Date();
            }
            return baseEventViewModel.updateEventTime(date);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateEventTime");
    }

    public final String updateEventTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.eventTime = date;
        String formatToYMdHm = ExtendsKt.formatToYMdHm(date);
        if (formatToYMdHm != null) {
            return formatToYMdHm;
        }
        String formatToYMdHm2 = ExtendsKt.formatToYMdHm(new Date());
        Intrinsics.checkNotNull(formatToYMdHm2);
        return formatToYMdHm2;
    }

    public final void updateEventMomentTypeIndex(int i) {
        this.eventMomentTypeIndex = i;
    }

    public final void addToSaveDetailList(BaseEventDetail baseEventDetail) {
        Intrinsics.checkNotNullParameter(baseEventDetail, "entity");
        this._toSaveDetailList.add(0, baseEventDetail);
    }

    public final void updateSaveDetailList(int i, BaseEventDetail baseEventDetail) {
        Intrinsics.checkNotNullParameter(baseEventDetail, "entity");
        this._toSaveDetailList.set(i, baseEventDetail);
    }

    public final D removeSaveDetailList(int i) {
        return (BaseEventDetail) this._toSaveDetailList.remove(i);
    }

    public final void clearToSaveDetailList() {
        this._toSaveDetailList.clear();
    }

    public final void clearPresetList() {
        this._presetList.clear();
    }

    public final Object loadHistory(Continuation<? super Flow<Integer>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new BaseEventViewModel$loadHistory$2(this, (Continuation<? super BaseEventViewModel$loadHistory$2>) null)), Dispatchers.getIO());
    }

    public final Object searchPresetByName(String str, Continuation<? super Flow<Integer>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new BaseEventViewModel$searchPresetByName$2(this, str, (Continuation<? super BaseEventViewModel$searchPresetByName$2>) null)), Dispatchers.getIO());
    }

    public final Object save(Continuation<? super Flow<? extends Pair<Boolean, ? extends T>>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new BaseEventViewModel$save$2(this, (Continuation<? super BaseEventViewModel$save$2>) null)), Dispatchers.getIO());
    }

    public final Object savePreset(P p, Continuation<? super Flow<Long>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new BaseEventViewModel$savePreset$2(p, (Continuation<? super BaseEventViewModel$savePreset$2>) null)), Dispatchers.getIO());
    }

    public final Object startSyncPreset(Continuation<? super Unit> continuation) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseEventViewModel$startSyncPreset$2(this, (Continuation<? super BaseEventViewModel$startSyncPreset$2>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object syncPreset(@EventType int i, boolean z, String str, Continuation<? super Unit> continuation) {
        Object collect;
        Flow flow = null;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        if (z) {
                            EventRepository eventRepository = EventRepository.INSTANCE;
                            flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$5(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
                        } else {
                            EventRepository eventRepository2 = EventRepository.INSTANCE;
                            flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$6(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
                        }
                    }
                } else if (z) {
                    EventRepository eventRepository3 = EventRepository.INSTANCE;
                    flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$1(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
                } else {
                    EventRepository eventRepository4 = EventRepository.INSTANCE;
                    flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$2(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
                }
            } else if (z) {
                EventRepository eventRepository5 = EventRepository.INSTANCE;
                flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$3(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
            } else {
                EventRepository eventRepository6 = EventRepository.INSTANCE;
                flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$4(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
            }
        } else if (z) {
            EventRepository eventRepository7 = EventRepository.INSTANCE;
            flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$7(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
        } else {
            EventRepository eventRepository8 = EventRepository.INSTANCE;
            flow = FlowKt.flowOn(FlowKt.callbackFlow(new BaseEventViewModel$syncPreset$$inlined$syncEventPreset$default$8(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO());
        }
        if (flow == null || (collect = flow.collect(new BaseEventViewModel$syncPreset$2$1(i, str, z), continuation)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return collect;
    }

    /* access modifiers changed from: private */
    public final Object fetchPresetVersion(@EventType int i, Continuation<? super Flow<ResEventPresetVersion>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new BaseEventViewModel$fetchPresetVersion$2(i, (Continuation<? super BaseEventViewModel$fetchPresetVersion$2>) null)), Dispatchers.getIO());
    }

    public final List<String> getEventPeriodTypes(int i) {
        return Companion.getPeriodMgr().getTypes(i);
    }

    public final String refreshEventPeriod() {
        Integer eventSlotType = getEventSlotType();
        if (eventSlotType == null) {
            return "";
        }
        eventSlotType.intValue();
        this.eventMomentTypeIndex = getEventSlotIndex(eventSlotType.intValue()) + 1;
        return Companion.getPeriodMgr().getEventSlot(eventSlotType.intValue());
    }

    public final String getEventSlot(int i) {
        return Companion.getPeriodMgr().getEventSlot(i);
    }

    public final int getEventSlotIndex(int i) {
        try {
            return Companion.getPeriodMgr().getEventSlotIndex(i);
        } catch (Exception unused) {
            return EventTimeSlotManager.Companion.instance().getEventSlotIndex(i);
        }
    }
}
