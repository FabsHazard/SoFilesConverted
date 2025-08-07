package com.kongzue.dialogx.dialogs;

import android.app.Activity;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.kongzue.dialogx.interfaces.DialogXAnimInterface;
import com.kongzue.dialogx.interfaces.OnBackPressedListener;
import com.kongzue.dialogx.interfaces.OnBackgroundMaskClickListener;

public class TipDialog extends WaitDialog {
    public static final int NO_AUTO_DISMISS = -1;

    protected TipDialog() {
    }

    public static WaitDialog show(int i) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(i, WaitDialog.TYPE.WARNING);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, int i) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(i, WaitDialog.TYPE.WARNING);
        showWithInstance(noInstance, activity);
        return instanceNotNull;
    }

    public static WaitDialog show(CharSequence charSequence) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(charSequence, WaitDialog.TYPE.WARNING);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, CharSequence charSequence) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(charSequence, WaitDialog.TYPE.WARNING);
        if (noInstance) {
            showWithInstance(noInstance, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(int i, WaitDialog.TYPE type) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(i, type);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, int i, WaitDialog.TYPE type) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(i, type);
        if (noInstance) {
            showWithInstance(noInstance, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(CharSequence charSequence, WaitDialog.TYPE type) {
        boolean noInstance = noInstance();
        log("noInstance:" + noInstance);
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(charSequence, type);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, CharSequence charSequence, WaitDialog.TYPE type) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(charSequence, type);
        if (noInstance) {
            showWithInstance(noInstance, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(int i, WaitDialog.TYPE type, long j) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(i, type);
        me().setTipShowDuration(j);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, int i, WaitDialog.TYPE type, long j) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(i, type);
        instanceNotNull.setTipShowDuration(j);
        if (noInstance) {
            showWithInstance(noInstance, activity);
        }
        return instanceNotNull;
    }

    public static WaitDialog show(CharSequence charSequence, WaitDialog.TYPE type, long j) {
        boolean noInstance = noInstance();
        if (noInstance) {
            instanceBuild();
        }
        me().setTip(charSequence, type);
        me().setTipShowDuration(j);
        showWithInstance(noInstance);
        return me();
    }

    public static WaitDialog show(Activity activity, CharSequence charSequence, WaitDialog.TYPE type, long j) {
        boolean noInstance = noInstance(activity);
        if (noInstance) {
            instanceBuild();
        }
        WaitDialog instanceNotNull = getInstanceNotNull(activity);
        instanceNotNull.setTip(charSequence, type);
        instanceNotNull.setTipShowDuration(j);
        if (noInstance) {
            showWithInstance(noInstance, activity);
        }
        return instanceNotNull;
    }

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    protected static void showWithInstance(boolean z) {
        if (z) {
            me().show();
            return;
        }
        me().refreshUI();
        me().showTip(me().readyTipType);
    }

    protected static void showWithInstance(boolean z, Activity activity) {
        if (z) {
            me().show(activity);
            return;
        }
        me().refreshUI();
        me().showTip(me().readyTipType);
    }

    public TipDialog setMaxWidth(int i) {
        this.maxWidth = i;
        refreshUI();
        return this;
    }

    public TipDialog setMaxHeight(int i) {
        this.maxHeight = i;
        refreshUI();
        return this;
    }

    public TipDialog setMinHeight(int i) {
        this.minHeight = i;
        refreshUI();
        return this;
    }

    public TipDialog setMinWidth(int i) {
        this.minWidth = i;
        refreshUI();
        return this;
    }

    public TipDialog setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public boolean isBkgInterceptTouch() {
        return this.bkgInterceptTouch;
    }

    public TipDialog setBkgInterceptTouch(boolean z) {
        this.bkgInterceptTouch = z;
        return this;
    }

    public OnBackgroundMaskClickListener<WaitDialog> getOnBackgroundMaskClickListener() {
        return this.onBackgroundMaskClickListener;
    }

    public TipDialog setOnBackgroundMaskClickListener(OnBackgroundMaskClickListener<WaitDialog> onBackgroundMaskClickListener) {
        this.onBackgroundMaskClickListener = onBackgroundMaskClickListener;
        return this;
    }

    public TipDialog setRadius(float f) {
        this.backgroundRadius = f;
        refreshUI();
        return this;
    }

    public float getRadius() {
        return this.backgroundRadius;
    }

    public TipDialog setDialogXAnimImpl(DialogXAnimInterface<WaitDialog> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public TipDialog setOnBackPressedListener(OnBackPressedListener<WaitDialog> onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
        refreshUI();
        return this;
    }

    public TipDialog setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public TipDialog setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }
}
