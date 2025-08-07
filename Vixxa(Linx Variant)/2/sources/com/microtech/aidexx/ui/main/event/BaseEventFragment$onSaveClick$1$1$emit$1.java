package com.microtech.aidexx.ui.main.event;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1$1", f = "BaseEventFragment.kt", i = {0}, l = {263}, m = "emit", n = {"this"}, s = {"L$0"})
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$onSaveClick$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseEventFragment$onSaveClick$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$onSaveClick$1$1$emit$1(BaseEventFragment$onSaveClick$1.AnonymousClass1<? super T> r1, Continuation<? super BaseEventFragment$onSaveClick$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = r1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Pair<Boolean, ? extends BaseEventEntity>) null, (Continuation<? super Unit>) this);
    }
}
