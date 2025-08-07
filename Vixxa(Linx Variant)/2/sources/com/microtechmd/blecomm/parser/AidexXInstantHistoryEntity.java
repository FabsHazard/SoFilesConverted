package com.microtechmd.blecomm.parser;

public class AidexXInstantHistoryEntity {
    public AidexXAbstractEntity abstractEntity;
    public AidexXHistoryEntity history;
    public AidexXRawHistoryEntity raw;

    public AidexXInstantHistoryEntity(AidexXAbstractEntity aidexXAbstractEntity, AidexXHistoryEntity aidexXHistoryEntity, AidexXRawHistoryEntity aidexXRawHistoryEntity) {
        this.abstractEntity = aidexXAbstractEntity;
        this.history = aidexXHistoryEntity;
        this.raw = aidexXRawHistoryEntity;
    }

    public String toString() {
        return "AidexXInstantHistoryEntity{abstractEntity=" + this.abstractEntity + ", history=" + this.history + ", raw=" + this.raw + '}';
    }
}
