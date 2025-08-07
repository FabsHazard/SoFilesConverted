package com.microtech.aidexx.ui.main.home.chart;

import com.github.mikephil.charting.data.Entry;
import com.microtech.aidexx.views.chart.dataset.ChartEntry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/github/mikephil/charting/data/Entry;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/github/mikephil/charting/data/Entry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$addDst$1$1 extends Lambda implements Function1<Entry, Boolean> {
    final /* synthetic */ String $sensorId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$addDst$1$1(String str) {
        super(1);
        this.$sensorId = str;
    }

    public final Boolean invoke(Entry entry) {
        Object data = entry.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.microtech.aidexx.views.chart.dataset.ChartEntry");
        return Boolean.valueOf(Intrinsics.areEqual((Object) ((ChartEntry) data).getSensorId(), (Object) this.$sensorId));
    }
}
