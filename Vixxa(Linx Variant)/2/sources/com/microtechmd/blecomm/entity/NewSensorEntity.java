package com.microtechmd.blecomm.entity;

public class NewSensorEntity {
    AidexXDatetimeEntity aidexXDatetimeEntity;
    Long dateTime;
    Boolean isNew;

    public NewSensorEntity(AidexXDatetimeEntity aidexXDatetimeEntity2) {
        this.aidexXDatetimeEntity = aidexXDatetimeEntity2;
    }

    public NewSensorEntity(Boolean bool, Long l) {
        this.isNew = bool;
        this.dateTime = l;
    }

    public AidexXDatetimeEntity getAidexXDatetimeEntity() {
        return this.aidexXDatetimeEntity;
    }

    public Boolean getNew() {
        return this.isNew;
    }

    public Long getDateTime() {
        return this.dateTime;
    }
}
