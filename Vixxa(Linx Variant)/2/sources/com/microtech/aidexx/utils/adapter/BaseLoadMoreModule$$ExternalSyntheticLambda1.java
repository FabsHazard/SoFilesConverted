package com.microtech.aidexx.utils.adapter;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseLoadMoreModule$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ BaseLoadMoreModule f$0;
    public final /* synthetic */ RecyclerView.LayoutManager f$1;

    public /* synthetic */ BaseLoadMoreModule$$ExternalSyntheticLambda1(BaseLoadMoreModule baseLoadMoreModule, RecyclerView.LayoutManager layoutManager) {
        this.f$0 = baseLoadMoreModule;
        this.f$1 = layoutManager;
    }

    public final void run() {
        BaseLoadMoreModule.checkDisableLoadMoreIfNotFullPage$lambda$4(this.f$0, this.f$1);
    }
}
