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

public final class FragmentGlucoseShareBinding implements ViewBinding {
    public final View bgPanelShare;
    public final Guideline guideLine;
    public final ConstraintLayout panelGlucoseShare;
    private final ConstraintLayout rootView;
    public final TextView shareCurrentTime;
    public final ConstraintLayout timezoneInfo;
    public final TextView tvGlucoseStateShare;
    public final TextView tvGlucoseValueShare;
    public final TextView tvSensorRemainTimeShare;
    public final TextView tvUnitShare;
    public final TextView tvValueTimeShare;

    private FragmentGlucoseShareBinding(ConstraintLayout constraintLayout, View view, Guideline guideline, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.bgPanelShare = view;
        this.guideLine = guideline;
        this.panelGlucoseShare = constraintLayout2;
        this.shareCurrentTime = textView;
        this.timezoneInfo = constraintLayout3;
        this.tvGlucoseStateShare = textView2;
        this.tvGlucoseValueShare = textView3;
        this.tvSensorRemainTimeShare = textView4;
        this.tvUnitShare = textView5;
        this.tvValueTimeShare = textView6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGlucoseShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentGlucoseShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_glucose_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentGlucoseShareBinding bind(View view) {
        int i = R.id.bg_panel_share;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.guide_line;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                i = R.id.panel_glucose_share;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.share_current_time;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.timezone_info;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.tv_glucose_state_share;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_glucose_value_share;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.tv_sensor_remain_time_share;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_unit_share;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            i = R.id.tv_value_time_share;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                return new FragmentGlucoseShareBinding((ConstraintLayout) view, findChildViewById, guideline, constraintLayout, textView, constraintLayout2, textView2, textView3, textView4, textView5, textView6);
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
