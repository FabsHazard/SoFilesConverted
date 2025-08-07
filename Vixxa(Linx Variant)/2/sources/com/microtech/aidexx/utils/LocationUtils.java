package com.microtech.aidexx.utils;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/utils/LocationUtils;", "", "()V", "enableLocationService", "", "context", "Landroid/content/Context;", "isLocationServiceEnable", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationUtils.kt */
public final class LocationUtils {
    public static final LocationUtils INSTANCE = new LocationUtils();

    private LocationUtils() {
    }

    public final boolean isLocationServiceEnable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    public final void enableLocationService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.putExtra("extra_prefs_show_button_bar", true);
        context.startActivity(intent);
    }
}
