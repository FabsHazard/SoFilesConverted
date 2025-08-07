package com.huawei.hms.scankit;

import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.o4;

/* compiled from: PreviewCallback */
public class j implements j0.e {
    private d a;

    public j(d dVar) {
        this.a = dVar;
    }

    public void a(byte[] bArr) {
        o4.a("scan-time", "request frame time:" + System.currentTimeMillis());
        this.a.a().obtainMessage(R.id.scankit_decode, bArr).sendToTarget();
    }
}
