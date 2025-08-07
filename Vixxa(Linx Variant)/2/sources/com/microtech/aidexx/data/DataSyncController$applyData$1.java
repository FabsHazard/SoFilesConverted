package com.microtech.aidexx.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.DataSyncController", f = "DataSyncController.kt", i = {0}, l = {286}, m = "applyData", n = {"data"}, s = {"L$0"})
/* compiled from: DataSyncController.kt */
final class DataSyncController$applyData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataSyncController<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataSyncController$applyData$1(DataSyncController<T> dataSyncController, Continuation<? super DataSyncController$applyData$1> continuation) {
        super(continuation);
        this.this$0 = dataSyncController;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.applyData((String) null, (List) null, this);
    }
}
