package com.microtech.aidexx.ui.main.home.panel;

import androidx.fragment.app.FragmentActivity;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.views.dialog.Dialogs;
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
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.panel.GlucosePanelFragment$deleteAndToPair$1", f = "GlucosePanelFragment.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GlucosePanelFragment.kt */
final class GlucosePanelFragment$deleteAndToPair$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GlucosePanelFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlucosePanelFragment$deleteAndToPair$1(GlucosePanelFragment glucosePanelFragment, Continuation<? super GlucosePanelFragment$deleteAndToPair$1> continuation) {
        super(2, continuation);
        this.this$0 = glucosePanelFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GlucosePanelFragment$deleteAndToPair$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GlucosePanelFragment$deleteAndToPair$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DeviceModel deviceModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Dialogs.INSTANCE.showWait(this.this$0.getString(R.string.com_loading));
            FragmentActivity activity = this.this$0.getActivity();
            if (!(activity == null || (deviceModel = TransmitterManager.Companion.instance().getDefault()) == null)) {
                this.label = 1;
                if (deviceModel.deletePair(new GlucosePanelFragment$deleteAndToPair$1$1$1(activity), this) == coroutine_suspended) {
                    return coroutine_suspended;
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
