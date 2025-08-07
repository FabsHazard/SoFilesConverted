package io.objectbox.kotlin;

import io.objectbox.BoxStore;
import io.objectbox.query.Query;
import io.objectbox.reactive.SubscriptionBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0002H\u0007\u001a$\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00060\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0007H\u0007\u001a\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\tH\u0007¨\u0006\n"}, d2 = {"flow", "Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Class;", "T", "Lio/objectbox/BoxStore;", "forClass", "", "Lio/objectbox/query/Query;", "toFlow", "Lio/objectbox/reactive/SubscriptionBuilder;", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Flow.kt */
public final class FlowKt {
    public static final <T> Flow<T> toFlow(SubscriptionBuilder<T> subscriptionBuilder) {
        Intrinsics.checkNotNullParameter(subscriptionBuilder, "<this>");
        return kotlinx.coroutines.flow.FlowKt.callbackFlow(new FlowKt$toFlow$1(subscriptionBuilder, (Continuation<? super FlowKt$toFlow$1>) null));
    }

    public static final <T> Flow<Class<T>> flow(BoxStore boxStore, Class<T> cls) {
        Intrinsics.checkNotNullParameter(boxStore, "<this>");
        Intrinsics.checkNotNullParameter(cls, "forClass");
        SubscriptionBuilder<Class<T>> subscribe = boxStore.subscribe(cls);
        Intrinsics.checkNotNullExpressionValue(subscribe, "this.subscribe(forClass)");
        return toFlow(subscribe);
    }

    public static final <T> Flow<List<T>> flow(Query<T> query) {
        Intrinsics.checkNotNullParameter(query, "<this>");
        SubscriptionBuilder<List<T>> subscribe = query.subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "this@flow.subscribe()");
        return toFlow(subscribe);
    }
}
