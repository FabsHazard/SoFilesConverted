package com.microtech.aidexx.db.entity.event.preset;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class InsulinSysPresetEntity_ implements EntityInfo<InsulinSysPresetEntity> {
    public static final Property<InsulinSysPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<InsulinSysPresetEntity> __CURSOR_FACTORY = new InsulinSysPresetEntityCursor.Factory();
    public static final String __DB_NAME = "InsulinSysPresetEntity";
    public static final Class<InsulinSysPresetEntity> __ENTITY_CLASS = InsulinSysPresetEntity.class;
    public static final int __ENTITY_ID = 21;
    public static final String __ENTITY_NAME = "InsulinSysPresetEntity";
    static final InsulinSysPresetEntityIdGetter __ID_GETTER = new InsulinSysPresetEntityIdGetter();
    public static final Property<InsulinSysPresetEntity> __ID_PROPERTY;
    public static final InsulinSysPresetEntity_ __INSTANCE;
    public static final Property<InsulinSysPresetEntity> categoryName;
    public static final Property<InsulinSysPresetEntity> comment;
    public static final Property<InsulinSysPresetEntity> deleteFlag;
    public static final Property<InsulinSysPresetEntity> idx;
    public static final Property<InsulinSysPresetEntity> insulinSysPresetId;
    public static final Property<InsulinSysPresetEntity> language;
    public static final Property<InsulinSysPresetEntity> manufacturer;
    public static final Property<InsulinSysPresetEntity> name;
    public static final Property<InsulinSysPresetEntity> tradeName;
    public static final Property<InsulinSysPresetEntity> userId;
    public static final Property<InsulinSysPresetEntity> version;

    public int getEntityId() {
        return 21;
    }

    static {
        InsulinSysPresetEntity_ insulinSysPresetEntity_ = new InsulinSysPresetEntity_();
        __INSTANCE = insulinSysPresetEntity_;
        InsulinSysPresetEntity_ insulinSysPresetEntity_2 = insulinSysPresetEntity_;
        Property<InsulinSysPresetEntity> property = new Property<>(insulinSysPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<InsulinSysPresetEntity> property2 = new Property<>(insulinSysPresetEntity_2, 1, 2, String.class, "name");
        name = property2;
        Property<InsulinSysPresetEntity> property3 = new Property<>(insulinSysPresetEntity_2, 2, 3, String.class, "userId");
        userId = property3;
        Property<InsulinSysPresetEntity> property4 = new Property<>(insulinSysPresetEntity_2, 3, 11, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<InsulinSysPresetEntity> property5 = new Property<>(insulinSysPresetEntity_2, 4, 10, String.class, "language");
        language = property5;
        Property<InsulinSysPresetEntity> property6 = new Property<>(insulinSysPresetEntity_2, 5, 5, String.class, "categoryName");
        categoryName = property6;
        Property<InsulinSysPresetEntity> property7 = new Property<>(insulinSysPresetEntity_2, 6, 6, String.class, "tradeName");
        tradeName = property7;
        Property<InsulinSysPresetEntity> property8 = new Property<>(insulinSysPresetEntity_2, 7, 7, String.class, "manufacturer");
        manufacturer = property8;
        Property<InsulinSysPresetEntity> property9 = new Property<>(insulinSysPresetEntity_2, 8, 8, String.class, "comment");
        comment = property9;
        Property<InsulinSysPresetEntity> property10 = new Property<>(insulinSysPresetEntity_2, 9, 9, Long.class, "insulinSysPresetId");
        insulinSysPresetId = property10;
        Property<InsulinSysPresetEntity> property11 = new Property<>(insulinSysPresetEntity_2, 10, 12, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property11;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "InsulinSysPresetEntity";
    }

    public Class<InsulinSysPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "InsulinSysPresetEntity";
    }

    public Property<InsulinSysPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<InsulinSysPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<InsulinSysPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<InsulinSysPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class InsulinSysPresetEntityIdGetter implements IdGetter<InsulinSysPresetEntity> {
        InsulinSysPresetEntityIdGetter() {
        }

        public long getId(InsulinSysPresetEntity insulinSysPresetEntity) {
            return insulinSysPresetEntity.getIdx();
        }
    }
}
