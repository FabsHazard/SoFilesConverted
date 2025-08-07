package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ItemGlucoseHistoryBgBinding implements ViewBinding {
    public final View glucoseHistoryDivider;
    public final LinearLayout llContainer;
    private final LinearLayout rootView;
    public final TextView tvGlucoseDescribe;
    public final TextView tvGlucoseRecordValue;
    public final TextView tvGlucoseTime;

    private ItemGlucoseHistoryBgBinding(LinearLayout linearLayout, View view, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.glucoseHistoryDivider = view;
        this.llContainer = linearLayout2;
        this.tvGlucoseDescribe = textView;
        this.tvGlucoseRecordValue = textView2;
        this.tvGlucoseTime = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemGlucoseHistoryBgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemGlucoseHistoryBgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_glucose_history_bg, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemGlucoseHistoryBgBinding bind(View view) {
        int i = R.id.glucose_history_divider;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.tv_glucose_describe;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_glucose_record_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_glucose_time;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new ItemGlucoseHistoryBgBinding(linearLayout, findChildViewById, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
