package com.microtech.aidexx.ota;

import android.bluetooth.BluetoothGatt;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ota/OtaWorker$handler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaWorker.kt */
public final class OtaWorker$handler$1 extends Handler {
    final /* synthetic */ OtaWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaWorker$handler$1(OtaWorker otaWorker, Looper looper) {
        super(looper);
        this.this$0 = otaWorker;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        int i = message.what;
        if (i == 0) {
            this.this$0.log("send data timeout");
            this.this$0.mError = OtaWorkerKt.OTA_ERROR_SEND_DATA_TIMEOUT;
            Object access$getMLock$p = this.this$0.mLock;
            OtaWorker otaWorker = this.this$0;
            synchronized (access$getMLock$p) {
                otaWorker.mLock.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
        } else if (i == 1) {
            new Thread(new OtaWorker$handler$1$$ExternalSyntheticLambda0(this.this$0, this)).start();
        } else if (i == 2) {
            new Thread(new OtaWorker$handler$1$$ExternalSyntheticLambda1(this.this$0, this)).start();
        } else if (i == 3) {
            this.this$0.log("ota 3mis timeout");
            this.this$0.mError = OtaWorkerKt.OTA_ERROR_OTA_TIMEOUT;
            Object access$getMLock$p2 = this.this$0.mLock;
            OtaWorker otaWorker2 = this.this$0;
            synchronized (access$getMLock$p2) {
                otaWorker2.mLock.notifyAll();
                Unit unit2 = Unit.INSTANCE;
            }
            CharSequence otaInfo = MmkvManager.INSTANCE.getOtaInfo();
            if (otaInfo.length() == 0) {
                otaInfo = null;
            }
            String str = (String) otaInfo;
            if (str != null) {
                Gson gson = new Gson();
                OtaInfo otaInfo2 = (OtaInfo) gson.fromJson(str, OtaInfo.class);
                otaInfo2.setRemark("3_min_timeout");
                MmkvManager mmkvManager = MmkvManager.INSTANCE;
                String json = gson.toJson((Object) otaInfo2);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                mmkvManager.setOtaInfo(json);
            }
        }
        super.handleMessage(message);
    }

    /* access modifiers changed from: private */
    public static final void handleMessage$lambda$5(OtaWorker otaWorker, OtaWorker$handler$1 otaWorker$handler$1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(otaWorker, "this$0");
        Intrinsics.checkNotNullParameter(otaWorker$handler$1, "this$1");
        otaWorker.log("control start command timeout retryTime=" + otaWorker.controlStartRetryTime);
        BluetoothGatt access$getBluetoothGatt$p = otaWorker.bluetoothGatt;
        if (access$getBluetoothGatt$p != null) {
            otaWorker.controlStartRetryTime = otaWorker.controlStartRetryTime - 1;
            if (otaWorker.controlStartRetryTime >= 0) {
                otaWorker.writeCommandToOtaControl(access$getBluetoothGatt$p, (byte) 0);
            } else {
                otaWorker.mError = OtaWorkerKt.OTA_ERROR_WAIT_UPLOAD_FAIL;
                synchronized (otaWorker.mLock) {
                    otaWorker.mLock.notifyAll();
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            otaWorker.log("bluetoothGatt is null");
            otaWorker.mError = OtaWorkerKt.OTA_ERROR_WAIT_UPLOAD_FAIL;
            synchronized (otaWorker.mLock) {
                otaWorker.mLock.notifyAll();
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void handleMessage$lambda$10(OtaWorker otaWorker, OtaWorker$handler$1 otaWorker$handler$1) {
        Unit unit;
        Intrinsics.checkNotNullParameter(otaWorker, "this$0");
        Intrinsics.checkNotNullParameter(otaWorker$handler$1, "this$1");
        otaWorker.log("control end command timeout retryTime=" + otaWorker.controlEndRetryTime);
        BluetoothGatt access$getBluetoothGatt$p = otaWorker.bluetoothGatt;
        if (access$getBluetoothGatt$p != null) {
            otaWorker.controlEndRetryTime = otaWorker.controlEndRetryTime - 1;
            if (otaWorker.controlEndRetryTime >= 0) {
                otaWorker.writeCommandToOtaControl(access$getBluetoothGatt$p, (byte) 3);
            } else {
                otaWorker.mError = OtaWorkerKt.OTA_ERROR_END_SEND_FAIL;
                synchronized (otaWorker.mLock) {
                    otaWorker.mLock.notifyAll();
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            otaWorker.log("bluetoothGatt is null");
            otaWorker.mError = OtaWorkerKt.OTA_ERROR_END_SEND_FAIL;
            synchronized (otaWorker.mLock) {
                otaWorker.mLock.notifyAll();
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }
}
