package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.common.net.entity.ResEventPresetVersion;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007*\u00020\bH@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$startSyncPreset$2", f = "BaseEventViewModel.kt", i = {0, 0}, l = {169, 169}, m = "invokeSuspend", n = {"$this$launch", "type"}, s = {"L$0", "I$0"})
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$startSyncPreset$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseEventViewModel<T, D, P> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventViewModel$startSyncPreset$2(BaseEventViewModel<T, D, P> baseEventViewModel, Continuation<? super BaseEventViewModel$startSyncPreset$2> continuation) {
        super(2, continuation);
        this.this$0 = baseEventViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseEventViewModel$startSyncPreset$2 baseEventViewModel$startSyncPreset$2 = new BaseEventViewModel$startSyncPreset$2(this.this$0, continuation);
        baseEventViewModel$startSyncPreset$2.L$0 = obj;
        return baseEventViewModel$startSyncPreset$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseEventViewModel$startSyncPreset$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final CoroutineScope coroutineScope;
        final int i;
        Integer num;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            Class access$getTClazz$p = this.this$0.tClazz;
            if (Intrinsics.areEqual((Object) access$getTClazz$p, (Object) MedicationEntity.class)) {
                num = Boxing.boxInt(3);
            } else if (Intrinsics.areEqual((Object) access$getTClazz$p, (Object) InsulinEntity.class)) {
                num = Boxing.boxInt(1);
            } else if (Intrinsics.areEqual((Object) access$getTClazz$p, (Object) DietEntity.class)) {
                num = Boxing.boxInt(2);
            } else {
                num = Intrinsics.areEqual((Object) access$getTClazz$p, (Object) ExerciseEntity.class) ? Boxing.boxInt(4) : null;
            }
            if (num == null) {
                return Unit.INSTANCE;
            }
            i = num.intValue();
            this.L$0 = coroutineScope2;
            this.I$0 = i;
            this.label = 1;
            Object access$fetchPresetVersion = this.this$0.fetchPresetVersion(i, this);
            if (access$fetchPresetVersion == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj2 = access$fetchPresetVersion;
            coroutineScope = coroutineScope2;
            obj = obj2;
        } else if (i2 == 1) {
            i = this.I$0;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i2 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final BaseEventViewModel<T, D, P> baseEventViewModel = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public final Object emit(ResEventPresetVersion resEventPresetVersion, Continuation<? super Unit> continuation) {
                if (resEventPresetVersion != null) {
                    CoroutineScope coroutineScope = coroutineScope;
                    int i = i;
                    BaseEventViewModel<T, D, P> baseEventViewModel = baseEventViewModel;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseEventViewModel$startSyncPreset$2$1$1$1(resEventPresetVersion, i, baseEventViewModel, (Continuation<? super BaseEventViewModel$startSyncPreset$2$1$1$1>) null), 3, (Object) null);
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BaseEventViewModel$startSyncPreset$2$1$1$2(resEventPresetVersion, i, baseEventViewModel, (Continuation<? super BaseEventViewModel$startSyncPreset$2$1$1$2>) null), 3, (Object) null);
                }
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
