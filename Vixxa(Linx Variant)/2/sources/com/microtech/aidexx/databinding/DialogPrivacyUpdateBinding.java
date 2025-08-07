package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.button.StateButton;

public final class DialogPrivacyUpdateBinding implements ViewBinding {
    public final TextView btCancel;
    public final StateButton btOk;
    public final LinearLayout llDownload;
    private final RelativeLayout rootView;
    public final ScrollView slContent;
    public final TextView tvContent;
    public final TextView tvDetail;
    public final LinearLayout upgradeTop;

    private DialogPrivacyUpdateBinding(RelativeLayout relativeLayout, TextView textView, StateButton stateButton, LinearLayout linearLayout, ScrollView scrollView, TextView textView2, TextView textView3, LinearLayout linearLayout2) {
        this.rootView = relativeLayout;
        this.btCancel = textView;
        this.btOk = stateButton;
        this.llDownload = linearLayout;
        this.slContent = scrollView;
        this.tvContent = textView2;
        this.tvDetail = textView3;
        this.upgradeTop = linearLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogPrivacyUpdateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogPrivacyUpdateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_privacy_update, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogPrivacyUpdateBinding bind(View view) {
        int i = R.id.bt_cancel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bt_ok;
            StateButton stateButton = (StateButton) ViewBindings.findChildViewById(view, i);
            if (stateButton != null) {
                i = R.id.ll_download;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.sl_content;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                    if (scrollView != null) {
                        i = R.id.tv_content;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_detail;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.upgradeTop;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    return new DialogPrivacyUpdateBinding((RelativeLayout) view, textView, stateButton, linearLayout, scrollView, textView2, textView3, linearLayout2);
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
