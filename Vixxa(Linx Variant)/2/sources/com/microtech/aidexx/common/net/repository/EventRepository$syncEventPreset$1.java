package com.microtech.aidexx.common.net.repository;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H@"}, d2 = {"<anonymous>", "", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1", f = "EventRepository.kt", i = {0, 1, 2}, l = {598, 606, 445, 455}, m = "invokeSuspend", n = {"$this$callbackFlow", "$this$callbackFlow", "$this$callbackFlow"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: EventRepository.kt */
public final class EventRepository$syncEventPreset$1 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends Boolean, ? extends Integer>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPullDesc;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventRepository$syncEventPreset$1(boolean z, String str, Continuation<? super EventRepository$syncEventPreset$1> continuation) {
        super(2, continuation);
        this.$isPullDesc = z;
        this.$userId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EventRepository$syncEventPreset$1 eventRepository$syncEventPreset$1 = new EventRepository$syncEventPreset$1(this.$isPullDesc, this.$userId, continuation);
        eventRepository$syncEventPreset$1.L$0 = obj;
        return eventRepository$syncEventPreset$1;
    }

    public final Object invoke(ProducerScope<? super Pair<Boolean, Integer>> producerScope, Continuation<? super Unit> continuation) {
        return ((EventRepository$syncEventPreset$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0122 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0130 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r5 = 3
            r6 = 2
            r7 = 1
            java.lang.String r8 = "P"
            r9 = 4
            r10 = 0
            if (r2 == 0) goto L_0x0046
            if (r2 == r7) goto L_0x003b
            if (r2 == r6) goto L_0x0031
            if (r2 == r5) goto L_0x0028
            if (r2 != r9) goto L_0x0020
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x0131
        L_0x0020:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0028:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x0123
        L_0x0031:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r24)
            r6 = r24
            goto L_0x0093
        L_0x003b:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r24)
            r6 = r24
            goto L_0x00df
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r24)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            boolean r11 = r0.$isPullDesc
            if (r11 != 0) goto L_0x00ab
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r9, r8)
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.BasePresetEntity> r11 = com.microtech.aidexx.db.entity.event.preset.BasePresetEntity.class
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r11)
            boolean r11 = r11 instanceof com.microtech.aidexx.db.entity.event.preset.BaseSysPreset
            if (r11 == 0) goto L_0x005f
            goto L_0x00ab
        L_0x005f:
            com.microtech.aidexx.db.repository.EventDbRepository r11 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            com.microtech.aidexx.db.dao.EventDao r11 = com.microtech.aidexx.db.dao.EventDao.INSTANCE
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r9, r8)
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.BasePresetEntity> r12 = com.microtech.aidexx.db.entity.event.preset.BasePresetEntity.class
            r13 = r12
            java.lang.Class r13 = (java.lang.Class) r13
            io.objectbox.Property r12 = r11.getPresetIdPropertyByClazz(r12)
            if (r12 != 0) goto L_0x0075
            com.microtech.aidexx.db.dao.EventDao r11 = (com.microtech.aidexx.db.dao.EventDao) r11
            r6 = r10
            goto L_0x0093
        L_0x0075:
            com.microtech.aidexx.db.ObjectBox r11 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            kotlin.jvm.internal.Intrinsics.needClassReification()
            com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1$invokeSuspend$$inlined$findMaxPresetId$1 r13 = new com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1$invokeSuspend$$inlined$findMaxPresetId$1
            r13.<init>(r12)
            java.util.concurrent.Callable r13 = (java.util.concurrent.Callable) r13
            io.objectbox.BoxStore r11 = r11.getStore()
            r12 = r0
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r0.L$0 = r2
            r0.label = r6
            java.lang.Object r6 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r11, r13, r12)
            if (r6 != r1) goto L_0x0093
            return r1
        L_0x0093:
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x00a6
            java.lang.Number r6 = (java.lang.Number) r6
            long r11 = r6.longValue()
            long r11 = r11 + r3
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            goto L_0x00a7
        L_0x00a6:
            r3 = r10
        L_0x00a7:
            r15 = r3
            r16 = r10
            goto L_0x00f6
        L_0x00ab:
            com.microtech.aidexx.db.repository.EventDbRepository r6 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            com.microtech.aidexx.db.dao.EventDao r6 = com.microtech.aidexx.db.dao.EventDao.INSTANCE
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r9, r8)
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.BasePresetEntity> r11 = com.microtech.aidexx.db.entity.event.preset.BasePresetEntity.class
            r12 = r11
            java.lang.Class r12 = (java.lang.Class) r12
            io.objectbox.Property r11 = r6.getPresetIdPropertyByClazz(r11)
            if (r11 != 0) goto L_0x00c1
            com.microtech.aidexx.db.dao.EventDao r6 = (com.microtech.aidexx.db.dao.EventDao) r6
            r6 = r10
            goto L_0x00df
        L_0x00c1:
            com.microtech.aidexx.db.ObjectBox r6 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            kotlin.jvm.internal.Intrinsics.needClassReification()
            com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1$invokeSuspend$$inlined$findMinPresetId$1 r12 = new com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1$invokeSuspend$$inlined$findMinPresetId$1
            r12.<init>(r11)
            java.util.concurrent.Callable r12 = (java.util.concurrent.Callable) r12
            io.objectbox.BoxStore r6 = r6.getStore()
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r2
            r0.label = r7
            java.lang.Object r6 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r6, r12, r11)
            if (r6 != r1) goto L_0x00df
            return r1
        L_0x00df:
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x00f2
            java.lang.Number r6 = (java.lang.Number) r6
            long r11 = r6.longValue()
            long r11 = r11 - r3
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            r4 = r3
            java.lang.Long r4 = (java.lang.Long) r4
            goto L_0x00f3
        L_0x00f2:
            r3 = r10
        L_0x00f3:
            r16 = r3
            r15 = r10
        L_0x00f6:
            com.microtech.aidexx.common.net.repository.EventRepository r11 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            java.lang.String r14 = r0.$userId
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r9, r8)
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.BasePresetEntity> r3 = com.microtech.aidexx.db.entity.event.preset.BasePresetEntity.class
            kotlin.reflect.KClass r18 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1$3 r3 = new com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1$3
            r3.<init>(r2)
            r19 = r3
            kotlin.jvm.functions.Function2 r19 = (kotlin.jvm.functions.Function2) r19
            r20 = r0
            kotlin.coroutines.Continuation r20 = (kotlin.coroutines.Continuation) r20
            r0.L$0 = r2
            r0.label = r5
            r12 = 0
            r13 = 0
            r17 = 0
            r21 = 35
            r22 = 0
            java.lang.Object r3 = com.microtech.aidexx.common.net.repository.EventRepository.pollPresetData$default(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            if (r3 != r1) goto L_0x0123
            return r1
        L_0x0123:
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.L$0 = r10
            r0.label = r9
            java.lang.Object r2 = kotlinx.coroutines.channels.ProduceKt.awaitClose$default(r2, r10, r3, r7, r10)
            if (r2 != r1) goto L_0x0131
            return r1
        L_0x0131:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.repository.EventRepository$syncEventPreset$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
