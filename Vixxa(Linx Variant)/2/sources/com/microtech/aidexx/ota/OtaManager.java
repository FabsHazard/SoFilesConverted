package com.microtech.aidexx.ota;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.google.gson.Gson;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.io.File;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 82\u00020\u0001:\u00018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011J'\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u0006\u0010)\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u0004J\u001b\u0010,\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010-J#\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020(2\b\b\u0002\u0010/\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u00100J%\u00101\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u00102\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020\u00182\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u00020\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lcom/microtech/aidexx/ota/OtaManager;", "", "()V", "hasDoNewSensor", "", "getHasDoNewSensor", "()Z", "setHasDoNewSensor", "(Z)V", "maxRetryTime", "", "otaProgressListener", "Lcom/microtech/aidexx/ota/OtaProgressListener;", "retryTimes", "buildWorkRequest", "Landroidx/work/OneTimeWorkRequest;", "mac", "", "filePath", "attempt", "delay", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;)Landroidx/work/OneTimeWorkRequest;", "checkIfNeedOta", "", "model", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/microtech/aidexx/ble/device/model/DeviceModel;Landroidx/lifecycle/LifecycleOwner;Lcom/microtech/aidexx/ota/OtaProgressListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOtaResource", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueueWork", "worker_first", "worker_second", "initOtaInfo", "sn", "appOldVersion", "isNeedDownLoad", "Lkotlin/Pair;", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "entity", "(Lcom/microtech/aidexx/db/entity/OtaResourceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "needCheckOtaVersion", "otaType", "(Lcom/microtech/aidexx/ble/device/model/DeviceModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOtaResource", "needCheckLocal", "(Lcom/microtech/aidexx/db/entity/OtaResourceEntity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultParam", "oldDpStr", "(Lcom/microtech/aidexx/ble/device/model/DeviceModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOtaInfo", "newOtaInfo", "Lcom/microtech/aidexx/common/net/entity/OtaInfo;", "uploadOtaInfo", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaManager.kt */
public final class OtaManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DP_OLD_HEX_STR_LEN = 168;
    /* access modifiers changed from: private */
    public static OtaManager INSTANCE = null;
    /* access modifiers changed from: private */
    public static final UUID OTA_CONTROL;
    public static final byte OTA_CONTROL_END_COMMAND = 3;
    public static final long OTA_CONTROL_END_DELAY = 500;
    public static final byte OTA_CONTROL_START_COMMAND = 0;
    public static final long OTA_CONTROL_START_DELAY = 200;
    /* access modifiers changed from: private */
    public static final UUID OTA_DATA;
    /* access modifiers changed from: private */
    public static final UUID OTA_SERVICE;
    /* access modifiers changed from: private */
    public static final String TAG = "OtaManager";
    /* access modifiers changed from: private */
    public static final String otaRootPath;
    private boolean hasDoNewSensor;
    private final int maxRetryTime;
    /* access modifiers changed from: private */
    public OtaProgressListener otaProgressListener;
    /* access modifiers changed from: private */
    public int retryTimes;

    public /* synthetic */ OtaManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OtaManager() {
        this.retryTimes = this.maxRetryTime;
    }

    public final boolean getHasDoNewSensor() {
        return this.hasDoNewSensor;
    }

    public final void setHasDoNewSensor(boolean z) {
        this.hasDoNewSensor = z;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/microtech/aidexx/ota/OtaManager$Companion;", "", "()V", "DP_OLD_HEX_STR_LEN", "", "INSTANCE", "Lcom/microtech/aidexx/ota/OtaManager;", "OTA_CONTROL", "Ljava/util/UUID;", "getOTA_CONTROL", "()Ljava/util/UUID;", "OTA_CONTROL_END_COMMAND", "", "OTA_CONTROL_END_DELAY", "", "OTA_CONTROL_START_COMMAND", "OTA_CONTROL_START_DELAY", "OTA_DATA", "getOTA_DATA", "OTA_SERVICE", "getOTA_SERVICE", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "otaRootPath", "getOtaRootPath", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OtaManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return OtaManager.TAG;
        }

        public final UUID getOTA_SERVICE() {
            return OtaManager.OTA_SERVICE;
        }

        public final UUID getOTA_CONTROL() {
            return OtaManager.OTA_CONTROL;
        }

        public final UUID getOTA_DATA() {
            return OtaManager.OTA_DATA;
        }

        public final String getOtaRootPath() {
            return OtaManager.otaRootPath;
        }

        public final OtaManager instance() {
            if (OtaManager.INSTANCE == null) {
                OtaManager.INSTANCE = new OtaManager((DefaultConstructorMarker) null);
            }
            OtaManager access$getINSTANCE$cp = OtaManager.INSTANCE;
            Intrinsics.checkNotNull(access$getINSTANCE$cp);
            return access$getINSTANCE$cp;
        }
    }

    static {
        String str = null;
        UUID fromString = UUID.fromString("1d14d6ee-fd63-4fa1-bfa4-8f47b42119f0");
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        OTA_SERVICE = fromString;
        UUID fromString2 = UUID.fromString("f7bf3564-fb6d-4e53-88a4-5e37e0326063");
        Intrinsics.checkNotNullExpressionValue(fromString2, "fromString(...)");
        OTA_CONTROL = fromString2;
        UUID fromString3 = UUID.fromString("984227f3-34fc-4045-a5d0-2c581f81a153");
        Intrinsics.checkNotNullExpressionValue(fromString3, "fromString(...)");
        OTA_DATA = fromString3;
        StringBuilder sb = new StringBuilder();
        File externalFilesDir = ExtendsKt.getContext().getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        otaRootPath = sb.append(str).append("/aidex/ota/").toString();
    }

    static /* synthetic */ OneTimeWorkRequest buildWorkRequest$default(OtaManager otaManager, String str, String str2, int i, Long l, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            l = null;
        }
        return otaManager.buildWorkRequest(str, str2, i, l);
    }

    private final OneTimeWorkRequest buildWorkRequest(String str, String str2, int i, Long l) {
        Data build = new Data.Builder().putInt(OtaWorkerKt.OTA_RECONNECTION_ATTEMPT, i).putString(OtaWorkerKt.OTA_UPLOAD_FILE_PATH, str2).putString(OtaWorkerKt.OTA_DEVICE_ADDRESS, str).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        OneTimeWorkRequest.Builder builder = (OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OtaWorker.class).setInputData(build)).addTag("OtaWorker");
        if (l != null) {
            builder.setInitialDelay(l.longValue(), TimeUnit.MILLISECONDS);
        }
        return (OneTimeWorkRequest) builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkIfNeedOta(com.microtech.aidexx.ble.device.model.DeviceModel r15, androidx.lifecycle.LifecycleOwner r16, com.microtech.aidexx.ota.OtaProgressListener r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r14 = this;
            r0 = r14
            r1 = r18
            boolean r2 = r1 instanceof com.microtech.aidexx.ota.OtaManager$checkIfNeedOta$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.microtech.aidexx.ota.OtaManager$checkIfNeedOta$1 r2 = (com.microtech.aidexx.ota.OtaManager$checkIfNeedOta$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001c
        L_0x0017:
            com.microtech.aidexx.ota.OtaManager$checkIfNeedOta$1 r2 = new com.microtech.aidexx.ota.OtaManager$checkIfNeedOta$1
            r2.<init>(r14, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x004c
            if (r4 != r5) goto L_0x0044
            java.lang.Object r3 = r2.L$3
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.L$2
            com.microtech.aidexx.ota.OtaProgressListener r4 = (com.microtech.aidexx.ota.OtaProgressListener) r4
            java.lang.Object r5 = r2.L$1
            androidx.lifecycle.LifecycleOwner r5 = (androidx.lifecycle.LifecycleOwner) r5
            java.lang.Object r2 = r2.L$0
            com.microtech.aidexx.ota.OtaManager r2 = (com.microtech.aidexx.ota.OtaManager) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r8 = r3
            r3 = r2
            r2 = r1
            r1 = r4
            r4 = r5
            goto L_0x00bf
        L_0x0044:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r1)
            com.microtech.aidexx.db.entity.TransmitterEntity r1 = r15.getEntity()
            java.lang.String r1 = r1.getDeviceMac()
            r4 = 2
            if (r1 == 0) goto L_0x00f1
            r7 = r1
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r8 = r7.length()
            if (r8 != 0) goto L_0x0064
            r7 = r6
        L_0x0064:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L_0x006a
            goto L_0x00f1
        L_0x006a:
            com.microtech.aidexx.db.entity.TransmitterEntity r7 = r15.getEntity()
            java.lang.String r7 = r7.getDeviceSn()
            com.microtech.aidexx.utils.mmkv.MmkvManager r8 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r8 = r8.getDidOtaSn()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x00a6
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "ota 检测 deviceSn="
            r2.<init>(r3)
            com.microtech.aidexx.db.entity.TransmitterEntity r3 = r15.getEntity()
            java.lang.String r3 = r3.getDeviceSn()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " 已经做过ota"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r1, r2, r6, r4, r6)
            r17.needNotOta()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00a6:
            r2.L$0 = r0
            r4 = r16
            r2.L$1 = r4
            r7 = r17
            r2.L$2 = r7
            r2.L$3 = r1
            r2.label = r5
            r5 = r15
            java.lang.Object r2 = r14.otaType(r15, r2)
            if (r2 != r3) goto L_0x00bc
            return r3
        L_0x00bc:
            r3 = r0
            r8 = r1
            r1 = r7
        L_0x00bf:
            r9 = r2
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x00e7
            r3.otaProgressListener = r1
            r12 = 8
            r13 = 0
            r10 = 0
            r11 = 0
            r7 = r3
            androidx.work.OneTimeWorkRequest r9 = buildWorkRequest$default(r7, r8, r9, r10, r11, r12, r13)
            r11 = 4
            r12 = 0
            r10 = 0
            r8 = r4
            enqueueWork$default(r7, r8, r9, r10, r11, r12)
            androidx.lifecycle.Lifecycle r2 = r4.getLifecycle()
            com.microtech.aidexx.ota.OtaManager$checkIfNeedOta$4$1 r4 = new com.microtech.aidexx.ota.OtaManager$checkIfNeedOta$4$1
            r4.<init>(r3)
            androidx.lifecycle.LifecycleObserver r4 = (androidx.lifecycle.LifecycleObserver) r4
            r2.addObserver(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x00e7:
            if (r6 != 0) goto L_0x00ee
            com.microtech.aidexx.ota.OtaManager r3 = (com.microtech.aidexx.ota.OtaManager) r3
            r1.needNotOta()
        L_0x00ee:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00f1:
            r7 = r17
            r2 = r0
            com.microtech.aidexx.ota.OtaManager r2 = (com.microtech.aidexx.ota.OtaManager) r2
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "ota 检测 deviceMac=="
            r3.<init>(r5)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r2, r1, r6, r4, r6)
            r17.needNotOta()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager.checkIfNeedOta(com.microtech.aidexx.ble.device.model.DeviceModel, androidx.lifecycle.LifecycleOwner, com.microtech.aidexx.ota.OtaProgressListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ void enqueueWork$default(OtaManager otaManager, LifecycleOwner lifecycleOwner, OneTimeWorkRequest oneTimeWorkRequest, OneTimeWorkRequest oneTimeWorkRequest2, int i, Object obj) {
        if ((i & 4) != 0) {
            oneTimeWorkRequest2 = null;
        }
        otaManager.enqueueWork(lifecycleOwner, oneTimeWorkRequest, oneTimeWorkRequest2);
    }

    private final void enqueueWork(LifecycleOwner lifecycleOwner, OneTimeWorkRequest oneTimeWorkRequest, OneTimeWorkRequest oneTimeWorkRequest2) {
        OtaProgressListener otaProgressListener2 = this.otaProgressListener;
        if (otaProgressListener2 != null) {
            otaProgressListener2.onStart();
        }
        WorkContinuation beginUniqueWork = WorkManager.getInstance(AidexxApp.Companion.getInstance()).beginUniqueWork("OtaWorker", ExistingWorkPolicy.REPLACE, oneTimeWorkRequest);
        Intrinsics.checkNotNullExpressionValue(beginUniqueWork, "beginUniqueWork(...)");
        LiveData<WorkInfo> workInfoByIdLiveData = WorkManager.getInstance(AidexxApp.Companion.getInstance()).getWorkInfoByIdLiveData(oneTimeWorkRequest.getId());
        Intrinsics.checkNotNullExpressionValue(workInfoByIdLiveData, "getWorkInfoByIdLiveData(...)");
        workInfoByIdLiveData.observe(lifecycleOwner, new OtaManagerKt$sam$androidx_lifecycle_Observer$0(new OtaManager$enqueueWork$1(oneTimeWorkRequest2, this, lifecycleOwner, oneTimeWorkRequest)));
        beginUniqueWork.enqueue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object otaType(com.microtech.aidexx.ble.device.model.DeviceModel r11, kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.microtech.aidexx.ota.OtaManager$otaType$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.microtech.aidexx.ota.OtaManager$otaType$1 r0 = (com.microtech.aidexx.ota.OtaManager$otaType$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ota.OtaManager$otaType$1 r0 = new com.microtech.aidexx.ota.OtaManager$otaType$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            java.lang.String r4 = "TAG"
            r5 = 0
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r11 = r0.L$2
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r1 = r0.L$1
            com.microtech.aidexx.db.entity.TransmitterEntity r1 = (com.microtech.aidexx.db.entity.TransmitterEntity) r1
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00b4
        L_0x003a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$BooleanRef r12 = new kotlin.jvm.internal.Ref$BooleanRef
            r12.<init>()
            com.microtech.aidexx.db.entity.TransmitterEntity r11 = r11.getEntity()
            com.microtech.aidexx.utils.StringUtils r2 = com.microtech.aidexx.utils.StringUtils.INSTANCE
            java.lang.String r6 = r11.getVersion()
            java.lang.String r7 = "0"
            if (r6 != 0) goto L_0x0059
            r6 = r7
        L_0x0059:
            java.lang.String r8 = "1.2.0"
            boolean r2 = r2.versionCompare(r8, r6)
            if (r2 != 0) goto L_0x0095
            java.lang.String r2 = r11.getVersion()
            if (r2 != 0) goto L_0x0068
            goto L_0x0069
        L_0x0068:
            r7 = r2
        L_0x0069:
            r2 = 0
            r6 = 2
            boolean r2 = kotlin.text.StringsKt.startsWith$default(r7, r8, r2, r6, r5)
            if (r2 != 0) goto L_0x0095
            com.microtech.aidexx.utils.LogUtil$Companion r12 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "发射器版本="
            r0.<init>(r1)
            java.lang.String r11 = r11.getVersion()
            java.lang.StringBuilder r11 = r0.append(r11)
            java.lang.String r0 = " 不支持OTA"
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            r12.xLogE(r11, r0)
            return r5
        L_0x0095:
            java.lang.String r2 = r11.getDeviceModelName()
            com.microtech.aidexx.db.repository.OtaDbRepository r6 = new com.microtech.aidexx.db.repository.OtaDbRepository
            r6.<init>()
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r2
            r0.label = r3
            java.lang.String r3 = "X"
            java.lang.Object r0 = r6.queryOtaResource(r2, r3, r0)
            if (r0 != r1) goto L_0x00af
            return r1
        L_0x00af:
            r1 = r11
            r11 = r2
            r9 = r0
            r0 = r12
            r12 = r9
        L_0x00b4:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x017a
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            com.microtech.aidexx.ota.OtaManager$otaType$2$1$1 r2 = com.microtech.aidexx.ota.OtaManager$otaType$2$1$1.INSTANCE
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            com.microtech.aidexx.ota.OtaManager$$ExternalSyntheticLambda0 r3 = new com.microtech.aidexx.ota.OtaManager$$ExternalSyntheticLambda0
            r3.<init>(r2)
            java.util.List r12 = kotlin.collections.CollectionsKt.sortedWith(r12, r3)
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r2 = r12.isEmpty()
            if (r2 == 0) goto L_0x00d0
            r12 = r5
        L_0x00d0:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x017a
            java.lang.Object r12 = kotlin.collections.CollectionsKt.last(r12)
            com.microtech.aidexx.db.entity.OtaResourceEntity r12 = (com.microtech.aidexx.db.entity.OtaResourceEntity) r12
            if (r12 == 0) goto L_0x017a
            com.microtech.aidexx.utils.StringUtils r2 = com.microtech.aidexx.utils.StringUtils.INSTANCE
            java.lang.String r3 = r1.getVersion()
            java.lang.String r6 = r12.getVersion()
            boolean r2 = r2.versionCompare(r3, r6)
            r0.element = r2
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r6 = "ifAppNeedUpdate:"
            r3.<init>(r6)
            boolean r6 = r0.element
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r6 = ", name:"
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.StringBuilder r11 = r3.append(r11)
            java.lang.String r3 = ", deviceVersion:"
            java.lang.StringBuilder r11 = r11.append(r3)
            java.lang.String r1 = r1.getVersion()
            java.lang.StringBuilder r11 = r11.append(r1)
            java.lang.String r1 = ", dbFileVersion:"
            java.lang.StringBuilder r11 = r11.append(r1)
            java.lang.String r1 = r12.getVersion()
            java.lang.StringBuilder r11 = r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.String r1 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r2.xLogE(r11, r1)
            boolean r11 = r0.element
            if (r11 == 0) goto L_0x017a
            java.lang.String r11 = r12.getLocalFilePath()
            if (r11 == 0) goto L_0x016d
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            int r12 = r11.length()
            if (r12 != 0) goto L_0x0140
            r11 = r5
        L_0x0140:
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x016d
            com.microtech.aidexx.utils.FileUtils r12 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r12 = r12.isFileExists((java.lang.String) r11)
            if (r12 == 0) goto L_0x014d
            return r11
        L_0x014d:
            com.microtech.aidexx.utils.LogUtil$Companion r12 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "otaResource file path="
            r0.<init>(r2)
            java.lang.StringBuilder r11 = r0.append(r11)
            java.lang.String r0 = " but not exists"
            java.lang.StringBuilder r11 = r11.append(r0)
            java.lang.String r11 = r11.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r12.xLogE(r11, r1)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            goto L_0x016e
        L_0x016d:
            r11 = r5
        L_0x016e:
            if (r11 != 0) goto L_0x017a
            com.microtech.aidexx.utils.LogUtil$Companion r11 = com.microtech.aidexx.utils.LogUtil.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            java.lang.String r12 = "otaResource file path is empty"
            r11.xLogE(r12, r1)
        L_0x017a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager.otaType(com.microtech.aidexx.ble.device.model.DeviceModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final int otaType$lambda$10$lambda$9$lambda$4(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public final Object checkOtaResource(Continuation<? super Unit> continuation) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new OtaManager$checkOtaResource$2(this, (Continuation<? super OtaManager$checkOtaResource$2>) null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e1, code lost:
        if (r4 == null) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object isNeedDownLoad(com.microtech.aidexx.db.entity.OtaResourceEntity r8, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, com.microtech.aidexx.db.entity.OtaResourceEntity>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.microtech.aidexx.ota.OtaManager$isNeedDownLoad$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.microtech.aidexx.ota.OtaManager$isNeedDownLoad$1 r0 = (com.microtech.aidexx.ota.OtaManager$isNeedDownLoad$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ota.OtaManager$isNeedDownLoad$1 r0 = new com.microtech.aidexx.ota.OtaManager$isNeedDownLoad$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r8 = r0.L$1
            com.microtech.aidexx.db.entity.OtaResourceEntity r8 = (com.microtech.aidexx.db.entity.OtaResourceEntity) r8
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.ota.OtaManager r0 = (com.microtech.aidexx.ota.OtaManager) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0054
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.microtech.aidexx.db.repository.OtaDbRepository r9 = new com.microtech.aidexx.db.repository.OtaDbRepository
            r9.<init>()
            java.lang.String r2 = r8.genEntityKey()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.queryOtaResourceByKey(r2, r0)
            if (r9 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r7
        L_0x0054:
            com.microtech.aidexx.db.entity.OtaResourceEntity r9 = (com.microtech.aidexx.db.entity.OtaResourceEntity) r9
            r1 = 0
            java.lang.String r2 = "TAG"
            if (r9 == 0) goto L_0x0111
            java.lang.String r4 = r9.getLocalFilePath()
            if (r4 == 0) goto L_0x00e3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r5 = r4.length()
            if (r5 != 0) goto L_0x006a
            r4 = r1
        L_0x006a:
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00e3
            com.microtech.aidexx.utils.FileUtils r5 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r4 = r5.isFileExists((java.lang.String) r4)
            if (r4 != 0) goto L_0x009c
            com.microtech.aidexx.utils.LogUtil$Companion r4 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r6 = ", need download localFilePath not exists"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r4.xLogE(r5, r6)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r9)
            goto L_0x00e1
        L_0x009c:
            java.lang.String r4 = r9.getSha256()
            java.lang.String r5 = r8.getSha256()
            boolean r4 = kotlin.text.StringsKt.equals(r4, r5, r3)
            if (r4 != 0) goto L_0x00d8
            com.microtech.aidexx.utils.LogUtil$Companion r4 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r6 = ", need download local-sha256:"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = r9.getSha256()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r4.xLogE(r5, r6)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r9)
            goto L_0x00e1
        L_0x00d8:
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r9)
        L_0x00e1:
            if (r4 != 0) goto L_0x010f
        L_0x00e3:
            r4 = r0
            com.microtech.aidexx.ota.OtaManager r4 = (com.microtech.aidexx.ota.OtaManager) r4
            com.microtech.aidexx.utils.LogUtil$Companion r4 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r6 = ", localFilePath = null need download dbEntity="
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r4.xLogE(r5, r6)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r9)
        L_0x010f:
            if (r4 != 0) goto L_0x013a
        L_0x0111:
            com.microtech.aidexx.ota.OtaManager r0 = (com.microtech.aidexx.ota.OtaManager) r0
            com.microtech.aidexx.utils.LogUtil$Companion r9 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "local resource "
            r0.<init>(r4)
            java.lang.StringBuilder r8 = r0.append(r8)
            java.lang.String r0 = " not exist"
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.String r0 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r9.xLogE(r8, r0)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r8, r1)
        L_0x013a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager.isNeedDownLoad(com.microtech.aidexx.db.entity.OtaResourceEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveOtaResource(com.microtech.aidexx.db.entity.OtaResourceEntity r6, boolean r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.ota.OtaManager$saveOtaResource$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.ota.OtaManager$saveOtaResource$1 r0 = (com.microtech.aidexx.ota.OtaManager$saveOtaResource$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ota.OtaManager$saveOtaResource$1 r0 = new com.microtech.aidexx.ota.OtaManager$saveOtaResource$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0072
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$0
            com.microtech.aidexx.db.entity.OtaResourceEntity r6 = (com.microtech.aidexx.db.entity.OtaResourceEntity) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r7 == 0) goto L_0x0061
            com.microtech.aidexx.db.repository.OtaDbRepository r7 = new com.microtech.aidexx.db.repository.OtaDbRepository
            r7.<init>()
            java.lang.String r8 = r6.genEntityKey()
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r7.queryOtaResourceByKey(r8, r0)
            if (r8 != r1) goto L_0x0056
            return r1
        L_0x0056:
            com.microtech.aidexx.db.entity.OtaResourceEntity r8 = (com.microtech.aidexx.db.entity.OtaResourceEntity) r8
            if (r8 == 0) goto L_0x0061
            java.lang.String r7 = r8.getLocalFilePath()
            r6.setLocalFilePath(r7)
        L_0x0061:
            com.microtech.aidexx.db.repository.OtaDbRepository r7 = new com.microtech.aidexx.db.repository.OtaDbRepository
            r7.<init>()
            r8 = 0
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r6 = r7.insertOrUpdate(r6, r0)
            if (r6 != r1) goto L_0x0072
            return r1
        L_0x0072:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager.saveOtaResource(com.microtech.aidexx.db.entity.OtaResourceEntity, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object saveOtaResource$default(OtaManager otaManager, OtaResourceEntity otaResourceEntity, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return otaManager.saveOtaResource(otaResourceEntity, z, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setDefaultParam(com.microtech.aidexx.ble.device.model.DeviceModel r32, java.lang.String r33, kotlin.coroutines.Continuation<? super java.lang.String> r34) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r34
            boolean r3 = r2 instanceof com.microtech.aidexx.ota.OtaManager$setDefaultParam$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.microtech.aidexx.ota.OtaManager$setDefaultParam$1 r3 = (com.microtech.aidexx.ota.OtaManager$setDefaultParam$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.microtech.aidexx.ota.OtaManager$setDefaultParam$1 r3 = new com.microtech.aidexx.ota.OtaManager$setDefaultParam$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0047
            if (r5 != r7) goto L_0x003f
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r4 = r3.L$1
            com.microtech.aidexx.ble.device.model.DeviceModel r4 = (com.microtech.aidexx.ble.device.model.DeviceModel) r4
            java.lang.Object r3 = r3.L$0
            com.microtech.aidexx.ota.OtaManager r3 = (com.microtech.aidexx.ota.OtaManager) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r9 = r1
            r1 = r4
            goto L_0x009e
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 == 0) goto L_0x01e4
            com.microtech.aidexx.db.entity.TransmitterEntity r2 = r32.getEntity()
            java.lang.String r2 = r2.getVersion()
            if (r2 == 0) goto L_0x01e4
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = kotlin.text.StringsKt.getLastIndex(r5)
        L_0x005d:
            r8 = -1
            if (r8 >= r5) goto L_0x0077
            char r8 = r2.charAt(r5)
            r9 = 46
            if (r8 == r9) goto L_0x006b
            int r5 = r5 + -1
            goto L_0x005d
        L_0x006b:
            r8 = 0
            int r5 = r5 + r7
            java.lang.String r2 = r2.substring(r8, r5)
            java.lang.String r5 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            goto L_0x0079
        L_0x0077:
            java.lang.String r2 = ""
        L_0x0079:
            java.lang.String r2 = kotlin.text.StringsKt.dropLast((java.lang.String) r2, (int) r7)
            com.microtech.aidexx.db.repository.OtaDbRepository r5 = new com.microtech.aidexx.db.repository.OtaDbRepository
            r5.<init>()
            com.microtech.aidexx.db.entity.TransmitterEntity r8 = r32.getEntity()
            java.lang.String r8 = r8.getDeviceModelName()
            r3.L$0 = r0
            r3.L$1 = r1
            r9 = r33
            r3.L$2 = r9
            r3.label = r7
            java.lang.String r10 = "X"
            java.lang.Object r2 = r5.queryOtaResourceByVersion(r8, r10, r2, r3)
            if (r2 != r4) goto L_0x009d
            return r4
        L_0x009d:
            r3 = r0
        L_0x009e:
            com.microtech.aidexx.db.entity.OtaResourceEntity r2 = (com.microtech.aidexx.db.entity.OtaResourceEntity) r2
            if (r2 == 0) goto L_0x01e4
            java.lang.String r4 = r2.getSettingContent()
            java.lang.String r5 = r2.getSettingVersion()
            com.microtech.aidexx.utils.LogUtil$Companion r8 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "setDefaultParam otaRes="
            r10.<init>(r11)
            java.lang.StringBuilder r2 = r10.append(r2)
            java.lang.String r10 = " oldV="
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.StringBuilder r2 = r2.append(r9)
            java.lang.String r10 = " newV="
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            r5 = 2
            com.microtech.aidexx.utils.LogUtil.Companion.xLogI$default(r8, r2, r6, r5, r6)
            if (r4 == 0) goto L_0x01e4
            java.lang.String r2 = kotlin.text.StringsKt.dropLast((java.lang.String) r4, (int) r5)
            r8 = 8
            java.lang.String r10 = kotlin.text.StringsKt.dropLast((java.lang.String) r4, (int) r8)
            java.lang.String r4 = kotlin.text.StringsKt.takeLast((java.lang.String) r4, (int) r5)
            com.microtech.aidexx.utils.StringUtils r11 = com.microtech.aidexx.utils.StringUtils.INSTANCE
            byte[] r2 = r11.hexStringToByteArray(r2)
            int r2 = com.microtechmd.blecomm.parser.AidexXParser.getCrc8(r2)
            java.lang.String r11 = kotlin.text.HexExtensionsKt.toHexString$default((int) r2, (kotlin.text.HexFormat) r6, (int) r7, (java.lang.Object) r6)
            java.lang.String r11 = kotlin.text.StringsKt.takeLast((java.lang.String) r11, (int) r5)
            com.microtech.aidexx.utils.LogUtil$Companion r12 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "localCrc8Int="
            r13.<init>(r14)
            java.lang.StringBuilder r2 = r13.append(r2)
            java.lang.String r13 = ", localCrc8HexStr="
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r2 = r2.toString()
            java.lang.String r13 = TAG
            java.lang.String r14 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            r12.xLogI(r2, r13)
            boolean r2 = kotlin.text.StringsKt.equals(r11, r4, r7)
            if (r2 == 0) goto L_0x01da
            int r2 = r9.length()
            r4 = 168(0xa8, float:2.35E-43)
            if (r2 != r4) goto L_0x0130
            kotlin.ranges.IntRange r2 = new kotlin.ranges.IntRange
            r4 = 15
            r2.<init>(r8, r4)
            goto L_0x0139
        L_0x0130:
            kotlin.ranges.IntRange r2 = new kotlin.ranges.IntRange
            r4 = 16
            r11 = 23
            r2.<init>(r4, r11)
        L_0x0139:
            java.lang.String r4 = kotlin.text.StringsKt.substring((java.lang.String) r9, (kotlin.ranges.IntRange) r2)
            com.microtech.aidexx.utils.LogUtil$Companion r11 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r15 = "setDefaultParam noChangeParamRange="
            r12.<init>(r15)
            java.lang.StringBuilder r12 = r12.append(r2)
            java.lang.String r15 = " oldParams="
            java.lang.StringBuilder r12 = r12.append(r15)
            java.lang.StringBuilder r12 = r12.append(r4)
            java.lang.String r12 = r12.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogI$default(r11, r12, r6, r5, r6)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r2 = kotlin.text.StringsKt.replaceRange((java.lang.CharSequence) r10, (kotlin.ranges.IntRange) r2, (java.lang.CharSequence) r4)
            java.lang.String r2 = r2.toString()
            boolean r4 = kotlin.text.StringsKt.equals(r2, r9, r7)
            if (r4 != 0) goto L_0x01cf
            com.microtech.aidexx.utils.LogUtil$Companion r4 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "ready to write newDpStr="
            r5.<init>(r6)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            r4.xLogI(r5, r13)
            com.microtech.aidexx.utils.StringUtils r4 = com.microtech.aidexx.utils.StringUtils.INSTANCE
            byte[] r4 = r4.hexStringToByteArray(r2)
            com.microtech.aidexx.common.net.entity.OtaInfo r5 = new com.microtech.aidexx.common.net.entity.OtaInfo
            r10 = r5
            r29 = 262143(0x3ffff, float:3.6734E-40)
            r30 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            r5.setNeedDpu(r6)
            java.lang.String r6 = kotlin.text.StringsKt.take((java.lang.String) r9, (int) r8)
            r5.setDpOldVersion(r6)
            r3.updateOtaInfo(r5)
            com.microtechmd.blecomm.controller.BleControllerProxy r1 = r1.getController()
            if (r1 == 0) goto L_0x01ce
            r1.setDefaultParamByteArray(r4)
        L_0x01ce:
            return r2
        L_0x01cf:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.String r2 = "no need to write dp"
            r1.xLogE(r2, r13)
            goto L_0x01e4
        L_0x01da:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.String r2 = "setDefaultParam fail online crc8 not match"
            r1.xLogE(r2, r13)
        L_0x01e4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ota.OtaManager.setDefaultParam(com.microtech.aidexx.ble.device.model.DeviceModel, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void initOtaInfo(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "sn");
        Intrinsics.checkNotNullParameter(str4, "appOldVersion");
        CharSequence otaInfo = MmkvManager.INSTANCE.getOtaInfo();
        OtaInfo otaInfo2 = null;
        if (otaInfo.length() == 0) {
            otaInfo = null;
        }
        String str5 = (String) otaInfo;
        if (str5 != null) {
            OtaInfo otaInfo3 = (OtaInfo) new Gson().fromJson(str5, OtaInfo.class);
            if (Intrinsics.areEqual((Object) otaInfo3.getSn(), (Object) str3)) {
                otaInfo2 = otaInfo3;
            }
            if (otaInfo2 != null) {
                return;
            }
        }
        OtaManager otaManager = this;
        OtaInfo otaInfo4 = new OtaInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
        otaInfo4.setSn(str3);
        otaInfo4.setNeedOta(false);
        otaInfo4.setNeedDpu(false);
        otaInfo4.setAppOldVersion(str4);
        otaInfo4.setAidexVersion(OtaManagerKt.AIDEX_VERSION);
        otaInfo4.setAppTime(ExtendsKt.formatWithoutZone(new Date()));
        otaInfo4.setAppTimeZone(TimeZone.getDefault().getID());
        otaInfo4.setBootOldVersion(MmkvManager.INSTANCE.getBootVer());
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        String json = new Gson().toJson((Object) otaInfo4);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        mmkvManager.setOtaInfo(json);
        Unit unit = Unit.INSTANCE;
    }

    public final void updateOtaInfo(OtaInfo otaInfo) {
        Intrinsics.checkNotNullParameter(otaInfo, "newOtaInfo");
        CharSequence otaInfo2 = MmkvManager.INSTANCE.getOtaInfo();
        OtaInfo otaInfo3 = null;
        if (otaInfo2.length() == 0) {
            otaInfo2 = null;
        }
        String str = (String) otaInfo2;
        if (str != null) {
            OtaInfo otaInfo4 = (OtaInfo) new Gson().fromJson(str, OtaInfo.class);
            otaInfo3 = (otaInfo.getSn() == null || Intrinsics.areEqual((Object) otaInfo4.getSn(), (Object) otaInfo.getSn())) ? otaInfo4 : new OtaInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
        }
        if (otaInfo3 == null) {
            otaInfo3 = new OtaInfo((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 262143, (DefaultConstructorMarker) null);
        }
        Boolean needOta = otaInfo.getNeedOta();
        if (needOta != null) {
            otaInfo3.setNeedOta(Boolean.valueOf(needOta.booleanValue()));
        }
        Boolean needDpu = otaInfo.getNeedDpu();
        if (needDpu != null) {
            otaInfo3.setNeedDpu(Boolean.valueOf(needDpu.booleanValue()));
        }
        Boolean otaWriteRet = otaInfo.getOtaWriteRet();
        if (otaWriteRet != null) {
            otaInfo3.setOtaWriteRet(Boolean.valueOf(otaWriteRet.booleanValue()));
        }
        String appNewVersion = otaInfo.getAppNewVersion();
        if (appNewVersion != null) {
            otaInfo3.setAppNewVersion(appNewVersion);
        }
        String bootNewVersion = otaInfo.getBootNewVersion();
        if (bootNewVersion != null) {
            otaInfo3.setBootNewVersion(bootNewVersion);
        }
        String dpOldVersion = otaInfo.getDpOldVersion();
        if (dpOldVersion != null) {
            otaInfo3.setDpOldVersion(dpOldVersion);
        }
        String dpNewVersion = otaInfo.getDpNewVersion();
        if (dpNewVersion != null) {
            otaInfo3.setDpNewVersion(dpNewVersion);
        }
        Boolean canUpload = otaInfo.getCanUpload();
        if (canUpload != null) {
            otaInfo3.setCanUpload(Boolean.valueOf(canUpload.booleanValue()));
        }
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        String json = new Gson().toJson((Object) otaInfo3);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        mmkvManager.setOtaInfo(json);
    }

    public final boolean needCheckOtaVersion() {
        Object obj;
        CharSequence bootNewVersion;
        TransmitterEntity entity;
        CharSequence otaInfo = MmkvManager.INSTANCE.getOtaInfo();
        String str = null;
        if (otaInfo.length() == 0) {
            otaInfo = null;
        }
        String str2 = (String) otaInfo;
        if (str2 == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            String str3 = TAG;
            Intrinsics.checkNotNullExpressionValue(str3, "TAG");
            LogUtil.Companion.xLogI("needCheckOtaVersion " + str2, str3);
            obj = Result.m343constructorimpl((OtaInfo) new Gson().fromJson(str2, OtaInfo.class));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m343constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m349isFailureimpl(obj)) {
            obj = null;
        }
        OtaInfo otaInfo2 = (OtaInfo) obj;
        if (otaInfo2 == null) {
            return false;
        }
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        String sn = otaInfo2.getSn();
        if (!(deviceModel == null || (entity = deviceModel.getEntity()) == null)) {
            str = entity.getDeviceSn();
        }
        if (!Intrinsics.areEqual((Object) sn, (Object) str) || !Intrinsics.areEqual((Object) otaInfo2.getNeedOta(), (Object) true)) {
            return false;
        }
        CharSequence appNewVersion = otaInfo2.getAppNewVersion();
        if (appNewVersion == null || appNewVersion.length() == 0 || (bootNewVersion = otaInfo2.getBootNewVersion()) == null || bootNewVersion.length() == 0) {
            return true;
        }
        return false;
    }

    public final void uploadOtaInfo() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new OtaManager$uploadOtaInfo$1((Continuation<? super OtaManager$uploadOtaInfo$1>) null), 3, (Object) null);
    }
}
