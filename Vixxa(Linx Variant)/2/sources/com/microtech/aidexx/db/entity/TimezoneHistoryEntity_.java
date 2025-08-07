package com.microtech.aidexx.db.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class TimezoneHistoryEntity_ implements EntityInfo<TimezoneHistoryEntity> {
    public static final Property<TimezoneHistoryEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<TimezoneHistoryEntity> __CURSOR_FACTORY = new TimezoneHistoryEntityCursor.Factory();
    public static final String __DB_NAME = "TimezoneHistoryEntity";
    public static final Class<TimezoneHistoryEntity> __ENTITY_CLASS = TimezoneHistoryEntity.class;
    public static final int __ENTITY_ID = 31;
    public static final String __ENTITY_NAME = "TimezoneHistoryEntity";
    static final TimezoneHistoryEntityIdGetter __ID_GETTER = new TimezoneHistoryEntityIdGetter();
    public static final Property<TimezoneHistoryEntity> __ID_PROPERTY;
    public static final TimezoneHistoryEntity_ __INSTANCE;
    public static final Property<TimezoneHistoryEntity> dstOffset;
    public static final Property<TimezoneHistoryEntity> from;
    public static final Property<TimezoneHistoryEntity> frontRecordId;
    public static final Property<TimezoneHistoryEntity> idx;
    public static final Property<TimezoneHistoryEntity> isDstChange;
    public static final Property<TimezoneHistoryEntity> sensorId;
    public static final Property<TimezoneHistoryEntity> timestamp;
    public static final Property<TimezoneHistoryEntity> to;
    public static final Property<TimezoneHistoryEntity> uploadState;
    public static final Property<TimezoneHistoryEntity> userId;

    public int getEntityId() {
        return 31;
    }

    static {
        TimezoneHistoryEntity_ timezoneHistoryEntity_ = new TimezoneHistoryEntity_();
        __INSTANCE = timezoneHistoryEntity_;
        TimezoneHistoryEntity_ timezoneHistoryEntity_2 = timezoneHistoryEntity_;
        Property<TimezoneHistoryEntity> property = new Property<>(timezoneHistoryEntity_2, 0, 1, Long.class, "idx", true, "idx");
        idx = property;
        Property<TimezoneHistoryEntity> property2 = new Property<>(timezoneHistoryEntity_2, 1, 2, String.class, TypedValues.TransitionType.S_FROM);
        from = property2;
        Property<TimezoneHistoryEntity> property3 = new Property<>(timezoneHistoryEntity_2, 2, 3, String.class, TypedValues.TransitionType.S_TO);
        to = property3;
        Property<TimezoneHistoryEntity> property4 = new Property<>(timezoneHistoryEntity_2, 3, 11, Integer.TYPE, "dstOffset");
        dstOffset = property4;
        Property<TimezoneHistoryEntity> property5 = new Property<>(timezoneHistoryEntity_2, 4, 9, Boolean.TYPE, "isDstChange");
        isDstChange = property5;
        Property<TimezoneHistoryEntity> property6 = new Property<>(timezoneHistoryEntity_2, 5, 4, String.class, "userId");
        userId = property6;
        Property<TimezoneHistoryEntity> property7 = new Property<>(timezoneHistoryEntity_2, 6, 5, String.class, "sensorId");
        sensorId = property7;
        Property<TimezoneHistoryEntity> property8 = new Property<>(timezoneHistoryEntity_2, 7, 6, Long.TYPE, "timestamp");
        timestamp = property8;
        Property<TimezoneHistoryEntity> property9 = new Property<>(timezoneHistoryEntity_2, 8, 7, Integer.TYPE, "uploadState");
        uploadState = property9;
        Property<TimezoneHistoryEntity> property10 = new Property<>(timezoneHistoryEntity_2, 9, 8, String.class, "frontRecordId");
        frontRecordId = property10;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "TimezoneHistoryEntity";
    }

    public Class<TimezoneHistoryEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "TimezoneHistoryEntity";
    }

    public Property<TimezoneHistoryEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<TimezoneHistoryEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<TimezoneHistoryEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<TimezoneHistoryEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class TimezoneHistoryEntityIdGetter implements IdGetter<TimezoneHistoryEntity> {
        TimezoneHistoryEntityIdGetter() {
        }

        public long getId(TimezoneHistoryEntity timezoneHistoryEntity) {
            Long idx = timezoneHistoryEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
