package com.microtech.aidexx.ui.main.trend;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "ret", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", "", "emit", "(Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$downloadAgp$2<T> implements FlowCollector {
    final /* synthetic */ String $downloadPath;
    final /* synthetic */ String $reportUrl;
    final /* synthetic */ TrendsFragment this$0;

    TrendsFragment$downloadAgp$2(TrendsFragment trendsFragment, String str, String str2) {
        this.this$0 = trendsFragment;
        this.$reportUrl = str;
        this.$downloadPath = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(com.microtech.aidexx.common.net.repository.ApiRepository.NetResult<java.lang.String> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2$emit$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2$emit$1 r0 = (com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2$emit$1 r0 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2$emit$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r7 = r0.L$0
            com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2 r7 = (com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x008f
        L_0x002e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Loading
            if (r8 == 0) goto L_0x004b
            com.microtech.aidexx.views.dialog.Dialogs r7 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            com.microtech.aidexx.ui.main.trend.TrendsFragment r8 = r6.this$0
            int r0 = com.microtech.aidexx.R.string.com_downloading
            java.lang.String r8 = r8.getString(r0)
            r7.showWait(r8)
            goto L_0x00a7
        L_0x004b:
            boolean r8 = r7 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success
            if (r8 == 0) goto L_0x006e
            com.microtech.aidexx.ui.main.trend.TrendsFragment r7 = r6.this$0
            androidx.lifecycle.LifecycleOwner r7 = (androidx.lifecycle.LifecycleOwner) r7
            androidx.lifecycle.LifecycleCoroutineScope r7 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r7)
            r0 = r7
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2$1 r7 = new com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2$1
            com.microtech.aidexx.ui.main.trend.TrendsFragment r8 = r6.this$0
            java.lang.String r1 = r6.$downloadPath
            r2 = 0
            r7.<init>(r8, r1, r2)
            r3 = r7
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 3
            r5 = 0
            r1 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r0, r1, r2, r3, r4, r5)
            goto L_0x00a7
        L_0x006e:
            boolean r8 = r7 instanceof com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Failure
            if (r8 == 0) goto L_0x00a7
            com.microtech.aidexx.ui.main.trend.TrendsFragment r8 = r6.this$0
            java.util.concurrent.atomic.AtomicInteger r8 = r8.attempt
            int r8 = r8.get()
            r2 = 3
            if (r8 >= r2) goto L_0x0099
            com.microtech.aidexx.ui.main.trend.TrendsFragment r7 = r6.this$0
            java.lang.String r8 = r6.$reportUrl
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.downloadAgp(r8, r0)
            if (r7 != r1) goto L_0x008e
            return r1
        L_0x008e:
            r7 = r6
        L_0x008f:
            com.microtech.aidexx.ui.main.trend.TrendsFragment r7 = r7.this$0
            java.util.concurrent.atomic.AtomicInteger r7 = r7.attempt
            r7.addAndGet(r3)
            goto L_0x00a7
        L_0x0099:
            com.microtech.aidexx.views.dialog.Dialogs r8 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r8.dismissWait()
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Failure r7 = (com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Failure) r7
            java.lang.String r7 = r7.getMsg()
            com.microtech.aidexx.common.ExtendsKt.toastShort(r7)
        L_0x00a7:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2.emit(com.microtech.aidexx.common.net.repository.ApiRepository$NetResult, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
