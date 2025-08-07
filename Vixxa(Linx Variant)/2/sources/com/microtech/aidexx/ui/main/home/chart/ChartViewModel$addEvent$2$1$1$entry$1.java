package com.microtech.aidexx.ui.main.home.chart;

import com.microtech.aidexx.utils.GlucoseUtilKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewModel.kt */
final class ChartViewModel$addEvent$2$1$1$entry$1 extends Lambda implements Function0<Float> {
    public static final ChartViewModel$addEvent$2$1$1$entry$1 INSTANCE = new ChartViewModel$addEvent$2$1$1$entry$1();

    ChartViewModel$addEvent$2$1$1$entry$1() {
        super(0);
    }

    public final Float invoke() {
        return Float.valueOf(GlucoseUtilKt.toGlucoseValue(90.0f));
    }
}
