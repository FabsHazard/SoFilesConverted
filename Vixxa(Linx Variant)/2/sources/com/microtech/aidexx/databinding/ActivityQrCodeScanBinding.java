package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityQrCodeScanBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final ImageView animationLine;
    public final CheckBox flashSwitch;
    public final FrameLayout layoutScan;
    public final LinearLayout llPreview;
    private final FrameLayout rootView;
    public final TextView tvScanTips;

    private ActivityQrCodeScanBinding(FrameLayout frameLayout, ActionBarWidget actionBarWidget, ImageView imageView, CheckBox checkBox, FrameLayout frameLayout2, LinearLayout linearLayout, TextView textView) {
        this.rootView = frameLayout;
        this.actionBar = actionBarWidget;
        this.animationLine = imageView;
        this.flashSwitch = checkBox;
        this.layoutScan = frameLayout2;
        this.llPreview = linearLayout;
        this.tvScanTips = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityQrCodeScanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityQrCodeScanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_qr_code_scan, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityQrCodeScanBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.animation_line;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.flash_switch;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                if (checkBox != null) {
                    i = R.id.layout_scan;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = R.id.ll_preview;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.tv_scan_tips;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new ActivityQrCodeScanBinding((FrameLayout) view, actionBarWidget, imageView, checkBox, frameLayout, linearLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
