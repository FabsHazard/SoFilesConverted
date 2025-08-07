package com.microtech.aidexx.data.resource;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.EventUnitManager$loadUnit$1", f = "EventUnitManager.kt", i = {0, 1}, l = {77, 79}, m = "invokeSuspend", n = {"ret", "ret"}, s = {"L$0", "L$0"})
/* compiled from: EventUnitManager.kt */
final class EventUnitManager$loadUnit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $lang;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventUnitManager$loadUnit$1(String str, Continuation<? super EventUnitManager$loadUnit$1> continuation) {
        super(2, continuation);
        this.$lang = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventUnitManager$loadUnit$1(this.$lang, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventUnitManager$loadUnit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(T r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0031
            if (r1 == r3) goto L_0x0022
            if (r1 != r2) goto L_0x001a
            java.lang.Object r0 = r7.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r7.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0071
        L_0x001a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0022:
            java.lang.Object r1 = r7.L$1
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r3 = r7.L$0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            kotlin.ResultKt.throwOnFailure(r8)
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x004e
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            com.microtech.aidexx.db.repository.EventDbRepository r8 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            java.lang.String r4 = r7.$lang
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.L$0 = r1
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r8 = r8.loadUnit(r4, r5)
            if (r8 != r0) goto L_0x004d
            return r0
        L_0x004d:
            r3 = r1
        L_0x004e:
            r3.element = r8
            T r8 = r1.element
            java.util.Collection r8 = (java.util.Collection) r8
            if (r8 == 0) goto L_0x005c
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0073
        L_0x005c:
            com.microtech.aidexx.db.repository.EventDbRepository r8 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.L$0 = r1
            r7.L$1 = r1
            r7.label = r2
            java.lang.String r2 = ""
            java.lang.Object r8 = r8.loadUnit(r2, r3)
            if (r8 != r0) goto L_0x0070
            return r0
        L_0x0070:
            r0 = r1
        L_0x0071:
            r0.element = r8
        L_0x0073:
            T r8 = r1.element
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x0082
            com.microtech.aidexx.data.resource.EventUnitManager r8 = com.microtech.aidexx.data.resource.EventUnitManager.INSTANCE
            T r0 = r1.element
            java.util.List r0 = (java.util.List) r0
            r8.updateMemo(r0)
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.EventUnitManager$loadUnit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
