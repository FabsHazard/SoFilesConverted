package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ItemTransmitterFooterBinding implements ViewBinding {
    public final CheckBox cbMoreDevice;
    private final ConstraintLayout rootView;

    private ItemTransmitterFooterBinding(ConstraintLayout constraintLayout, CheckBox checkBox) {
        this.rootView = constraintLayout;
        this.cbMoreDevice = checkBox;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTransmitterFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemTransmitterFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_transmitter_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemTransmitterFooterBinding bind(View view) {
        int i = R.id.cb_more_device;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
        if (checkBox != null) {
            return new ItemTransmitterFooterBinding((ConstraintLayout) view, checkBox);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
