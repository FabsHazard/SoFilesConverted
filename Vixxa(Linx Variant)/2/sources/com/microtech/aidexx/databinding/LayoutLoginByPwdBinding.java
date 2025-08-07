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

public final class LayoutLoginByPwdBinding implements ViewBinding {
    public final AppCompatEditText etPwd;
    private final LinearLayout rootView;
    public final TextView tvForget;

    private LayoutLoginByPwdBinding(LinearLayout linearLayout, AppCompatEditText appCompatEditText, TextView textView) {
        this.rootView = linearLayout;
        this.etPwd = appCompatEditText;
        this.tvForget = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutLoginByPwdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutLoginByPwdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_login_by_pwd, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutLoginByPwdBinding bind(View view) {
        int i = R.id.et_pwd;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
        if (appCompatEditText != null) {
            i = R.id.tv_forget;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LayoutLoginByPwdBinding((LinearLayout) view, appCompatEditText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
