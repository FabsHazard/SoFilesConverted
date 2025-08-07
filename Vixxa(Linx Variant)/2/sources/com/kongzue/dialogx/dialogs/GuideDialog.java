package com.kongzue.dialogx.dialogs;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.internal.view.SupportMenu;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.interfaces.DialogLifecycleCallback;
import com.kongzue.dialogx.interfaces.DialogXAnimInterface;
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.OnBackPressedListener;
import com.kongzue.dialogx.interfaces.OnBackgroundMaskClickListener;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.interfaces.OnDialogButtonClickListener;
import java.util.Arrays;

public class GuideDialog extends CustomDialog {
    int[] baseViewLocCache;
    protected int[] baseViewLocationCoordinateCompensation;
    protected Integer maskColor;
    protected OnDialogButtonClickListener<GuideDialog> onStageLightPathClickListener;
    protected float stageLightFilletRadius;
    Paint stageLightPaint;
    View stageLightPathStub;
    protected STAGE_LIGHT_TYPE stageLightType;
    protected Drawable tipImage;

    public enum STAGE_LIGHT_TYPE {
        RECTANGLE,
        SQUARE_OUTSIDE,
        SQUARE_INSIDE,
        CIRCLE_OUTSIDE,
        CIRCLE_INSIDE
    }

    protected GuideDialog() {
        this.stageLightType = STAGE_LIGHT_TYPE.CIRCLE_OUTSIDE;
        this.maskColor = null;
        this.baseViewLocationCoordinateCompensation = new int[4];
        this.enterAnimResId = R.anim.anim_dialogx_alpha_enter;
        this.exitAnimResId = R.anim.anim_dialogx_default_exit;
        this.alignViewGravity = 81;
    }

    public static GuideDialog build() {
        return new GuideDialog();
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type) {
        this();
        baseView(view);
        this.stageLightType = stage_light_type;
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type, OnBindView<CustomDialog> onBindView, int i) {
        this();
        baseView(view);
        this.stageLightType = stage_light_type;
        this.onBindView = onBindView;
        this.alignViewGravity = i;
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type, int i, int i2) {
        this();
        baseView(view);
        this.tipImage = getResources().getDrawable(i);
        this.stageLightType = stage_light_type;
        this.alignViewGravity = i2;
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type, Bitmap bitmap, int i) {
        this();
        baseView(view);
        this.tipImage = new BitmapDrawable(getResources(), bitmap);
        this.stageLightType = stage_light_type;
        this.alignViewGravity = i;
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type, Drawable drawable, int i) {
        this();
        baseView(view);
        this.tipImage = drawable;
        this.stageLightType = stage_light_type;
        this.alignViewGravity = i;
    }

    public GuideDialog(int i) {
        this();
        this.tipImage = getResources().getDrawable(i);
    }

    public GuideDialog(Bitmap bitmap) {
        this();
        this.tipImage = new BitmapDrawable(getResources(), bitmap);
    }

    public GuideDialog(Drawable drawable) {
        this();
        this.tipImage = drawable;
    }

    public GuideDialog(int i, CustomDialog.ALIGN align) {
        this();
        this.tipImage = getResources().getDrawable(i);
        this.align = align;
    }

    public GuideDialog(Bitmap bitmap, CustomDialog.ALIGN align) {
        this();
        this.tipImage = new BitmapDrawable(getResources(), bitmap);
        this.align = align;
    }

    public GuideDialog(Drawable drawable, CustomDialog.ALIGN align) {
        this();
        this.tipImage = drawable;
        this.align = align;
    }

    public GuideDialog(OnBindView<CustomDialog> onBindView) {
        this();
        this.onBindView = onBindView;
    }

    public GuideDialog(OnBindView<CustomDialog> onBindView, CustomDialog.ALIGN align) {
        this();
        this.onBindView = onBindView;
        this.align = align;
    }

    public GuideDialog(View view, int i) {
        this();
        baseView(view);
        this.tipImage = getResources().getDrawable(i);
    }

