package com.microtech.aidexx.ui.main;

import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import java.util.TimeZone;
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
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.MainActivity$recreateMain$2", f = "MainActivity.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MainActivity.kt */
final class MainActivity$recreateMain$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainActivity$recreateMain$2(MainActivity mainActivity, Continuation<? super MainActivity$recreateMain$2> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$recreateMain$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$recreateMain$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(500, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EventBusManager.INSTANCE.send(EventBusKey.EVENT_SWITCH_TIMEZONE, TimeZone.getDefault().getID());
        LogUtil.Companion companion = LogUtil.Companion;
        String access$getTAG$cp = MainActivity.TAG;
        Intrinsics.checkNotNullExpressionValue(access$getTAG$cp, "access$getTAG$cp(...)");
        companion.xLogI("checkTimeZoneChange 重建首页", access$getTAG$cp);
        this.this$0.recreate();
        return Unit.INSTANCE;
    }
}
