package com.microtech.aidexx.ui.main.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.HomeViewModel$switchUser$1", f = "HomeViewModel.kt", i = {1}, l = {55, 63}, m = "invokeSuspend", n = {"shareUserInfo"}, s = {"L$0"})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$switchUser$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userId;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$switchUser$1(String str, Continuation<? super HomeViewModel$switchUser$1> continuation) {
        super(2, continuation);
        this.$userId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$switchUser$1(this.$userId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$switchUser$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            r3 = 2
            java.lang.String r4 = "HomeViewModel"
            if (r1 == 0) goto L_0x0025
            if (r1 == r2) goto L_0x0021
            if (r1 != r3) goto L_0x0019
            java.lang.Object r0 = r6.L$0
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r0 = (com.microtech.aidexx.ui.setting.share.ShareUserInfo) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x00a3
        L_0x0019:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0038
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r7)
            com.microtech.aidexx.common.net.repository.ShareAndFollowRepository r7 = com.microtech.aidexx.common.net.repository.ShareAndFollowRepository.INSTANCE
            java.lang.String r1 = r6.$userId
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r2
            java.lang.Object r7 = r7.findAuthorizationInfoById(r1, r5)
            if (r7 != r0) goto L_0x0038
            return r0
        L_0x0038:
            com.microtech.aidexx.common.net.ApiResult r7 = (com.microtech.aidexx.common.net.ApiResult) r7
            boolean r1 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r2 = 0
            if (r1 == 0) goto L_0x00ef
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r5 = "点通知切换用户 findAuthorizationInfoById 成功"
            r1.xLogI(r5, r4)
            com.microtech.aidexx.common.net.ApiResult$Success r7 = (com.microtech.aidexx.common.net.ApiResult.Success) r7
            java.lang.Object r7 = r7.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r7 = (com.microtech.aidexx.common.net.entity.BaseResponse) r7
            java.lang.Object r7 = r7.getData()
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r7 = (com.microtech.aidexx.ui.setting.share.ShareUserInfo) r7
            if (r7 == 0) goto L_0x005b
            java.lang.String r1 = r7.getDataProviderId()
            goto L_0x005c
        L_0x005b:
            r1 = r2
        L_0x005c:
            if (r1 == 0) goto L_0x00e7
            com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r1 = r1.getShareUserInfo()
            if (r1 == 0) goto L_0x006a
            java.lang.String r2 = r1.getDataProviderId()
        L_0x006a:
            java.lang.String r1 = r7.getDataProviderId()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x00e7
            com.microtech.aidexx.views.dialog.Dialogs r1 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            com.microtech.aidexx.AidexxApp r2 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r5 = com.microtech.aidexx.R.string.com_loading
            java.lang.String r2 = r2.getString(r5)
            r1.showWait(r2)
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "点通知切换用户 下载数据"
            r1.xLogI(r2, r4)
            com.microtech.aidexx.data.CloudHistorySync$Companion r1 = com.microtech.aidexx.data.CloudHistorySync.Companion
            java.lang.String r2 = r7.getDataProviderId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r7
            r6.label = r3
            java.lang.Object r1 = r1.downloadRecentData(r2, r5)
            if (r1 != r0) goto L_0x00a1
            return r0
        L_0x00a1:
            r0 = r7
            r7 = r1
        L_0x00a3:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00c8
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r1 = "点通知切换用户 下载数据成功"
            r7.xLogI(r1, r4)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r7 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            r7.setShareUserInfo(r0)
            java.lang.String r7 = "EVENT_SWITCH_USER"
            java.lang.Class<com.microtech.aidexx.ui.setting.share.ShareUserInfo> r1 = com.microtech.aidexx.ui.setting.share.ShareUserInfo.class
            com.jeremyliao.liveeventbus.core.Observable r7 = com.jeremyliao.liveeventbus.LiveEventBus.get(r7, r1)
            r7.post(r0)
            com.microtech.aidexx.views.dialog.Dialogs r7 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r7.dismissWait()
            goto L_0x011b
        L_0x00c8:
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r0 = "点通知切换用户 下载数据失败"
            r7.xLogI(r0, r4)
            com.microtech.aidexx.views.dialog.Dialogs r7 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r7.dismissWait()
            com.microtech.aidexx.AidexxApp r7 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r0 = com.microtech.aidexx.R.string.share_switch_failure
            java.lang.String r7 = r7.getString(r0)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            com.microtech.aidexx.common.ExtendsKt.toast(r7)
            goto L_0x011b
        L_0x00e7:
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r0 = "点通知切换用户 当前已经是该用户"
            r7.xLogI(r0, r4)
            goto L_0x011b
        L_0x00ef:
            boolean r0 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r0 == 0) goto L_0x011b
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "通知过来的分享人切换失败-数据拉取失败"
            r1.<init>(r4)
            com.microtech.aidexx.common.net.ApiResult$Failure r7 = (com.microtech.aidexx.common.net.ApiResult.Failure) r7
            java.lang.String r4 = r7.getCode()
            java.lang.StringBuilder r1 = r1.append(r4)
            r4 = 45
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r7 = r7.getMsg()
            java.lang.StringBuilder r7 = r1.append(r7)
            java.lang.String r7 = r7.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r0, r7, r2, r3, r2)
        L_0x011b:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.HomeViewModel$switchUser$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
