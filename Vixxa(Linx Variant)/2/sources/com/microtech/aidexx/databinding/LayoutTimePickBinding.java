package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contrarywind.view.WheelView;
import com.microtech.aidexx.R;

public final class LayoutTimePickBinding implements ViewBinding {
    public final WheelView day;
    public final WheelView hour;
    public final WheelView min;
    public final WheelView month;
    private final LinearLayout rootView;
    public final WheelView second;
    public final LinearLayout timepicker;
    public final TextView tvCancel;
    public final TextView tvFinish;
    public final TextView tvTitle;
    public final WheelView year;

    private LayoutTimePickBinding(LinearLayout linearLayout, WheelView wheelView, WheelView wheelView2, WheelView wheelView3, WheelView wheelView4, WheelView wheelView5, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, WheelView wheelView6) {
        this.rootView = linearLayout;
        this.day = wheelView;
        this.hour = wheelView2;
        this.min = wheelView3;
        this.month = wheelView4;
        this.second = wheelView5;
        this.timepicker = linearLayout2;
        this.tvCancel = textView;
        this.tvFinish = textView2;
        this.tvTitle = textView3;
        this.year = wheelView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTimePickBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutTimePickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_time_pick, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutTimePickBinding bind(View view) {
        int i = R.id.day;
        WheelView wheelView = (WheelView) ViewBindings.findChildViewById(view, i);
        if (wheelView != null) {
            i = R.id.hour;
            WheelView wheelView2 = (WheelView) ViewBindings.findChildViewById(view, i);
            if (wheelView2 != null) {
                i = R.id.min;
                WheelView wheelView3 = (WheelView) ViewBindings.findChildViewById(view, i);
                if (wheelView3 != null) {
                    i = R.id.month;
                    WheelView wheelView4 = (WheelView) ViewBindings.findChildViewById(view, i);
                    if (wheelView4 != null) {
                        i = R.id.second;
                        WheelView wheelView5 = (WheelView) ViewBindings.findChildViewById(view, i);
                        if (wheelView5 != null) {
                            i = R.id.timepicker;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.tv_cancel;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.tv_finish;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.year;
                                            WheelView wheelView6 = (WheelView) ViewBindings.findChildViewById(view, i);
                                            if (wheelView6 != null) {
                                                return new LayoutTimePickBinding((LinearLayout) view, wheelView, wheelView2, wheelView3, wheelView4, wheelView5, linearLayout, textView, textView2, textView3, wheelView6);
                                            }
                                        }
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
