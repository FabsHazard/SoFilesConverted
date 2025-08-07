package com.huawei.hms.scankit.p;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlinx.coroutines.DebugKt;

/* compiled from: CameraFocusManager */
public class i0 implements Camera.AutoFocusCallback {
    private static final Set<String> i;
    private final boolean a;
    private Camera b;
    private AsyncTask<?, ?, ?> c;
    private boolean d = false;
    private boolean e = false;
    private int f = -1;
    private int g = 2;
    private String h = null;

    /* compiled from: CameraFocusManager */
    private static class a extends AsyncTask<Object, Object, Object> {
        private WeakReference<i0> a;

        a(i0 i0Var) {
            this.a = new WeakReference<>(i0Var);
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object... objArr) {
            i0 i0Var = (i0) this.a.get();
            if (i0Var == null) {
                return null;
            }
            i0Var.d();
            try {
                Thread.sleep((long) Math.max(i0Var.c(), 0));
            } catch (InterruptedException unused) {
                Log.e("CameraManager", "CameraFocusManager::doInBackground InterruptedException");
            }
            return null;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        i = hashSet;
        hashSet.add(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        hashSet.add("macro");
    }

    i0(Camera camera) {
        this.b = camera;
        boolean contains = i.contains(camera.getParameters().getFocusMode());
        this.a = contains;
        Log.i("CameraManager", "CameraFocusManager useAutoFocus： " + contains);
    }

    private synchronized void b() {
        AsyncTask<?, ?, ?> asyncTask = this.c;
        if (asyncTask != null) {
            if (asyncTask.getStatus() != AsyncTask.Status.FINISHED) {
                this.c.cancel(true);
            }
            this.c = null;
        }
    }

    /* access modifiers changed from: private */
    public synchronized int c() {
        return this.f;
    }

    public synchronized void d() {
        if (this.a) {
            this.c = null;
            if (!this.d && !this.e) {
                try {
                    this.b.autoFocus(this);
                    this.e = true;
                } catch (RuntimeException e2) {
                    Log.w("CameraManager", "Unexpected exception while focusing" + e2.getMessage());
                    a();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void e() {
        this.d = true;
        if (this.a) {
            b();
            try {
                this.b.cancelAutoFocus();
            } catch (RuntimeException e2) {
                Log.w("CameraManager", "Unexpected exception while cancelling focusing" + e2.getMessage());
            }
        }
    }

    public synchronized void onAutoFocus(boolean z, Camera camera) {
        this.e = false;
        a();
        try {
            camera.cancelAutoFocus();
        } catch (RuntimeException e2) {
            Log.i("CameraManager", "Unexpected exception while cancelling focusing" + e2.getMessage());
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode(this.h);
            camera.setParameters(parameters);
        } catch (RuntimeException e3) {
            Log.i("CameraManager", "CameraFocusManager::setCameraFocusArea failed: " + e3.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a() {
        /*
            r4 = this;
            java.lang.String r0 = "CameraFocusManager::autoFocusAgainLater RejectedExecutionException: "
            monitor-enter(r4)
            boolean r1 = r4.d     // Catch:{ all -> 0x0037 }
            if (r1 != 0) goto L_0x0035
            android.os.AsyncTask<?, ?, ?> r1 = r4.c     // Catch:{ all -> 0x0037 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0035
        L_0x000c:
            com.huawei.hms.scankit.p.i0$a r1 = new com.huawei.hms.scankit.p.i0$a     // Catch:{ all -> 0x0037 }
            r1.<init>(r4)     // Catch:{ all -> 0x0037 }
            java.util.concurrent.Executor r2 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch:{ RejectedExecutionException -> 0x001c }
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ RejectedExecutionException -> 0x001c }
            r1.executeOnExecutor(r2, r3)     // Catch:{ RejectedExecutionException -> 0x001c }
            r4.c = r1     // Catch:{ RejectedExecutionException -> 0x001c }
            goto L_0x0033
        L_0x001c:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0037 }
            r2.<init>(r0)     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x0037 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0037 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = "CameraManager"
            android.util.Log.w(r1, r0)     // Catch:{ all -> 0x0037 }
        L_0x0033:
            monitor-exit(r4)
            return
        L_0x0035:
            monitor-exit(r4)
            return
        L_0x0037:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0037 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.i0.a():void");
    }

    public void a(Rect rect, int i2, int i3, boolean z, boolean z2) {
        int i4 = this.g;
        if (i4 >= 1) {
            this.g = i4 - 1;
            Rect a2 = a((float) rect.centerX(), (float) rect.centerY(), 1.0f, i3, i2, false, z ? 90 : 0);
            if (a2 == null) {
                this.g--;
                return;
            }
            Camera camera = this.b;
            if (camera != null) {
                camera.cancelAutoFocus();
                Camera.Parameters parameters = this.b.getParameters();
                if (parameters.getMaxNumFocusAreas() > 0) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(a2, 1000));
                    parameters.setFocusAreas(arrayList);
                } else {
                    Log.i("CameraManager", "focus areas not supported");
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(a2, 1000));
                    parameters.setMeteringAreas(arrayList2);
                } else {
                    Log.i("CameraManager", "metering areas not supported");
                }
                this.h = parameters.getFocusMode();
                try {
                    parameters.setFocusMode("macro");
                    this.b.setParameters(parameters);
                    this.b.autoFocus(this);
                } catch (RuntimeException e2) {
                    Log.i("CameraManager", "CameraFocusManager::setCameraFocusArea failed: " + e2.getMessage());
                    this.g++;
                }
            }
        }
    }

    private static Rect a(float f2, float f3, float f4, int i2, int i3, boolean z, int i4) {
        int i5 = (int) (((f2 / ((float) i2)) * 2000.0f) - 1000.0f);
        int i6 = (int) (((f3 / ((float) i3)) * 2000.0f) - 1000.0f);
        RectF rectF = new RectF((float) a(i5 - 150), (float) a(i6 - 150), (float) a(i5 + 150), (float) a(i6 + 150));
        Matrix matrix = new Matrix();
        try {
            a(matrix, z, i4);
            matrix.mapRect(rectF);
            return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        } catch (RuntimeException e2) {
            Log.i("CameraManager", "CameraFocusManager::prepareMatrix failed: " + e2.getMessage());
            return null;
        }
    }

    public static void a(Matrix matrix, boolean z, int i2) {
        if (matrix != null) {
            Matrix matrix2 = new Matrix();
            try {
                matrix.reset();
                matrix2.setScale(z ? -1.0f : 1.0f, 1.0f);
                matrix2.postRotate((float) i2);
                matrix2.invert(matrix);
            } catch (RuntimeException e2) {
                Log.i("CameraManager", "CameraFocusManager::prepareMatrix failed: " + e2.getMessage());
            }
        }
    }

    private static int a(int i2) {
        if (i2 > 1000) {
            return 1000;
        }
        return Math.max(i2, -1000);
    }
}
