package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class DietUsrPresetEntity_ implements EntityInfo<DietUsrPresetEntity> {
    public static final Property<DietUsrPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<DietUsrPresetEntity> __CURSOR_FACTORY = new DietUsrPresetEntityCursor.Factory();
    public static final String __DB_NAME = "DietUsrPresetEntity";
    public static final Class<DietUsrPresetEntity> __ENTITY_CLASS = DietUsrPresetEntity.class;
    public static final int __ENTITY_ID = 22;
    public static final String __ENTITY_NAME = "DietUsrPresetEntity";
    static final DietUsrPresetEntityIdGetter __ID_GETTER = new DietUsrPresetEntityIdGetter();
    public static final Property<DietUsrPresetEntity> __ID_PROPERTY;
    public static final DietUsrPresetEntity_ __INSTANCE;
    public static final Property<DietUsrPresetEntity> autoIncrementColumn;
    public static final Property<DietUsrPresetEntity> carbohydrate;
    public static final Property<DietUsrPresetEntity> deleteFlag;
    public static final Property<DietUsrPresetEntity> fat;
    public static final Property<DietUsrPresetEntity> foodUserPresetId;
    public static final Property<DietUsrPresetEntity> idx;
    public static final Property<DietUsrPresetEntity> language;
    public static final Property<DietUsrPresetEntity> name;
    public static final Property<DietUsrPresetEntity> protein;
    public static final Property<DietUsrPresetEntity> quantity;
    public static final Property<DietUsrPresetEntity> unit;
    public static final Property<DietUsrPresetEntity> userId;

    public int getEntityId() {
        return 22;
    }

    static {
        DietUsrPresetEntity_ dietUsrPresetEntity_ = new DietUsrPresetEntity_();
        __INSTANCE = dietUsrPresetEntity_;
        DietUsrPresetEntity_ dietUsrPresetEntity_2 = dietUsrPresetEntity_;
        Property<DietUsrPresetEntity> property = new Property<>(dietUsrPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<DietUsrPresetEntity> property2 = new Property<>(dietUsrPresetEntity_2, 1, 2, String.class, "name");
        name = property2;
        Property<DietUsrPresetEntity> property3 = new Property<>(dietUsrPresetEntity_2, 2, 3, String.class, "userId");
        userId = property3;
        Property<DietUsrPresetEntity> property4 = new Property<>(dietUsrPresetEntity_2, 3, 13, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<DietUsrPresetEntity> property5 = new Property<>(dietUsrPresetEntity_2, 4, 5, String.class, "language");
        language = property5;
        Property<DietUsrPresetEntity> property6 = new Property<>(dietUsrPresetEntity_2, 5, 6, Double.TYPE, "protein");
        protein = property6;
        Property<DietUsrPresetEntity> property7 = new Property<>(dietUsrPresetEntity_2, 6, 7, Double.TYPE, "fat");
        fat = property7;
        Property<DietUsrPresetEntity> property8 = new Property<>(dietUsrPresetEntity_2, 7, 8, Double.TYPE, "carbohydrate");
        carbohydrate = property8;
        Property<DietUsrPresetEntity> property9 = new Property<>(dietUsrPresetEntity_2, 8, 9, Double.TYPE, "quantity");
        quantity = property9;
        Property<DietUsrPresetEntity> property10 = new Property<>(dietUsrPresetEntity_2, 9, 10, Integer.TYPE, "unit");
        unit = property10;
        Property<DietUsrPresetEntity> property11 = new Property<>(dietUsrPresetEntity_2, 10, 11, String.class, "foodUserPresetId");
        foodUserPresetId = property11;
        Property<DietUsrPresetEntity> property12 = new Property<>(dietUsrPresetEntity_2, 11, 12, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property12;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "DietUsrPresetEntity";
    }

    public Class<DietUsrPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "DietUsrPresetEntity";
    }

    public Property<DietUsrPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<DietUsrPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<DietUsrPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<DietUsrPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class DietUsrPresetEntityIdGetter implements IdGetter<DietUsrPresetEntity> {
        DietUsrPresetEntityIdGetter() {
        }

        public long getId(DietUsrPresetEntity dietUsrPresetEntity) {
            return dietUsrPresetEntity.getIdx();
        }
    }
}
