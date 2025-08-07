package com.microtech.aidexx.db.entity.event;

import com.microtech.aidexx.db.entity.event.OthersEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;

public final class OthersEntity_ implements EntityInfo<OthersEntity> {
    public static final Property<OthersEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<OthersEntity> __CURSOR_FACTORY = new OthersEntityCursor.Factory();
    public static final String __DB_NAME = "OthersEntity";
    public static final Class<OthersEntity> __ENTITY_CLASS = OthersEntity.class;
    public static final int __ENTITY_ID = 8;
    public static final String __ENTITY_NAME = "OthersEntity";
    static final OthersEntityIdGetter __ID_GETTER = new OthersEntityIdGetter();
    public static final Property<OthersEntity> __ID_PROPERTY;
    public static final OthersEntity_ __INSTANCE;
    public static final Property<OthersEntity> appCreateTime;
    public static final Property<OthersEntity> appTime;
    public static final Property<OthersEntity> appTimeZone;
    public static final Property<OthersEntity> autoIncrementColumn;
    public static final Property<OthersEntity> content;
    public static final Property<OthersEntity> deleteFlag;
    public static final Property<OthersEntity> deleteStatus;
    public static final Property<OthersEntity> dstOffset;
    public static final Property<OthersEntity> id;
    public static final Property<OthersEntity> idx;
    public static final Property<OthersEntity> language;
    public static final Property<OthersEntity> moment;
    public static final Property<OthersEntity> otherId;
    public static final Property<OthersEntity> recordId;
    public static final Property<OthersEntity> recordIndex;
    public static final Property<OthersEntity> state;
    public static final Property<OthersEntity> timestamp;
    public static final Property<OthersEntity> uploadState;
    public static final Property<OthersEntity> userId;

    public int getEntityId() {
        return 8;
    }

    static {
        OthersEntity_ othersEntity_ = new OthersEntity_();
        __INSTANCE = othersEntity_;
        OthersEntity_ othersEntity_2 = othersEntity_;
        Property<OthersEntity> property = new Property<>(othersEntity_2, 0, 1, Long.class, "idx", true, "idx");
        idx = property;
        Property<OthersEntity> property2 = new Property<>(othersEntity_2, 1, 2, Integer.TYPE, "state");
        state = property2;
        Property<OthersEntity> property3 = new Property<>(othersEntity_2, 2, 3, String.class, "id");
        id = property3;
        Property<OthersEntity> property4 = new Property<>(othersEntity_2, 3, 14, String.class, "userId");
        userId = property4;
        Property<OthersEntity> property5 = new Property<>(othersEntity_2, 4, 4, Long.class, "recordIndex");
        recordIndex = property5;
        Property<OthersEntity> property6 = new Property<>(othersEntity_2, 5, 23, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<OthersEntity> property7 = new Property<>(othersEntity_2, 6, 7, String.class, "recordId");
        recordId = property7;
        Property<OthersEntity> property8 = new Property<>(othersEntity_2, 7, 5, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<OthersEntity> property9 = new Property<>(othersEntity_2, 8, 12, String.class, "language");
        language = property9;
        Property<OthersEntity> property10 = new Property<>(othersEntity_2, 9, 13, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<OthersEntity> property11 = new Property<>(othersEntity_2, 10, 20, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<OthersEntity> property12 = new Property<>(othersEntity_2, 11, 16, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<OthersEntity> property13 = new Property<>(othersEntity_2, 12, 22, Integer.TYPE, "moment");
        moment = property13;
        Property<OthersEntity> property14 = new Property<>(othersEntity_2, 13, 17, String.class, "appTime");
        appTime = property14;
        Property<OthersEntity> property15 = new Property<>(othersEntity_2, 14, 18, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<OthersEntity> property16 = new Property<>(othersEntity_2, 15, 19, String.class, "dstOffset");
        dstOffset = property16;
        Property<OthersEntity> property17 = new Property<>(othersEntity_2, 16, 21, String.class, "otherId");
        otherId = property17;
        Property<OthersEntity> property18 = new Property<>(othersEntity_2, 17, 9, String.class, "content");
        content = property18;
        Property<OthersEntity> property19 = new Property<>(othersEntity_2, 18, 10, Integer.class, "deleteFlag");
        deleteFlag = property19;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "OthersEntity";
    }

    public Class<OthersEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "OthersEntity";
    }

    public Property<OthersEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<OthersEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<OthersEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<OthersEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class OthersEntityIdGetter implements IdGetter<OthersEntity> {
        OthersEntityIdGetter() {
        }

        public long getId(OthersEntity othersEntity) {
            Long idx = othersEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
