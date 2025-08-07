package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class LayoutSwitchEditBinding implements ViewBinding {
    public final ConstraintLayout clEditItem;
    public final View editDivider;
    public final TextView editItemInfo;
    public final SwitchCompat editItemSwitch;
    private final ConstraintLayout rootView;
    public final TextView switchEditTitle;

    private LayoutSwitchEditBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, TextView textView, SwitchCompat switchCompat, TextView textView2) {
        this.rootView = constraintLayout;
        this.clEditItem = constraintLayout2;
        this.editDivider = view;
        this.editItemInfo = textView;
        this.editItemSwitch = switchCompat;
        this.switchEditTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSwitchEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutSwitchEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_switch_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutSwitchEditBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.edit_divider;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.edit_item_info;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.edit_item_switch;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, i);
                if (switchCompat != null) {
                    i = R.id.switch_edit_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new LayoutSwitchEditBinding(constraintLayout, constraintLayout, findChildViewById, textView, switchCompat, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
