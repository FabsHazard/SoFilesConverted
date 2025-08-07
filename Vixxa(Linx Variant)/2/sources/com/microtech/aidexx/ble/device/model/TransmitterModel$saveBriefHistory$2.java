package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import io.objectbox.Box;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$saveBriefHistory$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $goon;
    final /* synthetic */ List<AidexXHistoryEntity> $histories;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$saveBriefHistory$2(TransmitterModel transmitterModel, List<AidexXHistoryEntity> list, boolean z) {
        super(0);
        this.this$0 = transmitterModel;
        this.$histories = list;
        this.$goon = z;
    }

    public final void invoke() {
        this.this$0.getEntity().setEventIndex(((AidexXHistoryEntity) CollectionsKt.last(this.$histories)).timeOffset);
        TransmitterModel transmitterModel = this.this$0;
        transmitterModel.setNextEventIndex(transmitterModel.getEntity().getEventIndex() + 1);
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        transmitterBox.put(this.this$0.getEntity());
        if (UserInfoManager.Companion.getShareUserInfo() == null) {
            EventBusManager eventBusManager = EventBusManager.INSTANCE;
            DataChangedType dataChangedType = DataChangedType.ADD;
            List arrayList = new ArrayList();
            arrayList.addAll(this.this$0.tempBriefList);
            Unit unit = Unit.INSTANCE;
            eventBusManager.send(EventBusKey.EVENT_DATA_CHANGED, new Pair(dataChangedType, arrayList));
        }
        this.this$0.tempBriefList.clear();
        if (this.$goon) {
            this.this$0.continueBriefFetch();
        }
    }
}
