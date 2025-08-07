package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.dialog.standard.RemeasureTextView;

public final class SignalLostCheckDialogBinding implements ViewBinding {
    public final TextView buttonCancel;
    public final TextView buttonConfirm;
    public final RemeasureTextView content;
    public final View dialogDivider;
    public final ConstraintLayout llBtn;
    private final ConstraintLayout rootView;
    public final View stick;

    private SignalLostCheckDialogBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, RemeasureTextView remeasureTextView, View view, ConstraintLayout constraintLayout2, View view2) {
        this.rootView = constraintLayout;
        this.buttonCancel = textView;
        this.buttonConfirm = textView2;
        this.content = remeasureTextView;
        this.dialogDivider = view;
        this.llBtn = constraintLayout2;
        this.stick = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SignalLostCheckDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static SignalLostCheckDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.signal_lost_check_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        r0 = com.microtech.aidexx.R.id.stick;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.microtech.aidexx.R.id.dialog_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.SignalLostCheckDialogBinding bind(android.view.View r10) {
        /*
            int r0 = com.microtech.aidexx.R.id.button_cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0046
            int r0 = com.microtech.aidexx.R.id.button_confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0046
            int r0 = com.microtech.aidexx.R.id.content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            com.microtech.aidexx.views.dialog.standard.RemeasureTextView r6 = (com.microtech.aidexx.views.dialog.standard.RemeasureTextView) r6
            if (r6 == 0) goto L_0x0046
            int r0 = com.microtech.aidexx.R.id.dialog_divider
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r7 == 0) goto L_0x0046
            int r0 = com.microtech.aidexx.R.id.ll_btn
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0046
            int r0 = com.microtech.aidexx.R.id.stick
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r9 == 0) goto L_0x0046
            com.microtech.aidexx.databinding.SignalLostCheckDialogBinding r0 = new com.microtech.aidexx.databinding.SignalLostCheckDialogBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0046:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.SignalLostCheckDialogBinding.bind(android.view.View):com.microtech.aidexx.databinding.SignalLostCheckDialogBinding");
    }
}
