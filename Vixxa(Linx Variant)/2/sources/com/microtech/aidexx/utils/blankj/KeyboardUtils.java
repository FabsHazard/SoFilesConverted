package com.microtech.aidexx.utils.blankj;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.microtech.aidexx.common.ExtendsKt;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0018\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\tJ\u0010\u0010\u001e\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/utils/blankj/KeyboardUtils;", "", "()V", "TAG_ON_GLOBAL_LAYOUT_LISTENER", "", "millis", "", "sDecorViewDelta", "KeyboardUtils", "", "clickBlankArea2HideSoftInput", "fixAndroidBug5497", "activity", "Landroid/app/Activity;", "window", "Landroid/view/Window;", "fixSoftInputLeaks", "getContentViewInvisibleHeight", "getDecorViewInvisibleHeight", "getNavBarHeight", "getStatusBarHeight", "hideSoftInput", "view", "Landroid/view/View;", "hideSoftInputByToggle", "isSoftInputVisible", "", "registerSoftInputChangedListener", "listener", "Lcom/microtech/aidexx/utils/blankj/KeyboardUtils$OnSoftInputChangedListener;", "showSoftInput", "flags", "toggleSoftInput", "unregisterSoftInputChangedListener", "OnSoftInputChangedListener", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: KeyboardUtils.kt */
public final class KeyboardUtils {
    public static final KeyboardUtils INSTANCE = new KeyboardUtils();
    private static final int TAG_ON_GLOBAL_LAYOUT_LISTENER = -8;
    private static long millis;
    private static int sDecorViewDelta;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/utils/blankj/KeyboardUtils$OnSoftInputChangedListener;", "", "onSoftInputChanged", "", "height", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: KeyboardUtils.kt */
    public interface OnSoftInputChangedListener {
        void onSoftInputChanged(int i);
    }

    public final void clickBlankArea2HideSoftInput() {
    }

    private KeyboardUtils() {
    }

