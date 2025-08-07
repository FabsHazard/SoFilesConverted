package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ItemPairedHistoryBinding implements ViewBinding {
    public final TextView historyDeviceSn;
    public final TextView historyDeviceTime;
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;

    private ItemPairedHistoryBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.historyDeviceSn = textView;
        this.historyDeviceTime = textView2;
        this.ivIcon = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPairedHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPairedHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_paired_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPairedHistoryBinding bind(View view) {
        int i = R.id.history_device_sn;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.history_device_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.iv_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    return new ItemPairedHistoryBinding((ConstraintLayout) view, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
