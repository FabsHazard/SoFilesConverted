package com.microtech.aidexx.ui.setting.profile.health;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MenuListAdapter$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ MenuCheckItem f$0;
    public final /* synthetic */ MenuListAdapter f$1;
    public final /* synthetic */ BaseViewHolder f$2;
    public final /* synthetic */ CheckBox f$3;

    public /* synthetic */ MenuListAdapter$$ExternalSyntheticLambda0(MenuCheckItem menuCheckItem, MenuListAdapter menuListAdapter, BaseViewHolder baseViewHolder, CheckBox checkBox) {
        this.f$0 = menuCheckItem;
        this.f$1 = menuListAdapter;
        this.f$2 = baseViewHolder;
        this.f$3 = checkBox;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MenuListAdapter.convert$lambda$2$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, compoundButton, z);
    }
}
