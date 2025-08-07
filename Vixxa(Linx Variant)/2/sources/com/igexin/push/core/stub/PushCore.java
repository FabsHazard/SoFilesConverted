package com.igexin.push.core.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.c;
import com.igexin.sdk.IPushCore;

public class PushCore implements IPushCore {
    private c a;

    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
    }

    public boolean onActivityCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    public void onActivityDestroy(Activity activity) {
    }

    public boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onActivityNewIntent(Activity activity, Intent intent) {
    }

    public void onActivityPause(Activity activity) {
    }

    public void onActivityRestart(Activity activity) {
    }

    public void onActivityResume(Activity activity) {
    }

    public void onActivityStart(Activity activity, Intent intent) {
    }

    public void onActivityStop(Activity activity) {
    }

    public IBinder onServiceBind(Intent intent) {
        return null;
    }

    public void onServiceDestroy() {
    }

    public int onServiceStartCommand(Intent intent, int i, int i2) {
        if (this.a == null) {
            return 2;
        }
        Message obtain = Message.obtain();
        obtain.what = CoreConsts.f;
        obtain.obj = intent;
        this.a.a(obtain);
        return 2;
    }

    public boolean start(Context context) {
        c a2 = c.a();
        this.a = a2;
        a2.a(context);
        return true;
    }
}
