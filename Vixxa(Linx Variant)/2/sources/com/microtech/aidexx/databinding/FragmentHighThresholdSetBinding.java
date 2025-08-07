package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ruler.RulerWidget;

public final class FragmentHighThresholdSetBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RulerWidget rwHighSet;
    public final TextView tvHypoDesc;

    private FragmentHighThresholdSetBinding(ConstraintLayout constraintLayout, RulerWidget rulerWidget, TextView textView) {
        this.rootView = constraintLayout;
        this.rwHighSet = rulerWidget;
        this.tvHypoDesc = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHighThresholdSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentHighThresholdSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_high_threshold_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHighThresholdSetBinding bind(View view) {
        int i = R.id.rw_high_set;
        RulerWidget rulerWidget = (RulerWidget) ViewBindings.findChildViewById(view, i);
        if (rulerWidget != null) {
            i = R.id.tv_hypo_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new FragmentHighThresholdSetBinding((ConstraintLayout) view, rulerWidget, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
