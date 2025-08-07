package com.microtech.aidexx.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.EventHistorySync", f = "EventHistorySync.kt", i = {0}, l = {17}, m = "saveOrUpload", n = {"this"}, s = {"L$0"})
/* compiled from: EventHistorySync.kt */
final class EventHistorySync$saveOrUpload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventHistorySync$saveOrUpload$1(EventHistorySync<T> eventHistorySync, Continuation<? super EventHistorySync$saveOrUpload$1> continuation) {
        super(continuation);
        this.this$0 = eventHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveOrUpload((List) null, this);
    }
}
