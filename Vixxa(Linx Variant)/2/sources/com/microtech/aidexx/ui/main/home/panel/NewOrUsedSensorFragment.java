package com.microtech.aidexx.ui.main.home.panel;

import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.databinding.FragmentNewOrUsedSensorBinding;
import com.microtech.aidexx.ota.OtaDialog;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.ui.main.home.HomeFragmentKt;
import com.microtech.aidexx.ui.main.home.HomeStateManager;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import com.microtechmd.blecomm.entity.AidexXDatetimeEntity;
import com.microtechmd.blecomm.entity.NewSensorEntity;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0006\t\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\u0012\u0010&\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentNewOrUsedSensorBinding;", "()V", "handler", "com/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment$handler$1", "Lcom/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment$handler$1;", "observer", "com/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment$observer$1", "Lcom/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment$observer$1;", "oldDpHexStr", "", "otaCommandState", "", "otaDialog", "Lcom/microtech/aidexx/ota/OtaDialog;", "sentNewSensorState", "autoNewSensor", "", "model", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "doNewSensor", "getDefaultParam", "getDeviceInfo", "otaRet", "initEvent", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "processAuto", "reset", "updateDefaultParam", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NewOrUsedSensorFragment.kt */
public final class NewOrUsedSensorFragment extends BaseFragment<BaseViewModel, FragmentNewOrUsedSensorBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MSG_COMMAND_TIMEOUT = 0;
    private static final int MSG_GET_DEVICE_INFO_COMMAND_TIMEOUT = 3;
    private static final int MSG_NEW_SENSOR_TIMEOUT = 1;
    private static final int MSG_START_NEW_SENSOR_TIMEOUT = 2;
    private static final long commandGetDeviceInfoTimeout = 60000;
    private static final long commandTimeout = 30000;
    private static final long newSensorTimeout = 60000;
    private static final long startNewSensorTimeout = 90000;
    /* access modifiers changed from: private */
    public final NewOrUsedSensorFragment$handler$1 handler = new NewOrUsedSensorFragment$handler$1(this, Looper.getMainLooper());
    private final NewOrUsedSensorFragment$observer$1 observer = new NewOrUsedSensorFragment$observer$1(this);
    /* access modifiers changed from: private */
    public String oldDpHexStr;
    /* access modifiers changed from: private */
    public int otaCommandState;
    /* access modifiers changed from: private */
    public OtaDialog otaDialog;
    /* access modifiers changed from: private */
    public int sentNewSensorState;

    @JvmStatic
    public static final NewOrUsedSensorFragment newInstance() {
        return Companion.newInstance();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentNewOrUsedSensorBinding inflate = FragmentNewOrUsedSensorBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        initView(deviceModel);
        initEvent();
        processAuto(deviceModel);
        ConstraintLayout root = ((FragmentNewOrUsedSensorBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void processAuto(DeviceModel deviceModel) {
        if (deviceModel != null && deviceModel.deviceType() == 2) {
            autoNewSensor(deviceModel);
        }
    }

    private final void initEvent() {
        LogUtil.Companion.eAiDEX("OTA newSensorFragment initEvent");
        MessageDistributor.Companion.instance().observer(this.observer);
    }

    public void onDetach() {
        super.onDetach();
        LogUtil.Companion.eAiDEX("OTA newSensorFragment onDetach removeObserver");
        MessageDistributor.Companion.instance().removeObserver(this.observer);
    }

    private final void initView(DeviceModel deviceModel) {
        if (deviceModel != null && deviceModel.deviceType() == 2) {
            ((FragmentNewOrUsedSensorBinding) getBinding()).buttonOldSensor.setVisibility(8);
        }
    }

    private final void autoNewSensor(DeviceModel deviceModel) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new NewOrUsedSensorFragment$autoNewSensor$1(this, deviceModel, (Continuation<? super NewOrUsedSensorFragment$autoNewSensor$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void getDeviceInfo(DeviceModel deviceModel, int i) {
        Unit unit;
        this.otaCommandState = i;
        this.handler.sendEmptyMessageDelayed(3, TimeUtils.oneMinuteMillis);
        BleControllerProxy controller = deviceModel.getController();
        if (controller != null) {
            controller.getTransInfo();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            NewOrUsedSensorFragment newOrUsedSensorFragment = this;
            LogUtil.Companion.xLogE$default(LogUtil.Companion, "ota getDeviceInfo model=null", (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateDefaultParam(DeviceModel deviceModel) {
        getDefaultParam(deviceModel);
    }

    /* access modifiers changed from: private */
    public final void doNewSensor(DeviceModel deviceModel) {
        OtaManager instance = OtaManager.Companion.instance();
        OtaInfo otaInfo = r2;
        OtaInfo otaInfo2 = new OtaInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
        OtaInfo otaInfo3 = otaInfo;
        otaInfo3.setCanUpload(true);
        instance.updateOtaInfo(otaInfo3);
        LogUtil.Companion.xLogI$default(LogUtil.Companion, " ota start doNewSensor 移除其他超时消息", (String) null, 2, (Object) null);
        this.handler.removeMessages(0);
        this.handler.removeMessages(3);
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageDelayed(1, TimeUtils.oneMinuteMillis);
        BleControllerProxy controller = deviceModel.getController();
        if (controller != null) {
            controller.newSensor(new NewSensorEntity(new AidexXDatetimeEntity(Calendar.getInstance())));
        }
    }

    /* access modifiers changed from: private */
    public final void getDefaultParam(DeviceModel deviceModel) {
        LogUtil.Companion.xLogI$default(LogUtil.Companion, "ota 之后 getDefaultParam", (String) null, 2, (Object) null);
        this.handler.sendEmptyMessageDelayed(0, 30000);
        BleControllerProxy controller = deviceModel.getController();
        if (controller != null) {
            controller.getDefaultParam();
        }
    }

    /* access modifiers changed from: private */
    public final void reset() {
        Dialogs.INSTANCE.dismissWait();
        HomeStateManager.Companion.instance().setState(HomeFragmentKt.glucosePanel);
    }

    public void onDestroy() {
        LogUtil.Companion.eAiDEX("OTA newSensorFragment onDestroy");
        Dialogs.INSTANCE.dismissWait();
        OtaDialog otaDialog2 = this.otaDialog;
        if (otaDialog2 != null) {
            otaDialog2.dismiss();
        }
        super.onDestroy();
        this.handler.removeCallbacksAndMessages((Object) null);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment$Companion;", "", "()V", "MSG_COMMAND_TIMEOUT", "", "MSG_GET_DEVICE_INFO_COMMAND_TIMEOUT", "MSG_NEW_SENSOR_TIMEOUT", "MSG_START_NEW_SENSOR_TIMEOUT", "commandGetDeviceInfoTimeout", "", "commandTimeout", "newSensorTimeout", "startNewSensorTimeout", "newInstance", "Lcom/microtech/aidexx/ui/main/home/panel/NewOrUsedSensorFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: NewOrUsedSensorFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NewOrUsedSensorFragment newInstance() {
            return new NewOrUsedSensorFragment();
        }
    }
}
