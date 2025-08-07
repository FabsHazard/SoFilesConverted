package com.microtech.aidexx.db.entity.event.preset;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class MedicineSysPresetEntity_ implements EntityInfo<MedicineSysPresetEntity> {
    public static final Property<MedicineSysPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<MedicineSysPresetEntity> __CURSOR_FACTORY = new MedicineSysPresetEntityCursor.Factory();
    public static final String __DB_NAME = "MedicineSysPresetEntity";
    public static final Class<MedicineSysPresetEntity> __ENTITY_CLASS = MedicineSysPresetEntity.class;
    public static final int __ENTITY_ID = 16;
    public static final String __ENTITY_NAME = "MedicineSysPresetEntity";
    static final MedicineSysPresetEntityIdGetter __ID_GETTER = new MedicineSysPresetEntityIdGetter();
    public static final Property<MedicineSysPresetEntity> __ID_PROPERTY;
    public static final MedicineSysPresetEntity_ __INSTANCE;
    public static final Property<MedicineSysPresetEntity> categoryName;
    public static final Property<MedicineSysPresetEntity> deleteFlag;
    public static final Property<MedicineSysPresetEntity> englishName;
    public static final Property<MedicineSysPresetEntity> idx;
    public static final Property<MedicineSysPresetEntity> language;
    public static final Property<MedicineSysPresetEntity> manufacturer;
    public static final Property<MedicineSysPresetEntity> medicationSysPresetId;
    public static final Property<MedicineSysPresetEntity> name;
    public static final Property<MedicineSysPresetEntity> tradeName;
    public static final Property<MedicineSysPresetEntity> userId;
    public static final Property<MedicineSysPresetEntity> version;

    public int getEntityId() {
        return 16;
    }

    static {
        MedicineSysPresetEntity_ medicineSysPresetEntity_ = new MedicineSysPresetEntity_();
        __INSTANCE = medicineSysPresetEntity_;
        MedicineSysPresetEntity_ medicineSysPresetEntity_2 = medicineSysPresetEntity_;
        Property<MedicineSysPresetEntity> property = new Property<>(medicineSysPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<MedicineSysPresetEntity> property2 = new Property<>(medicineSysPresetEntity_2, 1, 5, String.class, "name");
        name = property2;
        Property<MedicineSysPresetEntity> property3 = new Property<>(medicineSysPresetEntity_2, 2, 11, String.class, "userId");
        userId = property3;
        Property<MedicineSysPresetEntity> property4 = new Property<>(medicineSysPresetEntity_2, 3, 15, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<MedicineSysPresetEntity> property5 = new Property<>(medicineSysPresetEntity_2, 4, 14, String.class, "language");
        language = property5;
        Property<MedicineSysPresetEntity> property6 = new Property<>(medicineSysPresetEntity_2, 5, 7, String.class, "categoryName");
        categoryName = property6;
        Property<MedicineSysPresetEntity> property7 = new Property<>(medicineSysPresetEntity_2, 6, 8, String.class, "tradeName");
        tradeName = property7;
        Property<MedicineSysPresetEntity> property8 = new Property<>(medicineSysPresetEntity_2, 7, 9, String.class, "manufacturer");
        manufacturer = property8;
        Property<MedicineSysPresetEntity> property9 = new Property<>(medicineSysPresetEntity_2, 8, 10, String.class, "englishName");
        englishName = property9;
        Property<MedicineSysPresetEntity> property10 = new Property<>(medicineSysPresetEntity_2, 9, 13, Long.class, "medicationSysPresetId");
        medicationSysPresetId = property10;
        Property<MedicineSysPresetEntity> property11 = new Property<>(medicineSysPresetEntity_2, 10, 16, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property11;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "MedicineSysPresetEntity";
    }

    public Class<MedicineSysPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "MedicineSysPresetEntity";
    }

    public Property<MedicineSysPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<MedicineSysPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<MedicineSysPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<MedicineSysPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class MedicineSysPresetEntityIdGetter implements IdGetter<MedicineSysPresetEntity> {
        MedicineSysPresetEntityIdGetter() {
        }

        public long getId(MedicineSysPresetEntity medicineSysPresetEntity) {
            return medicineSysPresetEntity.getIdx();
        }
    }
}
