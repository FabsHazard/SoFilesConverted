package com.huawei.hms.scankit.p;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import kotlinx.coroutines.DebugKt;

/* compiled from: CameraManager */
public class j0 {
    private e0 a;
    private d b;
    private b c;
    private Camera.PreviewCallback d;
    private WeakReference<Context> e;
    private i0 f;
    private h0 g;
    private n0 h;
    private l0 i;
    private Camera j;
    private f0 k;
    private String l;
    private c m = c.CAMERA_CLOSED;
    private int n = -1;

    /* compiled from: CameraManager */
    public interface b {
        void a(Point point);
    }

    /* compiled from: CameraManager */
    public enum c {
        CAMERA_CLOSED(1),
        CAMERA_OPENED(2),
        CAMERA_INITIALED(3),
        PREVIEW_STARTED(4),
        PREVIEW_STOPPED(5);
        
        private final int a;

        private c(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    /* compiled from: CameraManager */
    public interface d {
        void a();

        void b();

        void c();
    }

    /* compiled from: CameraManager */
    public interface e {
        void a(byte[] bArr);
    }

    /* compiled from: CameraManager */
    private static class f implements Camera.PreviewCallback {
        private f() {
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }
    }

    public j0(Context context, e0 e0Var) {
        if (context == null || e0Var == null) {
            throw new IllegalArgumentException("CameraManager constructor param invalid");
        }
        this.e = new WeakReference<>(context);
        this.a = e0Var;
        this.l = e0Var.f();
        this.k = new f0();
        this.g = new h0();
        this.h = new n0();
        this.i = new l0();
    }

    public synchronized void a(e eVar) {
        if (eVar != null) {
            this.d = new f6(eVar);
        } else {
            throw new IllegalArgumentException("CameraManager::setFrameCallback param invalid");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.huawei.hms.scankit.p.g0 b() {
        /*
            r3 = this;
            monitor-enter(r3)
            android.hardware.Camera r0 = r3.j     // Catch:{ all -> 0x0028 }
            r1 = 0
            if (r0 == 0) goto L_0x0026
            com.huawei.hms.scankit.p.j0$c r0 = r3.m     // Catch:{ all -> 0x0028 }
            int r0 = r0.a()     // Catch:{ all -> 0x0028 }
            com.huawei.hms.scankit.p.j0$c r2 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ all -> 0x0028 }
            int r2 = r2.a()     // Catch:{ all -> 0x0028 }
            if (r0 != r2) goto L_0x0015
            goto L_0x0026
        L_0x0015:
            com.huawei.hms.scankit.p.h0 r0 = r3.g     // Catch:{ Exception -> 0x001d }
            com.huawei.hms.scankit.p.g0 r0 = r0.a()     // Catch:{ Exception -> 0x001d }
            monitor-exit(r3)
            return r0
        L_0x001d:
            java.lang.String r0 = "CameraManager"
            java.lang.String r2 = "CameraManager::getCameraExposureData failed"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return r1
        L_0x0026:
            monitor-exit(r3)
            return r1
        L_0x0028:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.b():com.huawei.hms.scankit.p.g0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void c(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.hardware.Camera r0 = r2.j     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x001d }
            int r0 = r0.a()     // Catch:{ all -> 0x001d }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ all -> 0x001d }
            int r1 = r1.a()     // Catch:{ all -> 0x001d }
            if (r0 != r1) goto L_0x0014
            goto L_0x001b
        L_0x0014:
            com.huawei.hms.scankit.p.h0 r0 = r2.g     // Catch:{ all -> 0x001d }
            r0.a((int) r3)     // Catch:{ all -> 0x001d }
            monitor-exit(r2)
            return
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.c(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.hardware.Camera r0 = r2.j     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x001d }
            int r0 = r0.a()     // Catch:{ all -> 0x001d }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ all -> 0x001d }
            int r1 = r1.a()     // Catch:{ all -> 0x001d }
            if (r0 != r1) goto L_0x0014
            goto L_0x001b
        L_0x0014:
            com.huawei.hms.scankit.p.n0 r0 = r2.h     // Catch:{ all -> 0x001d }
            r0.a((int) r3)     // Catch:{ all -> 0x001d }
            monitor-exit(r2)
            return
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.d(int):void");
    }

    public synchronized Point e() {
        return this.k.a();
    }

    public synchronized c f() {
        return this.m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.huawei.hms.scankit.p.m0 g() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.hardware.Camera r0 = r2.j     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001c
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x001f }
            int r0 = r0.a()     // Catch:{ all -> 0x001f }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ all -> 0x001f }
            int r1 = r1.a()     // Catch:{ all -> 0x001f }
            if (r0 != r1) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            com.huawei.hms.scankit.p.n0 r0 = r2.h     // Catch:{ all -> 0x001f }
            com.huawei.hms.scankit.p.m0 r0 = r0.a()     // Catch:{ all -> 0x001f }
            monitor-exit(r2)
            return r0
        L_0x001c:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.g():com.huawei.hms.scankit.p.m0");
    }

    public synchronized String h() {
        return this.l;
    }

    public synchronized boolean i() {
        return this.j != null && this.m.a() >= c.CAMERA_OPENED.a();
    }

    public synchronized boolean j() {
        return this.h.b();
    }

    public synchronized void k() {
        this.c = null;
    }

    public synchronized void l() {
        try {
            if (this.m.a() == c.PREVIEW_STARTED.a()) {
                a();
                q();
                this.m = c.PREVIEW_STOPPED;
            }
            if (h().equals("torch")) {
                a(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
            }
            if (this.m.a() >= c.CAMERA_OPENED.a()) {
                this.m = c.CAMERA_CLOSED;
                Camera camera = this.j;
                if (camera != null) {
                    camera.setPreviewCallback((Camera.PreviewCallback) null);
                    this.j.stopPreview();
                    this.j.release();
                    this.j = null;
                }
                d dVar = this.b;
                if (dVar != null) {
                    dVar.c();
                }
            }
        } catch (RuntimeException unused) {
            Log.e("CameraManager", "CameraManager::onPause failed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m() {
        /*
            r4 = this;
            java.lang.String r0 = "CameraManager::Camera open failed, "
            java.lang.String r1 = "onResume: "
            monitor-enter(r4)
            com.huawei.hms.scankit.p.j0$c r2 = r4.m     // Catch:{ all -> 0x006b }
            com.huawei.hms.scankit.p.j0$c r3 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ all -> 0x006b }
            if (r2 == r3) goto L_0x0011
            com.huawei.hms.scankit.p.j0$c r3 = com.huawei.hms.scankit.p.j0.c.PREVIEW_STOPPED     // Catch:{ all -> 0x006b }
            if (r2 == r3) goto L_0x0011
            monitor-exit(r4)
            return
        L_0x0011:
            com.huawei.hms.scankit.p.e0 r2 = r4.a     // Catch:{ all -> 0x006b }
            int r2 = r2.b()     // Catch:{ all -> 0x006b }
            int r2 = r4.a((int) r2)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r3.<init>(r1)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r1 = r3.append(r2)     // Catch:{ all -> 0x006b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006b }
            java.lang.String r3 = "CameraManager"
            android.util.Log.i(r3, r1)     // Catch:{ all -> 0x006b }
            android.hardware.Camera r1 = android.hardware.Camera.open(r2)     // Catch:{ RuntimeException -> 0x0034 }
            r4.j = r1     // Catch:{ RuntimeException -> 0x0034 }
            goto L_0x004b
        L_0x0034:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r2.<init>(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006b }
            java.lang.String r1 = "CameraManager"
            android.util.Log.e(r1, r0)     // Catch:{ all -> 0x006b }
        L_0x004b:
            android.hardware.Camera r0 = r4.j     // Catch:{ all -> 0x006b }
            if (r0 != 0) goto L_0x005e
            java.lang.String r0 = "CameraManager"
            java.lang.String r1 = "CameraManager::initCamera failed"
            android.util.Log.e(r0, r1)     // Catch:{ all -> 0x006b }
            com.huawei.hms.scankit.p.j0$d r0 = r4.b     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0069
            r0.b()     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x005e:
            com.huawei.hms.scankit.p.j0$d r0 = r4.b     // Catch:{ all -> 0x006b }
            if (r0 == 0) goto L_0x0065
            r0.a()     // Catch:{ all -> 0x006b }
        L_0x0065:
            com.huawei.hms.scankit.p.j0$c r0 = com.huawei.hms.scankit.p.j0.c.CAMERA_OPENED     // Catch:{ all -> 0x006b }
            r4.m = r0     // Catch:{ all -> 0x006b }
        L_0x0069:
            monitor-exit(r4)
            return
        L_0x006b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.m():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void n() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.huawei.hms.scankit.p.j0$c r0 = r3.m     // Catch:{ all -> 0x0028 }
            int r0 = r0.a()     // Catch:{ all -> 0x0028 }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.CAMERA_OPENED     // Catch:{ all -> 0x0028 }
            int r1 = r1.a()     // Catch:{ all -> 0x0028 }
            if (r0 >= r1) goto L_0x0011
            monitor-exit(r3)
            return
        L_0x0011:
            com.huawei.hms.scankit.p.e0 r0 = r3.a     // Catch:{ all -> 0x0028 }
            int r0 = r0.c()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            android.hardware.Camera r0 = r3.j     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0026
            com.huawei.hms.scankit.p.j0$f r1 = new com.huawei.hms.scankit.p.j0$f     // Catch:{ all -> 0x0028 }
            r2 = 0
            r1.<init>()     // Catch:{ all -> 0x0028 }
            r0.setPreviewCallback(r1)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r3)
            return
        L_0x0028:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.n():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void o() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.huawei.hms.scankit.p.e0 r0 = r2.a     // Catch:{ all -> 0x0067 }
            int r0 = r0.c()     // Catch:{ all -> 0x0067 }
            r1 = 1
            if (r0 != r1) goto L_0x0023
            java.lang.String r0 = "CameraManager"
            java.lang.String r1 = "CameraManager::requestPreviewFrame PREVIEW_ONE_SHOT"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0067 }
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x0067 }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.PREVIEW_STOPPED     // Catch:{ all -> 0x0067 }
            if (r0 != r1) goto L_0x0019
            monitor-exit(r2)
            return
        L_0x0019:
            android.hardware.Camera r0 = r2.j     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0065
            android.hardware.Camera$PreviewCallback r1 = r2.d     // Catch:{ all -> 0x0067 }
            r0.setOneShotPreviewCallback(r1)     // Catch:{ all -> 0x0067 }
            goto L_0x0065
        L_0x0023:
            com.huawei.hms.scankit.p.e0 r0 = r2.a     // Catch:{ all -> 0x0067 }
            int r0 = r0.c()     // Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x003c
            java.lang.String r0 = "CameraManager"
            java.lang.String r1 = "CameraManager::requestPreviewFrame PICTURE_MODE"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0067 }
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x0067 }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.PREVIEW_STOPPED     // Catch:{ all -> 0x0067 }
            if (r0 != r1) goto L_0x0065
            r2.p()     // Catch:{ all -> 0x0067 }
            goto L_0x0065
        L_0x003c:
            com.huawei.hms.scankit.p.e0 r0 = r2.a     // Catch:{ all -> 0x0067 }
            int r0 = r0.c()     // Catch:{ all -> 0x0067 }
            r1 = 2
            if (r0 != r1) goto L_0x005e
            java.lang.String r0 = "CameraManager"
            java.lang.String r1 = "CameraManager::requestPreviewFrame PREVIEW_MULTI_SHOT"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0067 }
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x0067 }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.PREVIEW_STOPPED     // Catch:{ all -> 0x0067 }
            if (r0 != r1) goto L_0x0054
            monitor-exit(r2)
            return
        L_0x0054:
            android.hardware.Camera r0 = r2.j     // Catch:{ all -> 0x0067 }
            if (r0 == 0) goto L_0x0065
            android.hardware.Camera$PreviewCallback r1 = r2.d     // Catch:{ all -> 0x0067 }
            r0.setPreviewCallback(r1)     // Catch:{ all -> 0x0067 }
            goto L_0x0065
        L_0x005e:
            java.lang.String r0 = "CameraManager"
            java.lang.String r1 = "CameraManager::requestPreviewFrame unknown mode"
            android.util.Log.w(r0, r1)     // Catch:{ all -> 0x0067 }
        L_0x0065:
            monitor-exit(r2)
            return
        L_0x0067:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0067 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.o():void");
    }

    public synchronized void p() {
        try {
            if (this.m.a() < c.CAMERA_INITIALED.a()) {
                Log.w("CameraManager", "CameraManager::startPreview camera is not initialed yet");
                return;
            }
            Camera camera = this.j;
            if (camera != null) {
                camera.startPreview();
                this.m = c.PREVIEW_STARTED;
            }
        } catch (RuntimeException unused) {
            Log.w("CameraManager", "stopPreview error");
        }
    }

    public synchronized void q() {
        try {
            if (this.m.a() < c.PREVIEW_STARTED.a()) {
                Log.w("CameraManager", "CameraManager::startPreview camera is not startPreview yet");
                return;
            }
            Camera camera = this.j;
            if (camera != null) {
                camera.setPreviewCallback((Camera.PreviewCallback) null);
                this.j.stopPreview();
                this.m = c.PREVIEW_STOPPED;
            }
        } catch (RuntimeException unused) {
            Log.w("CameraManager", "stopPreview error");
        }
    }

    public synchronized void a(d dVar) {
        if (dVar != null) {
            this.b = dVar;
        } else {
            throw new IllegalArgumentException("CameraManager::setCameraStatusListener param invalid");
        }
    }

    public synchronized void a(TextureView textureView) throws IOException {
        if (textureView != null) {
            if (this.m.a() != c.CAMERA_OPENED.a()) {
                Log.w("CameraManager", "CameraManager::initCamera camera is not opened yet");
                m();
            }
            this.g.a(this.j);
            this.h.a(this.j);
            this.i.a(this.j);
            Camera camera = this.j;
            if (camera != null) {
                camera.setPreviewTexture(textureView.getSurfaceTexture());
            }
            this.k.a(this.j, this.a);
            Camera camera2 = this.j;
            if (camera2 != null) {
                camera2.setDisplayOrientation(this.a.d());
            }
            b bVar = this.c;
            if (bVar != null) {
                bVar.a(this.k.a());
            }
            this.m = c.CAMERA_INITIALED;
        } else {
            throw new IllegalArgumentException("CameraManager::initCamera SurfaceHolder is null");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.huawei.hms.scankit.p.k0 c() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.hardware.Camera r0 = r2.j     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001c
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x001f }
            int r0 = r0.a()     // Catch:{ all -> 0x001f }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ all -> 0x001f }
            int r1 = r1.a()     // Catch:{ all -> 0x001f }
            if (r0 != r1) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            com.huawei.hms.scankit.p.l0 r0 = r2.i     // Catch:{ all -> 0x001f }
            com.huawei.hms.scankit.p.k0 r0 = r0.a()     // Catch:{ all -> 0x001f }
            monitor-exit(r2)
            return r0
        L_0x001c:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x001f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.c():com.huawei.hms.scankit.p.k0");
    }

    public synchronized int d() {
        return this.a.d();
    }

    public synchronized void b(int i2) {
        if (!(this.a == null || this.j == null || this.m.a() < c.CAMERA_OPENED.a())) {
            this.a.a(i2);
            try {
                this.j.setDisplayOrientation(i2);
            } catch (RuntimeException unused) {
                Log.e("CameraManager", "setDisplayOrientation RuntimeException");
            } catch (Exception unused2) {
                Log.e("CameraManager", "setDisplayOrientation Exception");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.hardware.Camera r0 = r2.j     // Catch:{ RuntimeException -> 0x003b }
            if (r0 == 0) goto L_0x0037
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ RuntimeException -> 0x003b }
            int r0 = r0.a()     // Catch:{ RuntimeException -> 0x003b }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ RuntimeException -> 0x003b }
            int r1 = r1.a()     // Catch:{ RuntimeException -> 0x003b }
            if (r0 != r1) goto L_0x0014
            goto L_0x0037
        L_0x0014:
            java.lang.String r0 = "off"
            boolean r0 = r0.equals(r3)     // Catch:{ RuntimeException -> 0x003b }
            if (r0 != 0) goto L_0x0026
            java.lang.String r0 = "torch"
            boolean r0 = r0.equals(r3)     // Catch:{ RuntimeException -> 0x003b }
            if (r0 != 0) goto L_0x0026
            monitor-exit(r2)
            return
        L_0x0026:
            android.hardware.Camera r0 = r2.j     // Catch:{ RuntimeException -> 0x003b }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ RuntimeException -> 0x003b }
            r0.setFlashMode(r3)     // Catch:{ RuntimeException -> 0x003b }
            android.hardware.Camera r1 = r2.j     // Catch:{ RuntimeException -> 0x003b }
            r1.setParameters(r0)     // Catch:{ RuntimeException -> 0x003b }
            r2.l = r3     // Catch:{ RuntimeException -> 0x003b }
            goto L_0x0042
        L_0x0037:
            monitor-exit(r2)
            return
        L_0x0039:
            r3 = move-exception
            goto L_0x0044
        L_0x003b:
            java.lang.String r3 = "CameraManager"
            java.lang.String r0 = "CameraManager::setTorchStatus error"
            android.util.Log.w(r3, r0)     // Catch:{ all -> 0x0039 }
        L_0x0042:
            monitor-exit(r2)
            return
        L_0x0044:
            monitor-exit(r2)     // Catch:{ all -> 0x0039 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.a(java.lang.String):void");
    }

    public synchronized void a(Rect rect, boolean z) {
        if (this.j != null) {
            if (this.f == null) {
                this.f = new i0(this.j);
            }
            this.f.a(rect, this.k.a().x, this.k.a().y, z, this.a.b() == 1);
        }
    }

    public synchronized void a() {
        i0 i0Var = this.f;
        if (i0Var != null) {
            i0Var.e();
            this.f = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.List<com.huawei.hms.scankit.p.k0.a> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.hardware.Camera r0 = r2.j     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.huawei.hms.scankit.p.j0$c r0 = r2.m     // Catch:{ all -> 0x001d }
            int r0 = r0.a()     // Catch:{ all -> 0x001d }
            com.huawei.hms.scankit.p.j0$c r1 = com.huawei.hms.scankit.p.j0.c.CAMERA_CLOSED     // Catch:{ all -> 0x001d }
            int r1 = r1.a()     // Catch:{ all -> 0x001d }
            if (r0 != r1) goto L_0x0014
            goto L_0x001b
        L_0x0014:
            com.huawei.hms.scankit.p.l0 r0 = r2.i     // Catch:{ all -> 0x001d }
            r0.a((java.util.List<com.huawei.hms.scankit.p.k0.a>) r3)     // Catch:{ all -> 0x001d }
            monitor-exit(r2)
            return
        L_0x001b:
            monitor-exit(r2)
            return
        L_0x001d:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.j0.a(java.util.List):void");
    }

    private int a(int i2) {
        if (i2 != 0 && i2 != 1) {
            return 0;
        }
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i3 = 0; i3 < numberOfCameras; i3++) {
                Camera.getCameraInfo(i3, cameraInfo);
                if (cameraInfo.facing == i2) {
                    Log.i("CameraManager", "findCameraId: " + i3);
                    return i3;
                }
            }
        } catch (RuntimeException unused) {
            Log.e("CameraManager", "getCameraInfo RuntimeException");
        } catch (Exception unused2) {
            Log.e("CameraManager", "getCameraInfo Exception");
        }
        return 0;
    }
}
