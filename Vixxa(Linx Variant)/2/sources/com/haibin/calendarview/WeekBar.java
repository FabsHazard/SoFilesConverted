package com.haibin.calendarview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

public class WeekBar extends LinearLayout {
    private CalendarViewDelegate mDelegate;

    /* access modifiers changed from: protected */
    public void onDateSelected(Calendar calendar, int i, boolean z) {
    }

    public WeekBar(Context context) {
        super(context);
        if ("com.haibin.calendarview.WeekBar".equals(getClass().getName())) {
            LayoutInflater.from(context).inflate(R.layout.cv_week_bar, this, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void setup(CalendarViewDelegate calendarViewDelegate) {
        this.mDelegate = calendarViewDelegate;
        if ("com.haibin.calendarview.WeekBar".equalsIgnoreCase(getClass().getName())) {
            setTextSize(this.mDelegate.getWeekTextSize());
            setTextColor(calendarViewDelegate.getWeekTextColor());
            setBackgroundColor(calendarViewDelegate.getWeekBackground());
            setPadding(calendarViewDelegate.getCalendarPaddingLeft(), 0, calendarViewDelegate.getCalendarPaddingRight(), 0);
        }
    }

    /* access modifiers changed from: protected */
    public void setTextColor(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((TextView) getChildAt(i2)).setTextColor(i);
        }
    }

    /* access modifiers changed from: protected */
    public void setTextSize(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((TextView) getChildAt(i2)).setTextSize(0, (float) i);
        }
    }

    /* access modifiers changed from: protected */
    public void onWeekStartChange(int i) {
        if ("com.haibin.calendarview.WeekBar".equalsIgnoreCase(getClass().getName())) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                ((TextView) getChildAt(i2)).setText(getWeekString(i2, i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public int getViewIndexByCalendar(Calendar calendar, int i) {
        int week = calendar.getWeek();
        int i2 = week + 1;
        if (i == 1) {
            return week;
        }
        if (i == 2) {
            if (i2 == 1) {
                return 6;
            }
            return week - 1;
        } else if (i2 == 7) {
            return 0;
        } else {
            return i2;
        }
    }

    private String getWeekString(int i, int i2) {
        String[] stringArray = getContext().getResources().getStringArray(R.array.week_string_array);
        if (i2 == 1) {
            return stringArray[i];
        }
        int i3 = 6;
        if (i2 == 2) {
            return stringArray[i == 6 ? 0 : i + 1];
        }
        if (i != 0) {
            i3 = i - 1;
        }
        return stringArray[i3];
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        CalendarViewDelegate calendarViewDelegate = this.mDelegate;
        if (calendarViewDelegate != null) {
            i3 = View.MeasureSpec.makeMeasureSpec(calendarViewDelegate.getWeekBarHeight(), BasicMeasure.EXACTLY);
        } else {
            i3 = View.MeasureSpec.makeMeasureSpec(CalendarUtil.dipToPx(getContext(), 40.0f), BasicMeasure.EXACTLY);
        }
        super.onMeasure(i, i3);
    }
}