    private final void KeyboardUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public final void showSoftInput() {
        Object systemService = ExtendsKt.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).toggleSoftInput(2, 1);
    }

    public final void showSoftInput(Activity activity) {
        if (activity != null && !isSoftInputVisible(activity)) {
            toggleSoftInput();
        }
    }

    public final void showSoftInput(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        showSoftInput(view, 0);
    }

    public final void showSoftInput(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object systemService = ExtendsKt.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, i, new KeyboardUtils$showSoftInput$1(new Handler()));
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public final void hideSoftInput(Activity activity) {
        if (activity != null) {
            hideSoftInput(activity.getWindow());
        }
    }

    public final void hideSoftInput(Window window) {
        if (window != null) {
            View currentFocus = window.getCurrentFocus();
            if (currentFocus == null) {
                View decorView = window.getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                View findViewWithTag = decorView.findViewWithTag("keyboardTagView");
                if (findViewWithTag == null) {
                    findViewWithTag = new EditText(window.getContext());
                    ((EditText) findViewWithTag).setTag("keyboardTagView");
                    ((ViewGroup) decorView).addView(findViewWithTag, 0, 0);
                }
                currentFocus = findViewWithTag;
                currentFocus.requestFocus();
            }
            hideSoftInput(currentFocus);
        }
    }

    public final void hideSoftInput(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object systemService = ExtendsKt.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public final void hideSoftInputByToggle(Activity activity) {
        if (activity != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(elapsedRealtime - millis) > 500 && isSoftInputVisible(activity)) {
                toggleSoftInput();
            }
            millis = elapsedRealtime;
        }
    }

    public final void toggleSoftInput() {
        Object systemService = ExtendsKt.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).toggleSoftInput(0, 0);
    }

    public final boolean isSoftInputVisible(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        return getDecorViewInvisibleHeight(window) > 0;
    }

    private final int getDecorViewInvisibleHeight(Window window) {
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom));
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs > getNavBarHeight() + getStatusBarHeight()) {
            return abs - sDecorViewDelta;
        }
        sDecorViewDelta = abs;
        return 0;
    }

    public final void registerSoftInputChangedListener(Activity activity, OnSoftInputChangedListener onSoftInputChangedListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onSoftInputChangedListener, "listener");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        registerSoftInputChangedListener(window, onSoftInputChangedListener);
    }

    public final void registerSoftInputChangedListener(Window window, OnSoftInputChangedListener onSoftInputChangedListener) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(onSoftInputChangedListener, "listener");
        if ((window.getAttributes().flags & 512) != 0) {
            window.clearFlags(512);
        }
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        KeyboardUtils$$ExternalSyntheticLambda1 keyboardUtils$$ExternalSyntheticLambda1 = new KeyboardUtils$$ExternalSyntheticLambda1(window, new int[]{getDecorViewInvisibleHeight(window)}, onSoftInputChangedListener);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(keyboardUtils$$ExternalSyntheticLambda1);
        frameLayout.setTag(TAG_ON_GLOBAL_LAYOUT_LISTENER, keyboardUtils$$ExternalSyntheticLambda1);
    }

    /* access modifiers changed from: private */
    public static final void registerSoftInputChangedListener$lambda$0(Window window, int[] iArr, OnSoftInputChangedListener onSoftInputChangedListener) {
        Intrinsics.checkNotNullParameter(window, "$window");
        Intrinsics.checkNotNullParameter(iArr, "$decorViewInvisibleHeightPre");
        Intrinsics.checkNotNullParameter(onSoftInputChangedListener, "$listener");
        int decorViewInvisibleHeight = INSTANCE.getDecorViewInvisibleHeight(window);
        if (iArr[0] != decorViewInvisibleHeight) {
            onSoftInputChangedListener.onSoftInputChanged(decorViewInvisibleHeight);
            iArr[0] = decorViewInvisibleHeight;
        }
    }

    public final void unregisterSoftInputChangedListener(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        View findViewById = window.findViewById(16908290);
        if (findViewById != null) {
            Object tag = findViewById.getTag(TAG_ON_GLOBAL_LAYOUT_LISTENER);
            if (tag instanceof ViewTreeObserver.OnGlobalLayoutListener) {
                findViewById.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) tag);
                findViewById.setTag(TAG_ON_GLOBAL_LAYOUT_LISTENER, (Object) null);
            }
        }
    }

    public final void fixAndroidBug5497(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        fixAndroidBug5497(window);
    }

    public final void fixAndroidBug5497(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.setSoftInputMode(window.getAttributes().softInputMode & -17);
        FrameLayout frameLayout = (FrameLayout) window.findViewById(16908290);
        View childAt = frameLayout.getChildAt(0);
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new KeyboardUtils$$ExternalSyntheticLambda0(window, new int[]{getContentViewInvisibleHeight(window)}, childAt, childAt.getPaddingBottom()));
    }

    /* access modifiers changed from: private */
    public static final void fixAndroidBug5497$lambda$1(Window window, int[] iArr, View view, int i) {
        Intrinsics.checkNotNullParameter(window, "$window");
        Intrinsics.checkNotNullParameter(iArr, "$contentViewInvisibleHeightPre5497");
        KeyboardUtils keyboardUtils = INSTANCE;
        int contentViewInvisibleHeight = keyboardUtils.getContentViewInvisibleHeight(window);
        if (iArr[0] != contentViewInvisibleHeight) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i + keyboardUtils.getDecorViewInvisibleHeight(window));
            iArr[0] = contentViewInvisibleHeight;
        }
    }

    public final int getStatusBarHeight() {
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "getSystem(...)");
        return system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public final int getNavBarHeight() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final int getContentViewInvisibleHeight(Window window) {
        View findViewById = window.findViewById(16908290);
        if (findViewById == null) {
            return 0;
        }
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getContentViewInvisibleHeight: " + (findViewById.getBottom() - rect.bottom));
        int abs = Math.abs(findViewById.getBottom() - rect.bottom);
        if (abs <= getStatusBarHeight() + getNavBarHeight()) {
            return 0;
        }
        return abs;
    }

    public final void fixSoftInputLeaks(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        fixSoftInputLeaks(window);
    }

    public final void fixSoftInputLeaks(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        Object systemService = ExtendsKt.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 4; i++) {
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i]);
                Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                Object obj = declaredField.get(inputMethodManager);
                View view = obj instanceof View ? (View) obj : null;
                if (view != null) {
                    if (view.getRootView() == window.getDecorView().getRootView()) {
                        declaredField.set(inputMethodManager, (Object) null);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
