package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;

public final class ItemPairedHistoryFooterBinding implements ViewBinding {
    public final ConstraintLayout historyDeviceFooter;
    private final ConstraintLayout rootView;

    private ItemPairedHistoryFooterBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.historyDeviceFooter = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPairedHistoryFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPairedHistoryFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_paired_history_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPairedHistoryFooterBinding bind(View view) {
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new ItemPairedHistoryFooterBinding(constraintLayout, constraintLayout);
        }
        throw new NullPointerException("rootView");
    }
}
