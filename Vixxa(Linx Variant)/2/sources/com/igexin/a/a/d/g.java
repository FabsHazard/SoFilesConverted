package com.igexin.a.a.d;

import android.content.Context;
import android.content.IntentFilter;

class g extends IntentFilter {
    final /* synthetic */ Context a;
    final /* synthetic */ f b;

    g(f fVar, Context context) {
        this.b = fVar;
        this.a = context;
        addAction("AlarmTaskSchedule." + context.getPackageName());
        addAction("AlarmTaskScheduleBak." + context.getPackageName());
        addAction("android.intent.action.SCREEN_OFF");
        addAction("android.intent.action.SCREEN_ON");
    }
}
