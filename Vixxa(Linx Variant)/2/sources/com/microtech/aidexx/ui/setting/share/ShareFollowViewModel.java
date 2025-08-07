package com.microtech.aidexx.ui.setting.share;

import androidx.lifecycle.ViewModel;
import com.microtech.aidexx.utils.TimeUtils;
import java.util.List;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J'\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\b2\u0006\u0010\u0013\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J[\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ+\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ+\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\u0006\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "fixedRateTimer", "Ljava/util/Timer;", "periodPullFollowList", "", "cancelShare", "Lkotlinx/coroutines/flow/Flow;", "", "shareUserId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedRateToGetFollowList", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQrCodeToShareMySelf", "loadData", "isShare", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyFollowUser", "providerAlias", "readerAlias", "hideState", "", "emergePushState", "normalPushState", "userAuthorizationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyShareUser", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shareMyselfToOther", "userName", "userAlise", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareFollowViewModel.kt */
public final class ShareFollowViewModel extends ViewModel {
    private Timer fixedRateTimer;
    /* access modifiers changed from: private */
    public final long periodPullFollowList = TimeUtils.oneMinuteMillis;

    public final Object loadData(boolean z, Continuation<? super Flow<? extends List<ShareUserInfo>>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ShareFollowViewModel$loadData$2(z, (Continuation<? super ShareFollowViewModel$loadData$2>) null)), Dispatchers.getIO());
    }

    public final Object shareMyselfToOther(String str, String str2, Continuation<? super Flow<String>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ShareFollowViewModel$shareMyselfToOther$2(str, str2, (Continuation<? super ShareFollowViewModel$shareMyselfToOther$2>) null)), Dispatchers.getIO());
    }

    public final Object getQrCodeToShareMySelf(Continuation<? super Flow<String>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ShareFollowViewModel$getQrCodeToShareMySelf$2((Continuation<? super ShareFollowViewModel$getQrCodeToShareMySelf$2>) null)), Dispatchers.getIO());
    }

    public static /* synthetic */ Object modifyFollowUser$default(ShareFollowViewModel shareFollowViewModel, String str, String str2, Integer num, Integer num2, Integer num3, String str3, Continuation continuation, int i, Object obj) {
        return shareFollowViewModel.modifyFollowUser((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3, str3, continuation);
    }

    public final Object modifyFollowUser(String str, String str2, Integer num, Integer num2, Integer num3, String str3, Continuation<? super Flow<Boolean>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ShareFollowViewModel$modifyFollowUser$2(str, str2, num, num2, num3, str3, (Continuation<? super ShareFollowViewModel$modifyFollowUser$2>) null)), Dispatchers.getIO());
    }

    public static /* synthetic */ Object modifyShareUser$default(ShareFollowViewModel shareFollowViewModel, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return shareFollowViewModel.modifyShareUser(str, str2, continuation);
    }

    public final Object modifyShareUser(String str, String str2, Continuation<? super Flow<Boolean>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ShareFollowViewModel$modifyShareUser$2(str, str2, (Continuation<? super ShareFollowViewModel$modifyShareUser$2>) null)), Dispatchers.getIO());
    }

    public final Object cancelShare(String str, Continuation<? super Flow<Boolean>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ShareFollowViewModel$cancelShare$2(str, (Continuation<? super ShareFollowViewModel$cancelShare$2>) null)), Dispatchers.getIO());
    }

    public final Object fixedRateToGetFollowList(Continuation<? super Flow<? extends List<ShareUserInfo>>> continuation) {
        return FlowKt.callbackFlow(new ShareFollowViewModel$fixedRateToGetFollowList$2(this, (Continuation<? super ShareFollowViewModel$fixedRateToGetFollowList$2>) null));
    }
}
