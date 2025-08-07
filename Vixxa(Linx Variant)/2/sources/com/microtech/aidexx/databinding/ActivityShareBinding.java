package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.tab.ScrollTab;

public final class ActivityShareBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final FrameLayout frgShare;
    private final LinearLayout rootView;
    public final ScrollTab shareNav;

    private ActivityShareBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, FrameLayout frameLayout, ScrollTab scrollTab) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.frgShare = frameLayout;
        this.shareNav = scrollTab;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityShareBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.frg_share;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.share_nav;
                ScrollTab scrollTab = (ScrollTab) ViewBindings.findChildViewById(view, i);
                if (scrollTab != null) {
                    return new ActivityShareBinding((LinearLayout) view, actionBarWidget, frameLayout, scrollTab);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
