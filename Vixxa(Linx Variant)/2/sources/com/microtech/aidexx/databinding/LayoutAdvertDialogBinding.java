package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class LayoutAdvertDialogBinding implements ViewBinding {
    public final ImageView ivClose;
    public final ImageView ivDetail;
    private final ConstraintLayout rootView;

    private LayoutAdvertDialogBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.ivClose = imageView;
        this.ivDetail = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutAdvertDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutAdvertDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_advert_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutAdvertDialogBinding bind(View view) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_detail;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                return new LayoutAdvertDialogBinding((ConstraintLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
