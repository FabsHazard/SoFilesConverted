package com.igexin.push.d;

import androidx.work.WorkRequest;
import com.igexin.a.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.util.a;

public class f implements i {
    public long a() {
        long j;
        long j2;
        long j3;
        boolean a = a.a(System.currentTimeMillis());
        boolean b = a.b();
        d.g = a.h();
        b.a("NormalModel|isPushOn = " + d.i + " checkIsSilentTime = " + a + " isBlockEndTime = " + b + " isNetworkAvailable = " + d.g, new Object[0]);
        if (!d.g || !d.i || a || !b) {
            b.a("NormalModel|reconnect stop, interval= 20min ++++", new Object[0]);
            d.E = 1200000;
            return 1200000;
        }
        if (d.D <= 0) {
            j3 = 100;
        } else {
            if (d.D <= WorkRequest.MIN_BACKOFF_MILLIS) {
                j = d.D;
                j2 = 500;
            } else if (d.D <= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                j = d.D;
                j2 = 1500;
            } else {
                j = d.D;
                j2 = 120000;
            }
            j3 = j + j2;
        }
        d.D = j3;
        if (d.D > 1200000) {
            d.D = 1200000;
        }
        long j4 = d.D;
        b.a("NormalModel|after add auto reconnect delay time = " + j4, new Object[0]);
        d.E = j4;
        return j4;
    }
}
