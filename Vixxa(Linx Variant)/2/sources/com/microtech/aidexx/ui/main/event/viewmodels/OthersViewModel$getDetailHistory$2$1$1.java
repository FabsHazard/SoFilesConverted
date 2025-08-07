package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.db.entity.event.BaseEventDetail;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/microtech/aidexx/ui/main/event/viewmodels/OthersViewModel$getDetailHistory$2$1$1", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "getCurrClassMutableListType", "Ljava/lang/reflect/Type;", "getEventDesc", "", "splitter", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OthersViewModel.kt */
public final class OthersViewModel$getDetailHistory$2$1$1 extends BaseEventDetail {
    OthersViewModel$getDetailHistory$2$1$1() {
    }

    public String getEventDesc(String str) {
        return getName();
    }

    public Type getCurrClassMutableListType() {
        Type type = new OthersViewModel$getDetailHistory$2$1$1$getCurrClassMutableListType$$inlined$getMutableListType$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getMutableListType(...)");
        return type;
    }
}
