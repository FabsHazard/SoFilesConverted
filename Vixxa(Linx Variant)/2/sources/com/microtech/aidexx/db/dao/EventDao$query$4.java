package com.microtech.aidexx.db.dao;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.db.dao.EventDao$query$4", f = "EventDao.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventDao.kt */
final class EventDao$query$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends BaseEventEntity>>, Object> {
    final /* synthetic */ String $endDate;
    final /* synthetic */ String $startDate;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventDao$query$4(String str, String str2, String str3, Continuation<? super EventDao$query$4> continuation) {
        super(2, continuation);
        this.$startDate = str;
        this.$endDate = str2;
        this.$userId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EventDao$query$4 eventDao$query$4 = new EventDao$query$4(this.$startDate, this.$endDate, this.$userId, continuation);
        eventDao$query$4.L$0 = obj;
        return eventDao$query$4;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends BaseEventEntity>> continuation) {
        return ((EventDao$query$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Deferred[] deferredArr = {BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventDao$query$4$events$1(this.$startDate, this.$endDate, this.$userId, (Continuation<? super EventDao$query$4$events$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventDao$query$4$events$2(this.$startDate, this.$endDate, this.$userId, (Continuation<? super EventDao$query$4$events$2>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventDao$query$4$events$3(this.$startDate, this.$endDate, this.$userId, (Continuation<? super EventDao$query$4$events$3>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventDao$query$4$events$4(this.$startDate, this.$endDate, this.$userId, (Continuation<? super EventDao$query$4$events$4>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventDao$query$4$events$5(this.$startDate, this.$endDate, this.$userId, (Continuation<? super EventDao$query$4$events$5>) null), 3, (Object) null)};
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
        return CollectionsKt.flatten((Iterable) obj);
    }
}
