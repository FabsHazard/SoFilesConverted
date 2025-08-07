package com.microtech.aidexx.ui.main.history;

import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/util/Date;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryFragment.kt */
final class HistoryFragment$initTitle$1$4$1 extends Lambda implements Function1<Date, Unit> {
    final /* synthetic */ HistoryFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HistoryFragment$initTitle$1$4$1(HistoryFragment historyFragment) {
        super(1);
        this.this$0 = historyFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Date) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Date date) {
        Intrinsics.checkNotNullParameter(date, "it");
        this.this$0.getVm().updateDate(date);
    }
}
