package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity;
import com.microtech.aidexx.db.repository.EventDbRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/data/EventPresetSync$Companion$exercisePresetSync$1", "Lcom/microtech/aidexx/data/EventPresetSync;", "Lcom/microtech/aidexx/db/entity/event/preset/SportUsrPresetEntity;", "getNeedUploadData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventPresetSync.kt */
public final class EventPresetSync$Companion$exercisePresetSync$1 extends EventPresetSync<SportUsrPresetEntity> {
    EventPresetSync$Companion$exercisePresetSync$1() {
    }

    public Object getNeedUploadData(Continuation<? super List<SportUsrPresetEntity>> continuation) {
        return EventDbRepository.INSTANCE.getExerciseNeedUploadPreset(continuation);
    }
}
