package com.microtech.aidexx.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync", f = "CloudHistorySync.kt", i = {}, l = {159}, m = "getNeedUploadData", n = {}, s = {})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$getNeedUploadData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudHistorySync<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$getNeedUploadData$1(CloudHistorySync<T> cloudHistorySync, Continuation<? super CloudHistorySync$getNeedUploadData$1> continuation) {
        super(continuation);
        this.this$0 = cloudHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getNeedUploadData(this);
    }
}
