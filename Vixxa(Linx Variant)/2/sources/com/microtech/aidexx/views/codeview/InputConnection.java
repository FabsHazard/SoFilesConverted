package com.microtech.aidexx.views.codeview;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;

public class InputConnection extends InputConnectionWrapper {
    private BackspaceListener mBackspaceListener;

    public interface BackspaceListener {
        boolean onBackspace();
    }

    public InputConnection(android.view.inputmethod.InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    public boolean deleteSurroundingText(int i, int i2) {
        BackspaceListener backspaceListener = this.mBackspaceListener;
        if (backspaceListener == null || !backspaceListener.onBackspace()) {
            return super.deleteSurroundingText(i, i2);
        }
        return true;
    }

    public void setBackspaceListener(BackspaceListener backspaceListener) {
        this.mBackspaceListener = backspaceListener;
    }

    public boolean sendKeyEvent(KeyEvent keyEvent) {
        BackspaceListener backspaceListener;
        if (keyEvent.getKeyCode() != 67 || keyEvent.getAction() != 0 || (backspaceListener = this.mBackspaceListener) == null || !backspaceListener.onBackspace()) {
            return super.sendKeyEvent(keyEvent);
        }
        return true;
    }
}
