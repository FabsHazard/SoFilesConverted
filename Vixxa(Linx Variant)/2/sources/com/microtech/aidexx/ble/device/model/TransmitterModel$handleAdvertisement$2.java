package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel$handleAdvertisement$2", f = "TransmitterModel.kt", i = {0}, l = {661}, m = "invokeSuspend", n = {"historiesFromBroadcast"}, s = {"L$0"})
/* compiled from: TransmitterModel.kt */
final class TransmitterModel$handleAdvertisement$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AidexXHistoryEntity> $adHistories;
    Object L$0;
    int label;
    final /* synthetic */ TransmitterModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterModel$handleAdvertisement$2(TransmitterModel transmitterModel, List<AidexXHistoryEntity> list, Continuation<? super TransmitterModel$handleAdvertisement$2> continuation) {
        super(2, continuation);
        this.this$0 = transmitterModel;
        this.$adHistories = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransmitterModel$handleAdvertisement$2(this.this$0, this.$adHistories, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransmitterModel$handleAdvertisement$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            final TransmitterModel transmitterModel = this.this$0;
            final List<AidexXHistoryEntity> list = this.$adHistories;
            this.L$0 = objectRef2;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else if (i == 1) {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!((Collection) objectRef.element).isEmpty()) {
            this.this$0.alertSetting = SettingsManager.INSTANCE.getSettingEntity();
            this.this$0.saveBriefHistory(CollectionsKt.asReversedMutable((List) objectRef.element), false);
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ble.device.model.TransmitterModel$handleAdvertisement$2$1", f = "TransmitterModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ble.device.model.TransmitterModel$handleAdvertisement$2$1  reason: invalid class name */
    /* compiled from: TransmitterModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(objectRef2, transmitterModel, list, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<List<AidexXHistoryEntity>> objectRef = objectRef2;
                TransmitterModel transmitterModel = transmitterModel;
                int nextEventIndex = transmitterModel.getNextEventIndex();
                List<AidexXHistoryEntity> list = list;
                Intrinsics.checkNotNullExpressionValue(list, "$adHistories");
                objectRef.element = transmitterModel.getHistoriesFromBroadcast(nextEventIndex, list);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
