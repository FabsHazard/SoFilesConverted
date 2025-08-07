package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityGuidanceBinding implements ViewBinding {
    public final ActionBarWidget actionbarGuide;
    private final ConstraintLayout rootView;
    public final TextView tvNextStep;
    public final ViewPager2 viewpagerGuide;

    private ActivityGuidanceBinding(ConstraintLayout constraintLayout, ActionBarWidget actionBarWidget, TextView textView, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.actionbarGuide = actionBarWidget;
        this.tvNextStep = textView;
        this.viewpagerGuide = viewPager2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGuidanceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityGuidanceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_guidance, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityGuidanceBinding bind(View view) {
        int i = R.id.actionbar_guide;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.tv_next_step;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.viewpager_guide;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                if (viewPager2 != null) {
                    return new ActivityGuidanceBinding((ConstraintLayout) view, actionBarWidget, textView, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
