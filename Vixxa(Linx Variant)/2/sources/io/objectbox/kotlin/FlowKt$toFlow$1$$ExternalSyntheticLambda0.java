package io.objectbox.kotlin;

import io.objectbox.reactive.DataObserver;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FlowKt$toFlow$1$$ExternalSyntheticLambda0 implements DataObserver {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ FlowKt$toFlow$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    public final void onData(Object obj) {
        FlowKt$toFlow$1.invokeSuspend$lambda$0(this.f$0, obj);
    }
}
