package com.igexin.push.core;

import android.content.ContentValues;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

class q implements Runnable {
    final /* synthetic */ ContentValues a;
    final /* synthetic */ String b;
    final /* synthetic */ n c;

    q(n nVar, ContentValues contentValues, String str) {
        this.c = nVar;
        this.a = contentValues;
        this.b = str;
    }

    public void run() {
        c.a().k().a(CrashHianalyticsData.MESSAGE, this.a, new String[]{"taskid"}, new String[]{this.b});
    }
}
