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

public final class DialogDietNewPresetBinding implements ViewBinding {
    public final RoundTextView btnCancel;
    public final RoundTextView btnOk;
    public final EditText etCarbohydrate;
    public final EditText etFat;
    public final EditText etProtein;
    public final EditText etWeight;
    public final Guideline glDivider;
    public final Guideline glPercent;
    public final TextView labelCarb;
    public final TextView labelFat;
    public final TextView labelFoodUnit;
    public final TextView labelFoodWeight;
    public final TextView labelProtein;
    public final RoundLinearLayout llContainer;
    private final ConstraintLayout rootView;
    public final RecyclerView rvSpecification;
    public final ImageView tvCategoryDelete;
    public final TextView tvCategoryName;
    public final View viTag;
    public final View viWhiteSpace;

    private DialogDietNewPresetBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, RoundTextView roundTextView2, EditText editText, EditText editText2, EditText editText3, EditText editText4, Guideline guideline, Guideline guideline2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RoundLinearLayout roundLinearLayout, RecyclerView recyclerView, ImageView imageView, TextView textView6, View view, View view2) {
        this.rootView = constraintLayout;
        this.btnCancel = roundTextView;
        this.btnOk = roundTextView2;
        this.etCarbohydrate = editText;
        this.etFat = editText2;
        this.etProtein = editText3;
        this.etWeight = editText4;
        this.glDivider = guideline;
        this.glPercent = guideline2;
        this.labelCarb = textView;
        this.labelFat = textView2;
        this.labelFoodUnit = textView3;
        this.labelFoodWeight = textView4;
        this.labelProtein = textView5;
        this.llContainer = roundLinearLayout;
        this.rvSpecification = recyclerView;
        this.tvCategoryDelete = imageView;
        this.tvCategoryName = textView6;
        this.viTag = view;
        this.viWhiteSpace = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogDietNewPresetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogDietNewPresetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_diet_new_preset, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r1 = com.microtech.aidexx.R.id.viTag;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        r1 = com.microtech.aidexx.R.id.viWhiteSpace;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.DialogDietNewPresetBinding bind(android.view.View r24) {
        /*
            r0 = r24
            int r1 = com.microtech.aidexx.R.id.btnCancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.btnOk
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.et_carbohydrate
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.EditText r7 = (android.widget.EditText) r7
            if (r7 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.et_fat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.EditText r8 = (android.widget.EditText) r8
            if (r8 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.et_protein
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.EditText r9 = (android.widget.EditText) r9
            if (r9 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.et_weight
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.EditText r10 = (android.widget.EditText) r10
            if (r10 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.glDivider
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.Guideline r11 = (androidx.constraintlayout.widget.Guideline) r11
            if (r11 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.glPercent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.Guideline r12 = (androidx.constraintlayout.widget.Guideline) r12
            if (r12 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.labelCarb
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.labelFat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.labelFoodUnit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.labelFoodWeight
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.labelProtein
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.llContainer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.flyco.roundview.RoundLinearLayout r18 = (com.flyco.roundview.RoundLinearLayout) r18
            if (r18 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.rvSpecification
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            androidx.recyclerview.widget.RecyclerView r19 = (androidx.recyclerview.widget.RecyclerView) r19
            if (r19 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.tvCategoryDelete
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.tvCategoryName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.viTag
            android.view.View r22 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r22 == 0) goto L_0x00dd
            int r1 = com.microtech.aidexx.R.id.viWhiteSpace
            android.view.View r23 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r23 == 0) goto L_0x00dd
            com.microtech.aidexx.databinding.DialogDietNewPresetBinding r1 = new com.microtech.aidexx.databinding.DialogDietNewPresetBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r1
        L_0x00dd:
            android.content.res.Resources r0 = r24.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.DialogDietNewPresetBinding.bind(android.view.View):com.microtech.aidexx.databinding.DialogDietNewPresetBinding");
    }
}
