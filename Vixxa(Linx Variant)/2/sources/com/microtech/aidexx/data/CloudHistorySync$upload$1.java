package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync", f = "CloudHistorySync.kt", i = {0}, l = {51, 54}, m = "upload$suspendImpl", n = {"$this"}, s = {"L$0"})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$upload$1<T extends BaseEventEntity> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$upload$1(CloudHistorySync<T> cloudHistorySync, Continuation<? super CloudHistorySync$upload$1> continuation) {
        super(continuation);
        this.this$0 = cloudHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return CloudHistorySync.upload$suspendImpl(this.this$0, this);
    }
}
