package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.e0;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.f5;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.m0;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.v3;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

/* compiled from: CaptureHelper */
public class b {
    public static final String G = "b";
    public static volatile v3 H;
    public static volatile w3 I;
    private boolean A = false;
    /* access modifiers changed from: private */
    public boolean B = false;
    private boolean C;
    /* access modifiers changed from: private */
    public IOnErrorCallback D;
    private boolean E = true;
    private boolean F = false;
    private final Rect a;
    private final int b;
    private final boolean c;
    /* access modifiers changed from: private */
    public Context d;
    private a e;
    private f5 f;
    /* access modifiers changed from: private */
    public j0 g;
    private ViewfinderView h;
    public TextureView i;
    private TextureView.SurfaceTextureListener j;
    private Collection<BarcodeFormat> k;
    private Map<l1, ?> l;
    private String m;
    /* access modifiers changed from: private */
    public boolean n;
    private String o;
    private boolean p = true;
    private float q;
    private boolean r = true;
    private boolean s = false;
    private boolean t = true;
    private boolean u;
    private boolean v;
    private boolean w;
    private IObjectWrapper x;
    private e5 y;
    private IOnResultCallback z;

    /* compiled from: CaptureHelper */
    class a implements Runnable {
        a() {
        }

        public void run() {
            b.this.g.m();
        }
    }

    /* renamed from: com.huawei.hms.scankit.b$b  reason: collision with other inner class name */
    /* compiled from: CaptureHelper */
    class C0005b implements j0.d {
        C0005b() {
        }

        public void a() {
        }

        public void b() {
            if (b.this.D != null) {
                try {
                    b.this.D.onError(-1000);
                } catch (RemoteException unused) {
                    o4.b(b.G, "RemoteException");
                }
            }
        }

        public void c() {
        }
    }

