package com.microtech.aidexx.db.entity.event;

import com.microtech.aidexx.db.entity.event.MedicationEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;
import java.util.List;

public final class MedicationEntity_ implements EntityInfo<MedicationEntity> {
    public static final Property<MedicationEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<MedicationEntity> __CURSOR_FACTORY = new MedicationEntityCursor.Factory();
    public static final String __DB_NAME = "MedicationEntity";
    public static final Class<MedicationEntity> __ENTITY_CLASS = MedicationEntity.class;
    public static final int __ENTITY_ID = 7;
    public static final String __ENTITY_NAME = "MedicationEntity";
    static final MedicationEntityIdGetter __ID_GETTER = new MedicationEntityIdGetter();
    public static final Property<MedicationEntity> __ID_PROPERTY;
    public static final MedicationEntity_ __INSTANCE;
    public static final Property<MedicationEntity> appCreateTime;
    public static final Property<MedicationEntity> appTime;
    public static final Property<MedicationEntity> appTimeZone;
    public static final Property<MedicationEntity> autoIncrementColumn;
    public static final Property<MedicationEntity> deleteStatus;
    public static final Property<MedicationEntity> dstOffset;
    public static final Property<MedicationEntity> expandList;
    public static final Property<MedicationEntity> id;
    public static final Property<MedicationEntity> idx;
    public static final Property<MedicationEntity> isPreset;
    public static final Property<MedicationEntity> language;
    public static final Property<MedicationEntity> medicationId;
    public static final Property<MedicationEntity> medicineDosage;
    public static final Property<MedicationEntity> medicineName;
    public static final Property<MedicationEntity> moment;
    public static final Property<MedicationEntity> recordId;
    public static final Property<MedicationEntity> recordIndex;
    public static final Property<MedicationEntity> state;
    public static final Property<MedicationEntity> takenTime;
    public static final Property<MedicationEntity> timestamp;
    public static final Property<MedicationEntity> uploadState;
    public static final Property<MedicationEntity> userId;

    public int getEntityId() {
        return 7;
    }

    static {
        MedicationEntity_ medicationEntity_ = new MedicationEntity_();
        __INSTANCE = medicationEntity_;
        MedicationEntity_ medicationEntity_2 = medicationEntity_;
        Property<MedicationEntity> property = new Property<>(medicationEntity_2, 0, 2, Long.class, "idx", true, "idx");
        idx = property;
        Property<MedicationEntity> property2 = new Property<>(medicationEntity_2, 1, 3, Integer.TYPE, "state");
        state = property2;
        Property<MedicationEntity> property3 = new Property<>(medicationEntity_2, 2, 4, String.class, "id");
        id = property3;
        Property<MedicationEntity> property4 = new Property<>(medicationEntity_2, 3, 18, String.class, "userId");
        userId = property4;
        Property<MedicationEntity> property5 = new Property<>(medicationEntity_2, 4, 5, Long.class, "recordIndex");
        recordIndex = property5;
        Property<MedicationEntity> property6 = new Property<>(medicationEntity_2, 5, 28, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<MedicationEntity> property7 = new Property<>(medicationEntity_2, 6, 15, String.class, "recordId");
        recordId = property7;
        Property<MedicationEntity> property8 = new Property<>(medicationEntity_2, 7, 6, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<MedicationEntity> property9 = new Property<>(medicationEntity_2, 8, 16, String.class, "language");
        language = property9;
        Property<MedicationEntity> property10 = new Property<>(medicationEntity_2, 9, 17, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<MedicationEntity> property11 = new Property<>(medicationEntity_2, 10, 24, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<MedicationEntity> property12 = new Property<>(medicationEntity_2, 11, 20, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<MedicationEntity> property13 = new Property<>(medicationEntity_2, 12, 27, Integer.TYPE, "moment");
        moment = property13;
        Property<MedicationEntity> property14 = new Property<>(medicationEntity_2, 13, 21, String.class, "appTime");
        appTime = property14;
        Property<MedicationEntity> property15 = new Property<>(medicationEntity_2, 14, 22, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<MedicationEntity> property16 = new Property<>(medicationEntity_2, 15, 23, String.class, "dstOffset");
        dstOffset = property16;
        Property<MedicationEntity> property17 = new Property<>(medicationEntity_2, 16, 25, String.class, "medicationId");
        medicationId = property17;
        Property<MedicationEntity> property18 = new Property<>(medicationEntity_2, 17, 8, Date.class, "takenTime");
        takenTime = property18;
        Property<MedicationEntity> property19 = new Property<>(medicationEntity_2, 18, 9, String.class, "medicineName");
        medicineName = property19;
        Property<MedicationEntity> property20 = new Property<>(medicationEntity_2, 19, 10, Float.class, "medicineDosage");
        medicineDosage = property20;
        Property<MedicationEntity> property21 = new Property<>(medicationEntity_2, 20, 11, Boolean.TYPE, "isPreset");
        isPreset = property21;
        Property<MedicationEntity> property22 = new Property<>(medicationEntity_2, 21, 26, String.class, "expandList", false, "expandList", MedicationDetail.class, List.class);
        expandList = property22;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "MedicationEntity";
    }

    public Class<MedicationEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "MedicationEntity";
    }

    public Property<MedicationEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<MedicationEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<MedicationEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<MedicationEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class MedicationEntityIdGetter implements IdGetter<MedicationEntity> {
        MedicationEntityIdGetter() {
        }

        public long getId(MedicationEntity medicationEntity) {
            Long idx = medicationEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
