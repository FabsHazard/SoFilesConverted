package com.microtech.aidexx.views.dialog.bottom;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.microtech.aidexx.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u0018\u0010%\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020#H\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\bH\u0002J\u000e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0015J\u0014\u0010/\u001a\u0004\u0018\u00010\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u00100\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0015H\u0014J\u0006\u00101\u001a\u00020#J\u0016\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0015J\u0010\u00101\u001a\u00020#2\b\u00102\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/microtech/aidexx/views/dialog/bottom/BaseBottomPopupView;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animGravity", "", "clickView", "Landroid/view/View;", "getClickView", "()Landroid/view/View;", "setClickView", "(Landroid/view/View;)V", "contentContainer", "Landroid/view/ViewGroup;", "getContentContainer", "()Landroid/view/ViewGroup;", "setContentContainer", "(Landroid/view/ViewGroup;)V", "decorView", "dismissing", "", "inAnim", "Landroid/view/animation/Animation;", "isAnim", "isShowing", "onCancelableTouchListener", "Landroid/view/View$OnTouchListener;", "onDismissListener", "Lcom/microtech/aidexx/views/dialog/bottom/OnDismissListener;", "onKeyBackListener", "Landroid/view/View$OnKeyListener;", "outAnim", "rootView", "dismiss", "", "dismissImmediately", "findViewById", "T", "id", "getInAnimation", "getOutAnimation", "initView", "onAttached", "view", "setKeyBackCancelable", "isCancelable", "setOnDismissListener", "setOutSideCancelable", "show", "v", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseBottomPopupView.kt */
public abstract class BaseBottomPopupView {
    private int animGravity = 80;
    private View clickView;
    protected ViewGroup contentContainer;
    private final Context context;
    private ViewGroup decorView;
    private boolean dismissing;
    private Animation inAnim;
    private boolean isAnim = true;
    private boolean isShowing;
    private final View.OnTouchListener onCancelableTouchListener;
    private OnDismissListener onDismissListener;
    private final View.OnKeyListener onKeyBackListener;
    private Animation outAnim;
    private ViewGroup rootView;

    public BaseBottomPopupView(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        initView();
        this.onKeyBackListener = new BaseBottomPopupView$$ExternalSyntheticLambda0(this);
        this.onCancelableTouchListener = new BaseBottomPopupView$$ExternalSyntheticLambda1(this);
    }

