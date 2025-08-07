package com.microtech.aidexx.views.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.DialogCalendarBinding;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.views.dialog.bottom.BaseBottomPopupView;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.lingala.zip4j.util.InternalZipConstants;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\u0010\rJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/views/calendar/CalendarDialog;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomPopupView;", "context", "Landroid/content/Context;", "showDataPoint", "", "onRangeSelected", "Lkotlin/Function1;", "", "", "onSelected", "Lkotlin/Function2;", "Ljava/util/Date;", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "buildText", "", "year", "month", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CalendarDialog.kt */
public final class CalendarDialog extends BaseBottomPopupView {
    private final Context context;

    /* access modifiers changed from: private */
    public static final boolean _init_$lambda$5(View view, MotionEvent motionEvent) {
        return true;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CalendarDialog(Context context2, boolean z, Function1<? super Integer, Unit> function1, Function2<? super Date, ? super Date, Unit> function2) {
        super(context2);
        Context context3 = context2;
        Intrinsics.checkNotNullParameter(context3, "context");
        Intrinsics.checkNotNullParameter(function1, "onRangeSelected");
        Intrinsics.checkNotNullParameter(function2, "onSelected");
        this.context = context3;
        CalendarDataCache.INSTANCE.setNeedShowDataPointInThisView(z);
        Calendar instance = Calendar.getInstance();
        instance.add(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        Date date = new Date(timeInMillis);
        Date date2 = new Date((timeInMillis - 604800000) + ((long) TimeZone.getDefault().getDSTSavings()));
        Date date3 = new Date((timeInMillis - 1209600000) + ((long) TimeZone.getDefault().getDSTSavings()));
        Date date4 = new Date((timeInMillis - 2592000000L) + ((long) TimeZone.getDefault().getDSTSavings()));
        DialogCalendarBinding bind = DialogCalendarBinding.bind(LayoutInflater.from(context2).inflate(R.layout.dialog_calendar, getContentContainer()));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        bind.calendarView.setOnMonthChangeListener(new CalendarDialog$$ExternalSyntheticLambda0(bind, this));
        bind.calendarView.setSelectSingleMode();
        bind.calendarView.setTextColor(context3.getColor(R.color.green_65), context3.getColor(ThemeManager.INSTANCE.isLight() ? R.color.black_33 : R.color.white), context3.getColor(ThemeManager.INSTANCE.isLight() ? R.color.gray_e6 : R.color.whiteAlpha30), context3.getColor(ThemeManager.INSTANCE.isLight() ? R.color.black_33 : R.color.white), context3.getColor(ThemeManager.INSTANCE.isLight() ? R.color.gray_e6 : R.color.whiteAlpha30));
        bind.tvMonth.setText(buildText(bind.calendarView.getCurYear(), bind.calendarView.getCurMonth()));
        bind.calendarView.setRange(bind.calendarView.getCurYear() - 1, 1, bind.calendarView.getCurDay(), bind.calendarView.getCurYear(), bind.calendarView.getCurMonth(), bind.calendarView.getCurDay());
        bind.calendarView.setMonthView(CustomRangeMonthView.class);
        bind.calendarView.scrollToCurrent();
        bind.calendarView.setSelectRangeMode();
        Ref.IntRef intRef = new Ref.IntRef();
        bind.rgSwitch.setOnCheckedChangeListener(new CalendarDialog$$ExternalSyntheticLambda1(date, bind, intRef, date2, date3, date4));
        View findViewById = findViewById(R.id.bt_ok);
        if (findViewById != null) {
            findViewById.setOnClickListener(new CalendarDialog$$ExternalSyntheticLambda2(intRef, function1, this, bind, function2));
        }
        View findViewById2 = findViewById(R.id.bt_cancel);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new CalendarDialog$$ExternalSyntheticLambda3(this));
        }
        getContentContainer().setOnTouchListener(new CalendarDialog$$ExternalSyntheticLambda4());
        setKeyBackCancelable(true);
        setOutSideCancelable(true);
        show();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DialogCalendarBinding dialogCalendarBinding, CalendarDialog calendarDialog, int i, int i2) {
        Intrinsics.checkNotNullParameter(dialogCalendarBinding, "$bind");
        Intrinsics.checkNotNullParameter(calendarDialog, "this$0");
        dialogCalendarBinding.tvMonth.setText(calendarDialog.buildText(i, i2));
        LogUtil.Companion.d$default(LogUtil.Companion, "year=" + i + " month=" + i2, (String) null, 2, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new CalendarDialog$1$1(i, i2, calendarDialog, dialogCalendarBinding, (Continuation<? super CalendarDialog$1$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(Date date, DialogCalendarBinding dialogCalendarBinding, Ref.IntRef intRef, Date date2, Date date3, Date date4, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(date, "$dateToday");
        Intrinsics.checkNotNullParameter(dialogCalendarBinding, "$bind");
        Intrinsics.checkNotNullParameter(intRef, "$rangeIndex");
        Intrinsics.checkNotNullParameter(date2, "$last7days");
        Intrinsics.checkNotNullParameter(date3, "$last14days");
        Intrinsics.checkNotNullParameter(date4, "$last30days");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if (checkedRadioButtonId == dialogCalendarBinding.btn7.getId()) {
            intRef.element = 1;
            Calendar instance2 = Calendar.getInstance();
            instance2.setTime(date2);
            dialogCalendarBinding.calendarView.setSelectStartCalendar(instance2.get(1), instance2.get(2) + 1, instance2.get(5));
            dialogCalendarBinding.calendarView.setSelectEndCalendar(instance.get(1), instance.get(2) + 1, instance.get(5) - 1);
        } else if (checkedRadioButtonId == dialogCalendarBinding.btn14.getId()) {
            intRef.element = 2;
            Calendar instance3 = Calendar.getInstance();
            instance3.setTime(date3);
            dialogCalendarBinding.calendarView.setSelectStartCalendar(instance3.get(1), instance3.get(2) + 1, instance3.get(5));
            dialogCalendarBinding.calendarView.setSelectEndCalendar(instance.get(1), instance.get(2) + 1, instance.get(5) - 1);
        } else if (checkedRadioButtonId == dialogCalendarBinding.btn30.getId()) {
            intRef.element = 3;
            Calendar instance4 = Calendar.getInstance();
            instance4.setTime(date4);
            dialogCalendarBinding.calendarView.setSelectStartCalendar(instance4.get(1), instance4.get(2) + 1, instance4.get(5));
            dialogCalendarBinding.calendarView.setSelectEndCalendar(instance.get(1), instance.get(2) + 1, instance.get(5) - 1);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(Ref.IntRef intRef, Function1 function1, CalendarDialog calendarDialog, DialogCalendarBinding dialogCalendarBinding, Function2 function2, View view) {
        Intrinsics.checkNotNullParameter(intRef, "$rangeIndex");
        Intrinsics.checkNotNullParameter(function1, "$onRangeSelected");
        Intrinsics.checkNotNullParameter(calendarDialog, "this$0");
        Intrinsics.checkNotNullParameter(dialogCalendarBinding, "$bind");
        Intrinsics.checkNotNullParameter(function2, "$onSelected");
        if (intRef.element != 0) {
            function1.invoke(Integer.valueOf(intRef.element));
            calendarDialog.dismiss();
            return;
        }
        List<com.haibin.calendarview.Calendar> selectCalendarRange = dialogCalendarBinding.calendarView.getSelectCalendarRange();
        Intrinsics.checkNotNullExpressionValue(selectCalendarRange, "getSelectCalendarRange(...)");
        if (selectCalendarRange.size() > 1) {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            instance.set(1, selectCalendarRange.get(0).getYear());
            instance.set(2, selectCalendarRange.get(0).getMonth() - 1);
            instance.set(5, selectCalendarRange.get(0).getDay());
            Date date = new Date();
            date.setTime(instance.getTimeInMillis());
            instance.set(1, selectCalendarRange.get(selectCalendarRange.size() - 1).getYear());
            instance.set(2, selectCalendarRange.get(selectCalendarRange.size() - 1).getMonth() - 1);
            instance.set(5, selectCalendarRange.get(selectCalendarRange.size() - 1).getDay() + 1);
            Date date2 = new Date();
            date2.setTime(instance.getTimeInMillis());
            function2.invoke(date, date2);
            calendarDialog.dismiss();
            return;
        }
        String string = calendarDialog.context.getString(R.string.com_datePicker_mulHint);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast.makeText(calendarDialog.context, string, 0).show();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$4(CalendarDialog calendarDialog, View view) {
        Intrinsics.checkNotNullParameter(calendarDialog, "this$0");
        calendarDialog.dismiss();
    }

    private final String buildText(int i, int i2) {
        String str = ExtendsKt.setYearFormat(i) + InternalZipConstants.ZIP_FILE_SEPARATOR + NumberFormat.getInstance(Locale.getDefault()).format(Integer.valueOf(i2));
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }
}
