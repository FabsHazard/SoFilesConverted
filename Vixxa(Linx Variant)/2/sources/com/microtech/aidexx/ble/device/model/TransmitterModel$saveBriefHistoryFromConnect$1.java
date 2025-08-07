package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import com.microtechmd.blecomm.parser.AidexXParser;
import java.util.Collection;
import java.util.List;
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
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel$saveBriefHistoryFromConnect$1", f = "TransmitterModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$saveBriefHistoryFromConnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$saveBriefHistoryFromConnect$1(byte[] bArr, TransmitterModel transmitterModel, Continuation<? super TransmitterModel$saveBriefHistoryFromConnect$1> continuation) {
        super(2, continuation);
        this.$data = bArr;
        this.this$0 = transmitterModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterModel$saveBriefHistoryFromConnect$1(this.$data, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterModel$saveBriefHistoryFromConnect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List histories = AidexXParser.getHistories(this.$data);
            Collection collection = histories;
            if (collection == null || collection.isEmpty()) {
                return Unit.INSTANCE;
            }
            this.this$0.alertSetting = SettingsManager.INSTANCE.getSettingEntity();
            Intrinsics.checkNotNull(histories);
            if (((AidexXHistoryEntity) CollectionsKt.first(histories)).timeOffset == this.this$0.getNextEventIndex()) {
                TransmitterModel.saveBriefHistory$default(this.this$0, histories, false, 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
