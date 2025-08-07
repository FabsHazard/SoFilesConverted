package com.microtech.aidexx.ui.main.event;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H@¨\u0006\b"}, d2 = {"<anonymous>", "", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "", "", "com/microtech/aidexx/common/net/repository/EventRepository$syncEventPreset$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1", f = "EventRepository.kt", i = {0, 1, 2}, l = {598, 606, 445, 455}, m = "invokeSuspend", n = {"$this$callbackFlow", "$this$callbackFlow", "$this$callbackFlow"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: EventRepository.kt */
public final class EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends Boolean, ? extends Integer>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPullDesc;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1(boolean z, String str, Continuation continuation) {
        super(2, continuation);
        this.$isPullDesc = z;
        this.$userId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1 eventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1 = new EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1(this.$isPullDesc, this.$userId, continuation);
        eventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1.L$0 = obj;
        return eventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1;
    }

    public final Object invoke(ProducerScope<? super Pair<Boolean, Integer>> producerScope, Continuation<? super Unit> continuation) {
        return ((EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r8) goto L_0x0039
            if (r2 == r7) goto L_0x002f
            if (r2 == r6) goto L_0x0026
            if (r2 != r5) goto L_0x001e
            kotlin.ResultKt.throwOnFailure(r23)
            goto L_0x010b
        L_0x001e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0026:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r23)
            goto L_0x00fd
        L_0x002f:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r23)
            r7 = r23
            goto L_0x0083
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r23)
            r7 = r23
            goto L_0x00c0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r23)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            boolean r10 = r0.$isPullDesc
            if (r10 != 0) goto L_0x0097
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity> r10 = com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity.class
            kotlin.reflect.KClass r10 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r10)
            boolean r10 = r10 instanceof com.microtech.aidexx.db.entity.event.preset.BaseSysPreset
            if (r10 == 0) goto L_0x005a
            goto L_0x0097
        L_0x005a:
            com.microtech.aidexx.db.repository.EventDbRepository r10 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            com.microtech.aidexx.db.dao.EventDao r10 = com.microtech.aidexx.db.dao.EventDao.INSTANCE
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity> r11 = com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity.class
            io.objectbox.Property r10 = r10.getPresetIdPropertyByClazz(r11)
            if (r10 != 0) goto L_0x0068
            r7 = r9
            goto L_0x0083
        L_0x0068:
            com.microtech.aidexx.db.ObjectBox r11 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ui.main.event.EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1$2 r12 = new com.microtech.aidexx.ui.main.event.EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1$2
            r12.<init>(r10)
            java.util.concurrent.Callable r12 = (java.util.concurrent.Callable) r12
            io.objectbox.BoxStore r10 = r11.getStore()
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r2
            r0.label = r7
            java.lang.Object r7 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r10, r12, r11)
            if (r7 != r1) goto L_0x0083
            return r1
        L_0x0083:
            java.lang.Long r7 = (java.lang.Long) r7
            if (r7 == 0) goto L_0x0093
            java.lang.Number r7 = (java.lang.Number) r7
            long r10 = r7.longValue()
            long r10 = r10 + r3
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            goto L_0x0094
        L_0x0093:
            r3 = r9
        L_0x0094:
            r14 = r3
            r15 = r9
            goto L_0x00d3
        L_0x0097:
            com.microtech.aidexx.db.repository.EventDbRepository r7 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            com.microtech.aidexx.db.dao.EventDao r7 = com.microtech.aidexx.db.dao.EventDao.INSTANCE
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity> r10 = com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity.class
            io.objectbox.Property r7 = r7.getPresetIdPropertyByClazz(r10)
            if (r7 != 0) goto L_0x00a5
            r7 = r9
            goto L_0x00c0
        L_0x00a5:
            com.microtech.aidexx.db.ObjectBox r10 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ui.main.event.EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1$1 r11 = new com.microtech.aidexx.ui.main.event.EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1$1
            r11.<init>(r7)
            java.util.concurrent.Callable r11 = (java.util.concurrent.Callable) r11
            io.objectbox.BoxStore r7 = r10.getStore()
            r10 = r0
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r0.L$0 = r2
            r0.label = r8
            java.lang.Object r7 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r7, r11, r10)
            if (r7 != r1) goto L_0x00c0
            return r1
        L_0x00c0:
            java.lang.Long r7 = (java.lang.Long) r7
            if (r7 == 0) goto L_0x00d0
            java.lang.Number r7 = (java.lang.Number) r7
            long r10 = r7.longValue()
            long r10 = r10 - r3
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            goto L_0x00d1
        L_0x00d0:
            r3 = r9
        L_0x00d1:
            r15 = r3
            r14 = r9
        L_0x00d3:
            com.microtech.aidexx.common.net.repository.EventRepository r10 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            java.lang.String r13 = r0.$userId
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity> r3 = com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity.class
            kotlin.reflect.KClass r17 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            com.microtech.aidexx.ui.main.event.EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1$3 r3 = new com.microtech.aidexx.ui.main.event.EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1$3
            r3.<init>(r2)
            r18 = r3
            kotlin.jvm.functions.Function2 r18 = (kotlin.jvm.functions.Function2) r18
            r19 = r0
            kotlin.coroutines.Continuation r19 = (kotlin.coroutines.Continuation) r19
            r0.L$0 = r2
            r0.label = r6
            r11 = 0
            r12 = 0
            r16 = 0
            r20 = 35
            r21 = 0
            java.lang.Object r3 = com.microtech.aidexx.common.net.repository.EventRepository.pollPresetData$default(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            if (r3 != r1) goto L_0x00fd
            return r1
        L_0x00fd:
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.channels.ProduceKt.awaitClose$default(r2, r9, r3, r8, r9)
            if (r2 != r1) goto L_0x010b
            return r1
        L_0x010b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.EventSportFragment$onRealResume$1$invokeSuspend$$inlined$syncEventPreset$default$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
