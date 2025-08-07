package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class LayoutLoginByCodeBinding implements ViewBinding {
    public final TextView btnGetVerCode;
    public final CheckBox checkProtocol;
    public final AppCompatEditText etCode;
    private final LinearLayout rootView;
    public final TextView txtUserProtocol;

    private LayoutLoginByCodeBinding(LinearLayout linearLayout, TextView textView, CheckBox checkBox, AppCompatEditText appCompatEditText, TextView textView2) {
        this.rootView = linearLayout;
        this.btnGetVerCode = textView;
        this.checkProtocol = checkBox;
        this.etCode = appCompatEditText;
        this.txtUserProtocol = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutLoginByCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutLoginByCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_login_by_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutLoginByCodeBinding bind(View view) {
        int i = R.id.btn_get_ver_code;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.check_protocol;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = R.id.et_code;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, i);
                if (appCompatEditText != null) {
                    i = R.id.txt_user_protocol;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new LayoutLoginByCodeBinding((LinearLayout) view, textView, checkBox, appCompatEditText, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
