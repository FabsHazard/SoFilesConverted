package com.microtech.aidexx.ui.main.trend.view;

import android.content.Context;
import com.microtech.aidexx.ui.main.trend.MultiDayBgItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "mutableList", "", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "b", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ExpandableGrid.kt */
final class ExpandableGrid$init$2 extends Lambda implements Function2<List<MultiDayBgItem>, Boolean, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ExpandableGrid this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpandableGrid$init$2(ExpandableGrid expandableGrid, Context context) {
        super(2);
        this.this$0 = expandableGrid;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((List<MultiDayBgItem>) (List) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(List<MultiDayBgItem> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "mutableList");
        Function1<List<MultiDayBgItem>, Unit> onDataChange = this.this$0.getOnDataChange();
        if (onDataChange != null) {
            onDataChange.invoke(list);
        }
        if (z) {
            this.this$0.switchOn(this.$context);
        } else {
            this.this$0.switchOff(this.$context);
        }
    }
}
