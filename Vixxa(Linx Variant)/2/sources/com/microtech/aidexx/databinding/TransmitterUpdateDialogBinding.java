package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ota.HorizonProgressBar;

public final class TransmitterUpdateDialogBinding implements ViewBinding {
    public final TextView buttonConfirm;
    public final TextView idHead;
    public final ImageView ivComplete;
    public final ConstraintLayout layoutComplete;
    public final ConstraintLayout layoutUpdating;
    public final HorizonProgressBar pbUpdate;
    private final RelativeLayout rootView;
    public final TextView tips;
    public final TextView tvComplete;
    public final TextView tvReboot;

    private TransmitterUpdateDialogBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, ImageView imageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, HorizonProgressBar horizonProgressBar, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = relativeLayout;
        this.buttonConfirm = textView;
        this.idHead = textView2;
        this.ivComplete = imageView;
        this.layoutComplete = constraintLayout;
        this.layoutUpdating = constraintLayout2;
        this.pbUpdate = horizonProgressBar;
        this.tips = textView3;
        this.tvComplete = textView4;
        this.tvReboot = textView5;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TransmitterUpdateDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static TransmitterUpdateDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.transmitter_update_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TransmitterUpdateDialogBinding bind(View view) {
        int i = R.id.button_confirm;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.id_head;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.iv_complete;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.layout_complete;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R.id.layout_updating;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null) {
                            i = R.id.pb_update;
                            HorizonProgressBar horizonProgressBar = (HorizonProgressBar) ViewBindings.findChildViewById(view, i);
                            if (horizonProgressBar != null) {
                                i = R.id.tips;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.tv_complete;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.tv_reboot;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new TransmitterUpdateDialogBinding((RelativeLayout) view, textView, textView2, imageView, constraintLayout, constraintLayout2, horizonProgressBar, textView3, textView4, textView5);
                                        }
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
