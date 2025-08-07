package com.microtechmd.blecomm.parser;

import java.util.List;

public class AidexXBroadcastEntity {
    public AidexXAbstractEntity abstractEntity;
    public List<AidexXHistoryEntity> history;
    public int historyCount;

    public AidexXBroadcastEntity(AidexXAbstractEntity aidexXAbstractEntity, List<AidexXHistoryEntity> list, int i) {
        this.abstractEntity = aidexXAbstractEntity;
        this.history = list;
        this.historyCount = i;
    }

    public String toString() {
        return "AidexXBroadcastEntity{abstractEntity=" + this.abstractEntity + ", history=" + this.history + ", historyCount=" + this.historyCount + '}';
    }
}
