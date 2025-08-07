package com.kongzue.dialogx.dialogs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.kongzue.dialogx.util.TextInfo;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.microtech.aidexx.ui.pair.PairUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;

public class PopTip extends BaseDialog implements NoTouchInterface {
    public static final int TIME_NO_AUTO_DISMISS_DELAY = -1;
    public static int overrideEnterAnimRes = 0;
    public static long overrideEnterDuration = -1;
    public static int overrideExitAnimRes = 0;
    public static long overrideExitDuration = -1;
    protected static List<PopTip> popTipList;
    protected DialogXStyle.PopTipSettings.ALIGN align;
    protected long autoDismissDelay;
    protected Timer autoDismissTimer;
    protected float backgroundRadius = -1.0f;
    protected int[] bodyMargin = {-1, -1, -1, -1};
    protected CharSequence buttonText;
    protected TextInfo buttonTextInfo = new TextInfo().setBold(true);
    protected DialogImpl dialogImpl;
    protected DialogLifecycleCallback<PopTip> dialogLifecycleCallback;
    protected DialogXAnimInterface<PopTip> dialogXAnimImpl;
    protected int enterAnimResId = 0;
    protected int exitAnimResId = 0;
    protected int iconResId;
    private boolean isHide;
    protected PopTip me = this;
    protected CharSequence message;
    protected TextInfo messageTextInfo;
    protected OnBindView<PopTip> onBindView;
    protected OnDialogButtonClickListener<PopTip> onButtonClickListener;
    protected OnDialogButtonClickListener<PopTip> onPopTipClickListener;
    protected boolean preRecycle = false;
    protected BaseDialog.BOOLEAN tintIcon;

    public boolean isCancelable() {
        return false;
    }

    public void onDismiss(PopTip popTip) {
    }

    public void onShow(PopTip popTip) {
    }

    protected PopTip() {
    }

    public static PopTip build() {
        return new PopTip();
    }

    public static PopTip build(DialogXStyle dialogXStyle) {
        return new PopTip().setStyle(dialogXStyle);
    }

    public static PopTip build(OnBindView<PopTip> onBindView2) {
        return new PopTip().setCustomView(onBindView2);
    }

    public PopTip(OnBindView<PopTip> onBindView2) {
        this.onBindView = onBindView2;
    }

    public PopTip(CharSequence charSequence) {
        this.message = charSequence;
    }

    public PopTip(int i) {
        this.message = getString(i);
    }

    public static PopTip tip(String str) {
        return show((CharSequence) str);
    }

    public static PopTip tip(int i) {
        return show(i);
    }

    public static PopTip tip(String str, String str2) {
        return show((CharSequence) str, (CharSequence) str2);
    }

    public static PopTip tip(int i, int i2) {
        return show(i, i2);
    }

    public static PopTip tip(int i, String str) {
        return show(i, (CharSequence) str);
    }

    public static PopTip tip(int i, String str, String str2) {
        return show(i, (CharSequence) str, (CharSequence) str2);
    }

    public PopTip(int i, CharSequence charSequence) {
        this.iconResId = i;
        this.message = charSequence;
    }

    public PopTip(int i, CharSequence charSequence, CharSequence charSequence2) {
        this.iconResId = i;
        this.message = charSequence;
        this.buttonText = charSequence2;
    }

    public PopTip(int i, int i2, int i3) {
        this.iconResId = i;
        this.message = getString(i2);
        this.buttonText = getString(i3);
    }

    public PopTip(CharSequence charSequence, CharSequence charSequence2) {
        this.message = charSequence;
        this.buttonText = charSequence2;
    }

    public PopTip(int i, int i2) {
        this.message = getString(i);
        this.buttonText = getString(i2);
    }

    public PopTip(CharSequence charSequence, OnBindView<PopTip> onBindView2) {
        this.message = charSequence;
        this.onBindView = onBindView2;
    }

    public PopTip(int i, OnBindView<PopTip> onBindView2) {
        this.message = getString(i);
        this.onBindView = onBindView2;
    }

    public PopTip(int i, CharSequence charSequence, OnBindView<PopTip> onBindView2) {
        this.iconResId = i;
        this.message = charSequence;
        this.onBindView = onBindView2;
    }

    public PopTip(int i, CharSequence charSequence, CharSequence charSequence2, OnBindView<PopTip> onBindView2) {
        this.iconResId = i;
        this.message = charSequence;
        this.buttonText = charSequence2;
        this.onBindView = onBindView2;
    }

    public PopTip(int i, int i2, int i3, OnBindView<PopTip> onBindView2) {
        this.iconResId = i;
        this.message = getString(i2);
        this.buttonText = getString(i3);
        this.onBindView = onBindView2;
    }

