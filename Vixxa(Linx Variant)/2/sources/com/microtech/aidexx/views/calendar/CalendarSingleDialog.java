package com.microtech.aidexx.views.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
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
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.lingala.zip4j.util.InternalZipConstants;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/views/calendar/CalendarSingleDialog;", "Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomPopupView;", "context", "Landroid/content/Context;", "showDataPoint", "", "needOutsideDismiss", "selectedDate", "Ljava/util/Date;", "onSelected", "Lkotlin/Function1;", "", "(Landroid/content/Context;ZZLjava/util/Date;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "buildText", "", "year", "", "month", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CalendarDialog.kt */
public final class CalendarSingleDialog extends BaseBottomPopupView {
    private final Context context;
    private final Date selectedDate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CalendarSingleDialog(Context context2, boolean z, boolean z2, Date date, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i & 2) != 0 ? true : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : date, function1);
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CalendarSingleDialog(Context context2, boolean z, boolean z2, Date date, Function1<? super Date, Unit> function1) {
        super(context2);
        Unit unit;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(function1, "onSelected");
        this.context = context2;
        this.selectedDate = date;
        CalendarDataCache.INSTANCE.setNeedShowDataPointInThisView(z);
        DialogCalendarBinding inflate = DialogCalendarBinding.inflate(LayoutInflater.from(context2), getContentContainer(), true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.calendarView.setTextColor(context2.getColor(R.color.green_65), context2.getColor(ThemeManager.INSTANCE.isLight() ? R.color.black_33 : R.color.white), context2.getColor(ThemeManager.INSTANCE.isLight() ? R.color.gray_e6 : R.color.whiteAlpha30), context2.getColor(ThemeManager.INSTANCE.isLight() ? R.color.black_33 : R.color.white), context2.getColor(ThemeManager.INSTANCE.isLight() ? R.color.gray_e6 : R.color.whiteAlpha30));
        inflate.tvMonth.setText(buildText(inflate.calendarView.getCurYear(), inflate.calendarView.getCurMonth()));
        RadioGroup radioGroup = inflate.rgSwitch;
        Intrinsics.checkNotNullExpressionValue(radioGroup, "rgSwitch");
        radioGroup.setVisibility(8);
        inflate.calendarView.setOnMonthChangeListener(new CalendarSingleDialog$$ExternalSyntheticLambda0(inflate, this));
        inflate.calendarView.setMonthView(CustomMonthView.class);
        if (date != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            inflate.calendarView.scrollToCalendar(instance.get(1), instance.get(2) + 1, instance.get(5));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            inflate.calendarView.scrollToCurrent();
        }
        inflate.calendarView.setSelectSingleMode();
        inflate.calendarView.setRange(inflate.calendarView.getCurYear() - 1, 1, inflate.calendarView.getCurDay(), inflate.calendarView.getCurYear(), inflate.calendarView.getCurMonth(), inflate.calendarView.getCurDay());
        ImageView imageView = inflate.btCancel;
        Intrinsics.checkNotNullExpressionValue(imageView, "btCancel");
        ExtendsKt.setDebounceClickListener$default(imageView, 0, new CalendarSingleDialog$$ExternalSyntheticLambda1(this), 1, (Object) null);
        TextView textView = inflate.btOk;
        Intrinsics.checkNotNullExpressionValue(textView, "btOk");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new CalendarSingleDialog$$ExternalSyntheticLambda2(inflate, function1, this), 1, (Object) null);
        setKeyBackCancelable(true);
        setOutSideCancelable(z2);
        show();
    }

    static final void lambda$5$lambda$0(DialogCalendarBinding dialogCalendarBinding, CalendarSingleDialog calendarSingleDialog, int i, int i2) {
        Intrinsics.checkNotNullParameter(dialogCalendarBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(calendarSingleDialog, "this$0");
        dialogCalendarBinding.tvMonth.setText(calendarSingleDialog.buildText(i, i2));
        LogUtil.Companion.d$default(LogUtil.Companion, "year=" + i + " month=" + i2, (String) null, 2, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new CalendarSingleDialog$1$1$1(i, i2, calendarSingleDialog, dialogCalendarBinding, (Continuation<? super CalendarSingleDialog$1$1$1>) null), 3, (Object) null);
    }

    static final void lambda$5$lambda$3(CalendarSingleDialog calendarSingleDialog, View view) {
        Intrinsics.checkNotNullParameter(calendarSingleDialog, "this$0");
        calendarSingleDialog.dismiss();
    }

    static final void lambda$5$lambda$4(DialogCalendarBinding dialogCalendarBinding, Function1 function1, CalendarSingleDialog calendarSingleDialog, View view) {
        Intrinsics.checkNotNullParameter(dialogCalendarBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(function1, "$onSelected");
        Intrinsics.checkNotNullParameter(calendarSingleDialog, "this$0");
        com.haibin.calendarview.Calendar selectedCalendar = dialogCalendarBinding.calendarView.getSelectedCalendar();
        if (selectedCalendar != null) {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            instance.set(1, selectedCalendar.getYear());
            instance.set(2, selectedCalendar.getMonth() - 1);
            instance.set(5, selectedCalendar.getDay());
            Date date = new Date();
            date.setTime(instance.getTimeInMillis());
            function1.invoke(date);
            calendarSingleDialog.dismiss();
            return;
        }
        String string = calendarSingleDialog.context.getString(R.string.com_datePicker_singleHint);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ExtendsKt.toastShort(string);
    }

    private final String buildText(int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, i);
        instance.set(2, i2 - 1);
        instance.set(5, 1);
        String yearFormat = ExtendsKt.setYearFormat(i);
        String format = NumberFormat.getInstance(Locale.getDefault()).format(Integer.valueOf(i2));
        Date time = instance.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
        String formatToYM = ExtendsKt.formatToYM(time);
        if (formatToYM != null) {
            return formatToYM;
        }
        String str = yearFormat + InternalZipConstants.ZIP_FILE_SEPARATOR + format;
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }
}
