package com.microtech.aidexx.db.entity;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.LanguageEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class LanguageEntity_ implements EntityInfo<LanguageEntity> {
    public static final Property<LanguageEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<LanguageEntity> __CURSOR_FACTORY = new LanguageEntityCursor.Factory();
    public static final String __DB_NAME = "LanguageEntity";
    public static final Class<LanguageEntity> __ENTITY_CLASS = LanguageEntity.class;
    public static final int __ENTITY_ID = 25;
    public static final String __ENTITY_NAME = "LanguageEntity";
    static final LanguageEntityIdGetter __ID_GETTER = new LanguageEntityIdGetter();
    public static final Property<LanguageEntity> __ID_PROPERTY;
    public static final LanguageEntity_ __INSTANCE;
    public static final Property<LanguageEntity> id;
    public static final Property<LanguageEntity> key;
    public static final Property<LanguageEntity> language;
    public static final Property<LanguageEntity> module;
    public static final Property<LanguageEntity> value;
    public static final Property<LanguageEntity> version;

    public int getEntityId() {
        return 25;
    }

    static {
        LanguageEntity_ languageEntity_ = new LanguageEntity_();
        __INSTANCE = languageEntity_;
        LanguageEntity_ languageEntity_2 = languageEntity_;
        Property<LanguageEntity> property = new Property<>(languageEntity_2, 0, 1, Long.class, "id", true, "id");
        id = property;
        Property<LanguageEntity> property2 = new Property<>(languageEntity_2, 1, 2, String.class, "key");
        key = property2;
        Property<LanguageEntity> property3 = new Property<>(languageEntity_2, 2, 3, String.class, "value");
        value = property3;
        Property<LanguageEntity> property4 = new Property<>(languageEntity_2, 3, 4, String.class, "language");
        language = property4;
        Property<LanguageEntity> property5 = new Property<>(languageEntity_2, 4, 5, String.class, "module");
        module = property5;
        Property<LanguageEntity> property6 = new Property<>(languageEntity_2, 5, 6, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property6;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "LanguageEntity";
    }

    public Class<LanguageEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "LanguageEntity";
    }

    public Property<LanguageEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<LanguageEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<LanguageEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<LanguageEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class LanguageEntityIdGetter implements IdGetter<LanguageEntity> {
        LanguageEntityIdGetter() {
        }

        public long getId(LanguageEntity languageEntity) {
            Long id = languageEntity.getId();
            if (id != null) {
                return id.longValue();
            }
            return 0;
        }
    }
}
