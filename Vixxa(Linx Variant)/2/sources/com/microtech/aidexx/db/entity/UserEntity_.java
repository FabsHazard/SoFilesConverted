package com.microtech.aidexx.db.entity;

import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.db.entity.UserEntityCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;

public final class UserEntity_ implements EntityInfo<UserEntity> {
    public static final Property<UserEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<UserEntity> __CURSOR_FACTORY = new UserEntityCursor.Factory();
    public static final String __DB_NAME = "UserEntity";
    public static final Class<UserEntity> __ENTITY_CLASS = UserEntity.class;
    public static final int __ENTITY_ID = 11;
    public static final String __ENTITY_NAME = "UserEntity";
    static final UserEntityIdGetter __ID_GETTER = new UserEntityIdGetter();
    public static final Property<UserEntity> __ID_PROPERTY;
    public static final UserEntity_ __INSTANCE;
    public static final Property<UserEntity> avatar;
    public static final Property<UserEntity> birthDate;
    public static final Property<UserEntity> bodyWeight;
    public static final Property<UserEntity> complications;
    public static final Property<UserEntity> complicationsDisplayName;
    public static final Property<UserEntity> diabetesType;
    public static final Property<UserEntity> diabetesTypeDisplayName;
    public static final Property<UserEntity> diabetesTypeValue;
    public static final Property<UserEntity> diagnosisDate;
    public static final Property<UserEntity> email;
    public static final Property<UserEntity> fullName;
    public static final Property<UserEntity> gender;
    public static final Property<UserEntity> height;
    public static final Property<UserEntity> idx;
    public static final Property<UserEntity> isGuide;
    public static final Property<UserEntity> isGuideStateChange;
    public static final Property<UserEntity> isSettedPassword;
    public static final Property<UserEntity> isUnitGuide;
    public static final Property<UserEntity> name;
    public static final Property<UserEntity> otherDiseases;
    public static final Property<UserEntity> otherDiseasesDisplayName;
    public static final Property<UserEntity> phone;
    public static final Property<UserEntity> treatment;
    public static final Property<UserEntity> treatmentDisplayName;
    public static final Property<UserEntity> userId;
    public static final Property<UserEntity> userInformationId;

    public int getEntityId() {
        return 11;
    }

    static {
        UserEntity_ userEntity_ = new UserEntity_();
        __INSTANCE = userEntity_;
        UserEntity_ userEntity_2 = userEntity_;
        Property<UserEntity> property = new Property<>(userEntity_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<UserEntity> property2 = new Property<>(userEntity_2, 1, 8, String.class, "userId");
        userId = property2;
        Property<UserEntity> property3 = new Property<>(userEntity_2, 2, 34, Boolean.TYPE, "isGuideStateChange");
        isGuideStateChange = property3;
        Property<UserEntity> property4 = new Property<>(userEntity_2, 3, 24, Integer.TYPE, "isGuide");
        isGuide = property4;
        Property<UserEntity> property5 = new Property<>(userEntity_2, 4, 35, Integer.TYPE, "isUnitGuide");
        isUnitGuide = property5;
        Property<UserEntity> property6 = new Property<>(userEntity_2, 5, 9, String.class, "userInformationId");
        userInformationId = property6;
        Property<UserEntity> property7 = new Property<>(userEntity_2, 6, 10, String.class, NotificationCompat.CATEGORY_EMAIL);
        email = property7;
        Property<UserEntity> property8 = new Property<>(userEntity_2, 7, 11, String.class, "phone");
        phone = property8;
        Property<UserEntity> property9 = new Property<>(userEntity_2, 8, 7, String.class, "avatar");
        avatar = property9;
        Property<UserEntity> property10 = new Property<>(userEntity_2, 9, 12, String.class, "name");
        name = property10;
        Property<UserEntity> property11 = new Property<>(userEntity_2, 10, 23, String.class, "fullName");
        fullName = property11;
        Property<UserEntity> property12 = new Property<>(userEntity_2, 11, 16, Integer.class, "gender");
        gender = property12;
        Property<UserEntity> property13 = new Property<>(userEntity_2, 12, 17, String.class, "birthDate");
        birthDate = property13;
        Property<UserEntity> property14 = new Property<>(userEntity_2, 13, 18, Integer.class, "height");
        height = property14;
        Property<UserEntity> property15 = new Property<>(userEntity_2, 14, 19, Integer.class, "bodyWeight");
        bodyWeight = property15;
        Property<UserEntity> property16 = new Property<>(userEntity_2, 15, 20, Integer.class, "diabetesType");
        diabetesType = property16;
        Property<UserEntity> property17 = new Property<>(userEntity_2, 16, 25, Integer.class, "diabetesTypeValue");
        diabetesTypeValue = property17;
        Property<UserEntity> property18 = new Property<>(userEntity_2, 17, 26, String.class, "diabetesTypeDisplayName");
        diabetesTypeDisplayName = property18;
        Property<UserEntity> property19 = new Property<>(userEntity_2, 18, 21, String.class, "diagnosisDate");
        diagnosisDate = property19;
        Property<UserEntity> property20 = new Property<>(userEntity_2, 19, 22, String.class, "complications");
        complications = property20;
        Property<UserEntity> property21 = new Property<>(userEntity_2, 20, 27, String.class, "complicationsDisplayName");
        complicationsDisplayName = property21;
        Property<UserEntity> property22 = new Property<>(userEntity_2, 21, 28, String.class, "treatment");
        treatment = property22;
        Property<UserEntity> property23 = new Property<>(userEntity_2, 22, 29, String.class, "treatmentDisplayName");
        treatmentDisplayName = property23;
        Property<UserEntity> property24 = new Property<>(userEntity_2, 23, 30, String.class, "otherDiseases");
        otherDiseases = property24;
        Property<UserEntity> property25 = new Property<>(userEntity_2, 24, 31, String.class, "otherDiseasesDisplayName");
        otherDiseasesDisplayName = property25;
        Property<UserEntity> property26 = new Property<>(userEntity_2, 25, 33, Integer.TYPE, "isSettedPassword");
        isSettedPassword = property26;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22, property23, property24, property25, property26};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "UserEntity";
    }

    public Class<UserEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "UserEntity";
    }

    public Property<UserEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<UserEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<UserEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<UserEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class UserEntityIdGetter implements IdGetter<UserEntity> {
        UserEntityIdGetter() {
        }

        public long getId(UserEntity userEntity) {
            return userEntity.getIdx();
        }
    }
}
