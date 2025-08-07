package com.microtech.aidexx.ui.main.trend;

import com.microtech.aidexx.common.net.repository.ApiRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment$downloadAgp$2", f = "TrendsFragment.kt", i = {0}, l = {754}, m = "emit", n = {"this"}, s = {"L$0"})
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$downloadAgp$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TrendsFragment$downloadAgp$2<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$downloadAgp$2$emit$1(TrendsFragment$downloadAgp$2<? super T> trendsFragment$downloadAgp$2, Continuation<? super TrendsFragment$downloadAgp$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = trendsFragment$downloadAgp$2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ApiRepository.NetResult<String>) null, (Continuation<? super Unit>) this);
    }
}
