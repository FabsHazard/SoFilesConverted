package com.microtech.aidexx.service.push;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.db.repository.EventDbRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/service/push/PushOtherMsg;", "Lcom/microtech/aidexx/service/push/PushMessage;", "data", "Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "(Lcom/microtech/aidexx/db/entity/event/OthersEntity;)V", "getData", "()Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "applyToDb", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PushMessage.kt */
public final class PushOtherMsg extends PushMessage {
    private final OthersEntity data;

    public static /* synthetic */ PushOtherMsg copy$default(PushOtherMsg pushOtherMsg, OthersEntity othersEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            othersEntity = pushOtherMsg.data;
        }
        return pushOtherMsg.copy(othersEntity);
    }

    public final OthersEntity component1() {
        return this.data;
    }

    public final PushOtherMsg copy(OthersEntity othersEntity) {
        return new PushOtherMsg(othersEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PushOtherMsg) && Intrinsics.areEqual((Object) this.data, (Object) ((PushOtherMsg) obj).data);
    }

    public int hashCode() {
        OthersEntity othersEntity = this.data;
        if (othersEntity == null) {
            return 0;
        }
        return othersEntity.hashCode();
    }

    public String toString() {
        return "PushOtherMsg(data=" + this.data + ')';
    }

    public final OthersEntity getData() {
        return this.data;
    }

    public PushOtherMsg(OthersEntity othersEntity) {
        this.data = othersEntity;
    }

    public Object applyToDb(Continuation<? super BaseEventEntity> continuation) {
        String otherId;
        OthersEntity othersEntity = this.data;
        if (othersEntity == null || (otherId = othersEntity.getOtherId()) == null) {
            return null;
        }
        Object removeEventByFrontId = EventDbRepository.INSTANCE.removeEventByFrontId(otherId, OthersEntity.class, continuation);
        return removeEventByFrontId == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? removeEventByFrontId : (OthersEntity) removeEventByFrontId;
    }
}
