package com.microtech.aidexx.views.chart.dataset;

import com.github.mikephil.charting.data.Entry;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/views/chart/dataset/ChartEntry;", "Lcom/github/mikephil/charting/data/Entry;", "xValue", "", "yValue", "data", "", "(FFLjava/lang/Object;)V", "equals", "", "other", "hashCode", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventEntryConverter.kt */
public final class ChartEntry extends Entry {
    public ChartEntry(float f, float f2, Object obj) {
        super(f, f2, obj);
    }

    public int hashCode() {
        return getData().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ChartEntry)) {
            return false;
        }
        return (getData() != null && getData().equals(((ChartEntry) obj).getData())) || equalTo((Entry) obj);
    }
}
