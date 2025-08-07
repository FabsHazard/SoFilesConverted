package com.microtech.aidexx.data.resource;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1", f = "LocalResourceManager.kt", i = {1}, l = {210, 212}, m = "invokeSuspend", n = {"result"}, s = {"I$0"})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$startUpgrade$5$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VersionMenu $it;
    final /* synthetic */ String $unzipPath;
    final /* synthetic */ String $version;
    final /* synthetic */ String $zipFilePath;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$startUpgrade$5$1$1(String str, String str2, VersionMenu versionMenu, String str3, Continuation<? super LocalResourceManager$startUpgrade$5$1$1> continuation) {
        super(2, continuation);
        this.$version = str;
        this.$unzipPath = str2;
        this.$it = versionMenu;
        this.$zipFilePath = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocalResourceManager$startUpgrade$5$1$1 localResourceManager$startUpgrade$5$1$1 = new LocalResourceManager$startUpgrade$5$1$1(this.$version, this.$unzipPath, this.$it, this.$zipFilePath, continuation);
        localResourceManager$startUpgrade$5$1$1.L$0 = obj;
        return localResourceManager$startUpgrade$5$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocalResourceManager$startUpgrade$5$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r5) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            int r0 = r12.I$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00cf
        L_0x0017:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0096
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            r1 = 4
            kotlinx.coroutines.Deferred[] r1 = new kotlinx.coroutines.Deferred[r1]
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1 r6 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1
            java.lang.String r7 = r12.$unzipPath
            com.microtech.aidexx.data.resource.VersionMenu r8 = r12.$it
            r6.<init>(r7, r8, r4)
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            r6 = r13
            kotlinx.coroutines.Deferred r6 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r6, r7, r8, r9, r10, r11)
            r1[r2] = r6
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$2 r6 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$2
            java.lang.String r7 = r12.$unzipPath
            com.microtech.aidexx.data.resource.VersionMenu r8 = r12.$it
            r6.<init>(r7, r8, r4)
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r7 = 0
            r8 = 0
            r6 = r13
            kotlinx.coroutines.Deferred r6 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r6, r7, r8, r9, r10, r11)
            r1[r5] = r6
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$3 r6 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$3
            java.lang.String r7 = r12.$unzipPath
            com.microtech.aidexx.data.resource.VersionMenu r8 = r12.$it
            r6.<init>(r7, r8, r4)
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r7 = 0
            r8 = 0
            r6 = r13
            kotlinx.coroutines.Deferred r6 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r6, r7, r8, r9, r10, r11)
            r1[r3] = r6
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$4 r6 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$4
            java.lang.String r7 = r12.$unzipPath
            com.microtech.aidexx.data.resource.VersionMenu r8 = r12.$it
            r6.<init>(r7, r8, r4)
            r9 = r6
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r7 = 0
            r8 = 0
            r6 = r13
            kotlinx.coroutines.Deferred r13 = kotlinx.coroutines.BuildersKt__Builders_commonKt.async$default(r6, r7, r8, r9, r10, r11)
            r6 = 3
            r1[r6] = r13
            java.util.List r13 = kotlin.collections.CollectionsKt.listOf(r1)
            java.util.Collection r13 = (java.util.Collection) r13
            r1 = r12
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r12.label = r5
            java.lang.Object r13 = kotlinx.coroutines.AwaitKt.awaitAll(r13, r1)
            if (r13 != r0) goto L_0x0096
            return r0
        L_0x0096:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            boolean r1 = r13 instanceof java.util.Collection
            if (r1 == 0) goto L_0x00a7
            r1 = r13
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00a7
        L_0x00a5:
            r13 = r5
            goto L_0x00be
        L_0x00a7:
            java.util.Iterator r13 = r13.iterator()
        L_0x00ab:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x00a5
            java.lang.Object r1 = r13.next()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x00ab
            r13 = r2
        L_0x00be:
            com.microtech.aidexx.data.resource.LanguageResourceManager r1 = com.microtech.aidexx.data.resource.LanguageResourceManager.INSTANCE
            r6 = r12
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r12.I$0 = r13
            r12.label = r3
            java.lang.Object r1 = r1.initLanguageTag(r6)
            if (r1 != r0) goto L_0x00ce
            return r0
        L_0x00ce:
            r0 = r13
        L_0x00cf:
            if (r0 == 0) goto L_0x00d8
            com.microtech.aidexx.utils.mmkv.MmkvManager r13 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r1 = r12.$version
            r13.setResourceVersion(r1)
        L_0x00d8:
            java.lang.String r13 = r12.$unzipPath
            java.lang.String r1 = r12.$zipFilePath
            if (r0 == 0) goto L_0x00e0
            r6 = r5
            goto L_0x00e1
        L_0x00e0:
            r6 = r2
        L_0x00e1:
            com.microtech.aidexx.data.resource.LocalResourceManager.startUpgrade$upgradeFinish(r13, r1, r6)
            com.microtech.aidexx.utils.LogUtil$Companion r13 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "升级完成 result="
            r1.<init>(r6)
            if (r0 == 0) goto L_0x00f0
            r2 = r5
        L_0x00f0:
            java.lang.StringBuilder r0 = r1.append(r2)
            java.lang.String r0 = r0.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.d$default(r13, r0, r4, r3, r4)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
