package com.microtech.aidexx.db.entity;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.TransmitterEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;

public final class TransmitterEntity_ implements EntityInfo<TransmitterEntity> {
    public static final Property<TransmitterEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<TransmitterEntity> __CURSOR_FACTORY = new TransmitterEntityCursor.Factory();
    public static final String __DB_NAME = "TransmitterEntity";
    public static final Class<TransmitterEntity> __ENTITY_CLASS = TransmitterEntity.class;
    public static final int __ENTITY_ID = 10;
    public static final String __ENTITY_NAME = "TransmitterEntity";
    static final TransmitterEntityIdGetter __ID_GETTER = new TransmitterEntityIdGetter();
    public static final Property<TransmitterEntity> __ID_PROPERTY;
    public static final TransmitterEntity_ __INSTANCE;
    public static final Property<TransmitterEntity> accessId;
    public static final Property<TransmitterEntity> calIndex;
    public static final Property<TransmitterEntity> deviceKey;
    public static final Property<TransmitterEntity> deviceMac;
    public static final Property<TransmitterEntity> deviceModel;
    public static final Property<TransmitterEntity> deviceName;
    public static final Property<TransmitterEntity> deviceSn;
    public static final Property<TransmitterEntity> deviceType;
    public static final Property<TransmitterEntity> encryptionKey;
    public static final Property<TransmitterEntity> et;
    public static final Property<TransmitterEntity> eventIndex;
    public static final Property<TransmitterEntity> expirationTime;
    public static final Property<TransmitterEntity> fullEventIndex;
    public static final Property<TransmitterEntity> fullSensorIndex;
    public static final Property<TransmitterEntity> hyperThreshold;
    public static final Property<TransmitterEntity> hypoThreshold;
    public static final Property<TransmitterEntity> id;
    public static final Property<TransmitterEntity> idx;
    public static final Property<TransmitterEntity> modelName;
    public static final Property<TransmitterEntity> needReplace;
    public static final Property<TransmitterEntity> sensorId;
    public static final Property<TransmitterEntity> sensorIndex;
    public static final Property<TransmitterEntity> sensorStartTime;
    public static final Property<TransmitterEntity> version;

    public int getEntityId() {
        return 10;
    }

    static {
        TransmitterEntity_ transmitterEntity_ = new TransmitterEntity_();
        __INSTANCE = transmitterEntity_;
        TransmitterEntity_ transmitterEntity_2 = transmitterEntity_;
        Property<TransmitterEntity> property = new Property<>(transmitterEntity_2, 0, 1, Integer.TYPE, "calIndex");
        calIndex = property;
        Property<TransmitterEntity> property2 = new Property<>(transmitterEntity_2, 1, 2, Long.class, "idx", true, "idx");
        idx = property2;
        Property<TransmitterEntity> property3 = new Property<>(transmitterEntity_2, 2, 3, String.class, "id");
        id = property3;
        Property<TransmitterEntity> property4 = new Property<>(transmitterEntity_2, 3, 4, String.class, "deviceMac");
        deviceMac = property4;
        Property<TransmitterEntity> property5 = new Property<>(transmitterEntity_2, 4, 5, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property5;
        Property<TransmitterEntity> property6 = new Property<>(transmitterEntity_2, 5, 6, String.class, "deviceSn");
        deviceSn = property6;
        Property<TransmitterEntity> property7 = new Property<>(transmitterEntity_2, 6, 7, byte[].class, "accessId");
        accessId = property7;
        Property<TransmitterEntity> property8 = new Property<>(transmitterEntity_2, 7, 8, byte[].class, "encryptionKey");
        encryptionKey = property8;
        Property<TransmitterEntity> property9 = new Property<>(transmitterEntity_2, 8, 9, Date.class, "sensorStartTime");
        sensorStartTime = property9;
        Property<TransmitterEntity> property10 = new Property<>(transmitterEntity_2, 9, 10, Boolean.TYPE, "needReplace");
        needReplace = property10;
        Property<TransmitterEntity> property11 = new Property<>(transmitterEntity_2, 10, 11, Integer.TYPE, "deviceModel");
        deviceModel = property11;
        Property<TransmitterEntity> property12 = new Property<>(transmitterEntity_2, 11, 24, String.class, "modelName");
        modelName = property12;
        Property<TransmitterEntity> property13 = new Property<>(transmitterEntity_2, 12, 12, Integer.TYPE, "expirationTime");
        expirationTime = property13;
        Property<TransmitterEntity> property14 = new Property<>(transmitterEntity_2, 13, 13, Integer.TYPE, "sensorIndex");
        sensorIndex = property14;
        Property<TransmitterEntity> property15 = new Property<>(transmitterEntity_2, 14, 14, Integer.TYPE, "eventIndex");
        eventIndex = property15;
        Property<TransmitterEntity> property16 = new Property<>(transmitterEntity_2, 15, 15, Integer.TYPE, "fullEventIndex");
        fullEventIndex = property16;
        Property<TransmitterEntity> property17 = new Property<>(transmitterEntity_2, 16, 16, Integer.TYPE, "fullSensorIndex");
        fullSensorIndex = property17;
        Property<TransmitterEntity> property18 = new Property<>(transmitterEntity_2, 17, 17, Float.TYPE, "hyperThreshold");
        hyperThreshold = property18;
        Property<TransmitterEntity> property19 = new Property<>(transmitterEntity_2, 18, 18, Float.TYPE, "hypoThreshold");
        hypoThreshold = property19;
        Property<TransmitterEntity> property20 = new Property<>(transmitterEntity_2, 19, 19, String.class, "deviceKey");
        deviceKey = property20;
        Property<TransmitterEntity> property21 = new Property<>(transmitterEntity_2, 20, 20, Integer.TYPE, "et");
        et = property21;
        Property<TransmitterEntity> property22 = new Property<>(transmitterEntity_2, 21, 21, String.class, "deviceName");
        deviceName = property22;
        Property<TransmitterEntity> property23 = new Property<>(transmitterEntity_2, 22, 22, Integer.TYPE, "deviceType");
        deviceType = property23;
        Property<TransmitterEntity> property24 = new Property<>(transmitterEntity_2, 23, 23, String.class, "sensorId");
        sensorId = property24;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22, property23, property24};
        __ID_PROPERTY = property2;
    }

    public String getEntityName() {
        return "TransmitterEntity";
    }

    public Class<TransmitterEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "TransmitterEntity";
    }

    public Property<TransmitterEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<TransmitterEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<TransmitterEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<TransmitterEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class TransmitterEntityIdGetter implements IdGetter<TransmitterEntity> {
        TransmitterEntityIdGetter() {
        }

        public long getId(TransmitterEntity transmitterEntity) {
            Long idx = transmitterEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
