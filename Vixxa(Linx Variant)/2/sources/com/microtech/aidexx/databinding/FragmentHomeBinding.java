package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.main.home.customerservice.CustomerServiceView;
import com.microtech.aidexx.ui.main.home.timetab.TimeTabLayout;
import com.microtech.aidexx.views.chart.GlucoseChart;

public final class FragmentHomeBinding implements ViewBinding {
    public final View bottomSpace;
    public final GlucoseChart chart;
    public final TextView chartDateTip;
    public final TextView dataOwner;
    public final TextView descriptionTvContent;
    public final TextView descriptionTvTime;
    public final TextView descriptionTvUnit;
    public final TextView descriptionTvValue;
    public final LinearLayout descriptions;
    public final FragmentContainerView fcvPanel;
    public final FragmentGlucoseShareBinding frgShare;
    public final ConstraintLayout function;
    public final ImageView goToHistory;
    public final ImageView homeLogo;
    public final ConstraintLayout homeRoot;
    public final TimeTabLayout homeTimeTab;
    public final ImageView ivBack;
    public final ImageView ivConnectState;
    public final ImageView ivScale;
    public final ConstraintLayout layoutActionbar;
    public final ConstraintLayout layoutChart;
    public final RelativeLayout layoutState;
    public final ConstraintLayout llChart;
    public final LinearLayout llDescValue;
    public final RelativeLayout rlDescription;
    private final ConstraintLayout rootView;
    public final CustomerServiceView serviceView;
    public final ImageView switchUserData;
    public final View touchView;
    public final TextView tvSn;
    public final TextView tvXTime;
    public final ImageView userCenter;
    public final ImageView welfareCenter;

    private FragmentHomeBinding(ConstraintLayout constraintLayout, View view, GlucoseChart glucoseChart, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout, FragmentContainerView fragmentContainerView, FragmentGlucoseShareBinding fragmentGlucoseShareBinding, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, TimeTabLayout timeTabLayout, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, RelativeLayout relativeLayout, ConstraintLayout constraintLayout6, LinearLayout linearLayout2, RelativeLayout relativeLayout2, CustomerServiceView customerServiceView, ImageView imageView6, View view2, TextView textView7, TextView textView8, ImageView imageView7, ImageView imageView8) {
        this.rootView = constraintLayout;
        this.bottomSpace = view;
        this.chart = glucoseChart;
        this.chartDateTip = textView;
        this.dataOwner = textView2;
        this.descriptionTvContent = textView3;
        this.descriptionTvTime = textView4;
        this.descriptionTvUnit = textView5;
        this.descriptionTvValue = textView6;
        this.descriptions = linearLayout;
        this.fcvPanel = fragmentContainerView;
        this.frgShare = fragmentGlucoseShareBinding;
        this.function = constraintLayout2;
        this.goToHistory = imageView;
        this.homeLogo = imageView2;
        this.homeRoot = constraintLayout3;
        this.homeTimeTab = timeTabLayout;
        this.ivBack = imageView3;
        this.ivConnectState = imageView4;
        this.ivScale = imageView5;
        this.layoutActionbar = constraintLayout4;
        this.layoutChart = constraintLayout5;
        this.layoutState = relativeLayout;
        this.llChart = constraintLayout6;
        this.llDescValue = linearLayout2;
        this.rlDescription = relativeLayout2;
        this.serviceView = customerServiceView;
        this.switchUserData = imageView6;
        this.touchView = view2;
        this.tvSn = textView7;
        this.tvXTime = textView8;
        this.userCenter = imageView7;
        this.welfareCenter = imageView8;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r1 = com.microtech.aidexx.R.id.frg_share;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0130, code lost:
        r1 = com.microtech.aidexx.R.id.touchView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.FragmentHomeBinding bind(android.view.View r36) {
        /*
            r0 = r36
            int r1 = com.microtech.aidexx.R.id.bottom_space
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.chart
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.microtech.aidexx.views.chart.GlucoseChart r5 = (com.microtech.aidexx.views.chart.GlucoseChart) r5
            if (r5 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.chartDateTip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.data_owner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.description_tv_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.description_tv_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.description_tv_unit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.description_tv_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.descriptions
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.fcv_panel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.fragment.app.FragmentContainerView r13 = (androidx.fragment.app.FragmentContainerView) r13
            if (r13 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.frg_share
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x0171
            com.microtech.aidexx.databinding.FragmentGlucoseShareBinding r14 = com.microtech.aidexx.databinding.FragmentGlucoseShareBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.function
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.go_to_history
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.home_logo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x0171
            r18 = r0
            androidx.constraintlayout.widget.ConstraintLayout r18 = (androidx.constraintlayout.widget.ConstraintLayout) r18
            int r1 = com.microtech.aidexx.R.id.home_time_tab
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.microtech.aidexx.ui.main.home.timetab.TimeTabLayout r19 = (com.microtech.aidexx.ui.main.home.timetab.TimeTabLayout) r19
            if (r19 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.iv_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.iv_connect_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.ImageView r21 = (android.widget.ImageView) r21
            if (r21 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.iv_scale
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            if (r22 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.layout_actionbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            androidx.constraintlayout.widget.ConstraintLayout r23 = (androidx.constraintlayout.widget.ConstraintLayout) r23
            if (r23 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.layout_chart
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            androidx.constraintlayout.widget.ConstraintLayout r24 = (androidx.constraintlayout.widget.ConstraintLayout) r24
            if (r24 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.layout_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.RelativeLayout r25 = (android.widget.RelativeLayout) r25
            if (r25 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.ll_chart
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            androidx.constraintlayout.widget.ConstraintLayout r26 = (androidx.constraintlayout.widget.ConstraintLayout) r26
            if (r26 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.ll_desc_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.LinearLayout r27 = (android.widget.LinearLayout) r27
            if (r27 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.rl_description
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.RelativeLayout r28 = (android.widget.RelativeLayout) r28
            if (r28 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.service_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            com.microtech.aidexx.ui.main.home.customerservice.CustomerServiceView r29 = (com.microtech.aidexx.ui.main.home.customerservice.CustomerServiceView) r29
            if (r29 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.switch_user_data
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.ImageView r30 = (android.widget.ImageView) r30
            if (r30 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.touchView
            android.view.View r31 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r31 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.tv_sn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.tv_x_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.TextView r33 = (android.widget.TextView) r33
            if (r33 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.user_center
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.ImageView r34 = (android.widget.ImageView) r34
            if (r34 == 0) goto L_0x0171
            int r1 = com.microtech.aidexx.R.id.welfare_center
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            android.widget.ImageView r35 = (android.widget.ImageView) r35
            if (r35 == 0) goto L_0x0171
            com.microtech.aidexx.databinding.FragmentHomeBinding r0 = new com.microtech.aidexx.databinding.FragmentHomeBinding
            r2 = r0
            r3 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            return r0
        L_0x0171:
            android.content.res.Resources r0 = r36.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.FragmentHomeBinding.bind(android.view.View):com.microtech.aidexx.databinding.FragmentHomeBinding");
    }
}
