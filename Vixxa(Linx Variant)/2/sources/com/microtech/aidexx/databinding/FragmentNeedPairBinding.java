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

public final class FragmentNeedPairBinding implements ViewBinding {
    public final TextView btConfirm;
    public final Guideline guideLine;
    public final ConstraintLayout layoutPanel;
    public final LinearLayout llPanel;
    private final ConstraintLayout rootView;
    public final TextView tvUnit;
    public final TextView txtSn;

    private FragmentNeedPairBinding(ConstraintLayout constraintLayout, TextView textView, Guideline guideline, ConstraintLayout constraintLayout2, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btConfirm = textView;
        this.guideLine = guideline;
        this.layoutPanel = constraintLayout2;
        this.llPanel = linearLayout;
        this.tvUnit = textView2;
        this.txtSn = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNeedPairBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentNeedPairBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_need_pair, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentNeedPairBinding bind(View view) {
        int i = R.id.bt_confirm;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.guide_line;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.ll_panel;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.tv_unit;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.txt_sn;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new FragmentNeedPairBinding(constraintLayout, textView, guideline, constraintLayout, linearLayout, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
