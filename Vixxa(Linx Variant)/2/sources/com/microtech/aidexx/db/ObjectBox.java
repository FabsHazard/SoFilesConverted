package com.microtech.aidexx.db;

import android.content.Context;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import com.microtech.aidexx.db.entity.MyObjectBox;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.utils.LogUtil;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.BoxStoreBuilder;
import io.objectbox.exception.FileCorruptException;
import io.objectbox.kotlin.BoxStoreKt;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010)\u001a\u0004\u0018\u0001H*\"\b\b\u0000\u0010**\u00020\u00012\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H*0,HHø\u0001\u0000¢\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201JI\u00102\u001a\u00020/2\u0006\u00103\u001a\u0002042\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020/\u0018\u0001062'\b\u0002\u00107\u001a!\u0012\u0015\u0012\u0013\u0018\u000109¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020/\u0018\u000108R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR$\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR$\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR$\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/microtech/aidexx/db/ObjectBox;", "", "()V", "bgHistoryBox", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "getBgHistoryBox", "()Lio/objectbox/Box;", "setBgHistoryBox", "(Lio/objectbox/Box;)V", "calibrationBox", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "getCalibrationBox", "setCalibrationBox", "cgmHistoryBox", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "getCgmHistoryBox", "setCgmHistoryBox", "historyDeviceBox", "Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "getHistoryDeviceBox", "setHistoryDeviceBox", "<set-?>", "Lio/objectbox/BoxStore;", "store", "getStore", "()Lio/objectbox/BoxStore;", "storeBuilder", "Lio/objectbox/BoxStoreBuilder;", "timeZoneHistoryBox", "Lcom/microtech/aidexx/db/entity/TimezoneHistoryEntity;", "getTimeZoneHistoryBox", "setTimeZoneHistoryBox", "transmitterBox", "Lcom/microtech/aidexx/db/entity/TransmitterEntity;", "getTransmitterBox", "setTransmitterBox", "userBox", "Lcom/microtech/aidexx/db/entity/UserEntity;", "getUserBox", "setUserBox", "awaitCallInTx", "V", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "init", "", "context", "Landroid/content/Context;", "runAsync", "runnable", "Ljava/lang/Runnable;", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "error", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectBox.kt */
public final class ObjectBox {
    public static final ObjectBox INSTANCE = new ObjectBox();
    private static Box<BloodGlucoseEntity> bgHistoryBox;
    private static Box<CalibrateEntity> calibrationBox;
    private static Box<RealCgmHistoryEntity> cgmHistoryBox;
    private static Box<HistoryDeviceInfo> historyDeviceBox;
    private static BoxStore store;
    private static BoxStoreBuilder storeBuilder;
    private static Box<TimezoneHistoryEntity> timeZoneHistoryBox;
    private static Box<TransmitterEntity> transmitterBox;
    private static Box<UserEntity> userBox;

    private ObjectBox() {
    }

    public final BoxStore getStore() {
        BoxStore boxStore = store;
        if (boxStore != null) {
            return boxStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("store");
        return null;
    }

    public final void init(Context context) {
        BoxStore boxStore;
        Intrinsics.checkNotNullParameter(context, "context");
        BoxStoreBuilder maxSizeInKByte = MyObjectBox.builder().validateOnOpen(5).androidContext(context.getApplicationContext()).maxSizeInKByte(5242880);
        Intrinsics.checkNotNullExpressionValue(maxSizeInKByte, "maxSizeInKByte(...)");
        storeBuilder = maxSizeInKByte;
        BoxStoreBuilder boxStoreBuilder = null;
        if (maxSizeInKByte == null) {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("storeBuilder");
                maxSizeInKByte = null;
            } catch (FileCorruptException unused) {
                LogUtil.Companion.eAiDEX("File corrupt, trying previous data snapshot");
                BoxStoreBuilder boxStoreBuilder2 = storeBuilder;
                if (boxStoreBuilder2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storeBuilder");
                    boxStoreBuilder2 = null;
                }
                boxStoreBuilder2.usePreviousCommit();
                BoxStoreBuilder boxStoreBuilder3 = storeBuilder;
                if (boxStoreBuilder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storeBuilder");
                } else {
                    boxStoreBuilder = boxStoreBuilder3;
                }
                boxStore = boxStoreBuilder.build();
                Intrinsics.checkNotNull(boxStore);
            }
        }
        boxStore = maxSizeInKByte.build();
        Intrinsics.checkNotNull(boxStore);
        store = boxStore;
    }

