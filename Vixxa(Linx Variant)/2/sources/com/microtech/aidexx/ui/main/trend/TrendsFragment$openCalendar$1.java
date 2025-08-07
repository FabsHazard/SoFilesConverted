package com.microtech.aidexx.ui.main.trend;

import com.microtech.aidexx.databinding.FragmentTrendBinding;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "position", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$openCalendar$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$openCalendar$1(TrendsFragment trendsFragment) {
        super(1);
        this.this$0 = trendsFragment;
    }

    public final void invoke(int i) {
        Date dateLastWeek = Dialogs.DateInfo.INSTANCE.getDateLastWeek();
        Intrinsics.checkNotNull(dateLastWeek);
        if (i == 1) {
            dateLastWeek = Dialogs.DateInfo.INSTANCE.getDateLastWeek();
            Intrinsics.checkNotNull(dateLastWeek);
        } else if (i == 2) {
            dateLastWeek = Dialogs.DateInfo.INSTANCE.getDateLast14days();
            Intrinsics.checkNotNull(dateLastWeek);
            this.this$0.setRangeChanged(true);
        } else if (i == 3) {
            dateLastWeek = Dialogs.DateInfo.INSTANCE.getDateLastMonth();
            Intrinsics.checkNotNull(dateLastWeek);
            this.this$0.setRangeChanged(true);
        }
        this.this$0.setCurrentStartDate(dateLastWeek);
        TrendsFragment trendsFragment = this.this$0;
        Date dateToday = Dialogs.DateInfo.INSTANCE.getDateToday();
        Intrinsics.checkNotNull(dateToday);
        trendsFragment.setCurrentEndDate(dateToday);
        ((FragmentTrendBinding) this.this$0.getBinding()).trendRefreshLayout.autoRefresh();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }
}
