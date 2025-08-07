package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.webview.BaseWebView;

public final class ActivityCustomServiceBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    private final LinearLayout rootView;
    public final BaseWebView webCustomerService;

    private ActivityCustomServiceBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, BaseWebView baseWebView) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.webCustomerService = baseWebView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCustomServiceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityCustomServiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_custom_service, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCustomServiceBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.web_customer_service;
            BaseWebView baseWebView = (BaseWebView) ViewBindings.findChildViewById(view, i);
            if (baseWebView != null) {
                return new ActivityCustomServiceBinding((LinearLayout) view, actionBarWidget, baseWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
