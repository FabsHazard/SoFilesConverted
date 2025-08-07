package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityTransmitterBinding implements ViewBinding {
    public final ActionBarWidget actionbarTransmitter;
    public final ConstraintLayout clDesc;
    public final ConstraintLayout clMyTrans;
    public final ConstraintLayout clOthers;
    public final ConstraintLayout clOthersDesc;
    public final ImageView ivRefreshScan;
    public final ImageView ivScanningTip;
    public final ItemTransmitterBinding layoutMyTrans;
    public final TextView noDevice;
    private final LinearLayout rootView;
    public final RecyclerView rvOtherTrans;
    public final TextView tvHistoryDevice;
    public final TextView tvMyTrans;
    public final TextView tvOtherTrans;
    public final TextView tvPlsSelectTrans;

    private ActivityTransmitterBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, ImageView imageView2, ItemTransmitterBinding itemTransmitterBinding, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.actionbarTransmitter = actionBarWidget;
        this.clDesc = constraintLayout;
        this.clMyTrans = constraintLayout2;
        this.clOthers = constraintLayout3;
        this.clOthersDesc = constraintLayout4;
        this.ivRefreshScan = imageView;
        this.ivScanningTip = imageView2;
        this.layoutMyTrans = itemTransmitterBinding;
        this.noDevice = textView;
        this.rvOtherTrans = recyclerView;
        this.tvHistoryDevice = textView2;
        this.tvMyTrans = textView3;
        this.tvOtherTrans = textView4;
        this.tvPlsSelectTrans = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTransmitterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTransmitterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_transmitter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.microtech.aidexx.R.id.layout_my_trans;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ActivityTransmitterBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.microtech.aidexx.R.id.actionbar_transmitter
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.microtech.aidexx.views.ActionBarWidget r5 = (com.microtech.aidexx.views.ActionBarWidget) r5
            if (r5 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.cl_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.cl_my_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.cl_others
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.cl_others_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.iv_refresh_scan
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.iv_scanning_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.layout_my_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00aa
            com.microtech.aidexx.databinding.ItemTransmitterBinding r12 = com.microtech.aidexx.databinding.ItemTransmitterBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.no_device
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.rv_other_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            if (r14 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.tv_history_device
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.tv_my_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.tv_other_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00aa
            int r1 = com.microtech.aidexx.R.id.tv_pls_select_trans
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00aa
            com.microtech.aidexx.databinding.ActivityTransmitterBinding r1 = new com.microtech.aidexx.databinding.ActivityTransmitterBinding
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00aa:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ActivityTransmitterBinding.bind(android.view.View):com.microtech.aidexx.databinding.ActivityTransmitterBinding");
    }
}
