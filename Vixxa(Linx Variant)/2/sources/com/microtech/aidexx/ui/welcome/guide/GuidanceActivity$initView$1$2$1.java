package com.microtech.aidexx.ui.welcome.guide;

import android.content.Intent;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.ui.main.MainActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.welcome.guide.GuidanceActivity$initView$1$2$1", f = "GuidanceActivity.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GuidanceActivity.kt */
final class GuidanceActivity$initView$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GuidanceActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GuidanceActivity$initView$1$2$1(GuidanceActivity guidanceActivity, Continuation<? super GuidanceActivity$initView$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = guidanceActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GuidanceActivity$initView$1$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GuidanceActivity$initView$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (UserInfoManager.updateProfile$default(UserInfoManager.Companion.instance(), (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, Boxing.boxInt(1), (Integer) null, (Boolean) null, this, 1835007, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intent intent = new Intent(this.this$0, MainActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        this.this$0.startActivity(intent);
        this.this$0.finish();
        return Unit.INSTANCE;
    }
}
