package com.microtech.aidexx.data;

import com.microtech.aidexx.data.DataSyncController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.DataSyncController", f = "DataSyncController.kt", i = {0, 1, 1, 1, 1, 2, 2, 3, 4}, l = {234, 236, 237, 238, 240}, m = "download", n = {"stopDownloadFun", "this", "userId", "statusFlow", "stopDownloadFun", "statusFlow", "stopDownloadFun", "stopDownloadFun", "stopDownloadFun"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$0"})
/* compiled from: DataSyncController.kt */
final class DataSyncController$download$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataSyncController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataSyncController$download$1(DataSyncController<T> dataSyncController, Continuation<? super DataSyncController$download$1> continuation) {
        super(continuation);
        this.this$0 = dataSyncController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.download((String) null, (MutableStateFlow<DataSyncController.SyncStatus>) null, (Function1<? super Boolean, Unit>) null, this);
    }
}
