package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class PairCheckDialogBinding implements ViewBinding {
    public final TextView btnReselect;
    public final ConstraintLayout clPairCheckDialog;
    public final ConstraintLayout clPairTipContent;
    public final ConstraintLayout clReselect;
    public final EditText etVerCode;
    public final ImageView ivClosePairCheck;
    public final TextView pairTips;
    public final View pairTipsLine;
    private final ConstraintLayout rootView;
    public final TextView tvNotSame;

    private PairCheckDialogBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, EditText editText, ImageView imageView, TextView textView2, View view, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnReselect = textView;
        this.clPairCheckDialog = constraintLayout2;
        this.clPairTipContent = constraintLayout3;
        this.clReselect = constraintLayout4;
        this.etVerCode = editText;
        this.ivClosePairCheck = imageView;
        this.pairTips = textView2;
        this.pairTipsLine = view;
        this.tvNotSame = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PairCheckDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static PairCheckDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pair_check_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = com.microtech.aidexx.R.id.pair_tips_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.PairCheckDialogBinding bind(android.view.View r13) {
        /*
            int r0 = com.microtech.aidexx.R.id.btn_reselect
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.cl_pair_check_dialog
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.cl_pair_tip_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.cl_reselect
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.et_ver_code
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.EditText r8 = (android.widget.EditText) r8
            if (r8 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.iv_close_pair_check
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.pair_tips
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.pair_tips_line
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r11 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.tv_not_same
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006a
            com.microtech.aidexx.databinding.PairCheckDialogBinding r0 = new com.microtech.aidexx.databinding.PairCheckDialogBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006a:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.PairCheckDialogBinding.bind(android.view.View):com.microtech.aidexx.databinding.PairCheckDialogBinding");
    }
}
