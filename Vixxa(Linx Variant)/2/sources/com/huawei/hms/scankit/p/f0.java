package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import kotlinx.coroutines.DebugKt;

/* compiled from: CameraConfigImpl */
public class f0 {
    private e0 a;
    private Point b;
    private Point c;

    private void b(Camera.Parameters parameters) {
        if (parameters.isZoomSupported()) {
            parameters.setZoom(1);
        } else {
            Log.w("CameraManager", "initCameraParameters::setDefaultZoom not support zoom");
        }
    }

    private void c(Camera.Parameters parameters) {
        String str;
        int i = 0;
        String[] strArr = {"continuous-picture", "continuous-video", DebugKt.DEBUG_PROPERTY_VALUE_AUTO};
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null) {
            Log.w("CameraManager", "setFocusMode failed, use default");
            return;
        }
        while (true) {
            if (i >= 3) {
                str = null;
                break;
            }
            str = strArr[i];
            if (supportedFocusModes.contains(str)) {
                break;
            }
            i++;
        }
        if (str != null) {
            Log.i("CameraManager", "setFocusMode: " + str);
            parameters.setFocusMode(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Camera camera, e0 e0Var) {
        if (camera == null || e0Var == null) {
            throw new IllegalArgumentException("initCameraParameters param is invalid");
        }
        Camera.Parameters parameters = camera.getParameters();
        this.a = e0Var;
        this.b = a(parameters, e0Var.a(), false);
        Log.d("CameraManager", "initCameraParameters previewCameraSize: " + this.b.toString());
        if (e0Var.c() == 0) {
            this.c = a(parameters, e0Var.a(), true);
            Log.d("CameraManager", "initCameraParameters pictureCameraSize: " + this.c.toString());
        }
        a(camera, this.b, this.c);
    }

    /* access modifiers changed from: package-private */
    public Point a() {
        return this.b;
    }

    private void a(Camera camera, Point point, Point point2) {
        if (this.a != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setPreviewSize(point.x, point.y);
            if (this.a.c() == 0) {
                parameters.setPictureSize(point2.x, point2.y);
            }
            if (this.a.b() != 1) {
                a(parameters);
            }
            c(parameters);
            b(parameters);
            if (this.a.e()) {
                parameters.setRecordingHint(true);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                a(parameters, true);
            }
            camera.setParameters(parameters);
        }
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        Class<Camera.Parameters> cls = Camera.Parameters.class;
        try {
            Method method = cls.getMethod("setScanOptEnable", new Class[]{Boolean.TYPE});
            if (method != null) {
                method.invoke(parameters, new Object[]{Boolean.valueOf(z)});
                Log.i("CameraManager", "setScanOptEnable isOpt " + z);
            }
        } catch (NoSuchMethodException unused) {
            Log.e("CameraManager", "setScanOptEnable reflection NoSuchMethodException");
        } catch (InvocationTargetException unused2) {
            Log.e("CameraManager", "setScanOptEnable reflection InvocationTargetException");
        } catch (IllegalAccessException unused3) {
            Log.e("CameraManager", "setScanOptEnable reflection IllegalAccessException");
        } catch (Exception unused4) {
            Log.e("CameraManager", "setScanOptEnable reflection Exception");
        }
    }

    private Point a(Camera.Parameters parameters, Point point, boolean z) {
        List<Camera.Size> list;
        if (!z) {
            list = parameters.getSupportedPreviewSizes();
        } else {
            list = parameters.getSupportedPictureSizes();
        }
        if (list != null && !list.isEmpty()) {
            return a(list, point);
        }
        Log.e("CameraManager", "CameraConfigImpl::findCameraResolution camera not support");
        return new Point(0, 0);
    }

    private Point a(List<Camera.Size> list, Point point) {
        double d = ((double) point.x) / ((double) point.y);
        int i = 0;
        double d2 = Double.MAX_VALUE;
        int i2 = 0;
        for (Camera.Size next : list) {
            int i3 = next.width;
            int i4 = next.height;
            if (i3 == point.x && i4 == point.y) {
                return new Point(i3, i4);
            }
            if (((double) (i3 * i4)) >= 153600.0d) {
                double d3 = (((double) i3) / ((double) i4)) - d;
                if (Math.abs(d3) < d2) {
                    d2 = Math.abs(d3);
                    i2 = i4;
                    i = i3;
                }
            }
        }
        return new Point(i, i2);
    }

    private void a(Camera.Parameters parameters) {
        e0 e0Var = this.a;
        if (e0Var != null) {
            String f = e0Var.f();
            if (!f.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF) && !f.equals("torch")) {
                f = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            }
            parameters.setFlashMode(f);
        }
    }
}
