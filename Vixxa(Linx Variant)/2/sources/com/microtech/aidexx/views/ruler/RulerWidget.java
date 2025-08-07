package com.microtech.aidexx.views.ruler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.WidgetRulerBinding;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.UnitManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u0011\u001a\u00020 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/microtech/aidexx/views/ruler/RulerWidget;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isFirstSetting", "", "()I", "setFirstSetting", "(I)V", "type", "Lcom/microtech/aidexx/views/ruler/RulerWidget$RulerType;", "getType", "()Lcom/microtech/aidexx/views/ruler/RulerWidget$RulerType;", "setType", "(Lcom/microtech/aidexx/views/ruler/RulerWidget$RulerType;)V", "viewBinding", "Lcom/microtech/aidexx/databinding/WidgetRulerBinding;", "getViewBinding", "()Lcom/microtech/aidexx/databinding/WidgetRulerBinding;", "setViewBinding", "(Lcom/microtech/aidexx/databinding/WidgetRulerBinding;)V", "fitRange", "", "default", "start", "end", "getCurrentValue", "init", "", "initLayout", "setCurrentValue", "value", "RulerType", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RulerWidget.kt */
public final class RulerWidget extends LinearLayout {
    private int isFirstSetting;
    private RulerType type;
    public WidgetRulerBinding viewBinding;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RulerWidget.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        static {
            /*
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit[] r0 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r2 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MMOL_PER_L     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.microtech.aidexx.utils.UnitManager$GlucoseUnit r3 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MG_PER_DL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                com.microtech.aidexx.views.ruler.RulerWidget$RulerType[] r0 = com.microtech.aidexx.views.ruler.RulerWidget.RulerType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.views.ruler.RulerWidget$RulerType r3 = com.microtech.aidexx.views.ruler.RulerWidget.RulerType.NORMAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.microtech.aidexx.views.ruler.RulerWidget$RulerType r1 = com.microtech.aidexx.views.ruler.RulerWidget.RulerType.HYPO     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                com.microtech.aidexx.views.ruler.RulerWidget$RulerType r1 = com.microtech.aidexx.views.ruler.RulerWidget.RulerType.HYPER     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.views.ruler.RulerWidget.WhenMappings.<clinit>():void");
        }
    }

    public final RulerType getType() {
        return this.type;
    }

    public final void setType(RulerType rulerType) {
        this.type = rulerType;
    }

    public final WidgetRulerBinding getViewBinding() {
        WidgetRulerBinding widgetRulerBinding = this.viewBinding;
        if (widgetRulerBinding != null) {
            return widgetRulerBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        return null;
    }

    public final void setViewBinding(WidgetRulerBinding widgetRulerBinding) {
        Intrinsics.checkNotNullParameter(widgetRulerBinding, "<set-?>");
        this.viewBinding = widgetRulerBinding;
    }

    public final int isFirstSetting() {
        return this.isFirstSetting;
    }

    public final void setFirstSetting(int i) {
        this.isFirstSetting = i;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/views/ruler/RulerWidget$RulerType;", "", "(Ljava/lang/String;I)V", "NORMAL", "HYPO", "HYPER", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RulerWidget.kt */
    public enum RulerType {
        NORMAL,
        HYPO,
        HYPER;

        public static EnumEntries<RulerType> getEntries() {
            return $ENTRIES;
        }

        static {
            RulerType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RulerWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initLayout();
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RulerWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        initLayout();
        init();
    }

    private final void init() {
        getViewBinding().rvNumber.setBarWidth(20.0f);
        getViewBinding().rvNumber.setBarColors(new int[]{getResources().getColor(R.color.red), getResources().getColor(R.color.green), getResources().getColor(R.color.yellow)});
        getViewBinding().rvNumber.setColorStartValues(new float[]{GlucoseUtilKt.toGlucoseValue(0.0f), GlucoseUtilKt.toGlucoseValue(70.200005f), GlucoseUtilKt.toGlucoseValue(180.0f)});
        getViewBinding().rvNumber.setIndicatorColorChange(new boolean[]{true, true, false});
        getViewBinding().rvNumber.setOnValueChangedListener(new RulerWidget$$ExternalSyntheticLambda0(this));
        getViewBinding().tvNumber.setText(UnitManager.INSTANCE.formatterUnitByIndex().format(Float.valueOf(5.0f)));
        getViewBinding().tvUnit.setText("");
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$1(RulerWidget rulerWidget, float f) {
        Intrinsics.checkNotNullParameter(rulerWidget, "this$0");
        RulerType rulerType = rulerWidget.type;
        if (rulerType != null) {
            rulerWidget.setCurrentValue(f, rulerType);
        }
    }

    private final void initLayout() {
        Object systemService = getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        WidgetRulerBinding bind = WidgetRulerBinding.bind(((LayoutInflater) systemService).inflate(R.layout.widget_ruler, this, true));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        setViewBinding(bind);
    }

    public final void setType(RulerType rulerType, float f) {
        float f2;
        Intrinsics.checkNotNullParameter(rulerType, TransmitterActivityKt.OPERATION_TYPE);
        this.type = rulerType;
        if (rulerType == RulerType.NORMAL) {
            getViewBinding().tvNumber.setText((CharSequence) null);
            getViewBinding().tvUnit.setText((CharSequence) null);
        }
        getViewBinding().rvNumber.setColorStartValues(new float[]{GlucoseUtilKt.toGlucoseValue(0.0f), GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getHypo()), GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getHyper())});
        int i = WhenMappings.$EnumSwitchMapping$0[UnitManager.INSTANCE.getGlucoseUnit().ordinal()];
        if (i == 1) {
            f2 = 0.1f;
        } else if (i == 2) {
            f2 = 1.0f;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        float f3 = f2;
        int i2 = WhenMappings.$EnumSwitchMapping$1[rulerType.ordinal()];
        if (i2 == 1) {
            float fitRange = fitRange(f, 2.0f, 30.0f);
            getViewBinding().rvNumber.setIndicatorColorChange((boolean[]) null);
            getViewBinding().rvNumber.setStickyIndex(-1);
            getViewBinding().rvNumber.setValue(GlucoseUtilKt.toGlucoseValue(2.0f), GlucoseUtilKt.toGlucoseValue(30.0f), fitRange, f3, 10);
            setCurrentValue(fitRange, rulerType);
        } else if (i2 == 2) {
            float fitRange2 = fitRange(f, 54.0f, 90.0f);
            getViewBinding().rvNumber.setIndicatorColorChange(new boolean[]{true, false, true});
            getViewBinding().rvNumber.setStickyIndex(1);
            getViewBinding().rvNumber.setValue(GlucoseUtilKt.toGlucoseValue(54.0f), GlucoseUtilKt.toGlucoseValue(90.0f), fitRange2, f3, 10);
            setCurrentValue(fitRange2, rulerType);
        } else if (i2 == 3) {
            float fitRange3 = fitRange(f, 126.0f, 450.0f);
            getViewBinding().rvNumber.setIndicatorColorChange(new boolean[]{true, false, true});
            getViewBinding().rvNumber.setStickyIndex(2);
            getViewBinding().rvNumber.setValue(GlucoseUtilKt.toGlucoseValue(126.0f), GlucoseUtilKt.toGlucoseValue(450.0f), fitRange3, f3, 10);
            setCurrentValue(fitRange3, rulerType);
        }
    }

    private final float fitRange(float f, float f2, float f3) {
        if (f2 <= f && f <= f3) {
            return GlucoseUtilKt.toGlucoseValue(f);
        }
        if (f < f2) {
            return GlucoseUtilKt.toGlucoseValue(f2);
        }
        return GlucoseUtilKt.toGlucoseValue(f3);
    }

    public final float getCurrentValue() {
        CharSequence text = getViewBinding().tvNumber.getText();
        if (text == null || StringsKt.isBlank(text)) {
            return 0.0f;
        }
        return getViewBinding().rvNumber.getCurrentValue();
    }

    private final void setCurrentValue(float f, RulerType rulerType) {
        if (rulerType != RulerType.NORMAL || this.isFirstSetting >= 2) {
            String displayUnit = UnitManager.INSTANCE.getDisplayUnit();
            getViewBinding().tvNumber.setText(UnitManager.INSTANCE.formatterUnitByIndex().format(Float.valueOf(f)));
            getViewBinding().tvUnit.setText(displayUnit);
        }
        this.isFirstSetting++;
        int indicatorLineColor = getViewBinding().rvNumber.getIndicatorLineColor();
        getViewBinding().tvNumber.setTextColor(indicatorLineColor);
        getViewBinding().tvArrow.setTextColor(indicatorLineColor);
        getViewBinding().tvUnit.setTextColor(indicatorLineColor);
    }
}
