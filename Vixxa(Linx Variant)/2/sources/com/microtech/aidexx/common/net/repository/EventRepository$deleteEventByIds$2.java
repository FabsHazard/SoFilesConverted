package com.microtech.aidexx.common.net.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.EventRepository$deleteEventByIds$2", f = "EventRepository.kt", i = {}, l = {575, 576, 577, 578, 579, 580}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventRepository.kt */
final class EventRepository$deleteEventByIds$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Class<T> $clazz;
    final /* synthetic */ List<String> $ids;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventRepository$deleteEventByIds$2(List<String> list, Class<T> cls, Continuation<? super EventRepository$deleteEventByIds$2> continuation) {
        super(2, continuation);
        this.$ids = list;
        this.$clazz = cls;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventRepository$deleteEventByIds$2(this.$ids, this.$clazz, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((EventRepository$deleteEventByIds$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        r6 = (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006c, code lost:
        r6 = (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
        r6 = (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        r6 = (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        r6 = (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00cc, code lost:
        r6 = (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        if (r6 == null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
        if ((r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success) == false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00dc, code lost:
        return kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            switch(r1) {
                case 0: goto L_0x002d;
                case 1: goto L_0x0029;
                case 2: goto L_0x0025;
                case 3: goto L_0x0021;
                case 4: goto L_0x001c;
                case 5: goto L_0x0017;
                case 6: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0012:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00cc
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00b4
        L_0x001c:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x009c
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0084
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006c
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0053
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.net.ApiService$Companion r6 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r6 = r6.getInstance()
            com.microtech.aidexx.common.net.entity.ReqDeleteEventIds r1 = new com.microtech.aidexx.common.net.entity.ReqDeleteEventIds
            java.util.List<java.lang.String> r3 = r5.$ids
            r1.<init>(r3)
            java.lang.Class<T> r3 = r5.$clazz
            java.lang.Class<com.microtech.aidexx.db.entity.BloodGlucoseEntity> r4 = com.microtech.aidexx.db.entity.BloodGlucoseEntity.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0057
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r6 = r6.deleteFingerBloodGlucose(r1, r3)
            if (r6 != r0) goto L_0x0053
            return r0
        L_0x0053:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x00d0
        L_0x0057:
            java.lang.Class<com.microtech.aidexx.db.entity.event.DietEntity> r4 = com.microtech.aidexx.db.entity.event.DietEntity.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x006f
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 2
            r5.label = r4
            java.lang.Object r6 = r6.deleteByIdsFood(r1, r3)
            if (r6 != r0) goto L_0x006c
            return r0
        L_0x006c:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x00d0
        L_0x006f:
            java.lang.Class<com.microtech.aidexx.db.entity.event.ExerciseEntity> r4 = com.microtech.aidexx.db.entity.event.ExerciseEntity.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0087
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 3
            r5.label = r4
            java.lang.Object r6 = r6.deleteByIdsExercise(r1, r3)
            if (r6 != r0) goto L_0x0084
            return r0
        L_0x0084:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x00d0
        L_0x0087:
            java.lang.Class<com.microtech.aidexx.db.entity.event.InsulinEntity> r4 = com.microtech.aidexx.db.entity.event.InsulinEntity.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x009f
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 4
            r5.label = r4
            java.lang.Object r6 = r6.deleteByIdsInsulin(r1, r3)
            if (r6 != r0) goto L_0x009c
            return r0
        L_0x009c:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x00d0
        L_0x009f:
            java.lang.Class<com.microtech.aidexx.db.entity.event.MedicationEntity> r4 = com.microtech.aidexx.db.entity.event.MedicationEntity.class
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x00b7
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 5
            r5.label = r4
            java.lang.Object r6 = r6.deleteByIdsMedication(r1, r3)
            if (r6 != r0) goto L_0x00b4
            return r0
        L_0x00b4:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x00d0
        L_0x00b7:
            java.lang.Class<com.microtech.aidexx.db.entity.event.OthersEntity> r4 = com.microtech.aidexx.db.entity.event.OthersEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x00cf
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 6
            r5.label = r4
            java.lang.Object r6 = r6.deleteByIdsOthers(r1, r3)
            if (r6 != r0) goto L_0x00cc
            return r0
        L_0x00cc:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x00d0
        L_0x00cf:
            r6 = 0
        L_0x00d0:
            if (r6 == 0) goto L_0x00d8
            boolean r6 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r6 == 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r2 = 0
        L_0x00d8:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.repository.EventRepository$deleteEventByIds$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
