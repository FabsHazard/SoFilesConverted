package com.microtech.aidexx.db.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microtech.aidexx.db.entity.CalibrateEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;

public final class CalibrateEntity_ implements EntityInfo<CalibrateEntity> {
    public static final Property<CalibrateEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<CalibrateEntity> __CURSOR_FACTORY = new CalibrateEntityCursor.Factory();
    public static final String __DB_NAME = "CalibrateEntity";
    public static final Class<CalibrateEntity> __ENTITY_CLASS = CalibrateEntity.class;
    public static final int __ENTITY_ID = 3;
    public static final String __ENTITY_NAME = "CalibrateEntity";
    static final CalibrateEntityIdGetter __ID_GETTER = new CalibrateEntityIdGetter();
    public static final Property<CalibrateEntity> __ID_PROPERTY;
    public static final CalibrateEntity_ __INSTANCE;
    public static final Property<CalibrateEntity> appCreateTime;
    public static final Property<CalibrateEntity> appTime;
    public static final Property<CalibrateEntity> appTimeZone;
    public static final Property<CalibrateEntity> autoIncrementColumn;
    public static final Property<CalibrateEntity> calTime;
    public static final Property<CalibrateEntity> calibrationId;
    public static final Property<CalibrateEntity> cf;
    public static final Property<CalibrateEntity> deleteStatus;
    public static final Property<CalibrateEntity> deviceId;
    public static final Property<CalibrateEntity> dstOffset;
    public static final Property<CalibrateEntity> eventIndex;
    public static final Property<CalibrateEntity> id;
    public static final Property<CalibrateEntity> idx;
    public static final Property<CalibrateEntity> index;
    public static final Property<CalibrateEntity> indexAfterCal;
    public static final Property<CalibrateEntity> indexBeforeCal;
    public static final Property<CalibrateEntity> isValid;
    public static final Property<CalibrateEntity> language;
    public static final Property<CalibrateEntity> moment;
    public static final Property<CalibrateEntity> offset;
    public static final Property<CalibrateEntity> recordId;
    public static final Property<CalibrateEntity> recordIndex;
    public static final Property<CalibrateEntity> referenceGlucose;
    public static final Property<CalibrateEntity> sensorId;
    public static final Property<CalibrateEntity> sensorIndex;
    public static final Property<CalibrateEntity> state;
    public static final Property<CalibrateEntity> timeOffset;
    public static final Property<CalibrateEntity> timestamp;
    public static final Property<CalibrateEntity> uploadState;
    public static final Property<CalibrateEntity> userId;

    public int getEntityId() {
        return 3;
    }

    static {
        CalibrateEntity_ calibrateEntity_ = new CalibrateEntity_();
        __INSTANCE = calibrateEntity_;
        CalibrateEntity_ calibrateEntity_2 = calibrateEntity_;
        Property<CalibrateEntity> property = new Property<>(calibrateEntity_2, 0, 1, Long.class, "idx", true, "idx");
        idx = property;
        Property<CalibrateEntity> property2 = new Property<>(calibrateEntity_2, 1, 2, Integer.TYPE, "state");
        state = property2;
        Property<CalibrateEntity> property3 = new Property<>(calibrateEntity_2, 2, 7, String.class, "id");
        id = property3;
        Property<CalibrateEntity> property4 = new Property<>(calibrateEntity_2, 3, 21, String.class, "userId");
        userId = property4;
        Property<CalibrateEntity> property5 = new Property<>(calibrateEntity_2, 4, 10, Long.class, "recordIndex");
        recordIndex = property5;
        Property<CalibrateEntity> property6 = new Property<>(calibrateEntity_2, 5, 36, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<CalibrateEntity> property7 = new Property<>(calibrateEntity_2, 6, 6, String.class, "recordId");
        recordId = property7;
        Property<CalibrateEntity> property8 = new Property<>(calibrateEntity_2, 7, 11, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<CalibrateEntity> property9 = new Property<>(calibrateEntity_2, 8, 34, String.class, "language");
        language = property9;
        Property<CalibrateEntity> property10 = new Property<>(calibrateEntity_2, 9, 20, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<CalibrateEntity> property11 = new Property<>(calibrateEntity_2, 10, 28, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<CalibrateEntity> property12 = new Property<>(calibrateEntity_2, 11, 29, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<CalibrateEntity> property13 = new Property<>(calibrateEntity_2, 12, 35, Integer.TYPE, "moment");
        moment = property13;
        Property<CalibrateEntity> property14 = new Property<>(calibrateEntity_2, 13, 30, String.class, "appTime");
        appTime = property14;
        Property<CalibrateEntity> property15 = new Property<>(calibrateEntity_2, 14, 31, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<CalibrateEntity> property16 = new Property<>(calibrateEntity_2, 15, 32, String.class, "dstOffset");
        dstOffset = property16;
        Property<CalibrateEntity> property17 = new Property<>(calibrateEntity_2, 16, 4, Date.class, "calTime");
        calTime = property17;
        Property<CalibrateEntity> property18 = new Property<>(calibrateEntity_2, 17, 8, String.class, "deviceId");
        deviceId = property18;
        Property<CalibrateEntity> property19 = new Property<>(calibrateEntity_2, 18, 9, Integer.TYPE, "eventIndex");
        eventIndex = property19;
        Property<CalibrateEntity> property20 = new Property<>(calibrateEntity_2, 19, 22, String.class, "calibrationId");
        calibrationId = property20;
        Property<CalibrateEntity> property21 = new Property<>(calibrateEntity_2, 20, 13, Integer.TYPE, "sensorIndex");
        sensorIndex = property21;
        Property<CalibrateEntity> property22 = new Property<>(calibrateEntity_2, 21, 23, String.class, "sensorId");
        sensorId = property22;
        Property<CalibrateEntity> property23 = new Property<>(calibrateEntity_2, 22, 14, Float.TYPE, "referenceGlucose");
        referenceGlucose = property23;
        Property<CalibrateEntity> property24 = new Property<>(calibrateEntity_2, 23, 15, Integer.TYPE, "indexBeforeCal");
        indexBeforeCal = property24;
        Property<CalibrateEntity> property25 = new Property<>(calibrateEntity_2, 24, 16, Integer.TYPE, "indexAfterCal");
        indexAfterCal = property25;
        Property<CalibrateEntity> property26 = new Property<>(calibrateEntity_2, 25, 24, Float.TYPE, "cf");
        cf = property26;
        Property<CalibrateEntity> property27 = new Property<>(calibrateEntity_2, 26, 25, Float.TYPE, TypedValues.CycleType.S_WAVE_OFFSET);
        offset = property27;
        Property<CalibrateEntity> property28 = new Property<>(calibrateEntity_2, 27, 19, Integer.class, "isValid");
        isValid = property28;
        Property<CalibrateEntity> property29 = new Property<>(calibrateEntity_2, 28, 26, Integer.TYPE, "index");
        index = property29;
        Property<CalibrateEntity> property30 = new Property<>(calibrateEntity_2, 29, 27, Integer.TYPE, "timeOffset");
        timeOffset = property30;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22, property23, property24, property25, property26, property27, property28, property29, property30};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "CalibrateEntity";
    }

    public Class<CalibrateEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "CalibrateEntity";
    }

    public Property<CalibrateEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<CalibrateEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<CalibrateEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<CalibrateEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class CalibrateEntityIdGetter implements IdGetter<CalibrateEntity> {
        CalibrateEntityIdGetter() {
        }

        public long getId(CalibrateEntity calibrateEntity) {
            Long idx = calibrateEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
