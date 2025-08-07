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

public final class ActivityTransOperationBinding implements ViewBinding {
    public final ActionBarWidget actionbarTransOperation;
    public final LinearLayout llForceDelete;
    public final LinearLayout llPair;
    public final LinearLayout llUnpair;
    private final ConstraintLayout rootView;
    public final TextView tvForceDelete;
    public final TextView tvPair;
    public final TextView tvUnpair;

    private ActivityTransOperationBinding(ConstraintLayout constraintLayout, ActionBarWidget actionBarWidget, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.actionbarTransOperation = actionBarWidget;
        this.llForceDelete = linearLayout;
        this.llPair = linearLayout2;
        this.llUnpair = linearLayout3;
        this.tvForceDelete = textView;
        this.tvPair = textView2;
        this.tvUnpair = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTransOperationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTransOperationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_trans_operation, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTransOperationBinding bind(View view) {
        int i = R.id.actionbar_trans_operation;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.ll_force_delete;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.ll_pair;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.ll_unpair;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.tv_force_delete;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_pair;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_unpair;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new ActivityTransOperationBinding((ConstraintLayout) view, actionBarWidget, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
