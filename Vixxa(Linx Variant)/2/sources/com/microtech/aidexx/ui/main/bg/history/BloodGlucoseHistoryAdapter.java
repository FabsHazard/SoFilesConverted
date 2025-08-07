package com.microtech.aidexx.ui.main.bg.history;

import android.content.res.Resources;
import com.microtech.aidexx.R;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0014¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/history/BloodGlucoseHistoryAdapter;", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "()V", "convert", "", "holder", "item", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BloodGlucoseHistoryAdapter.kt */
public final class BloodGlucoseHistoryAdapter extends BaseQuickAdapter<BloodGlucoseEntity, BaseViewHolder> {
    public BloodGlucoseHistoryAdapter() {
        super(R.layout.item_glucose_history, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, BloodGlucoseEntity bloodGlucoseEntity) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(bloodGlucoseEntity, "item");
        int i = R.id.tvGlucoseTime;
        String string = baseViewHolder.itemView.getResources().getString(R.string.com_dateFormat_yyyyMMddHHmm);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        baseViewHolder.setText(i, (CharSequence) BaseEventEntity.getDisplayTime$default(bloodGlucoseEntity, string, false, 2, (Object) null));
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        String tagText = bloodGlucoseEntity.getTagText(resources);
        CharSequence charSequence = tagText;
        if (charSequence == null || charSequence.length() == 0) {
            tagText = "— —";
        }
        baseViewHolder.setText(R.id.tvGlucoseDescribe, (CharSequence) tagText);
        int i2 = R.id.tvGlucoseValue;
        Resources resources2 = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        baseViewHolder.setText(i2, (CharSequence) bloodGlucoseEntity.getValueDescription(resources2));
        if (baseViewHolder.getAbsoluteAdapterPosition() == getData().size() - 1) {
            baseViewHolder.setGone(R.id.viDivider, true);
        } else {
            baseViewHolder.setGone(R.id.viDivider, false);
        }
    }
}
