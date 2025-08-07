package com.microtech.aidexx.data.wear;

import com.microtech.aidexx.common.net.entity.DeviceHeartBeat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.wear.WatchData", f = "WatchData.kt", i = {}, l = {33}, m = "uploadHeartBeat", n = {}, s = {})
/* compiled from: WatchData.kt */
final class WatchData$uploadHeartBeat$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WatchData$uploadHeartBeat$1(WatchData watchData, Continuation<? super WatchData$uploadHeartBeat$1> continuation) {
        super(continuation);
        this.this$0 = watchData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadHeartBeat((DeviceHeartBeat) null, this);
    }
}
