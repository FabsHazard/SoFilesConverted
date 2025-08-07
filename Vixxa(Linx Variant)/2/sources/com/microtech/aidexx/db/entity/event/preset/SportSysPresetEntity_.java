package com.microtech.aidexx.db.entity.event.preset;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class SportSysPresetEntity_ implements EntityInfo<SportSysPresetEntity> {
    public static final Property<SportSysPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<SportSysPresetEntity> __CURSOR_FACTORY = new SportSysPresetEntityCursor.Factory();
    public static final String __DB_NAME = "SportSysPresetEntity";
    public static final Class<SportSysPresetEntity> __ENTITY_CLASS = SportSysPresetEntity.class;
    public static final int __ENTITY_ID = 18;
    public static final String __ENTITY_NAME = "SportSysPresetEntity";
    static final SportSysPresetEntityIdGetter __ID_GETTER = new SportSysPresetEntityIdGetter();
    public static final Property<SportSysPresetEntity> __ID_PROPERTY;
    public static final SportSysPresetEntity_ __INSTANCE;
    public static final Property<SportSysPresetEntity> deleteFlag;
    public static final Property<SportSysPresetEntity> exerciseSysPresetId;
    public static final Property<SportSysPresetEntity> hourKcalPerKg;
    public static final Property<SportSysPresetEntity> idx;
    public static final Property<SportSysPresetEntity> intensityCategoryName;
    public static final Property<SportSysPresetEntity> language;
    public static final Property<SportSysPresetEntity> name;
    public static final Property<SportSysPresetEntity> userId;
    public static final Property<SportSysPresetEntity> version;

    public int getEntityId() {
        return 18;
    }

    static {
        SportSysPresetEntity_ sportSysPresetEntity_ = new SportSysPresetEntity_();
        __INSTANCE = sportSysPresetEntity_;
        SportSysPresetEntity_ sportSysPresetEntity_2 = sportSysPresetEntity_;
        Property<SportSysPresetEntity> property = new Property<>(sportSysPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<SportSysPresetEntity> property2 = new Property<>(sportSysPresetEntity_2, 1, 5, String.class, "name");
        name = property2;
        Property<SportSysPresetEntity> property3 = new Property<>(sportSysPresetEntity_2, 2, 9, String.class, "userId");
        userId = property3;
        Property<SportSysPresetEntity> property4 = new Property<>(sportSysPresetEntity_2, 3, 13, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<SportSysPresetEntity> property5 = new Property<>(sportSysPresetEntity_2, 4, 12, String.class, "language");
        language = property5;
        Property<SportSysPresetEntity> property6 = new Property<>(sportSysPresetEntity_2, 5, 7, String.class, "intensityCategoryName");
        intensityCategoryName = property6;
        Property<SportSysPresetEntity> property7 = new Property<>(sportSysPresetEntity_2, 6, 8, Double.TYPE, "hourKcalPerKg");
        hourKcalPerKg = property7;
        Property<SportSysPresetEntity> property8 = new Property<>(sportSysPresetEntity_2, 7, 11, Long.class, "exerciseSysPresetId");
        exerciseSysPresetId = property8;
        Property<SportSysPresetEntity> property9 = new Property<>(sportSysPresetEntity_2, 8, 14, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property9;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "SportSysPresetEntity";
    }

    public Class<SportSysPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "SportSysPresetEntity";
    }

    public Property<SportSysPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<SportSysPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<SportSysPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<SportSysPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class SportSysPresetEntityIdGetter implements IdGetter<SportSysPresetEntity> {
        SportSysPresetEntityIdGetter() {
        }

        public long getId(SportSysPresetEntity sportSysPresetEntity) {
            return sportSysPresetEntity.getIdx();
        }
    }
}
