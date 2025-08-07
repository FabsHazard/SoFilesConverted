package com.huawei.hms.scankit.p;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;

/* compiled from: Base256Encoder */
final class n implements v2 {
    n() {
    }

    public int a() {
        return 5;
    }

    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            sb.append(y2Var.c());
            y2Var.f++;
            if (d4.a(y2Var.d(), y2Var.f, a()) != a()) {
                y2Var.b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a = y2Var.a() + length + 1;
        y2Var.c(a);
        boolean z = y2Var.g().a() - a > 0;
        if (y2Var.i() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            y2Var.a(a(sb.charAt(i), y2Var.a() + 1));
        }
    }

    private static char a(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
