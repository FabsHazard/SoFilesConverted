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
import com.microtech.aidexx.views.webview.BaseWebView;

public final class ActivityWebBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final FrameLayout fullscreenContainer;
    private final LinearLayout rootView;
    public final BaseWebView webBase;

    private ActivityWebBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, FrameLayout frameLayout, BaseWebView baseWebView) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.fullscreenContainer = frameLayout;
        this.webBase = baseWebView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWebBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityWebBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_web, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityWebBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.fullscreen_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.web_base;
                BaseWebView baseWebView = (BaseWebView) ViewBindings.findChildViewById(view, i);
                if (baseWebView != null) {
                    return new ActivityWebBinding((LinearLayout) view, actionBarWidget, frameLayout, baseWebView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
