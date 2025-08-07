package com.microtech.aidexx.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.SystemClock;
import androidx.core.app.ActivityCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.ble.device.work.StartScanWorker;
import com.microtech.aidexx.ble.device.work.StopScanWorker;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.StringUtils;
import com.microtechmd.blecomm.BleAdapter;
import com.microtechmd.blecomm.BluetoothDeviceStore;
import com.microtechmd.blecomm.constant.AidexXOperation;
import com.microtechmd.blecomm.controller.BleController;
import com.microtechmd.blecomm.controller.BleControllerInfo;
import com.microtechmd.blecomm.entity.BleMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u001a\b\u0016\u0018\u0000 k2\u00020\u0001:\u0001kB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020;0AH\u0002J\b\u0010B\u001a\u00020CH\u0002J\u0012\u0010D\u001a\u00020\u00172\b\u0010E\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010F\u001a\u00020*H\u0002J\b\u0010G\u001a\u00020*H\u0003J\u0010\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020*H\u0016J\u0010\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020\rH\u0016J\b\u0010N\u001a\u00020*H\u0016J\b\u0010O\u001a\u00020*H\u0016J\u0010\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020RH\u0016J\u0018\u0010S\u001a\u00020*2\u0006\u0010M\u001a\u00020\r2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010T\u001a\u00020\bH\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020#J\u0010\u0010W\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0016J\u0006\u0010X\u001a\u00020*J\u0006\u0010Y\u001a\u00020*J\u001c\u0010Z\u001a\u00020*2\b\u0010E\u001a\u0004\u0018\u00010\u000e2\b\u0010[\u001a\u0004\u0018\u00010RH\u0002J\u000e\u0010\\\u001a\u00020*2\u0006\u0010)\u001a\u00020\u0017J\u0012\u0010]\u001a\u00020*2\b\u0010^\u001a\u0004\u0018\u00010 H\u0005J\u0006\u0010_\u001a\u00020*J\b\u0010`\u001a\u00020*H\u0002J\u0018\u0010a\u001a\u00020*2\u0006\u0010b\u001a\u00020\r2\u0006\u0010Q\u001a\u00020RH\u0003J\b\u0010c\u001a\u00020*H\u0016J\u0010\u0010d\u001a\u00020*2\u0006\u0010E\u001a\u00020\u000eH\u0003J\u0010\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020\u001cH\u0002J\u0010\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020\u0017H\u0016J\u0010\u0010i\u001a\u00020*2\u0006\u0010h\u001a\u00020\u0017H\u0016J\u0018\u0010j\u001a\u00020*2\u0006\u0010Q\u001a\u00020R2\u0006\u0010M\u001a\u00020\rH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u000e¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000RC\u0010%\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R7\u0010/\u001a\u001f\u0012\u0013\u0012\u001100¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020*\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\u000e\u00104\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u000e¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/microtech/aidexx/ble/AidexBleAdapter;", "Lcom/microtechmd/blecomm/BleAdapter;", "()V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothDeviceStore", "Lcom/microtechmd/blecomm/BluetoothDeviceStore;", "bluetoothGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "characteristicsMap", "Ljava/util/HashMap;", "", "Landroid/bluetooth/BluetoothGattCharacteristic;", "Lkotlin/collections/HashMap;", "connectStatus", "Lkotlin/Pair;", "getConnectStatus", "()Lkotlin/Pair;", "setConnectStatus", "(Lkotlin/Pair;)V", "isOnConnectState", "", "()Z", "setOnConnectState", "(Z)V", "lastDisConnectTime", "", "mBluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "mBluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "mCharacteristic", "mContext", "Landroid/content/Context;", "mLastSendDataTime", "onConnectStateChangeCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isConnect", "", "getOnConnectStateChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setOnConnectStateChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "onDeviceDiscover", "Lcom/microtechmd/blecomm/controller/BleControllerInfo;", "info", "getOnDeviceDiscover", "setOnDeviceDiscover", "retryNum", "scanCallback", "Landroid/bluetooth/le/ScanCallback;", "scanFilterBuilder", "Landroid/bluetooth/le/ScanFilter$Builder;", "scanFilterList", "", "Landroid/bluetooth/le/ScanFilter;", "scanSettingBuilder", "Landroid/bluetooth/le/ScanSettings$Builder;", "workHandler", "Landroid/os/Handler;", "buildScanFilters", "", "buildScanSettings", "Landroid/bluetooth/le/ScanSettings;", "checkOtaData", "characteristic", "checkSendTime", "closeGatt", "executeConnect", "mac", "", "executeDisconnect", "executeReadCharacteristic", "uuid", "executeStartScan", "executeStopScan", "executeWrite", "data", "", "executeWriteCharacteristic", "getDeviceStore", "initialize", "context", "isReadyToConnect", "onBluetoothDisable", "readBootLoaderVersion", "receiveData", "value", "refreshConnectState", "refreshDeviceCache", "gatt", "removeDiscoverCallback", "retry", "sendData", "arg1", "setDiscoverCallback", "setNotify", "sleep", "millis", "startBtScan", "isPeriodic", "stopBtScan", "toWrite", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AidexBleAdapter.kt */
public class AidexBleAdapter extends BleAdapter {
    private static final long BLE_CONNECT_TIME_LIMIT = 30000;
    private static final int BLE_CONNECT_TIME_OUT = 1100;
    private static final int BLE_IDLE_DISCONNECT = 1014;
    private static final int CLOSE_GATT = 1006;
    private static final int CONNECT_DISCONNECTED = 1008;
    private static final int CONNECT_FAILURE = 1009;
    private static final int CONNECT_GATT = 1003;
    private static final int CONNECT_SUCCESS = 1010;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DISCONNECT_GATT = 1005;
    private static final int DISCOVER_SERVICES = 1004;
    private static final int DISCOVER_TIME_OUT_SECONDS = 30;
    private static final int FOUND_SERVER = 1012;
    private static final int READ_CHARACTERISTIC = 1013;
    public static final int READ_OTA_CHARACTERISTIC = 1015;
    private static final int RECEIVER_DATA = 2000;
    private static final int SEND_DATA = 1007;
    public static final int START_SCAN = 1001;
    public static final int STOP_SCAN = 1002;
    private static final long TIME_BETWEEN_CONNECT = 2000;
    /* access modifiers changed from: private */
    public final BluetoothDeviceStore bluetoothDeviceStore;
    /* access modifiers changed from: private */
    public final BluetoothGattCallback bluetoothGattCallback;
    /* access modifiers changed from: private */
    public HashMap<Integer, BluetoothGattCharacteristic> characteristicsMap;
    private Pair<Integer, Integer> connectStatus;
    private boolean isOnConnectState;
    /* access modifiers changed from: private */
    public long lastDisConnectTime;
    /* access modifiers changed from: private */
    public BluetoothDevice mBluetoothDevice;
    /* access modifiers changed from: private */
    public BluetoothGatt mBluetoothGatt;
    /* access modifiers changed from: private */
    public BluetoothGattCharacteristic mCharacteristic;
    private Context mContext;
    private long mLastSendDataTime;
    private Function1<? super Pair<Integer, Integer>, Unit> onConnectStateChangeCallback;
    private Function1<? super BleControllerInfo, Unit> onDeviceDiscover;
    /* access modifiers changed from: private */
    public int retryNum;
    private final ScanCallback scanCallback;
    private ScanFilter.Builder scanFilterBuilder;
    private List<ScanFilter> scanFilterList;
    private ScanSettings.Builder scanSettingBuilder;
    /* access modifiers changed from: private */
    public Handler workHandler;

