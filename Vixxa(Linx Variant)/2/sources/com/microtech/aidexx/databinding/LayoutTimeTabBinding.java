package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class LayoutTimeTabBinding implements ViewBinding {
    public final View bgSix;
    public final View bgTwelve;
    public final View bgTwentyFour;
    public final ConstraintLayout layoutSix;
    public final ConstraintLayout layoutTwelve;
    public final ConstraintLayout layoutTwentyFour;
    private final ConstraintLayout rootView;
    public final TextView tvSix;
    public final TextView tvTwelve;
    public final TextView tvTwentyFour;

    private LayoutTimeTabBinding(ConstraintLayout constraintLayout, View view, View view2, View view3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.bgSix = view;
        this.bgTwelve = view2;
        this.bgTwentyFour = view3;
        this.layoutSix = constraintLayout2;
        this.layoutTwelve = constraintLayout3;
        this.layoutTwentyFour = constraintLayout4;
        this.tvSix = textView;
        this.tvTwelve = textView2;
        this.tvTwentyFour = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutTimeTabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutTimeTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_time_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.microtech.aidexx.R.id.bg_twelve;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.microtech.aidexx.R.id.bg_twenty_four;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.LayoutTimeTabBinding bind(android.view.View r12) {
        /*
            int r0 = com.microtech.aidexx.R.id.bg_six
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r3 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.bg_twelve
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r4 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.bg_twenty_four
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r5 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.layout_six
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.layout_twelve
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.layout_twenty_four
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.tv_six
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.tv_twelve
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0064
            int r0 = com.microtech.aidexx.R.id.tv_twenty_four
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0064
            com.microtech.aidexx.databinding.LayoutTimeTabBinding r0 = new com.microtech.aidexx.databinding.LayoutTimeTabBinding
            r2 = r12
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0064:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.LayoutTimeTabBinding.bind(android.view.View):com.microtech.aidexx.databinding.LayoutTimeTabBinding");
    }
}
