package com.microtech.aidexx.views.selector.time;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JK\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000e0\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/views/selector/time/TimePicker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "timePicker", "Lcom/microtech/aidexx/views/selector/time/TimePickerView;", "getTimePicker", "()Lcom/microtech/aidexx/views/selector/time/TimePickerView;", "setTimePicker", "(Lcom/microtech/aidexx/views/selector/time/TimePickerView;)V", "pick", "", "type", "", "title", "", "startDate", "Ljava/util/Calendar;", "callBack", "Lkotlin/Function1;", "Ljava/util/Date;", "Lkotlin/ParameterName;", "name", "date", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimePicker.kt */
public final class TimePicker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final boolean[] defType = {true, true, true, true, true, false};
    /* access modifiers changed from: private */
    public static final boolean[] yearMonthType = {true, true, false, false, false, false};
    private final Context context;
    public TimePickerView timePicker;

    public TimePicker(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final TimePickerView getTimePicker() {
        TimePickerView timePickerView = this.timePicker;
        if (timePickerView != null) {
            return timePickerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("timePicker");
        return null;
    }

    public final void setTimePicker(TimePickerView timePickerView) {
        Intrinsics.checkNotNullParameter(timePickerView, "<set-?>");
        this.timePicker = timePickerView;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/views/selector/time/TimePicker$Companion;", "", "()V", "defType", "", "yearMonthType", "getYearMonthType", "()[Z", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TimePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean[] getYearMonthType() {
            return TimePicker.yearMonthType;
        }
    }

    public static /* synthetic */ void pick$default(TimePicker timePicker2, boolean[] zArr, String str, Calendar calendar, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            zArr = defType;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            calendar = null;
        }
        timePicker2.pick(zArr, str, calendar, function1);
    }

    public final void pick(boolean[] zArr, String str, Calendar calendar, Function1<? super Date, Unit> function1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(zArr, TransmitterActivityKt.OPERATION_TYPE);
        Intrinsics.checkNotNullParameter(function1, "callBack");
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        if (calendar != null) {
            unit = Unit.INSTANCE;
        } else {
            Calendar calendar2 = instance;
            unit = null;
            calendar = calendar2;
        }
        if (unit == null) {
            TimePicker timePicker2 = this;
            calendar.set(calendar.get(1) - 1, calendar.get(2), calendar.get(5), calendar.get(11), calendar.get(12));
        }
        Calendar instance2 = Calendar.getInstance();
        TimePickerView build = new TimePickerBuilder(this.context, new TimePicker$$ExternalSyntheticLambda0(function1)).setDate(instance2).setRangDate(calendar, instance2).setLayoutRes(R.layout.layout_time_pick, new TimePicker$$ExternalSyntheticLambda1(str, this)).setTextColorCenter(this.context.getColor(R.color.green_65)).setContentTextSize(20).setType(zArr).setLabel("", "", "", "", "", "").setLineSpacingMultiplier(1.2f).setTextXOffset(0, 0, 0, 0, 0, 0).isCenterLabel(false).setDividerColor(this.context.getColor(R.color.green_65)).setBgColor(this.context.getColor(R.color.bg_item_color)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        setTimePicker(build);
        getTimePicker().show();
    }

    /* access modifiers changed from: private */
    public static final void pick$lambda$2(Function1 function1, Date date, View view) {
        Intrinsics.checkNotNullParameter(function1, "$callBack");
        Intrinsics.checkNotNull(date);
        function1.invoke(date);
    }

    /* access modifiers changed from: private */
    public static final void pick$lambda$5(String str, TimePicker timePicker2, View view) {
        Intrinsics.checkNotNullParameter(timePicker2, "this$0");
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        if (str != null) {
            textView.setText(str);
        }
        View findViewById2 = view.findViewById(R.id.tv_finish);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        View findViewById3 = view.findViewById(R.id.tv_cancel);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById2).setOnClickListener(new TimePicker$$ExternalSyntheticLambda2(timePicker2));
        ((TextView) findViewById3).setOnClickListener(new TimePicker$$ExternalSyntheticLambda3(timePicker2));
    }

    /* access modifiers changed from: private */
    public static final void pick$lambda$5$lambda$3(TimePicker timePicker2, View view) {
        Intrinsics.checkNotNullParameter(timePicker2, "this$0");
        timePicker2.getTimePicker().returnData();
        timePicker2.getTimePicker().dismiss();
    }

    /* access modifiers changed from: private */
    public static final void pick$lambda$5$lambda$4(TimePicker timePicker2, View view) {
        Intrinsics.checkNotNullParameter(timePicker2, "this$0");
        timePicker2.getTimePicker().dismiss();
    }
}
