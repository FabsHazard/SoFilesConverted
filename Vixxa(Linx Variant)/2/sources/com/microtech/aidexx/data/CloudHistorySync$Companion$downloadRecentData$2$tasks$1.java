package com.microtech.aidexx.data;

import com.microtech.aidexx.ui.setting.SettingsManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.CloudHistorySync$Companion$downloadRecentData$2$tasks$1", f = "CloudHistorySync.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CloudHistorySync.kt */
final class CloudHistorySync$Companion$downloadRecentData$2$tasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isSuccess;
    final /* synthetic */ String $userId;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CloudHistorySync$Companion$downloadRecentData$2$tasks$1(String str, Ref.BooleanRef booleanRef, Continuation<? super CloudHistorySync$Companion$downloadRecentData$2$tasks$1> continuation) {
        super(2, continuation);
        this.$userId = str;
        this.$isSuccess = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CloudHistorySync$Companion$downloadRecentData$2$tasks$1(this.$userId, this.$isSuccess, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CloudHistorySync$Companion$downloadRecentData$2$tasks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.BooleanRef booleanRef2 = this.$isSuccess;
            this.L$0 = booleanRef2;
            this.label = 1;
            Object downloadSettings = SettingsManager.INSTANCE.downloadSettings(this.$userId, this);
            if (downloadSettings == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
            obj = downloadSettings;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CloudHistorySync$Companion$downloadRecentData$2.invokeSuspend$updateStatus(booleanRef, ((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }
}
