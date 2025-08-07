package com.microtech.aidexx;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.work.Configuration;
import androidx.work.WorkManager;
import com.kongzue.dialogx.DialogX;
import com.microtech.aidexx.ble.AidexBleAdapter;
import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.ui.setting.alert.AlertUtil;
import com.microtech.aidexx.utils.ContextUtil;
import com.microtech.aidexx.utils.CrashHandler;
import com.microtech.aidexx.utils.ProcessUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtechmd.blecomm.controller.BleController;
import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mmkv.MMKV;
import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/AidexxApp;", "Landroid/app/Application;", "Landroidx/work/Configuration$Provider;", "()V", "activityLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "activityResumeCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getResources", "Landroid/content/res/Resources;", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "initSdks", "", "initXlog", "isDisplayOn", "", "isForeground", "onCreate", "onTerminate", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AidexxApp.kt */
public final class AidexxApp extends Application implements Configuration.Provider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static AidexxApp instance;
    public static CoroutineScope mainScope;
    /* access modifiers changed from: private */
    public static String xlogPath;
    private final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new AidexxApp$activityLifecycleCallbacks$1(this);
    /* access modifiers changed from: private */
    public AtomicInteger activityResumeCount = new AtomicInteger(0);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/AidexxApp$Companion;", "", "()V", "instance", "Lcom/microtech/aidexx/AidexxApp;", "getInstance", "()Lcom/microtech/aidexx/AidexxApp;", "setInstance", "(Lcom/microtech/aidexx/AidexxApp;)V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "setMainScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "xlogPath", "", "getXlogPath", "()Ljava/lang/String;", "setXlogPath", "(Ljava/lang/String;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AidexxApp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getXlogPath() {
            return AidexxApp.xlogPath;
        }

        public final void setXlogPath(String str) {
            AidexxApp.xlogPath = str;
        }

        public final AidexxApp getInstance() {
            AidexxApp aidexxApp = AidexxApp.instance;
            if (aidexxApp != null) {
                return aidexxApp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        public final void setInstance(AidexxApp aidexxApp) {
            Intrinsics.checkNotNullParameter(aidexxApp, "<set-?>");
            AidexxApp.instance = aidexxApp;
        }

        public final CoroutineScope getMainScope() {
            CoroutineScope coroutineScope = AidexxApp.mainScope;
            if (coroutineScope != null) {
                return coroutineScope;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mainScope");
            return null;
        }

        public final void setMainScope(CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
            AidexxApp.mainScope = coroutineScope;
        }
    }

    public void onCreate() {
        super.onCreate();
        Companion companion = Companion;
        companion.setInstance(this);
        companion.setMainScope(CoroutineScopeKt.MainScope());
        CrashHandler instance2 = CrashHandler.Companion.getInstance();
        if (instance2 != null) {
            instance2.init();
        }
        initSdks();
        registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        ThemeManager.INSTANCE.updateDayNightMode();
        WorkManager.getInstance(this).cancelAllWorkByTag("OtaWorker");
    }

    public void onTerminate() {
        super.onTerminate();
        ObjectBox.INSTANCE.getStore().close();
        MMKV.onExit();
        Log.appenderClose();
        CoroutineScopeKt.cancel$default(Companion.getMainScope(), (CancellationException) null, 1, (Object) null);
        unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }

    private final void initSdks() {
        Context context = this;
        MMKV.initialize(context);
        if (ProcessUtil.isMainProcess(context)) {
            ObjectBox.INSTANCE.init(context);
            initXlog();
        }
        AidexBleAdapter.Companion.init(context);
        BleController.setBleAdapter(AidexBleAdapter.Companion.getInstance());
        AidexBleAdapter.Companion.getInstance().setDiscoverCallback();
        AlertUtil.INSTANCE.init(context);
        ContextUtil.Companion.init(context);
        DialogX.init(context);
        System.loadLibrary("cgat-lib");
    }

    private final void initXlog() {
        System.loadLibrary("c++_shared");
        System.loadLibrary("marsxlog");
        StringBuilder sb = new StringBuilder();
        String str = null;
        File externalFilesDir = getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            str = externalFilesDir.getAbsolutePath();
        }
        xlogPath = sb.append(str).append("/aidex/log").toString();
        Xlog.XLogConfig xLogConfig = new Xlog.XLogConfig();
        xLogConfig.logdir = xlogPath;
        xLogConfig.nameprefix = DeviceModelKt.NAME_AIDEX;
        xLogConfig.pubkey = "";
        xLogConfig.compressmode = 0;
        xLogConfig.compresslevel = 0;
        xLogConfig.cachedir = getExternalCacheDir() + "/xlog";
        xLogConfig.cachedays = 15;
        Log.setLogImp(new Xlog());
        if (ProcessUtil.isMainProcess(this)) {
            Log.setConsoleLogOpen(false);
            Log.appenderOpen(1, 0, "", xlogPath, DeviceModelKt.NAME_AIDEX, 15);
        }
    }

    public final boolean isDisplayOn() {
        Object systemService = getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display[] displays = ((DisplayManager) systemService).getDisplays();
        Intrinsics.checkNotNullExpressionValue(displays, "getDisplays(...)");
        for (Display state : displays) {
            if (state.getState() != 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean isForeground() {
        return this.activityResumeCount.get() != 0;
    }

    public Resources getResources() {
        LanguageResourceManager languageResourceManager = LanguageResourceManager.INSTANCE;
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return languageResourceManager.getAidexApplicationResourceInspector(resources);
    }

    public Configuration getWorkManagerConfiguration() {
        Configuration build = new Configuration.Builder().setMinimumLoggingLevel(4).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
