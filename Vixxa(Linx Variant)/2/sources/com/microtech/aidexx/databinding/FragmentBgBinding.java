package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.button.StateButton;

public final class FragmentBgBinding implements ViewBinding {
    public final StateButton buttonCalibration;
    public final StateButton buttonRecord;
    public final AppCompatEditText etGlucoseValue;
    public final ConstraintLayout layoutActionbar;
    public final ItemGlucoseHistoryBgBinding llBgRecode;
    private final LinearLayout rootView;
    public final RecyclerView rvTimeSlop;
    public final TextView slopTitle;
    public final TextView tvGlucoseTimeText;
    public final TextView tvGlucoseUnit;
    public final TextView tvGlucoseValueText;
    public final TextView tvHistoryRecord;
    public final TextView tvMoreHistory;
    public final TextView tvNoneRecord;
    public final TextView tvTime;
    public final TextView tvTrendsTitle;

    private FragmentBgBinding(LinearLayout linearLayout, StateButton stateButton, StateButton stateButton2, AppCompatEditText appCompatEditText, ConstraintLayout constraintLayout, ItemGlucoseHistoryBgBinding itemGlucoseHistoryBgBinding, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = linearLayout;
        this.buttonCalibration = stateButton;
        this.buttonRecord = stateButton2;
        this.etGlucoseValue = appCompatEditText;
        this.layoutActionbar = constraintLayout;
        this.llBgRecode = itemGlucoseHistoryBgBinding;
        this.rvTimeSlop = recyclerView;
        this.slopTitle = textView;
        this.tvGlucoseTimeText = textView2;
        this.tvGlucoseUnit = textView3;
        this.tvGlucoseValueText = textView4;
        this.tvHistoryRecord = textView5;
        this.tvMoreHistory = textView6;
        this.tvNoneRecord = textView7;
        this.tvTime = textView8;
        this.tvTrendsTitle = textView9;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentBgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bg, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.microtech.aidexx.R.id.ll_bg_recode;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.FragmentBgBinding bind(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.microtech.aidexx.R.id.button_calibration
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.microtech.aidexx.views.button.StateButton r5 = (com.microtech.aidexx.views.button.StateButton) r5
            if (r5 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.button_record
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.microtech.aidexx.views.button.StateButton r6 = (com.microtech.aidexx.views.button.StateButton) r6
            if (r6 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.et_glucose_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.appcompat.widget.AppCompatEditText r7 = (androidx.appcompat.widget.AppCompatEditText) r7
            if (r7 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.layout_actionbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.ll_bg_recode
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00b6
            com.microtech.aidexx.databinding.ItemGlucoseHistoryBgBinding r9 = com.microtech.aidexx.databinding.ItemGlucoseHistoryBgBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.rv_time_slop
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            if (r10 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.slop_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tvGlucoseTimeText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tv_glucose_unit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tvGlucoseValueText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tvHistoryRecord
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tvMoreHistory
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tv_none_record
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tv_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00b6
            int r1 = com.microtech.aidexx.R.id.tv_trends_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00b6
            com.microtech.aidexx.databinding.FragmentBgBinding r1 = new com.microtech.aidexx.databinding.FragmentBgBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x00b6:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.FragmentBgBinding.bind(android.view.View):com.microtech.aidexx.databinding.FragmentBgBinding");
    }
}
