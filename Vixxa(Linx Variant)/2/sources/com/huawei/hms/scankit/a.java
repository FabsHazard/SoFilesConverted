package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.f5;
import com.huawei.hms.scankit.p.i8;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.s6;
import com.huawei.hms.scankit.p.u6;
import com.huawei.hms.scankit.p.v5;
import com.huawei.hms.scankit.p.v6;
import java.util.Collection;
import java.util.Map;

/* compiled from: CaptureHandler */
public class a extends Handler implements v6 {
    private final f5 a;
    private d b;
    private final int c;
    private C0004a d = C0004a.b;
    private Context e;
    private final j0 f;
    private final ViewfinderView g;
    private boolean h;
    private boolean i;
    private boolean j;
    private e5 k;
    private boolean l;

    /* renamed from: com.huawei.hms.scankit.a$a  reason: collision with other inner class name */
    /* compiled from: CaptureHandler */
    private enum C0004a {
        PREVIEW,
        b,
        DONE
    }

    a(Context context, ViewfinderView viewfinderView, f5 f5Var, Collection<BarcodeFormat> collection, Map<l1, ?> map, String str, j0 j0Var, Rect rect, int i2, boolean z, boolean z2) {
        j0 j0Var2 = j0Var;
        this.g = viewfinderView;
        this.a = f5Var;
        this.c = i2;
        Context context2 = context;
        this.e = context2;
        d dVar = new d(context2, j0Var, this, collection, map, str, this);
        this.b = dVar;
        dVar.a(rect);
        this.b.a(z2);
        this.b.start();
        this.l = z;
        j0Var2.a((j0.e) new j(this.b));
        this.f = j0Var2;
        j0Var.p();
        o4.a("scan-time", "start preview time:" + System.currentTimeMillis());
        f();
        v5.a((s6) null);
    }

    public void a(e5 e5Var) {
        this.k = e5Var;
    }

    public int b() {
        return this.c;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public boolean d() {
        return this.j;
    }

    public void e() {
        this.d = C0004a.DONE;
        this.f.q();
        Message.obtain(this.b.a(), R.id.scankit_quit).sendToTarget();
        try {
            this.b.b();
            this.b.join(50);
        } catch (InterruptedException unused) {
            o4.d("CaptureHandler", "quitSynchronously   wait interrupt");
        }
        this.b = null;
        removeMessages(R.id.scankit_decode_succeeded);
        removeMessages(R.id.scankit_decode_failed);
    }

    public void f() {
        if (this.d == C0004a.b) {
            this.d = C0004a.PREVIEW;
            this.f.o();
        }
    }

    public void handleMessage(Message message) {
        HmsScan hmsScan;
        int i2 = message.what;
        if (i2 == R.id.scankit_restart_preview) {
            f();
        } else if (i2 == R.id.scankit_decode_succeeded) {
            this.d = C0004a.b;
            Object obj = message.obj;
            if (obj instanceof HmsScan[]) {
                HmsScan[] hmsScanArr = (HmsScan[]) obj;
                if (hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.originalValue)) {
                    o4.c("CaptureHandler", "retrieve  HmsScan lenth is 0");
                } else {
                    o4.c("CaptureHandler", "scan successful");
                    Bitmap bitmap = null;
                    float f2 = 0.0f;
                    if (this.i) {
                        o4.c("CaptureHandler", "scan successful & return bitmap");
                        Bundle data = message.getData();
                        if (data != null) {
                            byte[] byteArray = data.getByteArray("barcode_bitmap");
                            f2 = data.getFloat("barcode_scaled_factor", 0.0f);
                            if (byteArray != null && byteArray.length > 0) {
                                bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                            }
                        }
                        this.a.a(hmsScanArr, bitmap, f2);
                    } else {
                        this.a.a(hmsScanArr, (Bitmap) null, 0.0f);
                    }
                    if (!this.l) {
                        return;
                    }
                }
                f();
            }
        } else if (i2 == R.id.scankit_decode_failed) {
            this.d = C0004a.PREVIEW;
            this.f.o();
        }
    }

    private u6 b(u6 u6Var) {
        float f2;
        float f3;
        int i2;
        Point b2 = i8.b(this.e);
        Point e2 = this.f.e();
        int i3 = b2.x;
        int i4 = b2.y;
        if (i3 < i4) {
            float f4 = (((float) i4) * 1.0f) / ((float) e2.x);
            f3 = (u6Var.b() * ((((float) i3) * 1.0f) / ((float) e2.y))) - (((float) Math.max(b2.x, e2.y)) / 2.0f);
            f2 = u6Var.c() * f4;
            i2 = Math.min(b2.y, e2.x);
        } else {
            float f5 = (((float) i4) * 1.0f) / ((float) e2.y);
            f3 = (u6Var.b() * ((((float) i3) * 1.0f) / ((float) e2.x))) - (((float) Math.min(b2.y, e2.y)) / 2.0f);
            f2 = u6Var.c() * f5;
            i2 = Math.max(b2.x, e2.x);
        }
        return new u6(f3, f2 - (((float) i2) / 2.0f));
    }

    public boolean a() {
        e5 e5Var = this.k;
        if (e5Var != null) {
            return e5Var.a();
        }
        return false;
    }

    public boolean c() {
        return this.i;
    }

    public void a(u6 u6Var) {
        if (this.g != null) {
            this.g.a(b(u6Var));
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void b(boolean z) {
        this.j = z;
    }
}
