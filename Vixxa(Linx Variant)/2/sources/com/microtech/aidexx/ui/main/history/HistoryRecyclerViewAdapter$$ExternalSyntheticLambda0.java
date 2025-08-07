package com.microtech.aidexx.ui.main.history;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HistoryRecyclerViewAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ HistoryDetailModel f$0;
    public final /* synthetic */ HistoryRecyclerViewAdapter f$1;
    public final /* synthetic */ TextView f$2;
    public final /* synthetic */ ImageView f$3;

    public /* synthetic */ HistoryRecyclerViewAdapter$$ExternalSyntheticLambda0(HistoryDetailModel historyDetailModel, HistoryRecyclerViewAdapter historyRecyclerViewAdapter, TextView textView, ImageView imageView) {
        this.f$0 = historyDetailModel;
        this.f$1 = historyRecyclerViewAdapter;
        this.f$2 = textView;
        this.f$3 = imageView;
    }

    public final void onClick(View view) {
        HistoryRecyclerViewAdapter.setCollapse$lambda$2(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
