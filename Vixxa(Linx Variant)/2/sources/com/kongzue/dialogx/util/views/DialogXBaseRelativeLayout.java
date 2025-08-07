package com.kongzue.dialogx.util.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.interfaces.DialogXBaseBottomDialog;
import com.kongzue.dialogx.interfaces.NoTouchInterface;
import com.kongzue.dialogx.interfaces.OnSafeInsetsChangeListener;
import com.kongzue.dialogx.util.views.FitSystemBarUtils;
import java.lang.ref.WeakReference;

public class DialogXBaseRelativeLayout extends RelativeLayout {
    public static boolean debugMode = false;
    private boolean autoUnsafePlacePadding = true;
    int[] extraPadding = new int[4];
    private FitSystemBarUtils fitSystemBarUtils;
    private boolean focusable = true;
    private boolean interceptBack = true;
    private boolean isInited = false;
    boolean isLightMode = true;
    float nowBkgAlphaValue;
    private PrivateBackPressedListener onBackPressedListener;
    private OnLifecycleCallBack onLifecycleCallBack;
    /* access modifiers changed from: private */
    public OnSafeInsetsChangeListener onSafeInsetsChangeListener;
    private WeakReference<BaseDialog> parentDialog;
    private WeakReference<View> requestFocusView;
    boolean touch;
    float touchDownX;
    float touchDownY;
    protected Rect unsafePlace = new Rect();

    public static abstract class OnLifecycleCallBack {
        public abstract void onDismiss();

        public void onShow() {
        }
    }

    public interface PrivateBackPressedListener {
        boolean onBackPressed();
    }

    public FitSystemBarUtils getFitSystemBarUtils() {
        return this.fitSystemBarUtils;
    }

