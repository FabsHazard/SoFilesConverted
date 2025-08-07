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

public final class FragmentEventInsulinBinding implements ViewBinding {
    public final RoundTextView btSaveInjection;
    public final View dietDivider1;
    public final View dietDivider2;
    public final View dietDivider3;
    public final EditText etInsulinName;
    public final LinearLayout llInjectionHistory;
    private final ConstraintLayout rootView;
    public final RecyclerView rvInjectInput;
    public final RecyclerView rvInjectionHistory;
    public final RecyclerView rvInjectionPreset;
    public final ShadowLayout slInjectionPreset;
    public final TextView tvInjectionHistoryTitle;
    public final TextView tvInjectionNoRecord;
    public final TextView tvInjectionTime;
    public final TextView tvInjectionTimeText;
    public final TextView tvInjectionTitle;
    public final TextView tvInjectionType;
    public final TextView tvInsulinName;

    private FragmentEventInsulinBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, View view, View view2, View view3, EditText editText, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, ShadowLayout shadowLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.btSaveInjection = roundTextView;
        this.dietDivider1 = view;
        this.dietDivider2 = view2;
        this.dietDivider3 = view3;
        this.etInsulinName = editText;
        this.llInjectionHistory = linearLayout;
        this.rvInjectInput = recyclerView;
        this.rvInjectionHistory = recyclerView2;
        this.rvInjectionPreset = recyclerView3;
        this.slInjectionPreset = shadowLayout;
        this.tvInjectionHistoryTitle = textView;
        this.tvInjectionNoRecord = textView2;
        this.tvInjectionTime = textView3;
        this.tvInjectionTimeText = textView4;
        this.tvInjectionTitle = textView5;
        this.tvInjectionType = textView6;
        this.tvInsulinName = textView7;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentEventInsulinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentEventInsulinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_event_insulin, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.microtech.aidexx.R.id.diet_divider1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = com.microtech.aidexx.R.id.diet_divider2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r1 = com.microtech.aidexx.R.id.diet_divider3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.FragmentEventInsulinBinding bind(android.view.View r22) {
        /*
            r0 = r22
            int r1 = com.microtech.aidexx.R.id.btSaveInjection
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.diet_divider1
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.diet_divider2
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.diet_divider3
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.etInsulinName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.EditText r9 = (android.widget.EditText) r9
            if (r9 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.llInjectionHistory
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.rvInjectInput
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.recyclerview.widget.RecyclerView r11 = (androidx.recyclerview.widget.RecyclerView) r11
            if (r11 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.rvInjectionHistory
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.rvInjectionPreset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.recyclerview.widget.RecyclerView r13 = (androidx.recyclerview.widget.RecyclerView) r13
            if (r13 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.slInjectionPreset
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.lihang.ShadowLayout r14 = (com.lihang.ShadowLayout) r14
            if (r14 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tvInjectionHistoryTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tvInjectionNoRecord
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tvInjectionTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tvInjectionTimeText
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tvInjectionTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tvInjectionType
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00c4
            int r1 = com.microtech.aidexx.R.id.tvInsulinName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00c4
            com.microtech.aidexx.databinding.FragmentEventInsulinBinding r1 = new com.microtech.aidexx.databinding.FragmentEventInsulinBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.FragmentEventInsulinBinding.bind(android.view.View):com.microtech.aidexx.databinding.FragmentEventInsulinBinding");
    }
}
