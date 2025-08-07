package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ActivityLoadResourceBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ImageView splashIcon;
    public final FrameLayout splashIconContainer;

    private ActivityLoadResourceBinding(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.splashIcon = imageView;
        this.splashIconContainer = frameLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoadResourceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLoadResourceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_load_resource, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLoadResourceBinding bind(View view) {
        int i = R.id.splashIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.splashIconContainer;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                return new ActivityLoadResourceBinding((ConstraintLayout) view, imageView, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
