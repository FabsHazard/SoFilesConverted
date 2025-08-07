package com.microtech.aidexx.views;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public abstract class HyperLinkText extends ClickableSpan {
    private final int color;

    public abstract void onClick(View view);

    public HyperLinkText(int i) {
        this.color = i;
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.color);
        textPaint.setUnderlineText(false);
    }
}