    public /* synthetic */ AidexBleAdapter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AidexBleAdapter() {
        this.connectStatus = new Pair<>(-1, -1);
        this.bluetoothDeviceStore = new BluetoothDeviceStore();
        this.characteristicsMap = new HashMap<>();
        this.scanCallback = new AidexBleAdapter$scanCallback$1(this);
        this.bluetoothGattCallback = new AidexBleAdapter$bluetoothGattCallback$1(this);
    }

    public /* bridge */ /* synthetic */ void startBtScan(Boolean bool) {
        startBtScan(bool.booleanValue());
    }

    public /* bridge */ /* synthetic */ void stopBtScan(Boolean bool) {
        stopBtScan(bool.booleanValue());
    }

    public final Pair<Integer, Integer> getConnectStatus() {
        return this.connectStatus;
    }

    public final void setConnectStatus(Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.connectStatus = pair;
    }

    public final Function1<BleControllerInfo, Unit> getOnDeviceDiscover() {
        return this.onDeviceDiscover;
    }

    public final void setOnDeviceDiscover(Function1<? super BleControllerInfo, Unit> function1) {
        this.onDeviceDiscover = function1;
    }

    public final boolean isOnConnectState() {
        return this.isOnConnectState;
    }

    public final void setOnConnectState(boolean z) {
        this.isOnConnectState = z;
    }

