package com.microtech.aidexx.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity_;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.QueryBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J#\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0002J'\u0010!\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020#\u0018\u00010\"2\u0006\u0010$\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010&JO\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020#\u0018\u00010\"2.\u0010(\u001a*\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b0)j\u0014\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b`+H@ø\u0001\u0000¢\u0006\u0002\u0010,JA\u0010-\u001a\u00020 2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010#2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010*H@ø\u0001\u0000¢\u0006\u0002\u00100JO\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020#\u0018\u00010\"2.\u0010(\u001a*\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b0)j\u0014\u0012\u0004\u0012\u00020*\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001b`+H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0011\u00102\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u00103R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/microtech/aidexx/data/CloudCgmHistorySync;", "Lcom/microtech/aidexx/data/CloudHistorySync;", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "()V", "briefUploadState", "Lio/objectbox/Property;", "currentTimezone", "Ljava/util/TimeZone;", "deleteStatus", "getDeleteStatus", "()Lio/objectbox/Property;", "eventWarning", "getEventWarning", "frontRecordId", "getFrontRecordId", "gsonBuilder", "Lcom/google/gson/Gson;", "id", "getId", "idx", "getIdx", "rawUploadState", "uploadState", "getUploadState", "userId", "getUserId", "getNeedUploadData", "", "type", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initGsonBuilder", "", "postBriefData", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postLocalData", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "replaceEventData", "origin", "responseList", "(Ljava/util/List;Ljava/util/List;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHistory", "upload", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CloudCgmHistorySync.kt */
public final class CloudCgmHistorySync extends CloudHistorySync<RealCgmHistoryEntity> {
    public static final CloudCgmHistorySync INSTANCE = new CloudCgmHistorySync();
    private static final Property<RealCgmHistoryEntity> briefUploadState;
    private static TimeZone currentTimezone;
    private static final Property<RealCgmHistoryEntity> deleteStatus;
    private static final Property<RealCgmHistoryEntity> eventWarning;
    private static final Property<RealCgmHistoryEntity> frontRecordId;
    private static Gson gsonBuilder;
    private static final Property<RealCgmHistoryEntity> id;
    private static final Property<RealCgmHistoryEntity> idx;
    private static final Property<RealCgmHistoryEntity> rawUploadState;
    private static final Property<RealCgmHistoryEntity> userId;

    public Object postLocalData(HashMap<String, List<RealCgmHistoryEntity>> hashMap, Continuation<? super BaseResponse<List<RealCgmHistoryEntity>>> continuation) {
        return null;
    }

    private CloudCgmHistorySync() {
    }

    static {
        Property<RealCgmHistoryEntity> property = RealCgmHistoryEntity_.idx;
        Intrinsics.checkNotNullExpressionValue(property, "idx");
        idx = property;
        Property<RealCgmHistoryEntity> property2 = RealCgmHistoryEntity_.id;
        Intrinsics.checkNotNullExpressionValue(property2, "id");
        id = property2;
        Property<RealCgmHistoryEntity> property3 = RealCgmHistoryEntity_.frontRecordId;
        Intrinsics.checkNotNullExpressionValue(property3, "frontRecordId");
        frontRecordId = property3;
        Property<RealCgmHistoryEntity> property4 = RealCgmHistoryEntity_.userId;
        Intrinsics.checkNotNullExpressionValue(property4, "userId");
        userId = property4;
        Property<RealCgmHistoryEntity> property5 = RealCgmHistoryEntity_.briefUploadState;
        Intrinsics.checkNotNullExpressionValue(property5, "briefUploadState");
        briefUploadState = property5;
        Property<RealCgmHistoryEntity> property6 = RealCgmHistoryEntity_.rawUploadState;
        Intrinsics.checkNotNullExpressionValue(property6, "rawUploadState");
        rawUploadState = property6;
        Property<RealCgmHistoryEntity> property7 = RealCgmHistoryEntity_.deleteStatus;
        Intrinsics.checkNotNullExpressionValue(property7, "deleteStatus");
        deleteStatus = property7;
        Property<RealCgmHistoryEntity> property8 = RealCgmHistoryEntity_.eventWarning;
        Intrinsics.checkNotNullExpressionValue(property8, "eventWarning");
        eventWarning = property8;
    }

    public Property<RealCgmHistoryEntity> getIdx() {
        return idx;
    }

    public Property<RealCgmHistoryEntity> getId() {
        return id;
    }

    public Property<RealCgmHistoryEntity> getFrontRecordId() {
        return frontRecordId;
    }

    public Property<RealCgmHistoryEntity> getUserId() {
        return userId;
    }

    public Property<RealCgmHistoryEntity> getDeleteStatus() {
        return deleteStatus;
    }

    public Property<RealCgmHistoryEntity> getUploadState() {
        Property<RealCgmHistoryEntity> property = RealCgmHistoryEntity_.uploadState;
        Intrinsics.checkNotNullExpressionValue(property, "uploadState");
        return property;
    }