    /* compiled from: CaptureHelper */
    class c implements TextureView.SurfaceTextureListener {
        c() {
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            boolean unused = b.this.B = false;
            if (surfaceTexture == null) {
                o4.b(b.G, "*** WARNING *** surfaceCreated() gave us a null surface!");
            }
            if (!b.this.n) {
                boolean unused2 = b.this.n = true;
                if (b.this.d.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
                    b bVar = b.this;
                    bVar.a(bVar.i);
                } else if (b.this.d instanceof Activity) {
                    boolean unused3 = b.this.B = true;
                    ((Activity) b.this.d).requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
                }
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            boolean unused = b.this.n = false;
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: CaptureHelper */
    class d implements f5 {
        d() {
        }

        public void a(HmsScan[] hmsScanArr, Bitmap bitmap, float f) {
            b.this.a(hmsScanArr, bitmap);
        }
    }

    public b(Context context, TextureView textureView, ViewfinderView viewfinderView, Rect rect, int i2, IObjectWrapper iObjectWrapper, boolean z2, String str, boolean z3) {
        this.d = context;
        this.h = viewfinderView;
        this.x = iObjectWrapper;
        this.i = textureView;
        this.n = false;
        this.a = rect;
        this.b = i2;
        this.c = z2;
        this.o = str;
        this.C = false;
        this.v = z3;
    }

    private void j() {
        a aVar = this.e;
        if (aVar != null) {
            aVar.e();
            this.e = null;
        }
        this.g.l();
    }

    public void e() {
        this.C = true;
        if (!this.A) {
            j();
        }
    }

    public void f() {
        TextureView textureView;
        TextureView textureView2;
        this.C = false;
        try {
            H = new v3((Bundle) ObjectWrapper.unwrap(this.x), this.o);
            H.h();
        } catch (RuntimeException unused) {
            o4.b(G, "RuntimeException");
        } catch (Exception unused2) {
            o4.b(G, "Exception");
        }
        if (!this.A && !this.n && (textureView2 = this.i) != null) {
            textureView2.setSurfaceTextureListener(this.j);
            if (this.n) {
                a(this.i);
            } else {
                this.i.setSurfaceTextureListener(this.j);
            }
        }
        if (this.B && this.d.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0 && (textureView = this.i) != null) {
            this.B = false;
            a(textureView);
        }
    }

    public void g() {
        this.C = false;
        TextureView textureView = this.i;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(this.j);
            this.A = true;
            if (this.n) {
                a(this.i);
            } else {
                this.i.setSurfaceTextureListener(this.j);
            }
        }
    }

    public void h() {
        this.C = true;
        if (H != null) {
            H.i();
        }
        H = null;
        if (this.A) {
            j();
        }
    }

    public void i() {
        try {
            j0 j0Var = this.g;
            if (j0Var != null) {
                j0Var.d(1);
            }
        } catch (RuntimeException unused) {
            o4.b(G, "RuntimeException in reset zoomValue");
        } catch (Exception unused2) {
            o4.b(G, "Exception in reset zoomValue");
        }
    }

    public void c() {
        this.C = false;
        try {
            I = new w3((Bundle) ObjectWrapper.unwrap(this.x), this.o);
            I.a("single");
        } catch (RuntimeException unused) {
            o4.b(G, "RuntimeException");
        } catch (Exception unused2) {
            o4.b(G, "Exception");
        }
        if (this.d.getPackageManager() == null || this.d.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            e0 a2 = a(this.d);
            Log.i(G, "onCreate: CameraManageOncreate");
            this.g = new j0(this.d, a2);
            new Thread(new a()).start();
            this.g.a((j0.d) new C0005b());
            this.j = new c();
            this.f = new d();
            return;
        }
        Log.e("scankit", "has no camera");
    }

    public void d() {
        this.C = true;
        this.i.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
        this.g.k();
        I.l.b();
        I = null;
    }

    public boolean b(MotionEvent motionEvent) {
        j0 j0Var = this.g;
        if (j0Var == null || !this.p || j0Var.f().a() < j0.c.CAMERA_OPENED.a() || motionEvent.getPointerCount() <= 1) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2) {
            float a2 = a(motionEvent);
            float f2 = this.q;
            if (a2 > f2 + 6.0f) {
                a(true, this.g);
            } else if (a2 < f2 - 6.0f) {
                a(false, this.g);
            } else {
                o4.c("CaptureHelper", "MotionEvent.ACTION_MOVE no handleZoom");
            }
            this.q = a2;
        } else if (action == 5) {
            this.q = a(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:3|4|5|6|7|8|9|(2:11|21)(1:20)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.TextureView r13) {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0086
            android.graphics.SurfaceTexture r0 = r13.getSurfaceTexture()
            if (r0 != 0) goto L_0x000a
            goto L_0x0086
        L_0x000a:
            com.huawei.hms.scankit.p.j0 r0 = r12.g     // Catch:{ Exception -> 0x0072 }
            r0.a((android.view.TextureView) r13)     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.p.j0 r13 = r12.g     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.p.k0$a r0 = new com.huawei.hms.scankit.p.k0$a     // Catch:{ Exception -> 0x0072 }
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ Exception -> 0x0072 }
            r2 = 150(0x96, float:2.1E-43)
            r3 = -150(0xffffffffffffff6a, float:NaN)
            r1.<init>(r3, r3, r2, r2)     // Catch:{ Exception -> 0x0072 }
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0072 }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ Exception -> 0x0072 }
            r13.a((java.util.List<com.huawei.hms.scankit.p.k0.a>) r0)     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.p.j0 r13 = r12.g     // Catch:{ Exception -> 0x002e }
            r13.n()     // Catch:{ Exception -> 0x002e }
            goto L_0x0035
        L_0x002e:
            java.lang.String r13 = G     // Catch:{ Exception -> 0x0072 }
            java.lang.String r0 = "initCamera() get exception"
            com.huawei.hms.scankit.p.o4.b(r13, r0)     // Catch:{ Exception -> 0x0072 }
        L_0x0035:
            com.huawei.hms.scankit.a r13 = r12.e     // Catch:{ Exception -> 0x0072 }
            if (r13 != 0) goto L_0x0085
            com.huawei.hms.scankit.a r13 = new com.huawei.hms.scankit.a     // Catch:{ Exception -> 0x0072 }
            android.content.Context r1 = r12.d     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.ViewfinderView r2 = r12.h     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.p.f5 r3 = r12.f     // Catch:{ Exception -> 0x0072 }
            java.util.Collection<com.huawei.hms.scankit.aiscan.common.BarcodeFormat> r4 = r12.k     // Catch:{ Exception -> 0x0072 }
            java.util.Map<com.huawei.hms.scankit.p.l1, ?> r5 = r12.l     // Catch:{ Exception -> 0x0072 }
            java.lang.String r6 = r12.m     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.p.j0 r7 = r12.g     // Catch:{ Exception -> 0x0072 }
            android.graphics.Rect r8 = r12.a     // Catch:{ Exception -> 0x0072 }
            int r9 = r12.b     // Catch:{ Exception -> 0x0072 }
            boolean r10 = r12.v     // Catch:{ Exception -> 0x0072 }
            boolean r11 = r12.E     // Catch:{ Exception -> 0x0072 }
            r0 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0072 }
            r12.e = r13     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r12.u     // Catch:{ Exception -> 0x0072 }
            r13.c(r0)     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.a r13 = r12.e     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r12.w     // Catch:{ Exception -> 0x0072 }
            r13.a((boolean) r0)     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.a r13 = r12.e     // Catch:{ Exception -> 0x0072 }
            boolean r0 = r12.r     // Catch:{ Exception -> 0x0072 }
            r13.b((boolean) r0)     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.a r13 = r12.e     // Catch:{ Exception -> 0x0072 }
            com.huawei.hms.scankit.p.e5 r0 = r12.y     // Catch:{ Exception -> 0x0072 }
            r13.a((com.huawei.hms.scankit.p.e5) r0)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0085
        L_0x0072:
            r13 = move-exception
            com.huawei.hms.scankit.p.v3 r0 = H
            if (r0 == 0) goto L_0x007e
            com.huawei.hms.scankit.p.v3 r0 = H
            r1 = -1002(0xfffffffffffffc16, float:NaN)
            r0.c(r1)
        L_0x007e:
            java.lang.String r0 = G
            java.lang.String r1 = "initCamera IOException"
            com.huawei.hms.scankit.p.o4.a(r0, r1, r13)
        L_0x0085:
            return
        L_0x0086:
            java.lang.String r13 = G
            java.lang.String r0 = "initCamera() no surface view"
            com.huawei.hms.scankit.p.o4.d(r13, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.b.a(android.view.TextureView):void");
    }

