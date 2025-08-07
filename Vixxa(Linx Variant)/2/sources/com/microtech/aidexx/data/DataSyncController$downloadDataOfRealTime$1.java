package com.microtech.aidexx.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.DataSyncController", f = "DataSyncController.kt", i = {0, 0, 1, 1}, l = {368, 372, 382}, m = "downloadDataOfRealTime", n = {"this", "userId", "this", "userId"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: DataSyncController.kt */
final class DataSyncController$downloadDataOfRealTime$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataSyncController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataSyncController$downloadDataOfRealTime$1(DataSyncController<T> dataSyncController, Continuation<? super DataSyncController$downloadDataOfRealTime$1> continuation) {
        super(continuation);
        this.this$0 = dataSyncController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadDataOfRealTime((String) null, this);
    }
}
