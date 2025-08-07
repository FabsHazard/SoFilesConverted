package com.microtech.aidexx.data.resource;

import android.os.Environment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microtech.aidexx.common.net.entity.VersionData;
import com.microtech.aidexx.common.net.entity.VersionInfo;
import com.microtech.aidexx.db.entity.event.preset.BaseSysPreset;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity;
import com.microtech.aidexx.utils.FileUtils;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.blankj.ResourceUtils;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002JA\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u0010\u0010$\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ%\u0010$\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010&J!\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010+J#\u0010,\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010&J#\u0010.\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010&JC\u0010/\u001a\u00020\u0016\"\b\b\u0000\u00100*\u0002012\u0006\u0010(\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H00 H@ø\u0001\u0000¢\u0006\u0002\u00103J#\u00104\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0011\u00105\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u00106R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lcom/microtech/aidexx/data/resource/LocalResourceManager;", "", "()V", "ASSETS_RESOURCE_FILE", "", "FILE_EXERCISE_SYS", "FILE_FOOD_SYS", "FILE_INSULIN_SYS", "FILE_LANGUAGE", "FILE_LANGUAGE_CONF", "FILE_MEDICATION_SYS", "FILE_OTHER_SYS", "FILE_UNIT", "FILE_VERSION_MENU", "TAG", "kotlin.jvm.PlatformType", "UNZIP_DIR_NAME", "UNZIP_RESOURCE_DIR_PREFIX", "ZIP_PASSWORD", "syncExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "upgrading", "", "downloadSuccess", "", "upInfo", "Lcom/microtech/aidexx/common/net/entity/VersionInfo;", "zipFilePath", "readJsonFileToObj", "R", "jsonFilePath", "clazz", "Ljava/lang/Class;", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "(Ljava/lang/String;Ljava/lang/Class;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;", "startUpgrade", "version", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventSysPreset", "unzipPath", "versionMenu", "Lcom/microtech/aidexx/data/resource/VersionMenu;", "(Ljava/lang/String;Lcom/microtech/aidexx/data/resource/VersionMenu;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLanguage", "newVersion", "updateLanguageConf", "updatePreset", "T", "Lcom/microtech/aidexx/db/entity/event/preset/BaseSysPreset;", "fileName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUnit", "upgradeFromAssets", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocalResourceManager.kt */
public final class LocalResourceManager {
    private static final String ASSETS_RESOURCE_FILE = "resource_1.7.1.zip";
    private static final String FILE_EXERCISE_SYS = "exercise_sys.json";
    private static final String FILE_FOOD_SYS = "food_sys.json";
    private static final String FILE_INSULIN_SYS = "insulin_sys.json";
    private static final String FILE_LANGUAGE = "language.json";
    private static final String FILE_LANGUAGE_CONF = "language_conf.json";
    private static final String FILE_MEDICATION_SYS = "medication_sys.json";
    private static final String FILE_OTHER_SYS = "other_sys.json";
    private static final String FILE_UNIT = "unit.json";
    private static final String FILE_VERSION_MENU = "version_menu.json";
    public static final LocalResourceManager INSTANCE = new LocalResourceManager();
    /* access modifiers changed from: private */
    public static final String TAG = "LocalResourceManager";
    private static final String UNZIP_DIR_NAME = "downloads";
    private static final String UNZIP_RESOURCE_DIR_PREFIX = "downloads/resource_";
    private static final String ZIP_PASSWORD = "weitai2020!";
    private static final CoroutineExceptionHandler syncExceptionHandler = new LocalResourceManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    /* access modifiers changed from: private */
    public static boolean upgrading;

    private LocalResourceManager() {
    }

