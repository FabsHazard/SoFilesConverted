package com.microtech.aidexx.data;

import com.microtech.aidexx.data.CloudHistorySync;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync$Companion", f = "CloudHistorySync.kt", i = {0, 0}, l = {244}, m = "downloadData", n = {"isSuccess", "needWait"}, s = {"L$0", "Z$0"})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$downloadData$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudHistorySync.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$Companion$downloadData$1(CloudHistorySync.Companion companion, Continuation<? super CloudHistorySync$Companion$downloadData$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadData((String) null, false, this);
    }
}
