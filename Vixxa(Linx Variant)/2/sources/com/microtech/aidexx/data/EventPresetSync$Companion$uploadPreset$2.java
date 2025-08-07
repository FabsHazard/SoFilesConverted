package com.microtech.aidexx.data;

import com.microtech.aidexx.data.EventPresetSync;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.EventPresetSync$Companion$uploadPreset$2", f = "EventPresetSync.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventPresetSync.kt */
final class EventPresetSync$Companion$uploadPreset$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    EventPresetSync$Companion$uploadPreset$2(Continuation<? super EventPresetSync$Companion$uploadPreset$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EventPresetSync$Companion$uploadPreset$2 eventPresetSync$Companion$uploadPreset$2 = new EventPresetSync$Companion$uploadPreset$2(continuation);
        eventPresetSync$Companion$uploadPreset$2.L$0 = obj;
        return eventPresetSync$Companion$uploadPreset$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventPresetSync$Companion$uploadPreset$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (EventPresetSync.isSyncing) {
                LogUtil.Companion.xLogE$default(LogUtil.Companion, "用户预设正在同步...", (String) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            EventPresetSync.Companion companion = EventPresetSync.Companion;
            EventPresetSync.isSyncing = true;
            Deferred[] deferredArr = {BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventPresetSync$Companion$uploadPreset$2$tasks$1((Continuation<? super EventPresetSync$Companion$uploadPreset$2$tasks$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventPresetSync$Companion$uploadPreset$2$tasks$2((Continuation<? super EventPresetSync$Companion$uploadPreset$2$tasks$2>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventPresetSync$Companion$uploadPreset$2$tasks$3((Continuation<? super EventPresetSync$Companion$uploadPreset$2$tasks$3>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new EventPresetSync$Companion$uploadPreset$2$tasks$4((Continuation<? super EventPresetSync$Companion$uploadPreset$2$tasks$4>) null), 3, (Object) null)};
            this.label = 1;
            if (AwaitKt.awaitAll(CollectionsKt.listOf(deferredArr), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EventPresetSync.Companion companion2 = EventPresetSync.Companion;
        EventPresetSync.isSyncing = false;
        return Unit.INSTANCE;
    }
}
