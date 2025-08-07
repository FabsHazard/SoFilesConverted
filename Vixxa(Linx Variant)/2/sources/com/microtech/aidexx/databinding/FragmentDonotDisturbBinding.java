package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class FragmentDonotDisturbBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private FragmentDonotDisturbBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDonotDisturbBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentDonotDisturbBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_donot_disturb, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDonotDisturbBinding bind(View view) {
        if (view != null) {
            return new FragmentDonotDisturbBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }
}
