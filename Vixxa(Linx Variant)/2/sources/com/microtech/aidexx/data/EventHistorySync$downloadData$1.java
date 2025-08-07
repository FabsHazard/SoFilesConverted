package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.EventHistorySync", f = "EventHistorySync.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {63, 66}, m = "downloadData$suspendImpl", n = {"$this", "userId", "syncTaskItem", "$this", "userId", "syncTaskItem", "it"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: EventHistorySync.kt */
final class EventHistorySync$downloadData$1<T extends BaseEventEntity> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHistorySync$downloadData$1(EventHistorySync<T> eventHistorySync, Continuation<? super EventHistorySync$downloadData$1> continuation) {
        super(continuation);
        this.this$0 = eventHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EventHistorySync.downloadData$suspendImpl(this.this$0, (String) null, this);
    }
}
