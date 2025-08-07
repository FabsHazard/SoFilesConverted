package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class SportUsrPresetEntity_ implements EntityInfo<SportUsrPresetEntity> {
    public static final Property<SportUsrPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<SportUsrPresetEntity> __CURSOR_FACTORY = new SportUsrPresetEntityCursor.Factory();
    public static final String __DB_NAME = "SportUsrPresetEntity";
    public static final Class<SportUsrPresetEntity> __ENTITY_CLASS = SportUsrPresetEntity.class;
    public static final int __ENTITY_ID = 19;
    public static final String __ENTITY_NAME = "SportUsrPresetEntity";
    static final SportUsrPresetEntityIdGetter __ID_GETTER = new SportUsrPresetEntityIdGetter();
    public static final Property<SportUsrPresetEntity> __ID_PROPERTY;
    public static final SportUsrPresetEntity_ __INSTANCE;
    public static final Property<SportUsrPresetEntity> autoIncrementColumn;
    public static final Property<SportUsrPresetEntity> deleteFlag;
    public static final Property<SportUsrPresetEntity> exerciseUserPresetId;
    public static final Property<SportUsrPresetEntity> hourKcalPerKg;
    public static final Property<SportUsrPresetEntity> idx;
    public static final Property<SportUsrPresetEntity> intensityCategoryName;
    public static final Property<SportUsrPresetEntity> language;
    public static final Property<SportUsrPresetEntity> name;
    public static final Property<SportUsrPresetEntity> userId;

    public int getEntityId() {
        return 19;
    }

    static {
        SportUsrPresetEntity_ sportUsrPresetEntity_ = new SportUsrPresetEntity_();
        __INSTANCE = sportUsrPresetEntity_;
        SportUsrPresetEntity_ sportUsrPresetEntity_2 = sportUsrPresetEntity_;
        Property<SportUsrPresetEntity> property = new Property<>(sportUsrPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<SportUsrPresetEntity> property2 = new Property<>(sportUsrPresetEntity_2, 1, 5, String.class, "name");
        name = property2;
        Property<SportUsrPresetEntity> property3 = new Property<>(sportUsrPresetEntity_2, 2, 9, String.class, "userId");
        userId = property3;
        Property<SportUsrPresetEntity> property4 = new Property<>(sportUsrPresetEntity_2, 3, 14, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<SportUsrPresetEntity> property5 = new Property<>(sportUsrPresetEntity_2, 4, 13, String.class, "language");
        language = property5;
        Property<SportUsrPresetEntity> property6 = new Property<>(sportUsrPresetEntity_2, 5, 7, String.class, "intensityCategoryName");
        intensityCategoryName = property6;
        Property<SportUsrPresetEntity> property7 = new Property<>(sportUsrPresetEntity_2, 6, 8, Double.TYPE, "hourKcalPerKg");
        hourKcalPerKg = property7;
        Property<SportUsrPresetEntity> property8 = new Property<>(sportUsrPresetEntity_2, 7, 11, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property8;
        Property<SportUsrPresetEntity> property9 = new Property<>(sportUsrPresetEntity_2, 8, 12, String.class, "exerciseUserPresetId");
        exerciseUserPresetId = property9;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "SportUsrPresetEntity";
    }

    public Class<SportUsrPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "SportUsrPresetEntity";
    }

    public Property<SportUsrPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<SportUsrPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<SportUsrPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<SportUsrPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class SportUsrPresetEntityIdGetter implements IdGetter<SportUsrPresetEntity> {
        SportUsrPresetEntityIdGetter() {
        }

        public long getId(SportUsrPresetEntity sportUsrPresetEntity) {
            return sportUsrPresetEntity.getIdx();
        }
    }
}
