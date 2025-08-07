package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class FragmentInsertionBinding implements ViewBinding {
    public final Guideline glBack;
    public final Guideline glFront;
    public final ImageView ivPicInsert;
    private final ConstraintLayout rootView;

    private FragmentInsertionBinding(ConstraintLayout constraintLayout, Guideline guideline, Guideline guideline2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.glBack = guideline;
        this.glFront = guideline2;
        this.ivPicInsert = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentInsertionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentInsertionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_insertion, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentInsertionBinding bind(View view) {
        int i = R.id.gl_back;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = R.id.gl_front;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline2 != null) {
                i = R.id.iv_pic_insert;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    return new FragmentInsertionBinding((ConstraintLayout) view, guideline, guideline2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
