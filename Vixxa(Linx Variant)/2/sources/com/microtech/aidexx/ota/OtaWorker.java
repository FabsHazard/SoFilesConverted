package com.microtech.aidexx.ota;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.microtech.aidexx.utils.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\u0003\b\u0016\u0018\u0000 K2\u00020\u0001:\u0001KB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0015J\u0012\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020#H\u0007J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020#H\u0002J\u0012\u00101\u001a\u0004\u0018\u00010/2\u0006\u0010+\u001a\u00020\nH\u0015J\b\u00102\u001a\u00020/H\u0017J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010+\u001a\u00020\nH\u0002J\u0010\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020*H\u0002J\u0010\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020#H\u0002J\u0018\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0012H\u0002J\u0010\u0010<\u001a\u00020*2\u0006\u0010\t\u001a\u00020\nH\u0007J\n\u0010=\u001a\u0004\u0018\u00010!H\u0002J\u0018\u0010>\u001a\u00020*2\u0006\u0010+\u001a\u00020\n2\u0006\u0010?\u001a\u00020@H\u0005J\b\u0010A\u001a\u00020*H\u0002J\u0012\u0010B\u001a\u0004\u0018\u00010/2\u0006\u0010+\u001a\u00020\nH\u0002J\u0018\u0010C\u001a\u00020*2\u0006\u0010+\u001a\u00020\n2\u0006\u0010D\u001a\u00020\bH\u0002J\u0010\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020%H\u0014J\u0018\u0010G\u001a\u00020*2\u0006\u0010+\u001a\u00020\n2\u0006\u0010H\u001a\u00020IH\u0003J\u001a\u0010J\u001a\u0004\u0018\u00010/2\u0006\u0010+\u001a\u00020\n2\u0006\u0010H\u001a\u00020IH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n (*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/microtech/aidexx/ota/OtaWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "attemptTimes", "", "bluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "getContext", "()Landroid/content/Context;", "controlEndRetryTime", "controlStartRetryTime", "handler", "Landroid/os/Handler;", "lastProgress", "", "mBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "mConnectionState", "getMConnectionState", "()I", "setMConnectionState", "(I)V", "mError", "mGattCallback", "Landroid/bluetooth/BluetoothGattCallback;", "mLock", "Ljava/lang/Object;", "mtuDivisible", "otaFile", "", "otaFilePath", "", "otatime", "", "pack", "tag", "kotlin.jvm.PlatformType", "close", "", "gatt", "connect", "address", "connectAndRetry", "Landroidx/work/ListenableWorker$Result;", "mac", "disconnect", "doWork", "getOtaControlCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "handleReliableUploadResponse", "initialize", "log", "msg", "notifyProgress", "state", "progressOrPackSize", "otaWriteDataReliable", "readOtaFile", "refreshDeviceCache", "force", "", "setupMtuDivisible", "startOtaUpload", "terminateConnection", "error", "waitFor", "millis", "writeCommandToOtaControl", "ctrl", "", "writeOtaControl", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaWorker.kt */
public class OtaWorker extends Worker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MSG_CONTROL_END_TIMEOUT = 2;
    private static final int MSG_CONTROL_START_TIMEOUT = 1;
    private static final int MSG_OTA_TIMEOUT = 3;
    private static final int MSG_SEND_DATA_TIMEOUT = 0;
    private static final long TIMEOUT_OTA = 180000;
    private static final long TIMEOUT_WRITE_DATA = 10000;
    private int attemptTimes;
    /* access modifiers changed from: private */
    public BluetoothGatt bluetoothGatt;
    private final Context context;
    /* access modifiers changed from: private */
    public int controlEndRetryTime = 1;
    /* access modifiers changed from: private */
    public int controlStartRetryTime = 2;
    /* access modifiers changed from: private */
    public Handler handler = new OtaWorker$handler$1(this, Looper.getMainLooper());
    private float lastProgress;
    private BluetoothAdapter mBluetoothAdapter;
    private int mConnectionState;
    /* access modifiers changed from: private */
    public int mError;
    private final BluetoothGattCallback mGattCallback;
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private int mtuDivisible;
    private byte[] otaFile;
    private String otaFilePath;
    private long otatime;
    private int pack;
    private final String tag = "OtaWorker";
    private final WorkerParameters workerParams;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OtaWorker(Context context2, WorkerParameters workerParameters) {
        super(context2, workerParameters);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        this.context = context2;
        this.workerParams = workerParameters;
        initialize();
        this.mGattCallback = new OtaWorker$mGattCallback$1(this);
    }

    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final int getMConnectionState() {
        return this.mConnectionState;
    }

    /* access modifiers changed from: protected */
    public final void setMConnectionState(int i) {
        this.mConnectionState = i;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/ota/OtaWorker$Companion;", "", "()V", "MSG_CONTROL_END_TIMEOUT", "", "MSG_CONTROL_START_TIMEOUT", "MSG_OTA_TIMEOUT", "MSG_SEND_DATA_TIMEOUT", "TIMEOUT_OTA", "", "TIMEOUT_WRITE_DATA", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OtaWorker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void log(String str) {
        LogUtil.Companion companion = LogUtil.Companion;
        String str2 = this.tag;
        Intrinsics.checkNotNullExpressionValue(str2, "tag");
        companion.xLogE(str, str2);
    }

    private final void initialize() {
        Object systemService = ContextCompat.getSystemService(this.context, BluetoothManager.class);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter == null) {
            log("OTA --> Unable to obtain a BluetoothAdapter.");
        }
        this.controlStartRetryTime = 2;
    }

    private final ListenableWorker.Result connectAndRetry(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.bluetoothGatt = connect(str);
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        if (this.bluetoothGatt == null) {
            log("OTA --> Bluetooth adapter disabled");
            return ListenableWorker.Result.failure();
        }
        int i = this.mError;
        if (i <= 0) {
            return null;
        }
        if ((32768 & i) > 0) {
            int i2 = i & -32769;
            log("OTA --> Connection error after: " + (elapsedRealtime2 - elapsedRealtime) + " ms");
            if (i2 != 133 || elapsedRealtime2 <= elapsedRealtime + ((long) 25000)) {
                log("OTA --> An error occurred while connecting to the device:" + i2);
            } else {
                log("OTA --> Device not reachable. Check if the device is in range, is advertising and is connectable");
            }
        } else {
            log("OTA --> An error occurred during discovering services:" + (i & -16385));
        }
        if (this.attemptTimes >= 3 || this.mError == 4117) {
            BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            terminateConnection(bluetoothGatt2, this.mError);
            return ListenableWorker.Result.failure();
        }
        if (this.mConnectionState != 0) {
            BluetoothGatt bluetoothGatt3 = this.bluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt3);
            ListenableWorker.Result disconnect = disconnect(bluetoothGatt3);
            if (disconnect != null) {
                return disconnect;
            }
        }
        BluetoothGatt bluetoothGatt4 = this.bluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt4);
        refreshDeviceCache(bluetoothGatt4, true);
        BluetoothGatt bluetoothGatt5 = this.bluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt5);
        close(bluetoothGatt5);
        this.mError = 0;
        this.mConnectionState = 0;
        this.attemptTimes++;
        try {
            Result.Companion companion = Result.Companion;
            Thread.sleep(3000);
            Result.m343constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m343constructorimpl(ResultKt.createFailure(th));
        }
        log("OTA --> Reconnect, " + this.attemptTimes + "/3");
        connectAndRetry(str);
        return null;
    }

    public ListenableWorker.Result doWork() {
        this.handler.sendEmptyMessageDelayed(3, TIMEOUT_OTA);
        log("OTA --> Worker's id " + this);
        String string = this.workerParams.getInputData().getString(OtaWorkerKt.OTA_DEVICE_ADDRESS);
        String string2 = this.workerParams.getInputData().getString(OtaWorkerKt.OTA_UPLOAD_FILE_PATH);
        this.otaFilePath = string2;
        if (string == null) {
            log("OTA --> Device Address is null");
            this.handler.removeCallbacksAndMessages((Object) null);
            ListenableWorker.Result failure = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure, "failure(...)");
            return failure;
        }
        CharSequence charSequence = string2;
        if (charSequence == null || charSequence.length() == 0) {
            log("OTA --> File path is NullOrEmpty");
            this.handler.removeCallbacksAndMessages((Object) null);
            ListenableWorker.Result failure2 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure2, "failure(...)");
            return failure2;
        }
        log("OTA --> File path : " + this.otaFilePath);
        ListenableWorker.Result connectAndRetry = connectAndRetry(string);
        if (connectAndRetry != null) {
            this.handler.removeCallbacksAndMessages((Object) null);
            return connectAndRetry;
        }
        notifyProgress(1, 5.0f);
        if (this.mConnectionState == 0) {
            BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt2);
            terminateConnection(bluetoothGatt2, 4096);
            this.handler.removeCallbacksAndMessages((Object) null);
            ListenableWorker.Result failure3 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure3, "failure(...)");
            return failure3;
        }
        BluetoothGatt bluetoothGatt3 = this.bluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt3);
        if (bluetoothGatt3.getService(OtaManager.Companion.getOTA_SERVICE()) == null) {
            log("OTA --> Ota service not found");
            BluetoothGatt bluetoothGatt4 = this.bluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt4);
            terminateConnection(bluetoothGatt4, OtaWorkerKt.OTA_ERROR_SERVICE_NOT_FOUND);
            this.handler.removeCallbacksAndMessages((Object) null);
            ListenableWorker.Result failure4 = ListenableWorker.Result.failure();
            Intrinsics.checkNotNullExpressionValue(failure4, "failure(...)");
            return failure4;
        }
        notifyProgress(1, 10.0f);
        BluetoothGatt bluetoothGatt5 = this.bluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt5);
        bluetoothGatt5.requestMtu(OtaManagerKt.INITIALIZATION_MTU_VALUE);
        BluetoothGatt bluetoothGatt6 = this.bluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt6);
        ListenableWorker.Result writeOtaControl = writeOtaControl(bluetoothGatt6, (byte) 0);
        if (writeOtaControl != null) {
            this.handler.removeCallbacksAndMessages((Object) null);
            return writeOtaControl;
        }
        notifyProgress(1, 15.0f);
        BluetoothGatt bluetoothGatt7 = this.bluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt7);
        ListenableWorker.Result startOtaUpload = startOtaUpload(bluetoothGatt7);
        if (startOtaUpload != null) {
            this.handler.removeCallbacksAndMessages((Object) null);
            BluetoothGatt bluetoothGatt8 = this.bluetoothGatt;
            Intrinsics.checkNotNull(bluetoothGatt8);
            terminateConnection(bluetoothGatt8, OtaWorkerKt.OTA_ERROR_FILE_SEND_FAIL);
            return startOtaUpload;
        }
        BluetoothGatt bluetoothGatt9 = this.bluetoothGatt;
        Intrinsics.checkNotNull(bluetoothGatt9);
        bluetoothGatt9.disconnect();
        this.handler.removeCallbacksAndMessages((Object) null);
        ListenableWorker.Result success = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success, "success(...)");
        return success;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001d, code lost:
        log("OTA --> writeOtaControl wait() interrupted:" + r2);
        r1.mError = com.microtech.aidexx.ota.OtaWorkerKt.OTA_ERROR_WAIT_UPLOAD_FAIL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        monitor-enter(r1.mLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.mLock.notifyAll();
        r3 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.work.ListenableWorker.Result writeOtaControl(android.bluetooth.BluetoothGatt r2, byte r3) {
        /*
            r1 = this;
            r1.writeCommandToOtaControl(r2, r3)
            java.lang.Object r2 = r1.mLock     // Catch:{ InterruptedException -> 0x001c }
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x001c }
        L_0x0006:
            int r3 = r1.mConnectionState     // Catch:{ all -> 0x0019 }
            r0 = -6
            if (r3 == r0) goto L_0x0015
            int r3 = r1.mError     // Catch:{ all -> 0x0019 }
            if (r3 != 0) goto L_0x0015
            java.lang.Object r3 = r1.mLock     // Catch:{ all -> 0x0019 }
            r3.wait()     // Catch:{ all -> 0x0019 }
            goto L_0x0006
        L_0x0015:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0019 }
            monitor-exit(r2)     // Catch:{ InterruptedException -> 0x001c }
            goto L_0x003e
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ InterruptedException -> 0x001c }
            throw r3     // Catch:{ InterruptedException -> 0x001c }
        L_0x001c:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "OTA --> writeOtaControl wait() interrupted:"
            r3.<init>(r0)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            r1.log(r2)
            r2 = 4103(0x1007, float:5.75E-42)
            r1.mError = r2
            java.lang.Object r2 = r1.mLock
            monitor-enter(r2)
            java.lang.Object r3 = r1.mLock     // Catch:{ all -> 0x0049 }
            r3.notifyAll()     // Catch:{ all -> 0x0049 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0049 }
            monitor-exit(r2)
        L_0x003e:
            int r2 = r1.mError
            if (r2 <= 0) goto L_0x0047
            androidx.work.ListenableWorker$Result r2 = androidx.work.ListenableWorker.Result.failure()
            return r2
        L_0x0047:
            r2 = 0
            return r2
        L_0x0049:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaWorker.writeOtaControl(android.bluetooth.BluetoothGatt, byte):androidx.work.ListenableWorker$Result");
    }

    /* access modifiers changed from: private */
    public final void writeCommandToOtaControl(BluetoothGatt bluetoothGatt2, byte b) {
        long j = b == 0 ? 200 : b == 3 ? 500 : 0;
        log("OTA --> Write ota control: controlDelay=" + j);
        BluetoothGattCharacteristic otaControlCharacteristic = getOtaControlCharacteristic(bluetoothGatt2);
        if (otaControlCharacteristic != null) {
            otaControlCharacteristic.setWriteType(2);
            otaControlCharacteristic.setValue(new byte[]{b});
        } else {
            otaControlCharacteristic = null;
        }
        log("OTA --> Write ota control start");
        this.handler.postDelayed(new OtaWorker$$ExternalSyntheticLambda0(this, b, bluetoothGatt2, otaControlCharacteristic), j);
    }

    /* access modifiers changed from: private */
    public static final void writeCommandToOtaControl$lambda$9$lambda$8(OtaWorker otaWorker, byte b, BluetoothGatt bluetoothGatt2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intrinsics.checkNotNullParameter(otaWorker, "this$0");
        Intrinsics.checkNotNullParameter(bluetoothGatt2, "$gatt");
        otaWorker.log("OTA --> Write ota control: " + b + " thread=" + Thread.currentThread());
        otaWorker.handler.sendEmptyMessageDelayed(b == 0 ? 1 : 2, 10000);
        bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic);
    }

    private final BluetoothGattCharacteristic getOtaControlCharacteristic(BluetoothGatt bluetoothGatt2) {
        BluetoothGattService service = bluetoothGatt2.getService(OtaManager.Companion.getOTA_SERVICE());
        if (service != null) {
            return service.getCharacteristic(OtaManager.Companion.getOTA_CONTROL());
        }
        return null;
    }

    private final void terminateConnection(BluetoothGatt bluetoothGatt2, int i) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt2);
        }
        refreshDeviceCache(bluetoothGatt2, false);
        close(bluetoothGatt2);
        waitFor(600);
        if (i != 0) {
            log("OTA --> terminateConnection:" + i);
        }
    }

    /* access modifiers changed from: protected */
    public void close(BluetoothGatt bluetoothGatt2) {
        Intrinsics.checkNotNullParameter(bluetoothGatt2, "gatt");
        bluetoothGatt2.disconnect();
        bluetoothGatt2.close();
        this.mConnectionState = -5;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002f, code lost:
        log("OTA --> disconnect wait() interrupted:" + r4);
        r3.mError = com.microtech.aidexx.ota.OtaWorkerKt.OTA_ERROR_WAIT_UNTIL_DISCONNECT_FAIL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        monitor-enter(r3.mLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r3.mLock.notifyAll();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.ListenableWorker.Result disconnect(android.bluetooth.BluetoothGatt r4) {
        /*
            r3 = this;
            java.lang.String r0 = "gatt"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r3.mConnectionState
            r1 = 0
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            r0 = -4
            r3.mConnectionState = r0
            java.lang.String r0 = "OTA --> Disconnecting from the device..."
            r3.log(r0)
            r4.disconnect()
            java.lang.Object r4 = r3.mLock     // Catch:{ InterruptedException -> 0x002e }
            monitor-enter(r4)     // Catch:{ InterruptedException -> 0x002e }
        L_0x0019:
            int r0 = r3.mConnectionState     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0027
            int r0 = r3.mError     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0027
            java.lang.Object r0 = r3.mLock     // Catch:{ all -> 0x002b }
            r0.wait()     // Catch:{ all -> 0x002b }
            goto L_0x0019
        L_0x0027:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002b }
            monitor-exit(r4)     // Catch:{ InterruptedException -> 0x002e }
            goto L_0x0050
        L_0x002b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ InterruptedException -> 0x002e }
            throw r0     // Catch:{ InterruptedException -> 0x002e }
        L_0x002e:
            r4 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "OTA --> disconnect wait() interrupted:"
            r0.<init>(r2)
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            r3.log(r4)
            r4 = 4114(0x1012, float:5.765E-42)
            r3.mError = r4
            java.lang.Object r4 = r3.mLock
            monitor-enter(r4)
            java.lang.Object r0 = r3.mLock     // Catch:{ all -> 0x005a }
            r0.notifyAll()     // Catch:{ all -> 0x005a }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005a }
            monitor-exit(r4)
        L_0x0050:
            int r4 = r3.mError
            if (r4 <= 0) goto L_0x0059
            androidx.work.ListenableWorker$Result r4 = androidx.work.ListenableWorker.Result.failure()
            return r4
        L_0x0059:
            return r1
        L_0x005a:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaWorker.disconnect(android.bluetooth.BluetoothGatt):androidx.work.ListenableWorker$Result");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        log("OTA --> connect wait() interrupted:" + r0);
        r8.mError = com.microtech.aidexx.ota.OtaWorkerKt.OTA_ERROR_WAIT_UNTIL_CONNECT_FAIL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        monitor-enter(r8.mLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r8.mLock.notifyAll();
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.bluetooth.BluetoothGatt connect(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.bluetooth.BluetoothAdapter r0 = r8.mBluetoothAdapter
            if (r0 == 0) goto L_0x0099
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r0 = r0.isEnabled()
            if (r0 != 0) goto L_0x0014
            goto L_0x0099
        L_0x0014:
            r0 = -1
            r8.mConnectionState = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "OTA --> Connecting to the "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            r8.log(r1)
            android.bluetooth.BluetoothAdapter r1 = r8.mBluetoothAdapter
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.bluetooth.BluetoothDevice r2 = r1.getRemoteDevice(r9)
            java.lang.String r9 = "getRemoteDevice(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r9)
            int r9 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r9 < r1) goto L_0x004c
            android.content.Context r3 = r8.context
            android.bluetooth.BluetoothGattCallback r5 = r8.mGattCallback
            r6 = 2
            r7 = 3
            r4 = 0
            android.bluetooth.BluetoothGatt r9 = r2.connectGatt(r3, r4, r5, r6, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            goto L_0x0058
        L_0x004c:
            android.content.Context r9 = r8.context
            r1 = 0
            android.bluetooth.BluetoothGattCallback r3 = r8.mGattCallback
            android.bluetooth.BluetoothGatt r9 = r2.connectGatt(r9, r1, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
        L_0x0058:
            java.lang.Object r1 = r8.mLock     // Catch:{ InterruptedException -> 0x0073 }
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0073 }
        L_0x005b:
            int r2 = r8.mConnectionState     // Catch:{ all -> 0x0070 }
            if (r2 == r0) goto L_0x0062
            r3 = -2
            if (r2 != r3) goto L_0x006c
        L_0x0062:
            int r2 = r8.mError     // Catch:{ all -> 0x0070 }
            if (r2 != 0) goto L_0x006c
            java.lang.Object r2 = r8.mLock     // Catch:{ all -> 0x0070 }
            r2.wait()     // Catch:{ all -> 0x0070 }
            goto L_0x005b
        L_0x006c:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0070 }
            monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0073 }
            goto L_0x0095
        L_0x0070:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ InterruptedException -> 0x0073 }
            throw r0     // Catch:{ InterruptedException -> 0x0073 }
        L_0x0073:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "OTA --> connect wait() interrupted:"
            r1.<init>(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r8.log(r0)
            r0 = 4115(0x1013, float:5.766E-42)
            r8.mError = r0
            java.lang.Object r0 = r8.mLock
            monitor-enter(r0)
            java.lang.Object r1 = r8.mLock     // Catch:{ all -> 0x0096 }
            r1.notifyAll()     // Catch:{ all -> 0x0096 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0096 }
            monitor-exit(r0)
        L_0x0095:
            return r9
        L_0x0096:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        L_0x0099:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaWorker.connect(java.lang.String):android.bluetooth.BluetoothGatt");
    }

    /* access modifiers changed from: private */
    public final void handleReliableUploadResponse(BluetoothGatt bluetoothGatt2) {
        this.handler.removeMessages(0);
        int i = this.pack + this.mtuDivisible;
        this.pack = i;
        notifyProgress(0, (float) i);
        int i2 = this.pack;
        byte[] bArr = this.otaFile;
        Integer num = null;
        Integer valueOf = bArr != null ? Integer.valueOf(bArr.length) : null;
        Intrinsics.checkNotNull(valueOf);
        if (i2 <= valueOf.intValue() - 1) {
            otaWriteDataReliable(bluetoothGatt2);
            return;
        }
        int i3 = this.pack;
        byte[] bArr2 = this.otaFile;
        if (bArr2 != null) {
            num = Integer.valueOf(bArr2.length);
        }
        Intrinsics.checkNotNull(num);
        if (i3 > num.intValue() - 1) {
            writeOtaControl(bluetoothGatt2, (byte) 3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        log("OTA --> upload wait() interrupted:" + r3);
        r2.mError = com.microtech.aidexx.ota.OtaWorkerKt.OTA_ERROR_WAIT_UPLOAD_FAIL;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        monitor-enter(r2.mLock);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.mLock.notifyAll();
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.work.ListenableWorker.Result startOtaUpload(android.bluetooth.BluetoothGatt r3) {
        /*
            r2 = this;
            r0 = 0
            r2.lastProgress = r0
            byte[] r0 = r2.readOtaFile()
            r2.otaFile = r0
            r0 = 0
            r2.pack = r0
            r2.setupMtuDivisible()
            r2.otaWriteDataReliable(r3)
            java.lang.Object r3 = r2.mLock     // Catch:{ InterruptedException -> 0x002b }
            monitor-enter(r3)     // Catch:{ InterruptedException -> 0x002b }
        L_0x0015:
            int r0 = r2.mConnectionState     // Catch:{ all -> 0x0028 }
            r1 = -7
            if (r0 == r1) goto L_0x0024
            int r0 = r2.mError     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0024
            java.lang.Object r0 = r2.mLock     // Catch:{ all -> 0x0028 }
            r0.wait()     // Catch:{ all -> 0x0028 }
            goto L_0x0015
        L_0x0024:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)     // Catch:{ InterruptedException -> 0x002b }
            goto L_0x004d
        L_0x0028:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ InterruptedException -> 0x002b }
            throw r0     // Catch:{ InterruptedException -> 0x002b }
        L_0x002b:
            r3 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "OTA --> upload wait() interrupted:"
            r0.<init>(r1)
            java.lang.StringBuilder r3 = r0.append(r3)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            r3 = 4103(0x1007, float:5.75E-42)
            r2.mError = r3
            java.lang.Object r3 = r2.mLock
            monitor-enter(r3)
            java.lang.Object r0 = r2.mLock     // Catch:{ all -> 0x006c }
            r0.notifyAll()     // Catch:{ all -> 0x006c }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006c }
            monitor-exit(r3)
        L_0x004d:
            int r3 = r2.mError
            if (r3 <= 0) goto L_0x006a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r0 = "OTA --> upload error occurred mError="
            r3.<init>(r0)
            int r0 = r2.mError
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2.log(r3)
            androidx.work.ListenableWorker$Result r3 = androidx.work.ListenableWorker.Result.failure()
            return r3
        L_0x006a:
            r3 = 0
            return r3
        L_0x006c:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaWorker.startOtaUpload(android.bluetooth.BluetoothGatt):androidx.work.ListenableWorker$Result");
    }

    private final byte[] readOtaFile() {
        try {
            log("read ota file:" + this.otaFilePath);
            String str = this.otaFilePath;
            FileInputStream fileInputStream = new FileInputStream(str != null ? new File(str) : null);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (Exception e) {
            log("Couldn't open file:" + e);
            this.mError = OtaWorkerKt.OTA_ERROR_READ_FILE_FAIL;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
                Unit unit = Unit.INSTANCE;
                return null;
            }
        }
    }

    private final void setupMtuDivisible() {
        int i;
        int i2 = 0;
        do {
            i = 244 - i2;
            this.mtuDivisible = i;
            i2++;
        } while (i % 4 != 0);
    }

    public final synchronized void otaWriteDataReliable(BluetoothGatt bluetoothGatt2) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(bluetoothGatt2, "bluetoothGatt");
        byte[] bArr2 = this.otaFile;
        if (bArr2 != null) {
            int i = this.pack;
            int i2 = this.mtuDivisible;
            if (i + i2 > bArr2.length - 1) {
                int length = bArr2.length - i;
                int i3 = 0;
                do {
                    length += i3;
                    i3++;
                } while (length % 4 != 0);
                bArr = new byte[length];
                int i4 = this.pack;
                int i5 = length + i4;
                int i6 = 0;
                while (i4 < i5) {
                    int i7 = i6 + 1;
                    if (bArr2.length - 1 < i4) {
                        bArr[i6] = -1;
                    } else {
                        bArr[i6] = bArr2[i4];
                    }
                    i4++;
                    i6 = i7;
                }
            } else {
                byte[] bArr3 = new byte[i2];
                int i8 = i2 + i;
                int i9 = 0;
                while (i < i8) {
                    bArr3[i9] = bArr2[i];
                    i++;
                    i9++;
                }
                bArr = bArr3;
            }
            BluetoothGattService service = bluetoothGatt2.getService(OtaManager.Companion.getOTA_SERVICE());
            UUID uuid = null;
            BluetoothGattCharacteristic characteristic = service != null ? service.getCharacteristic(OtaManager.Companion.getOTA_DATA()) : null;
            if (characteristic != null) {
                characteristic.setWriteType(2);
            }
            if (characteristic != null) {
                characteristic.setValue(bArr);
            }
            this.handler.sendEmptyMessageDelayed(0, 10000);
            bluetoothGatt2.writeCharacteristic(characteristic);
            float currentTimeMillis = ((((float) 8) * ((float) this.pack)) / 1024.0f) / (((float) (System.currentTimeMillis() - this.otatime)) / 1000.0f);
            StringBuilder append = new StringBuilder().append("OTA --> write uuid:");
            if (characteristic != null) {
                uuid = characteristic.getUuid();
            }
            log(append.append(uuid).append(", data:").append(ArraysKt.first(bArr)).append("..").append(ArraysKt.last(bArr)).append(" b=").append(currentTimeMillis).toString());
            if (this.pack == 0) {
                this.otatime = System.currentTimeMillis();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void waitFor(long j) {
        synchronized (this.mLock) {
            try {
                this.mLock.wait(j);
            } catch (InterruptedException e) {
                log("OTA --> waitFor() interrupted:" + e);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: protected */
    public final void refreshDeviceCache(BluetoothGatt bluetoothGatt2, boolean z) {
        Intrinsics.checkNotNullParameter(bluetoothGatt2, "gatt");
        if (z || bluetoothGatt2.getDevice().getBondState() == 10) {
            try {
                Object invoke = bluetoothGatt2.getClass().getMethod("refresh", new Class[0]).invoke(bluetoothGatt2, new Object[0]);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
                log("OTA --> refresh device cache result: " + ((Boolean) invoke).booleanValue());
            } catch (Exception e) {
                log("OTA --> An exception occurred while refreshing device " + e);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void notifyProgress(int i, float f) {
        if (i == 0) {
            byte[] bArr = this.otaFile;
            if (bArr != null) {
                float f2 = 100.0f;
                if (f < ((float) bArr.length)) {
                    f2 = 100.0f * (f / ((float) bArr.length));
                }
                double d = (((double) f2) * 0.8d) + ((double) 15);
                if (((double) this.lastProgress) < d) {
                    this.lastProgress = (float) d;
                    setProgressAsync(new Data.Builder().putInt("progress", (int) this.lastProgress).putFloat("bitrate", ((f * 8.0f) / 1024.0f) / ((float) ((System.currentTimeMillis() - this.otatime) / ((long) 1000)))).build());
                }
            }
        } else if (i == 1 && this.lastProgress < f) {
            this.lastProgress = f;
            setProgressAsync(new Data.Builder().putInt("progress", (int) this.lastProgress).build());
        }
    }
}
