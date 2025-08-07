package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import androidx.work.PeriodicWorkRequest;
import com.huawei.hms.framework.network.grs.g.d;
import java.util.concurrent.Future;

public class b {
    private final Future<d> a;
    private final long b = SystemClock.elapsedRealtime();

    public b(Future<d> future) {
        this.a = future;
    }

    public Future<d> a() {
        return this.a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.b <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    }
}
