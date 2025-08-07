package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
    private final List<Boolean> mCalculatedLabelBreakPoints;
    private final List<FSize> mCalculatedLabelSizes;
    private final List<FSize> mCalculatedLineSizes;
    private LegendDirection mDirection;
    private boolean mDrawInside;
    private LegendEntry[] mEntries;
    private LegendEntry[] mExtraEntries;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    private float mFormToTextSpace;
    private LegendHorizontalAlignment mHorizontalAlignment;
    private boolean mIsLegendCustom;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendOrientation mOrientation;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private LegendVerticalAlignment mVerticalAlignment;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.mEntries = new LegendEntry[0];
        this.mIsLegendCustom = false;
        this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
        this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
        this.mOrientation = LegendOrientation.HORIZONTAL;
        this.mDrawInside = false;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mFormLineWidth = 3.0f;
        this.mFormLineDashEffect = null;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new ArrayList(16);
        this.mCalculatedLabelBreakPoints = new ArrayList(16);
        this.mCalculatedLineSizes = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public Legend(LegendEntry[] legendEntryArr) {
        this();
        if (legendEntryArr != null) {
            this.mEntries = legendEntryArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }

    public void setEntries(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public LegendEntry[] getEntries() {
        return this.mEntries;
    }

    public float getMaximumEntryWidth(Paint paint) {
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormToTextSpace);
        float f = 0.0f;
        float f2 = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            if (legendEntry != null) {
                float convertDpToPixel2 = Utils.convertDpToPixel(Float.isNaN(legendEntry.formSize) ? this.mFormSize : legendEntry.formSize);
                if (convertDpToPixel2 > f2) {
                    f2 = convertDpToPixel2;
                }
                String str = legendEntry.label;
                if (str != null) {
                    float calcTextWidth = (float) Utils.calcTextWidth(paint, str);
                    if (calcTextWidth > f) {
                        f = calcTextWidth;
                    }
                }
            }
        }
        return f + f2 + convertDpToPixel;
    }

    public float getMaximumEntryHeight(Paint paint) {
        float f;
        float f2 = 0.0f;
        for (LegendEntry legendEntry : this.mEntries) {
            if (legendEntry != null) {
                String str = legendEntry.label;
                if (str == null) {
                } else {
                    f = (float) Utils.calcTextHeight(paint, str);
                }
            } else {
                f = 0.0f;
            }
            if (f > f2) {
                f2 = f;
            }
        }
        return f2;
    }

    public LegendEntry[] getExtraEntries() {
        return this.mExtraEntries;
    }

    public void setExtra(List<LegendEntry> list) {
        this.mExtraEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
    }

    public void setExtra(LegendEntry[] legendEntryArr) {
        if (legendEntryArr == null) {
            legendEntryArr = new LegendEntry[0];
        }
        this.mExtraEntries = legendEntryArr;
    }

    public void setExtra(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Math.min(iArr.length, strArr.length); i++) {
            LegendEntry legendEntry = new LegendEntry();
            legendEntry.formColor = iArr[i];
            legendEntry.label = strArr[i];
            if (legendEntry.formColor == 1122868 || legendEntry.formColor == 0) {
                legendEntry.form = LegendForm.NONE;
            } else if (legendEntry.formColor == 1122867) {
                legendEntry.form = LegendForm.EMPTY;
            }
            arrayList.add(legendEntry);
        }
        this.mExtraEntries = (LegendEntry[]) arrayList.toArray(new LegendEntry[arrayList.size()]);
    }

    public void setCustom(LegendEntry[] legendEntryArr) {
        this.mEntries = legendEntryArr;
        this.mIsLegendCustom = true;
    }

    public void setCustom(List<LegendEntry> list) {
        this.mEntries = (LegendEntry[]) list.toArray(new LegendEntry[list.size()]);
        this.mIsLegendCustom = true;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.mHorizontalAlignment = legendHorizontalAlignment;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public void setVerticalAlignment(LegendVerticalAlignment legendVerticalAlignment) {
        this.mVerticalAlignment = legendVerticalAlignment;
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(LegendOrientation legendOrientation) {
        this.mOrientation = legendOrientation;
    }

    public boolean isDrawInsideEnabled() {
        return this.mDrawInside;
    }

    public void setDrawInside(boolean z) {
        this.mDrawInside = z;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public void setDirection(LegendDirection legendDirection) {
        this.mDirection = legendDirection;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public void setForm(LegendForm legendForm) {
        this.mShape = legendForm;
    }

    public void setFormSize(float f) {
        this.mFormSize = f;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public void setFormLineWidth(float f) {
        this.mFormLineWidth = f;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public void setXEntrySpace(float f) {
        this.mXEntrySpace = f;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public void setYEntrySpace(float f) {
        this.mYEntrySpace = f;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public void setFormToTextSpace(float f) {
        this.mFormToTextSpace = f;
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public void setStackSpace(float f) {
        this.mStackSpace = f;
    }

    public void setWordWrapEnabled(boolean z) {
        this.mWordWrapEnabled = z;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public void setMaxSizePercent(float f) {
        this.mMaxSizePercent = f;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    public void calculateDimensions(Paint paint, ViewPortHandler viewPortHandler) {
        float f;
        float f2;
        float f3;
        int i;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Paint paint2 = paint;
        float convertDpToPixel = Utils.convertDpToPixel(this.mFormSize);
        float convertDpToPixel2 = Utils.convertDpToPixel(this.mStackSpace);
        float convertDpToPixel3 = Utils.convertDpToPixel(this.mFormToTextSpace);
        float convertDpToPixel4 = Utils.convertDpToPixel(this.mXEntrySpace);
        float convertDpToPixel5 = Utils.convertDpToPixel(this.mYEntrySpace);
        boolean z = this.mWordWrapEnabled;
        LegendEntry[] legendEntryArr = this.mEntries;
        int length = legendEntryArr.length;
        this.mTextWidthMax = getMaximumEntryWidth(paint);
        this.mTextHeightMax = getMaximumEntryHeight(paint);
        int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mOrientation.ordinal()];
        if (i2 == 1) {
            float f9 = convertDpToPixel;
            float f10 = convertDpToPixel2;
            LegendEntry[] legendEntryArr2 = legendEntryArr;
            float lineHeight = Utils.getLineHeight(paint);
            boolean z2 = false;
            float f11 = 0.0f;
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i3 = 0; i3 < length; i3++) {
                LegendEntry legendEntry = legendEntryArr2[i3];
                boolean z3 = legendEntry.form != LegendForm.NONE;
                if (Float.isNaN(legendEntry.formSize)) {
                    f = f9;
                } else {
                    f = Utils.convertDpToPixel(legendEntry.formSize);
                }
                String str = legendEntry.label;
                if (!z2) {
                    f12 = 0.0f;
                }
                if (z3) {
                    if (z2) {
                        f12 += f10;
                    }
                    f12 += f;
                }
                if (str != null) {
                    if (z3 && !z2) {
                        f12 += convertDpToPixel3;
                    } else if (z2) {
                        f3 = Math.max(f13, f12);
                        f11 += lineHeight + convertDpToPixel5;
                        z2 = false;
                        f2 = 0.0f;
                        f11 += lineHeight + convertDpToPixel5;
                        float calcTextWidth = f2 + ((float) Utils.calcTextWidth(paint2, str));
                        f13 = f3;
                        f12 = calcTextWidth;
                    }
                    float f14 = f13;
                    f2 = f12;
                    f3 = f14;
                    f11 += lineHeight + convertDpToPixel5;
                    float calcTextWidth2 = f2 + ((float) Utils.calcTextWidth(paint2, str));
                    f13 = f3;
                    f12 = calcTextWidth2;
                } else {
                    f12 += f;
                    if (i3 < length - 1) {
                        f12 += f10;
                    }
                    z2 = true;
                }
                f13 = Math.max(f13, f12);
            }
            this.mNeededWidth = f13;
            this.mNeededHeight = f11;
        } else if (i2 == 2) {
            float lineHeight2 = Utils.getLineHeight(paint);
            float lineSpacing = Utils.getLineSpacing(paint) + convertDpToPixel5;
            float contentWidth = viewPortHandler.contentWidth() * this.mMaxSizePercent;
            this.mCalculatedLabelBreakPoints.clear();
            this.mCalculatedLabelSizes.clear();
            this.mCalculatedLineSizes.clear();
            int i4 = 0;
            int i5 = -1;
            float f15 = 0.0f;
            float f16 = 0.0f;
            float f17 = 0.0f;
            while (i4 < length) {
                LegendEntry legendEntry2 = legendEntryArr[i4];
                float f18 = convertDpToPixel;
                boolean z4 = legendEntry2.form != LegendForm.NONE;
                if (Float.isNaN(legendEntry2.formSize)) {
                    f4 = f18;
                } else {
                    f4 = Utils.convertDpToPixel(legendEntry2.formSize);
                }
                String str2 = legendEntry2.label;
                float f19 = convertDpToPixel4;
                LegendEntry[] legendEntryArr3 = legendEntryArr;
                this.mCalculatedLabelBreakPoints.add(false);
                float f20 = i5 == -1 ? 0.0f : f16 + convertDpToPixel2;
                if (str2 != null) {
                    f5 = convertDpToPixel2;
                    this.mCalculatedLabelSizes.add(Utils.calcTextSize(paint2, str2));
                    f6 = f20 + (z4 ? convertDpToPixel3 + f4 : 0.0f);
                    if (this.mCalculatedLabelSizes.size() > i4 && this.mCalculatedLabelSizes.get(i4) != null) {
                        f6 += this.mCalculatedLabelSizes.get(i4).width;
                    }
                } else {
                    f5 = convertDpToPixel2;
                    float f21 = f4;
                    this.mCalculatedLabelSizes.add(FSize.getInstance(0.0f, 0.0f));
                    f6 = f20 + (z4 ? f21 : 0.0f);
                    if (i5 == -1) {
                        i5 = i4;
                    }
                }
                if (str2 != null || i4 == length - 1) {
                    float f22 = f17;
                    int i6 = (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1));
                    float f23 = i6 == 0 ? 0.0f : f19;
                    if (!z || i6 == 0 || contentWidth - f22 >= f23 + f6) {
                        float f24 = f22 + f23 + f6;
                        f8 = f15;
                        f7 = f24;
                    } else {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f22, lineHeight2));
                        f8 = Math.max(f15, f22);
                        this.mCalculatedLabelBreakPoints.set(i5 > -1 ? i5 : i4, true);
                        f7 = f6;
                    }
                    if (i4 == length - 1) {
                        this.mCalculatedLineSizes.add(FSize.getInstance(f7, lineHeight2));
                        f15 = Math.max(f8, f7);
                    } else {
                        f15 = f8;
                    }
                    f17 = f7;
                }
                if (str2 != null) {
                    i5 = -1;
                }
                i4++;
                convertDpToPixel2 = f5;
                convertDpToPixel = f18;
                legendEntryArr = legendEntryArr3;
                f16 = f6;
                convertDpToPixel4 = f19;
            }
            this.mNeededWidth = f15;
            float size = lineHeight2 * ((float) this.mCalculatedLineSizes.size());
            if (this.mCalculatedLineSizes.size() == 0) {
                i = 0;
            } else {
                i = this.mCalculatedLineSizes.size() - 1;
            }
            this.mNeededHeight = size + (lineSpacing * ((float) i));
        }
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
    }

    /* renamed from: com.github.mikephil.charting.components.Legend$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = r0
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r1 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.components.Legend.AnonymousClass1.<clinit>():void");
        }
    }
}
