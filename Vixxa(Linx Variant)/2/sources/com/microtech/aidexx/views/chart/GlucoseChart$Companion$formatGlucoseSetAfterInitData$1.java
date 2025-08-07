package com.microtech.aidexx.views.chart;

import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/microtech/aidexx/views/chart/GlucoseChart$Companion$formatGlucoseSetAfterInitData$1", "Lcom/github/mikephil/charting/formatter/IFillFormatter;", "getFillLine", "Lcom/github/mikephil/charting/interfaces/datasets/ILineDataSet;", "dataSet", "dataProvider", "Lcom/github/mikephil/charting/interfaces/dataprovider/LineDataProvider;", "getFillLinePosition", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseChart.kt */
public final class GlucoseChart$Companion$formatGlucoseSetAfterInitData$1 implements IFillFormatter {
    final /* synthetic */ float $lowerLimit;
    final /* synthetic */ float $upperLimit;

    public ILineDataSet getFillLine(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        return null;
    }

    GlucoseChart$Companion$formatGlucoseSetAfterInitData$1(float f, float f2) {
        this.$upperLimit = f;
        this.$lowerLimit = f2;
    }

    public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        return (this.$upperLimit + this.$lowerLimit) / ((float) 2);
    }
}
