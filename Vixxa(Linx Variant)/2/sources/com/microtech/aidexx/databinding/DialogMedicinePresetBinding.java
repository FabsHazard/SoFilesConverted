package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;

public final class DialogMedicinePresetBinding implements ViewBinding {
    public final RoundTextView btnCancel;
    public final RoundTextView btnOk;
    public final EditText etDose;
    public final Guideline glDivider;
    public final Guideline glPercent;
    public final ImageView ivDelete;
    public final TextView labelQuality;
    public final TextView labelUnit;
    public final RoundLinearLayout llContainer;
    private final ConstraintLayout rootView;
    public final RecyclerView rvSpecification;
    public final TextView tvCategoryName;
    public final View viTag;
    public final View viWhiteSpace;

    private DialogMedicinePresetBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, RoundTextView roundTextView2, EditText editText, Guideline guideline, Guideline guideline2, ImageView imageView, TextView textView, TextView textView2, RoundLinearLayout roundLinearLayout, RecyclerView recyclerView, TextView textView3, View view, View view2) {
        this.rootView = constraintLayout;
        this.btnCancel = roundTextView;
        this.btnOk = roundTextView2;
        this.etDose = editText;
        this.glDivider = guideline;
        this.glPercent = guideline2;
        this.ivDelete = imageView;
        this.labelQuality = textView;
        this.labelUnit = textView2;
        this.llContainer = roundLinearLayout;
        this.rvSpecification = recyclerView;
        this.tvCategoryName = textView3;
        this.viTag = view;
        this.viWhiteSpace = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogMedicinePresetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogMedicinePresetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_medicine_preset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.microtech.aidexx.R.id.viTag;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
        r1 = com.microtech.aidexx.R.id.viWhiteSpace;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.DialogMedicinePresetBinding bind(android.view.View r18) {
        /*
            r0 = r18
            int r1 = com.microtech.aidexx.R.id.btnCancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.btnOk
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.et_dose
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.EditText r7 = (android.widget.EditText) r7
            if (r7 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.glDivider
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.Guideline r8 = (androidx.constraintlayout.widget.Guideline) r8
            if (r8 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.glPercent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.Guideline r9 = (androidx.constraintlayout.widget.Guideline) r9
            if (r9 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.ivDelete
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.labelQuality
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.labelUnit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.llContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.flyco.roundview.RoundLinearLayout r13 = (com.flyco.roundview.RoundLinearLayout) r13
            if (r13 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.rvSpecification
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            if (r14 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.tvCategoryName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.viTag
            android.view.View r16 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r16 == 0) goto L_0x0095
            int r1 = com.microtech.aidexx.R.id.viWhiteSpace
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r17 == 0) goto L_0x0095
            com.microtech.aidexx.databinding.DialogMedicinePresetBinding r1 = new com.microtech.aidexx.databinding.DialogMedicinePresetBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r1
        L_0x0095:
            android.content.res.Resources r0 = r18.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.DialogMedicinePresetBinding.bind(android.view.View):com.microtech.aidexx.databinding.DialogMedicinePresetBinding");
    }
}
