package com.microtech.aidexx.ble;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.utils.LogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0017¨\u0006\n"}, d2 = {"com/microtech/aidexx/ble/AidexBleAdapter$scanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "onScanFailed", "", "errorCode", "", "onScanResult", "callbackType", "result", "Landroid/bluetooth/le/ScanResult;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AidexBleAdapter.kt */
public final class AidexBleAdapter$scanCallback$1 extends ScanCallback {
    final /* synthetic */ AidexBleAdapter this$0;

    AidexBleAdapter$scanCallback$1(AidexBleAdapter aidexBleAdapter) {
        this.this$0 = aidexBleAdapter;
    }

    public void onScanResult(int i, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, WiseOpenHianalyticsData.UNION_RESULT);
        super.onScanResult(i, scanResult);
        ScanRecord scanRecord = scanResult.getScanRecord();
        String str = null;
        byte[] bytes = scanRecord != null ? scanRecord.getBytes() : null;
        String address = scanResult.getDevice().getAddress();
        int rssi = scanResult.getRssi();
        ScanRecord scanRecord2 = scanResult.getScanRecord();
        String deviceName = scanRecord2 != null ? scanRecord2.getDeviceName() : null;
        List split$default = deviceName != null ? StringsKt.split$default((CharSequence) deviceName, new String[]{"-"}, false, 0, 6, (Object) null) : null;
        if (split$default != null) {
            str = (String) split$default.get(0);
        }
        if (Intrinsics.areEqual((Object) str, (Object) DeviceModelKt.NAME_RXC) || Intrinsics.areEqual((Object) str, (Object) DeviceModelKt.NAME_RXT)) {
            this.this$0.bluetoothDeviceStore.add(scanResult.getDevice());
            LogUtil.Companion.eAiDEX("ScanCallback : " + deviceName);
            this.this$0.onAdvertiseWithAndroidRawBytes(address, rssi, bytes);
        }
    }

    public void onScanFailed(int i) {
        super.onScanFailed(i);
        LogUtil.Companion.eAiDEX("onScanFailed errorCode:" + i);
    }
}
