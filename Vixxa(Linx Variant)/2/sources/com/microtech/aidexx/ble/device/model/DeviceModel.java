package com.microtech.aidexx.ble.device.model;

import com.microtech.aidexx.ble.device.entity.CalibrationInfo;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity_;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity_;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.utils.EncryptUtils;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtechmd.blecomm.controller.BleController;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import com.microtechmd.blecomm.entity.BleMessage;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0006¦\u0001§\u0001¨\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H&J'\u0010\u0001\u001a\u00020\r2\u0012\b\u0002\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J'\u0010\u0001\u001a\u00020\r2\u0012\b\u0002\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\u0001H¦@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u0004\u0018\u00010\u0007J\u0007\u0010\u0001\u001a\u00020\u000bJ\t\u0010\u0001\u001a\u00020qH&J\u000b\u0010\u0014\u001a\u0005\u0018\u00010\u0001H&J\u001a\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0003\u0010\u0001J\u0010\u0010\u0001\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010bJ\u001c\u0010\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u000bH&J\u0012\u0010\u0001\u001a\u00020\r2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0007J\t\u0010\u0001\u001a\u00020.H&J\t\u0010\u0001\u001a\u00020.H&J\u0007\u0010\u0001\u001a\u00020.J\u0007\u0010\u0001\u001a\u00020.J\t\u0010\u0001\u001a\u00020\rH&J\u0013\u0010\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H&J\u0007\u0010\u0001\u001a\u00020\rJ\u0013\u0010\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H&J\u0013\u0010\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030 \u0001H&J\u0013\u0010¡\u0001\u001a\u00020\r2\b\u0010\u0001\u001a\u00030\u0001H&J\u0010\u0010¢\u0001\u001a\u00020\r2\u0007\u0010£\u0001\u001a\u00020BJ\u0013\u0010¤\u0001\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0003\u0010¥\u0001RL\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001a\u00104\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00109\"\u0004\bI\u0010;R(\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00109\"\u0004\bR\u0010;R\u001c\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR \u0010Y\u001a\b\u0012\u0004\u0012\u00020\u000b0ZX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R&\u0010`\u001a\u0004\u0018\u00010\u000b2\b\u0010_\u001a\u0004\u0018\u00010\u000b8F@BX\u000e¢\u0006\n\n\u0002\u0010c\u001a\u0004\ba\u0010bR\u001a\u0010d\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR\u001a\u0010l\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010f\"\u0004\bn\u0010hR7\u0010o\u001a\u001f\u0012\u0013\u0012\u00110q¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(r\u0012\u0004\u0012\u00020\r\u0018\u00010pX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u00109\"\u0004\by\u0010;R\u001a\u0010z\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010f\"\u0004\b|\u0010hR\u001a\u0010}\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010f\"\u0004\b\u0010h\u0002\u0004\n\u0002\b\u0019¨\u0006©\u0001"}, d2 = {"Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "", "entity", "Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "(Lcom/microtech/aidexx/db/entity/TransmitterEntity;)V", "alert", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "time", "", "type", "", "getAlert", "()Lkotlin/jvm/functions/Function2;", "setAlert", "(Lkotlin/jvm/functions/Function2;)V", "controller", "Lcom/microtechmd/blecomm/controller/BleController;", "getController", "()Lcom/microtechmd/blecomm/controller/BleController;", "setController", "(Lcom/microtechmd/blecomm/controller/BleController;)V", "getEntity", "()Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "glucose", "", "getGlucose", "()Ljava/lang/Float;", "setGlucose", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "glucoseLevel", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "getGlucoseLevel", "()Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "setGlucoseLevel", "(Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;)V", "glucoseTrend", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseTrend;", "getGlucoseTrend", "()Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseTrend;", "setGlucoseTrend", "(Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseTrend;)V", "isGettingTransmitterData", "", "()Z", "setGettingTransmitterData", "(Z)V", "isHistoryValid", "setHistoryValid", "isSensorExpired", "setSensorExpired", "lastDownFastAlertTime", "", "getLastDownFastAlertTime", "()J", "setLastDownFastAlertTime", "(J)V", "lastHistoryAppTime", "getLastHistoryAppTime", "()Ljava/lang/String;", "setLastHistoryAppTime", "(Ljava/lang/String;)V", "lastHistoryTime", "Ljava/util/Date;", "getLastHistoryTime", "()Ljava/util/Date;", "setLastHistoryTime", "(Ljava/util/Date;)V", "lastUpFastAlertTime", "getLastUpFastAlertTime", "setLastUpFastAlertTime", "latestAdInfo", "Lkotlin/Pair;", "getLatestAdInfo", "()Lkotlin/Pair;", "setLatestAdInfo", "(Lkotlin/Pair;)V", "latestAdTime", "getLatestAdTime", "setLatestAdTime", "latestHistory", "Lcom/microtechmd/blecomm/parser/AidexXHistoryEntity;", "getLatestHistory", "()Lcom/microtechmd/blecomm/parser/AidexXHistoryEntity;", "setLatestHistory", "(Lcom/microtechmd/blecomm/parser/AidexXHistoryEntity;)V", "malFunctionList", "", "getMalFunctionList", "()Ljava/util/List;", "setMalFunctionList", "(Ljava/util/List;)V", "<set-?>", "minutesAgo", "getMinutesAgo", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "nextCalIndex", "getNextCalIndex", "()I", "setNextCalIndex", "(I)V", "nextEventIndex", "getNextEventIndex", "setNextEventIndex", "nextFullEventIndex", "getNextFullEventIndex", "setNextFullEventIndex", "onCalibrationPermitChange", "Lkotlin/Function1;", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$CalibrationState;", "state", "getOnCalibrationPermitChange", "()Lkotlin/jvm/functions/Function1;", "setOnCalibrationPermitChange", "(Lkotlin/jvm/functions/Function1;)V", "signalLostFlag", "getSignalLostFlag", "setSignalLostFlag", "targetCalIndex", "getTargetCalIndex", "setTargetCalIndex", "targetEventIndex", "getTargetEventIndex", "setTargetEventIndex", "calibration", "info", "Lcom/microtech/aidexx/ble/device/entity/CalibrationInfo;", "clearLocalPairInfo", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletePair", "deviceId", "deviceType", "getCalibrationState", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "(Ljava/lang/Float;)Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "getSensorRemainingTime", "handleAdvertisement", "data", "", "broadcastType", "insertHistoryDeviceRecord", "sn", "isAllowCalibration", "isDataValid", "isPaired", "isWarmingUp", "observerMessage", "onMessage", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "reset", "saveBriefHistoryFromConnect", "savePair", "scope", "Lkotlinx/coroutines/CoroutineScope;", "saveRawHistoryFromConnect", "updateStart", "sensorStartTime", "uploadPairInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CalibrationState", "GlucoseLevel", "GlucoseTrend", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceModel.kt */
public abstract class DeviceModel {
    private Function2<? super String, ? super Integer, Unit> alert;
    private BleController controller;
    private final TransmitterEntity entity;
    private Float glucose;
    private GlucoseLevel glucoseLevel;
    private GlucoseTrend glucoseTrend;
    private boolean isGettingTransmitterData;
    private boolean isHistoryValid;
    private boolean isSensorExpired;
    private long lastDownFastAlertTime;
    private String lastHistoryAppTime;
    private Date lastHistoryTime;
    private long lastUpFastAlertTime;
    private Pair<Integer, Integer> latestAdInfo;
    private long latestAdTime;
    private AidexXHistoryEntity latestHistory;
    private List<Integer> malFunctionList = new ArrayList();
    private Integer minutesAgo;
    private int nextCalIndex;
    private int nextEventIndex;
    private int nextFullEventIndex;
    private Function1<? super CalibrationState, Unit> onCalibrationPermitChange;
    private long signalLostFlag;
    private int targetCalIndex;
    private int targetEventIndex;

    public abstract void calibration(CalibrationInfo calibrationInfo);

    public abstract Object clearLocalPairInfo(Function0<Unit> function0, Continuation<? super Unit> continuation);

    public abstract Object deletePair(Function0<Unit> function0, Continuation<? super Unit> continuation);

    public abstract CalibrationState getCalibrationState();

    /* renamed from: getController  reason: collision with other method in class */
    public abstract BleControllerProxy m144getController();

    public abstract GlucoseLevel getGlucoseLevel(Float f);

    public abstract Integer getSensorRemainingTime();

    public abstract void handleAdvertisement(byte[] bArr, int i);

    public abstract boolean isAllowCalibration();

    public abstract boolean isDataValid();

    public abstract void observerMessage();

    public abstract void onMessage(BleMessage bleMessage);

    public abstract void saveBriefHistoryFromConnect(byte[] bArr);

    public abstract void savePair(CoroutineScope coroutineScope);

    public abstract void saveRawHistoryFromConnect(byte[] bArr);

    public abstract Object uploadPairInfo(Continuation<? super Unit> continuation);

    public DeviceModel(TransmitterEntity transmitterEntity) {
        Intrinsics.checkNotNullParameter(transmitterEntity, "entity");
        this.entity = transmitterEntity;
    }

    public TransmitterEntity getEntity() {
        return this.entity;
    }

    public final boolean isSensorExpired() {
        return this.isSensorExpired;
    }

    public final void setSensorExpired(boolean z) {
        this.isSensorExpired = z;
    }

    public final int getTargetEventIndex() {
        return this.targetEventIndex;
    }

    public final void setTargetEventIndex(int i) {
        this.targetEventIndex = i;
    }

    public final int getTargetCalIndex() {
        return this.targetCalIndex;
    }

    public final void setTargetCalIndex(int i) {
        this.targetCalIndex = i;
    }

    public final int getNextEventIndex() {
        return this.nextEventIndex;
    }

    public final void setNextEventIndex(int i) {
        this.nextEventIndex = i;
    }

    public final int getNextFullEventIndex() {
        return this.nextFullEventIndex;
    }

    public final void setNextFullEventIndex(int i) {
        this.nextFullEventIndex = i;
    }

    public final int getNextCalIndex() {
        return this.nextCalIndex;
    }

    public final void setNextCalIndex(int i) {
        this.nextCalIndex = i;
    }

    public final long getLatestAdTime() {
        return this.latestAdTime;
    }

    public final void setLatestAdTime(long j) {
        this.latestAdTime = j;
    }

    public final long getSignalLostFlag() {
        return this.signalLostFlag;
    }

    public final void setSignalLostFlag(long j) {
        this.signalLostFlag = j;
    }

    public final long getLastUpFastAlertTime() {
        return this.lastUpFastAlertTime;
    }

    public final void setLastUpFastAlertTime(long j) {
        this.lastUpFastAlertTime = j;
    }

    public final long getLastDownFastAlertTime() {
        return this.lastDownFastAlertTime;
    }

    public final void setLastDownFastAlertTime(long j) {
        this.lastDownFastAlertTime = j;
    }

    public final Pair<Integer, Integer> getLatestAdInfo() {
        return this.latestAdInfo;
    }

    public final void setLatestAdInfo(Pair<Integer, Integer> pair) {
        this.latestAdInfo = pair;
    }

    public final Float getGlucose() {
        return this.glucose;
    }

    public final void setGlucose(Float f) {
        this.glucose = f;
    }

    public final Date getLastHistoryTime() {
        return this.lastHistoryTime;
    }

    public final void setLastHistoryTime(Date date) {
        this.lastHistoryTime = date;
    }

    public final String getLastHistoryAppTime() {
        return this.lastHistoryAppTime;
    }

    public final void setLastHistoryAppTime(String str) {
        this.lastHistoryAppTime = str;
    }

    public final BleController getController() {
        return this.controller;
    }

    public final void setController(BleController bleController) {
        this.controller = bleController;
    }

    public final boolean isHistoryValid() {
        return this.isHistoryValid;
    }

    public final void setHistoryValid(boolean z) {
        this.isHistoryValid = z;
    }

    public final List<Integer> getMalFunctionList() {
        return this.malFunctionList;
    }

    public final void setMalFunctionList(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.malFunctionList = list;
    }

    public final GlucoseLevel getGlucoseLevel() {
        return this.glucoseLevel;
    }

    public final void setGlucoseLevel(GlucoseLevel glucoseLevel2) {
        this.glucoseLevel = glucoseLevel2;
    }

    public final GlucoseTrend getGlucoseTrend() {
        return this.glucoseTrend;
    }

    public final void setGlucoseTrend(GlucoseTrend glucoseTrend2) {
        this.glucoseTrend = glucoseTrend2;
    }

    public final AidexXHistoryEntity getLatestHistory() {
        return this.latestHistory;
    }

    public final void setLatestHistory(AidexXHistoryEntity aidexXHistoryEntity) {
        this.latestHistory = aidexXHistoryEntity;
    }

    public final boolean isGettingTransmitterData() {
        return this.isGettingTransmitterData;
    }

    public final void setGettingTransmitterData(boolean z) {
        this.isGettingTransmitterData = z;
    }

    public final Function2<String, Integer, Unit> getAlert() {
        return this.alert;
    }

    public final void setAlert(Function2<? super String, ? super Integer, Unit> function2) {
        this.alert = function2;
    }

    public final Function1<CalibrationState, Unit> getOnCalibrationPermitChange() {
        return this.onCalibrationPermitChange;
    }

    public final void setOnCalibrationPermitChange(Function1<? super CalibrationState, Unit> function1) {
        this.onCalibrationPermitChange = function1;
    }

    public final Integer getMinutesAgo() {
        Integer num;
        if (this.lastHistoryTime == null) {
            num = null;
        } else {
            long currentTimeMillis = TimeUtils.INSTANCE.getCurrentTimeMillis();
            Date date = this.lastHistoryTime;
            Intrinsics.checkNotNull(date);
            num = Integer.valueOf(ExtendsKt.millisToMinutes(currentTimeMillis - date.getTime()));
        }
        this.minutesAgo = num;
        return num;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModel.kt */
    public enum GlucoseLevel {
        LOW,
        NORMAL,
        HIGH;

        public static EnumEntries<GlucoseLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            GlucoseLevel[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseTrend;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "FAST_FALL", "FALL", "SLOW_FALL", "STEADY", "SLOW_UP", "UP", "FAST_UP", "UNKNOWN", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModel.kt */
    public enum GlucoseTrend {
        FAST_FALL(-3),
        FALL(-2),
        SLOW_FALL(-1),
        STEADY(0),
        SLOW_UP(1),
        UP(2),
        FAST_UP(3),
        UNKNOWN(-99);
        
        private final int index;

        public static EnumEntries<GlucoseTrend> getEntries() {
            return $ENTRIES;
        }

        private GlucoseTrend(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }

        static {
            GlucoseTrend[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final String deviceId() {
        return getEntity().getId();
    }

    public final int deviceType() {
        return getEntity().getDeviceType();
    }

    public final boolean isPaired() {
        return getEntity().getEncryptionKey() != null;
    }

    public final boolean isWarmingUp() {
        AidexXHistoryEntity aidexXHistoryEntity = this.latestHistory;
        return (aidexXHistoryEntity != null ? aidexXHistoryEntity.timeOffset : 61) < 60;
    }

    public static /* synthetic */ Object deletePair$default(DeviceModel deviceModel, Function0 function0, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function0 = null;
            }
            return deviceModel.deletePair(function0, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deletePair");
    }

    public static /* synthetic */ Object clearLocalPairInfo$default(DeviceModel deviceModel, Function0 function0, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function0 = null;
            }
            return deviceModel.clearLocalPairInfo(function0, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearLocalPairInfo");
    }

    public final void updateStart(Date date) {
        Unit unit;
        Intrinsics.checkNotNullParameter(date, "sensorStartTime");
        String md5 = EncryptUtils.Companion.md5(UserInfoManager.Companion.instance().userId() + getEntity().getDeviceSn() + getEntity().startTimeToIndex(date) + getEntity().startTimeToIndex(date));
        Box<RealCgmHistoryEntity> cgmHistoryBox = ObjectBox.INSTANCE.getCgmHistoryBox();
        Intrinsics.checkNotNull(cgmHistoryBox);
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryBox.query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Property<RealCgmHistoryEntity> property = RealCgmHistoryEntity_.sensorId;
        Intrinsics.checkNotNullExpressionValue(property, "sensorId");
        RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) ExtendsKt.equal(query, property, md5).orderDesc(RealCgmHistoryEntity_.timeOffset).build().findFirst();
        int i = 0;
        getEntity().setEventIndex(realCgmHistoryEntity != null ? realCgmHistoryEntity.getTimeOffset() : 0);
        this.nextEventIndex = getEntity().getEventIndex() + 1;
        Box<RealCgmHistoryEntity> cgmHistoryBox2 = ObjectBox.INSTANCE.getCgmHistoryBox();
        Intrinsics.checkNotNull(cgmHistoryBox2);
        QueryBuilder<RealCgmHistoryEntity> query2 = cgmHistoryBox2.query();
        Intrinsics.checkNotNullExpressionValue(query2, "query(...)");
        Property<RealCgmHistoryEntity> property2 = RealCgmHistoryEntity_.sensorId;
        Intrinsics.checkNotNullExpressionValue(property2, "sensorId");
        RealCgmHistoryEntity realCgmHistoryEntity2 = (RealCgmHistoryEntity) ExtendsKt.equal(query2, property2, md5).isNull(RealCgmHistoryEntity_.rawIsValid).order(RealCgmHistoryEntity_.timeOffset).build().findFirst();
        if (realCgmHistoryEntity2 != null) {
            getEntity().setFullEventIndex(realCgmHistoryEntity2.getTimeOffset() - 1);
            this.nextFullEventIndex = realCgmHistoryEntity2.getTimeOffset();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            DeviceModel deviceModel = this;
            getEntity().setFullEventIndex(getEntity().getEventIndex());
            this.nextFullEventIndex = getEntity().getEventIndex() + 1;
        }
        Box<CalibrateEntity> calibrationBox = ObjectBox.INSTANCE.getCalibrationBox();
        Intrinsics.checkNotNull(calibrationBox);
        QueryBuilder<CalibrateEntity> query3 = calibrationBox.query();
        Intrinsics.checkNotNullExpressionValue(query3, "query(...)");
        Property<CalibrateEntity> property3 = CalibrateEntity_.sensorId;
        Intrinsics.checkNotNullExpressionValue(property3, "sensorId");
        CalibrateEntity calibrateEntity = (CalibrateEntity) ExtendsKt.equal(query3, property3, md5).orderDesc(CalibrateEntity_.index).build().findFirst();
        TransmitterEntity entity2 = getEntity();
        if (calibrateEntity != null) {
            i = calibrateEntity.getIndex();
        }
        entity2.setCalIndex(i);
        this.nextCalIndex = getEntity().getCalIndex() + 1;
        getEntity().setSensorStartTime(date);
        LogUtil.Companion.eAiDEX("Init data index, Start time:" + ExtendsKt.date2ymdhm$default(date, (String) null, 1, (Object) null) + ", Brief index:" + getEntity().getEventIndex() + ", Raw index:" + getEntity().getFullEventIndex() + ",cal index:" + getEntity().getCalIndex());
    }

    public final void reset() {
        getEntity().setSensorStartTime((Date) null);
    }

    public final void insertHistoryDeviceRecord(String str) {
        HistoryDeviceInfo historyDeviceInfo = new HistoryDeviceInfo();
        historyDeviceInfo.setDeviceSn(str);
        historyDeviceInfo.setRegisterTime(new Date());
        Box<HistoryDeviceInfo> historyDeviceBox = ObjectBox.INSTANCE.getHistoryDeviceBox();
        Intrinsics.checkNotNull(historyDeviceBox);
        historyDeviceBox.put(historyDeviceInfo);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000b\"\u0004\b\u000e\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/ble/device/model/DeviceModel$CalibrationState;", "", "isPaired", "", "isSensorExpired", "deviceAllow", "withIn6Hrs", "isConnected", "signalLost", "(ZZZZZZ)V", "getDeviceAllow", "()Z", "setDeviceAllow", "(Z)V", "setConnected", "setPaired", "setSensorExpired", "getSignalLost", "setSignalLost", "getWithIn6Hrs", "setWithIn6Hrs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceModel.kt */
    public static final class CalibrationState {
        private boolean deviceAllow;
        private boolean isConnected;
        private boolean isPaired;
        private boolean isSensorExpired;
        private boolean signalLost;
        private boolean withIn6Hrs;

        public static /* synthetic */ CalibrationState copy$default(CalibrationState calibrationState, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i, Object obj) {
            if ((i & 1) != 0) {
                z = calibrationState.isPaired;
            }
            if ((i & 2) != 0) {
                z2 = calibrationState.isSensorExpired;
            }
            boolean z7 = z2;
            if ((i & 4) != 0) {
                z3 = calibrationState.deviceAllow;
            }
            boolean z8 = z3;
            if ((i & 8) != 0) {
                z4 = calibrationState.withIn6Hrs;
            }
            boolean z9 = z4;
            if ((i & 16) != 0) {
                z5 = calibrationState.isConnected;
            }
            boolean z10 = z5;
            if ((i & 32) != 0) {
                z6 = calibrationState.signalLost;
            }
            return calibrationState.copy(z, z7, z8, z9, z10, z6);
        }

        public final boolean component1() {
            return this.isPaired;
        }

        public final boolean component2() {
            return this.isSensorExpired;
        }

        public final boolean component3() {
            return this.deviceAllow;
        }

        public final boolean component4() {
            return this.withIn6Hrs;
        }

        public final boolean component5() {
            return this.isConnected;
        }

        public final boolean component6() {
            return this.signalLost;
        }

        public final CalibrationState copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            return new CalibrationState(z, z2, z3, z4, z5, z6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalibrationState)) {
                return false;
            }
            CalibrationState calibrationState = (CalibrationState) obj;
            return this.isPaired == calibrationState.isPaired && this.isSensorExpired == calibrationState.isSensorExpired && this.deviceAllow == calibrationState.deviceAllow && this.withIn6Hrs == calibrationState.withIn6Hrs && this.isConnected == calibrationState.isConnected && this.signalLost == calibrationState.signalLost;
        }

        public int hashCode() {
            boolean z = this.isPaired;
            boolean z2 = true;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            boolean z3 = this.isSensorExpired;
            if (z3) {
                z3 = true;
            }
            int i2 = (i + (z3 ? 1 : 0)) * 31;
            boolean z4 = this.deviceAllow;
            if (z4) {
                z4 = true;
            }
            int i3 = (i2 + (z4 ? 1 : 0)) * 31;
            boolean z5 = this.withIn6Hrs;
            if (z5) {
                z5 = true;
            }
            int i4 = (i3 + (z5 ? 1 : 0)) * 31;
            boolean z6 = this.isConnected;
            if (z6) {
                z6 = true;
            }
            int i5 = (i4 + (z6 ? 1 : 0)) * 31;
            boolean z7 = this.signalLost;
            if (!z7) {
                z2 = z7;
            }
            return i5 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "CalibrationState(isPaired=" + this.isPaired + ", isSensorExpired=" + this.isSensorExpired + ", deviceAllow=" + this.deviceAllow + ", withIn6Hrs=" + this.withIn6Hrs + ", isConnected=" + this.isConnected + ", signalLost=" + this.signalLost + ')';
        }

        public CalibrationState(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.isPaired = z;
            this.isSensorExpired = z2;
            this.deviceAllow = z3;
            this.withIn6Hrs = z4;
            this.isConnected = z5;
            this.signalLost = z6;
        }

        public final boolean isPaired() {
            return this.isPaired;
        }

        public final void setPaired(boolean z) {
            this.isPaired = z;
        }

        public final boolean isSensorExpired() {
            return this.isSensorExpired;
        }

        public final void setSensorExpired(boolean z) {
            this.isSensorExpired = z;
        }

        public final boolean getDeviceAllow() {
            return this.deviceAllow;
        }

        public final void setDeviceAllow(boolean z) {
            this.deviceAllow = z;
        }

        public final boolean getWithIn6Hrs() {
            return this.withIn6Hrs;
        }

        public final void setWithIn6Hrs(boolean z) {
            this.withIn6Hrs = z;
        }

        public final boolean isConnected() {
            return this.isConnected;
        }

        public final void setConnected(boolean z) {
            this.isConnected = z;
        }

        public final boolean getSignalLost() {
            return this.signalLost;
        }

        public final void setSignalLost(boolean z) {
            this.signalLost = z;
        }
    }
}