    private final BluetoothAdapter getBluetoothAdapter() {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Object systemService = context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        Intrinsics.checkNotNullExpressionValue(adapter, "getAdapter(...)");
        return adapter;
    }

    public final Function1<Pair<Integer, Integer>, Unit> getOnConnectStateChangeCallback() {
        return this.onConnectStateChangeCallback;
    }

    public final void setOnConnectStateChangeCallback(Function1<? super Pair<Integer, Integer>, Unit> function1) {
        this.onConnectStateChangeCallback = function1;
    }

    public BluetoothDeviceStore getDeviceStore() {
        return this.bluetoothDeviceStore;
    }

    public void setDiscoverCallback() {
        BleController.setDiscoveredCallback(new AidexBleAdapter$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void setDiscoverCallback$lambda$0(AidexBleAdapter aidexBleAdapter, BleControllerInfo bleControllerInfo) {
        Intrinsics.checkNotNullParameter(aidexBleAdapter, "this$0");
        Function1<? super BleControllerInfo, Unit> function1 = aidexBleAdapter.onDeviceDiscover;
        if (function1 != null) {
            Intrinsics.checkNotNull(bleControllerInfo);
            function1.invoke(bleControllerInfo);
        }
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel != null && deviceModel.isPaired() && StringsKt.equals(bleControllerInfo.sn, deviceModel.getEntity().getDeviceSn(), true)) {
            LogUtil.Companion.eAiDEX("Found specific device sn:" + bleControllerInfo.sn + " rssi:" + bleControllerInfo.rssi + " add=" + deviceModel.getEntity().getDeviceMac());
            deviceModel.setLatestAdTime(SystemClock.elapsedRealtime());
            deviceModel.setSignalLostFlag(SystemClock.elapsedRealtime());
        }
    }

    public final void removeDiscoverCallback() {
        this.onDeviceDiscover = null;
    }

    public final void refreshConnectState(boolean z) {
        this.isOnConnectState = z;
        LogUtil.Companion.eAiDEX("refreshConnectState isOnConnectState:" + this.isOnConnectState);
    }

    public final AidexBleAdapter initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        setDiscoverTimeoutSeconds(30);
        this.workHandler = new AidexBleAdapter$initialize$1(this, context, context.getMainLooper());
        return this;
    }

