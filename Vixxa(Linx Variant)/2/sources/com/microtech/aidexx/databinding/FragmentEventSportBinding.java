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

public final class FragmentEventSportBinding implements ViewBinding {
    public final RoundTextView btSaveSport;
    public final View dietDivider2;
    public final EditText etSportName;
    public final LinearLayout llSportHistory;
    private final ConstraintLayout rootView;
    public final RecyclerView rvSportHistory;
    public final RecyclerView rvSportPreset;
    public final RecyclerView rvSports;
    public final ShadowLayout slSportPreset;
    public final View sportDivider3;
    public final TextView tvSportHistoryTitle;
    public final TextView tvSportNameTitle;
    public final TextView tvSportNoRecord;
    public final TextView tvSportTime;
    public final TextView tvSportTimeTitle;

    private FragmentEventSportBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, View view, EditText editText, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, ShadowLayout shadowLayout, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btSaveSport = roundTextView;
        this.dietDivider2 = view;
        this.etSportName = editText;
        this.llSportHistory = linearLayout;
        this.rvSportHistory = recyclerView;
        this.rvSportPreset = recyclerView2;
        this.rvSports = recyclerView3;
        this.slSportPreset = shadowLayout;
        this.sportDivider3 = view2;
        this.tvSportHistoryTitle = textView;
        this.tvSportNameTitle = textView2;
        this.tvSportNoRecord = textView3;
        this.tvSportTime = textView4;
        this.tvSportTimeTitle = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEventSportBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentEventSportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event_sport, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        r1 = com.microtech.aidexx.R.id.sport_divider3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.microtech.aidexx.R.id.diet_divider2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.FragmentEventSportBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.microtech.aidexx.R.id.bt_save_sport
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.diet_divider2
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.et_sport_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.EditText r7 = (android.widget.EditText) r7
            if (r7 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.ll_sport_history
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.rv_sport_history
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            if (r9 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.rv_sport_preset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            if (r10 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.rv_sports
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.slSportPreset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.lihang.ShadowLayout r12 = (com.lihang.ShadowLayout) r12
            if (r12 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.sport_divider3
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.tv_sport_history_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.tv_sport_name_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.tv_sport_no_record
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.tv_sport_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00a3
            int r1 = com.microtech.aidexx.R.id.tv_sport_time_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00a3
            com.microtech.aidexx.databinding.FragmentEventSportBinding r1 = new com.microtech.aidexx.databinding.FragmentEventSportBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00a3:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.FragmentEventSportBinding.bind(android.view.View):com.microtech.aidexx.databinding.FragmentEventSportBinding");
    }
}
