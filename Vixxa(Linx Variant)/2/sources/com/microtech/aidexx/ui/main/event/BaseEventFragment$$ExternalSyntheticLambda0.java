package com.microtech.aidexx.ui.main.event;

import android.view.View;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.OnItemClickListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseEventFragment$$ExternalSyntheticLambda0 implements OnItemClickListener {
    public final /* synthetic */ BaseEventFragment f$0;

    public /* synthetic */ BaseEventFragment$$ExternalSyntheticLambda0(BaseEventFragment baseEventFragment) {
        this.f$0 = baseEventFragment;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        BaseEventFragment.initHistory$lambda$3(this.f$0, baseQuickAdapter, view, i);
    }
}
