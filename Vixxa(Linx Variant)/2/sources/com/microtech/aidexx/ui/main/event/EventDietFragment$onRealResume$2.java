package com.microtech.aidexx.ui.main.event;

import com.microtech.aidexx.common.net.repository.EventRepository;
import com.microtech.aidexx.common.user.UserInfoManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.EventDietFragment$onRealResume$2", f = "EventDietFragment.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventDietFragment.kt */
final class EventDietFragment$onRealResume$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    EventDietFragment$onRealResume$2(Continuation<? super EventDietFragment$onRealResume$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventDietFragment$onRealResume$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventDietFragment$onRealResume$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            EventRepository eventRepository = EventRepository.INSTANCE;
            this.label = 1;
            if (FlowKt.flowOn(FlowKt.callbackFlow(new EventDietFragment$onRealResume$2$invokeSuspend$$inlined$syncEventPreset$default$1(true, UserInfoManager.Companion.instance().userId(), (Continuation) null)), Dispatchers.getIO()).collect(AnonymousClass1.INSTANCE, this) == coroutine_suspended) {
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
