package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class ItemTransmitterBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final LinearLayout transItem;
    public final View transLine;
    public final TextView tvSn;
    public final TextView tvTransPairState;

    private ItemTransmitterBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, View view, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.transItem = linearLayout;
        this.transLine = view;
        this.tvSn = textView;
        this.tvTransPairState = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTransmitterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemTransmitterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_transmitter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.microtech.aidexx.R.id.trans_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ItemTransmitterBinding bind(android.view.View r8) {
        /*
            int r0 = com.microtech.aidexx.R.id.trans_item
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.microtech.aidexx.R.id.trans_line
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r5 == 0) goto L_0x0033
            int r0 = com.microtech.aidexx.R.id.tv_sn
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0033
            int r0 = com.microtech.aidexx.R.id.tv_trans_pair_state
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0033
            com.microtech.aidexx.databinding.ItemTransmitterBinding r0 = new com.microtech.aidexx.databinding.ItemTransmitterBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ItemTransmitterBinding.bind(android.view.View):com.microtech.aidexx.databinding.ItemTransmitterBinding");
    }
}
