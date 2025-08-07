package com.microtech.aidexx.ui.setting.timezonehistory;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity_;
import io.objectbox.Box;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u0011\u0010\u0012\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/ui/setting/timezonehistory/TimezoneHistoryManager;", "", "()V", "needRefreshChart", "Lkotlin/Pair;", "", "getNeedRefreshChart", "()Lkotlin/Pair;", "setNeedRefreshChart", "(Lkotlin/Pair;)V", "createTimezoneHistory", "", "from", "", "to", "isDstChange", "dst", "", "downloadTimezoneHistory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadTimezoneHistory", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimezoneHistoryManager.kt */
public final class TimezoneHistoryManager {
    public static final TimezoneHistoryManager INSTANCE = new TimezoneHistoryManager();
    private static Pair<Boolean, Boolean> needRefreshChart = new Pair<>(false, true);

    private TimezoneHistoryManager() {
    }

    public final Pair<Boolean, Boolean> getNeedRefreshChart() {
        return needRefreshChart;
    }

    public final void setNeedRefreshChart(Pair<Boolean, Boolean> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        needRefreshChart = pair;
    }

    public final void createTimezoneHistory(String str, String str2, boolean z, int i) {
        Intrinsics.checkNotNullParameter(str, TypedValues.TransitionType.S_FROM);
        Intrinsics.checkNotNullParameter(str2, TypedValues.TransitionType.S_TO);
        Job unused = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new TimezoneHistoryManager$createTimezoneHistory$1(str, str2, z, (Continuation<? super TimezoneHistoryManager$createTimezoneHistory$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object uploadTimezoneHistory(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$uploadTimezoneHistory$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$uploadTimezoneHistory$1 r0 = (com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$uploadTimezoneHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$uploadTimezoneHistory$1 r0 = new com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$uploadTimezoneHistory$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009f
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0054
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.microtech.aidexx.db.ObjectBox r9 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$$ExternalSyntheticLambda0 r2 = new com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$$ExternalSyntheticLambda0
            r2.<init>()
            io.objectbox.BoxStore r9 = r9.getStore()
            r0.label = r4
            java.lang.Object r9 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r9, r2, r0)
            if (r9 != r1) goto L_0x0054
            return r1
        L_0x0054:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x00e6
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r4
            if (r2 != r4) goto L_0x00e6
            kotlin.Pair[] r2 = new kotlin.Pair[r4]
            java.lang.String r4 = "records"
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r9)
            r5 = 0
            r2[r5] = r4
            java.util.HashMap r2 = kotlin.collections.MapsKt.hashMapOf(r2)
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            java.lang.String r2 = r4.toJson((java.lang.Object) r2)
            okhttp3.RequestBody$Companion r4 = okhttp3.RequestBody.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            okhttp3.MediaType$Companion r5 = okhttp3.MediaType.Companion
            java.lang.String r6 = "application/json"
            okhttp3.MediaType r5 = r5.get(r6)
            okhttp3.RequestBody r2 = r4.create((java.lang.String) r2, (okhttp3.MediaType) r5)
            com.microtech.aidexx.common.net.ApiService$Companion r4 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r4 = r4.getInstance()
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r0 = r4.uploadTimezoneHistory(r2, r0)
            if (r0 != r1) goto L_0x009c
            return r1
        L_0x009c:
            r7 = r0
            r0 = r9
            r9 = r7
        L_0x009f:
            com.microtech.aidexx.common.net.ApiResult r9 = (com.microtech.aidexx.common.net.ApiResult) r9
            boolean r1 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r1 == 0) goto L_0x00c8
            java.util.Iterator r9 = r0.iterator()
        L_0x00a9:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L_0x00b9
            java.lang.Object r1 = r9.next()
            com.microtech.aidexx.db.entity.TimezoneHistoryEntity r1 = (com.microtech.aidexx.db.entity.TimezoneHistoryEntity) r1
            r1.setUploadState(r3)
            goto L_0x00a9
        L_0x00b9:
            com.microtech.aidexx.db.ObjectBox r9 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            io.objectbox.Box r9 = r9.getTimeZoneHistoryBox()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            java.util.Collection r0 = (java.util.Collection) r0
            r9.put(r0)
            goto L_0x00e6
        L_0x00c8:
            boolean r0 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r0 == 0) goto L_0x00e6
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "uploadTimezoneHistory fail:"
            r1.<init>(r2)
            com.microtech.aidexx.common.net.ApiResult$Failure r9 = (com.microtech.aidexx.common.net.ApiResult.Failure) r9
            java.lang.String r9 = r9.getMsg()
            java.lang.StringBuilder r9 = r1.append(r9)
            java.lang.String r9 = r9.toString()
            r0.eAiDEX(r9)
        L_0x00e6:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager.uploadTimezoneHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final List uploadTimezoneHistory$lambda$0() {
        Box<TimezoneHistoryEntity> timeZoneHistoryBox = ObjectBox.INSTANCE.getTimeZoneHistoryBox();
        Intrinsics.checkNotNull(timeZoneHistoryBox);
        return timeZoneHistoryBox.query().equal(TimezoneHistoryEntity_.uploadState, 1).order(TimezoneHistoryEntity_.idx).build().find(0, 500);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadTimezoneHistory(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$downloadTimezoneHistory$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$downloadTimezoneHistory$1 r0 = (com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$downloadTimezoneHistory$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$downloadTimezoneHistory$1 r0 = new com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager$downloadTimezoneHistory$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.microtech.aidexx.common.net.ApiService$Companion r5 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r5 = r5.getInstance()
            r0.label = r3
            java.lang.Object r5 = r5.downloadTimezoneHistory(r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            com.microtech.aidexx.common.net.ApiResult r5 = (com.microtech.aidexx.common.net.ApiResult) r5
            boolean r0 = r5 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r0 == 0) goto L_0x006d
            com.microtech.aidexx.common.net.ApiResult$Success r5 = (com.microtech.aidexx.common.net.ApiResult.Success) r5
            java.lang.Object r5 = r5.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r5 = (com.microtech.aidexx.common.net.entity.BaseResponse) r5
            java.lang.Object r5 = r5.getData()
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0068
            com.microtech.aidexx.db.ObjectBox r0 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            io.objectbox.Box r0 = r0.getTimeZoneHistoryBox()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.Collection r5 = (java.util.Collection) r5
            r0.put(r5)
        L_0x0068:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L_0x006d:
            boolean r0 = r5 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r0 == 0) goto L_0x0091
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "downloadTimezoneHistory fail:"
            r1.<init>(r2)
            com.microtech.aidexx.common.net.ApiResult$Failure r5 = (com.microtech.aidexx.common.net.ApiResult.Failure) r5
            java.lang.String r5 = r5.getMsg()
            java.lang.StringBuilder r5 = r1.append(r5)
            java.lang.String r5 = r5.toString()
            r0.eAiDEX(r5)
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        L_0x0091:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager.downloadTimezoneHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
