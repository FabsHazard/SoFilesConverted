package com.microtech.aidexx.data.wear;

import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/data/wear/WatchData;", "", "()V", "canDoNetTask", "", "logMsg", "", "hasBindWatch", "uploadHeartBeat", "", "beatInfo", "Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;", "(Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: WatchData.kt */
public final class WatchData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "WatchData";
    /* access modifiers changed from: private */
    public static final Lazy<WatchData> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, WatchData$Companion$instance$2.INSTANCE);

    public /* synthetic */ WatchData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WatchData() {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/data/wear/WatchData$Companion;", "", "()V", "TAG", "", "instance", "Lcom/microtech/aidexx/data/wear/WatchData;", "getInstance", "()Lcom/microtech/aidexx/data/wear/WatchData;", "instance$delegate", "Lkotlin/Lazy;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: WatchData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WatchData getInstance() {
            return (WatchData) WatchData.instance$delegate.getValue();
        }
    }

    public final boolean hasBindWatch() {
        return MmkvManager.INSTANCE.hasBindWatch();
    }

    private final boolean canDoNetTask(String str) {
        if (!hasBindWatch()) {
            return false;
        }
        if (NetUtil.isNetAvailable(AidexxApp.Companion.getInstance())) {
            return true;
        }
        LogUtil.Companion.xLogE("netErr " + str, TAG);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object uploadHeartBeat(com.microtech.aidexx.common.net.entity.DeviceHeartBeat r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.data.wear.WatchData$uploadHeartBeat$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.data.wear.WatchData$uploadHeartBeat$1 r0 = (com.microtech.aidexx.data.wear.WatchData$uploadHeartBeat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.wear.WatchData$uploadHeartBeat$1 r0 = new com.microtech.aidexx.data.wear.WatchData$uploadHeartBeat$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0060
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "heart offset="
            r6.<init>(r2)
            java.lang.Integer r2 = r5.getTimeOffset()
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r6 = r6.toString()
            boolean r6 = r4.canDoNetTask(r6)
            if (r6 != 0) goto L_0x0051
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0051:
            com.microtech.aidexx.common.net.repository.DeviceRepository$Companion r6 = com.microtech.aidexx.common.net.repository.DeviceRepository.Companion
            com.microtech.aidexx.common.net.repository.DeviceRepository r6 = r6.getInstance()
            r0.label = r3
            java.lang.Object r6 = r6.deviceHeartBeat(r5, r0)
            if (r6 != r1) goto L_0x0060
            return r1
        L_0x0060:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r5 != 0) goto L_0x0068
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
        L_0x0068:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.wear.WatchData.uploadHeartBeat(com.microtech.aidexx.common.net.entity.DeviceHeartBeat, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
