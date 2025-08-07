package com.microtech.aidexx.ui.qrcode;

import android.os.Bundle;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: QrCodeScanActivity.kt */
final class QrCodeScanActivity$onCreate$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bundle $savedInstanceState;
    final /* synthetic */ QrCodeScanActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QrCodeScanActivity$onCreate$2(QrCodeScanActivity qrCodeScanActivity, Bundle bundle) {
        super(0);
        this.this$0 = qrCodeScanActivity;
        this.$savedInstanceState = bundle;
    }

    public final void invoke() {
        String[] camera = PermissionGroups.INSTANCE.getCamera();
        final QrCodeScanActivity qrCodeScanActivity = this.this$0;
        final Bundle bundle = this.$savedInstanceState;
        PermissionsUtil.INSTANCE.requestPermissions(this.this$0, camera, new Function0<Unit>() {
            public final void invoke() {
                QrCodeScanActivity qrCodeScanActivity = qrCodeScanActivity;
                qrCodeScanActivity.initView(bundle, qrCodeScanActivity.resultType);
            }
        });
    }
}
