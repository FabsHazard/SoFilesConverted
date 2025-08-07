package com.microtech.aidexx.ui.main.event.dialog;

import android.view.View;
import com.microtech.aidexx.ui.main.event.adapter.SpecificationAdapter;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.OnItemClickListener;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MedicinePresetDialog$$ExternalSyntheticLambda0 implements OnItemClickListener {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ SpecificationAdapter f$1;
    public final /* synthetic */ MedicinePresetDialog f$2;

    public /* synthetic */ MedicinePresetDialog$$ExternalSyntheticLambda0(List list, SpecificationAdapter specificationAdapter, MedicinePresetDialog medicinePresetDialog) {
        this.f$0 = list;
        this.f$1 = specificationAdapter;
        this.f$2 = medicinePresetDialog;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        MedicinePresetDialog.initUnitUi$lambda$16$lambda$15(this.f$0, this.f$1, this.f$2, baseQuickAdapter, view, i);
    }
}
