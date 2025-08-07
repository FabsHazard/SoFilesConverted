package com.microtech.aidexx.views.codeview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.DensityUtils;
import java.util.regex.Pattern;

public class VerificationCodeView extends RelativeLayout {
    private LinearLayout containerEt;
    /* access modifiers changed from: private */
    public PwdEditText et;
    private InputCompleteListener inputCompleteListener;
    private Drawable mEtBackgroundDrawableFocus;
    private Drawable mEtBackgroundDrawableNormal;
    private Drawable mEtDividerDrawable;
    /* access modifiers changed from: private */
    public int mEtNumber;
    private boolean mEtPwd;
    private float mEtPwdRadius;
    private int mEtTextColor;
    private float mEtTextSize;
    private int mEtWidth;
    private PwdTextView[] mPwdTextViews;
    private final MyTextWatcher myTextWatcher;

    public interface InputCompleteListener {
        void deleteContent();

        void inputComplete();
    }

    public VerificationCodeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.myTextWatcher = new MyTextWatcher();
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(context).inflate(R.layout.layout_identifying_code, this);
        this.containerEt = (LinearLayout) findViewById(R.id.container_et);
        PwdEditText pwdEditText = (PwdEditText) findViewById(R.id.et_code);
        this.et = pwdEditText;
        pwdEditText.setInputType(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VerificationCodeView, i, 0);
        this.mEtNumber = obtainStyledAttributes.getInteger(R.styleable.VerificationCodeView_icv_et_number, 6);
        this.mEtWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.VerificationCodeView_icv_et_width, DensityUtils.dp2px(35.0f));
        this.mEtDividerDrawable = obtainStyledAttributes.getDrawable(R.styleable.VerificationCodeView_icv_et_divider_drawable);
        this.mEtTextSize = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.VerificationCodeView_icv_et_text_size, (int) sp2px(16.0f, context));
        this.mEtTextColor = obtainStyledAttributes.getColor(R.styleable.VerificationCodeView_icv_et_text_color, ViewCompat.MEASURED_STATE_MASK);
        this.mEtBackgroundDrawableFocus = obtainStyledAttributes.getDrawable(R.styleable.VerificationCodeView_icv_et_bg_focus);
        this.mEtBackgroundDrawableNormal = obtainStyledAttributes.getDrawable(R.styleable.VerificationCodeView_icv_et_bg_normal);
        this.mEtPwd = obtainStyledAttributes.getBoolean(R.styleable.VerificationCodeView_icv_et_pwd, false);
        this.mEtPwdRadius = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.VerificationCodeView_icv_et_pwd_radius, 0);
        obtainStyledAttributes.recycle();
        if (this.mEtDividerDrawable == null) {
            this.mEtDividerDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.shape_divider_identifying, (Resources.Theme) null);
        }
        if (this.mEtBackgroundDrawableFocus == null) {
            this.mEtBackgroundDrawableFocus = ResourcesCompat.getDrawable(context.getResources(), R.drawable.shape_icv_et_bg_focus, (Resources.Theme) null);
        }
        if (this.mEtBackgroundDrawableNormal == null) {
            this.mEtBackgroundDrawableNormal = ResourcesCompat.getDrawable(context.getResources(), R.drawable.shape_icv_et_bg_normal, (Resources.Theme) null);
        }
        initUI();
    }

    private void initUI() {
        initTextViews(getContext(), this.mEtNumber, DensityUtils.dp2px(40.0f), this.mEtDividerDrawable, DensityUtils.sp2px(18.0f), this.mEtTextColor);
        initEtContainer(this.mPwdTextViews);
        setListener();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) dp2px(50.0f, getContext()), BasicMeasure.EXACTLY);
        }
        super.onMeasure(i, i2);
    }

    private void initTextViews(Context context, int i, int i2, Drawable drawable, float f, int i3) {
        this.et.setCursorVisible(false);
        this.et.setFilters(new InputFilter[]{new VerificationCodeView$$ExternalSyntheticLambda0(), new InputFilter.LengthFilter(i)});
        this.mPwdTextViews = new PwdTextView[i];
        for (int i4 = 0; i4 < this.mPwdTextViews.length; i4++) {
            PwdTextView pwdTextView = new PwdTextView(context);
            pwdTextView.setTextSize(0, f);
            pwdTextView.setFocusable(true);
            pwdTextView.setFocusableInTouchMode(true);
            pwdTextView.setPadding(DensityUtils.dp2px(3.0f), DensityUtils.dp2px(3.0f), DensityUtils.dp2px(3.0f), DensityUtils.dp2px(3.0f));
            pwdTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            pwdTextView.setGravity(17);
            pwdTextView.setFocusable(false);
            this.mPwdTextViews[i4] = pwdTextView;
        }
    }

    static /* synthetic */ CharSequence lambda$initTextViews$0(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!Pattern.compile("[0-9a-zA-Z]+").matcher(charSequence.toString()).matches()) {
            return "";
        }
        return null;
    }

    private void initEtContainer(TextView[] textViewArr) {
        for (TextView addView : textViewArr) {
            this.containerEt.addView(addView);
        }
    }

    private void setListener() {
        this.et.addTextChangedListener(this.myTextWatcher);
        this.et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 67 || keyEvent.getAction() != 0) {
                    return false;
                }
                VerificationCodeView.this.onKeyDelete();
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    public void setText(String str) {
        int i = 0;
        while (true) {
            PwdTextView[] pwdTextViewArr = this.mPwdTextViews;
            if (i < pwdTextViewArr.length) {
                PwdTextView pwdTextView = pwdTextViewArr[i];
                if (pwdTextView.getText().toString().trim().equals("")) {
                    if (this.mEtPwd) {
                        pwdTextView.drawPwd(this.mEtPwdRadius);
                    }
                    pwdTextView.setText(str.toUpperCase());
                    if (i >= this.mEtNumber - 1) {
                        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 2);
                        }
                        InputCompleteListener inputCompleteListener2 = this.inputCompleteListener;
                        if (inputCompleteListener2 != null) {
                            inputCompleteListener2.inputComplete();
                            return;
                        }
                        return;
                    }
                    return;
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void onKeyDelete() {
        for (int length = this.mPwdTextViews.length - 1; length >= 0; length--) {
            PwdTextView pwdTextView = this.mPwdTextViews[length];
            if (!pwdTextView.getText().toString().trim().equals("")) {
                if (this.mEtPwd) {
                    pwdTextView.clearPwd();
                }
                pwdTextView.setText("");
                InputCompleteListener inputCompleteListener2 = this.inputCompleteListener;
                if (inputCompleteListener2 != null) {
                    inputCompleteListener2.deleteContent();
                    return;
                }
                return;
            }
        }
    }

    public String getInputContent() {
        StringBuilder sb = new StringBuilder();
        for (PwdTextView text : this.mPwdTextViews) {
            sb.append(text.getText().toString().trim());
        }
        return sb.toString();
    }

    public void clearInputContent() {
        int i = 0;
        while (true) {
            PwdTextView[] pwdTextViewArr = this.mPwdTextViews;
            if (i < pwdTextViewArr.length) {
                if (i == 0) {
                    pwdTextViewArr[i].setBackgroundDrawable(this.mEtBackgroundDrawableFocus);
                } else {
                    pwdTextViewArr[i].setBackgroundDrawable(this.mEtBackgroundDrawableNormal);
                }
                if (this.mEtPwd) {
                    this.mPwdTextViews[i].clearPwd();
                }
                this.mPwdTextViews[i].setText("");
                i++;
            } else {
                return;
            }
        }
    }

    public void setEtNumber(int i) {
        this.mEtNumber = i;
        this.et.removeTextChangedListener(this.myTextWatcher);
        this.containerEt.removeAllViews();
        initUI();
    }

    public int getEtNumber() {
        return this.mEtNumber;
    }

    public void setPwdMode(boolean z) {
        this.mEtPwd = z;
    }

    public EditText getEditText() {
        return this.et;
    }

    public void setInputCompleteListener(InputCompleteListener inputCompleteListener2) {
        this.inputCompleteListener = inputCompleteListener2;
    }

    public float dp2px(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public float sp2px(float f, Context context) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    private class MyTextWatcher implements TextWatcher {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private MyTextWatcher() {
        }

        /* access modifiers changed from: package-private */
        public String stringFilter(String str) {
            return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
        }

        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (!TextUtils.isEmpty(obj)) {
                String[] split = obj.split("");
                int i = 0;
                while (i < split.length && i <= VerificationCodeView.this.mEtNumber) {
                    VerificationCodeView.this.setText(split[i]);
                    VerificationCodeView.this.et.setText("");
                    i++;
                }
            }
        }
    }
}
