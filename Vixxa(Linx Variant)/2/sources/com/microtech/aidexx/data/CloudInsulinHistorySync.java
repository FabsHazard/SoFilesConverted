package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.repository.EventDbRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/data/CloudInsulinHistorySync;", "Lcom/microtech/aidexx/data/EventHistorySync;", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "()V", "getNeedUploadData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CloudInsulinHistorySync.kt */
public final class CloudInsulinHistorySync extends EventHistorySync<InsulinEntity> {
    public static final CloudInsulinHistorySync INSTANCE = new CloudInsulinHistorySync();

    private CloudInsulinHistorySync() {
    }

    public Object getNeedUploadData(Continuation<? super List<InsulinEntity>> continuation) {
        return EventDbRepository.getInsulinNeedUploadEvent$default(EventDbRepository.INSTANCE, (String) null, continuation, 1, (Object) null);
    }
}
