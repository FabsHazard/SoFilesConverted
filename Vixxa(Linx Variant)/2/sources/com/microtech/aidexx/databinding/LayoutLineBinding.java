package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class LayoutLineBinding implements ViewBinding {
    private final View rootView;

    private LayoutLineBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static LayoutLineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutLineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_line, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutLineBinding bind(View view) {
        if (view != null) {
            return new LayoutLineBinding(view);
        }
        throw new NullPointerException("rootView");
    }
}