    public final Property<RealCgmHistoryEntity> getEventWarning() {
        return eventWarning;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object postBriefData(okhttp3.RequestBody r6, kotlin.coroutines.Continuation<? super com.microtech.aidexx.common.net.entity.BaseResponse<java.util.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.microtech.aidexx.data.CloudCgmHistorySync$postBriefData$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.data.CloudCgmHistorySync$postBriefData$1 r0 = (com.microtech.aidexx.data.CloudCgmHistorySync$postBriefData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudCgmHistorySync$postBriefData$1 r0 = new com.microtech.aidexx.data.CloudCgmHistorySync$postBriefData$1
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
            com.microtech.aidexx.data.CloudCgmHistorySync r6 = (com.microtech.aidexx.data.CloudCgmHistorySync) r6
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
            java.lang.Object r7 = r7.postBriefHistory(r6, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudCgmHistorySync.postBriefData(okhttp3.RequestBody, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object getNeedUploadData$default(CloudCgmHistorySync cloudCgmHistorySync, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return cloudCgmHistorySync.getNeedUploadData(i, continuation);
    }

    /* access modifiers changed from: private */
    public final Object getNeedUploadData(int i, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        String userId2 = UserInfoManager.Companion.instance().userId();
        QueryBuilder query = getEntityBox().query();
        if (i == 0) {
            QueryBuilder<T> equal = query.equal(briefUploadState, 1);
            Intrinsics.checkNotNullExpressionValue(equal, "equal(...)");
            ExtendsKt.equal(equal, getUserId(), userId2);
        } else if (i == 1) {
            QueryBuilder<T> equal2 = query.equal(briefUploadState, 2);
            Intrinsics.checkNotNullExpressionValue(equal2, "equal(...)");
            ExtendsKt.equal(equal2, getUserId(), userId2).equal(rawUploadState, 1);
        }
        return BoxStoreKt.awaitCallInTx(ObjectBox.INSTANCE.getStore(), new CloudCgmHistorySync$$ExternalSyntheticLambda0(query), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getNeedUploadData$lambda$0(QueryBuilder queryBuilder) {
        return queryBuilder.order(INSTANCE.getIdx()).build().find(0, 500);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateHistory(java.util.HashMap<java.lang.String, java.util.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity>> r6, kotlin.coroutines.Continuation<? super com.microtech.aidexx.common.net.entity.BaseResponse<java.util.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity>>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.microtech.aidexx.data.CloudCgmHistorySync$updateHistory$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.data.CloudCgmHistorySync$updateHistory$1 r0 = (com.microtech.aidexx.data.CloudCgmHistorySync$updateHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudCgmHistorySync$updateHistory$1 r0 = new com.microtech.aidexx.data.CloudCgmHistorySync$updateHistory$1
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
            com.microtech.aidexx.data.CloudCgmHistorySync r6 = (com.microtech.aidexx.data.CloudCgmHistorySync) r6
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
            java.lang.Object r7 = r7.updateHistory(r6, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudCgmHistorySync.updateHistory(java.util.HashMap, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0146 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object upload(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.microtech.aidexx.data.CloudCgmHistorySync$upload$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.microtech.aidexx.data.CloudCgmHistorySync$upload$1 r0 = (com.microtech.aidexx.data.CloudCgmHistorySync$upload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.CloudCgmHistorySync$upload$1 r0 = new com.microtech.aidexx.data.CloudCgmHistorySync$upload$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = " - "
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 0
            r9 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r9) goto L_0x004e
            if (r2 == r6) goto L_0x0045
            if (r2 == r5) goto L_0x0040
            if (r2 != r4) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0147
        L_0x0038:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00f2
        L_0x0045:
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.data.CloudCgmHistorySync r2 = (com.microtech.aidexx.data.CloudCgmHistorySync) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00e7
        L_0x004e:
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.data.CloudCgmHistorySync r2 = (com.microtech.aidexx.data.CloudCgmHistorySync) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0068
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r15)
            r14.initGsonBuilder()
            r0.L$0 = r14
            r0.label = r9
            java.lang.Object r15 = r14.getNeedUploadData(r8, r0)
            if (r15 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r14
        L_0x0068:
            java.util.List r15 = (java.util.List) r15
            if (r15 == 0) goto L_0x00e7
            int r10 = r15.size()
            if (r10 <= 0) goto L_0x00e7
            kotlin.Pair[] r10 = new kotlin.Pair[r9]
            java.lang.String r11 = "records"
            kotlin.Pair r11 = kotlin.TuplesKt.to(r11, r15)
            r10[r8] = r11
            java.util.HashMap r10 = kotlin.collections.MapsKt.hashMapOf(r10)
            com.google.gson.Gson r11 = gsonBuilder
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.String r10 = r11.toJson((java.lang.Object) r10)
            okhttp3.RequestBody$Companion r11 = okhttp3.RequestBody.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            okhttp3.MediaType$Companion r12 = okhttp3.MediaType.Companion
            java.lang.String r13 = "application/json"
            okhttp3.MediaType r12 = r12.get(r13)
            okhttp3.RequestBody r10 = r11.create((java.lang.String) r10, (okhttp3.MediaType) r12)
            com.microtech.aidexx.utils.LogUtil$Companion r11 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Upload brief History: timeOffset: "
            r12.<init>(r13)
            java.lang.Object r13 = r15.get(r8)
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r13 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r13
            int r13 = r13.getTimeOffset()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.StringBuilder r12 = r12.append(r3)
            int r13 = r15.size()
            int r13 = r13 - r9
            java.lang.Object r13 = r15.get(r13)
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r13 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r13
            int r13 = r13.getTimeOffset()
            java.lang.StringBuilder r12 = r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.eAiDEX(r12)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            com.microtech.aidexx.data.CloudCgmHistorySync$upload$2$1 r12 = new com.microtech.aidexx.data.CloudCgmHistorySync$upload$2$1
            r12.<init>(r10, r15, r7)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r0.L$0 = r2
            r0.label = r6
            java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r11, r12, r0)
            if (r15 != r1) goto L_0x00e7
            return r1
        L_0x00e7:
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r15 = r2.getNeedUploadData(r9, r0)
            if (r15 != r1) goto L_0x00f2
            return r1
        L_0x00f2:
            java.util.List r15 = (java.util.List) r15
            if (r15 == 0) goto L_0x0147
            int r2 = r15.size()
            if (r2 <= 0) goto L_0x0147
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Upload raw history: timeOffset: "
            r5.<init>(r6)
            java.lang.Object r6 = r15.get(r8)
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r6 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r6
            int r6 = r6.getTimeOffset()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r3 = r5.append(r3)
            int r5 = r15.size()
            int r5 = r5 - r9
            java.lang.Object r5 = r15.get(r5)
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r5 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r5
            int r5 = r5.getTimeOffset()
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.eAiDEX(r3)
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.microtech.aidexx.data.CloudCgmHistorySync$upload$3$1 r3 = new com.microtech.aidexx.data.CloudCgmHistorySync$upload$3$1
            r3.<init>(r15, r7)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0.label = r4
            java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r2, r3, r0)
            if (r15 != r1) goto L_0x0147
            return r1
        L_0x0147:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.CloudCgmHistorySync.upload(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void initGsonBuilder() {
        if (gsonBuilder == null || !Intrinsics.areEqual((Object) currentTimezone, (Object) TimeZone.getDefault())) {
            gsonBuilder = new GsonBuilder().addSerializationExclusionStrategy(new CloudCgmHistorySync$initGsonBuilder$1()).setDateFormat(ExtendsKt.DATE_FORMAT_YMDHMSZ).create();
            currentTimezone = TimeZone.getDefault();
        }
    }

    public Object replaceEventData(List<RealCgmHistoryEntity> list, List<RealCgmHistoryEntity> list2, int i, String str, Continuation<? super Unit> continuation) {
        if (list2 != null && !list2.isEmpty()) {
            List arrayList = new ArrayList();
            for (RealCgmHistoryEntity next : list2) {
                String frontRecordId2 = next.getFrontRecordId();
                if (frontRecordId2 != null) {
                    Box<RealCgmHistoryEntity> cgmHistoryBox = ObjectBox.INSTANCE.getCgmHistoryBox();
                    Intrinsics.checkNotNull(cgmHistoryBox);
                    QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryBox.query();
                    Intrinsics.checkNotNullExpressionValue(query, "query(...)");
                    Property<RealCgmHistoryEntity> property = RealCgmHistoryEntity_.frontRecordId;
                    Intrinsics.checkNotNullExpressionValue(property, "frontRecordId");
                    RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) ExtendsKt.equal(query, property, frontRecordId2).order(RealCgmHistoryEntity_.idx).build().findFirst();
                    if (i != 1) {
                        if (i == 2 && realCgmHistoryEntity != null) {
                            realCgmHistoryEntity.setRawUploadState(2);
                            Boxing.boxBoolean(arrayList.add(realCgmHistoryEntity));
                        }
                    } else if (realCgmHistoryEntity != null) {
                        realCgmHistoryEntity.setBriefUploadState(2);
                        if (realCgmHistoryEntity.getAutoIncrementColumn() == null) {
                            realCgmHistoryEntity.setAutoIncrementColumn(next.getAutoIncrementColumn());
                        }
                        if (realCgmHistoryEntity.getCgmRecordId() == null) {
                            realCgmHistoryEntity.setCgmRecordId(next.getCgmRecordId());
                        }
                        Boxing.boxBoolean(arrayList.add(realCgmHistoryEntity));
                    }
                }
            }
            INSTANCE.getEntityBox().put(arrayList);
        }
        return Unit.INSTANCE;
    }
}
