package com.microtechmd.blecomm.controller;

import com.microtechmd.blecomm.entity.NewSensorEntity;

public class CgmController extends BleControllerProxy {
    private native void constructor();

    private native void destructor();

    public native int calibration(float f, long j);

    public void clearPair() {
    }

    public int getCalTemp() {
        return 0;
    }

    public void getDefaultParam() {
    }

    public native int getDefaultParamData();

    public native int getDeviceInfo();

    public native int getFullHistories(int i);

    public native int getHistories(int i);

    public native float getHyper();

    public native float getHypo();

    public int getStatus() {
        return 0;
    }

    public void getTransInfo() {
    }

    public native void initialSettings(float f, float f2);

    public boolean isInitialized() {
        return false;
    }

    public boolean isNativePaired() {
        return false;
    }

    public boolean isProductionExpire() {
        return false;
    }

    public native int newSensor(boolean z, long j);

    public void newSensor(NewSensorEntity newSensorEntity) {
    }

    public native int recordBg(float f, long j);

    public void setAutoUpdate() {
    }

    public native int setDatetime(long j);

    public void setDefaultParam(float[] fArr) {
    }

    public void setDefaultParamByteArray(byte[] bArr) {
    }

    public native int setDefaultParamData(float[] fArr);

    public void setDynamicMode(int i) {
    }

    public native int setHyper(float f);

    public native int setHypo(float f);

    public void startTime() {
    }

    static {
        System.loadLibrary("blecomm-lib");
    }

    public CgmController() {
        constructor();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        destructor();
        super.finalize();
    }
}
