package io.objectbox.kotlin;

import io.objectbox.reactive.DataSubscription;
import io.objectbox.reactive.SubscriptionBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u0001H\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "io.objectbox.kotlin.FlowKt$toFlow$1", f = "Flow.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Flow.kt */
final class FlowKt$toFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubscriptionBuilder<T> $this_toFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt$toFlow$1(SubscriptionBuilder<T> subscriptionBuilder, Continuation<? super FlowKt$toFlow$1> continuation) {
        super(2, continuation);
        this.$this_toFlow = subscriptionBuilder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FlowKt$toFlow$1 flowKt$toFlow$1 = new FlowKt$toFlow$1(this.$this_toFlow, continuation);
        flowKt$toFlow$1.L$0 = obj;
        return flowKt$toFlow$1;
    }

    public final Object invoke(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
        return ((FlowKt$toFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final DataSubscription observer = this.$this_toFlow.observer(new FlowKt$toFlow$1$$ExternalSyntheticLambda0(producerScope));
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, new Function0<Unit>() {
                public final void invoke() {
                    observer.cancel();
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(ProducerScope producerScope, Object obj) {
        ChannelsKt.trySendBlocking(producerScope, obj);
    }
}
