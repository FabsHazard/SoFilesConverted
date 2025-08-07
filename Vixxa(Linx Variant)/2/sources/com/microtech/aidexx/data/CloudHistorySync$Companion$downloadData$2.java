package com.microtech.aidexx.data;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$2", f = "CloudHistorySync.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$downloadData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needWait;
    final /* synthetic */ Ref.ObjectRef<CountDownLatch> $taskLatch;
    final /* synthetic */ List<Function0<Boolean>> $tasks;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$Companion$downloadData$2(Ref.ObjectRef<CountDownLatch> objectRef, boolean z, List<? extends Function0<Boolean>> list, Continuation<? super CloudHistorySync$Companion$downloadData$2> continuation) {
        super(2, continuation);
        this.$taskLatch = objectRef;
        this.$needWait = z;
        this.$tasks = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudHistorySync$Companion$downloadData$2(this.$taskLatch, this.$needWait, this.$tasks, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudHistorySync$Companion$downloadData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CountDownLatch countDownLatch;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$taskLatch.element = this.$needWait ? new CountDownLatch(this.$tasks.size()) : null;
            Ref.ObjectRef<CountDownLatch> objectRef = this.$taskLatch;
            for (Function0 invoke : this.$tasks) {
                if (!((Boolean) invoke.invoke()).booleanValue() && (countDownLatch = (CountDownLatch) objectRef.element) != null) {
                    countDownLatch.countDown();
                }
            }
            CountDownLatch countDownLatch2 = (CountDownLatch) this.$taskLatch.element;
            if (countDownLatch2 == null) {
                return null;
            }
            countDownLatch2.await();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