    public void b(boolean z2) {
        this.E = z2;
    }

    public boolean b() {
        return this.F;
    }

    private void a(boolean z2, j0 j0Var) {
        try {
            m0 g2 = j0Var.g();
            if (j0Var.j()) {
                int c2 = g2.c();
                int b2 = g2.b();
                if (z2 && b2 < c2) {
                    b2++;
                } else if (b2 > 0) {
                    b2--;
                } else {
                    o4.c(G, "handleZoom  zoom not change");
                }
                j0Var.d(b2);
                return;
            }
            o4.c(G, "zoom not supported");
        } catch (RuntimeException unused) {
            Log.e(G, "handleZoom: RuntimeException");
        }
    }

    private float a(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        float y2 = motionEvent.getY(0) - motionEvent.getY(1);
        double sqrt = Math.sqrt((double) ((x2 * x2) + (y2 * y2)));
        if (Double.isInfinite(sqrt) || Double.isNaN(sqrt)) {
            return 0.0f;
        }
        return BigDecimal.valueOf(sqrt).floatValue();
    }

    public void a(HmsScan[] hmsScanArr, Bitmap bitmap) {
        o4.a("scan-time", "decode time:" + System.currentTimeMillis());
        try {
            String str = G;
            o4.c(str, "result onResult");
            if (this.y.a()) {
                o4.c(str, "result intercepted");
                return;
            }
            if (H != null) {
                H.a(hmsScanArr);
            }
            if (!this.c) {
                hmsScanArr = w7.a(hmsScanArr);
            }
            if (this.y != null) {
                if (!(this.h == null || hmsScanArr.length <= 0 || hmsScanArr[0] == null)) {
                    o4.c(str, "result draw result point");
                    if (this.d instanceof Activity) {
                        this.h.a(hmsScanArr[0].getBorderRect(), w7.c((Activity) this.d), this.g.e());
                    }
                    this.C = false;
                }
                this.y.a(hmsScanArr);
            }
            if (this.z != null) {
                try {
                    o4.c(str, "result callback end: pauseStatus" + this.C);
                    if (!this.C) {
                        if (this.w && hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null) {
                            Context context = this.d;
                            if (context instanceof Activity) {
                                int rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
                                hmsScanArr[0].originalBitmap = w7.a(bitmap, rotation);
                            }
                        }
                        this.z.onResult(hmsScanArr);
                    }
                } catch (RemoteException e2) {
                    if (H != null) {
                        H.c(-1003);
                    }
                    o4.d("CaptureHelper", "onResult  RemoteException  e:" + e2);
                }
            }
        } catch (RuntimeException e3) {
            Log.e(G, "onResult:RuntimeException " + e3);
        } catch (Exception e4) {
            Log.e(G, "onResult:Exception: " + e4);
        }
    }

