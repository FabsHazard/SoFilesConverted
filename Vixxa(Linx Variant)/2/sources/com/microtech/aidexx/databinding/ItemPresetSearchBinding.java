package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.microtech.aidexx.R;

public final class ItemPresetSearchBinding implements ViewBinding {
    public final FlexboxLayout flItem;
    public final ImageView ivFoodCustom;
    public final ImageView ivFoodEdit;
    public final ImageView ivFoodInputIcon;
    public final LinearLayout llDetail;
    private final LinearLayout rootView;
    public final TextView tvContent;

    private ItemPresetSearchBinding(LinearLayout linearLayout, FlexboxLayout flexboxLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.flItem = flexboxLayout;
        this.ivFoodCustom = imageView;
        this.ivFoodEdit = imageView2;
        this.ivFoodInputIcon = imageView3;
        this.llDetail = linearLayout2;
        this.tvContent = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemPresetSearchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPresetSearchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_preset_search, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPresetSearchBinding bind(View view) {
        int i = R.id.flItem;
        FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view, i);
        if (flexboxLayout != null) {
            i = R.id.ivFoodCustom;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.ivFoodEdit;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.ivFoodInputIcon;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.llDetail;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.tvContent;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new ItemPresetSearchBinding((LinearLayout) view, flexboxLayout, imageView, imageView2, imageView3, linearLayout, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
