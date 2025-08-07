package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.CalibrateEntity;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudCalHistorySync", f = "CloudCalHistorySync.kt", i = {0}, l = {28}, m = "postLocalData", n = {"this"}, s = {"L$0"})
/* compiled from: CloudCalHistorySync.kt */
final class CloudCalHistorySync$postLocalData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudCalHistorySync this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudCalHistorySync$postLocalData$1(CloudCalHistorySync cloudCalHistorySync, Continuation<? super CloudCalHistorySync$postLocalData$1> continuation) {
        super(continuation);
        this.this$0 = cloudCalHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.postLocalData((HashMap<String, List<CalibrateEntity>>) null, this);
    }
}
