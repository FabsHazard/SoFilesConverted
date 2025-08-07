package com.microtech.aidexx.utils.adapter;

import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseQuickAdapter$$ExternalSyntheticLambda1 implements View.OnLongClickListener {
    public final /* synthetic */ BaseViewHolder f$0;
    public final /* synthetic */ BaseQuickAdapter f$1;

    public /* synthetic */ BaseQuickAdapter$$ExternalSyntheticLambda1(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter) {
        this.f$0 = baseViewHolder;
        this.f$1 = baseQuickAdapter;
    }

    public final boolean onLongClick(View view) {
        return BaseQuickAdapter.bindViewClickListener$lambda$9$lambda$8(this.f$0, this.f$1, view);
    }
}
