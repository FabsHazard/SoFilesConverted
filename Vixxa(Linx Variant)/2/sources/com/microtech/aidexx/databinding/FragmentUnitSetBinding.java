package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class FragmentUnitSetBinding implements ViewBinding {
    public final RadioButton rbMg;
    public final RadioButton rbMmol;
    public final RadioGroup rgUnits;
    private final ConstraintLayout rootView;

    private FragmentUnitSetBinding(ConstraintLayout constraintLayout, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup) {
        this.rootView = constraintLayout;
        this.rbMg = radioButton;
        this.rbMmol = radioButton2;
        this.rgUnits = radioGroup;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUnitSetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentUnitSetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_unit_set, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentUnitSetBinding bind(View view) {
        int i = R.id.rb_mg;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
        if (radioButton != null) {
            i = R.id.rb_mmol;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
            if (radioButton2 != null) {
                i = R.id.rg_units;
                RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                if (radioGroup != null) {
                    return new FragmentUnitSetBinding((ConstraintLayout) view, radioButton, radioButton2, radioGroup);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