    public GuideDialog(View view, Bitmap bitmap) {
        this();
        baseView(view);
        this.tipImage = new BitmapDrawable(getResources(), bitmap);
    }

    public GuideDialog(View view, Drawable drawable) {
        this();
        baseView(view);
        this.tipImage = drawable;
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type, int i) {
        this();
        baseView(view);
        this.stageLightType = stage_light_type;
        this.tipImage = getResources().getDrawable(i);
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type, Bitmap bitmap) {
        this();
        baseView(view);
        this.stageLightType = stage_light_type;
        this.tipImage = new BitmapDrawable(getResources(), bitmap);
    }

    public GuideDialog(View view, STAGE_LIGHT_TYPE stage_light_type, Drawable drawable) {
        this();
        baseView(view);
        this.stageLightType = stage_light_type;
        this.tipImage = drawable;
    }

    public GuideDialog(View view, int i, int i2) {
        this();
        baseView(view);
        this.alignViewGravity = i2;
        this.tipImage = getResources().getDrawable(i);
    }

    public GuideDialog(View view, Bitmap bitmap, int i) {
        this();
        baseView(view);
        this.alignViewGravity = i;
        this.tipImage = new BitmapDrawable(getResources(), bitmap);
    }

    public GuideDialog(View view, Drawable drawable, int i) {
        this();
        baseView(view);
        this.alignViewGravity = i;
        this.tipImage = drawable;
    }

    public static GuideDialog show(OnBindView<CustomDialog> onBindView) {
        GuideDialog guideDialog = new GuideDialog(onBindView);
        guideDialog.show();
        return guideDialog;
    }

    public static GuideDialog show(OnBindView<CustomDialog> onBindView, CustomDialog.ALIGN align) {
        GuideDialog guideDialog = new GuideDialog(onBindView);
        guideDialog.align = align;
        guideDialog.show();
        return guideDialog;
    }

    public static GuideDialog show(int i) {
        return new GuideDialog(i).show();
    }

    public static GuideDialog show(Bitmap bitmap) {
        return new GuideDialog(bitmap).show();
    }

    public static GuideDialog show(Drawable drawable) {
        return new GuideDialog(drawable).show();
    }

    public static GuideDialog show(int i, CustomDialog.ALIGN align) {
        GuideDialog guideDialog = new GuideDialog(i, align);
        guideDialog.align = align;
        return guideDialog.show();
    }

    public static GuideDialog show(Bitmap bitmap, CustomDialog.ALIGN align) {
        GuideDialog guideDialog = new GuideDialog(bitmap, align);
        guideDialog.align = align;
        return guideDialog.show();
    }

    public static GuideDialog show(Drawable drawable, CustomDialog.ALIGN align) {
        return new GuideDialog(drawable, align).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type) {
        return new GuideDialog(view, stage_light_type).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type, OnBindView<CustomDialog> onBindView, int i) {
        return new GuideDialog(view, stage_light_type, onBindView, i).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type, int i, int i2) {
        return new GuideDialog(view, stage_light_type, i, i2).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type, Bitmap bitmap, int i) {
        return new GuideDialog(view, stage_light_type, bitmap, i).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type, Drawable drawable, int i) {
        return new GuideDialog(view, stage_light_type, drawable, i).show();
    }

    public static GuideDialog show(View view, int i) {
        return new GuideDialog(view, i).show();
    }

    public static GuideDialog show(View view, Bitmap bitmap) {
        return new GuideDialog(view, bitmap).show();
    }

    public static GuideDialog show(View view, Drawable drawable) {
        return new GuideDialog(view, drawable).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type, int i) {
        return new GuideDialog(view, stage_light_type, i).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type, Bitmap bitmap) {
        return new GuideDialog(view, stage_light_type, bitmap).show();
    }

    public static GuideDialog show(View view, STAGE_LIGHT_TYPE stage_light_type, Drawable drawable) {
        return new GuideDialog(view, stage_light_type, drawable).show();
    }

    public static GuideDialog show(View view, int i, int i2) {
        return new GuideDialog(view, i, i2).show();
    }

