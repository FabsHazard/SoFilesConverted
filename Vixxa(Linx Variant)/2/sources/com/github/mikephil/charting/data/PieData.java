package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import java.util.List;

public class PieData extends ChartData<IPieDataSet> {
    public PieData() {
    }

    public PieData(IPieDataSet iPieDataSet) {
        super((T[]) new IPieDataSet[]{iPieDataSet});
    }

    public void setDataSet(IPieDataSet iPieDataSet) {
        this.mDataSets.clear();
        this.mDataSets.add(iPieDataSet);
        notifyDataChanged();
    }

    public IPieDataSet getDataSet() {
        return (IPieDataSet) this.mDataSets.get(0);
    }

    public List<IPieDataSet> getDataSets() {
        List<IPieDataSet> dataSets = super.getDataSets();
        if (dataSets.size() < 1) {
            Log.e(Chart.LOG_TAG, "Found multiple data sets while pie chart only allows one");
        }
        return dataSets;
    }

    public IPieDataSet getDataSetByIndex(int i) {
        if (i == 0) {
            return getDataSet();
        }
        return null;
    }

    public IPieDataSet getDataSetByLabel(String str, boolean z) {
        if (z) {
            if (str.equalsIgnoreCase(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
                return (IPieDataSet) this.mDataSets.get(0);
            }
            return null;
        } else if (str.equals(((IPieDataSet) this.mDataSets.get(0)).getLabel())) {
            return (IPieDataSet) this.mDataSets.get(0);
        } else {
            return null;
        }
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        return getDataSet().getEntryForIndex((int) highlight.getX());
    }

    public float getYValueSum() {
        float f = 0.0f;
        for (int i = 0; i < getDataSet().getEntryCount(); i++) {
            Entry entryForIndex = getDataSet().getEntryForIndex(i);
            if (entryForIndex != null) {
                f += entryForIndex.getY();
            }
        }
        return f;
    }
}
