package com.microtech.aidexx.ui.main.home.panel;

import androidx.work.WorkRequest;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.StringUtils;
import com.microtechmd.blecomm.entity.BleMessage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$observer$1$onMessage$8", f = "NewOrUsedSensorFragment.kt", i = {0, 0}, l = {196}, m = "invokeSuspend", n = {"$this$launch", "model"}, s = {"L$0", "L$2"})
/* compiled from: NewOrUsedSensorFragment.kt */
final class NewOrUsedSensorFragment$observer$1$onMessage$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BleMessage $message;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ NewOrUsedSensorFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewOrUsedSensorFragment$observer$1$onMessage$8(NewOrUsedSensorFragment newOrUsedSensorFragment, BleMessage bleMessage, Continuation<? super NewOrUsedSensorFragment$observer$1$onMessage$8> continuation) {
        super(2, continuation);
        this.this$0 = newOrUsedSensorFragment;
        this.$message = bleMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NewOrUsedSensorFragment$observer$1$onMessage$8 newOrUsedSensorFragment$observer$1$onMessage$8 = new NewOrUsedSensorFragment$observer$1$onMessage$8(this.this$0, this.$message, continuation);
        newOrUsedSensorFragment$observer$1$onMessage$8.L$0 = obj;
        return newOrUsedSensorFragment$observer$1$onMessage$8;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NewOrUsedSensorFragment$observer$1$onMessage$8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        NewOrUsedSensorFragment newOrUsedSensorFragment;
        Object obj2;
        DeviceModel deviceModel;
        Unit unit;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String access$getOldDpHexStr$p = this.this$0.oldDpHexStr;
            if (access$getOldDpHexStr$p != null) {
                BleMessage bleMessage = this.$message;
                NewOrUsedSensorFragment newOrUsedSensorFragment2 = this.this$0;
                String binaryToHex = StringUtils.INSTANCE.binaryToHex(bleMessage.getData());
                LogUtil.Companion.xLogI$default(LogUtil.Companion, "ota GET_DEFAULT_PARAM newDpHexStr=" + binaryToHex + " isSetSucc=" + Intrinsics.areEqual((Object) access$getOldDpHexStr$p, (Object) binaryToHex), (String) null, 2, (Object) null);
                OtaManager instance = OtaManager.Companion.instance();
                OtaInfo otaInfo = new OtaInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
                otaInfo.setDpNewVersion(StringsKt.take(binaryToHex, 8));
                instance.updateOtaInfo(otaInfo);
                DeviceModel deviceModel2 = TransmitterManager.Companion.instance().getDefault();
                if (deviceModel2 != null) {
                    newOrUsedSensorFragment2.doNewSensor(deviceModel2);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    LogUtil.Companion.xLogE$default(LogUtil.Companion, "ota GET_DEFAULT_PARAM succ second model null", (String) null, 2, (Object) null);
                }
            } else {
                newOrUsedSensorFragment = this.this$0;
                BleMessage bleMessage2 = this.$message;
                DeviceModel deviceModel3 = TransmitterManager.Companion.instance().getDefault();
                if (deviceModel3 != null) {
                    newOrUsedSensorFragment.oldDpHexStr = StringUtils.INSTANCE.binaryToHex(bleMessage2.getData());
                    LogUtil.Companion.xLogI$default(LogUtil.Companion, "ota GET_DEFAULT_PARAM oldDp=" + newOrUsedSensorFragment.oldDpHexStr, (String) null, 2, (Object) null);
                    OtaManager instance2 = OtaManager.Companion.instance();
                    String access$getOldDpHexStr$p2 = newOrUsedSensorFragment.oldDpHexStr;
                    Intrinsics.checkNotNull(access$getOldDpHexStr$p2);
                    this.L$0 = coroutineScope;
                    this.L$1 = newOrUsedSensorFragment;
                    this.L$2 = deviceModel3;
                    this.label = 1;
                    obj2 = instance2.setDefaultParam(deviceModel3, access$getOldDpHexStr$p2, this);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    deviceModel = deviceModel3;
                } else {
                    LogUtil.Companion.xLogE$default(LogUtil.Companion, "ota GET_DEFAULT_PARAM succ first model null", (String) null, 2, (Object) null);
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            deviceModel = (DeviceModel) this.L$2;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            newOrUsedSensorFragment = (NewOrUsedSensorFragment) this.L$1;
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((String) obj2) != null) {
            Boxing.boxBoolean(newOrUsedSensorFragment.handler.sendEmptyMessageDelayed(0, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS));
        } else {
            newOrUsedSensorFragment.doNewSensor(deviceModel);
        }
        return Unit.INSTANCE;
    }
}
