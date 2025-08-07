package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class LayoutExpandableGridBinding implements ViewBinding {
    public final TextView btSelectAll;
    public final View edgeWithoutArrow;
    public final RelativeLayout rlSelect;
    private final ConstraintLayout rootView;
    public final RecyclerView rvDates;
    public final ImageView stateSwitch;

    private LayoutExpandableGridBinding(ConstraintLayout constraintLayout, TextView textView, View view, RelativeLayout relativeLayout, RecyclerView recyclerView, ImageView imageView) {
        this.rootView = constraintLayout;
        this.btSelectAll = textView;
        this.edgeWithoutArrow = view;
        this.rlSelect = relativeLayout;
        this.rvDates = recyclerView;
        this.stateSwitch = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutExpandableGridBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutExpandableGridBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_expandable_grid, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.microtech.aidexx.R.id.edge_without_arrow;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.LayoutExpandableGridBinding bind(android.view.View r9) {
        /*
            int r0 = com.microtech.aidexx.R.id.bt_select_all
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.microtech.aidexx.R.id.edge_without_arrow
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r5 == 0) goto L_0x003e
            int r0 = com.microtech.aidexx.R.id.rl_select
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.microtech.aidexx.R.id.rv_dates
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.microtech.aidexx.R.id.state_switch
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x003e
            com.microtech.aidexx.databinding.LayoutExpandableGridBinding r0 = new com.microtech.aidexx.databinding.LayoutExpandableGridBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.LayoutExpandableGridBinding.bind(android.view.View):com.microtech.aidexx.databinding.LayoutExpandableGridBinding");
    }
}
