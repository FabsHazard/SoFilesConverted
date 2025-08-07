package com.microtech.aidexx.db.entity.event.preset;

import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class MedicineUsrPresetEntity_ implements EntityInfo<MedicineUsrPresetEntity> {
    public static final Property<MedicineUsrPresetEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<MedicineUsrPresetEntity> __CURSOR_FACTORY = new MedicineUsrPresetEntityCursor.Factory();
    public static final String __DB_NAME = "MedicineUsrPresetEntity";
    public static final Class<MedicineUsrPresetEntity> __ENTITY_CLASS = MedicineUsrPresetEntity.class;
    public static final int __ENTITY_ID = 17;
    public static final String __ENTITY_NAME = "MedicineUsrPresetEntity";
    static final MedicineUsrPresetEntityIdGetter __ID_GETTER = new MedicineUsrPresetEntityIdGetter();
    public static final Property<MedicineUsrPresetEntity> __ID_PROPERTY;
    public static final MedicineUsrPresetEntity_ __INSTANCE;
    public static final Property<MedicineUsrPresetEntity> autoIncrementColumn;
    public static final Property<MedicineUsrPresetEntity> categoryName;
    public static final Property<MedicineUsrPresetEntity> deleteFlag;
    public static final Property<MedicineUsrPresetEntity> englishName;
    public static final Property<MedicineUsrPresetEntity> idx;
    public static final Property<MedicineUsrPresetEntity> language;
    public static final Property<MedicineUsrPresetEntity> manufacturer;
    public static final Property<MedicineUsrPresetEntity> medicationUserPresetId;
    public static final Property<MedicineUsrPresetEntity> name;
    public static final Property<MedicineUsrPresetEntity> tradeName;
    public static final Property<MedicineUsrPresetEntity> userId;

    public int getEntityId() {
        return 17;
    }

    static {
        MedicineUsrPresetEntity_ medicineUsrPresetEntity_ = new MedicineUsrPresetEntity_();
        __INSTANCE = medicineUsrPresetEntity_;
        MedicineUsrPresetEntity_ medicineUsrPresetEntity_2 = medicineUsrPresetEntity_;
        Property<MedicineUsrPresetEntity> property = new Property<>(medicineUsrPresetEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<MedicineUsrPresetEntity> property2 = new Property<>(medicineUsrPresetEntity_2, 1, 5, String.class, "name");
        name = property2;
        Property<MedicineUsrPresetEntity> property3 = new Property<>(medicineUsrPresetEntity_2, 2, 11, String.class, "userId");
        userId = property3;
        Property<MedicineUsrPresetEntity> property4 = new Property<>(medicineUsrPresetEntity_2, 3, 16, Integer.TYPE, "deleteFlag");
        deleteFlag = property4;
        Property<MedicineUsrPresetEntity> property5 = new Property<>(medicineUsrPresetEntity_2, 4, 15, String.class, "language");
        language = property5;
        Property<MedicineUsrPresetEntity> property6 = new Property<>(medicineUsrPresetEntity_2, 5, 7, String.class, "categoryName");
        categoryName = property6;
        Property<MedicineUsrPresetEntity> property7 = new Property<>(medicineUsrPresetEntity_2, 6, 8, String.class, "tradeName");
        tradeName = property7;
        Property<MedicineUsrPresetEntity> property8 = new Property<>(medicineUsrPresetEntity_2, 7, 9, String.class, "manufacturer");
        manufacturer = property8;
        Property<MedicineUsrPresetEntity> property9 = new Property<>(medicineUsrPresetEntity_2, 8, 10, String.class, "englishName");
        englishName = property9;
        Property<MedicineUsrPresetEntity> property10 = new Property<>(medicineUsrPresetEntity_2, 9, 13, String.class, "medicationUserPresetId");
        medicationUserPresetId = property10;
        Property<MedicineUsrPresetEntity> property11 = new Property<>(medicineUsrPresetEntity_2, 10, 14, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "MedicineUsrPresetEntity";
    }

    public Class<MedicineUsrPresetEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "MedicineUsrPresetEntity";
    }

    public Property<MedicineUsrPresetEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<MedicineUsrPresetEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<MedicineUsrPresetEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<MedicineUsrPresetEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class MedicineUsrPresetEntityIdGetter implements IdGetter<MedicineUsrPresetEntity> {
        MedicineUsrPresetEntityIdGetter() {
        }

        public long getId(MedicineUsrPresetEntity medicineUsrPresetEntity) {
            return medicineUsrPresetEntity.getIdx();
        }
    }
}
