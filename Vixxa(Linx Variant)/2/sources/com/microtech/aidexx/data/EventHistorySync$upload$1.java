package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.EventHistorySync", f = "EventHistorySync.kt", i = {0, 1, 1}, l = {47, 49, 50}, m = "upload$suspendImpl", n = {"$this", "$this", "it"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: EventHistorySync.kt */
final class EventHistorySync$upload$1<T extends BaseEventEntity> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHistorySync$upload$1(EventHistorySync<T> eventHistorySync, Continuation<? super EventHistorySync$upload$1> continuation) {
        super(continuation);
        this.this$0 = eventHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EventHistorySync.upload$suspendImpl(this.this$0, this);
    }
}
