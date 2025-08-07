package com.microtech.aidexx.db.entity;

import com.microtech.aidexx.db.entity.HistoryDeviceInfoCursor;
import io.objectbox.EntityInfo;
import io.objectbox.Property;
import io.objectbox.internal.CursorFactory;
import io.objectbox.internal.IdGetter;
import java.util.Date;

public final class HistoryDeviceInfo_ implements EntityInfo<HistoryDeviceInfo> {
    public static final Property<HistoryDeviceInfo>[] __ALL_PROPERTIES;
    public static final CursorFactory<HistoryDeviceInfo> __CURSOR_FACTORY = new HistoryDeviceInfoCursor.Factory();
    public static final String __DB_NAME = "HistoryDeviceInfo";
    public static final Class<HistoryDeviceInfo> __ENTITY_CLASS = HistoryDeviceInfo.class;
    public static final int __ENTITY_ID = 27;
    public static final String __ENTITY_NAME = "HistoryDeviceInfo";
    static final HistoryDeviceInfoIdGetter __ID_GETTER = new HistoryDeviceInfoIdGetter();
    public static final Property<HistoryDeviceInfo> __ID_PROPERTY;
    public static final HistoryDeviceInfo_ __INSTANCE;
    public static final Property<HistoryDeviceInfo> deviceId;
    public static final Property<HistoryDeviceInfo> deviceKey;
    public static final Property<HistoryDeviceInfo> deviceMac;
    public static final Property<HistoryDeviceInfo> deviceModel;
    public static final Property<HistoryDeviceInfo> deviceSn;
    public static final Property<HistoryDeviceInfo> et;
    public static final Property<HistoryDeviceInfo> idx;
    public static final Property<HistoryDeviceInfo> name;
    public static final Property<HistoryDeviceInfo> registerTime;
    public static final Property<HistoryDeviceInfo> sensorId;
    public static final Property<HistoryDeviceInfo> sensorIndex;
    public static final Property<HistoryDeviceInfo> sensorStartUp;
    public static final Property<HistoryDeviceInfo> startUpTimeZone;
    public static final Property<HistoryDeviceInfo> unregisterTime;
    public static final Property<HistoryDeviceInfo> userId;

    public int getEntityId() {
        return 27;
    }

    static {
        HistoryDeviceInfo_ historyDeviceInfo_ = new HistoryDeviceInfo_();
        __INSTANCE = historyDeviceInfo_;
        HistoryDeviceInfo_ historyDeviceInfo_2 = historyDeviceInfo_;
        Property<HistoryDeviceInfo> property = new Property<>(historyDeviceInfo_2, 0, 1, Long.TYPE, "idx", true, "idx");
        idx = property;
        Property<HistoryDeviceInfo> property2 = new Property<>(historyDeviceInfo_2, 1, 2, String.class, "deviceId");
        deviceId = property2;
        Property<HistoryDeviceInfo> property3 = new Property<>(historyDeviceInfo_2, 2, 3, String.class, "userId");
        userId = property3;
        Property<HistoryDeviceInfo> property4 = new Property<>(historyDeviceInfo_2, 3, 4, String.class, "sensorId");
        sensorId = property4;
        Property<HistoryDeviceInfo> property5 = new Property<>(historyDeviceInfo_2, 4, 5, Integer.TYPE, "sensorIndex");
        sensorIndex = property5;
        Property<HistoryDeviceInfo> property6 = new Property<>(historyDeviceInfo_2, 5, 6, Date.class, "sensorStartUp");
        sensorStartUp = property6;
        Property<HistoryDeviceInfo> property7 = new Property<>(historyDeviceInfo_2, 6, 7, String.class, "startUpTimeZone");
        startUpTimeZone = property7;
        Property<HistoryDeviceInfo> property8 = new Property<>(historyDeviceInfo_2, 7, 8, Integer.TYPE, "deviceModel");
        deviceModel = property8;
        Property<HistoryDeviceInfo> property9 = new Property<>(historyDeviceInfo_2, 8, 9, String.class, "deviceSn");
        deviceSn = property9;
        Property<HistoryDeviceInfo> property10 = new Property<>(historyDeviceInfo_2, 9, 10, String.class, "deviceMac");
        deviceMac = property10;
        Property<HistoryDeviceInfo> property11 = new Property<>(historyDeviceInfo_2, 10, 11, String.class, "deviceKey");
        deviceKey = property11;
        Property<HistoryDeviceInfo> property12 = new Property<>(historyDeviceInfo_2, 11, 12, Date.class, "registerTime");
        registerTime = property12;
        Property<HistoryDeviceInfo> property13 = new Property<>(historyDeviceInfo_2, 12, 13, Date.class, "unregisterTime");
        unregisterTime = property13;
        Property<HistoryDeviceInfo> property14 = new Property<>(historyDeviceInfo_2, 13, 14, Integer.TYPE, "et");
        et = property14;
        Property<HistoryDeviceInfo> property15 = new Property<>(historyDeviceInfo_2, 14, 15, String.class, "name");
        name = property15;
        __ALL_PROPERTIES = new Property[]{property, property2, property3, property4, property5, property6, property7, property8, property9, property10, property11, property12, property13, property14, property15};
        __ID_PROPERTY = property;
    }

    public String getEntityName() {
        return "HistoryDeviceInfo";
    }

    public Class<HistoryDeviceInfo> getEntityClass() {
        return __ENTITY_CLASS;
    }

    public String getDbName() {
        return "HistoryDeviceInfo";
    }

    public Property<HistoryDeviceInfo>[] getAllProperties() {
        return __ALL_PROPERTIES;
    }

    public Property<HistoryDeviceInfo> getIdProperty() {
        return __ID_PROPERTY;
    }

    public IdGetter<HistoryDeviceInfo> getIdGetter() {
        return __ID_GETTER;
    }

    public CursorFactory<HistoryDeviceInfo> getCursorFactory() {
        return __CURSOR_FACTORY;
    }

    static final class HistoryDeviceInfoIdGetter implements IdGetter<HistoryDeviceInfo> {
        HistoryDeviceInfoIdGetter() {
        }

        public long getId(HistoryDeviceInfo historyDeviceInfo) {
            return historyDeviceInfo.getIdx();
        }
    }
}
