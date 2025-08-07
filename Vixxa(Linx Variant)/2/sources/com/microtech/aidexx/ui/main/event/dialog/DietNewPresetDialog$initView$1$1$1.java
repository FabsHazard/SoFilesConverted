package com.microtech.aidexx.ui.main.event.dialog;

import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.dialog.DietNewPresetDialog$initView$1$1$1", f = "DietNewPresetDialog.kt", i = {}, l = {130, 130}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DietNewPresetDialog.kt */
final class DietNewPresetDialog$initView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DietUsrPresetEntity $presetEntity;
    int label;
    final /* synthetic */ DietNewPresetDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DietNewPresetDialog$initView$1$1$1(DietNewPresetDialog dietNewPresetDialog, DietUsrPresetEntity dietUsrPresetEntity, Continuation<? super DietNewPresetDialog$initView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = dietNewPresetDialog;
        this.$presetEntity = dietUsrPresetEntity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DietNewPresetDialog$initView$1$1$1(this.this$0, this.$presetEntity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DietNewPresetDialog$initView$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getVm().savePreset(this.$presetEntity, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final DietNewPresetDialog dietNewPresetDialog = this.this$0;
        final DietUsrPresetEntity dietUsrPresetEntity = this.$presetEntity;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public final Object emit(Long l, Continuation<? super Unit> continuation) {
                if (l != null) {
                    DietNewPresetDialog dietNewPresetDialog = dietNewPresetDialog;
                    DietUsrPresetEntity dietUsrPresetEntity = dietUsrPresetEntity;
                    l.longValue();
                    dietNewPresetDialog.dismiss();
                    dietNewPresetDialog.dietDetail.setFoodPresetId(dietUsrPresetEntity.getPresetId());
                    dietNewPresetDialog.getOnConfirmClick().invoke(dietNewPresetDialog.dietDetail);
                }
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
