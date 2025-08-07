package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityPermissionCheckBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final TextView checkOnce;
    public final LinearLayout itemLl;
    private final ConstraintLayout rootView;
    public final TextView tip;
    public final ConstraintLayout tipCl;

    private ActivityPermissionCheckBinding(ConstraintLayout constraintLayout, ActionBarWidget actionBarWidget, TextView textView, LinearLayout linearLayout, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.actionBar = actionBarWidget;
        this.checkOnce = textView;
        this.itemLl = linearLayout;
        this.tip = textView2;
        this.tipCl = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPermissionCheckBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPermissionCheckBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_permission_check, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPermissionCheckBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.checkOnce;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.itemLl;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.tip;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tipCl;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            return new ActivityPermissionCheckBinding((ConstraintLayout) view, actionBarWidget, textView, linearLayout, textView2, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
