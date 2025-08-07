package com.microtech.aidexx.ui.main.event.adapter;

import android.widget.TextView;
import com.flyco.roundview.RoundFrameLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.data.resource.SpecificationModel;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/adapter/SpecificationAdapter;", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "Lcom/microtech/aidexx/data/resource/SpecificationModel;", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SpecificationAdapter.kt */
public final class SpecificationAdapter extends BaseQuickAdapter<SpecificationModel, BaseViewHolder> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecificationAdapter(List<SpecificationModel> list) {
        super(R.layout.item_specification, list);
        Intrinsics.checkNotNullParameter(list, "data");
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, SpecificationModel specificationModel) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(specificationModel, "item");
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvSpecification);
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) baseViewHolder.getView(R.id.flSpecificationContainer);
        baseViewHolder.setText(R.id.tvSpecification, (CharSequence) specificationModel.getSpecification());
        textView.setTextColor(baseViewHolder.itemView.getResources().getColor(specificationModel.getCheck() ? R.color.event_tag_color_selected : R.color.event_unit_color, baseViewHolder.itemView.getContext().getTheme()));
        roundFrameLayout.getDelegate().setStrokeColor(baseViewHolder.itemView.getResources().getColor(specificationModel.getCheck() ? R.color.event_tag_color_selected : R.color.event_unit_border, baseViewHolder.itemView.getContext().getTheme()));
    }
}
