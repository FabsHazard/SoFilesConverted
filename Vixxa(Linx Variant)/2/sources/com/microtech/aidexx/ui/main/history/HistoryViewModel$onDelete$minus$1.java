package com.microtech.aidexx.ui.main.history;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "a", "b", "invoke", "(DD)Ljava/lang/Double;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryViewModel.kt */
final class HistoryViewModel$onDelete$minus$1 extends Lambda implements Function2<Double, Double, Double> {
    public static final HistoryViewModel$onDelete$minus$1 INSTANCE = new HistoryViewModel$onDelete$minus$1();

    HistoryViewModel$onDelete$minus$1() {
        super(2);
    }

    public final Double invoke(double d, double d2) {
        return Double.valueOf(d - d2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).doubleValue(), ((Number) obj2).doubleValue());
    }
}
