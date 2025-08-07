package com.kongzue.dialogx.dialogs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.interfaces.BlurViewType;
import com.kongzue.dialogx.interfaces.DialogConvertViewInterface;
import com.kongzue.dialogx.interfaces.DialogLifecycleCallback;
import com.kongzue.dialogx.interfaces.DialogXAnimInterface;
import com.kongzue.dialogx.interfaces.DialogXRunnable;
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.OnBackPressedListener;
import com.kongzue.dialogx.interfaces.OnBackgroundMaskClickListener;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.interfaces.ProgressViewInterface;
import com.kongzue.dialogx.util.TextInfo;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import com.kongzue.dialogx.util.views.ProgressView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class WaitDialog extends BaseDialog {
    protected static Timer delayDismissTimer = null;
    protected static WeakReference<WaitDialog> me = null;
    public static BaseDialog.BOOLEAN overrideCancelable = null;
    public static int overrideEnterAnimRes = 0;
    public static int overrideEnterDuration = -1;
    public static int overrideExitAnimRes = 0;
    public static int overrideExitDuration = -1;
    protected float backgroundRadius = -1.0f;
    protected boolean bkgInterceptTouch = true;
    protected int customEnterAnimResId;
    protected int customExitAnimResId;
    protected WeakReference<DialogImpl> dialogImpl;
    protected DialogLifecycleCallback<WaitDialog> dialogLifecycleCallback;
    /* access modifiers changed from: private */
    public WeakReference<View> dialogView;
    protected DialogXAnimInterface<WaitDialog> dialogXAnimImpl;
    protected Integer maskColor = null;
    protected CharSequence message;
    protected TextInfo messageTextInfo;
    protected OnBackPressedListener<WaitDialog> onBackPressedListener;
    protected OnBackgroundMaskClickListener<WaitDialog> onBackgroundMaskClickListener;
    protected OnBindView<WaitDialog> onBindView;
    DialogXRunnable<WaitDialog> onDismissRunnable;
    DialogXRunnable<WaitDialog> onShowRunnable;
    protected BaseDialog.BOOLEAN privateCancelable;
    protected TYPE readyTipType;
    protected int showType = -1;
    protected long tipShowDuration = 1500;
    protected float waitProgress = -1.0f;

    public enum TYPE {
        NONE,
        SUCCESS,
        WARNING,
        ERROR,
        PROGRESSING
    }

    protected WaitDialog() {
        this.cancelable = DialogX.cancelableTipDialog;
    }

    protected static WaitDialog instanceBuild() {
        WeakReference<WaitDialog> weakReference = new WeakReference<>(new WaitDialog());
        me = weakReference;
        return (WaitDialog) weakReference.get();
    }

    public static WaitDialog build() {
        return new WaitDialog();
    }

    public static WaitDialog show(CharSequence charSequence) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(charSequence, TYPE.NONE);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, CharSequence charSequence) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(charSequence, TYPE.NONE);
        if (noInstance) {
            showWithInstance(instanceNotNull, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(int i) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(i, TYPE.NONE);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, int i) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(i, TYPE.PROGRESSING);
        if (noInstance) {
            showWithInstance(instanceNotNull, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(CharSequence charSequence, float f) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(charSequence, TYPE.PROGRESSING);
        me().setProgress(f);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, CharSequence charSequence, float f) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(charSequence, TYPE.PROGRESSING);
        instanceNotNull.setProgress(f);
        if (noInstance) {
            showWithInstance(instanceNotNull, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(int i, float f) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(i, TYPE.PROGRESSING);
        me().setProgress(f);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, int i, float f) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(i, TYPE.PROGRESSING);
        instanceNotNull.setProgress(f);
        if (noInstance) {
            showWithInstance(instanceNotNull, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(Activity activity, float f) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(TYPE.PROGRESSING);
        instanceNotNull.setProgress(f);
        if (noInstance) {
            showWithInstance(instanceNotNull, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(float f) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(TYPE.PROGRESSING);
        me().setProgress(f);
        showWithInstance(noInstance);
        return me();
    }

    public float getProgress() {
        return this.waitProgress;
    }

    public WaitDialog setProgress(float f) {
        this.waitProgress = f;
        refreshUI();
        return this;
    }

    /* access modifiers changed from: protected */
    public View getWaitDialogView() {
        WeakReference<View> weakReference = this.dialogView;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* access modifiers changed from: protected */
    public void setWaitDialogView(View view) {
        this.dialogView = new WeakReference<>(view);
    }

    public WaitDialog show() {
        super.beforeShow();
        runOnMain(new Runnable() {
            public void run() {
                int i = R.layout.layout_dialogx_wait;
                if (!(WaitDialog.this.style.overrideWaitTipRes() == null || WaitDialog.this.style.overrideWaitTipRes().overrideWaitLayout(WaitDialog.this.isLightTheme()) == 0)) {
                    i = WaitDialog.this.style.overrideWaitTipRes().overrideWaitLayout(WaitDialog.this.isLightTheme());
                }
                WaitDialog.this.dialogImpl = new WeakReference<>(new DialogImpl(i));
                if (WaitDialog.this.getDialogImpl() != null) {
                    WaitDialog.this.getDialogImpl().lazyCreate();
                    if (WaitDialog.this.getWaitDialogView() != null) {
                        WaitDialog.this.getWaitDialogView().setTag(WaitDialog.this);
                        WaitDialog.show(WaitDialog.this.getWaitDialogView());
                    }
                }
            }
        });
        return this;
    }

    public WaitDialog show(final Activity activity) {
        super.beforeShow();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                int i = R.layout.layout_dialogx_wait;
                if (!(WaitDialog.this.style.overrideWaitTipRes() == null || WaitDialog.this.style.overrideWaitTipRes().overrideWaitLayout(WaitDialog.this.isLightTheme()) == 0)) {
                    i = WaitDialog.this.style.overrideWaitTipRes().overrideWaitLayout(WaitDialog.this.isLightTheme());
                }
                WaitDialog.this.dialogImpl = new WeakReference<>(new DialogImpl(i));
                if (WaitDialog.this.getDialogImpl() != null) {
                    WaitDialog.this.getDialogImpl().lazyCreate();
                    if (WaitDialog.this.getWaitDialogView() != null) {
                        WaitDialog.this.getWaitDialogView().setTag(WaitDialog.this);
                        WaitDialog.show(activity, WaitDialog.this.getWaitDialogView());
                    }
                }
            }
        });
        return this;
    }

    public class DialogImpl implements DialogConvertViewInterface {
        public MaxRelativeLayout bkg;
        private List<View> blurViews;
        public RelativeLayout boxCustomView;
        public RelativeLayout boxProgress;
        public DialogXBaseRelativeLayout boxRoot;
        private int layoutResId;
        private float oldProgress;
        public ProgressViewInterface progressView;
        public TextView txtInfo;

        public DialogImpl(int i) {
            this.layoutResId = i;
        }

        public void lazyCreate() {
            View createView = WaitDialog.this.createView(this.layoutResId);
            if (createView != null) {
                WaitDialog.this.setWaitDialogView(createView);
                this.boxRoot = (DialogXBaseRelativeLayout) createView.findViewById(R.id.box_root);
                this.bkg = (MaxRelativeLayout) createView.findViewById(R.id.bkg);
                this.boxProgress = (RelativeLayout) createView.findViewById(R.id.box_progress);
                View view = (View) WaitDialog.this.style.overrideWaitTipRes().overrideWaitView(WaitDialog.this.getOwnActivity(), WaitDialog.this.isLightTheme());
                if (view == null) {
                    view = new ProgressView(WaitDialog.this.getOwnActivity());
                }
                this.progressView = (ProgressViewInterface) view;
                this.boxProgress.addView(view, new RelativeLayout.LayoutParams(-1, -1));
                this.boxCustomView = (RelativeLayout) createView.findViewById(R.id.box_customView);
                this.txtInfo = (TextView) createView.findViewById(R.id.txt_info);
                this.blurViews = WaitDialog.this.findAllBlurView(createView);
                init();
                WaitDialog.this.setDialogImpl(this);
                refreshView();
            }
        }

        public DialogImpl(View view) {
            if (view != null) {
                WaitDialog.this.setDialogView(view);
                this.boxRoot = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
                this.bkg = (MaxRelativeLayout) view.findViewById(R.id.bkg);
                this.boxProgress = (RelativeLayout) view.findViewById(R.id.box_progress);
                View view2 = (View) WaitDialog.this.style.overrideWaitTipRes().overrideWaitView(WaitDialog.this.getOwnActivity(), WaitDialog.this.isLightTheme());
                view2 = view2 == null ? new ProgressView(WaitDialog.this.getOwnActivity()) : view2;
                this.progressView = (ProgressViewInterface) view2;
                this.boxProgress.addView(view2, new RelativeLayout.LayoutParams(-1, -1));
                this.boxCustomView = (RelativeLayout) view.findViewById(R.id.box_customView);
                this.txtInfo = (TextView) view.findViewById(R.id.txt_info);
                init();
                WaitDialog.this.setDialogImpl(this);
                refreshView();
            }
        }

        public void init() {
            if (WaitDialog.this.messageTextInfo == null) {
                WaitDialog.this.messageTextInfo = DialogX.tipTextInfo;
            }
            if (WaitDialog.this.backgroundColor == null) {
                Integer unused = WaitDialog.this.backgroundColor = DialogX.tipBackgroundColor;
            }
            WaitDialog waitDialog = WaitDialog.this;
            this.blurViews = waitDialog.findAllBlurView((View) waitDialog.dialogView.get());
            WaitDialog waitDialog2 = WaitDialog.this;
            Integer valueOf = Integer.valueOf(waitDialog2.getColor(waitDialog2.isLightTheme() ? R.color.dialogxWaitBkgDark : R.color.dialogxWaitBkgLight));
            Float valueOf2 = Float.valueOf((float) WaitDialog.this.dip2px(15.0f));
            if (WaitDialog.this.style.overrideWaitTipRes() != null) {
                WaitDialog waitDialog3 = WaitDialog.this;
                valueOf2 = waitDialog3.getFloatStyleAttr(Float.valueOf((float) waitDialog3.style.overrideWaitTipRes().overrideRadiusPx()), valueOf2);
                WaitDialog waitDialog4 = WaitDialog.this;
                valueOf = waitDialog4.getColorNullable(waitDialog4.getIntStyleAttr(Integer.valueOf(waitDialog4.style.overrideWaitTipRes().overrideBackgroundColorRes(WaitDialog.this.isLightTheme())), Integer.valueOf(WaitDialog.this.isLightTheme() ? R.color.dialogxWaitBkgDark : R.color.dialogxWaitBkgLight)), valueOf);
            }
            List<View> list = this.blurViews;
            if (list != null) {
                Iterator<View> it = list.iterator();
                while (it.hasNext()) {
                    BlurViewType blurViewType = (BlurViewType) it.next();
                    blurViewType.setOverlayColor(WaitDialog.this.backgroundColor == null ? valueOf : WaitDialog.this.backgroundColor);
                    blurViewType.setRadiusPx(valueOf2);
                }
            } else {
                GradientDrawable gradientDrawable = (GradientDrawable) WaitDialog.this.getResources().getDrawable(R.drawable.rect_dialogx_material_wait_bkg);
                gradientDrawable.setColor(valueOf.intValue());
                gradientDrawable.setCornerRadius(valueOf2.floatValue());
                this.bkg.setBackground(gradientDrawable);
            }
            this.boxRoot.setClickable(true);
            this.boxRoot.setParentDialog(WaitDialog.me());
            this.boxRoot.setOnLifecycleCallBack(new DialogXBaseRelativeLayout.OnLifecycleCallBack() {
                public void onShow() {
                    boolean unused = WaitDialog.this.isShow = true;
                    boolean unused2 = WaitDialog.this.preShow = false;
                    WaitDialog.this.setLifecycleState(Lifecycle.State.CREATED);
                    DialogImpl.this.boxRoot.setAlpha(0.0f);
                    DialogImpl.this.bkg.post(new Runnable() {
                        public void run() {
                            if (WaitDialog.this.getOwnActivity() != null) {
                                DialogImpl.this.getDialogXAnimImpl().doShowAnim(WaitDialog.this, DialogImpl.this.bkg);
                                WaitDialog.this.onDialogShow();
                                WaitDialog.this.getDialogLifecycleCallback().onShow(WaitDialog.this);
                                if (WaitDialog.this.onShowRunnable != null) {
                                    WaitDialog.this.onShowRunnable.run(WaitDialog.this);
                                }
                                WaitDialog.this.setLifecycleState(Lifecycle.State.RESUMED);
                            }
                        }
                    });
                }

                public void onDismiss() {
                    WaitDialog.this.cleanInstance();
                }
            });
            if (!(WaitDialog.this.readyTipType == null || WaitDialog.this.readyTipType == TYPE.NONE)) {
                this.progressView.noLoading();
                ((View) this.progressView).postDelayed(new Runnable() {
                    public void run() {
                        DialogImpl dialogImpl = DialogImpl.this;
                        dialogImpl.showTip(WaitDialog.this.readyTipType);
                    }
                }, 100);
            }
            this.boxRoot.setOnBackPressedListener(new DialogXBaseRelativeLayout.PrivateBackPressedListener() {
                public boolean onBackPressed() {
                    if (WaitDialog.this.onBackPressedListener != null) {
                        if (!WaitDialog.this.onBackPressedListener.onBackPressed(WaitDialog.this)) {
                            return true;
                        }
                        WaitDialog.dismiss();
                        return true;
                    } else if (!WaitDialog.this.isCancelable()) {
                        return true;
                    } else {
                        WaitDialog.dismiss();
                        return true;
                    }
                }
            });
            WaitDialog.this.onDialogInit();
        }

        public void refreshView() {
            if (this.boxRoot != null && WaitDialog.this.getOwnActivity() != null) {
                this.boxRoot.setRootPadding(WaitDialog.this.screenPaddings[0], WaitDialog.this.screenPaddings[1], WaitDialog.this.screenPaddings[2], WaitDialog.this.screenPaddings[3]);
                this.bkg.setMaxWidth(WaitDialog.this.getMaxWidth());
                this.bkg.setMaxHeight(WaitDialog.this.getMaxHeight());
                this.bkg.setMinWidth(WaitDialog.this.getMinWidth());
                this.bkg.setMinHeight(WaitDialog.this.getMinHeight());
                if (WaitDialog.this.backgroundColor != null) {
                    List<View> list = this.blurViews;
                    if (list != null) {
                        Iterator<View> it = list.iterator();
                        while (it.hasNext()) {
                            ((BlurViewType) it.next()).setOverlayColor(WaitDialog.this.backgroundColor);
                        }
                    } else {
                        GradientDrawable gradientDrawable = (GradientDrawable) WaitDialog.this.getResources().getDrawable(R.drawable.rect_dialogx_material_wait_bkg);
                        gradientDrawable.setColor(WaitDialog.this.getBackgroundColor());
                        gradientDrawable.setCornerRadius(WaitDialog.this.getRadius());
                        this.bkg.setBackground(gradientDrawable);
                    }
                }
                if (WaitDialog.this.style.overrideWaitTipRes() != null) {
                    WaitDialog waitDialog = WaitDialog.this;
                    int intValue = waitDialog.getIntStyleAttr(Integer.valueOf(waitDialog.style.overrideWaitTipRes().overrideTextColorRes(WaitDialog.this.isLightTheme())), Integer.valueOf(WaitDialog.this.isLightTheme() ? R.color.white : R.color.black)).intValue();
                    this.txtInfo.setTextColor(WaitDialog.this.getResources().getColor(intValue));
                    this.progressView.setColor(WaitDialog.this.getResources().getColor(intValue));
                } else {
                    int i = WaitDialog.this.isLightTheme() ? R.color.white : R.color.black;
                    this.txtInfo.setTextColor(WaitDialog.this.getResources().getColor(i));
                    this.progressView.setColor(WaitDialog.this.getResources().getColor(i));
                }
                if (DialogX.tipProgressColor != null) {
                    this.progressView.setColor(DialogX.tipProgressColor.intValue());
                }
                if (WaitDialog.this.waitProgress >= 0.0f && WaitDialog.this.waitProgress <= 1.0f && this.oldProgress != WaitDialog.this.waitProgress) {
                    this.progressView.progress(WaitDialog.this.waitProgress);
                    this.oldProgress = WaitDialog.this.waitProgress;
                }
                if (WaitDialog.this.backgroundRadius > -1.0f) {
                    this.bkg.setOutlineProvider(new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), WaitDialog.this.backgroundRadius);
                        }
                    });
                    this.bkg.setClipToOutline(true);
                    List<View> list2 = this.blurViews;
                    if (list2 != null) {
                        Iterator<View> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            ((BlurViewType) it2.next()).setRadiusPx(Float.valueOf(WaitDialog.this.backgroundRadius));
                        }
                    }
                }
                WaitDialog waitDialog2 = WaitDialog.this;
                waitDialog2.showText(this.txtInfo, waitDialog2.message);
                BaseDialog.useTextInfo(this.txtInfo, WaitDialog.this.messageTextInfo);
                if (WaitDialog.this.maskColor != null) {
                    this.boxRoot.setBackgroundColor(WaitDialog.this.maskColor.intValue());
                }
                if (WaitDialog.this.onBindView == null || WaitDialog.this.onBindView.getCustomView() == null) {
                    this.boxCustomView.setVisibility(8);
                    this.boxProgress.setVisibility(0);
                } else {
                    WaitDialog.this.onBindView.bindParent(this.boxCustomView, WaitDialog.this);
                    this.boxCustomView.setVisibility(0);
                    this.boxProgress.setVisibility(8);
                }
                if (!WaitDialog.this.bkgInterceptTouch) {
                    this.boxRoot.setClickable(false);
                } else if (WaitDialog.this.isCancelable()) {
                    this.boxRoot.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (WaitDialog.this.onBackgroundMaskClickListener == null || !WaitDialog.this.onBackgroundMaskClickListener.onClick(WaitDialog.this, view)) {
                                DialogImpl.this.doDismiss(view);
                            }
                        }
                    });
                } else {
                    this.boxRoot.setOnClickListener((View.OnClickListener) null);
                }
                WaitDialog.this.onDialogRefreshUI();
            }
        }

        public void doDismiss(final View view) {
            if (this.boxRoot != null && WaitDialog.this.getOwnActivity() != null && !WaitDialog.this.dismissAnimFlag && this.boxRoot != null) {
                boolean unused = WaitDialog.this.dismissAnimFlag = true;
                this.boxRoot.post(new Runnable() {
                    public void run() {
                        View view = view;
                        if (view != null) {
                            view.setEnabled(false);
                        }
                        DialogImpl.this.getDialogXAnimImpl().doExitAnim(WaitDialog.this, DialogImpl.this.bkg);
                        WaitDialog.runOnMainDelay(new Runnable() {
                            public void run() {
                                if (DialogImpl.this.boxRoot != null) {
                                    DialogImpl.this.boxRoot.setVisibility(8);
                                }
                                WaitDialog.dismiss(WaitDialog.this.getWaitDialogView());
                            }
                        }, DialogImpl.this.getExitAnimationDuration((Animation) null));
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public DialogXAnimInterface<WaitDialog> getDialogXAnimImpl() {
            if (WaitDialog.this.dialogXAnimImpl == null) {
                WaitDialog.this.dialogXAnimImpl = new DialogXAnimInterface<WaitDialog>() {
                    public void doShowAnim(WaitDialog waitDialog, ViewGroup viewGroup) {
                        int i = R.anim.anim_dialogx_default_enter;
                        if (WaitDialog.overrideEnterAnimRes != 0) {
                            i = WaitDialog.overrideEnterAnimRes;
                        }
                        if (WaitDialog.this.customEnterAnimResId != 0) {
                            i = WaitDialog.this.customEnterAnimResId;
                        }
                        Animation loadAnimation = AnimationUtils.loadAnimation(WaitDialog.this.getOwnActivity(), i);
                        long enterAnimationDuration = DialogImpl.this.getEnterAnimationDuration(loadAnimation);
                        loadAnimation.setInterpolator(new DecelerateInterpolator());
                        loadAnimation.setDuration(enterAnimationDuration);
                        DialogImpl.this.bkg.startAnimation(loadAnimation);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.setDuration(enterAnimationDuration);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            }
                        });
                        ofFloat.start();
                        DialogImpl.this.boxRoot.animate().setDuration(enterAnimationDuration).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setListener((Animator.AnimatorListener) null);
                    }

                    public void doExitAnim(WaitDialog waitDialog, ViewGroup viewGroup) {
                        Context ownActivity = WaitDialog.this.getOwnActivity();
                        if (ownActivity == null) {
                            ownActivity = DialogImpl.this.boxRoot.getContext();
                        }
                        if (ownActivity != null) {
                            int i = R.anim.anim_dialogx_default_exit;
                            if (WaitDialog.overrideExitAnimRes != 0) {
                                i = WaitDialog.overrideExitAnimRes;
                            }
                            if (WaitDialog.this.customExitAnimResId != 0) {
                                i = WaitDialog.this.customExitAnimResId;
                            }
                            Animation loadAnimation = AnimationUtils.loadAnimation(ownActivity, i);
                            long exitAnimationDuration = DialogImpl.this.getExitAnimationDuration(loadAnimation);
                            loadAnimation.setDuration(exitAnimationDuration);
                            loadAnimation.setInterpolator(new AccelerateInterpolator());
                            DialogImpl.this.bkg.startAnimation(loadAnimation);
                            DialogImpl.this.boxRoot.animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(exitAnimationDuration);
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                            ofFloat.setDuration(exitAnimationDuration);
                            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    if (DialogImpl.this.boxRoot != null) {
                                        DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                    }
                                }
                            });
                            ofFloat.start();
                        }
                    }
                };
            }
            return WaitDialog.this.dialogXAnimImpl;
        }

        public long getExitAnimationDuration(Animation animation) {
            if (animation == null && this.bkg.getAnimation() != null) {
                animation = this.bkg.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (WaitDialog.overrideExitDuration >= 0) {
                duration = (long) WaitDialog.overrideExitDuration;
            }
            return WaitDialog.this.exitAnimDuration != -1 ? WaitDialog.this.exitAnimDuration : duration;
        }

        public long getEnterAnimationDuration(Animation animation) {
            if (animation == null && this.bkg.getAnimation() != null) {
                animation = this.bkg.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (WaitDialog.overrideEnterDuration >= 0) {
                duration = (long) WaitDialog.overrideEnterDuration;
            }
            return WaitDialog.this.enterAnimDuration >= 0 ? WaitDialog.this.enterAnimDuration : duration;
        }

        public void showTip(final TYPE type) {
            WaitDialog.runOnMain(new Runnable() {
                public void run() {
                    WaitDialog.this.showType = type.ordinal();
                    if (DialogImpl.this.progressView != null) {
                        int i = AnonymousClass7.$SwitchMap$com$kongzue$dialogx$dialogs$WaitDialog$TYPE[type.ordinal()];
                        if (i != 1) {
                            if (i == 2) {
                                DialogImpl.this.progressView.success();
                            } else if (i == 3) {
                                DialogImpl.this.progressView.warning();
                            } else if (i == 4) {
                                DialogImpl.this.progressView.error();
                            }
                            if (DialogImpl.this.boxProgress == null || DialogImpl.this.boxProgress.getVisibility() != 0) {
                                WaitDialog.this.getDialogLifecycleCallback().onShow(WaitDialog.this);
                                DialogImpl.this.refreshView();
                                if (WaitDialog.this.tipShowDuration > 0) {
                                    WaitDialog.runOnMainDelay(new Runnable() {
                                        public void run() {
                                            if (WaitDialog.this.showType > -1) {
                                                DialogImpl.this.doDismiss((View) null);
                                            }
                                        }
                                    }, WaitDialog.this.tipShowDuration);
                                    return;
                                }
                                return;
                            }
                            DialogImpl.this.progressView.whenShowTick(new Runnable() {
                                public void run() {
                                    WaitDialog.this.getDialogLifecycleCallback().onShow(WaitDialog.this);
                                    DialogImpl.this.refreshView();
                                    if (WaitDialog.this.tipShowDuration > 0) {
                                        ((View) DialogImpl.this.progressView).postDelayed(new Runnable() {
                                            public void run() {
                                                if (WaitDialog.this.showType > -1) {
                                                    DialogImpl.this.doDismiss((View) null);
                                                }
                                            }
                                        }, WaitDialog.this.tipShowDuration);
                                    }
                                }
                            });
                            return;
                        }
                        DialogImpl.this.progressView.loading();
                    }
                }
            });
        }
    }

    /* renamed from: com.kongzue.dialogx.dialogs.WaitDialog$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$kongzue$dialogx$dialogs$WaitDialog$TYPE;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.kongzue.dialogx.dialogs.WaitDialog$TYPE[] r0 = com.kongzue.dialogx.dialogs.WaitDialog.TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kongzue$dialogx$dialogs$WaitDialog$TYPE = r0
                com.kongzue.dialogx.dialogs.WaitDialog$TYPE r1 = com.kongzue.dialogx.dialogs.WaitDialog.TYPE.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$WaitDialog$TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kongzue.dialogx.dialogs.WaitDialog$TYPE r1 = com.kongzue.dialogx.dialogs.WaitDialog.TYPE.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$WaitDialog$TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kongzue.dialogx.dialogs.WaitDialog$TYPE r1 = com.kongzue.dialogx.dialogs.WaitDialog.TYPE.WARNING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$WaitDialog$TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kongzue.dialogx.dialogs.WaitDialog$TYPE r1 = com.kongzue.dialogx.dialogs.WaitDialog.TYPE.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.dialogs.WaitDialog.AnonymousClass7.<clinit>():void");
        }
    }

    public void cleanInstance() {
        this.isShow = false;
        getDialogLifecycleCallback().onDismiss(this);
        DialogXRunnable<WaitDialog> dialogXRunnable = this.onDismissRunnable;
        if (dialogXRunnable != null) {
            dialogXRunnable.run(this);
        }
        WeakReference<DialogImpl> weakReference = this.dialogImpl;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.dialogImpl = null;
        WeakReference<View> weakReference2 = this.dialogView;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.dialogView = null;
        this.dialogLifecycleCallback = null;
        WeakReference<WaitDialog> weakReference3 = me;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        me = null;
        setLifecycleState(Lifecycle.State.DESTROYED);
        System.gc();
    }

    /* access modifiers changed from: private */
    public void setDialogImpl(DialogImpl dialogImpl2) {
        WeakReference<DialogImpl> weakReference = this.dialogImpl;
        if (weakReference != null && weakReference.get() != dialogImpl2) {
            this.dialogImpl = new WeakReference<>(dialogImpl2);
        }
    }

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    public boolean isLightTheme() {
        if (DialogX.tipTheme == null) {
            return super.isLightTheme();
        }
        return DialogX.tipTheme == DialogX.THEME.LIGHT;
    }

    public void refreshUI() {
        if (getDialogImpl() != null) {
            runOnMain(new Runnable() {
                public void run() {
                    if (WaitDialog.this.getDialogImpl() != null) {
                        WaitDialog.this.getDialogImpl().refreshView();
                    }
                }
            });
        }
    }

    public void doDismiss() {
        this.isShow = false;
        runOnMain(new Runnable() {
            public void run() {
                if (WaitDialog.this.getDialogImpl() != null) {
                    WaitDialog.this.getDialogImpl().doDismiss((View) null);
                }
            }
        });
    }

    public static void dismiss() {
        me().doDismiss();
    }

    public static void dismiss(Activity activity) {
        WaitDialog instance = getInstance(activity);
        if (instance != null) {
            instance.doDismiss();
        }
    }

    public static void dismiss(long j) {
        Timer timer = delayDismissTimer;
        if (timer != null) {
            timer.cancel();
        }
        Timer timer2 = new Timer();
        delayDismissTimer = timer2;
        timer2.schedule(new TimerTask() {
            public void run() {
                WaitDialog.dismiss();
            }
        }, j);
    }

    protected static WaitDialog me() {
        for (BaseDialog next : getRunningDialogList()) {
            if ((next instanceof WaitDialog) && next.isShow() && next.getOwnActivity() == getTopActivity()) {
                return (WaitDialog) next;
            }
        }
        WeakReference<WaitDialog> weakReference = me;
        if (weakReference == null || weakReference.get() == null) {
            return instanceBuild();
        }
        return (WaitDialog) me.get();
    }

    /* access modifiers changed from: protected */
    public void showTip(CharSequence charSequence, TYPE type) {
        this.showType = type.ordinal();
        this.message = charSequence;
        this.readyTipType = type;
        show();
    }

    /* access modifiers changed from: protected */
    public void showTip(Activity activity, CharSequence charSequence, TYPE type) {
        this.showType = type.ordinal();
        this.message = charSequence;
        this.readyTipType = type;
        show(activity);
    }

    /* access modifiers changed from: protected */
    public void showTip(int i, TYPE type) {
        this.showType = type.ordinal();
        this.message = getString(i);
        this.readyTipType = type;
        show();
    }

    /* access modifiers changed from: protected */
    public void showTip(Activity activity, int i, TYPE type) {
        this.showType = type.ordinal();
        this.message = getString(i);
        this.readyTipType = type;
        show(activity);
    }

    /* access modifiers changed from: protected */
    public void showTip(TYPE type) {
        if (this.readyTipType != type) {
            this.showType = type.ordinal();
            this.readyTipType = type;
            if (getDialogImpl() != null) {
                getDialogImpl().showTip(type);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setTip(TYPE type) {
        showTip(type);
    }

    /* access modifiers changed from: protected */
    public void setTip(CharSequence charSequence, TYPE type) {
        this.message = charSequence;
        showTip(type);
        refreshUI();
    }

    /* access modifiers changed from: protected */
    public void setTip(int i, TYPE type) {
        this.message = getString(i);
        showTip(type);
        refreshUI();
    }

    /* access modifiers changed from: protected */
    public void setTipShowDuration(long j) {
        this.tipShowDuration = j;
        showTip(this.readyTipType);
    }

    public static CharSequence getMessage() {
        return me().message;
    }

    public static WaitDialog setMessage(CharSequence charSequence) {
        me().preMessage(charSequence);
        me().refreshUI();
        return me();
    }

    public static WaitDialog setMessage(int i) {
        me().preMessage(i);
        me().refreshUI();
        return me();
    }

    public boolean isCancelable() {
        BaseDialog.BOOLEAN booleanR = this.privateCancelable;
        if (booleanR == null) {
            BaseDialog.BOOLEAN booleanR2 = overrideCancelable;
            if (booleanR2 == null) {
                return DialogX.cancelableTipDialog;
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

    public WaitDialog setCancelable(boolean z) {
        this.privateCancelable = z ? BaseDialog.BOOLEAN.TRUE : BaseDialog.BOOLEAN.FALSE;
        refreshUI();
        return this;
    }

    /* access modifiers changed from: protected */
    public WaitDialog preMessage(CharSequence charSequence) {
        this.message = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public WaitDialog preMessage(int i) {
        this.message = getString(i);
        return this;
    }

    public DialogLifecycleCallback<WaitDialog> getDialogLifecycleCallback() {
        DialogLifecycleCallback<WaitDialog> dialogLifecycleCallback2 = this.dialogLifecycleCallback;
        return dialogLifecycleCallback2 == null ? new DialogLifecycleCallback<WaitDialog>() {
        } : dialogLifecycleCallback2;
    }

    public WaitDialog setDialogLifecycleCallback(DialogLifecycleCallback<WaitDialog> dialogLifecycleCallback2) {
        this.dialogLifecycleCallback = dialogLifecycleCallback2;
        if (this.isShow) {
            dialogLifecycleCallback2.onShow(me());
        }
        return this;
    }

    public DialogImpl getDialogImpl() {
        WeakReference<DialogImpl> weakReference = this.dialogImpl;
        if (weakReference == null) {
            return null;
        }
        return (DialogImpl) weakReference.get();
    }

    public WaitDialog setCustomView(OnBindView<WaitDialog> onBindView2) {
        this.onBindView = onBindView2;
        refreshUI();
        return this;
    }

    public View getCustomView() {
        OnBindView<WaitDialog> onBindView2 = this.onBindView;
        if (onBindView2 == null) {
            return null;
        }
        return onBindView2.getCustomView();
    }

    public WaitDialog removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public OnBackPressedListener<WaitDialog> getOnBackPressedListener() {
        return this.onBackPressedListener;
    }

    public WaitDialog setOnBackPressedListener(OnBackPressedListener<WaitDialog> onBackPressedListener2) {
        this.onBackPressedListener = onBackPressedListener2;
        refreshUI();
        return this;
    }

    public int getBackgroundColor() {
        return this.backgroundColor.intValue();
    }

    public WaitDialog setBackgroundColor(int i) {
        this.backgroundColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public WaitDialog setBackgroundColorRes(int i) {
        this.backgroundColor = Integer.valueOf(getColor(i));
        refreshUI();
        return this;
    }

    public WaitDialog setMaskColor(int i) {
        this.maskColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public WaitDialog setEnterAnimDuration(long j) {
        this.enterAnimDuration = j;
        return this;
    }

    public long getExitAnimDuration() {
        return this.exitAnimDuration;
    }

    public WaitDialog setExitAnimDuration(long j) {
        this.exitAnimDuration = j;
        return this;
    }

    public void restartDialog() {
        refreshUI();
    }

    public static WaitDialog getInstance() {
        return me();
    }

    public static int getType() {
        return me().showType;
    }

    public WaitDialog setAnimResId(int i, int i2) {
        this.customEnterAnimResId = i;
        this.customExitAnimResId = i2;
        return this;
    }

    public WaitDialog setEnterAnimResId(int i) {
        this.customEnterAnimResId = i;
        return this;
    }

    public WaitDialog setExitAnimResId(int i) {
        this.customExitAnimResId = i;
        return this;
    }

    protected static boolean noInstance() {
        if (getTopActivity() != null && getInstance(getTopActivity()) != null) {
            return false;
        }
        WeakReference<WaitDialog> weakReference = me;
        if (weakReference == null || weakReference.get() == null || ((WaitDialog) me.get()).getOwnActivity() == null || ((WaitDialog) me.get()).getOwnActivity() != getTopActivity() || !((WaitDialog) me.get()).isShow) {
            return true;
        }
        return false;
    }

    protected static boolean noInstance(Activity activity) {
        if (getTopActivity() != null && getInstance(activity) != null) {
            return false;
        }
        WeakReference<WaitDialog> weakReference = me;
        if (weakReference == null || weakReference.get() == null || ((WaitDialog) me.get()).getOwnActivity() == null || ((WaitDialog) me.get()).getOwnActivity() != activity || !((WaitDialog) me.get()).isShow) {
            return true;
        }
        return false;
    }

    public static WaitDialog getInstanceNotNull(Activity activity) {
        for (BaseDialog next : getRunningDialogList()) {
            if ((next instanceof WaitDialog) && next.isShow() && next.getOwnActivity() == activity) {
                return (WaitDialog) next;
            }
        }
        return instanceBuild();
    }

    public static WaitDialog getInstance(Activity activity) {
        for (BaseDialog next : getRunningDialogList()) {
            if ((next instanceof WaitDialog) && next.isShow() && next.getOwnActivity() == activity) {
                return (WaitDialog) next;
            }
        }
        return null;
    }

    protected static void showWithInstance(boolean z) {
        Timer timer = delayDismissTimer;
        if (timer != null) {
            timer.cancel();
        }
        if (z) {
            me().show();
        } else {
            me().refreshUI();
        }
    }

    protected static void showWithInstance(WaitDialog waitDialog, Activity activity) {
        Timer timer = delayDismissTimer;
        if (timer != null) {
            timer.cancel();
        }
        if (activity == null) {
            waitDialog.show();
        } else {
            waitDialog.show(activity);
        }
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        dismiss();
    }

    public WaitDialog setMaxWidth(int i) {
        this.maxWidth = i;
        refreshUI();
        return this;
    }

    public WaitDialog setMaxHeight(int i) {
        this.maxHeight = i;
        refreshUI();
        return this;
    }

    public WaitDialog setMinHeight(int i) {
        this.minHeight = i;
        refreshUI();
        return this;
    }

    public WaitDialog setMinWidth(int i) {
        this.minWidth = i;
        refreshUI();
        return this;
    }

    public WaitDialog setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public boolean isBkgInterceptTouch() {
        return this.bkgInterceptTouch;
    }

    public WaitDialog setBkgInterceptTouch(boolean z) {
        this.bkgInterceptTouch = z;
        return this;
    }

    public OnBackgroundMaskClickListener<WaitDialog> getOnBackgroundMaskClickListener() {
        return this.onBackgroundMaskClickListener;
    }

    public WaitDialog setOnBackgroundMaskClickListener(OnBackgroundMaskClickListener<WaitDialog> onBackgroundMaskClickListener2) {
        this.onBackgroundMaskClickListener = onBackgroundMaskClickListener2;
        return this;
    }

    public WaitDialog setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public WaitDialog setTheme(DialogX.THEME theme) {
        this.theme = theme;
        return this;
    }

    public TextInfo getMessageTextInfo() {
        return this.messageTextInfo;
    }

    public WaitDialog setMessageTextInfo(TextInfo textInfo) {
        this.messageTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public WaitDialog setMessageContent(CharSequence charSequence) {
        this.message = charSequence;
        refreshUI();
        return this;
    }

    public WaitDialog setMessageContent(int i) {
        this.message = getString(i);
        refreshUI();
        return this;
    }

    public CharSequence getMessageContent() {
        return this.message;
    }

    public WaitDialog setTipType(TYPE type) {
        showTip(type);
        return this;
    }

    public WaitDialog setRadius(float f) {
        this.backgroundRadius = f;
        refreshUI();
        return this;
    }

    public float getRadius() {
        float f = this.backgroundRadius;
        return f < 0.0f ? (float) dip2px(15.0f) : f;
    }

    public DialogXAnimInterface<WaitDialog> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public WaitDialog setDialogXAnimImpl(DialogXAnimInterface<WaitDialog> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public WaitDialog setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public WaitDialog setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public WaitDialog onShow(DialogXRunnable<WaitDialog> dialogXRunnable) {
        this.onShowRunnable = dialogXRunnable;
        return this;
    }

    public WaitDialog onDismiss(DialogXRunnable<WaitDialog> dialogXRunnable) {
        this.onDismissRunnable = dialogXRunnable;
        return this;
    }
}
