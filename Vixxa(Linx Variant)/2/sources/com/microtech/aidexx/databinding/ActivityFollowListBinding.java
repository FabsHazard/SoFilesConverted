package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityFollowListBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final View animationLine;
    public final ConstraintLayout clMyCount;
    public final ConstraintLayout clMyCountShadow;
    public final ConstraintLayout clShadow;
    public final LinearLayoutCompat dialogRoot;
    public final LinearLayoutCompat dialogRootShadow;
    public final RelativeLayout followListTitle;
    public final ImageButton ibToShareFollowPage;
    public final ImageView ivCloseDialogShadow;
    public final View ivSwitchFollow;
    public final LayoutFollowListItemBinding myCountInfo;
    public final TextView myCountTitle;
    public final TextView myCountTitleShadow;
    public final TextView myFollowTitle;
    public final TextView myFollowTitleShadow;
    public final RelativeLayout rlRv;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFollowList;
    public final RecyclerView rvFollowListShadow;
    public final TextView tvMyInfoShadow;
    public final TextView tvSwitchBackShadow;
    public final View viewLineShadow;

    private ActivityFollowListBinding(ConstraintLayout constraintLayout, ActionBarWidget actionBarWidget, View view, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, RelativeLayout relativeLayout, ImageButton imageButton, ImageView imageView, View view2, LayoutFollowListItemBinding layoutFollowListItemBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, RelativeLayout relativeLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView5, TextView textView6, View view3) {
        this.rootView = constraintLayout;
        this.actionBar = actionBarWidget;
        this.animationLine = view;
        this.clMyCount = constraintLayout2;
        this.clMyCountShadow = constraintLayout3;
        this.clShadow = constraintLayout4;
        this.dialogRoot = linearLayoutCompat;
        this.dialogRootShadow = linearLayoutCompat2;
        this.followListTitle = relativeLayout;
        this.ibToShareFollowPage = imageButton;
        this.ivCloseDialogShadow = imageView;
        this.ivSwitchFollow = view2;
        this.myCountInfo = layoutFollowListItemBinding;
        this.myCountTitle = textView;
        this.myCountTitleShadow = textView2;
        this.myFollowTitle = textView3;
        this.myFollowTitleShadow = textView4;
        this.rlRv = relativeLayout2;
        this.rvFollowList = recyclerView;
        this.rvFollowListShadow = recyclerView2;
        this.tvMyInfoShadow = textView5;
        this.tvSwitchBackShadow = textView6;
        this.viewLineShadow = view3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFollowListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityFollowListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_follow_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r1 = com.microtech.aidexx.R.id.iv_switch_follow;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r1 = com.microtech.aidexx.R.id.my_count_info;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.microtech.aidexx.R.id.animation_line;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ed, code lost:
        r1 = com.microtech.aidexx.R.id.view_line_shadow;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ActivityFollowListBinding bind(android.view.View r27) {
        /*
            r0 = r27
            int r1 = com.microtech.aidexx.R.id.action_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.microtech.aidexx.views.ActionBarWidget r5 = (com.microtech.aidexx.views.ActionBarWidget) r5
            if (r5 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.animation_line
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.cl_my_count
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.cl_my_count_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.cl_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.dialog_root
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.appcompat.widget.LinearLayoutCompat r10 = (androidx.appcompat.widget.LinearLayoutCompat) r10
            if (r10 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.dialog_root_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.appcompat.widget.LinearLayoutCompat r11 = (androidx.appcompat.widget.LinearLayoutCompat) r11
            if (r11 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.followListTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            if (r12 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.ibToShareFollowPage
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageButton r13 = (android.widget.ImageButton) r13
            if (r13 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.iv_close_dialog_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.iv_switch_follow
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.my_count_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00ff
            com.microtech.aidexx.databinding.LayoutFollowListItemBinding r16 = com.microtech.aidexx.databinding.LayoutFollowListItemBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.my_count_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.my_count_title_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.my_follow_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.my_follow_title_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.rl_rv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.RelativeLayout r21 = (android.widget.RelativeLayout) r21
            if (r21 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.rv_follow_list
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            androidx.recyclerview.widget.RecyclerView r22 = (androidx.recyclerview.widget.RecyclerView) r22
            if (r22 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.rv_follow_list_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            androidx.recyclerview.widget.RecyclerView r23 = (androidx.recyclerview.widget.RecyclerView) r23
            if (r23 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.tv_my_info_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.tv_switch_back_shadow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x00ff
            int r1 = com.microtech.aidexx.R.id.view_line_shadow
            android.view.View r26 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r26 == 0) goto L_0x00ff
            com.microtech.aidexx.databinding.ActivityFollowListBinding r1 = new com.microtech.aidexx.databinding.ActivityFollowListBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return r1
        L_0x00ff:
            android.content.res.Resources r0 = r27.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ActivityFollowListBinding.bind(android.view.View):com.microtech.aidexx.databinding.ActivityFollowListBinding");
    }
}
