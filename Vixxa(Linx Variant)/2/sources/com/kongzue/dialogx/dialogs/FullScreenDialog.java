package com.kongzue.dialogx.dialogs;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.interfaces.DialogConvertViewInterface;
import com.kongzue.dialogx.interfaces.DialogLifecycleCallback;
import com.kongzue.dialogx.interfaces.DialogXAnimInterface;
import com.kongzue.dialogx.interfaces.DialogXBaseBottomDialog;
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.OnBackPressedListener;
import com.kongzue.dialogx.interfaces.OnBackgroundMaskClickListener;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.interfaces.OnSafeInsetsChangeListener;
import com.kongzue.dialogx.interfaces.ScrollController;
import com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor;
import com.kongzue.dialogx.util.views.ActivityScreenShotImageView;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;

public class FullScreenDialog extends BaseDialog implements DialogXBaseBottomDialog {
    public static final int ACTIVITY_CONTENT_RADIUS_DEFAULT = -1;
    public static final int ACTIVITY_CONTENT_RADIUS_KEEP = -2;
    public static BaseDialog.BOOLEAN overrideCancelable = null;
    public static int overrideEnterDuration = -1;
    public static int overrideExitDuration = -1;
    protected float activityContentRadius = -1.0f;
    protected boolean allowInterceptTouch = true;
    protected float backgroundRadius = -1.0f;
    protected boolean bottomNonSafetyAreaBySelf = false;
    private Integer deviceRadiusCache;
    protected DialogImpl dialogImpl;
    protected DialogLifecycleCallback<FullScreenDialog> dialogLifecycleCallback;
    protected DialogXAnimInterface<FullScreenDialog> dialogXAnimImpl;
    protected boolean hideActivityContentView;
    protected boolean hideWithExitAnim;
    protected boolean hideZoomBackground;
    private boolean isHide;
    protected Integer maskColor = null;
    protected FullScreenDialog me = this;
    protected OnBackPressedListener<FullScreenDialog> onBackPressedListener;
    protected OnBackgroundMaskClickListener<FullScreenDialog> onBackgroundMaskClickListener;
    protected OnBindView<FullScreenDialog> onBindView;
    protected BaseDialog.BOOLEAN privateCancelable;

