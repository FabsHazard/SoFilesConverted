package com.microtech.aidexx.service.push;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.repository.EventDbRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/service/push/PushExerciseMsg;", "Lcom/microtech/aidexx/service/push/PushMessage;", "data", "Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "(Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;)V", "getData", "()Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "applyToDb", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PushMessage.kt */
public final class PushExerciseMsg extends PushMessage {
    private final ExerciseEntity data;

    public static /* synthetic */ PushExerciseMsg copy$default(PushExerciseMsg pushExerciseMsg, ExerciseEntity exerciseEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            exerciseEntity = pushExerciseMsg.data;
        }
        return pushExerciseMsg.copy(exerciseEntity);
    }

    public final ExerciseEntity component1() {
        return this.data;
    }

    public final PushExerciseMsg copy(ExerciseEntity exerciseEntity) {
        return new PushExerciseMsg(exerciseEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PushExerciseMsg) && Intrinsics.areEqual((Object) this.data, (Object) ((PushExerciseMsg) obj).data);
    }

    public int hashCode() {
        ExerciseEntity exerciseEntity = this.data;
        if (exerciseEntity == null) {
            return 0;
        }
        return exerciseEntity.hashCode();
    }

    public String toString() {
        return "PushExerciseMsg(data=" + this.data + ')';
    }

    public final ExerciseEntity getData() {
        return this.data;
    }

    public PushExerciseMsg(ExerciseEntity exerciseEntity) {
        this.data = exerciseEntity;
    }

    public Object applyToDb(Continuation<? super BaseEventEntity> continuation) {
        String exerciseId;
        ExerciseEntity exerciseEntity = this.data;
        if (exerciseEntity == null || (exerciseId = exerciseEntity.getExerciseId()) == null) {
            return null;
        }
        Object removeEventByFrontId = EventDbRepository.INSTANCE.removeEventByFrontId(exerciseId, ExerciseEntity.class, continuation);
        return removeEventByFrontId == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? removeEventByFrontId : (ExerciseEntity) removeEventByFrontId;
    }
}
