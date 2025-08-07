package com.microtech.aidexx.db.entity.event;

import com.microtech.aidexx.db.entity.event.DietEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;
import java.util.List;

public final class DietEntity_ implements EntityInfo<DietEntity> {
    public static final Property<DietEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<DietEntity> __CURSOR_FACTORY = new DietEntityCursor.Factory();
    public static final String __DB_NAME = "DietEntity";
    public static final Class<DietEntity> __ENTITY_CLASS = DietEntity.class;
    public static final int __ENTITY_ID = 4;
    public static final String __ENTITY_NAME = "DietEntity";
    static final DietEntityIdGetter __ID_GETTER = new DietEntityIdGetter();
    public static final Property<DietEntity> __ID_PROPERTY;
    public static final DietEntity_ __INSTANCE;
    public static final Property<DietEntity> appCreateTime;
    public static final Property<DietEntity> appTime;
    public static final Property<DietEntity> appTimeZone;
    public static final Property<DietEntity> autoIncrementColumn;
    public static final Property<DietEntity> carbohydrate;
    public static final Property<DietEntity> deleteStatus;
    public static final Property<DietEntity> dstOffset;
    public static final Property<DietEntity> expandList;
    public static final Property<DietEntity> foodId;
    public static final Property<DietEntity> id;
    public static final Property<DietEntity> idx;
    public static final Property<DietEntity> isPreset;
    public static final Property<DietEntity> language;
    public static final Property<DietEntity> mealRemark;
    public static final Property<DietEntity> mealTime;
    public static final Property<DietEntity> moment;
    public static final Property<DietEntity> recordId;
    public static final Property<DietEntity> recordIndex;
    public static final Property<DietEntity> state;
    public static final Property<DietEntity> timestamp;
    public static final Property<DietEntity> uploadState;
    public static final Property<DietEntity> userId;

    public int getEntityId() {
        return 4;
    }

    static {
        DietEntity_ dietEntity_ = new DietEntity_();
        __INSTANCE = dietEntity_;
        DietEntity_ dietEntity_2 = dietEntity_;
        Property<DietEntity> property = new Property<>(dietEntity_2, 0, 1, Long.class, "idx", true, "idx");
        idx = property;
        Property<DietEntity> property2 = new Property<>(dietEntity_2, 1, 2, Integer.TYPE, "state");
        state = property2;
        Property<DietEntity> property3 = new Property<>(dietEntity_2, 2, 3, String.class, "id");
        id = property3;
        Property<DietEntity> property4 = new Property<>(dietEntity_2, 3, 18, String.class, "userId");
        userId = property4;
        Property<DietEntity> property5 = new Property<>(dietEntity_2, 4, 5, Long.class, "recordIndex");
        recordIndex = property5;
        Property<DietEntity> property6 = new Property<>(dietEntity_2, 5, 28, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<DietEntity> property7 = new Property<>(dietEntity_2, 6, 12, String.class, "recordId");
        recordId = property7;
        Property<DietEntity> property8 = new Property<>(dietEntity_2, 7, 6, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<DietEntity> property9 = new Property<>(dietEntity_2, 8, 16, String.class, "language");
        language = property9;
        Property<DietEntity> property10 = new Property<>(dietEntity_2, 9, 17, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<DietEntity> property11 = new Property<>(dietEntity_2, 10, 24, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<DietEntity> property12 = new Property<>(dietEntity_2, 11, 20, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<DietEntity> property13 = new Property<>(dietEntity_2, 12, 27, Integer.TYPE, "moment");
        moment = property13;
        Property<DietEntity> property14 = new Property<>(dietEntity_2, 13, 21, String.class, "appTime");
        appTime = property14;
        Property<DietEntity> property15 = new Property<>(dietEntity_2, 14, 22, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<DietEntity> property16 = new Property<>(dietEntity_2, 15, 23, String.class, "dstOffset");
        dstOffset = property16;
        Property<DietEntity> property17 = new Property<>(dietEntity_2, 16, 7, Date.class, "mealTime");
        mealTime = property17;
        Property<DietEntity> property18 = new Property<>(dietEntity_2, 17, 25, String.class, "foodId");
        foodId = property18;
        Property<DietEntity> property19 = new Property<>(dietEntity_2, 18, 9, String.class, "mealRemark");
        mealRemark = property19;
        Property<DietEntity> property20 = new Property<>(dietEntity_2, 19, 10, Integer.class, "carbohydrate");
        carbohydrate = property20;
        Property<DietEntity> property21 = new Property<>(dietEntity_2, 20, 11, Boolean.TYPE, "isPreset");
        isPreset = property21;
        Property<DietEntity> property22 = new Property<>(dietEntity_2, 21, 26, String.class, "expandList", false, "expandList", DietDetail.class, List.class);
        expandList = property22;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "DietEntity";
    }

    public Class<DietEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "DietEntity";
    }

    public Property<DietEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<DietEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<DietEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<DietEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class DietEntityIdGetter implements IdGetter<DietEntity> {
        DietEntityIdGetter() {
        }

        public long getId(DietEntity dietEntity) {
            Long idx = dietEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
