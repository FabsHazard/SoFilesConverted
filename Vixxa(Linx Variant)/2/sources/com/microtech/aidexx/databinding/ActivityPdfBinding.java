package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.github.barteksc.pdfviewer.PDFView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityPdfBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final PDFView pvReport;
    private final LinearLayout rootView;

    private ActivityPdfBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, PDFView pDFView) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.pvReport = pDFView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPdfBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPdfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_pdf, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPdfBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.pv_report;
            PDFView pDFView = (PDFView) ViewBindings.findChildViewById(view, i);
            if (pDFView != null) {
                return new ActivityPdfBinding((LinearLayout) view, actionBarWidget, pDFView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
