package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync", f = "CloudHistorySync.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {94, 108}, m = "downloadData$suspendImpl", n = {"$this", "userId", "syncTaskItem", "pageSize", "$this", "userId", "syncTaskItem", "it", "dataList", "pageSize"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$downloadData$1<T extends BaseEventEntity> extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$downloadData$1(CloudHistorySync<T> cloudHistorySync, Continuation<? super CloudHistorySync$downloadData$1> continuation) {
        super(continuation);
        this.this$0 = cloudHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CloudHistorySync.downloadData$suspendImpl(this.this$0, (String) null, this);
    }
}
