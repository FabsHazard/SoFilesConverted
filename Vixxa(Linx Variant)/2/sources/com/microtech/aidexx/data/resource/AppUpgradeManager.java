package com.microtech.aidexx.data.resource;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.utils.FileUtils;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.io.File;
import java.util.Date;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\fJ\u0012\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R%\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/microtech/aidexx/data/resource/AppUpgradeManager;", "", "()V", "DOWNLOAD_STATUS_DONE", "", "DOWNLOAD_STATUS_ERROR", "TAG", "", "mUpgradeProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "mUpgradeState", "Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "syncExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "upgradeProgressFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getUpgradeProgressFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchVersionInfo", "isManual", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "installApk", "", "path", "needCheckNewVersion", "openInGooglePlay", "startUpgrade", "appUpdateInfo", "stopUpgrade", "isFromException", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AppUpgradeManager.kt */
public final class AppUpgradeManager {
    public static final int DOWNLOAD_STATUS_DONE = 100;
    public static final int DOWNLOAD_STATUS_ERROR = -1;
    public static final AppUpgradeManager INSTANCE = new AppUpgradeManager();
    public static final String TAG = "AppUpgradeManager";
    /* access modifiers changed from: private */
    public static final MutableStateFlow<Pair<Integer, String>> mUpgradeProgress;
    /* access modifiers changed from: private */
    public static final MutableStateFlow<UpgradeInfo> mUpgradeState = StateFlowKt.MutableStateFlow(null);
    /* access modifiers changed from: private */
    public static final CoroutineExceptionHandler syncExceptionHandler = new AppUpgradeManager$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key);
    private static final StateFlow<Pair<Integer, String>> upgradeProgressFlow;

    private AppUpgradeManager() {
    }

    static {
        MutableStateFlow<Pair<Integer, String>> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        mUpgradeProgress = MutableStateFlow;
        upgradeProgressFlow = MutableStateFlow;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final StateFlow<Pair<Integer, String>> getUpgradeProgressFlow() {
        return upgradeProgressFlow;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.data.resource.AppUpgradeManager$1", f = "AppUpgradeManager.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.data.resource.AppUpgradeManager$1  reason: invalid class name */
    /* compiled from: AppUpgradeManager.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AppUpgradeManager.mUpgradeState.collect(AnonymousClass1.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: private */
    public final void openInGooglePlay() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.microtech.aidexx.grx1.mmoll"));
            if (!TextUtils.isEmpty("com.android.vending")) {
                intent.setPackage("com.android.vending");
            }
            intent.addFlags(268435456);
            ExtendsKt.getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ Object fetchVersionInfo$default(AppUpgradeManager appUpgradeManager, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return appUpgradeManager.fetchVersionInfo(z, continuation);
    }

    public final Object fetchVersionInfo(boolean z, Continuation<? super UpgradeInfo> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AppUpgradeManager$fetchVersionInfo$2(z, (Continuation<? super AppUpgradeManager$fetchVersionInfo$2>) null), continuation);
    }

    public final boolean startUpgrade(UpgradeInfo upgradeInfo) {
        Intrinsics.checkNotNullParameter(upgradeInfo, "appUpdateInfo");
        boolean compareAndSet = mUpgradeState.compareAndSet(null, upgradeInfo);
        LogUtil.Companion.xLogI("启动升级 ret=" + compareAndSet, TAG);
        return compareAndSet;
    }

    static /* synthetic */ void stopUpgrade$default(AppUpgradeManager appUpgradeManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        appUpgradeManager.stopUpgrade(z);
    }

    /* access modifiers changed from: private */
    public final void stopUpgrade(boolean z) {
        if (z) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new AppUpgradeManager$stopUpgrade$1((Continuation<? super AppUpgradeManager$stopUpgrade$1>) null), 3, (Object) null);
        }
        MutableStateFlow<UpgradeInfo> mutableStateFlow = mUpgradeState;
        mutableStateFlow.setValue(null);
        LogUtil.Companion.xLogI("结束升级 curState=" + mutableStateFlow.getValue(), TAG);
    }

    /* access modifiers changed from: private */
    public final boolean needCheckNewVersion(boolean z) {
        return (z || !((MmkvManager.INSTANCE.getAppCheckVersionTime() > ExtendsKt.getStartOfTheDay(new Date()).getTime() ? 1 : (MmkvManager.INSTANCE.getAppCheckVersionTime() == ExtendsKt.getStartOfTheDay(new Date()).getTime() ? 0 : -1)) == 0)) && NetUtil.isNetAvailable(ExtendsKt.getContext());
    }

    /* access modifiers changed from: private */
    public final void installApk(String str) {
        File file = new File(str);
        FileUtils fileUtils = FileUtils.INSTANCE;
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        fileUtils.setPermission(path);
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.addFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(ExtendsKt.getContext(), ExtendsKt.getContext().getPackageName() + ".FileProvider", file), "application/vnd.android.package-archive");
            ExtendsKt.getContext().startActivity(intent);
        }
    }
}
