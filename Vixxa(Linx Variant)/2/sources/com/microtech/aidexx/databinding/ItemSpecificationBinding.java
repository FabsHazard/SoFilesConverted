package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.roundview.RoundFrameLayout;
import com.microtech.aidexx.R;

public final class ItemSpecificationBinding implements ViewBinding {
    public final RoundFrameLayout flSpecificationContainer;
    private final LinearLayout rootView;
    public final TextView tvSpecification;

    private ItemSpecificationBinding(LinearLayout linearLayout, RoundFrameLayout roundFrameLayout, TextView textView) {
        this.rootView = linearLayout;
        this.flSpecificationContainer = roundFrameLayout;
        this.tvSpecification = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemSpecificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemSpecificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_specification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemSpecificationBinding bind(View view) {
        int i = R.id.flSpecificationContainer;
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) ViewBindings.findChildViewById(view, i);
        if (roundFrameLayout != null) {
            i = R.id.tvSpecification;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new ItemSpecificationBinding((LinearLayout) view, roundFrameLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