    public static /* synthetic */ void runAsync$default(ObjectBox objectBox, Runnable runnable, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        objectBox.runAsync(runnable, function0, function1);
    }

    public final void runAsync(Runnable runnable, Function0<Unit> function0, Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getStore().runInTxAsync(runnable, new ObjectBox$$ExternalSyntheticLambda0(function0, function1));
    }

    /* access modifiers changed from: private */
    public static final void runAsync$lambda$0(Function0 function0, Function1 function1, Void voidR, Throwable th) {
        if (th == null) {
            if (function0 != null) {
                function0.invoke();
            }
        } else if (function1 != null) {
            function1.invoke(th);
        }
    }

    public final void setUserBox(Box<UserEntity> box) {
        userBox = box;
    }

    public final Box<UserEntity> getUserBox() {
        Box<UserEntity> box = userBox;
        if (box != null) {
            return box;
        }
        Box<UserEntity> boxFor = getStore().boxFor(UserEntity.class);
        userBox = boxFor;
        return boxFor;
    }

    public final void setTransmitterBox(Box<TransmitterEntity> box) {
        transmitterBox = box;
    }

    public final Box<TransmitterEntity> getTransmitterBox() {
        Box<TransmitterEntity> box = transmitterBox;
        if (box != null) {
            return box;
        }
        Box<TransmitterEntity> boxFor = getStore().boxFor(TransmitterEntity.class);
        transmitterBox = boxFor;
        return boxFor;
    }

    public final void setHistoryDeviceBox(Box<HistoryDeviceInfo> box) {
        historyDeviceBox = box;
    }

    public final Box<HistoryDeviceInfo> getHistoryDeviceBox() {
        Box<HistoryDeviceInfo> box = historyDeviceBox;
        if (box != null) {
            return box;
        }
        Box<HistoryDeviceInfo> boxFor = getStore().boxFor(HistoryDeviceInfo.class);
        historyDeviceBox = boxFor;
        return boxFor;
    }

    public final void setCgmHistoryBox(Box<RealCgmHistoryEntity> box) {
        cgmHistoryBox = box;
    }

    public final Box<RealCgmHistoryEntity> getCgmHistoryBox() {
        Box<RealCgmHistoryEntity> box = cgmHistoryBox;
        if (box != null) {
            return box;
        }
        Box<RealCgmHistoryEntity> boxFor = getStore().boxFor(RealCgmHistoryEntity.class);
        cgmHistoryBox = boxFor;
        return boxFor;
    }

    public final void setBgHistoryBox(Box<BloodGlucoseEntity> box) {
        bgHistoryBox = box;
    }

    public final Box<BloodGlucoseEntity> getBgHistoryBox() {
        Box<BloodGlucoseEntity> box = bgHistoryBox;
        if (box != null) {
            return box;
        }
        Box<BloodGlucoseEntity> boxFor = getStore().boxFor(BloodGlucoseEntity.class);
        bgHistoryBox = boxFor;
        return boxFor;
    }

    public final void setCalibrationBox(Box<CalibrateEntity> box) {
        calibrationBox = box;
    }

    public final Box<CalibrateEntity> getCalibrationBox() {
        Box<CalibrateEntity> box = calibrationBox;
        if (box != null) {
            return box;
        }
        Box<CalibrateEntity> boxFor = getStore().boxFor(CalibrateEntity.class);
        calibrationBox = boxFor;
        return boxFor;
    }

    public final void setTimeZoneHistoryBox(Box<TimezoneHistoryEntity> box) {
        timeZoneHistoryBox = box;
    }

    public final Box<TimezoneHistoryEntity> getTimeZoneHistoryBox() {
        Box<TimezoneHistoryEntity> box = timeZoneHistoryBox;
        if (box != null) {
            return box;
        }
        Box<TimezoneHistoryEntity> boxFor = getStore().boxFor(TimezoneHistoryEntity.class);
        timeZoneHistoryBox = boxFor;
        return boxFor;
    }

    private final <V> Object awaitCallInTx$$forInline(Callable<V> callable, Continuation<? super V> continuation) {
        BoxStore store2 = getStore();
        InlineMarker.mark(0);
        Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store2, callable, continuation);
        InlineMarker.mark(1);
        return awaitCallInTx;
    }

    public final <V> Object awaitCallInTx(Callable<V> callable, Continuation<? super V> continuation) {
        return BoxStoreKt.awaitCallInTx(getStore(), callable, continuation);
    }
}
