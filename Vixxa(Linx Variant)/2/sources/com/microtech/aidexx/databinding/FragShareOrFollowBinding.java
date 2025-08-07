package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

public final class FragShareOrFollowBinding implements ViewBinding {
    public final RoundTextView btnAccountAdd;
    public final RoundTextView btnWechatAdd;
    public final RecyclerView listShare;
    public final LinearLayout llBtn;
    private final SmartRefreshLayout rootView;
    public final SmartRefreshLayout shareRefreshLayout;
    public final TextView shareTvTip;

    private FragShareOrFollowBinding(SmartRefreshLayout smartRefreshLayout, RoundTextView roundTextView, RoundTextView roundTextView2, RecyclerView recyclerView, LinearLayout linearLayout, SmartRefreshLayout smartRefreshLayout2, TextView textView) {
        this.rootView = smartRefreshLayout;
        this.btnAccountAdd = roundTextView;
        this.btnWechatAdd = roundTextView2;
        this.listShare = recyclerView;
        this.llBtn = linearLayout;
        this.shareRefreshLayout = smartRefreshLayout2;
        this.shareTvTip = textView;
    }

    public SmartRefreshLayout getRoot() {
        return this.rootView;
    }

    public static FragShareOrFollowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragShareOrFollowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.frag_share_or_follow, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragShareOrFollowBinding bind(View view) {
        int i = R.id.btn_account_add;
        RoundTextView roundTextView = (RoundTextView) ViewBindings.findChildViewById(view, i);
        if (roundTextView != null) {
            i = R.id.btn_wechat_add;
            RoundTextView roundTextView2 = (RoundTextView) ViewBindings.findChildViewById(view, i);
            if (roundTextView2 != null) {
                i = R.id.list_share;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                if (recyclerView != null) {
                    i = R.id.ll_btn;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view;
                        i = R.id.share_tv_tip;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new FragShareOrFollowBinding(smartRefreshLayout, roundTextView, roundTextView2, recyclerView, linearLayout, smartRefreshLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
