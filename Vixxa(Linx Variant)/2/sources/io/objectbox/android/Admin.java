package io.objectbox.android;

import android.content.Context;
import io.objectbox.BoxStore;

public class Admin {
    private int notificationId;

    public boolean start(Context context) {
        return false;
    }

    public Admin(BoxStore boxStore) {
    }

    public int getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(int i) {
        this.notificationId = i;
    }
}
