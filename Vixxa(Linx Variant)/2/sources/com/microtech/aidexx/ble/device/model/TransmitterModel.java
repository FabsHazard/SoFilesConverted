package com.microtech.aidexx.ble.device.model;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.ble.AidexBleAdapter;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.entity.CalibrationInfo;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity_;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.ui.main.home.HomeFragmentKt;
import com.microtech.aidexx.ui.main.home.HomeStateManager;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.ui.setting.alert.AlertUtil;
import com.microtech.aidexx.utils.ByteUtils;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.eventbus.CgmDataState;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.SignalLostCheckDialog;
import com.microtechmd.blecomm.constant.AidexXOperation;
import com.microtechmd.blecomm.controller.AidexXController;
import com.microtechmd.blecomm.controller.BleController;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import com.microtechmd.blecomm.entity.BleMessage;
import com.microtechmd.blecomm.parser.AidexXAbstractEntity;
import com.microtechmd.blecomm.parser.AidexXBroadcastEntity;
import com.microtechmd.blecomm.parser.AidexXCalibrationEntity;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import com.microtechmd.blecomm.parser.AidexXInstantHistoryEntity;
import com.microtechmd.blecomm.parser.AidexXParser;
import com.microtechmd.blecomm.parser.AidexXRawHistoryEntity;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 o2\u00020\u0001:\u0001oB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J!\u0010-\u001a\u00020*2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010/H@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u00101\u001a\u00020*H\u0002J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J!\u00104\u001a\u00020*2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010/H@ø\u0001\u0000¢\u0006\u0002\u00100J\b\u00105\u001a\u000206H\u0016J\n\u00107\u001a\u0004\u0018\u000108H\u0016J\u0019\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0002\u0010=J$\u0010>\u001a\b\u0012\u0004\u0012\u00020?0$2\u0006\u0010@\u001a\u00020\b2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020?0$H\u0002J\u0018\u0010B\u001a\u00020\u00192\u0006\u0010C\u001a\u00020\u00172\u0006\u0010D\u001a\u00020\bH\u0002J\u000f\u0010E\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010FJ\u0018\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\bH\u0016J\u0010\u0010K\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020MH\u0016J\u0006\u0010O\u001a\u00020MJ\u001e\u0010P\u001a\u00020M2\u0006\u0010@\u001a\u00020\b2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020?0RH\u0002J\b\u0010S\u001a\u00020*H\u0016J\u0010\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020VH\u0016J \u0010W\u001a\u00020M2\u0006\u0010X\u001a\u00020\b2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bH\u0002J \u0010[\u001a\u00020*2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020?0$2\b\b\u0002\u0010\\\u001a\u00020MH\u0002J\u0010\u0010]\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0016J\u001a\u0010^\u001a\u00020*2\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010_\u001a\u00020MH\u0002J\u0010\u0010`\u001a\u00020*2\u0006\u0010a\u001a\u00020bH\u0016J\u0016\u0010c\u001a\u00020*2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020e0RH\u0002J\u0010\u0010f\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0016J\b\u0010g\u001a\u00020*H\u0002J/\u0010h\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020i2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010j\u001a\u00020k2\u0006\u0010X\u001a\u00020\bH\u0002¢\u0006\u0002\u0010lJ\u0011\u0010m\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006p"}, d2 = {"Lcom/microtech/aidexx/ble/device/model/TransmitterModel;", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "entity", "Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "(Lcom/microtech/aidexx/db/entity/TransmitterEntity;)V", "alertSetting", "Lcom/microtech/aidexx/db/entity/SettingsEntity;", "briefRangeStartIndex", "", "briefRunnable", "Ljava/lang/Runnable;", "calRangeStartIndex", "calRunnable", "calTempBitArray", "", "dataTypeNeedSync", "getDataTypeNeedSync", "()I", "setDataTypeNeedSync", "(I)V", "getEntity", "()Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "lastAlertTimezone", "", "lastHyperAlertTime", "", "lastHypoAlertTime", "lastUrgentAlertTime", "mHandler", "Landroid/os/Handler;", "newestCalIndex", "newestEventIndex", "rawRangeStartIndex", "rawRunnable", "statusBitArray", "tempBriefList", "", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "tempCalList", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "tempRawList", "calibration", "", "info", "Lcom/microtech/aidexx/ble/device/entity/CalibrationInfo;", "clearLocalPairInfo", "callback", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "continueBriefFetch", "continueCalFetch", "continueRawFetch", "deletePair", "getCalibrationState", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$CalibrationState;", "getController", "Lcom/microtechmd/blecomm/controller/AidexXController;", "getGlucoseLevel", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "glucose", "", "(Ljava/lang/Float;)Lcom/microtech/aidexx/ble/device/model/DeviceModel$GlucoseLevel;", "getHistoriesFromBroadcast", "Lcom/microtechmd/blecomm/parser/AidexXHistoryEntity;", "next", "list", "getLastAlertTime", "sensorId", "type", "getSensorRemainingTime", "()Ljava/lang/Integer;", "handleAdvertisement", "data", "", "broadcastType", "handleLongConnectNotify", "isAllowCalibration", "", "isDataValid", "isFirstInsertSensor", "isNextInBroadcast", "histories", "", "observerMessage", "onMessage", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "refreshSensorState", "status", "calTemp", "timeOffset", "saveBriefHistory", "goon", "saveBriefHistoryFromConnect", "saveCalHistory", "isAuto", "savePair", "scope", "Lkotlinx/coroutines/CoroutineScope;", "saveRawHistory", "rawHistories", "Lcom/microtechmd/blecomm/parser/AidexXRawHistoryEntity;", "saveRawHistoryFromConnect", "startLongConnect", "updateTrend", "Lcom/microtechmd/blecomm/parser/AidexXAbstractEntity;", "historyDate", "Ljava/util/Date;", "(Lcom/microtechmd/blecomm/parser/AidexXAbstractEntity;Ljava/lang/Float;Ljava/util/Date;I)V", "uploadPairInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TransmitterModel.kt */
public final class TransmitterModel extends DeviceModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public SettingsEntity alertSetting;
    private int briefRangeStartIndex;
    private final Runnable briefRunnable;
    private int calRangeStartIndex;
    private final Runnable calRunnable;
    private final int[] calTempBitArray;
    private int dataTypeNeedSync;
    private final TransmitterEntity entity;
    private String lastAlertTimezone;
    private long lastHyperAlertTime;
    private long lastHypoAlertTime;
    private long lastUrgentAlertTime;
    private final Handler mHandler;
    private int newestCalIndex;
    private int newestEventIndex;
    private int rawRangeStartIndex;
    private final Runnable rawRunnable;
    private final int[] statusBitArray;
    /* access modifiers changed from: private */
    public final List<RealCgmHistoryEntity> tempBriefList;
    /* access modifiers changed from: private */
    public final List<CalibrateEntity> tempCalList;
    /* access modifiers changed from: private */
    public final List<RealCgmHistoryEntity> tempRawList;

    public /* synthetic */ TransmitterModel(TransmitterEntity transmitterEntity, DefaultConstructorMarker defaultConstructorMarker) {
        this(transmitterEntity);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ble/device/model/TransmitterModel$Companion;", "", "()V", "instance", "Lcom/microtech/aidexx/ble/device/model/TransmitterModel;", "entity", "Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "bleControllerProxy", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: TransmitterModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized TransmitterModel instance(TransmitterEntity transmitterEntity, BleControllerProxy bleControllerProxy) {
            TransmitterModel transmitterModel;
            Intrinsics.checkNotNullParameter(transmitterEntity, "entity");
            Intrinsics.checkNotNullParameter(bleControllerProxy, "bleControllerProxy");
            transmitterModel = new TransmitterModel(transmitterEntity, (DefaultConstructorMarker) null);
            transmitterModel.setNextEventIndex(transmitterEntity.getEventIndex() + 1);
            transmitterModel.setNextFullEventIndex(transmitterEntity.getFullEventIndex() + 1);
            transmitterModel.setNextCalIndex(transmitterEntity.getCalIndex() + 1);
            transmitterModel.setController(bleControllerProxy);
            BleController controller = transmitterModel.getController();
            if (controller != null) {
                controller.setMac(transmitterEntity.getDeviceMac());
                controller.setSn(transmitterEntity.getDeviceSn());
                CharSequence name = controller.getName();
                if (name == null || name.length() == 0) {
                    String deviceName = transmitterEntity.getDeviceName();
                    if (deviceName == null) {
                        deviceName = DeviceModelKt.NAME_LINX;
                    }
                    controller.setName(deviceName);
                }
                String userId = UserInfoManager.Companion.instance().userId();
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
                byte[] bytes = userId.getBytes(forName);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                controller.setHostAddress(bytes);
                controller.setId(transmitterEntity.getAccessId());
                controller.setKey(transmitterEntity.getEncryptionKey());
                controller.setMessageCallback(new TransmitterModel$Companion$$ExternalSyntheticLambda0(transmitterEntity));
            }
            return transmitterModel;
        }

        /* access modifiers changed from: private */
        public static final void instance$lambda$1$lambda$0(TransmitterEntity transmitterEntity, int i, boolean z, byte[] bArr) {
            byte b;
            byte[] bArr2;
            Intrinsics.checkNotNullParameter(transmitterEntity, "$entity");
            if (1 > i || i >= 4) {
                byte[] subByte = ByteUtils.subByte(bArr, 1, bArr.length - 1);
                b = bArr[0];
                bArr2 = subByte;
            } else {
                bArr2 = bArr;
                b = 1;
            }
            MessageDistributor.Companion.instance().send(new BleMessage(i, z, bArr2, b, transmitterEntity.getMessageType()));
        }
    }

    private TransmitterModel(TransmitterEntity transmitterEntity) {
        super(transmitterEntity);
        this.entity = transmitterEntity;
        this.tempBriefList = new ArrayList();
        this.tempRawList = new ArrayList();
        this.tempCalList = new ArrayList();
        this.statusBitArray = new int[6];
        this.calTempBitArray = new int[6];
        this.mHandler = new Handler(Looper.getMainLooper());
        this.briefRunnable = new TransmitterModel$$ExternalSyntheticLambda0(this);
        this.rawRunnable = new TransmitterModel$$ExternalSyntheticLambda1(this);
        this.calRunnable = new TransmitterModel$$ExternalSyntheticLambda2(this);
    }

    public TransmitterEntity getEntity() {
        return this.entity;
    }

    public void observerMessage() {
        MessageDistributor.Companion.instance().clear();
        MessageDistributor.Companion.instance().observer(new TransmitterModel$observerMessage$1(this));
    }

    public final int getDataTypeNeedSync() {
        return this.dataTypeNeedSync;
    }

    public final void setDataTypeNeedSync(int i) {
        this.dataTypeNeedSync = i;
    }

    public void onMessage(BleMessage bleMessage) {
        Intrinsics.checkNotNullParameter(bleMessage, CrashHianalyticsData.MESSAGE);
        LogUtil.Companion.d$default(LogUtil.Companion, "onMessage=" + bleMessage, (String) null, 2, (Object) null);
        byte[] data = bleMessage.getData();
        int operation = bleMessage.getOperation();
        if (operation == 1) {
            if (bleMessage.isSuccess()) {
                byte[] data2 = bleMessage.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
                handleAdvertisement(data2, 1);
            }
        } else if (operation == AidexXOperation.SET_NEW_SENSOR) {
            OtaManager.Companion.instance().setHasDoNewSensor(true);
            if (!bleMessage.isSuccess()) {
                HomeStateManager.Companion.instance().setState(HomeFragmentKt.glucosePanel);
            } else {
                DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
                if (deviceModel != null) {
                    deviceModel.reset();
                }
            }
            Boolean bool = BuildConfig.keepAlive;
            Intrinsics.checkNotNullExpressionValue(bool, "keepAlive");
            if (bool.booleanValue()) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new TransmitterModel$onMessage$1(this, (Continuation<? super TransmitterModel$onMessage$1>) null), 3, (Object) null);
            }
            if (OtaManager.Companion.instance().needCheckOtaVersion()) {
                AidexBleAdapter.Companion.getInstance().readBootLoaderVersion();
            } else {
                OtaManager.Companion.instance().uploadOtaInfo();
            }
        } else if (operation == AidexXOperation.GET_BOOT_VERSION) {
            CharSequence otaInfo = MmkvManager.INSTANCE.getOtaInfo();
            if (otaInfo.length() == 0) {
                otaInfo = null;
            }
            String str = (String) otaInfo;
            if (str != null) {
                Gson gson = new Gson();
                OtaInfo otaInfo2 = (OtaInfo) gson.fromJson(str, OtaInfo.class);
                otaInfo2.setBootNewVersion(ByteUtils.getBootVersion(bleMessage.getData()));
                LogUtil.Companion.xLogI$default(LogUtil.Companion, "OTA 更新 boot version " + otaInfo2.getBootNewVersion(), (String) null, 2, (Object) null);
                MmkvManager mmkvManager = MmkvManager.INSTANCE;
                String json = gson.toJson((Object) otaInfo2);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                mmkvManager.setOtaInfo(json);
                if (!OtaManager.Companion.instance().needCheckOtaVersion()) {
                    OtaManager.Companion.instance().uploadOtaInfo();
                }
            }
        } else if (operation == AidexXOperation.GET_START_TIME) {
            Date checkToDate = ByteUtils.checkToDate(data);
            if (checkToDate != null) {
                ObjectBox.runAsync$default(ObjectBox.INSTANCE, new TransmitterModel$$ExternalSyntheticLambda5(this, checkToDate), new TransmitterModel$onMessage$4$2(this), (Function1) null, 4, (Object) null);
            }
        } else if (operation != 7 && operation != 3 && operation != 17 && operation != 4877 && operation != 6 && operation != 5) {
            if (operation == AidexXOperation.GET_HISTORY_RANGE) {
                byte[] data3 = bleMessage.getData();
                if (data3.length < 6) {
                    LogUtil.Companion.xLogE$default(LogUtil.Companion, "get history range failed message=" + bleMessage, (String) null, 2, (Object) null);
                    return;
                }
                this.briefRangeStartIndex = ((data3[1] & UByte.MAX_VALUE) << 8) + (data3[0] & UByte.MAX_VALUE);
                this.rawRangeStartIndex = ((data3[3] & UByte.MAX_VALUE) << 8) + (data3[2] & UByte.MAX_VALUE);
                this.newestEventIndex = ((data3[5] & UByte.MAX_VALUE) << 8) + (data3[4] & UByte.MAX_VALUE);
                LogUtil.Companion.eAiDEX("get history range --> brief start:" + this.briefRangeStartIndex + ", raw start:" + this.rawRangeStartIndex + ", newest:" + this.newestEventIndex);
                int i = this.dataTypeNeedSync;
                if (i == 1) {
                    int nextEventIndex = getNextEventIndex();
                    int i2 = this.briefRangeStartIndex;
                    if (nextEventIndex < i2) {
                        setNextEventIndex(i2);
                    }
                    AidexXController controller = getController();
                    if (controller != null) {
                        controller.getHistories(getNextEventIndex());
                    }
                    LogUtil.Companion.eAiDEX("Get brief history from sensor from index : " + getNextEventIndex());
                } else if (i == 2) {
                    int nextFullEventIndex = getNextFullEventIndex();
                    int i3 = this.rawRangeStartIndex;
                    if (nextFullEventIndex < i3) {
                        setNextFullEventIndex(i3);
                    }
                    AidexXController controller2 = getController();
                    if (controller2 != null) {
                        controller2.getRawHistories(getNextFullEventIndex());
                    }
                    LogUtil.Companion.eAiDEX("Get raw history from sensor from index : " + getNextFullEventIndex());
                }
            } else if (operation == AidexXOperation.GET_CALIBRATION_RANGE) {
                byte[] data4 = bleMessage.getData();
                this.calRangeStartIndex = ((data4[1] & UByte.MAX_VALUE) << 8) + (data4[0] & UByte.MAX_VALUE);
                this.newestCalIndex = ((data4[3] & UByte.MAX_VALUE) << 8) + (data4[2] & UByte.MAX_VALUE);
                LogUtil.Companion.eAiDEX("get calibration range --- cal start:" + this.calRangeStartIndex + ", cal newest:" + this.newestCalIndex);
            } else if (operation == AidexXOperation.GET_CALIBRATION) {
                if (UserInfoManager.Companion.instance().isLogin()) {
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), Dispatchers.getIO(), (CoroutineStart) null, new TransmitterModel$onMessage$7(this, bleMessage, (Continuation<? super TransmitterModel$onMessage$7>) null), 2, (Object) null);
                }
            } else if (operation == AidexXOperation.GET_HISTORIES) {
                if (UserInfoManager.Companion.instance().isLogin()) {
                    byte[] data5 = bleMessage.getData();
                    Intrinsics.checkNotNullExpressionValue(data5, "getData(...)");
                    saveBriefHistoryFromConnect(data5);
                }
            } else if (operation == AidexXOperation.GET_HISTORIES_RAW) {
                if (UserInfoManager.Companion.instance().isLogin()) {
                    byte[] data6 = bleMessage.getData();
                    Intrinsics.checkNotNullExpressionValue(data6, "getData(...)");
                    saveRawHistoryFromConnect(data6);
                }
            } else if (operation == AidexXOperation.AUTO_UPDATE_CALIBRATION) {
                if (UserInfoManager.Companion.instance().isLogin()) {
                    Job unused3 = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), Dispatchers.getIO(), (CoroutineStart) null, new TransmitterModel$onMessage$8(this, bleMessage, (Continuation<? super TransmitterModel$onMessage$8>) null), 2, (Object) null);
                }
            } else if (operation == AidexXOperation.AUTO_UPDATE_FULL_HISTORY) {
                if (UserInfoManager.Companion.instance().isLogin()) {
                    Job unused4 = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new TransmitterModel$onMessage$9(this, data, (Continuation<? super TransmitterModel$onMessage$9>) null), 3, (Object) null);
                }
            } else if (operation == AidexXOperation.AUTO_UPDATE_SENSOR_EXPIRED) {
                setSensorExpired(true);
            } else if (operation == AidexXOperation.GET_BROADCAST_DATA && UserInfoManager.Companion.instance().isLogin()) {
                Intrinsics.checkNotNull(data);
                handleAdvertisement(data, 2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onMessage$lambda$3$lambda$2(TransmitterModel transmitterModel, Date date) {
        Intrinsics.checkNotNullParameter(transmitterModel, "this$0");
        Intrinsics.checkNotNull(date);
        transmitterModel.updateStart(date);
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        transmitterBox.put(transmitterModel.getEntity());
    }

    /* access modifiers changed from: private */
    public static final void briefRunnable$lambda$6(TransmitterModel transmitterModel) {
        Intrinsics.checkNotNullParameter(transmitterModel, "this$0");
        if (transmitterModel.newestEventIndex == transmitterModel.getTargetEventIndex()) {
            int nextEventIndex = transmitterModel.getNextEventIndex();
            int i = transmitterModel.briefRangeStartIndex;
            if (nextEventIndex < i) {
                transmitterModel.setNextEventIndex(i);
            }
            AidexXController controller = transmitterModel.getController();
            if (controller != null) {
                controller.getHistories(transmitterModel.getNextEventIndex());
            }
            LogUtil.Companion.eAiDEX("Notify triggers get brief history from sensor from index : " + transmitterModel.getNextEventIndex());
            return;
        }
        transmitterModel.dataTypeNeedSync = 1;
        AidexXController controller2 = transmitterModel.getController();
        if (controller2 != null) {
            controller2.getHistoryRange();
        }
    }

    /* access modifiers changed from: private */
    public static final void rawRunnable$lambda$7(TransmitterModel transmitterModel) {
        Intrinsics.checkNotNullParameter(transmitterModel, "this$0");
        if (transmitterModel.getNextFullEventIndex() == transmitterModel.getTargetEventIndex()) {
            AidexXController controller = transmitterModel.getController();
            if (controller != null) {
                controller.getRawHistories(transmitterModel.getNextFullEventIndex());
            }
        } else if (transmitterModel.newestEventIndex == transmitterModel.getTargetEventIndex()) {
            int nextFullEventIndex = transmitterModel.getNextFullEventIndex();
            int i = transmitterModel.rawRangeStartIndex;
            if (nextFullEventIndex < i) {
                transmitterModel.setNextFullEventIndex(i);
            }
            AidexXController controller2 = transmitterModel.getController();
            if (controller2 != null) {
                controller2.getRawHistories(transmitterModel.getNextFullEventIndex());
            }
            LogUtil.Companion.eAiDEX("Notify triggers get raw history from sensor from " + transmitterModel.getNextFullEventIndex());
        } else {
            transmitterModel.dataTypeNeedSync = 2;
            AidexXController controller3 = transmitterModel.getController();
            if (controller3 != null) {
                controller3.getHistoryRange();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void calRunnable$lambda$8(TransmitterModel transmitterModel) {
        Intrinsics.checkNotNullParameter(transmitterModel, "this$0");
        if (transmitterModel.newestCalIndex == transmitterModel.getTargetCalIndex()) {
            int nextCalIndex = transmitterModel.getNextCalIndex();
            int i = transmitterModel.calRangeStartIndex;
            if (nextCalIndex < i) {
                transmitterModel.setNextCalIndex(i);
            }
            AidexXController controller = transmitterModel.getController();
            if (controller != null) {
                controller.getCalibration(transmitterModel.getNextCalIndex());
                return;
            }
            return;
        }
        AidexXController controller2 = transmitterModel.getController();
        if (controller2 != null) {
            controller2.getCalibrationRange();
        }
    }

    /* access modifiers changed from: private */
    public final void handleLongConnectNotify(byte[] bArr) {
        AidexXHistoryEntity latestHistory;
        if (!isGettingTransmitterData()) {
            AidexXInstantHistoryEntity aidexXInstantHistory = AidexXParser.getAidexXInstantHistory(bArr);
            LogUtil.Companion.eAiDEX("history from long connect : " + aidexXInstantHistory);
            if (aidexXInstantHistory != null) {
                if (getEntity().getSensorStartTime() == null) {
                    AidexXController controller = getController();
                    if (controller != null) {
                        controller.getStartTime();
                        return;
                    }
                    return;
                }
                setLatestAdInfo(new Pair(Integer.valueOf(aidexXInstantHistory.abstractEntity.timeOffset), Integer.valueOf(aidexXInstantHistory.abstractEntity.calTemp)));
                if (!refreshSensorState(aidexXInstantHistory.abstractEntity.status, aidexXInstantHistory.abstractEntity.calTemp, aidexXInstantHistory.abstractEntity.timeOffset)) {
                    setLatestAdTime(SystemClock.elapsedRealtime());
                    setSignalLostFlag(SystemClock.elapsedRealtime());
                    setLatestHistory(aidexXInstantHistory.history);
                    AidexXHistoryEntity latestHistory2 = getLatestHistory();
                    if (latestHistory2 != null) {
                        int i = 1;
                        boolean z = latestHistory2.timeOffset >= 60;
                        setGlucose((!getMalFunctionList().isEmpty() || isSensorExpired() || latestHistory2.glucose < 0) ? null : Float.valueOf((float) latestHistory2.glucose));
                        AidexXHistoryEntity latestHistory3 = getLatestHistory();
                        setHistoryValid(latestHistory3 != null && latestHistory3.isValid == 1 && (latestHistory = getLatestHistory()) != null && latestHistory.status == 0);
                        setGlucoseLevel(getGlucoseLevel(getGlucose()));
                        int i2 = latestHistory2.timeOffset;
                        Date sensorStartTime = getEntity().getSensorStartTime();
                        Intrinsics.checkNotNull(sensorStartTime);
                        Date historyDate = ExtendsKt.toHistoryDate(i2, sensorStartTime);
                        if (!z) {
                            EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, false);
                        } else if (!Intrinsics.areEqual((Object) historyDate, (Object) getLastHistoryTime())) {
                            AidexXAbstractEntity aidexXAbstractEntity = aidexXInstantHistory.abstractEntity;
                            Intrinsics.checkNotNullExpressionValue(aidexXAbstractEntity, "abstractEntity");
                            updateTrend(aidexXAbstractEntity, Float.valueOf((float) latestHistory2.glucose), historyDate, latestHistory2.status);
                            EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, true);
                        }
                        if (getGlucose() != null && isHistoryValid()) {
                            EventBusManager.INSTANCE.send(EventBusKey.EVENT_DATA_STATE_CHANGED, new Pair(DataChangedType.DATA_STATE_ADD, new CgmDataState(Long.valueOf(historyDate.getTime()), getGlucose(), UserInfoManager.Companion.instance().userId())));
                        }
                        setLastHistoryTime(historyDate);
                        setLastHistoryAppTime(ExtendsKt.formatWithoutZone(historyDate));
                        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new TransmitterModel$handleLongConnectNotify$1$1(aidexXInstantHistory, latestHistory2, historyDate, this, (Continuation<? super TransmitterModel$handleLongConnectNotify$1$1>) null), 3, (Object) null);
                        AidexXHistoryEntity latestHistory4 = getLatestHistory();
                        if (latestHistory4 != null) {
                            i = latestHistory4.timeOffset;
                        }
                        setTargetEventIndex(i);
                        if (getNextEventIndex() <= getTargetEventIndex()) {
                            if (getNextEventIndex() == getTargetEventIndex()) {
                                Job unused2 = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new TransmitterModel$handleLongConnectNotify$1$2(this, aidexXInstantHistory, (Continuation<? super TransmitterModel$handleLongConnectNotify$1$2>) null), 3, (Object) null);
                            } else {
                                this.mHandler.removeCallbacks(this.briefRunnable);
                                this.mHandler.postDelayed(this.briefRunnable, 150);
                                return;
                            }
                        }
                        if (getNextFullEventIndex() + 9 <= getTargetEventIndex()) {
                            this.mHandler.removeCallbacks(this.rawRunnable);
                            this.mHandler.postDelayed(this.rawRunnable, 150);
                            return;
                        }
                    }
                    setTargetCalIndex(aidexXInstantHistory.abstractEntity.calIndex);
                    if (getNextCalIndex() <= getTargetCalIndex()) {
                        this.mHandler.removeCallbacks(this.calRunnable);
                        this.mHandler.postDelayed(this.calRunnable, 150);
                    }
                }
            }
        }
    }

    public AidexXController getController() {
        BleController controller = getController();
        if (controller instanceof AidexXController) {
            return (AidexXController) controller;
        }
        return null;
    }

    public boolean isDataValid() {
        if (getLastHistoryTime() == null || getGlucose() == null || !getMalFunctionList().isEmpty() || !isHistoryValid() || getMinutesAgo() == null) {
            return false;
        }
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        IntRange intRange = new IntRange(0, settingEntity != null ? settingEntity.getSignalMissingAlertRate() : 15);
        Integer minutesAgo = getMinutesAgo();
        if (minutesAgo == null || !intRange.contains(minutesAgo.intValue())) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object uploadPairInfo(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.microtech.aidexx.ble.device.model.TransmitterModel$uploadPairInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.microtech.aidexx.ble.device.model.TransmitterModel$uploadPairInfo$1 r0 = (com.microtech.aidexx.ble.device.model.TransmitterModel$uploadPairInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ble.device.model.TransmitterModel$uploadPairInfo$1 r0 = new com.microtech.aidexx.ble.device.model.TransmitterModel$uploadPairInfo$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.ble.device.model.TransmitterModel r0 = (com.microtech.aidexx.ble.device.model.TransmitterModel) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x012f
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Upload pair info --> "
            r2.<init>(r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r2 = r2.toString()
            r7.eAiDEX(r2)
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r2 = r7
            java.util.Map r2 = (java.util.Map) r2
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            int r4 = r4.getDeviceModel()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r5 = "deviceModel"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            java.lang.String r4 = r4.getSensorId()
            java.lang.String r5 = "sensorId"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            java.util.Date r4 = r4.getSensorStartTime()
            java.lang.String r5 = "sensorStartUp"
            r2.put(r5, r4)
            com.microtech.aidexx.utils.TimeUtils r4 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            java.lang.String r4 = r4.getTimeZoneId()
            java.lang.String r5 = "startUpTimeZone"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            int r4 = r4.startTimeToIndex()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r5 = "sensorIndex"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            java.lang.String r4 = r4.getDeviceSn()
            java.lang.String r5 = "deviceSn"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            java.lang.String r4 = r4.getDeviceMac()
            java.lang.String r5 = "deviceMac"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            byte[] r4 = r4.getEncryptionKey()
            java.lang.String r5 = "deviceKey"
            r2.put(r5, r4)
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            java.lang.String r5 = "registerTime"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            int r4 = r4.getEt()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r5 = "et"
            r2.put(r5, r4)
            com.microtech.aidexx.db.entity.TransmitterEntity r4 = r6.getEntity()
            java.lang.String r4 = r4.getDeviceName()
            java.lang.String r5 = "name"
            r2.put(r5, r4)
            java.util.TimeZone r4 = java.util.TimeZone.getDefault()
            java.util.Date r5 = new java.util.Date
            r5.<init>()
            boolean r4 = r4.inDaylightTime(r5)
            if (r4 == 0) goto L_0x010a
            java.util.TimeZone r4 = java.util.TimeZone.getDefault()
            int r4 = r4.getDSTSavings()
            int r4 = r4 / 1000
            goto L_0x010b
        L_0x010a:
            r4 = 0
        L_0x010b:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r5 = "dstOffset"
            r2.put(r5, r4)
            java.lang.String r4 = "isForceReplace"
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r2.put(r4, r5)
            com.microtech.aidexx.common.net.ApiService$Companion r2 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r2 = r2.getInstance()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r2.deviceRegister(r7, r0)
            if (r7 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r0 = r6
        L_0x012f:
            com.microtech.aidexx.common.net.ApiResult r7 = (com.microtech.aidexx.common.net.ApiResult) r7
            boolean r1 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r1 == 0) goto L_0x0153
            com.microtech.aidexx.common.net.ApiResult$Success r7 = (com.microtech.aidexx.common.net.ApiResult.Success) r7
            java.lang.Object r7 = r7.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r7 = (com.microtech.aidexx.common.net.entity.BaseResponse) r7
            java.lang.Object r7 = r7.getData()
            com.microtech.aidexx.ble.device.entity.DeviceRegisterInfo r7 = (com.microtech.aidexx.ble.device.entity.DeviceRegisterInfo) r7
            if (r7 == 0) goto L_0x0155
            java.lang.String r7 = r7.getDeviceId()
            if (r7 == 0) goto L_0x0155
            com.microtech.aidexx.db.entity.TransmitterEntity r0 = r0.getEntity()
            r0.setId(r7)
            goto L_0x0155
        L_0x0153:
            boolean r7 = r7 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
        L_0x0155:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.model.TransmitterModel.uploadPairInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void savePair(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        TransmitterEntity entity2 = getEntity();
        BleController controller = getController();
        entity2.setEncryptionKey(controller != null ? controller.getKey() : null);
        TransmitterEntity entity3 = getEntity();
        BleController controller2 = getController();
        entity3.setDeviceMac(controller2 != null ? controller2.getMac() : null);
        TransmitterEntity entity4 = getEntity();
        BleController controller3 = getController();
        entity4.setAccessId(controller3 != null ? controller3.getId() : null);
        TransmitterEntity entity5 = getEntity();
        BleController controller4 = getController();
        entity5.setDeviceName(controller4 != null ? controller4.getName() : null);
        Box<TransmitterEntity> transmitterBox = ObjectBox.INSTANCE.getTransmitterBox();
        Intrinsics.checkNotNull(transmitterBox);
        transmitterBox.put(getEntity());
        insertHistoryDeviceRecord(getEntity().getDeviceSn());
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TransmitterModel$savePair$1(this, (Continuation<? super TransmitterModel$savePair$1>) null), 3, (Object) null);
    }

    public final boolean isFirstInsertSensor() {
        if (getEntity().getSensorStartTime() != null) {
            long millisToSeconds = ExtendsKt.millisToSeconds(TimeUtils.INSTANCE.getCurrentTimeMillis());
            Date sensorStartTime = getEntity().getSensorStartTime();
            Intrinsics.checkNotNull(sensorStartTime);
            if (millisToSeconds - ExtendsKt.millisToSeconds(sensorStartTime.getTime()) > 1296000) {
                return true;
            }
            return false;
        } else if (getEntity().getSensorStartTime() == null) {
            return false;
        } else {
            long millisToSeconds2 = ExtendsKt.millisToSeconds(TimeUtils.INSTANCE.getCurrentTimeMillis());
            Date sensorStartTime2 = getEntity().getSensorStartTime();
            Intrinsics.checkNotNull(sensorStartTime2);
            if (millisToSeconds2 - ExtendsKt.millisToSeconds(sensorStartTime2.getTime()) > 1296000) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object deletePair(kotlin.jvm.functions.Function0<kotlin.Unit> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.microtech.aidexx.ble.device.model.TransmitterModel$deletePair$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.microtech.aidexx.ble.device.model.TransmitterModel$deletePair$1 r0 = (com.microtech.aidexx.ble.device.model.TransmitterModel$deletePair$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ble.device.model.TransmitterModel$deletePair$1 r0 = new com.microtech.aidexx.ble.device.model.TransmitterModel$deletePair$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r6) goto L_0x0041
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d0
        L_0x0034:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00c4
        L_0x0041:
            java.lang.Object r14 = r0.L$1
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.ble.device.model.TransmitterModel r2 = (com.microtech.aidexx.ble.device.model.TransmitterModel) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0088
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r15)
            com.microtech.aidexx.db.entity.TransmitterEntity r15 = r13.getEntity()
            java.lang.String r15 = r15.getId()
            if (r15 == 0) goto L_0x00c7
            com.microtech.aidexx.common.net.ApiService$Companion r15 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r15 = r15.getInstance()
            kotlin.Pair[] r2 = new kotlin.Pair[r6]
            com.microtech.aidexx.db.entity.TransmitterEntity r3 = r13.getEntity()
            java.lang.String r3 = r3.getId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.String r7 = "deviceId"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r7, r3)
            r7 = 0
            r2[r7] = r3
            java.util.HashMap r2 = kotlin.collections.MapsKt.hashMapOf(r2)
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r6
            java.lang.Object r15 = r15.deviceUnregister(r2, r0)
            if (r15 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r2 = r13
        L_0x0088:
            com.microtech.aidexx.common.net.ApiResult r15 = (com.microtech.aidexx.common.net.ApiResult) r15
            boolean r3 = r15 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r6 = 0
            if (r3 == 0) goto L_0x00a4
            com.microtech.aidexx.common.net.ApiResult$Success r15 = (com.microtech.aidexx.common.net.ApiResult.Success) r15
            java.lang.Object r15 = r15.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r15 = (com.microtech.aidexx.common.net.entity.BaseResponse) r15
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r14 = r2.clearLocalPairInfo(r14, r0)
            if (r14 != r1) goto L_0x00c4
            return r1
        L_0x00a4:
            boolean r3 = r15 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r3 == 0) goto L_0x00c4
            com.microtech.aidexx.common.net.ApiResult$Failure r15 = (com.microtech.aidexx.common.net.ApiResult.Failure) r15
            java.lang.String r8 = r15.getMsg()
            com.microtech.aidexx.views.dialog.Dialogs r7 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r11 = 2
            r12 = 0
            r9 = 0
            com.microtech.aidexx.views.dialog.Dialogs.showError$default(r7, r8, r9, r11, r12)
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r14 = r2.clearLocalPairInfo(r14, r0)
            if (r14 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00c7:
            r0.label = r3
            java.lang.Object r14 = r13.clearLocalPairInfo(r14, r0)
            if (r14 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.model.TransmitterModel.deletePair(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object clearLocalPairInfo(kotlin.jvm.functions.Function0<kotlin.Unit> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.microtech.aidexx.ble.device.model.TransmitterModel$clearLocalPairInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.microtech.aidexx.ble.device.model.TransmitterModel$clearLocalPairInfo$1 r0 = (com.microtech.aidexx.ble.device.model.TransmitterModel$clearLocalPairInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ble.device.model.TransmitterModel$clearLocalPairInfo$1 r0 = new com.microtech.aidexx.ble.device.model.TransmitterModel$clearLocalPairInfo$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00e2
        L_0x0030:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0038:
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.ble.device.model.TransmitterModel r2 = (com.microtech.aidexx.ble.device.model.TransmitterModel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x008e
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Boolean r11 = com.microtech.aidexx.BuildConfig.keepAlive
            java.lang.String r2 = "keepAlive"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r2)
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0078
            com.microtechmd.blecomm.controller.BleController r11 = r9.getController()
            if (r11 == 0) goto L_0x005d
            r11.disconnect()
        L_0x005d:
            com.microtechmd.blecomm.controller.BleController r11 = r9.getController()
            if (r11 == 0) goto L_0x0066
            r11.unregister()
        L_0x0066:
            r9.setController(r6)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            r7 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r7, r0)
            if (r11 != r1) goto L_0x008d
            return r1
        L_0x0078:
            com.microtech.aidexx.ble.AidexBleAdapter$Companion r11 = com.microtech.aidexx.ble.AidexBleAdapter.Companion
            com.microtech.aidexx.ble.AidexBleAdapter r11 = r11.getInstance()
            r11.stopBtScan((boolean) r5)
            com.microtechmd.blecomm.controller.BleController r11 = r9.getController()
            if (r11 == 0) goto L_0x008a
            r11.unregister()
        L_0x008a:
            r9.setController(r6)
        L_0x008d:
            r2 = r9
        L_0x008e:
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r2.getEntity()
            r11.setAccessId(r6)
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r2.getEntity()
            r11.setEncryptionKey(r6)
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r2.getEntity()
            r11.setSensorStartTime(r6)
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r2.getEntity()
            r11.setId(r6)
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r2.getEntity()
            r11.setEventIndex(r5)
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r2.getEntity()
            r11.setFullEventIndex(r5)
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r2.getEntity()
            r11.setCalIndex(r5)
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r11 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r11 = r11.instance()
            r11.removeDefault()
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r11 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r11 = r11.instance()
            com.microtech.aidexx.ble.device.model.TransmitterModel$clearLocalPairInfo$2 r2 = new com.microtech.aidexx.ble.device.model.TransmitterModel$clearLocalPairInfo$2
            r2.<init>(r10)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r10 = r11.removeDb(r2, r0)
            if (r10 != r1) goto L_0x00e2
            return r1
        L_0x00e2:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.model.TransmitterModel.clearLocalPairInfo(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void handleAdvertisement(byte[] bArr, int i) {
        AidexXHistoryEntity latestHistory;
        AidexXHistoryEntity latestHistory2;
        int i2 = i;
        Intrinsics.checkNotNullParameter(bArr, "data");
        SignalLostCheckDialog.Companion.dismiss();
        AidexXBroadcastEntity broadcast = AidexXParser.getBroadcast(bArr);
        if (broadcast != null) {
            LogUtil.Companion.eAiDEX("Advertising (type:" + i2 + ") --> " + broadcast);
            EventBusManager.INSTANCE.send(EventBusKey.RECEIVE_BROADCAST, true);
            setLatestAdTime(SystemClock.elapsedRealtime());
            setSignalLostFlag(SystemClock.elapsedRealtime());
            if (!refreshSensorState(broadcast.abstractEntity.status, broadcast.abstractEntity.calTemp, broadcast.abstractEntity.timeOffset)) {
                if (getEntity().getSensorStartTime() == null) {
                    AidexXController controller = getController();
                    if (controller != null) {
                        controller.getStartTime();
                        return;
                    }
                    return;
                }
                List<AidexXHistoryEntity> list = broadcast.history;
                setLatestAdInfo(new Pair(Integer.valueOf(broadcast.abstractEntity.timeOffset), Integer.valueOf(broadcast.abstractEntity.calTemp)));
                Intrinsics.checkNotNull(list);
                if (!list.isEmpty()) {
                    if (getLatestHistory() == null || (latestHistory2 = getLatestHistory()) == null || list.get(0).timeOffset != latestHistory2.timeOffset) {
                        int i3 = list.get(0).glucose;
                        setGlucose((!getMalFunctionList().isEmpty() || isSensorExpired() || i3 < 0) ? null : Float.valueOf((float) i3));
                    }
                    setLatestHistory(list.get(0));
                    AidexXHistoryEntity latestHistory3 = getLatestHistory();
                    setHistoryValid(latestHistory3 != null && latestHistory3.isValid == 1 && (latestHistory = getLatestHistory()) != null && latestHistory.status == 0);
                    setGlucoseLevel(getGlucoseLevel(getGlucose()));
                    AidexXHistoryEntity latestHistory4 = getLatestHistory();
                    if (latestHistory4 != null) {
                        boolean z = latestHistory4.timeOffset >= 60;
                        int i4 = latestHistory4.timeOffset;
                        Date sensorStartTime = getEntity().getSensorStartTime();
                        Intrinsics.checkNotNull(sensorStartTime);
                        Date historyDate = ExtendsKt.toHistoryDate(i4, sensorStartTime);
                        if (isHistoryValid() && getGlucose() != null && !Intrinsics.areEqual((Object) getLatestHistory(), (Object) historyDate)) {
                            EventBusManager eventBusManager = EventBusManager.INSTANCE;
                            DataChangedType dataChangedType = DataChangedType.DATA_STATE_ADD;
                            Date lastHistoryTime = getLastHistoryTime();
                            eventBusManager.send(EventBusKey.EVENT_DATA_STATE_CHANGED, new Pair(dataChangedType, new CgmDataState(lastHistoryTime != null ? Long.valueOf(lastHistoryTime.getTime()) : null, getGlucose(), UserInfoManager.Companion.instance().userId())));
                        }
                        setLastHistoryTime(historyDate);
                        setLastHistoryAppTime(ExtendsKt.formatWithoutZone(historyDate));
                        if (z) {
                            AidexXAbstractEntity aidexXAbstractEntity = broadcast.abstractEntity;
                            Intrinsics.checkNotNullExpressionValue(aidexXAbstractEntity, "abstractEntity");
                            updateTrend(aidexXAbstractEntity, Float.valueOf((float) latestHistory4.glucose), historyDate, latestHistory4.status);
                            EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, true);
                        } else {
                            EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, false);
                        }
                    }
                    AidexXHistoryEntity latestHistory5 = getLatestHistory();
                    setTargetEventIndex(latestHistory5 != null ? latestHistory5.timeOffset : 1);
                    if (getNextEventIndex() > getTargetEventIndex()) {
                        Boolean bool = BuildConfig.keepAlive;
                        Intrinsics.checkNotNullExpressionValue(bool, "keepAlive");
                        if (bool.booleanValue() && i2 == 1) {
                            startLongConnect();
                        } else if (getTargetEventIndex() < getNextFullEventIndex() + 30 && (getTargetEventIndex() < getNextFullEventIndex() || !isSensorExpired())) {
                            int i5 = broadcast.abstractEntity.calIndex;
                            if (getNextCalIndex() > i5) {
                                return;
                            }
                            if (this.newestCalIndex == i5) {
                                int nextCalIndex = getNextCalIndex();
                                int i6 = this.calRangeStartIndex;
                                if (nextCalIndex < i6) {
                                    setNextCalIndex(i6);
                                }
                                AidexXController controller2 = getController();
                                if (controller2 != null) {
                                    controller2.getCalibration(getNextCalIndex());
                                    return;
                                }
                                return;
                            }
                            AidexXController controller3 = getController();
                            if (controller3 != null) {
                                controller3.getCalibrationRange();
                            }
                        } else if (this.newestEventIndex == getTargetEventIndex()) {
                            int nextFullEventIndex = getNextFullEventIndex();
                            int i7 = this.rawRangeStartIndex;
                            if (nextFullEventIndex < i7) {
                                setNextFullEventIndex(i7);
                            }
                            AidexXController controller4 = getController();
                            if (controller4 != null) {
                                controller4.getRawHistories(getNextFullEventIndex());
                            }
                            LogUtil.Companion.eAiDEX("Advertising triggers get raw history from sensor from " + getNextFullEventIndex());
                        } else {
                            this.dataTypeNeedSync = 2;
                            AidexXController controller5 = getController();
                            if (controller5 != null) {
                                controller5.getHistoryRange();
                            }
                        }
                    } else if (isNextInBroadcast(getNextEventIndex(), list)) {
                        Job unused = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new TransmitterModel$handleAdvertisement$2(this, list, (Continuation<? super TransmitterModel$handleAdvertisement$2>) null), 3, (Object) null);
                        Boolean bool2 = BuildConfig.keepAlive;
                        Intrinsics.checkNotNullExpressionValue(bool2, "keepAlive");
                        if (bool2.booleanValue() && i2 == 1) {
                            startLongConnect();
                        }
                    } else {
                        Boolean bool3 = BuildConfig.keepAlive;
                        Intrinsics.checkNotNullExpressionValue(bool3, "keepAlive");
                        if (bool3.booleanValue() && i2 == 1) {
                            startLongConnect();
                        } else if (getLatestHistory() != null && getTargetEventIndex() > getNextEventIndex()) {
                            if (this.newestEventIndex == getTargetEventIndex()) {
                                int nextEventIndex = getNextEventIndex();
                                int i8 = this.briefRangeStartIndex;
                                if (nextEventIndex < i8) {
                                    setNextEventIndex(i8);
                                }
                                AidexXController controller6 = getController();
                                if (controller6 != null) {
                                    controller6.getHistories(getNextEventIndex());
                                }
                                LogUtil.Companion.eAiDEX("Advertising triggers get brief history from sensor from index : " + getNextEventIndex());
                                return;
                            }
                            this.dataTypeNeedSync = 1;
                            AidexXController controller7 = getController();
                            if (controller7 != null) {
                                controller7.getHistoryRange();
                            }
                        }
                    }
                } else {
                    Boolean bool4 = BuildConfig.keepAlive;
                    Intrinsics.checkNotNullExpressionValue(bool4, "keepAlive");
                    if (bool4.booleanValue() && i2 == 1) {
                        startLongConnect();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void startLongConnect() {
        AidexXController controller = getController();
        if (controller != null) {
            controller.setDynamicMode(1);
        }
        AidexXController controller2 = getController();
        if (controller2 != null) {
            controller2.setAutoUpdate();
        }
        AidexXController controller3 = getController();
        if (controller3 != null) {
            controller3.getBroadcastData();
        }
    }

    private final void updateTrend(AidexXAbstractEntity aidexXAbstractEntity, Float f, Date date, int i) {
        int i2 = aidexXAbstractEntity.trend;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i2 < -30) {
            setGlucoseTrend(DeviceModel.GlucoseTrend.FAST_FALL);
            if (SettingsManager.INSTANCE.getFastDownSwitch() && elapsedRealtime - getLastDownFastAlertTime() >= AlertUtil.INSTANCE.getAlertFrequency() && getMalFunctionList().isEmpty()) {
                Function2<String, Integer, Unit> alert = getAlert();
                if (alert != null) {
                    alert.invoke(TimeUtils.dateHourMinute$default(TimeUtils.INSTANCE, date, (String) null, 1, (Object) null), 4);
                }
                setLastDownFastAlertTime(SystemClock.elapsedRealtime());
            }
        } else if (-30 <= i2 && i2 < -20) {
            setGlucoseTrend(DeviceModel.GlucoseTrend.FALL);
        } else if (-20 <= i2 && i2 < -10) {
            setGlucoseTrend(DeviceModel.GlucoseTrend.SLOW_FALL);
        } else if (-10 <= i2 && i2 < 11) {
            setGlucoseTrend(DeviceModel.GlucoseTrend.STEADY);
        } else if (11 <= i2 && i2 < 21) {
            setGlucoseTrend(DeviceModel.GlucoseTrend.SLOW_UP);
        } else if (21 <= i2 && i2 < 31) {
            setGlucoseTrend(DeviceModel.GlucoseTrend.UP);
        } else if (i2 > 30) {
            setGlucoseTrend(DeviceModel.GlucoseTrend.FAST_UP);
            if (SettingsManager.INSTANCE.getFastUpSwitch() && elapsedRealtime - getLastUpFastAlertTime() >= AlertUtil.INSTANCE.getAlertFrequency() && getMalFunctionList().isEmpty()) {
                Function2<String, Integer, Unit> alert2 = getAlert();
                if (alert2 != null) {
                    alert2.invoke(TimeUtils.dateHourMinute$default(TimeUtils.INSTANCE, date, (String) null, 1, (Object) null), 5);
                }
                setLastUpFastAlertTime(SystemClock.elapsedRealtime());
            }
        } else {
            setGlucoseTrend(DeviceModel.GlucoseTrend.UNKNOWN);
        }
        if (!NetUtil.isNetAvailable(AidexxApp.Companion.getInstance())) {
            LogUtil.Companion.eAiDEX("Network unavailable, trend upload fail");
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new TransmitterModel$updateTrend$1(date, f, this, i2, aidexXAbstractEntity, i, (Continuation<? super TransmitterModel$updateTrend$1>) null), 3, (Object) null);
    }

    public Integer getSensorRemainingTime() {
        int expirationTime = getEntity().getExpirationTime();
        int i = -1;
        if (isSensorExpired()) {
            return -1;
        }
        Long l = null;
        if (getEntity().getSensorStartTime() == null) {
            return null;
        }
        long j = ((long) expirationTime) * TimeUtils.oneDayMillis;
        long currentTimeMillis = TimeUtils.INSTANCE.getCurrentTimeMillis();
        Date sensorStartTime = getEntity().getSensorStartTime();
        if (sensorStartTime != null) {
            l = Long.valueOf(sensorStartTime.getTime());
        }
        Intrinsics.checkNotNull(l);
        int millisToHours = ExtendsKt.millisToHours(j - (currentTimeMillis - l.longValue()), RoundingMode.CEILING);
        if (millisToHours > 0) {
            i = millisToHours;
        } else {
            setSensorExpired(true);
        }
        return Integer.valueOf(i);
    }

    public void calibration(CalibrationInfo calibrationInfo) {
        Intrinsics.checkNotNullParameter(calibrationInfo, TransmitterActivityKt.BLE_INFO);
        AidexXController controller = getController();
        if (controller != null) {
            controller.calibration(calibrationInfo.getIntValue(), calibrationInfo.getTimeOffset());
        }
    }

    public boolean isAllowCalibration() {
        Pair<Integer, Integer> latestAdInfo = getLatestAdInfo();
        if (latestAdInfo == null || ((latestAdInfo.getSecond().intValue() >> 1) & 1) == 1 || latestAdInfo.getFirst().intValue() <= 360 || getLatestAdTime() == 0 || Math.abs(SystemClock.elapsedRealtime() - getLatestAdTime()) > TimeUtils.oneMinuteMillis) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.microtech.aidexx.ble.device.model.DeviceModel.CalibrationState getCalibrationState() {
        /*
            r13 = this;
            com.microtech.aidexx.db.entity.TransmitterEntity r0 = r13.getEntity()
            java.util.Date r0 = r0.getSensorStartTime()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0021
            long r3 = r0.getTime()
            com.microtech.aidexx.utils.TimeUtils r0 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            long r5 = r0.getCurrentTimeMillis()
            long r5 = r5 - r3
            r3 = 21600000(0x1499700, double:1.0671818E-316)
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r0 = r1
            goto L_0x0022
        L_0x0021:
            r0 = r2
        L_0x0022:
            com.microtech.aidexx.ble.AidexBleAdapter$Companion r3 = com.microtech.aidexx.ble.AidexBleAdapter.Companion
            com.microtech.aidexx.ble.AidexBleAdapter r3 = r3.getInstance()
            kotlin.Pair r3 = r3.getConnectStatus()
            java.lang.Object r4 = r3.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r5 = 2
            if (r4 != 0) goto L_0x0047
            java.lang.Object r3 = r3.getSecond()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 != r5) goto L_0x0047
            r11 = r2
            goto L_0x0048
        L_0x0047:
            r11 = r1
        L_0x0048:
            kotlin.Pair r3 = r13.getLatestAdInfo()
            if (r3 == 0) goto L_0x0095
            java.lang.Object r0 = r3.getSecond()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r0 = r0 >> r2
            r0 = r0 & r2
            if (r0 == r2) goto L_0x005e
            r0 = r2
            goto L_0x005f
        L_0x005e:
            r0 = r1
        L_0x005f:
            java.lang.Object r3 = r3.getFirst()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            r4 = 360(0x168, float:5.04E-43)
            if (r3 > r4) goto L_0x006f
            r3 = r2
            goto L_0x0070
        L_0x006f:
            r3 = r1
        L_0x0070:
            long r6 = r13.getLatestAdTime()
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0090
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r8 = r13.getLatestAdTime()
            long r6 = r6 - r8
            long r6 = java.lang.Math.abs(r6)
            r8 = 300000(0x493e0, double:1.482197E-318)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0090
            r4 = r2
            goto L_0x0091
        L_0x0090:
            r4 = r1
        L_0x0091:
            r9 = r0
            r10 = r3
            r12 = r4
            goto L_0x0098
        L_0x0095:
            r10 = r0
            r9 = r2
            r12 = r9
        L_0x0098:
            boolean r7 = r13.isPaired()
            java.lang.Integer r0 = r13.getSensorRemainingTime()
            if (r0 == 0) goto L_0x00ab
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            if (r0 > 0) goto L_0x00ab
            r1 = r2
        L_0x00ab:
            r8 = r1
            com.microtech.aidexx.ble.device.model.DeviceModel$CalibrationState r0 = new com.microtech.aidexx.ble.device.model.DeviceModel$CalibrationState
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "校准状态:"
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            r3 = 0
            com.microtech.aidexx.utils.LogUtil.Companion.xLogI$default(r1, r2, r3, r5, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.model.TransmitterModel.getCalibrationState():com.microtech.aidexx.ble.device.model.DeviceModel$CalibrationState");
    }

    private final boolean refreshSensorState(int i, int i2, int i3) {
        for (int i4 = 0; i4 < 6; i4++) {
            this.statusBitArray[i4] = (i >> i4) & 1;
            this.calTempBitArray[i4] = 1 & (i2 >> i4);
        }
        if (this.statusBitArray[0] == 1 && this.calTempBitArray[0] == 1) {
            HomeStateManager.Companion.instance().setState(HomeFragmentKt.newOrUsedSensor);
            return true;
        }
        if (i3 < 0 || i3 >= 60) {
            HomeStateManager.Companion.instance().setState(HomeFragmentKt.glucosePanel);
        } else {
            HomeStateManager.Companion.instance().setState(HomeFragmentKt.warmingUp);
            HomeStateManager.Companion.instance().setWarmingUpTimeLeft(i3);
        }
        setSensorExpired(this.statusBitArray[0] == 1 && this.calTempBitArray[0] == 0);
        Function1<DeviceModel.CalibrationState, Unit> onCalibrationPermitChange = getOnCalibrationPermitChange();
        if (onCalibrationPermitChange != null) {
            onCalibrationPermitChange.invoke(new DeviceModel.CalibrationState(true, isSensorExpired(), this.calTempBitArray[1] != 1, i3 < 360, true, false));
        }
        getMalFunctionList().clear();
        if (this.statusBitArray[5] == 1) {
            getMalFunctionList().add(32);
        }
        if (this.statusBitArray[3] == 1) {
            getMalFunctionList().add(8);
        }
        if (this.statusBitArray[2] == 1) {
            getMalFunctionList().add(4);
        }
        if (this.statusBitArray[4] == 1) {
            getMalFunctionList().add(16);
        }
        if (this.statusBitArray[1] == 1) {
            getMalFunctionList().add(2);
        }
        return false;
    }

    private final boolean isNextInBroadcast(int i, List<? extends AidexXHistoryEntity> list) {
        return i <= ((AidexXHistoryEntity) list.get(0)).timeOffset && ((AidexXHistoryEntity) list.get(list.size() - 1)).timeOffset <= i;
    }

    /* access modifiers changed from: private */
    public final List<AidexXHistoryEntity> getHistoriesFromBroadcast(int i, List<AidexXHistoryEntity> list) {
        Iterator<AidexXHistoryEntity> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            i2++;
            if (it.next().timeOffset == i) {
                break;
            }
        }
        return list.subList(0, i2);
    }

    public void saveBriefHistoryFromConnect(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Job unused = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), Dispatchers.getIO(), (CoroutineStart) null, new TransmitterModel$saveBriefHistoryFromConnect$1(bArr, this, (Continuation<? super TransmitterModel$saveBriefHistoryFromConnect$1>) null), 2, (Object) null);
    }

    public void saveRawHistoryFromConnect(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        Job unused = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), Dispatchers.getIO(), (CoroutineStart) null, new TransmitterModel$saveRawHistoryFromConnect$1(bArr, this, (Continuation<? super TransmitterModel$saveRawHistoryFromConnect$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void saveCalHistory(byte[] bArr, boolean z) {
        CharSequence sensorId;
        List aidexXCalibration = AidexXParser.getAidexXCalibration(bArr);
        String userId = UserInfoManager.Companion.instance().userId();
        if (aidexXCalibration.isEmpty() || (sensorId = getEntity().getSensorId()) == null || sensorId.length() == 0 || userId.length() == 0) {
            LogUtil.Companion.eAiDEX("Save calibration history error");
        } else if (!z || ((AidexXCalibrationEntity) aidexXCalibration.get(0)).index == getNextCalIndex()) {
            ObjectBox.INSTANCE.runAsync(new TransmitterModel$$ExternalSyntheticLambda3(this, aidexXCalibration, userId), new TransmitterModel$saveCalHistory$2(this, aidexXCalibration), new TransmitterModel$saveCalHistory$3(this));
        } else {
            LogUtil.Companion.eAiDEX("Calibration record index not equal nextCalIndex");
        }
    }

    /* access modifiers changed from: private */
    public static final void saveCalHistory$lambda$21(TransmitterModel transmitterModel, List list, String str) {
        Intrinsics.checkNotNullParameter(transmitterModel, "this$0");
        Intrinsics.checkNotNullParameter(str, "$userId");
        transmitterModel.tempCalList.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AidexXCalibrationEntity aidexXCalibrationEntity = (AidexXCalibrationEntity) it.next();
            CalibrateEntity calibrateEntity = new CalibrateEntity();
            calibrateEntity.setSensorId(transmitterModel.getEntity().getSensorId());
            calibrateEntity.setIndex(aidexXCalibrationEntity.index);
            calibrateEntity.setTimeOffset(aidexXCalibrationEntity.timeOffset);
            int i = aidexXCalibrationEntity.timeOffset;
            Date sensorStartTime = transmitterModel.getEntity().getSensorStartTime();
            Intrinsics.checkNotNull(sensorStartTime);
            calibrateEntity.setTimeInfo(ExtendsKt.toHistoryDate(i, sensorStartTime));
            calibrateEntity.setUserId(str);
            calibrateEntity.setCalibrationId(calibrateEntity.updateCalibrationId());
            calibrateEntity.setCf(ExtendsKt.roundTwoDigits(aidexXCalibrationEntity.cf));
            calibrateEntity.setOffset(ExtendsKt.roundTwoDigits(aidexXCalibrationEntity.offset));
            calibrateEntity.setReferenceGlucose((float) aidexXCalibrationEntity.referenceGlucose);
            calibrateEntity.setValid(Integer.valueOf(aidexXCalibrationEntity.isValid));
            calibrateEntity.setUploadState(1);
            transmitterModel.tempCalList.add(calibrateEntity);
        }
        if (!transmitterModel.tempCalList.isEmpty()) {
            Box<CalibrateEntity> calibrationBox = ObjectBox.INSTANCE.getCalibrationBox();
            Intrinsics.checkNotNull(calibrationBox);
            calibrationBox.put((Collection<CalibrateEntity>) transmitterModel.tempCalList);
        }
    }

    static /* synthetic */ void saveBriefHistory$default(TransmitterModel transmitterModel, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        transmitterModel.saveBriefHistory(list, z);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x001d: MOVE  (r2v4 java.lang.CharSequence) = (r1v1 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final void saveBriefHistory(java.util.List<com.microtechmd.blecomm.parser.AidexXHistoryEntity> r5, boolean r6) {
        /*
            r4 = this;
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
            java.lang.String r0 = r0.userId()
            com.microtech.aidexx.db.entity.TransmitterEntity r1 = r4.getEntity()
            java.lang.String r1 = r1.getSensorId()
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x001c
            goto L_0x0040
        L_0x001c:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0040
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0028
            goto L_0x0040
        L_0x0028:
            com.microtech.aidexx.db.ObjectBox r2 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ble.device.model.TransmitterModel$$ExternalSyntheticLambda4 r3 = new com.microtech.aidexx.ble.device.model.TransmitterModel$$ExternalSyntheticLambda4
            r3.<init>(r4, r5, r1, r0)
            com.microtech.aidexx.ble.device.model.TransmitterModel$saveBriefHistory$2 r0 = new com.microtech.aidexx.ble.device.model.TransmitterModel$saveBriefHistory$2
            r0.<init>(r4, r5, r6)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            com.microtech.aidexx.ble.device.model.TransmitterModel$saveBriefHistory$3 r5 = new com.microtech.aidexx.ble.device.model.TransmitterModel$saveBriefHistory$3
            r5.<init>(r4)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r2.runAsync(r3, r0, r5)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ble.device.model.TransmitterModel.saveBriefHistory(java.util.List, boolean):void");
    }

    /* access modifiers changed from: private */
    public static final void saveBriefHistory$lambda$22(TransmitterModel transmitterModel, List list, String str, String str2) {
        long j;
        Iterator it;
        RealCgmHistoryEntity realCgmHistoryEntity;
        long j2;
        Function2<String, Integer, Unit> alert;
        Function2<String, Integer, Unit> alert2;
        Function2<String, Integer, Unit> alert3;
        TransmitterModel transmitterModel2 = transmitterModel;
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(transmitterModel2, "this$0");
        Intrinsics.checkNotNullParameter(list, "$histories");
        Intrinsics.checkNotNullParameter(str4, "$userId");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long alertFrequency = AlertUtil.INSTANCE.getAlertFrequency();
        long urgentFrequency = AlertUtil.INSTANCE.getUrgentFrequency();
        transmitterModel2.tempBriefList.clear();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            AidexXHistoryEntity aidexXHistoryEntity = (AidexXHistoryEntity) it2.next();
            RealCgmHistoryEntity realCgmHistoryEntity2 = new RealCgmHistoryEntity();
            realCgmHistoryEntity2.setTimeOffset(aidexXHistoryEntity.timeOffset);
            int i = aidexXHistoryEntity.timeOffset;
            Date sensorStartTime = transmitterModel.getEntity().getSensorStartTime();
            Intrinsics.checkNotNull(sensorStartTime);
            Date historyDate = ExtendsKt.toHistoryDate(i, sensorStartTime);
            realCgmHistoryEntity2.setDeviceTime(historyDate);
            realCgmHistoryEntity2.setSensorId(str3);
            realCgmHistoryEntity2.setSensorIndex(transmitterModel.getEntity().startTimeToIndex());
            realCgmHistoryEntity2.setUserId(str4);
            realCgmHistoryEntity2.setStatus(aidexXHistoryEntity.status);
            realCgmHistoryEntity2.setQuality(aidexXHistoryEntity.quality);
            realCgmHistoryEntity2.setGlucoseIsValid(aidexXHistoryEntity.isValid);
            realCgmHistoryEntity2.setFrontRecordId(realCgmHistoryEntity2.updateRecordUUID());
            realCgmHistoryEntity2.setBriefUploadState(1);
            String dateHourMinute$default = TimeUtils.dateHourMinute$default(TimeUtils.INSTANCE, historyDate, (String) null, 1, (Object) null);
            realCgmHistoryEntity2.setGlucose(Float.valueOf((float) aidexXHistoryEntity.glucose));
            Iterator it3 = it2;
            long time = realCgmHistoryEntity2.getDeviceTime().getTime();
            if (realCgmHistoryEntity2.getTimeOffset() >= 60 && realCgmHistoryEntity2.getGlucoseIsValid() == 1 && realCgmHistoryEntity2.getStatus() == 0) {
                int highOrLowGlucoseType$default = RealCgmHistoryEntity.getHighOrLowGlucoseType$default(realCgmHistoryEntity2, false, 1, (Object) null);
                if (highOrLowGlucoseType$default != 0) {
                    if (highOrLowGlucoseType$default != 1) {
                        if (highOrLowGlucoseType$default == 2) {
                            realCgmHistoryEntity = realCgmHistoryEntity2;
                            it = it3;
                            if (transmitterModel2.lastHypoAlertTime == 0 || !Intrinsics.areEqual((Object) transmitterModel2.lastAlertTimezone, (Object) TimeZone.getDefault().getID())) {
                                transmitterModel2.lastHypoAlertTime = transmitterModel2.getLastAlertTime(str3, 2);
                                transmitterModel2.lastAlertTimezone = TimeZone.getDefault().getID();
                            }
                            long j3 = transmitterModel2.lastHypoAlertTime;
                            if (j3 == 0 || time - j3 >= alertFrequency) {
                                realCgmHistoryEntity.setEventWarning(2);
                                if (SettingsManager.INSTANCE.getHypoAlertSwitch()) {
                                    j = urgentFrequency;
                                    if (TimeUtils.INSTANCE.getCurrentTimeMillis() - time < ((long) 2) * alertFrequency && (alert2 = transmitterModel.getAlert()) != null) {
                                        alert2.invoke(dateHourMinute$default, 2);
                                    }
                                } else {
                                    j = urgentFrequency;
                                }
                                transmitterModel2.lastHypoAlertTime = time;
                            }
                        } else if (highOrLowGlucoseType$default == 3) {
                            realCgmHistoryEntity = realCgmHistoryEntity2;
                            if (transmitterModel2.lastUrgentAlertTime == 0 || !Intrinsics.areEqual((Object) transmitterModel2.lastAlertTimezone, (Object) TimeZone.getDefault().getID())) {
                                transmitterModel2.lastUrgentAlertTime = transmitterModel2.getLastAlertTime(str3, 3);
                                transmitterModel2.lastAlertTimezone = TimeZone.getDefault().getID();
                            }
                            long j4 = transmitterModel2.lastUrgentAlertTime;
                            if (j4 == 0 || time - j4 >= urgentFrequency) {
                                realCgmHistoryEntity.setEventWarning(3);
                                if (SettingsManager.INSTANCE.getUrgentAlertSwitch()) {
                                    it = it3;
                                    if (TimeUtils.INSTANCE.getCurrentTimeMillis() - time < ((long) 2) * urgentFrequency && (alert3 = transmitterModel.getAlert()) != null) {
                                        alert3.invoke(dateHourMinute$default, 3);
                                    }
                                } else {
                                    it = it3;
                                }
                                transmitterModel2.lastUrgentAlertTime = time;
                            } else {
                                j2 = urgentFrequency;
                                it = it3;
                            }
                        }
                        j = urgentFrequency;
                    } else {
                        j = urgentFrequency;
                        realCgmHistoryEntity = realCgmHistoryEntity2;
                        it = it3;
                        if (transmitterModel2.lastHyperAlertTime == 0 || !Intrinsics.areEqual((Object) transmitterModel2.lastAlertTimezone, (Object) TimeZone.getDefault().getID())) {
                            transmitterModel2.lastHyperAlertTime = transmitterModel2.getLastAlertTime(str3, 1);
                            transmitterModel2.lastAlertTimezone = TimeZone.getDefault().getID();
                        }
                        long j5 = transmitterModel2.lastHyperAlertTime;
                        if (j5 == 0 || Math.abs(time - j5) >= alertFrequency) {
                            realCgmHistoryEntity.setEventWarning(1);
                            if (SettingsManager.INSTANCE.getHyperAlertSwitch() && TimeUtils.INSTANCE.getCurrentTimeMillis() - time < ((long) 2) * alertFrequency && (alert = transmitterModel.getAlert()) != null) {
                                alert.invoke(dateHourMinute$default, 1);
                            }
                            transmitterModel2.lastHyperAlertTime = time;
                        }
                    }
                }
                j2 = urgentFrequency;
                realCgmHistoryEntity = realCgmHistoryEntity2;
                it = it3;
            } else {
                j = urgentFrequency;
                realCgmHistoryEntity = realCgmHistoryEntity2;
                it = it3;
                realCgmHistoryEntity.setEventWarning(-1);
            }
            transmitterModel2.tempBriefList.add(realCgmHistoryEntity);
            List list2 = list;
            str4 = str2;
            it2 = it;
            urgentFrequency = j;
        }
        if (!transmitterModel2.tempBriefList.isEmpty()) {
            Box<RealCgmHistoryEntity> cgmHistoryBox = ObjectBox.INSTANCE.getCgmHistoryBox();
            Intrinsics.checkNotNull(cgmHistoryBox);
            cgmHistoryBox.put((Collection<RealCgmHistoryEntity>) transmitterModel2.tempBriefList);
        }
        LogUtil.Companion.eAiDEX("Save brief history " + ((AidexXHistoryEntity) CollectionsKt.first(list)).timeOffset + Soundex.SILENT_MARKER + ((AidexXHistoryEntity) CollectionsKt.last(list)).timeOffset + " takes : " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
    }

    /* access modifiers changed from: private */
    public final void continueBriefFetch() {
        if (getTargetEventIndex() >= getNextEventIndex()) {
            int nextEventIndex = getNextEventIndex();
            int i = this.briefRangeStartIndex;
            if (nextEventIndex < i) {
                setNextEventIndex(i);
            }
            AidexXController controller = getController();
            if (controller != null) {
                controller.getHistories(getNextEventIndex());
            }
            LogUtil.Companion.eAiDEX("Get brief history from sensor from index : " + getNextEventIndex());
            setGettingTransmitterData(true);
        } else if (getTargetEventIndex() >= getNextFullEventIndex()) {
            int nextFullEventIndex = getNextFullEventIndex();
            int i2 = this.rawRangeStartIndex;
            if (nextFullEventIndex < i2) {
                setNextFullEventIndex(i2);
            }
            AidexXController controller2 = getController();
            if (controller2 != null) {
                controller2.getRawHistories(getNextFullEventIndex());
            }
            LogUtil.Companion.eAiDEX("Get raw history from sensor from index : " + getNextFullEventIndex());
            setGettingTransmitterData(true);
        }
    }

    /* access modifiers changed from: private */
    public final void continueRawFetch() {
        if (getTargetEventIndex() > getNextFullEventIndex()) {
            AidexXController controller = getController();
            if (controller != null) {
                controller.getRawHistories(getNextFullEventIndex());
            }
            LogUtil.Companion.eAiDEX("Get raw history from sensor from index : " + getNextFullEventIndex());
            setGettingTransmitterData(true);
        }
    }

    /* access modifiers changed from: private */
    public final void continueCalFetch() {
        if (this.newestCalIndex > getNextCalIndex()) {
            AidexXController controller = getController();
            if (controller != null) {
                controller.getCalibration(getNextCalIndex());
            }
            setGettingTransmitterData(true);
        }
    }

    private final long getLastAlertTime(String str, int i) {
        Date deviceTime;
        Box<RealCgmHistoryEntity> cgmHistoryBox = ObjectBox.INSTANCE.getCgmHistoryBox();
        Intrinsics.checkNotNull(cgmHistoryBox);
        QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryBox.query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Property<RealCgmHistoryEntity> property = RealCgmHistoryEntity_.sensorId;
        Intrinsics.checkNotNullExpressionValue(property, "sensorId");
        QueryBuilder<T> equal = ExtendsKt.equal(query, property, str);
        Property<RealCgmHistoryEntity> property2 = RealCgmHistoryEntity_.eventWarning;
        Intrinsics.checkNotNullExpressionValue(property2, "eventWarning");
        Intrinsics.checkNotNullExpressionValue(equal.equal((Property<T>) property2, (long) i), "equal(property, value.toLong())");
        RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) equal.orderDesc(RealCgmHistoryEntity_.idx).build().findFirst();
        if (realCgmHistoryEntity == null || (deviceTime = realCgmHistoryEntity.getDeviceTime()) == null) {
            return 0;
        }
        return deviceTime.getTime();
    }

    /* access modifiers changed from: private */
    public final void saveRawHistory(List<? extends AidexXRawHistoryEntity> list) {
        CharSequence sensorId;
        String userId = UserInfoManager.Companion.instance().userId();
        if (userId.length() == 0 || (sensorId = getEntity().getSensorId()) == null || sensorId.length() == 0) {
            LogUtil.Companion.eAiDEX("Save raw history fail --> userId:" + userId + ", sensorId:" + getEntity().getSensorId());
            return;
        }
        ObjectBox.INSTANCE.runAsync(new TransmitterModel$$ExternalSyntheticLambda6(this, list), new TransmitterModel$saveRawHistory$2(this, list, SystemClock.elapsedRealtime()), new TransmitterModel$saveRawHistory$3(this));
    }

    /* access modifiers changed from: private */
    public static final void saveRawHistory$lambda$23(TransmitterModel transmitterModel, List list) {
        Intrinsics.checkNotNullParameter(transmitterModel, "this$0");
        Intrinsics.checkNotNullParameter(list, "$rawHistories");
        transmitterModel.tempRawList.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AidexXRawHistoryEntity aidexXRawHistoryEntity = (AidexXRawHistoryEntity) it.next();
            Box<RealCgmHistoryEntity> cgmHistoryBox = ObjectBox.INSTANCE.getCgmHistoryBox();
            Intrinsics.checkNotNull(cgmHistoryBox);
            QueryBuilder<RealCgmHistoryEntity> query = cgmHistoryBox.query();
            Intrinsics.checkNotNullExpressionValue(query, "query(...)");
            Property property = RealCgmHistoryEntity_.timeOffset;
            Intrinsics.checkNotNullExpressionValue(property, "timeOffset");
            QueryBuilder<RealCgmHistoryEntity> equal = query.equal((Property<RealCgmHistoryEntity>) property, (long) aidexXRawHistoryEntity.timeOffset);
            Intrinsics.checkNotNullExpressionValue(equal, "equal(property, value.toLong())");
            Property<RealCgmHistoryEntity> property2 = RealCgmHistoryEntity_.sensorId;
            Intrinsics.checkNotNullExpressionValue(property2, "sensorId");
            String sensorId = transmitterModel.getEntity().getSensorId();
            Intrinsics.checkNotNull(sensorId);
            RealCgmHistoryEntity realCgmHistoryEntity = (RealCgmHistoryEntity) ExtendsKt.equal(equal, property2, sensorId).orderDesc(RealCgmHistoryEntity_.idx).build().findFirst();
            if (realCgmHistoryEntity != null) {
                realCgmHistoryEntity.setRawOne(Float.valueOf(aidexXRawHistoryEntity.i1));
                realCgmHistoryEntity.setRawTwo(Float.valueOf(aidexXRawHistoryEntity.i2));
                realCgmHistoryEntity.setRawVc(Float.valueOf(aidexXRawHistoryEntity.vc));
                realCgmHistoryEntity.setRawIsValid(Integer.valueOf(aidexXRawHistoryEntity.isValid));
                realCgmHistoryEntity.setRawUploadState(1);
                transmitterModel.tempRawList.add(realCgmHistoryEntity);
            }
        }
        if (!transmitterModel.tempRawList.isEmpty() && transmitterModel.tempRawList.size() == list.size()) {
            Box<RealCgmHistoryEntity> cgmHistoryBox2 = ObjectBox.INSTANCE.getCgmHistoryBox();
            Intrinsics.checkNotNull(cgmHistoryBox2);
            cgmHistoryBox2.put((Collection<RealCgmHistoryEntity>) transmitterModel.tempRawList);
        }
    }

    public DeviceModel.GlucoseLevel getGlucoseLevel(Float f) {
        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L) {
            if (f == null) {
                return null;
            }
            if (Float.parseFloat(ExtendsKt.setScaleHalfEven(Float.valueOf(f.floatValue() / 18.0f), 1)) >= Float.parseFloat(ExtendsKt.setScaleHalfEven(Float.valueOf(ThresholdManager.INSTANCE.getHyper() / 18.0f), 1))) {
                return DeviceModel.GlucoseLevel.HIGH;
            }
            if (Float.parseFloat(ExtendsKt.setScaleHalfEven(Float.valueOf(f.floatValue() / 18.0f), 1)) <= Float.parseFloat(ExtendsKt.setScaleHalfEven(Float.valueOf(ThresholdManager.INSTANCE.getHypo() / 18.0f), 1))) {
                return DeviceModel.GlucoseLevel.LOW;
            }
            return DeviceModel.GlucoseLevel.NORMAL;
        } else if (f == null) {
            return null;
        } else {
            if (f.floatValue() >= ((float) MathKt.roundToInt(ThresholdManager.INSTANCE.getHyper()))) {
                return DeviceModel.GlucoseLevel.HIGH;
            }
            if (f.floatValue() <= ((float) MathKt.roundToInt(ThresholdManager.INSTANCE.getHypo()))) {
                return DeviceModel.GlucoseLevel.LOW;
            }
            return DeviceModel.GlucoseLevel.NORMAL;
        }
    }
}
