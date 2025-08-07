package com.microtech.aidexx.data;

import com.google.gson.Gson;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.DataTaskType;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.db.repository.CgmCalibBgRepository;
import com.microtech.aidexx.db.repository.EventDbRepository;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000 I*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0004IJKLB\u0005¢\u0006\u0002\u0010\u0004J'\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\rJ=\u0010-\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\f2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#00H@ø\u0001\u0000¢\u0006\u0002\u00101J\u0019\u00102\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\rH¤@ø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00104\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u00103J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u0010$\u001a\u00020\rH\u0004J\u0010\u00107\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0002J\u000e\u00108\u001a\u00020#2\u0006\u0010)\u001a\u00020*J\u0010\u00109\u001a\u00020#2\u0006\u0010$\u001a\u00020\rH\u0004J4\u0010:\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010;\u001a\u00020<2\u0018\b\u0002\u0010=\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020#\u0018\u000100J\u0006\u0010>\u001a\u00020#J\u0012\u0010?\u001a\u00020#2\b\b\u0002\u0010@\u001a\u00020\u0015H\u0002J\u0012\u0010A\u001a\u00020#2\b\b\u0002\u0010@\u001a\u00020\u0015H\u0002J\u0012\u0010B\u001a\u00020#2\b\b\u0002\u0010@\u001a\u00020\u0015H\u0002J-\u0010C\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#00H@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0018\u0010F\u001a\u00020#2\u0006\u0010$\u001a\u00020\r2\u0006\u0010G\u001a\u000206H\u0004J\u0019\u0010H\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\rH¤@ø\u0001\u0000¢\u0006\u0002\u00103R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController;", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "", "()V", "dataSyncExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "downloadLimitController", "Lcom/microtech/aidexx/data/SyncFrequencyLimitController;", "downloadShareDataJob", "Lkotlinx/coroutines/Job;", "downloadShareDataStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "downloadShareDataStatus", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus;", "getDownloadShareDataStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "downloadShareDataStatusStateFlow", "downloadStateFlow", "", "downloadStatus", "getDownloadStatus", "downloadStatusStateFlow", "shareUserDataSyncExceptionHandler", "syncDeletedDataExceptionHandler", "tClazz", "Ljava/lang/Class;", "getTClazz", "()Ljava/lang/Class;", "uploadDelLimitController", "uploadDeletedDataStateFlow", "uploadLimitController", "applyData", "", "userId", "data", "", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canDoHttpRequest", "type", "Lcom/microtech/aidexx/data/DataTaskType;", "canSync", "xLogInfo", "download", "statusFlow", "stopDownloadFun", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadDataOfRealTime", "getFirstTaskItem", "Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;", "getLimitController", "onHttpRequestSuccess", "removeFirstTaskItem", "startDownload", "scope", "Lkotlinx/coroutines/CoroutineScope;", "cb", "startUploadDeletedData", "stopDownloadData", "isFromException", "stopDownloadShareUserData", "stopSyncDeletedData", "syncDeletedData", "stopFun", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFirstTaskItem", "taskItem", "uploadDeletedData", "Companion", "SyncStatus", "SyncTaskItem", "SyncTaskItemList", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataSyncController.kt */
public abstract class DataSyncController<T extends BaseEventEntity> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DOWNLOAD_INTERVAL = 5000;
    private static final String TAG = "DataSyncController";
    /* access modifiers changed from: private */
    public static final CoroutineScope scope = DataSyncControllerKt.dataSyncScope;
    /* access modifiers changed from: private */
    public final CoroutineExceptionHandler dataSyncExceptionHandler = new DataSyncController$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
    private final SyncFrequencyLimitController downloadLimitController = new SyncFrequencyLimitController();
    private Job downloadShareDataJob;
    /* access modifiers changed from: private */
    public final MutableStateFlow<String> downloadShareDataStateFlow;
    private final StateFlow<SyncStatus> downloadShareDataStatus;
    /* access modifiers changed from: private */
    public final MutableStateFlow<SyncStatus> downloadShareDataStatusStateFlow;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> downloadStateFlow = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<SyncStatus> downloadStatus;
    /* access modifiers changed from: private */
    public final MutableStateFlow<SyncStatus> downloadStatusStateFlow;
    /* access modifiers changed from: private */
    public final CoroutineExceptionHandler shareUserDataSyncExceptionHandler = new DataSyncController$special$$inlined$CoroutineExceptionHandler$3(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final CoroutineExceptionHandler syncDeletedDataExceptionHandler = new DataSyncController$special$$inlined$CoroutineExceptionHandler$2(CoroutineExceptionHandler.Key, this);
    private final Class<T> tClazz;
    private final SyncFrequencyLimitController uploadDelLimitController = new SyncFrequencyLimitController();
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> uploadDeletedDataStateFlow;
    private final SyncFrequencyLimitController uploadLimitController = new SyncFrequencyLimitController();

    /* access modifiers changed from: protected */
    public abstract Object downloadData(String str, Continuation<? super Boolean> continuation);

    /* access modifiers changed from: protected */
    public abstract Object uploadDeletedData(String str, Continuation<? super Boolean> continuation);

    public DataSyncController() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<T of com.microtech.aidexx.data.DataSyncController>");
        this.tClazz = (Class) type;
        MutableStateFlow<SyncStatus> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.downloadStatusStateFlow = MutableStateFlow;
        this.downloadStatus = FlowKt.asStateFlow(MutableStateFlow);
        this.downloadShareDataStateFlow = StateFlowKt.MutableStateFlow(null);
        MutableStateFlow<SyncStatus> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this.downloadShareDataStatusStateFlow = MutableStateFlow2;
        this.downloadShareDataStatus = FlowKt.asStateFlow(MutableStateFlow2);
        this.uploadDeletedDataStateFlow = StateFlowKt.MutableStateFlow(false);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eJ\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eJ\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eJ/\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$Companion;", "", "()V", "DOWNLOAD_INTERVAL", "", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getLoginMaxIdKey", "userId", "clazz", "Ljava/lang/Class;", "getLoginStateKey", "getTaskItemListKey", "insertToDb", "", "data", "", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "(Ljava/util/List;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataSyncController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoroutineScope getScope() {
            return DataSyncController.scope;
        }

        public final String getLoginStateKey(String str, Class<?> cls) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(cls, "clazz");
            return "LoginState-" + str + Soundex.SILENT_MARKER + cls.getSimpleName();
        }

        public final String getLoginMaxIdKey(String str, Class<?> cls) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(cls, "clazz");
            return "LoginState-" + str + Soundex.SILENT_MARKER + cls.getSimpleName() + "-MaxId";
        }

        public final String getTaskItemListKey(String str, Class<?> cls) {
            Intrinsics.checkNotNullParameter(str, "userId");
            Intrinsics.checkNotNullParameter(cls, "clazz");
            return "TaskItemList-" + str + Soundex.SILENT_MARKER + cls.getSimpleName();
        }

        public final Object insertToDb(List<? extends BaseEventEntity> list, Class<? extends BaseEventEntity> cls, Continuation<? super Unit> continuation) {
            boolean z;
            if (Intrinsics.areEqual((Object) cls, (Object) RealCgmHistoryEntity.class)) {
                CgmCalibBgRepository cgmCalibBgRepository = CgmCalibBgRepository.INSTANCE;
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity>");
                return cgmCalibBgRepository.insertCgm(list, continuation);
            } else if (Intrinsics.areEqual((Object) cls, (Object) CalibrateEntity.class)) {
                CgmCalibBgRepository cgmCalibBgRepository2 = CgmCalibBgRepository.INSTANCE;
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.microtech.aidexx.db.entity.CalibrateEntity>");
                return cgmCalibBgRepository2.insertCal(list, continuation);
            } else if (Intrinsics.areEqual((Object) cls, (Object) BloodGlucoseEntity.class)) {
                CgmCalibBgRepository cgmCalibBgRepository3 = CgmCalibBgRepository.INSTANCE;
                Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<com.microtech.aidexx.db.entity.BloodGlucoseEntity>");
                return cgmCalibBgRepository3.insertBg(list, continuation);
            } else {
                boolean z2 = true;
                if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class) ? true : Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
                    z = true;
                } else {
                    z = Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class);
                }
                if (!(z ? true : Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class))) {
                    z2 = Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class);
                }
                if (z2) {
                    return EventDbRepository.INSTANCE.insertEvents(list, continuation);
                }
                LogUtil.Companion.xLogE$default(LogUtil.Companion, "不支持当前类型下载数据写入db clazz=" + cls.getSimpleName(), (String) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
        }
    }

    public final Class<T> getTClazz() {
        return this.tClazz;
    }

    private final SyncFrequencyLimitController getLimitController(DataTaskType dataTaskType) {
        if (dataTaskType instanceof DataTaskType.Upload) {
            return this.uploadLimitController;
        }
        if (dataTaskType instanceof DataTaskType.Download) {
            return this.downloadLimitController;
        }
        if (dataTaskType instanceof DataTaskType.UploadDel) {
            return this.uploadDelLimitController;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean canDoHttpRequest(DataTaskType dataTaskType) {
        Intrinsics.checkNotNullParameter(dataTaskType, TransmitterActivityKt.OPERATION_TYPE);
        return getLimitController(dataTaskType).canDo(dataTaskType.getClass().getSimpleName() + Soundex.SILENT_MARKER + this.tClazz.getSimpleName());
    }

    public final void onHttpRequestSuccess(DataTaskType dataTaskType) {
        Intrinsics.checkNotNullParameter(dataTaskType, TransmitterActivityKt.OPERATION_TYPE);
        getLimitController(dataTaskType).resetNextDoTime();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$SyncStatus;", "", "()V", "Failure", "Loading", "Success", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus$Failure;", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus$Loading;", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus$Success;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DataSyncController.kt */
    public static abstract class SyncStatus {
        public /* synthetic */ SyncStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$SyncStatus$Loading;", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus;", "progress", "", "(I)V", "getProgress", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: DataSyncController.kt */
        public static final class Loading extends SyncStatus {
            private final int progress;

            public Loading() {
                this(0, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Loading copy$default(Loading loading, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = loading.progress;
                }
                return loading.copy(i);
            }

            public final int component1() {
                return this.progress;
            }

            public final Loading copy(int i) {
                return new Loading(i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Loading) && this.progress == ((Loading) obj).progress;
            }

            public int hashCode() {
                return Integer.hashCode(this.progress);
            }

            public String toString() {
                return "Loading(progress=" + this.progress + ')';
            }

            public Loading(int i) {
                super((DefaultConstructorMarker) null);
                this.progress = i;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Loading(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 0 : i);
            }

            public final int getProgress() {
                return this.progress;
            }
        }

        private SyncStatus() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$SyncStatus$Success;", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus;", "()V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: DataSyncController.kt */
        public static final class Success extends SyncStatus {
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$SyncStatus$Failure;", "Lcom/microtech/aidexx/data/DataSyncController$SyncStatus;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* compiled from: DataSyncController.kt */
        public static final class Failure extends SyncStatus {
            private final String msg;

            public Failure() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Failure copy$default(Failure failure, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = failure.msg;
                }
                return failure.copy(str);
            }

            public final String component1() {
                return this.msg;
            }

            public final Failure copy(String str) {
                return new Failure(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.msg, (Object) ((Failure) obj).msg);
            }

            public int hashCode() {
                String str = this.msg;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Failure(msg=" + this.msg + ')';
            }

            public Failure(String str) {
                super((DefaultConstructorMarker) null);
                this.msg = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Failure(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getMsg() {
                return this.msg;
            }
        }
    }

    public final StateFlow<SyncStatus> getDownloadStatus() {
        return this.downloadStatus;
    }

    public final StateFlow<SyncStatus> getDownloadShareDataStatus() {
        return this.downloadShareDataStatus;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.data.DataSyncController$1", f = "DataSyncController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.data.DataSyncController$1  reason: invalid class name */
    /* compiled from: DataSyncController.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DataSyncController<T> this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final DataSyncController<T> dataSyncController = this.this$0;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 

                        public static /* synthetic */ boolean startDownload$default(DataSyncController dataSyncController, String str, CoroutineScope coroutineScope, Function1 function1, int i, Object obj) {
                            if (obj == null) {
                                if ((i & 2) != 0) {
                                    coroutineScope = DataSyncControllerKt.dataSyncScope;
                                }
                                if ((i & 4) != 0) {
                                    function1 = null;
                                }
                                return dataSyncController.startDownload(str, coroutineScope, function1);
                            }
                            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDownload");
                        }

                        public final boolean startDownload(String str, CoroutineScope coroutineScope, Function1<? super SyncStatus, Unit> function1) {
                            boolean z;
                            Intrinsics.checkNotNullParameter(coroutineScope, "scope");
                            if (str != null ? !Intrinsics.areEqual((Object) str, (Object) UserInfoManager.Companion.instance().userId()) : false) {
                                if (this.downloadShareDataStateFlow.getValue() != null && !Intrinsics.areEqual((Object) this.downloadShareDataStateFlow.getValue(), (Object) str)) {
                                    Job job = this.downloadShareDataJob;
                                    if (job != null) {
                                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                                    }
                                    this.downloadShareDataStateFlow.setValue(null);
                                }
                                z = this.downloadShareDataStateFlow.compareAndSet(null, str);
                                if (z) {
                                    this.downloadShareDataJob = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DataSyncController$startDownload$1(this, function1, (Continuation<? super DataSyncController$startDownload$1>) null), 3, (Object) null);
                                }
                            } else {
                                z = this.downloadStateFlow.compareAndSet(false, true);
                                if (z) {
                                    Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DataSyncController$startDownload$2(this, function1, (Continuation<? super DataSyncController$startDownload$2>) null), 3, (Object) null);
                                }
                            }
                            return z;
                        }

                        public final void startUploadDeletedData() {
                            this.uploadDeletedDataStateFlow.compareAndSet(false, true);
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.data.DataSyncController$SyncStatus>} */
                        /* access modifiers changed from: private */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
                        /* JADX WARNING: Removed duplicated region for block: B:30:0x00c4 A[RETURN] */
                        /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
                        /* JADX WARNING: Removed duplicated region for block: B:34:0x00ce  */
                        /* JADX WARNING: Removed duplicated region for block: B:38:0x00df  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object download(java.lang.String r11, kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.data.DataSyncController.SyncStatus> r12, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
                            /*
                                r10 = this;
                                boolean r0 = r14 instanceof com.microtech.aidexx.data.DataSyncController$download$1
                                if (r0 == 0) goto L_0x0014
                                r0 = r14
                                com.microtech.aidexx.data.DataSyncController$download$1 r0 = (com.microtech.aidexx.data.DataSyncController$download$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L_0x0014
                                int r14 = r0.label
                                int r14 = r14 - r2
                                r0.label = r14
                                goto L_0x0019
                            L_0x0014:
                                com.microtech.aidexx.data.DataSyncController$download$1 r0 = new com.microtech.aidexx.data.DataSyncController$download$1
                                r0.<init>(r10, r14)
                            L_0x0019:
                                java.lang.Object r14 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 0
                                r4 = 5
                                r5 = 4
                                r6 = 3
                                r7 = 2
                                r8 = 1
                                r9 = 0
                                if (r2 == 0) goto L_0x0073
                                if (r2 == r8) goto L_0x0069
                                if (r2 == r7) goto L_0x0053
                                if (r2 == r6) goto L_0x0046
                                if (r2 == r5) goto L_0x003d
                                if (r2 != r4) goto L_0x0035
                                goto L_0x003d
                            L_0x0035:
                                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                                r11.<init>(r12)
                                throw r11
                            L_0x003d:
                                java.lang.Object r11 = r0.L$0
                                kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
                                kotlin.ResultKt.throwOnFailure(r14)
                                goto L_0x00dd
                            L_0x0046:
                                java.lang.Object r11 = r0.L$1
                                kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
                                java.lang.Object r12 = r0.L$0
                                kotlinx.coroutines.flow.MutableStateFlow r12 = (kotlinx.coroutines.flow.MutableStateFlow) r12
                                kotlin.ResultKt.throwOnFailure(r14)
                                goto L_0x00c6
                            L_0x0053:
                                java.lang.Object r11 = r0.L$3
                                r13 = r11
                                kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
                                java.lang.Object r11 = r0.L$2
                                r12 = r11
                                kotlinx.coroutines.flow.MutableStateFlow r12 = (kotlinx.coroutines.flow.MutableStateFlow) r12
                                java.lang.Object r11 = r0.L$1
                                java.lang.String r11 = (java.lang.String) r11
                                java.lang.Object r2 = r0.L$0
                                com.microtech.aidexx.data.DataSyncController r2 = (com.microtech.aidexx.data.DataSyncController) r2
                                kotlin.ResultKt.throwOnFailure(r14)
                                goto L_0x00b4
                            L_0x0069:
                                java.lang.Object r11 = r0.L$0
                                r13 = r11
                                kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
                                kotlin.ResultKt.throwOnFailure(r14)
                                goto L_0x00f1
                            L_0x0073:
                                kotlin.ResultKt.throwOnFailure(r14)
                                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                                java.lang.String r2 = "下载数据-"
                                r14.<init>(r2)
                                java.lang.StringBuilder r14 = r14.append(r11)
                                java.lang.String r14 = r14.toString()
                                boolean r14 = r10.canSync(r14)
                                if (r14 != 0) goto L_0x009d
                                kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.data.DataSyncController$SyncStatus> r11 = r10.downloadStatusStateFlow
                                com.microtech.aidexx.data.DataSyncController$SyncStatus$Failure r12 = new com.microtech.aidexx.data.DataSyncController$SyncStatus$Failure
                                r12.<init>(r9, r8, r9)
                                r0.L$0 = r13
                                r0.label = r8
                                java.lang.Object r11 = r11.emit(r12, r0)
                                if (r11 != r1) goto L_0x00f1
                                return r1
                            L_0x009d:
                                com.microtech.aidexx.data.DataSyncController$SyncStatus$Loading r14 = new com.microtech.aidexx.data.DataSyncController$SyncStatus$Loading
                                r14.<init>(r3, r8, r9)
                                r0.L$0 = r10
                                r0.L$1 = r11
                                r0.L$2 = r12
                                r0.L$3 = r13
                                r0.label = r7
                                java.lang.Object r14 = r12.emit(r14, r0)
                                if (r14 != r1) goto L_0x00b3
                                return r1
                            L_0x00b3:
                                r2 = r10
                            L_0x00b4:
                                r0.L$0 = r12
                                r0.L$1 = r13
                                r0.L$2 = r9
                                r0.L$3 = r9
                                r0.label = r6
                                java.lang.Object r14 = r2.downloadData(r11, r0)
                                if (r14 != r1) goto L_0x00c5
                                return r1
                            L_0x00c5:
                                r11 = r13
                            L_0x00c6:
                                java.lang.Boolean r14 = (java.lang.Boolean) r14
                                boolean r13 = r14.booleanValue()
                                if (r13 == 0) goto L_0x00df
                                com.microtech.aidexx.data.DataSyncController$SyncStatus$Success r13 = com.microtech.aidexx.data.DataSyncController.SyncStatus.Success.INSTANCE
                                r0.L$0 = r11
                                r0.L$1 = r9
                                r0.label = r5
                                java.lang.Object r12 = r12.emit(r13, r0)
                                if (r12 != r1) goto L_0x00dd
                                return r1
                            L_0x00dd:
                                r13 = r11
                                goto L_0x00f1
                            L_0x00df:
                                com.microtech.aidexx.data.DataSyncController$SyncStatus$Failure r13 = new com.microtech.aidexx.data.DataSyncController$SyncStatus$Failure
                                r13.<init>(r9, r8, r9)
                                r0.L$0 = r11
                                r0.L$1 = r9
                                r0.label = r4
                                java.lang.Object r12 = r12.emit(r13, r0)
                                if (r12 != r1) goto L_0x00dd
                                return r1
                            L_0x00f1:
                                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                                r13.invoke(r11)
                                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                                return r11
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.DataSyncController.download(java.lang.String, kotlinx.coroutines.flow.MutableStateFlow, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        static /* synthetic */ void stopDownloadData$default(DataSyncController dataSyncController, boolean z, int i, Object obj) {
                            if (obj == null) {
                                if ((i & 1) != 0) {
                                    z = false;
                                }
                                dataSyncController.stopDownloadData(z);
                                return;
                            }
                            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopDownloadData");
                        }

                        /* access modifiers changed from: private */
                        public final void stopDownloadData(boolean z) {
                            if (z) {
                                Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new DataSyncController$stopDownloadData$1(this, (Continuation<? super DataSyncController$stopDownloadData$1>) null), 3, (Object) null);
                            }
                            this.downloadStateFlow.compareAndSet(true, false);
                        }

                        static /* synthetic */ void stopDownloadShareUserData$default(DataSyncController dataSyncController, boolean z, int i, Object obj) {
                            if (obj == null) {
                                if ((i & 1) != 0) {
                                    z = false;
                                }
                                dataSyncController.stopDownloadShareUserData(z);
                                return;
                            }
                            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopDownloadShareUserData");
                        }

                        /* access modifiers changed from: private */
                        public final void stopDownloadShareUserData(boolean z) {
                            if (z) {
                                Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new DataSyncController$stopDownloadShareUserData$1(this, (Continuation<? super DataSyncController$stopDownloadShareUserData$1>) null), 3, (Object) null);
                            }
                            this.downloadShareDataStateFlow.setValue(null);
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>} */
                        /* access modifiers changed from: private */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
                        /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object syncDeletedData(java.lang.String r5, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
                            /*
                                r4 = this;
                                boolean r0 = r7 instanceof com.microtech.aidexx.data.DataSyncController$syncDeletedData$1
                                if (r0 == 0) goto L_0x0014
                                r0 = r7
                                com.microtech.aidexx.data.DataSyncController$syncDeletedData$1 r0 = (com.microtech.aidexx.data.DataSyncController$syncDeletedData$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L_0x0014
                                int r7 = r0.label
                                int r7 = r7 - r2
                                r0.label = r7
                                goto L_0x0019
                            L_0x0014:
                                com.microtech.aidexx.data.DataSyncController$syncDeletedData$1 r0 = new com.microtech.aidexx.data.DataSyncController$syncDeletedData$1
                                r0.<init>(r4, r7)
                            L_0x0019:
                                java.lang.Object r7 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L_0x003b
                                if (r2 != r3) goto L_0x0033
                                java.lang.Object r5 = r0.L$1
                                r6 = r5
                                kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
                                java.lang.Object r5 = r0.L$0
                                com.microtech.aidexx.data.DataSyncController r5 = (com.microtech.aidexx.data.DataSyncController) r5
                                kotlin.ResultKt.throwOnFailure(r7)
                                goto L_0x0054
                            L_0x0033:
                                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                                r5.<init>(r6)
                                throw r5
                            L_0x003b:
                                kotlin.ResultKt.throwOnFailure(r7)
                                java.lang.String r7 = "同步删除数据"
                                boolean r7 = r4.canSync(r7)
                                if (r7 == 0) goto L_0x0078
                                r0.L$0 = r4
                                r0.L$1 = r6
                                r0.label = r3
                                java.lang.Object r7 = r4.uploadDeletedData(r5, r0)
                                if (r7 != r1) goto L_0x0053
                                return r1
                            L_0x0053:
                                r5 = r4
                            L_0x0054:
                                java.lang.Boolean r7 = (java.lang.Boolean) r7
                                boolean r7 = r7.booleanValue()
                                if (r7 != 0) goto L_0x0078
                                com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                java.lang.String r1 = "sync deleted data stop fail "
                                r0.<init>(r1)
                                java.lang.Class<T> r5 = r5.tClazz
                                java.lang.String r5 = r5.getSimpleName()
                                java.lang.StringBuilder r5 = r0.append(r5)
                                java.lang.String r5 = r5.toString()
                                java.lang.String r0 = "DataSyncController"
                                r7.xLogI(r5, r0)
                            L_0x0078:
                                r5 = 0
                                java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                                r6.invoke(r5)
                                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.DataSyncController.syncDeletedData(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        static /* synthetic */ void stopSyncDeletedData$default(DataSyncController dataSyncController, boolean z, int i, Object obj) {
                            if (obj == null) {
                                if ((i & 1) != 0) {
                                    z = false;
                                }
                                dataSyncController.stopSyncDeletedData(z);
                                return;
                            }
                            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopSyncDeletedData");
                        }

                        /* access modifiers changed from: private */
                        public final void stopSyncDeletedData(boolean z) {
                            this.uploadDeletedDataStateFlow.compareAndSet(true, false);
                        }

                        public static /* synthetic */ boolean canSync$default(DataSyncController dataSyncController, String str, int i, Object obj) {
                            if (obj == null) {
                                if ((i & 1) != 0) {
                                    str = "";
                                }
                                return dataSyncController.canSync(str);
                            }
                            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canSync");
                        }

                        public final boolean canSync(String str) {
                            Intrinsics.checkNotNullParameter(str, "xLogInfo");
                            if (UserInfoManager.Companion.instance().isLogin()) {
                                return true;
                            }
                            LogUtil.Companion.xLogE(str + " 未登录，" + this.tClazz.getSimpleName() + " 停止", TAG);
                            return false;
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.util.List<? extends T>} */
                        /* access modifiers changed from: protected */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object applyData(java.lang.String r4, java.util.List<? extends T> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                            /*
                                r3 = this;
                                boolean r4 = r6 instanceof com.microtech.aidexx.data.DataSyncController$applyData$1
                                if (r4 == 0) goto L_0x0014
                                r4 = r6
                                com.microtech.aidexx.data.DataSyncController$applyData$1 r4 = (com.microtech.aidexx.data.DataSyncController$applyData$1) r4
                                int r0 = r4.label
                                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                                r0 = r0 & r1
                                if (r0 == 0) goto L_0x0014
                                int r6 = r4.label
                                int r6 = r6 - r1
                                r4.label = r6
                                goto L_0x0019
                            L_0x0014:
                                com.microtech.aidexx.data.DataSyncController$applyData$1 r4 = new com.microtech.aidexx.data.DataSyncController$applyData$1
                                r4.<init>(r3, r6)
                            L_0x0019:
                                java.lang.Object r6 = r4.result
                                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r4.label
                                r2 = 1
                                if (r1 == 0) goto L_0x0037
                                if (r1 != r2) goto L_0x002f
                                java.lang.Object r4 = r4.L$0
                                r5 = r4
                                java.util.List r5 = (java.util.List) r5
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L_0x0049
                            L_0x002f:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L_0x0037:
                                kotlin.ResultKt.throwOnFailure(r6)
                                com.microtech.aidexx.data.DataSyncController$Companion r6 = Companion
                                java.lang.Class<T> r1 = r3.tClazz
                                r4.L$0 = r5
                                r4.label = r2
                                java.lang.Object r4 = r6.insertToDb(r5, r1, r4)
                                if (r4 != r0) goto L_0x0049
                                return r0
                            L_0x0049:
                                com.microtech.aidexx.utils.eventbus.EventBusManager r4 = com.microtech.aidexx.utils.eventbus.EventBusManager.INSTANCE
                                kotlin.Pair r6 = new kotlin.Pair
                                com.microtech.aidexx.utils.eventbus.DataChangedType r0 = com.microtech.aidexx.utils.eventbus.DataChangedType.ADD
                                r6.<init>(r0, r5)
                                java.lang.String r5 = "EVENT_DATA_CHANGED"
                                r4.send(r5, r6)
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.DataSyncController.applyData(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;", "", "startAutoIncrementColumn", "", "endAutoIncrementColumn", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getEndAutoIncrementColumn", "()Ljava/lang/Long;", "setEndAutoIncrementColumn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStartAutoIncrementColumn", "setStartAutoIncrementColumn", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;", "equals", "", "other", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
                        /* compiled from: DataSyncController.kt */
                        public static final class SyncTaskItem {
                            private Long endAutoIncrementColumn;
                            private Long startAutoIncrementColumn;

                            public static /* synthetic */ SyncTaskItem copy$default(SyncTaskItem syncTaskItem, Long l, Long l2, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    l = syncTaskItem.startAutoIncrementColumn;
                                }
                                if ((i & 2) != 0) {
                                    l2 = syncTaskItem.endAutoIncrementColumn;
                                }
                                return syncTaskItem.copy(l, l2);
                            }

                            public final Long component1() {
                                return this.startAutoIncrementColumn;
                            }

                            public final Long component2() {
                                return this.endAutoIncrementColumn;
                            }

                            public final SyncTaskItem copy(Long l, Long l2) {
                                return new SyncTaskItem(l, l2);
                            }

                            public SyncTaskItem(Long l, Long l2) {
                                this.startAutoIncrementColumn = l;
                                this.endAutoIncrementColumn = l2;
                            }

                            public final Long getStartAutoIncrementColumn() {
                                return this.startAutoIncrementColumn;
                            }

                            public final void setStartAutoIncrementColumn(Long l) {
                                this.startAutoIncrementColumn = l;
                            }

                            public final Long getEndAutoIncrementColumn() {
                                return this.endAutoIncrementColumn;
                            }

                            public final void setEndAutoIncrementColumn(Long l) {
                                this.endAutoIncrementColumn = l;
                            }

                            public int hashCode() {
                                return new StringBuilder().append(this.startAutoIncrementColumn).append(Soundex.SILENT_MARKER).append(this.endAutoIncrementColumn).toString().hashCode();
                            }

                            public boolean equals(Object obj) {
                                if (obj == null || !(obj instanceof SyncTaskItem)) {
                                    return false;
                                }
                                SyncTaskItem syncTaskItem = (SyncTaskItem) obj;
                                if (!Intrinsics.areEqual((Object) syncTaskItem.startAutoIncrementColumn, (Object) this.startAutoIncrementColumn) || !Intrinsics.areEqual((Object) syncTaskItem.endAutoIncrementColumn, (Object) this.endAutoIncrementColumn)) {
                                    return false;
                                }
                                return true;
                            }

                            public String toString() {
                                return "SyncTaskItem[" + this.startAutoIncrementColumn + "->" + this.endAutoIncrementColumn + ']';
                            }
                        }

                        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\b\u0010\u0010\u001a\u00020\u0011H\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItemList;", "", "list", "", "Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItem;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
                        /* compiled from: DataSyncController.kt */
                        public static final class SyncTaskItemList {
                            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
                            private List<SyncTaskItem> list;

                            public static /* synthetic */ SyncTaskItemList copy$default(SyncTaskItemList syncTaskItemList, List<SyncTaskItem> list2, int i, Object obj) {
                                if ((i & 1) != 0) {
                                    list2 = syncTaskItemList.list;
                                }
                                return syncTaskItemList.copy(list2);
                            }

                            public final List<SyncTaskItem> component1() {
                                return this.list;
                            }

                            public final SyncTaskItemList copy(List<SyncTaskItem> list2) {
                                Intrinsics.checkNotNullParameter(list2, "list");
                                return new SyncTaskItemList(list2);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return (obj instanceof SyncTaskItemList) && Intrinsics.areEqual((Object) this.list, (Object) ((SyncTaskItemList) obj).list);
                            }

                            public int hashCode() {
                                return this.list.hashCode();
                            }

                            public SyncTaskItemList(List<SyncTaskItem> list2) {
                                Intrinsics.checkNotNullParameter(list2, "list");
                                this.list = list2;
                            }

                            public final List<SyncTaskItem> getList() {
                                return this.list;
                            }

                            public final void setList(List<SyncTaskItem> list2) {
                                Intrinsics.checkNotNullParameter(list2, "<set-?>");
                                this.list = list2;
                            }

                            public String toString() {
                                String json = new Gson().toJson((Object) this);
                                Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                                return json;
                            }

                            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItemList$Companion;", "", "()V", "fromString", "Lcom/microtech/aidexx/data/DataSyncController$SyncTaskItemList;", "str", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
                            /* compiled from: DataSyncController.kt */
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                private Companion() {
                                }

                                public final SyncTaskItemList fromString(String str) {
                                    Object obj;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        Companion companion2 = this;
                                        obj = Result.m343constructorimpl((SyncTaskItemList) new Gson().fromJson(str, SyncTaskItemList.class));
                                    } catch (Throwable th) {
                                        Result.Companion companion3 = Result.Companion;
                                        obj = Result.m343constructorimpl(ResultKt.createFailure(th));
                                    }
                                    if (Result.m349isFailureimpl(obj)) {
                                        obj = null;
                                    }
                                    return (SyncTaskItemList) obj;
                                }
                            }
                        }

                        /* access modifiers changed from: protected */
                        public final SyncTaskItem getFirstTaskItem(String str) {
                            List<SyncTaskItem> list;
                            Intrinsics.checkNotNullParameter(str, "userId");
                            SyncTaskItemList eventSyncTask = MmkvManager.INSTANCE.getEventSyncTask(Companion.getTaskItemListKey(str, this.tClazz));
                            if (eventSyncTask == null || (list = eventSyncTask.getList()) == null) {
                                return null;
                            }
                            Collection collection = list;
                            if (collection.isEmpty()) {
                                collection = null;
                            }
                            List list2 = (List) collection;
                            if (list2 != null) {
                                return (SyncTaskItem) CollectionsKt.first(list2);
                            }
                            return null;
                        }

                        /* access modifiers changed from: protected */
                        public final void updateFirstTaskItem(String str, SyncTaskItem syncTaskItem) {
                            Intrinsics.checkNotNullParameter(str, "userId");
                            Intrinsics.checkNotNullParameter(syncTaskItem, "taskItem");
                            String taskItemListKey = Companion.getTaskItemListKey(str, this.tClazz);
                            SyncTaskItemList eventSyncTask = MmkvManager.INSTANCE.getEventSyncTask(taskItemListKey);
                            Unit unit = null;
                            if (eventSyncTask != null) {
                                Collection list = eventSyncTask.getList();
                                if (list.isEmpty()) {
                                    list = null;
                                }
                                List list2 = (List) list;
                                if (!(list2 == null || ((SyncTaskItem) list2.remove(0)) == null)) {
                                    eventSyncTask.getList().add(0, syncTaskItem);
                                    MmkvManager.INSTANCE.setEventSyncTask(taskItemListKey, eventSyncTask);
                                    LogUtil.Companion.d("SyncTaskItemList " + this.tClazz.getSimpleName() + " update " + taskItemListKey + '=' + eventSyncTask + ' ', TAG);
                                    unit = Unit.INSTANCE;
                                }
                                if (unit == null) {
                                    DataSyncController dataSyncController = this;
                                    LogUtil.Companion.d("SyncTaskItemList " + this.tClazz.getSimpleName() + " updateFail tasks=empty", TAG);
                                }
                                unit = Unit.INSTANCE;
                            }
                            if (unit == null) {
                                DataSyncController dataSyncController2 = this;
                                LogUtil.Companion.d("SyncTaskItemList " + this.tClazz.getSimpleName() + " updateFail tasks=null", TAG);
                            }
                        }

                        /* access modifiers changed from: protected */
                        public final void removeFirstTaskItem(String str) {
                            Intrinsics.checkNotNullParameter(str, "userId");
                            String taskItemListKey = Companion.getTaskItemListKey(str, this.tClazz);
                            SyncTaskItemList eventSyncTask = MmkvManager.INSTANCE.getEventSyncTask(taskItemListKey);
                            Object obj = null;
                            if (eventSyncTask != null) {
                                Collection list = eventSyncTask.getList();
                                if (list.isEmpty()) {
                                    list = null;
                                }
                                List list2 = (List) list;
                                if (list2 != null) {
                                    obj = (SyncTaskItem) list2.remove(0);
                                }
                                MmkvManager.INSTANCE.setEventSyncTask(taskItemListKey, eventSyncTask);
                                LogUtil.Companion.d("SyncTaskItemList removeFirst=" + obj + ' ' + taskItemListKey + '=' + eventSyncTask, TAG);
                                obj = Unit.INSTANCE;
                            }
                            if (obj == null) {
                                DataSyncController dataSyncController = this;
                                LogUtil.Companion.e("SyncTaskItemList removeFirst fail tasks=null", TAG);
                            }
                        }

                        /* access modifiers changed from: private */
                        /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
                        /* JADX WARNING: Removed duplicated region for block: B:22:0x0076  */
                        /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
                        /* JADX WARNING: Removed duplicated region for block: B:26:0x0084  */
                        /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
                        /* JADX WARNING: Removed duplicated region for block: B:31:0x009f  */
                        /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
                        /* JADX WARNING: Removed duplicated region for block: B:48:0x00f4  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object downloadDataOfRealTime(java.lang.String r18, kotlin.coroutines.Continuation<? super java.lang.Boolean> r19) {
                            /*
                                r17 = this;
                                r0 = r17
                                r1 = r18
                                r2 = r19
                                boolean r3 = r2 instanceof com.microtech.aidexx.data.DataSyncController$downloadDataOfRealTime$1
                                if (r3 == 0) goto L_0x001a
                                r3 = r2
                                com.microtech.aidexx.data.DataSyncController$downloadDataOfRealTime$1 r3 = (com.microtech.aidexx.data.DataSyncController$downloadDataOfRealTime$1) r3
                                int r4 = r3.label
                                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                                r4 = r4 & r5
                                if (r4 == 0) goto L_0x001a
                                int r2 = r3.label
                                int r2 = r2 - r5
                                r3.label = r2
                                goto L_0x001f
                            L_0x001a:
                                com.microtech.aidexx.data.DataSyncController$downloadDataOfRealTime$1 r3 = new com.microtech.aidexx.data.DataSyncController$downloadDataOfRealTime$1
                                r3.<init>(r0, r2)
                            L_0x001f:
                                java.lang.Object r2 = r3.result
                                java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r4 = r3.label
                                r12 = 0
                                r13 = 3
                                r5 = 2
                                r14 = 1
                                r15 = 0
                                if (r4 == 0) goto L_0x005b
                                if (r4 == r14) goto L_0x004e
                                if (r4 == r5) goto L_0x0041
                                if (r4 != r13) goto L_0x0039
                                kotlin.ResultKt.throwOnFailure(r2)
                                goto L_0x00f2
                            L_0x0039:
                                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                                r1.<init>(r2)
                                throw r1
                            L_0x0041:
                                java.lang.Object r1 = r3.L$1
                                java.lang.String r1 = (java.lang.String) r1
                                java.lang.Object r4 = r3.L$0
                                com.microtech.aidexx.data.DataSyncController r4 = (com.microtech.aidexx.data.DataSyncController) r4
                                kotlin.ResultKt.throwOnFailure(r2)
                                goto L_0x00bb
                            L_0x004e:
                                java.lang.Object r1 = r3.L$1
                                java.lang.String r1 = (java.lang.String) r1
                                java.lang.Object r4 = r3.L$0
                                com.microtech.aidexx.data.DataSyncController r4 = (com.microtech.aidexx.data.DataSyncController) r4
                                kotlin.ResultKt.throwOnFailure(r2)
                                r10 = r4
                                goto L_0x0070
                            L_0x005b:
                                kotlin.ResultKt.throwOnFailure(r2)
                                com.microtech.aidexx.db.repository.EventDbRepository r2 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
                                java.lang.Class<T> r4 = r0.tClazz
                                r3.L$0 = r0
                                r3.L$1 = r1
                                r3.label = r14
                                java.lang.Object r2 = r2.findMaxEventId(r1, r4, r3)
                                if (r2 != r11) goto L_0x006f
                                return r11
                            L_0x006f:
                                r10 = r0
                            L_0x0070:
                                java.lang.Long r2 = (java.lang.Long) r2
                                r6 = 0
                                if (r2 != 0) goto L_0x007a
                                java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
                            L_0x007a:
                                long r8 = r2.longValue()
                                int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                                if (r4 > 0) goto L_0x0084
                                r7 = r15
                                goto L_0x0090
                            L_0x0084:
                                long r6 = r2.longValue()
                                r8 = 1
                                long r6 = r6 + r8
                                java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
                                r7 = r2
                            L_0x0090:
                                com.microtech.aidexx.data.DataTaskType$Download r2 = com.microtech.aidexx.data.DataTaskType.Download.INSTANCE
                                com.microtech.aidexx.data.DataTaskType r2 = (com.microtech.aidexx.data.DataTaskType) r2
                                boolean r2 = r10.canDoHttpRequest(r2)
                                if (r2 != 0) goto L_0x009f
                                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
                                return r1
                            L_0x009f:
                                com.microtech.aidexx.common.net.repository.EventRepository r4 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
                                java.lang.Class<T> r9 = r10.tClazz
                                r3.L$0 = r10
                                r3.L$1 = r1
                                r3.label = r5
                                r6 = 500(0x1f4, float:7.0E-43)
                                r8 = 0
                                r5 = r1
                                r2 = r10
                                r10 = r3
                                java.lang.Object r4 = r4.getEventRecordsByPageInfo(r5, r6, r7, r8, r9, r10)
                                if (r4 != r11) goto L_0x00b6
                                return r11
                            L_0x00b6:
                                r16 = r4
                                r4 = r2
                                r2 = r16
                            L_0x00bb:
                                com.microtech.aidexx.common.net.ApiResult r2 = (com.microtech.aidexx.common.net.ApiResult) r2
                                boolean r5 = r2 instanceof com.microtech.aidexx.common.net.ApiResult.Success
                                if (r5 == 0) goto L_0x00f4
                                com.microtech.aidexx.data.DataTaskType$Download r5 = com.microtech.aidexx.data.DataTaskType.Download.INSTANCE
                                com.microtech.aidexx.data.DataTaskType r5 = (com.microtech.aidexx.data.DataTaskType) r5
                                r4.onHttpRequestSuccess(r5)
                                com.microtech.aidexx.common.net.ApiResult$Success r2 = (com.microtech.aidexx.common.net.ApiResult.Success) r2
                                java.lang.Object r2 = r2.getResult()
                                com.microtech.aidexx.common.net.entity.BaseResponse r2 = (com.microtech.aidexx.common.net.entity.BaseResponse) r2
                                java.lang.Object r2 = r2.getData()
                                java.util.List r2 = (java.util.List) r2
                                if (r2 == 0) goto L_0x00f2
                                java.util.Collection r2 = (java.util.Collection) r2
                                boolean r5 = r2.isEmpty()
                                if (r5 == 0) goto L_0x00e1
                                r2 = r15
                            L_0x00e1:
                                java.util.List r2 = (java.util.List) r2
                                if (r2 == 0) goto L_0x00f2
                                r3.L$0 = r15
                                r3.L$1 = r15
                                r3.label = r13
                                java.lang.Object r1 = r4.applyData(r1, r2, r3)
                                if (r1 != r11) goto L_0x00f2
                                return r11
                            L_0x00f2:
                                r12 = r14
                                goto L_0x00f8
                            L_0x00f4:
                                boolean r1 = r2 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
                                if (r1 == 0) goto L_0x00fd
                            L_0x00f8:
                                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
                                return r1
                            L_0x00fd:
                                kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
                                r1.<init>()
                                throw r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.DataSyncController.downloadDataOfRealTime(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }
