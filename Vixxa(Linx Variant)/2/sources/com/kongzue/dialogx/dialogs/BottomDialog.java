package com.kongzue.dialogx.dialogs;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.interfaces.BaseOnDialogClickCallback;
import com.kongzue.dialogx.interfaces.BlurViewType;
import com.kongzue.dialogx.interfaces.BottomDialogSlideEventLifecycleCallback;
import com.kongzue.dialogx.interfaces.DialogConvertViewInterface;
import com.kongzue.dialogx.interfaces.DialogLifecycleCallback;
import com.kongzue.dialogx.interfaces.DialogXAnimInterface;
import com.kongzue.dialogx.interfaces.DialogXBaseBottomDialog;
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.OnBackPressedListener;
import com.kongzue.dialogx.interfaces.OnBackgroundMaskClickListener;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.interfaces.OnBottomMenuButtonClickListener;
import com.kongzue.dialogx.interfaces.OnDialogButtonClickListener;
import com.kongzue.dialogx.interfaces.ScrollController;
import com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor;
import com.kongzue.dialogx.util.TextInfo;
import com.kongzue.dialogx.util.views.BottomDialogScrollView;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import java.util.Iterator;
import java.util.List;

public class BottomDialog extends BaseDialog implements DialogXBaseBottomDialog {
    public static BaseDialog.BOOLEAN overrideCancelable = null;
    public static int overrideEnterDuration = -1;
    public static int overrideExitDuration = -1;
    protected boolean allowInterceptTouch = true;
    protected float backgroundRadius = -1.0f;
    protected boolean bkgInterceptTouch = true;
    protected float bottomDialogMaxHeight = 0.0f;
    protected boolean bottomNonSafetyAreaBySelf = false;
    protected BaseDialog.BUTTON_SELECT_RESULT buttonSelectResult = BaseDialog.BUTTON_SELECT_RESULT.NONE;
    protected BaseOnDialogClickCallback cancelButtonClickListener;
    protected CharSequence cancelText;
    protected TextInfo cancelTextInfo = new TextInfo().setBold(true);
    protected DialogImpl dialogImpl;
    protected DialogLifecycleCallback<BottomDialog> dialogLifecycleCallback;
    protected DialogXAnimInterface<BottomDialog> dialogXAnimImpl;
    protected boolean hideWithExitAnim;
    protected boolean isHide;
    protected Integer maskColor = null;
    protected BottomDialog me = this;
    protected TextInfo menuTextInfo;
    protected CharSequence message;
    protected TextInfo messageTextInfo;
    protected BaseOnDialogClickCallback okButtonClickListener;
    protected CharSequence okText;
    protected TextInfo okTextInfo = new TextInfo().setBold(true);
    protected OnBackPressedListener<BottomDialog> onBackPressedListener;
    protected OnBackgroundMaskClickListener<BottomDialog> onBackgroundMaskClickListener;
    protected OnBindView<BottomDialog> onBindView;
    protected BaseOnDialogClickCallback otherButtonClickListener;
    protected CharSequence otherText;
    protected TextInfo otherTextInfo = new TextInfo().setBold(true);
    protected BaseDialog.BOOLEAN privateCancelable;
    protected boolean scrollableWhenContentLargeThanVisibleRange = true;
    protected CharSequence title;
    protected Drawable titleIcon;
    protected TextInfo titleTextInfo;

    public void onDismiss(BottomDialog bottomDialog) {
    }

    public void onShow(BottomDialog bottomDialog) {
    }

    protected BottomDialog() {
    }

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    public static BottomDialog build() {
        return new BottomDialog();
    }

    public static BottomDialog build(DialogXStyle dialogXStyle) {
        return new BottomDialog().setStyle(dialogXStyle);
    }

    public static BottomDialog build(OnBindView<BottomDialog> onBindView2) {
        return new BottomDialog().setCustomView(onBindView2);
    }

    public BottomDialog(CharSequence charSequence, CharSequence charSequence2) {
        this.title = charSequence;
        this.message = charSequence2;
    }

    public BottomDialog(int i, int i2) {
        this.title = getString(i);
        this.message = getString(i2);
    }

    public static BottomDialog show(CharSequence charSequence, CharSequence charSequence2) {
        BottomDialog bottomDialog = new BottomDialog(charSequence, charSequence2);
        bottomDialog.show();
        return bottomDialog;
    }

    public static BottomDialog show(int i, int i2) {
        BottomDialog bottomDialog = new BottomDialog(i, i2);
        bottomDialog.show();
        return bottomDialog;
    }

    public BottomDialog(CharSequence charSequence, CharSequence charSequence2, OnBindView<BottomDialog> onBindView2) {
        this.title = charSequence;
        this.message = charSequence2;
        this.onBindView = onBindView2;
    }

    public BottomDialog(int i, int i2, OnBindView<BottomDialog> onBindView2) {
        this.title = getString(i);
        this.message = getString(i2);
        this.onBindView = onBindView2;
    }

    public static BottomDialog show(CharSequence charSequence, CharSequence charSequence2, OnBindView<BottomDialog> onBindView2) {
        BottomDialog bottomDialog = new BottomDialog(charSequence, charSequence2, onBindView2);
        bottomDialog.show();
        return bottomDialog;
    }

    public static BottomDialog show(int i, int i2, OnBindView<BottomDialog> onBindView2) {
        BottomDialog bottomDialog = new BottomDialog(i, i2, onBindView2);
        bottomDialog.show();
        return bottomDialog;
    }

