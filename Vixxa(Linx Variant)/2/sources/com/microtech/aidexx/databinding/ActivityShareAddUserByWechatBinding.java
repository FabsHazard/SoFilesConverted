package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityShareAddUserByWechatBinding implements ViewBinding {
    public final RoundTextView btnSendQrCode;
    public final ImageView ivQrCode;
    public final LinearLayout llQrCode;
    public final ActionBarWidget myQrCodeActionBar;
    private final ConstraintLayout rootView;

    private ActivityShareAddUserByWechatBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, ImageView imageView, LinearLayout linearLayout, ActionBarWidget actionBarWidget) {
        this.rootView = constraintLayout;
        this.btnSendQrCode = roundTextView;
        this.ivQrCode = imageView;
        this.llQrCode = linearLayout;
        this.myQrCodeActionBar = actionBarWidget;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityShareAddUserByWechatBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityShareAddUserByWechatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_share_add_user_by_wechat, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityShareAddUserByWechatBinding bind(View view) {
        int i = R.id.btn_send_qr_code;
        RoundTextView roundTextView = (RoundTextView) ViewBindings.findChildViewById(view, i);
        if (roundTextView != null) {
            i = R.id.iv_qr_code;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.ll_qr_code;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.my_qr_code_action_bar;
                    ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
                    if (actionBarWidget != null) {
                        return new ActivityShareAddUserByWechatBinding((ConstraintLayout) view, roundTextView, imageView, linearLayout, actionBarWidget);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
