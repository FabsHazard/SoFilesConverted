package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class FragmentPermissionCheckBinding implements ViewBinding {
    public final TextView checkOnce;
    public final ConstraintLayout clDesc;
    public final LinearLayout permissionItems;
    private final ConstraintLayout rootView;
    public final TextView tip;

    private FragmentPermissionCheckBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, TextView textView2) {
        this.rootView = constraintLayout;
        this.checkOnce = textView;
        this.clDesc = constraintLayout2;
        this.permissionItems = linearLayout;
        this.tip = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPermissionCheckBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentPermissionCheckBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_permission_check, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentPermissionCheckBinding bind(View view) {
        int i = R.id.checkOnce;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.cl_desc;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.permission_items;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.tip;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new FragmentPermissionCheckBinding((ConstraintLayout) view, textView, constraintLayout, linearLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
