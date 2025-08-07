package com.microtech.aidexx.views.chart;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.MPPointD;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.chart.dataset.BgDataSet;
import com.microtech.aidexx.views.chart.dataset.CalDataSet;
import com.microtech.aidexx.views.chart.dataset.GlucoseDataSet;
import com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u0000 x2\u00020\u0001:\u0004wxyzB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010Z\u001a\u00020JJ\u000e\u0010[\u001a\u00020J2\u0006\u0010\\\u001a\u000201J\u0012\u0010]\u001a\u00020J2\b\u0010^\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010_\u001a\u00020\u0016H\u0016J\b\u0010`\u001a\u00020JH\u0014J\u0010\u0010a\u001a\u00020J2\u0006\u0010b\u001a\u00020cH\u0002J(\u0010d\u001a\u00020J2\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020\t2\u0006\u0010h\u001a\u00020\tH\u0014J\u0010\u0010i\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020cH\u0017J\b\u0010j\u001a\u00020JH\u0016J\u0006\u0010k\u001a\u00020JJ\u000e\u0010l\u001a\u00020J2\u0006\u0010m\u001a\u00020\u0010J\b\u0010n\u001a\u00020JH\u0002J:\u0010o\u001a\u00020J2\u0006\u0010p\u001a\u00020\u00102\u0006\u0010q\u001a\u00020\u00102\u0006\u0010r\u001a\u00020\u00102\u0006\u0010s\u001a\u00020\u00102\b\u0010t\u001a\u0004\u0018\u00010:2\u0006\u0010u\u001a\u000201H\u0016J\b\u0010v\u001a\u00020JH\u0002R/\u0010\u000b\u001a \u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R/\u0010\u0013\u001a \u0012\u0004\u0012\u00020\r\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000e0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001a\u0010'\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u000e\u0010*\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001a\u0010.\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u0010#R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR9\u0010E\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020J\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010!\"\u0004\bQ\u0010#R\u001a\u0010R\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010!\"\u0004\bT\u0010#R\u001a\u0010U\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006{"}, d2 = {"Lcom/microtech/aidexx/views/chart/MyChart;", "Lcom/github/mikephil/charting/charts/CombinedChart;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoYMaxRule", "", "", "", "Lkotlin/Pair;", "", "getAutoYMaxRule", "()Ljava/util/Map;", "autoYMinRule", "getAutoYMinRule", "bitmap", "Landroid/graphics/Bitmap;", "canvas", "Landroid/graphics/Canvas;", "curYUpper", "getCurYUpper", "()F", "setCurYUpper", "(F)V", "enableAutoScaleY", "", "getEnableAutoScaleY", "()Z", "setEnableAutoScaleY", "(Z)V", "gridBackgroundEnd", "getGridBackgroundEnd", "setGridBackgroundEnd", "gridBackgroundStart", "getGridBackgroundStart", "setGridBackgroundStart", "hasReloaded", "highlightOnLongPressedEnable", "getHighlightOnLongPressedEnable", "setHighlightOnLongPressedEnable", "isFling", "setFling", "lowestVisibleXBeforeOrientationChanged", "", "getLowestVisibleXBeforeOrientationChanged", "()J", "setLowestVisibleXBeforeOrientationChanged", "(J)V", "mVisibleXRange", "getMVisibleXRange", "setMVisibleXRange", "majorAxis", "Lcom/github/mikephil/charting/components/YAxis$AxisDependency;", "getMajorAxis", "()Lcom/github/mikephil/charting/components/YAxis$AxisDependency;", "setMajorAxis", "(Lcom/github/mikephil/charting/components/YAxis$AxisDependency;)V", "onScrollListener", "Lcom/microtech/aidexx/views/chart/MyChart$ScrollListener;", "getOnScrollListener", "()Lcom/microtech/aidexx/views/chart/MyChart$ScrollListener;", "setOnScrollListener", "(Lcom/microtech/aidexx/views/chart/MyChart$ScrollListener;)V", "onSelectX", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "x", "", "getOnSelectX", "()Lkotlin/jvm/functions/Function1;", "setOnSelectX", "(Lkotlin/jvm/functions/Function1;)V", "selectAllow", "getSelectAllow", "setSelectAllow", "touchable", "getTouchable", "setTouchable", "unitTag", "getUnitTag", "()Ljava/lang/String;", "setUnitTag", "(Ljava/lang/String;)V", "autoScaleY", "delayAutoScaleY", "delayMillis", "drawGridBackground", "c", "getChartBitmap", "init", "onSelectXCallback", "event", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "reload", "removeHighLine", "setVisibleXRange", "range", "stopFlying", "zoomAndCenterAnimated", "scaleX", "scaleY", "xValue", "yValue", "axis", "duration", "zoomToVisibleRange", "ChartGranularityPerScreen", "Companion", "MyOnChartGestureListener", "ScrollListener", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MyChart.kt */
public class MyChart extends CombinedChart {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int G_HALF_DAY = 2;
    public static final int G_ONE_DAY = 4;
    public static final int G_SIX_HOURS = 1;
    private final Map<String, List<Pair<Float, Float>>> autoYMaxRule = new LinkedHashMap();
    private final Map<String, List<Pair<Float, Float>>> autoYMinRule = new LinkedHashMap();
    private Bitmap bitmap;
    private Canvas canvas;
    private float curYUpper;
    private boolean enableAutoScaleY;
    private float gridBackgroundEnd;
    private float gridBackgroundStart;
    private volatile boolean hasReloaded;
    private boolean highlightOnLongPressedEnable = true;
    private boolean isFling;
    private long lowestVisibleXBeforeOrientationChanged = -1;
    private float mVisibleXRange = 6.0f;
    private YAxis.AxisDependency majorAxis;
    private ScrollListener onScrollListener;
    private Function1<? super Float, Unit> onSelectX;
    private boolean selectAllow;
    private boolean touchable = true;
    private String unitTag = "";

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/microtech/aidexx/views/chart/MyChart$ChartGranularityPerScreen;", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: MyChart.kt */
    public @interface ChartGranularityPerScreen {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/views/chart/MyChart$ScrollListener;", "", "onToEndLeft", "", "onToEndRight", "onXAxisVisibleAreaChanged", "", "isLtr", "", "visibleLeftX", "", "visibleRightX", "xAxisMin", "xAxisMax", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MyChart.kt */
    public interface ScrollListener {
        void onToEndLeft();

        void onToEndRight();

        int onXAxisVisibleAreaChanged(boolean z, float f, float f2, float f3, float f4);
    }

    public void reload() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/views/chart/MyChart$Companion;", "", "()V", "G_HALF_DAY", "", "G_ONE_DAY", "G_SIX_HOURS", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MyChart.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final long getLowestVisibleXBeforeOrientationChanged() {
        return this.lowestVisibleXBeforeOrientationChanged;
    }

    public final void setLowestVisibleXBeforeOrientationChanged(long j) {
        this.lowestVisibleXBeforeOrientationChanged = j;
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

    public final String getUnitTag() {
        return this.unitTag;
    }

    public final void setUnitTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.unitTag = str;
    }

    public final Map<String, List<Pair<Float, Float>>> getAutoYMaxRule() {
        return this.autoYMaxRule;
    }

    public final Map<String, List<Pair<Float, Float>>> getAutoYMinRule() {
        return this.autoYMinRule;
    }

    public final ScrollListener getOnScrollListener() {
        return this.onScrollListener;
    }

    public final void setOnScrollListener(ScrollListener scrollListener) {
        this.onScrollListener = scrollListener;
    }

    public final boolean isFling() {
        return this.isFling;
    }

    public final void setFling(boolean z) {
        this.isFling = z;
    }

    public final float getCurYUpper() {
        return this.curYUpper;
    }

    public final void setCurYUpper(float f) {
        this.curYUpper = f;
    }

    public MyChart(Context context) {
        super(context);
    }

    public MyChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        setNoDataText("");
        setOnChartGestureListener(new MyOnChartGestureListener());
    }

    /* access modifiers changed from: protected */
    public void drawGridBackground(Canvas canvas2) {
        if (this.mDrawGridBackground) {
            RectF rectF = new RectF(this.mViewPortHandler.getContentRect());
            rectF.bottom = (float) getPixelForValues(getXChartMin(), this.gridBackgroundStart, this.majorAxis).y;
            rectF.top = (float) getPixelForValues(getXChartMin(), this.gridBackgroundEnd, this.majorAxis).y;
            if (Float.isNaN(rectF.bottom) || Float.isNaN(rectF.top)) {
                LogUtil.Companion.xLogE("===CHART=== 图表高低区间绘制失败 " + this, "MyChart");
                LogUtil.Companion.d("===CHART=== 图表高低区间绘制失败 " + this, "MyChart");
                if (!this.hasReloaded) {
                    this.hasReloaded = true;
                    reload();
                }
            } else {
                this.hasReloaded = false;
            }
            Intrinsics.checkNotNull(canvas2);
            canvas2.drawRect(rectF, this.mGridBackgroundPaint);
        }
        if (this.mDrawBorders) {
            Intrinsics.checkNotNull(canvas2);
            canvas2.drawRect(this.mViewPortHandler.getContentRect(), this.mBorderPaint);
        }
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        }
        this.bitmap = bitmap2;
        if (bitmap2 != null) {
            Canvas canvas2 = this.canvas;
            if (canvas2 == null) {
                canvas2 = new Canvas(bitmap2);
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
        }
        Bitmap bitmap3 = this.bitmap;
        Intrinsics.checkNotNull(bitmap3);
        return bitmap3;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if ((motionEvent.getAction() & 255) != 0 && !this.touchable) {
            return false;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.isFling = false;
            this.touchable = true;
            this.selectAllow = false;
            Function1<? super Float, Unit> function1 = this.onSelectX;
            if (function1 != null) {
                function1.invoke(null);
            }
        } else if (action != 1) {
            if (action == 2 && this.selectAllow) {
                onSelectXCallback(motionEvent);
            }
        } else if (!this.isFling) {
            zoomToVisibleRange();
            if (this.enableAutoScaleY) {
                autoScaleY();
            }
        }
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        LogUtil.Companion.xLogI("onSizeChanged " + i + ' ' + i2 + ' ' + i3 + ' ' + i4, "MyChart");
        if ((i3 > 0 || i4 > 0) && this.lowestVisibleXBeforeOrientationChanged != -1) {
            postDelayed(new MyChart$$ExternalSyntheticLambda0(this), 1000);
        }
    }

    /* access modifiers changed from: private */
    public static final void onSizeChanged$lambda$2(MyChart myChart) {
        Intrinsics.checkNotNullParameter(myChart, "this$0");
        float secondToX = ChartUtil.INSTANCE.secondToX(myChart.lowestVisibleXBeforeOrientationChanged);
        new Date().setTime(myChart.lowestVisibleXBeforeOrientationChanged * ((long) 1000));
        myChart.moveViewToX(secondToX);
    }

    public void zoomAndCenterAnimated(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency, long j) {
        YAxis.AxisDependency axisDependency2 = axisDependency;
        MPPointD valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.getContentRect().centerY(), axisDependency2);
        addViewportJob(MyAnimatedZoomJob.Companion.getInstance(this.mViewPortHandler, this, getTransformer(axisDependency2), getAxis(axisDependency2), this.mXAxis.mAxisRange, f, f2, this.mViewPortHandler.getScaleX(), this.mViewPortHandler.getScaleY(), f3, f4, (float) valuesByTouchPoint.x, (float) valuesByTouchPoint.y, j));
        MPPointD.recycleInstance(valuesByTouchPoint);
    }

    public final void delayAutoScaleY(long j) {
        zoomToVisibleRange();
        postDelayed(new MyChart$$ExternalSyntheticLambda1(this), j);
    }

    /* access modifiers changed from: private */
    public static final void delayAutoScaleY$lambda$3(MyChart myChart) {
        Intrinsics.checkNotNullParameter(myChart, "this$0");
        myChart.autoScaleY();
    }

    public final void autoScaleY() {
        float f;
        float f2;
        ScatterData scatterData;
        List dataSets;
        ScatterData scatterData2;
        List dataSets2;
        LineData lineData;
        List dataSets3;
        LineData lineData2;
        List dataSets4;
        if (getData() != null) {
            CombinedData combinedData = (CombinedData) getData();
            float f3 = 0.0f;
            if (combinedData == null || (lineData2 = combinedData.getLineData()) == null || (dataSets4 = lineData2.getDataSets()) == null) {
                f = 600.0f;
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : dataSets4) {
                    if (next instanceof GlucoseDataSetLine) {
                        arrayList.add(next);
                    }
                }
                f = 600.0f;
                for (GlucoseDataSetLine glucoseDataSetLine : (List) arrayList) {
                    glucoseDataSetLine.calcMinMaxY(getLowestVisibleX(), getHighestVisibleX());
                    f3 = Math.max(f3, glucoseDataSetLine.getYMax());
                    f = Math.min(f, glucoseDataSetLine.getYMin());
                }
            }
            CombinedData combinedData2 = (CombinedData) getData();
            if (!(combinedData2 == null || (lineData = combinedData2.getLineData()) == null || (dataSets3 = lineData.getDataSets()) == null)) {
                Collection arrayList2 = new ArrayList();
                for (Object next2 : dataSets3) {
                    if (next2 instanceof GlucoseDataSet) {
                        arrayList2.add(next2);
                    }
                }
                for (GlucoseDataSet glucoseDataSet : (List) arrayList2) {
                    glucoseDataSet.calcMinMaxY(getLowestVisibleX(), getHighestVisibleX());
                    f3 = Math.max(f3, glucoseDataSet.getYMax());
                    f = Math.min(f, glucoseDataSet.getYMin());
                }
            }
            CombinedData combinedData3 = (CombinedData) getData();
            if (!(combinedData3 == null || (scatterData2 = combinedData3.getScatterData()) == null || (dataSets2 = scatterData2.getDataSets()) == null)) {
                Collection arrayList3 = new ArrayList();
                for (Object next3 : dataSets2) {
                    if (next3 instanceof BgDataSet) {
                        arrayList3.add(next3);
                    }
                }
                for (BgDataSet bgDataSet : (List) arrayList3) {
                    bgDataSet.calcMinMaxY(getLowestVisibleX(), getHighestVisibleX());
                    f3 = Math.max(f3, bgDataSet.getYMax());
                    f = Math.min(f, bgDataSet.getYMin());
                }
            }
            CombinedData combinedData4 = (CombinedData) getData();
            if (!(combinedData4 == null || (scatterData = combinedData4.getScatterData()) == null || (dataSets = scatterData.getDataSets()) == null)) {
                Collection arrayList4 = new ArrayList();
                for (Object next4 : dataSets) {
                    if (next4 instanceof CalDataSet) {
                        arrayList4.add(next4);
                    }
                }
                for (CalDataSet calDataSet : (List) arrayList4) {
                    calDataSet.calcMinMaxY(getLowestVisibleX(), getHighestVisibleX());
                    f3 = Math.max(f3, calDataSet.getYMax());
                    f = Math.min(f, calDataSet.getYMin());
                }
            }
            YAxis axis = getAxis(this.majorAxis);
            float axisMaximum = axis.getAxisMaximum();
            List list = this.autoYMaxRule.get(this.unitTag);
            if (list != null) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (f3 < ((Number) pair.getFirst()).floatValue()) {
                        axisMaximum = ((Number) pair.getSecond()).floatValue();
                        break;
                    }
                }
            }
            float axisMinimum = axis.getAxisMinimum();
            List list2 = this.autoYMinRule.get(this.unitTag);
            if (list2 != null) {
                Iterator it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Pair pair2 = (Pair) it2.next();
                    if (f < ((Number) pair2.getFirst()).floatValue()) {
                        axisMinimum = ((Number) pair2.getSecond()).floatValue();
                        break;
                    }
                }
            }
            float axisMaximum2 = (axis.getAxisMaximum() - axis.getAxisMinimum()) / (axisMaximum - axisMinimum);
            float f4 = (axisMinimum + axisMaximum) / 2.0f;
            LogUtil.Companion.d("autoScaleY curU=" + this.curYUpper + " u=" + axisMaximum + " scaleY=" + getScaleY() + " newScaleY=" + axisMaximum2, "GBGBGB");
            if (this.curYUpper != axisMaximum) {
                this.curYUpper = axisMaximum;
                if (axisMaximum == 20.0f) {
                    f2 = 4.0f;
                } else {
                    if (axisMaximum != 25.0f) {
                        if (axisMaximum == 30.0f) {
                            f2 = 6.0f;
                        } else if (axisMaximum == 360.0f) {
                            f2 = 72.0f;
                        } else if (axisMaximum == 450.0f) {
                            f2 = 90.0f;
                        } else if (axisMaximum == 600.0f) {
                            f2 = 120.0f;
                        }
                    }
                    f2 = 5.0f;
                }
                axis.setGranularity(f2);
                zoomAndCenterAnimated(getScaleX(), axisMaximum2 - 0.05f, (getLowestVisibleX() + getHighestVisibleX()) / 2.0f, f4, this.majorAxis, 200);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void stopFlying() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        Intrinsics.checkNotNull(chartTouchListener, "null cannot be cast to non-null type com.github.mikephil.charting.listener.BarLineChartTouchListener");
        ((BarLineChartTouchListener) chartTouchListener).stopDeceleration();
    }

    /* access modifiers changed from: private */
    public final void zoomToVisibleRange() {
        zoom(getVisibleXRange() / this.mVisibleXRange, 1.0f, getCenterOffsets().x * ((float) 2), 0.0f);
    }

    public final void removeHighLine() {
        highlightValue((Highlight) null, true);
        setHighlightPerDragEnabled(false);
    }

    /* access modifiers changed from: private */
    public final void onSelectXCallback(MotionEvent motionEvent) {
        Function1<? super Float, Unit> function1;
        float f = (float) getValuesByTouchPoint(motionEvent.getX(), motionEvent.getY(), this.majorAxis).x;
        int granularity = (int) getXAxis().getGranularity();
        if (((double) f) <= ((double) (getXAxis().mAxisMaximum - (granularity != 1 ? granularity != 2 ? 2.2f : 1.0f : 0.5f))) + 0.2d && (function1 = this.onSelectX) != null) {
            function1.invoke(Float.valueOf(f));
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J,\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u001c\u0010\u0015\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u001a\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u001e\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/microtech/aidexx/views/chart/MyChart$MyOnChartGestureListener;", "Lcom/github/mikephil/charting/listener/OnChartGestureListener;", "(Lcom/microtech/aidexx/views/chart/MyChart;)V", "chart", "Lcom/microtech/aidexx/views/chart/MyChart;", "curHighestX", "", "highlightAllowed", "", "isEndToLeft", "isEndToRight", "latestScrollDxByFling", "onChartDoubleTapped", "", "me", "Landroid/view/MotionEvent;", "onChartFling", "me1", "me2", "velocityX", "velocityY", "onChartGestureEnd", "lastPerformedGesture", "Lcom/github/mikephil/charting/listener/ChartTouchListener$ChartGesture;", "onChartGestureStart", "onChartLongPressed", "onChartScale", "scaleX", "scaleY", "onChartSingleTapped", "onChartTranslate", "dX", "dY", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MyChart.kt */
    public final class MyOnChartGestureListener implements OnChartGestureListener {
        private final MyChart chart;
        private float curHighestX;
        private boolean highlightAllowed = true;
        private boolean isEndToLeft;
        private boolean isEndToRight;
        private float latestScrollDxByFling;

        public void onChartDoubleTapped(MotionEvent motionEvent) {
        }

        public void onChartScale(MotionEvent motionEvent, float f, float f2) {
        }

        public void onChartSingleTapped(MotionEvent motionEvent) {
        }

        public MyOnChartGestureListener() {
            this.chart = MyChart.this;
        }

        public void onChartGestureStart(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
            this.curHighestX = MyChart.this.getHighestVisibleX();
            this.chart.highlightValue((Highlight) null, true);
            this.highlightAllowed = true;
            this.chart.setHighlightPerDragEnabled(false);
        }

        public void onChartGestureEnd(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture) {
            this.isEndToLeft = false;
            this.isEndToRight = false;
            if (motionEvent != null) {
                MyChart myChart = MyChart.this;
                if ((motionEvent.getAction() & 255) == 1 && chartGesture == ChartTouchListener.ChartGesture.FLING) {
                    LogUtil.Companion.d("FLING start", "MyChart");
                    myChart.setFling(true);
                    return;
                }
            }
            if (chartGesture == ChartTouchListener.ChartGesture.FLING) {
                MyChart.this.zoomToVisibleRange();
                if (MyChart.this.getEnableAutoScaleY()) {
                    MyChart.this.autoScaleY();
                }
                LogUtil.Companion.d("FLING end", "MyChart");
                MyChart.this.setFling(false);
                return;
            }
            this.highlightAllowed = false;
            this.chart.setHighlightPerDragEnabled(false);
        }

        public void onChartLongPressed(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "me");
            if (MyChart.this.getHighlightOnLongPressedEnable()) {
                if (this.highlightAllowed) {
                    MyChart.this.setSelectAllow(true);
                    Highlight highlightByTouchPoint = this.chart.getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
                    this.chart.highlightValue(highlightByTouchPoint, true);
                    if (highlightByTouchPoint != null) {
                        MyChart.this.onSelectXCallback(motionEvent);
                    }
                }
                this.chart.setHighlightPerDragEnabled(true);
            }
        }

        public void onChartFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            LogUtil.Companion.d("velocityX=" + f, "MyChart");
        }

        public void onChartTranslate(MotionEvent motionEvent, float f, float f2) {
            if (MyChart.this.isFling()) {
                if (((double) Math.abs(f - this.latestScrollDxByFling)) < 0.1d) {
                    MyChart.this.calculateOffsets();
                    MyChart.this.stopFlying();
                    MyChart.this.setFling(false);
                } else {
                    this.latestScrollDxByFling = f;
                }
            }
            this.highlightAllowed = false;
            boolean z = f < 0.0f;
            if (((double) Math.abs(MyChart.this.getHighestVisibleX() - this.curHighestX)) > 0.01d && ((!z && MyChart.this.getLowestVisibleX() > MyChart.this.mXAxis.mAxisMinimum) || (z && MyChart.this.getHighestVisibleX() < MyChart.this.mXAxis.mAxisMaximum))) {
                ScrollListener onScrollListener = MyChart.this.getOnScrollListener();
                Integer valueOf = onScrollListener != null ? Integer.valueOf(onScrollListener.onXAxisVisibleAreaChanged(z, MyChart.this.getLowestVisibleX(), MyChart.this.getHighestVisibleX(), MyChart.this.mXAxis.getAxisMinimum(), MyChart.this.mXAxis.getAxisMaximum())) : null;
                if (valueOf != null && valueOf.intValue() == -1) {
                    MyChart.this.stopFlying();
                }
                this.curHighestX = MyChart.this.getHighestVisibleX();
            } else if (z || MyChart.this.getLowestVisibleX() != MyChart.this.mXAxis.mAxisMinimum) {
                if (z && MyChart.this.getHighestVisibleX() == MyChart.this.mXAxis.mAxisMaximum && !this.isEndToRight) {
                    this.isEndToRight = true;
                    ScrollListener onScrollListener2 = MyChart.this.getOnScrollListener();
                    if (onScrollListener2 != null) {
                        onScrollListener2.onToEndRight();
                    }
                }
            } else if (!this.isEndToLeft) {
                this.isEndToLeft = true;
                ScrollListener onScrollListener3 = MyChart.this.getOnScrollListener();
                if (onScrollListener3 != null) {
                    onScrollListener3.onToEndLeft();
                }
            }
        }
    }
}
