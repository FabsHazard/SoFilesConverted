package com.microtech.aidexx.service;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.service.DataService$scheduleTask$1$run$2", f = "DataService.kt", i = {}, l = {72, 73, 74, 75}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DataService.kt */
final class DataService$scheduleTask$1$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    DataService$scheduleTask$1$run$2(Continuation<? super DataService$scheduleTask$1$run$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataService$scheduleTask$1$run$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DataService$scheduleTask$1$run$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002c
            if (r1 == r5) goto L_0x0028
            if (r1 == r4) goto L_0x0024
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006c
        L_0x0018:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005e
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0050
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0042
        L_0x002c:
            kotlin.ResultKt.throwOnFailure(r7)
            com.microtech.aidexx.data.CloudHistorySync$Companion r7 = com.microtech.aidexx.data.CloudHistorySync.Companion
            r7.uploadDeletedData()
            com.microtech.aidexx.data.CloudHistorySync$Companion r7 = com.microtech.aidexx.data.CloudHistorySync.Companion
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r5
            java.lang.Object r7 = r7.uploadHistoryData(r1)
            if (r7 != r0) goto L_0x0042
            return r0
        L_0x0042:
            com.microtech.aidexx.data.EventPresetSync$Companion r7 = com.microtech.aidexx.data.EventPresetSync.Companion
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r4
            java.lang.Object r7 = r7.uploadPreset(r1)
            if (r7 != r0) goto L_0x0050
            return r0
        L_0x0050:
            com.microtech.aidexx.ui.setting.SettingsManager r7 = com.microtech.aidexx.ui.setting.SettingsManager.INSTANCE
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r3
            java.lang.Object r7 = r7.uploadSettings(r1)
            if (r7 != r0) goto L_0x005e
            return r0
        L_0x005e:
            com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager r7 = com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager.INSTANCE
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r2
            java.lang.Object r7 = r7.uploadTimezoneHistory(r1)
            if (r7 != r0) goto L_0x006c
            return r0
        L_0x006c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.service.DataService$scheduleTask$1$run$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
