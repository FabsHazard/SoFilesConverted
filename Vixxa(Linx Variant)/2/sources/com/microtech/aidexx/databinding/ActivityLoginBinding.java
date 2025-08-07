package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.button.StateButton;

public final class ActivityLoginBinding implements ViewBinding {
    public final StateButton btnLogin;
    public final ConstraintLayout clLoginType;
    public final ConstraintLayout clMethod;
    public final AppCompatEditText etUsername;
    public final ActionBarWidget loginActionBar;
    public final LayoutLoginByCodeBinding loginByCode;
    public final LayoutLoginByPwdBinding loginByPwd;
    private final ConstraintLayout rootView;
    public final View splitLine;
    public final TextView tvExchange;
    public final TextView tvExchangeSecond;
    public final TextView tvGtLogin;
    public final TextView tvLoginLogo;

    private ActivityLoginBinding(ConstraintLayout constraintLayout, StateButton stateButton, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatEditText appCompatEditText, ActionBarWidget actionBarWidget, LayoutLoginByCodeBinding layoutLoginByCodeBinding, LayoutLoginByPwdBinding layoutLoginByPwdBinding, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnLogin = stateButton;
        this.clLoginType = constraintLayout2;
        this.clMethod = constraintLayout3;
        this.etUsername = appCompatEditText;
        this.loginActionBar = actionBarWidget;
        this.loginByCode = layoutLoginByCodeBinding;
        this.loginByPwd = layoutLoginByPwdBinding;
        this.splitLine = view;
        this.tvExchange = textView;
        this.tvExchangeSecond = textView2;
        this.tvGtLogin = textView3;
        this.tvLoginLogo = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.microtech.aidexx.R.id.login_by_code;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.microtech.aidexx.databinding.ActivityLoginBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.microtech.aidexx.R.id.btn_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.microtech.aidexx.views.button.StateButton r5 = (com.microtech.aidexx.views.button.StateButton) r5
            if (r5 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.cl_login_type
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.cl_method
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.et_username
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.appcompat.widget.AppCompatEditText r8 = (androidx.appcompat.widget.AppCompatEditText) r8
            if (r8 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.login_action_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.microtech.aidexx.views.ActionBarWidget r9 = (com.microtech.aidexx.views.ActionBarWidget) r9
            if (r9 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.login_by_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x0090
            com.microtech.aidexx.databinding.LayoutLoginByCodeBinding r10 = com.microtech.aidexx.databinding.LayoutLoginByCodeBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.login_by_pwd
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x0090
            com.microtech.aidexx.databinding.LayoutLoginByPwdBinding r11 = com.microtech.aidexx.databinding.LayoutLoginByPwdBinding.bind(r2)
            int r1 = com.microtech.aidexx.R.id.splitLine
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.tv_exchange
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.tv_exchange_second
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.tv_gt_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0090
            int r1 = com.microtech.aidexx.R.id.tv_login_logo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0090
            com.microtech.aidexx.databinding.ActivityLoginBinding r1 = new com.microtech.aidexx.databinding.ActivityLoginBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x0090:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.databinding.ActivityLoginBinding.bind(android.view.View):com.microtech.aidexx.databinding.ActivityLoginBinding");
    }
}
