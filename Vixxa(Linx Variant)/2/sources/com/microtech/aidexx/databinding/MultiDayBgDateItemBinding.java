package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.main.trend.view.DotView;

public final class MultiDayBgDateItemBinding implements ViewBinding {
    public final ConstraintLayout clItem;
    public final TextView dateItem;
    public final DotView dotView;
    private final ConstraintLayout rootView;

    private MultiDayBgDateItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, DotView dotView2) {
        this.rootView = constraintLayout;
        this.clItem = constraintLayout2;
        this.dateItem = textView;
        this.dotView = dotView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MultiDayBgDateItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MultiDayBgDateItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.multi_day_bg_date_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MultiDayBgDateItemBinding bind(View view) {
        int i = R.id.cl_item;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.date_item;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.dot_view;
                DotView dotView2 = (DotView) ViewBindings.findChildViewById(view, i);
                if (dotView2 != null) {
                    return new MultiDayBgDateItemBinding((ConstraintLayout) view, constraintLayout, textView, dotView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
