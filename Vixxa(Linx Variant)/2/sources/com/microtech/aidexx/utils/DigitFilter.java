package com.microtech.aidexx.utils;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import com.microtech.aidexx.utils.blankj.RomUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitFilter implements InputFilter {
    private static final String TAG = "GlucoseInputFilter";
    private static final String ZERO = "0";
    private String POINTER;
    private boolean isGlucoseValue = false;
    private boolean isIntOnly = false;
    Pattern mPattern;
    int maxLength = 1000;
    private float maxValue = Float.MAX_VALUE;
    int pointerLength = 1;

    public int getPointerLength() {
        return this.pointerLength;
    }

    public void setPointerLength(int i) {
        this.pointerLength = i;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public void setMaxLength(int i) {
        this.maxLength = i;
    }

    public DigitFilter(String str) {
        this.POINTER = str;
        if (str.equals(".")) {
            this.mPattern = Pattern.compile("([0-9]|\\.)*");
        } else {
            this.mPattern = Pattern.compile("([0-9]|,)*");
        }
    }

    public boolean isIntOnly() {
        return this.isIntOnly;
    }

    public void setIntOnly(boolean z) {
        this.isIntOnly = z;
        if (z) {
            this.mPattern = Pattern.compile("([0-9]|)*");
        } else if (this.POINTER.equals(".")) {
            this.mPattern = Pattern.compile("([0-9]|\\.)*");
        } else {
            this.mPattern = Pattern.compile("([0-9]|,)*");
        }
    }

    public float getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(float f) {
        this.maxValue = f;
    }

    public void setGlucoseValue(boolean z) {
        this.isGlucoseValue = z;
    }

    public boolean isGlucoseValue() {
        return this.isGlucoseValue;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String obj = charSequence.toString();
        String obj2 = spanned.toString();
        Log.d(TAG, "filter: isdigitOnly " + this.isIntOnly);
        Log.d(TAG, "filter: " + spanned + "   " + charSequence);
        Log.d(TAG, "filter: mPattern " + this.mPattern);
        Log.d(TAG, "filter: POINTER " + this.POINTER);
        if (RomUtils.INSTANCE.isSamsung() && obj.contains(obj2) && obj.contains(".")) {
            obj = obj.replace(obj2, "");
        }
        if (TextUtils.isEmpty(obj)) {
            Log.d(TAG, "filter返回0");
            return "";
        }
        Matcher matcher = this.mPattern.matcher(charSequence);
        if (obj2.contains(this.POINTER)) {
            if (!matcher.matches()) {
                Log.d(TAG, "filter返回1");
                return "";
            } else if (this.POINTER.contentEquals(charSequence)) {
                Log.d(TAG, "filter返回2");
                return "";
            } else if ("0".contentEquals(charSequence) && ("0" + this.POINTER).contentEquals(spanned)) {
                Log.d(TAG, "filter返回3");
                return "";
            } else if (this.isGlucoseValue) {
                int i5 = 0;
                while (i5 < 6) {
                    if (!(i5 + "").contentEquals(charSequence) || !("0" + this.POINTER).contentEquals(spanned)) {
                        i5++;
                    } else {
                        Log.d(TAG, "filter返回4");
                        return "";
                    }
                }
                if (i4 - obj2.indexOf(this.POINTER) > this.pointerLength) {
                    return spanned.subSequence(i3, i4);
                }
            }
        } else if (!matcher.matches()) {
            return "";
        } else {
            if (this.POINTER.contentEquals(charSequence) && TextUtils.isEmpty(obj2)) {
                return "";
            }
            if ("0".contentEquals(charSequence) && "0".contentEquals(spanned)) {
                return "";
            }
            if (!this.POINTER.contentEquals(charSequence) && "0".contentEquals(spanned)) {
                return "";
            }
        }
        if ((obj2 + obj).length() <= this.maxLength) {
            return spanned.subSequence(i3, i4) + obj;
        }
        Log.d(TAG, "filter返回8");
        return "";
    }
}
