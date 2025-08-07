package com.kongzue.dialogx.dialogs;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.interfaces.DialogConvertViewInterface;
import com.kongzue.dialogx.interfaces.DialogLifecycleCallback;
import com.kongzue.dialogx.interfaces.DialogXAnimInterface;
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.OnBackPressedListener;
import com.kongzue.dialogx.interfaces.OnBackgroundMaskClickListener;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import java.lang.ref.WeakReference;

public class CustomDialog extends BaseDialog {
    public static BaseDialog.BOOLEAN overrideCancelable = null;
    public static int overrideEnterAnimRes = 0;
    public static int overrideEnterDuration = -1;
    public static int overrideExitAnimRes = 0;
    public static int overrideExitDuration = -1;
    protected ALIGN align = ALIGN.CENTER;
    protected int alignViewGravity = -1;
    protected boolean autoUnsafePlacePadding = true;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnDrawListener baseViewDrawListener;
    protected int[] baseViewLoc;
    protected WeakReference<View> baseViewWeakReference;
    protected boolean bkgInterceptTouch = true;
    protected DialogImpl dialogImpl;
    protected DialogLifecycleCallback<CustomDialog> dialogLifecycleCallback;
    protected DialogXAnimInterface<CustomDialog> dialogXAnimImpl;
    protected int enterAnimResId = R.anim.anim_dialogx_default_enter;
    protected int exitAnimResId = R.anim.anim_dialogx_default_exit;
    protected int height = -1;
    protected boolean hideWithExitAnim;
    private boolean isHide;
    protected int[] marginRelativeBaseView = new int[4];
    protected int maskColor = 0;
    protected CustomDialog me = this;
    protected OnBackPressedListener<CustomDialog> onBackPressedListener;
    protected OnBackgroundMaskClickListener<CustomDialog> onBackgroundMaskClickListener;
    protected OnBindView<CustomDialog> onBindView;
    protected BaseDialog.BOOLEAN privateCancelable;
    /* access modifiers changed from: private */
    public ViewTreeObserver viewTreeObserver;
    protected int width = -1;

    public enum ALIGN {
        CENTER,
        TOP,
        TOP_CENTER,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM,
        BOTTOM_CENTER,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        LEFT_CENTER,
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT,
        RIGHT_CENTER,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public void onDismiss(CustomDialog customDialog) {
    }

    /* access modifiers changed from: protected */
    public void onGetBaseViewLoc(int[] iArr) {
    }

    public void onShow(CustomDialog customDialog) {
    }

    protected CustomDialog() {
    }

    public static CustomDialog build() {
        return new CustomDialog();
    }

    public static CustomDialog build(OnBindView<CustomDialog> onBindView2) {
        return new CustomDialog().setCustomView(onBindView2);
    }

    public CustomDialog(OnBindView<CustomDialog> onBindView2) {
        this.onBindView = onBindView2;
    }

    public static CustomDialog show(OnBindView<CustomDialog> onBindView2) {
        CustomDialog customDialog = new CustomDialog(onBindView2);
        customDialog.show();
        return customDialog;
    }

    public static CustomDialog show(OnBindView<CustomDialog> onBindView2, ALIGN align2) {
        CustomDialog customDialog = new CustomDialog(onBindView2);
        customDialog.align = align2;
        customDialog.show();
        return customDialog;
    }

