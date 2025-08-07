package com.microtechmd.blecomm.controller;

import com.microtechmd.blecomm.entity.AidexXDatetimeEntity;
import com.microtechmd.blecomm.entity.NewSensorEntity;

public class AidexXController extends BleControllerProxy {
    private native void constructor();

    private native void constructorWithInfo(BleControllerInfo bleControllerInfo);

    private native void destructor();

    public native int calibration(int i, int i2);

    public native int clearStorage();

    public native int deleteBond();

    public native int getBroadcastData();

    public native int getCalibration(int i);

    public native int getCalibrationRange();

    public native int getControllerCalTemp();

    public native int getControllerStatus();

    public native int getDefaultParamData();

    public native int getDeviceInfo();

    public native int getHistories(int i);

    public native int getHistoryRange();

    public native int getRawHistories(int i);

    public native int getSensorCheck(int i);

    public native int getStartTime();

    public native int isAesInitialized();

    public native int isBleNativePaired();

    public native int isProductExpire();

    public native int newSensor(AidexXDatetimeEntity aidexXDatetimeEntity);

    public native int reset();

    public native int setAutoUpdateStatus();

    public native int setDefaultParamByteData(byte[] bArr);

    public native int setDefaultParamData(float[] fArr);

    public native int setDynamicAdvMode(int i);

    public native int setGcBiasTrimming(int i);

    public native int setGcImeasTrimming(int i, int i2);

    public native int shelfMode();

    static {
        new Thread(new AidexXController$$ExternalSyntheticLambda0());
    }

    public static AidexXController getInstance() {
        return new AidexXController();
    }

    public static AidexXController getInstance(BleControllerInfo bleControllerInfo) {
        return new AidexXController(bleControllerInfo);
    }

    private AidexXController() {
        constructor();
    }

    private AidexXController(BleControllerInfo bleControllerInfo) {
        constructorWithInfo(bleControllerInfo);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        destructor();
        super.finalize();
    }

    public void getTransInfo() {
        getDeviceInfo();
    }

    public void getDefaultParam() {
        getDefaultParamData();
    }

    public void setDefaultParam(float[] fArr) {
        setDefaultParamData(fArr);
    }

    public void setDefaultParamByteArray(byte[] bArr) {
        setDefaultParamByteData(bArr);
    }

    public void newSensor(NewSensorEntity newSensorEntity) {
        newSensor(newSensorEntity.getAidexXDatetimeEntity());
    }

    public void setDynamicMode(int i) {
        setDynamicAdvMode(i);
    }

    public void setAutoUpdate() {
        setAutoUpdateStatus();
    }

    public boolean isNativePaired() {
        return isBleNativePaired() == 1;
    }

    public boolean isInitialized() {
        return isAesInitialized() == 1;
    }

    public boolean isProductionExpire() {
        return isProductExpire() == 1;
    }

    public int getStatus() {
        return getControllerStatus();
    }

    public int getCalTemp() {
        return getControllerCalTemp();
    }

    public void startTime() {
        getStartTime();
    }

    public void clearPair() {
        deleteBond();
    }
}
