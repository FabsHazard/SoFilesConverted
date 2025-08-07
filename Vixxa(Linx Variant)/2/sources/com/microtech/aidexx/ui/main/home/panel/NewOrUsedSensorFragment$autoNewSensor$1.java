package com.microtech.aidexx.ui.main.home.panel;

import android.content.DialogInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.databinding.FragmentNewOrUsedSensorBinding;
import com.microtech.aidexx.ota.OtaDialog;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.ota.OtaProgressListener;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment$autoNewSensor$1", f = "NewOrUsedSensorFragment.kt", i = {}, l = {272}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NewOrUsedSensorFragment.kt */
final class NewOrUsedSensorFragment$autoNewSensor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceModel $model;
    int label;
    final /* synthetic */ NewOrUsedSensorFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewOrUsedSensorFragment$autoNewSensor$1(NewOrUsedSensorFragment newOrUsedSensorFragment, DeviceModel deviceModel, Continuation<? super NewOrUsedSensorFragment$autoNewSensor$1> continuation) {
        super(2, continuation);
        this.this$0 = newOrUsedSensorFragment;
        this.$model = deviceModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NewOrUsedSensorFragment$autoNewSensor$1(this.this$0, this.$model, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NewOrUsedSensorFragment$autoNewSensor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ((FragmentNewOrUsedSensorBinding) this.this$0.getBinding()).llAutoNew.setVisibility(0);
            ((FragmentNewOrUsedSensorBinding) this.this$0.getBinding()).llNewOrUsed.setVisibility(8);
            String deviceSn = this.$model.getEntity().getDeviceSn();
            if (deviceSn != null) {
                DeviceModel deviceModel = this.$model;
                OtaManager instance = OtaManager.Companion.instance();
                String version = deviceModel.getEntity().getVersion();
                if (version == null) {
                    version = "";
                }
                instance.initOtaInfo(deviceSn, version);
            }
            OtaManager instance2 = OtaManager.Companion.instance();
            DeviceModel deviceModel2 = this.$model;
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            final NewOrUsedSensorFragment newOrUsedSensorFragment = this.this$0;
            final DeviceModel deviceModel3 = this.$model;
            this.label = 1;
            if (instance2.checkIfNeedOta(deviceModel2, viewLifecycleOwner, new OtaProgressListener() {
                public void needNotOta() {
                    Dialogs.INSTANCE.showWait(newOrUsedSensorFragment.getString(R.string.com_sending));
                    newOrUsedSensorFragment.getDeviceInfo(deviceModel3, -2);
                }

                public void onStart() {
                    LogUtil.Companion.eAiDEX("OTA ----> start");
                    MmkvManager mmkvManager = MmkvManager.INSTANCE;
                    String deviceSn = deviceModel3.getEntity().getDeviceSn();
                    if (deviceSn == null) {
                        deviceSn = "";
                    }
                    mmkvManager.setDidOtaSn(deviceSn);
                    newOrUsedSensorFragment.sentNewSensorState = 0;
                    newOrUsedSensorFragment.otaDialog = new OtaDialog.Setter(newOrUsedSensorFragment.requireActivity()).setPositive(new NewOrUsedSensorFragment$autoNewSensor$1$2$$ExternalSyntheticLambda0(newOrUsedSensorFragment)).create();
                    OtaDialog access$getOtaDialog$p = newOrUsedSensorFragment.otaDialog;
                    if (access$getOtaDialog$p != null) {
                        access$getOtaDialog$p.show();
                    }
                    OtaManager instance = OtaManager.Companion.instance();
                    OtaInfo otaInfo = r2;
                    OtaInfo otaInfo2 = new OtaInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
                    OtaInfo otaInfo3 = otaInfo;
                    otaInfo3.setNeedOta(true);
                    instance.updateOtaInfo(otaInfo3);
                }

                /* access modifiers changed from: private */
                public static final void onStart$lambda$0(NewOrUsedSensorFragment newOrUsedSensorFragment, DialogInterface dialogInterface, int i) {
                    Intrinsics.checkNotNullParameter(newOrUsedSensorFragment, "this$0");
                    dialogInterface.dismiss();
                    if (newOrUsedSensorFragment.sentNewSensorState == 0) {
                        Dialogs.INSTANCE.showWait(newOrUsedSensorFragment.getString(R.string.com_sending));
                    }
                    newOrUsedSensorFragment.sentNewSensorState = 2;
                }

                public void onFinish(boolean z) {
                    boolean z2 = z;
                    LogUtil.Companion.eAiDEX("OTA ----> finish, isSuccess:" + z2);
                    Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(newOrUsedSensorFragment), (CoroutineContext) null, (CoroutineStart) null, new NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1(newOrUsedSensorFragment, z2, deviceModel3, (Continuation<? super NewOrUsedSensorFragment$autoNewSensor$1$2$onFinish$1>) null), 3, (Object) null);
                    OtaManager instance = OtaManager.Companion.instance();
                    OtaInfo otaInfo = r3;
                    OtaInfo otaInfo2 = new OtaInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
                    OtaInfo otaInfo3 = otaInfo;
                    otaInfo3.setOtaWriteRet(Boolean.valueOf(z));
                    instance.updateOtaInfo(otaInfo3);
                }

                public void onProgress(int i, Float f) {
                    LogUtil.Companion.eAiDEX("OTA ----> TotalProgress:" + i);
                    Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(newOrUsedSensorFragment), (CoroutineContext) null, (CoroutineStart) null, new NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1(newOrUsedSensorFragment, i, f, (Continuation<? super NewOrUsedSensorFragment$autoNewSensor$1$2$onProgress$1>) null), 3, (Object) null);
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
