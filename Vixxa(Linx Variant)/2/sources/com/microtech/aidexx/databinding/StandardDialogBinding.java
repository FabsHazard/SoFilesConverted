package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.dialog.standard.RemeasureTextView;

public final class StandardDialogBinding implements ViewBinding {
    public final TextView buttonCancel;
    public final TextView buttonConfirm;
    public final RemeasureTextView content;
    public final View dialogDivider;
    public final ConstraintLayout llBtn;
    public final RemeasureTextView note;
    private final ConstraintLayout rootView;
    public final View stick;
    public final TextView title;

    private StandardDialogBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, RemeasureTextView remeasureTextView, View view, ConstraintLayout constraintLayout2, RemeasureTextView remeasureTextView2, View view2, TextView textView3) {
        this.rootView = constraintLayout;
        this.buttonCancel = textView;
        this.buttonConfirm = textView2;
        this.content = remeasureTextView;
        this.dialogDivider = view;
        this.llBtn = constraintLayout2;
        this.note = remeasureTextView2;
        this.stick = view2;
        this.title = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StandardDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StandardDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.standard_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r0 = com.microtech.aidexx.R.id.stick;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.microtech.aidexx.R.id.dialog_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.StandardDialogBinding bind(android.view.View r12) {
        /*
            int r0 = com.microtech.aidexx.R.id.button_cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.button_confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            com.microtech.aidexx.views.dialog.standard.RemeasureTextView r6 = (com.microtech.aidexx.views.dialog.standard.RemeasureTextView) r6
            if (r6 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.dialog_divider
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r7 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.ll_btn
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.note
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            com.microtech.aidexx.views.dialog.standard.RemeasureTextView r9 = (com.microtech.aidexx.views.dialog.standard.RemeasureTextView) r9
            if (r9 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.stick
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r10 == 0) goto L_0x005c
            int r0 = com.microtech.aidexx.R.id.title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005c
            com.microtech.aidexx.databinding.StandardDialogBinding r0 = new com.microtech.aidexx.databinding.StandardDialogBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x005c:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.StandardDialogBinding.bind(android.view.View):com.microtech.aidexx.databinding.StandardDialogBinding");
    }
}
