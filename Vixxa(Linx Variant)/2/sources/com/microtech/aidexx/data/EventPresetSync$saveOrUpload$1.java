package com.microtech.aidexx.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.EventPresetSync", f = "EventPresetSync.kt", i = {0}, l = {37}, m = "saveOrUpload", n = {"this"}, s = {"L$0"})
/* compiled from: EventPresetSync.kt */
final class EventPresetSync$saveOrUpload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventPresetSync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventPresetSync$saveOrUpload$1(EventPresetSync<T> eventPresetSync, Continuation<? super EventPresetSync$saveOrUpload$1> continuation) {
        super(continuation);
        this.this$0 = eventPresetSync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveOrUpload((List) null, this);
    }
}
