package com.microtech.aidexx.utils;

import android.widget.Toast;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/utils/ToastUtil;", "", "()V", "showLong", "", "info", "", "showShort", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ToastUtil.kt */
public final class ToastUtil {
    public static final ToastUtil INSTANCE = new ToastUtil();

    private ToastUtil() {
    }

    public final void showLong(String str) {
        Intrinsics.checkNotNullParameter(str, TransmitterActivityKt.BLE_INFO);
        Toast.makeText(AidexxApp.Companion.getInstance(), str, 1).show();
    }

    public final void showShort(String str) {
        Intrinsics.checkNotNullParameter(str, TransmitterActivityKt.BLE_INFO);
        Toast.makeText(AidexxApp.Companion.getInstance(), str, 0).show();
    }
}
