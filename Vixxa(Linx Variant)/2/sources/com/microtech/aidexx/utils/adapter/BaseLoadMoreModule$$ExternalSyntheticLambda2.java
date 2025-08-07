package com.microtech.aidexx.utils.adapter;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseLoadMoreModule$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ RecyclerView.LayoutManager f$0;
    public final /* synthetic */ BaseLoadMoreModule f$1;

    public /* synthetic */ BaseLoadMoreModule$$ExternalSyntheticLambda2(RecyclerView.LayoutManager layoutManager, BaseLoadMoreModule baseLoadMoreModule) {
        this.f$0 = layoutManager;
        this.f$1 = baseLoadMoreModule;
    }

    public final void run() {
        BaseLoadMoreModule.checkDisableLoadMoreIfNotFullPage$lambda$5(this.f$0, this.f$1);
    }
}
