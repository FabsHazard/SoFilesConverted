package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.haibin.calendarview.CalendarView;
import com.microtech.aidexx.R;

public final class DialogCalendarBinding implements ViewBinding {
    public final ImageView btCancel;
    public final TextView btOk;
    public final RadioButton btn14;
    public final RadioButton btn30;
    public final RadioButton btn7;
    public final CalendarView calendarView;
    public final RadioGroup rgSwitch;
    private final FrameLayout rootView;
    public final TextView tvMonth;

    private DialogCalendarBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, CalendarView calendarView2, RadioGroup radioGroup, TextView textView2) {
        this.rootView = frameLayout;
        this.btCancel = imageView;
        this.btOk = textView;
        this.btn14 = radioButton;
        this.btn30 = radioButton2;
        this.btn7 = radioButton3;
        this.calendarView = calendarView2;
        this.rgSwitch = radioGroup;
        this.tvMonth = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogCalendarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogCalendarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_calendar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogCalendarBinding bind(View view) {
        int i = R.id.bt_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bt_ok;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.btn_14;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton != null) {
                    i = R.id.btn_30;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton2 != null) {
                        i = R.id.btn_7;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, i);
                        if (radioButton3 != null) {
                            i = R.id.calendarView;
                            CalendarView calendarView2 = (CalendarView) ViewBindings.findChildViewById(view, i);
                            if (calendarView2 != null) {
                                i = R.id.rg_switch;
                                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                                if (radioGroup != null) {
                                    i = R.id.tv_month;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new DialogCalendarBinding((FrameLayout) view, imageView, textView, radioButton, radioButton2, radioButton3, calendarView2, radioGroup, textView2);
                                    }
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
