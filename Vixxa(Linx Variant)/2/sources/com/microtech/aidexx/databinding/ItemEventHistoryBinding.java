package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.flyco.roundview.RoundLinearLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.SwipeDeleteMenuLayout;

public final class ItemEventHistoryBinding implements ViewBinding {
    public final FrameLayout flCollapse;
    public final ConstraintLayout flHistoryDelete;
    public final RoundLinearLayout flItemHeightGuide;
    public final ImageView ivCollapse;
    public final ImageView ivHistory;
    public final ConstraintLayout llTimeline;
    private final ConstraintLayout rootView;
    public final SwipeDeleteMenuLayout smlDelete;
    public final TextView tvContent;
    public final TextView tvDetail;
    public final ImageButton tvHistoryDelete;
    public final TextView tvTimeLine;

    private ItemEventHistoryBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ConstraintLayout constraintLayout2, RoundLinearLayout roundLinearLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, SwipeDeleteMenuLayout swipeDeleteMenuLayout, TextView textView, TextView textView2, ImageButton imageButton, TextView textView3) {
        this.rootView = constraintLayout;
        this.flCollapse = frameLayout;
        this.flHistoryDelete = constraintLayout2;
        this.flItemHeightGuide = roundLinearLayout;
        this.ivCollapse = imageView;
        this.ivHistory = imageView2;
        this.llTimeline = constraintLayout3;
        this.smlDelete = swipeDeleteMenuLayout;
        this.tvContent = textView;
        this.tvDetail = textView2;
        this.tvHistoryDelete = imageButton;
        this.tvTimeLine = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemEventHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemEventHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_event_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemEventHistoryBinding bind(View view) {
        int i = R.id.flCollapse;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.flHistoryDelete;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.flItemHeightGuide;
                RoundLinearLayout roundLinearLayout = (RoundLinearLayout) ViewBindings.findChildViewById(view, i);
                if (roundLinearLayout != null) {
                    i = R.id.ivCollapse;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.ivHistory;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.llTimeline;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = R.id.sml_delete;
                                SwipeDeleteMenuLayout swipeDeleteMenuLayout = (SwipeDeleteMenuLayout) ViewBindings.findChildViewById(view, i);
                                if (swipeDeleteMenuLayout != null) {
                                    i = R.id.tvContent;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.tvDetail;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.tvHistoryDelete;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                                            if (imageButton != null) {
                                                i = R.id.tvTimeLine;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    return new ItemEventHistoryBinding((ConstraintLayout) view, frameLayout, constraintLayout, roundLinearLayout, imageView, imageView2, constraintLayout2, swipeDeleteMenuLayout, textView, textView2, imageButton, textView3);
                                                }
                                            }
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
