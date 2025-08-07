package com.microtech.aidexx.db.entity;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.microtech.aidexx.db.entity.LanguageConfEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class LanguageConfEntity_ implements EntityInfo<LanguageConfEntity> {
    public static final Property<LanguageConfEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<LanguageConfEntity> __CURSOR_FACTORY = new LanguageConfEntityCursor.Factory();
    public static final String __DB_NAME = "LanguageConfEntity";
    public static final Class<LanguageConfEntity> __ENTITY_CLASS = LanguageConfEntity.class;
    public static final int __ENTITY_ID = 26;
    public static final String __ENTITY_NAME = "LanguageConfEntity";
    static final LanguageConfEntityIdGetter __ID_GETTER = new LanguageConfEntityIdGetter();
    public static final Property<LanguageConfEntity> __ID_PROPERTY;
    public static final LanguageConfEntity_ __INSTANCE;
    public static final Property<LanguageConfEntity> chineseName;
    public static final Property<LanguageConfEntity> code;
    public static final Property<LanguageConfEntity> id;
    public static final Property<LanguageConfEntity> name;
    public static final Property<LanguageConfEntity> version;

    public int getEntityId() {
        return 26;
    }

    static {
        LanguageConfEntity_ languageConfEntity_ = new LanguageConfEntity_();
        __INSTANCE = languageConfEntity_;
        LanguageConfEntity_ languageConfEntity_2 = languageConfEntity_;
        Property<LanguageConfEntity> property = new Property<>(languageConfEntity_2, 0, 1, Long.class, "id", true, "id");
        id = property;
        Property<LanguageConfEntity> property2 = new Property<>(languageConfEntity_2, 1, 2, String.class, "name");
        name = property2;
        Property<LanguageConfEntity> property3 = new Property<>(languageConfEntity_2, 2, 3, String.class, "chineseName");
        chineseName = property3;
        Property<LanguageConfEntity> property4 = new Property<>(languageConfEntity_2, 3, 8, String.class, "code");
        code = property4;
        Property<LanguageConfEntity> property5 = new Property<>(languageConfEntity_2, 4, 7, String.class, WiseOpenHianalyticsData.UNION_VERSION);
        version = property5;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "LanguageConfEntity";
    }

    public Class<LanguageConfEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "LanguageConfEntity";
    }

    public Property<LanguageConfEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<LanguageConfEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<LanguageConfEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<LanguageConfEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class LanguageConfEntityIdGetter implements IdGetter<LanguageConfEntity> {
        LanguageConfEntityIdGetter() {
        }

        public long getId(LanguageConfEntity languageConfEntity) {
            Long id = languageConfEntity.getId();
            if (id != null) {
                return id.longValue();
            }
            return 0;
        }
    }
}
