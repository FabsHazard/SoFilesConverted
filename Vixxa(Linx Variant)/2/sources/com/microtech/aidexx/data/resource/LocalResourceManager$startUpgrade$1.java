package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.common.net.entity.VersionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1", f = "LocalResourceManager.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$startUpgrade$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VersionInfo $upInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$startUpgrade$1(VersionInfo versionInfo, Continuation<? super LocalResourceManager$startUpgrade$1> continuation) {
        super(2, continuation);
        this.$upInfo = versionInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalResourceManager$startUpgrade$1(this.$upInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocalResourceManager$startUpgrade$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r1 = r1.getInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r2) goto L_0x0010
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x008f
        L_0x0010:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r1)
            if (r8 != 0) goto L_0x003a
            com.microtech.aidexx.utils.LogUtil$Companion r8 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r0 = com.microtech.aidexx.data.resource.LocalResourceManager.TAG
            java.lang.String r1 = "access$getTAG$p(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "resource upgrade fail no sdcard"
            r8.xLogE(r1, r0)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x003a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "resource_"
            r8.<init>(r1)
            com.microtech.aidexx.common.net.entity.VersionInfo r1 = r7.$upInfo
            if (r1 == 0) goto L_0x0050
            com.microtech.aidexx.common.net.entity.VersionData r1 = r1.getInfo()
            if (r1 == 0) goto L_0x0050
            java.lang.String r1 = r1.getVersion()
            goto L_0x0051
        L_0x0050:
            r1 = 0
        L_0x0051:
            java.lang.StringBuilder r8 = r8.append(r1)
            java.lang.String r1 = ".zip"
            java.lang.StringBuilder r8 = r8.append(r1)
            java.lang.String r8 = r8.toString()
            com.microtech.aidexx.utils.FileUtils r1 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            java.lang.String r3 = "downloads"
            java.lang.String r1 = r1.getDownloadDir(r3)
            com.microtech.aidexx.common.net.entity.VersionInfo r3 = r7.$upInfo
            if (r3 == 0) goto L_0x008f
            com.microtech.aidexx.common.net.entity.VersionData r3 = r3.getInfo()
            if (r3 == 0) goto L_0x008f
            com.microtech.aidexx.common.net.entity.VersionInfo r4 = r7.$upInfo
            java.lang.String r5 = r3.getDownloadpath()
            if (r5 == 0) goto L_0x008f
            com.microtech.aidexx.common.net.repository.ApiRepository r6 = com.microtech.aidexx.common.net.repository.ApiRepository.INSTANCE
            kotlinx.coroutines.flow.Flow r8 = r6.downloadFile(r5, r1, r8)
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1 r1 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1
            r1.<init>(r3, r4)
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            r7.label = r2
            java.lang.Object r8 = r8.collect(r1, r7)
            if (r8 != r0) goto L_0x008f
            return r0
        L_0x008f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
