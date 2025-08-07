package com.microtech.aidexx.ui.pair;

import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.PendingIntentReceiver;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.ui.pair.TransmitterActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.controller.BleController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterActivity.kt */
final class TransmitterActivity$initEvent$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ TransmitterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransmitterActivity$initEvent$1(TransmitterActivity transmitterActivity) {
        super(1);
        this.this$0 = transmitterActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        TransmitterActivity.TransmitterHandler access$getTransmitterHandler$p = this.this$0.transmitterHandler;
        if (access$getTransmitterHandler$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transmitterHandler");
            access$getTransmitterHandler$p = null;
        }
        access$getTransmitterHandler$p.removeMessages(PendingIntentReceiver.REQUEST_CODE);
        if (!z) {
            Dialogs.showError$default(Dialogs.INSTANCE, this.this$0.getString(R.string.com_actionState_failure, new Object[]{this.this$0.getString(R.string.com_action_pair)}), 0, 2, (Object) null);
            TransmitterManager.Companion.instance().removePair();
        } else if (this.this$0.getWindow().getDecorView().getVisibility() == 0) {
            final TransmitterActivity transmitterActivity = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.pair.TransmitterActivity$initEvent$1$1", f = "TransmitterActivity.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.pair.TransmitterActivity$initEvent$1$1  reason: invalid class name */
    /* compiled from: TransmitterActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(transmitterActivity, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            DeviceModel deviceModel;
            BleController controller;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Dialogs.INSTANCE.showSuccess(transmitterActivity.getString(R.string.com_actionState_success, new Object[]{transmitterActivity.getString(R.string.com_action_pair)}));
                Boolean bool = BuildConfig.keepAlive;
                Intrinsics.checkNotNullExpressionValue(bool, "keepAlive");
                if (!(!bool.booleanValue() || (deviceModel = TransmitterManager.Companion.instance().getDefault()) == null || (controller = deviceModel.getController()) == null)) {
                    controller.disconnect();
                }
                this.label = 1;
                if (DelayKt.delay(PairUtilKt.DELAY_A_WHILE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ActivityUtil.INSTANCE.finishToMain();
            return Unit.INSTANCE;
        }
    }
}
