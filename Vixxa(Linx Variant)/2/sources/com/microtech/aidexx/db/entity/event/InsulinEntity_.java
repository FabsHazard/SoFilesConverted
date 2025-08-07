package com.microtech.aidexx.db.entity.event;

import com.microtech.aidexx.db.entity.event.InsulinEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;
import java.util.List;

public final class InsulinEntity_ implements EntityInfo<InsulinEntity> {
    public static final Property<InsulinEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<InsulinEntity> __CURSOR_FACTORY = new InsulinEntityCursor.Factory();
    public static final String __DB_NAME = "InsulinEntity";
    public static final Class<InsulinEntity> __ENTITY_CLASS = InsulinEntity.class;
    public static final int __ENTITY_ID = 6;
    public static final String __ENTITY_NAME = "InsulinEntity";
    static final InsulinEntityIdGetter __ID_GETTER = new InsulinEntityIdGetter();
    public static final Property<InsulinEntity> __ID_PROPERTY;
    public static final InsulinEntity_ __INSTANCE;
    public static final Property<InsulinEntity> appCreateTime;
    public static final Property<InsulinEntity> appTime;
    public static final Property<InsulinEntity> appTimeZone;
    public static final Property<InsulinEntity> autoIncrementColumn;
    public static final Property<InsulinEntity> deleteStatus;
    public static final Property<InsulinEntity> dstOffset;
    public static final Property<InsulinEntity> expandList;
    public static final Property<InsulinEntity> id;
    public static final Property<InsulinEntity> idx;
    public static final Property<InsulinEntity> injectionTime;
    public static final Property<InsulinEntity> insulinDosage;
    public static final Property<InsulinEntity> insulinId;
    public static final Property<InsulinEntity> insulinName;
    public static final Property<InsulinEntity> isPreset;
    public static final Property<InsulinEntity> language;
    public static final Property<InsulinEntity> moment;
    public static final Property<InsulinEntity> recordId;
    public static final Property<InsulinEntity> recordIndex;
    public static final Property<InsulinEntity> state;
    public static final Property<InsulinEntity> timestamp;
    public static final Property<InsulinEntity> uploadState;
    public static final Property<InsulinEntity> userId;

    public int getEntityId() {
        return 6;
    }

    static {
        InsulinEntity_ insulinEntity_ = new InsulinEntity_();
        __INSTANCE = insulinEntity_;
        InsulinEntity_ insulinEntity_2 = insulinEntity_;
        Property<InsulinEntity> property = new Property<>(insulinEntity_2, 0, 2, Long.class, "idx", true, "idx");
        idx = property;
        Property<InsulinEntity> property2 = new Property<>(insulinEntity_2, 1, 3, Integer.TYPE, "state");
        state = property2;
        Property<InsulinEntity> property3 = new Property<>(insulinEntity_2, 2, 4, String.class, "id");
        id = property3;
        Property<InsulinEntity> property4 = new Property<>(insulinEntity_2, 3, 18, String.class, "userId");
        userId = property4;
        Property<InsulinEntity> property5 = new Property<>(insulinEntity_2, 4, 5, Long.class, "recordIndex");
        recordIndex = property5;
        Property<InsulinEntity> property6 = new Property<>(insulinEntity_2, 5, 28, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<InsulinEntity> property7 = new Property<>(insulinEntity_2, 6, 15, String.class, "recordId");
        recordId = property7;
        Property<InsulinEntity> property8 = new Property<>(insulinEntity_2, 7, 6, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<InsulinEntity> property9 = new Property<>(insulinEntity_2, 8, 16, String.class, "language");
        language = property9;
        Property<InsulinEntity> property10 = new Property<>(insulinEntity_2, 9, 17, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<InsulinEntity> property11 = new Property<>(insulinEntity_2, 10, 24, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<InsulinEntity> property12 = new Property<>(insulinEntity_2, 11, 20, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<InsulinEntity> property13 = new Property<>(insulinEntity_2, 12, 27, Integer.TYPE, "moment");
        moment = property13;
        Property<InsulinEntity> property14 = new Property<>(insulinEntity_2, 13, 21, String.class, "appTime");
        appTime = property14;
        Property<InsulinEntity> property15 = new Property<>(insulinEntity_2, 14, 22, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<InsulinEntity> property16 = new Property<>(insulinEntity_2, 15, 23, String.class, "dstOffset");
        dstOffset = property16;
        Property<InsulinEntity> property17 = new Property<>(insulinEntity_2, 16, 7, Date.class, "injectionTime");
        injectionTime = property17;
        Property<InsulinEntity> property18 = new Property<>(insulinEntity_2, 17, 8, String.class, "insulinName");
        insulinName = property18;
        Property<InsulinEntity> property19 = new Property<>(insulinEntity_2, 18, 25, String.class, "insulinId");
        insulinId = property19;
        Property<InsulinEntity> property20 = new Property<>(insulinEntity_2, 19, 10, Float.class, "insulinDosage");
        insulinDosage = property20;
        Property<InsulinEntity> property21 = new Property<>(insulinEntity_2, 20, 11, Boolean.TYPE, "isPreset");
        isPreset = property21;
        Property<InsulinEntity> property22 = new Property<>(insulinEntity_2, 21, 26, String.class, "expandList", false, "expandList", InsulinDetail.class, List.class);
        expandList = property22;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "InsulinEntity";
    }

    public Class<InsulinEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "InsulinEntity";
    }

    public Property<InsulinEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<InsulinEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<InsulinEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<InsulinEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class InsulinEntityIdGetter implements IdGetter<InsulinEntity> {
        InsulinEntityIdGetter() {
        }

        public long getId(InsulinEntity insulinEntity) {
            Long idx = insulinEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
