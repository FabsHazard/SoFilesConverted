package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.WeekTextView;

public final class CvWeekBarBinding implements ViewBinding {
    private final View rootView;
    public final WeekTextView weekFri;
    public final WeekTextView weekMon;
    public final WeekTextView weekSat;
    public final WeekTextView weekSun;
    public final WeekTextView weekThu;
    public final WeekTextView weekTue;
    public final WeekTextView weekWed;

    private CvWeekBarBinding(View view, WeekTextView weekTextView, WeekTextView weekTextView2, WeekTextView weekTextView3, WeekTextView weekTextView4, WeekTextView weekTextView5, WeekTextView weekTextView6, WeekTextView weekTextView7) {
        this.rootView = view;
        this.weekFri = weekTextView;
        this.weekMon = weekTextView2;
        this.weekSat = weekTextView3;
        this.weekSun = weekTextView4;
        this.weekThu = weekTextView5;
        this.weekTue = weekTextView6;
        this.weekWed = weekTextView7;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static CvWeekBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.cv_week_bar, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public static CvWeekBarBinding bind(View view) {
        int i = R.id.week_fri;
        WeekTextView weekTextView = (WeekTextView) ViewBindings.findChildViewById(view, i);
        if (weekTextView != null) {
            i = R.id.week_mon;
            WeekTextView weekTextView2 = (WeekTextView) ViewBindings.findChildViewById(view, i);
            if (weekTextView2 != null) {
                i = R.id.week_sat;
                WeekTextView weekTextView3 = (WeekTextView) ViewBindings.findChildViewById(view, i);
                if (weekTextView3 != null) {
                    i = R.id.week_sun;
                    WeekTextView weekTextView4 = (WeekTextView) ViewBindings.findChildViewById(view, i);
                    if (weekTextView4 != null) {
                        i = R.id.week_thu;
                        WeekTextView weekTextView5 = (WeekTextView) ViewBindings.findChildViewById(view, i);
                        if (weekTextView5 != null) {
                            i = R.id.week_tue;
                            WeekTextView weekTextView6 = (WeekTextView) ViewBindings.findChildViewById(view, i);
                            if (weekTextView6 != null) {
                                i = R.id.week_wed;
                                WeekTextView weekTextView7 = (WeekTextView) ViewBindings.findChildViewById(view, i);
                                if (weekTextView7 != null) {
                                    return new CvWeekBarBinding(view, weekTextView, weekTextView2, weekTextView3, weekTextView4, weekTextView5, weekTextView6, weekTextView7);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
