package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import com.huawei.hms.scankit.p.j0;

/* compiled from: PreviewCallbackProxy */
public class f6 implements Camera.PreviewCallback {
    private j0.e a;

    public f6(j0.e eVar) {
        this.a = eVar;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        this.a.a(bArr);
    }
}
