package com.microtech.aidexx.ui.main.event.adapter;

import android.view.View;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.db.entity.event.EventActions;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B8\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014R,\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/adapter/EventPresetAdapter;", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "data", "", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "convert", "holder", "item", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventPresetAdapter.kt */
public final class EventPresetAdapter extends BaseQuickAdapter<BasePresetEntity, BaseViewHolder> {
    private final Function1<Integer, Unit> onItemClick;

    public final Function1<Integer, Unit> getOnItemClick() {
        return this.onItemClick;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventPresetAdapter(List<? extends BasePresetEntity> list, Function1<? super Integer, Unit> function1) {
        super(R.layout.item_preset_search, TypeIntrinsics.asMutableList(list));
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        this.onItemClick = function1;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, BasePresetEntity basePresetEntity) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(basePresetEntity, "item");
        ((FlexboxLayout) baseViewHolder.getView(R.id.flItem)).setOnClickListener(new EventPresetAdapter$$ExternalSyntheticLambda0(this, baseViewHolder));
        boolean z = true;
        ((TextView) baseViewHolder.getView(R.id.tvContent)).setText(EventActions.DefaultImpls.getEventDesc$default(basePresetEntity, (String) null, 1, (Object) null));
        int i = R.id.ivFoodCustom;
        if (basePresetEntity.isUserInputType() || !basePresetEntity.isUserPreset()) {
            z = false;
        }
        baseViewHolder.setVisible(i, z);
        baseViewHolder.setVisible(R.id.ivFoodInputIcon, basePresetEntity.isUserInputType());
    }

    /* access modifiers changed from: private */
    public static final void convert$lambda$2$lambda$1$lambda$0(EventPresetAdapter eventPresetAdapter, BaseViewHolder baseViewHolder, View view) {
        Intrinsics.checkNotNullParameter(eventPresetAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseViewHolder, "$this_apply");
        eventPresetAdapter.onItemClick.invoke(Integer.valueOf(baseViewHolder.getAdapterPosition()));
    }
}
