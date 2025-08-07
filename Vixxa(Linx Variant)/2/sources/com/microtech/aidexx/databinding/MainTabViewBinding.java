package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class MainTabViewBinding implements ViewBinding {
    public final ImageView ivHome;
    private final ConstraintLayout rootView;
    public final MainTabItemBinding tabBg;
    public final MainTabItemBinding tabEvent;
    public final MainTabItemBinding tabHistory;
    public final RelativeLayout tabHome;
    public final MainTabItemBinding tabTrend;
    public final View tabView;
    public final TextView tvHome;

    private MainTabViewBinding(ConstraintLayout constraintLayout, ImageView imageView, MainTabItemBinding mainTabItemBinding, MainTabItemBinding mainTabItemBinding2, MainTabItemBinding mainTabItemBinding3, RelativeLayout relativeLayout, MainTabItemBinding mainTabItemBinding4, View view, TextView textView) {
        this.rootView = constraintLayout;
        this.ivHome = imageView;
        this.tabBg = mainTabItemBinding;
        this.tabEvent = mainTabItemBinding2;
        this.tabHistory = mainTabItemBinding3;
        this.tabHome = relativeLayout;
        this.tabTrend = mainTabItemBinding4;
        this.tabView = view;
        this.tvHome = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MainTabViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static MainTabViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.main_tab_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r0 = com.microtech.aidexx.R.id.tab_trend;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.microtech.aidexx.R.id.tab_bg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.MainTabViewBinding bind(android.view.View r12) {
        /*
            int r0 = com.microtech.aidexx.R.id.iv_home
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0063
            int r0 = com.microtech.aidexx.R.id.tab_bg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x0063
            com.microtech.aidexx.databinding.MainTabItemBinding r5 = com.microtech.aidexx.databinding.MainTabItemBinding.bind(r1)
            int r0 = com.microtech.aidexx.R.id.tab_event
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x0063
            com.microtech.aidexx.databinding.MainTabItemBinding r6 = com.microtech.aidexx.databinding.MainTabItemBinding.bind(r1)
            int r0 = com.microtech.aidexx.R.id.tab_history
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x0063
            com.microtech.aidexx.databinding.MainTabItemBinding r7 = com.microtech.aidexx.databinding.MainTabItemBinding.bind(r1)
            int r0 = com.microtech.aidexx.R.id.tab_home
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x0063
            int r0 = com.microtech.aidexx.R.id.tab_trend
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x0063
            com.microtech.aidexx.databinding.MainTabItemBinding r9 = com.microtech.aidexx.databinding.MainTabItemBinding.bind(r1)
            int r0 = com.microtech.aidexx.R.id.tab_view
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r10 == 0) goto L_0x0063
            int r0 = com.microtech.aidexx.R.id.tv_home
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0063
            com.microtech.aidexx.databinding.MainTabViewBinding r0 = new com.microtech.aidexx.databinding.MainTabViewBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0063:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.MainTabViewBinding.bind(android.view.View):com.microtech.aidexx.databinding.MainTabViewBinding");
    }
}
