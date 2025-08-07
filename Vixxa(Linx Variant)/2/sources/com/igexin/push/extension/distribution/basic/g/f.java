package com.igexin.push.extension.distribution.basic.g;

import android.app.Notification;
import android.app.NotificationManager;
import com.igexin.a.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.b.a;

public class f {
    public static void a(NotificationManager notificationManager, int i, Notification notification, int i2, a aVar) {
        try {
            if (notification.icon == 0 || d.e.getResources().getDrawable(notification.icon) != null) {
                if (aVar.D() > 0) {
                    d.a(aVar.D(), false);
                    d.a(aVar.D(), notification);
                }
                notificationManager.notify(i, notification);
                return;
            }
            b.a("NotificationShow|showNotification smallIconId: " + notification.icon + " couldn't find resource", new Object[0]);
        } catch (Throwable unused) {
        }
    }
}
