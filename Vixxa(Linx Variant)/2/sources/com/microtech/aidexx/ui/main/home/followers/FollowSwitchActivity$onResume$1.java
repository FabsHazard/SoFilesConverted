package com.microtech.aidexx.ui.main.home.followers;

import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import java.util.List;
import kotlin.Metadata;
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
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$onResume$1", f = "FollowSwitchActivity.kt", i = {}, l = {113, 113}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FollowSwitchActivity.kt */
final class FollowSwitchActivity$onResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FollowSwitchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FollowSwitchActivity$onResume$1(FollowSwitchActivity followSwitchActivity, Continuation<? super FollowSwitchActivity$onResume$1> continuation) {
        super(2, continuation);
        this.this$0 = followSwitchActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FollowSwitchActivity$onResume$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FollowSwitchActivity$onResume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "it", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$onResume$1$1", f = "FollowSwitchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$onResume$1$1  reason: invalid class name */
    /* compiled from: FollowSwitchActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<List<ShareUserInfo>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(followSwitchActivity, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(List<ShareUserInfo> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                List list = (List) this.L$0;
                if (list != null) {
                    FollowListAdapter access$getFollowListAdapter$p = followSwitchActivity.followListAdapter;
                    if (access$getFollowListAdapter$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("followListAdapter");
                        access$getFollowListAdapter$p = null;
                    }
                    access$getFollowListAdapter$p.refreshData(list);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getShareVm().fixedRateToGetFollowList(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final FollowSwitchActivity followSwitchActivity = this.this$0;
        this.label = 2;
        if (FlowKt.collectLatest((Flow) obj, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
