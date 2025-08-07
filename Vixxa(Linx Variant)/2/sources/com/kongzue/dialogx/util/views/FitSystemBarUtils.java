package com.kongzue.dialogx.util.views;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.interfaces.BaseDialog;
import java.util.List;

public class FitSystemBarUtils {
    private CallBack callBack;
    private View contentView;
    /* access modifiers changed from: private */
    public boolean inSmoothingPadding = false;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    RelativePadding relativePaddingCache;
    View.OnLayoutChangeListener rootViewLayoutChangeListener;
    public boolean safeCutOutPadding = true;
    public boolean smoothPadding = true;
    private boolean specialMode;
    /* access modifiers changed from: private */
    public int specialModeImeHeight;

    public interface CallBack {
        int initialPadding(Orientation orientation);

        boolean isEnable(Orientation orientation);

        void unsafeRect(int i, int i2, int i3, int i4);
    }

    enum Orientation {
        Start,
        Top,
        End,
        Bottom
    }

    public boolean isInSmoothingPadding() {
        return this.inSmoothingPadding;
    }

    public static FitSystemBarUtils attachView(View view) {
        return attachView(view, new CallBack() {
            public int initialPadding(Orientation orientation) {
                return 0;
            }

            public boolean isEnable(Orientation orientation) {
                return true;
            }

            public void unsafeRect(int i, int i2, int i3, int i4) {
            }
        });
    }

    public static FitSystemBarUtils attachView(View view, CallBack callBack2) {
        return new FitSystemBarUtils(view, callBack2);
    }

    public static FitSystemBarUtils attachView(View view, final boolean z, final boolean z2, final boolean z3, final boolean z4) {
        return attachView(view, new CallBack() {
            public int initialPadding(Orientation orientation) {
                return 0;
            }

            public void unsafeRect(int i, int i2, int i3, int i4) {
            }

            public boolean isEnable(Orientation orientation) {
                int i = AnonymousClass6.$SwitchMap$com$kongzue$dialogx$util$views$FitSystemBarUtils$Orientation[orientation.ordinal()];
                if (i == 1) {
                    return z;
                }
                if (i == 2) {
                    return z2;
                }
                if (i == 3) {
                    return z3;
                }
                if (i != 4) {
                    return false;
                }
                return z4;
            }
        });
    }

