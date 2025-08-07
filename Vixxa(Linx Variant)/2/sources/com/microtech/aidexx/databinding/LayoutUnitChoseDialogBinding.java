package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class LayoutUnitChoseDialogBinding implements ViewBinding {
    public final TextView buttonConfirm;
    public final ConstraintLayout clUnitOption;
    public final RadioButton rbMg;
    public final RadioButton rbMmol;
    public final RadioGroup rgUnits;
    private final ConstraintLayout rootView;
    public final TextView tvDialogTitleUnitChose;

    private LayoutUnitChoseDialogBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TextView textView2) {
        this.rootView = constraintLayout;
        this.buttonConfirm = textView;
        this.clUnitOption = constraintLayout2;
        this.rbMg = radioButton;
        this.rbMmol = radioButton2;
        this.rgUnits = radioGroup;
        this.tvDialogTitleUnitChose = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutUnitChoseDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutUnitChoseDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_unit_chose_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutUnitChoseDialogBinding bind(View view) {
        int i = R.id.button_confirm;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.cl_unit_option;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.rb_mg;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, i);
                if (radioButton != null) {
                    i = R.id.rb_mmol;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, i);
                    if (radioButton2 != null) {
                        i = R.id.rg_units;
                        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, i);
                        if (radioGroup != null) {
                            i = R.id.tv_dialog_title_unit_chose;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new LayoutUnitChoseDialogBinding((ConstraintLayout) view, textView, constraintLayout, radioButton, radioButton2, radioGroup, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
