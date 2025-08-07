package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import android.util.Log;

/* compiled from: CameraZoomManager */
public class n0 {
    private Camera a;

    public synchronized void a(Camera camera) {
        this.a = camera;
    }

    public synchronized boolean b() {
        Camera camera = this.a;
        if (camera == null) {
            return false;
        }
        return camera.getParameters().isZoomSupported();
    }

    public synchronized m0 a() {
        return new m0(this.a.getParameters().getMaxZoom(), this.a.getParameters().getZoom(), this.a.getParameters().getZoomRatios());
    }

    public synchronized void a(int i) {
        Camera camera = this.a;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setZoom(i);
            try {
                this.a.setParameters(parameters);
            } catch (RuntimeException e) {
                Log.e("CameraManager", "CameraZoomManager::setCameraZoomIndex failed: " + e.getMessage());
            }
        }
    }
}
