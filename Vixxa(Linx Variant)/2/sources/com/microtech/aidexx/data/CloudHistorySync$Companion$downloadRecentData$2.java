package com.microtech.aidexx.data;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2", f = "CloudHistorySync.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"isSuccess"}, s = {"L$0"})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$downloadRecentData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$Companion$downloadRecentData$2(String str, Continuation<? super CloudHistorySync$Companion$downloadRecentData$2> continuation) {
        super(2, continuation);
        this.$userId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CloudHistorySync$Companion$downloadRecentData$2 cloudHistorySync$Companion$downloadRecentData$2 = new CloudHistorySync$Companion$downloadRecentData$2(this.$userId, continuation);
        cloudHistorySync$Companion$downloadRecentData$2.L$0 = obj;
        return cloudHistorySync$Companion$downloadRecentData$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CloudHistorySync$Companion$downloadRecentData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            booleanRef2.element = true;
            Deferred[] deferredArr = {BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$1(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$2(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$2>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$3(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$3>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$4(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$4>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$5(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$5>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$6(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$6>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$7(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$7>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$8(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$8>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$9(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$9>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$10(this.$userId, booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$10>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CloudHistorySync$Companion$downloadRecentData$2$tasks$11(booleanRef2, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$11>) null), 3, (Object) null)};
            this.L$0 = booleanRef2;
            this.label = 1;
            if (AwaitKt.awaitAll(CollectionsKt.listOf(deferredArr), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(booleanRef.element);
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$updateStatus(Ref.BooleanRef booleanRef, boolean z) {
        if (!z) {
            booleanRef.element = false;
        }
    }
}