    public final void startUpgrade(VersionInfo versionInfo) {
        if (upgrading) {
            LogUtil.Companion companion = LogUtil.Companion;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            companion.xLogE("启动资源升级-false", str);
            return;
        }
        upgrading = true;
        LogUtil.Companion companion2 = LogUtil.Companion;
        String str2 = TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
        companion2.xLogE("启动资源升级", str2);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LocalResourceManagerKt.resourceUpgradeScope, syncExceptionHandler, (CoroutineStart) null, new LocalResourceManager$startUpgrade$1(versionInfo, (Continuation<? super LocalResourceManager$startUpgrade$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void downloadSuccess(VersionInfo versionInfo, String str) {
        VersionInfo versionInfo2 = new VersionInfo();
        versionInfo2.setInfo(versionInfo.getInfo());
        VersionData info = versionInfo2.getInfo();
        if (info != null) {
            info.setDownloadpath(str);
        }
        versionInfo2.setForce(versionInfo.isForce());
        String json = new Gson().toJson((Object) versionInfo2);
        String str2 = TAG;
        Intrinsics.checkNotNullExpressionValue(str2, "TAG");
        LogUtil.Companion.d("upgradeInfo=" + json, str2);
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        Intrinsics.checkNotNull(json);
        mmkvManager.setUpgradeResourceZipFileInfo(json);
    }

    public final Object upgradeFromAssets(Continuation<? super Unit> continuation) {
        if (!Intrinsics.areEqual((Object) Environment.getExternalStorageState(), (Object) "mounted")) {
            LogUtil.Companion companion = LogUtil.Companion;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            companion.xLogE("resource upgrade fail no sdcard", str);
            return Unit.INSTANCE;
        }
        String downloadDir = FileUtils.INSTANCE.getDownloadDir(UNZIP_DIR_NAME);
        String str2 = downloadDir + (!FileUtils.INSTANCE.delete(new StringBuilder().append(downloadDir).append(ASSETS_RESOURCE_FILE).toString()) ? "resource_1.7.1_" + System.currentTimeMillis() + ".zip" : ASSETS_RESOURCE_FILE);
        if (ResourceUtils.INSTANCE.copyFileFromAssets(ASSETS_RESOURCE_FILE, str2)) {
            Object startUpgrade = startUpgrade(str2, "1.7.1", continuation);
            return startUpgrade == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? startUpgrade : Unit.INSTANCE;
        }
        LogUtil.Companion companion2 = LogUtil.Companion;
        String str3 = TAG;
        Intrinsics.checkNotNullExpressionValue(str3, "TAG");
        companion2.xLogE("内置资源包释放失败", str3);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object startUpgrade(java.lang.String r23, java.lang.String r24, kotlin.coroutines.Continuation<? super kotlin.Unit> r25) {
        /*
            r22 = this;
            r1 = r22
            r8 = r23
            r3 = r24
            r0 = r25
            boolean r2 = r0 instanceof com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$2
            if (r2 == 0) goto L_0x001c
            r2 = r0
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$2 r2 = (com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$2) r2
            int r4 = r2.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001c
            int r0 = r2.label
            int r0 = r0 - r5
            r2.label = r0
            goto L_0x0021
        L_0x001c:
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$2 r2 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$2
            r2.<init>(r1, r0)
        L_0x0021:
            r9 = r2
            java.lang.Object r0 = r9.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            r11 = 4
            r12 = 0
            r13 = 2
            r14 = 1
            r15 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 != r14) goto L_0x0040
            java.lang.Object r2 = r9.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r9.L$0
            java.lang.String r3 = (java.lang.String) r3
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x011f
        L_0x0040:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r0)
            if (r8 == 0) goto L_0x0136
            if (r3 != 0) goto L_0x0051
            goto L_0x0136
        L_0x0051:
            com.microtech.aidexx.utils.FileUtils r0 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "downloads/resource_"
            r2.<init>(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r7 = r0.getDownloadDir(r2)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0090 }
            r0 = r1
            com.microtech.aidexx.data.resource.LocalResourceManager r0 = (com.microtech.aidexx.data.resource.LocalResourceManager) r0     // Catch:{ all -> 0x0090 }
            net.lingala.zip4j.ZipFile r0 = new net.lingala.zip4j.ZipFile     // Catch:{ all -> 0x0090 }
            r0.<init>((java.lang.String) r8)     // Catch:{ all -> 0x0090 }
            r2 = r0
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0090 }
            r0 = r2
            net.lingala.zip4j.ZipFile r0 = (net.lingala.zip4j.ZipFile) r0     // Catch:{ all -> 0x0087 }
            r0.extractAll(r7)     // Catch:{ all -> 0x0087 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0087 }
            kotlin.io.CloseableKt.closeFinally(r2, r15)     // Catch:{ all -> 0x0090 }
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = kotlin.Result.m343constructorimpl(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x009b
        L_0x0087:
            r0 = move-exception
            r4 = r0
            throw r4     // Catch:{ all -> 0x008a }
        L_0x008a:
            r0 = move-exception
            r5 = r0
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0090 }
            throw r5     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m343constructorimpl(r0)
        L_0x009b:
            java.lang.Throwable r0 = kotlin.Result.m346exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x00c9
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "资源文件解压失败 v="
            r4.<init>(r5)
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r5 = " e="
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r2, r0, r15, r13, r15)
            startUpgrade$upgradeFinish$default(r7, r8, r12, r11, r15)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            goto L_0x00ca
        L_0x00c9:
            r0 = r15
        L_0x00ca:
            if (r0 != 0) goto L_0x0133
            r0 = r1
            com.microtech.aidexx.data.resource.LocalResourceManager r0 = (com.microtech.aidexx.data.resource.LocalResourceManager) r0
            com.microtech.aidexx.data.resource.LocalResourceManager r16 = INSTANCE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r2 = "version_menu.json"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r17 = r0.toString()
            java.lang.Class<com.microtech.aidexx.data.resource.VersionMenu> r18 = com.microtech.aidexx.data.resource.VersionMenu.class
            r20 = 4
            r21 = 0
            r19 = 0
            java.lang.Object r0 = readJsonFileToObj$default(r16, r17, r18, r19, r20, r21)
            r5 = r0
            com.microtech.aidexx.data.resource.VersionMenu r5 = (com.microtech.aidexx.data.resource.VersionMenu) r5
            if (r5 == 0) goto L_0x0123
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1 r16 = new com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1
            r17 = 0
            r2 = r16
            r3 = r24
            r4 = r7
            r6 = r23
            r11 = r7
            r7 = r17
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = r16
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r9.L$0 = r8
            r9.L$1 = r11
            r9.label = r14
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r9)
            if (r0 != r10) goto L_0x011d
            return r10
        L_0x011d:
            r3 = r8
            r2 = r11
        L_0x011f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r7 = r2
            goto L_0x0126
        L_0x0123:
            r11 = r7
            r3 = r8
            r0 = r15
        L_0x0126:
            if (r0 != 0) goto L_0x0133
            com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "版本文件解析失败"
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r0, r2, r15, r13, r15)
            r2 = 4
            startUpgrade$upgradeFinish$default(r7, r3, r12, r2, r15)
        L_0x0133:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0136:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager.startUpgrade(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ void startUpgrade$upgradeFinish$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        startUpgrade$upgradeFinish(str, str2, z);
    }

    /* access modifiers changed from: private */
    public static final void startUpgrade$upgradeFinish(String str, String str2, boolean z) {
        MmkvManager.INSTANCE.setUpgradeResourceZipFileInfo("");
        boolean delete = FileUtils.INSTANCE.delete(str);
        boolean delete2 = FileUtils.INSTANCE.delete(str2);
        LogUtil.Companion companion = LogUtil.Companion;
        String str3 = "资源升级结果 isSuccess=" + z + " unzipFileDeleteRet=" + delete + ", zipFileDeleteRet=" + delete2;
        String str4 = TAG;
        Intrinsics.checkNotNullExpressionValue(str4, "TAG");
        companion.xLogI(str3, str4);
    }

    /* access modifiers changed from: private */
    public final Object updateEventSysPreset(String str, VersionMenu versionMenu, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalResourceManager$updateEventSysPreset$2(str, versionMenu, (Continuation<? super LocalResourceManager$updateEventSysPreset$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.microtech.aidexx.db.entity.event.preset.BaseSysPreset> java.lang.Object updatePreset(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.Class<T> r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            r2 = r21
            r3 = r22
            boolean r4 = r3 instanceof com.microtech.aidexx.data.resource.LocalResourceManager$updatePreset$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            com.microtech.aidexx.data.resource.LocalResourceManager$updatePreset$1 r4 = (com.microtech.aidexx.data.resource.LocalResourceManager$updatePreset$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            com.microtech.aidexx.data.resource.LocalResourceManager$updatePreset$1 r4 = new com.microtech.aidexx.data.resource.LocalResourceManager$updatePreset$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 3
            r8 = 2
            r9 = 1
            java.lang.String r10 = "TAG"
            if (r6 == 0) goto L_0x0059
            if (r6 == r9) goto L_0x004c
            if (r6 == r8) goto L_0x0047
            if (r6 != r7) goto L_0x003f
            java.lang.Object r1 = r4.L$0
            java.lang.Class r1 = (java.lang.Class) r1
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x017f
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x01a3
        L_0x004c:
            java.lang.Object r1 = r4.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r4.L$0
            java.lang.Class r2 = (java.lang.Class) r2
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x00cc
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r3)
            if (r1 == 0) goto L_0x016e
            com.microtech.aidexx.utils.mmkv.MmkvManager r3 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r3 = r3.getEventSysPresetVersion(r2)
            int r6 = r1.compareTo(r3)
            if (r6 <= 0) goto L_0x013c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r6 = r18
            java.lang.StringBuilder r3 = r3.append(r6)
            r6 = r19
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r12 = r3.toString()
            com.microtech.aidexx.utils.FileUtils r3 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r3 = r3.isFileExists((java.lang.String) r12)
            if (r3 == 0) goto L_0x011d
            com.microtech.aidexx.data.resource.LocalResourceManager r11 = INSTANCE
            com.google.gson.reflect.TypeToken r14 = updatePreset$lambda$10$getTypeToken(r21)
            r15 = 2
            r16 = 0
            r13 = 0
            java.lang.Object r3 = readJsonFileToObj$default(r11, r12, r13, r14, r15, r16)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x00ff
            r6 = r3
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x00a0:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00b4
            java.lang.Object r7 = r6.next()
            boolean r11 = r7 instanceof com.microtech.aidexx.db.entity.event.preset.BaseSysPreset
            if (r11 == 0) goto L_0x00a0
            com.microtech.aidexx.db.entity.event.preset.BaseSysPreset r7 = (com.microtech.aidexx.db.entity.event.preset.BaseSysPreset) r7
            r7.setVersion(r1)
            goto L_0x00a0
        L_0x00b4:
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x00e1
            com.microtech.aidexx.db.repository.EventDbRepository r6 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r4.L$0 = r2
            r4.L$1 = r1
            r4.label = r9
            java.lang.Object r3 = r6.insertSysPresetData(r3, r4)
            if (r3 != r5) goto L_0x00cc
            return r5
        L_0x00cc:
            com.microtech.aidexx.utils.mmkv.MmkvManager r3 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r3.setEventSysPresetVersion(r1, r2)
            com.microtech.aidexx.db.repository.EventDbRepository r3 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r6 = 0
            r4.L$0 = r6
            r4.L$1 = r6
            r4.label = r8
            java.lang.Object r1 = r3.removeSysPresetOfOtherVersion(r1, r2, r4)
            if (r1 != r5) goto L_0x01a3
            return r5
        L_0x00e1:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "updateEventSysPreset 资源文件转 entity 为空 "
            r3.<init>(r4)
            java.lang.String r2 = r21.getSimpleName()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            r1.xLogE(r2, r3)
            goto L_0x013a
        L_0x00ff:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "updateEventSysPreset 资源文件转 entity 失败 "
            r3.<init>(r4)
            java.lang.String r2 = r21.getSimpleName()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            r1.xLogE(r2, r3)
            goto L_0x013a
        L_0x011d:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "updateEventSysPreset 解压后资源文件不存在 "
            r3.<init>(r4)
            java.lang.String r2 = r21.getSimpleName()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            r1.xLogE(r2, r3)
        L_0x013a:
            r9 = 0
            goto L_0x01a3
        L_0x013c:
            com.microtech.aidexx.utils.LogUtil$Companion r4 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "updateEventSysPreset "
            r5.<init>(r6)
            java.lang.String r2 = r21.getSimpleName()
            java.lang.StringBuilder r2 = r5.append(r2)
            java.lang.String r5 = " ov="
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " nv="
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r10)
            r4.xLogI(r1, r2)
            goto L_0x01a3
        L_0x016e:
            r1 = r0
            com.microtech.aidexx.data.resource.LocalResourceManager r1 = (com.microtech.aidexx.data.resource.LocalResourceManager) r1
            com.microtech.aidexx.db.repository.EventDbRepository r1 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r4.L$0 = r2
            r4.label = r7
            java.lang.Object r1 = r1.removeSysPresetData(r2, r4)
            if (r1 != r5) goto L_0x017e
            return r5
        L_0x017e:
            r1 = r2
        L_0x017f:
            com.microtech.aidexx.utils.mmkv.MmkvManager r2 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r3 = ""
            r2.setEventSysPresetVersion(r3, r1)
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "清空预设 "
            r3.<init>(r4)
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            r2.xLogE(r1, r3)
        L_0x01a3:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager.updatePreset(java.lang.String, java.lang.String, java.lang.String, java.lang.Class, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T extends BaseSysPreset> TypeToken<? extends List<? extends Object>> updatePreset$lambda$10$getTypeToken(Class<T> cls) {
        if (Intrinsics.areEqual((Object) cls, (Object) DietSysPresetEntity.class)) {
            return new LocalResourceManager$updatePreset$2$getTypeToken$1();
        }
        if (Intrinsics.areEqual((Object) cls, (Object) SportSysPresetEntity.class)) {
            return new LocalResourceManager$updatePreset$2$getTypeToken$2();
        }
        if (Intrinsics.areEqual((Object) cls, (Object) MedicineSysPresetEntity.class)) {
            return new LocalResourceManager$updatePreset$2$getTypeToken$3();
        }
        if (Intrinsics.areEqual((Object) cls, (Object) InsulinSysPresetEntity.class)) {
            return new LocalResourceManager$updatePreset$2$getTypeToken$4();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateUnit(java.lang.String r18, java.lang.String r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            boolean r3 = r2 instanceof com.microtech.aidexx.data.resource.LocalResourceManager$updateUnit$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.microtech.aidexx.data.resource.LocalResourceManager$updateUnit$1 r3 = (com.microtech.aidexx.data.resource.LocalResourceManager$updateUnit$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.microtech.aidexx.data.resource.LocalResourceManager$updateUnit$1 r3 = new com.microtech.aidexx.data.resource.LocalResourceManager$updateUnit$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            r8 = 0
            java.lang.String r9 = "TAG"
            r10 = 1
            if (r5 == 0) goto L_0x0066
            if (r5 == r10) goto L_0x0053
            if (r5 == r7) goto L_0x0046
            if (r5 != r6) goto L_0x003e
            java.lang.Object r1 = r3.L$0
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0169
        L_0x003e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0046:
            java.lang.Object r1 = r3.L$1
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r5 = r3.L$0
            com.microtech.aidexx.data.resource.LocalResourceManager r5 = (com.microtech.aidexx.data.resource.LocalResourceManager) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00f8
        L_0x0053:
            java.lang.Object r1 = r3.L$2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$1
            kotlin.jvm.internal.Ref$BooleanRef r5 = (kotlin.jvm.internal.Ref.BooleanRef) r5
            java.lang.Object r11 = r3.L$0
            com.microtech.aidexx.data.resource.LocalResourceManager r11 = (com.microtech.aidexx.data.resource.LocalResourceManager) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r5
            r5 = r11
            goto L_0x00e1
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            if (r1 == 0) goto L_0x0153
            com.microtech.aidexx.utils.mmkv.MmkvManager r5 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r5 = r5.getUnitVersion()
            int r11 = r1.compareTo(r5)
            if (r11 <= 0) goto L_0x012a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r11 = r18
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.String r11 = "unit.json"
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.String r12 = r5.toString()
            com.microtech.aidexx.utils.FileUtils r5 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r5 = r5.isFileExists((java.lang.String) r12)
            if (r5 == 0) goto L_0x011d
            com.microtech.aidexx.data.resource.LocalResourceManager r11 = INSTANCE
            com.microtech.aidexx.data.resource.LocalResourceManager$updateUnit$2$1 r5 = new com.microtech.aidexx.data.resource.LocalResourceManager$updateUnit$2$1
            r5.<init>()
            r14 = r5
            com.google.gson.reflect.TypeToken r14 = (com.google.gson.reflect.TypeToken) r14
            r15 = 2
            r16 = 0
            r13 = 0
            java.lang.Object r5 = readJsonFileToObj$default(r11, r12, r13, r14, r15, r16)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x010c
            r11 = r5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L_0x00b6:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x00c6
            java.lang.Object r12 = r11.next()
            com.microtech.aidexx.db.entity.event.UnitEntity r12 = (com.microtech.aidexx.db.entity.event.UnitEntity) r12
            r12.setVersion(r1)
            goto L_0x00b6
        L_0x00c6:
            r11 = r5
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x00fc
            com.microtech.aidexx.db.repository.EventDbRepository r11 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r3.L$0 = r0
            r3.L$1 = r2
            r3.L$2 = r1
            r3.label = r10
            java.lang.Object r5 = r11.insertUnit(r5, r3)
            if (r5 != r4) goto L_0x00e0
            return r4
        L_0x00e0:
            r5 = r0
        L_0x00e1:
            com.microtech.aidexx.utils.mmkv.MmkvManager r11 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r11.setUnitVersion(r1)
            com.microtech.aidexx.db.repository.EventDbRepository r11 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r3.L$0 = r5
            r3.L$1 = r2
            r3.L$2 = r8
            r3.label = r7
            java.lang.Object r1 = r11.removeUnitOfOtherVersion(r1, r3)
            if (r1 != r4) goto L_0x00f7
            return r4
        L_0x00f7:
            r1 = r2
        L_0x00f8:
            r1.element = r10
            r2 = r1
            goto L_0x0109
        L_0x00fc:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            java.lang.String r7 = "updateUnit 资源文件转 entity 为空"
            r1.xLogE(r7, r5)
            r5 = r0
        L_0x0109:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x010e
        L_0x010c:
            r5 = r0
            r1 = r8
        L_0x010e:
            if (r1 != 0) goto L_0x0150
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r7 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            java.lang.String r11 = "updateUnit 资源文件转 entity 失败 "
            r1.xLogE(r11, r7)
            goto L_0x0150
        L_0x011d:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            java.lang.String r7 = "updateUnit 解压后资源文件不存在"
            r1.xLogE(r7, r5)
            goto L_0x014f
        L_0x012a:
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "updateUnit ov="
            r11.<init>(r12)
            java.lang.StringBuilder r5 = r11.append(r5)
            java.lang.String r11 = " nv="
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.StringBuilder r1 = r5.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
            r7.xLogI(r1, r5)
            r2.element = r10
        L_0x014f:
            r5 = r0
        L_0x0150:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0155
        L_0x0153:
            r5 = r0
            r1 = r8
        L_0x0155:
            if (r1 != 0) goto L_0x017f
            com.microtech.aidexx.data.resource.LocalResourceManager r5 = (com.microtech.aidexx.data.resource.LocalResourceManager) r5
            com.microtech.aidexx.db.repository.EventDbRepository r1 = com.microtech.aidexx.db.repository.EventDbRepository.INSTANCE
            r3.L$0 = r2
            r3.L$1 = r8
            r3.label = r6
            java.lang.Object r1 = r1.removeAllUnit(r3)
            if (r1 != r4) goto L_0x0168
            return r4
        L_0x0168:
            r1 = r2
        L_0x0169:
            com.microtech.aidexx.utils.mmkv.MmkvManager r2 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r3 = ""
            r2.setUnitVersion(r3)
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r3 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
            java.lang.String r4 = "清空单位"
            r2.xLogE(r4, r3)
            r1.element = r10
            r2 = r1
        L_0x017f:
            boolean r1 = r2.element
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager.updateUnit(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0155 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateLanguage(java.lang.String r19, java.lang.String r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            boolean r3 = r2 instanceof com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguage$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguage$1 r3 = (com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguage$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguage$1 r3 = new com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguage$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            java.lang.String r8 = "TAG"
            r9 = 1
            r10 = 0
            if (r5 == 0) goto L_0x006f
            if (r5 == r9) goto L_0x0054
            if (r5 == r7) goto L_0x0046
            if (r5 != r6) goto L_0x003e
            java.lang.Object r1 = r3.L$0
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x01cf
        L_0x003e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0046:
            java.lang.Object r1 = r3.L$1
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r5 = r3.L$0
            com.microtech.aidexx.data.resource.LocalResourceManager r5 = (com.microtech.aidexx.data.resource.LocalResourceManager) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r9
            goto L_0x0159
        L_0x0054:
            java.lang.Object r1 = r3.L$3
            com.microtech.aidexx.db.repository.LanguageDbRepository r1 = (com.microtech.aidexx.db.repository.LanguageDbRepository) r1
            java.lang.Object r5 = r3.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r11 = r3.L$1
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r3.L$0
            com.microtech.aidexx.data.resource.LocalResourceManager r12 = (com.microtech.aidexx.data.resource.LocalResourceManager) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r11
            r17 = r5
            r5 = r1
            r1 = r17
            goto L_0x0140
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            if (r1 == 0) goto L_0x01b5
            com.microtech.aidexx.utils.mmkv.MmkvManager r5 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r5 = r5.getLanguageVersion()
            int r11 = r1.compareTo(r5)
            if (r11 <= 0) goto L_0x018b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r11 = r19
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.String r11 = "language.json"
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.String r5 = r5.toString()
            com.microtech.aidexx.utils.FileUtils r11 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r11 = r11.isFileExists((java.lang.String) r5)
            if (r11 == 0) goto L_0x017e
            com.microtech.aidexx.data.resource.LocalResourceManager r11 = INSTANCE
            com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguage$2$1 r12 = new com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguage$2$1
            r12.<init>()
            r14 = r12
            com.google.gson.reflect.TypeToken r14 = (com.google.gson.reflect.TypeToken) r14
            r15 = 2
            r16 = 0
            r13 = 0
            r12 = r5
            java.lang.Object r11 = readJsonFileToObj$default(r11, r12, r13, r14, r15, r16)
            java.util.List r11 = (java.util.List) r11
            if (r11 == 0) goto L_0x016d
            r12 = r11
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r13 = new java.util.ArrayList
            r14 = 10
            int r14 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r12, r14)
            r13.<init>(r14)
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.Iterator r12 = r12.iterator()
            r14 = 0
        L_0x00ce:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x011d
            java.lang.Object r15 = r12.next()
            int r16 = r14 + 1
            if (r14 >= 0) goto L_0x00df
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x00df:
            com.microtech.aidexx.db.entity.LanguageEntity r15 = (com.microtech.aidexx.db.entity.LanguageEntity) r15
            if (r15 == 0) goto L_0x00ee
            r15.setVersion(r1)
            com.microtech.aidexx.data.resource.LanguageResourceManager r6 = com.microtech.aidexx.data.resource.LanguageResourceManager.INSTANCE
            r6.verifySpecialResources(r15)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L_0x00ef
        L_0x00ee:
            r6 = r10
        L_0x00ef:
            if (r6 != 0) goto L_0x0113
            com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.StringBuilder r15 = r15.append(r5)
            java.lang.String r9 = " index="
            java.lang.StringBuilder r9 = r15.append(r9)
            java.lang.StringBuilder r9 = r9.append(r14)
            java.lang.String r14 = " is null"
            java.lang.StringBuilder r9 = r9.append(r14)
            java.lang.String r9 = r9.toString()
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r6, r9, r10, r7, r10)
        L_0x0113:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            r13.add(r6)
            r14 = r16
            r6 = 3
            r9 = 1
            goto L_0x00ce
        L_0x011d:
            java.util.List r13 = (java.util.List) r13
            r5 = r11
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x015d
            com.microtech.aidexx.db.repository.LanguageDbRepository r5 = new com.microtech.aidexx.db.repository.LanguageDbRepository
            r5.<init>()
            r3.L$0 = r0
            r3.L$1 = r2
            r3.L$2 = r1
            r3.L$3 = r5
            r6 = 1
            r3.label = r6
            java.lang.Object r6 = r5.insert(r11, r3)
            if (r6 != r4) goto L_0x013f
            return r4
        L_0x013f:
            r12 = r0
        L_0x0140:
            com.microtech.aidexx.utils.mmkv.MmkvManager r6 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r6.setLanguageVersion(r1)
            r3.L$0 = r12
            r3.L$1 = r2
            r3.L$2 = r10
            r3.L$3 = r10
            r3.label = r7
            java.lang.Object r1 = r5.removeLanguageOfOtherVersion(r1, r3)
            if (r1 != r4) goto L_0x0156
            return r4
        L_0x0156:
            r1 = r2
            r5 = r12
            r2 = 1
        L_0x0159:
            r1.element = r2
            r2 = r1
            goto L_0x016a
        L_0x015d:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            java.lang.String r6 = "updateLanguage 资源文件转 entity 为空"
            r1.xLogE(r6, r5)
            r5 = r0
        L_0x016a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x016f
        L_0x016d:
            r5 = r0
            r1 = r10
        L_0x016f:
            if (r1 != 0) goto L_0x01b2
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r6 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)
            java.lang.String r7 = "updateLanguage 资源文件转 entity 失败 "
            r1.xLogE(r7, r6)
            goto L_0x01b2
        L_0x017e:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            java.lang.String r6 = "updateLanguage 解压后资源文件不存在"
            r1.xLogE(r6, r5)
            goto L_0x01b1
        L_0x018b:
            com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "updateLanguage ov="
            r7.<init>(r9)
            java.lang.StringBuilder r5 = r7.append(r5)
            java.lang.String r7 = " nv="
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.StringBuilder r1 = r5.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            r6.xLogI(r1, r5)
            r1 = 1
            r2.element = r1
        L_0x01b1:
            r5 = r0
        L_0x01b2:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x01b7
        L_0x01b5:
            r5 = r0
            r1 = r10
        L_0x01b7:
            if (r1 != 0) goto L_0x01da
            com.microtech.aidexx.data.resource.LocalResourceManager r5 = (com.microtech.aidexx.data.resource.LocalResourceManager) r5
            com.microtech.aidexx.db.repository.LanguageDbRepository r1 = new com.microtech.aidexx.db.repository.LanguageDbRepository
            r1.<init>()
            r3.L$0 = r2
            r3.L$1 = r10
            r5 = 3
            r3.label = r5
            java.lang.Object r1 = r1.removeAll(r3)
            if (r1 != r4) goto L_0x01ce
            return r4
        L_0x01ce:
            r1 = r2
        L_0x01cf:
            com.microtech.aidexx.utils.mmkv.MmkvManager r2 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r3 = ""
            r2.setLanguageVersion(r3)
            r2 = 1
            r1.element = r2
            r2 = r1
        L_0x01da:
            boolean r1 = r2.element
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager.updateLanguage(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0115 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateLanguageConf(java.lang.String r18, java.lang.String r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r20
            boolean r3 = r2 instanceof com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguageConf$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguageConf$1 r3 = (com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguageConf$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguageConf$1 r3 = new com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguageConf$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 3
            r7 = 2
            java.lang.String r8 = "TAG"
            r9 = 0
            r10 = 1
            if (r5 == 0) goto L_0x006c
            if (r5 == r10) goto L_0x0053
            if (r5 == r7) goto L_0x0046
            if (r5 != r6) goto L_0x003e
            java.lang.Object r1 = r3.L$0
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x018b
        L_0x003e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0046:
            java.lang.Object r1 = r3.L$1
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            java.lang.Object r5 = r3.L$0
            com.microtech.aidexx.data.resource.LocalResourceManager r5 = (com.microtech.aidexx.data.resource.LocalResourceManager) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0117
        L_0x0053:
            java.lang.Object r1 = r3.L$3
            com.microtech.aidexx.db.repository.LanguageDbRepository r1 = (com.microtech.aidexx.db.repository.LanguageDbRepository) r1
            java.lang.Object r5 = r3.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r11 = r3.L$1
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r3.L$0
            com.microtech.aidexx.data.resource.LocalResourceManager r12 = (com.microtech.aidexx.data.resource.LocalResourceManager) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r11
            r11 = r1
            r1 = r5
            r5 = r12
            goto L_0x0100
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            if (r1 == 0) goto L_0x0172
            com.microtech.aidexx.utils.mmkv.MmkvManager r5 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r5 = r5.getLanguageConfVersion()
            int r11 = r1.compareTo(r5)
            if (r11 <= 0) goto L_0x0149
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r11 = r18
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.String r11 = "language_conf.json"
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.String r12 = r5.toString()
            com.microtech.aidexx.utils.FileUtils r5 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r5 = r5.isFileExists((java.lang.String) r12)
            if (r5 == 0) goto L_0x013c
            com.microtech.aidexx.data.resource.LocalResourceManager r11 = INSTANCE
            com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguageConf$2$1 r5 = new com.microtech.aidexx.data.resource.LocalResourceManager$updateLanguageConf$2$1
            r5.<init>()
            r14 = r5
            com.google.gson.reflect.TypeToken r14 = (com.google.gson.reflect.TypeToken) r14
            r15 = 2
            r16 = 0
            r13 = 0
            java.lang.Object r5 = readJsonFileToObj$default(r11, r12, r13, r14, r15, r16)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x012b
            r11 = r5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = 10
            int r13 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r13)
            r12.<init>(r13)
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r11 = r11.iterator()
        L_0x00c9:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00de
            java.lang.Object r13 = r11.next()
            com.microtech.aidexx.db.entity.LanguageConfEntity r13 = (com.microtech.aidexx.db.entity.LanguageConfEntity) r13
            r13.setVersion(r1)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r12.add(r13)
            goto L_0x00c9
        L_0x00de:
            java.util.List r12 = (java.util.List) r12
            r11 = r5
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x011b
            com.microtech.aidexx.db.repository.LanguageDbRepository r11 = new com.microtech.aidexx.db.repository.LanguageDbRepository
            r11.<init>()
            r3.L$0 = r0
            r3.L$1 = r2
            r3.L$2 = r1
            r3.L$3 = r11
            r3.label = r10
            java.lang.Object r5 = r11.insertConf(r5, r3)
            if (r5 != r4) goto L_0x00ff
            return r4
        L_0x00ff:
            r5 = r0
        L_0x0100:
            com.microtech.aidexx.utils.mmkv.MmkvManager r12 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r12.setLanguageConfVersion(r1)
            r3.L$0 = r5
            r3.L$1 = r2
            r3.L$2 = r9
            r3.L$3 = r9
            r3.label = r7
            java.lang.Object r1 = r11.removeLanguageConfOfOtherVersion(r1, r3)
            if (r1 != r4) goto L_0x0116
            return r4
        L_0x0116:
            r1 = r2
        L_0x0117:
            r1.element = r10
            r2 = r1
            goto L_0x0128
        L_0x011b:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            java.lang.String r7 = "updateLanguageConf 资源文件转 entity 为空"
            r1.xLogE(r7, r5)
            r5 = r0
        L_0x0128:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x012d
        L_0x012b:
            r5 = r0
            r1 = r9
        L_0x012d:
            if (r1 != 0) goto L_0x016f
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r7 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            java.lang.String r8 = "updateLanguageConf 资源文件转 entity 失败 "
            r1.xLogE(r8, r7)
            goto L_0x016f
        L_0x013c:
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            java.lang.String r7 = "updateLanguageConf 解压后资源文件不存在"
            r1.xLogE(r7, r5)
            goto L_0x016e
        L_0x0149:
            com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "updateLanguageConf ov="
            r11.<init>(r12)
            java.lang.StringBuilder r5 = r11.append(r5)
            java.lang.String r11 = " nv="
            java.lang.StringBuilder r5 = r5.append(r11)
            java.lang.StringBuilder r1 = r5.append(r1)
            java.lang.String r1 = r1.toString()
            java.lang.String r5 = TAG
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            r7.xLogI(r1, r5)
            r2.element = r10
        L_0x016e:
            r5 = r0
        L_0x016f:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            goto L_0x0174
        L_0x0172:
            r5 = r0
            r1 = r9
        L_0x0174:
            if (r1 != 0) goto L_0x0195
            com.microtech.aidexx.data.resource.LocalResourceManager r5 = (com.microtech.aidexx.data.resource.LocalResourceManager) r5
            com.microtech.aidexx.db.repository.LanguageDbRepository r1 = new com.microtech.aidexx.db.repository.LanguageDbRepository
            r1.<init>()
            r3.L$0 = r2
            r3.L$1 = r9
            r3.label = r6
            java.lang.Object r1 = r1.removeAllConf(r3)
            if (r1 != r4) goto L_0x018a
            return r4
        L_0x018a:
            r1 = r2
        L_0x018b:
            com.microtech.aidexx.utils.mmkv.MmkvManager r2 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r3 = ""
            r2.setLanguageConfVersion(r3)
            r1.element = r10
            r2 = r1
        L_0x0195:
            boolean r1 = r2.element
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager.updateLanguageConf(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readJsonFileToObj$default(LocalResourceManager localResourceManager, String str, Class cls, TypeToken typeToken, int i, Object obj) {
        if ((i & 2) != 0) {
            cls = null;
        }
        if ((i & 4) != 0) {
            typeToken = null;
        }
        return localResourceManager.readJsonFileToObj(str, cls, typeToken);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
        throw r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R readJsonFileToObj(java.lang.String r6, java.lang.Class<R> r7, com.google.gson.reflect.TypeToken<R> r8) {
        /*
            r5 = this;
            r0 = 0
            if (r7 != 0) goto L_0x0006
            if (r8 != 0) goto L_0x0006
            return r0
        L_0x0006:
            com.microtech.aidexx.utils.FileUtils r1 = com.microtech.aidexx.utils.FileUtils.INSTANCE
            boolean r1 = r1.isFileExists((java.lang.String) r6)
            if (r1 == 0) goto L_0x0071
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x005e }
            r2 = r5
            com.microtech.aidexx.data.resource.LocalResourceManager r2 = (com.microtech.aidexx.data.resource.LocalResourceManager) r2     // Catch:{ all -> 0x005e }
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x005e }
            r2.<init>(r6)     // Catch:{ all -> 0x005e }
            java.nio.charset.Charset r6 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x005e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x005e }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x005e }
            r4.<init>(r2)     // Catch:{ all -> 0x005e }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x005e }
            r3.<init>(r4, r6)     // Catch:{ all -> 0x005e }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x005e }
            r6 = r3
            java.io.InputStreamReader r6 = (java.io.InputStreamReader) r6     // Catch:{ all -> 0x0057 }
            if (r7 == 0) goto L_0x003a
            r2 = r6
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x0057 }
            java.lang.Object r7 = r1.fromJson((java.io.Reader) r2, r7)     // Catch:{ all -> 0x0057 }
            goto L_0x003b
        L_0x003a:
            r7 = r0
        L_0x003b:
            if (r7 != 0) goto L_0x004f
            java.io.Reader r6 = (java.io.Reader) r6     // Catch:{ all -> 0x0057 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ all -> 0x0057 }
            java.lang.reflect.Type r7 = r8.getType()     // Catch:{ all -> 0x0057 }
            java.lang.Object r7 = r1.fromJson((java.io.Reader) r6, (java.lang.reflect.Type) r7)     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = "let(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)     // Catch:{ all -> 0x0057 }
        L_0x004f:
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ all -> 0x005e }
            java.lang.Object r6 = kotlin.Result.m343constructorimpl(r7)     // Catch:{ all -> 0x005e }
            goto L_0x0069
        L_0x0057:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r6)     // Catch:{ all -> 0x005e }
            throw r7     // Catch:{ all -> 0x005e }
        L_0x005e:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m343constructorimpl(r6)
        L_0x0069:
            boolean r7 = kotlin.Result.m349isFailureimpl(r6)
            if (r7 == 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r0 = r6
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.LocalResourceManager.readJsonFileToObj(java.lang.String, java.lang.Class, com.google.gson.reflect.TypeToken):java.lang.Object");
    }
}
