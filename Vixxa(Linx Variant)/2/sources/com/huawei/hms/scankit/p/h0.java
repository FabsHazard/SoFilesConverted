package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import android.util.Log;

/* compiled from: CameraExposureManager */
public class h0 {
    private Camera a;

    public synchronized void a(Camera camera) {
        this.a = camera;
    }

    public synchronized g0 a() {
        return new g0(this.a.getParameters().getMaxExposureCompensation(), this.a.getParameters().getMinExposureCompensation(), this.a.getParameters().getExposureCompensation(), this.a.getParameters().getExposureCompensationStep());
    }

    public synchronized void a(int i) {
        Camera camera = this.a;
        if (camera != null) {
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setExposureCompensation(i);
                Log.i("WWYYEHG", "setExpuseModeA: " + parameters.getAutoExposureLock());
                this.a.setParameters(parameters);
                Log.i("WWYYEHG", "setExpuseModeB: " + parameters.getAutoExposureLock());
            } catch (RuntimeException unused) {
                Log.w("CameraManager", "CameraExposureManager::setCompensation failed");
            }
        }
    }
}
