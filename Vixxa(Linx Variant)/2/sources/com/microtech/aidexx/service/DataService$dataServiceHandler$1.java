package com.microtech.aidexx.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/service/DataService$dataServiceHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataService.kt */
public final class DataService$dataServiceHandler$1 extends Handler {
    final /* synthetic */ DataService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DataService$dataServiceHandler$1(DataService dataService, Looper looper) {
        super(looper);
        this.this$0 = dataService;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        LogUtil.Companion.eAiDEX("DataService start success");
        this.this$0.scheduleTask();
    }
}
