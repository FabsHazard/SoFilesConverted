package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudCgmHistorySync", f = "CloudCgmHistorySync.kt", i = {0}, l = {88}, m = "updateHistory", n = {"this"}, s = {"L$0"})
/* compiled from: CloudCgmHistorySync.kt */
final class CloudCgmHistorySync$updateHistory$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudCgmHistorySync this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudCgmHistorySync$updateHistory$1(CloudCgmHistorySync cloudCgmHistorySync, Continuation<? super CloudCgmHistorySync$updateHistory$1> continuation) {
        super(continuation);
        this.this$0 = cloudCgmHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateHistory((HashMap<String, List<RealCgmHistoryEntity>>) null, this);
    }
}
