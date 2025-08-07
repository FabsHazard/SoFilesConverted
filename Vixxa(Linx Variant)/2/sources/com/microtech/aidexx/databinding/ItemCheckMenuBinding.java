package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class ItemCheckMenuBinding implements ViewBinding {
    public final CheckBox cbItem;
    private final ConstraintLayout rootView;
    public final TextView tvItemName;
    public final View viDivider;

    private ItemCheckMenuBinding(ConstraintLayout constraintLayout, CheckBox checkBox, TextView textView, View view) {
        this.rootView = constraintLayout;
        this.cbItem = checkBox;
        this.tvItemName = textView;
        this.viDivider = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCheckMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemCheckMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_check_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.microtech.aidexx.R.id.viDivider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ItemCheckMenuBinding bind(android.view.View r4) {
        /*
            int r0 = com.microtech.aidexx.R.id.cbItem
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            if (r1 == 0) goto L_0x0024
            int r0 = com.microtech.aidexx.R.id.tvItemName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.TextView r2 = (android.widget.TextView) r2
            if (r2 == 0) goto L_0x0024
            int r0 = com.microtech.aidexx.R.id.viDivider
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0024
            com.microtech.aidexx.databinding.ItemCheckMenuBinding r0 = new com.microtech.aidexx.databinding.ItemCheckMenuBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0024:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ItemCheckMenuBinding.bind(android.view.View):com.microtech.aidexx.databinding.ItemCheckMenuBinding");
    }
}
