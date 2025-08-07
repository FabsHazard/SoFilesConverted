package com.microtech.aidexx.views.selector.base;

import com.microtech.aidexx.R;

public class PickerViewAnimateUtil {
    private static final int INVALID = -1;

    public static int getAnimationResource(int i, boolean z) {
        if (i != 80) {
            return -1;
        }
        return z ? R.anim.bottom_menu_enter : R.anim.bottom_menu_exit;
    }
}
