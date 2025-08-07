package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class ItemTimezoneHistoryBinding implements ViewBinding {
    public final TextView fromTime;
    public final TextView fromTimezone;
    private final ConstraintLayout rootView;
    public final TextView timezoneHistoryCreateTime;
    public final ImageView timezoneHistoryDot1;
    public final ImageView timezoneHistoryDot2;
    public final View timezoneHistoryLine;
    public final TextView toTime;
    public final TextView toTimezone;

    private ItemTimezoneHistoryBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, ImageView imageView2, View view, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.fromTime = textView;
        this.fromTimezone = textView2;
        this.timezoneHistoryCreateTime = textView3;
        this.timezoneHistoryDot1 = imageView;
        this.timezoneHistoryDot2 = imageView2;
        this.timezoneHistoryLine = view;
        this.toTime = textView4;
        this.toTimezone = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemTimezoneHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemTimezoneHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_timezone_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.microtech.aidexx.R.id.timezone_history_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ItemTimezoneHistoryBinding bind(android.view.View r12) {
        /*
            int r0 = com.microtech.aidexx.R.id.from_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.from_timezone
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.timezone_history_create_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.timezone_history_dot1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.timezone_history_dot2
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.timezone_history_line
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r9 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.to_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.to_timezone
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            com.microtech.aidexx.databinding.ItemTimezoneHistoryBinding r0 = new com.microtech.aidexx.databinding.ItemTimezoneHistoryBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x005f:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ItemTimezoneHistoryBinding.bind(android.view.View):com.microtech.aidexx.databinding.ItemTimezoneHistoryBinding");
    }
}
