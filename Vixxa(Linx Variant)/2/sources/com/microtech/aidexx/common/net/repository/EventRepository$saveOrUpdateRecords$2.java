package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001*\u00020\u0005H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.EventRepository$saveOrUpdateRecords$2", f = "EventRepository.kt", i = {}, l = {62, 63, 64, 65, 66, 68, 69, 70, 71}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventRepository.kt */
final class EventRepository$saveOrUpdateRecords$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BaseResponse<? extends List<? extends Object>>>>, Object> {
    final /* synthetic */ List<Object> $data;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventRepository$saveOrUpdateRecords$2(List<? extends Object> list, Continuation<? super EventRepository$saveOrUpdateRecords$2> continuation) {
        super(2, continuation);
        this.$data = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventRepository$saveOrUpdateRecords$2(this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<? extends BaseResponse<? extends List<? extends Object>>>> continuation) {
        return ((EventRepository$saveOrUpdateRecords$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return (com.microtech.aidexx.common.net.ApiResult) r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            switch(r1) {
                case 0: goto L_0x003b;
                case 1: goto L_0x0037;
                case 2: goto L_0x0033;
                case 3: goto L_0x002f;
                case 4: goto L_0x002a;
                case 5: goto L_0x0025;
                case 6: goto L_0x0020;
                case 7: goto L_0x001b;
                case 8: goto L_0x0016;
                case 9: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0011:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0132
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0119
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0100
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00e7
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00ce
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x00b5
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x009c
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0083
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006a
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.net.entity.ReqSaveOrUpdateEventRecords r6 = new com.microtech.aidexx.common.net.entity.ReqSaveOrUpdateEventRecords
            java.util.List<java.lang.Object> r1 = r5.$data
            r6.<init>(r1)
            com.microtech.aidexx.common.net.ApiService$Companion r1 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r1 = r1.getInstance()
            java.util.List<java.lang.Object> r2 = r5.$data
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            java.lang.Class r2 = r2.getClass()
            java.lang.Class<com.microtech.aidexx.db.entity.event.DietEntity> r3 = com.microtech.aidexx.db.entity.event.DietEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x006e
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 1
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateFoodRecord(r6, r2)
            if (r6 != r0) goto L_0x006a
            return r0
        L_0x006a:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x006e:
            java.lang.Class<com.microtech.aidexx.db.entity.event.ExerciseEntity> r3 = com.microtech.aidexx.db.entity.event.ExerciseEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r4 = 2
            if (r3 == 0) goto L_0x0087
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r5.label = r4
            java.lang.Object r6 = r1.saveOrUpdateExerciseRecord(r6, r2)
            if (r6 != r0) goto L_0x0083
            return r0
        L_0x0083:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x0087:
            java.lang.Class<com.microtech.aidexx.db.entity.event.MedicationEntity> r3 = com.microtech.aidexx.db.entity.event.MedicationEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00a0
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 3
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateMedicationRecord(r6, r2)
            if (r6 != r0) goto L_0x009c
            return r0
        L_0x009c:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x00a0:
            java.lang.Class<com.microtech.aidexx.db.entity.event.InsulinEntity> r3 = com.microtech.aidexx.db.entity.event.InsulinEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00b9
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 4
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateInsulinRecord(r6, r2)
            if (r6 != r0) goto L_0x00b5
            return r0
        L_0x00b5:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x00b9:
            java.lang.Class<com.microtech.aidexx.db.entity.event.OthersEntity> r3 = com.microtech.aidexx.db.entity.event.OthersEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00d2
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 5
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateOtherRecord(r6, r2)
            if (r6 != r0) goto L_0x00ce
            return r0
        L_0x00ce:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x00d2:
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity> r3 = com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x00eb
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 6
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateUserFoodPreset(r6, r2)
            if (r6 != r0) goto L_0x00e7
            return r0
        L_0x00e7:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x00eb:
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity> r3 = com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0103
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 7
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateExerciseUserPreset(r6, r2)
            if (r6 != r0) goto L_0x0100
            return r0
        L_0x0100:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x0103:
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity> r3 = com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity.class
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x011c
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 8
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateMedicationUsrPreset(r6, r2)
            if (r6 != r0) goto L_0x0119
            return r0
        L_0x0119:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x011c:
            java.lang.Class<com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity> r3 = com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0135
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 9
            r5.label = r3
            java.lang.Object r6 = r1.saveOrUpdateUserInsulinPreset(r6, r2)
            if (r6 != r0) goto L_0x0132
            return r0
        L_0x0132:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            goto L_0x0163
        L_0x0135:
            com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "不支持当前类型下载数据 clazz="
            r0.<init>(r1)
            java.util.List<java.lang.Object> r1 = r5.$data
            java.lang.Object r1 = kotlin.collections.CollectionsKt.first(r1)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r6, r0, r1, r4, r1)
            com.microtech.aidexx.common.net.ApiResult$Failure r6 = new com.microtech.aidexx.common.net.ApiResult$Failure
            java.lang.String r0 = "3"
            java.lang.String r1 = "not support"
            r6.<init>(r0, r1)
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
        L_0x0163:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.repository.EventRepository$saveOrUpdateRecords$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