    public static GuideDialog show(View view, Bitmap bitmap, int i) {
        return new GuideDialog(view, bitmap, i).show();
    }

    public static GuideDialog show(View view, Drawable drawable, int i) {
        return new GuideDialog(view, drawable, i).show();
    }

    public GuideDialog show() {
        super.show();
        return this;
    }

    public GuideDialog show(Activity activity) {
        super.show(activity);
        return this;
    }

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    public GuideDialog setDialogLifecycleCallback(DialogLifecycleCallback<CustomDialog> dialogLifecycleCallback) {
        this.dialogLifecycleCallback = dialogLifecycleCallback;
        if (this.isShow) {
            dialogLifecycleCallback.onShow(this.me);
        }
        return this;
    }

    public GuideDialog setOnBackPressedListener(OnBackPressedListener<CustomDialog> onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
        refreshUI();
        return this;
    }

    public GuideDialog setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public GuideDialog setTheme(DialogX.THEME theme) {
        this.theme = theme;
        return this;
    }

    public GuideDialog setCancelable(boolean z) {
        this.privateCancelable = z ? BaseDialog.BOOLEAN.TRUE : BaseDialog.BOOLEAN.FALSE;
        refreshUI();
        return this;
    }

    public CustomDialog.DialogImpl getDialogImpl() {
        return this.dialogImpl;
    }

    public GuideDialog setCustomView(OnBindView<CustomDialog> onBindView) {
        this.onBindView = onBindView;
        refreshUI();
        return this;
    }

    public GuideDialog removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public GuideDialog setEnterAnimResId(int i) {
        this.enterAnimResId = i;
        return this;
    }

    public GuideDialog setExitAnimResId(int i) {
        this.exitAnimResId = i;
        return this;
    }

    public GuideDialog setAnimResId(int i, int i2) {
        this.enterAnimResId = i;
        this.exitAnimResId = i2;
        return this;
    }

    public GuideDialog setAlign(CustomDialog.ALIGN align) {
        this.align = align;
        return this;
    }

    public GuideDialog setAutoUnsafePlacePadding(boolean z) {
        this.autoUnsafePlacePadding = z;
        refreshUI();
        return this;
    }

    public GuideDialog setFullScreen(boolean z) {
        this.autoUnsafePlacePadding = !this.autoUnsafePlacePadding;
        refreshUI();
        return this;
    }

    public GuideDialog setMaskColor(int i) {
        this.maskColor = Integer.valueOf(i);
        refreshUI();
        return this;
    }

    public GuideDialog setEnterAnimDuration(long j) {
        this.enterAnimDuration = j;
        return this;
    }

    public GuideDialog setExitAnimDuration(long j) {
        this.exitAnimDuration = j;
        return this;
    }

    public GuideDialog setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public GuideDialog setBkgInterceptTouch(boolean z) {
        this.bkgInterceptTouch = z;
        return this;
    }

    public GuideDialog setAlignBaseViewGravity(View view, int i) {
        baseView(view);
        this.alignViewGravity = i;
        this.baseViewLoc = new int[4];
        view.getLocationInWindow(this.baseViewLoc);
        setFullScreen(true);
        return this;
    }

    public GuideDialog setAlignBaseViewGravity(View view) {
        baseView(view);
        this.baseViewLoc = new int[4];
        view.getLocationInWindow(this.baseViewLoc);
        setFullScreen(true);
        return this;
    }

    public GuideDialog setAlignBaseViewGravity(int i) {
        this.alignViewGravity = i;
        if (baseView() != null) {
            this.baseViewLoc = new int[4];
            baseView().getLocationInWindow(this.baseViewLoc);
        }
        setFullScreen(true);
        return this;
    }

    public GuideDialog setAlignBaseViewGravity(View view, int i, int i2, int i3, int i4, int i5) {
        this.marginRelativeBaseView = new int[]{i2, i3, i4, i5};
        return setAlignBaseViewGravity(view, i);
    }

    public GuideDialog setBaseViewMargin(int[] iArr) {
        this.marginRelativeBaseView = iArr;
        return this;
    }