    /* renamed from: com.kongzue.dialogx.util.views.FitSystemBarUtils$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kongzue$dialogx$util$views$FitSystemBarUtils$Orientation;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.kongzue.dialogx.util.views.FitSystemBarUtils$Orientation[] r0 = com.kongzue.dialogx.util.views.FitSystemBarUtils.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kongzue$dialogx$util$views$FitSystemBarUtils$Orientation = r0
                com.kongzue.dialogx.util.views.FitSystemBarUtils$Orientation r1 = com.kongzue.dialogx.util.views.FitSystemBarUtils.Orientation.Start     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$util$views$FitSystemBarUtils$Orientation     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kongzue.dialogx.util.views.FitSystemBarUtils$Orientation r1 = com.kongzue.dialogx.util.views.FitSystemBarUtils.Orientation.Top     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$util$views$FitSystemBarUtils$Orientation     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kongzue.dialogx.util.views.FitSystemBarUtils$Orientation r1 = com.kongzue.dialogx.util.views.FitSystemBarUtils.Orientation.End     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$util$views$FitSystemBarUtils$Orientation     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kongzue.dialogx.util.views.FitSystemBarUtils$Orientation r1 = com.kongzue.dialogx.util.views.FitSystemBarUtils.Orientation.Bottom     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.util.views.FitSystemBarUtils.AnonymousClass6.<clinit>():void");
        }
    }

    private FitSystemBarUtils() {
    }

    public FitSystemBarUtils(View view, CallBack callBack2) {
        this.contentView = view;
        this.callBack = callBack2;
        applyWindowInsets();
    }

    public void applyWindowInsets() {
        final RelativePadding relativePadding = new RelativePadding(ViewCompat.getPaddingStart(this.contentView), this.contentView.getPaddingTop(), ViewCompat.getPaddingEnd(this.contentView), this.contentView.getPaddingBottom());
        ViewCompat.setOnApplyWindowInsetsListener(this.contentView, new FitSystemBarUtils$$ExternalSyntheticLambda0(this, relativePadding));
        if (Build.VERSION.SDK_INT >= 30) {
            log("FitSystemBarUtils: setWindowInsetsAnimationCallback");
            ViewCompat.setWindowInsetsAnimationCallback(this.contentView, new WindowInsetsAnimationCompat.Callback(1) {
                public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
                    FitSystemBarUtils.this.log("FitSystemBarUtils: setWindowInsetsAnimationCallback#onProgress: " + windowInsetsCompat);
                    if (FitSystemBarUtils.this.smoothPadding) {
                        FitSystemBarUtils.this.formatInsets(windowInsetsCompat, new RelativePadding(relativePadding));
                    }
                    return windowInsetsCompat;
                }

                public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                    FitSystemBarUtils.this.log("FitSystemBarUtils: setWindowInsetsAnimationCallback#onEnd ");
                    boolean unused = FitSystemBarUtils.this.inSmoothingPadding = false;
                    super.onEnd(windowInsetsAnimationCompat);
                }

                public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
                    FitSystemBarUtils fitSystemBarUtils = FitSystemBarUtils.this;
                    boolean unused = fitSystemBarUtils.inSmoothingPadding = fitSystemBarUtils.smoothPadding;
                    super.onPrepare(windowInsetsAnimationCompat);
                }
            });
        }
        if (ViewCompat.isAttachedToWindow(this.contentView)) {
            log("FitSystemBarUtils: AttachedToWindow ok");
            ViewCompat.requestApplyInsets(this.contentView);
            return;
        }
        log("FitSystemBarUtils: wait AttachedToWindow");
        this.contentView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewDetachedFromWindow(View view) {
            }

            public void onViewAttachedToWindow(View view) {
                view.removeOnAttachStateChangeListener(this);
                FitSystemBarUtils.this.log("FitSystemBarUtils: onViewAttachedToWindow");
                if (Build.VERSION.SDK_INT < 30 || FitSystemBarUtils.this.getAppTargetSDKVersion() < 30) {
                    final View view2 = (View) view.getParent();
                    if (FitSystemBarUtils.this.rootViewLayoutChangeListener != null) {
                        view2.removeOnLayoutChangeListener(FitSystemBarUtils.this.rootViewLayoutChangeListener);
                    }
                    FitSystemBarUtils.this.rootViewLayoutChangeListener = new View.OnLayoutChangeListener() {
                        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                            WindowInsets rootWindowInsets = view.getRootView().getRootWindowInsets();
                            if (rootWindowInsets != null) {
                                FitSystemBarUtils.this.log("    FitSystemBarUtils: RootView get Insets");
                                FitSystemBarUtils.this.formatInsets(WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets), new RelativePadding(relativePadding));
                                return;
                            }
                            FitSystemBarUtils.this.log("    FitSystemBarUtils: RootView not get Insets");
                        }
                    };
                    view2.addOnLayoutChangeListener(FitSystemBarUtils.this.rootViewLayoutChangeListener);
                    view2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                        public void onViewAttachedToWindow(View view) {
                        }

                        public void onViewDetachedFromWindow(View view) {
                            view2.removeOnLayoutChangeListener(FitSystemBarUtils.this.rootViewLayoutChangeListener);
                        }
                    });
                }
                ViewCompat.requestApplyInsets(view);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$applyWindowInsets$0$com-kongzue-dialogx-util-views-FitSystemBarUtils  reason: not valid java name */
    public /* synthetic */ WindowInsetsCompat m137lambda$applyWindowInsets$0$comkongzuedialogxutilviewsFitSystemBarUtils(RelativePadding relativePadding, View view, WindowInsetsCompat windowInsetsCompat) {
        if (this.inSmoothingPadding) {
            return windowInsetsCompat;
        }
        formatInsets(windowInsetsCompat, new RelativePadding(relativePadding));
        return windowInsetsCompat;
    }

