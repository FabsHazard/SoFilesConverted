package com.microtech.aidexx.views.codeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.microtech.aidexx.views.codeview.InputConnection;

public class PwdEditText extends AppCompatEditText {
    private InputConnection inputConnection;

    public PwdEditText(Context context) {
        super(context);
        init();
    }

    public PwdEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PwdEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.inputConnection = new InputConnection((InputConnection) null, true);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.inputConnection.setTarget(super.onCreateInputConnection(editorInfo));
        return this.inputConnection;
    }

    public void setBackSpaceListener(InputConnection.BackspaceListener backspaceListener) {
        this.inputConnection.setBackspaceListener(backspaceListener);
    }
}
