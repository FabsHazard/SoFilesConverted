package com.microtech.aidexx.data;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.data.DataSyncController;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000 6*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00016B\u0005¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ3\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u0015\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%JO\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0018\u00010'2.\u0010(\u001a*\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c0)j\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001c`*H¦@ø\u0001\u0000¢\u0006\u0002\u0010+JI\u0010,\u001a\u00020-2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001f2\b\b\u0002\u00100\u001a\u00020$2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0019H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0011\u00102\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0019\u00103\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001f\u00103\u001a\u00020\u00182\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH@ø\u0001\u0000¢\u0006\u0002\u00105R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcom/microtech/aidexx/data/CloudHistorySync;", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lcom/microtech/aidexx/data/DataSyncController;", "()V", "deleteStatus", "Lio/objectbox/Property;", "getDeleteStatus", "()Lio/objectbox/Property;", "entityBox", "Lio/objectbox/Box;", "getEntityBox", "()Lio/objectbox/Box;", "frontRecordId", "getFrontRecordId", "id", "getId", "idx", "getIdx", "uploadState", "getUploadState", "userId", "getUserId", "downloadData", "", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNeedUploadData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteData", "", "", "syncTaskItem", "Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;", "pageSize", "", "(Ljava/lang/String;Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postLocalData", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceEventData", "", "origin", "responseList", "type", "(Ljava/util/List;Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upload", "uploadDeletedData", "data", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CloudHistorySync.kt */
public abstract class CloudHistorySync<T extends BaseEventEntity> extends DataSyncController<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "CloudHistorySync";
    private final Box<T> entityBox;

    /* access modifiers changed from: protected */
    public Object downloadData(String str, Continuation<? super Boolean> continuation) {
        return downloadData$suspendImpl(this, str, continuation);
    }

    public abstract Property<T> getDeleteStatus();

    public abstract Property<T> getFrontRecordId();

    public abstract Property<T> getId();

    public abstract Property<T> getIdx();

    public Object getRemoteData(String str, DataSyncController.SyncTaskItem syncTaskItem, int i, Continuation<? super List<? extends Object>> continuation) {
        return getRemoteData$suspendImpl(this, str, syncTaskItem, i, continuation);
    }

    public abstract Property<T> getUploadState();

    public abstract Property<T> getUserId();

    public abstract Object postLocalData(HashMap<String, List<T>> hashMap, Continuation<? super BaseResponse<List<T>>> continuation);

    public Object replaceEventData(List<T> list, List<? extends T> list2, int i, String str, Continuation<? super Unit> continuation) {
        return replaceEventData$suspendImpl(this, list, list2, i, str, continuation);
    }

    public Object upload(Continuation<? super Unit> continuation) {
        return upload$suspendImpl(this, continuation);
    }

    /* access modifiers changed from: protected */
    public Object uploadDeletedData(String str, Continuation<? super Boolean> continuation) {
        return uploadDeletedData$suspendImpl(this, str, continuation);
    }

    public Object uploadDeletedData(List<String> list, Continuation<? super Boolean> continuation) {
        return uploadDeletedData$suspendImpl(this, list, continuation);
    }

    public CloudHistorySync() {
        Box<T> boxFor = ObjectBox.INSTANCE.getStore().boxFor(getTClazz());
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(...)");
        this.entityBox = boxFor;
    }

    public final Box<T> getEntityBox() {
        return this.entityBox;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object upload$suspendImpl(com.microtech.aidexx.data.CloudHistorySync<T> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.microtech.aidexx.data.CloudHistorySync$upload$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.data.CloudHistorySync$upload$1 r0 = (com.microtech.aidexx.data.CloudHistorySync$upload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudHistorySync$upload$1 r0 = new com.microtech.aidexx.data.CloudHistorySync$upload$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$0
            com.microtech.aidexx.data.CloudHistorySync r6 = (com.microtech.aidexx.data.CloudHistorySync) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004b
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r6.getNeedUploadData(r0)
            if (r7 != r1) goto L_0x004b
            return r1
        L_0x004b:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L_0x006e
            int r2 = r7.size()
            if (r2 <= 0) goto L_0x006e
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.microtech.aidexx.data.CloudHistorySync$upload$2$1 r4 = new com.microtech.aidexx.data.CloudHistorySync$upload$2$1
            r5 = 0
            r4.<init>(r6, r7, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r6 != r1) goto L_0x006e
            return r1
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync.upload$suspendImpl(com.microtech.aidexx.data.CloudHistorySync, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getRemoteData$default(CloudHistorySync cloudHistorySync, String str, DataSyncController.SyncTaskItem syncTaskItem, int i, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                i = 500;
            }
            return cloudHistorySync.getRemoteData(str, syncTaskItem, i, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRemoteData");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object getRemoteData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync<T> r9, java.lang.String r10, com.microtech.aidexx.data.DataSyncController.SyncTaskItem r11, int r12, kotlin.coroutines.Continuation<? super java.util.List<? extends java.lang.Object>> r13) {
        /*
            boolean r0 = r13 instanceof com.microtech.aidexx.data.CloudHistorySync$getRemoteData$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.microtech.aidexx.data.CloudHistorySync$getRemoteData$1 r0 = (com.microtech.aidexx.data.CloudHistorySync$getRemoteData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudHistorySync$getRemoteData$1 r0 = new com.microtech.aidexx.data.CloudHistorySync$getRemoteData$1
            r0.<init>(r9, r13)
        L_0x0019:
            r7 = r0
            java.lang.Object r13 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r8 = 0
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r9 = r7.L$0
            com.microtech.aidexx.data.CloudHistorySync r9 = (com.microtech.aidexx.data.CloudHistorySync) r9
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0061
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r13)
            com.microtech.aidexx.data.DataTaskType$Download r13 = com.microtech.aidexx.data.DataTaskType.Download.INSTANCE
            com.microtech.aidexx.data.DataTaskType r13 = (com.microtech.aidexx.data.DataTaskType) r13
            boolean r13 = r9.canDoHttpRequest(r13)
            if (r13 != 0) goto L_0x0046
            return r8
        L_0x0046:
            com.microtech.aidexx.common.net.repository.EventRepository r1 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            java.lang.Long r4 = r11.getStartAutoIncrementColumn()
            java.lang.Long r5 = r11.getEndAutoIncrementColumn()
            java.lang.Class r6 = r9.getTClazz()
            r7.L$0 = r9
            r7.label = r2
            r2 = r10
            r3 = r12
            java.lang.Object r13 = r1.getEventRecordsByPageInfo(r2, r3, r4, r5, r6, r7)
            if (r13 != r0) goto L_0x0061
            return r0
        L_0x0061:
            com.microtech.aidexx.common.net.ApiResult r13 = (com.microtech.aidexx.common.net.ApiResult) r13
            boolean r10 = r13 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r10 == 0) goto L_0x007e
            com.microtech.aidexx.data.DataTaskType$Download r10 = com.microtech.aidexx.data.DataTaskType.Download.INSTANCE
            com.microtech.aidexx.data.DataTaskType r10 = (com.microtech.aidexx.data.DataTaskType) r10
            r9.onHttpRequestSuccess(r10)
            com.microtech.aidexx.common.net.ApiResult$Success r13 = (com.microtech.aidexx.common.net.ApiResult.Success) r13
            java.lang.Object r9 = r13.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r9 = (com.microtech.aidexx.common.net.entity.BaseResponse) r9
            java.lang.Object r9 = r9.getData()
            r8 = r9
            java.util.List r8 = (java.util.List) r8
            goto L_0x0082
        L_0x007e:
            boolean r9 = r13 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r9 == 0) goto L_0x0083
        L_0x0082:
            return r8
        L_0x0083:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync.getRemoteData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync, java.lang.String, com.microtech.aidexx.data.DataSyncController$SyncTaskItem, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object downloadData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync<T> r12, java.lang.String r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            boolean r0 = r14 instanceof com.microtech.aidexx.data.CloudHistorySync$downloadData$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.microtech.aidexx.data.CloudHistorySync$downloadData$1 r0 = (com.microtech.aidexx.data.CloudHistorySync$downloadData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudHistorySync$downloadData$1 r0 = new com.microtech.aidexx.data.CloudHistorySync$downloadData$1
            r0.<init>(r12, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "SyncTaskItemList "
            r4 = 0
            r5 = 2
            java.lang.String r6 = "CloudHistorySync"
            r7 = 1
            if (r2 == 0) goto L_0x0069
            if (r2 == r7) goto L_0x0051
            if (r2 != r5) goto L_0x0049
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$4
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r1 = r0.L$3
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.L$2
            com.microtech.aidexx.data.DataSyncController$SyncTaskItem r2 = (com.microtech.aidexx.data.DataSyncController.SyncTaskItem) r2
            java.lang.Object r3 = r0.L$1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.data.CloudHistorySync r0 = (com.microtech.aidexx.data.CloudHistorySync) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x015e
        L_0x0049:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0051:
            int r12 = r0.I$0
            java.lang.Object r13 = r0.L$2
            com.microtech.aidexx.data.DataSyncController$SyncTaskItem r13 = (com.microtech.aidexx.data.DataSyncController.SyncTaskItem) r13
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r8 = r0.L$0
            com.microtech.aidexx.data.CloudHistorySync r8 = (com.microtech.aidexx.data.CloudHistorySync) r8
            kotlin.ResultKt.throwOnFailure(r14)
            r11 = r2
            r2 = r12
            r12 = r8
            r8 = r13
            r13 = r11
            goto L_0x00e4
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r14 = "下载数据"
            boolean r14 = r12.canSync(r14)
            if (r14 == 0) goto L_0x0186
            com.microtech.aidexx.data.DataSyncController$SyncTaskItem r14 = r12.getFirstTaskItem(r13)
            if (r14 != 0) goto L_0x009b
            com.microtech.aidexx.utils.LogUtil$Companion r13 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "SyncTaskItemList=empty "
            r14.<init>(r0)
            java.lang.Class r12 = r12.getTClazz()
            java.lang.String r12 = r12.getSimpleName()
            java.lang.StringBuilder r12 = r14.append(r12)
            java.lang.String r12 = r12.toString()
            r13.d(r12, r6)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r12
        L_0x009b:
            java.lang.Class r2 = r12.getTClazz()
            java.lang.Class<com.microtech.aidexx.db.entity.RealCgmHistoryEntity> r8 = com.microtech.aidexx.db.entity.RealCgmHistoryEntity.class
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r8)
            if (r2 == 0) goto L_0x00aa
            r2 = 5000(0x1388, float:7.006E-42)
            goto L_0x00ac
        L_0x00aa:
            r2 = 500(0x1f4, float:7.0E-43)
        L_0x00ac:
            com.microtech.aidexx.utils.LogUtil$Companion r8 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.Class r10 = r12.getTClazz()
            java.lang.String r10 = r10.getSimpleName()
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.String r10 = " startGetRemoteData="
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r14)
            java.lang.String r9 = r9.toString()
            r8.xLogI(r9, r6)
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.I$0 = r2
            r0.label = r7
            java.lang.Object r8 = r12.getRemoteData(r13, r14, r2, r0)
            if (r8 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            r11 = r8
            r8 = r14
            r14 = r11
        L_0x00e4:
            java.util.List r14 = (java.util.List) r14
            if (r14 == 0) goto L_0x0181
            com.microtech.aidexx.utils.LogUtil$Companion r4 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r3)
            java.lang.Class r3 = r12.getTClazz()
            java.lang.String r3 = r3.getSimpleName()
            java.lang.StringBuilder r3 = r9.append(r3)
            java.lang.String r9 = " remoteData="
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r9 = " ret=["
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.Object r9 = kotlin.collections.CollectionsKt.first(r14)
            com.microtech.aidexx.db.entity.BaseEventEntity r9 = (com.microtech.aidexx.db.entity.BaseEventEntity) r9
            java.lang.Long r9 = r9.getAutoIncrementColumn()
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r9 = "->"
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.Object r9 = kotlin.collections.CollectionsKt.last(r14)
            com.microtech.aidexx.db.entity.BaseEventEntity r9 = (com.microtech.aidexx.db.entity.BaseEventEntity) r9
            java.lang.Long r9 = r9.getAutoIncrementColumn()
            java.lang.StringBuilder r3 = r3.append(r9)
            r9 = 93
            java.lang.StringBuilder r3 = r3.append(r9)
            java.lang.String r3 = r3.toString()
            r4.xLogI(r3, r6)
            r3 = r14
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0165
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r8
            r0.L$3 = r14
            r0.L$4 = r14
            r0.I$0 = r2
            r0.label = r5
            java.lang.Object r0 = r12.applyData(r13, r14, r0)
            if (r0 != r1) goto L_0x0158
            return r1
        L_0x0158:
            r0 = r12
            r3 = r13
            r13 = r14
            r1 = r13
            r12 = r2
            r2 = r8
        L_0x015e:
            r14 = r1
            r8 = r2
            r2 = r12
            r12 = r0
            r0 = r13
            r13 = r3
            goto L_0x0166
        L_0x0165:
            r0 = r14
        L_0x0166:
            int r14 = r14.size()
            if (r14 < r2) goto L_0x017d
            java.lang.Object r14 = kotlin.collections.CollectionsKt.last(r0)
            com.microtech.aidexx.db.entity.BaseEventEntity r14 = (com.microtech.aidexx.db.entity.BaseEventEntity) r14
            java.lang.Long r14 = r14.getAutoIncrementColumn()
            r8.setEndAutoIncrementColumn(r14)
            r12.updateFirstTaskItem(r13, r8)
            goto L_0x0180
        L_0x017d:
            r12.removeFirstTaskItem(r13)
        L_0x0180:
            r4 = r7
        L_0x0181:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r12
        L_0x0186:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync.downloadData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object uploadDeletedData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync<T> r5, java.util.List<java.lang.String> r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$1 r0 = (com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$1 r0 = new com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r5 = r0.L$0
            com.microtech.aidexx.data.CloudHistorySync r5 = (com.microtech.aidexx.data.CloudHistorySync) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005a
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            com.microtech.aidexx.data.DataTaskType$UploadDel r7 = com.microtech.aidexx.data.DataTaskType.UploadDel.INSTANCE
            com.microtech.aidexx.data.DataTaskType r7 = (com.microtech.aidexx.data.DataTaskType) r7
            boolean r7 = r5.canDoHttpRequest(r7)
            if (r7 != 0) goto L_0x0049
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L_0x0049:
            com.microtech.aidexx.common.net.repository.EventRepository r7 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            java.lang.Class r2 = r5.getTClazz()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.deleteEventByIds(r6, r2, r0)
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 == 0) goto L_0x006a
            com.microtech.aidexx.data.DataTaskType$UploadDel r6 = com.microtech.aidexx.data.DataTaskType.UploadDel.INSTANCE
            com.microtech.aidexx.data.DataTaskType r6 = (com.microtech.aidexx.data.DataTaskType) r6
            r5.onHttpRequestSuccess(r6)
            r3 = r4
        L_0x006a:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync.uploadDeletedData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object uploadDeletedData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync<T> r13, java.lang.String r14, kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
        /*
            boolean r14 = r15 instanceof com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$2
            if (r14 == 0) goto L_0x0014
            r14 = r15
            com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$2 r14 = (com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$2) r14
            int r0 = r14.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0014
            int r15 = r14.label
            int r15 = r15 - r1
            r14.label = r15
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$2 r14 = new com.microtech.aidexx.data.CloudHistorySync$uploadDeletedData$2
            r14.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r14.result
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r14.label
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 0
            r11 = 1
            if (r0 == 0) goto L_0x0050
            if (r0 == r11) goto L_0x0048
            if (r0 == r9) goto L_0x003b
            if (r0 != r8) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00ce
        L_0x0033:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003b:
            java.lang.Object r13 = r14.L$1
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r0 = r14.L$0
            com.microtech.aidexx.data.CloudHistorySync r0 = (com.microtech.aidexx.data.CloudHistorySync) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b3
        L_0x0048:
            java.lang.Object r13 = r14.L$0
            com.microtech.aidexx.data.CloudHistorySync r13 = (com.microtech.aidexx.data.CloudHistorySync) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0070
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.String r15 = "上传删除数据"
            boolean r15 = r13.canSync(r15)
            if (r15 == 0) goto L_0x00e0
            com.microtech.aidexx.db.repository.EventDbRepository r0 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            java.lang.Class r1 = r13.getTClazz()
            r14.L$0 = r13
            r14.label = r11
            r2 = 0
            r4 = 2
            r5 = 0
            r3 = r14
            java.lang.Object r15 = com.microtech.aidexx.db.repository.EventDbRepository.queryDeletedData$default(r0, r1, r2, r3, r4, r5)
            if (r15 != r6) goto L_0x0070
            return r6
        L_0x0070:
            java.util.List r15 = (java.util.List) r15
            if (r15 == 0) goto L_0x00db
            r0 = r15
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x009e
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DELETE "
            r1.<init>(r2)
            java.lang.Class r2 = r13.getTClazz()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " EMPTY"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CloudHistorySync"
            r0.d(r1, r2)
            r0 = r10
        L_0x009e:
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x00db
            r14.L$0 = r13
            r14.L$1 = r15
            r14.label = r9
            java.lang.Object r0 = r13.uploadDeletedData((java.util.List<java.lang.String>) r15, (kotlin.coroutines.Continuation<? super java.lang.Boolean>) r14)
            if (r0 != r6) goto L_0x00af
            return r6
        L_0x00af:
            r12 = r0
            r0 = r13
            r13 = r15
            r15 = r12
        L_0x00b3:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x00d1
            com.microtech.aidexx.db.repository.EventDbRepository r15 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            java.lang.Class r0 = r0.getTClazz()
            r14.L$0 = r10
            r14.L$1 = r10
            r14.label = r8
            java.lang.Object r15 = r15.updateDeleteStatusByIds(r13, r0, r14)
            if (r15 != r6) goto L_0x00ce
            return r6
        L_0x00ce:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            goto L_0x00d5
        L_0x00d1:
            java.lang.Boolean r15 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
        L_0x00d5:
            if (r15 == 0) goto L_0x00db
            boolean r11 = r15.booleanValue()
        L_0x00db:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r13
        L_0x00e0:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync.uploadDeletedData$suspendImpl(com.microtech.aidexx.data.CloudHistorySync, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getNeedUploadData(kotlin.coroutines.Continuation<? super java.util.List<T>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.data.CloudHistorySync$getNeedUploadData$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.data.CloudHistorySync$getNeedUploadData$1 r0 = (com.microtech.aidexx.data.CloudHistorySync$getNeedUploadData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudHistorySync$getNeedUploadData$1 r0 = new com.microtech.aidexx.data.CloudHistorySync$getNeedUploadData$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0053
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r6 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r6 = r6.instance()
            java.lang.String r6 = r6.userId()
            com.microtech.aidexx.db.ObjectBox r2 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            io.objectbox.BoxStore r2 = r2.getStore()
            com.microtech.aidexx.data.CloudHistorySync$$ExternalSyntheticLambda0 r4 = new com.microtech.aidexx.data.CloudHistorySync$$ExternalSyntheticLambda0
            r4.<init>(r5, r6)
            r0.label = r3
            java.lang.Object r6 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r2, r4, r0)
            if (r6 != r1) goto L_0x0053
            return r1
        L_0x0053:
            java.util.List r6 = (java.util.List) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync.getNeedUploadData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final List getNeedUploadData$lambda$5(CloudHistorySync cloudHistorySync, String str) {
        Intrinsics.checkNotNullParameter(cloudHistorySync, "this$0");
        Intrinsics.checkNotNullParameter(str, "$id");
        QueryBuilder<T> equal = cloudHistorySync.entityBox.query().equal(cloudHistorySync.getUploadState(), 1);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(...)");
        return ExtendsKt.equal(equal, cloudHistorySync.getUserId(), str).order(cloudHistorySync.getIdx()).build().find();
    }

    public static /* synthetic */ Object replaceEventData$default(CloudHistorySync cloudHistorySync, List list, List list2, int i, String str, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                list = new ArrayList();
            }
            List list3 = list;
            if ((i2 & 2) != 0) {
                list2 = new ArrayList();
            }
            List list4 = list2;
            if ((i2 & 4) != 0) {
                i = 0;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                str = null;
            }
            return cloudHistorySync.replaceEventData(list3, list4, i3, str, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceEventData");
    }

    static /* synthetic */ <T extends BaseEventEntity> Object replaceEventData$suspendImpl(CloudHistorySync<T> cloudHistorySync, List<T> list, List<? extends T> list2, int i, String str, Continuation<? super Unit> continuation) {
        for (T uploadState : list) {
            uploadState.setUploadState(2);
        }
        cloudHistorySync.entityBox.put(list);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0011\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/data/CloudHistorySync$Companion;", "", "()V", "TAG", "", "downloadData", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus;", "userId", "needWait", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadRecentData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadDeletedData", "", "uploadHistoryData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CloudHistorySync.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object downloadRecentData(String str, Continuation<? super Boolean> continuation) {
            return BuildersKt.withContext(DataSyncController.Companion.getScope().getCoroutineContext(), new CloudHistorySync$Companion$downloadRecentData$2(str, (Continuation<? super CloudHistorySync$Companion$downloadRecentData$2>) null), continuation);
        }

        public static /* synthetic */ Object downloadData$default(Companion companion, String str, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.downloadData(str, z, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00ba  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object downloadData(java.lang.String r11, boolean r12, kotlin.coroutines.Continuation<? super com.microtech.aidexx.data.DataSyncController.SyncStatus> r13) {
            /*
                r10 = this;
                boolean r0 = r13 instanceof com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$1
                if (r0 == 0) goto L_0x0014
                r0 = r13
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$1 r0 = (com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r13 = r0.label
                int r13 = r13 - r2
                r0.label = r13
                goto L_0x0019
            L_0x0014:
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$1 r0 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$1
                r0.<init>(r10, r13)
            L_0x0019:
                java.lang.Object r13 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 0
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L_0x003b
                if (r2 != r5) goto L_0x0033
                boolean r12 = r0.Z$0
                java.lang.Object r11 = r0.L$0
                kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x00b6
            L_0x0033:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L_0x003b:
                kotlin.ResultKt.throwOnFailure(r13)
                kotlin.jvm.internal.Ref$BooleanRef r13 = new kotlin.jvm.internal.Ref$BooleanRef
                r13.<init>()
                r13.element = r5
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                if (r12 == 0) goto L_0x0054
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$callback$1 r6 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$callback$1
                r6.<init>(r13, r2)
                kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
                goto L_0x0055
            L_0x0054:
                r6 = r4
            L_0x0055:
                r7 = 8
                kotlin.jvm.functions.Function0[] r7 = new kotlin.jvm.functions.Function0[r7]
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$1 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$1
                r8.<init>(r11, r6)
                r7[r3] = r8
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$2 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$2
                r8.<init>(r11, r6)
                r7[r5] = r8
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$3 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$3
                r8.<init>(r11, r6)
                r9 = 2
                r7[r9] = r8
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$4 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$4
                r8.<init>(r11, r6)
                r9 = 3
                r7[r9] = r8
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$5 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$5
                r8.<init>(r11, r6)
                r9 = 4
                r7[r9] = r8
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$6 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$6
                r8.<init>(r11, r6)
                r9 = 5
                r7[r9] = r8
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$7 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$7
                r8.<init>(r11, r6)
                r9 = 6
                r7[r9] = r8
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$8 r8 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$tasks$8
                r8.<init>(r11, r6)
                r11 = 7
                r7[r11] = r8
                java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r7)
                kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
                com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$2 r7 = new com.microtech.aidexx.data.CloudHistorySync$Companion$downloadData$2
                r7.<init>(r2, r12, r11, r4)
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r0.L$0 = r13
                r0.Z$0 = r12
                r0.label = r5
                java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r0)
                if (r11 != r1) goto L_0x00b5
                return r1
            L_0x00b5:
                r11 = r13
            L_0x00b6:
                boolean r11 = r11.element
                if (r11 == 0) goto L_0x00c7
                if (r12 == 0) goto L_0x00bf
                com.microtech.aidexx.data.DataSyncController$SyncStatus$Success r11 = com.microtech.aidexx.data.DataSyncController.SyncStatus.Success.INSTANCE
                goto L_0x00c4
            L_0x00bf:
                com.microtech.aidexx.data.DataSyncController$SyncStatus$Loading r11 = new com.microtech.aidexx.data.DataSyncController$SyncStatus$Loading
                r11.<init>(r3, r5, r4)
            L_0x00c4:
                com.microtech.aidexx.data.DataSyncController$SyncStatus r11 = (com.microtech.aidexx.data.DataSyncController.SyncStatus) r11
                goto L_0x00ce
            L_0x00c7:
                com.microtech.aidexx.data.DataSyncController$SyncStatus$Failure r11 = new com.microtech.aidexx.data.DataSyncController$SyncStatus$Failure
                r11.<init>(r4, r5, r4)
                com.microtech.aidexx.data.DataSyncController$SyncStatus r11 = (com.microtech.aidexx.data.DataSyncController.SyncStatus) r11
            L_0x00ce:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudHistorySync.Companion.downloadData(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* access modifiers changed from: private */
        public static final void downloadData$updateRet(Ref.BooleanRef booleanRef, Ref.ObjectRef<CountDownLatch> objectRef, DataSyncController.SyncStatus syncStatus) {
            boolean z;
            if (syncStatus instanceof DataSyncController.SyncStatus.Failure) {
                CountDownLatch countDownLatch = (CountDownLatch) objectRef.element;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                z = false;
            } else if (syncStatus instanceof DataSyncController.SyncStatus.Success) {
                CountDownLatch countDownLatch2 = (CountDownLatch) objectRef.element;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                z = booleanRef.element;
            } else {
                z = booleanRef.element;
            }
            booleanRef.element = z;
        }

        public final Object uploadHistoryData(Continuation<? super Unit> continuation) {
            Object withContext = BuildersKt.withContext(DataSyncController.Companion.getScope().getCoroutineContext(), new CloudHistorySync$Companion$uploadHistoryData$2((Continuation<? super CloudHistorySync$Companion$uploadHistoryData$2>) null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }

        public final void uploadDeletedData() {
            CloudBgHistorySync.INSTANCE.startUploadDeletedData();
            CloudDietHistorySync.INSTANCE.startUploadDeletedData();
            CloudExerciseHistorySync.INSTANCE.startUploadDeletedData();
            CloudMedicineHistorySync.INSTANCE.startUploadDeletedData();
            CloudInsulinHistorySync.INSTANCE.startUploadDeletedData();
            CloudOthersHistorySync.INSTANCE.startUploadDeletedData();
        }
    }
}
