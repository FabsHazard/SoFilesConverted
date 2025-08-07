package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ActivityPairedHistoryBinding implements ViewBinding {
    public final ImageView ivBack;
    public final LinearLayout pairedHistoryActionbar;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPairedHistory;
    public final TextView tvTitle;

    private ActivityPairedHistoryBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivBack = imageView;
        this.pairedHistoryActionbar = linearLayout;
        this.rvPairedHistory = recyclerView;
        this.tvTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPairedHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPairedHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_paired_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPairedHistoryBinding bind(View view) {
        int i = R.id.iv_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.paired_history_actionbar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.rv_paired_history;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.tvTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new ActivityPairedHistoryBinding((ConstraintLayout) view, imageView, linearLayout, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
