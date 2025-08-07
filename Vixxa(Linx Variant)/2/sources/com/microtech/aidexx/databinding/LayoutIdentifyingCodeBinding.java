package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.codeview.PwdEditText;

public final class LayoutIdentifyingCodeBinding implements ViewBinding {
    public final LinearLayout containerEt;
    public final PwdEditText etCode;
    private final RelativeLayout rootView;

    private LayoutIdentifyingCodeBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, PwdEditText pwdEditText) {
        this.rootView = relativeLayout;
        this.containerEt = linearLayout;
        this.etCode = pwdEditText;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutIdentifyingCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutIdentifyingCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_identifying_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutIdentifyingCodeBinding bind(View view) {
        int i = R.id.container_et;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.et_code;
            PwdEditText pwdEditText = (PwdEditText) ViewBindings.findChildViewById(view, i);
            if (pwdEditText != null) {
                return new LayoutIdentifyingCodeBinding((RelativeLayout) view, linearLayout, pwdEditText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
