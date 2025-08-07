package com.microtech.aidexx.service;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.CloudHistorySync;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.service.DataService$scheduleTask$1$run$1", f = "DataService.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DataService.kt */
final class DataService$scheduleTask$1$run$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    DataService$scheduleTask$1$run$1(Continuation<? super DataService$scheduleTask$1$run$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataService$scheduleTask$1$run$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DataService$scheduleTask$1$run$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CloudHistorySync.Companion companion = CloudHistorySync.Companion;
            String curShowUserId = UserInfoManager.Companion.getCurShowUserId();
            this.label = 1;
            if (CloudHistorySync.Companion.downloadData$default(companion, curShowUserId, false, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
