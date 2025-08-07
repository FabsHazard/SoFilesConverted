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
@DebugMetadata(c = "com.microtech.aidexx.views.calendar.CalendarDialog$1$1", f = "CalendarDialog.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CalendarDialog.kt */
final class CalendarDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DialogCalendarBinding $bind;
    final /* synthetic */ int $month;
    final /* synthetic */ int $year;
    int label;
    final /* synthetic */ CalendarDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarDialog$1$1(int i, int i2, CalendarDialog calendarDialog, DialogCalendarBinding dialogCalendarBinding, Continuation<? super CalendarDialog$1$1> continuation) {
        super(2, continuation);
        this.$year = i;
        this.$month = i2;
        this.this$0 = calendarDialog;
        this.$bind = dialogCalendarBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CalendarDialog$1$1(this.$year, this.$month, this.this$0, this.$bind, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CalendarDialog$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        if (this.this$0.isShowing() && this.$bind.calendarView != null) {
            BaseMonthView baseMonthView = (BaseMonthView) this.$bind.calendarView.getMonthViewPager().findViewWithTag(Boxing.boxInt(this.$bind.calendarView.getMonthViewPager().getCurrentItem()));
            if (baseMonthView != null) {
                baseMonthView.postInvalidate();
            }
        }
        return Unit.INSTANCE;
    }
}
