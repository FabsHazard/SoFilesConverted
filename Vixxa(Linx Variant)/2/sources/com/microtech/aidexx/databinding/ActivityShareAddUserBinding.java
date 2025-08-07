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

public final class ActivityShareAddUserBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final RoundTextView btnAddShareSave;
    public final ConstraintLayout clInfo;
    public final EditText etAddAccountValue;
    public final EditText etAddAliasValue;
    private final LinearLayout rootView;
    public final View shareAndFollowEditDivider1;
    public final TextView tvAccountTitle;
    public final TextView tvAliasAdd;

    private ActivityShareAddUserBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, RoundTextView roundTextView, ConstraintLayout constraintLayout, EditText editText, EditText editText2, View view, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.btnAddShareSave = roundTextView;
        this.clInfo = constraintLayout;
        this.etAddAccountValue = editText;
        this.etAddAliasValue = editText2;
        this.shareAndFollowEditDivider1 = view;
        this.tvAccountTitle = textView;
        this.tvAliasAdd = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityShareAddUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityShareAddUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_share_add_user, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.microtech.aidexx.R.id.share_and_follow_edit_divider1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ActivityShareAddUserBinding bind(android.view.View r12) {
        /*
            int r0 = com.microtech.aidexx.R.id.action_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            com.microtech.aidexx.views.ActionBarWidget r4 = (com.microtech.aidexx.views.ActionBarWidget) r4
            if (r4 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.btn_add_share_save
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.cl_info
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.et_add_account_value
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.EditText r7 = (android.widget.EditText) r7
            if (r7 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.et_add_alias_value
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.EditText r8 = (android.widget.EditText) r8
            if (r8 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.share_and_follow_edit_divider1
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r9 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.tv_account_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005f
            int r0 = com.microtech.aidexx.R.id.tv_alias_add
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x005f
            com.microtech.aidexx.databinding.ActivityShareAddUserBinding r0 = new com.microtech.aidexx.databinding.ActivityShareAddUserBinding
            r3 = r12
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ActivityShareAddUserBinding.bind(android.view.View):com.microtech.aidexx.databinding.ActivityShareAddUserBinding");
    }
}
