package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.main.MainTabView;

public final class ActivityMainBinding implements ViewBinding {
    public final View bottomSpace;
    public final ConstraintLayout container;
    public final MainTabView mainTabView;
    private final ConstraintLayout rootView;
    public final ViewPager2 viewpager;

    private ActivityMainBinding(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, MainTabView mainTabView2, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.bottomSpace = view;
        this.container = constraintLayout2;
        this.mainTabView = mainTabView2;
        this.viewpager = viewPager2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        int i = R.id.bottom_space;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.main_tab_view;
            MainTabView mainTabView2 = (MainTabView) ViewBindings.findChildViewById(view, i);
            if (mainTabView2 != null) {
                i = R.id.viewpager;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                if (viewPager2 != null) {
                    return new ActivityMainBinding(constraintLayout, findChildViewById, constraintLayout, mainTabView2, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