    public BottomDialog(CharSequence charSequence, OnBindView<BottomDialog> onBindView2) {
        this.title = charSequence;
        this.onBindView = onBindView2;
    }

    public BottomDialog(int i, OnBindView<BottomDialog> onBindView2) {
        this.title = getString(i);
        this.onBindView = onBindView2;
    }

    public static BottomDialog show(CharSequence charSequence, OnBindView<BottomDialog> onBindView2) {
        BottomDialog bottomDialog = new BottomDialog(charSequence, onBindView2);
        bottomDialog.show();
        return bottomDialog;
    }

    public static BottomDialog show(int i, OnBindView<BottomDialog> onBindView2) {
        BottomDialog bottomDialog = new BottomDialog(i, onBindView2);
        bottomDialog.show();
        return bottomDialog;
    }

    public BottomDialog(OnBindView<BottomDialog> onBindView2) {
        this.onBindView = onBindView2;
    }

    public static BottomDialog show(OnBindView<BottomDialog> onBindView2) {
        BottomDialog bottomDialog = new BottomDialog(onBindView2);
        bottomDialog.show();
        return bottomDialog;
    }

    public BottomDialog show() {
        if (!this.isHide || getDialogView() == null || !this.isShow) {
            super.beforeShow();
            if (getDialogView() == null) {
                int i = isLightTheme() ? R.layout.layout_dialogx_bottom_material : R.layout.layout_dialogx_bottom_material_dark;
                if (this.style.overrideBottomDialogRes() != null) {
                    i = this.style.overrideBottomDialogRes().overrideDialogLayout(isLightTheme());
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
            int i = isLightTheme() ? R.layout.layout_dialogx_bottom_material : R.layout.layout_dialogx_bottom_material_dark;
            if (this.style.overrideBottomDialogRes() != null) {
                i = this.style.overrideBottomDialogRes().overrideDialogLayout(isLightTheme());
            }
            View createView = createView(i);
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
        /* access modifiers changed from: private */
        public List<View> blurViews;
        /* access modifiers changed from: private */
        public BottomDialogTouchEventInterceptor bottomDialogTouchEventInterceptor;
        public RelativeLayout boxBkg;
        public LinearLayout boxButton;
        public ViewGroup boxCancel;
        public LinearLayout boxContent;
        public RelativeLayout boxCustom;
        public ViewGroup boxList;
        public DialogXBaseRelativeLayout boxRoot;
        public TextView btnSelectNegative;
        public TextView btnSelectOther;
        public TextView btnSelectPositive;
        public View imgSplit;
        public ImageView imgTab;
        public ScrollController scrollView;
        public ImageView splitSelectOther;
        public ImageView splitSelectPositive;
        public TextView txtDialogTip;
        public TextView txtDialogTitle;

        public DialogImpl(View view) {
            if (view != null) {
                BottomDialog.this.setDialogView(view);
                this.boxRoot = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
                this.boxBkg = (RelativeLayout) view.findViewById(R.id.box_bkg);
                this.bkg = (MaxRelativeLayout) view.findViewById(R.id.bkg);
                this.imgTab = (ImageView) view.findViewById(R.id.img_tab);
                this.txtDialogTitle = (TextView) view.findViewById(R.id.txt_dialog_title);
                this.scrollView = (ScrollController) view.findViewById(R.id.scrollView);
                this.boxContent = (LinearLayout) view.findViewById(R.id.box_content);
                this.txtDialogTip = (TextView) view.findViewById(R.id.txt_dialog_tip);
                this.imgSplit = view.findViewWithTag("split");
                this.boxList = (ViewGroup) view.findViewById(R.id.box_list);
                this.boxCustom = (RelativeLayout) view.findViewById(R.id.box_custom);
                if (!BottomDialog.this.scrollableWhenContentLargeThanVisibleRange) {
                    ((ViewGroup) this.boxContent.getParent()).removeView(this.boxContent);
                    ((ViewGroup) this.txtDialogTitle.getParent()).addView(this.boxContent, 1, new ViewGroup.LayoutParams(-1, -2));
                }
                this.boxCancel = (ViewGroup) view.findViewWithTag("cancelBox");
                this.boxButton = (LinearLayout) view.findViewById(R.id.box_button);
                this.btnSelectNegative = (TextView) view.findViewById(R.id.btn_selectNegative);
                this.btnSelectOther = (TextView) view.findViewById(R.id.btn_selectOther);
                this.btnSelectPositive = (TextView) view.findViewById(R.id.btn_selectPositive);
                this.splitSelectPositive = (ImageView) view.findViewWithTag("imgPositiveButtonSplit");
                this.splitSelectOther = (ImageView) view.findViewWithTag("imgOtherButtonSplit");
                this.blurViews = BottomDialog.this.findAllBlurView(view);
                init();
                BottomDialog.this.dialogImpl = this;
                refreshView();
            }
        }

        public void reBuild() {
            init();
            BottomDialog.this.dialogImpl = this;
            refreshView();
        }

        public void init() {
            BottomDialog.this.buttonSelectResult = BaseDialog.BUTTON_SELECT_RESULT.NONE;
            if (BottomDialog.this.titleTextInfo == null) {
                BottomDialog.this.titleTextInfo = DialogX.titleTextInfo;
            }
            if (BottomDialog.this.messageTextInfo == null) {
                BottomDialog.this.messageTextInfo = DialogX.messageTextInfo;
            }
            if (BottomDialog.this.okTextInfo == null) {
                BottomDialog.this.okTextInfo = DialogX.okButtonTextInfo;
            }
            if (BottomDialog.this.okTextInfo == null) {
                BottomDialog.this.okTextInfo = DialogX.buttonTextInfo;
            }
            if (BottomDialog.this.cancelTextInfo == null) {
                BottomDialog.this.cancelTextInfo = DialogX.buttonTextInfo;
            }
            if (BottomDialog.this.otherTextInfo == null) {
                BottomDialog.this.otherTextInfo = DialogX.buttonTextInfo;
            }
            if (BottomDialog.this.backgroundColor == null) {
                Integer unused = BottomDialog.this.backgroundColor = DialogX.backgroundColor;
            }
            if (BottomDialog.this.cancelText == null) {
                BottomDialog.this.cancelText = DialogX.cancelButtonText;
            }
            this.txtDialogTitle.getPaint().setFakeBoldText(true);
            TextView textView = this.btnSelectNegative;
            if (textView != null) {
                textView.getPaint().setFakeBoldText(true);
            }
            TextView textView2 = this.btnSelectPositive;
            if (textView2 != null) {
                textView2.getPaint().setFakeBoldText(true);
            }
            TextView textView3 = this.btnSelectOther;
            if (textView3 != null) {
                textView3.getPaint().setFakeBoldText(true);
            }
            this.boxBkg.setY((float) BottomDialog.this.getRootFrameLayout().getMeasuredHeight());
            this.bkg.setMaxWidth(BottomDialog.this.getMaxWidth());
            this.bkg.setMaxHeight(BottomDialog.this.getMaxHeight());
            this.bkg.setMinimumWidth(BottomDialog.this.getMinWidth());
            this.bkg.setMinimumHeight(BottomDialog.this.getMinHeight());
            this.boxRoot.setParentDialog(BottomDialog.this.me);
            this.boxRoot.setOnLifecycleCallBack(new DialogXBaseRelativeLayout.OnLifecycleCallBack() {
                public void onShow() {
                    boolean unused = BottomDialog.this.isShow = true;
                    boolean unused2 = BottomDialog.this.preShow = false;
                    BottomDialog.this.setLifecycleState(Lifecycle.State.CREATED);
                    BottomDialog.this.getDialogLifecycleCallback().onShow(BottomDialog.this.me);
                    BottomDialog.this.onShow(BottomDialog.this.me);
                    BottomDialog.this.onDialogShow();
                    BottomDialog.this.refreshUI();
                }

                public void onDismiss() {
                    boolean unused = BottomDialog.this.isShow = false;
                    BottomDialog.this.getDialogLifecycleCallback().onDismiss(BottomDialog.this.me);
                    BottomDialog.this.onDismiss(BottomDialog.this.me);
                    BottomDialog.this.dialogImpl = null;
                    BottomDialogTouchEventInterceptor unused2 = DialogImpl.this.bottomDialogTouchEventInterceptor = null;
                    BottomDialog.this.dialogLifecycleCallback = null;
                    BottomDialog.this.setLifecycleState(Lifecycle.State.DESTROYED);
                    System.gc();
                }
            });
            TextView textView4 = this.btnSelectNegative;
            if (textView4 != null) {
                textView4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BottomDialog.this.buttonSelectResult = BaseDialog.BUTTON_SELECT_RESULT.BUTTON_CANCEL;
                        if (BottomDialog.this.cancelButtonClickListener == null) {
                            BottomDialog.this.dismiss();
                        } else if (BottomDialog.this.cancelButtonClickListener instanceof OnDialogButtonClickListener) {
                            if (!((OnDialogButtonClickListener) BottomDialog.this.cancelButtonClickListener).onClick(BottomDialog.this.me, view)) {
                                BottomDialog.this.dismiss();
                            }
                        } else if ((BottomDialog.this.cancelButtonClickListener instanceof OnBottomMenuButtonClickListener) && !((OnBottomMenuButtonClickListener) BottomDialog.this.cancelButtonClickListener).onClick(BottomDialog.this.me, view)) {
                            BottomDialog.this.dismiss();
                        }
                    }
                });
            }
            TextView textView5 = this.btnSelectOther;
            if (textView5 != null) {
                textView5.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BottomDialog.this.buttonSelectResult = BaseDialog.BUTTON_SELECT_RESULT.BUTTON_OTHER;
                        if (BottomDialog.this.otherButtonClickListener == null) {
                            BottomDialog.this.dismiss();
                        } else if (BottomDialog.this.otherButtonClickListener instanceof OnDialogButtonClickListener) {
                            if (!((OnDialogButtonClickListener) BottomDialog.this.otherButtonClickListener).onClick(BottomDialog.this.me, view)) {
                                BottomDialog.this.dismiss();
                            }
                        } else if ((BottomDialog.this.otherButtonClickListener instanceof OnBottomMenuButtonClickListener) && !((OnBottomMenuButtonClickListener) BottomDialog.this.otherButtonClickListener).onClick(BottomDialog.this.me, view)) {
                            BottomDialog.this.dismiss();
                        }
                    }
                });
            }
            TextView textView6 = this.btnSelectPositive;
            if (textView6 != null) {
                textView6.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        BottomDialog.this.buttonSelectResult = BaseDialog.BUTTON_SELECT_RESULT.BUTTON_OK;
                        if (BottomDialog.this.okButtonClickListener == null) {
                            BottomDialog.this.dismiss();
                        } else if (BottomDialog.this.okButtonClickListener instanceof OnDialogButtonClickListener) {
                            if (!((OnDialogButtonClickListener) BottomDialog.this.okButtonClickListener).onClick(BottomDialog.this.me, view)) {
                                BottomDialog.this.dismiss();
                            }
                        } else if ((BottomDialog.this.okButtonClickListener instanceof OnBottomMenuButtonClickListener) && !((OnBottomMenuButtonClickListener) BottomDialog.this.okButtonClickListener).onClick(BottomDialog.this.me, view)) {
                            BottomDialog.this.dismiss();
                        }
                    }
                });
            }
            if (this.imgSplit != null) {
                int overrideMenuDividerDrawableRes = BottomDialog.this.style.overrideBottomDialogRes().overrideMenuDividerDrawableRes(BottomDialog.this.isLightTheme());
                int overrideMenuDividerHeight = BottomDialog.this.style.overrideBottomDialogRes().overrideMenuDividerHeight(BottomDialog.this.isLightTheme());
                if (overrideMenuDividerDrawableRes != 0) {
                    this.imgSplit.setBackgroundResource(overrideMenuDividerDrawableRes);
                }
                if (overrideMenuDividerHeight != 0) {
                    ViewGroup.LayoutParams layoutParams = this.imgSplit.getLayoutParams();
                    layoutParams.height = overrideMenuDividerHeight;
                    this.imgSplit.setLayoutParams(layoutParams);
                }
            }
            this.boxRoot.setOnBackPressedListener(new DialogXBaseRelativeLayout.PrivateBackPressedListener() {
                public boolean onBackPressed() {
                    if (BottomDialog.this.onBackPressedListener != null) {
                        if (!BottomDialog.this.onBackPressedListener.onBackPressed(BottomDialog.this.me)) {
                            return true;
                        }
                        BottomDialog.this.dismiss();
                        return true;
                    } else if (!BottomDialog.this.isCancelable()) {
                        return true;
                    } else {
                        BottomDialog.this.dismiss();
                        return true;
                    }
                }
            });
            this.boxBkg.post(new Runnable() {
                public void run() {
                    Float f;
                    Integer num;
                    DialogImpl.this.getDialogXAnimImpl().doShowAnim(BottomDialog.this, DialogImpl.this.bkg);
                    if (BottomDialog.this.style.messageDialogBlurSettings() != null) {
                        num = BottomDialog.this.getColorNullable(BottomDialog.this.getIntStyleAttr(Integer.valueOf(BottomDialog.this.style.messageDialogBlurSettings().blurForwardColorRes(BottomDialog.this.isLightTheme()))));
                        f = BottomDialog.this.getFloatStyleAttr(Float.valueOf((float) BottomDialog.this.style.messageDialogBlurSettings().blurBackgroundRoundRadiusPx()));
                    } else {
                        num = null;
                        f = null;
                    }
                    if (DialogImpl.this.blurViews != null) {
                        for (View view : DialogImpl.this.blurViews) {
                            BlurViewType blurViewType = (BlurViewType) view;
                            blurViewType.setOverlayColor(BottomDialog.this.backgroundColor == null ? num : BottomDialog.this.backgroundColor);
                            blurViewType.setRadiusPx(f);
                        }
                    }
                }
            });
            BottomDialog.runOnMainDelay(new Runnable() {
                public void run() {
                    BottomDialogTouchEventInterceptor unused = DialogImpl.this.bottomDialogTouchEventInterceptor = new BottomDialogTouchEventInterceptor(BottomDialog.this.me, BottomDialog.this.dialogImpl);
                }
            }, getEnterAnimationDuration());
            BottomDialog.this.onDialogInit();
        }

        public void refreshView() {
            if (this.boxRoot != null && BottomDialog.this.getOwnActivity() != null) {
                this.boxRoot.setRootPadding(BottomDialog.this.screenPaddings[0], BottomDialog.this.screenPaddings[1], BottomDialog.this.screenPaddings[2], BottomDialog.this.screenPaddings[3]);
                if (BottomDialog.this.backgroundColor != null) {
                    BottomDialog bottomDialog = BottomDialog.this;
                    bottomDialog.tintColor(this.bkg, bottomDialog.backgroundColor.intValue());
                    BottomDialog bottomDialog2 = BottomDialog.this;
                    bottomDialog2.tintColor(this.btnSelectOther, bottomDialog2.backgroundColor.intValue());
                    BottomDialog bottomDialog3 = BottomDialog.this;
                    bottomDialog3.tintColor(this.btnSelectNegative, bottomDialog3.backgroundColor.intValue());
                    BottomDialog bottomDialog4 = BottomDialog.this;
                    bottomDialog4.tintColor(this.btnSelectPositive, bottomDialog4.backgroundColor.intValue());
                    List<View> list = this.blurViews;
                    if (list != null) {
                        Iterator<View> it = list.iterator();
                        while (it.hasNext()) {
                            ((BlurViewType) it.next()).setOverlayColor(BottomDialog.this.backgroundColor);
                        }
                    }
                }
                BottomDialog bottomDialog5 = BottomDialog.this;
                bottomDialog5.showText(this.txtDialogTitle, bottomDialog5.title);
                BottomDialog bottomDialog6 = BottomDialog.this;
                bottomDialog6.showText(this.txtDialogTip, bottomDialog6.message);
                BaseDialog.useTextInfo(this.txtDialogTitle, BottomDialog.this.titleTextInfo);
                BaseDialog.useTextInfo(this.txtDialogTip, BottomDialog.this.messageTextInfo);
                BaseDialog.useTextInfo(this.btnSelectNegative, BottomDialog.this.cancelTextInfo);
                BaseDialog.useTextInfo(this.btnSelectOther, BottomDialog.this.otherTextInfo);
                BaseDialog.useTextInfo(this.btnSelectPositive, BottomDialog.this.okTextInfo);
                if (BottomDialog.this.titleIcon != null) {
                    int textSize = (int) this.txtDialogTitle.getTextSize();
                    BottomDialog.this.titleIcon.setBounds(0, 0, textSize, textSize);
                    this.txtDialogTitle.setCompoundDrawablePadding(BottomDialog.this.dip2px(10.0f));
                    this.txtDialogTitle.setCompoundDrawables(BottomDialog.this.titleIcon, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (!BottomDialog.this.bkgInterceptTouch) {
                    this.boxRoot.setClickable(false);
                } else if (BottomDialog.this.isCancelable()) {
                    this.boxRoot.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (BottomDialog.this.onBackgroundMaskClickListener == null || !BottomDialog.this.onBackgroundMaskClickListener.onClick(BottomDialog.this.me, view)) {
                                DialogImpl.this.doDismiss(view);
                            }
                        }
                    });
                } else {
                    this.boxRoot.setOnClickListener((View.OnClickListener) null);
                }
                this.boxBkg.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        DialogImpl.this.boxRoot.callOnClick();
                    }
                });
                if (BottomDialog.this.backgroundRadius > -1.0f) {
                    GradientDrawable gradientDrawable = (GradientDrawable) this.bkg.getBackground();
                    if (gradientDrawable != null) {
                        gradientDrawable.setCornerRadii(new float[]{BottomDialog.this.backgroundRadius, BottomDialog.this.backgroundRadius, BottomDialog.this.backgroundRadius, BottomDialog.this.backgroundRadius, 0.0f, 0.0f, 0.0f, 0.0f});
                    }
                    this.bkg.setOutlineProvider(new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, view.getWidth(), (int) (((float) view.getHeight()) + BottomDialog.this.backgroundRadius), BottomDialog.this.backgroundRadius);
                        }
                    });
                    this.bkg.setClipToOutline(true);
                    List<View> list2 = this.blurViews;
                    if (list2 != null) {
                        Iterator<View> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            ((BlurViewType) it2.next()).setRadiusPx(Float.valueOf(BottomDialog.this.backgroundRadius));
                        }
                    }
                }
                if (BottomDialog.this.maskColor != null) {
                    this.boxRoot.setBackground(new ColorDrawable(BottomDialog.this.maskColor.intValue()));
                }
                if (!(BottomDialog.this.onBindView == null || BottomDialog.this.onBindView.getCustomView() == null)) {
                    BottomDialog.this.onBindView.bindParent(this.boxCustom, BottomDialog.this.me);
                    if (BottomDialog.this.onBindView.getCustomView() instanceof ScrollController) {
                        ScrollController scrollController = this.scrollView;
                        if (scrollController instanceof BottomDialogScrollView) {
                            ((BottomDialogScrollView) scrollController).setVerticalScrollBarEnabled(false);
                        }
                        this.scrollView = (ScrollController) BottomDialog.this.onBindView.getCustomView();
                    } else {
                        View findViewWithTag = BottomDialog.this.onBindView.getCustomView().findViewWithTag("ScrollController");
                        if (findViewWithTag instanceof ScrollController) {
                            ScrollController scrollController2 = this.scrollView;
                            if (scrollController2 instanceof BottomDialogScrollView) {
                                ((BottomDialogScrollView) scrollController2).setVerticalScrollBarEnabled(false);
                            }
                            this.scrollView = (ScrollController) findViewWithTag;
                        }
                    }
                }
                if (!BottomDialog.this.isAllowInterceptTouch() || !BottomDialog.this.isCancelable()) {
                    ImageView imageView = this.imgTab;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                } else {
                    ImageView imageView2 = this.imgTab;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                }
                BottomDialogTouchEventInterceptor bottomDialogTouchEventInterceptor2 = this.bottomDialogTouchEventInterceptor;
                if (bottomDialogTouchEventInterceptor2 != null) {
                    bottomDialogTouchEventInterceptor2.refresh(BottomDialog.this.me, this);
                }
                if (this.imgSplit != null) {
                    if (this.txtDialogTitle.getVisibility() == 0 || this.txtDialogTip.getVisibility() == 0) {
                        this.imgSplit.setVisibility(0);
                    } else {
                        this.imgSplit.setVisibility(8);
                    }
                }
                if (this.boxCancel != null) {
                    if (BaseDialog.isNull(BottomDialog.this.cancelText)) {
                        this.boxCancel.setVisibility(8);
                    } else {
                        this.boxCancel.setVisibility(0);
                    }
                }
                BottomDialog bottomDialog7 = BottomDialog.this;
                bottomDialog7.showText(this.btnSelectPositive, bottomDialog7.okText);
                BottomDialog bottomDialog8 = BottomDialog.this;
                bottomDialog8.showText(this.btnSelectNegative, bottomDialog8.cancelText);
                BottomDialog bottomDialog9 = BottomDialog.this;
                bottomDialog9.showText(this.btnSelectOther, bottomDialog9.otherText);
                ImageView imageView3 = this.splitSelectPositive;
                if (imageView3 != null) {
                    imageView3.setVisibility(this.btnSelectPositive.getVisibility());
                }
                ImageView imageView4 = this.splitSelectOther;
                if (imageView4 != null) {
                    imageView4.setVisibility(this.btnSelectOther.getVisibility());
                }
                BottomDialog.this.onDialogRefreshUI();
            }
        }

        public void doDismiss(View view) {
            if (view != null) {
                view.setEnabled(false);
            }
            if (BottomDialog.this.getOwnActivity() != null && !BottomDialog.this.dismissAnimFlag && getDialogXAnimImpl() != null) {
                boolean unused = BottomDialog.this.dismissAnimFlag = true;
                getDialogXAnimImpl().doExitAnim(BottomDialog.this, this.bkg);
                BottomDialog.runOnMainDelay(new Runnable() {
                    public void run() {
                        if (DialogImpl.this.boxRoot != null) {
                            DialogImpl.this.boxRoot.setVisibility(8);
                        }
                        BottomDialog.dismiss(BottomDialog.this.getDialogView());
                    }
                }, getExitAnimationDuration());
            }
        }

        public void preDismiss() {
            if (!BottomDialog.this.isCancelable()) {
                long j = BottomDialog.overrideExitDuration >= 0 ? (long) BottomDialog.overrideExitDuration : 300;
                if (BottomDialog.this.exitAnimDuration >= 0) {
                    j = BottomDialog.this.exitAnimDuration;
                }
                RelativeLayout relativeLayout = this.boxBkg;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "y", new float[]{relativeLayout.getY(), (float) this.boxRoot.getUnsafePlace().top});
                ofFloat.setDuration(j);
                ofFloat.start();
            } else if (!(BottomDialog.this.getDialogLifecycleCallback() instanceof BottomDialogSlideEventLifecycleCallback)) {
                doDismiss(this.boxRoot);
            } else if (!((BottomDialogSlideEventLifecycleCallback) BottomDialog.this.getDialogLifecycleCallback()).onSlideClose(BottomDialog.this.me)) {
                doDismiss(this.boxRoot);
            }
        }

        /* access modifiers changed from: protected */
        public DialogXAnimInterface<BottomDialog> getDialogXAnimImpl() {
            if (BottomDialog.this.dialogXAnimImpl == null) {
                BottomDialog.this.dialogXAnimImpl = new DialogXAnimInterface<BottomDialog>() {
                    public void doShowAnim(BottomDialog bottomDialog, ViewGroup viewGroup) {
                        float f;
                        float f2;
                        float f3;
                        float f4;
                        long enterAnimationDuration = DialogImpl.this.getEnterAnimationDuration();
                        float f5 = 0.0f;
                        if (bottomDialog.isAllowInterceptTouch()) {
                            if (BottomDialog.this.bottomDialogMaxHeight > 0.0f && BottomDialog.this.bottomDialogMaxHeight <= 1.0f) {
                                f3 = (float) DialogImpl.this.boxBkg.getHeight();
                                f4 = BottomDialog.this.bottomDialogMaxHeight * ((float) DialogImpl.this.boxBkg.getHeight());
                            } else if (BottomDialog.this.bottomDialogMaxHeight > 1.0f) {
                                f3 = (float) DialogImpl.this.boxBkg.getHeight();
                                f4 = BottomDialog.this.bottomDialogMaxHeight;
                            }
                            f5 = f3 - f4;
                        } else {
                            if (BottomDialog.this.bottomDialogMaxHeight <= 0.0f || BottomDialog.this.bottomDialogMaxHeight > 1.0f) {
                                if (BottomDialog.this.bottomDialogMaxHeight > 1.0f) {
                                    f = (float) DialogImpl.this.boxBkg.getHeight();
                                    f2 = BottomDialog.this.bottomDialogMaxHeight;
                                }
                                DialogImpl.this.boxBkg.setPadding(0, 0, 0, (int) f5);
                            } else {
                                f = (float) DialogImpl.this.boxBkg.getHeight();
                                f2 = BottomDialog.this.bottomDialogMaxHeight * ((float) DialogImpl.this.boxBkg.getHeight());
                            }
                            f5 = f - f2;
                            DialogImpl.this.boxBkg.setPadding(0, 0, 0, (int) f5);
                        }
                        RelativeLayout relativeLayout = DialogImpl.this.boxBkg;
                        DialogImpl dialogImpl = DialogImpl.this;
                        float f6 = ((float) dialogImpl.boxRoot.getUnsafePlace().top) + f5;
                        dialogImpl.bkgEnterAimY = f6;
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "y", new float[]{(float) BottomDialog.this.getRootFrameLayout().getMeasuredHeight(), f6});
                        ofFloat.setDuration(enterAnimationDuration);
                        ofFloat.setAutoCancel(true);
                        ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
                        ofFloat.start();
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat2.setDuration(enterAnimationDuration);
                        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            }
                        });
                        ofFloat2.start();
                    }

                    public void doExitAnim(BottomDialog bottomDialog, ViewGroup viewGroup) {
                        long exitAnimationDuration = DialogImpl.this.getExitAnimationDuration();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DialogImpl.this.boxBkg, "y", new float[]{DialogImpl.this.boxBkg.getY(), (float) DialogImpl.this.boxBkg.getHeight()});
                        ofFloat.setDuration(exitAnimationDuration);
                        ofFloat.start();
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                        ofFloat2.setDuration(exitAnimationDuration);
                        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            }
                        });
                        ofFloat2.start();
                    }
                };
            }
            return BottomDialog.this.dialogXAnimImpl;
        }

        public long getExitAnimationDuration() {
            return BottomDialog.this.exitAnimDuration != -1 ? BottomDialog.this.exitAnimDuration : BottomDialog.overrideExitDuration >= 0 ? (long) BottomDialog.overrideExitDuration : 300;
        }

        public long getEnterAnimationDuration() {
            return BottomDialog.this.enterAnimDuration >= 0 ? BottomDialog.this.enterAnimDuration : BottomDialog.overrideEnterDuration >= 0 ? (long) BottomDialog.overrideEnterDuration : 300;
        }

        public BottomDialogTouchEventInterceptor getBottomDialogTouchEventInterceptor() {
            return this.bottomDialogTouchEventInterceptor;
        }
    }

    public void refreshUI() {
        if (getDialogImpl() != null) {
            runOnMain(new Runnable() {
                public void run() {
                    if (BottomDialog.this.dialogImpl != null) {
                        BottomDialog.this.dialogImpl.refreshView();
                    }
                }
            });
        }
    }

    public void dismiss() {
        runOnMain(new Runnable() {
            public void run() {
                if (BottomDialog.this.dialogImpl != null) {
                    BottomDialog.this.dialogImpl.doDismiss((View) null);
                }
            }
        });
    }

    public DialogLifecycleCallback<BottomDialog> getDialogLifecycleCallback() {
        DialogLifecycleCallback<BottomDialog> dialogLifecycleCallback2 = this.dialogLifecycleCallback;
        return dialogLifecycleCallback2 == null ? new DialogLifecycleCallback<BottomDialog>() {
        } : dialogLifecycleCallback2;
    }

    public BottomDialog setDialogLifecycleCallback(DialogLifecycleCallback<BottomDialog> dialogLifecycleCallback2) {
        this.dialogLifecycleCallback = dialogLifecycleCallback2;
        if (this.isShow) {
            dialogLifecycleCallback2.onShow(this.me);
        }
        return this;
    }

    public OnBackPressedListener<BottomDialog> getOnBackPressedListener() {
        return this.onBackPressedListener;
    }

    public BottomDialog setOnBackPressedListener(OnBackPressedListener<BottomDialog> onBackPressedListener2) {
        this.onBackPressedListener = onBackPressedListener2;
        refreshUI();
        return this;
    }

    public BottomDialog setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public BottomDialog setTheme(DialogX.THEME theme) {
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

    public BottomDialog setCancelable(boolean z) {
        this.privateCancelable = z ? BaseDialog.BOOLEAN.TRUE : BaseDialog.BOOLEAN.FALSE;
        refreshUI();
        return this;
    }

    public DialogImpl getDialogImpl() {
        return this.dialogImpl;
    }

    public CharSequence getTitle() {
        return this.title;
    }

    public BottomDialog setTitle(CharSequence charSequence) {
        this.title = charSequence;
        refreshUI();
        return this;
    }

    public BottomDialog setTitle(int i) {
        this.title = getString(i);
        refreshUI();
        return this;
    }

    public CharSequence getMessage() {
        return this.message;
    }

    public BottomDialog setMessage(CharSequence charSequence) {
        this.message = charSequence;
        refreshUI();
        return this;
    }

    public BottomDialog setMessage(int i) {
        this.message = getString(i);
        refreshUI();
        return this;
    }

    public CharSequence getCancelButton() {
        return this.cancelText;
    }

    public BottomDialog setCancelButton(CharSequence charSequence) {
        this.cancelText = charSequence;
        refreshUI();
        return this;
    }

    public BottomDialog setCancelButton(int i) {
        this.cancelText = getString(i);
        refreshUI();
        return this;
    }

    public BottomDialog setCancelButton(OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.cancelButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    public BottomDialog setCancelButton(CharSequence charSequence, OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.cancelText = charSequence;
        this.cancelButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public BottomDialog setCancelButton(int i, OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.cancelText = getString(i);
        this.cancelButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public BottomDialog setCustomView(OnBindView<BottomDialog> onBindView2) {
        this.onBindView = onBindView2;
        refreshUI();
        return this;
    }

    public View getCustomView() {
        OnBindView<BottomDialog> onBindView2 = this.onBindView;
        if (onBindView2 == null) {
            return null;
        }
        return onBindView2.getCustomView();
    }

    public BottomDialog removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public boolean isAllowInterceptTouch() {
        if (this.style.overrideBottomDialogRes() != null && this.allowInterceptTouch && this.style.overrideBottomDialogRes().touchSlide()) {
            return true;
        }
        return false;
    }

    public BottomDialog setAllowInterceptTouch(boolean z) {
        this.allowInterceptTouch = z;
        return this;
    }

    public OnDialogButtonClickListener<BottomDialog> getCancelButtonClickListener() {
        return (OnDialogButtonClickListener) this.cancelButtonClickListener;
    }

    public BottomDialog setCancelButtonClickListener(OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.cancelButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    public TextInfo getTitleTextInfo() {
        return this.titleTextInfo;
    }

    public BottomDialog setTitleTextInfo(TextInfo textInfo) {
        this.titleTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public TextInfo getMessageTextInfo() {
        return this.messageTextInfo;
    }

    public BottomDialog setMessageTextInfo(TextInfo textInfo) {
        this.messageTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public TextInfo getCancelTextInfo() {
        return this.cancelTextInfo;
    }

    public BottomDialog setCancelTextInfo(TextInfo textInfo) {
        this.cancelTextInfo = textInfo;
        refreshUI();
        return this;
    }

    public TextInfo getOkTextInfo() {
        return this.okTextInfo;
    }

    public BottomDialog setOkTextInfo(TextInfo textInfo) {
        this.okTextInfo = textInfo;
        return this;
    }

    public TextInfo getOtherTextInfo() {
        return this.otherTextInfo;
    }

    public BottomDialog setOtherTextInfo(TextInfo textInfo) {
        this.otherTextInfo = textInfo;
        return this;
    }

    public int getBackgroundColor() {
        return this.backgroundColor.intValue();
    }

    public BottomDialog setBackgroundColor(int i) {
        this.backgroundColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public BottomDialog setBackgroundColorRes(int i) {
        this.backgroundColor = Integer.valueOf(getColor(i));
        refreshUI();
        return this;
    }

    public CharSequence getOkButton() {
        return this.okText;
    }

    public BottomDialog setOkButton(CharSequence charSequence) {
        this.okText = charSequence;
        refreshUI();
        return this;
    }

    public BottomDialog setOkButton(int i) {
        this.okText = getString(i);
        refreshUI();
        return this;
    }

    public BottomDialog setOkButton(OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.okButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    public BottomDialog setOkButton(CharSequence charSequence, OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.okText = charSequence;
        this.okButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public BottomDialog setOkButton(int i, OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.okText = getString(i);
        this.okButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public CharSequence getOtherButton() {
        return this.otherText;
    }

    public BottomDialog setOtherButton(CharSequence charSequence) {
        this.otherText = charSequence;
        refreshUI();
        return this;
    }

    public BottomDialog setOtherButton(int i) {
        this.otherText = getString(i);
        refreshUI();
        return this;
    }

    public BottomDialog setOtherButton(OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.otherButtonClickListener = onDialogButtonClickListener;
        return this;
    }

    public BottomDialog setOtherButton(CharSequence charSequence, OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.otherText = charSequence;
        this.otherButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public BottomDialog setOtherButton(int i, OnDialogButtonClickListener<BottomDialog> onDialogButtonClickListener) {
        this.otherText = getString(i);
        this.otherButtonClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public BottomDialog setMaskColor(int i) {
        this.maskColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public long getEnterAnimDuration() {
        return this.enterAnimDuration;
    }

    public BottomDialog setEnterAnimDuration(long j) {
        this.enterAnimDuration = j;
        return this;
    }

    public long getExitAnimDuration() {
        return this.exitAnimDuration;
    }

    public BottomDialog setExitAnimDuration(long j) {
        this.exitAnimDuration = j;
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
        if (getDialogImpl().boxList != null) {
            getDialogImpl().boxList.removeAllViews();
        }
        int i = isLightTheme() ? R.layout.layout_dialogx_bottom_material : R.layout.layout_dialogx_bottom_material_dark;
        if (this.style.overrideBottomDialogRes() != null) {
            i = this.style.overrideBottomDialogRes().overrideDialogLayout(isLightTheme());
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
                    if (BottomDialog.this.getDialogView() != null) {
                        BottomDialog.this.getDialogView().setVisibility(8);
                    }
                }
            }, getDialogImpl().getExitAnimationDuration());
        }
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
        dismiss();
    }

    public float getBottomDialogMaxHeight() {
        return this.bottomDialogMaxHeight;
    }

    public BottomDialog setBottomDialogMaxHeight(float f) {
        this.bottomDialogMaxHeight = f;
        return this;
    }

    public BottomDialog setMaxWidth(int i) {
        this.maxWidth = i;
        refreshUI();
        return this;
    }

    public BottomDialog setMaxHeight(int i) {
        this.maxHeight = i;
        refreshUI();
        return this;
    }

    public BottomDialog setMinHeight(int i) {
        this.minHeight = i;
        refreshUI();
        return this;
    }

    public BottomDialog setMinWidth(int i) {
        this.minWidth = i;
        refreshUI();
        return this;
    }

    public BottomDialog setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public boolean isBkgInterceptTouch() {
        return this.bkgInterceptTouch;
    }

    public BottomDialog setBkgInterceptTouch(boolean z) {
        this.bkgInterceptTouch = z;
        return this;
    }

    public OnBackgroundMaskClickListener<BottomDialog> getOnBackgroundMaskClickListener() {
        return this.onBackgroundMaskClickListener;
    }

    public BottomDialog setOnBackgroundMaskClickListener(OnBackgroundMaskClickListener<BottomDialog> onBackgroundMaskClickListener2) {
        this.onBackgroundMaskClickListener = onBackgroundMaskClickListener2;
        return this;
    }

    public BottomDialog setRadius(float f) {
        this.backgroundRadius = f;
        refreshUI();
        return this;
    }

    public float getRadius() {
        return this.backgroundRadius;
    }

    public Drawable getTitleIcon() {
        return this.titleIcon;
    }

    public BottomDialog setTitleIcon(Bitmap bitmap) {
        this.titleIcon = new BitmapDrawable(getResources(), bitmap);
        refreshUI();
        return this;
    }

    public BottomDialog setTitleIcon(int i) {
        this.titleIcon = getResources().getDrawable(i);
        refreshUI();
        return this;
    }

    public BottomDialog setTitleIcon(Drawable drawable) {
        this.titleIcon = drawable;
        refreshUI();
        return this;
    }

    public DialogXAnimInterface<BottomDialog> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public BottomDialog setDialogXAnimImpl(DialogXAnimInterface<BottomDialog> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public BottomDialog setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public BottomDialog setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public BaseDialog.BUTTON_SELECT_RESULT getButtonSelectResult() {
        return this.buttonSelectResult;
    }

    public boolean isBottomNonSafetyAreaBySelf() {
        return this.bottomNonSafetyAreaBySelf;
    }

    public BottomDialog setBottomNonSafetyAreaBySelf(boolean z) {
        this.bottomNonSafetyAreaBySelf = z;
        return this;
    }

    public boolean isScrollableWhenContentLargeThanVisibleRange() {
        return this.scrollableWhenContentLargeThanVisibleRange;
    }

    public BottomDialog setScrollableWhenContentLargeThanVisibleRange(boolean z) {
        this.scrollableWhenContentLargeThanVisibleRange = z;
        return this;
    }
}
