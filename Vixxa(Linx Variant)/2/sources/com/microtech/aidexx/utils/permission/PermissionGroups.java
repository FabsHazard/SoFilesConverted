package com.microtech.aidexx.utils.permission;

import android.app.Activity;
import android.os.Build;
import com.microtech.aidexx.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0015R\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/utils/permission/PermissionGroups;", "", "()V", "Bluetooth", "", "", "getBluetooth", "()[Ljava/lang/String;", "[Ljava/lang/String;", "CallPhone", "getCallPhone", "Camera", "getCamera", "Location", "getLocation", "Storage", "getStorage", "getFuncToPermission", "context", "Landroid/app/Activity;", "permissions", "(Landroid/app/Activity;[Ljava/lang/String;)Ljava/lang/String;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionGroups.kt */
public final class PermissionGroups {
    private static final String[] Bluetooth = {"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    private static final String[] CallPhone = {"android.permission.CALL_PHONE"};
    private static final String[] Camera = {"android.permission.CAMERA"};
    public static final PermissionGroups INSTANCE = new PermissionGroups();
    private static final String[] Location = (Build.VERSION.SDK_INT <= 28 ? new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"} : new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
    private static final String[] Storage = (Build.VERSION.SDK_INT > 32 ? new String[]{"android.permission.READ_MEDIA_IMAGES"} : Build.VERSION.SDK_INT > 28 ? new String[]{"android.permission.READ_EXTERNAL_STORAGE"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});

    private PermissionGroups() {
    }

    public final String[] getCallPhone() {
        return CallPhone;
    }

    public final String[] getStorage() {
        return Storage;
    }

    public final String[] getCamera() {
        return Camera;
    }

    public final String[] getBluetooth() {
        return Bluetooth;
    }

    public final String[] getLocation() {
        return Location;
    }

    public final String getFuncToPermission(Activity activity, String[] strArr) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        if (Arrays.equals(CallPhone, strArr)) {
            String string = activity.getString(R.string.permission_name_phoneCall);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (Arrays.equals(Camera, strArr)) {
            String string2 = activity.getString(R.string.permission_item_camera);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        } else if (Arrays.equals(Storage, strArr)) {
            String string3 = activity.getString(R.string.permission_item_storage);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        } else if (Build.VERSION.SDK_INT >= 31) {
            if (!Arrays.equals(Bluetooth, strArr)) {
                return "";
            }
            String string4 = activity.getString(R.string.permission_name_bluetooth);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        } else if (!Arrays.equals(Location, strArr)) {
            return "";
        } else {
            String string5 = activity.getString(R.string.permission_name_bluetooth);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
    }
}