    /* access modifiers changed from: private */
    public void formatInsets(WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        DisplayCutoutCompat displayCutout;
        this.relativePaddingCache = relativePadding;
        boolean z = false;
        if (!this.safeCutOutPadding || (displayCutout = windowInsetsCompat.getDisplayCutout()) == null) {
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        } else {
            i3 = displayCutout.getSafeInsetTop();
            i2 = displayCutout.getSafeInsetLeft();
            i = displayCutout.getSafeInsetRight();
            i4 = displayCutout.getSafeInsetRight();
        }
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime() | WindowInsetsCompat.Type.systemBars());
        int i6 = insets.left;
        int i7 = insets.right;
        int windowSystemUiVisibility = this.contentView.getRootView().getWindowSystemUiVisibility();
        boolean z2 = Build.VERSION.SDK_INT >= 30 || (windowSystemUiVisibility & 4) == 0;
        if ((Build.VERSION.SDK_INT >= 30 || (windowSystemUiVisibility & 2) == 0) && (windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime()) || windowInsetsCompat.isVisible(WindowInsetsCompat.Type.navigationBars()))) {
            i5 = insets.bottom;
        } else {
            i5 = 0;
        }
        int i8 = (!z2 || !windowInsetsCompat.isVisible(WindowInsetsCompat.Type.statusBars())) ? 0 : insets.top;
        if (isWrongInsets(insets)) {
            log("    FitSystemBarUtils: isWrongInsets try special mode...");
            int checkOrientationAndStatusBarSide = checkOrientationAndStatusBarSide();
            if (checkOrientationAndStatusBarSide == 0) {
                relativePadding.start = getStatusBarHeight();
                relativePadding.end = getNavigationBarHeight();
            } else if (checkOrientationAndStatusBarSide != 1) {
                relativePadding.top = getStatusBarHeight();
                relativePadding.bottom = getNavigationBarHeight();
            } else {
                relativePadding.end = getStatusBarHeight();
                relativePadding.start = getNavigationBarHeight();
            }
            addListenerWhenImeHeightChanged();
        } else {
            if (this.callBack.isEnable(Orientation.Top)) {
                relativePadding.top += Math.max(i8, i3);
            }
            if (this.callBack.isEnable(Orientation.Bottom)) {
                relativePadding.bottom += Math.max(i5, i4);
            }
            if (ViewCompat.getLayoutDirection(this.contentView) == 1) {
                z = true;
            }
            if (this.callBack.isEnable(Orientation.Start)) {
                if (z) {
                    relativePadding.start += Math.max(i7, i);
                } else {
                    relativePadding.start += Math.max(i6, i2);
                }
            }
            if (this.callBack.isEnable(Orientation.End)) {
                if (z) {
                    relativePadding.end += Math.max(i6, i2);
                } else {
                    relativePadding.end += Math.max(i7, i);
                }
            }
        }
        applyCallBack(relativePadding);
    }

    /* access modifiers changed from: private */
    public void applyCallBack() {
        RelativePadding relativePadding = this.relativePaddingCache;
        if (relativePadding != null) {
            applyCallBack(relativePadding);
        }
    }

    private void applyCallBack(RelativePadding relativePadding) {
        if (this.callBack != null) {
            relativePadding.start += this.callBack.initialPadding(Orientation.Start);
            relativePadding.top += this.callBack.initialPadding(Orientation.Top);
            relativePadding.end += this.callBack.initialPadding(Orientation.End);
            relativePadding.bottom += this.callBack.initialPadding(Orientation.Bottom);
            relativePadding.applyToView(this.contentView);
            log("    KONGZUE DEBUG DIALOGX FitSystemBarUtils callBack: left=" + relativePadding.start + " top=" + relativePadding.top + " right=" + relativePadding.end + " bottom=" + relativePadding.bottom);
            this.callBack.unsafeRect(relativePadding.start, relativePadding.top, relativePadding.end, relativePadding.bottom + (this.specialMode ? this.specialModeImeHeight : 0));
        }
    }

    private boolean isWrongInsets(Insets insets) {
        return insets.top == 0 && insets.bottom == 0 && insets.left == 0 && insets.right == 0;
    }

    public static class RelativePadding {
        int bottom;
        int end;
        int start;
        int top;

        public RelativePadding(int i, int i2, int i3, int i4) {
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public RelativePadding(RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }

        public void applyToView(View view) {
            if (!(view instanceof DialogXBaseRelativeLayout)) {
                ViewCompat.setPaddingRelative(view, this.start, this.top, this.end, this.bottom);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        if (DialogXBaseRelativeLayout.debugMode && DialogX.DEBUGMODE) {
            Log.e(">>>", str);
        }
    }

    private int getStatusBarHeight() {
        Resources resources;
        if (isFullScreen()) {
            return 0;
        }
        View view = this.contentView;
        if (view == null || view.getContext() == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.contentView.getContext().getResources();
        }
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private int getNavigationBarHeight() {
        Resources resources;
        if (isFullScreen()) {
            return 0;
        }
        View view = this.contentView;
        if (view == null || view.getContext() == null) {
            resources = Resources.getSystem();
        } else {
            resources = this.contentView.getContext().getResources();
        }
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private boolean isFullScreen() {
        Activity topActivity = BaseDialog.getTopActivity();
        if (topActivity == null) {
            return false;
        }
        if ((topActivity.getWindow().getAttributes().flags & 1024) == 0 && (topActivity.getWindow().getDecorView().getSystemUiVisibility() & 4) == 0) {
            return false;
        }
        return true;
    }

    private int checkOrientationAndStatusBarSide() {
        Activity topActivity = BaseDialog.getTopActivity();
        if (topActivity == null || topActivity.getResources().getConfiguration().orientation != 2) {
            return 0;
        }
        int rotation = topActivity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return -1;
        }
        if (rotation != 3) {
            return 0;
        }
        return 1;
    }

    private void addListenerWhenImeHeightChanged() {
        this.specialMode = true;
        Activity topActivity = BaseDialog.getTopActivity();
        if (topActivity != null) {
            final View decorView = topActivity.getWindow().getDecorView();
            if (this.onGlobalLayoutListener != null) {
                decorView.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
            }
            ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
            AnonymousClass5 r2 = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    Rect rect = new Rect();
                    decorView.getWindowVisibleDisplayFrame(rect);
                    int height = decorView.getHeight() - rect.bottom;
                    if (height != FitSystemBarUtils.this.specialModeImeHeight) {
                        int unused = FitSystemBarUtils.this.specialModeImeHeight = height;
                        FitSystemBarUtils.this.log("    FitSystemBarUtils: specialModeImeHeight=" + FitSystemBarUtils.this.specialModeImeHeight);
                        FitSystemBarUtils.this.applyCallBack();
                    }
                }
            };
            this.onGlobalLayoutListener = r2;
            viewTreeObserver.addOnGlobalLayoutListener(r2);
        }
    }

    /* access modifiers changed from: private */
    public int getAppTargetSDKVersion() {
        try {
            Context applicationContext = BaseDialog.getApplicationContext();
            return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 0).targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
