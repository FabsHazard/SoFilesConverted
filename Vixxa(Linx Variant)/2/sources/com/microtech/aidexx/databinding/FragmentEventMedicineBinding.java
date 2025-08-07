package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.flyco.roundview.RoundTextView;
import com.lihang.ShadowLayout;
import com.microtech.aidexx.R;

public final class FragmentEventMedicineBinding implements ViewBinding {
    public final RoundTextView btSaveMedicine;
    public final EditText etMedicineName;
    public final LinearLayout llMedicineHistory;
    public final View medicineDivider1;
    public final View medicineDivider2;
    public final View medicineDivider3;
    private final ConstraintLayout rootView;
    public final RecyclerView rvMedicineFoods;
    public final RecyclerView rvMedicineHistory;
    public final RecyclerView rvMedicinePreset;
    public final ShadowLayout slMedicinePreset;
    public final TextView tvMedicineHistoryTitle;
    public final TextView tvMedicineNameTitle;
    public final TextView tvMedicineNoRecord;
    public final TextView tvMedicineTime;
    public final TextView tvMedicineTimeTitle;
    public final TextView tvMedicineType;
    public final TextView tvMedicineTypeTitle;

    private FragmentEventMedicineBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, EditText editText, LinearLayout linearLayout, View view, View view2, View view3, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, ShadowLayout shadowLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.btSaveMedicine = roundTextView;
        this.etMedicineName = editText;
        this.llMedicineHistory = linearLayout;
        this.medicineDivider1 = view;
        this.medicineDivider2 = view2;
        this.medicineDivider3 = view3;
        this.rvMedicineFoods = recyclerView;
        this.rvMedicineHistory = recyclerView2;
        this.rvMedicinePreset = recyclerView3;
        this.slMedicinePreset = shadowLayout;
        this.tvMedicineHistoryTitle = textView;
        this.tvMedicineNameTitle = textView2;
        this.tvMedicineNoRecord = textView3;
        this.tvMedicineTime = textView4;
        this.tvMedicineTimeTitle = textView5;
        this.tvMedicineType = textView6;
        this.tvMedicineTypeTitle = textView7;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEventMedicineBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentEventMedicineBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event_medicine, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        r1 = com.microtech.aidexx.R.id.medicine_divider3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.microtech.aidexx.R.id.medicine_divider1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        r1 = com.microtech.aidexx.R.id.medicine_divider2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.FragmentEventMedicineBinding bind(android.view.View r22) {
        /*
            r0 = r22
            int r1 = com.microtech.aidexx.R.id.bt_save_medicine
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.et_medicine_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.EditText r6 = (android.widget.EditText) r6
            if (r6 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.ll_medicine_history
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.medicine_divider1
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.medicine_divider2
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.medicine_divider3
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.rv_medicine_foods
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.rv_medicine_history
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.rv_medicine_preset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.recyclerview.widget.RecyclerView r13 = (androidx.recyclerview.widget.RecyclerView) r13
            if (r13 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.slMedicinePreset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.lihang.ShadowLayout r14 = (com.lihang.ShadowLayout) r14
            if (r14 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tv_medicine_history_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tv_medicine_name_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tv_medicine_no_record
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tv_medicine_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tv_medicine_time_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tv_medicine_type
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tv_medicine_type_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00c4
            com.microtech.aidexx.databinding.FragmentEventMedicineBinding r1 = new com.microtech.aidexx.databinding.FragmentEventMedicineBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r1
        L_0x00c4:
            android.content.res.Resources r0 = r22.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.FragmentEventMedicineBinding.bind(android.view.View):com.microtech.aidexx.databinding.FragmentEventMedicineBinding");
    }
}
