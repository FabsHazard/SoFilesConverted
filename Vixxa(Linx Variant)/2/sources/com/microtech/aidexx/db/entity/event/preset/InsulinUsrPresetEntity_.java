package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class InsulinUsrPresetEntity_ implements EntityInfo<InsulinUsrPresetEntity> {
    public static final Property<InsulinUsrPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<InsulinUsrPresetEntity> __CURSOR_FACTORY = new InsulinUsrPresetEntityCursor.Factory();
    public static final String __DB_NAME = "InsulinUsrPresetEntity";
    public static final Class<InsulinUsrPresetEntity> __ENTITY_CLASS = InsulinUsrPresetEntity.class;
    public static final int __ENTITY_ID = 23;
    public static final String __ENTITY_NAME = "InsulinUsrPresetEntity";
    static final InsulinUsrPresetEntityIdGetter __ID_GETTER = new InsulinUsrPresetEntityIdGetter();
    public static final Property<InsulinUsrPresetEntity> __ID_PROPERTY;
    public static final InsulinUsrPresetEntity_ __INSTANCE;
    public static final Property<InsulinUsrPresetEntity> autoIncrementColumn;
    public static final Property<InsulinUsrPresetEntity> categoryName;
    public static final Property<InsulinUsrPresetEntity> comment;
    public static final Property<InsulinUsrPresetEntity> deleteFlag;
    public static final Property<InsulinUsrPresetEntity> idx;
    public static final Property<InsulinUsrPresetEntity> insulinUserPresetId;
    public static final Property<InsulinUsrPresetEntity> language;
    public static final Property<InsulinUsrPresetEntity> manufacturer;
    public static final Property<InsulinUsrPresetEntity> name;
    public static final Property<InsulinUsrPresetEntity> tradeName;
    public static final Property<InsulinUsrPresetEntity> userId;

    public int getEntityId() {
        return 23;
    }

    static {
        InsulinUsrPresetEntity_ insulinUsrPresetEntity_ = new InsulinUsrPresetEntity_();
        __INSTANCE = insulinUsrPresetEntity_;
        InsulinUsrPresetEntity_ insulinUsrPresetEntity_2 = insulinUsrPresetEntity_;
        Property<InsulinUsrPresetEntity> property = new Property<>(insulinUsrPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<InsulinUsrPresetEntity> property2 = new Property<>(insulinUsrPresetEntity_2, 1, 2, String.class, "name");
        name = property2;
        Property<InsulinUsrPresetEntity> property3 = new Property<>(insulinUsrPresetEntity_2, 2, 3, String.class, "userId");
        userId = property3;
        Property<InsulinUsrPresetEntity> property4 = new Property<>(insulinUsrPresetEntity_2, 3, 12, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<InsulinUsrPresetEntity> property5 = new Property<>(insulinUsrPresetEntity_2, 4, 5, String.class, "language");
        language = property5;
        Property<InsulinUsrPresetEntity> property6 = new Property<>(insulinUsrPresetEntity_2, 5, 6, String.class, "categoryName");
        categoryName = property6;
        Property<InsulinUsrPresetEntity> property7 = new Property<>(insulinUsrPresetEntity_2, 6, 7, String.class, "tradeName");
        tradeName = property7;
        Property<InsulinUsrPresetEntity> property8 = new Property<>(insulinUsrPresetEntity_2, 7, 8, String.class, "manufacturer");
        manufacturer = property8;
        Property<InsulinUsrPresetEntity> property9 = new Property<>(insulinUsrPresetEntity_2, 8, 9, String.class, "comment");
        comment = property9;
        Property<InsulinUsrPresetEntity> property10 = new Property<>(insulinUsrPresetEntity_2, 9, 10, String.class, "insulinUserPresetId");
        insulinUserPresetId = property10;
        Property<InsulinUsrPresetEntity> property11 = new Property<>(insulinUsrPresetEntity_2, 10, 11, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "InsulinUsrPresetEntity";
    }

    public Class<InsulinUsrPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "InsulinUsrPresetEntity";
    }

    public Property<InsulinUsrPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<InsulinUsrPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<InsulinUsrPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<InsulinUsrPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class InsulinUsrPresetEntityIdGetter implements IdGetter<InsulinUsrPresetEntity> {
        InsulinUsrPresetEntityIdGetter() {
        }

        public long getId(InsulinUsrPresetEntity insulinUsrPresetEntity) {
            return insulinUsrPresetEntity.getIdx();
        }
    }
}