    /* access modifiers changed from: private */
    public final void setNotify(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt);
        if (bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
            for (BluetoothGattDescriptor next : bluetoothGattCharacteristic.getDescriptors()) {
                if ((bluetoothGattCharacteristic.getProperties() & 16) != 0) {
                    if (Build.VERSION.SDK_INT < 33 || ActivityUtil.INSTANCE.isColorOS()) {
                        next.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt2);
                        bluetoothGatt2.writeDescriptor(next);
                    } else {
                        BluetoothGatt bluetoothGatt3 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt3);
                        bluetoothGatt3.writeDescriptor(next, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void closeGatt() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            refreshDeviceCache(bluetoothGatt);
            BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
            if (bluetoothGatt2 != null) {
                bluetoothGatt2.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a A[Catch:{ Exception -> 0x0015 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refreshDeviceCache(android.bluetooth.BluetoothGatt r7) {
        /*
            r6 = this;
            java.lang.String r0 = "refreshDeviceCache --> result: "
            r1 = 0
            r2 = 0
            if (r7 == 0) goto L_0x0017
            java.lang.Class r3 = r7.getClass()     // Catch:{ Exception -> 0x0015 }
            if (r3 == 0) goto L_0x0017
            java.lang.String r4 = "refresh"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0015 }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r7 = move-exception
            goto L_0x003e
        L_0x0017:
            r3 = r2
        L_0x0018:
            if (r3 == 0) goto L_0x0020
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0015 }
            java.lang.Object r2 = r3.invoke(r7, r1)     // Catch:{ Exception -> 0x0015 }
        L_0x0020:
            java.lang.String r7 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r7)     // Catch:{ Exception -> 0x0015 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0015 }
            boolean r7 = r2.booleanValue()     // Catch:{ Exception -> 0x0015 }
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion     // Catch:{ Exception -> 0x0015 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0015 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0015 }
            java.lang.StringBuilder r7 = r2.append(r7)     // Catch:{ Exception -> 0x0015 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0015 }
            r1.eAiDEX(r7)     // Catch:{ Exception -> 0x0015 }
            goto L_0x0056
        L_0x003e:
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "refreshDeviceCache --> error: "
            r1.<init>(r2)
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r7 = r1.append(r7)
            java.lang.String r7 = r7.toString()
            r0.eAiDEX(r7)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.AidexBleAdapter.refreshDeviceCache(android.bluetooth.BluetoothGatt):void");
    }

    private final void sleep(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void sendData(int i, byte[] bArr) {
        try {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.characteristicsMap.get(Integer.valueOf(i));
            if (bArr.length > 20) {
                int length = bArr.length / 20;
                for (int i2 = 0; i2 < length; i2++) {
                    byte[] bArr2 = new byte[20];
                    System.arraycopy(bArr, i2 * 20, bArr2, 0, 20);
                    sendData(i, bArr2);
                }
                byte[] bArr3 = new byte[(bArr.length % 20)];
                System.arraycopy(bArr, length * 20, bArr3, 0, bArr.length % 20);
                sendData(i, bArr3);
            } else if (bluetoothGattCharacteristic == null) {
                LogUtil.Companion.eAiDEX("send data error --> characteristic is null");
            } else if (this.mBluetoothGatt == null) {
                LogUtil.Companion.eAiDEX("send data error --> gatt is null");
            } else {
                checkSendTime();
                if (Build.VERSION.SDK_INT >= 33) {
                    if ((bluetoothGattCharacteristic.getProperties() & 4) != 0) {
                        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt);
                        bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
                    } else if ((bluetoothGattCharacteristic.getProperties() & 8) != 0) {
                        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
                        Intrinsics.checkNotNull(bluetoothGatt2);
                        bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic, bArr, 2);
                    }
                } else if ((bluetoothGattCharacteristic.getProperties() & 4) != 0) {
                    bluetoothGattCharacteristic.setValue(bArr);
                    bluetoothGattCharacteristic.setWriteType(1);
                    BluetoothGatt bluetoothGatt3 = this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt3);
                    bluetoothGatt3.writeCharacteristic(bluetoothGattCharacteristic);
                } else if ((bluetoothGattCharacteristic.getProperties() & 8) != 0) {
                    bluetoothGattCharacteristic.setValue(bArr);
                    bluetoothGattCharacteristic.setWriteType(2);
                    BluetoothGatt bluetoothGatt4 = this.mBluetoothGatt;
                    Intrinsics.checkNotNull(bluetoothGatt4);
                    bluetoothGatt4.writeCharacteristic(bluetoothGattCharacteristic);
                }
                LogUtil.Companion.eAiDEX("send data --> " + StringUtils.INSTANCE.binaryToHexString(bArr) + ", uuid: " + bluetoothGattCharacteristic.getUuid());
                if (!BuildConfig.keepAlive.booleanValue()) {
                    Handler handler = this.workHandler;
                    if (handler != null) {
                        handler.removeMessages(1014);
                    }
                    Handler handler2 = this.workHandler;
                    if (handler2 != null) {
                        handler2.sendEmptyMessageDelayed(1014, 1500);
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.Companion.eAiDEX("send data error --> " + e);
            e.printStackTrace();
        }
    }

    private final void checkSendTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mLastSendDataTime;
        if (1 <= elapsedRealtime && elapsedRealtime < 20) {
            sleep(((long) 20) - elapsedRealtime);
        }
        this.mLastSendDataTime = SystemClock.elapsedRealtime();
    }

    private final List<ScanFilter> buildScanFilters() {
        if (this.scanFilterList == null) {
            this.scanFilterList = new ArrayList();
            this.scanFilterBuilder = new ScanFilter.Builder();
            ParcelUuid fromString = ParcelUuid.fromString("0000181F-0000-1000-8000-00805F9B34FB");
            ScanFilter.Builder builder = this.scanFilterBuilder;
            if (builder != null) {
                builder.setServiceUuid(fromString);
            }
            List<ScanFilter> list = this.scanFilterList;
            if (list != null) {
                ScanFilter.Builder builder2 = this.scanFilterBuilder;
                Intrinsics.checkNotNull(builder2);
                ScanFilter build = builder2.build();
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                list.add(build);
            }
        }
        List<ScanFilter> list2 = this.scanFilterList;
        Intrinsics.checkNotNull(list2);
        return list2;
    }

    private final ScanSettings buildScanSettings() {
        if (this.scanSettingBuilder == null) {
            ScanSettings.Builder builder = new ScanSettings.Builder();
            this.scanSettingBuilder = builder;
            Intrinsics.checkNotNull(builder);
            builder.setScanMode(2);
            ScanSettings.Builder builder2 = this.scanSettingBuilder;
            Intrinsics.checkNotNull(builder2);
            builder2.setMatchMode(1);
            if (getBluetoothAdapter().isOffloadedScanBatchingSupported()) {
                ScanSettings.Builder builder3 = this.scanSettingBuilder;
                Intrinsics.checkNotNull(builder3);
                builder3.setReportDelay(0);
            }
            ScanSettings.Builder builder4 = this.scanSettingBuilder;
            Intrinsics.checkNotNull(builder4);
            builder4.setCallbackType(1);
        }
        ScanSettings.Builder builder5 = this.scanSettingBuilder;
        Intrinsics.checkNotNull(builder5);
        ScanSettings build = builder5.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public void executeStartScan() {
        startBtScan(true);
    }

    public void startBtScan(boolean z) {
        OneTimeWorkRequest.Builder builder;
        if (UserInfoManager.Companion.instance().isLogin()) {
            LogUtil.Companion.eAiDEX("Start ble scan");
            try {
                if (getBluetoothAdapter().getBluetoothLeScanner() == null) {
                    LogUtil.Companion.eAiDEX("Start scan fail, bluetoothLeScanner is null");
                    if (!this.isOnConnectState && z) {
                        WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1002");
                        if (TransmitterManager.Companion.instance().getDefault() != null) {
                            WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(StopScanWorker.class).setInitialDelay(30, TimeUnit.SECONDS)).addTag("1002")).build());
                        }
                    }
                } else if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(AidexxApp.Companion.getInstance(), "android.permission.BLUETOOTH_SCAN") == 0) {
                    getBluetoothAdapter().getBluetoothLeScanner().startScan(buildScanFilters(), buildScanSettings(), this.scanCallback);
                    if (!this.isOnConnectState && z) {
                        WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1002");
                        if (TransmitterManager.Companion.instance().getDefault() != null) {
                            builder = new OneTimeWorkRequest.Builder(StopScanWorker.class);
                            WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) builder.setInitialDelay(30, TimeUnit.SECONDS)).addTag("1002")).build());
                        }
                    }
                } else {
                    LogUtil.Companion.eAiDEX("Start scan fail, permission denied");
                    if (!this.isOnConnectState && z) {
                        WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1002");
                        if (TransmitterManager.Companion.instance().getDefault() != null) {
                            WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(StopScanWorker.class).setInitialDelay(30, TimeUnit.SECONDS)).addTag("1002")).build());
                        }
                    }
                }
            } catch (Exception e) {
                LogUtil.Companion.eAiDEX("Start scan error --> " + e);
                if (!this.isOnConnectState && z) {
                    WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1002");
                    if (TransmitterManager.Companion.instance().getDefault() != null) {
                        builder = new OneTimeWorkRequest.Builder(StopScanWorker.class);
                    }
                }
            } catch (Throwable th) {
                if (!this.isOnConnectState && z) {
                    WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1002");
                    if (TransmitterManager.Companion.instance().getDefault() != null) {
                        WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(StopScanWorker.class).setInitialDelay(30, TimeUnit.SECONDS)).addTag("1002")).build());
                    }
                }
                throw th;
            }
        }
    }

    public void stopBtScan(boolean z) {
        OneTimeWorkRequest.Builder builder;
        LogUtil.Companion.eAiDEX("Stop ble scan --> periodic:" + z);
        WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1002");
        WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1001");
        BluetoothLeScanner bluetoothLeScanner = getBluetoothAdapter().getBluetoothLeScanner();
        Boolean bool = null;
        try {
            if (getBluetoothAdapter().getBluetoothLeScanner() == null) {
                LogUtil.Companion.eAiDEX("Stop scan fail, bluetoothLeScanner is null");
                DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
                LogUtil.Companion companion = LogUtil.Companion;
                StringBuilder append = new StringBuilder("Stop scan default=").append(deviceModel).append(" default.isPaired()=");
                if (deviceModel != null) {
                    bool = Boolean.valueOf(deviceModel.isPaired());
                }
                companion.eAiDEX(append.append(bool).append(" !isOnConnectState=").append(!this.isOnConnectState).toString());
                if (deviceModel != null && deviceModel.isPaired() && !this.isOnConnectState && z) {
                    WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(StartScanWorker.class).setInitialDelay(2, TimeUnit.SECONDS)).addTag("1001")).build());
                }
            } else if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(AidexxApp.Companion.getInstance(), "android.permission.BLUETOOTH_SCAN") == 0) {
                bluetoothLeScanner.stopScan(this.scanCallback);
                DeviceModel deviceModel2 = TransmitterManager.Companion.instance().getDefault();
                LogUtil.Companion companion2 = LogUtil.Companion;
                StringBuilder append2 = new StringBuilder("Stop scan default=").append(deviceModel2).append(" default.isPaired()=");
                if (deviceModel2 != null) {
                    bool = Boolean.valueOf(deviceModel2.isPaired());
                }
                companion2.eAiDEX(append2.append(bool).append(" !isOnConnectState=").append(!this.isOnConnectState).toString());
                if (deviceModel2 != null && deviceModel2.isPaired() && !this.isOnConnectState && z) {
                    builder = new OneTimeWorkRequest.Builder(StartScanWorker.class);
                    WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) builder.setInitialDelay(2, TimeUnit.SECONDS)).addTag("1001")).build());
                }
            } else {
                LogUtil.Companion.eAiDEX("Stop scan fail, permission denied");
                DeviceModel deviceModel3 = TransmitterManager.Companion.instance().getDefault();
                LogUtil.Companion companion3 = LogUtil.Companion;
                StringBuilder append3 = new StringBuilder("Stop scan default=").append(deviceModel3).append(" default.isPaired()=");
                if (deviceModel3 != null) {
                    bool = Boolean.valueOf(deviceModel3.isPaired());
                }
                companion3.eAiDEX(append3.append(bool).append(" !isOnConnectState=").append(!this.isOnConnectState).toString());
                if (deviceModel3 != null && deviceModel3.isPaired() && !this.isOnConnectState && z) {
                    WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(StartScanWorker.class).setInitialDelay(2, TimeUnit.SECONDS)).addTag("1001")).build());
                }
            }
        } catch (Exception e) {
            LogUtil.Companion.eAiDEX("Stop scan error --> " + e);
            DeviceModel deviceModel4 = TransmitterManager.Companion.instance().getDefault();
            LogUtil.Companion companion4 = LogUtil.Companion;
            StringBuilder append4 = new StringBuilder("Stop scan default=").append(deviceModel4).append(" default.isPaired()=");
            if (deviceModel4 != null) {
                bool = Boolean.valueOf(deviceModel4.isPaired());
            }
            companion4.eAiDEX(append4.append(bool).append(" !isOnConnectState=").append(!this.isOnConnectState).toString());
            if (deviceModel4 != null && deviceModel4.isPaired() && !this.isOnConnectState && z) {
                builder = new OneTimeWorkRequest.Builder(StartScanWorker.class);
            }
        } catch (Throwable th) {
            DeviceModel deviceModel5 = TransmitterManager.Companion.instance().getDefault();
            LogUtil.Companion companion5 = LogUtil.Companion;
            StringBuilder append5 = new StringBuilder("Stop scan default=").append(deviceModel5).append(" default.isPaired()=");
            if (deviceModel5 != null) {
                bool = Boolean.valueOf(deviceModel5.isPaired());
            }
            companion5.eAiDEX(append5.append(bool).append(" !isOnConnectState=").append(!this.isOnConnectState).toString());
            if (deviceModel5 != null && deviceModel5.isPaired() && !this.isOnConnectState && z) {
                WorkManager.getInstance(AidexxApp.Companion.getInstance()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(StartScanWorker.class).setInitialDelay(2, TimeUnit.SECONDS)).addTag("1001")).build());
            }
            throw th;
        }
    }

    public void executeStopScan() {
        stopBtScan(true);
    }

    public boolean isReadyToConnect(String str) {
        Intrinsics.checkNotNullParameter(str, "mac");
        BluetoothDevice bluetoothDevice = this.bluetoothDeviceStore.getDeviceMap().get(str);
        LogUtil.Companion.eAiDEX("Number of devices :" + this.bluetoothDeviceStore.getDeviceMap().keySet().size() + ", Device " + str + " isReadyToConnect: " + (bluetoothDevice != null));
        return bluetoothDevice != null;
    }

    public void executeConnect(String str) {
        Intrinsics.checkNotNullParameter(str, "mac");
        LogUtil.Companion.eAiDEX("executeConnect");
        refreshConnectState(true);
        this.connectStatus = new Pair<>(-1, -1);
        LogUtil.Companion.eAiDEX("Connecting to " + str);
        WorkManager.getInstance(AidexxApp.Companion.getInstance()).cancelAllWorkByTag("1001");
        this.mBluetoothDevice = this.bluetoothDeviceStore.getDeviceMap().get(str);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.lastDisConnectTime;
        if (elapsedRealtime >= 2000) {
            Handler handler = this.workHandler;
            Intrinsics.checkNotNull(handler);
            handler.sendEmptyMessage(1003);
            return;
        }
        Handler handler2 = this.workHandler;
        Intrinsics.checkNotNull(handler2);
        handler2.sendEmptyMessageDelayed(1003, 2000 - elapsedRealtime);
    }

    public void executeDisconnect() {
        LogUtil.Companion.eAiDEX("Disconnecting");
        if (this.mBluetoothGatt != null) {
            Handler handler = this.workHandler;
            if (handler != null) {
                handler.sendEmptyMessage(1005);
                return;
            }
            return;
        }
        LogUtil.Companion.eAiDEX("Gatt is null, call onDisconnected directly");
        refreshConnectState(false);
        onDisconnected();
    }

    public void executeWrite(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        toWrite(bArr, getCharacteristicUUID());
    }

    public void executeWriteCharacteristic(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        toWrite(bArr, i);
    }

    private final void toWrite(byte[] bArr, int i) {
        Message obtain = Message.obtain();
        obtain.what = 1007;
        obtain.obj = bArr;
        obtain.arg1 = i;
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public void executeReadCharacteristic(int i) {
        Message obtain = Message.obtain();
        obtain.what = 1013;
        obtain.arg1 = i;
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public final void readBootLoaderVersion() {
        Message obtain = Message.obtain();
        obtain.what = 1015;
        obtain.obj = OtaManager.Companion.getOTA_CONTROL();
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public final void onBluetoothDisable() {
        Handler handler = this.workHandler;
        if (handler != null) {
            handler.sendEmptyMessage(1008);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r3 = r3.getUuid();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void receiveData(android.bluetooth.BluetoothGattCharacteristic r3, byte[] r4) {
        /*
            r2 = this;
            android.os.Message r0 = android.os.Message.obtain()
            r1 = 2000(0x7d0, float:2.803E-42)
            r0.what = r1
            r0.obj = r4
            if (r3 == 0) goto L_0x0017
            java.util.UUID r3 = r3.getUuid()
            if (r3 == 0) goto L_0x0017
            int r3 = com.microtech.aidexx.common.ExtendsKt.toIntBigEndian(r3)
            goto L_0x0018
        L_0x0017:
            r3 = 0
        L_0x0018:
            r0.arg1 = r3
            android.os.Handler r3 = r2.workHandler
            if (r3 == 0) goto L_0x0021
            r3.sendMessage(r0)
        L_0x0021:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.AidexBleAdapter.receiveData(android.bluetooth.BluetoothGattCharacteristic, byte[]):void");
    }

    /* access modifiers changed from: private */
    public final void retry() {
        this.retryNum++;
        Handler handler = this.workHandler;
        Intrinsics.checkNotNull(handler);
        handler.sendEmptyMessage(1003);
    }

    /* access modifiers changed from: private */
    public final boolean checkOtaData(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic == null) {
            return false;
        }
        boolean areEqual = Intrinsics.areEqual((Object) bluetoothGattCharacteristic.getUuid(), (Object) OtaManager.Companion.getOTA_CONTROL());
        if (!areEqual) {
            return areEqual;
        }
        MessageDistributor.Companion.instance().send(new BleMessage(AidexXOperation.GET_BOOT_VERSION, true, bluetoothGattCharacteristic.getValue()));
        return areEqual;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/ble/AidexBleAdapter$Companion;", "", "()V", "BLE_CONNECT_TIME_LIMIT", "", "BLE_CONNECT_TIME_OUT", "", "BLE_IDLE_DISCONNECT", "CLOSE_GATT", "CONNECT_DISCONNECTED", "CONNECT_FAILURE", "CONNECT_GATT", "CONNECT_SUCCESS", "DISCONNECT_GATT", "DISCOVER_SERVICES", "DISCOVER_TIME_OUT_SECONDS", "FOUND_SERVER", "READ_CHARACTERISTIC", "READ_OTA_CHARACTERISTIC", "RECEIVER_DATA", "SEND_DATA", "START_SCAN", "STOP_SCAN", "TIME_BETWEEN_CONNECT", "getInstance", "Lcom/microtech/aidexx/ble/AidexBleAdapter;", "init", "", "context", "Landroid/content/Context;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AidexBleAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void init(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (BleAdapter.instance == null) {
                BleAdapter.instance = new AidexBleAdapter((DefaultConstructorMarker) null).initialize(context);
            }
        }

        public final AidexBleAdapter getInstance() {
            BleAdapter r0 = BleAdapter.instance;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.microtech.aidexx.ble.AidexBleAdapter");
            return (AidexBleAdapter) r0;
        }
    }
}
