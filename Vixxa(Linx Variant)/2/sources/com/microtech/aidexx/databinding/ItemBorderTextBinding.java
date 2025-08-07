package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;

public final class ItemBorderTextBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final RoundTextView tvContent;

    private ItemBorderTextBinding(FrameLayout frameLayout, RoundTextView roundTextView) {
        this.rootView = frameLayout;
        this.tvContent = roundTextView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemBorderTextBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemBorderTextBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_border_text, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemBorderTextBinding bind(View view) {
        int i = R.id.tvContent;
        RoundTextView roundTextView = (RoundTextView) ViewBindings.findChildViewById(view, i);
        if (roundTextView != null) {
            return new ItemBorderTextBinding((FrameLayout) view, roundTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
