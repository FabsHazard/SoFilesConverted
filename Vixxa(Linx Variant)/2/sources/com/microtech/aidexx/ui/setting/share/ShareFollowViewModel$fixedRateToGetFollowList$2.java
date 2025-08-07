package com.microtech.aidexx.ui.setting.share;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$fixedRateToGetFollowList$2", f = "ShareFollowViewModel.kt", i = {0, 1, 2}, l = {84, 84, 87, 89}, m = "invokeSuspend", n = {"$this$callbackFlow", "$this$callbackFlow", "$this$callbackFlow"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: ShareFollowViewModel.kt */
final class ShareFollowViewModel$fixedRateToGetFollowList$2 extends SuspendLambda implements Function2<ProducerScope<? super List<ShareUserInfo>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShareFollowViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareFollowViewModel$fixedRateToGetFollowList$2(ShareFollowViewModel shareFollowViewModel, Continuation<? super ShareFollowViewModel$fixedRateToGetFollowList$2> continuation) {
        super(2, continuation);
        this.this$0 = shareFollowViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShareFollowViewModel$fixedRateToGetFollowList$2 shareFollowViewModel$fixedRateToGetFollowList$2 = new ShareFollowViewModel$fixedRateToGetFollowList$2(this.this$0, continuation);
        shareFollowViewModel$fixedRateToGetFollowList$2.L$0 = obj;
        return shareFollowViewModel$fixedRateToGetFollowList$2;
    }

    public final Object invoke(ProducerScope<? super List<ShareUserInfo>> producerScope, Continuation<? super Unit> continuation) {
        return ((ShareFollowViewModel$fixedRateToGetFollowList$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 == r5) goto L_0x0031
            if (r1 == r4) goto L_0x0029
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0095
        L_0x0019:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0021:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0041
        L_0x0029:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0072
        L_0x0031:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005b
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            r1 = r9
        L_0x0041:
            r9 = r1
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            boolean r9 = kotlinx.coroutines.CoroutineScopeKt.isActive(r9)
            if (r9 == 0) goto L_0x0086
            com.microtech.aidexx.ui.setting.share.ShareFollowViewModel r9 = r8.this$0
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r1
            r8.label = r5
            r7 = 0
            java.lang.Object r9 = r9.loadData(r7, r6)
            if (r9 != r0) goto L_0x005b
            return r0
        L_0x005b:
            kotlinx.coroutines.flow.Flow r9 = (kotlinx.coroutines.flow.Flow) r9
            com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$fixedRateToGetFollowList$2$1 r6 = new com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$fixedRateToGetFollowList$2$1
            r6.<init>(r1)
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.L$0 = r1
            r8.label = r4
            java.lang.Object r9 = r9.collect(r6, r7)
            if (r9 != r0) goto L_0x0072
            return r0
        L_0x0072:
            com.microtech.aidexx.ui.setting.share.ShareFollowViewModel r9 = r8.this$0
            long r6 = r9.periodPullFollowList
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r9)
            if (r9 != r0) goto L_0x0041
            return r0
        L_0x0086:
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r3 = 0
            r8.L$0 = r3
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.channels.ProduceKt.awaitClose$default(r1, r3, r9, r5, r3)
            if (r9 != r0) goto L_0x0095
            return r0
        L_0x0095:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.share.ShareFollowViewModel$fixedRateToGetFollowList$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
