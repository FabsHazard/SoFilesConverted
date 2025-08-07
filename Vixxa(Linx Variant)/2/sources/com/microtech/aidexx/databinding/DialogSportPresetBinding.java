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
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;

public final class DialogSportPresetBinding implements ViewBinding {
    public final RoundTextView btnCancel;
    public final RoundTextView btnOk;
    public final EditText etDuration;
    public final Guideline glDivider;
    public final Guideline glPercent;
    public final ImageView ivDelete;
    public final TextView labelQuality;
    public final TextView labelUnit;
    private final ConstraintLayout rootView;
    public final RecyclerView rvSpecification;
    public final TextView tvCategoryName;
    public final View viTag;

    private DialogSportPresetBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, RoundTextView roundTextView2, EditText editText, Guideline guideline, Guideline guideline2, ImageView imageView, TextView textView, TextView textView2, RecyclerView recyclerView, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.btnCancel = roundTextView;
        this.btnOk = roundTextView2;
        this.etDuration = editText;
        this.glDivider = guideline;
        this.glPercent = guideline2;
        this.ivDelete = imageView;
        this.labelQuality = textView;
        this.labelUnit = textView2;
        this.rvSpecification = recyclerView;
        this.tvCategoryName = textView3;
        this.viTag = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogSportPresetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogSportPresetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sport_preset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        r0 = com.microtech.aidexx.R.id.viTag;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.DialogSportPresetBinding bind(android.view.View r15) {
        /*
            int r0 = com.microtech.aidexx.R.id.btnCancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.btnOk
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.et_duration
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            android.widget.EditText r6 = (android.widget.EditText) r6
            if (r6 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.glDivider
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            androidx.constraintlayout.widget.Guideline r7 = (androidx.constraintlayout.widget.Guideline) r7
            if (r7 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.glPercent
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            androidx.constraintlayout.widget.Guideline r8 = (androidx.constraintlayout.widget.Guideline) r8
            if (r8 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.ivDelete
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.labelQuality
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.labelUnit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.rvSpecification
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.tvCategoryName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0080
            int r0 = com.microtech.aidexx.R.id.viTag
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r14 == 0) goto L_0x0080
            com.microtech.aidexx.databinding.DialogSportPresetBinding r0 = new com.microtech.aidexx.databinding.DialogSportPresetBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0080:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.DialogSportPresetBinding.bind(android.view.View):com.microtech.aidexx.databinding.DialogSportPresetBinding");
    }
}
