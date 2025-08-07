package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ActivityWelcomeBinding implements ViewBinding {
    public final ActivityLoadResourceBinding loadResource;
    private final ConstraintLayout rootView;
    public final ConstraintLayout welcomeRoot;
    public final ActivityWelcomeTipBinding welcomeTipViewStub;

    private ActivityWelcomeBinding(ConstraintLayout constraintLayout, ActivityLoadResourceBinding activityLoadResourceBinding, ConstraintLayout constraintLayout2, ActivityWelcomeTipBinding activityWelcomeTipBinding) {
        this.rootView = constraintLayout;
        this.loadResource = activityLoadResourceBinding;
        this.welcomeRoot = constraintLayout2;
        this.welcomeTipViewStub = activityWelcomeTipBinding;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityWelcomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_welcome, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityWelcomeBinding bind(View view) {
        int i = R.id.loadResource;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            ActivityLoadResourceBinding bind = ActivityLoadResourceBinding.bind(findChildViewById);
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.welcomeTipViewStub;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i2);
            if (findChildViewById2 != null) {
                return new ActivityWelcomeBinding(constraintLayout, bind, constraintLayout, ActivityWelcomeTipBinding.bind(findChildViewById2));
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
