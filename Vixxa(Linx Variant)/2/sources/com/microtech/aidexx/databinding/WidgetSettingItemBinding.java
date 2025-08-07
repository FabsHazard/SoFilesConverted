package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class WidgetSettingItemBinding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final ImageView ivIconLeft;
    private final ConstraintLayout rootView;
    public final SwitchCompat swOn;
    public final ImageView tvDown;
    public final ImageView tvNext;
    public final TextView tvTitle;
    public final TextView tvValue;
    public final TextView txtSecondValue;
    public final View viewLine;

    private WidgetSettingItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, SwitchCompat switchCompat, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivIconLeft = imageView;
        this.swOn = switchCompat;
        this.tvDown = imageView2;
        this.tvNext = imageView3;
        this.tvTitle = textView;
        this.tvValue = textView2;
        this.txtSecondValue = textView3;
        this.viewLine = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WidgetSettingItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static WidgetSettingItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.widget_setting_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.microtech.aidexx.R.id.view_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.WidgetSettingItemBinding bind(android.view.View r13) {
        /*
            int r0 = com.microtech.aidexx.R.id.cl_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.iv_icon_left
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.sw_on
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            androidx.appcompat.widget.SwitchCompat r6 = (androidx.appcompat.widget.SwitchCompat) r6
            if (r6 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.tv_down
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.tv_next
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.tv_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.tv_value
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.txt_second_value
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006a
            int r0 = com.microtech.aidexx.R.id.view_line
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r12 == 0) goto L_0x006a
            com.microtech.aidexx.databinding.WidgetSettingItemBinding r0 = new com.microtech.aidexx.databinding.WidgetSettingItemBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006a:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.WidgetSettingItemBinding.bind(android.view.View):com.microtech.aidexx.databinding.WidgetSettingItemBinding");
    }
}