    /* access modifiers changed from: protected */
    public final ViewGroup getContentContainer() {
        ViewGroup viewGroup = this.contentContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setContentContainer(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.contentContainer = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final View getClickView() {
        return this.clickView;
    }

    /* access modifiers changed from: protected */
    public final void setClickView(View view) {
        this.clickView = view;
    }

    private final void initView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.context);
        Context context2 = this.context;
        Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
        View decorView2 = ((Activity) context2).getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.decorView = (ViewGroup) decorView2;
        int i = R.layout.layout_basepickerview;
        ViewGroup viewGroup = this.decorView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorView");
            viewGroup = null;
        }
        View inflate = from.inflate(i, viewGroup, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup3 = (ViewGroup) inflate;
        this.rootView = viewGroup3;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup3 = null;
        }
        viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup viewGroup4 = this.rootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            viewGroup2 = viewGroup4;
        }
        View findViewById = viewGroup2.findViewById(R.id.content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setContentContainer((ViewGroup) findViewById);
        getContentContainer().setLayoutParams(layoutParams);
        this.inAnim = getInAnimation();
        this.outAnim = getOutAnimation();
    }

    public final void show(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "v");
        this.clickView = view;
        this.isAnim = z;
        show();
    }

    public final void show() {
        if (!isShowing()) {
            this.isShowing = true;
            ViewGroup viewGroup = this.rootView;
            ViewGroup viewGroup2 = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
                viewGroup = null;
            }
            onAttached(viewGroup);
            ViewGroup viewGroup3 = this.rootView;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            } else {
                viewGroup2 = viewGroup3;
            }
            viewGroup2.requestFocus();
        }
    }

    public final void show(View view) {
        this.clickView = view;
        show();
    }

    public final void setKeyBackCancelable(boolean z) {
        ViewGroup viewGroup = this.rootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup = null;
        }
        viewGroup.setFocusable(z);
        ViewGroup viewGroup3 = this.rootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup3 = null;
        }
        viewGroup3.setFocusableInTouchMode(z);
        if (z) {
            ViewGroup viewGroup4 = this.rootView;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            } else {
                viewGroup2 = viewGroup4;
            }
            viewGroup2.setOnKeyListener(this.onKeyBackListener);
            return;
        }
        ViewGroup viewGroup5 = this.rootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup5 = null;
        }
        viewGroup5.setOnKeyListener((View.OnKeyListener) null);
    }

    private final void onAttached(View view) {
        ViewGroup viewGroup = this.decorView;
        Animation animation = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorView");
            viewGroup = null;
        }
        viewGroup.addView(view);
        if (this.isAnim) {
            ViewGroup contentContainer2 = getContentContainer();
            Animation animation2 = this.inAnim;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inAnim");
            } else {
                animation = animation2;
            }
            contentContainer2.startAnimation(animation);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean onKeyBackListener$lambda$0(BaseBottomPopupView baseBottomPopupView, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(baseBottomPopupView, "this$0");
        if (i != 4 || keyEvent.getAction() != 0 || !baseBottomPopupView.isShowing()) {
            return false;
        }
        baseBottomPopupView.dismiss();
        return true;
    }

    public final boolean isShowing() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup = null;
        }
        return viewGroup.getParent() != null || this.isShowing;
    }

    public final void dismiss() {
        if (!this.dismissing) {
            if (this.isAnim) {
                Animation animation = this.outAnim;
                Animation animation2 = null;
                if (animation == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("outAnim");
                    animation = null;
                }
                animation.setAnimationListener(new BaseBottomPopupView$dismiss$1(this));
                ViewGroup contentContainer2 = getContentContainer();
                Animation animation3 = this.outAnim;
                if (animation3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("outAnim");
                } else {
                    animation2 = animation3;
                }
                contentContainer2.startAnimation(animation2);
            } else {
                dismissImmediately();
            }
            this.dismissing = true;
        }
    }

    private final Animation getInAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, PickerViewAnimateUtil.getAnimationResource(this.animGravity, true));
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(...)");
        return loadAnimation;
    }

    private final Animation getOutAnimation() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, PickerViewAnimateUtil.getAnimationResource(this.animGravity, false));
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(...)");
        return loadAnimation;
    }

    public final void dismissImmediately() {
        ViewGroup viewGroup = this.decorView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorView");
            viewGroup = null;
        }
        viewGroup.post(new BaseBottomPopupView$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void dismissImmediately$lambda$1(BaseBottomPopupView baseBottomPopupView) {
        Intrinsics.checkNotNullParameter(baseBottomPopupView, "this$0");
        ViewGroup viewGroup = baseBottomPopupView.decorView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decorView");
            viewGroup = null;
        }
        ViewGroup viewGroup3 = baseBottomPopupView.rootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup.removeView(viewGroup2);
        baseBottomPopupView.isShowing = false;
        baseBottomPopupView.dismissing = false;
        OnDismissListener onDismissListener2 = baseBottomPopupView.onDismissListener;
        if (onDismissListener2 != null) {
            onDismissListener2.onDismiss(baseBottomPopupView);
        }
    }

    /* access modifiers changed from: protected */
    public BaseBottomPopupView setOutSideCancelable(boolean z) {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.outmost_container);
        if (z) {
            findViewById.setOnTouchListener(this.onCancelableTouchListener);
        } else {
            findViewById.setOnTouchListener((View.OnTouchListener) null);
        }
        return this;
    }

    public <T> View findViewById(int i) {
        return getContentContainer().findViewById(i);
    }

    /* access modifiers changed from: private */
    public static final boolean onCancelableTouchListener$lambda$2(BaseBottomPopupView baseBottomPopupView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(baseBottomPopupView, "this$0");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        baseBottomPopupView.dismiss();
        return false;
    }

    public BaseBottomPopupView setOnDismissListener(OnDismissListener onDismissListener2) {
        this.onDismissListener = onDismissListener2;
        return this;
    }
}
