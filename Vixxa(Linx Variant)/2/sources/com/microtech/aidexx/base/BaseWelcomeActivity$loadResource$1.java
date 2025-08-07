package com.microtech.aidexx.base;

import android.os.Build;
import androidx.core.splashscreen.SplashScreenViewProvider;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.base.BaseWelcomeActivity$loadResource$1", f = "BaseWelcomeActivity.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseWelcomeActivity.kt */
final class BaseWelcomeActivity$loadResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseWelcomeActivity<VM> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseWelcomeActivity$loadResource$1(BaseWelcomeActivity<VM> baseWelcomeActivity, Continuation<? super BaseWelcomeActivity$loadResource$1> continuation) {
        super(2, continuation);
        this.this$0 = baseWelcomeActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseWelcomeActivity$loadResource$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseWelcomeActivity$loadResource$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.base.BaseWelcomeActivity$loadResource$1$1", f = "BaseWelcomeActivity.kt", i = {}, l = {97, 103, 108, 110}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.base.BaseWelcomeActivity$loadResource$1$1  reason: invalid class name */
    /* compiled from: BaseWelcomeActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x007e, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r1 = kotlin.Result.Companion;
            r7 = kotlin.Result.m343constructorimpl(kotlin.ResultKt.createFailure(r7));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00db, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00dc, code lost:
            r0 = kotlin.Result.Companion;
            r7 = kotlin.Result.m343constructorimpl(kotlin.ResultKt.createFailure(r7));
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0014, B:26:0x006a] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0026
                if (r1 == r5) goto L_0x0021
                if (r1 == r4) goto L_0x0021
                if (r1 == r3) goto L_0x0021
                if (r1 != r2) goto L_0x0019
                kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x00db }
                goto L_0x00cb
            L_0x0019:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x0021:
                kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x00db }
                goto L_0x00c0
            L_0x0026:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
                kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00db }
                com.microtech.aidexx.common.user.UserInfoManager$Companion r7 = com.microtech.aidexx.common.user.UserInfoManager.Companion     // Catch:{ all -> 0x00db }
                com.microtech.aidexx.common.user.UserInfoManager r7 = r7.instance()     // Catch:{ all -> 0x00db }
                boolean r7 = r7.isLogin()     // Catch:{ all -> 0x00db }
                if (r7 == 0) goto L_0x00b5
                com.microtech.aidexx.utils.StringUtils r7 = com.microtech.aidexx.utils.StringUtils.INSTANCE     // Catch:{ all -> 0x00db }
                com.microtech.aidexx.utils.mmkv.MmkvManager r1 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE     // Catch:{ all -> 0x00db }
                java.lang.String r1 = r1.getResourceVersion()     // Catch:{ all -> 0x00db }
                java.lang.String r3 = "1.7.1"
                boolean r7 = r7.versionCompare(r1, r3)     // Catch:{ all -> 0x00db }
                if (r7 == 0) goto L_0x0056
                com.microtech.aidexx.data.resource.LocalResourceManager r7 = com.microtech.aidexx.data.resource.LocalResourceManager.INSTANCE     // Catch:{ all -> 0x00db }
                r6.label = r5     // Catch:{ all -> 0x00db }
                java.lang.Object r7 = r7.upgradeFromAssets(r6)     // Catch:{ all -> 0x00db }
                if (r7 != r0) goto L_0x00c0
                return r0
            L_0x0056:
                com.microtech.aidexx.utils.mmkv.MmkvManager r7 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE     // Catch:{ all -> 0x00db }
                java.lang.String r7 = r7.getUpgradeResourceZipFileInfo()     // Catch:{ all -> 0x00db }
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x00db }
                int r1 = r7.length()     // Catch:{ all -> 0x00db }
                r3 = 0
                if (r1 != 0) goto L_0x0066
                r7 = r3
            L_0x0066:
                java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00db }
                if (r7 == 0) goto L_0x00c0
                kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x007e }
                com.google.gson.Gson r1 = new com.google.gson.Gson     // Catch:{ all -> 0x007e }
                r1.<init>()     // Catch:{ all -> 0x007e }
                java.lang.Class<com.microtech.aidexx.common.net.entity.VersionInfo> r5 = com.microtech.aidexx.common.net.entity.VersionInfo.class
                java.lang.Object r7 = r1.fromJson((java.lang.String) r7, r5)     // Catch:{ all -> 0x007e }
                com.microtech.aidexx.common.net.entity.VersionInfo r7 = (com.microtech.aidexx.common.net.entity.VersionInfo) r7     // Catch:{ all -> 0x007e }
                java.lang.Object r7 = kotlin.Result.m343constructorimpl(r7)     // Catch:{ all -> 0x007e }
                goto L_0x0089
            L_0x007e:
                r7 = move-exception
                kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00db }
                java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)     // Catch:{ all -> 0x00db }
                java.lang.Object r7 = kotlin.Result.m343constructorimpl(r7)     // Catch:{ all -> 0x00db }
            L_0x0089:
                boolean r1 = kotlin.Result.m349isFailureimpl(r7)     // Catch:{ all -> 0x00db }
                if (r1 == 0) goto L_0x0090
                r7 = r3
            L_0x0090:
                com.microtech.aidexx.common.net.entity.VersionInfo r7 = (com.microtech.aidexx.common.net.entity.VersionInfo) r7     // Catch:{ all -> 0x00db }
                if (r7 == 0) goto L_0x00c0
                com.microtech.aidexx.data.resource.LocalResourceManager r1 = com.microtech.aidexx.data.resource.LocalResourceManager.INSTANCE     // Catch:{ all -> 0x00db }
                com.microtech.aidexx.common.net.entity.VersionData r5 = r7.getInfo()     // Catch:{ all -> 0x00db }
                if (r5 == 0) goto L_0x00a1
                java.lang.String r5 = r5.getDownloadpath()     // Catch:{ all -> 0x00db }
                goto L_0x00a2
            L_0x00a1:
                r5 = r3
            L_0x00a2:
                com.microtech.aidexx.common.net.entity.VersionData r7 = r7.getInfo()     // Catch:{ all -> 0x00db }
                if (r7 == 0) goto L_0x00ac
                java.lang.String r3 = r7.getVersion()     // Catch:{ all -> 0x00db }
            L_0x00ac:
                r6.label = r4     // Catch:{ all -> 0x00db }
                java.lang.Object r7 = r1.startUpgrade(r5, r3, r6)     // Catch:{ all -> 0x00db }
                if (r7 != r0) goto L_0x00c0
                return r0
            L_0x00b5:
                com.microtech.aidexx.data.resource.LocalResourceManager r7 = com.microtech.aidexx.data.resource.LocalResourceManager.INSTANCE     // Catch:{ all -> 0x00db }
                r6.label = r3     // Catch:{ all -> 0x00db }
                java.lang.Object r7 = r7.upgradeFromAssets(r6)     // Catch:{ all -> 0x00db }
                if (r7 != r0) goto L_0x00c0
                return r0
            L_0x00c0:
                com.microtech.aidexx.data.resource.LanguageResourceManager r7 = com.microtech.aidexx.data.resource.LanguageResourceManager.INSTANCE     // Catch:{ all -> 0x00db }
                r6.label = r2     // Catch:{ all -> 0x00db }
                java.lang.Object r7 = r7.loadLanguageInfo(r6)     // Catch:{ all -> 0x00db }
                if (r7 != r0) goto L_0x00cb
                return r0
            L_0x00cb:
                com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion     // Catch:{ all -> 0x00db }
                java.lang.String r0 = "资源加载成功"
                java.lang.String r1 = "BaseWelcomeActivity"
                r7.d(r0, r1)     // Catch:{ all -> 0x00db }
                kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00db }
                java.lang.Object r7 = kotlin.Result.m343constructorimpl(r7)     // Catch:{ all -> 0x00db }
                goto L_0x00e6
            L_0x00db:
                r7 = move-exception
                kotlin.Result$Companion r0 = kotlin.Result.Companion
                java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
                java.lang.Object r7 = kotlin.Result.m343constructorimpl(r7)
            L_0x00e6:
                kotlin.Result r7 = kotlin.Result.m342boximpl(r7)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.base.BaseWelcomeActivity$loadResource$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Throwable r7 = Result.m346exceptionOrNullimpl(((Result) obj).m352unboximpl());
        if (r7 != null) {
            LogUtil.Companion.xLogE("资源加载失败：" + r7, "BaseWelcomeActivity");
        }
        this.this$0.resourceLoaded = true;
        LogUtil.Companion.xLogI("loadResource done isSupportSplashProgress=" + this.this$0.isSupportSplashProgress, "BaseWelcomeActivity");
        if (!this.this$0.isSupportSplashProgress) {
            this.this$0.nextStepIfNeed();
        } else {
            LogUtil.Companion.xLogI("loadResource done SDK_INT=" + Build.VERSION.SDK_INT, "BaseWelcomeActivity");
            if (Build.VERSION.SDK_INT != 31 || !MmkvManager.INSTANCE.isApi31FirstIn()) {
                this.this$0.nextTimerStepIfNeed();
            } else {
                LogUtil.Companion.xLogI("loadResource done sdk 31 first in", "BaseWelcomeActivity");
                MmkvManager.INSTANCE.setApi31FirstIn();
                BaseWelcomeActivity.afterResourceLoaded$default(this.this$0, (SplashScreenViewProvider) null, 1, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }
}
