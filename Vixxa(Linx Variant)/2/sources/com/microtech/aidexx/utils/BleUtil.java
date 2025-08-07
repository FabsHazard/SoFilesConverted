package com.microtech.aidexx.utils;

import android.app.Activity;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.ActivityCompat;

public class BleUtil {
    public static void enableBluetooth(Activity activity, int i) {
        if (Build.VERSION.SDK_INT < 31 || ActivityCompat.checkSelfPermission(activity, "android.permission.BLUETOOTH_CONNECT") == 0) {
            activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), i);
        }
    }

    public static boolean isSupportBle(Context context) {
        if (context == null || !context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter() == null) {
            return false;
        }
        return true;
    }

    public static boolean isBleEnable(Context context) {
        if (!isSupportBle(context)) {
            return false;
        }
        return ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled();
    }
}
