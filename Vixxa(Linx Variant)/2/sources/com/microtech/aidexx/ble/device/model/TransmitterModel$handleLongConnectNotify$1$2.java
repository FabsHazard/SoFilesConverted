package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import com.microtechmd.blecomm.parser.AidexXInstantHistoryEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel$handleLongConnectNotify$1$2", f = "TransmitterModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$handleLongConnectNotify$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AidexXInstantHistoryEntity $historyEntity;
    int label;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$handleLongConnectNotify$1$2(TransmitterModel transmitterModel, AidexXInstantHistoryEntity aidexXInstantHistoryEntity, Continuation<? super TransmitterModel$handleLongConnectNotify$1$2> continuation) {
        super(2, continuation);
        this.this$0 = transmitterModel;
        this.$historyEntity = aidexXInstantHistoryEntity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterModel$handleLongConnectNotify$1$2(this.this$0, this.$historyEntity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterModel$handleLongConnectNotify$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.alertSetting = SettingsManager.INSTANCE.getSettingEntity();
            TransmitterModel transmitterModel = this.this$0;
            AidexXHistoryEntity aidexXHistoryEntity = this.$historyEntity.history;
            Intrinsics.checkNotNullExpressionValue(aidexXHistoryEntity, "history");
            transmitterModel.saveBriefHistory(CollectionsKt.mutableListOf(aidexXHistoryEntity), false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
