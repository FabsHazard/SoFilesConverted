package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class DialogWithOneBtnBinding implements ViewBinding {
    public final TextView btOk;
    private final LinearLayout rootView;
    public final TextView tvContent;
    public final TextView tvDesc;

    private DialogWithOneBtnBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btOk = textView;
        this.tvContent = textView2;
        this.tvDesc = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogWithOneBtnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogWithOneBtnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_with_one_btn, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogWithOneBtnBinding bind(View view) {
        int i = R.id.bt_ok;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_content;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_desc;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new DialogWithOneBtnBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
