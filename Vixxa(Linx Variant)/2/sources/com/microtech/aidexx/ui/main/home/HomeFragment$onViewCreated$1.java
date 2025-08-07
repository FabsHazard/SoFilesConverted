package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.ui.main.MainActivity;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$onViewCreated$1 extends Lambda implements Function1<BaseEventEntity, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$onViewCreated$1(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BaseEventEntity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BaseEventEntity baseEventEntity) {
        Intrinsics.checkNotNullParameter(baseEventEntity, "it");
        MainActivity access$getMainActivity$p = this.this$0.mainActivity;
        if (access$getMainActivity$p == null || access$getMainActivity$p.getMCurrentOrientation() != 2) {
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_GO_TO_HISTORY, baseEventEntity);
            return;
        }
        HomeFragment homeFragment = this.this$0;
        homeFragment.orientation(homeFragment.switchOrientation);
        EventBusManager.INSTANCE.sendDelay(EventBusKey.EVENT_GO_TO_HISTORY, baseEventEntity, 500);
    }
}
