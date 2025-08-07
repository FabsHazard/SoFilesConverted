package com.microtechmd.blecomm.parser;

public interface CgmBroadcastEntity {
    void _setBattery(int i);

    void _setDatetime(long j);

    void _setGlucose(float f);

    void _setHistory(CgmHistoryEntity cgmHistoryEntity);

    void _setPrimary(int i);

    void _setState(int i);
}
