package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.tab.ScrollTab;

public final class FragmentEventBinding implements ViewBinding {
    public final ConstraintLayout layoutActionbar;
    private final LinearLayout rootView;
    public final ScrollTab stIndicator;
    public final TextView tvHistoryTitle;
    public final ViewPager2 vpEventContent;

    private FragmentEventBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, ScrollTab scrollTab, TextView textView, ViewPager2 viewPager2) {
        this.rootView = linearLayout;
        this.layoutActionbar = constraintLayout;
        this.stIndicator = scrollTab;
        this.tvHistoryTitle = textView;
        this.vpEventContent = viewPager2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentEventBinding bind(View view) {
        int i = R.id.layout_actionbar;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.stIndicator;
            ScrollTab scrollTab = (ScrollTab) ViewBindings.findChildViewById(view, i);
            if (scrollTab != null) {
                i = R.id.tv_history_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.vp_event_content;
                    ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                    if (viewPager2 != null) {
                        return new FragmentEventBinding((LinearLayout) view, constraintLayout, scrollTab, textView, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
