package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$checkClosestEvent$2", f = "ChartViewModel.kt", i = {}, l = {741}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$checkClosestEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BaseEventEntity>, Object> {
    final /* synthetic */ Date $maxTime;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$checkClosestEvent$2(Date date, Continuation<? super ChartViewModel$checkClosestEvent$2> continuation) {
        super(2, continuation);
        this.$maxTime = date;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ChartViewModel$checkClosestEvent$2 chartViewModel$checkClosestEvent$2 = new ChartViewModel$checkClosestEvent$2(this.$maxTime, continuation);
        chartViewModel$checkClosestEvent$2.L$0 = obj;
        return chartViewModel$checkClosestEvent$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BaseEventEntity> continuation) {
        return ((ChartViewModel$checkClosestEvent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        long j2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Deferred[] deferredArr = {BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$checkClosestEvent$2$taskList$1(this.$maxTime, (Continuation<? super ChartViewModel$checkClosestEvent$2$taskList$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$checkClosestEvent$2$taskList$2(this.$maxTime, (Continuation<? super ChartViewModel$checkClosestEvent$2$taskList$2>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$checkClosestEvent$2$taskList$3(this.$maxTime, (Continuation<? super ChartViewModel$checkClosestEvent$2$taskList$3>) null), 3, (Object) null)};
            this.label = 1;
            obj = AwaitKt.awaitAll(CollectionsKt.listOf(deferredArr), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterator it = ((Iterable) obj).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                BaseEventEntity baseEventEntity = (BaseEventEntity) next;
                if (baseEventEntity != null) {
                    j = baseEventEntity.getTimestamp();
                } else {
                    j = 0;
                }
                do {
                    Object next2 = it.next();
                    BaseEventEntity baseEventEntity2 = (BaseEventEntity) next2;
                    if (baseEventEntity2 != null) {
                        j2 = baseEventEntity2.getTimestamp();
                    } else {
                        j2 = 0;
                    }
                    if (j < j2) {
                        next = next2;
                        j = j2;
                    }
                } while (it.hasNext());
            }
            return next;
        }
        throw new NoSuchElementException();
    }
}
