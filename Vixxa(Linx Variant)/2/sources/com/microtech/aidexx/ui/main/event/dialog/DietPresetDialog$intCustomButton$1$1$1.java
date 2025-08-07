package com.microtech.aidexx.ui.main.event.dialog;

import com.microtech.aidexx.db.entity.event.DietDetail;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog$intCustomButton$1$1$1", f = "DietPresetDialog.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DietPresetDialog.kt */
final class DietPresetDialog$intCustomButton$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DietDetail $dietDetailEntity;
    int label;
    final /* synthetic */ DietPresetDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DietPresetDialog$intCustomButton$1$1$1(DietPresetDialog dietPresetDialog, DietDetail dietDetail, Continuation<? super DietPresetDialog$intCustomButton$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = dietPresetDialog;
        this.$dietDetailEntity = dietDetail;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DietPresetDialog$intCustomButton$1$1$1(this.this$0, this.$dietDetailEntity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DietPresetDialog$intCustomButton$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.setPropertyName(this.$dietDetailEntity, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        new DietNewPresetDialog(this.this$0.mFragment, this.$dietDetailEntity, this.this$0.getOnConfirmClick()).show();
        this.this$0.dismiss();
        return Unit.INSTANCE;
    }
}
