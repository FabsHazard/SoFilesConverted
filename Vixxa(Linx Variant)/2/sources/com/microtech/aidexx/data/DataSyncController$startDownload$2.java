package com.microtech.aidexx.data;

import com.microtech.aidexx.data.DataSyncController;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.DataSyncController$startDownload$2", f = "DataSyncController.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DataSyncController.kt */
final class DataSyncController$startDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DataSyncController.SyncStatus, Unit> $cb;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DataSyncController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataSyncController$startDownload$2(DataSyncController<T> dataSyncController, Function1<? super DataSyncController.SyncStatus, Unit> function1, Continuation<? super DataSyncController$startDownload$2> continuation) {
        super(2, continuation);
        this.this$0 = dataSyncController;
        this.$cb = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataSyncController$startDownload$2 dataSyncController$startDownload$2 = new DataSyncController$startDownload$2(this.this$0, this.$cb, continuation);
        dataSyncController$startDownload$2.L$0 = obj;
        return dataSyncController$startDownload$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DataSyncController$startDownload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            MutableStateFlow access$getDownloadStatusStateFlow$p = this.this$0.downloadStatusStateFlow;
            final Function1<DataSyncController.SyncStatus, Unit> function1 = this.$cb;
            this.label = 1;
            if (access$getDownloadStatusStateFlow$p.collect(new FlowCollector() {
                public final Object emit(DataSyncController.SyncStatus syncStatus, Continuation<? super Unit> continuation) {
                    Function1<DataSyncController.SyncStatus, Unit> function1 = function1;
                    if (function1 != null) {
                        function1.invoke(syncStatus);
                    }
                    if ((syncStatus instanceof DataSyncController.SyncStatus.Success) || (syncStatus instanceof DataSyncController.SyncStatus.Failure)) {
                        CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
