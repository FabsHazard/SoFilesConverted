package com.microtechmd.blecomm.parser;

public interface CgmHistoryEntity {
    void _setDatetime(long j);

    void _setEventIndex(int i);

    void _setEventType(int i);

    void _setEventValue(float f);

    void _setRawValue(float[] fArr);

    void _setSensorIndex(int i);
}
