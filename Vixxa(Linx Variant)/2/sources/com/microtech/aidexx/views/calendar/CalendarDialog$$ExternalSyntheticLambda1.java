package com.microtech.aidexx.views.calendar;

import android.widget.RadioGroup;
import com.microtech.aidexx.databinding.DialogCalendarBinding;
import java.util.Date;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CalendarDialog$$ExternalSyntheticLambda1 implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ Date f$0;
    public final /* synthetic */ DialogCalendarBinding f$1;
    public final /* synthetic */ Ref.IntRef f$2;
    public final /* synthetic */ Date f$3;
    public final /* synthetic */ Date f$4;
    public final /* synthetic */ Date f$5;

    public /* synthetic */ CalendarDialog$$ExternalSyntheticLambda1(Date date, DialogCalendarBinding dialogCalendarBinding, Ref.IntRef intRef, Date date2, Date date3, Date date4) {
        this.f$0 = date;
        this.f$1 = dialogCalendarBinding;
        this.f$2 = intRef;
        this.f$3 = date2;
        this.f$4 = date3;
        this.f$5 = date4;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        CalendarDialog._init_$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, radioGroup, i);
    }
}
