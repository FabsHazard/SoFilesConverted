package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class ItemGlucoseHistoryBinding implements ViewBinding {
    public final LinearLayout llContainer;
    private final LinearLayout rootView;
    public final TextView tvGlucoseDescribe;
    public final TextView tvGlucoseTime;
    public final TextView tvGlucoseValue;
    public final View viDivider;

    private ItemGlucoseHistoryBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = linearLayout;
        this.llContainer = linearLayout2;
        this.tvGlucoseDescribe = textView;
        this.tvGlucoseTime = textView2;
        this.tvGlucoseValue = textView3;
        this.viDivider = view;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemGlucoseHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemGlucoseHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_glucose_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.microtech.aidexx.R.id.viDivider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ItemGlucoseHistoryBinding bind(android.view.View r7) {
        /*
            r2 = r7
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            int r0 = com.microtech.aidexx.R.id.tvGlucoseDescribe
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r3 = r1
            android.widget.TextView r3 = (android.widget.TextView) r3
            if (r3 == 0) goto L_0x0034
            int r0 = com.microtech.aidexx.R.id.tvGlucoseTime
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0034
            int r0 = com.microtech.aidexx.R.id.tvGlucoseValue
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0034
            int r0 = com.microtech.aidexx.R.id.viDivider
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            if (r6 == 0) goto L_0x0034
            com.microtech.aidexx.databinding.ItemGlucoseHistoryBinding r7 = new com.microtech.aidexx.databinding.ItemGlucoseHistoryBinding
            r0 = r7
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x0034:
            android.content.res.Resources r7 = r7.getResources()
            java.lang.String r7 = r7.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ItemGlucoseHistoryBinding.bind(android.view.View):com.microtech.aidexx.databinding.ItemGlucoseHistoryBinding");
    }
}
