package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityShareAndFollowEditBinding implements ViewBinding {
    public final RoundTextView btnEditDelete;
    public final RoundTextView btnEditSave;
    public final LinearLayout clEdit;
    public final ConstraintLayout clEditContent;
    public final ConstraintLayout clInfo;
    public final EditText etAliasValue;
    public final LayoutSwitchEditBinding normalNotice;
    private final ConstraintLayout rootView;
    public final ActionBarWidget shareAndFollowEditActionbar;
    public final View shareAndFollowEditDivider1;
    public final LayoutSwitchEditBinding showOrHide;
    public final TextView tvAccountTitle;
    public final TextView tvAccountValue;
    public final TextView tvAliasEdit;
    public final LayoutSwitchEditBinding urgentNotice;

    private ActivityShareAndFollowEditBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, RoundTextView roundTextView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, EditText editText, LayoutSwitchEditBinding layoutSwitchEditBinding, ActionBarWidget actionBarWidget, View view, LayoutSwitchEditBinding layoutSwitchEditBinding2, TextView textView, TextView textView2, TextView textView3, LayoutSwitchEditBinding layoutSwitchEditBinding3) {
        this.rootView = constraintLayout;
        this.btnEditDelete = roundTextView;
        this.btnEditSave = roundTextView2;
        this.clEdit = linearLayout;
        this.clEditContent = constraintLayout2;
        this.clInfo = constraintLayout3;
        this.etAliasValue = editText;
        this.normalNotice = layoutSwitchEditBinding;
        this.shareAndFollowEditActionbar = actionBarWidget;
        this.shareAndFollowEditDivider1 = view;
        this.showOrHide = layoutSwitchEditBinding2;
        this.tvAccountTitle = textView;
        this.tvAccountValue = textView2;
        this.tvAliasEdit = textView3;
        this.urgentNotice = layoutSwitchEditBinding3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityShareAndFollowEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityShareAndFollowEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_share_and_follow_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.microtech.aidexx.R.id.normal_notice;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        r1 = com.microtech.aidexx.R.id.share_and_follow_edit_divider1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r1 = com.microtech.aidexx.R.id.show_or_hide;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        r1 = com.microtech.aidexx.R.id.urgent_notice;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ActivityShareAndFollowEditBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.microtech.aidexx.R.id.btn_edit_delete
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.btn_edit_save
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.cl_edit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.cl_edit_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.cl_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.et_alias_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.EditText r10 = (android.widget.EditText) r10
            if (r10 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.normal_notice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a8
            com.microtech.aidexx.databinding.LayoutSwitchEditBinding r11 = com.microtech.aidexx.databinding.LayoutSwitchEditBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.share_and_follow_edit_actionbar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.microtech.aidexx.views.ActionBarWidget r12 = (com.microtech.aidexx.views.ActionBarWidget) r12
            if (r12 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.share_and_follow_edit_divider1
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.show_or_hide
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a8
            com.microtech.aidexx.databinding.LayoutSwitchEditBinding r14 = com.microtech.aidexx.databinding.LayoutSwitchEditBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.tv_account_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.tv_account_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.tv_alias_edit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00a8
            int r1 = com.microtech.aidexx.R.id.urgent_notice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00a8
            com.microtech.aidexx.databinding.LayoutSwitchEditBinding r18 = com.microtech.aidexx.databinding.LayoutSwitchEditBinding.bind(r2)
            com.microtech.aidexx.databinding.ActivityShareAndFollowEditBinding r1 = new com.microtech.aidexx.databinding.ActivityShareAndFollowEditBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00a8:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ActivityShareAndFollowEditBinding.bind(android.view.View):com.microtech.aidexx.databinding.ActivityShareAndFollowEditBinding");
    }
}
