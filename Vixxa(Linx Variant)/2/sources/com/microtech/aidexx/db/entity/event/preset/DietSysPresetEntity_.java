package com.microtech.aidexx.db.entity.event.preset;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class DietSysPresetEntity_ implements EntityInfo<DietSysPresetEntity> {
    public static final Property<DietSysPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<DietSysPresetEntity> __CURSOR_FACTORY = new DietSysPresetEntityCursor.Factory();
    public static final String __DB_NAME = "DietSysPresetEntity";
    public static final Class<DietSysPresetEntity> __ENTITY_CLASS = DietSysPresetEntity.class;
    public static final int __ENTITY_ID = 20;
    public static final String __ENTITY_NAME = "DietSysPresetEntity";
    static final DietSysPresetEntityIdGetter __ID_GETTER = new DietSysPresetEntityIdGetter();
    public static final Property<DietSysPresetEntity> __ID_PROPERTY;
    public static final DietSysPresetEntity_ __INSTANCE;
    public static final Property<DietSysPresetEntity> carbohydrate;
    public static final Property<DietSysPresetEntity> deleteFlag;
    public static final Property<DietSysPresetEntity> energyKcal;
    public static final Property<DietSysPresetEntity> fat;
    public static final Property<DietSysPresetEntity> foodSysPresetId;
    public static final Property<DietSysPresetEntity> idx;
    public static final Property<DietSysPresetEntity> language;
    public static final Property<DietSysPresetEntity> name;
    public static final Property<DietSysPresetEntity> protein;
    public static final Property<DietSysPresetEntity> quantity;
    public static final Property<DietSysPresetEntity> unit;
    public static final Property<DietSysPresetEntity> userId;
    public static final Property<DietSysPresetEntity> version;

    public int getEntityId() {
        return 20;
    }

    static {
        DietSysPresetEntity_ dietSysPresetEntity_ = new DietSysPresetEntity_();
        __INSTANCE = dietSysPresetEntity_;
        DietSysPresetEntity_ dietSysPresetEntity_2 = dietSysPresetEntity_;
        Property<DietSysPresetEntity> property = new Property<>(dietSysPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<DietSysPresetEntity> property2 = new Property<>(dietSysPresetEntity_2, 1, 2, String.class, "name");
        name = property2;
        Property<DietSysPresetEntity> property3 = new Property<>(dietSysPresetEntity_2, 2, 3, String.class, "userId");
        userId = property3;
        Property<DietSysPresetEntity> property4 = new Property<>(dietSysPresetEntity_2, 3, 13, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<DietSysPresetEntity> property5 = new Property<>(dietSysPresetEntity_2, 4, 12, String.class, "language");
        language = property5;
        Property<DietSysPresetEntity> property6 = new Property<>(dietSysPresetEntity_2, 5, 5, Double.TYPE, "protein");
        protein = property6;
        Property<DietSysPresetEntity> property7 = new Property<>(dietSysPresetEntity_2, 6, 6, Double.TYPE, "fat");
        fat = property7;
        Property<DietSysPresetEntity> property8 = new Property<>(dietSysPresetEntity_2, 7, 7, Double.TYPE, "carbohydrate");
        carbohydrate = property8;
        Property<DietSysPresetEntity> property9 = new Property<>(dietSysPresetEntity_2, 8, 8, Double.TYPE, "quantity");
        quantity = property9;
        Property<DietSysPresetEntity> property10 = new Property<>(dietSysPresetEntity_2, 9, 9, Integer.TYPE, "unit");
        unit = property10;
        Property<DietSysPresetEntity> property11 = new Property<>(dietSysPresetEntity_2, 10, 10, Double.TYPE, "energyKcal");
        energyKcal = property11;
        Property<DietSysPresetEntity> property12 = new Property<>(dietSysPresetEntity_2, 11, 11, Long.class, "foodSysPresetId");
        foodSysPresetId = property12;
        Property<DietSysPresetEntity> property13 = new Property<>(dietSysPresetEntity_2, 12, 15, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property13;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "DietSysPresetEntity";
    }

    public Class<DietSysPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "DietSysPresetEntity";
    }

    public Property<DietSysPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<DietSysPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<DietSysPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<DietSysPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class DietSysPresetEntityIdGetter implements IdGetter<DietSysPresetEntity> {
        DietSysPresetEntityIdGetter() {
        }

        public long getId(DietSysPresetEntity dietSysPresetEntity) {
            return dietSysPresetEntity.getIdx();
        }
    }
}
