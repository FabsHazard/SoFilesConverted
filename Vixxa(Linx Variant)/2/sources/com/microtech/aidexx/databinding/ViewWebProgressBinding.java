package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class ViewWebProgressBinding implements ViewBinding {
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final WebView webView;

    private ViewWebProgressBinding(RelativeLayout relativeLayout, ProgressBar progressBar2, WebView webView2) {
        this.rootView = relativeLayout;
        this.progressBar = progressBar2;
        this.webView = webView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewWebProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewWebProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_web_progress, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewWebProgressBinding bind(View view) {
        int i = R.id.progress_bar;
        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar2 != null) {
            i = R.id.web_view;
            WebView webView2 = (WebView) ViewBindings.findChildViewById(view, i);
            if (webView2 != null) {
                return new ViewWebProgressBinding((RelativeLayout) view, progressBar2, webView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
