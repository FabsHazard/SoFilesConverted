package com.microtech.aidexx.ui.main.event.adapter;

import com.flyco.roundview.RoundTextView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.db.entity.event.EventActions;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/adapter/EventInputAdapter;", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "Lcom/microtech/aidexx/db/entity/event/EventActions;", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "data", "", "isHistory", "", "(Ljava/util/List;Z)V", "convert", "", "holder", "item", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventInputAdapter.kt */
public final class EventInputAdapter extends BaseQuickAdapter<EventActions, BaseViewHolder> {
    private final boolean isHistory;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EventInputAdapter(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventInputAdapter(List<? extends EventActions> list, boolean z) {
        super(R.layout.item_border_text, TypeIntrinsics.asMutableList(list));
        Intrinsics.checkNotNullParameter(list, "data");
        this.isHistory = z;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, EventActions eventActions) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(eventActions, "item");
        RoundTextView roundTextView = (RoundTextView) baseViewHolder.getView(R.id.tvContent);
        roundTextView.setText(EventActions.DefaultImpls.getEventDesc$default(eventActions, (String) null, 1, (Object) null));
        roundTextView.getDelegate().setStrokeColor(baseViewHolder.itemView.getResources().getColor(this.isHistory ? R.color.event_tag_border : R.color.event_tag_color_selected, baseViewHolder.itemView.getContext().getTheme()));
        roundTextView.setTextColor(baseViewHolder.itemView.getResources().getColor(this.isHistory ? R.color.event_tag_color : R.color.event_tag_color_selected, baseViewHolder.itemView.getContext().getTheme()));
    }
}
