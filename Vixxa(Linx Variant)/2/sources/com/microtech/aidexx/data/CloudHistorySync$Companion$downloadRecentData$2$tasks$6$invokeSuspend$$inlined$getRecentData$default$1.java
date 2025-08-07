package com.microtech.aidexx.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H@¨\u0006\u0005"}, d2 = {"<anonymous>", "", "EVENT", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;", "com/microtech/aidexx/common/net/repository/EventRepository$getRecentData$result$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.EventRepository$getRecentData$result$1", f = "EventRepository.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {598, 159, 184}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "breakAll", "list", "$this$withContext", "breakAll", "list", "it"}, s = {"L$0", "L$0", "L$1", "L$7", "L$0", "L$1", "L$7", "L$8"})
/* compiled from: EventRepository.kt */
public final class CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Class $clazz;
    final /* synthetic */ int $count;
    final /* synthetic */ Ref.ObjectRef $endAutoIncrementColumn;
    final /* synthetic */ String $loginMaxIdKey;
    final /* synthetic */ String $loginStateKey;
    final /* synthetic */ int $pageSize;
    final /* synthetic */ Ref.ObjectRef $startAutoIncrementColumn;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1(String str, Ref.ObjectRef objectRef, String str2, String str3, int i, int i2, Ref.ObjectRef objectRef2, Class cls, Continuation continuation) {
        super(2, continuation);
        this.$loginStateKey = str;
        this.$startAutoIncrementColumn = objectRef;
        this.$userId = str2;
        this.$loginMaxIdKey = str3;
        this.$count = i;
        this.$pageSize = i2;
        this.$endAutoIncrementColumn = objectRef2;
        this.$clazz = cls;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1 cloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1 = new CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1(this.$loginStateKey, this.$startAutoIncrementColumn, this.$userId, this.$loginMaxIdKey, this.$count, this.$pageSize, this.$endAutoIncrementColumn, this.$clazz, continuation);
        cloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1.L$0 = obj;
        return cloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v52, resolved type: T} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v53, resolved type: T} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02e3  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0360  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            r25 = this;
            r7 = r25
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r7.label
            r11 = 3
            java.lang.String r12 = "getrecent fail "
            r13 = 0
            r15 = 0
            r6 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0086
            if (r0 == r5) goto L_0x0078
            if (r0 == r6) goto L_0x004b
            if (r0 != r11) goto L_0x0043
            java.lang.Object r0 = r7.L$8
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r7.L$7
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r7.L$6
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r7.L$5
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.Object r11 = r7.L$4
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r4 = r7.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r7.L$2
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r9 = r7.L$1
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            java.lang.Object r10 = r7.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlin.ResultKt.throwOnFailure(r26)
            r13 = r5
            r14 = 3
            goto L_0x028a
        L_0x0043:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004b:
            java.lang.Object r0 = r7.L$7
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r7.L$6
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r2 = r7.L$5
            java.lang.Class r2 = (java.lang.Class) r2
            java.lang.Object r3 = r7.L$4
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r7.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r7.L$2
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r9 = r7.L$1
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            java.lang.Object r10 = r7.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlin.ResultKt.throwOnFailure(r26)
            r11 = r3
            r13 = r5
            r14 = 0
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r26
            goto L_0x01f7
        L_0x0078:
            java.lang.Object r0 = r7.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r26)
            r2 = r26
            goto L_0x00d7
        L_0x0086:
            kotlin.ResultKt.throwOnFailure(r26)
            java.lang.Object r0 = r7.L$0
            r1 = r0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.microtech.aidexx.utils.mmkv.MmkvManager r0 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r2 = r7.$loginStateKey
            boolean r0 = r0.isLastLoginEventDownloadSuccess(r2)
            if (r0 == 0) goto L_0x0117
            com.microtech.aidexx.utils.mmkv.MmkvManager r0 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r2 = r7.$loginStateKey
            r0.setLastLoginEventDownloadState(r2, r15)
            kotlin.jvm.internal.Ref$ObjectRef r0 = r7.$startAutoIncrementColumn
            com.microtech.aidexx.db.repository.EventDbRepository r2 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            java.lang.String r2 = r7.$userId
            com.microtech.aidexx.db.dao.EventDao r3 = com.microtech.aidexx.db.dao.EventDao.INSTANCE
            java.lang.Class<com.microtech.aidexx.db.entity.event.DietEntity> r4 = com.microtech.aidexx.db.entity.event.DietEntity.class
            io.objectbox.Property r4 = r3.getEventIdPropertyByClazz(r4)
            java.lang.Class<com.microtech.aidexx.db.entity.event.DietEntity> r6 = com.microtech.aidexx.db.entity.event.DietEntity.class
            io.objectbox.Property r3 = r3.getUserIdPropertyByClazz(r6)
            if (r4 != 0) goto L_0x00b7
        L_0x00b5:
            r2 = 0
            goto L_0x00d7
        L_0x00b7:
            if (r3 != 0) goto L_0x00ba
            goto L_0x00b5
        L_0x00ba:
            com.microtech.aidexx.db.ObjectBox r6 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1$1 r9 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1$1
            r9.<init>(r4, r3, r2)
            java.util.concurrent.Callable r9 = (java.util.concurrent.Callable) r9
            io.objectbox.BoxStore r2 = r6.getStore()
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.L$0 = r1
            r7.L$1 = r0
            r7.label = r5
            java.lang.Object r2 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r2, r9, r3)
            if (r2 != r8) goto L_0x00d7
            return r8
        L_0x00d7:
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 != 0) goto L_0x00df
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r13)
        L_0x00df:
            r0.element = r2
            kotlin.jvm.internal.Ref$ObjectRef r0 = r7.$startAutoIncrementColumn
            T r2 = r0.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            long r2 = r2.longValue()
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 > 0) goto L_0x00f4
            r2 = 0
            goto L_0x00fa
        L_0x00f4:
            kotlin.jvm.internal.Ref$ObjectRef r2 = r7.$startAutoIncrementColumn
            T r2 = r2.element
            java.lang.Long r2 = (java.lang.Long) r2
        L_0x00fa:
            r0.element = r2
            com.microtech.aidexx.utils.mmkv.MmkvManager r0 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r2 = r7.$loginMaxIdKey
            kotlin.jvm.internal.Ref$ObjectRef r3 = r7.$startAutoIncrementColumn
            T r3 = r3.element
            java.lang.Long r3 = (java.lang.Long) r3
            if (r3 == 0) goto L_0x010d
            long r3 = r3.longValue()
            goto L_0x010f
        L_0x010d:
            r3 = -1
        L_0x010f:
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
            r0.setEventDataId(r2, r3)
            goto L_0x0123
        L_0x0117:
            kotlin.jvm.internal.Ref$ObjectRef r0 = r7.$startAutoIncrementColumn
            com.microtech.aidexx.utils.mmkv.MmkvManager r2 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r3 = r7.$loginMaxIdKey
            java.lang.Long r2 = r2.getEventDataId(r3)
            r0.element = r2
        L_0x0123:
            kotlin.jvm.internal.Ref$ObjectRef r0 = r7.$startAutoIncrementColumn
            T r2 = r0.element
            java.lang.Long r2 = (java.lang.Long) r2
            if (r2 == 0) goto L_0x0139
            java.lang.Number r2 = (java.lang.Number) r2
            long r2 = r2.longValue()
            r9 = 1
            long r2 = r2 + r9
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r2)
            goto L_0x013a
        L_0x0139:
            r2 = 0
        L_0x013a:
            r0.element = r2
            com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1$2 r0 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = r7.$endAutoIncrementColumn
            r0.<init>(r2)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            int r2 = r7.$count
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r15, (int) r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            int r3 = r7.$pageSize
            java.util.List r2 = kotlin.collections.CollectionsKt.chunked(r2, r3)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            kotlin.jvm.internal.Ref$ObjectRef r3 = r7.$endAutoIncrementColumn
            java.lang.String r4 = r7.$userId
            kotlin.jvm.internal.Ref$ObjectRef r6 = r7.$startAutoIncrementColumn
            java.lang.Class r9 = r7.$clazz
            boolean r10 = r2 instanceof java.util.Collection
            if (r10 == 0) goto L_0x016d
            r10 = r2
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x016d
            r15 = r5
            goto L_0x036d
        L_0x016d:
            java.util.Iterator r2 = r2.iterator()
            r10 = r1
            r11 = r2
            r2 = r9
            r9 = r0
            r24 = r6
            r6 = r3
            r3 = r24
        L_0x017a:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x036c
            java.lang.Object r0 = r11.next()
            r1 = r0
            java.util.List r1 = (java.util.List) r1
            T r0 = r6.element
            if (r0 == 0) goto L_0x01ab
            T r0 = r6.element
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            long r21 = r0.longValue()
            int r0 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r0 > 0) goto L_0x01ab
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r1 = "最小id为0 代表数据下载完了"
            r2 = 2
            r3 = 0
            com.microtech.aidexx.utils.LogUtil.Companion.d$default(r0, r1, r3, r2, r3)
            r9.invoke()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r0
        L_0x01ab:
            com.microtech.aidexx.common.net.repository.EventRepository r0 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            int r21 = r1.size()
            T r5 = r3.element
            java.lang.Long r5 = (java.lang.Long) r5
            T r13 = r6.element
            java.lang.Long r13 = (java.lang.Long) r13
            r7.L$0 = r10
            r7.L$1 = r9
            r7.L$2 = r6
            r7.L$3 = r4
            r7.L$4 = r3
            r7.L$5 = r2
            r7.L$6 = r11
            r7.L$7 = r1
            r14 = 0
            r7.L$8 = r14
            r14 = 2
            r7.label = r14
            r18 = r1
            r1 = r4
            r23 = r2
            r2 = r21
            r21 = r3
            r3 = r5
            r17 = r4
            r5 = 0
            r4 = r13
            r14 = r5
            r13 = 1
            r5 = r23
            r22 = r6
            r6 = r25
            java.lang.Object r0 = r0.getEventRecordsByPageInfo(r1, r2, r3, r4, r5, r6)
            if (r0 != r8) goto L_0x01ec
            return r8
        L_0x01ec:
            r2 = r11
            r4 = r17
            r1 = r18
            r11 = r21
            r6 = r22
            r3 = r23
        L_0x01f7:
            com.microtech.aidexx.common.net.ApiResult r0 = (com.microtech.aidexx.common.net.ApiResult) r0
            boolean r5 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r5 == 0) goto L_0x031a
            com.microtech.aidexx.common.net.ApiResult$Success r0 = (com.microtech.aidexx.common.net.ApiResult.Success) r0
            java.lang.Object r0 = r0.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r0 = (com.microtech.aidexx.common.net.entity.BaseResponse) r0
            java.lang.Object r0 = r0.getData()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x02ec
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x0224
            java.lang.Object r0 = r1.get(r15)
            java.lang.Number r0 = (java.lang.Number) r0
            r0.intValue()
            r9.invoke()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            return r0
        L_0x0224:
            com.microtech.aidexx.utils.LogUtil$Companion r5 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r14 = "getRecentData "
            r15.<init>(r14)
            java.lang.String r14 = r3.getSimpleName()
            java.lang.StringBuilder r14 = r15.append(r14)
            java.lang.String r15 = " ret=["
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.Object r15 = kotlin.collections.CollectionsKt.first(r0)
            com.microtech.aidexx.db.entity.BaseEventEntity r15 = (com.microtech.aidexx.db.entity.BaseEventEntity) r15
            java.lang.Long r15 = r15.getAutoIncrementColumn()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r15 = "->"
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.Object r15 = kotlin.collections.CollectionsKt.last(r0)
            com.microtech.aidexx.db.entity.BaseEventEntity r15 = (com.microtech.aidexx.db.entity.BaseEventEntity) r15
            java.lang.Long r15 = r15.getAutoIncrementColumn()
            java.lang.StringBuilder r14 = r14.append(r15)
            r15 = 93
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "getRecentData"
            r5.xLogE(r14, r15)
            com.microtech.aidexx.data.DataSyncController$Companion r5 = com.microtech.aidexx.data.DataSyncController.Companion
            r7.L$0 = r10
            r7.L$1 = r9
            r7.L$2 = r6
            r7.L$3 = r4
            r7.L$4 = r11
            r7.L$5 = r3
            r7.L$6 = r2
            r7.L$7 = r1
            r7.L$8 = r0
            r14 = 3
            r7.label = r14
            java.lang.Object r5 = r5.insertToDb(r0, r3, r7)
            if (r5 != r8) goto L_0x028a
            return r8
        L_0x028a:
            java.lang.Object r5 = kotlin.collections.CollectionsKt.last(r0)
            com.microtech.aidexx.db.entity.BaseEventEntity r5 = (com.microtech.aidexx.db.entity.BaseEventEntity) r5
            java.lang.Long r5 = r5.getAutoIncrementColumn()
            if (r5 == 0) goto L_0x02bb
            java.lang.Number r5 = (java.lang.Number) r5
            long r15 = r5.longValue()
            r19 = 1
            long r15 = r15 - r19
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r15)
            r6.element = r5
            int r0 = r0.size()
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x02b8
            r9.invoke()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            return r0
        L_0x02b8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x02be
        L_0x02bb:
            r19 = 1
            r0 = 0
        L_0x02be:
            if (r0 != 0) goto L_0x02e3
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r12)
            java.lang.String r2 = r3.getSimpleName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " 登录拉数据出现空id情况"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            r5 = 2
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r0, r1, r2, r5, r2)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            return r0
        L_0x02e3:
            r5 = 2
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r24 = r4
            r4 = r0
            r0 = r24
            goto L_0x02f2
        L_0x02ec:
            r5 = 2
            r14 = 3
            r19 = 1
            r0 = r4
            r4 = 0
        L_0x02f2:
            if (r4 != 0) goto L_0x0316
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r12)
            java.lang.String r2 = r3.getSimpleName()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " apiResult.result.data = null"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r0, r1, r2, r5, r2)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            return r0
        L_0x0316:
            r4 = r0
            r0 = r13
            r13 = 0
            goto L_0x0356
        L_0x031a:
            r5 = 2
            r14 = 3
            r19 = 1
            boolean r1 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r1 == 0) goto L_0x0366
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r12)
            java.lang.String r13 = r3.getSimpleName()
            java.lang.StringBuilder r13 = r15.append(r13)
            r15 = 32
            java.lang.StringBuilder r13 = r13.append(r15)
            com.microtech.aidexx.common.net.ApiResult$Failure r0 = (com.microtech.aidexx.common.net.ApiResult.Failure) r0
            java.lang.String r14 = r0.getCode()
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.StringBuilder r13 = r13.append(r15)
            java.lang.String r0 = r0.getMsg()
            java.lang.StringBuilder r0 = r13.append(r0)
            java.lang.String r0 = r0.toString()
            r13 = 0
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r1, r0, r13, r5, r13)
            r0 = 0
        L_0x0356:
            r24 = r11
            r11 = r2
            r2 = r3
            r3 = r24
            if (r0 != 0) goto L_0x0360
            r15 = 0
            goto L_0x036d
        L_0x0360:
            r5 = 1
            r13 = 0
            r15 = 0
            goto L_0x017a
        L_0x0366:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x036c:
            r15 = 1
        L_0x036d:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2$tasks$6$invokeSuspend$$inlined$getRecentData$default$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
