package com.microtech.aidexx.db.entity.event;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.event.UnitEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class UnitEntity_ implements EntityInfo<UnitEntity> {
    public static final Property<UnitEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<UnitEntity> __CURSOR_FACTORY = new UnitEntityCursor.Factory();
    public static final String __DB_NAME = "UnitEntity";
    public static final Class<UnitEntity> __ENTITY_CLASS = UnitEntity.class;
    public static final int __ENTITY_ID = 24;
    public static final String __ENTITY_NAME = "UnitEntity";
    static final UnitEntityIdGetter __ID_GETTER = new UnitEntityIdGetter();
    public static final Property<UnitEntity> __ID_PROPERTY;
    public static final UnitEntity_ __INSTANCE;
    public static final Property<UnitEntity> eventType;
    public static final Property<UnitEntity> id;
    public static final Property<UnitEntity> isDefault;
    public static final Property<UnitEntity> language;
    public static final Property<UnitEntity> name;
    public static final Property<UnitEntity> ratio;
    public static final Property<UnitEntity> value;
    public static final Property<UnitEntity> version;

    public int getEntityId() {
        return 24;
    }

    static {
        UnitEntity_ unitEntity_ = new UnitEntity_();
        __INSTANCE = unitEntity_;
        UnitEntity_ unitEntity_2 = unitEntity_;
        Property<UnitEntity> property = new Property<>(unitEntity_2, 0, 1, Long.TYPE, "id", true, "id");
        id = property;
        Property<UnitEntity> property2 = new Property<>(unitEntity_2, 1, 10, Integer.TYPE, "eventType");
        eventType = property2;
        Property<UnitEntity> property3 = new Property<>(unitEntity_2, 2, 11, Integer.TYPE, "value");
        value = property3;
        Property<UnitEntity> property4 = new Property<>(unitEntity_2, 3, 3, Integer.TYPE, "isDefault");
        isDefault = property4;
        Property<UnitEntity> property5 = new Property<>(unitEntity_2, 4, 5, String.class, "language");
        language = property5;
        Property<UnitEntity> property6 = new Property<>(unitEntity_2, 5, 7, String.class, "name");
        name = property6;
        Property<UnitEntity> property7 = new Property<>(unitEntity_2, 6, 8, Double.TYPE, "ratio");
        ratio = property7;
        Property<UnitEntity> property8 = new Property<>(unitEntity_2, 7, 12, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property8;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "UnitEntity";
    }

    public Class<UnitEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "UnitEntity";
    }

    public Property<UnitEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<UnitEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<UnitEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<UnitEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class UnitEntityIdGetter implements IdGetter<UnitEntity> {
        UnitEntityIdGetter() {
        }

        public long getId(UnitEntity unitEntity) {
            return unitEntity.getId();
        }
    }
}
