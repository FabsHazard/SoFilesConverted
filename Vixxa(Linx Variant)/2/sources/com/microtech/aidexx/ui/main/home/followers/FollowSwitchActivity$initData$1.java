package com.microtech.aidexx.ui.main.home.followers;

import androidx.lifecycle.LifecycleOwnerKt;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.CloudHistorySync;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "shareUserInfo", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: FollowSwitchActivity.kt */
final class FollowSwitchActivity$initData$1 extends Lambda implements Function2<Integer, ShareUserInfo, Unit> {
    final /* synthetic */ FollowSwitchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FollowSwitchActivity$initData$1(FollowSwitchActivity followSwitchActivity) {
        super(2);
        this.this$0 = followSwitchActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (ShareUserInfo) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, final ShareUserInfo shareUserInfo) {
        Intrinsics.checkNotNullParameter(shareUserInfo, "shareUserInfo");
        if (shareUserInfo.getDataProviderId() != null) {
            ShareUserInfo shareUserInfo2 = UserInfoManager.Companion.getShareUserInfo();
            if (Intrinsics.areEqual((Object) shareUserInfo2 != null ? shareUserInfo2.getDataProviderId() : null, (Object) shareUserInfo.getDataProviderId())) {
                return;
            }
            if (NetUtil.isNetAvailable(ExtendsKt.getContext())) {
                final FollowSwitchActivity followSwitchActivity = this.this$0;
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
                return;
            }
            String string = this.this$0.getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$initData$1$1", f = "FollowSwitchActivity.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$initData$1$1  reason: invalid class name */
    /* compiled from: FollowSwitchActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(followSwitchActivity, shareUserInfo, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Dialogs.INSTANCE.showWait(followSwitchActivity.getString(R.string.com_downloading));
                CloudHistorySync.Companion companion = CloudHistorySync.Companion;
                String dataProviderId = shareUserInfo.getDataProviderId();
                Intrinsics.checkNotNull(dataProviderId);
                this.label = 1;
                obj = companion.downloadRecentData(dataProviderId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (((Boolean) obj).booleanValue()) {
                Dialogs.INSTANCE.dismissWait();
                UserInfoManager.Companion.setShareUserInfo(shareUserInfo);
                LiveEventBus.get(EventBusKey.EVENT_SWITCH_USER, ShareUserInfo.class).post(shareUserInfo);
                followSwitchActivity.finish();
            } else {
                Dialogs.INSTANCE.dismissWait();
                String string = followSwitchActivity.getString(R.string.share_switch_failure);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
            }
            return Unit.INSTANCE;
        }
    }
}
