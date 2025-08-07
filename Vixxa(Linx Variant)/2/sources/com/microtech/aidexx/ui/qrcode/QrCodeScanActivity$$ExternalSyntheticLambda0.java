package com.microtech.aidexx.ui.qrcode;

import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QrCodeScanActivity$$ExternalSyntheticLambda0 implements OnResultCallback {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ QrCodeScanActivity f$2;

    public /* synthetic */ QrCodeScanActivity$$ExternalSyntheticLambda0(Ref.BooleanRef booleanRef, int i, QrCodeScanActivity qrCodeScanActivity) {
        this.f$0 = booleanRef;
        this.f$1 = i;
        this.f$2 = qrCodeScanActivity;
    }

    public final void onResult(HmsScan[] hmsScanArr) {
        QrCodeScanActivity.initView$lambda$2(this.f$0, this.f$1, this.f$2, hmsScanArr);
    }
}
