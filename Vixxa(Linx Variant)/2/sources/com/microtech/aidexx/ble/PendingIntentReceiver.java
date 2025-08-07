package com.microtech.aidexx.ble;

import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public class PendingIntentReceiver extends BroadcastReceiver {
    public static final String ACTION = "no.nordicsemi.android.support.v18.ACTION_FOUND";
    public static final int REQUEST_CODE = 2004;

    public void onReceive(Context context, Intent intent) {
        intent.getIntExtra("android.bluetooth.le.extra.ERROR_CODE", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT");
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            ScanResult scanResult = (ScanResult) parcelableArrayListExtra.get(0);
        }
    }
}
