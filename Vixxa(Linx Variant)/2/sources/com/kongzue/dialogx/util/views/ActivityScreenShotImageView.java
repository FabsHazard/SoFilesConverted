package com.kongzue.dialogx.util.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.impl.ActivityLifecycleImpl;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.util.DialogXFloatingWindowActivity;
import java.lang.ref.WeakReference;
import java.util.Objects;

public class ActivityScreenShotImageView extends ImageView {
    public static boolean hideContentView = false;
    public static boolean useHardwareRenderingMode = true;
    private WeakReference<View> contentView;
    BaseDialog dialog;
    float height;
    public boolean hideActivityContentView;
    private boolean inited = false;
    private boolean isScreenshotSuccess;
    float mRadius;
    boolean readyDraw = false;
    private int screenHeight;
    private int screenWidth;
    float width;

    public ActivityScreenShotImageView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public ActivityScreenShotImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ActivityScreenShotImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        requestLayoutType();
    }

    private void requestLayoutType() {
        setLayerType(useHardwareRenderingMode ? 2 : 1, (Paint) null);
    }

    public void setRadius(float f) {
        this.mRadius = f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!(this.width == ((float) getWidth()) && this.height == ((float) getHeight()))) {
            refreshImage();
        }
        this.width = (float) getWidth();
        this.height = (float) getHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.readyDraw) {
            super.onDraw(canvas);
        }
        float f = this.width;
        float f2 = this.mRadius;
        if (f >= f2 && this.height > f2) {
            if (this.isScreenshotSuccess) {
                canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            }
            Path path = new Path();
            path.moveTo(this.mRadius, 0.0f);
            path.lineTo(this.width - this.mRadius, 0.0f);
            float f3 = this.width;
            path.quadTo(f3, 0.0f, f3, this.mRadius);
            path.lineTo(this.width, this.height - this.mRadius);
            float f4 = this.width;
            float f5 = this.height;
            path.quadTo(f4, f5, f4 - this.mRadius, f5);
            path.lineTo(this.mRadius, this.height);
            float f6 = this.height;
            path.quadTo(0.0f, f6, 0.0f, f6 - this.mRadius);
            path.lineTo(0.0f, this.mRadius);
            path.quadTo(0.0f, 0.0f, this.mRadius, 0.0f);
            canvas.clipPath(path);
        }
        canvas.drawColor(-1);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.isScreenshotSuccess) {
            refreshImage();
        }
    }

    private void refreshImage() {
        if (isAttachedToWindow()) {
            if (this.screenWidth != getMeasuredWidth() || this.screenHeight != getMeasuredHeight()) {
                this.screenWidth = getMeasuredWidth();
                this.screenHeight = getMeasuredHeight();
                doScreenshotActivityAndZoom();
            }
        }
    }

    private void doScreenshotActivityAndZoom() {
        ViewGroup decorView = getDecorView();
        if (decorView != null) {
            drawViewImage(decorView);
            setVisibility(0);
            this.inited = true;
        }
    }

    private ViewGroup getDecorView() {
        BaseDialog baseDialog = this.dialog;
        if (baseDialog != null) {
            return (ViewGroup) baseDialog.getOwnActivity().getWindow().getDecorView();
        }
        Activity topActivity = ActivityLifecycleImpl.getTopActivity();
        if (topActivity == null) {
            return null;
        }
        if (topActivity instanceof DialogXFloatingWindowActivity) {
            return (ViewGroup) ((DialogXFloatingWindowActivity) topActivity).getFromActivity().getWindow().getDecorView();
        }
        return (ViewGroup) topActivity.getWindow().getDecorView();
    }

    private void drawViewImage(View view) {
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            this.dialog.getDialogView().setVisibility(8);
            setContentViewVisibility(true);
            if (view.getWidth() + view.getHeight() == 0) {
                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            try {
                view.draw(new Canvas(createBitmap));
            } catch (Exception e) {
                if (DialogX.DEBUGMODE) {
                    e.printStackTrace();
                }
                if (useHardwareRenderingMode) {
                    useHardwareRenderingMode = false;
                    requestLayoutType();
                    drawViewImage(view);
                }
            }
            setImageBitmap(Bitmap.createBitmap(createBitmap, 0, 0, view.getWidth(), view.getHeight()));
            this.isScreenshotSuccess = true;
            setContentViewVisibility(false);
            this.dialog.getDialogView().setVisibility(0);
            this.dialog.getDialogView().requestFocus();
        }
    }

    /* access modifiers changed from: protected */
    public void setContentViewVisibility(boolean z) {
        if (!hideContentView && !this.hideActivityContentView) {
            return;
        }
        if (z) {
            WeakReference<View> weakReference = this.contentView;
            if (weakReference != null && weakReference.get() != null) {
                ((View) this.contentView.get()).setVisibility(0);
                return;
            }
            return;
        }
        View childAt = ((ViewGroup) Objects.requireNonNull(getDecorView())).getChildAt(0);
        if (childAt != null) {
            childAt.setVisibility(8);
            this.contentView = new WeakReference<>(childAt);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setContentViewVisibility(true);
        WeakReference<View> weakReference = this.contentView;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public void setScale(float f) {
        setScaleX(f);
        setScaleY(f);
        this.readyDraw = true;
    }

    public void bindDialog(BaseDialog baseDialog) {
        this.dialog = baseDialog;
    }
}
