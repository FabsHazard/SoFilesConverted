package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.roundview.RoundLinearLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityDiabetesInfoConfigBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final RoundLinearLayout llComplications;
    public final RoundLinearLayout llDiagnosisDate;
    public final RoundLinearLayout llTreat;
    public final RoundLinearLayout llType;
    private final ConstraintLayout rootView;
    public final TextView tvComplications;
    public final TextView tvDiagnosisDate;
    public final TextView tvDiagnosisType;
    public final TextView tvSave;
    public final TextView tvTreatment;

    private ActivityDiabetesInfoConfigBinding(ConstraintLayout constraintLayout, ActionBarWidget actionBarWidget, RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, RoundLinearLayout roundLinearLayout3, RoundLinearLayout roundLinearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.actionBar = actionBarWidget;
        this.llComplications = roundLinearLayout;
        this.llDiagnosisDate = roundLinearLayout2;
        this.llTreat = roundLinearLayout3;
        this.llType = roundLinearLayout4;
        this.tvComplications = textView;
        this.tvDiagnosisDate = textView2;
        this.tvDiagnosisType = textView3;
        this.tvSave = textView4;
        this.tvTreatment = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDiabetesInfoConfigBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDiabetesInfoConfigBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_diabetes_info_config, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDiabetesInfoConfigBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.llComplications;
            RoundLinearLayout roundLinearLayout = (RoundLinearLayout) ViewBindings.findChildViewById(view, i);
            if (roundLinearLayout != null) {
                i = R.id.llDiagnosisDate;
                RoundLinearLayout roundLinearLayout2 = (RoundLinearLayout) ViewBindings.findChildViewById(view, i);
                if (roundLinearLayout2 != null) {
                    i = R.id.llTreat;
                    RoundLinearLayout roundLinearLayout3 = (RoundLinearLayout) ViewBindings.findChildViewById(view, i);
                    if (roundLinearLayout3 != null) {
                        i = R.id.llType;
                        RoundLinearLayout roundLinearLayout4 = (RoundLinearLayout) ViewBindings.findChildViewById(view, i);
                        if (roundLinearLayout4 != null) {
                            i = R.id.tvComplications;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tvDiagnosisDate;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.tvDiagnosisType;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.tvSave;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.tvTreatment;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new ActivityDiabetesInfoConfigBinding((ConstraintLayout) view, actionBarWidget, roundLinearLayout, roundLinearLayout2, roundLinearLayout3, roundLinearLayout4, textView, textView2, textView3, textView4, textView5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
