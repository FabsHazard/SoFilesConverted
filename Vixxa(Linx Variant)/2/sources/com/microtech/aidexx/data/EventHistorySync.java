package com.microtech.aidexx.data;

import com.microtech.aidexx.data.DataSyncController;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u001c*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ)\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J'\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\u001b\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/microtech/aidexx/data/EventHistorySync;", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lcom/microtech/aidexx/data/DataSyncController;", "()V", "downloadData", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNeedUploadData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteData", "", "syncTaskItem", "Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;", "(Ljava/lang/String;Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpload", "data", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventDataAfterUpload", "", "origin", "responseList", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upload", "uploadDeletedData", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventHistorySync.kt */
public abstract class EventHistorySync<T extends BaseEventEntity> extends DataSyncController<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "EventHistorySync";

    /* access modifiers changed from: protected */
    public Object downloadData(String str, Continuation<? super Boolean> continuation) {
        return downloadData$suspendImpl(this, str, continuation);
    }

    public abstract Object getNeedUploadData(Continuation<? super List<T>> continuation);

    public Object getRemoteData(String str, DataSyncController.SyncTaskItem syncTaskItem, Continuation<? super List<? extends T>> continuation) {
        return getRemoteData$suspendImpl(this, str, syncTaskItem, continuation);
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/data/EventHistorySync$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventHistorySync.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveOrUpload(java.util.List<? extends T> r6, kotlin.coroutines.Continuation<? super java.util.List<T>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.microtech.aidexx.data.EventHistorySync$saveOrUpload$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.data.EventHistorySync$saveOrUpload$1 r0 = (com.microtech.aidexx.data.EventHistorySync$saveOrUpload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventHistorySync$saveOrUpload$1 r0 = new com.microtech.aidexx.data.EventHistorySync$saveOrUpload$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r6 = r0.L$0
            com.microtech.aidexx.data.EventHistorySync r6 = (com.microtech.aidexx.data.EventHistorySync) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0053
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            com.microtech.aidexx.data.DataTaskType$Upload r7 = com.microtech.aidexx.data.DataTaskType.Upload.INSTANCE
            com.microtech.aidexx.data.DataTaskType r7 = (com.microtech.aidexx.data.DataTaskType) r7
            boolean r7 = r5.canDoHttpRequest(r7)
            if (r7 != 0) goto L_0x0045
            return r3
        L_0x0045:
            com.microtech.aidexx.common.net.repository.EventRepository r7 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.saveOrUpdateRecords(r6, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            r6 = r5
        L_0x0053:
            com.microtech.aidexx.common.net.ApiResult r7 = (com.microtech.aidexx.common.net.ApiResult) r7
            boolean r0 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r0 == 0) goto L_0x0076
            com.microtech.aidexx.data.DataTaskType$Upload r0 = com.microtech.aidexx.data.DataTaskType.Upload.INSTANCE
            com.microtech.aidexx.data.DataTaskType r0 = (com.microtech.aidexx.data.DataTaskType) r0
            r6.onHttpRequestSuccess(r0)
            com.microtech.aidexx.common.net.ApiResult$Success r7 = (com.microtech.aidexx.common.net.ApiResult.Success) r7
            java.lang.Object r6 = r7.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r6 = (com.microtech.aidexx.common.net.entity.BaseResponse) r6
            java.lang.Object r6 = r6.getData()
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.collections.MutableList<T of com.microtech.aidexx.data.EventHistorySync>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            java.util.List r3 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r6)
            goto L_0x007a
        L_0x0076:
            boolean r6 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r6 == 0) goto L_0x007b
        L_0x007a:
            return r3
        L_0x007b:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventHistorySync.saveOrUpload(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object getRemoteData$suspendImpl(com.microtech.aidexx.data.EventHistorySync<T> r9, java.lang.String r10, com.microtech.aidexx.data.DataSyncController.SyncTaskItem r11, kotlin.coroutines.Continuation<? super java.util.List<? extends T>> r12) {
        /*
            boolean r0 = r12 instanceof com.microtech.aidexx.data.EventHistorySync$getRemoteData$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.microtech.aidexx.data.EventHistorySync$getRemoteData$1 r0 = (com.microtech.aidexx.data.EventHistorySync$getRemoteData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventHistorySync$getRemoteData$1 r0 = new com.microtech.aidexx.data.EventHistorySync$getRemoteData$1
            r0.<init>(r9, r12)
        L_0x0019:
            r7 = r0
            java.lang.Object r12 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r8 = 0
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r9 = r7.L$0
            com.microtech.aidexx.data.EventHistorySync r9 = (com.microtech.aidexx.data.EventHistorySync) r9
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0062
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r12)
            com.microtech.aidexx.data.DataTaskType$Download r12 = com.microtech.aidexx.data.DataTaskType.Download.INSTANCE
            com.microtech.aidexx.data.DataTaskType r12 = (com.microtech.aidexx.data.DataTaskType) r12
            boolean r12 = r9.canDoHttpRequest(r12)
            if (r12 != 0) goto L_0x0046
            return r8
        L_0x0046:
            com.microtech.aidexx.common.net.repository.EventRepository r1 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            java.lang.Long r4 = r11.getStartAutoIncrementColumn()
            java.lang.Long r5 = r11.getEndAutoIncrementColumn()
            java.lang.Class r6 = r9.getTClazz()
            r7.L$0 = r9
            r7.label = r2
            r3 = 500(0x1f4, float:7.0E-43)
            r2 = r10
            java.lang.Object r12 = r1.getEventRecordsByPageInfo(r2, r3, r4, r5, r6, r7)
            if (r12 != r0) goto L_0x0062
            return r0
        L_0x0062:
            com.microtech.aidexx.common.net.ApiResult r12 = (com.microtech.aidexx.common.net.ApiResult) r12
            boolean r10 = r12 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r10 == 0) goto L_0x0084
            com.microtech.aidexx.data.DataTaskType$Download r10 = com.microtech.aidexx.data.DataTaskType.Download.INSTANCE
            com.microtech.aidexx.data.DataTaskType r10 = (com.microtech.aidexx.data.DataTaskType) r10
            r9.onHttpRequestSuccess(r10)
            com.microtech.aidexx.common.net.ApiResult$Success r12 = (com.microtech.aidexx.common.net.ApiResult.Success) r12
            java.lang.Object r9 = r12.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r9 = (com.microtech.aidexx.common.net.entity.BaseResponse) r9
            java.lang.Object r9 = r9.getData()
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.collections.List<T of com.microtech.aidexx.data.EventHistorySync>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r10)
            r8 = r9
            java.util.List r8 = (java.util.List) r8
            goto L_0x0088
        L_0x0084:
            boolean r9 = r12 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r9 == 0) goto L_0x0089
        L_0x0088:
            return r8
        L_0x0089:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventHistorySync.getRemoteData$suspendImpl(com.microtech.aidexx.data.EventHistorySync, java.lang.String, com.microtech.aidexx.data.DataSyncController$SyncTaskItem, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object upload$suspendImpl(com.microtech.aidexx.data.EventHistorySync<T> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof com.microtech.aidexx.data.EventHistorySync$upload$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.microtech.aidexx.data.EventHistorySync$upload$1 r0 = (com.microtech.aidexx.data.EventHistorySync$upload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventHistorySync$upload$1 r0 = new com.microtech.aidexx.data.EventHistorySync$upload$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x004e
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009a
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.data.EventHistorySync r2 = (com.microtech.aidexx.data.EventHistorySync) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0089
        L_0x0046:
            java.lang.Object r8 = r0.L$0
            com.microtech.aidexx.data.EventHistorySync r8 = (com.microtech.aidexx.data.EventHistorySync) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = "上传数据"
            boolean r9 = r8.canSync(r9)
            if (r9 != 0) goto L_0x005c
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x005c:
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r8.getNeedUploadData(r0)
            if (r9 != r1) goto L_0x0067
            return r1
        L_0x0067:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x009a
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L_0x0074
            r9 = r6
        L_0x0074:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x009a
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = r8.saveOrUpload(r9, r0)
            if (r2 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L_0x0089:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x009a
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r2.updateEventDataAfterUpload(r8, r9, r0)
            if (r8 != r1) goto L_0x009a
            return r1
        L_0x009a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventHistorySync.upload$suspendImpl(com.microtech.aidexx.data.EventHistorySync, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object downloadData$suspendImpl(com.microtech.aidexx.data.EventHistorySync<T> r7, java.lang.String r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            boolean r0 = r9 instanceof com.microtech.aidexx.data.EventHistorySync$downloadData$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.microtech.aidexx.data.EventHistorySync$downloadData$1 r0 = (com.microtech.aidexx.data.EventHistorySync$downloadData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventHistorySync$downloadData$1 r0 = new com.microtech.aidexx.data.EventHistorySync$downloadData$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005b
            if (r2 == r5) goto L_0x0047
            if (r2 != r4) goto L_0x003f
            java.lang.Object r7 = r0.L$3
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r0.L$2
            com.microtech.aidexx.data.DataSyncController$SyncTaskItem r8 = (com.microtech.aidexx.data.DataSyncController.SyncTaskItem) r8
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.data.EventHistorySync r0 = (com.microtech.aidexx.data.EventHistorySync) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00cd
        L_0x003f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0047:
            java.lang.Object r7 = r0.L$2
            com.microtech.aidexx.data.DataSyncController$SyncTaskItem r7 = (com.microtech.aidexx.data.DataSyncController.SyncTaskItem) r7
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.data.EventHistorySync r2 = (com.microtech.aidexx.data.EventHistorySync) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r9
            r9 = r7
            r7 = r2
            r2 = r6
            goto L_0x00ab
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "下载数据-"
            r9.<init>(r2)
            java.lang.StringBuilder r9 = r9.append(r8)
            java.lang.String r9 = r9.toString()
            boolean r9 = r7.canSync(r9)
            if (r9 == 0) goto L_0x00f3
            com.microtech.aidexx.data.DataSyncController$SyncTaskItem r9 = r7.getFirstTaskItem(r8)
            if (r9 != 0) goto L_0x009c
            com.microtech.aidexx.utils.LogUtil$Companion r8 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "SyncTaskItemList=empty "
            r9.<init>(r0)
            java.lang.Class r7 = r7.getTClazz()
            java.lang.String r7 = r7.getSimpleName()
            java.lang.StringBuilder r7 = r9.append(r7)
            java.lang.String r7 = r7.toString()
            java.lang.String r9 = "EventHistorySync"
            r8.d(r7, r9)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        L_0x009c:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.label = r5
            java.lang.Object r2 = r7.getRemoteData(r8, r9, r0)
            if (r2 != r1) goto L_0x00ab
            return r1
        L_0x00ab:
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00ee
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x00d1
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r2
            r0.label = r4
            java.lang.Object r0 = r7.applyData(r8, r2, r0)
            if (r0 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            r0 = r7
            r1 = r8
            r8 = r9
            r7 = r2
        L_0x00cd:
            r2 = r7
            r9 = r8
            r7 = r0
            r8 = r1
        L_0x00d1:
            int r0 = r2.size()
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 < r1) goto L_0x00ea
            java.lang.Object r0 = kotlin.collections.CollectionsKt.last(r2)
            com.microtech.aidexx.db.entity.BaseEventEntity r0 = (com.microtech.aidexx.db.entity.BaseEventEntity) r0
            java.lang.Long r0 = r0.getAutoIncrementColumn()
            r9.setEndAutoIncrementColumn(r0)
            r7.updateFirstTaskItem(r8, r9)
            goto L_0x00ed
        L_0x00ea:
            r7.removeFirstTaskItem(r8)
        L_0x00ed:
            r3 = r5
        L_0x00ee:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r7
        L_0x00f3:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventHistorySync.downloadData$suspendImpl(com.microtech.aidexx.data.EventHistorySync, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object updateEventDataAfterUpload(List<T> list, List<T> list2, Continuation<? super Unit> continuation) {
        Object obj;
        for (T t : list) {
            t.setUploadState(2);
            if (t.getAutoIncrementColumn() == null) {
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) t, (Object) (BaseEventEntity) obj)) {
                        break;
                    }
                }
                BaseEventEntity baseEventEntity = (BaseEventEntity) obj;
                if (baseEventEntity != null) {
                    t.setAutoIncrementColumn(baseEventEntity.getAutoIncrementColumn());
                    Boxing.boxBoolean(list2.remove(baseEventEntity));
                }
            }
        }
        Object insertToDb = DataSyncController.Companion.insertToDb(list, CloudDietHistorySync.INSTANCE.getTClazz(), continuation);
        return insertToDb == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insertToDb : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object uploadDeletedData$suspendImpl(com.microtech.aidexx.data.EventHistorySync<T> r5, java.util.List<java.lang.String> r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            boolean r0 = r7 instanceof com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$1 r0 = (com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$1 r0 = new com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$1
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
            com.microtech.aidexx.data.EventHistorySync r5 = (com.microtech.aidexx.data.EventHistorySync) r5
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
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventHistorySync.uploadDeletedData$suspendImpl(com.microtech.aidexx.data.EventHistorySync, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.BaseEventEntity> java.lang.Object uploadDeletedData$suspendImpl(com.microtech.aidexx.data.EventHistorySync<T> r13, java.lang.String r14, kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
        /*
            boolean r14 = r15 instanceof com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$2
            if (r14 == 0) goto L_0x0014
            r14 = r15
            com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$2 r14 = (com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$2) r14
            int r0 = r14.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0014
            int r15 = r14.label
            int r15 = r15 - r1
            r14.label = r15
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$2 r14 = new com.microtech.aidexx.data.EventHistorySync$uploadDeletedData$2
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
            com.microtech.aidexx.data.EventHistorySync r0 = (com.microtech.aidexx.data.EventHistorySync) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b3
        L_0x0048:
            java.lang.Object r13 = r14.L$0
            com.microtech.aidexx.data.EventHistorySync r13 = (com.microtech.aidexx.data.EventHistorySync) r13
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
            java.lang.String r2 = "EventHistorySync"
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
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventHistorySync.uploadDeletedData$suspendImpl(com.microtech.aidexx.data.EventHistorySync, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
