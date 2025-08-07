package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.tab.ScrollTab;

public final class FragmentHistoryBinding implements ViewBinding {
    public final ImageView btnNextDay;
    public final ImageView btnPreviousDay;
    public final ViewPager2 pageHistory;
    private final ConstraintLayout rootView;
    public final ScrollTab stIndicator;
    public final TextView tvHistoryTitle;
    public final TextView tvTimeSelected;

    private FragmentHistoryBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ViewPager2 viewPager2, ScrollTab scrollTab, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnNextDay = imageView;
        this.btnPreviousDay = imageView2;
        this.pageHistory = viewPager2;
        this.stIndicator = scrollTab;
        this.tvHistoryTitle = textView;
        this.tvTimeSelected = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHistoryBinding bind(View view) {
        int i = R.id.btn_next_day;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_previous_day;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.page_history;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                if (viewPager2 != null) {
                    i = R.id.stIndicator;
                    ScrollTab scrollTab = (ScrollTab) ViewBindings.findChildViewById(view, i);
                    if (scrollTab != null) {
                        i = R.id.tv_history_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tvTimeSelected;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new FragmentHistoryBinding((ConstraintLayout) view, imageView, imageView2, viewPager2, scrollTab, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
