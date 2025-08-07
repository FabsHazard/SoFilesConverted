package com.microtech.aidexx.ui.main.event;

import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00052\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007j\u0002`\u000bH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "it", "Lkotlin/Pair;", "Lcom/microtech/aidexx/utils/eventbus/DataChangedType;", "", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lcom/microtech/aidexx/utils/eventbus/EventDataChangedInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$initEventMsg$1 extends Lambda implements Function1<Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>>, Unit> {
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$initEventMsg$1(BaseEventFragment<VM, VB> baseEventFragment) {
        super(1);
        this.this$0 = baseEventFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>>) (Pair) obj);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\u0006H@"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.event.BaseEventFragment$initEventMsg$1$1", f = "BaseEventFragment.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.event.BaseEventFragment$initEventMsg$1$1  reason: invalid class name */
    /* compiled from: BaseEventFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(pair, baseEventFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BaseEventEntity baseEventEntity = (BaseEventEntity) CollectionsKt.firstOrNull(pair.getSecond());
                if (baseEventEntity != null) {
                    BaseEventFragment<VM, VB> baseEventFragment = baseEventFragment;
                    if (((baseEventFragment instanceof EventDietFragment) && (baseEventEntity instanceof DietEntity)) || (((baseEventFragment instanceof EventSportFragment) && (baseEventEntity instanceof ExerciseEntity)) || (((baseEventFragment instanceof EventMedicineFragment) && (baseEventEntity instanceof MedicationEntity)) || (((baseEventFragment instanceof EventInsulinFragment) && (baseEventEntity instanceof InsulinEntity)) || ((baseEventFragment instanceof EventOthersFragment) && (baseEventEntity instanceof OthersEntity)))))) {
                        this.label = 1;
                        if (baseEventFragment.updateHistoryUi(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void invoke(final Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>> pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (pair.getFirst() == DataChangedType.DELETE) {
            final BaseEventFragment<VM, VB> baseEventFragment = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }
}
