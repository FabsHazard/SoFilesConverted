package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ruler.RulerView;

public final class WidgetRulerBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RulerView rvNumber;
    public final TextView tvArrow;
    public final TextView tvNumber;
    public final TextView tvUnit;

    private WidgetRulerBinding(LinearLayout linearLayout, RulerView rulerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.rvNumber = rulerView;
        this.tvArrow = textView;
        this.tvNumber = textView2;
        this.tvUnit = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WidgetRulerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static WidgetRulerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.widget_ruler, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WidgetRulerBinding bind(View view) {
        int i = R.id.rv_number;
        RulerView rulerView = (RulerView) ViewBindings.findChildViewById(view, i);
        if (rulerView != null) {
            i = R.id.tv_arrow;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_number;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_unit;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new WidgetRulerBinding((LinearLayout) view, rulerView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