    public GuideDialog setBaseViewMargin(int i, int i2, int i3, int i4) {
        this.marginRelativeBaseView = new int[]{i, i2, i3, i4};
        return this;
    }

    public GuideDialog setBaseViewMarginLeft(int i) {
        this.marginRelativeBaseView[0] = i;
        return this;
    }

    public GuideDialog setBaseViewMarginTop(int i) {
        this.marginRelativeBaseView[1] = i;
        return this;
    }

    public GuideDialog setBaseViewMarginRight(int i) {
        this.marginRelativeBaseView[2] = i;
        return this;
    }

    public GuideDialog setBaseViewMarginBottom(int i) {
        this.marginRelativeBaseView[3] = i;
        return this;
    }

    public GuideDialog setWidth(int i) {
        this.width = i;
        refreshUI();
        return this;
    }

    public GuideDialog setHeight(int i) {
        this.height = i;
        refreshUI();
        return this;
    }

    public GuideDialog setOnBackgroundMaskClickListener(OnBackgroundMaskClickListener<CustomDialog> onBackgroundMaskClickListener) {
        this.onBackgroundMaskClickListener = onBackgroundMaskClickListener;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onDialogShow() {
        super.onDialogShow();
        if (baseView() == null) {
            Integer num = this.maskColor;
            super.setMaskColor(num == null ? getColor(R.color.black50) : num.intValue());
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogRefreshUI() {
        super.onDialogRefreshUI();
        if (this.onBindView == null && this.tipImage != null) {
            getDialogImpl().boxCustom.setFocusable(false);
            getDialogImpl().boxCustom.setFocusableInTouchMode(false);
            getDialogImpl().boxCustom.setOnClickListener((View.OnClickListener) null);
            getDialogImpl().boxCustom.setClickable(false);
            ImageView imageView = new ImageView(getOwnActivity());
            imageView.setImageDrawable(this.tipImage);
            imageView.setAdjustViewBounds(true);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.onBindView = new OnBindView<CustomDialog>(imageView) {
                public void onBind(CustomDialog customDialog, View view) {
                }
            };
            this.onBindView.bindParent(getDialogImpl().boxCustom, this.me);
        }
        if (getOnStageLightPathClickListener() == null || baseView() == null) {
            View view = this.stageLightPathStub;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.stageLightPathStub.getParent()).removeView(this.stageLightPathStub);
                return;
            }
            return;
        }
        View view2 = new View(getOwnActivity());
        this.stageLightPathStub = view2;
        view2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!GuideDialog.this.getOnStageLightPathClickListener().onClick(GuideDialog.this, view)) {
                    GuideDialog.this.dismiss();
                }
            }
        });
        getDialogImpl().boxRoot.addView(this.stageLightPathStub);
    }

    /* access modifiers changed from: protected */
    public void onGetBaseViewLoc(int[] iArr) {
        if (!Arrays.equals(iArr, this.baseViewLocCache) && getDialogImpl() != null) {
            Bitmap createBitmap = Bitmap.createBitmap(getDialogImpl().boxRoot.getWidth(), getDialogImpl().boxRoot.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            int i = iArr[0];
            int[] iArr2 = this.baseViewLocationCoordinateCompensation;
            int i2 = i + iArr2[0];
            int i3 = iArr[1] + iArr2[1];
            int i4 = iArr[2] + iArr2[2];
            int i5 = iArr[3] + iArr2[3];
            int i6 = i4 / 2;
            int i7 = i5 / 2;
            View view = this.stageLightPathStub;
            if (view != null) {
                float f = (float) i2;
                if (!(view.getX() == f && this.stageLightPathStub.getY() == ((float) i3))) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.stageLightPathStub.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(i4, i5);
                    } else {
                        layoutParams.width = i4;
                        layoutParams.height = i5;
                    }
                    this.stageLightPathStub.setLayoutParams(layoutParams);
                    this.stageLightPathStub.setX(f);
                    this.stageLightPathStub.setY((float) i3);
                }
            }
            int i8 = AnonymousClass3.$SwitchMap$com$kongzue$dialogx$dialogs$GuideDialog$STAGE_LIGHT_TYPE[this.stageLightType.ordinal()];
            if (i8 == 1) {
                canvas.drawCircle((float) (i2 + i6), (float) (i3 + i7), (float) ((int) Math.sqrt((double) ((i6 * i6) + (i7 * i7)))), getStageLightPaint());
            } else if (i8 == 2) {
                canvas.drawCircle((float) (i2 + i6), (float) (i3 + i7), (float) (Math.min(i4, i5) / 2), getStageLightPaint());
            } else if (i8 == 3) {
                RectF rectF = new RectF((float) i2, (float) i3, (float) (i2 + i4), (float) (i3 + i5));
                float f2 = this.stageLightFilletRadius;
                canvas.drawRoundRect(rectF, f2, f2, getStageLightPaint());
            } else if (i8 == 4) {
                int min = Math.min(i4, i5);
                int i9 = i2 + i6;
                int i10 = min / 2;
                int i11 = i9 - i10;
                int i12 = (i3 + i7) - i10;
                RectF rectF2 = new RectF((float) i11, (float) i12, (float) (i11 + min), (float) (i12 + min));
                float f3 = this.stageLightFilletRadius;
                canvas.drawRoundRect(rectF2, f3, f3, getStageLightPaint());
            } else if (i8 == 5) {
                int max = Math.max(i4, i5);
                int i13 = i2 + i6;
                int i14 = max / 2;
                int i15 = i13 - i14;
                int i16 = (i3 + i7) - i14;
                RectF rectF3 = new RectF((float) i15, (float) i16, (float) (i15 + max), (float) (i16 + max));
                float f4 = this.stageLightFilletRadius;
                canvas.drawRoundRect(rectF3, f4, f4, getStageLightPaint());
            }
            this.stageLightPaint.setXfermode((Xfermode) null);
            Integer num = this.maskColor;
            canvas.drawColor(num == null ? getColor(R.color.black50) : num.intValue(), PorterDuff.Mode.SRC_OUT);
            getDialogImpl().boxRoot.setBackground(new BitmapDrawable(getResources(), createBitmap));
            this.baseViewLocCache = Arrays.copyOf(iArr, 4);
        }
    }

    /* renamed from: com.kongzue.dialogx.dialogs.GuideDialog$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$kongzue$dialogx$dialogs$GuideDialog$STAGE_LIGHT_TYPE;

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
                com.kongzue.dialogx.dialogs.GuideDialog$STAGE_LIGHT_TYPE[] r0 = com.kongzue.dialogx.dialogs.GuideDialog.STAGE_LIGHT_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kongzue$dialogx$dialogs$GuideDialog$STAGE_LIGHT_TYPE = r0
                com.kongzue.dialogx.dialogs.GuideDialog$STAGE_LIGHT_TYPE r1 = com.kongzue.dialogx.dialogs.GuideDialog.STAGE_LIGHT_TYPE.CIRCLE_OUTSIDE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$GuideDialog$STAGE_LIGHT_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kongzue.dialogx.dialogs.GuideDialog$STAGE_LIGHT_TYPE r1 = com.kongzue.dialogx.dialogs.GuideDialog.STAGE_LIGHT_TYPE.CIRCLE_INSIDE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$GuideDialog$STAGE_LIGHT_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kongzue.dialogx.dialogs.GuideDialog$STAGE_LIGHT_TYPE r1 = com.kongzue.dialogx.dialogs.GuideDialog.STAGE_LIGHT_TYPE.RECTANGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$GuideDialog$STAGE_LIGHT_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.kongzue.dialogx.dialogs.GuideDialog$STAGE_LIGHT_TYPE r1 = com.kongzue.dialogx.dialogs.GuideDialog.STAGE_LIGHT_TYPE.SQUARE_INSIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$dialogs$GuideDialog$STAGE_LIGHT_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                com.kongzue.dialogx.dialogs.GuideDialog$STAGE_LIGHT_TYPE r1 = com.kongzue.dialogx.dialogs.GuideDialog.STAGE_LIGHT_TYPE.SQUARE_OUTSIDE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.dialogs.GuideDialog.AnonymousClass3.<clinit>():void");
        }
    }

    private Paint getStageLightPaint() {
        if (this.stageLightPaint == null) {
            Paint paint = new Paint();
            this.stageLightPaint = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            this.stageLightPaint.setStyle(Paint.Style.FILL);
            this.stageLightPaint.setAntiAlias(true);
        }
        return this.stageLightPaint;
    }

    public STAGE_LIGHT_TYPE getStageLightType() {
        return this.stageLightType;
    }

    public GuideDialog setStageLightType(STAGE_LIGHT_TYPE stage_light_type) {
        this.stageLightType = stage_light_type;
        refreshUI();
        return this;
    }

    public Drawable getTipImage() {
        return this.tipImage;
    }

    public GuideDialog setTipImage(int i) {
        this.tipImage = getResources().getDrawable(i);
        refreshUI();
        return this;
    }

    public GuideDialog setTipImage(Bitmap bitmap) {
        this.tipImage = new BitmapDrawable(getResources(), bitmap);
        refreshUI();
        return this;
    }

    public GuideDialog setTipImage(Drawable drawable) {
        this.tipImage = drawable;
        refreshUI();
        return this;
    }

    public float getStageLightFilletRadius() {
        return this.stageLightFilletRadius;
    }

    public GuideDialog setStageLightFilletRadius(float f) {
        this.stageLightFilletRadius = f;
        refreshUI();
        return this;
    }

    public OnDialogButtonClickListener<GuideDialog> getOnStageLightPathClickListener() {
        return this.onStageLightPathClickListener;
    }

    public GuideDialog setOnStageLightPathClickListener(OnDialogButtonClickListener<GuideDialog> onDialogButtonClickListener) {
        this.onStageLightPathClickListener = onDialogButtonClickListener;
        refreshUI();
        return this;
    }

    public DialogXAnimInterface<CustomDialog> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public GuideDialog setDialogXAnimImpl(DialogXAnimInterface<CustomDialog> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public GuideDialog setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public GuideDialog setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public int[] getBaseViewLocationCoordinateCompensation() {
        return this.baseViewLocationCoordinateCompensation;
    }

    public GuideDialog setBaseViewLocationCoordinateCompensation(int[] iArr) {
        this.baseViewLocationCoordinateCompensation = iArr;
        return this;
    }

    public GuideDialog setBaseViewLocationCoordinateCompensation(int i) {
        this.baseViewLocationCoordinateCompensation = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public GuideDialog setBaseViewLocationCoordinateCompensation(int i, int i2, int i3, int i4) {
        this.baseViewLocationCoordinateCompensation = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public GuideDialog setBaseViewLocationCoordinateCompensationLeft(int i) {
        this.baseViewLocationCoordinateCompensation[0] = i;
        refreshUI();
        return this;
    }

    public GuideDialog setBaseViewLocationCoordinateCompensationTop(int i) {
        this.baseViewLocationCoordinateCompensation[1] = i;
        refreshUI();
        return this;
    }

    public GuideDialog setBaseViewLocationCoordinateCompensationRight(int i) {
        this.baseViewLocationCoordinateCompensation[2] = i;
        refreshUI();
        return this;
    }

    public GuideDialog setBaseViewLocationCoordinateCompensationBottom(int i) {
        this.baseViewLocationCoordinateCompensation[3] = i;
        refreshUI();
        return this;
    }

    public int getBaseViewLocationCoordinateCompensationLeft() {
        return this.baseViewLocationCoordinateCompensation[0];
    }

    public int getBaseViewLocationCoordinateCompensationTop() {
        return this.baseViewLocationCoordinateCompensation[1];
    }

    public int getBaseViewLocationCoordinateCompensationRight() {
        return this.baseViewLocationCoordinateCompensation[2];
    }

    public int getBaseViewLocationCoordinateCompensationBottom() {
        return this.baseViewLocationCoordinateCompensation[3];
    }
}