    public PopTip(CharSequence charSequence, CharSequence charSequence2, OnBindView<PopTip> onBindView2) {
        this.message = charSequence;
        this.buttonText = charSequence2;
        this.onBindView = onBindView2;
    }

    public PopTip(int i, int i2, OnBindView<PopTip> onBindView2) {
        this.message = getString(i);
        this.buttonText = getString(i2);
        this.onBindView = onBindView2;
    }

    public static PopTip show(OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(onBindView2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(CharSequence charSequence) {
        PopTip popTip = new PopTip(charSequence);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i) {
        PopTip popTip = new PopTip(i);
        popTip.show();
        return popTip;
    }

    public static PopTip show(CharSequence charSequence, OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(charSequence, onBindView2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(i, onBindView2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(CharSequence charSequence, CharSequence charSequence2) {
        PopTip popTip = new PopTip(charSequence, charSequence2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, int i2) {
        PopTip popTip = new PopTip(i, i2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, CharSequence charSequence, OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(i, charSequence, onBindView2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, CharSequence charSequence) {
        PopTip popTip = new PopTip(i, charSequence);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, CharSequence charSequence, CharSequence charSequence2) {
        PopTip popTip = new PopTip(i, charSequence, charSequence2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, CharSequence charSequence, CharSequence charSequence2, OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(i, charSequence, charSequence2, onBindView2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, int i2, int i3, OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(i, i2, i3, onBindView2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(CharSequence charSequence, CharSequence charSequence2, OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(charSequence, charSequence2, onBindView2);
        popTip.show();
        return popTip;
    }

    public static PopTip show(int i, int i2, OnBindView<PopTip> onBindView2) {
        PopTip popTip = new PopTip(i, i2, onBindView2);
        popTip.show();
        return popTip;
    }

    public PopTip show() {
        long j;
        long j2;
        PopTip popTip;
        if (!this.isHide || getDialogView() == null) {
            super.beforeShow();
            if (getDialogView() == null) {
                if (DialogX.onlyOnePopTip) {
                    List<PopTip> list = popTipList;
                    if (list == null || list.isEmpty()) {
                        popTip = null;
                    } else {
                        List<PopTip> list2 = popTipList;
                        popTip = list2.get(list2.size() - 1);
                    }
                    if (popTip != null) {
                        popTip.dismiss();
                    }
                } else if (popTipList != null) {
                    for (int i = 0; i < popTipList.size(); i++) {
                        popTipList.get(i).moveUp();
                    }
                }
                if (popTipList == null) {
                    popTipList = new ArrayList();
                }
                popTipList.add(this);
                int i2 = isLightTheme() ? R.layout.layout_dialogx_poptip_material : R.layout.layout_dialogx_poptip_material_dark;
                if (this.style.popTipSettings() != null) {
                    if (this.style.popTipSettings().layout(isLightTheme()) != 0) {
                        i2 = this.style.popTipSettings().layout(isLightTheme());
                    }
                    if (this.align == null) {
                        if (this.style.popTipSettings().align() == null) {
                            this.align = DialogXStyle.PopTipSettings.ALIGN.BOTTOM;
                        } else {
                            this.align = this.style.popTipSettings().align();
                        }
                    }
                    int enterAnimResId2 = this.style.popTipSettings().enterAnimResId(isLightTheme());
                    int exitAnimResId2 = this.style.popTipSettings().exitAnimResId(isLightTheme());
                    int i3 = this.enterAnimResId;
                    if (i3 != 0 || (i3 = overrideEnterAnimRes) != 0) {
                        enterAnimResId2 = i3;
                    } else if (enterAnimResId2 == 0) {
                        enterAnimResId2 = R.anim.anim_dialogx_default_enter;
                    }
                    this.enterAnimResId = enterAnimResId2;
                    int i4 = this.exitAnimResId;
                    if (i4 != 0 || (i4 = overrideExitAnimRes) != 0) {
                        exitAnimResId2 = i4;
                    } else if (exitAnimResId2 == 0) {
                        exitAnimResId2 = R.anim.anim_dialogx_default_exit;
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
                View createView = createView(i2);
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

    public PopTip show(Activity activity) {
        long j;
        long j2;
        PopTip popTip;
        super.beforeShow();
        if (getDialogView() != null) {
            if (DialogX.onlyOnePopTip) {
                List<PopTip> list = popTipList;
                if (list == null || list.isEmpty()) {
                    popTip = null;
                } else {
                    List<PopTip> list2 = popTipList;
                    popTip = list2.get(list2.size() - 1);
                }
                if (popTip != null) {
                    popTip.dismiss();
                }
            } else if (popTipList != null) {
                for (int i = 0; i < popTipList.size(); i++) {
                    popTipList.get(i).moveUp();
                }
            }
            if (popTipList == null) {
                popTipList = new ArrayList();
            }
            popTipList.add(this);
            int i2 = isLightTheme() ? R.layout.layout_dialogx_poptip_material : R.layout.layout_dialogx_poptip_material_dark;
            if (this.style.popTipSettings() != null) {
                if (this.style.popTipSettings().layout(isLightTheme()) != 0) {
                    i2 = this.style.popTipSettings().layout(isLightTheme());
                }
                if (this.align == null) {
                    if (this.style.popTipSettings().align() == null) {
                        this.align = DialogXStyle.PopTipSettings.ALIGN.BOTTOM;
                    } else {
                        this.align = this.style.popTipSettings().align();
                    }
                }
                int enterAnimResId2 = this.style.popTipSettings().enterAnimResId(isLightTheme());
                int exitAnimResId2 = this.style.popTipSettings().exitAnimResId(isLightTheme());
                int i3 = this.enterAnimResId;
                if (i3 != 0 || (i3 = overrideEnterAnimRes) != 0) {
                    enterAnimResId2 = i3;
                } else if (enterAnimResId2 == 0) {
                    enterAnimResId2 = R.anim.anim_dialogx_default_enter;
                }
                this.enterAnimResId = enterAnimResId2;
                int i4 = this.exitAnimResId;
                if (i4 != 0 || (i4 = overrideExitAnimRes) != 0) {
                    exitAnimResId2 = i4;
                } else if (exitAnimResId2 == 0) {
                    exitAnimResId2 = R.anim.anim_dialogx_default_exit;
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
            View createView = createView(i2);
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

    public PopTip autoDismiss(long j) {
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
                PopTip.this.dismiss();
            }
        }, j);
        return this;
    }

    public void resetAutoDismissTimer() {
        autoDismiss(this.autoDismissDelay);
    }

    public PopTip showShort() {
        autoDismiss(PairUtilKt.DELAY_A_WHILE);
        if (!this.preShow && !this.isShow) {
            show();
        }
        return this;
    }

    public PopTip showLong() {
        autoDismiss(3500);
        if (!this.preShow && !this.isShow) {
            show();
        }
        return this;
    }

    public PopTip showAlways() {
        return noAutoDismiss();
    }

    public PopTip noAutoDismiss() {
        autoDismiss(-1);
        return this;
    }

    public class DialogImpl implements DialogConvertViewInterface {
        private List<View> blurViews;
        public LinearLayout boxBody;
        public RelativeLayout boxCustom;
        public DialogXBaseRelativeLayout boxRoot;
        public ImageView imgDialogxPopIcon;
        public TextView txtDialogxButton;
        public TextView txtDialogxPopText;

        public DialogImpl(View view) {
            if (view != null) {
                PopTip.this.setDialogView(view);
                this.boxRoot = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
                this.boxBody = (LinearLayout) view.findViewById(R.id.box_body);
                this.imgDialogxPopIcon = (ImageView) view.findViewById(R.id.img_dialogx_pop_icon);
                this.txtDialogxPopText = (TextView) view.findViewById(R.id.txt_dialogx_pop_text);
                this.boxCustom = (RelativeLayout) view.findViewById(R.id.box_custom);
                this.txtDialogxButton = (TextView) view.findViewById(R.id.txt_dialogx_button);
                this.blurViews = PopTip.this.findAllBlurView(view);
                init();
                PopTip.this.dialogImpl = this;
                refreshView();
            }
        }

        public void init() {
            if (PopTip.this.messageTextInfo == null) {
                PopTip.this.messageTextInfo = DialogX.popTextInfo;
            }
            if (PopTip.this.buttonTextInfo == null) {
                PopTip.this.buttonTextInfo = DialogX.buttonTextInfo;
            }
            if (PopTip.this.backgroundColor == null) {
                Integer unused = PopTip.this.backgroundColor = DialogX.backgroundColor;
            }
            if (PopTip.this.autoDismissTimer == null) {
                PopTip.this.showShort();
            }
            this.boxRoot.setParentDialog(PopTip.this.me);
            this.boxRoot.setAutoUnsafePlacePadding(true);
            this.boxRoot.setOnLifecycleCallBack(new DialogXBaseRelativeLayout.OnLifecycleCallBack() {
                public void onShow() {
                    boolean unused = PopTip.this.isShow = true;
                    boolean unused2 = PopTip.this.preShow = false;
                    PopTip.this.setLifecycleState(Lifecycle.State.CREATED);
                    DialogImpl.this.boxRoot.setAlpha(0.0f);
                    PopTip.this.onDialogShow();
                    PopTip.this.getDialogLifecycleCallback().onShow(PopTip.this.me);
                    PopTip.this.onShow(PopTip.this.me);
                }

                public void onDismiss() {
                    if (PopTip.popTipList != null) {
                        PopTip.popTipList.remove(PopTip.this);
                        if (PopTip.popTipList.isEmpty()) {
                            PopTip.popTipList = null;
                        }
                    }
                    boolean unused = PopTip.this.isShow = false;
                    if (PopTip.this.autoDismissTimer != null) {
                        PopTip.this.autoDismissTimer.cancel();
                    }
                    PopTip.this.getDialogLifecycleCallback().onDismiss(PopTip.this.me);
                    PopTip.this.onDismiss(PopTip.this.me);
                    PopTip.this.dialogImpl = null;
                    PopTip.this.setLifecycleState(Lifecycle.State.DESTROYED);
                    System.gc();
                }
            });
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.boxBody.getLayoutParams();
            if (PopTip.this.align == null) {
                PopTip.this.align = DialogXStyle.PopTipSettings.ALIGN.BOTTOM;
            }
            int i = AnonymousClass6.$SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN[PopTip.this.align.ordinal()];
            if (i == 1) {
                layoutParams.removeRule(13);
                layoutParams.addRule(10);
            } else if (i == 2) {
                layoutParams.removeRule(13);
                layoutParams.addRule(12);
            } else if (i == 3) {
                layoutParams.removeRule(10);
                layoutParams.removeRule(12);
                layoutParams.addRule(13);
            }
            this.boxBody.setLayoutParams(layoutParams);
            this.boxRoot.setOnSafeInsetsChangeListener(new OnSafeInsetsChangeListener() {
                public void onChange(Rect rect) {
                    if (PopTip.this.align == DialogXStyle.PopTipSettings.ALIGN.TOP_INSIDE) {
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
                    DialogImpl.this.getDialogXAnimImpl().doShowAnim(PopTip.this.me, DialogImpl.this.boxBody);
                    PopTip.this.setLifecycleState(Lifecycle.State.RESUMED);
                }
            });
            this.txtDialogxButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (PopTip.this.onButtonClickListener == null) {
                        DialogImpl.this.doDismiss(view);
                    } else if (!PopTip.this.onButtonClickListener.onClick(PopTip.this.me, view)) {
                        DialogImpl.this.doDismiss(view);
                    }
                }
            });
            PopTip.this.onDialogInit();
        }

        public void refreshView() {
            if (this.boxRoot != null && PopTip.this.getOwnActivity() != null) {
                this.boxRoot.setRootPadding(PopTip.this.screenPaddings[0], PopTip.this.screenPaddings[1], PopTip.this.screenPaddings[2], PopTip.this.screenPaddings[3]);
                if (PopTip.this.backgroundColor != null) {
                    PopTip popTip = PopTip.this;
                    popTip.tintColor(this.boxBody, popTip.backgroundColor.intValue());
                    List<View> list = this.blurViews;
                    if (list != null) {
                        Iterator<View> it = list.iterator();
                        while (it.hasNext()) {
                            ((BlurViewType) it.next()).setOverlayColor(PopTip.this.backgroundColor);
                        }
                    }
                }
                if (PopTip.this.onBindView == null || PopTip.this.onBindView.getCustomView() == null) {
                    this.boxCustom.setVisibility(8);
                } else {
                    PopTip.this.onBindView.bindParent(this.boxCustom, PopTip.this.me);
                    this.boxCustom.setVisibility(0);
                }
                PopTip popTip2 = PopTip.this;
                popTip2.showText(this.txtDialogxPopText, popTip2.message);
                PopTip popTip3 = PopTip.this;
                popTip3.showText(this.txtDialogxButton, popTip3.buttonText);
                BaseDialog.useTextInfo(this.txtDialogxPopText, PopTip.this.messageTextInfo);
                BaseDialog.useTextInfo(this.txtDialogxButton, PopTip.this.buttonTextInfo);
                if (PopTip.this.iconResId != 0) {
                    this.imgDialogxPopIcon.setVisibility(0);
                    this.imgDialogxPopIcon.setImageResource(PopTip.this.iconResId);
                    if (PopTip.this.isTintIcon()) {
                        this.imgDialogxPopIcon.setImageTintList(this.txtDialogxPopText.getTextColors());
                    } else {
                        this.imgDialogxPopIcon.setImageTintList((ColorStateList) null);
                    }
                } else {
                    this.imgDialogxPopIcon.setVisibility(8);
                }
                if (PopTip.this.backgroundRadius > -1.0f) {
                    GradientDrawable gradientDrawable = (GradientDrawable) this.boxBody.getBackground();
                    if (gradientDrawable != null) {
                        gradientDrawable.setCornerRadius(PopTip.this.backgroundRadius);
                    }
                    this.boxBody.setOutlineProvider(new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), PopTip.this.backgroundRadius);
                        }
                    });
                    this.boxBody.setClipToOutline(true);
                    List<View> list2 = this.blurViews;
                    if (list2 != null) {
                        Iterator<View> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            ((BlurViewType) it2.next()).setRadiusPx(Float.valueOf(PopTip.this.backgroundRadius));
                        }
                    }
                }
                if (PopTip.this.onPopTipClickListener != null) {
                    this.boxBody.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (!PopTip.this.onPopTipClickListener.onClick(PopTip.this.me, view)) {
                                PopTip.this.dismiss();
                            }
                        }
                    });
                } else {
                    this.boxBody.setOnClickListener((View.OnClickListener) null);
                    this.boxBody.setClickable(false);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.boxBody.getLayoutParams();
                if (PopTip.this.bodyMargin[0] != -1) {
                    layoutParams.leftMargin = PopTip.this.bodyMargin[0];
                }
                if (PopTip.this.bodyMargin[1] != -1) {
                    layoutParams.topMargin = PopTip.this.bodyMargin[1];
                }
                if (PopTip.this.bodyMargin[2] != -1) {
                    layoutParams.rightMargin = PopTip.this.bodyMargin[2];
                }
                if (PopTip.this.bodyMargin[3] != -1) {
                    layoutParams.bottomMargin = PopTip.this.bodyMargin[3];
                }
                this.boxBody.setLayoutParams(layoutParams);
                PopTip.this.onDialogRefreshUI();
            }
        }

        public void doDismiss(View view) {
            if (view != null) {
                view.setEnabled(false);
            }
            if (!PopTip.this.dismissAnimFlag && this.boxRoot != null) {
                boolean unused = PopTip.this.dismissAnimFlag = true;
                this.boxRoot.post(new Runnable() {
                    public void run() {
                        DialogImpl.this.getDialogXAnimImpl().doExitAnim(PopTip.this.me, DialogImpl.this.boxBody);
                        PopTip.runOnMainDelay(new Runnable() {
                            public void run() {
                                PopTip.this.waitForDismiss();
                            }
                        }, DialogImpl.this.getExitAnimationDuration((Animation) null));
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public DialogXAnimInterface<PopTip> getDialogXAnimImpl() {
            if (PopTip.this.dialogXAnimImpl == null) {
                PopTip.this.dialogXAnimImpl = new DialogXAnimInterface<PopTip>() {
                    public void doShowAnim(PopTip popTip, ViewGroup viewGroup) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PopTip.this.getOwnActivity(), PopTip.this.enterAnimResId == 0 ? R.anim.anim_dialogx_default_enter : PopTip.this.enterAnimResId);
                        long enterAnimationDuration = DialogImpl.this.getEnterAnimationDuration(loadAnimation);
                        loadAnimation.setInterpolator(new DecelerateInterpolator(2.0f));
                        loadAnimation.setDuration(enterAnimationDuration);
                        loadAnimation.setFillAfter(true);
                        DialogImpl.this.boxBody.startAnimation(loadAnimation);
                        DialogImpl.this.boxRoot.animate().setDuration(enterAnimationDuration).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setListener((Animator.AnimatorListener) null);
                    }

                    public void doExitAnim(PopTip popTip, ViewGroup viewGroup) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PopTip.this.getOwnActivity() == null ? DialogImpl.this.boxRoot.getContext() : PopTip.this.getOwnActivity(), PopTip.this.exitAnimResId == 0 ? R.anim.anim_dialogx_default_exit : PopTip.this.exitAnimResId);
                        long exitAnimationDuration = DialogImpl.this.getExitAnimationDuration(loadAnimation);
                        loadAnimation.setDuration(exitAnimationDuration);
                        loadAnimation.setFillAfter(true);
                        DialogImpl.this.boxBody.startAnimation(loadAnimation);
                        DialogImpl.this.boxRoot.animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(exitAnimationDuration);
                    }
                };
            }
            return PopTip.this.dialogXAnimImpl;
        }

        public long getExitAnimationDuration(Animation animation) {
            if (animation == null && this.boxBody.getAnimation() != null) {
                animation = this.boxBody.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (PopTip.overrideExitDuration >= 0) {
                duration = PopTip.overrideExitDuration;
            }
            return PopTip.this.exitAnimDuration != -1 ? PopTip.this.exitAnimDuration : duration;
        }

        public long getEnterAnimationDuration(Animation animation) {
            if (animation == null && this.boxBody.getAnimation() != null) {
                animation = this.boxBody.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 300 : animation.getDuration();
            if (PopTip.overrideEnterDuration >= 0) {
                duration = PopTip.overrideEnterDuration;
            }
            return PopTip.this.enterAnimDuration >= 0 ? PopTip.this.enterAnimDuration : duration;
        }
    }

    /* renamed from: com.kongzue.dialogx.dialogs.PopTip$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN;

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
                com.kongzue.dialogx.interfaces.DialogXStyle$PopTipSettings$ALIGN[] r0 = com.kongzue.dialogx.interfaces.DialogXStyle.PopTipSettings.ALIGN.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN = r0
                com.kongzue.dialogx.interfaces.DialogXStyle$PopTipSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopTipSettings.ALIGN.TOP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopTipSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopTipSettings.ALIGN.BOTTOM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopTipSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopTipSettings.ALIGN.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopTipSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopTipSettings.ALIGN.TOP_INSIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN     // Catch:{ NoSuchFieldError -> 0x003e }
                com.kongzue.dialogx.interfaces.DialogXStyle$PopTipSettings$ALIGN r1 = com.kongzue.dialogx.interfaces.DialogXStyle.PopTipSettings.ALIGN.BOTTOM_INSIDE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.dialogs.PopTip.AnonymousClass6.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void waitForDismiss() {
        this.preRecycle = true;
        if (popTipList != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(popTipList);
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (!((PopTip) it.next()).preRecycle) {
                    return;
                }
            }
            Iterator it2 = copyOnWriteArrayList.iterator();
            while (it2.hasNext()) {
                dismiss(((PopTip) it2.next()).getDialogView());
            }
        }
    }

    private void moveUp() {
        if (getDialogImpl() != null && getDialogImpl().boxBody != null && getDialogImpl() != null && getDialogImpl().boxBody != null) {
            final LinearLayout linearLayout = getDialogImpl().boxBody;
            linearLayout.post(new Runnable() {
                public void run() {
                    float f;
                    if (PopTip.this.getDialogImpl() != null) {
                        if (PopTip.this.style.popTipSettings() != null) {
                            PopTip popTip = PopTip.this;
                            popTip.align = popTip.style.popTipSettings().align();
                        }
                        if (PopTip.this.align == null) {
                            PopTip.this.align = DialogXStyle.PopTipSettings.ALIGN.TOP;
                        }
                        int i = AnonymousClass6.$SwitchMap$com$kongzue$dialogx$interfaces$DialogXStyle$PopTipSettings$ALIGN[PopTip.this.align.ordinal()];
                        if (i != 1) {
                            if (!(i == 2 || i == 3)) {
                                if (i == 4) {
                                    f = (linearLayout.getY() + ((float) linearLayout.getHeight())) - ((float) linearLayout.getPaddingTop());
                                } else if (i != 5) {
                                    f = 0.0f;
                                }
                            }
                            f = linearLayout.getY() - (((float) linearLayout.getHeight()) * 1.3f);
                        } else {
                            f = linearLayout.getY() + (((float) linearLayout.getHeight()) * 1.3f);
                        }
                        if (linearLayout.getTag() instanceof ValueAnimator) {
                            ((ValueAnimator) linearLayout.getTag()).end();
                        }
                        PopTip.log("#Animation from:" + linearLayout.getY() + " to:" + f);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{linearLayout.getY(), f});
                        linearLayout.setTag(ofFloat);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (PopTip.this.getDialogImpl() == null || !PopTip.this.isShow) {
                                    valueAnimator.cancel();
                                    return;
                                }
                                LinearLayout linearLayout = PopTip.this.getDialogImpl().boxBody;
                                if (linearLayout != null && linearLayout.isAttachedToWindow()) {
                                    linearLayout.setY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            }
                        });
                        ofFloat.setDuration(PopTip.this.enterAnimDuration == -1 ? 300 : PopTip.this.enterAnimDuration).setInterpolator(new DecelerateInterpolator(2.0f));
                        ofFloat.start();
                    }
                }
            });
        }
    }

    public void refreshUI() {
        if (getDialogImpl() != null) {
            runOnMain(new Runnable() {
                public void run() {
                    if (PopTip.this.dialogImpl != null) {
                        PopTip.this.dialogImpl.refreshView();
                    }
                }
            });
        }
    }

    public void dismiss() {
        runOnMain(new Runnable() {
            public void run() {
                if (PopTip.this.dialogImpl != null) {
                    PopTip.this.dialogImpl.doDismiss((View) null);
                }
            }
        });
    }

    public DialogLifecycleCallback<PopTip> getDialogLifecycleCallback() {
        DialogLifecycleCallback<PopTip> dialogLifecycleCallback2 = this.dialogLifecycleCallback;
        return dialogLifecycleCallback2 == null ? new DialogLifecycleCallback<PopTip>() {
        } : dialogLifecycleCallback2;
    }

    public PopTip setDialogLifecycleCallback(DialogLifecycleCallback<PopTip> dialogLifecycleCallback2) {
        this.dialogLifecycleCallback = dialogLifecycleCallback2;
        if (this.isShow) {
            dialogLifecycleCallback2.onShow(this.me);
        }
        return this;
    }

    public PopTip setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public PopTip setTheme(DialogX.THEME theme) {
        this.theme = theme;
        return this;
    }

    public DialogImpl getDialogImpl() {
        return this.dialogImpl;
    }

    public PopTip setCustomView(OnBindView<PopTip> onBindView2) {
        this.onBindView = onBindView2;
        refreshUI();
        return this;
    }

    public View getCustomView() {
        OnBindView<PopTip> onBindView2 = this.onBindView;
        if (onBindView2 == null) {
            return null;
        }
        return onBindView2.getCustomView();
    }

    public PopTip removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public DialogXStyle.PopTipSettings.ALIGN getAlign() {
        return this.align;
    }

    @Deprecated
    public PopTip setAlign(DialogXStyle.PopTipSettings.ALIGN align2) {
        this.align = align2;
        return this;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public PopTip setIconResId(int i) {
        this.iconResId = i;
        refreshUI();
        return this;
    }

    public CharSequence getMessage() {
        return this.message;
    }

    public PopTip setMessage(CharSequence charSequence) {
        this.message = charSequence;
        refreshUI();
        return this;
    }

    public PopTip setMessage(int i) {
        this.message = getString(i);
        refreshUI();
        return this;
    }

    public CharSequence getButtonText() {
        return this.buttonText;
    }

    public PopTip setButton(CharSequence charSequence) {
        this.buttonText = charSequence;
        refreshUI();
        return this;
    }

    public PopTip setButton(int i) {
        this.buttonText = getString(i);
        refreshUI();
        return this;
    }

    public PopTip setButton(CharSequence charSequence, OnDialogButtonClickListener<PopTip> onDialogButtonClickListener) {
        this.buttonText = charSequence;
        this.onButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public PopTip setButton(int i, OnDialogButtonClickListener<PopTip> onDialogButtonClickListener) {
        this.buttonText = getString(i);
        this.onButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public PopTip setButton(OnDialogButtonClickListener<PopTip> onDialogButtonClickListener) {
        this.onButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    public TextInfo getMessageTextInfo() {
        return this.messageTextInfo;
    }

    public PopTip setMessageTextInfo(TextInfo textInfo) {
        this.messageTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public TextInfo getButtonTextInfo() {
        return this.buttonTextInfo;
    }

    public PopTip setButtonTextInfo(TextInfo textInfo) {
        this.buttonTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public OnDialogButtonClickListener<PopTip> getOnButtonClickListener() {
        return this.onButtonClickListener;
    }

    public PopTip setOnButtonClickListener(OnDialogButtonClickListener<PopTip> onDialogButtonClickListener) {
        this.onButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    @Deprecated
    public boolean isAutoTintIconInLightOrDarkMode() {
        return isTintIcon();
    }

    @Deprecated
    public PopTip setAutoTintIconInLightOrDarkMode(boolean z) {
        setTintIcon(z);
        return this;
    }

    public OnDialogButtonClickListener<PopTip> getOnPopTipClickListener() {
        return this.onPopTipClickListener;
    }

    public PopTip setOnPopTipClickListener(OnDialogButtonClickListener<PopTip> onDialogButtonClickListener) {
        this.onPopTipClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public int getBackgroundColor() {
        return this.backgroundColor.intValue();
    }

    public PopTip setBackgroundColor(int i) {
        this.backgroundColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public PopTip setBackgroundColorRes(int i) {
        this.backgroundColor = Integer.valueOf(getColor(i));
        refreshUI();
        return this;
    }

    public long getEnterAnimDuration() {
        return this.enterAnimDuration;
    }

    public PopTip setEnterAnimDuration(long j) {
        this.enterAnimDuration = j;
        return this;
    }

    public long getExitAnimDuration() {
        return this.exitAnimDuration;
    }

    public PopTip setExitAnimDuration(long j) {
        this.exitAnimDuration = j;
        return this;
    }

    public void restartDialog() {
        long j;
        long j2;
        PopTip popTip;
        if (getDialogView() != null) {
            dismiss(getDialogView());
            this.isShow = false;
        }
        if (getDialogImpl().boxCustom != null) {
            getDialogImpl().boxCustom.removeAllViews();
        }
        if (DialogX.onlyOnePopTip) {
            List<PopTip> list = popTipList;
            if (list == null || list.isEmpty()) {
                popTip = null;
            } else {
                List<PopTip> list2 = popTipList;
                popTip = list2.get(list2.size() - 1);
            }
            if (popTip != null) {
                popTip.dismiss();
            }
        } else if (popTipList != null) {
            for (int i = 0; i < popTipList.size(); i++) {
                popTipList.get(i).moveUp();
            }
        }
        if (popTipList == null) {
            popTipList = new ArrayList();
        }
        popTipList.add(this);
        int i2 = isLightTheme() ? R.layout.layout_dialogx_poptip_material : R.layout.layout_dialogx_poptip_material_dark;
        if (this.style.popTipSettings() != null) {
            if (this.style.popTipSettings().layout(isLightTheme()) != 0) {
                i2 = this.style.popTipSettings().layout(isLightTheme());
            }
            if (this.align == null) {
                if (this.style.popTipSettings().align() == null) {
                    this.align = DialogXStyle.PopTipSettings.ALIGN.BOTTOM;
                } else {
                    this.align = this.style.popTipSettings().align();
                }
            }
            int enterAnimResId2 = this.style.popTipSettings().enterAnimResId(isLightTheme());
            int exitAnimResId2 = this.style.popTipSettings().exitAnimResId(isLightTheme());
            int i3 = this.enterAnimResId;
            if (i3 != 0 || (i3 = overrideEnterAnimRes) != 0) {
                enterAnimResId2 = i3;
            } else if (enterAnimResId2 == 0) {
                enterAnimResId2 = R.anim.anim_dialogx_default_enter;
            }
            this.enterAnimResId = enterAnimResId2;
            int i4 = this.exitAnimResId;
            if (i4 != 0 || (i4 = overrideExitAnimRes) != 0) {
                exitAnimResId2 = i4;
            } else if (exitAnimResId2 == 0) {
                exitAnimResId2 = R.anim.anim_dialogx_default_exit;
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
        View createView = createView(i2);
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

    public PopTip setAnimResId(int i, int i2) {
        this.enterAnimResId = i;
        this.exitAnimResId = i2;
        return this;
    }

    public PopTip setEnterAnimResId(int i) {
        this.enterAnimResId = i;
        return this;
    }

    public PopTip setExitAnimResId(int i) {
        this.exitAnimResId = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        dismiss();
    }

    public PopTip setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public PopTip setMargin(int i, int i2, int i3, int i4) {
        int[] iArr = this.bodyMargin;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        refreshUI();
        return this;
    }

    public PopTip setMarginLeft(int i) {
        this.bodyMargin[0] = i;
        refreshUI();
        return this;
    }

    public PopTip setMarginTop(int i) {
        this.bodyMargin[1] = i;
        refreshUI();
        return this;
    }

    public PopTip setMarginRight(int i) {
        this.bodyMargin[2] = i;
        refreshUI();
        return this;
    }

    public PopTip setMarginBottom(int i) {
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

    public PopTip iconSuccess() {
        setTintIcon(false);
        int i = R.mipmap.ico_dialogx_success;
        if (!(getStyle().popTipSettings() == null || getStyle().popTipSettings().defaultIconSuccess() == 0)) {
            i = getStyle().popTipSettings().defaultIconSuccess();
        }
        setIconResId(i);
        return this;
    }

    public PopTip iconWarning() {
        setTintIcon(false);
        int i = R.mipmap.ico_dialogx_warning;
        if (!(getStyle().popTipSettings() == null || getStyle().popTipSettings().defaultIconWarning() == 0)) {
            i = getStyle().popTipSettings().defaultIconWarning();
        }
        setIconResId(i);
        return this;
    }

    public PopTip iconError() {
        setTintIcon(false);
        int i = R.mipmap.ico_dialogx_error;
        if (!(getStyle().popTipSettings() == null || getStyle().popTipSettings().defaultIconError() == 0)) {
            i = getStyle().popTipSettings().defaultIconError();
        }
        setIconResId(i);
        return this;
    }

    public boolean isTintIcon() {
        if (this.tintIcon != null || getStyle().popTipSettings() == null) {
            return this.tintIcon == BaseDialog.BOOLEAN.TRUE;
        }
        return getStyle().popTipSettings().tintIcon();
    }

    public PopTip setTintIcon(boolean z) {
        this.tintIcon = z ? BaseDialog.BOOLEAN.TRUE : BaseDialog.BOOLEAN.FALSE;
        refreshUI();
        return this;
    }

    public PopTip setRadius(float f) {
        this.backgroundRadius = f;
        refreshUI();
        return this;
    }

    public float getRadius() {
        return this.backgroundRadius;
    }

    public DialogXAnimInterface<PopTip> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public PopTip setDialogXAnimImpl(DialogXAnimInterface<PopTip> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public PopTip setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public PopTip setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    /* access modifiers changed from: protected */
    public void cleanActivityContext() {
        super.cleanActivityContext();
        dismiss(getDialogView());
    }
}
