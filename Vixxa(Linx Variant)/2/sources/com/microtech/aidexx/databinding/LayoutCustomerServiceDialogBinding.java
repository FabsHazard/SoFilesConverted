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

public final class LayoutCustomerServiceDialogBinding implements ViewBinding {
    public final ConstraintLayout clOnlineService;
    public final ConstraintLayout clTelService;
    public final LinearLayoutCompat dialogRoot;
    public final ImageView ivCloseServiceDialog;
    public final ImageView ivGoOnline;
    public final TextView myOnlineTitle;
    private final LinearLayoutCompat rootView;
    public final TextView telServiceTitle;
    public final TextView tvDialogMessageUnread;
    public final TextView tvSwitchBack;
    public final View viewLineOne;
    public final View viewLineTwo;

    private LayoutCustomerServiceDialogBinding(LinearLayoutCompat linearLayoutCompat, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayoutCompat linearLayoutCompat2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2) {
        this.rootView = linearLayoutCompat;
        this.clOnlineService = constraintLayout;
        this.clTelService = constraintLayout2;
        this.dialogRoot = linearLayoutCompat2;
        this.ivCloseServiceDialog = imageView;
        this.ivGoOnline = imageView2;
        this.myOnlineTitle = textView;
        this.telServiceTitle = textView2;
        this.tvDialogMessageUnread = textView3;
        this.tvSwitchBack = textView4;
        this.viewLineOne = view;
        this.viewLineTwo = view2;
    }

    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static LayoutCustomerServiceDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutCustomerServiceDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_customer_service_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        r0 = com.microtech.aidexx.R.id.view_line_one;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r0 = com.microtech.aidexx.R.id.view_line_two;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.LayoutCustomerServiceDialogBinding bind(android.view.View r15) {
        /*
            int r0 = com.microtech.aidexx.R.id.cl_online_service
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.cl_tel_service
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0073
            r6 = r15
            androidx.appcompat.widget.LinearLayoutCompat r6 = (androidx.appcompat.widget.LinearLayoutCompat) r6
            int r0 = com.microtech.aidexx.R.id.iv_close_service_dialog
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.iv_go_online
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.my_online_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.tel_service_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.tv_dialog_message_unread
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.tv_switch_back
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.view_line_one
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r13 == 0) goto L_0x0073
            int r0 = com.microtech.aidexx.R.id.view_line_two
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r14 == 0) goto L_0x0073
            com.microtech.aidexx.databinding.LayoutCustomerServiceDialogBinding r15 = new com.microtech.aidexx.databinding.LayoutCustomerServiceDialogBinding
            r2 = r15
            r3 = r6
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x0073:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.LayoutCustomerServiceDialogBinding.bind(android.view.View):com.microtech.aidexx.databinding.LayoutCustomerServiceDialogBinding");
    }
}
