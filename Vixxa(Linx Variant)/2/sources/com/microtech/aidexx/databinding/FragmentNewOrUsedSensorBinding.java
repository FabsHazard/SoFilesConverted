package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class FragmentNewOrUsedSensorBinding implements ViewBinding {
    public final TextView buttonNewSensor;
    public final TextView buttonOldSensor;
    public final LinearLayout llAutoNew;
    public final LinearLayout llNewOrUsed;
    private final ConstraintLayout rootView;
    public final TextView tvSensorRecognize;

    private FragmentNewOrUsedSensorBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonNewSensor = textView;
        this.buttonOldSensor = textView2;
        this.llAutoNew = linearLayout;
        this.llNewOrUsed = linearLayout2;
        this.tvSensorRecognize = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNewOrUsedSensorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentNewOrUsedSensorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_new_or_used_sensor, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentNewOrUsedSensorBinding bind(View view) {
        int i = R.id.button_new_sensor;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.button_old_sensor;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.ll_auto_new;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.ll_new_or_used;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.tv_sensor_recognize;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new FragmentNewOrUsedSensorBinding((ConstraintLayout) view, textView, textView2, linearLayout, linearLayout2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