    /* access modifiers changed from: private */
    public float getActivityZoomRadius(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public void onDismiss(FullScreenDialog fullScreenDialog) {
    }

    public void onShow(FullScreenDialog fullScreenDialog) {
    }

    protected FullScreenDialog() {
    }

    public static FullScreenDialog build() {
        return new FullScreenDialog();
    }

    public static FullScreenDialog build(OnBindView<FullScreenDialog> onBindView2) {
        return new FullScreenDialog(onBindView2);
    }

    public FullScreenDialog(OnBindView<FullScreenDialog> onBindView2) {
        this.onBindView = onBindView2;
    }

    public static FullScreenDialog show(OnBindView<FullScreenDialog> onBindView2) {
        FullScreenDialog fullScreenDialog = new FullScreenDialog(onBindView2);
        fullScreenDialog.show();
        return fullScreenDialog;
    }

    public FullScreenDialog show() {
        if (!this.isHide || getDialogView() == null || !this.isShow) {
            super.beforeShow();
            if (getDialogView() == null) {
                View createView = createView(isLightTheme() ? R.layout.layout_dialogx_fullscreen : R.layout.layout_dialogx_fullscreen_dark);
                this.dialogImpl = new DialogImpl(createView);
                if (createView != null) {
                    createView.setTag(this.me);
                }
                show(createView);
            } else {
                show(getDialogView());
            }
            return this;
        }
        if (!this.hideWithExitAnim || getDialogImpl() == null) {
            getDialogView().setVisibility(0);
        } else {
            getDialogView().setVisibility(0);
            getDialogImpl().getDialogXAnimImpl().doShowAnim(this.me, getDialogImpl().bkg);
        }
        return this;
    }

    public void show(Activity activity) {
        super.beforeShow();
        if (getDialogView() == null) {
            View createView = createView(isLightTheme() ? R.layout.layout_dialogx_fullscreen : R.layout.layout_dialogx_fullscreen_dark);
            this.dialogImpl = new DialogImpl(createView);
            if (createView != null) {
                createView.setTag(this.me);
            }
            show(activity, createView);
            return;
        }
        show(activity, getDialogView());
    }

    public class DialogImpl implements DialogConvertViewInterface {
        public MaxRelativeLayout bkg;
        public float bkgEnterAimY = -1.0f;
        public RelativeLayout boxBkg;
        public RelativeLayout boxCustom;
        public DialogXBaseRelativeLayout boxRoot;
        /* access modifiers changed from: private */
        public boolean enterAnimRunning = true;
        protected int enterY;
        /* access modifiers changed from: private */
        public FullScreenDialogTouchEventInterceptor fullScreenDialogTouchEventInterceptor;
        public ActivityScreenShotImageView imgZoomActivity;
        /* access modifiers changed from: private */
        public Rect mUnsafeRect = new Rect(0, 0, 0, 0);
        public ScrollController scrollView;

        public DialogImpl setScrollView(ScrollController scrollController) {
            this.scrollView = scrollController;
            return this;
        }

        public DialogImpl(View view) {
            if (view != null) {
                FullScreenDialog.this.setDialogView(view);
                this.imgZoomActivity = (ActivityScreenShotImageView) view.findViewById(R.id.img_zoom_activity);
                this.boxRoot = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
                this.boxBkg = (RelativeLayout) view.findViewById(R.id.box_bkg);
                this.bkg = (MaxRelativeLayout) view.findViewById(R.id.bkg);
                this.boxCustom = (RelativeLayout) view.findViewById(R.id.box_custom);
                this.imgZoomActivity.hideActivityContentView = FullScreenDialog.this.hideActivityContentView;
                this.imgZoomActivity.bindDialog(FullScreenDialog.this);
                if (FullScreenDialog.this.hideZoomBackground) {
                    view.setBackgroundResource(R.color.black20);
                    this.imgZoomActivity.setVisibility(8);
                } else {
                    view.setBackgroundResource(R.color.black);
                    this.imgZoomActivity.setVisibility(0);
                }
                init();
                FullScreenDialog.this.dialogImpl = this;
                refreshView();
            }
        }

        public float getEnterY() {
            return Math.max(0.0f, this.boxRoot.getSafeHeight() - ((float) this.enterY));
        }

        public void init() {
            this.boxRoot.setParentDialog(FullScreenDialog.this.me);
            this.boxRoot.setOnLifecycleCallBack(new DialogXBaseRelativeLayout.OnLifecycleCallBack() {
                public void onShow() {
                    boolean unused = FullScreenDialog.this.isShow = true;
                    boolean unused2 = FullScreenDialog.this.preShow = false;
                    FullScreenDialog.this.setLifecycleState(Lifecycle.State.CREATED);
                    FullScreenDialog.this.onDialogShow();
                    FullScreenDialog.this.getDialogLifecycleCallback().onShow(FullScreenDialog.this.me);
                    FullScreenDialog.this.onShow(FullScreenDialog.this.me);
                }

                public void onDismiss() {
                    boolean unused = FullScreenDialog.this.isShow = false;
                    FullScreenDialog.this.getDialogLifecycleCallback().onDismiss(FullScreenDialog.this.me);
                    FullScreenDialog.this.onDismiss(FullScreenDialog.this.me);
                    FullScreenDialogTouchEventInterceptor unused2 = DialogImpl.this.fullScreenDialogTouchEventInterceptor = null;
                    FullScreenDialog.this.dialogImpl = null;
                    FullScreenDialog.this.dialogLifecycleCallback = null;
                    FullScreenDialog.this.setLifecycleState(Lifecycle.State.DESTROYED);
                    System.gc();
                }
            });
            this.boxRoot.setOnBackPressedListener(new DialogXBaseRelativeLayout.PrivateBackPressedListener() {
                public boolean onBackPressed() {
                    if (FullScreenDialog.this.onBackPressedListener != null) {
                        if (!FullScreenDialog.this.onBackPressedListener.onBackPressed(FullScreenDialog.this.me)) {
                            return true;
                        }
                        FullScreenDialog.this.dismiss();
                        return true;
                    } else if (!FullScreenDialog.this.isCancelable()) {
                        return true;
                    } else {
                        FullScreenDialog.this.dismiss();
                        return true;
                    }
                }
            });
            this.fullScreenDialogTouchEventInterceptor = new FullScreenDialogTouchEventInterceptor(FullScreenDialog.this.me, FullScreenDialog.this.dialogImpl);
            this.boxRoot.setBkgAlpha(0.0f);
            this.bkg.setY((float) this.boxRoot.getHeight());
            this.boxRoot.post(new Runnable() {
                public void run() {
                    DialogImpl.this.getDialogXAnimImpl().doShowAnim(FullScreenDialog.this.me, DialogImpl.this.bkg);
                    FullScreenDialog.this.setLifecycleState(Lifecycle.State.RESUMED);
                }
            });
            this.boxRoot.setOnSafeInsetsChangeListener(new OnSafeInsetsChangeListener() {
                public void onChange(Rect rect) {
                    DialogImpl.this.mUnsafeRect.set(rect);
                    DialogImpl.this.makeEnterY();
                    if (!DialogImpl.this.enterAnimRunning) {
                        DialogImpl.this.bkg.setY(DialogImpl.this.getEnterY());
                    }
                }
            });
            this.bkg.setOnYChanged(new MaxRelativeLayout.OnYChanged() {
                public void y(float f) {
                    float top = f + ((float) DialogImpl.this.bkg.getTop());
                    float f2 = 1.0f;
                    float height = 1.0f - ((((float) DialogImpl.this.boxRoot.getHeight()) - top) * 2.0E-5f);
                    if (height <= 1.0f) {
                        f2 = height;
                    }
                    if (!FullScreenDialog.this.hideZoomBackground) {
                        DialogImpl.this.imgZoomActivity.setScale(f2);
                        DialogImpl.this.imgZoomActivity.setRadius(FullScreenDialog.this.getActivityZoomRadius((float) FullScreenDialog.this.getDeviceRadius(), FullScreenDialog.this.getActivityContentRadius(), (((float) DialogImpl.this.boxRoot.getHeight()) - top) / ((float) DialogImpl.this.boxRoot.getHeight())));
                    }
                }
            });
            this.boxCustom.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    if (i8 - i6 != i4 - i2 && !DialogImpl.this.enterAnimRunning && !DialogImpl.this.boxRoot.getFitSystemBarUtils().isInSmoothingPadding()) {
                        DialogImpl.this.makeEnterY();
                        float safeHeight = ((DialogImpl.this.boxRoot.getSafeHeight() - ((float) DialogImpl.this.mUnsafeRect.bottom)) - ((float) DialogImpl.this.enterY)) - ((float) DialogImpl.this.boxRoot.getUnsafePlace().top);
                        if (safeHeight < 0.0f) {
                            safeHeight = 0.0f;
                        }
                        if (safeHeight != DialogImpl.this.bkgEnterAimY && DialogImpl.this.bkg.getY() != safeHeight) {
                            float f = DialogImpl.this.bkgEnterAimY;
                            DialogImpl.this.bkgEnterAimY = safeHeight;
                            DialogImpl.this.doShowAnimRepeat((int) f, (int) safeHeight, true);
                        } else if (DialogImpl.this.bkg.getY() != safeHeight) {
                            DialogImpl.this.bkg.setY(safeHeight);
                        }
                    }
                }
            });
            FullScreenDialog.this.onDialogInit();
        }

        private boolean isMatchParentHeightCustomView() {
            ViewGroup.LayoutParams layoutParams;
            if (FullScreenDialog.this.onBindView == null || FullScreenDialog.this.onBindView.getCustomView() == null || (layoutParams = FullScreenDialog.this.onBindView.getCustomView().getLayoutParams()) == null || layoutParams.height != -1) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public void makeEnterY() {
            int height = this.boxCustom.getHeight();
            if (height == 0 || isMatchParentHeightCustomView()) {
                height = (int) this.boxRoot.getSafeHeight();
            }
            this.enterY = height;
        }

        public void refreshView() {
            if (this.boxRoot != null && FullScreenDialog.this.getOwnActivity() != null) {
                this.boxRoot.setRootPadding(FullScreenDialog.this.screenPaddings[0], FullScreenDialog.this.screenPaddings[1], FullScreenDialog.this.screenPaddings[2], FullScreenDialog.this.screenPaddings[3]);
                if (FullScreenDialog.this.backgroundColor != null) {
                    FullScreenDialog fullScreenDialog = FullScreenDialog.this;
                    fullScreenDialog.tintColor(this.bkg, fullScreenDialog.backgroundColor.intValue());
                }
                this.bkg.setMaxWidth(FullScreenDialog.this.getMaxWidth());
                this.bkg.setMaxHeight(FullScreenDialog.this.getMaxHeight());
                this.bkg.setMinimumWidth(FullScreenDialog.this.getMinWidth());
                this.bkg.setMinimumHeight(FullScreenDialog.this.getMinHeight());
                if (FullScreenDialog.this.isCancelable()) {
                    this.boxRoot.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (FullScreenDialog.this.onBackgroundMaskClickListener == null || !FullScreenDialog.this.onBackgroundMaskClickListener.onClick(FullScreenDialog.this.me, view)) {
                                DialogImpl.this.doDismiss(view);
                            }
                        }
                    });
                } else {
                    this.boxRoot.setOnClickListener((View.OnClickListener) null);
                }
                if (FullScreenDialog.this.backgroundRadius > -1.0f) {
                    GradientDrawable gradientDrawable = (GradientDrawable) this.bkg.getBackground();
                    if (gradientDrawable != null) {
                        gradientDrawable.setCornerRadii(new float[]{FullScreenDialog.this.backgroundRadius, FullScreenDialog.this.backgroundRadius, FullScreenDialog.this.backgroundRadius, FullScreenDialog.this.backgroundRadius, 0.0f, 0.0f, 0.0f, 0.0f});
                    }
                    this.bkg.setOutlineProvider(new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, view.getWidth(), (int) (((float) view.getHeight()) + FullScreenDialog.this.backgroundRadius), FullScreenDialog.this.backgroundRadius);
                        }
                    });
                    this.bkg.setClipToOutline(true);
                }
                if (FullScreenDialog.this.maskColor != null) {
                    this.boxRoot.setBackgroundColor(FullScreenDialog.this.maskColor.intValue());
                }
                if (FullScreenDialog.this.onBindView != null) {
                    FullScreenDialog.this.onBindView.bindParent(this.boxCustom, FullScreenDialog.this.me);
                    if (FullScreenDialog.this.onBindView.getCustomView() instanceof ScrollController) {
                        this.scrollView = (ScrollController) FullScreenDialog.this.onBindView.getCustomView();
                    } else {
                        View findViewWithTag = FullScreenDialog.this.onBindView.getCustomView().findViewWithTag("ScrollController");
                        if (findViewWithTag instanceof ScrollController) {
                            this.scrollView = (ScrollController) findViewWithTag;
                        }
                    }
                }
                if (FullScreenDialog.this.hideZoomBackground) {
                    FullScreenDialog.this.getDialogView().setBackgroundResource(R.color.black20);
                    this.imgZoomActivity.setVisibility(8);
                } else {
                    FullScreenDialog.this.getDialogView().setBackgroundResource(R.color.black);
                    this.imgZoomActivity.setVisibility(0);
                }
                this.fullScreenDialogTouchEventInterceptor.refresh(FullScreenDialog.this.me, this);
                FullScreenDialog.this.onDialogRefreshUI();
            }
        }

        public void doDismiss(View view) {
            if (view != null) {
                view.setEnabled(false);
            }
            if (FullScreenDialog.this.getOwnActivity() != null && !FullScreenDialog.this.dismissAnimFlag && getDialogXAnimImpl() != null) {
                boolean unused = FullScreenDialog.this.dismissAnimFlag = true;
                getDialogXAnimImpl().doExitAnim(FullScreenDialog.this.me, this.bkg);
                FullScreenDialog.runOnMainDelay(new Runnable() {
                    public void run() {
                        if (DialogImpl.this.boxRoot != null) {
                            DialogImpl.this.boxRoot.setVisibility(8);
                        }
                        FullScreenDialog.dismiss(FullScreenDialog.this.getDialogView());
                    }
                }, getExitAnimationDuration());
            }
        }

        public void preDismiss() {
            if (FullScreenDialog.this.isCancelable()) {
                doDismiss(this.boxRoot);
                return;
            }
            long j = FullScreenDialog.overrideExitDuration >= 0 ? (long) FullScreenDialog.overrideExitDuration : 300;
            if (FullScreenDialog.this.exitAnimDuration >= 0) {
                j = FullScreenDialog.this.exitAnimDuration;
            }
            MaxRelativeLayout maxRelativeLayout = this.bkg;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(maxRelativeLayout, "y", new float[]{maxRelativeLayout.getY(), this.bkgEnterAimY});
            ofFloat.setDuration(j);
            ofFloat.start();
        }

        /* access modifiers changed from: private */
        public void doShowAnimRepeat(int i, int i2, boolean z) {
            this.enterAnimRunning = true;
            long enterAnimationDuration = getEnterAnimationDuration();
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.setDuration(enterAnimationDuration);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.addUpdateListener(new FullScreenDialog$DialogImpl$$ExternalSyntheticLambda0(this, i2));
            ofInt.start();
            this.bkg.setVisibility(0);
            if (!z) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.setDuration(enterAnimationDuration);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ofFloat.start();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doShowAnimRepeat$0$com-kongzue-dialogx-dialogs-FullScreenDialog$DialogImpl  reason: not valid java name */
        public /* synthetic */ void m136lambda$doShowAnimRepeat$0$comkongzuedialogxdialogsFullScreenDialog$DialogImpl(int i, ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.bkg.setY((float) intValue);
            makeEnterY();
            float safeHeight = this.boxRoot.getSafeHeight() - ((float) this.enterY);
            if (safeHeight < 0.0f) {
                safeHeight = 0.0f;
            }
            if (safeHeight != this.bkgEnterAimY) {
                this.bkgEnterAimY = safeHeight;
                valueAnimator.cancel();
                doShowAnimRepeat(intValue, (int) safeHeight, true);
            } else if (intValue >= i) {
                this.enterAnimRunning = false;
            }
        }

        /* access modifiers changed from: protected */
        public DialogXAnimInterface<FullScreenDialog> getDialogXAnimImpl() {
            if (FullScreenDialog.this.dialogXAnimImpl == null) {
                FullScreenDialog.this.dialogXAnimImpl = new DialogXAnimInterface<FullScreenDialog>() {
                    public void doShowAnim(FullScreenDialog fullScreenDialog, ViewGroup viewGroup) {
                        DialogImpl.this.makeEnterY();
                        DialogImpl dialogImpl = DialogImpl.this;
                        dialogImpl.bkgEnterAimY = dialogImpl.boxRoot.getSafeHeight() - ((float) DialogImpl.this.enterY);
                        if (DialogImpl.this.bkgEnterAimY < 0.0f) {
                            DialogImpl.this.bkgEnterAimY = 0.0f;
                        }
                        DialogImpl dialogImpl2 = DialogImpl.this;
                        dialogImpl2.doShowAnimRepeat(dialogImpl2.boxRoot.getHeight(), (int) DialogImpl.this.bkgEnterAimY, false);
                    }

                    public void doExitAnim(FullScreenDialog fullScreenDialog, ViewGroup viewGroup) {
                        long exitAnimationDuration = DialogImpl.this.getExitAnimationDuration();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DialogImpl.this.bkg, "y", new float[]{DialogImpl.this.bkg.getY(), (float) DialogImpl.this.boxBkg.getHeight()});
                        ofFloat.setDuration(exitAnimationDuration);
                        ofFloat.start();
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                        ofFloat2.setDuration(exitAnimationDuration);
                        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                DialogImpl.this.boxRoot.setBkgAlpha(floatValue);
                                boolean unused = DialogImpl.this.enterAnimRunning = floatValue != 1.0f;
                            }
                        });
                        ofFloat2.start();
                    }
                };
            }
            return FullScreenDialog.this.dialogXAnimImpl;
        }

        public long getExitAnimationDuration() {
            return FullScreenDialog.this.exitAnimDuration != -1 ? FullScreenDialog.this.exitAnimDuration : FullScreenDialog.overrideExitDuration >= 0 ? (long) FullScreenDialog.overrideExitDuration : 300;
        }

        public long getEnterAnimationDuration() {
            return FullScreenDialog.this.enterAnimDuration >= 0 ? FullScreenDialog.this.enterAnimDuration : FullScreenDialog.overrideEnterDuration >= 0 ? (long) FullScreenDialog.overrideEnterDuration : 300;
        }
    }

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    public void refreshUI() {
        if (getDialogImpl() != null) {
            runOnMain(new Runnable() {
                public void run() {
                    if (FullScreenDialog.this.dialogImpl != null) {
                        FullScreenDialog.this.dialogImpl.refreshView();
                    }
                }
            });
        }
    }

    public void dismiss() {
        runOnMain(new Runnable() {
            public void run() {
                if (FullScreenDialog.this.dialogImpl != null) {
                    FullScreenDialog.this.dialogImpl.doDismiss((View) null);
                }
            }
        });
    }

    public DialogLifecycleCallback<FullScreenDialog> getDialogLifecycleCallback() {
        DialogLifecycleCallback<FullScreenDialog> dialogLifecycleCallback2 = this.dialogLifecycleCallback;
        return dialogLifecycleCallback2 == null ? new DialogLifecycleCallback<FullScreenDialog>() {
        } : dialogLifecycleCallback2;
    }

    public FullScreenDialog setDialogLifecycleCallback(DialogLifecycleCallback<FullScreenDialog> dialogLifecycleCallback2) {
        this.dialogLifecycleCallback = dialogLifecycleCallback2;
        if (this.isShow) {
            dialogLifecycleCallback2.onShow(this.me);
        }
        return this;
    }

    public OnBackPressedListener<FullScreenDialog> getOnBackPressedListener() {
        return this.onBackPressedListener;
    }

    public FullScreenDialog setOnBackPressedListener(OnBackPressedListener<FullScreenDialog> onBackPressedListener2) {
        this.onBackPressedListener = onBackPressedListener2;
        refreshUI();
        return this;
    }

    public FullScreenDialog setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public FullScreenDialog setTheme(DialogX.THEME theme) {
        this.theme = theme;
        return this;
    }

    public boolean isCancelable() {
        BaseDialog.BOOLEAN booleanR = this.privateCancelable;
        if (booleanR == null) {
            BaseDialog.BOOLEAN booleanR2 = overrideCancelable;
            if (booleanR2 == null) {
                return this.cancelable;
            }
            if (booleanR2 == BaseDialog.BOOLEAN.TRUE) {
                return true;
            }
            return false;
        } else if (booleanR == BaseDialog.BOOLEAN.TRUE) {
            return true;
        } else {
            return false;
        }
    }

    public FullScreenDialog setCancelable(boolean z) {
        this.privateCancelable = z ? BaseDialog.BOOLEAN.TRUE : BaseDialog.BOOLEAN.FALSE;
        refreshUI();
        return this;
    }

    public DialogImpl getDialogImpl() {
        return this.dialogImpl;
    }

    public FullScreenDialog setCustomView(OnBindView<FullScreenDialog> onBindView2) {
        this.onBindView = onBindView2;
        refreshUI();
        return this;
    }

    public View getCustomView() {
        OnBindView<FullScreenDialog> onBindView2 = this.onBindView;
        if (onBindView2 == null) {
            return null;
        }
        return onBindView2.getCustomView();
    }

    public FullScreenDialog removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public int getBackgroundColor() {
        return this.backgroundColor.intValue();
    }

    public FullScreenDialog setBackgroundColor(int i) {
        this.backgroundColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public FullScreenDialog setBackgroundColorRes(int i) {
        this.backgroundColor = Integer.valueOf(getColor(i));
        refreshUI();
        return this;
    }

    public long getEnterAnimDuration() {
        return this.enterAnimDuration;
    }

    public FullScreenDialog setEnterAnimDuration(long j) {
        this.enterAnimDuration = j;
        return this;
    }

    public long getExitAnimDuration() {
        return this.exitAnimDuration;
    }

    public FullScreenDialog setExitAnimDuration(long j) {
        this.exitAnimDuration = j;
        return this;
    }

    public boolean isHideZoomBackground() {
        return this.hideZoomBackground;
    }

    public FullScreenDialog setHideZoomBackground(boolean z) {
        this.hideZoomBackground = z;
        refreshUI();
        return this;
    }

    public void restartDialog() {
        if (getDialogView() != null) {
            dismiss(getDialogView());
            this.isShow = false;
        }
        if (getDialogImpl().boxCustom != null) {
            getDialogImpl().boxCustom.removeAllViews();
        }
        this.enterAnimDuration = 0;
        View createView = createView(isLightTheme() ? R.layout.layout_dialogx_fullscreen : R.layout.layout_dialogx_fullscreen_dark);
        this.dialogImpl = new DialogImpl(createView);
        if (createView != null) {
            createView.setTag(this.me);
        }
        show(createView);
    }

    public void hide() {
        this.isHide = true;
        this.hideWithExitAnim = false;
        if (getDialogView() != null) {
            getDialogView().setVisibility(8);
        }
    }

    public void hideWithExitAnim() {
        this.hideWithExitAnim = true;
        this.isHide = true;
        if (getDialogImpl() != null) {
            getDialogImpl().getDialogXAnimImpl().doExitAnim(this.me, getDialogImpl().bkg);
            runOnMainDelay(new Runnable() {
                public void run() {
                    if (FullScreenDialog.this.getDialogView() != null) {
                        FullScreenDialog.this.getDialogView().setVisibility(8);
                    }
                }
            }, getDialogImpl().getExitAnimationDuration());
        }
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        dismiss();
    }

    public FullScreenDialog setMaxWidth(int i) {
        this.maxWidth = i;
        refreshUI();
        return this;
    }

    public FullScreenDialog setMaxHeight(int i) {
        this.maxHeight = i;
        refreshUI();
        return this;
    }

    public FullScreenDialog setMinHeight(int i) {
        this.minHeight = i;
        refreshUI();
        return this;
    }

    public FullScreenDialog setMinWidth(int i) {
        this.minWidth = i;
        refreshUI();
        return this;
    }

    public FullScreenDialog setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public OnBackgroundMaskClickListener<FullScreenDialog> getOnBackgroundMaskClickListener() {
        return this.onBackgroundMaskClickListener;
    }

    public FullScreenDialog setOnBackgroundMaskClickListener(OnBackgroundMaskClickListener<FullScreenDialog> onBackgroundMaskClickListener2) {
        this.onBackgroundMaskClickListener = onBackgroundMaskClickListener2;
        return this;
    }

    public FullScreenDialog setRadius(float f) {
        this.backgroundRadius = f;
        refreshUI();
        return this;
    }

    public float getRadius() {
        return this.backgroundRadius;
    }

    public boolean isAllowInterceptTouch() {
        return this.allowInterceptTouch;
    }

    public FullScreenDialog setAllowInterceptTouch(boolean z) {
        this.allowInterceptTouch = z;
        refreshUI();
        return this;
    }

    public DialogXAnimInterface<FullScreenDialog> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public FullScreenDialog setDialogXAnimImpl(DialogXAnimInterface<FullScreenDialog> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public FullScreenDialog setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public FullScreenDialog setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public boolean isBottomNonSafetyAreaBySelf() {
        return this.bottomNonSafetyAreaBySelf;
    }

    public FullScreenDialog setBottomNonSafetyAreaBySelf(boolean z) {
        this.bottomNonSafetyAreaBySelf = z;
        return this;
    }

    public FullScreenDialog hideActivityContentView(boolean z) {
        this.hideActivityContentView = z;
        return this;
    }

    public FullScreenDialog setMaskColor(int i) {
        this.maskColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public float getActivityContentRadius() {
        int dip2px;
        float f = this.activityContentRadius;
        if (f >= 0.0f) {
            return f;
        }
        if (f == -2.0f) {
            dip2px = getDeviceRadius();
        } else if (getRadius() >= 0.0f) {
            return getRadius();
        } else {
            dip2px = dip2px(15.0f);
        }
        return (float) dip2px;
    }

    public int getDeviceRadius() {
        if (this.deviceRadiusCache == null) {
            this.deviceRadiusCache = 0;
            if (Build.VERSION.SDK_INT >= 31) {
                WindowInsets rootWindowInsets = getRootFrameLayout().getRootWindowInsets();
                RoundedCorner roundedCorner = rootWindowInsets.getRoundedCorner(0);
                RoundedCorner roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                if (!(roundedCorner == null || roundedCorner2 == null)) {
                    this.deviceRadiusCache = Integer.valueOf(Math.max(roundedCorner.getRadius(), roundedCorner2.getRadius()));
                }
            }
        }
        return this.deviceRadiusCache.intValue();
    }

    public FullScreenDialog setDeviceRadius(int i) {
        this.deviceRadiusCache = Integer.valueOf(i);
        return this;
    }

    public FullScreenDialog setActivityContentRadius(float f) {
        this.activityContentRadius = f;
        return this;
    }
}
