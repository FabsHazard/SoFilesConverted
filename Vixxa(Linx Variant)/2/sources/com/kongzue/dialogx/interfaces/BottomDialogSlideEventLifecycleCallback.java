package com.kongzue.dialogx.interfaces;

import android.view.MotionEvent;
import android.view.View;
import com.kongzue.dialogx.interfaces.BaseDialog;

public abstract class BottomDialogSlideEventLifecycleCallback<D extends BaseDialog> extends DialogLifecycleCallback<D> {
    public boolean onSlideClose(D d) {
        return false;
    }

    public boolean onSlideTouchEvent(D d, View view, MotionEvent motionEvent) {
        return false;
    }
}
