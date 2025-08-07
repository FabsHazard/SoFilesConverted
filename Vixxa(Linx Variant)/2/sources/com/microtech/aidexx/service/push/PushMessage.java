package com.microtech.aidexx.service.push;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001aH\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/microtech/aidexx/service/push/PushMessage;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "detail", "getDetail", "messageId", "getMessageId", "setMessageId", "(Ljava/lang/String;)V", "msgType", "", "getMsgType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "taskId", "getTaskId", "setTaskId", "applyMsg", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyToDb", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "getRealMsgByType", "notifyEventDataChanged", "", "event", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PushMessage.kt */
public class PushMessage {
    private final String TAG = "PushMessage";
    private final String detail;
    private String messageId;
    private final Integer msgType;
    private String taskId;

    static /* synthetic */ Object applyToDb$suspendImpl(PushMessage pushMessage, Continuation<? super BaseEventEntity> continuation) {
        return null;
    }

    public Object applyMsg(Continuation<? super Boolean> continuation) {
        return applyMsg$suspendImpl(this, continuation);
    }

    public Object applyToDb(Continuation<? super BaseEventEntity> continuation) {
        return applyToDb$suspendImpl(this, continuation);
    }

    /* access modifiers changed from: protected */
    public final String getTAG() {
        return this.TAG;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    public final Integer getMsgType() {
        return this.msgType;
    }

    public final String getDetail() {
        return this.detail;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
        if (r2.intValue() == 3) goto L_0x0034;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007b A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0097 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b2 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d0 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ee A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.microtech.aidexx.service.push.PushMessage getRealMsgByType() {
        /*
            r5 = this;
            com.google.gson.GsonBuilder r0 = new com.google.gson.GsonBuilder
            r0.<init>()
            java.lang.String r1 = "yyyy-MM-dd HH:mm:ssZ"
            com.google.gson.GsonBuilder r0 = r0.setDateFormat((java.lang.String) r1)
            com.google.gson.Gson r0 = r0.create()
            r1 = 0
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0106 }
            java.lang.Integer r2 = r5.msgType     // Catch:{ all -> 0x0106 }
            if (r2 != 0) goto L_0x0017
            goto L_0x001f
        L_0x0017:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 1
            if (r3 != r4) goto L_0x001f
            goto L_0x0034
        L_0x001f:
            if (r2 != 0) goto L_0x0022
            goto L_0x002a
        L_0x0022:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 2
            if (r3 != r4) goto L_0x002a
            goto L_0x0034
        L_0x002a:
            if (r2 != 0) goto L_0x002d
            goto L_0x003e
        L_0x002d:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 3
            if (r3 != r4) goto L_0x003e
        L_0x0034:
            com.microtech.aidexx.service.push.PushCgmMsg r0 = new com.microtech.aidexx.service.push.PushCgmMsg     // Catch:{ all -> 0x0106 }
            r0.<init>()     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r0 = (com.microtech.aidexx.service.push.PushMessage) r0     // Catch:{ all -> 0x0106 }
        L_0x003b:
            r1 = r0
            goto L_0x00ff
        L_0x003e:
            if (r2 != 0) goto L_0x0041
            goto L_0x005c
        L_0x0041:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 4
            if (r3 != r4) goto L_0x005c
            com.microtech.aidexx.service.push.PushDietMsg r2 = new com.microtech.aidexx.service.push.PushDietMsg     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r5.detail     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.microtech.aidexx.db.entity.event.DietEntity> r4 = com.microtech.aidexx.db.entity.event.DietEntity.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r3, r4)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.db.entity.event.DietEntity r0 = (com.microtech.aidexx.db.entity.event.DietEntity) r0     // Catch:{ all -> 0x0106 }
            r2.<init>(r0)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r2 = (com.microtech.aidexx.service.push.PushMessage) r2     // Catch:{ all -> 0x0106 }
        L_0x0059:
            r1 = r2
            goto L_0x00ff
        L_0x005c:
            if (r2 != 0) goto L_0x005f
            goto L_0x0078
        L_0x005f:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 5
            if (r3 != r4) goto L_0x0078
            com.microtech.aidexx.service.push.PushExerciseMsg r2 = new com.microtech.aidexx.service.push.PushExerciseMsg     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r5.detail     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.microtech.aidexx.db.entity.event.ExerciseEntity> r4 = com.microtech.aidexx.db.entity.event.ExerciseEntity.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r3, r4)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.db.entity.event.ExerciseEntity r0 = (com.microtech.aidexx.db.entity.event.ExerciseEntity) r0     // Catch:{ all -> 0x0106 }
            r2.<init>(r0)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r2 = (com.microtech.aidexx.service.push.PushMessage) r2     // Catch:{ all -> 0x0106 }
            goto L_0x0059
        L_0x0078:
            if (r2 != 0) goto L_0x007b
            goto L_0x0094
        L_0x007b:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 6
            if (r3 != r4) goto L_0x0094
            com.microtech.aidexx.service.push.PushMedicationMsg r2 = new com.microtech.aidexx.service.push.PushMedicationMsg     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r5.detail     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.microtech.aidexx.db.entity.event.MedicationEntity> r4 = com.microtech.aidexx.db.entity.event.MedicationEntity.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r3, r4)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.db.entity.event.MedicationEntity r0 = (com.microtech.aidexx.db.entity.event.MedicationEntity) r0     // Catch:{ all -> 0x0106 }
            r2.<init>(r0)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r2 = (com.microtech.aidexx.service.push.PushMessage) r2     // Catch:{ all -> 0x0106 }
            goto L_0x0059
        L_0x0094:
            if (r2 != 0) goto L_0x0097
            goto L_0x00b0
        L_0x0097:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 7
            if (r3 != r4) goto L_0x00b0
            com.microtech.aidexx.service.push.PushInsulinMsg r2 = new com.microtech.aidexx.service.push.PushInsulinMsg     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r5.detail     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.microtech.aidexx.db.entity.event.InsulinEntity> r4 = com.microtech.aidexx.db.entity.event.InsulinEntity.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r3, r4)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.db.entity.event.InsulinEntity r0 = (com.microtech.aidexx.db.entity.event.InsulinEntity) r0     // Catch:{ all -> 0x0106 }
            r2.<init>(r0)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r2 = (com.microtech.aidexx.service.push.PushMessage) r2     // Catch:{ all -> 0x0106 }
            goto L_0x0059
        L_0x00b0:
            if (r2 != 0) goto L_0x00b3
            goto L_0x00cd
        L_0x00b3:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 8
            if (r3 != r4) goto L_0x00cd
            com.microtech.aidexx.service.push.PushOtherMsg r2 = new com.microtech.aidexx.service.push.PushOtherMsg     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r5.detail     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.microtech.aidexx.db.entity.event.OthersEntity> r4 = com.microtech.aidexx.db.entity.event.OthersEntity.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r3, r4)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.db.entity.event.OthersEntity r0 = (com.microtech.aidexx.db.entity.event.OthersEntity) r0     // Catch:{ all -> 0x0106 }
            r2.<init>(r0)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r2 = (com.microtech.aidexx.service.push.PushMessage) r2     // Catch:{ all -> 0x0106 }
            goto L_0x0059
        L_0x00cd:
            if (r2 != 0) goto L_0x00d0
            goto L_0x00eb
        L_0x00d0:
            int r3 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r4 = 9
            if (r3 != r4) goto L_0x00eb
            com.microtech.aidexx.service.push.PushBgMsg r2 = new com.microtech.aidexx.service.push.PushBgMsg     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r5.detail     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.microtech.aidexx.db.entity.BloodGlucoseEntity> r4 = com.microtech.aidexx.db.entity.BloodGlucoseEntity.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r3, r4)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.db.entity.BloodGlucoseEntity r0 = (com.microtech.aidexx.db.entity.BloodGlucoseEntity) r0     // Catch:{ all -> 0x0106 }
            r2.<init>(r0)     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r2 = (com.microtech.aidexx.service.push.PushMessage) r2     // Catch:{ all -> 0x0106 }
            goto L_0x0059
        L_0x00eb:
            if (r2 != 0) goto L_0x00ee
            goto L_0x00ff
        L_0x00ee:
            int r0 = r2.intValue()     // Catch:{ all -> 0x0106 }
            r2 = 10
            if (r0 != r2) goto L_0x00ff
            com.microtech.aidexx.service.push.PushLogMsg r0 = new com.microtech.aidexx.service.push.PushLogMsg     // Catch:{ all -> 0x0106 }
            r0.<init>()     // Catch:{ all -> 0x0106 }
            com.microtech.aidexx.service.push.PushMessage r0 = (com.microtech.aidexx.service.push.PushMessage) r0     // Catch:{ all -> 0x0106 }
            goto L_0x003b
        L_0x00ff:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0106 }
            java.lang.Object r0 = kotlin.Result.m343constructorimpl(r0)     // Catch:{ all -> 0x0106 }
            goto L_0x0111
        L_0x0106:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m343constructorimpl(r0)
        L_0x0111:
            java.lang.Throwable r0 = kotlin.Result.m346exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x013c
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getRealMsgByType fail detail="
            r3.<init>(r4)
            java.lang.String r4 = r5.detail
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = "  error="
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = r5.TAG
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r2.xLogE(r0, r3)
        L_0x013c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.service.push.PushMessage.getRealMsgByType():com.microtech.aidexx.service.push.PushMessage");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object applyMsg$suspendImpl(com.microtech.aidexx.service.push.PushMessage r4, kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            boolean r0 = r5 instanceof com.microtech.aidexx.service.push.PushMessage$applyMsg$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.microtech.aidexx.service.push.PushMessage$applyMsg$1 r0 = (com.microtech.aidexx.service.push.PushMessage$applyMsg$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.service.push.PushMessage$applyMsg$1 r0 = new com.microtech.aidexx.service.push.PushMessage$applyMsg$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            com.microtech.aidexx.service.push.PushMessage r4 = (com.microtech.aidexx.service.push.PushMessage) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.applyToDb(r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            com.microtech.aidexx.db.entity.BaseEventEntity r5 = (com.microtech.aidexx.db.entity.BaseEventEntity) r5
            if (r5 == 0) goto L_0x004c
            r4.notifyEventDataChanged(r5)
            goto L_0x004d
        L_0x004c:
            r3 = 0
        L_0x004d:
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.service.push.PushMessage.applyMsg$suspendImpl(com.microtech.aidexx.service.push.PushMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void notifyEventDataChanged(BaseEventEntity baseEventEntity) {
        EventBusManager.INSTANCE.send(EventBusKey.EVENT_DATA_CHANGED, new Pair(DataChangedType.DELETE, CollectionsKt.listOf(baseEventEntity)));
    }
}
