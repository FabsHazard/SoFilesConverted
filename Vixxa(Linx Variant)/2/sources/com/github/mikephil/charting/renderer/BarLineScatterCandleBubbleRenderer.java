package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {
    protected XBounds mXBounds = new XBounds();

    public BarLineScatterCandleBubbleRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    /* access modifiers changed from: protected */
    public boolean shouldDrawValues(IDataSet iDataSet) {
        return iDataSet.isVisible() && (iDataSet.isDrawValuesEnabled() || iDataSet.isDrawIconsEnabled());
    }

    /* access modifiers changed from: protected */
    public boolean isInBoundsX(Entry entry, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
        if (entry == null) {
            return false;
        }
        float entryIndex = (float) iBarLineScatterCandleBubbleDataSet.getEntryIndex(entry);
        if (entry == null || entryIndex >= ((float) iBarLineScatterCandleBubbleDataSet.getEntryCount()) * this.mAnimator.getPhaseX()) {
            return false;
        }
        return true;
    }

    protected class XBounds {
        public int max;
        public int min;
        public int range;

        protected XBounds() {
        }

        public void set(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
            float max2 = Math.max(0.0f, Math.min(1.0f, BarLineScatterCandleBubbleRenderer.this.mAnimator.getPhaseX()));
            float lowestVisibleX = barLineScatterCandleBubbleDataProvider.getLowestVisibleX();
            float highestVisibleX = barLineScatterCandleBubbleDataProvider.getHighestVisibleX();
            this.min = iBarLineScatterCandleBubbleDataSet.getEntryIndexForXValue(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            int entryIndexForXValue = iBarLineScatterCandleBubbleDataSet.getEntryIndexForXValue(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            this.max = entryIndexForXValue;
            this.range = (int) (((float) (entryIndexForXValue - this.min)) * max2);
        }
    }
}
