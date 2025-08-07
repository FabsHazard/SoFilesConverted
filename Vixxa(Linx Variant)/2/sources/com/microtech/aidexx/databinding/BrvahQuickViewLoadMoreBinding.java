package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class BrvahQuickViewLoadMoreBinding implements ViewBinding {
    public final FrameLayout loadMoreLoadCompleteView;
    public final FrameLayout loadMoreLoadEndView;
    public final FrameLayout loadMoreLoadFailView;
    public final LinearLayout loadMoreLoadingView;
    public final ProgressBar loadingProgress;
    public final TextView loadingText;
    private final FrameLayout rootView;
    public final TextView tvPrompt;

    private BrvahQuickViewLoadMoreBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, LinearLayout linearLayout, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.loadMoreLoadCompleteView = frameLayout2;
        this.loadMoreLoadEndView = frameLayout3;
        this.loadMoreLoadFailView = frameLayout4;
        this.loadMoreLoadingView = linearLayout;
        this.loadingProgress = progressBar;
        this.loadingText = textView;
        this.tvPrompt = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BrvahQuickViewLoadMoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BrvahQuickViewLoadMoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.brvah_quick_view_load_more, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BrvahQuickViewLoadMoreBinding bind(View view) {
        int i = R.id.load_more_load_complete_view;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.load_more_load_end_view;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                i = R.id.load_more_load_fail_view;
                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout3 != null) {
                    i = R.id.load_more_loading_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.loading_progress;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R.id.loading_text;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_prompt;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new BrvahQuickViewLoadMoreBinding((FrameLayout) view, frameLayout, frameLayout2, frameLayout3, linearLayout, progressBar, textView, textView2);
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
