package com.haibin.calendarview;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

public abstract class BaseMonthView extends BaseView {
    protected int mHeight;
    protected int mLineCount;
    protected int mMonth;
    MonthViewPager mMonthViewPager;
    protected int mNextDiff;
    protected int mYear;

    /* access modifiers changed from: protected */
    public Object getClickCalendarPaddingObject(float f, float f2, Calendar calendar) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onLoopStart(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onPreviewHook() {
    }

    public BaseMonthView(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public final void initMonthWithDate(int i, int i2) {
        this.mYear = i;
        this.mMonth = i2;
        initCalendar();
        this.mHeight = CalendarUtil.getMonthViewHeight(i, i2, this.mItemHeight, this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
    }

    private void initCalendar() {
        this.mNextDiff = CalendarUtil.getMonthEndDiff(this.mYear, this.mMonth, this.mDelegate.getWeekStart());
        int monthViewStartDiff = CalendarUtil.getMonthViewStartDiff(this.mYear, this.mMonth, this.mDelegate.getWeekStart());
        int monthDaysCount = CalendarUtil.getMonthDaysCount(this.mYear, this.mMonth);
        this.mItems = CalendarUtil.initCalendarForMonthView(this.mYear, this.mMonth, this.mDelegate.getCurrentDay(), this.mDelegate.getWeekStart());
        if (this.mItems.contains(this.mDelegate.getCurrentDay())) {
            this.mCurrentItem = this.mItems.indexOf(this.mDelegate.getCurrentDay());
        } else {
            this.mCurrentItem = this.mItems.indexOf(this.mDelegate.mSelectedCalendar);
        }
        if (this.mCurrentItem > 0 && this.mDelegate.mCalendarInterceptListener != null && this.mDelegate.mCalendarInterceptListener.onCalendarIntercept(this.mDelegate.mSelectedCalendar)) {
            this.mCurrentItem = -1;
        }
        if (this.mDelegate.getMonthViewShowMode() == 0) {
            this.mLineCount = 6;
        } else {
            this.mLineCount = ((monthViewStartDiff + monthDaysCount) + this.mNextDiff) / 7;
        }
        addSchemesFromMap();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public Calendar getIndex() {
        if (!(this.mItemWidth == 0 || this.mItemHeight == 0)) {
            if (this.mX <= ((float) this.mDelegate.getCalendarPaddingLeft()) || this.mX >= ((float) (getWidth() - this.mDelegate.getCalendarPaddingRight()))) {
                onClickCalendarPadding();
            } else {
                int calendarPaddingLeft = ((int) (this.mX - ((float) this.mDelegate.getCalendarPaddingLeft()))) / this.mItemWidth;
                if (calendarPaddingLeft >= 7) {
                    calendarPaddingLeft = 6;
                }
                int i = ((((int) this.mY) / this.mItemHeight) * 7) + calendarPaddingLeft;
                if (i < 0 || i >= this.mItems.size()) {
                    return null;
                }
                return (Calendar) this.mItems.get(i);
            }
        }
        return null;
    }

    private void onClickCalendarPadding() {
        if (this.mDelegate.mClickCalendarPaddingListener != null) {
            int calendarPaddingLeft = ((int) (this.mX - ((float) this.mDelegate.getCalendarPaddingLeft()))) / this.mItemWidth;
            if (calendarPaddingLeft >= 7) {
                calendarPaddingLeft = 6;
            }
            int i = ((((int) this.mY) / this.mItemHeight) * 7) + calendarPaddingLeft;
            Calendar calendar = (i < 0 || i >= this.mItems.size()) ? null : (Calendar) this.mItems.get(i);
            if (calendar != null) {
                this.mDelegate.mClickCalendarPaddingListener.onClickCalendarPadding(this.mX, this.mY, true, calendar, getClickCalendarPaddingObject(this.mX, this.mY, calendar));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void setSelectedCalendar(Calendar calendar) {
        this.mCurrentItem = this.mItems.indexOf(calendar);
    }

    /* access modifiers changed from: package-private */
    public final void updateShowMode() {
        this.mLineCount = CalendarUtil.getMonthViewLineCount(this.mYear, this.mMonth, this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        this.mHeight = CalendarUtil.getMonthViewHeight(this.mYear, this.mMonth, this.mItemHeight, this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public final void updateWeekStart() {
        initCalendar();
        this.mHeight = CalendarUtil.getMonthViewHeight(this.mYear, this.mMonth, this.mItemHeight, this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
    }

    /* access modifiers changed from: package-private */
    public void updateItemHeight() {
        super.updateItemHeight();
        this.mHeight = CalendarUtil.getMonthViewHeight(this.mYear, this.mMonth, this.mItemHeight, this.mDelegate.getWeekStart(), this.mDelegate.getMonthViewShowMode());
    }

    /* access modifiers changed from: package-private */
    public void updateCurrentDate() {
        if (this.mItems != null) {
            if (this.mItems.contains(this.mDelegate.getCurrentDay())) {
                for (Calendar currentDay : this.mItems) {
                    currentDay.setCurrentDay(false);
                }
                ((Calendar) this.mItems.get(this.mItems.indexOf(this.mDelegate.getCurrentDay()))).setCurrentDay(true);
            }
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public final int getSelectedIndex(Calendar calendar) {
        return this.mItems.indexOf(calendar);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.mLineCount != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.mHeight, BasicMeasure.EXACTLY);
        }
        super.onMeasure(i, i2);
    }
}
