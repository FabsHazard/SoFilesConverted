package com.microtech.aidexx.ui.main.event.dialog;

import android.view.View;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.OnItemClickListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DietPresetDialog$$ExternalSyntheticLambda6 implements OnItemClickListener {
    public final /* synthetic */ DietPresetDialog f$0;
    public final /* synthetic */ SpecificationAdapter f$1;

    public /* synthetic */ DietPresetDialog$$ExternalSyntheticLambda6(DietPresetDialog dietPresetDialog, SpecificationAdapter specificationAdapter) {
        this.f$0 = dietPresetDialog;
        this.f$1 = specificationAdapter;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        DietPresetDialog.initUnitUi$lambda$17$lambda$16(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
