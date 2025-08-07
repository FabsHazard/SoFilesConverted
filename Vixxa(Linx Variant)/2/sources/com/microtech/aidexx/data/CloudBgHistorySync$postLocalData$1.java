package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudBgHistorySync", f = "CloudBgHistorySync.kt", i = {0}, l = {27}, m = "postLocalData", n = {"this"}, s = {"L$0"})
/* compiled from: CloudBgHistorySync.kt */
final class CloudBgHistorySync$postLocalData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CloudBgHistorySync this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudBgHistorySync$postLocalData$1(CloudBgHistorySync cloudBgHistorySync, Continuation<? super CloudBgHistorySync$postLocalData$1> continuation) {
        super(continuation);
        this.this$0 = cloudBgHistorySync;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.postLocalData((HashMap<String, List<BloodGlucoseEntity>>) null, this);
    }
}
