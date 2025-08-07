package com.microtech.aidexx.data;

import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity_;
import com.microtech.aidexx.utils.LogUtil;
import io.objectbox.Property;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003JO\u0010\u0012\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0014\u0018\u00010\u00132.\u0010\u0015\u001a*\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00180\u0016j\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0018`\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJA\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010!R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/data/CloudCalHistorySync;", "Lcom/microtech/aidexx/data/CloudHistorySync;", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "()V", "deleteStatus", "Lio/objectbox/Property;", "getDeleteStatus", "()Lio/objectbox/Property;", "frontRecordId", "getFrontRecordId", "id", "getId", "idx", "getIdx", "uploadState", "getUploadState", "userId", "getUserId", "postLocalData", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "map", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceEventData", "", "origin", "responseList", "type", "", "(Ljava/util/List;Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CloudCalHistorySync.kt */
public final class CloudCalHistorySync extends CloudHistorySync<CalibrateEntity> {
    public static final CloudCalHistorySync INSTANCE = new CloudCalHistorySync();

    private CloudCalHistorySync() {
    }

    public Property<CalibrateEntity> getIdx() {
        Property<CalibrateEntity> property = CalibrateEntity_.idx;
        Intrinsics.checkNotNullExpressionValue(property, "idx");
        return property;
    }

    public Property<CalibrateEntity> getId() {
        Property<CalibrateEntity> property = CalibrateEntity_.id;
        Intrinsics.checkNotNullExpressionValue(property, "id");
        return property;
    }

    public Property<CalibrateEntity> getFrontRecordId() {
        Property<CalibrateEntity> property = CalibrateEntity_.calibrationId;
        Intrinsics.checkNotNullExpressionValue(property, "calibrationId");
        return property;
    }

    public Property<CalibrateEntity> getUserId() {
        Property<CalibrateEntity> property = CalibrateEntity_.userId;
        Intrinsics.checkNotNullExpressionValue(property, "userId");
        return property;
    }

    public Property<CalibrateEntity> getDeleteStatus() {
        Property<CalibrateEntity> property = CalibrateEntity_.deleteStatus;
        Intrinsics.checkNotNullExpressionValue(property, "deleteStatus");
        return property;
    }

    public Property<CalibrateEntity> getUploadState() {
        Property<CalibrateEntity> property = CalibrateEntity_.uploadState;
        Intrinsics.checkNotNullExpressionValue(property, "uploadState");
        return property;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object postLocalData(java.util.HashMap<java.lang.String, java.util.List<com.microtech.aidexx.db.entity.CalibrateEntity>> r6, kotlin.coroutines.Continuation<? super com.microtech.aidexx.common.net.entity.BaseResponse<java.util.List<com.microtech.aidexx.db.entity.CalibrateEntity>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.microtech.aidexx.data.CloudCalHistorySync$postLocalData$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.data.CloudCalHistorySync$postLocalData$1 r0 = (com.microtech.aidexx.data.CloudCalHistorySync$postLocalData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudCalHistorySync$postLocalData$1 r0 = new com.microtech.aidexx.data.CloudCalHistorySync$postLocalData$1
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
            com.microtech.aidexx.data.CloudCalHistorySync r6 = (com.microtech.aidexx.data.CloudCalHistorySync) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0057
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
            com.microtech.aidexx.common.net.ApiService$Companion r7 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r7 = r7.getInstance()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.postCalHistory(r6, r0)
            if (r7 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r6 = r5
        L_0x0057:
            com.microtech.aidexx.common.net.ApiResult r7 = (com.microtech.aidexx.common.net.ApiResult) r7
            boolean r0 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r0 == 0) goto L_0x006e
            com.microtech.aidexx.data.DataTaskType$Upload r0 = com.microtech.aidexx.data.DataTaskType.Upload.INSTANCE
            com.microtech.aidexx.data.DataTaskType r0 = (com.microtech.aidexx.data.DataTaskType) r0
            r6.onHttpRequestSuccess(r0)
            com.microtech.aidexx.common.net.ApiResult$Success r7 = (com.microtech.aidexx.common.net.ApiResult.Success) r7
            java.lang.Object r6 = r7.getResult()
            r3 = r6
            com.microtech.aidexx.common.net.entity.BaseResponse r3 = (com.microtech.aidexx.common.net.entity.BaseResponse) r3
            goto L_0x0072
        L_0x006e:
            boolean r6 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r6 == 0) goto L_0x0073
        L_0x0072:
            return r3
        L_0x0073:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudCalHistorySync.postLocalData(java.util.HashMap, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object replaceEventData(List<CalibrateEntity> list, List<CalibrateEntity> list2, int i, String str, Continuation<? super Unit> continuation) {
        if (list2 != null) {
            Collection collection = list;
            if (!collection.isEmpty()) {
                if (list2.size() != list.size()) {
                    LogUtil.Companion.xLogE$default(LogUtil.Companion, "校准上传异常 responseList=" + list2 + " origin=" + list, (String) null, 2, (Object) null);
                } else {
                    int i2 = 0;
                    for (CalibrateEntity next : list) {
                        next.setUploadState(2);
                        next.setAutoIncrementColumn(list2.get(i2).getAutoIncrementColumn());
                        i2++;
                    }
                    INSTANCE.getEntityBox().put(collection);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
