package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityTimezoneHistoryBinding implements ViewBinding {
    public final ActionBarWidget actionbarTimezoneHistory;
    public final LinearLayout llTimezoneHistoryList;
    public final ConstraintLayout main;
    private final ConstraintLayout rootView;
    public final RecyclerView rvTimezoneHistory;
    public final TextView titleTimezoneHistory;
    public final TextView tvTimezoneHistoryNotice;

    private ActivityTimezoneHistoryBinding(ConstraintLayout constraintLayout, ActionBarWidget actionBarWidget, LinearLayout linearLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.actionbarTimezoneHistory = actionBarWidget;
        this.llTimezoneHistoryList = linearLayout;
        this.main = constraintLayout2;
        this.rvTimezoneHistory = recyclerView;
        this.titleTimezoneHistory = textView;
        this.tvTimezoneHistoryNotice = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTimezoneHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTimezoneHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_timezone_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTimezoneHistoryBinding bind(View view) {
        int i = R.id.actionbar_timezone_history;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.ll_timezone_history_list;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.rv_timezone_history;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.title_timezone_history;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_timezone_history_notice;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new ActivityTimezoneHistoryBinding(constraintLayout, actionBarWidget, linearLayout, constraintLayout, recyclerView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
