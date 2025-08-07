package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.button.StateButton;

public final class ActivityForgetPwdBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final TextView btnGetCode;
    public final StateButton buttonRegist;
    public final AppCompatEditText etCode;
    public final AppCompatEditText etPwd;
    public final AppCompatEditText etPwdConfirm;
    public final AppCompatEditText etUsername;
    private final LinearLayout rootView;

    private ActivityForgetPwdBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, TextView textView, StateButton stateButton, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, AppCompatEditText appCompatEditText3, AppCompatEditText appCompatEditText4) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.btnGetCode = textView;
        this.buttonRegist = stateButton;
        this.etCode = appCompatEditText;
        this.etPwd = appCompatEditText2;
        this.etPwdConfirm = appCompatEditText3;
        this.etUsername = appCompatEditText4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityForgetPwdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityForgetPwdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_forget_pwd, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityForgetPwdBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.btn_get_code;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.button_regist;
                StateButton stateButton = (StateButton) ViewBindings.findChildViewById(view, i);
                if (stateButton != null) {
                    i = R.id.et_code;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                    if (appCompatEditText != null) {
                        i = R.id.et_pwd;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                        if (appCompatEditText2 != null) {
                            i = R.id.et_pwd_confirm;
                            AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                            if (appCompatEditText3 != null) {
                                i = R.id.et_username;
                                AppCompatEditText appCompatEditText4 = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                                if (appCompatEditText4 != null) {
                                    return new ActivityForgetPwdBinding((LinearLayout) view, actionBarWidget, textView, stateButton, appCompatEditText, appCompatEditText2, appCompatEditText3, appCompatEditText4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
