package com.microtech.aidexx.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import androidx.work.WorkRequest;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0006\u0010\u0016\u001a\u00020\u0011R\u0010\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/service/DataService;", "Landroid/app/Service;", "()V", "dataServiceHandler", "com/microtech/aidexx/service/DataService$dataServiceHandler$1", "Lcom/microtech/aidexx/service/DataService$dataServiceHandler$1;", "dataServiceTask", "Ljava/util/TimerTask;", "dataServiceTimer", "Ljava/util/Timer;", "serviceMainScope", "Lkotlinx/coroutines/CoroutineScope;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onStartCommand", "", "flags", "startId", "scheduleTask", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataService.kt */
public final class DataService extends Service {
    private DataService$dataServiceHandler$1 dataServiceHandler = new DataService$dataServiceHandler$1(this, Looper.getMainLooper());
    private TimerTask dataServiceTask;
    private Timer dataServiceTimer;
    /* access modifiers changed from: private */
    public CoroutineScope serviceMainScope;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.serviceMainScope = CoroutineScopeKt.MainScope();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public final void scheduleTask() {
        this.dataServiceTask = new DataService$scheduleTask$1(new Ref.IntRef(), this);
        Timer timer = new Timer();
        this.dataServiceTimer = timer;
        timer.schedule(this.dataServiceTask, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MIN_BACKOFF_MILLIS);
    }
}
