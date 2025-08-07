package com.microtech.aidexx.ui.main.trend;

import com.microtech.aidexx.databinding.FragmentTrendBinding;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "startDate", "Ljava/util/Date;", "endDate", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$openCalendar$2 extends Lambda implements Function2<Date, Date, Unit> {
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$openCalendar$2(TrendsFragment trendsFragment) {
        super(2);
        this.this$0 = trendsFragment;
    }

    public final void invoke(Date date, Date date2) {
        Intrinsics.checkNotNullParameter(date, "startDate");
        Intrinsics.checkNotNullParameter(date2, "endDate");
        this.this$0.setCurrentStartDate(date);
        this.this$0.setCurrentEndDate(date2);
        ((FragmentTrendBinding) this.this$0.getBinding()).trendRefreshLayout.autoRefresh();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Date) obj, (Date) obj2);
        return Unit.INSTANCE;
    }
}
