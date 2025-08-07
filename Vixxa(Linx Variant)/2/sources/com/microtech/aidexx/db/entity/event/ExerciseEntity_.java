package com.microtech.aidexx.db.entity.event;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microtech.aidexx.db.entity.event.ExerciseEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;
import java.util.List;

public final class ExerciseEntity_ implements EntityInfo<ExerciseEntity> {
    public static final Property<ExerciseEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<ExerciseEntity> __CURSOR_FACTORY = new ExerciseEntityCursor.Factory();
    public static final String __DB_NAME = "ExerciseEntity";
    public static final Class<ExerciseEntity> __ENTITY_CLASS = ExerciseEntity.class;
    public static final int __ENTITY_ID = 5;
    public static final String __ENTITY_NAME = "ExerciseEntity";
    static final ExerciseEntityIdGetter __ID_GETTER = new ExerciseEntityIdGetter();
    public static final Property<ExerciseEntity> __ID_PROPERTY;
    public static final ExerciseEntity_ __INSTANCE;
    public static final Property<ExerciseEntity> appCreateTime;
    public static final Property<ExerciseEntity> appTime;
    public static final Property<ExerciseEntity> appTimeZone;
    public static final Property<ExerciseEntity> autoIncrementColumn;
    public static final Property<ExerciseEntity> deleteStatus;
    public static final Property<ExerciseEntity> dstOffset;
    public static final Property<ExerciseEntity> duration;
    public static final Property<ExerciseEntity> exerciseId;
    public static final Property<ExerciseEntity> expandList;
    public static final Property<ExerciseEntity> id;
    public static final Property<ExerciseEntity> idx;
    public static final Property<ExerciseEntity> intensity;
    public static final Property<ExerciseEntity> isPreset;
    public static final Property<ExerciseEntity> language;
    public static final Property<ExerciseEntity> moment;
    public static final Property<ExerciseEntity> recordId;
    public static final Property<ExerciseEntity> recordIndex;
    public static final Property<ExerciseEntity> startTime;
    public static final Property<ExerciseEntity> state;
    public static final Property<ExerciseEntity> timestamp;
    public static final Property<ExerciseEntity> uploadState;
    public static final Property<ExerciseEntity> userId;

    public int getEntityId() {
        return 5;
    }

    static {
        ExerciseEntity_ exerciseEntity_ = new ExerciseEntity_();
        __INSTANCE = exerciseEntity_;
        ExerciseEntity_ exerciseEntity_2 = exerciseEntity_;
        Property<ExerciseEntity> property = new Property<>(exerciseEntity_2, 0, 2, Long.class, "idx", true, "idx");
        idx = property;
        Property<ExerciseEntity> property2 = new Property<>(exerciseEntity_2, 1, 3, Integer.TYPE, "state");
        state = property2;
        Property<ExerciseEntity> property3 = new Property<>(exerciseEntity_2, 2, 4, String.class, "id");
        id = property3;
        Property<ExerciseEntity> property4 = new Property<>(exerciseEntity_2, 3, 17, String.class, "userId");
        userId = property4;
        Property<ExerciseEntity> property5 = new Property<>(exerciseEntity_2, 4, 5, Long.class, "recordIndex");
        recordIndex = property5;
        Property<ExerciseEntity> property6 = new Property<>(exerciseEntity_2, 5, 27, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<ExerciseEntity> property7 = new Property<>(exerciseEntity_2, 6, 12, String.class, "recordId");
        recordId = property7;
        Property<ExerciseEntity> property8 = new Property<>(exerciseEntity_2, 7, 6, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<ExerciseEntity> property9 = new Property<>(exerciseEntity_2, 8, 15, String.class, "language");
        language = property9;
        Property<ExerciseEntity> property10 = new Property<>(exerciseEntity_2, 9, 16, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<ExerciseEntity> property11 = new Property<>(exerciseEntity_2, 10, 23, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<ExerciseEntity> property12 = new Property<>(exerciseEntity_2, 11, 19, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<ExerciseEntity> property13 = new Property<>(exerciseEntity_2, 12, 26, Integer.TYPE, "moment");
        moment = property13;
        Property<ExerciseEntity> property14 = new Property<>(exerciseEntity_2, 13, 20, String.class, "appTime");
        appTime = property14;
        Property<ExerciseEntity> property15 = new Property<>(exerciseEntity_2, 14, 21, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<ExerciseEntity> property16 = new Property<>(exerciseEntity_2, 15, 22, String.class, "dstOffset");
        dstOffset = property16;
        Property<ExerciseEntity> property17 = new Property<>(exerciseEntity_2, 16, 24, String.class, "exerciseId");
        exerciseId = property17;
        Property<ExerciseEntity> property18 = new Property<>(exerciseEntity_2, 17, 8, Date.class, "startTime");
        startTime = property18;
        Property<ExerciseEntity> property19 = new Property<>(exerciseEntity_2, 18, 9, Integer.class, TypedValues.TransitionType.S_DURATION);
        duration = property19;
        Property<ExerciseEntity> property20 = new Property<>(exerciseEntity_2, 19, 10, Integer.class, "intensity");
        intensity = property20;
        Property<ExerciseEntity> property21 = new Property<>(exerciseEntity_2, 20, 11, Boolean.TYPE, "isPreset");
        isPreset = property21;
        Property<ExerciseEntity> property22 = new Property<>(exerciseEntity_2, 21, 25, String.class, "expandList", false, "expandList", ExerciseDetail.class, List.class);
        expandList = property22;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "ExerciseEntity";
    }

    public Class<ExerciseEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "ExerciseEntity";
    }

    public Property<ExerciseEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<ExerciseEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<ExerciseEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<ExerciseEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class ExerciseEntityIdGetter implements IdGetter<ExerciseEntity> {
        ExerciseEntityIdGetter() {
        }

        public long getId(ExerciseEntity exerciseEntity) {
            Long idx = exerciseEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
