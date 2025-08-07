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

public final class WidgetActionBarBinding implements ViewBinding {
    public final ConstraintLayout actionbarRoot;
    public final ImageView ivLeft;
    public final ImageView ivRight;
    public final ImageView ivTitleRight;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;

    private WidgetActionBarBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = constraintLayout;
        this.actionbarRoot = constraintLayout2;
        this.ivLeft = imageView;
        this.ivRight = imageView2;
        this.ivTitleRight = imageView3;
        this.tvTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WidgetActionBarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static WidgetActionBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.widget_action_bar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WidgetActionBarBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_left;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_right;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_title_right;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new WidgetActionBarBinding(constraintLayout, constraintLayout, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
