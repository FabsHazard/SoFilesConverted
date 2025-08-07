package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class LayoutDialogInputBinding implements ViewBinding {
    public final View dialogDivider;
    public final TextView dialogInputCancel;
    public final TextView dialogInputConfirm;
    public final EditText inputDialogEt;
    public final View inputDialogStick;
    public final TextView inputDialogTitle;
    public final ConstraintLayout llBtn;
    private final ConstraintLayout rootView;

    private LayoutDialogInputBinding(ConstraintLayout constraintLayout, View view, TextView textView, TextView textView2, EditText editText, View view2, TextView textView3, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.dialogDivider = view;
        this.dialogInputCancel = textView;
        this.dialogInputConfirm = textView2;
        this.inputDialogEt = editText;
        this.inputDialogStick = view2;
        this.inputDialogTitle = textView3;
        this.llBtn = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDialogInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDialogInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_dialog_input, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.microtech.aidexx.R.id.input_dialog_stick;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.LayoutDialogInputBinding bind(android.view.View r10) {
        /*
            int r0 = com.microtech.aidexx.R.id.dialog_divider
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r3 == 0) goto L_0x0051
            int r0 = com.microtech.aidexx.R.id.dialog_input_cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0051
            int r0 = com.microtech.aidexx.R.id.dialog_input_confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0051
            int r0 = com.microtech.aidexx.R.id.input_dialog_et
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            android.widget.EditText r6 = (android.widget.EditText) r6
            if (r6 == 0) goto L_0x0051
            int r0 = com.microtech.aidexx.R.id.input_dialog_stick
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r7 == 0) goto L_0x0051
            int r0 = com.microtech.aidexx.R.id.input_dialog_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0051
            int r0 = com.microtech.aidexx.R.id.ll_btn
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x0051
            com.microtech.aidexx.databinding.LayoutDialogInputBinding r0 = new com.microtech.aidexx.databinding.LayoutDialogInputBinding
            r2 = r10
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0051:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.LayoutDialogInputBinding.bind(android.view.View):com.microtech.aidexx.databinding.LayoutDialogInputBinding");
    }
}
