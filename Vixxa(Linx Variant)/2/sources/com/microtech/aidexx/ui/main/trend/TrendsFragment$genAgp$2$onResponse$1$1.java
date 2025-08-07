package com.microtech.aidexx.ui.main.trend;

import java.util.concurrent.atomic.AtomicInteger;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$2$onResponse$1$1", f = "TrendsFragment.kt", i = {}, l = {718}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$genAgp$2$onResponse$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reportUrl;
    int label;
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$genAgp$2$onResponse$1$1(TrendsFragment trendsFragment, String str, Continuation<? super TrendsFragment$genAgp$2$onResponse$1$1> continuation) {
        super(2, continuation);
        this.this$0 = trendsFragment;
        this.$reportUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendsFragment$genAgp$2$onResponse$1$1(this.this$0, this.$reportUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrendsFragment$genAgp$2$onResponse$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.attempt = new AtomicInteger(0);
            TrendsFragment trendsFragment = this.this$0;
            String str = this.$reportUrl;
            Intrinsics.checkNotNullExpressionValue(str, "$reportUrl");
            this.label = 1;
            if (trendsFragment.downloadAgp(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
