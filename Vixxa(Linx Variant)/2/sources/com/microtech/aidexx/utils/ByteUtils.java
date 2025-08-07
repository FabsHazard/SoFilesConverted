package com.microtech.aidexx.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ByteUtils {
    public static byte[] subByte(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static Date checkToDate(byte[] bArr) {
        int m = (ByteUtils$$ExternalSyntheticBackport0.m(bArr[1]) * 256) + ByteUtils$$ExternalSyntheticBackport0.m(bArr[0]);
        int m2 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[2]);
        int m3 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[3]);
        int m4 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[4]);
        int m5 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[5]);
        int m6 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[6]);
        byte b = bArr[7];
        int m7 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[8]);
        LogUtils.eAiDex("Get start time --> timeZone : " + b + ", dstOffset : " + m7 + ", " + m + "-" + m2 + "-" + m3 + " " + m4 + ":" + m5 + ":" + m6);
        if (m == 0 && m2 == 0 && m3 == 0 && m4 == 0 && m5 == 0 && m6 == 0) {
            return null;
        }
        SensorTimeZoneInfo timeZone = getTimeZone(b * 900000, 900000 * m7);
        Calendar instance = Calendar.getInstance(timeZone.timeZone);
        instance.set(1, m);
        instance.set(2, m2 - 1);
        instance.set(5, m3);
        int i = m7 / 4;
        int i2 = m7 % 4;
        if (timeZone.ignoreOffset) {
            i2 = 0;
            i = 0;
        }
        instance.set(11, m4 - i);
        instance.set(12, m5 - (i2 * 15));
        instance.set(13, m6);
        instance.set(14, 0);
        return instance.getTime();
    }

    static class SensorTimeZoneInfo {
        public boolean ignoreOffset;
        public TimeZone timeZone;

        public SensorTimeZoneInfo(TimeZone timeZone2, boolean z) {
            this.timeZone = timeZone2;
            this.ignoreOffset = z;
        }
    }

    public static SensorTimeZoneInfo getTimeZone(int i, int i2) {
        SensorTimeZoneInfo sensorTimeZoneInfo;
        String[] availableIDs = TimeZone.getAvailableIDs(i);
        boolean z = true;
        if (availableIDs == null || availableIDs.length == 0) {
            return new SensorTimeZoneInfo(TimeZone.getTimeZone("UTC"), true);
        }
        int length = availableIDs.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                sensorTimeZoneInfo = null;
                break;
            }
            String str = availableIDs[i3];
            if (str.contains("Etc/GMT")) {
                sensorTimeZoneInfo = new SensorTimeZoneInfo(TimeZone.getTimeZone(str), false);
                break;
            }
            i3++;
        }
        if (sensorTimeZoneInfo == null) {
            int length2 = availableIDs.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                TimeZone timeZone = TimeZone.getTimeZone(availableIDs[i4]);
                if (i2 <= 0 || timeZone.getDSTSavings() <= 0 || timeZone.getDSTSavings() != i2) {
                    if (i2 == 0 && timeZone.getDSTSavings() == 0) {
                        sensorTimeZoneInfo = new SensorTimeZoneInfo(timeZone, false);
                        break;
                    }
                    i4++;
                } else {
                    sensorTimeZoneInfo = new SensorTimeZoneInfo(timeZone, true);
                    break;
                }
            }
        }
        if (sensorTimeZoneInfo == null) {
            TimeZone timeZone2 = TimeZone.getTimeZone(availableIDs[0]);
            if (timeZone2.getDSTSavings() <= 0) {
                z = false;
            }
            sensorTimeZoneInfo = new SensorTimeZoneInfo(timeZone2, z);
        }
        LogUtils.eAiDex("Time zone Id --> " + sensorTimeZoneInfo.timeZone.getID());
        return sensorTimeZoneInfo;
    }

    public static Date toDate(byte[] bArr) {
        int m = ByteUtils$$ExternalSyntheticBackport0.m(bArr[2]);
        int m2 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[3]);
        int m3 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[4]);
        int m4 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[5]);
        int m5 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[6]);
        Calendar instance = Calendar.getInstance();
        instance.set(1, (ByteUtils$$ExternalSyntheticBackport0.m(bArr[1]) * 256) + ByteUtils$$ExternalSyntheticBackport0.m(bArr[0]));
        instance.set(2, m - 1);
        instance.set(5, m2);
        instance.set(11, m3);
        instance.set(12, m4);
        instance.set(13, m5);
        instance.set(14, 0);
        return instance.getTime();
    }

    public static String getDeviceSoftVersion(byte[] bArr) {
        int m = ByteUtils$$ExternalSyntheticBackport0.m(bArr[2]);
        int m2 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[3]);
        int m3 = ByteUtils$$ExternalSyntheticBackport0.m(bArr[4]);
        return m + "." + m2 + "." + m3 + "." + ByteUtils$$ExternalSyntheticBackport0.m(bArr[5]);
    }

    public static int getDeviceType(byte[] bArr) {
        return ByteUtils$$ExternalSyntheticBackport0.m(bArr[1]);
    }

    public static String getBootVersion(byte[] bArr) {
        if (bArr.length != 4) {
            StringBuilder sb = new StringBuilder();
            for (int length = bArr.length - 1; length >= 0; length--) {
                sb.append(ByteUtils$$ExternalSyntheticBackport0.m(bArr[length]));
            }
            return sb.toString();
        }
        return ByteUtils$$ExternalSyntheticBackport0.m(bArr[3]) + "." + ByteUtils$$ExternalSyntheticBackport0.m(bArr[2]) + "." + ((ByteUtils$$ExternalSyntheticBackport0.m(bArr[1]) * 256) + ByteUtils$$ExternalSyntheticBackport0.m(bArr[0]));
    }
}
