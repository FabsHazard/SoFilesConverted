package com.microtech.aidexx.ota;

import com.microtech.aidexx.common.net.repository.ApiRepository;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import com.microtech.aidexx.utils.LogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1", f = "OtaManager.kt", i = {}, l = {266, 272, 276, 309, 312}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OtaManager.kt */
final class OtaManager$checkOtaResource$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OtaResourceEntity $info;
    final /* synthetic */ List<String> $latestVersionInfo;
    int label;
    final /* synthetic */ OtaManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$checkOtaResource$2$1$1$1$1(OtaResourceEntity otaResourceEntity, List<String> list, OtaManager otaManager, Continuation<? super OtaManager$checkOtaResource$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.$info = otaResourceEntity;
        this.$latestVersionInfo = list;
        this.this$0 = otaManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OtaManager$checkOtaResource$2$1$1$1$1(this.$info, this.$latestVersionInfo, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OtaManager$checkOtaResource$2$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$info.getSettingType() == null || this.$info.getOssFileUrl() == null || this.$info.getSha256() == null) {
                String tag = OtaManager.Companion.getTAG();
                Intrinsics.checkNotNullExpressionValue(tag, "<get-TAG>(...)");
                LogUtil.Companion.xLogE("ota info error, update abort " + this.$info + ' ', tag);
                return Unit.INSTANCE;
            }
            OtaResourceEntity otaResourceEntity = this.$info;
            otaResourceEntity.setSettingTypeVersionKey(otaResourceEntity.genEntityKey());
            if (this.$latestVersionInfo.contains(this.$info.genEntityKey())) {
                this.label = 1;
                obj = this.this$0.isNeedDownLoad(this.$info, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 5;
                if (this.this$0.saveOtaResource(this.$info, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else if (i == 3 || i == 4 || i == 5) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Pair pair = (Pair) obj;
        if (((Boolean) pair.getFirst()).booleanValue()) {
            final String genDownloadFileName = this.$info.genDownloadFileName();
            if (genDownloadFileName.length() == 0) {
                String tag2 = OtaManager.Companion.getTAG();
                Intrinsics.checkNotNullExpressionValue(tag2, "<get-TAG>(...)");
                LogUtil.Companion.xLogE("unSupport info fileType=" + this.$info.getFileType() + " aidexVersion=" + this.$info.getAidexVersion(), tag2);
                this.label = 2;
                if (OtaManager.saveOtaResource$default(this.this$0, this.$info, false, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ApiRepository apiRepository = ApiRepository.INSTANCE;
            String ossFileUrl = this.$info.getOssFileUrl();
            Intrinsics.checkNotNull(ossFileUrl);
            Flow<ApiRepository.NetResult<String>> downloadFile = apiRepository.downloadFile(ossFileUrl, OtaManager.Companion.getOtaRootPath(), genDownloadFileName);
            final OtaResourceEntity otaResourceEntity2 = this.$info;
            final OtaManager otaManager = this.this$0;
            this.label = 3;
            if (downloadFile.collect(new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
                /* JADX WARNING: Removed duplicated region for block: B:27:0x00dd  */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x013e  */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x0176 A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(com.microtech.aidexx.common.net.repository.ApiRepository.NetResult<java.lang.String> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1
                        if (r0 == 0) goto L_0x0014
                        r0 = r11
                        com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1 r0 = (com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L_0x0014
                        int r11 = r0.label
                        int r11 = r11 - r2
                        r0.label = r11
                        goto L_0x0019
                    L_0x0014:
                        com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1 r0 = new com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1$1$emit$1
                        r0.<init>(r9, r11)
                    L_0x0019:
                        r4 = r0
                        java.lang.Object r11 = r4.result
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r1 = r4.label
                        r2 = 3
                        r3 = 2
                        r5 = 1
                        java.lang.String r6 = "<get-TAG>(...)"
                        if (r1 == 0) goto L_0x004e
                        if (r1 == r5) goto L_0x0041
                        if (r1 == r3) goto L_0x003c
                        if (r1 != r2) goto L_0x0034
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L_0x01ca
                    L_0x0034:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L_0x003c:
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L_0x0177
                    L_0x0041:
                        java.lang.Object r10 = r4.L$1
                        com.microtech.aidexx.common.net.repository.ApiRepository$NetResult r10 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult) r10
                        java.lang.Object r1 = r4.L$0
                        com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1$1 r1 = (com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1.AnonymousClass1) r1
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L_0x00c8
                    L_0x004e:
                        kotlin.ResultKt.throwOnFailure(r11)
                        boolean r11 = r10 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Loading
                        if (r11 == 0) goto L_0x0084
                        com.microtech.aidexx.utils.LogUtil$Companion r11 = com.microtech.aidexx.utils.LogUtil.Companion
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = r14
                        java.lang.StringBuilder r0 = r0.append(r1)
                        java.lang.String r1 = " downloading "
                        java.lang.StringBuilder r0 = r0.append(r1)
                        com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Loading r10 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Loading) r10
                        int r10 = r10.getValue()
                        java.lang.StringBuilder r10 = r0.append(r10)
                        java.lang.String r10 = r10.toString()
                        com.microtech.aidexx.ota.OtaManager$Companion r0 = com.microtech.aidexx.ota.OtaManager.Companion
                        java.lang.String r0 = r0.getTAG()
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
                        r11.xLogI(r10, r0)
                        goto L_0x01cd
                    L_0x0084:
                        boolean r11 = r10 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success
                        if (r11 == 0) goto L_0x017a
                        com.microtech.aidexx.utils.LogUtil$Companion r11 = com.microtech.aidexx.utils.LogUtil.Companion
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = r14
                        java.lang.StringBuilder r1 = r1.append(r2)
                        java.lang.String r2 = " download success file="
                        java.lang.StringBuilder r1 = r1.append(r2)
                        r2 = r10
                        com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Success r2 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success) r2
                        java.lang.Object r2 = r2.getResult()
                        java.lang.String r2 = (java.lang.String) r2
                        java.lang.StringBuilder r1 = r1.append(r2)
                        java.lang.String r1 = r1.toString()
                        com.microtech.aidexx.ota.OtaManager$Companion r2 = com.microtech.aidexx.ota.OtaManager.Companion
                        java.lang.String r2 = r2.getTAG()
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
                        r11.xLogI(r1, r2)
                        r4.L$0 = r9
                        r4.L$1 = r10
                        r4.label = r5
                        r1 = 500(0x1f4, double:2.47E-321)
                        java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r1, r4)
                        if (r11 != r0) goto L_0x00c7
                        return r0
                    L_0x00c7:
                        r1 = r9
                    L_0x00c8:
                        java.io.File r11 = new java.io.File
                        com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Success r10 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success) r10
                        java.lang.Object r10 = r10.getResult()
                        java.lang.String r10 = (java.lang.String) r10
                        r11.<init>(r10)
                        com.microtech.aidexx.utils.FileUtils r10 = com.microtech.aidexx.utils.FileUtils.INSTANCE
                        boolean r10 = r10.isFileExists((java.io.File) r11)
                        if (r10 == 0) goto L_0x013e
                        byte[] r10 = kotlin.io.FilesKt.readBytes(r11)
                        java.lang.String r10 = com.microtech.aidexx.utils.blankj.EncryptUtils.encryptSHA256ToString((byte[]) r10)
                        com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        r7.<init>()
                        java.lang.String r8 = r14
                        java.lang.StringBuilder r7 = r7.append(r8)
                        java.lang.String r8 = " download complete, download-sha256:"
                        java.lang.StringBuilder r7 = r7.append(r8)
                        java.lang.StringBuilder r7 = r7.append(r10)
                        java.lang.String r8 = ", cloud-sha256:"
                        java.lang.StringBuilder r7 = r7.append(r8)
                        com.microtech.aidexx.db.entity.OtaResourceEntity r8 = r3
                        java.lang.String r8 = r8.getSha256()
                        java.lang.StringBuilder r7 = r7.append(r8)
                        java.lang.String r7 = r7.toString()
                        com.microtech.aidexx.ota.OtaManager$Companion r8 = com.microtech.aidexx.ota.OtaManager.Companion
                        java.lang.String r8 = r8.getTAG()
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
                        r2.xLogI(r7, r8)
                        com.microtech.aidexx.db.entity.OtaResourceEntity r2 = r3
                        java.lang.String r2 = r2.getSha256()
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
                        int r10 = kotlin.text.StringsKt.compareTo(r2, r10, r5)
                        if (r10 != 0) goto L_0x0138
                        com.microtech.aidexx.db.entity.OtaResourceEntity r10 = r3
                        java.lang.String r11 = r11.getAbsolutePath()
                        r10.setLocalFilePath(r11)
                        goto L_0x0161
                    L_0x0138:
                        com.microtech.aidexx.utils.FileUtils r10 = com.microtech.aidexx.utils.FileUtils.INSTANCE
                        r10.delete((java.io.File) r11)
                        goto L_0x0161
                    L_0x013e:
                        com.microtech.aidexx.utils.LogUtil$Companion r10 = com.microtech.aidexx.utils.LogUtil.Companion
                        java.lang.StringBuilder r11 = new java.lang.StringBuilder
                        r11.<init>()
                        java.lang.String r2 = r14
                        java.lang.StringBuilder r11 = r11.append(r2)
                        java.lang.String r2 = " downloaded file not exists"
                        java.lang.StringBuilder r11 = r11.append(r2)
                        java.lang.String r11 = r11.toString()
                        com.microtech.aidexx.ota.OtaManager$Companion r2 = com.microtech.aidexx.ota.OtaManager.Companion
                        java.lang.String r2 = r2.getTAG()
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
                        r10.xLogE(r11, r2)
                    L_0x0161:
                        com.microtech.aidexx.ota.OtaManager r10 = r4
                        com.microtech.aidexx.db.entity.OtaResourceEntity r2 = r3
                        r11 = 0
                        r4.L$0 = r11
                        r4.L$1 = r11
                        r4.label = r3
                        r3 = 0
                        r5 = 2
                        r6 = 0
                        r1 = r10
                        java.lang.Object r10 = com.microtech.aidexx.ota.OtaManager.saveOtaResource$default(r1, r2, r3, r4, r5, r6)
                        if (r10 != r0) goto L_0x0177
                        return r0
                    L_0x0177:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    L_0x017a:
                        boolean r11 = r10 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Failure
                        if (r11 == 0) goto L_0x01cd
                        com.microtech.aidexx.utils.LogUtil$Companion r11 = com.microtech.aidexx.utils.LogUtil.Companion
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r3 = r14
                        java.lang.StringBuilder r1 = r1.append(r3)
                        java.lang.String r3 = " download fail "
                        java.lang.StringBuilder r1 = r1.append(r3)
                        com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Failure r10 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Failure) r10
                        java.lang.String r3 = r10.getCode()
                        java.lang.StringBuilder r1 = r1.append(r3)
                        r3 = 45
                        java.lang.StringBuilder r1 = r1.append(r3)
                        java.lang.String r10 = r10.getMsg()
                        java.lang.StringBuilder r10 = r1.append(r10)
                        java.lang.String r10 = r10.toString()
                        com.microtech.aidexx.ota.OtaManager$Companion r1 = com.microtech.aidexx.ota.OtaManager.Companion
                        java.lang.String r1 = r1.getTAG()
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
                        r11.xLogE(r10, r1)
                        com.microtech.aidexx.ota.OtaManager r1 = r4
                        com.microtech.aidexx.db.entity.OtaResourceEntity r10 = r3
                        r4.label = r2
                        r3 = 0
                        r5 = 2
                        r6 = 0
                        r2 = r10
                        java.lang.Object r10 = com.microtech.aidexx.ota.OtaManager.saveOtaResource$default(r1, r2, r3, r4, r5, r6)
                        if (r10 != r0) goto L_0x01ca
                        return r0
                    L_0x01ca:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    L_0x01cd:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager$checkOtaResource$2$1$1$1$1.AnonymousClass1.emit(com.microtech.aidexx.common.net.repository.ApiRepository$NetResult, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            OtaResourceEntity otaResourceEntity3 = (OtaResourceEntity) pair.getSecond();
            if (otaResourceEntity3 != null) {
                this.$info.setLocalFilePath(otaResourceEntity3.getLocalFilePath());
            }
            this.label = 4;
            if (OtaManager.saveOtaResource$default(this.this$0, this.$info, false, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
