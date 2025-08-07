package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.common.net.entity.VersionData;
import com.microtech.aidexx.common.net.entity.VersionInfo;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "ret", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", "", "emit", "(Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$startUpgrade$1$1$1$1<T> implements FlowCollector {
    final /* synthetic */ VersionData $info;
    final /* synthetic */ VersionInfo $upInfo;

    LocalResourceManager$startUpgrade$1$1$1$1(VersionData versionData, VersionInfo versionInfo) {
        this.$info = versionData;
        this.$upInfo = versionInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(com.microtech.aidexx.common.net.repository.ApiRepository.NetResult<java.lang.String> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1$emit$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1$emit$1 r0 = (com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1$emit$1 r0 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1$emit$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            java.lang.String r5 = "access$getTAG$p(...)"
            if (r2 == 0) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r9 = r0.L$1
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult r9 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult) r9
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1 r0 = (com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0058
        L_0x0035:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r9 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Loading
            if (r10 != 0) goto L_0x0147
            boolean r10 = r9 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success
            if (r10 == 0) goto L_0x010f
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            r6 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r10 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r0 = r8
        L_0x0058:
            com.microtech.aidexx.common.net.entity.VersionData r10 = r0.$info
            java.lang.String r10 = r10.getSha256()
            if (r10 == 0) goto L_0x00fa
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r10 = r10.length()
            if (r10 <= 0) goto L_0x00fa
            java.io.File r10 = new java.io.File
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Success r9 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success) r9
            java.lang.Object r1 = r9.getResult()
            java.lang.String r1 = (java.lang.String) r1
            r10.<init>(r1)
            com.microtech.aidexx.utils.FileUtils r1 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r1 = r1.isFileExists((java.io.File) r10)
            if (r1 == 0) goto L_0x00eb
            byte[] r10 = kotlin.io.FilesKt.readBytes(r10)
            java.lang.String r10 = com.microtech.aidexx.utils.blankj.EncryptUtils.encryptSHA256ToString((byte[]) r10)
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "ZIP SHA256="
            r2.<init>(r6)
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = com.microtech.aidexx.data.resource.LocalResourceManager.TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            r1.d(r2, r6)
            com.microtech.aidexx.common.net.entity.VersionData r1 = r0.$info
            java.lang.String r1 = r1.getSha256()
            if (r1 == 0) goto L_0x00bf
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            int r1 = kotlin.text.StringsKt.compareTo(r1, r10, r4)
            if (r1 != 0) goto L_0x00bf
            com.microtech.aidexx.data.resource.LocalResourceManager r10 = com.microtech.aidexx.data.resource.LocalResourceManager.INSTANCE
            com.microtech.aidexx.common.net.entity.VersionInfo r0 = r0.$upInfo
            java.lang.Object r9 = r9.getResult()
            java.lang.String r9 = (java.lang.String) r9
            r10.downloadSuccess(r0, r9)
            goto L_0x0109
        L_0x00bf:
            com.microtech.aidexx.utils.LogUtil$Companion r9 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "资源下载成功后文件指纹不对 c="
            r1.<init>(r2)
            java.lang.StringBuilder r10 = r1.append(r10)
            java.lang.String r1 = " s="
            java.lang.StringBuilder r10 = r10.append(r1)
            com.microtech.aidexx.common.net.entity.VersionData r0 = r0.$info
            java.lang.String r0 = r0.getSha256()
            java.lang.StringBuilder r10 = r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = com.microtech.aidexx.data.resource.LocalResourceManager.TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r9.xLogE(r10, r0)
            goto L_0x0109
        L_0x00eb:
            com.microtech.aidexx.utils.LogUtil$Companion r9 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r10 = com.microtech.aidexx.data.resource.LocalResourceManager.TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)
            java.lang.String r0 = "资源下载成功后文件丢了？"
            r9.xLogE(r0, r10)
            goto L_0x0109
        L_0x00fa:
            com.microtech.aidexx.data.resource.LocalResourceManager r10 = com.microtech.aidexx.data.resource.LocalResourceManager.INSTANCE
            com.microtech.aidexx.common.net.entity.VersionInfo r0 = r0.$upInfo
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Success r9 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success) r9
            java.lang.Object r9 = r9.getResult()
            java.lang.String r9 = (java.lang.String) r9
            r10.downloadSuccess(r0, r9)
        L_0x0109:
            com.microtech.aidexx.data.resource.LocalResourceManager r9 = com.microtech.aidexx.data.resource.LocalResourceManager.INSTANCE
            com.microtech.aidexx.data.resource.LocalResourceManager.upgrading = r3
            goto L_0x0147
        L_0x010f:
            boolean r10 = r9 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Failure
            if (r10 == 0) goto L_0x0147
            com.microtech.aidexx.data.resource.LocalResourceManager r10 = com.microtech.aidexx.data.resource.LocalResourceManager.INSTANCE
            com.microtech.aidexx.data.resource.LocalResourceManager.upgrading = r3
            com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "download fail "
            r0.<init>(r1)
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Failure r9 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Failure) r9
            java.lang.String r1 = r9.getCode()
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 45
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r9 = r9.getMsg()
            java.lang.StringBuilder r9 = r0.append(r9)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = com.microtech.aidexx.data.resource.LocalResourceManager.TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r10.xLogE(r9, r0)
        L_0x0147:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$1$1$1$1.emit(com.microtech.aidexx.common.net.repository.ApiRepository$NetResult, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
