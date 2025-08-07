package com.microtech.aidexx.ui.setting.timezonehistory;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager", f = "TimezoneHistoryManager.kt", i = {}, l = {79}, m = "downloadTimezoneHistory", n = {}, s = {})
/* compiled from: TimezoneHistoryManager.kt */
final class TimezoneHistoryManager$downloadTimezoneHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TimezoneHistoryManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimezoneHistoryManager$downloadTimezoneHistory$1(TimezoneHistoryManager timezoneHistoryManager, Continuation<? super TimezoneHistoryManager$downloadTimezoneHistory$1> continuation) {
        super(continuation);
        this.this$0 = timezoneHistoryManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadTimezoneHistory(this);
    }
}
