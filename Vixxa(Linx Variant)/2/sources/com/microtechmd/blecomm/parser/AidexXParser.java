package com.microtechmd.blecomm.parser;

import java.util.List;

public class AidexXParser {
    public static native <V extends AidexXCalibrationEntity> List<V> getAidexXCalibration(byte[] bArr);

    public static native <V extends AidexXDeviceInfoEntity> V getAidexXDeviceInfo(byte[] bArr);

    public static native <V extends AidexXInstantHistoryEntity> V getAidexXInstantHistory(byte[] bArr);

    public static native <T extends AidexXBroadcastEntity> T getBroadcast(byte[] bArr);

    public static native int getCrc8(byte[] bArr);

    public static native <V extends AidexXHistoryEntity> List<V> getHistories(byte[] bArr);

    public static native float[] getParam(byte[] bArr);

    public static native <V extends AidexXRawHistoryEntity> List<V> getRawHistory(byte[] bArr);
}
