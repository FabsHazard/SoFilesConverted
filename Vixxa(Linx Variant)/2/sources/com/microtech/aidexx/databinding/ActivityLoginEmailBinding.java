package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.button.StateButton;

public final class ActivityLoginEmailBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final StateButton buttonLogin;
    public final CheckBox checkProtocal;
    public final AppCompatEditText etPwd;
    public final AppCompatEditText etUsername;
    public final FrameLayout flBg;
    private final LinearLayout rootView;
    public final TextView tvForget;
    public final TextView txtUserProtocal;

    private ActivityLoginEmailBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, StateButton stateButton, CheckBox checkBox, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.buttonLogin = stateButton;
        this.checkProtocal = checkBox;
        this.etPwd = appCompatEditText;
        this.etUsername = appCompatEditText2;
        this.flBg = frameLayout;
        this.tvForget = textView;
        this.txtUserProtocal = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLoginEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_login_email, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLoginEmailBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.button_login;
            StateButton stateButton = (StateButton) ViewBindings.findChildViewById(view, i);
            if (stateButton != null) {
                i = R.id.check_protocal;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                if (checkBox != null) {
                    i = R.id.et_pwd;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                    if (appCompatEditText != null) {
                        i = R.id.et_username;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                        if (appCompatEditText2 != null) {
                            i = R.id.fl_bg;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R.id.tv_forget;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.txt_user_protocal;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new ActivityLoginEmailBinding((LinearLayout) view, actionBarWidget, stateButton, checkBox, appCompatEditText, appCompatEditText2, frameLayout, textView, textView2);
                                    }
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
