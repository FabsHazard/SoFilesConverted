package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.huawei.hms.scankit.p.k0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraMeteringManager */
public class l0 {
    private Camera a;

    public synchronized void a(Camera camera) {
        this.a = camera;
    }

    public synchronized k0 a() {
        int i;
        Rect rect;
        RuntimeException e;
        try {
            i = this.a.getParameters().getMaxNumMeteringAreas();
            try {
                rect = this.a.getParameters().getMeteringAreas().get(0).rect;
            } catch (RuntimeException e2) {
                e = e2;
            }
        } catch (RuntimeException e3) {
            RuntimeException runtimeException = e3;
            i = 0;
            e = runtimeException;
            Log.w("CameraManager", "CameraMeteringManager::getCameraMeteringData failed: " + e.getMessage());
            rect = null;
            return new k0(i, rect);
        }
        return new k0(i, rect);
    }

    public synchronized void a(List<k0.a> list) {
        Camera camera = this.a;
        if (camera != null) {
            Camera.Parameters parameters = camera.getParameters();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new Camera.Area(list.get(i).a, list.get(i).b));
            }
            parameters.setMeteringAreas(arrayList);
            try {
                this.a.setParameters(parameters);
            } catch (RuntimeException e) {
                Log.w("CameraManager", "CameraMeteringManager::setCameraMeteringArea failed: " + e.getMessage());
            }
        }
    }
}
