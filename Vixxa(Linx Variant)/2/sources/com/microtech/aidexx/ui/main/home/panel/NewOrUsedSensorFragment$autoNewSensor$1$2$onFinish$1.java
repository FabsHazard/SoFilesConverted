package com.microtech.aidexx.ui.main.home.panel;

import androidx.lifecycle.LifecycleOwner;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.ota.OtaDialog;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1", f = "NewOrUsedSensorFragment.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NewOrUsedSensorFragment.kt */
final class NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ DeviceModel $model;
    int label;
    final /* synthetic */ NewOrUsedSensorFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1(NewOrUsedSensorFragment newOrUsedSensorFragment, boolean z, DeviceModel deviceModel, Continuation<? super NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1> continuation) {
        super(2, continuation);
        this.this$0 = newOrUsedSensorFragment;
        this.$isSuccess = z;
        this.$model = deviceModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1(this.this$0, this.$isSuccess, this.$model, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            OtaDialog access$getOtaDialog$p = this.this$0.otaDialog;
            if (access$getOtaDialog$p != null) {
                access$getOtaDialog$p.changeState(this.$isSuccess ? 2 : 3, 0, -1.0f, Boxing.boxBoolean(false));
            }
            final NewOrUsedSensorFragment newOrUsedSensorFragment = this.this$0;
            final DeviceModel deviceModel = this.$model;
            final boolean z = this.$isSuccess;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1$1", f = "NewOrUsedSensorFragment.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1$1  reason: invalid class name */
    /* compiled from: NewOrUsedSensorFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(newOrUsedSensorFragment, deviceModel, z, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LogUtil.Companion.eAiDEX("OTA ---->  ota之后开始延迟7s");
                this.label = 1;
                if (DelayKt.delay(7000, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LogUtil.Companion.eAiDEX("OTA ---->  ota之后延迟7s结束 注册广播事件");
            newOrUsedSensorFragment.handler.sendEmptyMessageDelayed(2, 90000);
            final NewOrUsedSensorFragment newOrUsedSensorFragment = newOrUsedSensorFragment;
            final DeviceModel deviceModel = deviceModel;
            final boolean z = z;
            EventBusManager.INSTANCE.onReceive(EventBusKey.RECEIVE_BROADCAST, (LifecycleOwner) newOrUsedSensorFragment, new Function1<Boolean, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    newOrUsedSensorFragment.handler.removeMessages(2);
                    LogUtil.Companion.eAiDEX("OTA ---->  收到广播事件 sentNewSensorState=" + newOrUsedSensorFragment.sentNewSensorState + " hasDoNewSensor=" + OtaManager.Companion.instance().getHasDoNewSensor());
                    if ((newOrUsedSensorFragment.sentNewSensorState == 0 || newOrUsedSensorFragment.sentNewSensorState == 2) && !OtaManager.Companion.instance().getHasDoNewSensor()) {
                        LogUtil.Companion.eAiDEX("OTA ---->  ota之后收到广播开始自动确认传感器");
                        newOrUsedSensorFragment.getDeviceInfo(deviceModel, z ? 1 : -1);
                        if (newOrUsedSensorFragment.sentNewSensorState == 0) {
                            Dialogs.INSTANCE.showWait(newOrUsedSensorFragment.getString(R.string.com_sending));
                        }
                        newOrUsedSensorFragment.sentNewSensorState = 1;
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }
}
