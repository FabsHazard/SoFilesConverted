package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.welcome.UserAgreeView;
import com.microtech.aidexx.views.button.StateButton;

public final class ActivityWelcomeTipBinding implements ViewBinding {
    public final StateButton buttonLogin;
    public final StateButton buttonRegist;
    private final ConstraintLayout rootView;
    public final TextView textView;
    public final TextView textView2;
    public final LinearLayout tipLl;
    public final TextView title;
    public final UserAgreeView viewAgreeProtocal;
    public final Guideline welcomeGuideline;

    private ActivityWelcomeTipBinding(ConstraintLayout constraintLayout, StateButton stateButton, StateButton stateButton2, TextView textView3, TextView textView4, LinearLayout linearLayout, TextView textView5, UserAgreeView userAgreeView, Guideline guideline) {
        this.rootView = constraintLayout;
        this.buttonLogin = stateButton;
        this.buttonRegist = stateButton2;
        this.textView = textView3;
        this.textView2 = textView4;
        this.tipLl = linearLayout;
        this.title = textView5;
        this.viewAgreeProtocal = userAgreeView;
        this.welcomeGuideline = guideline;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWelcomeTipBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityWelcomeTipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_welcome_tip, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityWelcomeTipBinding bind(View view) {
        int i = R.id.button_login;
        StateButton stateButton = (StateButton) ViewBindings.findChildViewById(view, i);
        if (stateButton != null) {
            i = R.id.button_regist;
            StateButton stateButton2 = (StateButton) ViewBindings.findChildViewById(view, i);
            if (stateButton2 != null) {
                i = R.id.textView;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.textView2;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.tipLl;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.title;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.view_agree_protocal;
                                UserAgreeView userAgreeView = (UserAgreeView) ViewBindings.findChildViewById(view, i);
                                if (userAgreeView != null) {
                                    i = R.id.welcome_guideline;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline != null) {
                                        return new ActivityWelcomeTipBinding((ConstraintLayout) view, stateButton, stateButton2, textView3, textView4, linearLayout, textView5, userAgreeView, guideline);
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
