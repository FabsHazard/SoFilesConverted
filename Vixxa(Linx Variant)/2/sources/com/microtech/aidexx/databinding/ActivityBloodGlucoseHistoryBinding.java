package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ActivityBloodGlucoseHistoryBinding implements ViewBinding {
    public final ImageView ivBack;
    public final LinearLayout llHistoryContent;
    public final LinearLayout rlDateSpace;
    private final LinearLayout rootView;
    public final RecyclerView rvGlucoseHistory;
    public final TextView timeBegin;
    public final TextView timeEnd;
    public final TextView timeSeparate;
    public final TextView tvGlucoseTimeText;
    public final TextView tvTitle;

    private ActivityBloodGlucoseHistoryBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.ivBack = imageView;
        this.llHistoryContent = linearLayout2;
        this.rlDateSpace = linearLayout3;
        this.rvGlucoseHistory = recyclerView;
        this.timeBegin = textView;
        this.timeEnd = textView2;
        this.timeSeparate = textView3;
        this.tvGlucoseTimeText = textView4;
        this.tvTitle = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBloodGlucoseHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBloodGlucoseHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_blood_glucose_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityBloodGlucoseHistoryBinding bind(View view) {
        int i = R.id.ivBack;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.ll_history_content;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.rl_date_space;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.rvGlucoseHistory;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.time_begin;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.time_end;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.time_separate;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.tvGlucoseTimeText;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tvTitle;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new ActivityBloodGlucoseHistoryBinding((LinearLayout) view, imageView, linearLayout, linearLayout2, recyclerView, textView, textView2, textView3, textView4, textView5);
                                        }
                                    }
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
