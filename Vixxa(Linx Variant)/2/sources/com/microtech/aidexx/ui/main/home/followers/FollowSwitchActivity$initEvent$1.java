package com.microtech.aidexx.ui.main.home.followers;

import androidx.lifecycle.LifecycleOwner;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity$initEvent$1", f = "FollowSwitchActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FollowSwitchActivity.kt */
final class FollowSwitchActivity$initEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FollowSwitchActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FollowSwitchActivity$initEvent$1(FollowSwitchActivity followSwitchActivity, Continuation<? super FollowSwitchActivity$initEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = followSwitchActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FollowSwitchActivity$initEvent$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FollowSwitchActivity$initEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final FollowSwitchActivity followSwitchActivity = this.this$0;
            EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_WARMING_UP_TIME_LEFT, (LifecycleOwner) this.this$0, new Function1<Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Integer) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Integer num) {
                    if (num != null) {
                        followSwitchActivity.createTimer(60 - num.intValue());
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
