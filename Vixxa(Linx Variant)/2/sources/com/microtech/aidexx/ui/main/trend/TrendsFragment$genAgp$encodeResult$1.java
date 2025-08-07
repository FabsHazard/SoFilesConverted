package com.microtech.aidexx.ui.main.trend;

import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment$genAgp$encodeResult$1", f = "TrendsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$genAgp$encodeResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $result;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$genAgp$encodeResult$1(String str, Continuation<? super TrendsFragment$genAgp$encodeResult$1> continuation) {
        super(2, continuation);
        this.$result = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendsFragment$genAgp$encodeResult$1(this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((TrendsFragment$genAgp$encodeResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return URLEncoder.encode(this.$result, "UTF-8");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
