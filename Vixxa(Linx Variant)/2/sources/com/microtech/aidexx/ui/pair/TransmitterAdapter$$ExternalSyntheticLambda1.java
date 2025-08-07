package com.microtech.aidexx.ui.pair;

import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TransmitterAdapter$$ExternalSyntheticLambda1 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ TransmitterAdapter f$0;
    public final /* synthetic */ RecyclerView.ViewHolder f$1;

    public /* synthetic */ TransmitterAdapter$$ExternalSyntheticLambda1(TransmitterAdapter transmitterAdapter, RecyclerView.ViewHolder viewHolder) {
        this.f$0 = transmitterAdapter;
        this.f$1 = viewHolder;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        TransmitterAdapter.onBindViewHolder$lambda$2(this.f$0, this.f$1, compoundButton, z);
    }
}
