package com.microtech.aidexx.service;

import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "model", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainService.kt */
final class MainService$onTransmitterChangeListener$1 extends Lambda implements Function1<DeviceModel, Unit> {
    final /* synthetic */ MainService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainService$onTransmitterChangeListener$1(MainService mainService) {
        super(1);
        this.this$0 = mainService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DeviceModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DeviceModel deviceModel) {
        if (deviceModel != null) {
            MainService mainService = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(mainService), (CoroutineContext) null, (CoroutineStart) null, new MainService$onTransmitterChangeListener$1$1$1(deviceModel, mainService, (Continuation<? super MainService$onTransmitterChangeListener$1$1$1>) null), 3, (Object) null);
        }
    }
}
