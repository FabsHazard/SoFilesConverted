package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.DeviceHeartBeat;
import com.microtech.aidexx.data.wear.WatchData;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import com.microtechmd.blecomm.parser.AidexXInstantHistoryEntity;
import java.util.Date;
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
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel$handleLongConnectNotify$1$1", f = "TransmitterModel.kt", i = {}, l = {433}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$handleLongConnectNotify$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Date $historyDate;
    final /* synthetic */ AidexXInstantHistoryEntity $historyEntity;
    final /* synthetic */ AidexXHistoryEntity $it;
    int label;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$handleLongConnectNotify$1$1(AidexXInstantHistoryEntity aidexXInstantHistoryEntity, AidexXHistoryEntity aidexXHistoryEntity, Date date, TransmitterModel transmitterModel, Continuation<? super TransmitterModel$handleLongConnectNotify$1$1> continuation) {
        super(2, continuation);
        this.$historyEntity = aidexXInstantHistoryEntity;
        this.$it = aidexXHistoryEntity;
        this.$historyDate = date;
        this.this$0 = transmitterModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterModel$handleLongConnectNotify$1$1(this.$historyEntity, this.$it, this.$historyDate, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterModel$handleLongConnectNotify$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (WatchData.Companion.getInstance().uploadHeartBeat(new DeviceHeartBeat(Boxing.boxInt(0), Boxing.boxInt(this.$historyEntity.abstractEntity.calIndex), Boxing.boxFloat((float) this.$it.glucose), Boxing.boxInt(this.$historyEntity.abstractEntity.trend), ExtendsKt.dateAndTimeS$default(this.$historyDate, (String) null, 1, (Object) null), Boxing.boxInt(this.$it.timeOffset), Boxing.boxInt(this.$historyEntity.abstractEntity.calTemp), Boxing.boxInt(this.$historyEntity.abstractEntity.status), this.this$0.getEntity().getSensorId(), Boxing.boxInt(this.$it.status)), this) == coroutine_suspended) {
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
