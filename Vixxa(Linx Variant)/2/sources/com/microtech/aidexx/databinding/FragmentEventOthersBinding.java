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
import com.microtech.aidexx.R;

public final class FragmentEventOthersBinding implements ViewBinding {
    public final RoundTextView btSaveOthers;
    public final EditText etOthersContent;
    public final LinearLayout llOthersHistory;
    public final View othersDivider1;
    public final View othersDivider2;
    private final ConstraintLayout rootView;
    public final RecyclerView rvOthersHistory;
    public final TextView tvOthersNameTitle;
    public final TextView tvOthersNoRecord;
    public final TextView tvOthersTime;
    public final TextView tvOthersTimeTitle;
    public final TextView tvSportHistoryTitle;

    private FragmentEventOthersBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, EditText editText, LinearLayout linearLayout, View view, View view2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btSaveOthers = roundTextView;
        this.etOthersContent = editText;
        this.llOthersHistory = linearLayout;
        this.othersDivider1 = view;
        this.othersDivider2 = view2;
        this.rvOthersHistory = recyclerView;
        this.tvOthersNameTitle = textView;
        this.tvOthersNoRecord = textView2;
        this.tvOthersTime = textView3;
        this.tvOthersTimeTitle = textView4;
        this.tvSportHistoryTitle = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEventOthersBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentEventOthersBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event_others, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.microtech.aidexx.R.id.others_divider1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.microtech.aidexx.R.id.others_divider2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.FragmentEventOthersBinding bind(android.view.View r15) {
        /*
            int r0 = com.microtech.aidexx.R.id.bt_save_others
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.et_others_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            android.widget.EditText r5 = (android.widget.EditText) r5
            if (r5 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.ll_others_history
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.others_divider1
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r7 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.others_divider2
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            if (r8 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.rv_others_history
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            if (r9 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.tv_others_name_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.tv_others_no_record
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.tv_others_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.tv_others_time_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x007d
            int r0 = com.microtech.aidexx.R.id.tv_sport_history_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x007d
            com.microtech.aidexx.databinding.FragmentEventOthersBinding r0 = new com.microtech.aidexx.databinding.FragmentEventOthersBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x007d:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.FragmentEventOthersBinding.bind(android.view.View):com.microtech.aidexx.databinding.FragmentEventOthersBinding");
    }
}
