package com.microtech.aidexx.data;

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

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync$Companion$uploadHistoryData$2", f = "CloudHistorySync.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$uploadHistoryData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    CloudHistorySync$Companion$uploadHistoryData$2(Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CloudHistorySync$Companion$uploadHistoryData$2 cloudHistorySync$Companion$uploadHistoryData$2 = new CloudHistorySync$Companion$uploadHistoryData$2(continuation);
        cloudHistorySync$Companion$uploadHistoryData$2.L$0 = obj;
        return cloudHistorySync$Companion$uploadHistoryData$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
        return ((CloudHistorySync$Companion$uploadHistoryData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Deferred[] deferredArr = {BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$1((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$2((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$2>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$3((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$3>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$4((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$4>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$5((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$5>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$6((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$6>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$7((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$7>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$uploadHistoryData$2$tasks$8((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2$tasks$8>) null), 3, (Object) null)};
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
        return obj;
    }
}
