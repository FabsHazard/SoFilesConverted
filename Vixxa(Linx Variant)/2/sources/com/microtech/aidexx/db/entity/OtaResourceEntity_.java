package com.microtech.aidexx.db.entity;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.OtaResourceEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class OtaResourceEntity_ implements EntityInfo<OtaResourceEntity> {
    public static final Property<OtaResourceEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<OtaResourceEntity> __CURSOR_FACTORY = new OtaResourceEntityCursor.Factory();
    public static final String __DB_NAME = "OtaResourceEntity";
    public static final Class<OtaResourceEntity> __ENTITY_CLASS = OtaResourceEntity.class;
    public static final int __ENTITY_ID = 30;
    public static final String __ENTITY_NAME = "OtaResourceEntity";
    static final OtaResourceEntityIdGetter __ID_GETTER = new OtaResourceEntityIdGetter();
    public static final Property<OtaResourceEntity> __ID_PROPERTY;
    public static final OtaResourceEntity_ __INSTANCE;
    public static final Property<OtaResourceEntity> aidexVersion;
    public static final Property<OtaResourceEntity> fileType;
    public static final Property<OtaResourceEntity> idx;
    public static final Property<OtaResourceEntity> localFilePath;
    public static final Property<OtaResourceEntity> md5;
    public static final Property<OtaResourceEntity> ossFileUrl;
    public static final Property<OtaResourceEntity> settingContent;
    public static final Property<OtaResourceEntity> settingType;
    public static final Property<OtaResourceEntity> settingTypeVersionKey;
    public static final Property<OtaResourceEntity> settingVersion;
    public static final Property<OtaResourceEntity> sha256;
    public static final Property<OtaResourceEntity> version;

    public int getEntityId() {
        return 30;
    }

    static {
        OtaResourceEntity_ otaResourceEntity_ = new OtaResourceEntity_();
        __INSTANCE = otaResourceEntity_;
        OtaResourceEntity_ otaResourceEntity_2 = otaResourceEntity_;
        Property<OtaResourceEntity> property = new Property<>(otaResourceEntity_2, 0, 1, Long.class, "idx", true, "idx");
        idx = property;
        Property<OtaResourceEntity> property2 = new Property<>(otaResourceEntity_2, 1, 11, String.class, "settingTypeVersionKey");
        settingTypeVersionKey = property2;
        Property<OtaResourceEntity> property3 = new Property<>(otaResourceEntity_2, 2, 9, String.class, "settingVersion");
        settingVersion = property3;
        Property<OtaResourceEntity> property4 = new Property<>(otaResourceEntity_2, 3, 12, String.class, "localFilePath");
        localFilePath = property4;
        Property<OtaResourceEntity> property5 = new Property<>(otaResourceEntity_2, 4, 10, String.class, "settingContent");
        settingContent = property5;
        Property<OtaResourceEntity> property6 = new Property<>(otaResourceEntity_2, 5, 2, String.class, "sha256");
        sha256 = property6;
        Property<OtaResourceEntity> property7 = new Property<>(otaResourceEntity_2, 6, 3, String.class, "ossFileUrl");
        ossFileUrl = property7;
        Property<OtaResourceEntity> property8 = new Property<>(otaResourceEntity_2, 7, 4, String.class, "settingType");
        settingType = property8;
        Property<OtaResourceEntity> property9 = new Property<>(otaResourceEntity_2, 8, 5, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property9;
        Property<OtaResourceEntity> property10 = new Property<>(otaResourceEntity_2, 9, 6, Integer.class, "fileType");
        fileType = property10;
        Property<OtaResourceEntity> property11 = new Property<>(otaResourceEntity_2, 10, 7, String.class, "md5");
        md5 = property11;
        Property<OtaResourceEntity> property12 = new Property<>(otaResourceEntity_2, 11, 8, String.class, "aidexVersion");
        aidexVersion = property12;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "OtaResourceEntity";
    }

    public Class<OtaResourceEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "OtaResourceEntity";
    }

    public Property<OtaResourceEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<OtaResourceEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<OtaResourceEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<OtaResourceEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class OtaResourceEntityIdGetter implements IdGetter<OtaResourceEntity> {
        OtaResourceEntityIdGetter() {
        }

        public long getId(OtaResourceEntity otaResourceEntity) {
            Long idx = otaResourceEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
