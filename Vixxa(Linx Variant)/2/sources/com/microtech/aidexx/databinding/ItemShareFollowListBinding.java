package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ItemShareFollowListBinding implements ViewBinding {
    public final View dividerTop;
    public final ImageView ivAvatar;
    public final ImageView ivShareListArrow;
    public final ImageView ivShareWechat;
    public final RelativeLayout rlItemRoot;
    private final RelativeLayout rootView;
    public final TextView txtName;

    private ItemShareFollowListBinding(RelativeLayout relativeLayout, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.dividerTop = view;
        this.ivAvatar = imageView;
        this.ivShareListArrow = imageView2;
        this.ivShareWechat = imageView3;
        this.rlItemRoot = relativeLayout2;
        this.txtName = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemShareFollowListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShareFollowListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_share_follow_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemShareFollowListBinding bind(View view) {
        int i = R.id.divider_top;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.iv_avatar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_share_list_arrow;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_share_wechat;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i = R.id.txt_name;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new ItemShareFollowListBinding(relativeLayout, findChildViewById, imageView, imageView2, imageView3, relativeLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
