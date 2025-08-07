package com.microtech.aidexx.ui.main.trend;

import com.github.mikephil.charting.formatter.ValueFormatter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/main/trend/TrendsFragment$updateAgpChart$1", "Lcom/github/mikephil/charting/formatter/ValueFormatter;", "getFormattedValue", "", "value", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
public final class TrendsFragment$updateAgpChart$1 extends ValueFormatter {
    final /* synthetic */ TrendsFragment this$0;

    TrendsFragment$updateAgpChart$1(TrendsFragment trendsFragment) {
        this.this$0 = trendsFragment;
    }

    public String getFormattedValue(float f) {
        return this.this$0.getFormatText(f);
    }
}
