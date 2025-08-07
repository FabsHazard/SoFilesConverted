package com.microtech.aidexx.ui.main.bg;

import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.utils.LogUtil;
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
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$CalibrationState;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgFragment.kt */
final class BgFragment$onResume$1 extends Lambda implements Function1<DeviceModel.CalibrationState, Unit> {
    final /* synthetic */ BgFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BgFragment$onResume$1(BgFragment bgFragment) {
        super(1);
        this.this$0 = bgFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceModel.CalibrationState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceModel.CalibrationState calibrationState) {
        Intrinsics.checkNotNullParameter(calibrationState, "it");
        this.this$0.calibrationState = calibrationState;
        LogUtil.Companion.xLogI$default(LogUtil.Companion, "刷新校准状态:" + calibrationState, (String) null, 2, (Object) null);
        final BgFragment bgFragment = this.this$0;
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.bg.BgFragment$onResume$1$1", f = "BgFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.bg.BgFragment$onResume$1$1  reason: invalid class name */
    /* compiled from: BgFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(bgFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                bgFragment.refreshBtnState();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
