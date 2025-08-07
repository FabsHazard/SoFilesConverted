package com.haibin.calendarview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.haibin.calendarview.CalendarView;

public abstract class RangeMonthView extends BaseMonthView {
    /* access modifiers changed from: protected */
    public abstract void onDrawScheme(Canvas canvas, Calendar calendar, int i, int i2, boolean z);

    /* access modifiers changed from: protected */
    public abstract boolean onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: protected */
    public abstract void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2);

    public boolean onLongClick(View view) {
        return false;
    }

    public RangeMonthView(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mLineCount != 0) {
            this.mItemWidth = ((getWidth() - this.mDelegate.getCalendarPaddingLeft()) - this.mDelegate.getCalendarPaddingRight()) / 7;
            onPreviewHook();
            int i = this.mLineCount * 7;
            int i2 = 0;
            int i3 = 0;
            while (i3 < this.mLineCount) {
                int i4 = i2;
                for (int i5 = 0; i5 < 7; i5++) {
                    Calendar calendar = (Calendar) this.mItems.get(i4);
                    if (this.mDelegate.getMonthViewShowMode() == 1) {
                        if (i4 <= this.mItems.size() - this.mNextDiff) {
                            if (!calendar.isCurrentMonth()) {
                                i4++;
                            }
                        } else {
                            return;
                        }
                    } else if (this.mDelegate.getMonthViewShowMode() == 2 && i4 >= i) {
                        return;
                    }
                    draw(canvas, calendar, i4, i3, i5);
                    i4++;
                }
                i3++;
                i2 = i4;
            }
        }
    }

    private void draw(Canvas canvas, Calendar calendar, int i, int i2, int i3) {
        int calendarPaddingLeft = (i3 * this.mItemWidth) + this.mDelegate.getCalendarPaddingLeft();
        int i4 = i2 * this.mItemHeight;
        onLoopStart(calendarPaddingLeft, i4);
        boolean isCalendarSelected = isCalendarSelected(calendar);
        boolean hasScheme = calendar.hasScheme();
        boolean isSelectPreCalendar = isSelectPreCalendar(calendar, i);
        boolean isSelectNextCalendar = isSelectNextCalendar(calendar, i);
        if (hasScheme) {
            if ((isCalendarSelected ? onDrawSelected(canvas, calendar, calendarPaddingLeft, i4, true, isSelectPreCalendar, isSelectNextCalendar) : false) || !isCalendarSelected) {
                this.mSchemePaint.setColor(calendar.getSchemeColor() != 0 ? calendar.getSchemeColor() : this.mDelegate.getSchemeThemeColor());
                onDrawScheme(canvas, calendar, calendarPaddingLeft, i4, true);
            }
        } else if (isCalendarSelected) {
            onDrawSelected(canvas, calendar, calendarPaddingLeft, i4, false, isSelectPreCalendar, isSelectNextCalendar);
        }
        onDrawText(canvas, calendar, calendarPaddingLeft, i4, hasScheme, isCalendarSelected);
    }

    /* access modifiers changed from: protected */
    public boolean isCalendarSelected(Calendar calendar) {
        if (this.mDelegate.mSelectedStartRangeCalendar == null || onCalendarIntercept(calendar)) {
            return false;
        }
        if (this.mDelegate.mSelectedEndRangeCalendar == null) {
            if (calendar.compareTo(this.mDelegate.mSelectedStartRangeCalendar) == 0) {
                return true;
            }
            return false;
        } else if (calendar.compareTo(this.mDelegate.mSelectedStartRangeCalendar) < 0 || calendar.compareTo(this.mDelegate.mSelectedEndRangeCalendar) > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void onClick(View view) {
        Calendar index;
        if (this.isClick && (index = getIndex()) != null) {
            boolean z = true;
            if (this.mDelegate.getMonthViewShowMode() == 1 && !index.isCurrentMonth()) {
                return;
            }
            if (onCalendarIntercept(index)) {
                this.mDelegate.mCalendarInterceptListener.onCalendarInterceptClick(index, true);
            } else if (isInRange(index)) {
                if (this.mDelegate.mSelectedStartRangeCalendar != null && this.mDelegate.mSelectedEndRangeCalendar == null) {
                    int differ = CalendarUtil.differ(index, this.mDelegate.mSelectedStartRangeCalendar);
                    if (differ < 0 || this.mDelegate.getMinSelectRange() == -1 || this.mDelegate.getMinSelectRange() <= differ + 1) {
                        if (this.mDelegate.getMaxSelectRange() != -1 && this.mDelegate.getMaxSelectRange() < CalendarUtil.differ(index, this.mDelegate.mSelectedStartRangeCalendar) + 1) {
                            if (this.mDelegate.mCalendarRangeSelectListener != null) {
                                this.mDelegate.mCalendarRangeSelectListener.onSelectOutOfRange(index, false);
                                return;
                            }
                            return;
                        }
                    } else if (this.mDelegate.mCalendarRangeSelectListener != null) {
                        this.mDelegate.mCalendarRangeSelectListener.onSelectOutOfRange(index, true);
                        return;
                    } else {
                        return;
                    }
                }
                if (this.mDelegate.mSelectedStartRangeCalendar == null || this.mDelegate.mSelectedEndRangeCalendar != null) {
                    this.mDelegate.mSelectedStartRangeCalendar = index;
                    this.mDelegate.mSelectedEndRangeCalendar = null;
                } else {
                    int compareTo = index.compareTo(this.mDelegate.mSelectedStartRangeCalendar);
                    if (this.mDelegate.getMinSelectRange() == -1 && compareTo <= 0) {
                        this.mDelegate.mSelectedStartRangeCalendar = index;
                        this.mDelegate.mSelectedEndRangeCalendar = null;
                    } else if (compareTo < 0) {
                        this.mDelegate.mSelectedStartRangeCalendar = index;
                        this.mDelegate.mSelectedEndRangeCalendar = null;
                    } else if (compareTo == 0 && this.mDelegate.getMinSelectRange() == 1) {
                        this.mDelegate.mSelectedEndRangeCalendar = index;
                    } else {
                        this.mDelegate.mSelectedEndRangeCalendar = index;
                    }
                }
                this.mCurrentItem = this.mItems.indexOf(index);
                if (!index.isCurrentMonth() && this.mMonthViewPager != null) {
                    int currentItem = this.mMonthViewPager.getCurrentItem();
                    this.mMonthViewPager.setCurrentItem(this.mCurrentItem < 7 ? currentItem - 1 : currentItem + 1);
                }
                if (this.mDelegate.mInnerListener != null) {
                    this.mDelegate.mInnerListener.onMonthDateSelected(index, true);
                }
                if (this.mParentLayout != null) {
                    if (index.isCurrentMonth()) {
                        this.mParentLayout.updateSelectPosition(this.mItems.indexOf(index));
                    } else {
                        this.mParentLayout.updateSelectWeek(CalendarUtil.getWeekFromDayInMonth(index, this.mDelegate.getWeekStart()));
                    }
                }
                if (this.mDelegate.mCalendarRangeSelectListener != null) {
                    CalendarView.OnCalendarRangeSelectListener onCalendarRangeSelectListener = this.mDelegate.mCalendarRangeSelectListener;
                    if (this.mDelegate.mSelectedEndRangeCalendar == null) {
                        z = false;
                    }
                    onCalendarRangeSelectListener.onCalendarRangeSelect(index, z);
                }
            } else if (this.mDelegate.mCalendarRangeSelectListener != null) {
                this.mDelegate.mCalendarRangeSelectListener.onCalendarSelectOutOfRange(index);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isSelectPreCalendar(Calendar calendar, int i) {
        Calendar calendar2;
        if (i == 0) {
            calendar2 = CalendarUtil.getPreCalendar(calendar);
            this.mDelegate.updateCalendarScheme(calendar2);
        } else {
            calendar2 = (Calendar) this.mItems.get(i - 1);
        }
        if (this.mDelegate.mSelectedStartRangeCalendar == null || !isCalendarSelected(calendar2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean isSelectNextCalendar(Calendar calendar, int i) {
        Calendar calendar2;
        if (i == this.mItems.size() - 1) {
            calendar2 = CalendarUtil.getNextCalendar(calendar);
            this.mDelegate.updateCalendarScheme(calendar2);
        } else {
            calendar2 = (Calendar) this.mItems.get(i + 1);
        }
        if (this.mDelegate.mSelectedStartRangeCalendar == null || !isCalendarSelected(calendar2)) {
            return false;
        }
        return true;
    }
}
