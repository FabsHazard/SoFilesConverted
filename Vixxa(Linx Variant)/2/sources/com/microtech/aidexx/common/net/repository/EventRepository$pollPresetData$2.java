package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.EventRepository$pollPresetData$2", f = "EventRepository.kt", i = {1, 1, 2}, l = {470, 480, 493}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u246", "rspList", "$this$invokeSuspend_u24lambda_u246"}, s = {"L$6", "L$7", "L$1"})
/* compiled from: EventRepository.kt */
final class EventRepository$pollPresetData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2<Boolean, Integer, Unit> $cb;
    final /* synthetic */ Long $endAutoIncrementColumn;
    final /* synthetic */ String $orderStrategy;
    final /* synthetic */ KClass<? extends BasePresetEntity> $pClazz;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ Long $startAutoIncrementColumn;
    final /* synthetic */ String $userId;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventRepository$pollPresetData$2(int i, int i2, String str, Long l, Long l2, String str2, KClass<? extends BasePresetEntity> kClass, Function2<? super Boolean, ? super Integer, Unit> function2, Continuation<? super EventRepository$pollPresetData$2> continuation) {
        super(2, continuation);
        this.$pageNum = i;
        this.$pageSize = i2;
        this.$userId = str;
        this.$startAutoIncrementColumn = l;
        this.$endAutoIncrementColumn = l2;
        this.$orderStrategy = str2;
        this.$pClazz = kClass;
        this.$cb = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventRepository$pollPresetData$2(this.$pageNum, this.$pageSize, this.$userId, this.$startAutoIncrementColumn, this.$endAutoIncrementColumn, this.$orderStrategy, this.$pClazz, this.$cb, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((EventRepository$pollPresetData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0198, code lost:
        if (r0 != null) goto L_0x01b7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x016b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            r26 = this;
            r10 = r26
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r10.label
            r1 = 3
            r2 = 2
            r3 = 1
            r13 = 0
            if (r0 == 0) goto L_0x0064
            if (r0 == r3) goto L_0x005e
            if (r0 == r2) goto L_0x002e
            if (r0 != r1) goto L_0x0026
            int r0 = r10.I$0
            java.lang.Object r1 = r10.L$1
            com.microtech.aidexx.common.net.entity.BaseResponse r1 = (com.microtech.aidexx.common.net.entity.BaseResponse) r1
            java.lang.Object r1 = r10.L$0
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            kotlin.ResultKt.throwOnFailure(r27)
            r12 = r0
            r0 = r27
            goto L_0x016d
        L_0x0026:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            int r0 = r10.I$1
            int r2 = r10.I$0
            java.lang.Object r4 = r10.L$7
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r10.L$6
            com.microtech.aidexx.common.net.entity.BaseResponse r5 = (com.microtech.aidexx.common.net.entity.BaseResponse) r5
            java.lang.Object r6 = r10.L$5
            kotlin.reflect.KClass r6 = (kotlin.reflect.KClass) r6
            java.lang.Object r7 = r10.L$4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r10.L$3
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r10.L$2
            java.lang.Long r9 = (java.lang.Long) r9
            java.lang.Object r14 = r10.L$1
            java.lang.Long r14 = (java.lang.Long) r14
            java.lang.Object r15 = r10.L$0
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            kotlin.ResultKt.throwOnFailure(r27)
            r12 = r0
            r3 = r8
            r25 = r7
            r7 = r6
            r6 = r25
            goto L_0x00ed
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r27)
            r0 = r27
            goto L_0x0094
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r27)
            com.microtech.aidexx.common.net.repository.EventRepository r16 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            int r0 = r10.$pageNum
            int r4 = r10.$pageSize
            java.lang.String r5 = r10.$userId
            java.lang.Long r6 = r10.$startAutoIncrementColumn
            java.lang.Long r7 = r10.$endAutoIncrementColumn
            java.lang.String r8 = r10.$orderStrategy
            kotlin.reflect.KClass<? extends com.microtech.aidexx.db.entity.event.preset.BasePresetEntity> r9 = r10.$pClazz
            java.lang.Class r23 = kotlin.jvm.JvmClassMappingKt.getJavaClass(r9)
            r24 = r10
            kotlin.coroutines.Continuation r24 = (kotlin.coroutines.Continuation) r24
            r10.label = r3
            r17 = r0
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            java.lang.Object r0 = r16.getEventPresetByPageInfo(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r0 != r11) goto L_0x0094
            return r11
        L_0x0094:
            com.microtech.aidexx.common.net.ApiResult r0 = (com.microtech.aidexx.common.net.ApiResult) r0
            boolean r4 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r4 == 0) goto L_0x01a6
            com.microtech.aidexx.common.net.ApiResult$Success r0 = (com.microtech.aidexx.common.net.ApiResult.Success) r0
            java.lang.Object r0 = r0.getResult()
            kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.Integer, kotlin.Unit> r4 = r10.$cb
            int r5 = r10.$pageSize
            int r6 = r10.$pageNum
            java.lang.Long r14 = r10.$startAutoIncrementColumn
            java.lang.Long r9 = r10.$endAutoIncrementColumn
            java.lang.String r7 = r10.$userId
            java.lang.String r8 = r10.$orderStrategy
            kotlin.reflect.KClass<? extends com.microtech.aidexx.db.entity.event.preset.BasePresetEntity> r15 = r10.$pClazz
            com.microtech.aidexx.common.net.entity.BaseResponse r0 = (com.microtech.aidexx.common.net.entity.BaseResponse) r0
            java.lang.Object r16 = r0.getData()
            r12 = r16
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x019a
            r16 = r12
            java.util.Collection r16 = (java.util.Collection) r16
            boolean r16 = r16.isEmpty()
            if (r16 != 0) goto L_0x0186
            com.microtech.aidexx.db.repository.EventDbRepository r3 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r10.L$0 = r4
            r10.L$1 = r14
            r10.L$2 = r9
            r10.L$3 = r7
            r10.L$4 = r8
            r10.L$5 = r15
            r10.L$6 = r0
            r10.L$7 = r12
            r10.I$0 = r5
            r10.I$1 = r6
            r10.label = r2
            java.lang.Object r2 = r3.insertPresetData((java.util.List<? extends com.microtech.aidexx.db.entity.event.preset.BasePresetEntity>) r12, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r10)
            if (r2 != r11) goto L_0x00e5
            return r11
        L_0x00e5:
            r2 = r5
            r3 = r7
            r7 = r15
            r5 = r0
            r15 = r4
            r4 = r12
            r12 = r6
            r6 = r8
        L_0x00ed:
            r0 = 500(0x1f4, float:7.0E-43)
            if (r15 == 0) goto L_0x0101
            if (r2 >= r0) goto L_0x00f5
            r8 = 1
            goto L_0x00f6
        L_0x00f5:
            r8 = 0
        L_0x00f6:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r15.invoke(r8, r1)
        L_0x0101:
            if (r2 < r0) goto L_0x0170
            r0 = 1
            if (r14 == 0) goto L_0x0125
            java.lang.Number r14 = (java.lang.Number) r14
            r14.longValue()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r4)
            com.microtech.aidexx.db.entity.event.preset.BasePresetEntity r8 = (com.microtech.aidexx.db.entity.event.preset.BasePresetEntity) r8
            java.lang.Long r8 = r8.getServerPresetId()
            if (r8 == 0) goto L_0x0125
            java.lang.Number r8 = (java.lang.Number) r8
            long r19 = r8.longValue()
            long r19 = r19 + r0
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r19)
            goto L_0x0126
        L_0x0125:
            r8 = r13
        L_0x0126:
            if (r9 == 0) goto L_0x0147
            java.lang.Number r9 = (java.lang.Number) r9
            r9.longValue()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r4)
            com.microtech.aidexx.db.entity.event.preset.BasePresetEntity r4 = (com.microtech.aidexx.db.entity.event.preset.BasePresetEntity) r4
            java.lang.Long r4 = r4.getServerPresetId()
            if (r4 == 0) goto L_0x0147
            java.lang.Number r4 = (java.lang.Number) r4
            long r19 = r4.longValue()
            long r19 = r19 - r0
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r19)
            r9 = r0
            goto L_0x0148
        L_0x0147:
            r9 = r13
        L_0x0148:
            com.microtech.aidexx.common.net.repository.EventRepository r0 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            r10.L$0 = r15
            r10.L$1 = r5
            r10.L$2 = r13
            r10.L$3 = r13
            r10.L$4 = r13
            r10.L$5 = r13
            r10.L$6 = r13
            r10.L$7 = r13
            r10.I$0 = r12
            r1 = 3
            r10.label = r1
            r1 = r12
            r4 = r8
            r5 = r9
            r8 = r15
            r9 = r26
            java.lang.Object r0 = r0.pollPresetData(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            if (r0 != r11) goto L_0x016c
            return r11
        L_0x016c:
            r1 = r15
        L_0x016d:
            r4 = r1
            r6 = r12
            goto L_0x0198
        L_0x0170:
            if (r15 == 0) goto L_0x0182
            r0 = 1
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r15.invoke(r0, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r6 = r12
            goto L_0x0184
        L_0x0182:
            r6 = r12
            r0 = r13
        L_0x0184:
            r4 = r15
            goto L_0x0198
        L_0x0186:
            r0 = r3
            if (r4 == 0) goto L_0x0197
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r4.invoke(r0, r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x0198
        L_0x0197:
            r0 = r13
        L_0x0198:
            if (r0 != 0) goto L_0x01b7
        L_0x019a:
            if (r4 == 0) goto L_0x01b7
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            r4.invoke(r13, r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x01b7
        L_0x01a6:
            boolean r0 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r0 == 0) goto L_0x01b7
            kotlin.jvm.functions.Function2<java.lang.Boolean, java.lang.Integer, kotlin.Unit> r0 = r10.$cb
            if (r0 == 0) goto L_0x01b7
            int r1 = r10.$pageNum
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r0.invoke(r13, r1)
        L_0x01b7:
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.repository.EventRepository$pollPresetData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
