package com.microtech.aidexx.common.net.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "EVENT", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: EventRepository.kt */
public final class EventRepository$getRecentData$result$1$breakAll$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<Long> $endAutoIncrementColumn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EventRepository$getRecentData$result$1$breakAll$1(Ref.ObjectRef<Long> objectRef) {
        super(0);
        this.$endAutoIncrementColumn = objectRef;
    }

    public final void invoke() {
        this.$endAutoIncrementColumn.element = 0L;
    }
}
