package com.microtech.aidexx.ui.main.event.viewmodels;

import com.microtech.aidexx.common.net.entity.ResEventPresetVersion;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005\"\b\b\u0002\u0010\u0006*\u00020\u0007*\u00020\bH@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "D", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "P", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel$startSyncPreset$2$1$1$2", f = "BaseEventViewModel.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseEventViewModel.kt */
final class BaseEventViewModel$startSyncPreset$2$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResEventPresetVersion $it;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ BaseEventViewModel<T, D, P> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventViewModel$startSyncPreset$2$1$1$2(ResEventPresetVersion resEventPresetVersion, int i, BaseEventViewModel<T, D, P> baseEventViewModel, Continuation<? super BaseEventViewModel$startSyncPreset$2$1$1$2> continuation) {
        super(2, continuation);
        this.$it = resEventPresetVersion;
        this.$type = i;
        this.this$0 = baseEventViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseEventViewModel$startSyncPreset$2$1$1$2(this.$it, this.$type, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseEventViewModel$startSyncPreset$2$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String userVersion = this.$it.getUserVersion();
            if (userVersion != null) {
                int i2 = this.$type;
                BaseEventViewModel<T, D, P> baseEventViewModel = this.this$0;
                ResEventPresetVersion resEventPresetVersion = this.$it;
                if (userVersion.compareTo(MmkvManager.INSTANCE.getPresetVersion(i2, false)) > 0) {
                    String userVersion2 = resEventPresetVersion.getUserVersion();
                    this.label = 1;
                    if (baseEventViewModel.syncPreset(i2, false, userVersion2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
