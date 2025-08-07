package com.microtech.aidexx.ui.main.event.dialog;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.dialog.InsulinPresetDialog$initBtnEvent$1$3$1", f = "InsulinPresetDialog.kt", i = {0}, l = {87, 87}, m = "invokeSuspend", n = {"presetEntity"}, s = {"L$0"})
/* compiled from: InsulinPresetDialog.kt */
final class InsulinPresetDialog$initBtnEvent$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ InsulinPresetDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InsulinPresetDialog$initBtnEvent$1$3$1(InsulinPresetDialog insulinPresetDialog, Continuation<? super InsulinPresetDialog$initBtnEvent$1$3$1> continuation) {
        super(2, continuation);
        this.this$0 = insulinPresetDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InsulinPresetDialog$initBtnEvent$1$3$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InsulinPresetDialog$initBtnEvent$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final InsulinUsrPresetEntity insulinUsrPresetEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.needSaveNewPreset || !Intrinsics.areEqual((Object) this.this$0.oldInsulinEntity.getInsulinPresetId(), (Object) "")) {
                this.this$0.dismiss();
                this.this$0.onConfirmClick.invoke(this.this$0.oldInsulinEntity);
                return Unit.INSTANCE;
            }
            insulinUsrPresetEntity = new InsulinUsrPresetEntity();
            insulinUsrPresetEntity.setName(this.this$0.oldInsulinEntity.getName());
            insulinUsrPresetEntity.setUserId(UserInfoManager.Companion.instance().userId());
            this.L$0 = insulinUsrPresetEntity;
            this.label = 1;
            obj = this.this$0.getVm().savePreset(insulinUsrPresetEntity, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            insulinUsrPresetEntity = (InsulinUsrPresetEntity) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final InsulinPresetDialog insulinPresetDialog = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            public final Object emit(Long l, Continuation<? super Unit> continuation) {
                if (l != null) {
                    InsulinPresetDialog insulinPresetDialog = insulinPresetDialog;
                    InsulinUsrPresetEntity insulinUsrPresetEntity = insulinUsrPresetEntity;
                    l.longValue();
                    insulinPresetDialog.dismiss();
                    insulinPresetDialog.oldInsulinEntity.setInsulinPresetId(insulinUsrPresetEntity.getPresetId());
                    insulinPresetDialog.onConfirmClick.invoke(insulinPresetDialog.oldInsulinEntity);
                }
                return Unit.INSTANCE;
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
