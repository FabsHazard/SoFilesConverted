package com.microtech.aidexx.ui.pair;

import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo_;
import io.objectbox.Box;
import io.objectbox.kotlin.BoxStoreKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/ui/pair/PairedDeviceManager;", "", "()V", "downloadHistoryDevice", "", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHistoryDevices", "", "Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairedDeviceManager.kt */
public final class PairedDeviceManager {
    public static final PairedDeviceManager INSTANCE = new PairedDeviceManager();

    private PairedDeviceManager() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadHistoryDevice(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ui.pair.PairedDeviceManager$downloadHistoryDevice$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ui.pair.PairedDeviceManager$downloadHistoryDevice$1 r0 = (com.microtech.aidexx.ui.pair.PairedDeviceManager$downloadHistoryDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.pair.PairedDeviceManager$downloadHistoryDevice$1 r0 = new com.microtech.aidexx.ui.pair.PairedDeviceManager$downloadHistoryDevice$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0059
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r6 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r6 = r6.instance()
            java.lang.String r6 = r6.userId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x004a
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L_0x004a:
            com.microtech.aidexx.common.net.ApiService$Companion r5 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r5 = r5.getInstance()
            r0.label = r3
            java.lang.Object r6 = r5.getHistoryDevice(r0)
            if (r6 != r1) goto L_0x0059
            return r1
        L_0x0059:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r5 == 0) goto L_0x0082
            com.microtech.aidexx.common.net.ApiResult$Success r6 = (com.microtech.aidexx.common.net.ApiResult.Success) r6
            java.lang.Object r5 = r6.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r5 = (com.microtech.aidexx.common.net.entity.BaseResponse) r5
            java.lang.Object r5 = r5.getData()
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x007d
            com.microtech.aidexx.db.ObjectBox r6 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            io.objectbox.Box r6 = r6.getHistoryDeviceBox()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            r6.put(r5)
        L_0x007d:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L_0x0082:
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r5 == 0) goto L_0x008d
            com.microtech.aidexx.utils.LogUtil$Companion r5 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r6 = "download history device fail"
            r5.eAiDEX(r6)
        L_0x008d:
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.pair.PairedDeviceManager.downloadHistoryDevice(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object loadHistoryDevices(Continuation<? super List<HistoryDeviceInfo>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new PairedDeviceManager$$ExternalSyntheticLambda0(), continuation);
    }

    /* access modifiers changed from: private */
    public static final List loadHistoryDevices$lambda$1() {
        Box<HistoryDeviceInfo> historyDeviceBox = ObjectBox.INSTANCE.getHistoryDeviceBox();
        Intrinsics.checkNotNull(historyDeviceBox);
        return historyDeviceBox.query().orderDesc(HistoryDeviceInfo_.registerTime).build().find();
    }
}
