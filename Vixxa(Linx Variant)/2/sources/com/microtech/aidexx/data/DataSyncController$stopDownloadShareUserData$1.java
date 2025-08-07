package com.microtech.aidexx.data;

import com.microtech.aidexx.data.DataSyncController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.DataSyncController$stopDownloadShareUserData$1", f = "DataSyncController.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DataSyncController.kt */
final class DataSyncController$stopDownloadShareUserData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataSyncController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataSyncController$stopDownloadShareUserData$1(DataSyncController<T> dataSyncController, Continuation<? super DataSyncController$stopDownloadShareUserData$1> continuation) {
        super(2, continuation);
        this.this$0 = dataSyncController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataSyncController$stopDownloadShareUserData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DataSyncController$stopDownloadShareUserData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.downloadShareDataStatusStateFlow.emit(new DataSyncController.SyncStatus.Failure((String) null, 1, (DefaultConstructorMarker) null), this) == coroutine_suspended) {
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
