package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;

public final class ItemShareBtnBinding implements ViewBinding {
    public final RoundTextView btnAccountAdd;
    public final RoundTextView btnWechatAdd;
    private final LinearLayout rootView;

    private ItemShareBtnBinding(LinearLayout linearLayout, RoundTextView roundTextView, RoundTextView roundTextView2) {
        this.rootView = linearLayout;
        this.btnAccountAdd = roundTextView;
        this.btnWechatAdd = roundTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemShareBtnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShareBtnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_share_btn, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemShareBtnBinding bind(View view) {
        int i = R.id.btn_account_add;
        RoundTextView roundTextView = (RoundTextView) ViewBindings.findChildViewById(view, i);
        if (roundTextView != null) {
            i = R.id.btn_wechat_add;
            RoundTextView roundTextView2 = (RoundTextView) ViewBindings.findChildViewById(view, i);
            if (roundTextView2 != null) {
                return new ItemShareBtnBinding((LinearLayout) view, roundTextView, roundTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
