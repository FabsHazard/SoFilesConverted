package com.microtech.aidexx.ui.main.home.customerservice;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.pair.PairUtilKt;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.customerservice.MessageManager;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010:\u001a\u00020\tH\u0002J\b\u0010;\u001a\u00020\tH\u0002J\b\u0010<\u001a\u00020\tH\u0002J\b\u0010=\u001a\u00020\tH\u0002J\u0006\u0010>\u001a\u00020\u001cJ\u000e\u0010?\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010@\u001a\u00020\u0012H\u0002J0\u0010A\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020\t2\u0006\u0010F\u001a\u00020\tH\u0014J\u0018\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\t2\u0006\u0010I\u001a\u00020\tH\u0014J(\u0010J\u001a\u00020\u001c2\u0006\u0010K\u001a\u00020\t2\u0006\u0010L\u001a\u00020\t2\u0006\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\tH\u0014J\u0010\u0010O\u001a\u00020\u00122\u0006\u0010P\u001a\u00020QH\u0017J&\u0010R\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\t2\u0006\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\t2\u0006\u0010V\u001a\u00020\tJ\u0006\u0010W\u001a\u00020\u001cJ\u0006\u0010X\u001a\u00020\u001cJ\b\u0010Y\u001a\u00020\u001cH\u0002R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\"\u0010'\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020-X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006["}, d2 = {"Lcom/microtech/aidexx/ui/main/home/customerservice/CustomerServiceView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "child", "Landroid/widget/RelativeLayout;", "childRect", "Landroid/graphics/Rect;", "downX", "downY", "isConsume", "", "isInMotion", "isLongClick", "isMoving", "lastClickTime", "", "lastX", "lastY", "layoutRunnable", "Lkotlin/Function0;", "", "mContext", "mFrameRect", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "moveX", "moveY", "onClick", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "setOnClick", "(Lkotlin/jvm/functions/Function0;)V", "serviceImageView", "Landroid/widget/ImageView;", "getServiceImageView", "()Landroid/widget/ImageView;", "setServiceImageView", "(Landroid/widget/ImageView;)V", "timer", "Ljava/util/Timer;", "tvMessageCount", "Landroid/widget/TextView;", "getTvMessageCount", "()Landroid/widget/TextView;", "setTvMessageCount", "(Landroid/widget/TextView;)V", "getSavedBottom", "getSavedLeft", "getSavedRight", "getSavedTop", "hide", "init", "isFastClick", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "savePosition", "left", "top", "right", "bottom", "setMessageCount", "show", "store", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CustomerServiceView.kt */
public final class CustomerServiceView extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "CustomerServiceView";
    /* access modifiers changed from: private */
    public RelativeLayout child;
    private Rect childRect;
    /* access modifiers changed from: private */
    public int downX;
    /* access modifiers changed from: private */
    public int downY;
    private boolean isConsume;
    /* access modifiers changed from: private */
    public boolean isInMotion;
    /* access modifiers changed from: private */
    public boolean isLongClick;
    private boolean isMoving;
    private long lastClickTime;
    private int lastX;
    private int lastY;
    private final Function0<Unit> layoutRunnable;
    /* access modifiers changed from: private */
    public Context mContext;
    private Rect mFrameRect;
    public Handler mHandler;
    /* access modifiers changed from: private */
    public int moveX;
    /* access modifiers changed from: private */
    public int moveY;
    private Function0<Unit> onClick;
    public ImageView serviceImageView;
    private Timer timer;
    public TextView tvMessageCount;

    public final Function0<Unit> getOnClick() {
        return this.onClick;
    }

    public final void setOnClick(Function0<Unit> function0) {
        this.onClick = function0;
    }

    public final ImageView getServiceImageView() {
        ImageView imageView = this.serviceImageView;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serviceImageView");
        return null;
    }

    public final void setServiceImageView(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.serviceImageView = imageView;
    }

    public final TextView getTvMessageCount() {
        TextView textView = this.tvMessageCount;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvMessageCount");
        return null;
    }

    public final void setTvMessageCount(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvMessageCount = textView;
    }

    public final Handler getMHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        return null;
    }

    public final void setMHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mHandler = handler;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomerServiceView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomerServiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomerServiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.layoutRunnable = new CustomerServiceView$layoutRunnable$1(this);
        init(context);
    }

    public final void init(Context context) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(context, "context");
        setMHandler(new Handler(Looper.getMainLooper()));
        this.mContext = context;
        if (getChildCount() > 0) {
            removeAllViews();
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.child = relativeLayout;
        relativeLayout.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_customer_service));
        RelativeLayout relativeLayout2 = this.child;
        RelativeLayout relativeLayout3 = null;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout2 = null;
        }
        relativeLayout2.setLayoutParams(new LinearLayout.LayoutParams(DensityUtils.dp2px(50.0f), DensityUtils.dp2px(50.0f)));
        setServiceImageView(new ImageView(context));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DensityUtils.dp2px(30.0f), DensityUtils.dp2px(30.0f));
        layoutParams.addRule(13);
        ImageView serviceImageView2 = getServiceImageView();
        if (ThemeManager.INSTANCE.isLight()) {
            drawable = ContextCompat.getDrawable(context, R.drawable.ic_customer_service_light);
        } else {
            drawable = ContextCompat.getDrawable(context, R.drawable.ic_customer_service_dark);
        }
        serviceImageView2.setImageDrawable(drawable);
        getServiceImageView().setLayoutParams(layoutParams);
        RelativeLayout relativeLayout4 = this.child;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout4 = null;
        }
        relativeLayout4.addView(getServiceImageView());
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginEnd(DensityUtils.dp2px(10.0f));
        layoutParams2.topMargin = DensityUtils.dp2px(10.0f);
        layoutParams2.addRule(21);
        linearLayout.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout5 = this.child;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout5 = null;
        }
        relativeLayout5.addView(linearLayout);
        setTvMessageCount(new TextView(context));
        getTvMessageCount().setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        int dp2px = DensityUtils.dp2px(1.0f);
        getTvMessageCount().setPadding(dp2px, 0, dp2px, 0);
        getTvMessageCount().setLayoutParams(layoutParams3);
        getTvMessageCount().setTextColor(ContextCompat.getColor(context, R.color.white));
        getTvMessageCount().setTextSize(DensityUtils.sp2px(4.0f));
        getTvMessageCount().setBackground(ContextCompat.getDrawable(context, R.drawable.red_dot));
        getTvMessageCount().setText("0");
        getTvMessageCount().setVisibility(4);
        linearLayout.addView(getTvMessageCount());
        RelativeLayout relativeLayout6 = this.child;
        if (relativeLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
        } else {
            relativeLayout3 = relativeLayout6;
        }
        addView(relativeLayout3, 0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        measureChildren(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mFrameRect = new Rect(getLeft(), getTop(), getRight(), getBottom());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        RelativeLayout relativeLayout = null;
        if (getSavedLeft() == 0 && getSavedTop() == 0 && getSavedRight() == 0 && getSavedBottom() == 0) {
            RelativeLayout relativeLayout2 = this.child;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("child");
            } else {
                relativeLayout = relativeLayout2;
            }
            relativeLayout.layout(getRight() - DensityUtils.dp2px(50.0f), DensityUtils.dp2px(100.0f), getRight(), DensityUtils.dp2px(100.0f) + DensityUtils.dp2px(50.0f));
            return;
        }
        RelativeLayout relativeLayout3 = this.child;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
        } else {
            relativeLayout = relativeLayout3;
        }
        relativeLayout.layout(getSavedLeft(), getSavedTop(), getSavedRight(), getSavedBottom());
    }

    private final boolean isFastClick() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime >= 1000) {
            this.lastClickTime = currentTimeMillis;
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.util.Timer} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [android.widget.RelativeLayout] */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5, types: [android.widget.RelativeLayout] */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r6v7, types: [android.widget.RelativeLayout] */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v9, types: [android.widget.RelativeLayout] */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 0
            r12.moveX = r0
            r12.moveY = r0
            int r1 = r13.getActionMasked()
            float r2 = r13.getRawX()
            int r2 = (int) r2
            float r3 = r13.getRawY()
            int r3 = (int) r3
            r4 = 1
            java.lang.String r5 = "child"
            r6 = 0
            if (r1 == 0) goto L_0x01d3
            if (r1 == r4) goto L_0x0169
            r7 = 2
            if (r1 == r7) goto L_0x0025
            goto L_0x023f
        L_0x0025:
            float r1 = r13.getX()
            int r1 = (int) r1
            r12.moveX = r1
            float r13 = r13.getY()
            int r13 = (int) r13
            r12.moveY = r13
            int r13 = r12.lastX
            int r13 = r2 - r13
            int r1 = r12.lastY
            int r1 = r3 - r1
            android.graphics.Rect r7 = new android.graphics.Rect
            android.widget.RelativeLayout r8 = r12.child
            if (r8 != 0) goto L_0x0045
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r8 = r6
        L_0x0045:
            int r8 = r8.getLeft()
            int r8 = r8 + r13
            android.widget.RelativeLayout r9 = r12.child
            if (r9 != 0) goto L_0x0052
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r9 = r6
        L_0x0052:
            int r9 = r9.getTop()
            int r9 = r9 + r1
            android.widget.RelativeLayout r10 = r12.child
            if (r10 != 0) goto L_0x005f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r10 = r6
        L_0x005f:
            int r10 = r10.getRight()
            int r10 = r10 + r13
            android.widget.RelativeLayout r11 = r12.child
            if (r11 != 0) goto L_0x006c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r11 = r6
        L_0x006c:
            int r11 = r11.getBottom()
            int r11 = r11 + r1
            r7.<init>(r8, r9, r10, r11)
            boolean r8 = r12.isConsume
            if (r8 == 0) goto L_0x0163
            boolean r8 = r12.isLongClick
            if (r8 == 0) goto L_0x0163
            r12.isMoving = r4
            android.graphics.Rect r4 = r12.mFrameRect
            if (r4 != 0) goto L_0x0088
            java.lang.String r4 = "mFrameRect"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r4 = r6
        L_0x0088:
            boolean r4 = r4.contains(r7)
            if (r4 == 0) goto L_0x00d0
            android.widget.RelativeLayout r0 = r12.child
            if (r0 != 0) goto L_0x0096
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r0 = r6
        L_0x0096:
            android.widget.RelativeLayout r4 = r12.child
            if (r4 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r4 = r6
        L_0x009e:
            int r4 = r4.getLeft()
            int r4 = r4 + r13
            android.widget.RelativeLayout r7 = r12.child
            if (r7 != 0) goto L_0x00ab
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r7 = r6
        L_0x00ab:
            int r7 = r7.getTop()
            int r7 = r7 + r1
            android.widget.RelativeLayout r8 = r12.child
            if (r8 != 0) goto L_0x00b8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r8 = r6
        L_0x00b8:
            int r8 = r8.getRight()
            int r8 = r8 + r13
            android.widget.RelativeLayout r13 = r12.child
            if (r13 != 0) goto L_0x00c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x00c6
        L_0x00c5:
            r6 = r13
        L_0x00c6:
            int r13 = r6.getBottom()
            int r13 = r13 + r1
            r0.layout(r4, r7, r8, r13)
            goto L_0x0163
        L_0x00d0:
            android.widget.RelativeLayout r13 = r12.child
            if (r13 != 0) goto L_0x00d8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r13 = r6
        L_0x00d8:
            int r13 = r13.getRight()
            int r1 = r12.getRight()
            if (r13 <= r1) goto L_0x011c
            android.widget.RelativeLayout r13 = r12.child
            if (r13 != 0) goto L_0x00ea
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r13 = r6
        L_0x00ea:
            int r0 = r12.getRight()
            android.widget.RelativeLayout r1 = r12.child
            if (r1 != 0) goto L_0x00f6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r6
        L_0x00f6:
            int r1 = r1.getWidth()
            int r0 = r0 - r1
            android.widget.RelativeLayout r1 = r12.child
            if (r1 != 0) goto L_0x0103
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r6
        L_0x0103:
            int r1 = r1.getTop()
            int r4 = r12.getRight()
            android.widget.RelativeLayout r7 = r12.child
            if (r7 != 0) goto L_0x0113
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0114
        L_0x0113:
            r6 = r7
        L_0x0114:
            int r5 = r6.getBottom()
            r13.layout(r0, r1, r4, r5)
            goto L_0x0163
        L_0x011c:
            android.widget.RelativeLayout r13 = r12.child
            if (r13 != 0) goto L_0x0124
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r13 = r6
        L_0x0124:
            int r13 = r13.getLeft()
            int r1 = r12.getLeft()
            if (r13 >= r1) goto L_0x0163
            android.widget.RelativeLayout r13 = r12.child
            if (r13 != 0) goto L_0x0136
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r13 = r6
        L_0x0136:
            android.widget.RelativeLayout r1 = r12.child
            if (r1 != 0) goto L_0x013e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r6
        L_0x013e:
            int r1 = r1.getTop()
            int r4 = r12.getLeft()
            android.widget.RelativeLayout r7 = r12.child
            if (r7 != 0) goto L_0x014e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r7 = r6
        L_0x014e:
            int r7 = r7.getWidth()
            int r4 = r4 + r7
            android.widget.RelativeLayout r7 = r12.child
            if (r7 != 0) goto L_0x015b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x015c
        L_0x015b:
            r6 = r7
        L_0x015c:
            int r5 = r6.getBottom()
            r13.layout(r0, r1, r4, r5)
        L_0x0163:
            r12.lastX = r2
            r12.lastY = r3
            goto L_0x023f
        L_0x0169:
            float r1 = r13.getX()
            int r1 = (int) r1
            float r13 = r13.getY()
            int r13 = (int) r13
            r12.isMoving = r0
            boolean r2 = r12.isLongClick
            if (r2 == 0) goto L_0x0180
            boolean r2 = r12.isInMotion
            if (r2 != 0) goto L_0x0180
            r12.store()
        L_0x0180:
            boolean r2 = r12.isConsume
            if (r2 == 0) goto L_0x01c1
            boolean r2 = r12.isLongClick
            if (r2 != 0) goto L_0x01c1
            int r2 = r12.downX
            int r1 = r1 - r2
            int r1 = java.lang.Math.abs(r1)
            r2 = 20
            if (r1 >= r2) goto L_0x01c1
            int r1 = r12.downY
            int r13 = r13 - r1
            int r13 = java.lang.Math.abs(r13)
            if (r13 >= r2) goto L_0x01c1
            android.graphics.Rect r13 = r12.childRect
            if (r13 != 0) goto L_0x01a6
            java.lang.String r13 = "childRect"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            r13 = r6
        L_0x01a6:
            int r1 = r12.downX
            int r2 = r12.downY
            boolean r13 = r13.contains(r1, r2)
            if (r13 == 0) goto L_0x01c1
            boolean r13 = r12.isFastClick()
            if (r13 == 0) goto L_0x01c1
            boolean r13 = r12.isInMotion
            if (r13 != 0) goto L_0x01c1
            kotlin.jvm.functions.Function0<kotlin.Unit> r13 = r12.onClick
            if (r13 == 0) goto L_0x01c1
            r13.invoke()
        L_0x01c1:
            java.util.Timer r13 = r12.timer
            if (r13 != 0) goto L_0x01cb
            java.lang.String r13 = "timer"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r13)
            goto L_0x01cc
        L_0x01cb:
            r6 = r13
        L_0x01cc:
            r6.cancel()
            r12.isLongClick = r0
            goto L_0x023f
        L_0x01d3:
            float r1 = r13.getX()
            int r1 = (int) r1
            r12.downX = r1
            float r13 = r13.getY()
            int r13 = (int) r13
            r12.downY = r13
            r12.lastX = r2
            r12.lastY = r3
            android.widget.RelativeLayout r13 = r12.child
            if (r13 != 0) goto L_0x01ed
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r13 = r6
        L_0x01ed:
            int r13 = r13.getLeft()
            android.widget.RelativeLayout r1 = r12.child
            if (r1 != 0) goto L_0x01f9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r1 = r6
        L_0x01f9:
            int r1 = r1.getTop()
            android.widget.RelativeLayout r2 = r12.child
            if (r2 != 0) goto L_0x0205
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r2 = r6
        L_0x0205:
            int r2 = r2.getRight()
            android.widget.RelativeLayout r3 = r12.child
            if (r3 != 0) goto L_0x0211
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x0212
        L_0x0211:
            r6 = r3
        L_0x0212:
            int r3 = r6.getBottom()
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>(r13, r1, r2, r3)
            r12.childRect = r5
            int r13 = r12.downX
            int r1 = r12.downY
            boolean r13 = r5.contains(r13, r1)
            if (r13 == 0) goto L_0x023d
            r12.isConsume = r4
            java.util.Timer r13 = new java.util.Timer
            r13.<init>()
            r12.timer = r13
            com.microtech.aidexx.ui.main.home.customerservice.CustomerServiceView$onTouchEvent$1 r0 = new com.microtech.aidexx.ui.main.home.customerservice.CustomerServiceView$onTouchEvent$1
            r0.<init>(r12)
            java.util.TimerTask r0 = (java.util.TimerTask) r0
            r1 = 500(0x1f4, double:2.47E-321)
            r13.schedule(r0, r1)
            goto L_0x023f
        L_0x023d:
            r12.isConsume = r0
        L_0x023f:
            boolean r13 = r12.isConsume
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.customerservice.CustomerServiceView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private final void store() {
        RelativeLayout relativeLayout = this.child;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout = null;
        }
        if (relativeLayout.getRight() < getRight()) {
            RelativeLayout relativeLayout3 = this.child;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("child");
                relativeLayout3 = null;
            }
            if (relativeLayout3.getLeft() >= getLeft()) {
                this.isInMotion = true;
                RelativeLayout relativeLayout4 = this.child;
                if (relativeLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("child");
                    relativeLayout4 = null;
                }
                int left = relativeLayout4.getLeft();
                int width = getWidth() / 2;
                RelativeLayout relativeLayout5 = this.child;
                if (relativeLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("child");
                    relativeLayout5 = null;
                }
                if (left < width - (relativeLayout5.getWidth() / 2)) {
                    AnimatorSet animatorSet = new AnimatorSet();
                    RelativeLayout relativeLayout6 = this.child;
                    if (relativeLayout6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("child");
                        relativeLayout6 = null;
                    }
                    float right = (float) relativeLayout6.getRight();
                    RelativeLayout relativeLayout7 = this.child;
                    if (relativeLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("child");
                    } else {
                        relativeLayout2 = relativeLayout7;
                    }
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{right, (float) relativeLayout2.getWidth()});
                    ofFloat.setDuration(500);
                    ofFloat.addUpdateListener(new CustomerServiceView$$ExternalSyntheticLambda1(this));
                    animatorSet.playTogether(new Animator[]{ofFloat});
                    animatorSet.addListener(new CustomerServiceView$store$2(this));
                    animatorSet.start();
                    return;
                }
                AnimatorSet animatorSet2 = new AnimatorSet();
                RelativeLayout relativeLayout8 = this.child;
                if (relativeLayout8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("child");
                    relativeLayout8 = null;
                }
                float left2 = (float) relativeLayout8.getLeft();
                int width2 = getWidth();
                RelativeLayout relativeLayout9 = this.child;
                if (relativeLayout9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("child");
                } else {
                    relativeLayout2 = relativeLayout9;
                }
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{left2, (float) (width2 - relativeLayout2.getWidth())});
                ofFloat2.setDuration(500);
                ofFloat2.addUpdateListener(new CustomerServiceView$$ExternalSyntheticLambda2(this));
                animatorSet2.playTogether(new Animator[]{ofFloat2});
                animatorSet2.addListener(new CustomerServiceView$store$4(this));
                animatorSet2.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void store$lambda$0(CustomerServiceView customerServiceView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(customerServiceView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        RelativeLayout relativeLayout = customerServiceView.child;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout = null;
        }
        RelativeLayout relativeLayout3 = customerServiceView.child;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout3 = null;
        }
        int width = (int) (floatValue - ((float) relativeLayout3.getWidth()));
        RelativeLayout relativeLayout4 = customerServiceView.child;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout4 = null;
        }
        int top = relativeLayout4.getTop();
        int i = (int) floatValue;
        RelativeLayout relativeLayout5 = customerServiceView.child;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
        } else {
            relativeLayout2 = relativeLayout5;
        }
        relativeLayout.layout(width, top, i, relativeLayout2.getBottom());
    }

    /* access modifiers changed from: private */
    public static final void store$lambda$1(CustomerServiceView customerServiceView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(customerServiceView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        RelativeLayout relativeLayout = customerServiceView.child;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout = null;
        }
        int i = (int) floatValue;
        RelativeLayout relativeLayout3 = customerServiceView.child;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout3 = null;
        }
        int top = relativeLayout3.getTop();
        RelativeLayout relativeLayout4 = customerServiceView.child;
        if (relativeLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout4 = null;
        }
        int width = (int) (floatValue + ((float) relativeLayout4.getWidth()));
        RelativeLayout relativeLayout5 = customerServiceView.child;
        if (relativeLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
        } else {
            relativeLayout2 = relativeLayout5;
        }
        relativeLayout.layout(i, top, width, relativeLayout2.getBottom());
    }

    public final void savePosition(int i, int i2, int i3, int i4) {
        MmkvManager.INSTANCE.saveCustomerIconPosition(i, i2, i3, i4);
    }

    private final int getSavedLeft() {
        return MmkvManager.INSTANCE.getCustomerServiceIconLeft();
    }

    private final int getSavedTop() {
        return MmkvManager.INSTANCE.getCustomerServiceIconTop();
    }

    private final int getSavedRight() {
        return MmkvManager.INSTANCE.getCustomerServiceIconRight();
    }

    private final int getSavedBottom() {
        return MmkvManager.INSTANCE.getCustomerServiceIconBottom();
    }

    public final void setMessageCount() {
        CharSequence messageCountStr = MessageManager.Companion.instance().getMessageCountStr();
        if (messageCountStr.length() == 0) {
            getTvMessageCount().setVisibility(4);
        } else {
            getTvMessageCount().setText(messageCountStr);
            getTvMessageCount().setVisibility(0);
        }
        getMHandler().removeCallbacksAndMessages((Object) null);
        getMHandler().postDelayed(new CustomerServiceView$$ExternalSyntheticLambda0(this.layoutRunnable), PairUtilKt.DELAY_A_WHILE);
    }

    /* access modifiers changed from: private */
    public static final void setMessageCount$lambda$2(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public final void hide() {
        RelativeLayout relativeLayout = this.child;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(8);
    }

    public final void show() {
        RelativeLayout relativeLayout = this.child;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("child");
            relativeLayout = null;
        }
        relativeLayout.setVisibility(0);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/customerservice/CustomerServiceView$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CustomerServiceView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
