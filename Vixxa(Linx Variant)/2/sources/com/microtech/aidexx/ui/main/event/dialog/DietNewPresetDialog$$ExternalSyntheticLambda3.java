package com.microtech.aidexx.ui.main.event.dialog;

import android.view.View;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.OnItemClickListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DietNewPresetDialog$$ExternalSyntheticLambda3 implements OnItemClickListener {
    public final /* synthetic */ DietNewPresetDialog f$0;
    public final /* synthetic */ SpecificationAdapter f$1;

    public /* synthetic */ DietNewPresetDialog$$ExternalSyntheticLambda3(DietNewPresetDialog dietNewPresetDialog, SpecificationAdapter specificationAdapter) {
        this.f$0 = dietNewPresetDialog;
        this.f$1 = specificationAdapter;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        DietNewPresetDialog.initUnitUi$lambda$16$lambda$15(this.f$0, this.f$1, baseQuickAdapter, view, i);
    }
}
