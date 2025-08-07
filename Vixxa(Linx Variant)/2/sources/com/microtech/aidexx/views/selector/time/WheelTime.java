package com.microtech.aidexx.views.selector.time;

import android.view.View;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.igexin.assist.sdk.AssistPushConsts;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.views.selector.base.ArrayWheelAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WheelTime {
    private static final int DEFAULT_END_DAY = 31;
    private static final int DEFAULT_END_HOUR = 0;
    private static final int DEFAULT_END_MINUTE = 0;
    private static final int DEFAULT_END_MONTH = 12;
    private static final int DEFAULT_END_SECOND = 0;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_DAY = 1;
    private static final int DEFAULT_START_MONTH = 1;
    private static final int DEFAULT_START_YEAR = 1900;
    public static DateFormat dateFormat = new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.ENGLISH);
    /* access modifiers changed from: private */
    public int currentYear;
    /* access modifiers changed from: private */
    public int endDay = 31;
    /* access modifiers changed from: private */
    public int endHour = 0;
    /* access modifiers changed from: private */
    public int endMinute = 0;
    /* access modifiers changed from: private */
    public int endMonth = 12;
    /* access modifiers changed from: private */
    public int endYear = DEFAULT_END_YEAR;
    private final int gravity;
    private boolean isLunarCalendar = false;
    /* access modifiers changed from: private */
    public ISelectTimeCallback mSelectChangeCallback;
    /* access modifiers changed from: private */
    public int startDay = 1;
    /* access modifiers changed from: private */
    public int startMonth = 1;
    /* access modifiers changed from: private */
    public int startYear = 1900;
    private final int textSize;
    private final boolean[] type;
    private final View view;
    /* access modifiers changed from: private */
    public WheelView wv_day;
    /* access modifiers changed from: private */
    public WheelView wv_hours;
    /* access modifiers changed from: private */
    public WheelView wv_minutes;
    /* access modifiers changed from: private */
    public WheelView wv_month;
    private WheelView wv_seconds;
    /* access modifiers changed from: private */
    public WheelView wv_year;

    public WheelTime(View view2, boolean[] zArr, int i, int i2) {
        this.view = view2;
        this.type = zArr;
        this.gravity = i;
        this.textSize = i2;
    }

    public void setLunarMode(boolean z) {
        this.isLunarCalendar = z;
    }

    public boolean isLunarMode() {
        return this.isLunarCalendar;
    }

    public void setPicker(int i, int i2, int i3) {
        setPicker(i, i2, i3, 0, 0, 0);
    }

    public void setPicker(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.isLunarCalendar) {
            int[] solarToLunar = LunarCalendar.solarToLunar(i, i2 + 1, i3);
            setLunar(solarToLunar[0], solarToLunar[1] - 1, solarToLunar[2], solarToLunar[3] == 1, i4, i5, i6);
            return;
        }
        setSolar(i, i2, i3, i4, i5, i6);
    }

    private void setLunar(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        WheelView wheelView = (WheelView) this.view.findViewById(R.id.year);
        this.wv_year = wheelView;
        wheelView.setAdapter(new ArrayWheelAdapter(ChinaDate.getYears(this.startYear, this.endYear)));
        this.wv_year.setLabel("");
        this.wv_year.setCurrentItem(i - this.startYear);
        this.wv_year.setGravity(this.gravity);
        WheelView wheelView2 = (WheelView) this.view.findViewById(R.id.month);
        this.wv_month = wheelView2;
        wheelView2.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(i)));
        this.wv_month.setLabel("");
        int leapMonth = ChinaDate.leapMonth(i);
        if (leapMonth == 0 || (i2 <= leapMonth - 1 && !z)) {
            this.wv_month.setCurrentItem(i2);
        } else {
            this.wv_month.setCurrentItem(i2 + 1);
        }
        this.wv_month.setGravity(this.gravity);
        this.wv_day = (WheelView) this.view.findViewById(R.id.day);
        if (ChinaDate.leapMonth(i) == 0) {
            this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(i, i2))));
        } else {
            this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(i))));
        }
        this.wv_day.setLabel("");
        this.wv_day.setCurrentItem(i3 - 1);
        this.wv_day.setGravity(this.gravity);
        WheelView wheelView3 = (WheelView) this.view.findViewById(R.id.hour);
        this.wv_hours = wheelView3;
        int i7 = 0;
        wheelView3.setAdapter(new NumericWheelAdapter(0, 23));
        this.wv_hours.setCurrentItem(i4);
        this.wv_hours.setGravity(this.gravity);
        WheelView wheelView4 = (WheelView) this.view.findViewById(R.id.min);
        this.wv_minutes = wheelView4;
        wheelView4.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_minutes.setCurrentItem(i5);
        this.wv_minutes.setGravity(this.gravity);
        WheelView wheelView5 = (WheelView) this.view.findViewById(R.id.second);
        this.wv_seconds = wheelView5;
        wheelView5.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_seconds.setCurrentItem(i5);
        this.wv_seconds.setGravity(this.gravity);
        this.wv_year.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int access$000 = i + WheelTime.this.startYear;
                WheelTime.this.wv_month.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(access$000)));
                if (ChinaDate.leapMonth(access$000) == 0 || WheelTime.this.wv_month.getCurrentItem() <= ChinaDate.leapMonth(access$000) - 1) {
                    WheelTime.this.wv_month.setCurrentItem(WheelTime.this.wv_month.getCurrentItem());
                } else {
                    WheelTime.this.wv_month.setCurrentItem(WheelTime.this.wv_month.getCurrentItem() + 1);
                }
                int currentItem = WheelTime.this.wv_day.getCurrentItem();
                if (ChinaDate.leapMonth(access$000) == 0 || WheelTime.this.wv_month.getCurrentItem() <= ChinaDate.leapMonth(access$000) - 1) {
                    WheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(access$000, WheelTime.this.wv_month.getCurrentItem() + 1))));
                    i2 = ChinaDate.monthDays(access$000, WheelTime.this.wv_month.getCurrentItem() + 1);
                } else if (WheelTime.this.wv_month.getCurrentItem() == ChinaDate.leapMonth(access$000) + 1) {
                    WheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(access$000))));
                    i2 = ChinaDate.leapDays(access$000);
                } else {
                    WheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(access$000, WheelTime.this.wv_month.getCurrentItem()))));
                    i2 = ChinaDate.monthDays(access$000, WheelTime.this.wv_month.getCurrentItem());
                }
                int i3 = i2 - 1;
                if (currentItem > i3) {
                    WheelTime.this.wv_day.setCurrentItem(i3);
                }
                if (WheelTime.this.mSelectChangeCallback != null) {
                    WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                }
            }
        });
        this.wv_month.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int currentItem = WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear;
                int currentItem2 = WheelTime.this.wv_day.getCurrentItem();
                if (ChinaDate.leapMonth(currentItem) == 0 || i <= ChinaDate.leapMonth(currentItem) - 1) {
                    int i3 = i + 1;
                    WheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i3))));
                    i2 = ChinaDate.monthDays(currentItem, i3);
                } else if (WheelTime.this.wv_month.getCurrentItem() == ChinaDate.leapMonth(currentItem) + 1) {
                    WheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(currentItem))));
                    i2 = ChinaDate.leapDays(currentItem);
                } else {
                    WheelTime.this.wv_day.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i))));
                    i2 = ChinaDate.monthDays(currentItem, i);
                }
                int i4 = i2 - 1;
                if (currentItem2 > i4) {
                    WheelTime.this.wv_day.setCurrentItem(i4);
                }
                if (WheelTime.this.mSelectChangeCallback != null) {
                    WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                }
            }
        });
        setChangedListener(this.wv_day);
        setChangedListener(this.wv_hours);
        setChangedListener(this.wv_minutes);
        setChangedListener(this.wv_seconds);
        boolean[] zArr = this.type;
        if (zArr.length == 6) {
            this.wv_year.setVisibility(zArr[0] ? 0 : 8);
            this.wv_month.setVisibility(this.type[1] ? 0 : 8);
            this.wv_day.setVisibility(this.type[2] ? 0 : 8);
            this.wv_hours.setVisibility(this.type[3] ? 0 : 8);
            this.wv_minutes.setVisibility(this.type[4] ? 0 : 8);
            WheelView wheelView6 = this.wv_seconds;
            if (!this.type[5]) {
                i7 = 8;
            }
            wheelView6.setVisibility(i7);
            setContentTextSize();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    private void setSolar(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        int i11 = 0;
        String[] strArr = {"1", "3", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST, "8", "10", "12"};
        String[] strArr2 = {AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_VIVO, "9", "11"};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.currentYear = i9;
        WheelView wheelView = (WheelView) this.view.findViewById(R.id.year);
        this.wv_year = wheelView;
        wheelView.setAdapter(new NumericWheelAdapter(this.startYear, this.endYear));
        this.wv_year.setCurrentItem(i9 - this.startYear);
        this.wv_year.setGravity(this.gravity);
        WheelView wheelView2 = (WheelView) this.view.findViewById(R.id.month);
        this.wv_month = wheelView2;
        int i12 = this.startYear;
        int i13 = this.endYear;
        if (i12 == i13) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.startMonth, this.endMonth));
            this.wv_month.setCurrentItem((i10 + 1) - this.startMonth);
        } else if (i9 == i12) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.startMonth, 12));
            this.wv_month.setCurrentItem((i10 + 1) - this.startMonth);
        } else if (i9 == i13) {
            wheelView2.setAdapter(new NumericWheelAdapter(1, this.endMonth));
            this.wv_month.setCurrentItem(i10);
        } else {
            wheelView2.setAdapter(new NumericWheelAdapter(1, 12));
            this.wv_month.setCurrentItem(i10);
        }
        this.wv_month.setGravity(this.gravity);
        this.wv_day = (WheelView) this.view.findViewById(R.id.day);
        boolean z = (i9 % 4 == 0 && i9 % 100 != 0) || i9 % 400 == 0;
        int i14 = this.startYear;
        int i15 = this.endYear;
        int i16 = 29;
        if (i14 == i15 && this.startMonth == this.endMonth) {
            int i17 = i10 + 1;
            if (asList.contains(String.valueOf(i17))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            } else if (asList2.contains(String.valueOf(i17))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            } else if (z) {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            } else {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
            }
            this.wv_day.setCurrentItem(i3 - this.startDay);
        } else if (i9 == i14 && (i8 = i10 + 1) == this.startMonth) {
            if (asList.contains(String.valueOf(i8))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, 31));
            } else if (asList2.contains(String.valueOf(i8))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(this.startDay, 30));
            } else {
                WheelView wheelView3 = this.wv_day;
                int i18 = this.startDay;
                if (!z) {
                    i16 = 28;
                }
                wheelView3.setAdapter(new NumericWheelAdapter(i18, i16));
            }
            this.wv_day.setCurrentItem(i3 - this.startDay);
        } else if (i9 == i15 && (i7 = i10 + 1) == this.endMonth) {
            if (asList.contains(String.valueOf(i7))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            } else if (asList2.contains(String.valueOf(i7))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            } else if (z) {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            } else {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(1, this.endDay));
            }
            this.wv_day.setCurrentItem(i3 - 1);
        } else {
            int i19 = i10 + 1;
            if (asList.contains(String.valueOf(i19))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(1, 31));
            } else if (asList2.contains(String.valueOf(i19))) {
                this.wv_day.setAdapter(new NumericWheelAdapter(1, 30));
            } else {
                WheelView wheelView4 = this.wv_day;
                int i20 = this.startDay;
                if (!z) {
                    i16 = 28;
                }
                wheelView4.setAdapter(new NumericWheelAdapter(i20, i16));
            }
            this.wv_day.setCurrentItem(i3 - 1);
        }
        this.wv_day.setGravity(this.gravity);
        WheelView wheelView5 = (WheelView) this.view.findViewById(R.id.hour);
        this.wv_hours = wheelView5;
        wheelView5.setAdapter(new NumericWheelAdapter(0, this.endHour));
        this.wv_hours.setCurrentItem(i4);
        this.wv_hours.setGravity(this.gravity);
        WheelView wheelView6 = (WheelView) this.view.findViewById(R.id.min);
        this.wv_minutes = wheelView6;
        wheelView6.setAdapter(new NumericWheelAdapter(0, this.endMinute));
        this.wv_minutes.setCurrentItem(i5);
        this.wv_minutes.setGravity(this.gravity);
        WheelView wheelView7 = (WheelView) this.view.findViewById(R.id.second);
        this.wv_seconds = wheelView7;
        wheelView7.setAdapter(new NumericWheelAdapter(0, 0));
        this.wv_seconds.setCurrentItem(i6);
        this.wv_seconds.setGravity(this.gravity);
        this.wv_year.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int access$000 = i + WheelTime.this.startYear;
                int unused = WheelTime.this.currentYear = access$000;
                int currentItem = WheelTime.this.wv_month.getCurrentItem();
                if (WheelTime.this.startYear == WheelTime.this.endYear) {
                    WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(WheelTime.this.startMonth, WheelTime.this.endMonth));
                    if (currentItem > WheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        WheelTime.this.wv_month.setCurrentItem(currentItem);
                    }
                    int access$700 = currentItem + WheelTime.this.startMonth;
                    if (WheelTime.this.startMonth == WheelTime.this.endMonth) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.setReDay(access$000, access$700, wheelTime.startDay, WheelTime.this.endDay, asList, asList2);
                    } else if (access$700 == WheelTime.this.startMonth) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.setReDay(access$000, access$700, wheelTime2.startDay, 31, asList, asList2);
                    } else if (access$700 == WheelTime.this.endMonth) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.setReDay(access$000, access$700, 1, wheelTime3.endDay, asList, asList2);
                    } else {
                        WheelTime.this.setReDay(access$000, access$700, 1, 31, asList, asList2);
                    }
                } else if (access$000 == WheelTime.this.startYear) {
                    WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(WheelTime.this.startMonth, 12));
                    if (currentItem > WheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        WheelTime.this.wv_month.setCurrentItem(currentItem);
                    }
                    int access$7002 = currentItem + WheelTime.this.startMonth;
                    if (access$7002 == WheelTime.this.startMonth) {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.setReDay(access$000, access$7002, wheelTime4.startDay, 31, asList, asList2);
                    } else {
                        WheelTime.this.setReDay(access$000, access$7002, 1, 31, asList, asList2);
                    }
                } else if (access$000 == WheelTime.this.endYear) {
                    WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(1, WheelTime.this.endMonth));
                    if (currentItem > WheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                        WheelTime.this.wv_month.setCurrentItem(currentItem);
                    }
                    int i2 = currentItem + 1;
                    if (i2 == WheelTime.this.endMonth) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.setReDay(access$000, i2, 1, wheelTime5.endDay, asList, asList2);
                    } else {
                        WheelTime.this.setReDay(access$000, i2, 1, 31, asList, asList2);
                    }
                } else {
                    WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(1, 12));
                    WheelTime wheelTime6 = WheelTime.this;
                    wheelTime6.setReDay(access$000, wheelTime6.wv_month.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear == WheelTime.this.endYear && WheelTime.this.wv_month.getCurrentItem() + 1 == WheelTime.this.endMonth && WheelTime.this.wv_day.getCurrentItem() + 1 == WheelTime.this.endDay) {
                    WheelTime.this.wv_hours.setAdapter(new NumericWheelAdapter(0, WheelTime.this.endHour));
                    WheelTime.this.wv_hours.setCurrentItem(WheelTime.this.endHour);
                } else {
                    WheelTime.this.wv_hours.setAdapter(new NumericWheelAdapter(0, 23));
                    WheelTime.this.wv_hours.setCurrentItem(12);
                }
                if (WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear == WheelTime.this.endYear && WheelTime.this.wv_month.getCurrentItem() + 1 == WheelTime.this.endMonth && WheelTime.this.wv_day.getCurrentItem() + 1 == WheelTime.this.endDay && WheelTime.this.wv_hours.getCurrentItem() == WheelTime.this.endHour) {
                    WheelTime.this.wv_minutes.setAdapter(new NumericWheelAdapter(0, WheelTime.this.endMinute));
                    WheelTime.this.wv_minutes.setCurrentItem(WheelTime.this.endMinute);
                } else {
                    WheelTime.this.wv_minutes.setAdapter(new NumericWheelAdapter(0, 59));
                    WheelTime.this.wv_minutes.setCurrentItem(30);
                }
                if (WheelTime.this.mSelectChangeCallback != null) {
                    WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                }
            }
        });
        this.wv_month.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2 = i + 1;
                if (WheelTime.this.startYear == WheelTime.this.endYear) {
                    int access$700 = (i2 + WheelTime.this.startMonth) - 1;
                    if (WheelTime.this.startMonth == WheelTime.this.endMonth) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.setReDay(wheelTime.currentYear, access$700, WheelTime.this.startDay, WheelTime.this.endDay, asList, asList2);
                    } else if (WheelTime.this.startMonth == access$700) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.setReDay(wheelTime2.currentYear, access$700, WheelTime.this.startDay, 31, asList, asList2);
                    } else if (WheelTime.this.endMonth == access$700) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.setReDay(wheelTime3.currentYear, access$700, 1, WheelTime.this.endDay, asList, asList2);
                    } else {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.setReDay(wheelTime4.currentYear, access$700, 1, 31, asList, asList2);
                    }
                } else if (WheelTime.this.currentYear == WheelTime.this.startYear) {
                    int access$7002 = (i2 + WheelTime.this.startMonth) - 1;
                    if (access$7002 == WheelTime.this.startMonth) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.setReDay(wheelTime5.currentYear, access$7002, WheelTime.this.startDay, 31, asList, asList2);
                    } else {
                        WheelTime wheelTime6 = WheelTime.this;
                        wheelTime6.setReDay(wheelTime6.currentYear, access$7002, 1, 31, asList, asList2);
                    }
                } else if (WheelTime.this.currentYear != WheelTime.this.endYear) {
                    WheelTime wheelTime7 = WheelTime.this;
                    wheelTime7.setReDay(wheelTime7.currentYear, i2, 1, 31, asList, asList2);
                } else if (i2 == WheelTime.this.endMonth) {
                    WheelTime wheelTime8 = WheelTime.this;
                    wheelTime8.setReDay(wheelTime8.currentYear, WheelTime.this.wv_month.getCurrentItem() + 1, 1, WheelTime.this.endDay, asList, asList2);
                } else {
                    WheelTime wheelTime9 = WheelTime.this;
                    wheelTime9.setReDay(wheelTime9.currentYear, WheelTime.this.wv_month.getCurrentItem() + 1, 1, 31, asList, asList2);
                }
                if (WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear == WheelTime.this.endYear && WheelTime.this.wv_month.getCurrentItem() + 1 == WheelTime.this.endMonth && WheelTime.this.wv_day.getCurrentItem() + 1 == WheelTime.this.endDay) {
                    WheelTime.this.wv_hours.setAdapter(new NumericWheelAdapter(0, WheelTime.this.endHour));
                    WheelTime.this.wv_hours.setCurrentItem(WheelTime.this.endHour);
                } else {
                    WheelTime.this.wv_hours.setAdapter(new NumericWheelAdapter(0, 23));
                    WheelTime.this.wv_hours.setCurrentItem(12);
                }
                if (WheelTime.this.wv_year.getCurrentItem() + WheelTime.this.startYear == WheelTime.this.endYear && WheelTime.this.wv_month.getCurrentItem() + 1 == WheelTime.this.endMonth && WheelTime.this.wv_day.getCurrentItem() + 1 == WheelTime.this.endDay && WheelTime.this.wv_hours.getCurrentItem() == WheelTime.this.endHour) {
                    WheelTime.this.wv_minutes.setAdapter(new NumericWheelAdapter(0, WheelTime.this.endMinute));
                    WheelTime.this.wv_minutes.setCurrentItem(WheelTime.this.endMinute);
                } else {
                    WheelTime.this.wv_minutes.setAdapter(new NumericWheelAdapter(0, 59));
                    WheelTime.this.wv_minutes.setCurrentItem(30);
                }
                if (WheelTime.this.mSelectChangeCallback != null) {
                    WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                }
            }
        });
        this.wv_day.setOnItemSelectedListener(new WheelTime$$ExternalSyntheticLambda0(this));
        this.wv_hours.setOnItemSelectedListener(new WheelTime$$ExternalSyntheticLambda1(this));
        setChangedListener(this.wv_day);
        setChangedListener(this.wv_hours);
        setChangedListener(this.wv_minutes);
        setChangedListener(this.wv_seconds);
        boolean[] zArr = this.type;
        if (zArr.length == 6) {
            this.wv_year.setVisibility(zArr[0] ? 0 : 8);
            this.wv_month.setVisibility(this.type[1] ? 0 : 8);
            this.wv_day.setVisibility(this.type[2] ? 0 : 8);
            this.wv_hours.setVisibility(this.type[3] ? 0 : 8);
            this.wv_minutes.setVisibility(this.type[4] ? 0 : 8);
            WheelView wheelView8 = this.wv_seconds;
            if (!this.type[5]) {
                i11 = 8;
            }
            wheelView8.setVisibility(i11);
            setContentTextSize();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setSolar$0$com-microtech-aidexx-views-selector-time-WheelTime  reason: not valid java name */
    public /* synthetic */ void m297lambda$setSolar$0$commicrotechaidexxviewsselectortimeWheelTime(int i) {
        if (this.wv_year.getCurrentItem() + this.startYear == this.endYear && this.wv_month.getCurrentItem() + 1 == this.endMonth && this.wv_day.getCurrentItem() + 1 == this.endDay) {
            this.wv_hours.setAdapter(new NumericWheelAdapter(0, this.endHour));
            this.wv_hours.setCurrentItem(this.endHour);
        } else {
            this.wv_hours.setAdapter(new NumericWheelAdapter(0, 23));
            this.wv_hours.setCurrentItem(12);
        }
        if (this.wv_year.getCurrentItem() + this.startYear == this.endYear && this.wv_month.getCurrentItem() + 1 == this.endMonth && this.wv_day.getCurrentItem() + 1 == this.endDay && this.wv_hours.getCurrentItem() == this.endHour) {
            this.wv_minutes.setAdapter(new NumericWheelAdapter(0, this.endMinute));
            this.wv_minutes.setCurrentItem(this.endMinute);
            return;
        }
        this.wv_minutes.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_minutes.setCurrentItem(30);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setSolar$1$com-microtech-aidexx-views-selector-time-WheelTime  reason: not valid java name */
    public /* synthetic */ void m298lambda$setSolar$1$commicrotechaidexxviewsselectortimeWheelTime(int i) {
        if (this.wv_year.getCurrentItem() + this.startYear == this.endYear && this.wv_month.getCurrentItem() + 1 == this.endMonth && this.wv_day.getCurrentItem() + 1 == this.endDay && i == this.endHour) {
            this.wv_minutes.setAdapter(new NumericWheelAdapter(0, this.endMinute));
            this.wv_minutes.setCurrentItem(this.endMinute);
            return;
        }
        this.wv_minutes.setAdapter(new NumericWheelAdapter(0, 59));
        this.wv_minutes.setCurrentItem(30);
    }

    private void setChangedListener(WheelView wheelView) {
        if (this.mSelectChangeCallback != null) {
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void setReDay(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.wv_day.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            if (i4 > 28) {
                i4 = 28;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i3, i4));
        } else {
            if (i4 > 29) {
                i4 = 29;
            }
            this.wv_day.setAdapter(new NumericWheelAdapter(i3, i4));
        }
        if (currentItem > this.wv_day.getAdapter().getItemsCount() - 1) {
            this.wv_day.setCurrentItem(this.wv_day.getAdapter().getItemsCount() - 1);
        }
    }

    private void setContentTextSize() {
        this.wv_day.setTextSize((float) this.textSize);
        this.wv_month.setTextSize((float) this.textSize);
        this.wv_year.setTextSize((float) this.textSize);
        this.wv_hours.setTextSize((float) this.textSize);
        this.wv_minutes.setTextSize((float) this.textSize);
        this.wv_seconds.setTextSize((float) this.textSize);
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.isLunarCalendar) {
            if (str != null) {
                this.wv_year.setLabel(str);
            } else {
                this.wv_year.setLabel("年");
            }
            if (str2 != null) {
                this.wv_month.setLabel(str2);
            } else {
                this.wv_month.setLabel("月");
            }
            if (str3 != null) {
                this.wv_day.setLabel(str3);
            } else {
                this.wv_day.setLabel("日");
            }
            if (str4 != null) {
                this.wv_hours.setLabel(str4);
            } else {
                this.wv_hours.setLabel("时");
            }
            if (str5 != null) {
                this.wv_minutes.setLabel(str5);
            } else {
                this.wv_minutes.setLabel("分");
            }
            if (str6 != null) {
                this.wv_seconds.setLabel(str6);
            } else {
                this.wv_seconds.setLabel("秒");
            }
        }
    }

    public void setTextXOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        this.wv_year.setTextXOffset(i);
        this.wv_month.setTextXOffset(i2);
        this.wv_day.setTextXOffset(i3);
        this.wv_hours.setTextXOffset(i4);
        this.wv_minutes.setTextXOffset(i5);
        this.wv_seconds.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.wv_year.setCyclic(z);
        this.wv_month.setCyclic(z);
        this.wv_day.setCyclic(z);
        this.wv_hours.setCyclic(z);
        this.wv_minutes.setCyclic(z);
        this.wv_seconds.setCyclic(z);
    }

    public String getTime() {
        if (this.isLunarCalendar) {
            return getLunarTime();
        }
        StringBuilder sb = new StringBuilder();
        if (this.currentYear == this.startYear) {
            int currentItem = this.wv_month.getCurrentItem();
            int i = this.startMonth;
            if (currentItem + i == i) {
                sb.append(this.wv_year.getCurrentItem() + this.startYear).append("-").append(this.wv_month.getCurrentItem() + this.startMonth).append("-").append(this.wv_day.getCurrentItem() + this.startDay).append(" ").append(this.wv_hours.getCurrentItem()).append(":").append(this.wv_minutes.getCurrentItem()).append(":").append(this.wv_seconds.getCurrentItem());
            } else {
                sb.append(this.wv_year.getCurrentItem() + this.startYear).append("-").append(this.wv_month.getCurrentItem() + this.startMonth).append("-").append(this.wv_day.getCurrentItem() + 1).append(" ").append(this.wv_hours.getCurrentItem()).append(":").append(this.wv_minutes.getCurrentItem()).append(":").append(this.wv_seconds.getCurrentItem());
            }
        } else {
            sb.append(this.wv_year.getCurrentItem() + this.startYear).append("-").append(this.wv_month.getCurrentItem() + 1).append("-").append(this.wv_day.getCurrentItem() + 1).append(" ").append(this.wv_hours.getCurrentItem()).append(":").append(this.wv_minutes.getCurrentItem()).append(":").append(this.wv_seconds.getCurrentItem());
        }
        return sb.toString();
    }

    private String getLunarTime() {
        boolean z;
        int i;
        int currentItem;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.wv_year.getCurrentItem() + this.startYear;
        if (ChinaDate.leapMonth(currentItem2) == 0) {
            currentItem = this.wv_month.getCurrentItem();
        } else if ((this.wv_month.getCurrentItem() + 1) - ChinaDate.leapMonth(currentItem2) <= 0) {
            currentItem = this.wv_month.getCurrentItem();
        } else if ((this.wv_month.getCurrentItem() + 1) - ChinaDate.leapMonth(currentItem2) == 1) {
            i = this.wv_month.getCurrentItem();
            z = true;
            int[] lunarToSolar = LunarCalendar.lunarToSolar(currentItem2, i, this.wv_day.getCurrentItem() + 1, z);
            sb.append(lunarToSolar[0]).append("-").append(lunarToSolar[1]).append("-").append(lunarToSolar[2]).append(" ").append(this.wv_hours.getCurrentItem()).append(":").append(this.wv_minutes.getCurrentItem()).append(":").append(this.wv_seconds.getCurrentItem());
            return sb.toString();
        } else {
            i = this.wv_month.getCurrentItem();
            z = false;
            int[] lunarToSolar2 = LunarCalendar.lunarToSolar(currentItem2, i, this.wv_day.getCurrentItem() + 1, z);
            sb.append(lunarToSolar2[0]).append("-").append(lunarToSolar2[1]).append("-").append(lunarToSolar2[2]).append(" ").append(this.wv_hours.getCurrentItem()).append(":").append(this.wv_minutes.getCurrentItem()).append(":").append(this.wv_seconds.getCurrentItem());
            return sb.toString();
        }
        i = currentItem + 1;
        z = false;
        int[] lunarToSolar22 = LunarCalendar.lunarToSolar(currentItem2, i, this.wv_day.getCurrentItem() + 1, z);
        sb.append(lunarToSolar22[0]).append("-").append(lunarToSolar22[1]).append("-").append(lunarToSolar22[2]).append(" ").append(this.wv_hours.getCurrentItem()).append(":").append(this.wv_minutes.getCurrentItem()).append(":").append(this.wv_seconds.getCurrentItem());
        return sb.toString();
    }

    public View getView() {
        return this.view;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public void setStartYear(int i) {
        this.startYear = i;
    }

    public int getEndYear() {
        return this.endYear;
    }

    public void setEndYear(int i) {
        this.endYear = i;
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = calendar2.get(11);
            int i5 = calendar2.get(12);
            int i6 = this.startYear;
            if (i > i6) {
                this.endYear = i;
                this.endMonth = i2;
                this.endDay = i3;
                this.endHour = i4;
                this.endMinute = i5;
            } else if (i == i6) {
                int i7 = this.startMonth;
                if (i2 > i7) {
                    this.endYear = i;
                    this.endMonth = i2;
                    this.endDay = i3;
                    this.endHour = i4;
                    this.endMinute = i5;
                } else if (i2 == i7 && i3 > this.startDay) {
                    this.endYear = i;
                    this.endMonth = i2;
                    this.endDay = i3;
                    this.endHour = i4;
                    this.endMinute = i5;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i8 = calendar.get(1);
            int i9 = calendar.get(2) + 1;
            int i10 = calendar.get(5);
            int i11 = this.endYear;
            if (i8 < i11) {
                this.startMonth = i9;
                this.startDay = i10;
                this.startYear = i8;
            } else if (i8 == i11) {
                int i12 = this.endMonth;
                if (i9 < i12) {
                    this.startMonth = i9;
                    this.startDay = i10;
                    this.startYear = i8;
                } else if (i9 == i12 && i10 < this.endDay) {
                    this.startMonth = i9;
                    this.startDay = i10;
                    this.startYear = i8;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.startMonth = calendar.get(2) + 1;
            this.endMonth = calendar2.get(2) + 1;
            this.startDay = calendar.get(5);
            this.endDay = calendar2.get(5);
            this.endHour = calendar2.get(11);
            this.endMinute = calendar2.get(12);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.wv_day.setLineSpacingMultiplier(f);
        this.wv_month.setLineSpacingMultiplier(f);
        this.wv_year.setLineSpacingMultiplier(f);
        this.wv_hours.setLineSpacingMultiplier(f);
        this.wv_minutes.setLineSpacingMultiplier(f);
        this.wv_seconds.setLineSpacingMultiplier(f);
    }

    public void setDividerColor(int i) {
        this.wv_day.setDividerColor(i);
        this.wv_month.setDividerColor(i);
        this.wv_year.setDividerColor(i);
        this.wv_hours.setDividerColor(i);
        this.wv_minutes.setDividerColor(i);
        this.wv_seconds.setDividerColor(i);
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.wv_day.setDividerType(dividerType);
        this.wv_month.setDividerType(dividerType);
        this.wv_year.setDividerType(dividerType);
        this.wv_hours.setDividerType(dividerType);
        this.wv_minutes.setDividerType(dividerType);
        this.wv_seconds.setDividerType(dividerType);
    }

    public void setTextColorCenter(int i) {
        this.wv_day.setTextColorCenter(i);
        this.wv_month.setTextColorCenter(i);
        this.wv_year.setTextColorCenter(i);
        this.wv_hours.setTextColorCenter(i);
        this.wv_minutes.setTextColorCenter(i);
        this.wv_seconds.setTextColorCenter(i);
    }

    public void setTextColorOut(int i) {
        this.wv_day.setTextColorOut(i);
        this.wv_month.setTextColorOut(i);
        this.wv_year.setTextColorOut(i);
        this.wv_hours.setTextColorOut(i);
        this.wv_minutes.setTextColorOut(i);
        this.wv_seconds.setTextColorOut(i);
    }

    public void isCenterLabel(boolean z) {
        this.wv_day.isCenterLabel(z);
        this.wv_month.isCenterLabel(z);
        this.wv_year.isCenterLabel(z);
        this.wv_hours.isCenterLabel(z);
        this.wv_minutes.isCenterLabel(z);
        this.wv_seconds.isCenterLabel(z);
    }

    public void setSelectChangeCallback(ISelectTimeCallback iSelectTimeCallback) {
        this.mSelectChangeCallback = iSelectTimeCallback;
    }

    public void setItemsVisible(int i) {
        this.wv_day.setItemsVisibleCount(i);
        this.wv_month.setItemsVisibleCount(i);
        this.wv_year.setItemsVisibleCount(i);
        this.wv_hours.setItemsVisibleCount(i);
        this.wv_minutes.setItemsVisibleCount(i);
        this.wv_seconds.setItemsVisibleCount(i);
    }

    public void setAlphaGradient(boolean z) {
        this.wv_day.setAlphaGradient(z);
        this.wv_month.setAlphaGradient(z);
        this.wv_year.setAlphaGradient(z);
        this.wv_hours.setAlphaGradient(z);
        this.wv_minutes.setAlphaGradient(z);
        this.wv_seconds.setAlphaGradient(z);
    }
}
