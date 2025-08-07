package com.kongzue.dialogx.dialogs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
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
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.NoTouchInterface;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialogx.interfaces.OnSafeInsetsChangeListener;
import com.kongzue.dialogx.util.PopValueAnimator;
import com.kongzue.dialogx.util.TextInfo;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.microtech.aidexx.ui.pair.PairUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class PopNotification extends BaseDialog implements NoTouchInterface {
    public static final int TIME_NO_AUTO_DISMISS_DELAY = -1;
    public static int overrideEnterAnimRes = 0;
    public static long overrideEnterDuration = -1;
    public static int overrideExitAnimRes = 0;
    public static long overrideExitDuration = -1;
    protected static List<PopNotification> popNotificationList;
    protected DialogXStyle.PopNotificationSettings.ALIGN align;
    protected long autoDismissDelay = Long.MIN_VALUE;
    protected Timer autoDismissTimer;
    protected boolean autoTintIconInLightOrDarkMode = true;
    protected float backgroundRadius = -1.0f;
    protected int[] bodyMargin = {-1, -1, -1, -1};
    protected CharSequence buttonText;
    protected TextInfo buttonTextInfo = new TextInfo().setBold(true);
    /* access modifiers changed from: private */
    public float defaultTop;
    protected DialogImpl dialogImpl;
    protected DialogLifecycleCallback<PopNotification> dialogLifecycleCallback;
    protected DialogXAnimInterface<PopNotification> dialogXAnimImpl;
    protected int enterAnimResId = 0;
    protected int exitAnimResId = 0;
    protected Bitmap iconBitmap;
    protected Drawable iconDrawable;
    protected int iconResId;
    protected int iconSize;
    private boolean isHide;
    protected PopNotification me = this;
    protected CharSequence message;
    protected TextInfo messageTextInfo;
    protected OnBindView<PopNotification> onBindView;
    protected OnDialogButtonClickListener<PopNotification> onButtonClickListener;
    protected OnDialogButtonClickListener<PopNotification> onPopNotificationClickListener;
    protected boolean preRecycle = false;
    protected boolean slideToClose = true;
    protected BaseDialog.BOOLEAN tintIcon;
    protected CharSequence title;
    protected TextInfo titleTextInfo;

    public boolean isCancelable() {
        return false;
    }

    public void onDismiss(PopNotification popNotification) {
    }

    public void onShow(PopNotification popNotification) {
    }

    protected PopNotification() {
    }

    public static PopNotification build() {
        return new PopNotification();
    }

    public static PopNotification build(DialogXStyle dialogXStyle) {
        return new PopNotification().setStyle(dialogXStyle);
    }

    public static PopNotification build(OnBindView<PopNotification> onBindView2) {
        return new PopNotification().setCustomView(onBindView2);
    }

    public PopNotification(OnBindView<PopNotification> onBindView2) {
        this.onBindView = onBindView2;
    }

    public PopNotification(CharSequence charSequence) {
        this.title = charSequence;
    }

    public PopNotification(CharSequence charSequence, CharSequence charSequence2) {
        this.title = charSequence;
        this.message = charSequence2;
    }

    public PopNotification(int i) {
        this.title = getString(i);
    }

    public PopNotification(int i, int i2) {
        this.title = getString(i);
        this.message = getString(i2);
    }

    public PopNotification(int i, CharSequence charSequence) {
        this.iconResId = i;
        this.title = charSequence;
    }

    public PopNotification(int i, CharSequence charSequence, CharSequence charSequence2) {
        this.iconResId = i;
        this.title = charSequence;
        this.message = charSequence2;
    }

    public PopNotification(int i, int i2, int i3) {
        this.iconResId = i;
        this.title = getString(i2);
        this.message = getString(i3);
    }

    public PopNotification(CharSequence charSequence, OnBindView<PopNotification> onBindView2) {
        this.title = charSequence;
        this.onBindView = onBindView2;
    }

    public PopNotification(CharSequence charSequence, CharSequence charSequence2, OnBindView<PopNotification> onBindView2) {
        this.title = charSequence;
        this.message = charSequence2;
        this.onBindView = onBindView2;
    }

    public PopNotification(int i, OnBindView<PopNotification> onBindView2) {
        this.title = getString(i);
        this.onBindView = onBindView2;
    }

    public PopNotification(int i, int i2, OnBindView<PopNotification> onBindView2) {
        this.title = getString(i);
        this.message = getString(i2);
        this.onBindView = onBindView2;
    }

    public PopNotification(int i, CharSequence charSequence, OnBindView<PopNotification> onBindView2) {
        this.iconResId = i;
        this.title = charSequence;
        this.onBindView = onBindView2;
    }

    public PopNotification(int i, CharSequence charSequence, CharSequence charSequence2, OnBindView<PopNotification> onBindView2) {
        this.iconResId = i;
        this.title = charSequence;
        this.message = charSequence2;
        this.onBindView = onBindView2;
    }

    public PopNotification(int i, int i2, int i3, OnBindView<PopNotification> onBindView2) {
        this.iconResId = i;
        this.title = getString(i2);
        this.message = getString(i3);
        this.onBindView = onBindView2;
    }

    public PopNotification(int i, int i2, int i3, int i4) {
        this.iconResId = i;
        this.title = getString(i2);
        this.message = getString(i3);
        this.buttonText = getString(i4);
    }

    public PopNotification(int i, int i2, int i3, int i4, OnBindView<PopNotification> onBindView2) {
        this.iconResId = i;
        this.title = getString(i2);
        this.message = getString(i3);
        this.buttonText = getString(i4);
        this.onBindView = onBindView2;
    }

    public PopNotification(int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.iconResId = i;
        this.title = charSequence;
        this.message = charSequence2;
        this.buttonText = charSequence3;
    }

    public PopNotification(int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, OnBindView<PopNotification> onBindView2) {
        this.iconResId = i;
        this.title = charSequence;
        this.message = charSequence2;
        this.buttonText = charSequence3;
        this.onBindView = onBindView2;
    }

    public static PopNotification show(OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(CharSequence charSequence) {
        PopNotification popNotification = new PopNotification(charSequence);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(CharSequence charSequence, CharSequence charSequence2) {
        PopNotification popNotification = new PopNotification(charSequence, charSequence2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i) {
        PopNotification popNotification = new PopNotification(i);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, int i2) {
        PopNotification popNotification = new PopNotification(i, i2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(CharSequence charSequence, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(charSequence, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(CharSequence charSequence, CharSequence charSequence2, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(charSequence, charSequence2, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(i, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, int i2, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(i, i2, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, CharSequence charSequence, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(i, charSequence, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, CharSequence charSequence, CharSequence charSequence2, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(i, charSequence, charSequence2, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, CharSequence charSequence) {
        PopNotification popNotification = new PopNotification(i, charSequence);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, CharSequence charSequence, CharSequence charSequence2) {
        PopNotification popNotification = new PopNotification(i, charSequence, charSequence2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, int i2, int i3) {
        PopNotification popNotification = new PopNotification(i, i2, i3);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, int i2, int i3, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(i, i2, i3, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, int i2, int i3, int i4) {
        PopNotification popNotification = new PopNotification(i, i2, i3, i4);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, int i2, int i3, int i4, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(i, i2, i3, i4, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        PopNotification popNotification = new PopNotification(i, charSequence, charSequence2, charSequence3);
        popNotification.show();
        return popNotification;
    }

    public static PopNotification show(int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, OnBindView<PopNotification> onBindView2) {
        PopNotification popNotification = new PopNotification(i, charSequence, charSequence2, charSequence3, onBindView2);
        popNotification.show();
        return popNotification;
    }

    public PopNotification show() {
        long j;
        long j2;
        PopNotification popNotification;
        if (!this.isHide || getDialogView() == null) {
            super.beforeShow();
            if (getDialogView() == null) {
                if (DialogX.onlyOnePopNotification) {
                    List<PopNotification> list = popNotificationList;
                    if (list == null || list.isEmpty()) {
                        popNotification = null;
                    } else {
                        List<PopNotification> list2 = popNotificationList;
                        popNotification = list2.get(list2.size() - 1);
                    }
                    if (popNotification != null) {
                        popNotification.dismiss();
                    }
                }
                if (popNotificationList == null) {
                    popNotificationList = new ArrayList();
                }
                popNotificationList.add(this);
                int i = isLightTheme() ? R.layout.layout_dialogx_popnotification_material : R.layout.layout_dialogx_popnotification_material_dark;
                if (this.style.popNotificationSettings() != null) {
                    if (this.style.popNotificationSettings().layout(isLightTheme()) != 0) {
                        i = this.style.popNotificationSettings().layout(isLightTheme());
                    }
                    DialogXStyle.PopNotificationSettings.ALIGN align2 = this.style.popNotificationSettings().align();
                    this.align = align2;
                    if (align2 == null) {
                        this.align = DialogXStyle.PopNotificationSettings.ALIGN.TOP;
                    }
                    int enterAnimResId2 = this.style.popNotificationSettings().enterAnimResId(isLightTheme());
                    int exitAnimResId2 = this.style.popNotificationSettings().exitAnimResId(isLightTheme());
                    int i2 = this.enterAnimResId;
                    if (i2 != 0 || (i2 = overrideEnterAnimRes) != 0) {
                        enterAnimResId2 = i2;
                    } else if (enterAnimResId2 == 0) {
                        enterAnimResId2 = R.anim.anim_dialogx_notification_enter;
                    }
                    this.enterAnimResId = enterAnimResId2;
                    int i3 = this.exitAnimResId;
                    if (i3 != 0 || (i3 = overrideExitAnimRes) != 0) {
                        exitAnimResId2 = i3;
                    } else if (exitAnimResId2 == 0) {
                        exitAnimResId2 = R.anim.anim_dialogx_notification_exit;
                    }
                    this.exitAnimResId = exitAnimResId2;
                    if (this.enterAnimDuration == -1) {
                        j = overrideEnterDuration;
                    } else {
                        j = this.enterAnimDuration;
                    }
                    this.enterAnimDuration = j;
                    if (this.exitAnimDuration == -1) {
                        j2 = overrideExitDuration;
                    } else {
                        j2 = this.exitAnimDuration;
                    }
                    this.exitAnimDuration = j2;
                }
                View createView = createView(i);
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
        getDialogView().setVisibility(0);
        return this;
    }

    public PopNotification show(Activity activity) {
        long j;
        long j2;
        PopNotification popNotification;
        super.beforeShow();
        if (getDialogView() != null) {
            if (DialogX.onlyOnePopNotification) {
                List<PopNotification> list = popNotificationList;
                if (list == null || list.isEmpty()) {
                    popNotification = null;
                } else {
                    List<PopNotification> list2 = popNotificationList;
                    popNotification = list2.get(list2.size() - 1);
                }
                if (popNotification != null) {
                    popNotification.dismiss();
                }
            }
            if (popNotificationList == null) {
                popNotificationList = new ArrayList();
            }
            popNotificationList.add(this);
            int i = isLightTheme() ? R.layout.layout_dialogx_popnotification_material : R.layout.layout_dialogx_popnotification_material_dark;
            if (this.style.popNotificationSettings() != null) {
                if (this.style.popNotificationSettings().layout(isLightTheme()) != 0) {
                    i = this.style.popNotificationSettings().layout(isLightTheme());
                }
                DialogXStyle.PopNotificationSettings.ALIGN align2 = this.style.popNotificationSettings().align();
                this.align = align2;
                if (align2 == null) {
                    this.align = DialogXStyle.PopNotificationSettings.ALIGN.TOP;
                }
                int enterAnimResId2 = this.style.popNotificationSettings().enterAnimResId(isLightTheme());
                int exitAnimResId2 = this.style.popNotificationSettings().exitAnimResId(isLightTheme());
                int i2 = this.enterAnimResId;
                if (i2 != 0 || (i2 = overrideEnterAnimRes) != 0) {
                    enterAnimResId2 = i2;
                } else if (enterAnimResId2 == 0) {
                    enterAnimResId2 = R.anim.anim_dialogx_notification_enter;
                }
                this.enterAnimResId = enterAnimResId2;
                int i3 = this.exitAnimResId;
                if (i3 != 0 || (i3 = overrideExitAnimRes) != 0) {
                    exitAnimResId2 = i3;
                } else if (exitAnimResId2 == 0) {
                    exitAnimResId2 = R.anim.anim_dialogx_notification_exit;
                }
                this.exitAnimResId = exitAnimResId2;
                if (this.enterAnimDuration == -1) {
                    j = overrideEnterDuration;
                } else {
                    j = this.enterAnimDuration;
                }
                this.enterAnimDuration = j;
                if (this.exitAnimDuration == -1) {
                    j2 = overrideExitDuration;
                } else {
                    j2 = this.exitAnimDuration;
                }
                this.exitAnimDuration = j2;
            }
            View createView = createView(i);
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

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    public PopNotification autoDismiss(long j) {
        this.autoDismissDelay = j;
        Timer timer = this.autoDismissTimer;
        if (timer != null) {
            timer.cancel();
        }
        if (j < 0) {
            return this;
        }
        Timer timer2 = new Timer();
        this.autoDismissTimer = timer2;
        timer2.schedule(new TimerTask() {
            public void run() {
                PopNotification.this.dismiss();
            }
        }, j);
        return this;
    }

    public void resetAutoDismissTimer() {
        autoDismiss(this.autoDismissDelay);
    }

    private boolean isNoSetCustomDelay() {
        return this.autoDismissDelay == Long.MIN_VALUE;
    }

    public PopNotification showShort() {
        if (isNoSetCustomDelay()) {
            autoDismiss(PairUtilKt.DELAY_A_WHILE);
        }
        if (!this.preShow && !this.isShow) {
            show();
        }
        return this;
    }

    public PopNotification showLong() {
        autoDismiss(3500);
        if (!this.preShow && !this.isShow) {
            show();
        }
        return this;
    }

    public PopNotification showAlways() {
        return noAutoDismiss();
    }

    public PopNotification noAutoDismiss() {
        autoDismiss(-1);
        return this;
    }

    public class DialogImpl implements DialogConvertViewInterface {
        /* access modifiers changed from: private */
        public List<View> blurViews;
        public ViewGroup boxBody;
        public RelativeLayout boxCustom;
        public DialogXBaseRelativeLayout boxRoot;
        public ImageView imgDialogxPopIcon;
        public TextView txtDialogxButton;
        public TextView txtDialogxPopMessage;
        public TextView txtDialogxPopTitle;

        public DialogImpl(View view) {
            if (view != null) {
                PopNotification.this.setDialogView(view);
                this.boxRoot = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
                this.boxBody = (ViewGroup) view.findViewById(R.id.box_body);
                this.imgDialogxPopIcon = (ImageView) view.findViewById(R.id.img_dialogx_pop_icon);
                this.txtDialogxPopTitle = (TextView) view.findViewById(R.id.txt_dialogx_pop_title);
                this.txtDialogxPopMessage = (TextView) view.findViewById(R.id.txt_dialogx_pop_message);
                this.txtDialogxButton = (TextView) view.findViewById(R.id.txt_dialogx_button);
                this.boxCustom = (RelativeLayout) view.findViewById(R.id.box_custom);
                this.blurViews = PopNotification.this.findAllBlurView(view);
                init();
                PopNotification.this.dialogImpl = this;
                refreshView();
            }
        }

        public void init() {
            if (PopNotification.this.titleTextInfo == null) {
                PopNotification.this.titleTextInfo = DialogX.titleTextInfo;
            }
            if (PopNotification.this.messageTextInfo == null) {
                PopNotification.this.messageTextInfo = DialogX.messageTextInfo;
            }
            if (PopNotification.this.buttonTextInfo == null) {
                PopNotification.this.buttonTextInfo = DialogX.buttonTextInfo;
            }
            if (PopNotification.this.backgroundColor == null) {
                Integer unused = PopNotification.this.backgroundColor = DialogX.backgroundColor;
            }
            if (PopNotification.this.autoDismissTimer == null) {
                PopNotification.this.showShort();
            }
            this.boxRoot.setClickable(false);
            this.boxRoot.setFocusable(false);
            this.boxRoot.setParentDialog(PopNotification.this.me);
            this.boxRoot.setAutoUnsafePlacePadding(false);
            this.boxRoot.setOnLifecycleCallBack(new DialogXBaseRelativeLayout.OnLifecycleCallBack() {
                public void onShow() {
                    boolean unused = PopNotification.this.isShow = true;
                    boolean unused2 = PopNotification.this.preShow = false;
                    PopNotification.this.setLifecycleState(Lifecycle.State.CREATED);
                    DialogImpl.this.boxRoot.setAlpha(0.0f);
                    PopNotification.this.onDialogShow();
                    PopNotification.this.getDialogLifecycleCallback().onShow(PopNotification.this.me);
                    PopNotification.this.onShow(PopNotification.this.me);
                }

                public void onDismiss() {
                    if (PopNotification.popNotificationList != null) {
                        PopNotification.popNotificationList.remove(PopNotification.this);
                        if (PopNotification.popNotificationList.isEmpty()) {
                            PopNotification.popNotificationList = null;
                        }
                    }
                    if (PopNotification.this.autoDismissTimer != null) {
                        PopNotification.this.autoDismissTimer.cancel();
                    }
                    boolean unused = PopNotification.this.isShow = false;
                    PopNotification.this.getDialogLifecycleCallback().onDismiss(PopNotification.this.me);
                    PopNotification.this.onDismiss(PopNotification.this.me);
                    PopNotification.this.dialogImpl = null;
                    PopNotification.this.setLifecycleState(Lifecycle.State.DESTROYED);
                    System.gc();
                }
            });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.boxBody.getLayoutParams();
            if (PopNotification.this.align == null) {
                PopNotification.this.align = DialogXStyle.PopNotificationSettings.ALIGN.TOP;
            }
            int i = AnonymousClass6.$SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN[PopNotification.this.align.ordinal()];
            if (i == 1) {
                layoutParams.removeRule(13);
                layoutParams.addRule(10);
            } else if (i == 2) {
                layoutParams.removeRule(13);
                layoutParams.addRule(12);
                this.boxRoot.setAutoUnsafePlacePadding(true);
            } else if (i == 3) {
                layoutParams.removeRule(10);
                layoutParams.removeRule(12);
                layoutParams.addRule(13);
            }
            this.boxBody.setLayoutParams(layoutParams);
            this.boxRoot.setOnSafeInsetsChangeListener(new OnSafeInsetsChangeListener() {
                public void onChange(Rect rect) {
                    if (PopNotification.this.align == DialogXStyle.PopNotificationSettings.ALIGN.TOP) {
                        DialogImpl.this.boxBody.setY(PopNotification.this.defaultTop = (float) (rect.top + PopNotification.this.bodyMargin[1]));
                    } else if (PopNotification.this.align == DialogXStyle.PopNotificationSettings.ALIGN.TOP_INSIDE) {
                        DialogImpl.this.boxBody.setPadding(0, rect.top, 0, 0);
                    }
                }
            });
            this.boxRoot.setOnBackPressedListener(new DialogXBaseRelativeLayout.PrivateBackPressedListener() {
                public boolean onBackPressed() {
                    return false;
                }
            });
            this.boxRoot.post(new Runnable() {
                public void run() {
                    Float f;
                    Integer num;
                    DialogImpl.this.getDialogXAnimImpl().doShowAnim(PopNotification.this.me, DialogImpl.this.boxBody);
                    if (!DialogX.onlyOnePopNotification && PopNotification.popNotificationList != null) {
                        for (int i = 0; i < PopNotification.popNotificationList.size() - 1; i++) {
                            PopNotification.popNotificationList.get(i).moveUp(DialogImpl.this.boxBody.getHeight());
                        }
                    }
                    if (PopNotification.this.getStyle().popNotificationSettings() == null || PopNotification.this.getStyle().popNotificationSettings().blurBackgroundSettings() == null || !PopNotification.this.getStyle().popNotificationSettings().blurBackgroundSettings().blurBackground()) {
                        num = null;
                        f = null;
                    } else {
                        if (PopNotification.this.backgroundColor == null) {
                            num = PopNotification.this.getColorNullable(PopNotification.this.getIntStyleAttr(Integer.valueOf(PopNotification.this.getStyle().popNotificationSettings().blurBackgroundSettings().blurForwardColorRes(PopNotification.this.isLightTheme()))));
                        } else {
                            num = PopNotification.this.backgroundColor;
                        }
                        f = PopNotification.this.getFloatStyleAttr(Float.valueOf((float) PopNotification.this.getStyle().popNotificationSettings().blurBackgroundSettings().blurBackgroundRoundRadiusPx()));
                    }
                    if (DialogImpl.this.blurViews != null) {
                        for (View view : DialogImpl.this.blurViews) {
                            BlurViewType blurViewType = (BlurViewType) view;
                            blurViewType.setOverlayColor(PopNotification.this.backgroundColor == null ? num : PopNotification.this.backgroundColor);
                            blurViewType.setRadiusPx(f);
                        }
                    }
                    PopNotification.this.setLifecycleState(Lifecycle.State.RESUMED);
                }
            });
            this.boxBody.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (PopNotification.this.onPopNotificationClickListener == null) {
                        PopNotification.this.dismiss();
                    } else if (!PopNotification.this.onPopNotificationClickListener.onClick(PopNotification.this.me, view)) {
                        PopNotification.this.dismiss();
                    }
                }
            });
            this.txtDialogxButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (PopNotification.this.onButtonClickListener == null) {
                        DialogImpl.this.doDismiss(view);
                    } else if (!PopNotification.this.onButtonClickListener.onClick(PopNotification.this.me, view)) {
                        DialogImpl.this.doDismiss(view);
                    }
                }
            });
            PopNotification.this.onDialogInit();
        }

        public void refreshView() {
            if (this.boxRoot != null && PopNotification.this.getOwnActivity() != null) {
                this.boxRoot.setRootPadding(PopNotification.this.screenPaddings[0], PopNotification.this.screenPaddings[1], PopNotification.this.screenPaddings[2], PopNotification.this.screenPaddings[3]);
                if (PopNotification.this.backgroundColor != null) {
                    PopNotification popNotification = PopNotification.this;
                    popNotification.tintColor(this.boxBody, popNotification.backgroundColor.intValue());
                    List<View> list = this.blurViews;
                    if (list != null) {
                        Iterator<View> it = list.iterator();
                        while (it.hasNext()) {
                            ((BlurViewType) it.next()).setOverlayColor(PopNotification.this.backgroundColor);
                        }
                    }
                }
                if (PopNotification.this.onBindView == null || PopNotification.this.onBindView.getCustomView() == null) {
                    this.boxCustom.setVisibility(8);
                } else {
                    PopNotification.this.onBindView.bindParent(this.boxCustom, PopNotification.this.me);
                    this.boxCustom.setVisibility(0);
                }
                if (PopNotification.this.backgroundRadius > -1.0f) {
                    GradientDrawable gradientDrawable = (GradientDrawable) this.boxBody.getBackground();
                    if (gradientDrawable != null) {
                        gradientDrawable.setCornerRadius(PopNotification.this.backgroundRadius);
                    }
                    this.boxBody.setOutlineProvider(new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), PopNotification.this.backgroundRadius);
                        }
                    });
                    this.boxBody.setClipToOutline(true);
                    List<View> list2 = this.blurViews;
                    if (list2 != null) {
                        Iterator<View> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            ((BlurViewType) it2.next()).setRadiusPx(Float.valueOf(PopNotification.this.backgroundRadius));
                        }
                    }
                }
                PopNotification popNotification2 = PopNotification.this;
                popNotification2.showText(this.txtDialogxPopTitle, popNotification2.title);
                PopNotification popNotification3 = PopNotification.this;
                popNotification3.showText(this.txtDialogxPopMessage, popNotification3.message);
                PopNotification popNotification4 = PopNotification.this;
                popNotification4.showText(this.txtDialogxButton, popNotification4.buttonText);
                BaseDialog.useTextInfo(this.txtDialogxPopTitle, PopNotification.this.titleTextInfo);
                BaseDialog.useTextInfo(this.txtDialogxPopMessage, PopNotification.this.messageTextInfo);
                BaseDialog.useTextInfo(this.txtDialogxButton, PopNotification.this.buttonTextInfo);
                if (PopNotification.this.iconBitmap != null && !PopNotification.this.iconBitmap.isRecycled()) {
                    this.imgDialogxPopIcon.setVisibility(0);
                    this.imgDialogxPopIcon.setImageBitmap(PopNotification.this.iconBitmap);
                } else if (PopNotification.this.iconDrawable != null) {
                    this.imgDialogxPopIcon.setVisibility(0);
                    this.imgDialogxPopIcon.setImageDrawable(PopNotification.this.iconDrawable);
                } else if (PopNotification.this.iconResId != 0) {
                    this.imgDialogxPopIcon.setVisibility(0);
                    this.imgDialogxPopIcon.setImageResource(PopNotification.this.iconResId);
                } else {
                    this.imgDialogxPopIcon.setVisibility(8);
                }
                if (PopNotification.this.tintIcon != BaseDialog.BOOLEAN.TRUE) {
                    this.imgDialogxPopIcon.setImageTintList((ColorStateList) null);
                } else if (PopNotification.this.autoTintIconInLightOrDarkMode) {
                    this.imgDialogxPopIcon.setImageTintList(this.txtDialogxPopTitle.getTextColors());
                } else {
                    this.imgDialogxPopIcon.setImageTintList((ColorStateList) null);
                }
                if (PopNotification.this.iconSize > 0) {
                    ViewGroup.LayoutParams layoutParams = this.imgDialogxPopIcon.getLayoutParams();
                    layoutParams.width = PopNotification.this.iconSize;
                    layoutParams.height = PopNotification.this.iconSize;
                    this.imgDialogxPopIcon.setLayoutParams(layoutParams);
                }
                if (PopNotification.this.slideToClose) {
                    this.boxBody.setOnTouchListener(new View.OnTouchListener() {
                        boolean touchDown;
                        float touchY;

                        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
                            if (r0 != 3) goto L_0x00fc;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
                            /*
                                r6 = this;
                                int r0 = r8.getAction()
                                r1 = 0
                                r2 = 1
                                if (r0 == 0) goto L_0x00f4
                                r3 = 2
                                if (r0 == r2) goto L_0x0055
                                if (r0 == r3) goto L_0x0012
                                r4 = 3
                                if (r0 == r4) goto L_0x0055
                                goto L_0x00fc
                            L_0x0012:
                                boolean r7 = r6.touchDown
                                if (r7 == 0) goto L_0x00fc
                                float r7 = r8.getY()
                                float r8 = r6.touchY
                                float r7 = r7 - r8
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r8 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r8 = r8.boxBody
                                float r8 = r8.getY()
                                float r8 = r8 + r7
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                com.kongzue.dialogx.dialogs.PopNotification r0 = com.kongzue.dialogx.dialogs.PopNotification.this
                                float r0 = r0.defaultTop
                                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                                if (r8 >= 0) goto L_0x0044
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r8 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r8 = r8.boxBody
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r0 = r0.boxBody
                                float r0 = r0.getY()
                                float r0 = r0 + r7
                                r8.setY(r0)
                                goto L_0x00fc
                            L_0x0044:
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r7 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r7 = r7.boxBody
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r8 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                com.kongzue.dialogx.dialogs.PopNotification r8 = com.kongzue.dialogx.dialogs.PopNotification.this
                                float r8 = r8.defaultTop
                                r7.setY(r8)
                                goto L_0x00fc
                            L_0x0055:
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r0 = r0.boxBody
                                float r0 = r0.getY()
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r4 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                com.kongzue.dialogx.dialogs.PopNotification r4 = com.kongzue.dialogx.dialogs.PopNotification.this
                                float r4 = r4.defaultTop
                                int r5 = com.kongzue.dialogx.DialogX.touchSlideTriggerThreshold
                                float r5 = (float) r5
                                float r4 = r4 - r5
                                int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                                if (r0 >= 0) goto L_0x0074
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r8 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                r8.doDismiss(r7)
                                goto L_0x00fc
                            L_0x0074:
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r7 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r7 = r7.boxBody
                                float r7 = r7.getY()
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                com.kongzue.dialogx.dialogs.PopNotification r0 = com.kongzue.dialogx.dialogs.PopNotification.this
                                float r0 = r0.defaultTop
                                float[] r3 = new float[r3]
                                r3[r1] = r7
                                r3[r2] = r0
                                com.kongzue.dialogx.util.PopValueAnimator r7 = com.kongzue.dialogx.util.PopValueAnimator.ofFloat(r3)
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r0 = r0.boxBody
                                r0.setTag(r7)
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl$8$1 r0 = new com.kongzue.dialogx.dialogs.PopNotification$DialogImpl$8$1
                                r0.<init>()
                                r7.addUpdateListener(r0)
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                com.kongzue.dialogx.dialogs.PopNotification r0 = com.kongzue.dialogx.dialogs.PopNotification.this
                                long r2 = r0.enterAnimDuration
                                r4 = -1
                                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                                if (r0 != 0) goto L_0x00ae
                                r2 = 300(0x12c, double:1.48E-321)
                                goto L_0x00b6
                            L_0x00ae:
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                com.kongzue.dialogx.dialogs.PopNotification r0 = com.kongzue.dialogx.dialogs.PopNotification.this
                                long r2 = r0.enterAnimDuration
                            L_0x00b6:
                                android.animation.ValueAnimator r0 = r7.setDuration(r2)
                                android.view.animation.DecelerateInterpolator r2 = new android.view.animation.DecelerateInterpolator
                                r3 = 1073741824(0x40000000, float:2.0)
                                r2.<init>(r3)
                                r0.setInterpolator(r2)
                                r7.start()
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r7 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r7 = r7.boxBody
                                float r7 = r7.getY()
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r0 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                com.kongzue.dialogx.dialogs.PopNotification r0 = com.kongzue.dialogx.dialogs.PopNotification.this
                                float r0 = r0.defaultTop
                                float r7 = r7 - r0
                                float r7 = java.lang.Math.abs(r7)
                                r0 = 1065353216(0x3f800000, float:1.0)
                                int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                                if (r7 > 0) goto L_0x00fc
                                float r7 = r8.getY()
                                float r8 = r6.touchY
                                int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
                                if (r7 > 0) goto L_0x00fc
                                com.kongzue.dialogx.dialogs.PopNotification$DialogImpl r7 = com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.this
                                android.view.ViewGroup r7 = r7.boxBody
                                r7.callOnClick()
                                goto L_0x00fc
                            L_0x00f4:
                                r6.touchDown = r2
                                float r7 = r8.getY()
                                r6.touchY = r7
                            L_0x00fc:
                                return r1
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.dialogs.PopNotification.DialogImpl.AnonymousClass8.onTouch(android.view.View, android.view.MotionEvent):boolean");
                        }
                    });
                } else {
                    this.boxBody.setOnTouchListener((View.OnTouchListener) null);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.boxBody.getLayoutParams();
                if (PopNotification.this.bodyMargin[0] != -1) {
                    layoutParams2.leftMargin = PopNotification.this.bodyMargin[0];
                }
                if (PopNotification.this.bodyMargin[1] != -1) {
                    layoutParams2.topMargin = PopNotification.this.bodyMargin[1];
                }
                if (PopNotification.this.bodyMargin[2] != -1) {
                    layoutParams2.rightMargin = PopNotification.this.bodyMargin[2];
                }
                if (PopNotification.this.bodyMargin[3] != -1) {
                    layoutParams2.bottomMargin = PopNotification.this.bodyMargin[3];
                }
                this.boxBody.setLayoutParams(layoutParams2);
                PopNotification.this.onDialogRefreshUI();
            }
        }

        public void doDismiss(View view) {
            if (view != null) {
                view.setEnabled(false);
            }
            if (!PopNotification.this.dismissAnimFlag && this.boxRoot != null) {
                boolean unused = PopNotification.this.dismissAnimFlag = true;
                this.boxRoot.post(new Runnable() {
                    public void run() {
                        DialogImpl.this.getDialogXAnimImpl().doExitAnim(PopNotification.this.me, DialogImpl.this.boxBody);
                        PopNotification.runOnMainDelay(new Runnable() {
                            public void run() {
                                PopNotification.this.waitForDismiss();
                            }
                        }, DialogImpl.this.getExitAnimationDuration((Animation) null));
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public DialogXAnimInterface<PopNotification> getDialogXAnimImpl() {
            if (PopNotification.this.dialogXAnimImpl == null) {
                PopNotification.this.dialogXAnimImpl = new DialogXAnimInterface<PopNotification>() {
                    public void doShowAnim(PopNotification popNotification, ViewGroup viewGroup) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PopNotification.this.getOwnActivity(), PopNotification.this.enterAnimResId == 0 ? R.anim.anim_dialogx_notification_enter : PopNotification.this.enterAnimResId);
                        long enterAnimationDuration = DialogImpl.this.getEnterAnimationDuration(loadAnimation);
                        loadAnimation.setInterpolator(new DecelerateInterpolator(2.0f));
                        loadAnimation.setDuration(enterAnimationDuration);
                        loadAnimation.setFillAfter(true);
                        DialogImpl.this.boxBody.startAnimation(loadAnimation);
                        DialogImpl.this.boxRoot.animate().setDuration(enterAnimationDuration).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setListener((Animator.AnimatorListener) null);
                    }

                    public void doExitAnim(PopNotification popNotification, ViewGroup viewGroup) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PopNotification.this.getOwnActivity() == null ? DialogImpl.this.boxRoot.getContext() : PopNotification.this.getOwnActivity(), PopNotification.this.exitAnimResId == 0 ? R.anim.anim_dialogx_notification_exit : PopNotification.this.exitAnimResId);
                        long exitAnimationDuration = DialogImpl.this.getExitAnimationDuration(loadAnimation);
                        loadAnimation.setDuration(exitAnimationDuration);
                        loadAnimation.setFillAfter(true);
                        DialogImpl.this.boxBody.startAnimation(loadAnimation);
                        DialogImpl.this.boxRoot.animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(exitAnimationDuration);
                    }
                };
            }
            return PopNotification.this.dialogXAnimImpl;
        }

        public long getExitAnimationDuration(Animation animation) {
            if (animation == null && this.boxBody.getAnimation() != null) {
                animation = this.boxBody.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (PopNotification.overrideExitDuration >= 0) {
                duration = PopNotification.overrideExitDuration;
            }
            return PopNotification.this.exitAnimDuration != -1 ? PopNotification.this.exitAnimDuration : duration;
        }

        public long getEnterAnimationDuration(Animation animation) {
            if (animation == null && this.boxBody.getAnimation() != null) {
                animation = this.boxBody.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (PopNotification.overrideEnterDuration >= 0) {
                duration = PopNotification.overrideEnterDuration;
            }
            return PopNotification.this.enterAnimDuration >= 0 ? PopNotification.this.enterAnimDuration : duration;
        }
    }

    /* renamed from: com.kongzue.dialogx.dialogs.PopNotification$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.kongzue.dialogx.interfaces.DialogXStyle$PopNotificationSettings$ALIGN[] r0 = com.kongzue.dialogx.interfaces.DialogXStyle.PopNotificationSettings.ALIGN.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN = r0
                com.kongzue.dialogx.interfaces.DialogXStyle$PopNotificationSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopNotificationSettings.ALIGN.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopNotificationSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopNotificationSettings.ALIGN.BOTTOM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopNotificationSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopNotificationSettings.ALIGN.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopNotificationSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopNotificationSettings.ALIGN.TOP_INSIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x003e }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopNotificationSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopNotificationSettings.ALIGN.BOTTOM_INSIDE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.dialogs.PopNotification.AnonymousClass6.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void waitForDismiss() {
        this.preRecycle = true;
        List<PopNotification> list = popNotificationList;
        if (list != null) {
            for (PopNotification popNotification : list) {
                if (!popNotification.preRecycle) {
                    return;
                }
            }
            Iterator it = new CopyOnWriteArrayList(popNotificationList).iterator();
            while (it.hasNext()) {
                dismiss(((PopNotification) it.next()).getDialogView());
            }
        }
    }

    /* access modifiers changed from: private */
    public void moveUp(int i) {
        float f;
        float f2;
        if (getDialogImpl() != null && getDialogImpl().boxBody != null) {
            ViewGroup viewGroup = getDialogImpl().boxBody;
            if (getDialogImpl() != null && viewGroup != null) {
                if (this.style.popNotificationSettings() != null) {
                    this.align = this.style.popNotificationSettings().align();
                }
                if (this.align == null) {
                    this.align = DialogXStyle.PopNotificationSettings.ALIGN.TOP;
                }
                float y = viewGroup.getY();
                if (viewGroup.getTag() instanceof PopValueAnimator) {
                    ((PopValueAnimator) viewGroup.getTag()).end();
                    y = ((PopValueAnimator) viewGroup.getTag()).getEndValue();
                }
                int i2 = AnonymousClass6.$SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopNotificationSettings$ALIGN[this.align.ordinal()];
                if (i2 != 1) {
                    if (!(i2 == 2 || i2 == 3)) {
                        if (i2 == 4) {
                            y += (float) i;
                            f2 = (float) viewGroup.getPaddingTop();
                            f = y - f2;
                        } else if (i2 != 5) {
                            f = 0.0f;
                        }
                    }
                    f2 = ((float) i) * 1.1f;
                    f = y - f2;
                } else {
                    f = (((float) i) * 1.1f) + y;
                }
                PopValueAnimator ofFloat = PopValueAnimator.ofFloat(viewGroup.getY(), f);
                viewGroup.setTag(ofFloat);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (PopNotification.this.getDialogImpl() == null || !PopNotification.this.isShow) {
                            valueAnimator.cancel();
                            return;
                        }
                        ViewGroup viewGroup = PopNotification.this.getDialogImpl().boxBody;
                        if (viewGroup != null && viewGroup.isAttachedToWindow()) {
                            viewGroup.setY(PopNotification.this.defaultTop = ((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    }
                });
                ofFloat.setDuration(this.enterAnimDuration == -1 ? 300 : this.enterAnimDuration).setInterpolator(new DecelerateInterpolator(2.0f));
                ofFloat.start();
            }
        }
    }

    public void refreshUI() {
        if (getDialogImpl() != null) {
            runOnMain(new Runnable() {
                public void run() {
                    if (PopNotification.this.dialogImpl != null) {
                        PopNotification.this.dialogImpl.refreshView();
                    }
                }
            });
        }
    }

    public void dismiss() {
        runOnMain(new Runnable() {
            public void run() {
                if (PopNotification.this.dialogImpl != null) {
                    PopNotification.this.dialogImpl.doDismiss((View) null);
                }
            }
        });
    }

    public DialogLifecycleCallback<PopNotification> getDialogLifecycleCallback() {
        DialogLifecycleCallback<PopNotification> dialogLifecycleCallback2 = this.dialogLifecycleCallback;
        return dialogLifecycleCallback2 == null ? new DialogLifecycleCallback<PopNotification>() {
        } : dialogLifecycleCallback2;
    }

    public PopNotification setDialogLifecycleCallback(DialogLifecycleCallback<PopNotification> dialogLifecycleCallback2) {
        this.dialogLifecycleCallback = dialogLifecycleCallback2;
        if (this.isShow) {
            dialogLifecycleCallback2.onShow(this.me);
        }
        return this;
    }

    public PopNotification setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public PopNotification setTheme(DialogX.THEME theme) {
        this.theme = theme;
        return this;
    }

    public DialogImpl getDialogImpl() {
        return this.dialogImpl;
    }

    public PopNotification setCustomView(OnBindView<PopNotification> onBindView2) {
        this.onBindView = onBindView2;
        refreshUI();
        return this;
    }

    public View getCustomView() {
        OnBindView<PopNotification> onBindView2 = this.onBindView;
        if (onBindView2 == null) {
            return null;
        }
        return onBindView2.getCustomView();
    }

    public PopNotification removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public DialogXStyle.PopNotificationSettings.ALIGN getAlign() {
        return this.align;
    }

    public PopNotification setAlign(DialogXStyle.PopNotificationSettings.ALIGN align2) {
        this.align = align2;
        return this;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public PopNotification setIconResId(int i) {
        this.iconResId = i;
        refreshUI();
        return this;
    }

    public PopNotification setIcon(Bitmap bitmap) {
        this.iconBitmap = bitmap;
        refreshUI();
        return this;
    }

    public PopNotification setIcon(Drawable drawable) {
        this.iconDrawable = drawable;
        return this;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public PopNotification setIconSize(int i) {
        this.iconSize = i;
        refreshUI();
        return this;
    }

    public CharSequence getMessage() {
        return this.message;
    }

    public PopNotification setMessage(CharSequence charSequence) {
        this.message = charSequence;
        refreshUI();
        return this;
    }

    public PopNotification setMessage(int i) {
        this.message = getString(i);
        refreshUI();
        return this;
    }

    public CharSequence getButtonText() {
        return this.buttonText;
    }

    public PopNotification setButton(CharSequence charSequence) {
        this.buttonText = charSequence;
        refreshUI();
        return this;
    }

    public PopNotification setButton(int i) {
        this.buttonText = getString(i);
        refreshUI();
        return this;
    }

    public PopNotification setButton(CharSequence charSequence, OnDialogButtonClickListener<PopNotification> onDialogButtonClickListener) {
        this.buttonText = charSequence;
        this.onButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public PopNotification setButton(int i, OnDialogButtonClickListener<PopNotification> onDialogButtonClickListener) {
        this.buttonText = getString(i);
        this.onButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public PopNotification setButton(OnDialogButtonClickListener<PopNotification> onDialogButtonClickListener) {
        this.onButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    public TextInfo getMessageTextInfo() {
        return this.messageTextInfo;
    }

    public PopNotification setMessageTextInfo(TextInfo textInfo) {
        this.messageTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public TextInfo getButtonTextInfo() {
        return this.buttonTextInfo;
    }

    public PopNotification setButtonTextInfo(TextInfo textInfo) {
        this.buttonTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public OnDialogButtonClickListener<PopNotification> getOnButtonClickListener() {
        return this.onButtonClickListener;
    }

    public PopNotification setOnButtonClickListener(OnDialogButtonClickListener<PopNotification> onDialogButtonClickListener) {
        this.onButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    public boolean isAutoTintIconInLightOrDarkMode() {
        return this.autoTintIconInLightOrDarkMode;
    }

    public PopNotification setAutoTintIconInLightOrDarkMode(boolean z) {
        this.autoTintIconInLightOrDarkMode = z;
        refreshUI();
        return this;
    }

    public OnDialogButtonClickListener<PopNotification> getOnPopNotificationClickListener() {
        return this.onPopNotificationClickListener;
    }

    public PopNotification setOnPopNotificationClickListener(OnDialogButtonClickListener<PopNotification> onDialogButtonClickListener) {
        this.onPopNotificationClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public int getBackgroundColor() {
        return this.backgroundColor.intValue();
    }

    public PopNotification setBackgroundColor(int i) {
        this.backgroundColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public PopNotification setBackgroundColorRes(int i) {
        this.backgroundColor = Integer.valueOf(getColor(i));
        refreshUI();
        return this;
    }

    public long getEnterAnimDuration() {
        return this.enterAnimDuration;
    }

    public PopNotification setEnterAnimDuration(long j) {
        this.enterAnimDuration = j;
        return this;
    }

    public long getExitAnimDuration() {
        return this.exitAnimDuration;
    }

    public PopNotification setExitAnimDuration(long j) {
        this.exitAnimDuration = j;
        return this;
    }

    public void restartDialog() {
        long j;
        long j2;
        PopNotification popNotification;
        if (getDialogView() != null) {
            dismiss(getDialogView());
            this.isShow = false;
        }
        if (getDialogImpl().boxCustom != null) {
            getDialogImpl().boxCustom.removeAllViews();
        }
        if (DialogX.onlyOnePopNotification) {
            List<PopNotification> list = popNotificationList;
            if (list == null || list.isEmpty()) {
                popNotification = null;
            } else {
                List<PopNotification> list2 = popNotificationList;
                popNotification = list2.get(list2.size() - 1);
            }
            if (popNotification != null) {
                popNotification.dismiss();
            }
        }
        if (popNotificationList == null) {
            popNotificationList = new ArrayList();
        }
        popNotificationList.add(this);
        int i = isLightTheme() ? R.layout.layout_dialogx_popnotification_material : R.layout.layout_dialogx_popnotification_material_dark;
        if (this.style.popNotificationSettings() != null) {
            if (this.style.popNotificationSettings().layout(isLightTheme()) != 0) {
                i = this.style.popNotificationSettings().layout(isLightTheme());
            }
            DialogXStyle.PopNotificationSettings.ALIGN align2 = this.style.popNotificationSettings().align();
            this.align = align2;
            if (align2 == null) {
                this.align = DialogXStyle.PopNotificationSettings.ALIGN.TOP;
            }
            int enterAnimResId2 = this.style.popNotificationSettings().enterAnimResId(isLightTheme());
            int exitAnimResId2 = this.style.popNotificationSettings().exitAnimResId(isLightTheme());
            int i2 = this.enterAnimResId;
            if (i2 != 0 || (i2 = overrideEnterAnimRes) != 0) {
                enterAnimResId2 = i2;
            } else if (enterAnimResId2 == 0) {
                enterAnimResId2 = R.anim.anim_dialogx_notification_enter;
            }
            this.enterAnimResId = enterAnimResId2;
            int i3 = this.exitAnimResId;
            if (i3 != 0 || (i3 = overrideExitAnimRes) != 0) {
                exitAnimResId2 = i3;
            } else if (exitAnimResId2 == 0) {
                exitAnimResId2 = R.anim.anim_dialogx_notification_exit;
            }
            this.exitAnimResId = exitAnimResId2;
            if (this.enterAnimDuration == -1) {
                j = overrideEnterDuration;
            } else {
                j = this.enterAnimDuration;
            }
            this.enterAnimDuration = j;
            if (this.exitAnimDuration == -1) {
                j2 = overrideExitDuration;
            } else {
                j2 = this.exitAnimDuration;
            }
            this.exitAnimDuration = j2;
        }
        this.enterAnimDuration = 0;
        View createView = createView(i);
        this.dialogImpl = new DialogImpl(createView);
        if (createView != null) {
            createView.setTag(this.me);
        }
        show(createView);
    }

    public void hide() {
        this.isHide = true;
        if (getDialogView() != null) {
            getDialogView().setVisibility(8);
        }
    }

    public PopNotification setAnimResId(int i, int i2) {
        this.enterAnimResId = i;
        this.exitAnimResId = i2;
        return this;
    }

    public PopNotification setEnterAnimResId(int i) {
        this.enterAnimResId = i;
        return this;
    }

    public PopNotification setExitAnimResId(int i) {
        this.exitAnimResId = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        dismiss();
    }

    public PopNotification setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public PopNotification setMargin(int i, int i2, int i3, int i4) {
        int[] iArr = this.bodyMargin;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        refreshUI();
        return this;
    }

    public PopNotification setMarginLeft(int i) {
        this.bodyMargin[0] = i;
        refreshUI();
        return this;
    }

    public PopNotification setMarginTop(int i) {
        this.bodyMargin[1] = i;
        refreshUI();
        return this;
    }

    public PopNotification setMarginRight(int i) {
        this.bodyMargin[2] = i;
        refreshUI();
        return this;
    }

    public PopNotification setMarginBottom(int i) {
        this.bodyMargin[3] = i;
        refreshUI();
        return this;
    }

    public int getMarginLeft() {
        return this.bodyMargin[0];
    }

    public int getMarginTop() {
        return this.bodyMargin[1];
    }

    public int getMarginRight() {
        return this.bodyMargin[2];
    }

    public int getMarginBottom() {
        return this.bodyMargin[3];
    }

    public PopNotification iconSuccess() {
        setTintIcon(false);
        int i = R.mipmap.ico_dialogx_success;
        if (!(getStyle().popNotificationSettings() == null || getStyle().popNotificationSettings().defaultIconSuccess() == 0)) {
            i = getStyle().popNotificationSettings().defaultIconSuccess();
        }
        setIconSize(dip2px(26.0f));
        setIconResId(i);
        return this;
    }

    public PopNotification iconWarning() {
        setTintIcon(false);
        int i = R.mipmap.ico_dialogx_warning;
        if (!(getStyle().popNotificationSettings() == null || getStyle().popNotificationSettings().defaultIconWarning() == 0)) {
            i = getStyle().popNotificationSettings().defaultIconWarning();
        }
        setIconSize(dip2px(26.0f));
        setIconResId(i);
        return this;
    }

    public PopNotification iconError() {
        setTintIcon(false);
        int i = R.mipmap.ico_dialogx_error;
        if (!(getStyle().popNotificationSettings() == null || getStyle().popNotificationSettings().defaultIconError() == 0)) {
            i = getStyle().popNotificationSettings().defaultIconError();
        }
        setIconSize(dip2px(26.0f));
        setIconResId(i);
        return this;
    }

    public boolean getTintIcon() {
        return this.tintIcon == BaseDialog.BOOLEAN.TRUE;
    }

    public PopNotification setTintIcon(boolean z) {
        this.tintIcon = z ? BaseDialog.BOOLEAN.TRUE : BaseDialog.BOOLEAN.FALSE;
        refreshUI();
        return this;
    }

    public Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public Bitmap getIconBitmap() {
        return this.iconBitmap;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public PopNotification setTitle(CharSequence charSequence) {
        this.title = charSequence;
        refreshUI();
        return this;
    }

    public TextInfo getTitleTextInfo() {
        return this.titleTextInfo;
    }

    public PopNotification setTitleTextInfo(TextInfo textInfo) {
        this.titleTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public PopNotification setRadius(float f) {
        this.backgroundRadius = f;
        refreshUI();
        return this;
    }

    public float getRadius() {
        return this.backgroundRadius;
    }

    public DialogXAnimInterface<PopNotification> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public PopNotification setDialogXAnimImpl(DialogXAnimInterface<PopNotification> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public PopNotification setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public PopNotification setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public boolean isSlideToClose() {
        return this.slideToClose;
    }

    public PopNotification setSlideToClose(boolean z) {
        this.slideToClose = z;
        refreshUI();
        return this;
    }
}
