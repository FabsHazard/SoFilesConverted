package com.microtech.aidexx.ui.setting.timezonehistory;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager", f = "TimezoneHistoryManager.kt", i = {1}, l = {95, 63}, m = "uploadTimezoneHistory", n = {"needUploadHistory"}, s = {"L$0"})
/* compiled from: TimezoneHistoryManager.kt */
final class TimezoneHistoryManager$uploadTimezoneHistory$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TimezoneHistoryManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimezoneHistoryManager$uploadTimezoneHistory$1(TimezoneHistoryManager timezoneHistoryManager, Continuation<? super TimezoneHistoryManager$uploadTimezoneHistory$1> continuation) {
        super(continuation);
        this.this$0 = timezoneHistoryManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadTimezoneHistory(this);
    }
}
