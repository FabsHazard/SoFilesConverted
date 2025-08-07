package com.microtech.aidexx.ui.main.trend.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.MPPointD;
import com.microtech.aidexx.views.chart.MyAnimatedZoomJob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001:\u0001\\B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010@\u001a\u00020/J\u000e\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020CJ\u0012\u0010D\u001a\u00020/2\b\u0010E\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010F\u001a\u00020\fH\u0016J\b\u0010G\u001a\u00020/H\u0014J(\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\tH\u0014J\u0010\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020OH\u0017J\u0006\u0010P\u001a\u00020/J\u000e\u0010Q\u001a\u00020/2\u0006\u0010R\u001a\u00020\u0016J\b\u0010S\u001a\u00020/H\u0002J:\u0010T\u001a\u00020/2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\u00162\u0006\u0010W\u001a\u00020\u00162\u0006\u0010X\u001a\u00020\u00162\b\u0010Y\u001a\u0004\u0018\u00010%2\u0006\u0010Z\u001a\u00020CH\u0016J\b\u0010[\u001a\u00020/H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R9\u0010*\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\u001a\u00107\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0012\"\u0004\b9\u0010\u0014R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160;¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00160;¢\u0006\b\n\u0000\u001a\u0004\b?\u0010=¨\u0006]"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/view/TrendsChart;", "Lcom/github/mikephil/charting/charts/CombinedChart;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "enableAutoScaleY", "", "getEnableAutoScaleY", "()Z", "setEnableAutoScaleY", "(Z)V", "gridBackgroundEnd", "", "getGridBackgroundEnd", "()F", "setGridBackgroundEnd", "(F)V", "gridBackgroundStart", "getGridBackgroundStart", "setGridBackgroundStart", "highlightOnLongPressedEnable", "getHighlightOnLongPressedEnable", "setHighlightOnLongPressedEnable", "mVisibleXRange", "getMVisibleXRange", "setMVisibleXRange", "majorAxis", "Lcom/github/mikephil/charting/components/YAxis$AxisDependency;", "getMajorAxis", "()Lcom/github/mikephil/charting/components/YAxis$AxisDependency;", "setMajorAxis", "(Lcom/github/mikephil/charting/components/YAxis$AxisDependency;)V", "onSelectX", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "x", "", "getOnSelectX", "()Lkotlin/jvm/functions/Function1;", "setOnSelectX", "(Lkotlin/jvm/functions/Function1;)V", "selectAllow", "getSelectAllow", "setSelectAllow", "touchable", "getTouchable", "setTouchable", "yMaximums", "", "getYMaximums", "()Ljava/util/List;", "yMinimums", "getYMinimums", "autoScaleY", "delayAutoScaleY", "delayMillis", "", "drawGridBackground", "c", "getChartBitmap", "init", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "removeHighLine", "setVisibleXRange", "range", "stopFlying", "zoomAndCenterAnimated", "scaleX", "scaleY", "xValue", "yValue", "axis", "duration", "zoomToVisibleRange", "MyOnChartGestureListener", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsChart.kt */
public class TrendsChart extends CombinedChart {
    private Bitmap bitmap;
    private Canvas canvas;
    private boolean enableAutoScaleY = true;
    private float gridBackgroundEnd;
    private float gridBackgroundStart;
    private boolean highlightOnLongPressedEnable = true;
    private float mVisibleXRange = 6.0f;
    private YAxis.AxisDependency majorAxis;
    private Function1<? super Float, Unit> onSelectX;
    private boolean selectAllow;
    private boolean touchable = true;
    private final List<Float> yMaximums = new ArrayList();
    private final List<Float> yMinimums = new ArrayList();

    /* access modifiers changed from: protected */
    public void drawGridBackground(Canvas canvas2) {
    }

    public final YAxis.AxisDependency getMajorAxis() {
        return this.majorAxis;
    }

    public final void setMajorAxis(YAxis.AxisDependency axisDependency) {
        this.majorAxis = axisDependency;
    }

    public final boolean getHighlightOnLongPressedEnable() {
        return this.highlightOnLongPressedEnable;
    }

    public final void setHighlightOnLongPressedEnable(boolean z) {
        this.highlightOnLongPressedEnable = z;
    }

    public final boolean getTouchable() {
        return this.touchable;
    }

    public final void setTouchable(boolean z) {
        this.touchable = z;
    }

    public final boolean getSelectAllow() {
        return this.selectAllow;
    }

    public final void setSelectAllow(boolean z) {
        this.selectAllow = z;
    }

    public final Function1<Float, Unit> getOnSelectX() {
        return this.onSelectX;
    }

    public final void setOnSelectX(Function1<? super Float, Unit> function1) {
        this.onSelectX = function1;
    }

    public final float getGridBackgroundStart() {
        return this.gridBackgroundStart;
    }

    public final void setGridBackgroundStart(float f) {
        this.gridBackgroundStart = f;
    }

    public final float getGridBackgroundEnd() {
        return this.gridBackgroundEnd;
    }

    public final void setGridBackgroundEnd(float f) {
        this.gridBackgroundEnd = f;
    }

    public final float getMVisibleXRange() {
        return this.mVisibleXRange;
    }

    public final void setMVisibleXRange(float f) {
        this.mVisibleXRange = f;
    }

    public final void setVisibleXRange(float f) {
        this.mVisibleXRange = f;
        stopFlying();
        zoomToVisibleRange();
    }

    public final boolean getEnableAutoScaleY() {
        return this.enableAutoScaleY;
    }

    public final void setEnableAutoScaleY(boolean z) {
        this.enableAutoScaleY = z;
    }

    public final List<Float> getYMaximums() {
        return this.yMaximums;
    }

    public final List<Float> getYMinimums() {
        return this.yMinimums;
    }

    public TrendsChart(Context context) {
        super(context);
    }

    public TrendsChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TrendsChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        setNoDataText("");
        setExtraBottomOffset(18.0f);
        setOnChartGestureListener(new MyOnChartGestureListener());
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        }
        this.bitmap = bitmap2;
        Canvas canvas2 = this.canvas;
        if (canvas2 == null) {
            Bitmap bitmap3 = this.bitmap;
            Intrinsics.checkNotNull(bitmap3);
            canvas2 = new Canvas(bitmap3);
        }
        this.canvas = canvas2;
        try {
            Drawable background = getBackground();
            if (background != null) {
                Canvas canvas3 = this.canvas;
                Intrinsics.checkNotNull(canvas3);
                background.draw(canvas3);
            }
            Canvas canvas4 = this.canvas;
            Intrinsics.checkNotNull(canvas4);
            draw(canvas4);
        } catch (Exception unused) {
        }
        Bitmap bitmap4 = this.bitmap;
        Intrinsics.checkNotNull(bitmap4);
        return bitmap4;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Function1<? super Float, Unit> function1;
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if ((motionEvent.getAction() & 255) != 0 && !this.touchable) {
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.touchable = true;
            this.selectAllow = false;
            Function1<? super Float, Unit> function12 = this.onSelectX;
            if (function12 != null) {
                function12.invoke(null);
            }
        } else if (action == 1) {
            zoomToVisibleRange();
            if (this.enableAutoScaleY) {
                autoScaleY();
            }
        } else if (action == 2 && this.selectAllow && (function1 = this.onSelectX) != null) {
            function1.invoke(Float.valueOf((float) getValuesByTouchPoint(motionEvent.getX(), motionEvent.getY(), this.majorAxis).x));
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float lowestVisibleX = getLowestVisibleX();
        super.onSizeChanged(i, i2, i3, i4);
        if (i3 > 0 || i4 > 0) {
            moveViewToX(lowestVisibleX);
        }
    }

    public void zoomAndCenterAnimated(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency, long j) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        MPPointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.getContentRect().centerY(), axisDependency2);
        addViewportJob(MyAnimatedZoomJob.Companion.getInstance(this.mViewPortHandler, this, getTransformer(axisDependency2), getAxis(axisDependency2), this.mXAxis.mAxisRange, f, f2, this.mViewPortHandler.getScaleX(), this.mViewPortHandler.getScaleY(), f3, f4, (float) valuesByTouchPoint.x, (float) valuesByTouchPoint.y, 200));
        MPPointD.recycleInstance(valuesByTouchPoint);
    }

    /* access modifiers changed from: private */
    public static final void delayAutoScaleY$lambda$0(TrendsChart trendsChart) {
        Intrinsics.checkNotNullParameter(trendsChart, "this$0");
        trendsChart.autoScaleY();
    }

    public final void delayAutoScaleY(long j) {
        postDelayed(new TrendsChart$$ExternalSyntheticLambda0(this), j);
    }

    public final void autoScaleY() {
        if (getData() != null) {
            ((CombinedData) getData()).calcMinMaxY(getLowestVisibleX(), getHighestVisibleX());
            YAxis axis = getAxis(this.majorAxis);
            float axisMaximum = axis.getAxisMaximum();
            Iterator<Float> it = this.yMaximums.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                float floatValue = it.next().floatValue();
                if (((CombinedData) getData()).getYMax() < floatValue) {
                    axisMaximum = floatValue;
                    break;
                }
            }
            float axisMinimum = axis.getAxisMinimum();
            Iterator<Float> it2 = this.yMinimums.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                float floatValue2 = it2.next().floatValue();
                if (((CombinedData) getData()).getYMin() > floatValue2) {
                    axisMinimum = floatValue2;
                    break;
                }
            }
            float axisMaximum2 = (axis.getAxisMaximum() - axis.getAxisMinimum()) / (axisMaximum - axisMinimum);
            if (getScaleY() != axisMaximum2) {
                zoomAndCenterAnimated(getScaleX(), axisMaximum2, (getLowestVisibleX() + getHighestVisibleX()) / 2.0f, (axisMaximum + axisMinimum) / 2.0f, this.majorAxis, 200);
            }
        }
    }

    private final void stopFlying() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        Intrinsics.checkNotNull(chartTouchListener, "null cannot be cast to non-null type com.github.mikephil.charting.listener.BarLineChartTouchListener");
        ((BarLineChartTouchListener) chartTouchListener).stopDeceleration();
    }

    private final void zoomToVisibleRange() {
        zoom(getVisibleXRange() / this.mVisibleXRange, 1.0f, getCenterOffsets().x * ((float) 2), 0.0f);
    }

    public final void removeHighLine() {
        highlightValue((Highlight) null, true);
        setHighlightPerDragEnabled(false);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0016\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u001a\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/view/TrendsChart$MyOnChartGestureListener;", "Lcom/github/mikephil/charting/listener/OnChartGestureListener;", "(Lcom/microtech/aidexx/ui/main/trend/view/TrendsChart;)V", "chart", "Lcom/microtech/aidexx/ui/main/trend/view/TrendsChart;", "highlightAllowed", "", "onChartDoubleTapped", "", "me", "Landroid/view/MotionEvent;", "onChartFling", "me1", "me2", "velocityX", "", "velocityY", "onChartGestureEnd", "lastPerformedGesture", "Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;", "onChartGestureStart", "onChartLongPressed", "onChartScale", "scaleX", "scaleY", "onChartSingleTapped", "onChartTranslate", "dX", "dY", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TrendsChart.kt */
    public final class MyOnChartGestureListener implements OnChartGestureListener {
        private final TrendsChart chart;
        private boolean highlightAllowed = true;

        public void onChartDoubleTapped(MotionEvent motionEvent) {
        }

        public void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        }

        public void onChartScale(MotionEvent motionEvent, float f, float f2) {
        }

        public void onChartSingleTapped(MotionEvent motionEvent) {
        }

        public MyOnChartGestureListener() {
            this.chart = TrendsChart.this;
        }

        public void onChartGestureStart(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
            this.chart.highlightValue((Highlight) null, true);
            this.highlightAllowed = true;
            this.chart.setHighlightPerDragEnabled(false);
        }

        public void onChartGestureEnd(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
            this.highlightAllowed = false;
            this.chart.setHighlightPerDragEnabled(false);
        }

        public void onChartLongPressed(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "me");
            if (TrendsChart.this.getHighlightOnLongPressedEnable()) {
                if (this.highlightAllowed) {
                    TrendsChart.this.setSelectAllow(true);
                    Function1<Float, Unit> onSelectX = TrendsChart.this.getOnSelectX();
                    if (onSelectX != null) {
                        onSelectX.invoke(Float.valueOf((float) TrendsChart.this.getValuesByTouchPoint(motionEvent.getX(), motionEvent.getY(), TrendsChart.this.getMajorAxis()).x));
                    }
                    this.chart.highlightValue(this.chart.getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), true);
                }
                this.chart.setHighlightPerDragEnabled(true);
            }
        }

        public void onChartTranslate(MotionEvent motionEvent, float f, float f2) {
            this.highlightAllowed = false;
        }
    }
}