    public DialogXBaseRelativeLayout(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public DialogXBaseRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public DialogXBaseRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        if (!this.isInited) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DialogXBaseRelativeLayout);
                this.focusable = obtainStyledAttributes.getBoolean(R.styleable.DialogXBaseRelativeLayout_baseFocusable, true);
                this.autoUnsafePlacePadding = obtainStyledAttributes.getBoolean(R.styleable.DialogXBaseRelativeLayout_autoSafeArea, true);
                this.interceptBack = obtainStyledAttributes.getBoolean(R.styleable.DialogXBaseRelativeLayout_interceptBack, true);
                obtainStyledAttributes.recycle();
                this.isInited = true;
            }
            if (this.focusable) {
                setFocusable(true);
                setFocusableInTouchMode(true);
            }
            setBkgAlpha(0.0f);
            if (!(getParentDialog() == null || getParentDialog().getDialogImplMode() == DialogX.IMPL_MODE.VIEW)) {
                setFitsSystemWindows(true);
            }
            setClipChildren(false);
            setClipToPadding(false);
            log("KONGZUE DEBUG DIALOGX: create fitSystemBarUtils");
            this.fitSystemBarUtils = FitSystemBarUtils.attachView(this, new FitSystemBarUtils.CallBack() {
                public boolean isEnable(FitSystemBarUtils.Orientation orientation) {
                    return true;
                }

                public void unsafeRect(int i, int i2, int i3, int i4) {
                    DialogXBaseRelativeLayout.this.log("KONGZUE DEBUG DIALOGX: unsafeRect t=" + i2 + " b=" + i4);
                    if (DialogXBaseRelativeLayout.this.unsafePlace == null) {
                        DialogXBaseRelativeLayout.this.unsafePlace = new Rect();
                    }
                    Insets insets = null;
                    if (DialogXBaseRelativeLayout.this.getRootWindowInsets() != null) {
                        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(DialogXBaseRelativeLayout.this.getRootWindowInsets());
                        boolean isVisible = windowInsetsCompat.isVisible(WindowInsetsCompat.Type.navigationBars());
                        if (!windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime()) && isVisible) {
                            Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                            if (!(insets2.bottom == i4 && insets2.top == i2 && insets2.left == i && insets2.right == i3)) {
                                insets = insets2;
                            }
                        }
                    }
                    if (insets != null) {
                        DialogXBaseRelativeLayout.this.unsafePlace.left = Math.max(insets.left, i);
                        DialogXBaseRelativeLayout.this.unsafePlace.top = Math.max(insets.top, i2);
                        DialogXBaseRelativeLayout.this.unsafePlace.right = Math.max(insets.right, i3);
                        DialogXBaseRelativeLayout.this.unsafePlace.bottom = Math.max(insets.bottom, i4);
                    } else {
                        DialogXBaseRelativeLayout.this.unsafePlace.left = i;
                        DialogXBaseRelativeLayout.this.unsafePlace.top = i2;
                        DialogXBaseRelativeLayout.this.unsafePlace.right = i3;
                        DialogXBaseRelativeLayout.this.unsafePlace.bottom = i4;
                    }
                    if (DialogXBaseRelativeLayout.this.onSafeInsetsChangeListener != null) {
                        DialogXBaseRelativeLayout.this.onSafeInsetsChangeListener.onChange(DialogXBaseRelativeLayout.this.unsafePlace);
                    }
                    DialogXBaseRelativeLayout dialogXBaseRelativeLayout = DialogXBaseRelativeLayout.this;
                    dialogXBaseRelativeLayout.setUnsafePadding(dialogXBaseRelativeLayout.unsafePlace.left, DialogXBaseRelativeLayout.this.unsafePlace.top, DialogXBaseRelativeLayout.this.unsafePlace.right, DialogXBaseRelativeLayout.this.unsafePlace.bottom);
                }

                public int initialPadding(FitSystemBarUtils.Orientation orientation) {
                    int i = AnonymousClass2.$SwitchMap$com$kongzue$dialogx$util$views$FitSystemBarUtils$Orientation[orientation.ordinal()];
                    if (i == 1) {
                        return DialogXBaseRelativeLayout.this.extraPadding[0];
                    }
                    if (i == 2) {
                        return DialogXBaseRelativeLayout.this.extraPadding[1];
                    }
                    if (i == 3) {
                        return DialogXBaseRelativeLayout.this.extraPadding[2];
                    }
                    if (i != 4) {
                        return 0;
                    }
                    return DialogXBaseRelativeLayout.this.extraPadding[3];
                }
            });
        }
    }

    /* renamed from: com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout.AnonymousClass2.<clinit>():void");
        }
    }

    public void setUnsafePadding(int i, int i2, int i3, int i4) {
        log("KONGZUE DEBUG DIALOGX: setUnsafePadding=" + getParentDialog() + " t=" + i2 + " b=" + i4);
        if (getParentDialog() instanceof DialogXBaseBottomDialog) {
            log("  KONGZUE DEBUG DIALOGX: isDialogXBaseBottomDialog");
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.bkg);
            if (!((DialogXBaseBottomDialog) getParentDialog()).isBottomNonSafetyAreaBySelf() && viewGroup != null) {
                log("    KONGZUE DEBUG DIALOGX: bkgView.setPadding b=" + i4);
                viewGroup.setPadding(0, 0, 0, i4);
            }
            i4 = 0;
        }
        if (isAutoUnsafePlacePadding()) {
            log("  KONGZUE DEBUG DIALOGX: root.setPadding t=" + i2 + " b=" + i4);
            setPadding(i, i2, i3, i4);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        PrivateBackPressedListener privateBackPressedListener;
        log("#dispatchKeyEvent: KeyCode=" + keyEvent.getKeyCode());
        if (!isAttachedToWindow() || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 4 || !this.interceptBack || (privateBackPressedListener = this.onBackPressedListener) == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return privateBackPressedListener.onBackPressed();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.touch = true;
            this.touchDownX = motionEvent.getX();
            this.touchDownY = motionEvent.getY();
        } else if (action == 1 && this.touch && findFocus() != this && getParentDialog() != null) {
            float dip2px = (float) getParentDialog().dip2px(5.0f);
            if (Math.abs(motionEvent.getX() - this.touchDownX) <= dip2px && Math.abs(motionEvent.getY() - this.touchDownY) <= dip2px) {
                callOnClick();
            }
        }
        if (getParentDialog() instanceof NoTouchInterface) {
            return super.onTouchEvent(motionEvent);
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && getParentDialog() != null && getParentDialog().getOwnActivity() != null) {
            OnLifecycleCallBack onLifecycleCallBack2 = this.onLifecycleCallBack;
            if (onLifecycleCallBack2 != null) {
                onLifecycleCallBack2.onShow();
            }
            this.isLightMode = (getResources().getConfiguration().uiMode & 48) == 16;
            if (this.focusable) {
                requestFocus();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        OnLifecycleCallBack onLifecycleCallBack2 = this.onLifecycleCallBack;
        if (onLifecycleCallBack2 != null) {
            onLifecycleCallBack2.onDismiss();
        }
        this.onSafeInsetsChangeListener = null;
        super.onDetachedFromWindow();
    }

    public boolean performClick() {
        if (!isEnabled()) {
            return false;
        }
        return super.performClick();
    }

    public boolean callOnClick() {
        if (!isEnabled()) {
            return false;
        }
        return super.callOnClick();
    }

    public DialogXBaseRelativeLayout setOnLifecycleCallBack(OnLifecycleCallBack onLifecycleCallBack2) {
        this.onLifecycleCallBack = onLifecycleCallBack2;
        return this;
    }

    public float getSafeHeight() {
        return (float) ((getMeasuredHeight() - this.unsafePlace.bottom) - this.unsafePlace.top);
    }

    public void bindFocusView(View view) {
        if (view != this) {
            this.requestFocusView = new WeakReference<>(view);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        WeakReference<View> weakReference;
        if (getParentDialog() != null && (getParentDialog() instanceof NoTouchInterface)) {
            return false;
        }
        if (i == 130 && (weakReference = this.requestFocusView) != null && weakReference.get() != null && this.requestFocusView.get() != this) {
            return ((View) this.requestFocusView.get()).requestFocus();
        }
        View findFocus = findFocus();
        if (findFocus == null || findFocus == this) {
            return super.requestFocus(i, rect);
        }
        findFocus.requestFocus();
        return true;
    }

    public void requestFocusOnResume() {
        View findFocus = findFocus();
        if (findFocus == null || findFocus == this) {
            requestFocus();
        } else {
            findFocus.requestFocus();
        }
    }

    public DialogXBaseRelativeLayout setOnBackPressedListener(PrivateBackPressedListener privateBackPressedListener) {
        this.onBackPressedListener = privateBackPressedListener;
        return this;
    }

    public OnSafeInsetsChangeListener getOnSafeInsetsChangeListener() {
        return this.onSafeInsetsChangeListener;
    }

    public DialogXBaseRelativeLayout setOnSafeInsetsChangeListener(OnSafeInsetsChangeListener onSafeInsetsChangeListener2) {
        this.onSafeInsetsChangeListener = onSafeInsetsChangeListener2;
        return this;
    }

    public boolean isAutoUnsafePlacePadding() {
        return this.autoUnsafePlacePadding;
    }

    public Rect getUnsafePlace() {
        return this.unsafePlace;
    }

    public DialogXBaseRelativeLayout setAutoUnsafePlacePadding(boolean z) {
        this.autoUnsafePlacePadding = z;
        return this;
    }

    public BaseDialog getParentDialog() {
        WeakReference<BaseDialog> weakReference = this.parentDialog;
        if (weakReference == null) {
            return null;
        }
        return (BaseDialog) weakReference.get();
    }

    public DialogXBaseRelativeLayout setParentDialog(BaseDialog baseDialog) {
        this.parentDialog = new WeakReference<>(baseDialog);
        if (!(baseDialog == null || baseDialog.getDialogImplMode() == DialogX.IMPL_MODE.VIEW)) {
            setFitsSystemWindows(true);
        }
        if (this.unsafePlace != null) {
            log("KONGZUE DEBUG DIALOGX: setParentDialog()=" + getParentDialog());
            setUnsafePadding(this.unsafePlace.left, this.unsafePlace.top, this.unsafePlace.right, this.unsafePlace.bottom);
        } else {
            log("KONGZUE DEBUG DIALOGX: setParentDialog() unsafePlace is null");
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.isLightMode != ((configuration.uiMode & 48) == 16) && DialogX.globalTheme == DialogX.THEME.AUTO && getParentDialog() != null) {
            getParentDialog().restartDialog();
        }
    }

    public DialogXBaseRelativeLayout setBkgAlpha(float f) {
        this.nowBkgAlphaValue = f;
        if (getBackground() != null) {
            getBackground().mutate().setAlpha((int) (f * 255.0f));
        }
        return this;
    }

    public void setBackground(Drawable drawable) {
        drawable.setAlpha((int) (this.nowBkgAlphaValue * 255.0f));
        super.setBackground(drawable);
    }

    public void setBackgroundColor(int i) {
        setBackground(new ColorDrawable(i));
    }

    public boolean isBaseFocusable() {
        return this.focusable;
    }

    public boolean isInterceptBack() {
        return this.interceptBack;
    }

    public DialogXBaseRelativeLayout setInterceptBack(boolean z) {
        this.interceptBack = z;
        return this;
    }

    public void setVisibility(int i) {
        if (i == 8 && getAlpha() == 0.0f) {
            setAlpha(0.01f);
        }
        super.setVisibility(i);
    }

    public void setRootPadding(int i, int i2, int i3, int i4) {
        int[] iArr = this.extraPadding;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }

    public int getRootPaddingLeft() {
        return this.extraPadding[0];
    }

    public int getRootPaddingTop() {
        return this.extraPadding[1];
    }

    public int getRootPaddingRight() {
        return this.extraPadding[2];
    }

    public int getRootPaddingBottom() {
        return this.extraPadding[3];
    }

    public int getUseAreaWidth() {
        return getWidth() - getRootPaddingRight();
    }

    public int getUseAreaHeight() {
        return getHeight() - getRootPaddingBottom();
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        if (debugMode && DialogX.DEBUGMODE) {
            Log.e(">>>", str);
        }
    }
}
