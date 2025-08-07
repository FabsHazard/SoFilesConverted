package com.microtech.aidexx.data;

import com.microtech.aidexx.data.DataSyncController;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync", f = "CloudHistorySync.kt", i = {0}, l = {68}, m = "getRemoteData$suspendImpl", n = {"$this"}, s = {"L$0"})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$getRemoteData$1<T extends BaseEventEntity> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$getRemoteData$1(CloudHistorySync<T> cloudHistorySync, Continuation<? super CloudHistorySync$getRemoteData$1> continuation) {
        super(continuation);
        this.this$0 = cloudHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CloudHistorySync.getRemoteData$suspendImpl(this.this$0, (String) null, (DataSyncController.SyncTaskItem) null, 0, this);
    }
}
