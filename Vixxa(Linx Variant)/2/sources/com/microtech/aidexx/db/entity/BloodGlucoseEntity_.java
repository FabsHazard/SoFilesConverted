package com.microtech.aidexx.db.entity;

import com.microtech.aidexx.db.entity.BloodGlucoseEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;

public final class BloodGlucoseEntity_ implements EntityInfo<BloodGlucoseEntity> {
    public static final Property<BloodGlucoseEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<BloodGlucoseEntity> __CURSOR_FACTORY = new BloodGlucoseEntityCursor.Factory();
    public static final String __DB_NAME = "BloodGlucoseEntity";
    public static final Class<BloodGlucoseEntity> __ENTITY_CLASS = BloodGlucoseEntity.class;
    public static final int __ENTITY_ID = 2;
    public static final String __ENTITY_NAME = "BloodGlucoseEntity";
    static final BloodGlucoseEntityIdGetter __ID_GETTER = new BloodGlucoseEntityIdGetter();
    public static final Property<BloodGlucoseEntity> __ID_PROPERTY;
    public static final BloodGlucoseEntity_ __INSTANCE;
    public static final Property<BloodGlucoseEntity> appCreateTime;
    public static final Property<BloodGlucoseEntity> appTime;
    public static final Property<BloodGlucoseEntity> appTimeZone;
    public static final Property<BloodGlucoseEntity> autoIncrementColumn;
    public static final Property<BloodGlucoseEntity> bloodGlucoseId;
    public static final Property<BloodGlucoseEntity> bloodGlucoseMg;
    public static final Property<BloodGlucoseEntity> deleteStatus;
    public static final Property<BloodGlucoseEntity> dstOffset;
    public static final Property<BloodGlucoseEntity> id;
    public static final Property<BloodGlucoseEntity> idx;
    public static final Property<BloodGlucoseEntity> language;
    public static final Property<BloodGlucoseEntity> moment;
    public static final Property<BloodGlucoseEntity> recordId;
    public static final Property<BloodGlucoseEntity> recordIndex;
    public static final Property<BloodGlucoseEntity> state;
    public static final Property<BloodGlucoseEntity> testTag;
    public static final Property<BloodGlucoseEntity> timestamp;
    public static final Property<BloodGlucoseEntity> uploadState;
    public static final Property<BloodGlucoseEntity> userId;

    public int getEntityId() {
        return 2;
    }

    static {
        BloodGlucoseEntity_ bloodGlucoseEntity_ = new BloodGlucoseEntity_();
        __INSTANCE = bloodGlucoseEntity_;
        BloodGlucoseEntity_ bloodGlucoseEntity_2 = bloodGlucoseEntity_;
        Property<BloodGlucoseEntity> property = new Property<>(bloodGlucoseEntity_2, 0, 2, Long.class, "idx", true, "idx");
        idx = property;
        Property<BloodGlucoseEntity> property2 = new Property<>(bloodGlucoseEntity_2, 1, 3, Integer.TYPE, "state");
        state = property2;
        Property<BloodGlucoseEntity> property3 = new Property<>(bloodGlucoseEntity_2, 2, 8, String.class, "id");
        id = property3;
        Property<BloodGlucoseEntity> property4 = new Property<>(bloodGlucoseEntity_2, 3, 17, String.class, "userId");
        userId = property4;
        Property<BloodGlucoseEntity> property5 = new Property<>(bloodGlucoseEntity_2, 4, 4, Long.class, "recordIndex");
        recordIndex = property5;
        Property<BloodGlucoseEntity> property6 = new Property<>(bloodGlucoseEntity_2, 5, 26, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<BloodGlucoseEntity> property7 = new Property<>(bloodGlucoseEntity_2, 6, 5, String.class, "recordId");
        recordId = property7;
        Property<BloodGlucoseEntity> property8 = new Property<>(bloodGlucoseEntity_2, 7, 6, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<BloodGlucoseEntity> property9 = new Property<>(bloodGlucoseEntity_2, 8, 13, String.class, "language");
        language = property9;
        Property<BloodGlucoseEntity> property10 = new Property<>(bloodGlucoseEntity_2, 9, 15, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<BloodGlucoseEntity> property11 = new Property<>(bloodGlucoseEntity_2, 10, 19, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<BloodGlucoseEntity> property12 = new Property<>(bloodGlucoseEntity_2, 11, 20, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<BloodGlucoseEntity> property13 = new Property<>(bloodGlucoseEntity_2, 12, 25, Integer.TYPE, "moment");
        moment = property13;
        Property<BloodGlucoseEntity> property14 = new Property<>(bloodGlucoseEntity_2, 13, 21, String.class, "appTime");
        appTime = property14;
        Property<BloodGlucoseEntity> property15 = new Property<>(bloodGlucoseEntity_2, 14, 22, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<BloodGlucoseEntity> property16 = new Property<>(bloodGlucoseEntity_2, 15, 23, String.class, "dstOffset");
        dstOffset = property16;
        Property<BloodGlucoseEntity> property17 = new Property<>(bloodGlucoseEntity_2, 16, 16, String.class, "bloodGlucoseId");
        bloodGlucoseId = property17;
        Property<BloodGlucoseEntity> property18 = new Property<>(bloodGlucoseEntity_2, 17, 10, Integer.TYPE, "testTag");
        testTag = property18;
        Property<BloodGlucoseEntity> property19 = new Property<>(bloodGlucoseEntity_2, 18, 14, Float.TYPE, "bloodGlucoseMg");
        bloodGlucoseMg = property19;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "BloodGlucoseEntity";
    }

    public Class<BloodGlucoseEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "BloodGlucoseEntity";
    }

    public Property<BloodGlucoseEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<BloodGlucoseEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<BloodGlucoseEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<BloodGlucoseEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class BloodGlucoseEntityIdGetter implements IdGetter<BloodGlucoseEntity> {
        BloodGlucoseEntityIdGetter() {
        }

        public long getId(BloodGlucoseEntity bloodGlucoseEntity) {
            Long idx = bloodGlucoseEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