    public CustomDialog show() {
        if (!this.isHide || getDialogView() == null || !this.isShow) {
            super.beforeShow();
            if (getDialogView() == null) {
                View createView = createView(R.layout.layout_dialogx_custom);
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
        if (!this.hideWithExitAnim || getDialogImpl() == null || getDialogImpl().boxCustom == null) {
            getDialogView().setVisibility(0);
        } else {
            getDialogView().setVisibility(0);
            getDialogImpl().getDialogXAnimImpl().doShowAnim(this, getDialogImpl().boxCustom);
            getDialogImpl().boxCustom.setVisibility(0);
            getDialogImpl().boxCustom.startAnimation(getEnterAnimation());
        }
        return this;
    }

    public CustomDialog show(Activity activity) {
        super.beforeShow();
        if (getDialogView() == null) {
            View createView = createView(R.layout.layout_dialogx_custom);
            this.dialogImpl = new DialogImpl(createView);
            if (createView != null) {
                createView.setTag(this.me);
            }
            show(activity, createView);
        } else {
            show(activity, getDialogView());
        }
        return this;
    }

    public class DialogImpl implements DialogConvertViewInterface {
        ALIGN alignCache;
        public MaxRelativeLayout boxCustom;
        public DialogXBaseRelativeLayout boxRoot;
        boolean initSetCustomViewLayoutListener = false;

        public DialogImpl(View view) {
            if (view != null) {
                CustomDialog.this.setDialogView(view);
                this.boxRoot = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
                this.boxCustom = (MaxRelativeLayout) view.findViewById(R.id.box_custom);
                init();
                CustomDialog.this.dialogImpl = this;
                refreshView();
            }
        }

        public void init() {
            if (CustomDialog.this.baseViewLoc == null && CustomDialog.this.baseView() != null) {
                CustomDialog.this.baseViewLoc = new int[4];
                CustomDialog.this.baseView().getLocationInWindow(CustomDialog.this.baseViewLoc);
                CustomDialog.this.baseViewLoc[2] = CustomDialog.this.baseView().getWidth();
                CustomDialog.this.baseViewLoc[3] = CustomDialog.this.baseView().getHeight();
            }
            this.boxRoot.setParentDialog(CustomDialog.this.me);
            this.boxRoot.setOnLifecycleCallBack(new DialogXBaseRelativeLayout.OnLifecycleCallBack() {
                public void onShow() {
                    boolean unused = CustomDialog.this.isShow = true;
                    boolean unused2 = CustomDialog.this.preShow = false;
                    CustomDialog.this.setLifecycleState(Lifecycle.State.CREATED);
                    CustomDialog.this.getDialogLifecycleCallback().onShow(CustomDialog.this.me);
                    CustomDialog.this.onShow(CustomDialog.this.me);
                    CustomDialog.this.onDialogShow();
                    DialogImpl.this.boxCustom.setVisibility(8);
                }

                public void onDismiss() {
                    boolean unused = CustomDialog.this.isShow = false;
                    CustomDialog.this.getDialogLifecycleCallback().onDismiss(CustomDialog.this.me);
                    CustomDialog.this.onDismiss(CustomDialog.this.me);
                    CustomDialog.this.dialogImpl = null;
                    CustomDialog.this.dialogLifecycleCallback = null;
                    CustomDialog.this.setLifecycleState(Lifecycle.State.DESTROYED);
                    System.gc();
                }
            });
            this.boxRoot.setOnBackPressedListener(new DialogXBaseRelativeLayout.PrivateBackPressedListener() {
                public boolean onBackPressed() {
                    if (CustomDialog.this.onBackPressedListener != null) {
                        if (!CustomDialog.this.onBackPressedListener.onBackPressed(CustomDialog.this.me)) {
                            return true;
                        }
                        CustomDialog.this.dismiss();
                        return true;
                    } else if (!CustomDialog.this.isCancelable()) {
                        return true;
                    } else {
                        CustomDialog.this.dismiss();
                        return true;
                    }
                }
            });
            this.boxRoot.post(new Runnable() {
                public void run() {
                    if (DialogImpl.this.getDialogXAnimImpl() != null) {
                        DialogImpl.this.getDialogXAnimImpl().doShowAnim(CustomDialog.this, DialogImpl.this.boxCustom);
                    }
                    if (!(CustomDialog.this.getDialogImpl() == null || CustomDialog.this.getDialogImpl().boxCustom == null)) {
                        CustomDialog.this.getDialogImpl().boxCustom.setVisibility(0);
                    }
                    CustomDialog.this.setLifecycleState(Lifecycle.State.RESUMED);
                }
            });
            CustomDialog.this.onDialogInit();
        }

        public void refreshView() {
            ALIGN align;
            if (this.boxRoot != null && CustomDialog.this.getOwnActivity() != null) {
                this.boxRoot.setRootPadding(CustomDialog.this.screenPaddings[0], CustomDialog.this.screenPaddings[1], CustomDialog.this.screenPaddings[2], CustomDialog.this.screenPaddings[3]);
                if (CustomDialog.this.baseView() == null) {
                    MaxRelativeLayout maxRelativeLayout = this.boxCustom;
                    if (maxRelativeLayout != null) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) maxRelativeLayout.getLayoutParams();
                        if (layoutParams == null || !((align = this.alignCache) == null || align == CustomDialog.this.align)) {
                            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        }
                        switch (AnonymousClass5.$SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN[CustomDialog.this.align.ordinal()]) {
                            case 1:
                            case 2:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(10);
                                layoutParams.addRule(9);
                                break;
                            case 3:
                            case 4:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(10);
                                layoutParams.addRule(14);
                                break;
                            case 5:
                            case 6:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(10);
                                layoutParams.addRule(11);
                                break;
                            case 7:
                            case 8:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(12);
                                break;
                            case 9:
                            case 10:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(12);
                                layoutParams.addRule(14);
                                break;
                            case 11:
                            case 12:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(12);
                                layoutParams.addRule(11);
                                break;
                            case 13:
                                layoutParams.removeRule(10);
                                layoutParams.removeRule(12);
                                layoutParams.addRule(13);
                                break;
                            case 14:
                            case 15:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(10);
                                layoutParams.addRule(15);
                                break;
                            case 16:
                            case 17:
                                layoutParams.removeRule(13);
                                layoutParams.addRule(11);
                                layoutParams.addRule(15);
                                break;
                        }
                        this.alignCache = CustomDialog.this.align;
                        this.boxCustom.setLayoutParams(layoutParams);
                    }
                } else if (!this.initSetCustomViewLayoutListener) {
                    if (this.boxCustom != null) {
                        this.boxCustom.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                    }
                    final AnonymousClass4 r0 = new Runnable() {
                        public void run() {
                            int x = CustomDialog.this.baseViewLoc[0] - ((int) DialogImpl.this.boxRoot.getX());
                            int y = CustomDialog.this.baseViewLoc[1] - ((int) DialogImpl.this.boxRoot.getY());
                            if (CustomDialog.this.alignViewGravity != -1) {
                                int measuredHeight = CustomDialog.this.isAlignBaseViewGravity(16) ? ((CustomDialog.this.baseView().getMeasuredHeight() / 2) + y) - (DialogImpl.this.boxCustom.getHeight() / 2) : 0;
                                int measuredWidth = CustomDialog.this.isAlignBaseViewGravity(1) ? ((CustomDialog.this.baseView().getMeasuredWidth() / 2) + x) - (DialogImpl.this.boxCustom.getWidth() / 2) : 0;
                                if (CustomDialog.this.isAlignBaseViewGravity(17)) {
                                    measuredWidth = ((CustomDialog.this.baseView().getMeasuredWidth() / 2) + x) - (DialogImpl.this.boxCustom.getWidth() / 2);
                                    measuredHeight = ((CustomDialog.this.baseView().getMeasuredHeight() / 2) + y) - (DialogImpl.this.boxCustom.getHeight() / 2);
                                }
                                if (CustomDialog.this.isAlignBaseViewGravity(48)) {
                                    measuredHeight = (y - DialogImpl.this.boxCustom.getHeight()) - CustomDialog.this.marginRelativeBaseView[3];
                                }
                                if (CustomDialog.this.isAlignBaseViewGravity(3)) {
                                    measuredWidth = (x - DialogImpl.this.boxCustom.getWidth()) - CustomDialog.this.marginRelativeBaseView[2];
                                }
                                if (CustomDialog.this.isAlignBaseViewGravity(5)) {
                                    measuredWidth = x + CustomDialog.this.baseView().getWidth() + CustomDialog.this.marginRelativeBaseView[0];
                                }
                                if (CustomDialog.this.isAlignBaseViewGravity(80)) {
                                    measuredHeight = y + CustomDialog.this.baseView().getHeight() + CustomDialog.this.marginRelativeBaseView[1];
                                }
                                int width = CustomDialog.this.width == 0 ? CustomDialog.this.baseView().getWidth() : CustomDialog.this.width;
                                int height = CustomDialog.this.height == 0 ? CustomDialog.this.baseView().getHeight() : CustomDialog.this.height;
                                int[] iArr = CustomDialog.this.baseViewLoc;
                                if (width <= 0) {
                                    width = CustomDialog.this.baseViewLoc[2];
                                }
                                iArr[2] = width;
                                int[] iArr2 = CustomDialog.this.baseViewLoc;
                                if (height <= 0) {
                                    height = CustomDialog.this.baseViewLoc[3];
                                }
                                iArr2[3] = height;
                                if (measuredWidth != 0) {
                                    float f = (float) measuredWidth;
                                    if (f != DialogImpl.this.boxCustom.getX()) {
                                        DialogImpl.this.boxCustom.setX(f);
                                    }
                                }
                                if (measuredHeight != 0) {
                                    float f2 = (float) measuredHeight;
                                    if (f2 != DialogImpl.this.boxCustom.getY()) {
                                        DialogImpl.this.boxCustom.setY(f2);
                                    }
                                }
                                CustomDialog.this.onGetBaseViewLoc(CustomDialog.this.baseViewLoc);
                            }
                        }
                    };
                    ViewTreeObserver unused = CustomDialog.this.viewTreeObserver = this.boxCustom.getViewTreeObserver();
                    CustomDialog.this.viewTreeObserver.addOnDrawListener(CustomDialog.this.baseViewDrawListener = new ViewTreeObserver.OnDrawListener() {
                        public void onDraw() {
                            int[] iArr = new int[2];
                            if (CustomDialog.this.baseView() != null) {
                                CustomDialog.this.baseView().getLocationInWindow(iArr);
                                if (CustomDialog.this.getDialogImpl() != null && CustomDialog.this.isShow) {
                                    CustomDialog.this.baseViewLoc[0] = iArr[0];
                                    CustomDialog.this.baseViewLoc[1] = iArr[1];
                                    r0.run();
                                    return;
                                }
                                return;
                            }
                            CustomDialog.this.removeDrawListener(CustomDialog.this.viewTreeObserver, this);
                            ViewTreeObserver unused = CustomDialog.this.viewTreeObserver = null;
                            ViewTreeObserver.OnDrawListener unused2 = CustomDialog.this.baseViewDrawListener = null;
                        }
                    });
                    this.initSetCustomViewLayoutListener = true;
                }
                this.boxRoot.setAutoUnsafePlacePadding(CustomDialog.this.autoUnsafePlacePadding);
                if (!CustomDialog.this.bkgInterceptTouch) {
                    this.boxRoot.setClickable(false);
                } else if (CustomDialog.this.isCancelable()) {
                    this.boxRoot.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (CustomDialog.this.onBackgroundMaskClickListener == null || !CustomDialog.this.onBackgroundMaskClickListener.onClick(CustomDialog.this.me, view)) {
                                DialogImpl.this.doDismiss(view);
                            }
                        }
                    });
                } else {
                    this.boxRoot.setOnClickListener((View.OnClickListener) null);
                }
                if (!(CustomDialog.this.onBindView == null || CustomDialog.this.onBindView.getCustomView() == null || this.boxCustom == null)) {
                    CustomDialog.this.onBindView.bindParent(this.boxCustom, CustomDialog.this.me);
                }
                if (this.boxCustom != null) {
                    if (CustomDialog.this.width != -1) {
                        this.boxCustom.setMaxWidth(CustomDialog.this.width);
                        this.boxCustom.setMinimumWidth(CustomDialog.this.width);
                    }
                    if (CustomDialog.this.height != -1) {
                        this.boxCustom.setMaxHeight(CustomDialog.this.height);
                        this.boxCustom.setMinimumHeight(CustomDialog.this.height);
                    }
                }
                this.boxRoot.setBackgroundColor(CustomDialog.this.getMaskColor());
                CustomDialog.this.onDialogRefreshUI();
            }
        }

        public void doDismiss(View view) {
            if (view != null) {
                view.setEnabled(false);
            }
            if (!CustomDialog.this.dismissAnimFlag && this.boxCustom != null) {
                boolean unused = CustomDialog.this.dismissAnimFlag = true;
                this.boxCustom.post(new Runnable() {
                    public void run() {
                        DialogImpl.this.getDialogXAnimImpl().doExitAnim(CustomDialog.this, DialogImpl.this.boxCustom);
                        CustomDialog.runOnMainDelay(new Runnable() {
                            public void run() {
                                if (DialogImpl.this.boxRoot != null) {
                                    DialogImpl.this.boxRoot.setVisibility(8);
                                }
                                if (CustomDialog.this.baseViewDrawListener != null) {
                                    if (CustomDialog.this.viewTreeObserver != null) {
                                        CustomDialog.this.removeDrawListener(CustomDialog.this.viewTreeObserver, CustomDialog.this.baseViewDrawListener);
                                    } else if (DialogImpl.this.boxCustom != null) {
                                        CustomDialog.this.removeDrawListener(DialogImpl.this.boxCustom.getViewTreeObserver(), CustomDialog.this.baseViewDrawListener);
                                    }
                                    ViewTreeObserver.OnDrawListener unused = CustomDialog.this.baseViewDrawListener = null;
                                    ViewTreeObserver unused2 = CustomDialog.this.viewTreeObserver = null;
                                }
                                CustomDialog.dismiss(CustomDialog.this.getDialogView());
                            }
                        }, DialogImpl.this.getExitAnimationDuration((Animation) null));
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public DialogXAnimInterface<CustomDialog> getDialogXAnimImpl() {
            if (CustomDialog.this.dialogXAnimImpl == null) {
                CustomDialog.this.dialogXAnimImpl = new DialogXAnimInterface<CustomDialog>() {
                    public void doShowAnim(CustomDialog customDialog, ViewGroup viewGroup) {
                        if (CustomDialog.this.getDialogImpl() != null && CustomDialog.this.getDialogImpl().boxCustom != null) {
                            Animation access$2200 = CustomDialog.this.getEnterAnimation();
                            long enterAnimationDuration = DialogImpl.this.getEnterAnimationDuration(access$2200);
                            access$2200.setDuration(enterAnimationDuration);
                            if (DialogImpl.this.boxCustom != null) {
                                DialogImpl.this.boxCustom.setVisibility(0);
                                DialogImpl.this.boxCustom.startAnimation(access$2200);
                            }
                            if (CustomDialog.this.maskColor != 0) {
                                DialogImpl.this.boxRoot.setBackgroundColor(CustomDialog.this.maskColor);
                            }
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

                    public void doExitAnim(CustomDialog customDialog, ViewGroup viewGroup) {
                        long j;
                        if (CustomDialog.this.getDialogImpl() != null && CustomDialog.this.getDialogImpl().boxCustom != null) {
                            int i = R.anim.anim_dialogx_default_exit;
                            if (CustomDialog.overrideExitAnimRes != 0) {
                                i = CustomDialog.overrideExitAnimRes;
                            }
                            if (CustomDialog.this.exitAnimResId != 0) {
                                i = CustomDialog.this.exitAnimResId;
                            }
                            if (DialogImpl.this.boxCustom != null) {
                                Animation loadAnimation = AnimationUtils.loadAnimation(CustomDialog.this.getOwnActivity() == null ? DialogImpl.this.boxCustom.getContext() : CustomDialog.this.getOwnActivity(), i);
                                j = DialogImpl.this.getExitAnimationDuration(loadAnimation);
                                loadAnimation.setDuration(j);
                                DialogImpl.this.boxCustom.startAnimation(loadAnimation);
                            } else {
                                j = DialogImpl.this.getExitAnimationDuration((Animation) null);
                            }
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                            ofFloat.setDuration(j);
                            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            });
                            ofFloat.start();
                        }
                    }
                };
            }
            return CustomDialog.this.dialogXAnimImpl;
        }

        public long getExitAnimationDuration(Animation animation) {
            if (animation == null && this.boxCustom.getAnimation() != null) {
                animation = this.boxCustom.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (CustomDialog.overrideExitDuration >= 0) {
                duration = (long) CustomDialog.overrideExitDuration;
            }
            return CustomDialog.this.exitAnimDuration != -1 ? CustomDialog.this.exitAnimDuration : duration;
        }

        public long getEnterAnimationDuration(Animation animation) {
            if (animation == null && this.boxCustom.getAnimation() != null) {
                animation = this.boxCustom.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (CustomDialog.overrideEnterDuration >= 0) {
                duration = (long) CustomDialog.overrideEnterDuration;
            }
            return CustomDialog.this.enterAnimDuration >= 0 ? CustomDialog.this.enterAnimDuration : duration;
        }
    }

    /* renamed from: com.kongzue.dialogx.dialogs.CustomDialog$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN[] r0 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN = r0
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.LEFT_TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.TOP_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x003e }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.RIGHT_TOP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.LEFT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x006c }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.BOTTOM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.BOTTOM_CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.RIGHT_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x009c }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.CENTER     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.LEFT     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.LEFT_CENTER     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.RIGHT     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.kongzue.dialogx.dialogs.CustomDialog$ALIGN r1 = com.kongzue.dialogx.dialogs.CustomDialog.ALIGN.RIGHT_CENTER     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.dialogs.CustomDialog.AnonymousClass5.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void removeDrawListener(ViewTreeObserver viewTreeObserver2, ViewTreeObserver.OnDrawListener onDrawListener) {
        if (viewTreeObserver2 != null && onDrawListener != null && viewTreeObserver2.isAlive()) {
            try {
                viewTreeObserver2.removeOnDrawListener(onDrawListener);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public Animation getEnterAnimation() {
        Animation animation;
        if (this.enterAnimResId == R.anim.anim_dialogx_default_enter && this.exitAnimResId == R.anim.anim_dialogx_default_exit && baseView() == null) {
            switch (AnonymousClass5.$SwitchMap$com$kongzue$dialogx$dialogs$CustomDialog$ALIGN[this.align.ordinal()]) {
                case 1:
                case 3:
                case 4:
                case 5:
                    this.enterAnimResId = R.anim.anim_dialogx_top_enter;
                    this.exitAnimResId = R.anim.anim_dialogx_top_exit;
                    break;
                case 2:
                case 8:
                case 14:
                case 15:
                    this.enterAnimResId = R.anim.anim_dialogx_left_enter;
                    this.exitAnimResId = R.anim.anim_dialogx_left_exit;
                    break;
                case 6:
                case 12:
                case 16:
                case 17:
                    this.enterAnimResId = R.anim.anim_dialogx_right_enter;
                    this.exitAnimResId = R.anim.anim_dialogx_right_exit;
                    break;
                case 7:
                case 9:
                case 10:
                case 11:
                    this.enterAnimResId = R.anim.anim_dialogx_bottom_enter;
                    this.exitAnimResId = R.anim.anim_dialogx_bottom_exit;
                    break;
            }
            animation = AnimationUtils.loadAnimation(getOwnActivity(), this.enterAnimResId);
            animation.setInterpolator(new DecelerateInterpolator(2.0f));
        } else {
            int i = R.anim.anim_dialogx_default_enter;
            int i2 = overrideEnterAnimRes;
            if (i2 != 0) {
                i = i2;
            }
            int i3 = this.enterAnimResId;
            if (i3 != 0) {
                i = i3;
            }
            animation = AnimationUtils.loadAnimation(getOwnActivity(), i);
        }
        long duration = animation.getDuration();
        int i4 = overrideEnterDuration;
        if (i4 >= 0) {
            duration = (long) i4;
        }
        if (this.enterAnimDuration >= 0) {
            duration = this.enterAnimDuration;
        }
        animation.setDuration(duration);
        return animation;
    }

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    public void refreshUI() {
        if (getDialogImpl() != null) {
            runOnMain(new Runnable() {
                public void run() {
                    if (CustomDialog.this.dialogImpl != null) {
                        CustomDialog.this.dialogImpl.refreshView();
                    }
                }
            });
        }
    }

    public void dismiss() {
        runOnMain(new Runnable() {
            public void run() {
                if (CustomDialog.this.dialogImpl != null) {
                    CustomDialog.this.dialogImpl.doDismiss((View) null);
                }
            }
        });
    }

    public DialogLifecycleCallback<CustomDialog> getDialogLifecycleCallback() {
        DialogLifecycleCallback<CustomDialog> dialogLifecycleCallback2 = this.dialogLifecycleCallback;
        return dialogLifecycleCallback2 == null ? new DialogLifecycleCallback<CustomDialog>() {
        } : dialogLifecycleCallback2;
    }

    public CustomDialog setDialogLifecycleCallback(DialogLifecycleCallback<CustomDialog> dialogLifecycleCallback2) {
        this.dialogLifecycleCallback = dialogLifecycleCallback2;
        if (this.isShow) {
            dialogLifecycleCallback2.onShow(this.me);
        }
        return this;
    }

    public OnBackPressedListener<CustomDialog> getOnBackPressedListener() {
        return this.onBackPressedListener;
    }

    public CustomDialog setOnBackPressedListener(OnBackPressedListener<CustomDialog> onBackPressedListener2) {
        this.onBackPressedListener = onBackPressedListener2;
        refreshUI();
        return this;
    }

    public CustomDialog setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public CustomDialog setTheme(DialogX.THEME theme) {
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

    public CustomDialog setCancelable(boolean z) {
        this.privateCancelable = z ? BaseDialog.BOOLEAN.TRUE : BaseDialog.BOOLEAN.FALSE;
        refreshUI();
        return this;
    }

    public DialogImpl getDialogImpl() {
        return this.dialogImpl;
    }

    public CustomDialog setCustomView(OnBindView<CustomDialog> onBindView2) {
        this.onBindView = onBindView2;
        refreshUI();
        return this;
    }

    public View getCustomView() {
        OnBindView<CustomDialog> onBindView2 = this.onBindView;
        if (onBindView2 == null) {
            return null;
        }
        return onBindView2.getCustomView();
    }

    public CustomDialog removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public int getEnterAnimResId() {
        return this.enterAnimResId;
    }

    public CustomDialog setEnterAnimResId(int i) {
        this.enterAnimResId = i;
        return this;
    }

    public int getExitAnimResId() {
        return this.exitAnimResId;
    }

    public CustomDialog setExitAnimResId(int i) {
        this.exitAnimResId = i;
        return this;
    }

    public CustomDialog setAnimResId(int i, int i2) {
        this.enterAnimResId = i;
        this.exitAnimResId = i2;
        return this;
    }

    public ALIGN getAlign() {
        return this.align;
    }

    public CustomDialog setAlign(ALIGN align2) {
        this.align = align2;
        refreshUI();
        return this;
    }

    public boolean isAutoUnsafePlacePadding() {
        return this.autoUnsafePlacePadding;
    }

    public CustomDialog setAutoUnsafePlacePadding(boolean z) {
        this.autoUnsafePlacePadding = z;
        refreshUI();
        return this;
    }

    public CustomDialog setFullScreen(boolean z) {
        this.autoUnsafePlacePadding = !this.autoUnsafePlacePadding;
        refreshUI();
        return this;
    }

    public CustomDialog setMaskColor(int i) {
        this.maskColor = i;
        refreshUI();
        return this;
    }

    public int getMaskColor() {
        return this.maskColor;
    }

    public long getEnterAnimDuration() {
        return this.enterAnimDuration;
    }

    public CustomDialog setEnterAnimDuration(long j) {
        this.enterAnimDuration = j;
        return this;
    }

    public long getExitAnimDuration() {
        return this.exitAnimDuration;
    }

    public CustomDialog setExitAnimDuration(long j) {
        this.exitAnimDuration = j;
        return this;
    }

    public void restartDialog() {
        ViewTreeObserver.OnDrawListener onDrawListener;
        if (getDialogView() != null) {
            if (!(getDialogImpl() == null || getDialogImpl().boxCustom == null || (onDrawListener = this.baseViewDrawListener) == null)) {
                ViewTreeObserver viewTreeObserver2 = this.viewTreeObserver;
                if (viewTreeObserver2 != null) {
                    removeDrawListener(viewTreeObserver2, onDrawListener);
                } else if (getDialogImpl().boxCustom != null) {
                    removeDrawListener(getDialogImpl().boxCustom.getViewTreeObserver(), this.baseViewDrawListener);
                }
                this.baseViewDrawListener = null;
                this.viewTreeObserver = null;
            }
            dismiss(getDialogView());
            this.isShow = false;
        }
        if (!(getDialogImpl() == null || getDialogImpl().boxCustom == null)) {
            getDialogImpl().boxCustom.removeAllViews();
        }
        this.enterAnimDuration = 0;
        View createView = createView(R.layout.layout_dialogx_custom);
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
            getDialogImpl().getDialogXAnimImpl().doExitAnim(this, getDialogImpl().boxCustom);
            runOnMainDelay(new Runnable() {
                public void run() {
                    if (CustomDialog.this.getDialogView() != null) {
                        CustomDialog.this.getDialogView().setVisibility(8);
                    }
                }
            }, getDialogImpl().getExitAnimationDuration((Animation) null));
        }
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        dismiss();
    }

    public CustomDialog setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public boolean isBkgInterceptTouch() {
        return this.bkgInterceptTouch;
    }

    public CustomDialog setBkgInterceptTouch(boolean z) {
        this.bkgInterceptTouch = z;
        refreshUI();
        return this;
    }

    public int getAlignBaseViewGravity() {
        return this.alignViewGravity;
    }

    public boolean isAlignBaseViewGravity(int i) {
        return (this.alignViewGravity & i) == i;
    }

    public CustomDialog setAlignBaseViewGravity(View view, int i) {
        baseView(view);
        this.alignViewGravity = i;
        int[] iArr = new int[4];
        this.baseViewLoc = iArr;
        view.getLocationInWindow(iArr);
        setFullScreen(true);
        return this;
    }

    public CustomDialog setAlignBaseView(View view) {
        baseView(view);
        int[] iArr = new int[4];
        this.baseViewLoc = iArr;
        view.getLocationInWindow(iArr);
        setFullScreen(true);
        return this;
    }

    public CustomDialog setAlignBaseViewGravity(int i) {
        this.alignViewGravity = i;
        if (baseView() != null) {
            this.baseViewLoc = new int[4];
            baseView().getLocationInWindow(this.baseViewLoc);
        }
        setFullScreen(true);
        return this;
    }

    public CustomDialog setAlignBaseViewGravity(View view, int i, int i2, int i3, int i4, int i5) {
        this.marginRelativeBaseView = new int[]{i2, i3, i4, i5};
        refreshUI();
        return setAlignBaseViewGravity(view, i);
    }

    public int[] getBaseViewMargin() {
        return this.marginRelativeBaseView;
    }

    public CustomDialog setBaseViewMargin(int[] iArr) {
        this.marginRelativeBaseView = iArr;
        refreshUI();
        return this;
    }

    public CustomDialog setBaseViewMargin(int i, int i2, int i3, int i4) {
        this.marginRelativeBaseView = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public CustomDialog setBaseViewMarginLeft(int i) {
        this.marginRelativeBaseView[0] = i;
        refreshUI();
        return this;
    }

    public CustomDialog setBaseViewMarginTop(int i) {
        this.marginRelativeBaseView[1] = i;
        refreshUI();
        return this;
    }

    public CustomDialog setBaseViewMarginRight(int i) {
        this.marginRelativeBaseView[2] = i;
        refreshUI();
        return this;
    }

    public CustomDialog setBaseViewMarginBottom(int i) {
        this.marginRelativeBaseView[3] = i;
        refreshUI();
        return this;
    }

    public int getBaseViewMarginLeft(int i) {
        return this.marginRelativeBaseView[0];
    }

    public int getBaseViewMarginTop(int i) {
        return this.marginRelativeBaseView[1];
    }

    public int getBaseViewMarginRight(int i) {
        return this.marginRelativeBaseView[2];
    }

    public int getBaseViewMarginBottom(int i) {
        return this.marginRelativeBaseView[3];
    }

    public View getBaseView() {
        return baseView();
    }

    public int getWidth() {
        return this.width;
    }

    public CustomDialog setWidth(int i) {
        this.width = i;
        refreshUI();
        return this;
    }

    public int getHeight() {
        return this.height;
    }

    public CustomDialog setHeight(int i) {
        this.height = i;
        refreshUI();
        return this;
    }

    public OnBackgroundMaskClickListener<CustomDialog> getOnBackgroundMaskClickListener() {
        return this.onBackgroundMaskClickListener;
    }

    public CustomDialog setOnBackgroundMaskClickListener(OnBackgroundMaskClickListener<CustomDialog> onBackgroundMaskClickListener2) {
        this.onBackgroundMaskClickListener = onBackgroundMaskClickListener2;
        return this;
    }

    public DialogXAnimInterface<CustomDialog> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public CustomDialog setDialogXAnimImpl(DialogXAnimInterface<CustomDialog> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public CustomDialog setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public CustomDialog setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    /* access modifiers changed from: protected */
    public CustomDialog baseView(View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.baseViewWeakReference) == null) {
            this.baseViewWeakReference = new WeakReference<>(view);
        } else {
            weakReference.clear();
            this.baseViewWeakReference = null;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public View baseView() {
        WeakReference<View> weakReference = this.baseViewWeakReference;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }
}
