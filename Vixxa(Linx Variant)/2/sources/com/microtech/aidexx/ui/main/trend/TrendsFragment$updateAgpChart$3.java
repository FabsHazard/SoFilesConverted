package com.microtech.aidexx.ui.main.trend;

import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"com/microtech/aidexx/ui/main/trend/TrendsFragment$updateAgpChart$3", "Lcom/github/mikephil/charting/formatter/IFillFormatter;", "getFillLine", "Lcom/github/mikephil/charting/interfaces/datasets/ILineDataSet;", "dataSet", "dataProvider", "Lcom/github/mikephil/charting/interfaces/dataprovider/LineDataProvider;", "getFillLinePosition", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
public final class TrendsFragment$updateAgpChart$3 implements IFillFormatter {
    final /* synthetic */ LineDataSet $p25DataSet;

    public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        return 0.0f;
    }

    TrendsFragment$updateAgpChart$3(LineDataSet lineDataSet) {
        this.$p25DataSet = lineDataSet;
    }

    public ILineDataSet getFillLine(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        return this.$p25DataSet;
    }
}
