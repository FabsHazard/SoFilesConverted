package com.microtech.aidexx.views.calendar;

import com.haibin.calendarview.BaseMonthView;
import com.microtech.aidexx.databinding.DialogCalendarBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.views.calendar.CalendarSingleDialog$1$1$1", f = "CalendarDialog.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CalendarDialog.kt */
final class CalendarSingleDialog$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $month;
    final /* synthetic */ DialogCalendarBinding $this_apply;
    final /* synthetic */ int $year;
    int label;
    final /* synthetic */ CalendarSingleDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarSingleDialog$1$1$1(int i, int i2, CalendarSingleDialog calendarSingleDialog, DialogCalendarBinding dialogCalendarBinding, Continuation<? super CalendarSingleDialog$1$1$1> continuation) {
        super(2, continuation);
        this.$year = i;
        this.$month = i2;
        this.this$0 = calendarSingleDialog;
        this.$this_apply = dialogCalendarBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CalendarSingleDialog$1$1$1(this.$year, this.$month, this.this$0, this.$this_apply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CalendarSingleDialog$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CalendarDataCache.INSTANCE.loadThisMonthData(this.$year, this.$month, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (this.this$0.isShowing() && this.$this_apply.calendarView != null) {
            BaseMonthView baseMonthView = (BaseMonthView) this.$this_apply.calendarView.getMonthViewPager().findViewWithTag(Boxing.boxInt(this.$this_apply.calendarView.getMonthViewPager().getCurrentItem()));
            if (baseMonthView != null) {
                baseMonthView.postInvalidate();
            }
        }
        return Unit.INSTANCE;
    }
}
