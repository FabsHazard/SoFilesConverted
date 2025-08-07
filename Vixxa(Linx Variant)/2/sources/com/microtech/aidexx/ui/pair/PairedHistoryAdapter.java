package com.microtech.aidexx.ui.pair;

import android.content.Context;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/ui/pair/PairedHistoryAdapter;", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "()V", "convert", "", "holder", "item", "onBindViewHolder", "position", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairedHistoryAdapter.kt */
public final class PairedHistoryAdapter extends BaseQuickAdapter<HistoryDeviceInfo, BaseViewHolder> {
    public PairedHistoryAdapter() {
        super(R.layout.item_paired_history, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, HistoryDeviceInfo historyDeviceInfo) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(historyDeviceInfo, "item");
        baseViewHolder.setText(R.id.history_device_sn, (CharSequence) getContext().getString(R.string.ble_history_sn, new Object[]{historyDeviceInfo.getDeviceSn()}));
        int i = R.id.history_device_time;
        Context context = getContext();
        int i2 = R.string.ble_history_time;
        Date registerTime = historyDeviceInfo.getRegisterTime();
        baseViewHolder.setText(i, (CharSequence) context.getString(i2, new Object[]{registerTime != null ? ExtendsKt.formatToYMdHm(registerTime) : null}));
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        super.onBindViewHolder(baseViewHolder, i);
    }
}
