package com.microtech.aidexx.ble.device.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.microtech.aidexx.ble.AidexBleAdapter;

public class StopScanWorker extends Worker {
    public StopScanWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        AidexBleAdapter.getInstance().executeStopScan();
        return ListenableWorker.Result.success();
    }
}
