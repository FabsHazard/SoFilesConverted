package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;

public final class DialogMenuListBinding implements ViewBinding {
    public final RoundTextView btnCancel;
    public final RoundTextView btnOk;
    public final Guideline glDivider;
    public final Guideline glPercent;
    public final RoundLinearLayout llContainer;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMenuList;
    public final TextView tvMultiSelectEnable;
    public final TextView tvTitleName;
    public final View viTag;
    public final View viWhiteSpace;

    private DialogMenuListBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, RoundTextView roundTextView2, Guideline guideline, Guideline guideline2, RoundLinearLayout roundLinearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, View view, View view2) {
        this.rootView = constraintLayout;
        this.btnCancel = roundTextView;
        this.btnOk = roundTextView2;
        this.glDivider = guideline;
        this.glPercent = guideline2;
        this.llContainer = roundLinearLayout;
        this.rvMenuList = recyclerView;
        this.tvMultiSelectEnable = textView;
        this.tvTitleName = textView2;
        this.viTag = view;
        this.viWhiteSpace = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogMenuListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogMenuListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_menu_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.microtech.aidexx.R.id.viTag;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        r0 = com.microtech.aidexx.R.id.viWhiteSpace;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.DialogMenuListBinding bind(android.view.View r14) {
        /*
            int r0 = com.microtech.aidexx.R.id.btnCancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.btnOk
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.glDivider
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            androidx.constraintlayout.widget.Guideline r6 = (androidx.constraintlayout.widget.Guideline) r6
            if (r6 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.glPercent
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            androidx.constraintlayout.widget.Guideline r7 = (androidx.constraintlayout.widget.Guideline) r7
            if (r7 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.llContainer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            com.flyco.roundview.RoundLinearLayout r8 = (com.flyco.roundview.RoundLinearLayout) r8
            if (r8 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.rvMenuList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            if (r9 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.tvMultiSelectEnable
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.tvTitleName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.viTag
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r12 == 0) goto L_0x0072
            int r0 = com.microtech.aidexx.R.id.viWhiteSpace
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            if (r13 == 0) goto L_0x0072
            com.microtech.aidexx.databinding.DialogMenuListBinding r0 = new com.microtech.aidexx.databinding.DialogMenuListBinding
            r3 = r14
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0072:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.DialogMenuListBinding.bind(android.view.View):com.microtech.aidexx.databinding.DialogMenuListBinding");
    }
}
