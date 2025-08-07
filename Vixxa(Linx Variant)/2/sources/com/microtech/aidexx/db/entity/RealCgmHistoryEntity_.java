package com.microtech.aidexx.db.entity;

import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntityCursor;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;

public final class RealCgmHistoryEntity_ implements EntityInfo<RealCgmHistoryEntity> {
    public static final Property<RealCgmHistoryEntity>[] __ALL_PROPERTIES;
    public static final CursorFactory<RealCgmHistoryEntity> __CURSOR_FACTORY = new RealCgmHistoryEntityCursor.Factory();
    public static final String __DB_NAME = "RealCgmHistoryEntity";
    public static final Class<RealCgmHistoryEntity> __ENTITY_CLASS = RealCgmHistoryEntity.class;
    public static final int __ENTITY_ID = 9;
    public static final String __ENTITY_NAME = "RealCgmHistoryEntity";
    static final RealCgmHistoryEntityIdGetter __ID_GETTER = new RealCgmHistoryEntityIdGetter();
    public static final Property<RealCgmHistoryEntity> __ID_PROPERTY;
    public static final RealCgmHistoryEntity_ __INSTANCE;
    public static final Property<RealCgmHistoryEntity> appCreateTime;
    public static final Property<RealCgmHistoryEntity> appTime;
    public static final Property<RealCgmHistoryEntity> appTimeZone;
    public static final Property<RealCgmHistoryEntity> autoIncrementColumn;
    public static final Property<RealCgmHistoryEntity> briefUploadState;
    public static final Property<RealCgmHistoryEntity> cgmRecordId;
    public static final Property<RealCgmHistoryEntity> dataStatus;
    public static final Property<RealCgmHistoryEntity> deleteStatus;
    public static final Property<RealCgmHistoryEntity> deviceId;
    public static final Property<RealCgmHistoryEntity> deviceSn;
    public static final Property<RealCgmHistoryEntity> deviceTime;
    public static final Property<RealCgmHistoryEntity> dstOffset;
    public static final Property<RealCgmHistoryEntity> eventDataOrigin;
    public static final Property<RealCgmHistoryEntity> eventIndex;
    public static final Property<RealCgmHistoryEntity> eventType;
    public static final Property<RealCgmHistoryEntity> eventWarning;
    public static final Property<RealCgmHistoryEntity> frontRecordId;
    public static final Property<RealCgmHistoryEntity> glucose;
    public static final Property<RealCgmHistoryEntity> glucoseIsValid;
    public static final Property<RealCgmHistoryEntity> id;
    public static final Property<RealCgmHistoryEntity> idx;
    public static final Property<RealCgmHistoryEntity> language;
    public static final Property<RealCgmHistoryEntity> moment;
    public static final Property<RealCgmHistoryEntity> quality;
    public static final Property<RealCgmHistoryEntity> rawData1;
    public static final Property<RealCgmHistoryEntity> rawData2;
    public static final Property<RealCgmHistoryEntity> rawData3;
    public static final Property<RealCgmHistoryEntity> rawData4;
    public static final Property<RealCgmHistoryEntity> rawData5;
    public static final Property<RealCgmHistoryEntity> rawData6;
    public static final Property<RealCgmHistoryEntity> rawData7;
    public static final Property<RealCgmHistoryEntity> rawData8;
    public static final Property<RealCgmHistoryEntity> rawData9;
    public static final Property<RealCgmHistoryEntity> rawIsValid;
    public static final Property<RealCgmHistoryEntity> rawOne;
    public static final Property<RealCgmHistoryEntity> rawTwo;
    public static final Property<RealCgmHistoryEntity> rawUploadState;
    public static final Property<RealCgmHistoryEntity> rawVc;
    public static final Property<RealCgmHistoryEntity> recordId;
    public static final Property<RealCgmHistoryEntity> recordIndex;
    public static final Property<RealCgmHistoryEntity> referenceGlucose;
    public static final Property<RealCgmHistoryEntity> sensorId;
    public static final Property<RealCgmHistoryEntity> sensorIndex;
    public static final Property<RealCgmHistoryEntity> state;
    public static final Property<RealCgmHistoryEntity> status;
    public static final Property<RealCgmHistoryEntity> timeOffset;
    public static final Property<RealCgmHistoryEntity> timestamp;
    public static final Property<RealCgmHistoryEntity> type;
    public static final Property<RealCgmHistoryEntity> uploadState;
    public static final Property<RealCgmHistoryEntity> userId;

    public int getEntityId() {
        return 9;
    }

