package com.microtech.aidexx.base;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.splashscreen.SplashScreenViewProvider;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.databinding.ActivityLoadResourceBinding;
import com.microtech.aidexx.databinding.ActivityWelcomeBinding;
import com.microtech.aidexx.databinding.ActivityWelcomeTipBinding;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0007\n\b&\u0018\u0000 %*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003:\u0001%B\u0005¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0014\u0010\u0015\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0002J\u0012\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u0012H\u0014J\b\u0010$\u001a\u00020\u0012H\u0002R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/microtech/aidexx/base/BaseWelcomeActivity;", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/databinding/ActivityWelcomeBinding;", "()V", "animationCallback", "com/microtech/aidexx/base/BaseWelcomeActivity$animationCallback$1", "Lcom/microtech/aidexx/base/BaseWelcomeActivity$animationCallback$1;", "countDownTimer", "com/microtech/aidexx/base/BaseWelcomeActivity$countDownTimer$1", "Lcom/microtech/aidexx/base/BaseWelcomeActivity$countDownTimer$1;", "isAnimationFinish", "", "isSupportSplashProgress", "isTimerFinish", "resourceLoaded", "afterAgreeUserProtocol", "", "welcomeTipBinding", "Lcom/microtech/aidexx/databinding/ActivityWelcomeTipBinding;", "afterResourceLoaded", "splashScreen", "Landroidx/core/splashscreen/SplashScreenViewProvider;", "getNavBarHeight", "", "getViewBinding", "initSplashProgressIfNoSupported", "initSplashProgressIfSupported", "loadResource", "nextStepIfNeed", "nextTimerStepIfNeed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "updateWindow", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseWelcomeActivity.kt */
public abstract class BaseWelcomeActivity<VM extends BaseViewModel> extends BaseActivity<VM, ActivityWelcomeBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXT_CHANGE_LANGUAGE = "EXT_CHANGE_LANGUAGE";
    public static final String EXT_UPDATE_RESOURCE = "EXT_UPDATE_RESOURCE";
    private static final String TAG = "BaseWelcomeActivity";
    private final BaseWelcomeActivity$animationCallback$1<VM> animationCallback = new BaseWelcomeActivity$animationCallback$1(this);
    private final BaseWelcomeActivity$countDownTimer$1<VM> countDownTimer = new BaseWelcomeActivity$countDownTimer$1(this);
    /* access modifiers changed from: private */
    public volatile boolean isAnimationFinish;
    /* access modifiers changed from: private */
    public boolean isSupportSplashProgress = true;
    /* access modifiers changed from: private */
    public boolean isTimerFinish;
    /* access modifiers changed from: private */
    public volatile boolean resourceLoaded;

    public abstract void afterAgreeUserProtocol(ActivityWelcomeTipBinding activityWelcomeTipBinding);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/base/BaseWelcomeActivity$Companion;", "", "()V", "EXT_CHANGE_LANGUAGE", "", "EXT_UPDATE_RESOURCE", "TAG", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseWelcomeActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ActivityWelcomeBinding getViewBinding() {
        ActivityWelcomeBinding inflate = ActivityWelcomeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (LanguageResourceManager.INSTANCE.getCurLanguageTag().length() > 0) {
            LanguageResourceManager.INSTANCE.setAppLocale(LanguageResourceManager.INSTANCE.getCurLanguageTag());
        }
        LogUtil.Companion companion = LogUtil.Companion;
        String intent = getIntent().toString();
        Intrinsics.checkNotNullExpressionValue(intent, "toString(...)");
        companion.e(intent, TAG);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 31 && !getIntent().getBooleanExtra(EXT_UPDATE_RESOURCE, false) && !getIntent().getBooleanExtra(EXT_CHANGE_LANGUAGE, false)) {
            z = true;
        }
        this.isSupportSplashProgress = z;
        initSplashProgressIfSupported();
        super.onCreate(bundle);
        setContentView((View) ((ActivityWelcomeBinding) getBinding()).getRoot());
        initSplashProgressIfNoSupported();
        loadResource();
        this.countDownTimer.start();
    }

    private final void loadResource() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseWelcomeActivity$loadResource$1(this, (Continuation<? super BaseWelcomeActivity$loadResource$1>) null), 3, (Object) null);
    }

    private final void initSplashProgressIfSupported() {
        SplashScreen installSplashScreen = SplashScreen.Companion.installSplashScreen(this);
        installSplashScreen.setOnExitAnimationListener(new BaseWelcomeActivity$$ExternalSyntheticLambda0(this));
        installSplashScreen.setKeepOnScreenCondition(new BaseWelcomeActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void initSplashProgressIfSupported$lambda$0(BaseWelcomeActivity baseWelcomeActivity, SplashScreenViewProvider splashScreenViewProvider) {
        Intrinsics.checkNotNullParameter(baseWelcomeActivity, "this$0");
        Intrinsics.checkNotNullParameter(splashScreenViewProvider, "it");
        LogUtil.Companion.xLogI("OnExitAnimationListener isSupportSplashProgress=" + baseWelcomeActivity.isSupportSplashProgress + " resourceLoaded=" + baseWelcomeActivity.resourceLoaded, TAG);
        if (baseWelcomeActivity.isSupportSplashProgress) {
            baseWelcomeActivity.countDownTimer.cancel();
            baseWelcomeActivity.afterResourceLoaded(splashScreenViewProvider);
            return;
        }
        splashScreenViewProvider.remove();
    }

    /* access modifiers changed from: private */
    public static final boolean initSplashProgressIfSupported$lambda$1(BaseWelcomeActivity baseWelcomeActivity) {
        Intrinsics.checkNotNullParameter(baseWelcomeActivity, "this$0");
        return baseWelcomeActivity.isSupportSplashProgress && !baseWelcomeActivity.resourceLoaded;
    }

    private final void initSplashProgressIfNoSupported() {
        if (!this.isSupportSplashProgress) {
            ActivityLoadResourceBinding activityLoadResourceBinding = ((ActivityWelcomeBinding) getBinding()).loadResource;
            activityLoadResourceBinding.splashIconContainer.setPadding(0, getNavBarHeight(), 0, 0);
            activityLoadResourceBinding.splashIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_splash));
            Drawable drawable = activityLoadResourceBinding.splashIcon.getDrawable();
            if (drawable instanceof AnimatedVectorDrawable) {
                AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
                animatedVectorDrawable.registerAnimationCallback(this.animationCallback);
                animatedVectorDrawable.start();
            }
        }
    }

    private final int getNavBarHeight() {
        int identifier = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return ExtendsKt.dp2px((Number) 40);
    }

    /* access modifiers changed from: private */
    public final void nextStepIfNeed() {
        if (this.resourceLoaded && this.isAnimationFinish) {
            this.countDownTimer.cancel();
            afterResourceLoaded$default(this, (SplashScreenViewProvider) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void nextTimerStepIfNeed() {
        if (this.resourceLoaded && this.isTimerFinish) {
            afterResourceLoaded$default(this, (SplashScreenViewProvider) null, 1, (Object) null);
        }
    }

    static /* synthetic */ void afterResourceLoaded$default(BaseWelcomeActivity baseWelcomeActivity, SplashScreenViewProvider splashScreenViewProvider, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                splashScreenViewProvider = null;
            }
            baseWelcomeActivity.afterResourceLoaded(splashScreenViewProvider);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: afterResourceLoaded");
    }

    private final void afterResourceLoaded(SplashScreenViewProvider splashScreenViewProvider) {
        updateWindow();
        LogUtil.Companion.xLogI("afterResourceLoaded splashScreen=" + splashScreenViewProvider, TAG);
        if (MmkvManager.INSTANCE.isAppFirstLaunch()) {
            LogUtil.Companion.xLogI("afterResourceLoaded isAppFirstLaunch", TAG);
            if (splashScreenViewProvider != null) {
                splashScreenViewProvider.remove();
            }
            ConstraintLayout root = ((ActivityWelcomeBinding) getBinding()).loadResource.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            root.setVisibility(8);
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseWelcomeActivity$afterResourceLoaded$1(this, (Continuation<? super BaseWelcomeActivity$afterResourceLoaded$1>) null), 3, (Object) null);
            return;
        }
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BaseWelcomeActivity$afterResourceLoaded$2(this, splashScreenViewProvider, (Continuation<? super BaseWelcomeActivity$afterResourceLoaded$2>) null), 3, (Object) null);
    }

    private final void updateWindow() {
        Window window = getWindow();
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
            window.setStatusBarColor(0);
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.show(WindowInsets.Type.navigationBars());
                return;
            }
            return;
        }
        decorView.setSystemUiVisibility(0);
        window.setStatusBarColor(0);
        View decorView2 = window.getDecorView();
        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 1280);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ((ActivityWelcomeBinding) getBinding()).welcomeTipViewStub.viewAgreeProtocal.removeClick();
        if (!this.isSupportSplashProgress) {
            Drawable drawable = ((ActivityWelcomeBinding) getBinding()).loadResource.splashIcon.getDrawable();
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).unregisterAnimationCallback(this.animationCallback);
            }
        }
    }
}
