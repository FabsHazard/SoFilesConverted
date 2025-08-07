package io.objectbox.android;

import android.content.Context;
import io.objectbox.BoxStore;

@Deprecated
public class AndroidObjectBrowser extends Admin {
    @Deprecated
    public AndroidObjectBrowser(BoxStore boxStore) {
        super(boxStore);
    }

    @Deprecated
    public int getNotificationId() {
        return super.getNotificationId();
    }

    @Deprecated
    public void setNotificationId(int i) {
        super.setNotificationId(i);
    }

    @Deprecated
    public boolean start(Context context) {
        return super.start(context);
    }
}
