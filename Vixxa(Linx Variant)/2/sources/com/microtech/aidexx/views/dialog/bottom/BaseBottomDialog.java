package com.microtech.aidexx.views.dialog.bottom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.microtech.aidexx.utils.blankj.KeyboardUtils;

public class BaseBottomDialog extends Dialog {
    public View getFocusView() {
        return null;
    }

    public BaseBottomDialog(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getWindow().setBackgroundDrawableResource(17170445);
        getWindow().setLayout(-1, -2);
        getWindow().setGravity(80);
        setCanceledOnTouchOutside(true);
        View focusView = getFocusView();
        if (focusView != null) {
            focusView.postDelayed(new BaseBottomDialog$$ExternalSyntheticLambda0(focusView), 200);
        }
    }

    private void hideSoftInput() {
        View focusView = getFocusView();
        if (focusView != null) {
            KeyboardUtils.INSTANCE.hideSoftInput(focusView);
        }
    }

    public void dismiss() {
        hideSoftInput();
        super.dismiss();
    }
}
