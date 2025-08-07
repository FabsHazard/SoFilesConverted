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

public final class ActivityChangeAccountBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final TextView btnGetCode;
    public final StateButton btnSure;
    public final AppCompatEditText etCode;
    public final AppCompatEditText etUsername;
    private final LinearLayout rootView;

    private ActivityChangeAccountBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, TextView textView, StateButton stateButton, AppCompatEditText appCompatEditText, AppCompatEditText appCompatEditText2) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.btnGetCode = textView;
        this.btnSure = stateButton;
        this.etCode = appCompatEditText;
        this.etUsername = appCompatEditText2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChangeAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityChangeAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_change_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityChangeAccountBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.btn_get_code;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.btn_sure;
                StateButton stateButton = (StateButton) ViewBindings.findChildViewById(view, i);
                if (stateButton != null) {
                    i = R.id.et_code;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                    if (appCompatEditText != null) {
                        i = R.id.et_username;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                        if (appCompatEditText2 != null) {
                            return new ActivityChangeAccountBinding((LinearLayout) view, actionBarWidget, textView, stateButton, appCompatEditText, appCompatEditText2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
