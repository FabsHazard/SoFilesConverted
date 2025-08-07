package com.microtech.aidexx.common;

import com.microtech.aidexx.utils.ToastUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.ExtendsKt$toastShort$1", f = "Extends.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Extends.kt */
final class ExtendsKt$toastShort$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $this_toastShort;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExtendsKt$toastShort$1(String str, Continuation<? super ExtendsKt$toastShort$1> continuation) {
        super(2, continuation);
        this.$this_toastShort = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExtendsKt$toastShort$1(this.$this_toastShort, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExtendsKt$toastShort$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ToastUtil.INSTANCE.showShort(this.$this_toastShort);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
