package com.lihang;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ShadowLayout extends FrameLayout {
    private static final int MODE_DASHLINE = 4;
    private static final int MODE_PRESSED = 1;
    private static final int MODE_RIPPLE = 3;
    private static final int MODE_SELECTED = 2;
    private int angle;
    private int bottomPadding;
    private boolean bottomShow;
    private int centerColor;
    private int clickAbleFalseColor;
    private Drawable clickAbleFalseDrawable;
    private int current_stroke_color;
    private Path dashPath;
    private int endColor;
    private View firstView;
    GradientDrawable gradientDrawable;
    private boolean isClickable;
    private boolean isShowShadow;
    private boolean isSym;
    private Drawable layoutBackground;
    private Drawable layoutBackground_true;
    private int leftPadding;
    private boolean leftShow;
    private int mBackGroundColor;
    private int mBackGroundColor_true;
    private float mCornerRadius;
    private float mCornerRadius_leftBottom;
    private float mCornerRadius_leftTop;
    private float mCornerRadius_rightBottom;
    private float mCornerRadius_rightTop;
    private float mDx;
    private float mDy;
    private Paint mPaintDash;
    private int mShadowColor;
    private float mShadowLimit;
    private TextView mTextView;
    private int mTextViewResId;
    private View.OnClickListener onClickListener;
    private RectF rectf;
    private int rightPadding;
    private boolean rightShow;
    private Paint shadowPaint;
    private int shapeModeType;
    private int startColor;
    private int stroke_color;
    private int stroke_color_true;
    private float stroke_dashGap;
    private float stroke_dashWidth;
    private float stroke_with;
    private String text;
    private int textColor;
    private int textColor_true;
    private String text_true;
    private int topPadding;
    private boolean topShow;

    public ShadowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rectf = new RectF();
        this.isShowShadow = true;
        this.mBackGroundColor_true = -101;
        this.stroke_dashWidth = -1.0f;
        this.stroke_dashGap = -1.0f;
        this.clickAbleFalseColor = -101;
        this.mTextViewResId = -1;
        initView(context, attributeSet);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        initAttributes(attributeSet);
        if (!isDashLine()) {
            Paint paint = new Paint();
            this.shadowPaint = paint;
            paint.setAntiAlias(true);
            this.shadowPaint.setStyle(Paint.Style.FILL);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            this.gradientDrawable = gradientDrawable2;
            int i = this.mBackGroundColor;
            gradientDrawable2.setColors(new int[]{i, i});
            int i2 = this.stroke_color;
            if (i2 != -101) {
                this.current_stroke_color = i2;
            }
            setPadding();
        }
    }

    private boolean isDashLine() {
        return this.shapeModeType == 4;
    }

    private void initDashLine() {
        Paint paint = new Paint();
        this.mPaintDash = paint;
        paint.setAntiAlias(true);
        this.mPaintDash.setColor(this.stroke_color);
        this.mPaintDash.setStyle(Paint.Style.STROKE);
        this.mPaintDash.setPathEffect(new DashPathEffect(new float[]{this.stroke_dashWidth, this.stroke_dashGap}, 0.0f));
        this.dashPath = new Path();
    }

    private void initAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout);
        this.shapeModeType = obtainStyledAttributes.getInt(R.styleable.ShadowLayout_hl_shapeMode, 1);
        if (isDashLine()) {
            this.stroke_color = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_strokeColor, -101);
            this.stroke_dashWidth = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashWidth, -1.0f);
            float dimension = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashGap, -1.0f);
            this.stroke_dashGap = dimension;
            if (this.stroke_color != -101) {
                float f = this.stroke_dashWidth;
                if (f == -1.0f) {
                    throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE,需设置stroke_dashWidth值");
                } else if ((f != -1.0f || dimension == -1.0f) && (f == -1.0f || dimension != -1.0f)) {
                    initDashLine();
                    obtainStyledAttributes.recycle();
                } else {
                    throw new UnsupportedOperationException("使用了虚线边框,必须设置以下2个属性：ShadowLayout_hl_stroke_dashWidth，ShadowLayout_hl_stroke_dashGap");
                }
            } else {
                throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE,需设置stroke_color值");
            }
        } else {
            this.isShowShadow = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHidden, false);
            this.leftShow = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenLeft, false);
            this.rightShow = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenRight, false);
            this.bottomShow = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenBottom, false);
            this.topShow = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenTop, false);
            this.mCornerRadius = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius, getResources().getDimension(R.dimen.dp_0));
            this.mCornerRadius_leftTop = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_leftTop, -1.0f);
            this.mCornerRadius_leftBottom = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_leftBottom, -1.0f);
            this.mCornerRadius_rightTop = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_rightTop, -1.0f);
            this.mCornerRadius_rightBottom = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_rightBottom, -1.0f);
            float dimension2 = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_shadowLimit, 0.0f);
            this.mShadowLimit = dimension2;
            if (dimension2 == 0.0f) {
                this.isShowShadow = false;
            }
            this.mDx = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_shadowOffsetX, 0.0f);
            this.mDy = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_shadowOffsetY, 0.0f);
            this.mShadowColor = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_shadowColor, getResources().getColor(R.color.default_shadow_color));
            this.isSym = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowSymmetry, true);
            this.mBackGroundColor = getResources().getColor(R.color.default_shadowback_color);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ShadowLayout_hl_layoutBackground);
            if (drawable != null) {
                if (drawable instanceof ColorDrawable) {
                    this.mBackGroundColor = ((ColorDrawable) drawable).getColor();
                } else {
                    this.layoutBackground = drawable;
                }
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ShadowLayout_hl_layoutBackground_true);
            if (drawable2 != null) {
                if (drawable2 instanceof ColorDrawable) {
                    this.mBackGroundColor_true = ((ColorDrawable) drawable2).getColor();
                } else {
                    this.layoutBackground_true = drawable2;
                }
            }
            if (this.mBackGroundColor_true != -101 && this.layoutBackground != null) {
                throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，必须先设置ShadowLayout_hl_layoutBackground属性。且设置颜色时，必须保持都为颜色");
            } else if (this.layoutBackground != null || this.layoutBackground_true == null) {
                this.stroke_color = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_strokeColor, -101);
                int color = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_strokeColor_true, -101);
                this.stroke_color_true = color;
                if (this.stroke_color != -101 || color == -101) {
                    this.stroke_with = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_strokeWith, (float) dip2px(1.0f));
                    this.stroke_dashWidth = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashWidth, -1.0f);
                    float dimension3 = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashGap, -1.0f);
                    this.stroke_dashGap = dimension3;
                    float f2 = this.stroke_dashWidth;
                    if ((f2 != -1.0f || dimension3 == -1.0f) && (f2 == -1.0f || dimension3 != -1.0f)) {
                        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ShadowLayout_hl_layoutBackground_clickFalse);
                        if (drawable3 != null) {
                            if (drawable3 instanceof ColorDrawable) {
                                this.clickAbleFalseColor = ((ColorDrawable) drawable3).getColor();
                            } else {
                                this.clickAbleFalseDrawable = drawable3;
                            }
                        }
                        this.startColor = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_startColor, -101);
                        this.centerColor = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_centerColor, -101);
                        int color2 = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_endColor, -101);
                        this.endColor = color2;
                        if (this.startColor == -101 || color2 != -101) {
                            int i = obtainStyledAttributes.getInt(R.styleable.ShadowLayout_hl_angle, 0);
                            this.angle = i;
                            if (i % 45 == 0) {
                                if (this.shapeModeType == 3) {
                                    if (this.mBackGroundColor == -101 || this.mBackGroundColor_true == -101) {
                                        throw new NullPointerException("使用了ShadowLayout的水波纹，必须设置使用了ShadowLayout_hl_layoutBackground和使用了ShadowLayout_hl_layoutBackground_true属性，且为颜色值");
                                    } else if (this.layoutBackground != null) {
                                        this.shapeModeType = 1;
                                    }
                                }
                                this.mTextViewResId = obtainStyledAttributes.getResourceId(R.styleable.ShadowLayout_hl_bindTextView, -1);
                                this.textColor = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_textColor, -101);
                                this.textColor_true = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_textColor_true, -101);
                                this.text = obtainStyledAttributes.getString(R.styleable.ShadowLayout_hl_text);
                                this.text_true = obtainStyledAttributes.getString(R.styleable.ShadowLayout_hl_text_true);
                                boolean z = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_clickable, true);
                                this.isClickable = z;
                                setClickable(z);
                                obtainStyledAttributes.recycle();
                                return;
                            }
                            throw new IllegalArgumentException("Linear gradient requires 'angle' attribute to be a multiple of 45");
                        }
                        throw new UnsupportedOperationException("使用了ShadowLayout_hl_startColor渐变起始色，必须搭配终止色ShadowLayout_hl_endColor");
                    }
                    throw new UnsupportedOperationException("使用了虚线边框,必须设置以下2个属性：ShadowLayout_hl_stroke_dashWidth，ShadowLayout_hl_stroke_dashGap");
                }
                throw new UnsupportedOperationException("使用了ShadowLayout_hl_strokeColor_true属性，必须先设置ShadowLayout_hl_strokeColor属性");
            } else {
                throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，必须先设置ShadowLayout_hl_layoutBackground属性。且设置图片时，必须保持都为图片");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (isDashLine()) {
            setBackgroundColor(Color.parseColor("#00000000"));
        } else if (i > 0 && i2 > 0) {
            setBackgroundCompat(i, i2);
            if (this.startColor != -101) {
                gradient(this.gradientDrawable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isDashLine()) {
            int i = this.mTextViewResId;
            if (i != -1) {
                TextView textView = (TextView) findViewById(i);
                this.mTextView = textView;
                if (textView != null) {
                    if (this.textColor == -101) {
                        this.textColor = textView.getCurrentTextColor();
                    }
                    if (this.textColor_true == -101) {
                        this.textColor_true = this.mTextView.getCurrentTextColor();
                    }
                    this.mTextView.setTextColor(this.textColor);
                    if (!TextUtils.isEmpty(this.text)) {
                        this.mTextView.setText(this.text);
                    }
                } else {
                    throw new NullPointerException("ShadowLayout找不到hl_bindTextView，请确保绑定的资源id在ShadowLayout内");
                }
            }
            this.firstView = getChildAt(0);
            if (this.layoutBackground == null || !this.isShowShadow || this.mShadowLimit <= 0.0f || getChildAt(0) != null) {
                if (this.firstView == null) {
                    this.firstView = this;
                    this.isShowShadow = false;
                }
                if (this.firstView == null) {
                    return;
                }
                if (this.shapeModeType == 2) {
                    setmBackGround(this.layoutBackground, "onFinishInflate");
                } else if (this.isClickable) {
                    setmBackGround(this.layoutBackground, "onFinishInflate");
                } else {
                    setmBackGround(this.clickAbleFalseDrawable, "onFinishInflate");
                    int i2 = this.clickAbleFalseColor;
                    if (i2 != -101) {
                        this.gradientDrawable.setColors(new int[]{i2, i2});
                    }
                }
            } else {
                throw new UnsupportedOperationException("使用了图片又加上阴影的情况下，必须加上子view才会生效!~");
            }
        } else if (getChildAt(0) != null) {
            throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE，不支持子view");
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        TextView textView;
        int i = this.shapeModeType;
        if (i == 3) {
            if (this.isClickable) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    TextView textView2 = this.mTextView;
                    if (textView2 != null) {
                        textView2.setTextColor(this.textColor_true);
                        if (!TextUtils.isEmpty(this.text_true)) {
                            this.mTextView.setText(this.text_true);
                        }
                    }
                } else if ((action == 1 || action == 3) && (textView = this.mTextView) != null) {
                    textView.setTextColor(this.textColor);
                    if (!TextUtils.isEmpty(this.text)) {
                        this.mTextView.setText(this.text);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        if (!(this.mBackGroundColor_true == -101 && this.stroke_color_true == -101 && this.layoutBackground_true == null) && this.isClickable && i == 1) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                int i2 = this.mBackGroundColor_true;
                if (i2 != -101) {
                    this.gradientDrawable.setColors(new int[]{i2, i2});
                }
                int i3 = this.stroke_color_true;
                if (i3 != -101) {
                    this.current_stroke_color = i3;
                }
                Drawable drawable = this.layoutBackground_true;
                if (drawable != null) {
                    setmBackGround(drawable, "onTouchEvent");
                }
                postInvalidate();
                TextView textView3 = this.mTextView;
                if (textView3 != null) {
                    textView3.setTextColor(this.textColor_true);
                    if (!TextUtils.isEmpty(this.text_true)) {
                        this.mTextView.setText(this.text_true);
                    }
                }
            } else if (action2 == 1 || action2 == 3) {
                GradientDrawable gradientDrawable2 = this.gradientDrawable;
                int i4 = this.mBackGroundColor;
                gradientDrawable2.setColors(new int[]{i4, i4});
                if (this.startColor != -101) {
                    gradient(this.gradientDrawable);
                }
                int i5 = this.stroke_color;
                if (i5 != -101) {
                    this.current_stroke_color = i5;
                }
                Drawable drawable2 = this.layoutBackground;
                if (drawable2 != null) {
                    setmBackGround(drawable2, "onTouchEvent");
                }
                postInvalidate();
                TextView textView4 = this.mTextView;
                if (textView4 != null) {
                    textView4.setTextColor(this.textColor);
                    if (!TextUtils.isEmpty(this.text)) {
                        this.mTextView.setText(this.text);
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (getWidth() == 0) {
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    ShadowLayout.this.removeOnLayoutChangeListener(this);
                    ShadowLayout shadowLayout = ShadowLayout.this;
                    shadowLayout.setSelected(shadowLayout.isSelected());
                }
            });
        } else if (this.shapeModeType == 2) {
            if (z) {
                int i = this.mBackGroundColor_true;
                if (i != -101) {
                    this.gradientDrawable.setColors(new int[]{i, i});
                }
                int i2 = this.stroke_color_true;
                if (i2 != -101) {
                    this.current_stroke_color = i2;
                }
                Drawable drawable = this.layoutBackground_true;
                if (drawable != null) {
                    setmBackGround(drawable, "setSelected");
                }
                TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setTextColor(this.textColor_true);
                    if (!TextUtils.isEmpty(this.text_true)) {
                        this.mTextView.setText(this.text_true);
                    }
                }
            } else {
                GradientDrawable gradientDrawable2 = this.gradientDrawable;
                int i3 = this.mBackGroundColor;
                gradientDrawable2.setColors(new int[]{i3, i3});
                if (this.startColor != -101) {
                    gradient(this.gradientDrawable);
                }
                int i4 = this.stroke_color;
                if (i4 != -101) {
                    this.current_stroke_color = i4;
                }
                Drawable drawable2 = this.layoutBackground;
                if (drawable2 != null) {
                    setmBackGround(drawable2, "setSelected");
                }
                TextView textView2 = this.mTextView;
                if (textView2 != null) {
                    textView2.setTextColor(this.textColor);
                    if (!TextUtils.isEmpty(this.text)) {
                        this.mTextView.setText(this.text);
                    }
                }
            }
            postInvalidate();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
        if (this.isClickable) {
            super.setOnClickListener(onClickListener2);
        }
    }

    private void changeSwitchClickable() {
        View view;
        if (this.shapeModeType == 1 && (view = this.firstView) != null) {
            if (this.isClickable) {
                Drawable drawable = this.layoutBackground;
                if (drawable != null) {
                    setmBackGround(drawable, "changeSwitchClickable");
                } else if (view.getBackground() != null) {
                    this.firstView.getBackground().setAlpha(0);
                }
                GradientDrawable gradientDrawable2 = this.gradientDrawable;
                int i = this.mBackGroundColor;
                gradientDrawable2.setColors(new int[]{i, i});
                postInvalidate();
            } else if (this.clickAbleFalseColor != -101) {
                if (this.layoutBackground != null) {
                    view.getBackground().setAlpha(0);
                }
                GradientDrawable gradientDrawable3 = this.gradientDrawable;
                int i2 = this.clickAbleFalseColor;
                gradientDrawable3.setColors(new int[]{i2, i2});
                postInvalidate();
            } else {
                Drawable drawable2 = this.clickAbleFalseDrawable;
                if (drawable2 != null) {
                    setmBackGround(drawable2, "changeSwitchClickable");
                    this.gradientDrawable.setColors(new int[]{Color.parseColor("#00000000"), Color.parseColor("#00000000")});
                    postInvalidate();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i = (int) (this.rectf.bottom - this.rectf.top);
        if (getChildAt(0) != null) {
            if (this.mCornerRadius_leftTop == -1.0f && this.mCornerRadius_leftBottom == -1.0f && this.mCornerRadius_rightTop == -1.0f && this.mCornerRadius_rightBottom == -1.0f) {
                float f = (float) (i / 2);
                if (this.mCornerRadius > f) {
                    Path path = new Path();
                    path.addRoundRect(this.rectf, f, f, Path.Direction.CW);
                    canvas.clipPath(path);
                } else {
                    Path path2 = new Path();
                    RectF rectF = this.rectf;
                    float f2 = this.mCornerRadius;
                    path2.addRoundRect(rectF, f2, f2, Path.Direction.CW);
                    canvas.clipPath(path2);
                }
            } else {
                float[] cornerValue = getCornerValue(i);
                Path path3 = new Path();
                path3.addRoundRect((float) this.leftPadding, (float) this.topPadding, (float) (getWidth() - this.rightPadding), (float) (getHeight() - this.bottomPadding), cornerValue, Path.Direction.CW);
                canvas.clipPath(path3);
            }
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isDashLine()) {
            drawLine(canvas);
            return;
        }
        this.rectf.left = (float) this.leftPadding;
        this.rectf.top = (float) this.topPadding;
        this.rectf.right = (float) (getWidth() - this.rightPadding);
        this.rectf.bottom = (float) (getHeight() - this.bottomPadding);
        int i = (int) (this.rectf.bottom - this.rectf.top);
        if (this.stroke_color != -101) {
            float f = (float) (i / 2);
            if (this.stroke_with > f) {
                this.stroke_with = f;
            }
        }
        if (this.layoutBackground == null && this.layoutBackground_true == null) {
            float[] cornerValue = getCornerValue(i);
            if (this.shapeModeType != 3) {
                drawGradientDrawable(canvas, this.rectf, cornerValue);
            } else {
                ripple(cornerValue);
            }
        }
    }

    public void drawLine(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width > height) {
            this.mPaintDash.setStrokeWidth((float) height);
            this.dashPath.reset();
            float f = (float) (height / 2);
            this.dashPath.moveTo(0.0f, f);
            this.dashPath.lineTo((float) width, f);
        } else {
            this.mPaintDash.setStrokeWidth((float) width);
            this.dashPath.reset();
            float f2 = (float) (width / 2);
            this.dashPath.moveTo(f2, 0.0f);
            this.dashPath.lineTo(f2, (float) height);
        }
        canvas.drawPath(this.dashPath, this.mPaintDash);
    }

    public void drawGradientDrawable(Canvas canvas, RectF rectF, float[] fArr) {
        this.gradientDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        if (this.stroke_color != -101) {
            if (this.stroke_dashWidth != -1.0f) {
                this.gradientDrawable.setStroke(Math.round(this.stroke_with), this.current_stroke_color, this.stroke_dashWidth, this.stroke_dashGap);
            } else {
                this.gradientDrawable.setStroke(Math.round(this.stroke_with), this.current_stroke_color);
            }
        }
        this.gradientDrawable.setCornerRadii(fArr);
        this.gradientDrawable.draw(canvas);
    }

    private float[] getCornerValue(int i) {
        float f = this.mCornerRadius_leftTop;
        if (f == -1.0f) {
            f = this.mCornerRadius;
        }
        int i2 = (int) f;
        int i3 = i / 2;
        if (i2 > i3) {
            i2 = i3;
        }
        float f2 = this.mCornerRadius_rightTop;
        if (f2 == -1.0f) {
            f2 = this.mCornerRadius;
        }
        int i4 = (int) f2;
        if (i4 > i3) {
            i4 = i3;
        }
        float f3 = this.mCornerRadius_rightBottom;
        if (f3 == -1.0f) {
            f3 = this.mCornerRadius;
        }
        int i5 = (int) f3;
        if (i5 > i3) {
            i5 = i3;
        }
        float f4 = this.mCornerRadius_leftBottom;
        int i6 = f4 == -1.0f ? (int) this.mCornerRadius : (int) f4;
        if (i6 <= i3) {
            i3 = i6;
        }
        float f5 = (float) i2;
        float f6 = (float) i4;
        float f7 = (float) i5;
        float f8 = (float) i3;
        return new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
    }

    private void ripple(float[] fArr) {
        int i = this.mBackGroundColor;
        int i2 = this.mBackGroundColor_true;
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842908}, new int[]{16843518}, new int[0]}, new int[]{i2, i2, i2, i});
        RoundRectShape roundRectShape = new RoundRectShape(fArr, (RectF) null, (float[]) null);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(roundRectShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        if (this.stroke_color != -101) {
            if (this.stroke_dashWidth != -1.0f) {
                this.gradientDrawable.setStroke(Math.round(this.stroke_with), this.current_stroke_color, this.stroke_dashWidth, this.stroke_dashGap);
            } else {
                this.gradientDrawable.setStroke(Math.round(this.stroke_with), this.current_stroke_color);
            }
        }
        this.gradientDrawable.setCornerRadii(fArr);
        if (this.startColor != -101) {
            gradient(this.gradientDrawable);
        }
        this.firstView.setBackground(new RippleDrawable(colorStateList, this.gradientDrawable, shapeDrawable));
    }

    private void gradient(GradientDrawable gradientDrawable2) {
        int[] iArr;
        if (this.isClickable) {
            int i = this.centerColor;
            if (i == -101) {
                iArr = new int[]{this.startColor, this.endColor};
            } else {
                iArr = new int[]{this.startColor, i, this.endColor};
            }
            gradientDrawable2.setColors(iArr);
            int i2 = this.angle;
            if (i2 < 0) {
                this.angle = (i2 % 360) + 360;
            }
            switch ((this.angle % 360) / 45) {
                case 0:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    return;
                case 1:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.BL_TR);
                    return;
                case 2:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                    return;
                case 3:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.BR_TL);
                    return;
                case 4:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                    return;
                case 5:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.TR_BL);
                    return;
                case 6:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                    return;
                case 7:
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.TL_BR);
                    return;
                default:
                    return;
            }
        }
    }

    private int dip2px(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void setPadding() {
        if (this.isShowShadow) {
            float f = this.mShadowLimit;
            if (f > 0.0f) {
                if (this.isSym) {
                    int abs = (int) (f + Math.abs(this.mDx));
                    int abs2 = (int) (this.mShadowLimit + Math.abs(this.mDy));
                    if (this.leftShow) {
                        this.leftPadding = abs;
                    } else {
                        this.leftPadding = 0;
                    }
                    if (this.topShow) {
                        this.topPadding = abs2;
                    } else {
                        this.topPadding = 0;
                    }
                    if (this.rightShow) {
                        this.rightPadding = abs;
                    } else {
                        this.rightPadding = 0;
                    }
                    if (this.bottomShow) {
                        this.bottomPadding = abs2;
                    } else {
                        this.bottomPadding = 0;
                    }
                } else {
                    float abs3 = Math.abs(this.mDy);
                    float f2 = this.mShadowLimit;
                    if (abs3 > f2) {
                        if (this.mDy > 0.0f) {
                            this.mDy = f2;
                        } else {
                            this.mDy = 0.0f - f2;
                        }
                    }
                    float abs4 = Math.abs(this.mDx);
                    float f3 = this.mShadowLimit;
                    if (abs4 > f3) {
                        if (this.mDx > 0.0f) {
                            this.mDx = f3;
                        } else {
                            this.mDx = 0.0f - f3;
                        }
                    }
                    if (this.topShow) {
                        this.topPadding = (int) (f3 - this.mDy);
                    } else {
                        this.topPadding = 0;
                    }
                    if (this.bottomShow) {
                        this.bottomPadding = (int) (this.mDy + f3);
                    } else {
                        this.bottomPadding = 0;
                    }
                    if (this.rightShow) {
                        this.rightPadding = (int) (f3 - this.mDx);
                    } else {
                        this.rightPadding = 0;
                    }
                    if (this.leftShow) {
                        this.leftPadding = (int) (f3 + this.mDx);
                    } else {
                        this.leftPadding = 0;
                    }
                }
                setPadding(this.leftPadding, this.topPadding, this.rightPadding, this.bottomPadding);
            }
        }
    }

    private void setBackgroundCompat(int i, int i2) {
        if (this.isShowShadow) {
            isAddAlpha(this.mShadowColor);
            setBackground(new BitmapDrawable(createShadowBitmap(i, i2, this.mCornerRadius, this.mShadowLimit, this.mDx, this.mDy, this.mShadowColor, 0)));
        } else if (getChildAt(0) == null) {
            Drawable drawable = this.layoutBackground;
            if (drawable != null) {
                this.firstView = this;
                if (this.isClickable) {
                    setmBackGround(drawable, "setBackgroundCompat");
                } else {
                    changeSwitchClickable();
                }
            } else {
                setBackgroundColor(Color.parseColor("#00000000"));
            }
        } else {
            setBackgroundColor(Color.parseColor("#00000000"));
        }
    }

    private Bitmap createShadowBitmap(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        float f5;
        float f6;
        float f7;
        float f8;
        int i5;
        int i6;
        int i7;
        int i8;
        float f9 = f3 / 4.0f;
        float f10 = f4 / 4.0f;
        int i9 = i / 4;
        if (i9 == 0) {
            i9 = 1;
        }
        int i10 = i2 / 4;
        if (i10 == 0) {
            i10 = 1;
        }
        float f11 = f / 4.0f;
        float f12 = f2 / 4.0f;
        Bitmap createBitmap = Bitmap.createBitmap(i9, i10, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        if (this.leftShow) {
            f5 = f12;
        } else {
            f5 = Math.max(Math.max(Math.max(f11, this.mCornerRadius_leftTop), Math.max(f11, this.mCornerRadius_leftBottom)), f12) / 2.0f;
        }
        if (this.topShow) {
            f6 = f12;
        } else {
            f6 = Math.max(Math.max(Math.max(f11, this.mCornerRadius_leftTop), Math.max(f11, this.mCornerRadius_rightTop)), f12) / 2.0f;
        }
        if (this.rightShow) {
            f7 = ((float) i9) - f12;
        } else {
            f7 = ((float) i9) - (Math.max(Math.max(Math.max(f11, this.mCornerRadius_rightTop), Math.max(f11, this.mCornerRadius_rightBottom)), f12) / 2.0f);
        }
        if (this.bottomShow) {
            f8 = ((float) i10) - f12;
        } else {
            f8 = ((float) i10) - (Math.max(Math.max(Math.max(f11, this.mCornerRadius_leftBottom), Math.max(f11, this.mCornerRadius_rightBottom)), f12) / 2.0f);
        }
        RectF rectF = new RectF(f5, f6, f7, f8);
        if (this.isSym) {
            if (f10 > 0.0f) {
                rectF.top += f10;
                rectF.bottom -= f10;
            } else if (f10 < 0.0f) {
                rectF.top += Math.abs(f10);
                rectF.bottom -= Math.abs(f10);
            }
            if (f9 > 0.0f) {
                rectF.left += f9;
                rectF.right -= f9;
            } else if (f9 < 0.0f) {
                rectF.left += Math.abs(f9);
                rectF.right -= Math.abs(f9);
            }
        } else {
            rectF.top -= f10;
            rectF.bottom -= f10;
            rectF.right -= f9;
            rectF.left -= f9;
        }
        this.shadowPaint.setColor(i4);
        if (!isInEditMode()) {
            this.shadowPaint.setShadowLayer(f12 / 2.0f, f9, f10, i3);
        }
        if (this.mCornerRadius_leftBottom == -1.0f && this.mCornerRadius_leftTop == -1.0f && this.mCornerRadius_rightTop == -1.0f && this.mCornerRadius_rightBottom == -1.0f) {
            canvas.drawRoundRect(rectF, f11, f11, this.shadowPaint);
        } else {
            this.rectf.left = (float) this.leftPadding;
            this.rectf.top = (float) this.topPadding;
            this.rectf.right = (float) (getWidth() - this.rightPadding);
            this.rectf.bottom = (float) (getHeight() - this.bottomPadding);
            this.shadowPaint.setAntiAlias(true);
            float f13 = this.mCornerRadius_leftTop;
            if (f13 == -1.0f) {
                i5 = ((int) this.mCornerRadius) / 4;
            } else {
                i5 = ((int) f13) / 4;
            }
            float f14 = this.mCornerRadius_leftBottom;
            if (f14 == -1.0f) {
                i6 = ((int) this.mCornerRadius) / 4;
            } else {
                i6 = ((int) f14) / 4;
            }
            float f15 = this.mCornerRadius_rightTop;
            if (f15 == -1.0f) {
                i7 = ((int) this.mCornerRadius) / 4;
            } else {
                i7 = ((int) f15) / 4;
            }
            float f16 = this.mCornerRadius_rightBottom;
            if (f16 == -1.0f) {
                i8 = ((int) this.mCornerRadius) / 4;
            } else {
                i8 = ((int) f16) / 4;
            }
            float f17 = (float) i5;
            float f18 = (float) i7;
            float f19 = (float) i8;
            float f20 = (float) i6;
            float[] fArr = {f17, f17, f18, f18, f19, f19, f20, f20};
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, this.shadowPaint);
        }
        return createBitmap;
    }

    private void isAddAlpha(int i) {
        if (Color.alpha(i) == 255) {
            String hexString = Integer.toHexString(Color.red(i));
            String hexString2 = Integer.toHexString(Color.green(i));
            String hexString3 = Integer.toHexString(Color.blue(i));
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            if (hexString2.length() == 1) {
                hexString2 = "0" + hexString2;
            }
            if (hexString3.length() == 1) {
                hexString3 = "0" + hexString3;
            }
            this.mShadowColor = convertToColorInt("#2a" + hexString + hexString2 + hexString3);
        }
    }

    private static int convertToColorInt(String str) throws IllegalArgumentException {
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        return Color.parseColor(str);
    }

    private void setmBackGround(Drawable drawable, String str) {
        this.firstView.setTag(R.id.action_container, str);
        View view = this.firstView;
        if (view != null && drawable != null) {
            float f = this.mCornerRadius_leftTop;
            if (f == -1.0f && this.mCornerRadius_leftBottom == -1.0f && this.mCornerRadius_rightTop == -1.0f && this.mCornerRadius_rightBottom == -1.0f) {
                GlideRoundUtils.setRoundCorner(view, drawable, this.mCornerRadius, str);
                return;
            }
            if (f == -1.0f) {
                f = this.mCornerRadius;
            }
            int i = (int) f;
            float f2 = this.mCornerRadius_leftBottom;
            if (f2 == -1.0f) {
                f2 = this.mCornerRadius;
            }
            int i2 = (int) f2;
            float f3 = this.mCornerRadius_rightTop;
            if (f3 == -1.0f) {
                f3 = this.mCornerRadius;
            }
            int i3 = (int) f3;
            float f4 = this.mCornerRadius_rightBottom;
            GlideRoundUtils.setCorners(view, drawable, (float) i, (float) i2, (float) i3, (float) (f4 == -1.0f ? (int) this.mCornerRadius : (int) f4), str);
        }
    }

    public void setClickable(boolean z) {
        isExceptionByDashLine();
        super.setClickable(z);
        this.isClickable = z;
        changeSwitchClickable();
        if (this.isClickable) {
            super.setOnClickListener(this.onClickListener);
        }
        GradientDrawable gradientDrawable2 = this.gradientDrawable;
        if (gradientDrawable2 != null && this.startColor != -101 && this.endColor != -101) {
            gradient(gradientDrawable2);
        }
    }

    public void setGradientColor(int i, int i2) {
        setGradientColor(this.angle, i, i2);
    }

    public void setGradientColor(int i, int i2, int i3) {
        setGradientColor(i, i2, -101, i3);
    }

    public void setGradientColor(int i, int i2, int i3, int i4) {
        isExceptionByDashLine();
        if (i % 45 == 0) {
            this.angle = i;
            this.startColor = i2;
            this.centerColor = i3;
            this.endColor = i4;
            gradient(this.gradientDrawable);
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("Linear gradient requires 'angle' attribute to be a multiple of 45");
    }

    private void isExceptionByDashLine() {
        if (isDashLine()) {
            throw new RuntimeException("shapeMode为MODE_DASHLINE,不允许设置此属性");
        }
    }

    public void setShadowHidden(boolean z) {
        isExceptionByDashLine();
        this.isShowShadow = !z;
        if (getWidth() != 0 && getHeight() != 0) {
            setBackgroundCompat(getWidth(), getHeight());
        }
    }

    public void setShadowOffsetX(float f) {
        isExceptionByDashLine();
        if (this.isShowShadow) {
            float abs = Math.abs(f);
            float f2 = this.mShadowLimit;
            if (abs <= f2) {
                this.mDx = f;
            } else if (f > 0.0f) {
                this.mDx = f2;
            } else {
                this.mDx = -f2;
            }
            setPadding();
        }
    }

    public void setShadowOffsetY(float f) {
        isExceptionByDashLine();
        if (this.isShowShadow) {
            float abs = Math.abs(f);
            float f2 = this.mShadowLimit;
            if (abs <= f2) {
                this.mDy = f;
            } else if (f > 0.0f) {
                this.mDy = f2;
            } else {
                this.mDy = -f2;
            }
            setPadding();
        }
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setCornerRadius(int i) {
        isExceptionByDashLine();
        this.mCornerRadius = (float) i;
        if (getWidth() != 0 && getHeight() != 0) {
            setBackgroundCompat(getWidth(), getHeight());
        }
    }

    public float getShadowLimit() {
        return this.mShadowLimit;
    }

    public void setShadowLimit(int i) {
        isExceptionByDashLine();
        if (this.isShowShadow) {
            this.mShadowLimit = (float) i;
            setPadding();
        }
    }

    public void setShadowColor(int i) {
        isExceptionByDashLine();
        this.mShadowColor = i;
        if (getWidth() != 0 && getHeight() != 0) {
            setBackgroundCompat(getWidth(), getHeight());
        }
    }

    public void setSpecialCorner(int i, int i2, int i3, int i4) {
        isExceptionByDashLine();
        this.mCornerRadius_leftTop = (float) i;
        this.mCornerRadius_rightTop = (float) i2;
        this.mCornerRadius_leftBottom = (float) i3;
        this.mCornerRadius_rightBottom = (float) i4;
        if (getWidth() != 0 && getHeight() != 0) {
            setBackgroundCompat(getWidth(), getHeight());
        }
    }

    public void setShadowHiddenTop(boolean z) {
        isExceptionByDashLine();
        this.topShow = !z;
        setPadding();
    }

    public void setShadowHiddenBottom(boolean z) {
        isExceptionByDashLine();
        this.bottomShow = !z;
        setPadding();
    }

    public void setShadowHiddenRight(boolean z) {
        isExceptionByDashLine();
        this.rightShow = !z;
        setPadding();
    }

    public void setShadowHiddenLeft(boolean z) {
        isExceptionByDashLine();
        this.leftShow = !z;
        setPadding();
    }

    public void setLayoutBackground(int i) {
        isExceptionByDashLine();
        if (this.isClickable) {
            if (this.layoutBackground_true == null) {
                this.mBackGroundColor = i;
                this.startColor = -101;
                this.centerColor = -101;
                this.endColor = -101;
                if (this.shapeModeType != 2) {
                    this.gradientDrawable.setColors(new int[]{i, i});
                } else if (!isSelected()) {
                    GradientDrawable gradientDrawable2 = this.gradientDrawable;
                    int i2 = this.mBackGroundColor;
                    gradientDrawable2.setColors(new int[]{i2, i2});
                }
                postInvalidate();
                return;
            }
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，要与ShadowLayout_hl_layoutBackground属性统一为颜色");
        }
    }

    public void setLayoutBackgroundTrue(int i) {
        isExceptionByDashLine();
        if (this.layoutBackground == null) {
            this.mBackGroundColor_true = i;
            if (this.shapeModeType == 2 && isSelected()) {
                GradientDrawable gradientDrawable2 = this.gradientDrawable;
                int i2 = this.mBackGroundColor_true;
                gradientDrawable2.setColors(new int[]{i2, i2});
            }
            postInvalidate();
            return;
        }
        throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground属性，要与ShadowLayout_hl_layoutBackground_true属性统一为颜色");
    }

    public void setStrokeColor(int i) {
        isExceptionByDashLine();
        this.stroke_color = i;
        if (this.shapeModeType != 2) {
            this.current_stroke_color = i;
        } else if (!isSelected()) {
            this.current_stroke_color = this.stroke_color;
        }
        postInvalidate();
    }

    public void setStrokeColorTrue(int i) {
        isExceptionByDashLine();
        this.stroke_color_true = i;
        if (this.shapeModeType == 2 && isSelected()) {
            this.current_stroke_color = this.stroke_color_true;
        }
        postInvalidate();
    }

    public void setStrokeWidth(float f) {
        isExceptionByDashLine();
        this.stroke_with = f;
        postInvalidate();
    }
}
