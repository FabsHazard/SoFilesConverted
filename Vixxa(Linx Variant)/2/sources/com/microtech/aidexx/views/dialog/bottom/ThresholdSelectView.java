package com.microtech.aidexx.views.dialog.bottom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.views.ruler.RulerWidget;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rR5\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/views/dialog/bottom/ThresholdSelectView;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomPopupView;", "context", "Landroid/content/Context;", "type", "Lcom/microtech/aidexx/views/ruler/RulerWidget$RulerType;", "onValue", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "value", "", "(Landroid/content/Context;Lcom/microtech/aidexx/views/ruler/RulerWidget$RulerType;Lkotlin/jvm/functions/Function1;)V", "getOnValue", "()Lkotlin/jvm/functions/Function1;", "setOnValue", "(Lkotlin/jvm/functions/Function1;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ThresholdSelectView.kt */
public final class ThresholdSelectView extends BaseBottomPopupView {
    private Function1<? super Float, Unit> onValue;

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$2(View view, MotionEvent motionEvent) {
        return true;
    }

    public final Function1<Float, Unit> getOnValue() {
        return this.onValue;
    }

    public final void setOnValue(Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onValue = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThresholdSelectView(Context context, RulerWidget.RulerType rulerType, Function1<? super Float, Unit> function1) {
        super(context);
        float f;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rulerType, TransmitterActivityKt.OPERATION_TYPE);
        Intrinsics.checkNotNullParameter(function1, "onValue");
        this.onValue = function1;
        LayoutInflater.from(context).inflate(R.layout.layout_ruler_dialog, getContentContainer());
        View findViewById = findViewById(R.id.rw_number);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.microtech.aidexx.views.ruler.RulerWidget");
        RulerWidget rulerWidget = (RulerWidget) findViewById;
        if (rulerType == RulerWidget.RulerType.HYPO) {
            f = ThresholdManager.INSTANCE.getHypo();
        } else {
            f = ThresholdManager.INSTANCE.getHyper();
        }
        rulerWidget.setType(rulerType, f);
        View findViewById2 = findViewById(R.id.bt_ok);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new ThresholdSelectView$$ExternalSyntheticLambda0(rulerWidget, this));
        }
        View findViewById3 = findViewById(R.id.bt_cancel);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new ThresholdSelectView$$ExternalSyntheticLambda1(this));
        }
        getContentContainer().setOnTouchListener(new ThresholdSelectView$$ExternalSyntheticLambda2());
        setKeyBackCancelable(true);
        setOutSideCancelable(true);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(RulerWidget rulerWidget, ThresholdSelectView thresholdSelectView, View view) {
        Intrinsics.checkNotNullParameter(rulerWidget, "$rulerWidget");
        Intrinsics.checkNotNullParameter(thresholdSelectView, "this$0");
        thresholdSelectView.onValue.invoke(Float.valueOf(GlucoseUtilKt.fromGlucoseValue(rulerWidget.getCurrentValue())));
        thresholdSelectView.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(ThresholdSelectView thresholdSelectView, View view) {
        Intrinsics.checkNotNullParameter(thresholdSelectView, "this$0");
        thresholdSelectView.dismiss();
    }
}
