package com.microtech.aidexx.views.calendar;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.views.calendar.CalendarDataCache", f = "CalendarDialog.kt", i = {0, 0, 0, 0}, l = {331}, m = "loadThisMonthData", n = {"day31", "key", "year", "month"}, s = {"L$0", "L$2", "I$0", "I$1"})
/* compiled from: CalendarDialog.kt */
final class CalendarDataCache$loadThisMonthData$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CalendarDataCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarDataCache$loadThisMonthData$1(CalendarDataCache calendarDataCache, Continuation<? super CalendarDataCache$loadThisMonthData$1> continuation) {
        super(continuation);
        this.this$0 = calendarDataCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadThisMonthData(0, 0, this);
    }
}
