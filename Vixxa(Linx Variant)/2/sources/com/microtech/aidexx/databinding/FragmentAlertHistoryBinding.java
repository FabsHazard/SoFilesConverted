package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class FragmentAlertHistoryBinding implements ViewBinding {
    public final TextView noDataView;
    private final LinearLayout rootView;
    public final RecyclerView rvHistoryDetail;

    private FragmentAlertHistoryBinding(LinearLayout linearLayout, TextView textView, RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.noDataView = textView;
        this.rvHistoryDetail = recyclerView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAlertHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentAlertHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_alert_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAlertHistoryBinding bind(View view) {
        int i = R.id.noDataView;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.rvHistoryDetail;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                return new FragmentAlertHistoryBinding((LinearLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