    public b a(boolean z2) {
        this.w = z2;
        a aVar = this.e;
        if (aVar != null) {
            aVar.a(z2);
        }
        return this;
    }

    public b a(e5 e5Var) {
        this.y = e5Var;
        return this;
    }

    public void a(IOnResultCallback iOnResultCallback) {
        this.z = iOnResultCallback;
    }

    public j0 a() {
        return this.g;
    }

    public void a(IOnErrorCallback iOnErrorCallback) {
        this.D = iOnErrorCallback;
    }

    private e0 a(Context context) {
        e0 e0Var;
        Activity activity = (Activity) context;
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        Log.i(G, "initCameraConfig:falserotation" + rotation);
        if (rotation == 0) {
            e0Var = new e0.b().a(new Point(1920, 1080)).a(1).b(90).b(false).a(true).a();
        } else if (rotation == 1) {
            e0Var = new e0.b().a(new Point(1920, 1080)).a(1).b(0).b(false).a(true).a();
        } else if (rotation == 2) {
            e0Var = new e0.b().a(new Point(1920, 1080)).a(1).b(270).b(false).a(true).a();
        } else if (rotation != 3) {
            e0Var = new e0.b().a(new Point(1920, 1080)).a(1).b(90).b(false).a(true).a();
        } else {
            e0Var = new e0.b().a(new Point(1920, 1080)).a(1).b(180).b(false).a(true).a();
        }
        if (w7.e(context) || w7.b(activity) || w7.d(context)) {
            e0Var.a(new Point(1080, 1080));
            this.F = true;
        }
        if ("ceres-c3".equals(Build.DEVICE)) {
            e0Var = new e0.b().a(new Point(1080, 1920)).a(1).b(false).a(true).a();
        }
        boolean b2 = w7.b();
        boolean d2 = w7.d();
        if ((!w7.d(context) || b2) && (!w7.b(activity) || d2)) {
            return e0Var;
        }
        e0 a2 = new e0.b().a(new Point(1080, 1080)).a(1).b(90).b(false).a(true).a();
        this.F = true;
        return a2;
    }
}
