package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class ScanDeviceTipDialogBinding implements ViewBinding {
    public final TextView buttonConfirm;
    public final ConstraintLayout content;
    public final View dialogDivider;
    public final ConstraintLayout llBtn;
    private final ConstraintLayout rootView;
    public final ImageView tipImgR;
    public final TextView tipOr;
    public final TextView title;

    private ScanDeviceTipDialogBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, View view, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonConfirm = textView;
        this.content = constraintLayout2;
        this.dialogDivider = view;
        this.llBtn = constraintLayout3;
        this.tipImgR = imageView;
        this.tipOr = textView2;
        this.title = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ScanDeviceTipDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ScanDeviceTipDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.scan_device_tip_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.microtech.aidexx.R.id.dialog_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ScanDeviceTipDialogBinding bind(android.view.View r11) {
        /*
            int r0 = com.microtech.aidexx.R.id.button_confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0054
            int r0 = com.microtech.aidexx.R.id.content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0054
            int r0 = com.microtech.aidexx.R.id.dialog_divider
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r6 == 0) goto L_0x0054
            int r0 = com.microtech.aidexx.R.id.ll_btn
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0054
            int r0 = com.microtech.aidexx.R.id.tip_img_r
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0054
            int r0 = com.microtech.aidexx.R.id.tip_or
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0054
            int r0 = com.microtech.aidexx.R.id.title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0054
            com.microtech.aidexx.databinding.ScanDeviceTipDialogBinding r0 = new com.microtech.aidexx.databinding.ScanDeviceTipDialogBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ScanDeviceTipDialogBinding.bind(android.view.View):com.microtech.aidexx.databinding.ScanDeviceTipDialogBinding");
    }
}
