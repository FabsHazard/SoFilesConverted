package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class LayoutFollowListItemBinding implements ViewBinding {
    public final View bgPanel;
    public final View bgPanelWarmUp;
    public final ImageView ivSelected;
    public final TextView latestValueTime;
    public final TextView leftTime;
    public final ConstraintLayout listFollowRoot;
    public final ConstraintLayout panelGlucose;
    private final ConstraintLayout rootView;
    public final LinearLayoutCompat timeLl;
    public final TextView tvGlucoseValue;
    public final TextView tvUnit;
    public final TextView userName;

    private LayoutFollowListItemBinding(ConstraintLayout constraintLayout, View view, View view2, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayoutCompat linearLayoutCompat, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.bgPanel = view;
        this.bgPanelWarmUp = view2;
        this.ivSelected = imageView;
        this.latestValueTime = textView;
        this.leftTime = textView2;
        this.listFollowRoot = constraintLayout2;
        this.panelGlucose = constraintLayout3;
        this.timeLl = linearLayoutCompat;
        this.tvGlucoseValue = textView3;
        this.tvUnit = textView4;
        this.userName = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutFollowListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutFollowListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_follow_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.microtech.aidexx.R.id.bg_panel_warmUp;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.LayoutFollowListItemBinding bind(android.view.View r14) {
        /*
            int r0 = com.microtech.aidexx.R.id.bg_panel
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r3 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.bg_panel_warmUp
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r4 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.ivSelected
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.latestValueTime
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.leftTime
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0073
            r8 = r14
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            int r0 = com.microtech.aidexx.R.id.panel_glucose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.timeLl
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            androidx.appcompat.widget.LinearLayoutCompat r10 = (androidx.appcompat.widget.LinearLayoutCompat) r10
            if (r10 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.tv_glucose_value
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.tv_unit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.userName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0073
            com.microtech.aidexx.databinding.LayoutFollowListItemBinding r14 = new com.microtech.aidexx.databinding.LayoutFollowListItemBinding
            r1 = r14
            r2 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r14
        L_0x0073:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.LayoutFollowListItemBinding.bind(android.view.View):com.microtech.aidexx.databinding.LayoutFollowListItemBinding");
    }
}
