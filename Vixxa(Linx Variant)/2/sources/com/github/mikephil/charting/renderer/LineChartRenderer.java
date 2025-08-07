package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LineChartRenderer extends LineRadarRenderer {
    protected Path cubicFillPath = new Path();
    protected Path cubicPath = new Path();
    protected Canvas mBitmapCanvas;
    protected Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_4444;
    protected LineDataProvider mChart;
    protected Paint mCirclePaintInner;
    private final float[] mCirclesBuffer = new float[2];
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mGenerateFilledPathBuffer = new Path();
    private final HashMap<IDataSet, DataSetImageCache> mImageCaches = new HashMap<>();
    private float[] mLineBuffer = new float[4];
    protected List<Float> mPositions;

    public void initBuffers() {
    }

    public LineChartRenderer(LineDataProvider lineDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.mChart = lineDataProvider;
        Paint paint = new Paint(1);
        this.mCirclePaintInner = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCirclePaintInner.setColor(-1);
    }

    public void drawData(Canvas canvas) {
        int chartWidth = (int) this.mViewPortHandler.getChartWidth();
        int chartHeight = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (!(bitmap != null && bitmap.getWidth() == chartWidth && bitmap.getHeight() == chartHeight)) {
            if (chartWidth > 0 && chartHeight > 0) {
                bitmap = Bitmap.createBitmap(chartWidth, chartHeight, this.mBitmapConfig);
                this.mDrawBitmap = new WeakReference<>(bitmap);
                this.mBitmapCanvas = new Canvas(bitmap);
            } else {
                return;
            }
        }
        bitmap.eraseColor(0);
        for (ILineDataSet iLineDataSet : this.mChart.getLineData().getDataSets()) {
            if (iLineDataSet.isVisible()) {
                drawDataSet(canvas, iLineDataSet);
            }
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.mRenderPaint);
    }

    /* access modifiers changed from: protected */
    public void drawDataSet(Canvas canvas, ILineDataSet iLineDataSet) {
        if (iLineDataSet.getEntryCount() >= 1) {
            this.mRenderPaint.setStrokeWidth(iLineDataSet.getLineWidth());
            this.mRenderPaint.setPathEffect(iLineDataSet.getDashPathEffect());
            int i = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[iLineDataSet.getMode().ordinal()];
            if (i == 3) {
                drawCubicBezier(iLineDataSet);
            } else if (i != 4) {
                drawLinear(canvas, iLineDataSet);
            } else {
                drawHorizontalBezier(iLineDataSet);
            }
            this.mRenderPaint.setPathEffect((PathEffect) null);
        }
    }

    /* renamed from: com.github.mikephil.charting.renderer.LineChartRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.github.mikephil.charting.data.LineDataSet$Mode[] r0 = com.github.mikephil.charting.data.LineDataSet.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode = r0
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.LINEAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.STEPPED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.CUBIC_BEZIER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.data.LineDataSet$Mode r1 = com.github.mikephil.charting.data.LineDataSet.Mode.HORIZONTAL_BEZIER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LineChartRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void drawHorizontalBezier(ILineDataSet iLineDataSet) {
        float phaseY = this.mAnimator.getPhaseY();
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        this.mXBounds.set(this.mChart, iLineDataSet);
        this.cubicPath.reset();
        if (this.mXBounds.range >= 1) {
            Entry entryForIndex = iLineDataSet.getEntryForIndex(this.mXBounds.min);
            this.cubicPath.moveTo(entryForIndex.getX(), entryForIndex.getY() * phaseY);
            int i = this.mXBounds.min + 1;
            while (i <= this.mXBounds.range + this.mXBounds.min) {
                Entry entryForIndex2 = iLineDataSet.getEntryForIndex(i);
                float x = entryForIndex.getX() + ((entryForIndex2.getX() - entryForIndex.getX()) / 2.0f);
                this.cubicPath.cubicTo(x, entryForIndex.getY() * phaseY, x, entryForIndex2.getY() * phaseY, entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                i++;
                entryForIndex = entryForIndex2;
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet, this.cubicFillPath, transformer, this.mXBounds, iLineDataSet.isDrawClipPathEnabled());
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        transformer.pathValueToPixel(this.cubicPath);
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void drawCubicBezier(ILineDataSet iLineDataSet) {
        Entry entry;
        Entry entry2;
        float f;
        float f2;
        float f3;
        ILineDataSet iLineDataSet2 = iLineDataSet;
        float phaseY = this.mAnimator.getPhaseY();
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        this.mXBounds.set(this.mChart, iLineDataSet2);
        float cubicIntensity = iLineDataSet.getCubicIntensity();
        this.cubicPath.reset();
        if (this.mXBounds.range >= 1) {
            int i = this.mXBounds.min;
            int i2 = this.mXBounds.min;
            int i3 = this.mXBounds.range;
            Entry entryForIndex = iLineDataSet2.getEntryForIndex(Math.max(i - 1, 0));
            Entry entryForIndex2 = iLineDataSet2.getEntryForIndex(Math.max(i, 0));
            if (entryForIndex2 != null) {
                this.cubicPath.moveTo(entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                int i4 = this.mXBounds.range + this.mXBounds.min;
                int i5 = this.mXBounds.min + 1;
                Entry entry3 = null;
                Entry entry4 = null;
                Entry entry5 = entryForIndex;
                int i6 = -1;
                Entry entry6 = entryForIndex2;
                while (i5 <= i4) {
                    if (entry3 != null) {
                        entryForIndex2 = entry3;
                    }
                    if (i6 != i5) {
                        entry6 = iLineDataSet2.getEntryForIndex(i5);
                    } else if (entry4 != null) {
                        entry6 = entry4;
                    }
                    int i7 = i5 + 1;
                    if (i7 < iLineDataSet.getEntryCount()) {
                        i5 = i7;
                    }
                    Entry entryForIndex3 = iLineDataSet2.getEntryForIndex(i5);
                    if (iLineDataSet2.checkBreak(entry5, entryForIndex2)) {
                        entry5 = entryForIndex2;
                    }
                    boolean checkBreak = iLineDataSet2.checkBreak(entryForIndex2, entry6);
                    if (checkBreak) {
                        entry2 = entry6;
                        entry = entryForIndex3;
                        entry6 = entryForIndex2;
                        entryForIndex3 = entry6;
                    } else {
                        entry2 = null;
                        entry = null;
                    }
                    float x = (entry6.getX() - entry5.getX()) * cubicIntensity;
                    float y = (entry6.getY() - entry5.getY()) * cubicIntensity;
                    if (iLineDataSet2.checkBreak(entry6, entryForIndex3)) {
                        f3 = (entry6.getX() - entryForIndex2.getX()) * cubicIntensity;
                        f2 = entry6.getY();
                        f = entryForIndex2.getY();
                    } else {
                        f3 = (entryForIndex3.getX() - entryForIndex2.getX()) * cubicIntensity;
                        f2 = entryForIndex3.getY();
                        f = entryForIndex2.getY();
                    }
                    this.cubicPath.cubicTo(entryForIndex2.getX() + x, (entryForIndex2.getY() + y) * phaseY, entry6.getX() - f3, (entry6.getY() - ((f2 - f) * cubicIntensity)) * phaseY, entry6.getX(), entry6.getY() * phaseY);
                    if (checkBreak) {
                        this.cubicPath.moveTo(entry2.getX(), entry2.getY() * phaseY);
                    }
                    entry5 = entryForIndex2;
                    entryForIndex2 = entry6;
                    entry6 = entryForIndex3;
                    entry3 = entry2;
                    entry4 = entry;
                    int i8 = i5;
                    i5 = i7;
                    i6 = i8;
                }
            } else {
                return;
            }
        }
        if (iLineDataSet.isDrawFilledEnabled()) {
            this.cubicFillPath.reset();
            this.cubicFillPath.addPath(this.cubicPath);
            drawCubicFill(this.mBitmapCanvas, iLineDataSet, this.cubicFillPath, transformer, this.mXBounds, iLineDataSet.isDrawClipPathEnabled());
        }
        this.mRenderPaint.setColor(iLineDataSet.getColor());
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        this.mRenderPaint.setStrokeCap(Paint.Cap.ROUND);
        transformer.pathValueToPixel(this.cubicPath);
        this.mRenderPaint.setShader(generateLinearGradient(iLineDataSet2, iLineDataSet.getColors(), iLineDataSet.getGradientPositions()));
        this.mBitmapCanvas.drawPath(this.cubicPath, this.mRenderPaint);
        this.mRenderPaint.setShader((Shader) null);
        this.mRenderPaint.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void drawCubicFill(Canvas canvas, ILineDataSet iLineDataSet, Path path, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds, boolean z) {
        ILineDataSet fillLine = iLineDataSet.getFillFormatter().getFillLine(iLineDataSet, this.mChart);
        if (fillLine != null) {
            BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = new BarLineScatterCandleBubbleRenderer.XBounds();
            xBounds2.set(this.mChart, fillLine);
            addFillMinPath(path, fillLine, xBounds2);
        } else {
            float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
            path.lineTo(iLineDataSet.getEntryForIndex(xBounds.min + xBounds.range).getX(), fillLinePosition);
            path.lineTo(iLineDataSet.getEntryForIndex(xBounds.min).getX(), fillLinePosition);
        }
        path.close();
        transformer.pathValueToPixel(path);
        Drawable fillDrawable = iLineDataSet.getFillDrawable();
        if (fillDrawable != null) {
            drawFilledPath(canvas, path, fillDrawable, z);
            return;
        }
        this.mRenderPaint.setShader(generateLinearGradient(iLineDataSet, iLineDataSet.getFillColors(), iLineDataSet.getFillGradientPositions()));
        drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha(), z);
        this.mRenderPaint.setShader((Shader) null);
    }

    /* access modifiers changed from: protected */
    public void drawLinear(Canvas canvas, ILineDataSet iLineDataSet) {
        Canvas canvas2;
        Canvas canvas3;
        ILineDataSet iLineDataSet2 = iLineDataSet;
        int entryCount = iLineDataSet.getEntryCount();
        char c = 1;
        boolean z = iLineDataSet.getMode() == LineDataSet.Mode.STEPPED;
        int i = z ? 4 : 2;
        Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
        float phaseY = this.mAnimator.getPhaseY();
        this.mRenderPaint.setStyle(Paint.Style.STROKE);
        Canvas canvas4 = iLineDataSet.isDashedLineEnabled() ? this.mBitmapCanvas : canvas;
        this.mXBounds.set(this.mChart, iLineDataSet2);
        if (!iLineDataSet.isDrawFilledEnabled() || entryCount <= 0) {
            canvas2 = canvas4;
        } else {
            canvas2 = canvas4;
            drawLinearFill(canvas, iLineDataSet, transformer, this.mXBounds, iLineDataSet.isDrawClipPathEnabled());
        }
        if (iLineDataSet.getColors().size() > 1) {
            int i2 = i * 2;
            if (this.mLineBuffer.length <= i2) {
                this.mLineBuffer = new float[(i * 4)];
            }
            int i3 = this.mXBounds.min + this.mXBounds.range;
            int i4 = this.mXBounds.min;
            while (i4 < i3) {
                Entry entryForIndex = iLineDataSet2.getEntryForIndex(i4);
                if (entryForIndex != null) {
                    this.mLineBuffer[0] = entryForIndex.getX();
                    this.mLineBuffer[c] = entryForIndex.getY() * phaseY;
                    if (i4 < this.mXBounds.max) {
                        Entry entryForIndex2 = iLineDataSet2.getEntryForIndex(i4 + 1);
                        if (entryForIndex2 == null) {
                            break;
                        } else if (z) {
                            this.mLineBuffer[2] = entryForIndex2.getX();
                            float[] fArr = this.mLineBuffer;
                            float f = fArr[c];
                            fArr[3] = f;
                            fArr[4] = fArr[2];
                            fArr[5] = f;
                            fArr[6] = entryForIndex2.getX();
                            this.mLineBuffer[7] = entryForIndex2.getY() * phaseY;
                        } else {
                            this.mLineBuffer[2] = entryForIndex2.getX();
                            this.mLineBuffer[3] = entryForIndex2.getY() * phaseY;
                        }
                    } else {
                        float[] fArr2 = this.mLineBuffer;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[c];
                    }
                    float[] fArr3 = this.mLineBuffer;
                    float f2 = fArr3[0];
                    float f3 = fArr3[c];
                    float f4 = fArr3[i2 - 2];
                    float f5 = fArr3[i2 - 1];
                    if (!(f2 == f4 && f3 == f5)) {
                        transformer.pointValuesToPixel(fArr3);
                        if (!this.mViewPortHandler.isInBoundsRight(f2)) {
                            break;
                        } else if (this.mViewPortHandler.isInBoundsLeft(f4) && this.mViewPortHandler.isInBoundsTop(Math.max(f3, f5)) && this.mViewPortHandler.isInBoundsBottom(Math.min(f3, f5))) {
                            this.mRenderPaint.setColor(iLineDataSet2.getColor(i4));
                            this.mRenderPaint.setShader(generateLinearGradient(iLineDataSet2, iLineDataSet.getColors(), iLineDataSet.getGradientPositions()));
                            canvas3 = canvas2;
                            canvas3.drawLines(this.mLineBuffer, 0, i2, this.mRenderPaint);
                            this.mRenderPaint.setShader((Shader) null);
                            i4++;
                            canvas2 = canvas3;
                            c = 1;
                        }
                    }
                }
                canvas3 = canvas2;
                i4++;
                canvas2 = canvas3;
                c = 1;
            }
        } else {
            Canvas canvas5 = canvas2;
            int i5 = entryCount * i;
            if (this.mLineBuffer.length < Math.max(i5, i) * 2) {
                this.mLineBuffer = new float[(Math.max(i5, i) * 4)];
            }
            if (iLineDataSet2.getEntryForIndex(this.mXBounds.min) != null) {
                int i6 = this.mXBounds.min;
                int i7 = 0;
                while (i6 <= this.mXBounds.range + this.mXBounds.min) {
                    Entry entryForIndex3 = iLineDataSet2.getEntryForIndex(i6 == 0 ? 0 : i6 - 1);
                    Entry entryForIndex4 = iLineDataSet2.getEntryForIndex(i6);
                    if (!(entryForIndex3 == null || entryForIndex4 == null)) {
                        this.mLineBuffer[i7] = entryForIndex3.getX();
                        int i8 = i7 + 2;
                        this.mLineBuffer[i7 + 1] = entryForIndex3.getY() * phaseY;
                        if (z) {
                            this.mLineBuffer[i8] = entryForIndex4.getX();
                            this.mLineBuffer[i7 + 3] = entryForIndex3.getY() * phaseY;
                            this.mLineBuffer[i7 + 4] = entryForIndex4.getX();
                            i8 = i7 + 6;
                            this.mLineBuffer[i7 + 5] = entryForIndex3.getY() * phaseY;
                        }
                        this.mLineBuffer[i8] = entryForIndex4.getX();
                        this.mLineBuffer[i8 + 1] = entryForIndex4.getY() * phaseY;
                        i7 = i8 + 2;
                    }
                    i6++;
                }
                if (i7 > 0) {
                    transformer.pointValuesToPixel(this.mLineBuffer);
                    this.mRenderPaint.setColor(iLineDataSet.getColor());
                    canvas5.drawLines(this.mLineBuffer, 0, Math.max((this.mXBounds.range + 1) * i, i) * 2, this.mRenderPaint);
                }
            }
        }
        this.mRenderPaint.setPathEffect((PathEffect) null);
    }

    /* access modifiers changed from: protected */
    public void drawLinearFill(Canvas canvas, ILineDataSet iLineDataSet, Transformer transformer, BarLineScatterCandleBubbleRenderer.XBounds xBounds, boolean z) {
        Path path = this.mGenerateFilledPathBuffer;
        generateFilledPath(iLineDataSet, xBounds.min, xBounds.range + xBounds.min, path);
        transformer.pathValueToPixel(path);
        Drawable fillDrawable = iLineDataSet.getFillDrawable();
        if (fillDrawable != null) {
            drawFilledPath(canvas, path, fillDrawable, z);
            return;
        }
        this.mRenderPaint.setShader(generateLinearGradient(iLineDataSet, iLineDataSet.getFillColors(), iLineDataSet.getFillGradientPositions()));
        drawFilledPath(canvas, path, iLineDataSet.getFillColor(), iLineDataSet.getFillAlpha(), z);
        this.mRenderPaint.setShader((Shader) null);
    }

    private void generateFilledPath(ILineDataSet iLineDataSet, int i, int i2, Path path) {
        float phaseY = this.mAnimator.getPhaseY();
        boolean z = iLineDataSet.getMode() == LineDataSet.Mode.STEPPED;
        path.reset();
        Entry entryForIndex = iLineDataSet.getEntryForIndex(i);
        if (entryForIndex != null) {
            path.moveTo(entryForIndex.getX(), entryForIndex.getY() * phaseY);
            Entry entry = null;
            Entry entry2 = entryForIndex;
            for (int i3 = i + 1; i3 <= i2; i3++) {
                entry = iLineDataSet.getEntryForIndex(i3);
                if (entry != null) {
                    if (z) {
                        path.lineTo(entry.getX(), entry2.getY() * phaseY);
                    }
                    path.lineTo(entry.getX(), entry.getY() * phaseY);
                    entry2 = entry;
                }
            }
            ILineDataSet fillLine = iLineDataSet.getFillFormatter().getFillLine(iLineDataSet, this.mChart);
            if (entry != null) {
                if (fillLine != null) {
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = new BarLineScatterCandleBubbleRenderer.XBounds();
                    xBounds.set(this.mChart, fillLine);
                    Entry entryForIndex2 = fillLine.getEntryForIndex(xBounds.range + xBounds.min);
                    if (entryForIndex2 != null) {
                        path.lineTo(entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                        addFillMinPath(path, fillLine, xBounds);
                    } else {
                        return;
                    }
                } else {
                    float fillLinePosition = iLineDataSet.getFillFormatter().getFillLinePosition(iLineDataSet, this.mChart);
                    path.lineTo(entry.getX(), fillLinePosition);
                    path.lineTo(entryForIndex.getX(), fillLinePosition);
                }
            }
            path.close();
        }
    }

    private void addFillMinPath(Path path, ILineDataSet iLineDataSet, BarLineScatterCandleBubbleRenderer.XBounds xBounds) {
        Entry entry;
        int i;
        Path path2 = path;
        ILineDataSet iLineDataSet2 = iLineDataSet;
        BarLineScatterCandleBubbleRenderer.XBounds xBounds2 = xBounds;
        float phaseY = this.mAnimator.getPhaseY();
        int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$data$LineDataSet$Mode[iLineDataSet.getMode().ordinal()];
        int i3 = 0;
        if (i2 == 1 || i2 == 2) {
            int i4 = xBounds2.min;
            int i5 = xBounds2.range + xBounds2.min;
            if (iLineDataSet.getMode() == LineDataSet.Mode.STEPPED) {
                i3 = 1;
            }
            Entry entryForIndex = iLineDataSet2.getEntryForIndex(i5);
            if (entryForIndex != null) {
                path2.lineTo(entryForIndex.getX(), entryForIndex.getY() * phaseY);
                for (int i6 = i5 - 1; i6 >= i4; i6--) {
                    Entry entryForIndex2 = iLineDataSet2.getEntryForIndex(i6);
                    if (entryForIndex2 != null) {
                        if (i3 != 0) {
                            path2.lineTo(entryForIndex.getX(), entryForIndex2.getY() * phaseY);
                        }
                        path2.lineTo(entryForIndex2.getX(), entryForIndex2.getY() * phaseY);
                        entryForIndex = entryForIndex2;
                    }
                }
            }
        } else if (i2 == 3) {
            float cubicIntensity = iLineDataSet.getCubicIntensity();
            if (xBounds2.range >= 1) {
                int i7 = xBounds2.min;
                int i8 = xBounds2.min + xBounds2.range;
                int entryCount = iLineDataSet.getEntryCount() - 1;
                Entry entryForIndex3 = iLineDataSet2.getEntryForIndex(Math.min(i8 + 2, entryCount));
                Entry entryForIndex4 = iLineDataSet2.getEntryForIndex(Math.min(i8 + 1, entryCount));
                if (entryForIndex4 != null && entryForIndex3 != null) {
                    path2.lineTo(entryForIndex4.getX(), entryForIndex4.getY() * phaseY);
                    Entry entry2 = entryForIndex4;
                    int i9 = i8;
                    while (i9 >= i7) {
                        if (i3 == i9) {
                            entry = entryForIndex4;
                        } else {
                            entry = iLineDataSet2.getEntryForIndex(i9);
                        }
                        if (entry != null) {
                            int i10 = i9 - 1;
                            int i11 = i10 >= 0 ? i10 : i9;
                            Entry entryForIndex5 = iLineDataSet2.getEntryForIndex(i11);
                            if (entryForIndex5 == null) {
                                i = i11;
                            } else {
                                i = i11;
                                path.cubicTo(entry2.getX() + ((entry.getX() - entryForIndex3.getX()) * cubicIntensity), (entry2.getY() + ((entry.getY() - entryForIndex3.getY()) * cubicIntensity)) * phaseY, entry.getX() - ((entryForIndex5.getX() - entry2.getX()) * cubicIntensity), (entry.getY() - ((entryForIndex5.getY() - entry2.getY()) * cubicIntensity)) * phaseY, entry.getX(), entry.getY() * phaseY);
                            }
                            entryForIndex4 = entryForIndex5;
                            i3 = i;
                        }
                        i9--;
                        entryForIndex3 = entry2;
                        entry2 = entry;
                    }
                }
            }
        }
    }

    private boolean needDrawValues() {
        List dataSets = this.mChart.getLineData().getDataSets();
        for (int i = 0; i < dataSets.size(); i++) {
            if (shouldDrawValues((IDataSet) dataSets.get(i)) && ((ILineDataSet) dataSets.get(i)).getEntryCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public void drawValues(Canvas canvas) {
        int i;
        ILineDataSet iLineDataSet;
        int i2;
        Entry entry;
        if (needDrawValues() && isDrawingValuesAllowed(this.mChart)) {
            List dataSets = this.mChart.getLineData().getDataSets();
            this.mPositions = new ArrayList();
            for (int i3 = 0; i3 < dataSets.size(); i3++) {
                ILineDataSet iLineDataSet2 = (ILineDataSet) dataSets.get(i3);
                if (shouldDrawValues(iLineDataSet2)) {
                    if (iLineDataSet2.getEntryCount() >= 1) {
                        applyValueTextStyle(iLineDataSet2);
                        Transformer transformer = this.mChart.getTransformer(iLineDataSet2.getAxisDependency());
                        int circleRadius = (int) (iLineDataSet2.getCircleRadius() * 1.75f);
                        if (!iLineDataSet2.isDrawCirclesEnabled()) {
                            circleRadius /= 2;
                        }
                        int i4 = circleRadius;
                        this.mXBounds.set(this.mChart, iLineDataSet2);
                        float[] generateTransformedValuesLine = transformer.generateTransformedValuesLine(iLineDataSet2, this.mAnimator.getPhaseX(), this.mAnimator.getPhaseY(), this.mXBounds.min, this.mXBounds.max);
                        ValueFormatter valueFormatter = iLineDataSet2.getValueFormatter();
                        MPPointF instance = MPPointF.getInstance(iLineDataSet2.getIconsOffset());
                        instance.x = Utils.convertDpToPixel(instance.x);
                        instance.y = Utils.convertDpToPixel(instance.y);
                        int i5 = 0;
                        for (int i6 = 1; i5 < generateTransformedValuesLine.length - i6; i6 = i) {
                            float f = generateTransformedValuesLine[i5];
                            float f2 = generateTransformedValuesLine[i5 + 1];
                            this.mPositions.add(Float.valueOf(f));
                            this.mPositions.add(Float.valueOf(f2));
                            if (!this.mViewPortHandler.isInBoundsRight(f)) {
                                break;
                            }
                            if (this.mViewPortHandler.isInBoundsLeft(f) && this.mViewPortHandler.isInBoundsY(f2)) {
                                int i7 = i5 / 2;
                                Entry entryForIndex = iLineDataSet2.getEntryForIndex(this.mXBounds.min + i7);
                                if (entryForIndex != null) {
                                    if (iLineDataSet2.isDrawValuesEnabled()) {
                                        entry = entryForIndex;
                                        String pointLabel = valueFormatter.getPointLabel(entryForIndex);
                                        i2 = i4;
                                        i = i6;
                                        iLineDataSet = iLineDataSet2;
                                        drawValue(canvas, pointLabel, f, f2 - ((float) i4), iLineDataSet2.getValueTextColor(i7));
                                    } else {
                                        entry = entryForIndex;
                                        i2 = i4;
                                        i = i6;
                                        iLineDataSet = iLineDataSet2;
                                    }
                                    if (entry.getIcon() != null && iLineDataSet.isDrawIconsEnabled()) {
                                        Drawable icon = entry.getIcon();
                                        Utils.drawImage(canvas, icon, (int) (f + instance.x), (int) (f2 + instance.y), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                                    }
                                    i5 += 2;
                                    i4 = i2;
                                    iLineDataSet2 = iLineDataSet;
                                }
                            }
                            i2 = i4;
                            i = i6;
                            iLineDataSet = iLineDataSet2;
                            i5 += 2;
                            i4 = i2;
                            iLineDataSet2 = iLineDataSet;
                        }
                        MPPointF.recycleInstance(instance);
                    }
                }
            }
        }
    }

    public void drawValue(Canvas canvas, String str, float f, float f2, int i) {
        this.mValuePaint.setColor(i);
        canvas.drawText(str, f, f2, this.mValuePaint);
    }

    public void drawExtras(Canvas canvas) {
        drawCircles(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawCircles(Canvas canvas) {
        DataSetImageCache dataSetImageCache;
        Bitmap bitmap;
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        float phaseY = this.mAnimator.getPhaseY();
        float[] fArr = this.mCirclesBuffer;
        boolean z = false;
        float f = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List dataSets = this.mChart.getLineData().getDataSets();
        int i = 0;
        while (i < dataSets.size()) {
            ILineDataSet iLineDataSet = (ILineDataSet) dataSets.get(i);
            if (iLineDataSet.isVisible() && iLineDataSet.isDrawCirclesEnabled() && iLineDataSet.getEntryCount() != 0) {
                this.mCirclePaintInner.setColor(iLineDataSet.getCircleHoleColor());
                Transformer transformer = this.mChart.getTransformer(iLineDataSet.getAxisDependency());
                this.mXBounds.set(this.mChart, iLineDataSet);
                float circleRadius = iLineDataSet.getCircleRadius();
                float circleHoleRadius = iLineDataSet.getCircleHoleRadius();
                boolean z2 = (!iLineDataSet.isDrawCircleHoleEnabled() || circleHoleRadius >= circleRadius || circleHoleRadius <= f) ? z : true;
                boolean z3 = (!z2 || iLineDataSet.getCircleHoleColor() != 1122867) ? z : true;
                if (this.mImageCaches.containsKey(iLineDataSet)) {
                    dataSetImageCache = this.mImageCaches.get(iLineDataSet);
                } else {
                    dataSetImageCache = new DataSetImageCache(this, (AnonymousClass1) null);
                    this.mImageCaches.put(iLineDataSet, dataSetImageCache);
                }
                if (dataSetImageCache.init(iLineDataSet)) {
                    dataSetImageCache.fill(iLineDataSet, z2, z3);
                }
                int i2 = this.mXBounds.range + this.mXBounds.min;
                int i3 = this.mXBounds.min;
                char c = z;
                while (i3 <= i2) {
                    Entry entryForIndex = iLineDataSet.getEntryForIndex(i3);
                    if (entryForIndex == null) {
                        break;
                    }
                    this.mCirclesBuffer[c] = entryForIndex.getX();
                    this.mCirclesBuffer[1] = entryForIndex.getY() * phaseY;
                    transformer.pointValuesToPixel(this.mCirclesBuffer);
                    if (!this.mViewPortHandler.isInBoundsRight(this.mCirclesBuffer[c])) {
                        break;
                    }
                    if (!this.mViewPortHandler.isInBoundsLeft(this.mCirclesBuffer[c]) || !this.mViewPortHandler.isInBoundsY(this.mCirclesBuffer[1]) || (bitmap = dataSetImageCache.getBitmap(iLineDataSet.getCircleColorIndex(entryForIndex))) == null) {
                        Canvas canvas2 = canvas;
                    } else {
                        float[] fArr2 = this.mCirclesBuffer;
                        canvas.drawBitmap(bitmap, fArr2[c] - circleRadius, fArr2[1] - circleRadius, (Paint) null);
                    }
                    i3++;
                    c = 0;
                }
            }
            Canvas canvas3 = canvas;
            i++;
            z = false;
            f = 0.0f;
        }
    }

    public void drawHighlighted(Canvas canvas, Highlight[] highlightArr) {
        LineData lineData = this.mChart.getLineData();
        for (Highlight highlight : highlightArr) {
            ILineDataSet iLineDataSet = (ILineDataSet) lineData.getDataSetByIndex(highlight.getDataSetIndex());
            if (iLineDataSet != null && iLineDataSet.isHighlightEnabled()) {
                Entry entryForXValue = iLineDataSet.getEntryForXValue(highlight.getX(), highlight.getY());
                if (isInBoundsX(entryForXValue, iLineDataSet)) {
                    MPPointD pixelForValues = this.mChart.getTransformer(iLineDataSet.getAxisDependency()).getPixelForValues(entryForXValue.getX(), entryForXValue.getY() * this.mAnimator.getPhaseY());
                    highlight.setDraw((float) pixelForValues.x, (float) pixelForValues.y);
                    drawHighlightLines(canvas, (float) pixelForValues.x, (float) pixelForValues.y, iLineDataSet);
                    this.mRenderPaint.setColor(iLineDataSet.getCircleColor(iLineDataSet.getCircleColorIndex(entryForXValue)));
                    this.mRenderPaint.setStyle(Paint.Style.FILL);
                    canvas.drawCircle((float) pixelForValues.x, (float) pixelForValues.y, iLineDataSet.getCircleRadius() * 1.75f, this.mRenderPaint);
                }
            }
        }
    }

    public List<Float> getPositions() {
        return this.mPositions;
    }

    private LinearGradient generateLinearGradient(ILineDataSet iLineDataSet, List<Integer> list, List<Float> list2) {
        if (list == null || list2 == null) {
            return null;
        }
        int[] iArr = new int[list.size()];
        int i = 0;
        int i2 = 0;
        for (Integer intValue : list) {
            iArr[i2] = intValue.intValue();
            i2++;
        }
        float[] fArr = new float[list2.size()];
        double d = this.mChart.getTransformer(iLineDataSet.getAxisDependency()).getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentTop()).y;
        double d2 = this.mChart.getTransformer(iLineDataSet.getAxisDependency()).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom()).y;
        for (Float floatValue : list2) {
            fArr[i] = (float) ((d - ((double) floatValue.floatValue())) / (d - d2));
            i++;
        }
        return new LinearGradient(0.0f, this.mChart.getContentRect().top, 0.0f, this.mChart.getContentRect().bottom, iArr, fArr, Shader.TileMode.CLAMP);
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        releaseBitmap();
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public void releaseBitmap() {
        Canvas canvas = this.mBitmapCanvas;
        if (canvas != null) {
            canvas.setBitmap((Bitmap) null);
            this.mBitmapCanvas = null;
        }
        WeakReference<Bitmap> weakReference = this.mDrawBitmap;
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.mDrawBitmap.clear();
            this.mDrawBitmap = null;
        }
    }

    private class DataSetImageCache {
        private Bitmap[] circleBitmaps;
        private final Path mCirclePathBuffer;

        private DataSetImageCache() {
            this.mCirclePathBuffer = new Path();
        }

        /* synthetic */ DataSetImageCache(LineChartRenderer lineChartRenderer, AnonymousClass1 r2) {
            this();
        }

        /* access modifiers changed from: protected */
        public boolean init(ILineDataSet iLineDataSet) {
            int circleColorCount = iLineDataSet.getCircleColorCount();
            Bitmap[] bitmapArr = this.circleBitmaps;
            if (bitmapArr == null) {
                this.circleBitmaps = new Bitmap[circleColorCount];
                return true;
            } else if (bitmapArr.length == circleColorCount) {
                return false;
            } else {
                this.circleBitmaps = new Bitmap[circleColorCount];
                return true;
            }
        }

        /* access modifiers changed from: protected */
        public void fill(ILineDataSet iLineDataSet, boolean z, boolean z2) {
            int circleColorCount = iLineDataSet.getCircleColorCount();
            float circleRadius = iLineDataSet.getCircleRadius();
            float circleHoleRadius = iLineDataSet.getCircleHoleRadius();
            for (int i = 0; i < circleColorCount; i++) {
                int i2 = (int) (((double) circleRadius) * 2.1d);
                Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                this.circleBitmaps[i] = createBitmap;
                LineChartRenderer.this.mRenderPaint.setColor(iLineDataSet.getCircleColor(i));
                if (z2) {
                    this.mCirclePathBuffer.reset();
                    this.mCirclePathBuffer.addCircle(circleRadius, circleRadius, circleRadius, Path.Direction.CW);
                    this.mCirclePathBuffer.addCircle(circleRadius, circleRadius, circleHoleRadius, Path.Direction.CCW);
                    canvas.drawPath(this.mCirclePathBuffer, LineChartRenderer.this.mRenderPaint);
                } else {
                    int i3 = (circleRadius > 0.0f ? 1 : (circleRadius == 0.0f ? 0 : -1));
                    if (i3 > 0) {
                        try {
                            if (LineChartRenderer.this.mRenderPaint != null) {
                                canvas.drawCircle(circleRadius, circleRadius, circleRadius, LineChartRenderer.this.mRenderPaint);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (z && i3 > 0 && circleHoleRadius > 0.0f && LineChartRenderer.this.mCirclePaintInner != null) {
                        try {
                            canvas.drawCircle(circleRadius, circleRadius, circleHoleRadius, LineChartRenderer.this.mCirclePaintInner);
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public Bitmap getBitmap(int i) {
            Bitmap[] bitmapArr = this.circleBitmaps;
            return bitmapArr[i % bitmapArr.length];
        }
    }
}
