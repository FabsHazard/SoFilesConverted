package com.microtech.aidexx.ui.main.event.dialog;

import android.view.View;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.OnItemClickListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SportPresetDialog$$ExternalSyntheticLambda0 implements OnItemClickListener {
    public final /* synthetic */ SportPresetDialog f$0;
    public final /* synthetic */ SpecificationAdapter f$1;

    public /* synthetic */ SportPresetDialog$$ExternalSyntheticLambda0(SportPresetDialog sportPresetDialog, SpecificationAdapter specificationAdapter) {
        this.f$0 = sportPresetDialog;
        this.f$1 = specificationAdapter;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        SportPresetDialog.initUnitUi$lambda$14$lambda$13(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
