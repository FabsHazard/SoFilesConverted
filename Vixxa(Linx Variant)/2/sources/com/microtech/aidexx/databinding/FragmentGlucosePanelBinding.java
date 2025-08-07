package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class FragmentGlucosePanelBinding implements ViewBinding {
    public final View bgPanel;
    public final TextView btToPair;
    public final Guideline guideLine;
    public final ConstraintLayout panelGlucose;
    private final ConstraintLayout rootView;
    public final TextView tvGlucoseState;
    public final TextView tvGlucoseValue;
    public final TextView tvSensorRemainTime;
    public final TextView tvUnit;
    public final TextView tvValueTime;

    private FragmentGlucosePanelBinding(ConstraintLayout constraintLayout, View view, TextView textView, Guideline guideline, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.bgPanel = view;
        this.btToPair = textView;
        this.guideLine = guideline;
        this.panelGlucose = constraintLayout2;
        this.tvGlucoseState = textView2;
        this.tvGlucoseValue = textView3;
        this.tvSensorRemainTime = textView4;
        this.tvUnit = textView5;
        this.tvValueTime = textView6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGlucosePanelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentGlucosePanelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glucose_panel, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentGlucosePanelBinding bind(View view) {
        int i = R.id.bg_panel;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.bt_to_pair;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.guide_line;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.panel_glucose;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.tv_glucose_state;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_glucose_value;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.tv_sensor_remain_time;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.tv_unit;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.tv_value_time;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            return new FragmentGlucosePanelBinding((ConstraintLayout) view, findChildViewById, textView, guideline, constraintLayout, textView2, textView3, textView4, textView5, textView6);
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
