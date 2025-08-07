package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class FragmentWarmingUpBinding implements ViewBinding {
    public final View bgPanel;
    public final View bgPanelBlank;
    public final Guideline guideLine;
    public final ConstraintLayout panelWarmUp;
    private final ConstraintLayout rootView;
    public final TextView tvRemain;
    public final TextView tvStates;
    public final TextView tvUnit;
    public final TextView tvWarmingUp;

    private FragmentWarmingUpBinding(ConstraintLayout constraintLayout, View view, View view2, Guideline guideline, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.bgPanel = view;
        this.bgPanelBlank = view2;
        this.guideLine = guideline;
        this.panelWarmUp = constraintLayout2;
        this.tvRemain = textView;
        this.tvStates = textView2;
        this.tvUnit = textView3;
        this.tvWarmingUp = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWarmingUpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentWarmingUpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_warming_up, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.microtech.aidexx.R.id.bg_panel_blank;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.FragmentWarmingUpBinding bind(android.view.View r11) {
        /*
            int r0 = com.microtech.aidexx.R.id.bg_panel
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r3 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.bg_panel_blank
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r4 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.guide_line
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            androidx.constraintlayout.widget.Guideline r5 = (androidx.constraintlayout.widget.Guideline) r5
            if (r5 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.panel_warm_up
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.tv_remain
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.tv_states
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.tv_unit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.tv_warming_up
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005c
            com.microtech.aidexx.databinding.FragmentWarmingUpBinding r0 = new com.microtech.aidexx.databinding.FragmentWarmingUpBinding
            r2 = r11
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x005c:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.FragmentWarmingUpBinding.bind(android.view.View):com.microtech.aidexx.databinding.FragmentWarmingUpBinding");
    }
}