    static {
        RealCgmHistoryEntity_ realCgmHistoryEntity_ = new RealCgmHistoryEntity_();
        __INSTANCE = realCgmHistoryEntity_;
        RealCgmHistoryEntity_ realCgmHistoryEntity_2 = realCgmHistoryEntity_;
        Property<RealCgmHistoryEntity> property = new Property<>(realCgmHistoryEntity_2, 0, 1, Long.class, "idx", true, "idx");
        idx = property;
        Property<RealCgmHistoryEntity> property2 = new Property<>(realCgmHistoryEntity_2, 1, 2, Integer.TYPE, "state");
        state = property2;
        Property<RealCgmHistoryEntity> property3 = new Property<>(realCgmHistoryEntity_2, 2, 3, String.class, "id");
        id = property3;
        Property<RealCgmHistoryEntity> property4 = new Property<>(realCgmHistoryEntity_2, 3, 33, String.class, "userId");
        userId = property4;
        Property<RealCgmHistoryEntity> property5 = new Property<>(realCgmHistoryEntity_2, 4, 9, Long.class, "recordIndex");
        recordIndex = property5;
        Property<RealCgmHistoryEntity> property6 = new Property<>(realCgmHistoryEntity_2, 5, 64, Date.class, "appCreateTime");
        appCreateTime = property6;
        Property<RealCgmHistoryEntity> property7 = new Property<>(realCgmHistoryEntity_2, 6, 20, String.class, "recordId");
        recordId = property7;
        Property<RealCgmHistoryEntity> property8 = new Property<>(realCgmHistoryEntity_2, 7, 10, Integer.TYPE, "deleteStatus");
        deleteStatus = property8;
        Property<RealCgmHistoryEntity> property9 = new Property<>(realCgmHistoryEntity_2, 8, 62, String.class, "language");
        language = property9;
        Property<RealCgmHistoryEntity> property10 = new Property<>(realCgmHistoryEntity_2, 9, 54, Integer.TYPE, "uploadState");
        uploadState = property10;
        Property<RealCgmHistoryEntity> property11 = new Property<>(realCgmHistoryEntity_2, 10, 44, Long.class, "autoIncrementColumn");
        autoIncrementColumn = property11;
        Property<RealCgmHistoryEntity> property12 = new Property<>(realCgmHistoryEntity_2, 11, 59, Long.TYPE, "timestamp");
        timestamp = property12;
        Property<RealCgmHistoryEntity> property13 = new Property<>(realCgmHistoryEntity_2, 12, 63, Integer.TYPE, "moment");
        moment = property13;
        Property<RealCgmHistoryEntity> property14 = new Property<>(realCgmHistoryEntity_2, 13, 56, String.class, "appTime");
        appTime = property14;
        Property<RealCgmHistoryEntity> property15 = new Property<>(realCgmHistoryEntity_2, 14, 57, String.class, "appTimeZone");
        appTimeZone = property15;
        Property<RealCgmHistoryEntity> property16 = new Property<>(realCgmHistoryEntity_2, 15, 58, String.class, "dstOffset");
        dstOffset = property16;
        Property<RealCgmHistoryEntity> property17 = new Property<>(realCgmHistoryEntity_2, 16, 51, Integer.TYPE, "briefUploadState");
        briefUploadState = property17;
        Property<RealCgmHistoryEntity> property18 = new Property<>(realCgmHistoryEntity_2, 17, 52, Integer.TYPE, "rawUploadState");
        rawUploadState = property18;
        Property<RealCgmHistoryEntity> property19 = new Property<>(realCgmHistoryEntity_2, 18, 4, String.class, "deviceSn");
        deviceSn = property19;
        Property<RealCgmHistoryEntity> property20 = new Property<>(realCgmHistoryEntity_2, 19, 31, String.class, "cgmRecordId");
        cgmRecordId = property20;
        Property<RealCgmHistoryEntity> property21 = new Property<>(realCgmHistoryEntity_2, 20, 32, String.class, "sensorId");
        sensorId = property21;
        Property<RealCgmHistoryEntity> property22 = new Property<>(realCgmHistoryEntity_2, 21, 5, Date.class, "deviceTime");
        deviceTime = property22;
        Property<RealCgmHistoryEntity> property23 = new Property<>(realCgmHistoryEntity_2, 22, 6, Integer.TYPE, "eventIndex");
        eventIndex = property23;
        Property<RealCgmHistoryEntity> property24 = new Property<>(realCgmHistoryEntity_2, 23, 7, Integer.TYPE, "sensorIndex");
        sensorIndex = property24;
        Property<RealCgmHistoryEntity> property25 = new Property<>(realCgmHistoryEntity_2, 24, 8, Integer.TYPE, "dataStatus");
        dataStatus = property25;
        Property<RealCgmHistoryEntity> property26 = new Property<>(realCgmHistoryEntity_2, 25, 11, Integer.class, "eventType");
        eventType = property26;
        Property<RealCgmHistoryEntity> property27 = new Property<>(realCgmHistoryEntity_2, 26, 34, Float.class, "glucose");
        glucose = property27;
        Property<RealCgmHistoryEntity> property28 = new Property<>(realCgmHistoryEntity_2, 27, 35, Float.class, "eventDataOrigin");
        eventDataOrigin = property28;
        Property<RealCgmHistoryEntity> property29 = new Property<>(realCgmHistoryEntity_2, 28, 40, Integer.class, "rawIsValid");
        rawIsValid = property29;
        Property<RealCgmHistoryEntity> property30 = new Property<>(realCgmHistoryEntity_2, 29, 41, Integer.TYPE, "glucoseIsValid");
        glucoseIsValid = property30;
        Property<RealCgmHistoryEntity> property31 = new Property<>(realCgmHistoryEntity_2, 30, 42, Integer.TYPE, "quality");
        quality = property31;
        Property<RealCgmHistoryEntity> property32 = new Property<>(realCgmHistoryEntity_2, 31, 43, Integer.TYPE, NotificationCompat.CATEGORY_STATUS);
        status = property32;
        Property<RealCgmHistoryEntity> property33 = new Property<>(realCgmHistoryEntity_2, 32, 45, Integer.TYPE, "timeOffset");
        timeOffset = property33;
        Property<RealCgmHistoryEntity> property34 = new Property<>(realCgmHistoryEntity_2, 33, 46, Float.class, "rawOne");
        rawOne = property34;
        Property<RealCgmHistoryEntity> property35 = new Property<>(realCgmHistoryEntity_2, 34, 47, Float.class, "rawTwo");
        rawTwo = property35;
        Property<RealCgmHistoryEntity> property36 = new Property<>(realCgmHistoryEntity_2, 35, 48, Float.class, "rawVc");
        rawVc = property36;
        Property<RealCgmHistoryEntity> property37 = new Property<>(realCgmHistoryEntity_2, 36, 16, Integer.TYPE, "eventWarning");
        eventWarning = property37;
        Property<RealCgmHistoryEntity> property38 = new Property<>(realCgmHistoryEntity_2, 37, 49, Float.TYPE, "referenceGlucose");
        referenceGlucose = property38;
        Property<RealCgmHistoryEntity> property39 = new Property<>(realCgmHistoryEntity_2, 38, 17, String.class, "deviceId");
        deviceId = property39;
        Property<RealCgmHistoryEntity> property40 = new Property<>(realCgmHistoryEntity_2, 39, 18, Integer.TYPE, TransmitterActivityKt.OPERATION_TYPE);
        type = property40;
        Property<RealCgmHistoryEntity> property41 = new Property<>(realCgmHistoryEntity_2, 40, 50, String.class, "frontRecordId");
        frontRecordId = property41;
        Property<RealCgmHistoryEntity> property42 = new Property<>(realCgmHistoryEntity_2, 41, 22, Float.class, "rawData1");
        rawData1 = property42;
        Property<RealCgmHistoryEntity> property43 = new Property<>(realCgmHistoryEntity_2, 42, 23, Float.class, "rawData2");
        rawData2 = property43;
        Property<RealCgmHistoryEntity> property44 = new Property<>(realCgmHistoryEntity_2, 43, 24, Float.class, "rawData3");
        rawData3 = property44;
        Property<RealCgmHistoryEntity> property45 = new Property<>(realCgmHistoryEntity_2, 44, 25, Float.class, "rawData4");
        rawData4 = property45;
        Property<RealCgmHistoryEntity> property46 = new Property<>(realCgmHistoryEntity_2, 45, 26, Float.class, "rawData5");
        rawData5 = property46;
        Property<RealCgmHistoryEntity> property47 = new Property<>(realCgmHistoryEntity_2, 46, 27, Float.class, "rawData6");
        rawData6 = property47;
        Property<RealCgmHistoryEntity> property48 = new Property<>(realCgmHistoryEntity_2, 47, 28, Float.class, "rawData7");
        rawData7 = property48;
        Property<RealCgmHistoryEntity> property49 = new Property<>(realCgmHistoryEntity_2, 48, 29, Float.class, "rawData8");
        rawData8 = property49;
        Property<RealCgmHistoryEntity> property50 = new Property<>(realCgmHistoryEntity_2, 49, 30, Float.class, "rawData9");
        rawData9 = property50;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15, property16, property17, property18, property19, property20, property21, property22, property23, property24, property25, property26, property27, property28, property29, property30, property31, property32, property33, property34, property35, property36, property37, property38, property39, property40, property41, property42, property43, property44, property45, property46, property47, property48, property49, property50};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "RealCgmHistoryEntity";
    }

    public Class<RealCgmHistoryEntity> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "RealCgmHistoryEntity";
    }

    public Property<RealCgmHistoryEntity>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<RealCgmHistoryEntity> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<RealCgmHistoryEntity> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<RealCgmHistoryEntity> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class RealCgmHistoryEntityIdGetter implements IdGetter<RealCgmHistoryEntity> {
        RealCgmHistoryEntityIdGetter() {
        }

        public long getId(RealCgmHistoryEntity realCgmHistoryEntity) {
            Long idx = realCgmHistoryEntity.getIdx();
            if (idx != null) {
                return idx.longValue();
            }
            return 0;
        }
    }
}
