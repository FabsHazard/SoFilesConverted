package com.microtech.aidexx.ui.main.home.panel;

import com.microtech.aidexx.ota.OtaDialog;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1", f = "NewOrUsedSensorFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NewOrUsedSensorFragment.kt */
final class NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Float $bitrate;
    final /* synthetic */ int $progress;
    int label;
    final /* synthetic */ NewOrUsedSensorFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1(NewOrUsedSensorFragment newOrUsedSensorFragment, int i, Float f, Continuation<? super NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1> continuation) {
        super(2, continuation);
        this.this$0 = newOrUsedSensorFragment;
        this.$progress = i;
        this.$bitrate = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1(this.this$0, this.$progress, this.$bitrate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            OtaDialog access$getOtaDialog$p = this.this$0.otaDialog;
            if (access$getOtaDialog$p != null) {
                int i = this.$progress;
                Float f = this.$bitrate;
                access$getOtaDialog$p.changeState(1, i, f != null ? f.floatValue() : -1.0f, Boxing.boxBoolean(false));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
