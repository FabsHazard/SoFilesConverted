package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.EventPresetSync", f = "EventPresetSync.kt", i = {0, 1, 1}, l = {50, 52, 53}, m = "upload$suspendImpl", n = {"$this", "$this", "it"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: EventPresetSync.kt */
final class EventPresetSync$upload$1<T extends BasePresetEntity> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventPresetSync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventPresetSync$upload$1(EventPresetSync<T> eventPresetSync, Continuation<? super EventPresetSync$upload$1> continuation) {
        super(continuation);
        this.this$0 = eventPresetSync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EventPresetSync.upload$suspendImpl(this.this$0, this);
    }
}
